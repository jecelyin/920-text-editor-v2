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

import com.stericson.RootTools.RootTools;

import java.io.File;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class FileUtils {
    private static Boolean mRootAccess = null;

    public static boolean hasRootAccess() {
        if (mRootAccess != null)
            return mRootAccess;
        try {
            mRootAccess = RootTools.isAccessGiven();
        } catch (Exception e) {
            mRootAccess = false;
        }
        return mRootAccess;
    }


    /**
     * Indicates whether file is considered to be "text".
     *
     * @return {@code true} if file is text, {@code false} if not.
     */
    public static boolean isTextFile(File f) {
        return !f.isDirectory() && isMimeText(f.getPath());
    }

    /**
     * Indicates whether requested file path is "text". This is done by
     * comparing file extension to a static list of extensions known to be text.
     * If the file has no file extension, it is also considered to be text.
     *
     * @param file File path
     * @return {@code true} if file is text, {@code false} if not.
     */
    private static boolean isMimeText(String file) {
        if (file == null)
            return false;
        if (!file.contains("."))
            return false;
        file = file.substring(file.lastIndexOf("/") + 1);
//        String ext = file.substring(file.lastIndexOf(".") + 1);
        return MimeTypes.getInstance().getMimeType(file).startsWith("text/");
    }
}
