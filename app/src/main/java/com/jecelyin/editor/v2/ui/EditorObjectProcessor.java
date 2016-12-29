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

import android.annotation.ColorInt;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Parcelable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UpdateAppearance;
import android.view.View;

import com.jecelyin.common.task.TaskListener;
import com.jecelyin.common.utils.L;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.core.text.SpannableStringBuilder;
import com.jecelyin.editor.v2.core.text.method.LinkMovementMethod;
import com.jecelyin.editor.v2.core.widget.JecEditText;
import com.jecelyin.editor.v2.utils.ExtGrep;

import java.io.File;
import java.util.List;


/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class EditorObjectProcessor {
    public static void process(Parcelable object, EditorDelegate editorDelegate) {
        if (object instanceof ExtGrep) {
            new FindInFilesProcessor(object, editorDelegate);
        }
    }

    private static class FindInFilesProcessor {
        private final JecEditText editText;
        private final EditorDelegate editorDelegate;
        private final int findResultsKeywordColor;
        private final int findResultsPathColor;
        ExtGrep grep;

        public FindInFilesProcessor(Parcelable object, EditorDelegate editorDelegate) {
            grep = (ExtGrep) object;
            this.editorDelegate = editorDelegate;
            this.editText = editorDelegate.mEditText;
            editText.setMovementMethod(LinkMovementMethod.getInstance());

            TypedArray a = editText.getContext().obtainStyledAttributes(new int[]{
                    R.attr.findResultsPath,
                    R.attr.findResultsKeyword,
            });
            findResultsPathColor = a.getColor(a.getIndex(0), Color.BLACK);
            findResultsKeywordColor = a.getColor(a.getIndex(1), Color.BLACK);
            a.recycle();

            find();
        }

        private void find() {
            editText.setText(R.string.searching);
            editText.append("\n\n");
            grep.execute(new TaskListener<List<ExtGrep.Result>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onSuccess(List<ExtGrep.Result> result) {
                    buildResults(result);
                }

                @Override
                public void onError(Exception e) {
                    editText.append(e.getMessage());
                    editText.append(editText.getContext().getString(R.string.zero_matches));
                    L.e(e);
                }
            });
        }

        private void buildResults(List<ExtGrep.Result> results) {
            SpannableStringBuilder ssb = new SpannableStringBuilder();

            File file = null;
            for(ExtGrep.Result rs : results) {
                if(file == null || !rs.file.equals(file)) {
                    file = rs.file;
                    ssb.append("\n");
                    ssb.append(file.getPath(), new ForegroundColorSpan(findResultsPathColor), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    ssb.append("\n");
                }
                //%[index$][标识]*[最小宽度][.精度]转换符
//                ssb.append(String.format("%1$4d  %2$s\n", rs.lineNumber, rs.line), new FileClickableSpan(editorDelegate, rs), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ssb.append(String.format("%1$4d  ", rs.lineNumber));
                int start = ssb.length();
                ssb.append(rs.line);
//                ssb.setSpan(new ForegroundColorSpan(findResultsKeywordColor), start + rs.matchStart, start + rs.matchEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ssb.setSpan(new FileClickableSpan(findResultsKeywordColor, editorDelegate, rs), start + rs.matchStart, start + rs.matchEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ssb.append('\n');
            }
            editText.setText(ssb);
        }

    }

    private static class FileClickableSpan extends ClickableSpan
            implements UpdateAppearance {
        private final ExtGrep.Result result;
        private final EditorDelegate editorDelegate;
        private final int mColor;

        public FileClickableSpan(@ColorInt int color, EditorDelegate editorDelegate, ExtGrep.Result result) {
            this.editorDelegate = editorDelegate;
            this.result = result;
            mColor = color;
        }

        @Override
        public void onClick(View widget) {
            editorDelegate.getMainActivity().openFile(result.file.getPath(), null, result.startOffset);
        }

        /**
         * Makes the text underlined and in the link color.
         */
        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(mColor);
            ds.setUnderlineText(true);
        }


    }
}
