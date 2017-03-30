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
import android.content.res.TypedArray;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.common.Command;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class CharsetsDialog extends AbstractDialog {
    private String[] names;

    public CharsetsDialog(Context context) {
        super(context);

        initCharsets();
    }

    private void initCharsets() {
        SortedMap m = Charset.availableCharsets();
        Set k = m.keySet();

        names = new String[m.size()];
        Iterator iterator = k.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            String n = (String) iterator.next();
//            Charset e = (Charset) m.get(n);
//            String d = e.displayName();
//            boolean c = e.canEncode();
//            System.out.print(n+", "+d+", "+c);
//            Set s = e.aliases();
//            Iterator j = s.iterator();
//            while (j.hasNext()) {
//                String a = (String) j.next();
//                System.out.print(", "+a);
//            }
//            System.out.println("");
            names[i++] = n;
        }
    }

    @Override
    public void show() {
        MaterialDialog dlg = getDialogBuilder().items(names)
                .title(R.string.reopen_with_encoding)
                .itemsCallback(new MaterialDialog.ListCallback() {

                    @Override
                    public void onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
                        Command command = new Command(Command.CommandEnum.RELOAD_WITH_ENCODING);
                        command.object = names[i];
                        getMainActivity().doCommand(command);
                    }
                })
                .positiveText(R.string.cancel)
                .show();

        handleDialog(dlg);

        TypedArray a = context.obtainStyledAttributes(new int[]{R.attr.dividerColor});
        int dividerColor = a.getColor(0, 0);
        a.recycle();

        dlg.getRecyclerView().addItemDecoration(new HorizontalDividerItemDecoration.Builder(getMainActivity()).build());
    }
}
