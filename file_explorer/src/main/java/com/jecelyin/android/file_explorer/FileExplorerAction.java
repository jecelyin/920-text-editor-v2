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
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

import com.jecelyin.android.file_explorer.io.JecFile;
import com.jecelyin.android.file_explorer.util.OnCheckedChangeListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class FileExplorerAction implements OnCheckedChangeListener, ActionMode.Callback {
    private final FileExplorerView view;
    private final Context context;
    private final FileClipboard fileClipboard;
    private ActionMode actionMode;
    private List<JecFile> checkedList = new ArrayList<>();

    public FileExplorerAction(Context context, FileExplorerView view, FileClipboard fileClipboard) {
        this.view = view;
        this.context = context;
        this.fileClipboard = fileClipboard;
    }

    @Override
    public void onCheckedChanged(JecFile file, int checkedCount, int position, boolean checked) {
        if (checked) {
            checkedList.add(file);
        } else {
            checkedList.remove(file);
        }
        if(checkedCount > 0) {
            if (actionMode == null)
                actionMode = view.startActionMode(this);
            actionMode.setTitle(context.getString(R.string.selected_x_items, checkedCount));
        } else {
            if(actionMode != null) {
                actionMode.finish();
                actionMode = null;
            }
        }
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        menu.add(0, R.id.select_all, 0, R.string.select_all).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, R.id.cut, 0, R.string.cut).setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        menu.add(0, R.id.copy, 0, R.string.copy).setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        if (fileClipboard.canPaste())
            menu.add(0, R.id.paste, 0, R.string.paste).setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

        if (checkedList.size()  == 1) {
            menu.add(0, R.id.rename, 0, R.string.rename).setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
            menu.add(0, R.id.share, 0, R.string.share).setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        }
        menu.add(0, R.id.delete, 0, R.string.delete).setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        return false;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }

    public void destroy() {
        if (actionMode != null) {
            actionMode.finish();
            actionMode = null;
        }
    }
}
