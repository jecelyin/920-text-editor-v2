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

package com.jecelyin.editor2.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jecelyin.editor2.R;

import org.apmem.tools.layouts.FlowLayout;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class SymbolBarLayout extends FlowLayout implements View.OnClickListener {
    private static final String charList = "{}<>,;\"()/\\'%[]|#=$:&?!@^+*-_\t\n";

    private OnSymbolCharClickListener onSymbolCharClickListener;

    public interface OnSymbolCharClickListener {
        void onClick(View v, String text);
    }

    public SymbolBarLayout(Context context) {
        super(context);
        init();
    }

    public SymbolBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SymbolBarLayout(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        init();
    }

    private void init() {
        makeItemViews(getContext());
    }

    private void makeItemViews(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);

        TextView tv;
        char c;
        int size = charList.length();
        String str;
        for (int i = 0; i < size; i++) {
            c = charList.charAt(i);
            if (c == '\t') {
                str = "\\t";
            } else if (c == '\n') {
                str = "\\n";
            } else {
                str = String.valueOf(c);
            }
            tv = (TextView) inflater.inflate(R.layout.symbol_item, this, false);
            tv.setTag(c);

            tv.setText(str);

            tv.setOnClickListener(this);
            addView(tv);
        }
    }

    @Override
    public void onClick(View v) {
        if (onSymbolCharClickListener == null)
            return;

        char c = (char)v.getTag();
        onSymbolCharClickListener.onClick(v, String.valueOf(c));
    }

    public void setOnSymbolCharClickListener(OnSymbolCharClickListener listener) {
        this.onSymbolCharClickListener = listener;
    }
}
