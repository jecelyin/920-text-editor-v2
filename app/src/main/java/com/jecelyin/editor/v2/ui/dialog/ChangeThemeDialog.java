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
import android.content.Intent;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor.v2.Pref;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.ui.MainActivity;
import com.jecelyin.editor.v2.ThemeList;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class ChangeThemeDialog extends AbstractDialog {
    public ChangeThemeDialog(Context context) {
        super(context);
    }

    @Override
    public void show() {
        int length = ThemeList.themes.length;
        final String[] names = new String[length];
        int themeIndex = Pref.getInstance(context).getTheme();

        ThemeList.Theme theme;
        for (int i = 0; i < length; i++) {
            theme = ThemeList.themes[i];
            names[i] = theme.title + (theme.isDark ? " (" + context.getString(R.string.dark) + ")" : "");
        }

        getDialogBuilder()
            .items(names)
            .title(R.string.change_theme)
            .itemsCallbackSingleChoice(themeIndex, new MaterialDialog.ListCallbackSingleChoice() {

                @Override
                public boolean onSelection(MaterialDialog materialDialog, View view, final int i, CharSequence charSequence) {
                    materialDialog.dismiss();
                    UIUtils.showConfirmDialog(context, R.string.confirm_change_theme_message, new UIUtils.OnClickCallback() {
                        @Override
                        public void onOkClick() {
                            Pref.getInstance(context).setTheme(i);
                            restartApp();
                        }
                    });

                    return true;
                }
            })
            .show();
    }

    private void restartApp() {
        Intent it = new Intent(context, MainActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
    }
}
