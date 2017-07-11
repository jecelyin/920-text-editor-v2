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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import eu.chainfire.libsuperuser.Shell;

public class RootUtils {
    public static final String DATA_APP_DIR = "/data/app";
    private static final String LS = "ls -lAnH \"%\" --color=never";
    private static final String LSDIR = "ls -land \"%\" --color=never";
    public static final String SYSTEM_APP_DIR = "/system/app";
    private static final Pattern mLsPattern;
    private static final Shell.Builder shellBuilder;

    static {
        mLsPattern = Pattern.compile(".[rwxsStT-]{9}\\s+.*");
        shellBuilder = new Shell.Builder().
                useSU().
                setWantSTDERR(true).
                setWatchdogTimeout(5).
                setMinimalLogging(false);
    }

    /**
     * @param cmd the command
     * @return a list of results. Null only if the command passed is a blocking call or no output is
     * there for the command passed
     * @
     */
    public static ArrayList<String> runShellCommand(String cmd) {
        final ArrayList<String> result = new ArrayList<>();

        Shell.Interactive interactive = shellBuilder.open();
        interactive.addCommand(cmd, 1, new Shell.OnCommandResultListener() {
            @Override
            public void onCommandResult(int commandCode, int exitCode, List<String> output) {

                for (String line : output) {
                    result.add(line);
                }
            }
        });
        interactive.close();
        return result;
    }

    /**
     * Runs the command on an interactive shell. Provides a listener for the caller to interact.
     * The caller is executed on a worker background thread, hence any calls from the callback
     * should be thread safe.
     * Command is run from superuser context (u:r:SuperSU0)
     *
     * @param cmd      the command
     * @param callback
     * @return a list of results. Null only if the command passed is a blocking call or no output is
     * there for the command passed
     * @
     */
    public static void runShellCommand(String cmd, Shell.OnCommandResultListener callback) {
        Shell.Interactive interactive = shellBuilder.open();
        interactive.addCommand(cmd, 1, callback);
        interactive.close();
    }

    public static boolean isValid(String str) {
        return mLsPattern.matcher(str).matches();
    }

    public static boolean isUnixVirtualDirectory(String str) {
        return str.startsWith("/proc") || str.startsWith("/sys");
    }

    /**
     * Get a shell based listing
     * Context is superuser level shell
     *
     * @param str
     * @return
     */
    public static ArrayList<String> getDirListingSu(String str) {
        ArrayList<String> arrayLis = runShellCommand(LS.replace("%", str));
        return arrayLis;
    }

    /**
     * Change permissions (owner/group/others) of a specified path
     *
     * @param path
     * @param octalNotation octal notation of permission
     * @
     */
    public static void chmod(String path, int octalNotation) {

        String mountPoint = mountFileSystemRW(path);

        String command = "chmod %d \"%s\"";

        runShellCommand(String.format(command, octalNotation, path));

        if (mountPoint != null) {
            // we mounted the filesystem as rw, let's mount it back to ro
            mountFileSystemRO(mountPoint);
        }
    }


    /**
     * Mount filesystem associated with path for writable access (rw)
     * Since we don't have the root of filesystem to remount, we need to parse output of
     * # mount command.
     *
     * @param path the path on which action to perform
     * @return String the root of mount point that was ro, and mounted to rw; null otherwise
     * @
     */
    private static String mountFileSystemRW(String path) {
        String command = "mount";
        ArrayList<String> output = runShellCommand(command);
        String mountPoint = "", types = null;
        for (String line : output) {
            String[] words = line.split(" ");

            if (words.length >= 4 && path.contains(words[1])) {
                // current found point is bigger than last one, hence not a conflicting one
                // we're finding the best match, this omits for eg. / and /sys when we're actually
                // looking for /system
                if (words[1].length() > mountPoint.length()) {
                    mountPoint = words[1];
                    types = words[3];
                }
            }
        }

        if (!mountPoint.equals("") && types != null) {

            // we have the mountpoint, check for mount options if already rw
            if (types.contains("rw")) {
                // already a rw filesystem return
                return null;
            } else if (types.contains("ro")) {
                // read-only file system, remount as rw
                String mountCommand = "mount -o rw,remount " + mountPoint;
                ArrayList<String> mountOutput = runShellCommand(mountCommand);

                if (mountOutput.size() != 0) {
                    // command failed, and we got a reason echo'ed
                    return null;
                } else return mountPoint;
            }
        }
        return null;
    }

    /**
     * Mount path for read-only access (ro)
     *
     * @param path the root of device/filesystem to be mounted as ro
     * @
     */
    private static void mountFileSystemRO(String path) {
        String command = "umount -r \"" + path + "\"";
        runShellCommand(command);
    }

    /**
     * Copies file using root
     *
     * @param source
     * @param destination
     * @
     */
    public static boolean copy(String source, String destination) {

        // remounting destination as rw
        String mountPoint = mountFileSystemRW(destination);

        ArrayList<String> results = runShellCommand("cp \"" + source + "\" \"" + destination + "\"");


        if (mountPoint != null) {
            // we mounted the filesystem as rw, let's mount it back to ro
            mountFileSystemRO(mountPoint);
        }
        return false;
    }

    /**
     * Creates an empty directory using root
     *
     * @param path path to new directory
     * @param name name of directory
     * @
     */
    public static void mkDir(String path, String name) {

        String mountPoint = mountFileSystemRW(path);

        runShellCommand("mkdir \"" + path + "/" + name + "\"");
        if (mountPoint != null) {
            // we mounted the filesystem as rw, let's mount it back to ro
            mountFileSystemRO(mountPoint);
        }
    }

    /**
     * Creates an empty file using root
     *
     * @param path path to new file
     * @
     */
    public static void mkFile(String path) {

        String mountPoint = mountFileSystemRW(path);

        runShellCommand("touch \"" + path + "\"");
        if (mountPoint != null) {
            // we mounted the filesystem as rw, let's mount it back to ro
            mountFileSystemRO(mountPoint);
        }
    }


    /**
     * Returns file permissions in octal notation
     * Method requires busybox
     *
     * @param path
     * @return
     */
    private static int getFilePermissions(String path) {
        String line = runShellCommand("stat -c  %a \"" + path + "\"").get(0);

        return Integer.valueOf(line);
    }

    /**
     * Recursively removes a path with it's contents (if any)
     *
     * @param path
     * @return boolean whether file was deleted or not
     * @
     */
    public static boolean delete(String path) {

        String mountPoint = mountFileSystemRW(path);

        ArrayList<String> result = runShellCommand("rm -rf \"" + path + "\"");

        if (mountPoint != null) {
            // we mounted the filesystem as rw, let's mount it back to ro
            mountFileSystemRO(mountPoint);
        }

        return result.size() != 0;
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
    public static void move(String path, String destination) {

        // remounting destination as rw
        String mountPoint = mountFileSystemRW(destination);

        //mountOwnerRW(mountPath);
        runShellCommand("mv \"" + path + "\" \"" + destination + "\"");

        if (mountPoint != null) {
            // we mounted the filesystem as rw, let's mount it back to ro
            mountFileSystemRO(mountPoint);
        }
    }

    /**
     * Renames file using root
     *
     * @param oldPath path to file before rename
     * @param newPath path to file after rename
     * @return if rename was successful or not
     * @
     */
    public static boolean rename(String oldPath, String newPath) {

        String mountPoint = mountFileSystemRW(oldPath);

        ArrayList<String> output = runShellCommand("mv \"" + oldPath + "\" \"" + newPath + "\"");

        if (mountPoint != null) {
            // we mounted the filesystem as rw, let's mount it back to ro
            mountFileSystemRO(mountPoint);
        }

        return output.size() == 0;
    }

    public static void cat(String sourcePath, String destinationPath) {

        String mountPoint = mountFileSystemRW(destinationPath);

        runShellCommand("cat \"" + sourcePath + "\" > \"" + destinationPath + "\"");
        if (mountPoint != null) {
            // we mounted the filesystem as rw, let's mount it back to ro
            mountFileSystemRO(mountPoint);
        }
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
}
