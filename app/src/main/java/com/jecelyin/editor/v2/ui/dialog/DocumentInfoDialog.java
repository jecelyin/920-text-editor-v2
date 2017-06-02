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

package com.jecelyin.editor.v2.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.ui.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class DocumentInfoDialog extends AbstractDialog {
    private CharSequence path;
    private CharSequence text;
    private Document document;

    public DocumentInfoDialog(Context context) {
        super(context);
    }

    public void setPath(CharSequence path) {
        this.path = path;
    }

    public void setText(CharSequence text) {
        this.text = text;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public void show() {
        Matcher matcher = Pattern.compile("[a-zA-Z]+").matcher(text);
        int wordCount = 0;
        while (matcher.find())
            wordCount++;

        int lineNumber = 1;
        int size = text.length();
        for (int i = 0; i < size; i++) {
            if (text.charAt(i) == '\n')
                lineNumber++;
        }

        View view = LayoutInflater.from(context).inflate(R.layout.document_info, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mPathTextView.setText(context.getString(R.string.path_x, path == null ? "" : path));
        viewHolder.mCharCountTextView.setText(context.getString(R.string.char_x, text.length()));
        viewHolder.mWordCountTextView.setText(context.getString(R.string.word_x, wordCount));
        viewHolder.mEncodingTextView.setText(context.getString(R.string.encoding_x, document.getEncoding()));
        viewHolder.mLineCountTextView.setText(context.getString(R.string.line_number_x, lineNumber));

        MaterialDialog dlg = getDialogBuilder().title(R.string.document_info)
                .customView(view, false)
                .positiveText(R.string.close)
                .show();

        handleDialog(dlg);
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'document_info.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Inmite Developers (http://inmite.github.io)
     */
    static class ViewHolder {
        TextView mPathTextView;
        TextView mEncodingTextView;
        TextView mWordCountTextView;
        TextView mCharCountTextView;
        TextView mLineCountTextView;

        ViewHolder(View view) {
            mPathTextView = (TextView) view.findViewById(R.id.path_textView);
            mEncodingTextView = (TextView) view.findViewById(R.id.encoding_textView);
            mWordCountTextView = (TextView) view.findViewById(R.id.word_count_textView);
            mCharCountTextView = (TextView) view.findViewById(R.id.char_count_textView);
            mLineCountTextView = (TextView) view.findViewById(R.id.line_count_textView);
        }
    }
}
