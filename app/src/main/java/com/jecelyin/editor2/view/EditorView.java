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

package com.jecelyin.editor2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.jecelyin.editor2.R;
import com.jecelyin.editor2.core.widget.JecEditText;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class EditorView extends RelativeLayout {
    private JecEditText editText;
    private ProgressBar progressView;
    private boolean removed = false;

    public EditorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EditorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        editText = (JecEditText) findViewById(R.id.edit_text);
        progressView = (ProgressBar) findViewById(R.id.progress_view);

    }

    public JecEditText getEditText() {
        return editText;
    }

    public void setLoading(boolean loading) {
        if (loading) {
            editText.setVisibility(GONE);
            progressView.setVisibility(VISIBLE);
        } else {
            editText.setVisibility(VISIBLE);
            progressView.setVisibility(GONE);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removed = true;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved() {
        this.removed = true;
    }
}
