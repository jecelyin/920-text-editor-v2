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
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

import com.jecelyin.common.utils.DrawableUtils;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.adapter.MainMenuAdapter;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class MenuManager {

    private static int toolbarIconNormalColor;
    private static int toolbarIconDisabledColor;
    private static int menuIconNormalColor;

    public MenuManager(MainActivity mainActivity) {
        MainMenuAdapter adapter = new MainMenuAdapter(mainActivity);
        mainActivity.mMenuRecyclerView.setAdapter(adapter);
        adapter.setMenuItemClickListener(mainActivity);
    }

    @SuppressWarnings("ResourceType")
    public static void init(Context context) {
        int[] attrs = new int[] {
                R.attr.toolbarIconNormalColor,
                R.attr.toolbarIconDisabledColor,
                R.attr.menuIconNormalColor,
        };
        TypedArray a = context.obtainStyledAttributes(attrs);
        toolbarIconNormalColor = a.getColor(0, 0);
        toolbarIconDisabledColor = a.getColor(1, 0);
        menuIconNormalColor = a.getColor(2, 0);
        a.recycle();
    }

    public static Drawable makeToolbarNormalIcon(Resources res, int resId) {
        Drawable d = res.getDrawable(resId);
        return DrawableUtils.tintDrawable(d, toolbarIconNormalColor);
    }

    public static Drawable makeToolbarNormalIcon(Drawable d) {
        return DrawableUtils.tintDrawable(d, toolbarIconNormalColor);
    }

    public static Drawable makeToolbarDisabledIcon(Drawable d) {
        return DrawableUtils.tintDrawable(d, toolbarIconDisabledColor);
    }

    public static Drawable makeMenuNormalIcon(Resources res, int resId) {
        Drawable d = res.getDrawable(resId);
        return DrawableUtils.tintDrawable(d, menuIconNormalColor);
    }

    public static Drawable makeMenuNormalIcon(Drawable d) {
        return DrawableUtils.tintDrawable(d, menuIconNormalColor);
    }
}
