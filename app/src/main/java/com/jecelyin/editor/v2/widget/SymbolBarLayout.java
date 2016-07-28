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

package com.jecelyin.editor.v2.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jecelyin.editor.v2.Pref;
import com.jecelyin.editor.v2.R;

import org.apmem.tools.layouts.FlowLayout;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class SymbolBarLayout extends FlowLayout implements View.OnClickListener {
    private OnSymbolCharClickListener onSymbolCharClickListener;
    private String[] charList;

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
        String symbol = Pref.getInstance(getContext()).getSymbol();
        charList = TextUtils.split(symbol, "\n");
        makeItemViews(getContext());
    }

    private void makeItemViews(Context context) {
        if (charList == null || charList.length == 0)
            return;

        LayoutInflater inflater = LayoutInflater.from(context);

        TextView tv;
        for (String str : charList) {
            tv = (TextView) inflater.inflate(R.layout.symbol_item, this, false);
            tv.setText(str);

            tv.setOnClickListener(this);
            addView(tv);
        }
    }

    @Override
    public void onClick(View v) {
        if (onSymbolCharClickListener == null)
            return;

        String str = ((TextView)v).getText().toString();
        if ("\\t".equals(str)) {
            str = "\t";
        } else if ("\\n".equals(str)) {
            str = "\n";
        }
        onSymbolCharClickListener.onClick(v, str);
    }

    public void setOnSymbolCharClickListener(OnSymbolCharClickListener listener) {
        this.onSymbolCharClickListener = listener;
    }
}
