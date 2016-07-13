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
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class FileNameEditText extends EditText {

    public FileNameEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FileNameEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setSelectAllOnFocus(true);
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);

        if (!focused)
            return;
        String name = getText().toString();
        int endSel = name.indexOf('.');
        if (endSel < 0)
            endSel = name.length();
        if (endSel > 0) {
            requestFocus();
            setSelection(0, endSel);
        }
    }
}
