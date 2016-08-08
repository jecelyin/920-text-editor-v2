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

package com.jecelyin.common.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.jecelyin.common.R;
import com.jecelyin.common.view.StatusBarUtil;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class JecActivity extends AppCompatActivity {

    private boolean isAttached;

    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
        setStatusBarColor(null);
    }

    protected void setStatusBarColor(ViewGroup drawerLayout) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return;
        }
        if (isFullScreenMode())
            return;
        TypedArray a = getTheme().obtainStyledAttributes(new int[]{R.attr.colorPrimary});
        int color = a.getColor(0, Color.TRANSPARENT);
        a.recycle();

        if (drawerLayout != null) {
            StatusBarUtil.setColorForDrawerLayout(this, drawerLayout, color, 0);
        } else {
            StatusBarUtil.setColor(this, color, 0);
        }
    }

    protected boolean isFullScreenMode() {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // 当setDisplayHomeAsUpEnabled(true)时，提供返回支持
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public Context getContext() {
        return this;
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        isAttached = true;
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        isAttached = false;
    }

    public boolean isAttached() {
        return isAttached;
    }

    public boolean isDetached() {
        return !isAttached;
    }
}
