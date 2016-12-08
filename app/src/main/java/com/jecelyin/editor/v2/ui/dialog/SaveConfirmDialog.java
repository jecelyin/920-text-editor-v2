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
import com.jecelyin.editor.v2.R;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class SaveConfirmDialog extends AbstractDialog {
    private final MaterialDialog.SingleButtonCallback callback;
    private final String filename;

    public SaveConfirmDialog(Context context, String filename, MaterialDialog.SingleButtonCallback callback) {
        super(context);
        this.callback = callback;
        this.filename = filename;
    }

    @Override
    public void show() {
        getDialogBuilder().title(R.string.confirm_save)
                .content(context.getString(R.string.confirm_save_msg, filename))
                .positiveText(R.string.yes)
                .negativeText(R.string.no)
                .neutralText(R.string.cancel)
                .onPositive(callback)
                .onNegative(callback)
                .show();
    }
}
