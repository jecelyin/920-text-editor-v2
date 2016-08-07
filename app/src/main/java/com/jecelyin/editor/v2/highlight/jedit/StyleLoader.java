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

package com.jecelyin.editor.v2.highlight.jedit;

import android.content.Context;
import android.content.res.TypedArray;

import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.highlight.jedit.syntax.SyntaxStyle;
import com.jecelyin.editor.v2.highlight.jedit.syntax.Token;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class StyleLoader {
    public static SyntaxStyle[] loadStyles(Context context) {
        int[] attrs = new int[] {
                R.attr.hlComment1,
                R.attr.hlComment2,
                R.attr.hlComment3,
                R.attr.hlComment4,
                R.attr.hlDigit,
                R.attr.hlFunction,
                R.attr.hlInvalid,
                R.attr.hlKeyword1,
                R.attr.hlKeyword2,
                R.attr.hlKeyword3,
                R.attr.hlKeyword4,
                R.attr.hlLabel,
                R.attr.hlLiteral1,
                R.attr.hlLiteral2,
                R.attr.hlLiteral3,
                R.attr.hlLiteral4,
                R.attr.hlMarkup,
                R.attr.hlOperator,
        };
        TypedArray a = context.obtainStyledAttributes(attrs);
        int i = 0;

        SyntaxStyle[] styles = new SyntaxStyle[Token.ID_COUNT];
        styles[Token.COMMENT1] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.COMMENT2] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.COMMENT3] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.COMMENT4] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.DIGIT] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.FUNCTION] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.INVALID] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.KEYWORD1] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.KEYWORD2] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.KEYWORD3] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.KEYWORD4] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.LABEL] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.LITERAL1] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.LITERAL2] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.LITERAL3] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.LITERAL4] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.MARKUP] = new SyntaxStyle(a.getColor(i++, 0), 0);
        styles[Token.OPERATOR] = new SyntaxStyle(a.getColor(i++, 0), 0);

        a.recycle();

        return styles;
    }
}
