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

package com.jecelyin.android.file_explorer.io;

import android.os.Parcel;

import com.jecelyin.android.file_explorer.listener.BoolResultListener;
import com.jecelyin.android.file_explorer.listener.FileListResultListener;
import com.jecelyin.common.utils.FileInfo;
import com.jecelyin.common.utils.RootUtils;

import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class RootFile extends LocalFile {
    private static final String TAG = RootFile.class.getName();
    private FileInfo fileInfo;

    public RootFile(JecFile parent, String child) {
        super(parent, child);
        init();
    }

    public RootFile(String parent, String child) {
        super(parent, child);
        init();
    }

    public RootFile(String pathname) {
        super(pathname);
        init();
    }

    private RootFile(String pathname, FileInfo fileInfo) {
        super(pathname);
        this.fileInfo = fileInfo;
    }

    private void init() {
        List<FileInfo> files = RootUtils.listFileInfo(getPath());
        if (!files.isEmpty()) {
            fileInfo = files.get(0);
        }
    }

    @Override
    public boolean isDirectory() {
        return fileInfo != null ? fileInfo.isDirectory : super.isDirectory();
    }

    @Override
    public boolean isFile() {
        return fileInfo != null ? !fileInfo.isDirectory : super.isFile();
    }

    @Override
    public long lastModified() {
        return fileInfo != null ? fileInfo.lastModified : super.lastModified();
    }

    @Override
    public long length() {
        return fileInfo != null ? fileInfo.size : super.length();
    }

    @Override
    public String getAbsolutePath() {
        return fileInfo != null && fileInfo.isSymlink ? fileInfo.linkedPath : RootUtils.getRealPath(getPath());
    }

    @Override
    public boolean exists() {
        return RootUtils.exists(getPath());
    }

    @Override
    public void delete(final BoolResultListener listener) {
        RootUtils.delete(getPath());
        listener.onResult(!exists());
    }

    @Override
    public void listFiles(FileListResultListener listener) {
        List<FileInfo> list = RootUtils.listFileInfo(getPath());

        int size = list.size();
        RootFile[] results = new RootFile[size];
        FileInfo fi;
        for (int i = 0; i < size; i++) {
            fi = list.get(i);
            results[i] = new RootFile(getPath() + "/" + fi.name, fi);
        }

        listener.onResult(results);
    }

    @Override
    public void mkdirs(final BoolResultListener listener) {
        RootUtils.mkdirs(getPath());
        listener.onResult(RootUtils.isDirectory(getPath()));
    }

    @Override
    public void renameTo(JecFile dest, final BoolResultListener listener) {
        boolean rt = RootUtils.rename(getPath(), dest.getPath());
        listener.onResult(rt);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getPath());
    }

    protected RootFile(Parcel in) {
        this(in.readString());
    }

    public static final Creator<RootFile> CREATOR = new Creator<RootFile>() {
        @Override
        public RootFile createFromParcel(Parcel source) {
            return new RootFile(source);
        }

        @Override
        public RootFile[] newArray(int size) {
            return new RootFile[size];
        }
    };
}
