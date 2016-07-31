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

package com.jecelyin.android.file_explorer;

import com.jecelyin.android.file_explorer.io.JecFile;
import com.jecelyin.android.file_explorer.util.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class FileClipboard {
    private List<JecFile> clipList = new ArrayList<>();
    private boolean isCopy;

    public boolean canPaste() {
        return !clipList.isEmpty();
    }

    public void setData(boolean isCopy, List<JecFile> data) {
        this.isCopy = isCopy;
        clipList.clear();
        clipList.addAll(data);
    }

    public void paste(JecFile currentDirectory) {
        if (!canPaste())
            return;

        for (JecFile file : clipList) {
            if (file.isDirectory()) {
                FileUtils.copyDirectory(file, currentDirectory, !isCopy);
            } else {
                FileUtils.copyFile(file, currentDirectory.newFile(file.getName()), !isCopy);
            }
        }
    }
}
