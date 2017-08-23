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

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jecelyin.editor.v2.R;

import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class IntentChooserAdapter extends RecyclerView.Adapter<IntentChooserAdapter.IntentViewHolder> {
    private final Context context;
    private final List<ResolveInfo> apps;
    private OnIntentItemSelectedListener onIntentItemSelectedListener;

    public interface OnIntentItemSelectedListener {
        void onItemSelected(ResolveInfo ri);
    }

    public IntentChooserAdapter(Context context, List<ResolveInfo> apps) {
        this.context = context;
        this.apps = apps;
    }

    public void setOnIntentItemSelectedListener(OnIntentItemSelectedListener onIntentItemSelectedListener) {
        this.onIntentItemSelectedListener = onIntentItemSelectedListener;
    }

    @Override
    public IntentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new IntentViewHolder(LayoutInflater.from(context).inflate(R.layout.intent_chooser_listitem, parent, false));
    }

    @Override
    public void onBindViewHolder(IntentViewHolder holder, int position) {
        final ResolveInfo info = apps.get(position);
        holder.titleTextView.setText(info.activityInfo.loadLabel(context.getPackageManager()));
        holder.iconImageView.setImageDrawable(info.activityInfo.loadIcon(context.getPackageManager()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onIntentItemSelectedListener != null) {
                    onIntentItemSelectedListener.onItemSelected(info);
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
        return apps == null ? 0 : apps.size();
    }

    static class IntentViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImageView;
        TextView titleTextView;


        public IntentViewHolder(View itemView) {
            super(itemView);
            iconImageView = (ImageView) itemView.findViewById(R.id.iconImageView);
            titleTextView = (TextView) itemView.findViewById(R.id.title_text_view);
        }
    }
}
