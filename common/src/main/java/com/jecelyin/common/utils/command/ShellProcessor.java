/*
 * Copyright (C) 2016 Jecelyin Peng <jecelyin@gmail.com>
 *
 * This file is part of 920 Text Editor.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jecelyin.common.utils.command;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

import com.jecelyin.common.utils.L;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class ShellProcessor {
    private Process process;
    private static ShellProcessor shellProcessor;
    private BufferedReader inputStream;
    private BufferedReader errorStream;
    private OutputStreamWriter outputStream;
    private boolean close;
    private Runner runner;
    private ArrayList<String> result;
    private ArrayList<String> error;
    private static InternalHandler sHandler;
    private TaskQueue taskQueue = new TaskQueue();

    private static final int MESSAGE_POST_RESULT = 1;

    private static class TaskResult {
        final ShellProcessor mTask;
        final List<String> mResults;
        final List<String> mErrors;

        TaskResult(ShellProcessor task, List<String> data, List<String> error) {
            mTask = task;
            mResults = data;
            mErrors = error;
        }
    }

    private static class TaskQueue implements Runnable {
        private final ArrayBlockingQueue<WeakReference<Runnable>> queue = new ArrayBlockingQueue<>(30);

        private void addTask(Runnable r) {
            queue.add(new WeakReference<>(r));
        }

        @Override
        public void run() {
            WeakReference<Runnable> active;
            for (;;) {
                try {
                    if ((active = queue.take()) != null) {
                        queue.remove(active);
                        try {
                            Runnable runnable = active.get();
                            if (runnable != null)runnable.run();
                        } catch (Exception e) {
                            L.e(e);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private ShellProcessor() {}

    public static ShellProcessor getShell() {
        if (shellProcessor != null)
            return shellProcessor;

        shellProcessor = new ShellProcessor();

        return new ShellProcessor();
    }

    public void close() {
        if (taskQueue == null)
            return;
        taskQueue.queue.clear();
    }

    public synchronized void addCommand(final Runner runner) {
        try {
            prepare();
            taskQueue.addTask(new Runnable() {
                @Override
                public void run() {
                    try {
                        processCommand(runner);
                    } catch (Exception e) {
                        L.e(e);
                        runner.process(new ArrayList<String>(), e.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            L.e(e);
            runner.process(new ArrayList<String>(), e.getMessage());
        }
    }

    private static Handler getHandler() {
        synchronized (ShellProcessor.class) {
            if (sHandler == null) {
                sHandler = new InternalHandler();
            }
            return sHandler;
        }
    }

    private static class InternalHandler extends Handler {

        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        @SuppressWarnings({"unchecked", "RawUseOfParameterizedType"})
        @Override
        public void handleMessage(Message msg) {
            TaskResult result = (TaskResult) msg.obj;
            switch (msg.what) {
                case MESSAGE_POST_RESULT:
                    result.mTask.runner.process(result.mResults, TextUtils.join("\n", result.mErrors));
                    break;
            }
        }
    }

    private void postResult() {
//        process.notifyAll();
        @SuppressWarnings("unchecked")
        Message message = getHandler().obtainMessage(MESSAGE_POST_RESULT,
                new TaskResult(this, result, error));
        message.sendToTarget();
    }

    private void prepare() throws Exception {
        if (process != null) {
            return;
        }
        L.d("CMD", "prepare start");

        try {
            process = Runtime.getRuntime().exec("su");
        } catch (Exception e) {
            //没有Root的设备无法执行su，但是要访问 / 根目录（用File.listFiles会返回null）
            process = Runtime.getRuntime().exec("/system/bin/sh");
        }
        inputStream = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
        errorStream = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
        outputStream = new OutputStreamWriter(process.getOutputStream(), "UTF-8");

        new Thread(new ReadTask(inputStream), "CMD-INPUT").start();
        new Thread(new ReadTask(errorStream), "CMD-OUTPUT").start();
        new Thread(taskQueue, "CMD-TASK-QUEUE").start();
        L.d("CMD", "prepare end");
    }

    private void processCommand(Runner runner) throws Exception {
        this.runner = runner;

        L.d("CMD", runner.command());
        result = new ArrayList<>();
        error = new ArrayList<>();

        //write the command
        outputStream.write(runner.command() + "\n");
        outputStream.flush();

        //write the token...
        String line = "echo " + runner.token + "\n";
        outputStream.write(line);
        outputStream.flush();
    }

    private class ReadTask implements Runnable {
        private final BufferedReader reader;

        private ReadTask(BufferedReader reader) {
            this.reader = reader;
        }

        public void run() {
            try {
                //as long as there is something to read, we will keep reading.
                while (!close || reader.ready() ) {
                    String outputLine = reader.readLine();

                    if (outputLine == null) {
                        break;
                    }

                    L.d("CMD", "> " + outputLine);

                    ArrayList<String> buffer = reader == errorStream ? error : result;
                    if (buffer == null)
                        continue;

                    int pos = outputLine.indexOf(runner.token);

                    if (pos == -1) {
                        buffer.add(outputLine);
                    } else if (pos >= 0) {
                        L.d("CND", "Found token, line: " + outputLine);
                        String line = outputLine.substring(0, pos);
                        if (!TextUtils.isEmpty(line))
                            buffer.add(line);
                        postResult();
                    }
                }

            } catch (IOException e) {
                L.e(e);
            } finally {
                L.d("CMD", "read finish");
                closeQuietly(outputStream);
                closeQuietly(errorStream);
                closeQuietly(inputStream);
                close = true;
            }
        }
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            if(closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            L.e(e);
        }
    }
}
