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

package com.jecelyin.common.utils;


import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.jecelyin.common.utils.command.Runner;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static android.os.AsyncTask.THREAD_POOL_EXECUTOR;

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
    private volatile Runner runner;
    private volatile ArrayList<String> result;
    private volatile ArrayList<String> error;
    private static InternalHandler sHandler;
    private final ArrayDeque<Runnable> mTasks = new ArrayDeque<Runnable>();
    private Runnable mActive;
    private static final int MESSAGE_POST_RESULT = 1;

    private static class TaskResult {
        final ShellProcessor mTask;
        final List<String> mData;

        TaskResult(ShellProcessor task, List<String> data) {
            mTask = task;
            mData = data;
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
                    result.mTask.onPostExecute(result.mData);
                    break;
            }
        }
    }

    private synchronized void execute(final Runnable r) {
        mTasks.offer(new Runnable() {
            public void run() {
                try {
                    r.run();
                } finally {
                    scheduleNext();
                }
            }
        });
        if (mActive == null) {
            scheduleNext();
        }
    }

    private synchronized void scheduleNext() {
        if ((mActive = mTasks.poll()) != null) {
            THREAD_POOL_EXECUTOR.execute(mActive);
        }
    }

    private static Handler getHandler() {
        synchronized (AsyncTask.class) {
            if (sHandler == null) {
                sHandler = new InternalHandler();
            }
            return sHandler;
        }
    }


    private ShellProcessor() {}

    public static ShellProcessor getShell() {
        if (shellProcessor != null)
            return shellProcessor;

        shellProcessor = new ShellProcessor();

        return new ShellProcessor();
    }

    public void addCommand(final Runner runner) {
        execute(new Runnable() {
            @Override
            public void run() {
                try {
                    processCommand(runner);
                    postResult(result);
                } catch (Exception e) {
                    L.e(e);
                }
            }
        });
    }

    private void postResult(List<String> result) {
        @SuppressWarnings("unchecked")
        Message message = getHandler().obtainMessage(MESSAGE_POST_RESULT,
                new TaskResult(this, result));
        message.sendToTarget();
    }

    private void onPostExecute(List<String> strings) {
        runner.onResult(null, strings);
    }

    private void prepare() throws IOException {
//        if (process != null) {
//            return;
//        }
        process = Runtime.getRuntime().exec("su");
        inputStream = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
        errorStream = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
        outputStream = new OutputStreamWriter(process.getOutputStream(), "UTF-8");

        new Thread(new ReadTask(inputStream)).start();
        new Thread(new ReadTask(errorStream)).start();
    }

    private void processCommand(Runner runner) throws Exception {
        this.runner = runner;
        result = new ArrayList<>();
        error = new ArrayList<>();
        L.d("CMD", runner.command());
        prepare();
        //write the command
        outputStream.write(runner.command() + "\n");
        outputStream.flush();

        //write the token...
        String line = "echo " + runner.token + "\n";
        outputStream.write(line);
        outputStream.flush();

        process.waitFor();
        L.d("CMD", "wait finish");
    }

    private class ReadTask implements Runnable {
        private final BufferedReader reader;

        private ReadTask(BufferedReader reader) {
            this.reader = reader;
        }

        public void run() {
            try {
                ArrayList<String> buffer = reader == errorStream ? error : result;
                //as long as there is something to read, we will keep reading.
                while (!close || reader.ready() ) {
                    String outputLine = reader.readLine();

                    if (outputLine == null) {
                        break;
                    }

                    L.d("CMD", ">" + outputLine);

                    int pos = outputLine.indexOf(runner.token);

                    if (pos == -1) {
                        buffer.add(outputLine);
                    } else if (pos >= 0) {
                        L.d("CND", "Found token, line: " + outputLine);
                        buffer.add(outputLine.substring(0, pos));
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
