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

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jecelyin.editor.v2.R;

import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class IntentChooserAdapter extends BaseAdapter {
    private final Context context;
    private final List<ResolveInfo> apps;
    private final int iconDpi;

    public IntentChooserAdapter(Context context, List<ResolveInfo> apps) {
        this.context = context;
        this.apps = apps;

        ActivityManager activityManager =
                (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        iconDpi = activityManager.getLauncherLargeIconDensity();
    }

    @Override
    public int getCount() {
        return apps == null ? 0 : apps.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView title;
        ImageView icon;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.intent_chooser_listitem, parent, false);
            title = (TextView) convertView.findViewById(R.id.title_text_view);
            icon = (ImageView) convertView.findViewById(R.id.iconImageView);
            convertView.setTag(R.id.title_text_view, title);
            convertView.setTag(R.id.iconImageView, icon);
        } else {
            title = (TextView) convertView.getTag(R.id.title_text_view);
            icon = (ImageView) convertView.getTag(R.id.iconImageView);
        }

        ResolveInfo ri = apps.get(position);
        title.setText(ri.activityInfo.loadLabel(context.getPackageManager()));
        icon.setImageDrawable(ri.activityInfo.loadIcon(context.getPackageManager()));

        return convertView;
    }
}
