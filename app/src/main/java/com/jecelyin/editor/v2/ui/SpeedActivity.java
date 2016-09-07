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
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import com.jecelyin.common.app.JecActivity;
import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.SysUtils;
import com.jecelyin.editor.v2.core.text.SpannableStringBuilder;
import com.jecelyin.editor.v2.core.widget.JecEditText;
import com.jecelyin.editor.v2.io.FileReader;

import java.io.File;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class SpeedActivity extends JecActivity {
    public static void startActicity(Context context) {
        context.startActivity(new Intent(context, SpeedActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        JecEditText editText = new JecEditText(getContext());
        editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        editText.setInputType(editText.getInputType() | EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE);
        setContentView(editText);

        FileReader fr = new FileReader(new File(SysUtils.getSDCardDir(this), "1/TextView.java"), "utf-8");
        long t1 = System.currentTimeMillis();
        fr.read();
        long t2 = System.currentTimeMillis();
        SpannableStringBuilder ssb = fr.getBuffer();
        Debug.startMethodTracing("textview");
        long t3 = System.currentTimeMillis();
        editText.setText(ssb);
        long t4 = System.currentTimeMillis();
        Debug.stopMethodTracing();

        L.d("Speed: #1=%f, #2=%f", (t2 - t1) / 1000f, (t4 - t3) / 1000f);
    }
}
