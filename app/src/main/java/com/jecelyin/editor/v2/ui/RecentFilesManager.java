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

package com.jecelyin.editor.v2.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.jecelyin.editor.v2.R;
import com.jecelyin.common.utils.DBHelper;

import java.util.ArrayList;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class RecentFilesManager implements MaterialDialog.ListCallback, MaterialDialog.SingleButtonCallback {
    private final DBHelper dbHelper;
    private OnFileItemClickListener onFileItemClickListener;
    private ArrayList<DBHelper.RecentFileItem> list;

    static interface OnFileItemClickListener {
        void onClick(DBHelper.RecentFileItem item);
    }

    public RecentFilesManager(Context context) {
        dbHelper = DBHelper.getInstance(context.getApplicationContext());
    }

    public void show(Context context) {
        list = dbHelper.getRecentFiles();
//        Collections.sort(list, new Comparator<DBHelper.RecentFileItem>() {
//            @Override
//            public int compare(DBHelper.RecentFileItem lhs, DBHelper.RecentFileItem rhs) {
//                return (int) (lhs.time - rhs.time);
//            }
//        });
        String[] items = new String[list.size()];
        for(int i=list.size()-1; i>=0; i--) {
            items[i] = list.get(i).path;
        }
        new MaterialDialog.Builder(context)
                .items(items)
                .dividerColorRes(R.color.md_divider_black)
                .negativeText(R.string.clear_history)
                .onNegative(this)
                .positiveText(R.string.close)
                .title(R.string.recent_files)
                .itemsCallback(this)
                .show();
    }

    @Override
    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
        if (which == DialogAction.NEGATIVE) {
            dbHelper.clearRecentFiles();
        }
    }

    @Override
    public void onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
        materialDialog.dismiss();
        if(onFileItemClickListener == null)
            return;
        DBHelper.RecentFileItem item = list.get(i);
        onFileItemClickListener.onClick(item);
    }

    public void setOnFileItemClickListener(OnFileItemClickListener onFileItemClickListener) {
        this.onFileItemClickListener = onFileItemClickListener;
    }
}
