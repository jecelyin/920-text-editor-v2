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

package com.jecelyin.editor.v2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jecelyin.editor.v2.R;


/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class RangeAdapter extends BaseAdapter {
    protected final int minValue;
    protected final int maxValue;
    private final CharSequence[] items;
    private final CharSequence[] values;

    public RangeAdapter(int min, int max, String format) {
        this.minValue = min;
        this.maxValue = max;

        int count = getCount();
        items = new String[count];
        values = new String[count];

        for (int i = 0; i < count; i++) {
            int value = getValue(i);
            values[i] = String.valueOf(value);
            items[i] = format != null ? String.format(format, value) : String.valueOf(value);
        }
    }

    public CharSequence[] getItems() {
        return items;
    }

    public CharSequence[] getValues() {
        return values;
    }

    @Override
    public int getCount() {
        return maxValue - minValue + 1;
    }

    public int getValue(int position) {
        return minValue + position;
    }

    @Override
    public CharSequence getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv;
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(getLayoutResId(), parent, false);
            tv = (TextView) convertView.findViewById(getTextResId());
            convertView.setTag(tv);
        } else {
            tv = (TextView) convertView.getTag();
        }

        tv.setText(getItem(position));
        setupTextView(tv, position);

        return convertView;
    }

    protected int getLayoutResId() {
        return R.layout.md_listitem;
    }

    protected int getTextResId() {
        return R.id.title;
    }

    protected void setupTextView(TextView tv, int position) {

    }
}
