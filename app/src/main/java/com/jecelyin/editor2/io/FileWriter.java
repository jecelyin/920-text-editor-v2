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

package com.jecelyin.editor2.io;

import android.os.AsyncTask;
import android.text.Editable;

import com.jecelyin.android.file_explorer.io.RootFile;
import com.stericson.RootTools.RootTools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class FileWriter extends AsyncTask<Editable, Void, Exception> {
    private final String encoding;
    private final File file;
    private final static int BUFFER_SIZE = 16*1024;
    private final File backupFile, tempFile;
    private final File orgiFile;
    private FileWriteListener fileWriteListener;

    public static interface FileWriteListener {
        public void onSuccess();
        public void onError(Exception e);
    }

    public FileWriter(File file, File orgiFile, String encoding) {
        this.file = file;
        this.orgiFile = orgiFile;
        this.backupFile = makeBackupFile(file);
        this.tempFile = makeTempFile(file);
        this.encoding = encoding;
    }

    public void write(Editable text) {
        execute(text);
    }

    public void setFileWriteListener(FileWriteListener fileWriteListener) {
        this.fileWriteListener = fileWriteListener;
    }

    @Override
    protected Exception doInBackground(Editable... params) {
        if(tempFile.exists()) {
            if(!tempFile.delete()) {
                return new IOException("Couldn't remove old temp file " + tempFile);
            }
        }

        Editable text = params[0];
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), encoding), BUFFER_SIZE);
            char[] buffer = new char[BUFFER_SIZE]; //16kb
            int size = text.length();
            if (size > 0) {
                int start = 0, end = BUFFER_SIZE;
                for (;;) {
                    end = Math.min(end, size);
                    text.getChars(start, end, buffer, 0);

                    bw.write(buffer, 0, end - start);
                    start = end;

                    if (end >= size)
                        break;

                    end += BUFFER_SIZE;
                }
            }

            bw.close();
        } catch (Exception e) {
            return e;
        }

        if (!tempFile.isFile()) {
            return new IOException("Couldn't write temp file " + tempFile);
        }

        if(backupFile.exists()) {
            if(!backupFile.delete()) {
                return new IOException("Couldn't remove old backup file " + backupFile);
            }
        }

        if(file.isFile() && !file.renameTo(backupFile)) {
            return new IOException("Couldn't rename file " + file
                    + " to backup file " + backupFile);
        }

        if(!tempFile.renameTo(file)) {
            return new IOException("Couldn't rename temp file " + tempFile
                    + " to file " + file);
        }

        // 注意路径可能是 symbolic links
        if (orgiFile != null && !RootTools.copyFile(file.getAbsolutePath() , (new RootFile(orgiFile.getPath())).getAbsolutePath(), true, false)) {
            return new IOException("Can't copy " + file.getPath() + " content to " + orgiFile.getPath());
        }
        if(file.exists()) {
            if(backupFile.exists() && !backupFile.delete()) {
                return new IOException("Couldn't remove backup file " + backupFile);
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Exception e) {
        if(fileWriteListener == null)
            return;
        if(e == null)
            fileWriteListener.onSuccess();
        else
            fileWriteListener.onError(e);
    }

    private static File makeBackupFile(File prefsFile) {
        return new File(prefsFile.getPath() + ".920.bak");
    }

    private static File makeTempFile(File prefsFile) {
        return new File(prefsFile.getPath() + ".920.tmp");
    }

}
