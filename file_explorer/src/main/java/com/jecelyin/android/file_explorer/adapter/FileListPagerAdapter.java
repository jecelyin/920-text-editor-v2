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

package com.jecelyin.android.file_explorer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.jecelyin.android.file_explorer.FileListPagerFragment;
import com.jecelyin.android.file_explorer.io.JecFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class FileListPagerAdapter extends FragmentPagerAdapter {
    private final List<JecFile> pathList;
    private FileListPagerFragment mCurrentFragment;

    public FileListPagerFragment getCurrentFragment() {
        return mCurrentFragment;
    }

    public FileListPagerAdapter(FragmentManager fm) {
        super(fm);
        this.pathList = new ArrayList<>();
    }

    public void addPath(JecFile path) {
        pathList.add(path);
        notifyDataSetChanged();
    }

    public void removePath(JecFile path) {
        pathList.remove(path);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return pathList == null ? 0 : pathList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return FileListPagerFragment.newFragment(pathList.get(position));
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        mCurrentFragment = (FileListPagerFragment) object;
    }
}
