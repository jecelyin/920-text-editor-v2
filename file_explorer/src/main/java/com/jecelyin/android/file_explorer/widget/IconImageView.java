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

package com.jecelyin.android.file_explorer.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.widget.Checkable;

import com.jecelyin.android.file_explorer.R;
import com.makeramen.roundedimageview.RoundedImageView;

/**
 * Created by jecelyin on 16/7/29.
 */

public class IconImageView extends RoundedImageView implements Checkable {
    private int defaultBackgroundColor;
    private int defaultImageResource;
    private boolean checked;

    public IconImageView(Context context) {
        super(context);
    }

    public IconImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IconImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setDefaultBackgroundColor(int color) {
        super.setBackgroundColor(color);
        defaultBackgroundColor = color;
    }

    public void setDefaultImageResource(@DrawableRes int resId) {
        super.setImageResource(resId);
        defaultImageResource = resId;
    }

    public void reset() {
        setBackgroundColor(defaultBackgroundColor);
        setImageResource(defaultImageResource);
    }

    @Override
    public void setChecked(boolean checked) {
        this.checked = checked;
        if (checked) {
            setBackgroundColor(getResources().getColor(R.color.item_icon_select_status));
            setImageResource(R.drawable.file_checked);
        } else {
            setBackgroundColor(defaultBackgroundColor);
            setImageResource(defaultImageResource);
        }
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public void toggle() {
        checked = !checked;
        setChecked(checked);
    }
}
