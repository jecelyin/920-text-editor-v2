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

import android.support.annotation.NonNull;

import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class MountFileSystemRWRunner extends Runner<String> {
    private final String path;

    public MountFileSystemRWRunner(String path) {
        this.path = path;
    }

    @Override
    public String command() {
        return "mount";
    }

    @Override
    protected void process(List<String> results, @NonNull String errors) {
        String mountPoint = "", types = null;
        for (String line : results) {
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
            final String mountPointPath = mountPoint;
            // we have the mountpoint, check for mount options if already rw
            if (types.contains("rw")) {
                // already a rw filesystem return
                onResult(null, errors);
            } else if (types.contains("ro")) {
                // read-only file system, remount as rw
                ShellDaemon.getShell().addCommand(new Runner<Boolean>() {
                    @Override
                    public String command() {
                        return "mount -o rw,remount " + mountPointPath;
                    }

                    @Override
                    protected void process(List result, @NonNull String errors) {
                        onResult(result.isEmpty(), errors);
                    }

                    @Override
                    public void onResult(Boolean result, @NonNull String errors) {
                        MountFileSystemRWRunner.this.onResult(result ? mountPointPath : null, errors);
                    }
                });
            }
        } else {
            onResult(null, "");
        }
    }

    @Override
    public void onResult(String mountPoint, @NonNull String errors) {

    }

}