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

package com.jecelyin.common.widget;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class FormatTextView extends TextView {
    public FormatTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FormatTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        Spanned html = Html.fromHtml(text.toString());
        ClickableSpan[] spans = html.getSpans(0, html.length(), ClickableSpan.class);
        if (spans != null && spans.length > 0) {
            setMovementMethod(LinkMovementMethod.getInstance());
        }
        super.setText(html, type);
    }

    public void setText(String format, Object... args) {
        setText(String.format(format, args));
    }
}
