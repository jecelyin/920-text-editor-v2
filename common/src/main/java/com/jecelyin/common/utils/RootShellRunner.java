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

import android.support.annotation.NonNull;

import com.jecelyin.common.listeners.OnResultCallback;
import com.jecelyin.common.utils.command.CopyRunner;
import com.jecelyin.common.utils.command.ExistsRunner;
import com.jecelyin.common.utils.command.IsDirectoryRunner;
import com.jecelyin.common.utils.command.ListFileRunner;
import com.jecelyin.common.utils.command.MkdirRunner;
import com.jecelyin.common.utils.command.MountFileSystemRORunner;
import com.jecelyin.common.utils.command.MountFileSystemRWRunner;
import com.jecelyin.common.utils.command.Runner;
import com.jecelyin.common.utils.command.ShellDaemon;

import java.io.File;
import java.util.List;

public class RootShellRunner {
    private final Object lock = new Object();

    public static RootShellRunner getRunner() {
        return new RootShellRunner();
    }

    public void waitFor() {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        synchronized (lock) {
            lock.notifyAll();
        }
        ShellDaemon.getShell().reset();
    }

    private void run(final Runner runner) {
        ShellDaemon.getShell().addCommand(runner);
    }

    public void copy(final String source, final String destination, final OnResultCallback<Boolean> listener) {
        copy(source, destination, null, listener);
    }

    public void copy(final String source, final String destination, final String mode, final OnResultCallback<Boolean> listener) {
        run(new MountFileSystemRWRunner(destination) {
            @Override
            public void onResult(final String mountPoint, @NonNull String errors) {
                if (!errors.isEmpty()) {
                    listener.onError(errors);
                    return;
                }
                run(new CopyRunner(source, destination, mode){
                    @Override
                    public void onResult(Boolean result, @NonNull String errors) {
                        if (mountPoint != null && !mountPoint.isEmpty()) {
                            run(new MountFileSystemRORunner(destination));
                        }
                        listener.onSuccess(result);
                    }
                });
            }
        });
    }

    public void mkdirs(final String path, final OnResultCallback<Boolean> listener) {
        run(new MountFileSystemRWRunner(path) {
            @Override
            public void onResult(final String mountPoint, @NonNull String errors) {
                if (!errors.isEmpty()) {
                    listener.onError(errors);
                    return;
                }
                run(new MkdirRunner(path){
                    @Override
                    public void onResult(Boolean result, @NonNull String errors) {
                        if (!errors.isEmpty()) {
                            listener.onError(errors);
                            return;
                        }
                        if (mountPoint != null && !mountPoint.isEmpty()) {
                            run(new MountFileSystemRORunner(path));
                        }
                        listener.onSuccess(result);
                    }
                });
            }
        });
    }

    public void chmod(final String mode, final String path,  final OnResultCallback<Boolean> listener) {
        run(new MountFileSystemRWRunner(path) {
            @Override
            public void onResult(final String mountPoint, @NonNull String errors) {
                if (!errors.isEmpty()) {
                    listener.onError(errors);
                    return;
                }
                run(new Runner<Boolean>(){
                    @Override
                    public String command() {
                        return "chmod " + mode + " \"" + path + "\"";
                    }

                    @Override
                    protected void process(List<String> result, @NonNull String errors) {
                        if (!errors.isEmpty()) {
                            listener.onError(errors);
                            return;
                        }
                        onResult(result.isEmpty(), errors);
                    }

                    @Override
                    public void onResult(Boolean result, @NonNull String errors) {
                        if (mountPoint != null && !mountPoint.isEmpty()) {
                            run(new MountFileSystemRORunner(path));
                        }
                        listener.onSuccess(result);
                    }
                });
            }
        });
    }

    public void delete(final String path, final OnResultCallback<Boolean> listener) {
        run(new MountFileSystemRWRunner(path) {
            @Override
            public void onResult(final String mountPoint, @NonNull String errors) {
                if (!errors.isEmpty()) {
                    listener.onError(errors);
                    return;
                }
                run(new Runner<Boolean>(){
                    @Override
                    public String command() {
                        return "rm -rf \"" + path + "\"";
                    }

                    @Override
                    protected void process(List<String> result, @NonNull String errors) {
                        onResult(result.isEmpty(), errors);
                    }

                    @Override
                    public void onResult(Boolean result, @NonNull String errors) {
                        if (errors.isEmpty()) {
                            if (mountPoint != null && !mountPoint.isEmpty()) {
                                run(new MountFileSystemRORunner(path));
                            }
                            return;
                        }
                        listener.onError(errors);
                    }
                });
            }
        });
    }

    public void move(final String path, final String destination, final OnResultCallback<Boolean> listener) {
        run(new MountFileSystemRWRunner(path) {
            @Override
            public void onResult(final String mountPoint, @NonNull String errors) {
                if (!errors.isEmpty()) {
                    listener.onError(errors);
                    return;
                }

                run(new Runner<Boolean>(){
                    @Override
                    public String command() {
                        return "cat \"" + path + "\" > \"" + destination + "\";" +
                                "if [ -f \"" + destination + "\" ]; then rm -f \"" + path + "\"; fi";
                    }

                    @Override
                    protected void process(List<String> result, @NonNull String errors) {
                        if (!errors.isEmpty()) {
                            listener.onError(errors);
                            return;
                        }
                        onResult(result.isEmpty(), errors);
                    }

                    @Override
                    public void onResult(Boolean result, @NonNull String errors) {
                        if (mountPoint != null && !mountPoint.isEmpty()) {
                            run(new MountFileSystemRORunner(path));
                        }
                        listener.onSuccess(result);
                    }
                });
            }
        });
    }

    public void rename(String oldPath, String newPath, final OnResultCallback<Boolean> listener) {
        move(oldPath, newPath, listener);
    }

    public static boolean isRootPath(String path) {
        String[] paths = new String[] {SysUtils.getInternalStorageDirectory(), "/sdcard", "/mnt/sdcard", "/storage/emulated", "/storage/sdcard0", "/storage/sdcard1"};
        for (String prefix : paths) {
            if (path.startsWith(prefix)) {
                String androidPath = prefix + "/Android/";
                return path.startsWith(androidPath) || androidPath.equals(path);
            }
        }

        File file = new File(path);
        return !file.canRead() || !file.canWrite();
    }

    public void exists(String path, final OnResultCallback<Boolean> listener) {
        run(new ExistsRunner(path) {

            @Override
            public void onResult(Boolean result, @NonNull String errors) {
                if (!errors.isEmpty()) {
                    listener.onError(errors);
                    return;
                }
                listener.onSuccess(result);
            }

        });
    }

    public void isDirectory(String path, final OnResultCallback<Boolean> listener) {
        run(new IsDirectoryRunner(path) {

            @Override
            public void onResult(Boolean result, @NonNull String errors) {
                listener.onSuccess(result);
            }
        });
    }

    public void listFileInfo(String path, final OnResultCallback<List<FileInfo>> callback) {

        if (!path.endsWith("/"))
            path += "/";

        run(new ListFileRunner(path) {
            @Override
            public void onResult(List<FileInfo> result, @NonNull String errors) {
                if (result.isEmpty() && !errors.isEmpty()) {
                    callback.onError(errors);
                } else {
                    callback.onSuccess(result);
                }
            }
        });
    }

    public void isRootAvailable(final OnResultCallback<Boolean> listener) {
        run(new Runner<Boolean>() {
            @Override
            public String command() {
                return "id";
            }

            @Override
            protected void process(List<String> result, @NonNull String errors) {
                onResult(result != null && !result.isEmpty() && result.get(0).contains("uid=0"), errors);
            }

            @Override
            public void onResult(Boolean result, @NonNull String errors) {
                listener.onSuccess(result);
            }
        });
    }
}
