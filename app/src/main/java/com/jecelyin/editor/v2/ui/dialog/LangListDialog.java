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
import com.jecelyin.editor.v2.ui.ModeList;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class LangListDialog extends AbstractDialog {
    private String[] langList;
    private int currentLangIndex = -1;

    public LangListDialog(Context context) {
        super(context);

        String currLang = getMainActivity().getCurrentLang();

        int length = ModeList.modes.length;
        langList = new String[length];
        for (int i = 0; i < length; i++) {
            langList[i] = ModeList.modes[i].name;
            if (currLang != null && currLang.equals(langList[i])) {
                currentLangIndex = i;
            }
        }
    }

    @Override
    public void show() {
        MaterialDialog dlg = getDialogBuilder().items(langList)
                .title(R.string.select_lang_to_highlight)
                .itemsCallbackSingleChoice(currentLangIndex, new MaterialDialog.ListCallbackSingleChoice() {

                    @Override
                    public boolean onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
                        Command command = new Command(Command.CommandEnum.CHANGE_MODE);
                        command.object = ModeList.modes[i].mode;
                        getMainActivity().doCommand(command);
                        return true;
                    }
                })
                .negativeText(R.string.cancel)
                .show();

        handleDialog(dlg);
    }
}
