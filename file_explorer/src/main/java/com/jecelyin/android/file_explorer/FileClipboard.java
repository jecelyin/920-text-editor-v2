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

import android.content.Context;
import android.text.TextUtils;

import com.jecelyin.android.file_explorer.io.JecFile;
import com.jecelyin.android.file_explorer.listener.OnClipboardDataChangedListener;
import com.jecelyin.android.file_explorer.listener.OnClipboardPasteFinishListener;
import com.jecelyin.android.file_explorer.util.FileUtils;
import com.jecelyin.common.app.ProgressDialog;
import com.jecelyin.common.task.JecAsyncTask;
import com.jecelyin.common.task.TaskResult;
import com.jecelyin.common.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class FileClipboard {
    private List<JecFile> clipList = new ArrayList<>();
    private boolean isCopy;
    private OnClipboardDataChangedListener onClipboardDataChangedListener;

    public boolean canPaste() {
        return !clipList.isEmpty();
    }

    public void setData(boolean isCopy, List<JecFile> data) {
        this.isCopy = isCopy;
        clipList.clear();
        clipList.addAll(data);
        if (onClipboardDataChangedListener != null)
            onClipboardDataChangedListener.onClipboardDataChanged();
    }

    public void paste(Context context, JecFile currentDirectory, OnClipboardPasteFinishListener listener) {
        if (!canPaste())
            return;

        ProgressDialog dlg = new ProgressDialog(context);
        PasteTask task = new PasteTask(listener);
        task.setProgress(dlg);
        task.execute(currentDirectory);
    }

    public void showPasteResult(Context context, int count, String error) {
        if (TextUtils.isEmpty(error)) {
            UIUtils.toast(context, R.string.x_items_completed, count);
        } else {
            UIUtils.toast(context, R.string.x_items_completed_and_error_x, count, error);
        }
    }

    private class PasteTask extends JecAsyncTask<JecFile, JecFile, Integer> {
        private final OnClipboardPasteFinishListener listener;
        private StringBuilder errorMsg = new StringBuilder();

        public PasteTask(OnClipboardPasteFinishListener listener) {
            this.listener = listener;
        }

        @Override
        protected void onProgressUpdate(JecFile... values) {
            getProgress().setMessage(values[0].getPath());
        }

        @Override
        protected void onRun(TaskResult<Integer> taskResult, JecFile... params) throws Exception {
            JecFile currentDirectory = params[0];
            int count = 0;
            for (JecFile file : clipList) {
                publishProgress(file);
                try {
                    if (file.isDirectory()) {
                        FileUtils.copyDirectory(file, currentDirectory, !isCopy);
                    } else {
                        FileUtils.copyFile(file, currentDirectory.newFile(file.getName()), !isCopy);
                    }
                    count++;
                } catch (Exception e) {
                    errorMsg.append(e.getMessage()).append("\n");
                }
            }
            clipList.clear();
            taskResult.setResult(count);
        }

        @Override
        protected void onSuccess(Integer integer) {
            if (listener != null) {
                listener.onFinish(integer, errorMsg.toString());
            }
        }

        @Override
        protected void onError(Exception e) {
            if (listener != null) {
                listener.onFinish(0, e.getMessage());
            }
        }
    }

    public void setOnClipboardDataChangedListener(OnClipboardDataChangedListener onClipboardDataChangedListener) {
        this.onClipboardDataChangedListener = onClipboardDataChangedListener;
    }
}
