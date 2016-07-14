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
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.common.Command;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class WrapCharDialog extends AbstractDialog {
    public WrapCharDialog(Context context) {
        super(context);
    }

    @Override
    public void show() {
        MaterialDialog dlg = getDialogBuilder().items(R.array.wrap_char_list)
                .title(R.string.convert_wrap_char)
                .positiveText(R.string.ok)
                .negativeText(R.string.cancel)
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {

                    @Override
                    public boolean onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
                        return false;
                    }
                })
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        super.onPositive(dialog);
                        int index = dialog.getSelectedIndex();
                        if (index < 0)
                            return;
                        String[] chars = new String[]{"\n", "\r\n"};
                        Command command = new Command(Command.CommandEnum.CONVERT_WRAP_CHAR);
                        command.object = chars[index];
                        getMainActivity().doCommand(command);
                    }
                })
                .show();

        handleDialog(dlg);
    }
}
