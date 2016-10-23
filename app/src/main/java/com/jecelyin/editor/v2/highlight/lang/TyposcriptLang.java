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
public class TyposcriptLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*/\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"({\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\")}\",\"NAME\":\"indentCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"lineUpClosingBracket\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"FALSE\",\"DEFAULT\":\"MARKUP\",\"IGNORE_CASE\":\"FALSE\",\"NO_WORD_SEP\":\":\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD4\",\"AT_LINE_START\":\"TRUE\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<INCLUDE\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"EOL_SPAN\",\"text\":\"=\",\"attrs\":{\"AT_WHITESPACE_END\":\"FALSE\",\"TYPE\":\"OPERATOR\",\"AT_LINE_START\":\"FALSE\",\"DELEGATE\":\"typoscript::assignment\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"FALSE\",\"TYPE\":\"OPERATOR\",\"AT_LINE_START\":\"FALSE\",\"DELEGATE\":\"typoscript::assignment\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"(\"},{\"tag\":\"END\",\"text\":\")\",\"attrs\":{\"AT_WHITESPACE_END\":\"TRUE\"}}]},{\"tag\":\"EOL_SPAN\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"OPERATOR\",\"AT_LINE_START\":\"FALSE\",\"DELEGATE\":\"typoscript::copy\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"COMMENT4\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"FALSE\",\"TYPE\":\"COMMENT1\",\"AT_LINE_START\":\"TRUE\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"/*\"},{\"tag\":\"END\",\"text\":\"*/\"}]},{\"tag\":\"EOL_SPAN\",\"text\":\"/\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"COMMENT2\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"[\"},{\"tag\":\"END\",\"text\":\"]\"}]},{\"tag\":\"SEQ\",\"text\":\"{\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"}\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"(\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\")\",\"attrs\":{\"TYPE\":\"NULL\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"assignment\",\"HIGHLIGHT_DIGITS\":\"FALSE\",\"DEFAULT\":\"LITERAL1\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"AT_WORD_START\":\"FALSE\",\"TYPE\":\"LABEL\",\"AT_LINE_START\":\"FALSE\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"{$\"},{\"tag\":\"END\",\"text\":\"}\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"copy\",\"HIGHLIGHT_DIGITS\":\"FALSE\",\"DEFAULT\":\"KEYWORD2\",\"IGNORE_CASE\":\"FALSE\"}}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
