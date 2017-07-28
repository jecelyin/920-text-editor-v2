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

import com.jecelyin.common.utils.command.Runner;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class ShellProcessor extends AsyncTask<Runner, Void, List<String>> {
    private Process process;
    private static ShellProcessor shellProcessor;
    private BufferedReader inputStream;
    private BufferedReader errorStream;
    private OutputStreamWriter outputStream;
    private boolean close;
    private volatile Runner runner;
    private volatile ArrayList<String> result;
    private volatile ArrayList<String> error;

    private ShellProcessor() {}

    public static ShellProcessor getShell() {
//        if (shellProcessor != null)
//            return shellProcessor;
//
//        shellProcessor = new ShellProcessor();

        return new ShellProcessor();
    }

    public void addCommand(Runner runner) {
        execute(runner);
    }

    @Override
    protected List<String> doInBackground(Runner... params) {
        try {
            processCommand(params[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(List<String> strings) {
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
                        L.d("Found token, line: " + outputLine);
                        buffer.add(outputLine.substring(0, pos));
                        break;
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
            e.printStackTrace();
        }
    }
}
