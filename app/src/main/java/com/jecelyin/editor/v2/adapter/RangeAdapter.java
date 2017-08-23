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

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jecelyin.editor.v2.R;

import java.util.HashMap;


/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class RangeAdapter extends PreferenceAdapter<RangeAdapter.RangeViewHolder> {
    protected final int minValue;
    protected final int maxValue;
    private final CharSequence[] items;
    private final CharSequence[] values;

    public RangeAdapter(int min, int max, String format) {
        this.minValue = min;
        this.maxValue = max;

        int count = getItemCount();
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

    public int getValue(int position) {
        return minValue + position;
    }

    @Override
    public RangeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutResId(), parent, false);
        RangeViewHolder vh = new RangeViewHolder(view);
        vh.mTitleTextView = (TextView) view.findViewById(getTextResId());
        return vh;
    }

    @Override
    public void onBindViewHolder(final RangeViewHolder holder, final int position) {
        holder.mTitleTextView.setText(items[position]);
        setupTextView(holder.mTitleTextView, position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getOnItemClickListener() != null) {
                    getOnItemClickListener().onItemClick(holder, position);
                }
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return maxValue - minValue + 1;
    }

    protected int getLayoutResId() {
        return R.layout.md_listitem;
    }

    protected int getTextResId() {
        return R.id.md_title;
    }

    protected void setupTextView(TextView tv, int position) {

    }

    public static class RangeViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitleTextView;
        public HashMap<Integer, View> mViewMap = new HashMap<>();

        public RangeViewHolder(View itemView) {
            super(itemView);
        }
    }
}
