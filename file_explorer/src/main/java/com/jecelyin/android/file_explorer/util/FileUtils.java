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

import com.jecelyin.android.file_explorer.ExplorerException;
import com.jecelyin.android.file_explorer.io.JecFile;
import com.jecelyin.android.file_explorer.listener.BoolResultListener;
import com.jecelyin.android.file_explorer.listener.FileListResultListener;
import com.stericson.RootTools.RootTools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    public static void copyDirectory(final JecFile srcDir, JecFile destDir
                                     , final boolean moveFile) {
        if (srcDir == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (destDir == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!srcDir.exists()) {
            throw new ExplorerException("Source '" + srcDir + "' does not exist");
        }
        if (!srcDir.isDirectory()) {
            throw new ExplorerException("Source '" + srcDir + "' exists but is not a directory");
        }
        if (srcDir.getAbsolutePath().equals(destDir.getAbsolutePath())) {
            throw new ExplorerException("Source '" + srcDir + "' and destination '" + destDir + "' are the same");
        }

        final JecFile destDir2 = destDir.newFile(srcDir.getName());

        // Cater for destination being directory within the source directory (see IO-141)
        if (destDir.getAbsolutePath().startsWith(srcDir.getAbsolutePath())) {
            srcDir.listFiles(new FileListResultListener() {
                @Override
                public void onResult(JecFile[] srcFiles) {
                    List<JecFile> exclusionList = null;
                    if (srcFiles != null && srcFiles.length > 0) {
                        exclusionList = new ArrayList<>(srcFiles.length);
                        for (JecFile srcFile : srcFiles) {
                            JecFile copiedFile = destDir2.newFile(srcFile.getName());
                            exclusionList.add(copiedFile.getAbsoluteFile());
                        }
                    }
                    doCopyDirectory(srcDir, destDir2, moveFile, exclusionList);
                }
            });
        } else {
            doCopyDirectory(srcDir, destDir2, moveFile, null);
        }
    }

    private static void doCopyDirectory(final JecFile srcDir, final JecFile destDir,
                                        final boolean moveFile, final List<JecFile> exclusionList) {
        srcDir.listFiles(new FileListResultListener() {
            @Override
            public void onResult(final JecFile[] srcFiles) {
                if (srcFiles == null) {  // null if abstract pathname does not denote a directory, or if an I/O error occurs
                    throw new ExplorerException("Failed to list contents of " + srcDir);
                }
                if (destDir.exists()) {
                    if (!destDir.isDirectory()) {
                        throw new ExplorerException("Destination '" + destDir + "' exists but is not a directory");
                    }
                    doCopyDirectory(srcDir, destDir, srcFiles, moveFile, exclusionList);
                } else {
                    destDir.mkdirs(new BoolResultListener() {
                        @Override
                        public void onResult(boolean result) {
                            if (!result && !destDir.isDirectory()) {
                                throw new ExplorerException("Destination '" + destDir + "' directory cannot be created");
                            }
                            doCopyDirectory(srcDir, destDir, srcFiles, moveFile, exclusionList);
                        }
                    });
                }
            }
        });
    }

    private static void doCopyDirectory(JecFile srcDir, final JecFile destDir, JecFile[] srcFiles,
                                        final boolean moveFile, final List<JecFile> exclusionList) throws ExplorerException {
        if (!destDir.canWrite()) {
            throw new ExplorerException("Destination '" + destDir + "' cannot be written to");
        }
        for (final JecFile srcFile : srcFiles) {
            JecFile dstFile = destDir.newFile(srcFile.getName()); //new File(destDir, srcFile.getName());
            if (exclusionList == null || !exclusionList.contains(srcFile.getAbsoluteFile())) {
                if (srcFile.isDirectory()) {
                    doCopyDirectory(srcFile, dstFile, moveFile, exclusionList);
                } else {
                    copyFile(srcFile, dstFile, moveFile);
                }
            }
        }
    }

    public static void copyFile(final JecFile srcFile, final JecFile dstFile, boolean moveFile) {
        if (moveFile) {
            srcFile.renameTo(dstFile, new BoolResultListener() {
                @Override
                public void onResult(boolean result) {
                    if (!result)
                        throw new ExplorerException("Source '" + srcFile + "' move to destination '" + dstFile + "' fail");
                }
            });
        } else {
            srcFile.copyTo(dstFile, new BoolResultListener() {
                @Override
                public void onResult(boolean result) {
                    if (!result)
                        throw new ExplorerException("Source '" + srcFile + "' copy to destination '" + dstFile + "' fail");
                }
            });
        }
    }

}
