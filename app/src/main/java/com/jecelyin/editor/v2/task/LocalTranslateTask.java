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

package com.jecelyin.editor.v2.task;

import android.content.Context;

import com.jecelyin.common.task.JecAsyncTask;
import com.jecelyin.common.task.TaskResult;
import com.jecelyin.common.utils.IOUtils;
import com.jecelyin.common.utils.SysUtils;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.ui.MainActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class LocalTranslateTask extends JecAsyncTask<Void, Void, Boolean> {
    private final Context context;
    private final File stringsFile;

    public LocalTranslateTask(Context context) {
        this.context = context;
        stringsFile = new File(SysUtils.getAppStoragePath(context), "920.strings.xml");
    }

    @Override
    protected void onRun(TaskResult<Boolean> taskResult, Void... params) throws Exception {
        InputStream inputStream = context.getResources().openRawResource(R.raw.strings);
        FileOutputStream fos = new FileOutputStream(stringsFile);
        boolean rs = IOUtils.copyFile(inputStream, fos);
        taskResult.setResult(rs);
    }

    @Override
    protected void onSuccess(Boolean b) {
        if (!b) {
            UIUtils.alert(context, context.getString(R.string.cannt_load_lang_file));
            return;
        }
        ((MainActivity)context).openFile(stringsFile.getPath(), "UTF-8", 0, 0);
        UIUtils.alert(context, context.getString(R.string.local_translate_message));
    }

    @Override
    protected void onError(Exception e) {
        UIUtils.alert(context, context.getString(R.string.cannt_load_lang_file) + "\n" + e.getMessage());
    }
}
