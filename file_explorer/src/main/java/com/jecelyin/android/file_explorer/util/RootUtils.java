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

package com.jecelyin.android.file_explorer.util;

import android.text.TextUtils;

import com.jecelyin.common.utils.L;
import com.stericson.RootShell.RootShell;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootShell.execution.Shell;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class RootUtils {
    private static final String TAG = "RootUtils";

    public static class RootCommand extends Command {
        private StringBuilder stringBuilder;

        public RootCommand(String commandFormat, Object... args) {
            super(0, true, String.format(commandFormat, args));
            stringBuilder = new StringBuilder();
        }

        @Override
        public void commandOutput(int id, String line) {
            stringBuilder.append(line).append("\n");
            super.commandOutput(id, line);
        }

        @Override
        public void commandCompleted(int id, int exitcode) {
            super.commandCompleted(id, exitcode);

            onFinish(exitcode == 0, stringBuilder.toString());
        }

        public void onFinish(boolean success, String output) {}
    }

    public static void commandWait(Shell shell, Command cmd) throws Exception {
        while (!cmd.isFinished()) {

            synchronized (cmd) {
                try {
                    if (!cmd.isFinished()) {
                        cmd.wait(2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (!cmd.isExecuting() && !cmd.isFinished()) {
                if (!shell.isExecuting && !shell.isReading) {
                    Exception e = new Exception();
                    e.setStackTrace(Thread.currentThread().getStackTrace());
                    e.printStackTrace();
                    L.d(TAG, "Waiting for a command to be executed in a shell that is not executing and not reading! \n\n Command: " + cmd.getCommand(), e);
                } else if (shell.isExecuting && !shell.isReading) {
                    Exception e = new Exception();
                    e.setStackTrace(Thread.currentThread().getStackTrace());
                    e.printStackTrace();
                    L.d(TAG, "Waiting for a command to be executed in a shell that is executing but not reading! \n\n Command: " + cmd.getCommand(), e);
                } else {
                    Exception e = new Exception();
                    e.setStackTrace(Thread.currentThread().getStackTrace());
                    e.printStackTrace();
                    L.d(TAG, "Waiting for a command to be executed in a shell that is not reading! \n\n Command: " + cmd.getCommand(), e);
                }
            }

        }
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

    public static List<FileInfo> listFileInfo(String path) {
        final List<String> result = new ArrayList<>();
        final List<FileInfo> files = new ArrayList<>();

        Command command = new Command(0, false, "ls -la \"" + path + "\"") {
            @Override
            public void commandOutput(int id, String line) {
                RootShell.log(line);
                result.add(line);

                super.commandOutput(id, line);
            }
        };

        try {
            //Try without root...
            Shell shell = RootShell.getShell(true);
            shell.add(command);
            RootUtils.commandWait(shell, command);

        } catch (Exception e) {
            L.e(e);
            return files;
        }

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
            for (;;) {
                List<FileInfo> fileInfos = listFileInfo(linkPath);
                if (fileInfos.isEmpty())
                    break;
                FileInfo fi = fileInfos.get(0);
                if (!fi.isSymlink) {
                    file.isDirectory = fi.isDirectory;
                    break;
                }
                linkPath = fi.linkedPath;
            }
        }

        return file;
    }
}
