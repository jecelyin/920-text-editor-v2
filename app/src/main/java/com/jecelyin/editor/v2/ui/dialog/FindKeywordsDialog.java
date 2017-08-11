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
import android.support.annotation.NonNull;
import android.view.View;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.jecelyin.common.widget.DrawClickableEditText;
import com.jecelyin.editor.v2.R;
import com.jecelyin.common.utils.DBHelper;

import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class FindKeywordsDialog extends AbstractDialog implements MaterialDialog.SingleButtonCallback, MaterialDialog.ListCallback {
    private final boolean isReplace;
    private final DrawClickableEditText editText;

    public FindKeywordsDialog(Context context, DrawClickableEditText editText, boolean isReplace) {
        super(context);
        this.isReplace = isReplace;
        this.editText = editText;
    }

    @Override
    public void show() {
        List<String> items = DBHelper.getInstance(context).getFindKeywords(isReplace);

        MaterialDialog dlg = getDialogBuilder()
                .items(items)
                .dividerColorRes(R.color.md_divider_black)
                .negativeText(R.string.clear_history)
                .onNegative(this)
                .positiveText(R.string.close)
                .title(isReplace ? R.string.replace_log : R.string.find_log)
                .itemsCallback(this)
                .show();
        handleDialog(dlg);
    }

    @Override
    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
        switch (which) {
            case NEGATIVE:
                DBHelper.getInstance(context).clearFindKeywords(isReplace);
            default:
                dialog.dismiss();
                break;
        }
    }

    @Override
    public void onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
        dialog.dismiss();
        editText.setText(text.toString());
    }
}
