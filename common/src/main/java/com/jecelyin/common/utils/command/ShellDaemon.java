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

public class ShellDaemon extends Thread {
    private Process process;
    private static ShellDaemon shellDaemon;
    private BufferedReader inputStream;
    private BufferedReader errorStream;
    private OutputStreamWriter outputStream;
    private boolean close;

    private static InternalHandler sHandler;
    private final ArrayBlockingQueue<Runner> queue = new ArrayBlockingQueue<>(30);
    private final Object waiter = new Object();

    private static final int MESSAGE_POST_RESULT = 1;
    private ReadTask inputReadTask;
    private ReadTask errorReadTask;

    private ShellDaemon() {
        setName("ShellDaemon");
    }

    public static ShellDaemon getShell() {
        if (shellDaemon != null)
            return shellDaemon;

        shellDaemon = new ShellDaemon();

        return new ShellDaemon();
    }

    public void reset() {
        queue.clear();
    }

    public synchronized void addCommand(final Runner runner) {
        try {
            prepare();
            queue.add(runner);
        } catch (Exception e) {
            L.e(e);
            runner.process(new ArrayList<String>(), e.getMessage());
        }
    }

    /** ------------------------------------------------------------------------
     ------------------------------- IN THREAD ---------------------------------
     --------------------------------------------------------------------------*/
    private static class TaskResult {
        final Runner mRunner;
        final List<String> mResults;
        final String mErrors;

        TaskResult(Runner runner, List<String> data, String error) {
            mRunner = runner;
            mResults = data;
            mErrors = error;
        }
    }

    @Override
    public void run() {
        Runner active;
        for (;;) {
            try {
                if ((active = queue.take()) != null) {
                    queue.remove(active);
                    try {
                        processCommand(active);
                        if (!active.done) {
                            synchronized (waiter) {
                                L.d("CMD", "wait " + active.command());
                                waiter.wait();
                            }
                        }
                    } catch (Exception e) {
                        L.e(e);
                        Message message = getHandler().obtainMessage(MESSAGE_POST_RESULT,
                                new TaskResult(active, new ArrayList<String>(), e.getMessage()));
                        message.sendToTarget();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Handler getHandler() {
        synchronized (ShellDaemon.class) {
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
                    result.mRunner.process(result.mResults, result.mErrors);
                    break;
            }
        }
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

        inputReadTask = new ReadTask(inputStream, "CMD-INPUT");
        errorReadTask = new ReadTask(errorStream, "CMD-OUTPUT");

        inputReadTask.start();
        errorReadTask.start();
        start();
        L.d("CMD", "prepare end");
    }

    private void processCommand(Runner runner) throws Exception {
        L.d("CMD", runner.command());

        inputReadTask.setRunner(runner);
        errorReadTask.setRunner(runner);

        //write the command
        outputStream.write(runner.command() + "\n");
        outputStream.flush();

        //write the token...
        String line = "echo " + runner.token + "\n";
        outputStream.write(line);
        outputStream.flush();
    }

    private void doNext() {
        try {
            synchronized (waiter) {
                waiter.notifyAll();
            }
        } catch (IllegalMonitorStateException e) {
            e.printStackTrace();
        }
    }

    private class ReadTask extends Thread {
        private final BufferedReader reader;
        private WeakReference<Runner> runner;
        private ArrayList<String> result;
        private ArrayList<String> error;

        private ReadTask(BufferedReader reader, String name) {
            this.reader = reader;
            setName(name);
        }

        private void setRunner(Runner runner) {
            this.runner = new WeakReference<>(runner);
            result = new ArrayList<>();
            error = new ArrayList<>();
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
                    if (buffer == null || runner == null) {
                        doNext();
                        continue;
                    }

                    Runner r = runner.get();
                    if (r == null) {
                        doNext();
                        continue;
                    }

                    int pos = outputLine.indexOf(r.token);

                    if (pos == -1) {
                        buffer.add(outputLine);
                    } else if (pos >= 0) {
                        L.d("CND", "Found token, line: " + outputLine);
                        String line = outputLine.substring(0, pos);
                        if (!TextUtils.isEmpty(line))
                            buffer.add(line);

                        r.done = true;
                        Message message = getHandler().obtainMessage(MESSAGE_POST_RESULT,
                                new TaskResult(r, result, TextUtils.join("\n", error)));
                        message.sendToTarget();

                        doNext();
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
