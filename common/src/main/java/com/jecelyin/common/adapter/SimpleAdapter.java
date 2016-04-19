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

package com.jecelyin.common.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public abstract class SimpleAdapter extends BaseAdapter {
    public static class SimpleViewHolder {
        public View itemView;

        public SimpleViewHolder(View itemView) {
            this.itemView = itemView;
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    final public View getView(int position, View convertView, ViewGroup parent) {
        SimpleViewHolder holder;
        if(convertView == null) {
            holder = onCreateViewHolder(parent);
            convertView = holder.itemView;
            convertView.setTag(holder);
        } else {
            holder = (SimpleViewHolder) convertView.getTag();
        }
        onBindViewHolder(holder, position);
        return convertView;
    }

    public abstract SimpleViewHolder onCreateViewHolder(ViewGroup parent);
    public abstract void onBindViewHolder(SimpleViewHolder holder, int position);
}
