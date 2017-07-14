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

import com.jecelyin.common.utils.RootShellRunner;

import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class MountFileSystemRWRunner implements Runner<String> {
    private final String path;

    public MountFileSystemRWRunner(String path) {
        this.path = path;
    }

    @Override
    public String command() {
        return "mount";
    }

    @Override
    public void onResult(RootShellRunner runner, List<String> results) {
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
                onSuccess(null);
            } else if (types.contains("ro")) {
                // read-only file system, remount as rw
                runner.run(new Runner() {
                    @Override
                    public String command() {
                        return "mount -o rw,remount " + mountPointPath;
                    }

                    @Override
                    public void onResult(RootShellRunner runner, List results) {
                        if (results.isEmpty())
                            MountFileSystemRWRunner.this.onSuccess(mountPointPath);
                        else
                            MountFileSystemRWRunner.this.onError(results.toString());
                    }

                    @Override
                    public void onError(String error) {

                    }

                    @Override
                    public void onSuccess(Object result) {

                    }
                });
            }
        }
    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onSuccess(String result) {

    }
}