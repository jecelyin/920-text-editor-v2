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

package com.jecelyin.editor.v2.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import com.jecelyin.editor.v2.Pref;
import com.jecelyin.editor.v2.adapter.RangeAdapter;


/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class FontSizePreference extends JecListPreference {
    public FontSizePreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public FontSizePreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public FontSizePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontSizePreference(Context context) {
        super(context);
        init();
    }

    public void init() {
        ItemAdapter adapter = new ItemAdapter(Pref.DEF_MIN_FONT_SIZE, Pref.DEF_MAX_FONT_SIZE, "%d sp");
        setEntries(adapter.getItems());
        setEntryValues(adapter.getValues());
        setAdapter(adapter);
    }

    static class ItemAdapter extends RangeAdapter {

        public ItemAdapter(int min, int max, String format) {
            super(min, max, format);
        }

        @Override
        public void setupTextView(TextView tv, int position) {
            int fontSize = getValue(position);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontSize);
        }
    }
}
