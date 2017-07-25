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

import com.jecelyin.common.utils.command.CopyRunner;
import com.jecelyin.common.utils.command.ExistsRunner;
import com.jecelyin.common.utils.command.IsDirectory;
import com.jecelyin.common.utils.command.ListFileRunner;
import com.jecelyin.common.utils.command.MkdirRunner;
import com.jecelyin.common.utils.command.MountFileSystemRORunner;
import com.jecelyin.common.utils.command.MountFileSystemRWRunner;
import com.jecelyin.common.listeners.OnResultCallback;
import com.jecelyin.common.utils.command.Runner;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import eu.chainfire.libsuperuser.Shell;

public class RootShellRunner {
    private final Shell.Interactive interactive;
    private AtomicInteger code = new AtomicInteger(0);
    private boolean autoClose = true;

    public RootShellRunner() {
        interactive = new Shell.Builder().
                useSU().
                setWantSTDERR(true).
                setWatchdogTimeout(5).
                setMinimalLogging(false).open();
    }

    public void close() {
        interactive.close();
    }

    public void setAutoClose(boolean autoClose) {
        this.autoClose = autoClose;
    }

    public void run(final Runner runner) {
        interactive.addCommand(runner.command(), code.getAndIncrement(), new Shell.OnCommandResultListener() {
            @Override
            public void onCommandResult(int commandCode, int exitCode, List<String> output) {
                runner.onResult(RootShellRunner.this, output);
                if (autoClose)
                    close();
            }
        });
    }

    public void copy(final String source, final String destination, final OnResultCallback<Boolean> listener) {
        run(new MountFileSystemRWRunner(destination) {
            @Override
            public void onSuccess(final String mountPoint) {
                run(new CopyRunner(source, destination){
                    @Override
                    public void onSuccess(Boolean result) {
                        if (mountPoint != null && !mountPoint.isEmpty()) {
                            run(new MountFileSystemRORunner(destination));
                        }
                        listener.onSuccess(result);
                    }

                    @Override
                    public void onError(String error) {
                        listener.onError(error);
                    }
                });
            }

            @Override
            public void onError(String error) {
                listener.onError(error);
            }
        });

    }

    public void mkdirs(final String path, final OnResultCallback<Boolean> listener) {
        run(new MountFileSystemRWRunner(path) {
            @Override
            public void onSuccess(final String mountPoint) {
                run(new MkdirRunner(path){
                    @Override
                    public void onSuccess(Boolean result) {
                        if (mountPoint != null && !mountPoint.isEmpty()) {
                            run(new MountFileSystemRORunner(path));
                        }
                        listener.onSuccess(result);
                    }

                    @Override
                    public void onError(String error) {
                        listener.onError(error);
                    }
                });
            }

            @Override
            public void onError(String error) {
                listener.onError(error);
            }
        });
    }

    public void chmod(final String mode, final String path,  final OnResultCallback<Boolean> listener) {
        run(new MountFileSystemRWRunner(path) {
            @Override
            public void onSuccess(final String mountPoint) {
                run(new Runner<String>(){
                    @Override
                    public String command() {
                        return "chmod " + mode + " \"" + path + "\"";
                    }

                    @Override
                    public void onResult(RootShellRunner runner, List<String> results) {
                        if (mountPoint != null && !mountPoint.isEmpty()) {
                            run(new MountFileSystemRORunner(path));
                        }
                        listener.onSuccess(results.isEmpty());
                    }
                });
            }

            @Override
            public void onError(String error) {
                listener.onError(error);
            }
        });
    }

    public void delete(final String path, final OnResultCallback<Boolean> listener) {
        run(new MountFileSystemRWRunner(path) {
            @Override
            public void onSuccess(final String mountPoint) {
                run(new Runner<String>(){
                    @Override
                    public String command() {
                        return "rm -rf \"" + path + "\"";
                    }

                    @Override
                    public void onResult(RootShellRunner runner, List<String> results) {
                        if (mountPoint != null && !mountPoint.isEmpty()) {
                            run(new MountFileSystemRORunner(path));
                        }
                        listener.onSuccess(results.isEmpty());
                    }
                });
            }

            @Override
            public void onError(String error) {
                listener.onError(error);
            }
        });
    }

    public void move(final String path, final String destination, final OnResultCallback<Boolean> listener) {
        run(new MountFileSystemRWRunner(path) {
            @Override
            public void onSuccess(final String mountPoint) {
                run(new Runner<String>(){
                    @Override
                    public String command() {
                        return "mv \"" + path + "\" \"" + destination + "\"";
                    }

                    @Override
                    public void onResult(RootShellRunner runner, List<String> results) {
                        if (mountPoint != null && !mountPoint.isEmpty()) {
                            run(new MountFileSystemRORunner(path));
                        }
                        listener.onSuccess(results.isEmpty());
                    }
                });
            }

            @Override
            public void onError(String error) {
                listener.onError(error);
            }
        });
    }

    public void rename(String oldPath, String newPath, final OnResultCallback<Boolean> listener) {
        move(oldPath, newPath, listener);
    }

    public static String parsePermission(String permLine) {
        int owner = 0;
        int READ = 4;
        int WRITE = 2;
        int EXECUTE = 1;
        if (permLine.charAt(1) == 'r') {
            owner += READ;
        }
        if (permLine.charAt(2) == 'w') {
            owner += WRITE;
        }
        if (permLine.charAt(3) == 'x') {
            owner += EXECUTE;
        }
        int group = 0;
        if (permLine.charAt(4) == 'r') {
            group += READ;
        }
        if (permLine.charAt(5) == 'w') {
            group += WRITE;
        }
        if (permLine.charAt(6) == 'x') {
            group += EXECUTE;
        }
        int world = 0;
        if (permLine.charAt(7) == 'r') {
            world += READ;
        }
        if (permLine.charAt(8) == 'w') {
            world += WRITE;
        }
        if (permLine.charAt(9) == 'x') {
            world += EXECUTE;
        }
        String finalValue = owner + "" + group + "" + world;
        return finalValue;
    }

    public static boolean isRootPath(String path) {
        String isd = SysUtils.getInternalStorageDirectory();
        if (path.startsWith(isd)) {
            String androidPath = isd + "/Android/";
            return path.startsWith(androidPath) || androidPath.equals(path);
        }
        return true;
    }

    public void exists(String path, final OnResultCallback<Boolean> listener) {
        run(new ExistsRunner(path) {
            @Override
            public void onSuccess(Boolean result) {
                listener.onSuccess(result);
            }

            @Override
            public void onError(String error) {
                listener.onError(error);
            }
        });
    }

    public void isDirectory(String path, final OnResultCallback<Boolean> listener) {
        run(new IsDirectory(path) {
            @Override
            public void onSuccess(Boolean result) {
                listener.onSuccess(result);
            }
        });
    }

    public void listFileInfo(String path, final OnResultCallback<List<FileInfo>> callback) {

        if (!path.endsWith("/"))
            path += "/";

        run(new ListFileRunner(path) {
            @Override
            public void onSuccess(List<FileInfo> result) {
                callback.onSuccess(result);
            }
        });
    }

    public void isRootAvailable(final OnResultCallback<Boolean> listener) {
        run(new Runner<String>() {
            @Override
            public String command() {
                return "id";
            }

            @Override
            public void onResult(RootShellRunner runner, List<String> results) {
                listener.onSuccess(results != null && !results.isEmpty() && results.get(0).contains("uid=0"));
            }
        });
    }
}
