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
import android.view.inputmethod.EditorInfo;

import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.StringUtils;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.common.Command;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class GotoLineDialog extends AbstractDialog {
    public GotoLineDialog(Context context) {
        super(context);
    }

    @Override
    public void show() {
        UIUtils.showInputDialog(context, R.string.goto_line, 0, null, EditorInfo.TYPE_CLASS_NUMBER, new UIUtils.OnShowInputCallback() {
            @Override
            public void onConfirm(CharSequence input) {
                try {
                    int line = StringUtils.toInt(input.toString());
                    Command command = new Command(Command.CommandEnum.GOTO_LINE);
                    command.args.putInt("line", line);
                    getMainActivity().doCommand(command);
                } catch (Exception e) {
                    L.e(e);
                }
            }
        });
    }
}
