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
public class MailLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\">\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"-_\",\"NAME\":\"noWordSep\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"FALSE\",\"IGNORE_CASE\":\"TRUE\",\"NO_WORD_SEP\":\"-_:)\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\">>>\",\"attrs\":{\"TYPE\":\"COMMENT3\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN\",\"text\":\">>\",\"attrs\":{\"TYPE\":\"COMMENT2\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN\",\"text\":\">\",\"attrs\":{\"TYPE\":\"COMMENT1\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"|\",\"attrs\":{\"TYPE\":\"COMMENT1\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN\",\"text\":\":\",\"attrs\":{\"TYPE\":\"COMMENT1\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"SEQ\",\"text\":\"--\",\"attrs\":{\"TYPE\":\"COMMENT2\",\"AT_LINE_START\":\"TRUE\",\"DELEGATE\":\"SIGNATURE\"}},{\"tag\":\"SEQ\",\"text\":\":-)\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\":-(\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\":)\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\":(\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\";-)\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\";-(\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\";)\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\";(\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"MARK_PREVIOUS\",\"text\":\":\",\"attrs\":{\"TYPE\":\"LABEL\",\"AT_LINE_START\":\"TRUE\"}}]},{\"tag\":\"RULES\",\"attrs\":{\"SET\":\"SIGNATURE\",\"DEFAULT\":\"COMMENT2\"}}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
