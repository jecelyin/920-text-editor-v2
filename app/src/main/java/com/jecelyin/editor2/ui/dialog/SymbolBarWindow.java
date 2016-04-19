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

package com.jecelyin.editor2.ui.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jecelyin.editor2.R;
import com.jecelyin.editor2.ui.MainActivity;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class SymbolBarWindow extends PopupWindow implements View.OnClickListener {
    private static final String charList = "x{}<>,;\"()/\\'%[]|#=$:&?!@^+*-_\t\n";
    private final MainActivity mainActivity;

    ViewGroup mCharListLayout;

    public SymbolBarWindow(MainActivity context) {
        super(context);

        this.mainActivity = context;

        setWindowLayoutMode(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new ColorDrawable());
        setTouchable(true);

        View view = LayoutInflater.from(context).inflate(R.layout.symbol_layout, null);
        mCharListLayout = (ViewGroup) view.findViewById(R.id.char_list_layout);

        makeItemViews(context);
        setContentView(view);
        setInputMethodMode(INPUT_METHOD_NEEDED);
    }

    private void makeItemViews(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);

        TextView tv;
        char c;
        int size = charList.length();
        String str;
        for(int i=0; i<size; i++) {
            c = charList.charAt(i);
            if(c == '\t') {
                str = "\\t";
            } else if(c == '\n') {
                str = "\\n";
            } else {
                str = String.valueOf(c);
            }
            tv = (TextView) inflater.inflate(R.layout.symbol_item, mCharListLayout, false);
            tv.setTag(c);

            if(c == 'x') //占位
                tv.setBackgroundResource(R.drawable.round_close);
            else
                tv.setText(str);

            tv.setOnClickListener(this);
            mCharListLayout.addView(tv);
        }
    }

    public void showAtLocation(View parent) {
        super.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
    }

    @Override
    public void onClick(View v) {
        if(mainActivity == null)
            return;
        char c = (char)v.getTag();
        if(c == 'x') {
            dismiss();
            return;
        }
        mainActivity.insertText(String.valueOf(c));
    }

}
