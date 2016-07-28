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

package com.jecelyin.editor.v2.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jecelyin.editor.v2.Pref;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class SymbolBarPreference extends MaterialEditTextPreference {

    public SymbolBarPreference(Context context) {
        super(context);
    }

    public SymbolBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SymbolBarPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onPrepareDialogBuilder(MaterialDialog.Builder builder) {
        builder.autoDismiss(false);
    }

    @Override
    public String getText() {
        String text = super.getText();
        String[] strings = TextUtils.split(text, "\n");
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            string = string.trim();
            if (string.isEmpty())
                continue;
            if (sb.length() > 0)
                sb.append("\n");
            sb.append(string);
        }
        return sb.toString();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        super.onClick(dialog, which);

        if (which == DialogInterface.BUTTON_POSITIVE) {
            getDialog().dismiss();
        } else {
            getEditText().setText(Pref.VALUE_SYMBOL);
            setText(Pref.VALUE_SYMBOL);
        }
    }

}
