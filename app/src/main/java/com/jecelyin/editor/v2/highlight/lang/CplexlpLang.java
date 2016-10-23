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

package com.jecelyin.editor.v2.highlight.lang;

import com.jecelyin.editor.v2.highlight.LangDefine;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class CplexlpLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"+-/*^=<>\\\\\",\"NAME\":\"wordBreakChars\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DIGIT_RE\":\"\\\\d+(?:\\\\.\\\\d+)?|\\\\d+(?:\\\\.\\\\d+)?e\\\\d+\",\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"\\\\\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SEQ\",\"text\":\">=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"=>\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"=<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\":\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"+\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"-\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"*\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"/\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"maximize\"},{\"tag\":\"KEYWORD1\",\"text\":\"maximum\"},{\"tag\":\"KEYWORD1\",\"text\":\"minimize\"},{\"tag\":\"KEYWORD1\",\"text\":\"minimum\"},{\"tag\":\"KEYWORD1\",\"text\":\"min\"},{\"tag\":\"KEYWORD1\",\"text\":\"max\"},{\"tag\":\"KEYWORD1\",\"text\":\"s.t.\"},{\"tag\":\"KEYWORD1\",\"text\":\"st.\"},{\"tag\":\"KEYWORD1\",\"text\":\"st\"},{\"tag\":\"KEYWORD1\",\"text\":\"end\"},{\"tag\":\"KEYWORD1\",\"text\":\"bounds\"},{\"tag\":\"KEYWORD1\",\"text\":\"bound\"},{\"tag\":\"KEYWORD1\",\"text\":\"generals\"},{\"tag\":\"KEYWORD1\",\"text\":\"general\"},{\"tag\":\"KEYWORD1\",\"text\":\"gen\"},{\"tag\":\"KEYWORD1\",\"text\":\"integers\"},{\"tag\":\"KEYWORD1\",\"text\":\"integer\"},{\"tag\":\"KEYWORD1\",\"text\":\"int\"},{\"tag\":\"KEYWORD1\",\"text\":\"binaries\"},{\"tag\":\"KEYWORD1\",\"text\":\"binary\"},{\"tag\":\"KEYWORD1\",\"text\":\"bin\"},{\"tag\":\"SEQ\",\"text\":\"infinity\",\"attrs\":{\"TYPE\":\"KEYWORD3\",\"AT_LINE_START\":\"FALSE\"}},{\"tag\":\"SEQ\",\"text\":\"inf\",\"attrs\":{\"TYPE\":\"KEYWORD3\",\"AT_LINE_START\":\"FALSE\"}},{\"tag\":\"SEQ\",\"text\":\"free\",\"attrs\":{\"TYPE\":\"KEYWORD3\",\"AT_LINE_START\":\"FALSE\"}}]},{\"tag\":\"SEQ\",\"text\":\"subject to\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"such that\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"[A-z_ ][\\\\w(),]+(?=:)\",\"attrs\":{\"HASH_CHARS\":\"ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz_\",\"TYPE\":\"LABEL\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"[A-z_][\\\\w!\\\"#$%&()/,.;?@_`'{}|~]*\",\"attrs\":{\"HASH_CHARS\":\"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_\",\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"KEYWORD2\",\"AT_LINE_START\":\"FALSE\"}}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
