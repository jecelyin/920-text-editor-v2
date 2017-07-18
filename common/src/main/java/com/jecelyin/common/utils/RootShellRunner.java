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

import android.text.TextUtils;

import com.jecelyin.common.listeners.BoolResultListener;
import com.jecelyin.common.utils.command.CopyRunner;
import com.jecelyin.common.utils.command.ExistsRunner;
import com.jecelyin.common.utils.command.IsDirectory;
import com.jecelyin.common.utils.command.MkdirRunner;
import com.jecelyin.common.utils.command.MountFileSystemRORunner;
import com.jecelyin.common.utils.command.MountFileSystemRWRunner;
import com.jecelyin.common.utils.command.OnCommandResultCallback;
import com.jecelyin.common.utils.command.Runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

import eu.chainfire.libsuperuser.Debug;
import eu.chainfire.libsuperuser.Shell;

public class RootShellRunner {
    private static final int CALLBACK_CODE = 0;
    private final Shell.Interactive interactive;
    private OnErrorListener onErrorListener;
    private AtomicInteger code = new AtomicInteger(0);

    public interface OnErrorListener {
        void onError(Runner callback);
    }

    public RootShellRunner() {
        interactive = new Shell.Builder().
                useSU().
                setWantSTDERR(true).
                setWatchdogTimeout(5).
                setMinimalLogging(false).open();
    }

    public void onError(OnErrorListener listener) {
        this.onErrorListener = listener;
    }

    public void run(final Runner runner) {
        interactive.addCommand(runner.command(), code.getAndIncrement(), new Shell.OnCommandResultListener() {
            @Override
            public void onCommandResult(int commandCode, int exitCode, List<String> output) {
                runner.onResult(RootShellRunner.this, output);
            }
        });
    }

    /**
     * Copies file using root
     *
     * @param source
     * @param destination
     * @
     */
    public void copy(final String source, final String destination, final OnCommandResultCallback<Boolean> listener) {
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

    /**
     * Creates an empty directory using root
     *
     * @param path path to new directory
     * @
     */
    public void mkdirs(final String path, final OnCommandResultCallback<Boolean> listener) {
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

    /**
     * Recursively removes a path with it's contents (if any)
     *
     * @param path
     * @return boolean whether file was deleted or not
     * @
     */
    public void delete(final String path, final OnCommandResultCallback<Boolean> listener) {
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

    /*public static boolean isBusyboxAvailable()  {
        ArrayList<String> output = runShellCommand("busybox");
        return output.size()!=0;
    }*/

    /**
     * Moves file using root
     *
     * @param path
     * @param destination
     * @
     */
    public void move(final String path, final String destination, final OnCommandResultCallback<Boolean> listener) {
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

    /**
     * Renames file using root
     *
     * @param oldPath path to file before rename
     * @param newPath path to file after rename
     * @return if rename was successful or not
     * @
     */
    public void rename(String oldPath, String newPath, final OnCommandResultCallback<Boolean> listener) {
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

    public void exists(String path, final OnCommandResultCallback<Boolean> listener) {
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

    public void isDirectory(String path, final OnCommandResultCallback<Boolean> listener) {
        run(new IsDirectory(path) {
            @Override
            public void onSuccess(Boolean result) {
                listener.onSuccess(result);
            }
        });
    }

    public static String getRealPath(String file) {
        List<String> paths = new ArrayList<>();
        File parent = new File(file);

        do {
            paths.add(parent.getName());
        } while ((parent = parent.getParentFile()) != null);

        List<FileInfo> infos;
        FileInfo fi;
        String path;
        StringBuilder sb = new StringBuilder();
        for (int i = paths.size() - 1; i >= 0; i--) {
            path = paths.get(i);

            if ("/".equals(path)) {
                continue;
            }
            sb.append("/").append(path);
            infos = listFileInfo(sb.toString());
            if (infos.isEmpty())
                break;
            fi = infos.get(0);
            if (fi.isSymlink) {
                sb.setLength(0);
                sb.append(fi.linkedPath);
            }
        }

        return sb.toString();
    }

    public List<FileInfo> listFileInfo(String path) {
        final List<FileInfo> files = new ArrayList<>();
        if (!path.endsWith("/"))
            path += "/";

        final List<String> result = runShellCommand("ls -la \"" + path + "\"");

        for (String line : result) {
            line = line.trim();
            // lstat '//persist' failed: Permission denied
            if (line.startsWith("lstat \'" + path) && line.contains("\' failed: Permission denied")) {
                line = line.replace("lstat \'" + path, "");
                line = line.replace("\' failed: Permission denied", "");
                if (line.startsWith("/")) {
                    line = line.substring(1);
                }
                FileInfo failedToRead = new FileInfo(false, line);
                files.add(failedToRead);
                continue;
            }
            // /data/data/com.android.shell/files/bugreports: No such file or directory
            if (line.startsWith("/") && line.contains(": No such file")) {
                continue;
            }
            try {
                files.add(lsParser(path, line));
            } catch (Exception e) {
                L.e("parse line error: " + line, e);
            }
        }

        result.clear();
        return files;
    }

    private static FileInfo lsParser(String path, String line) {
        final String[] split = line.split(" ");
        int index = 0;

        FileInfo file = new FileInfo(false, "");

        String date = "";
        String time = "";
        //drwxrwx--x 3 root sdcard_rw 4096 2016-12-17 15:02 obb
        for (String token : split) {
            if (token.trim().isEmpty())
                continue;
            switch (index) {
                case 0: {
                    file.permissions = token;
                    break;
                }
                case 1: {
                    if (TextUtils.isDigitsOnly(token))
                        continue;
                    file.owner = token;
                    break;
                }
                case 2: {
                    file.group = token;
                    break;
                }
                case 3: {
                    if (token.contains("-")) {
                        // No length, this is the date
                        file.size = -1;
                        date = token;
                    } else if (token.contains(",")) {
                        //In /dev, ls lists the major and minor device numbers
                        file.size = -2;
                    } else {
                        // Length, this is a file
                        try {
                            file.size = Long.parseLong(token);
                        } catch (Exception e) {
                            throw new NumberFormatException(e.getMessage() + " Line: " + line);
                        }
                    }
                    break;
                }
                case 4: {
                    if (file.size == -1) {
                        // This is the time
                        time = token;
                    } else {
                        // This is the date
                        date = token;
                    }
                    break;
                }
                case 5: {
                    if (file.size == -2) {
                        date = token;
                    } else if (file.size > -1) {
                        time = token;
                    }
                    break;
                }
                case 6:
                    if (file.size == -2) {
                        time = token;
                    }
                    break;
            }
            index++;
        }

        if (line.length() > 0) {
            final String nameAndLink = line.substring(line.indexOf(time) + time.length() + 1);
            if (nameAndLink.contains(" -> ")) {
                final String[] splitSl = nameAndLink.split(" -> ");
                file.name = splitSl[0].trim();
                String realPath = splitSl[1].trim();
                if (realPath.charAt(0) != '/') {
                    file.linkedPath  = new File(path).getParent() + "/" + realPath;
                } else {
                    file.linkedPath  = realPath;
                }
            } else {
                file.name = nameAndLink;
            }
        }

        try {
            file.lastModified = new SimpleDateFormat("yyyy-MM-ddHH:mm", Locale.getDefault())
                    .parse(date + time).getTime();
        } catch (Exception e) {
//            L.e(e); //ignore: java.text.ParseException: Unparseable date: ""
            file.lastModified = 0;
        }

        file.readAvailable = true;
        file.directoryFileCount = "";

        char type = file.permissions.charAt(0);

        if (type == 'd') {
            file.isDirectory = true;
        } else if (type == 'l') {
            file.isSymlink = true;
            String linkPath = file.linkedPath;
            file.isDirectory = isDirectory(linkPath);
        }

        return file;
    }

    public void isRootAvailable(final OnCommandResultCallback<Boolean> listener) {
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
