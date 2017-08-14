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

package com.jecelyin.android.file_explorer;


import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.jecelyin.common.utils.DBHelper;

import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class RecentPathsMenu extends PopupMenu implements PopupMenu.OnMenuItemClickListener {
    private final Context context;
    private List<String> list;
    private OnPathSelectListener onPathSelectListener;

    public interface OnPathSelectListener {
        void onSelect(String path);
    }

    public RecentPathsMenu(Context context, View anchor) {
        super(context, anchor);
        this.context = context;
        setOnMenuItemClickListener(this);
    }

    public void setOnPathSelectListener(OnPathSelectListener onPathSelectListener) {
        this.onPathSelectListener = onPathSelectListener;
    }

    @Override
    public void show() {
        list = DBHelper.getInstance(context).getRecentPathList();
        Menu menu = getMenu();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            menu.add(0, i, 0, list.get(i));
        }
        try {
            super.show();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId < list.size()) {
            if (onPathSelectListener != null) {
                onPathSelectListener.onSelect(list.get(itemId));
                dismiss();
                return true;
            }
        }
        return false;
    }
}
