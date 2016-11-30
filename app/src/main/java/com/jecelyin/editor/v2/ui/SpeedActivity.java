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
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import com.jecelyin.common.app.JecActivity;
import com.jecelyin.common.utils.L;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.core.text.SpannableStringBuilder;
import com.jecelyin.editor.v2.core.widget.JecEditText;
import com.jecelyin.editor.v2.highlight.Buffer;
import com.jecelyin.editor.v2.highlight.jedit.LineManager;
import com.jecelyin.editor.v2.highlight.jedit.Mode;
import com.jecelyin.editor.v2.highlight.jedit.syntax.ModeProvider;
import com.jecelyin.editor.v2.io.FileReader;

import java.io.File;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class SpeedActivity extends JecActivity {

    public static final String PATH = "/sdcard/1/build2.xml";

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, SpeedActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.speed_activity);
        JecEditText editText = new JecEditText(getContext());
        editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        editText.setInputType(editText.getInputType() | EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE);
        setContentView(editText);

        FileReader fr = new FileReader(new File(PATH), "utf-8");
        fr.read();
        SpannableStringBuilder ssb = fr.getBuffer();
        editText.setText(ssb);

        Buffer buffer = new Buffer(this);

        Editable editableText = editText.getEditableText();
        buffer.setEditable(editableText);

        int start = 0;
        int count = ssb.length();
        buffer.insert(0, ssb.toString());

        L.startTracing("textview-highlight");
        int lineNumber = buffer.getLineManager().getLineCount();

        LineManager lineManager = buffer.getLineManager();
        int startLine = lineManager.getLineOfOffset(start);
        int endLine = lineManager.getLineOfOffset(start + count);
        int lineStartOffset = lineManager.getLineStartOffset(startLine);
        int lineEndOffset = lineManager.getLineEndOffset(endLine);

        boolean canHighlight = buffer.isCanHighlight();
        if(startLine == 0 && !canHighlight) {
            Mode mode = ModeProvider.instance.getModeForFile(PATH, null, ssb.subSequence(0, Math.min(80, ssb.length())).toString());

            buffer.setMode(mode);
        }

        ForegroundColorSpan[] spans = editableText.getSpans(lineStartOffset, lineEndOffset, ForegroundColorSpan.class);
        for(ForegroundColorSpan span : spans) {
            editableText.removeSpan(span);
        }

//        highlight(editableText, startLine, endLine);

        L.stopTracing();
    }

}
