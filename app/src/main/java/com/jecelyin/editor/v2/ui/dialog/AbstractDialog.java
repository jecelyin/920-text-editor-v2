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

package com.jecelyin.editor.v2.ui.dialog;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jecelyin.editor.v2.ui.MainActivity;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public abstract class AbstractDialog {
    protected final Context context;

    public AbstractDialog(Context context) {
        this.context = context;
    }

    protected MaterialDialog.Builder getDialogBuilder() {
        return new MaterialDialog.Builder(context);
    }

    protected void handleDialog(MaterialDialog dlg) {
        dlg.setCanceledOnTouchOutside(false);
        dlg.setCancelable(true);
    }

    protected MainActivity getMainActivity() {
        return (MainActivity) context;
    }

    abstract public void show();
}
