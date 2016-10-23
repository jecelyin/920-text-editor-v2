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
public class RoffLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"noTabs\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"\\\\\\\\#\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\",+-=<>/?^&*\",\"NAME\":\"wordBreakChars\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"\\\\#\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"\\\\\\\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"\\\\.\\\\s*\\\\w+\",\"attrs\":{\"TYPE\":\"KEYWORD1\",\"AT_LINE_START\":\"TRUE\",\"DELEGATE\":\"ROFF_ESCAPE\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\\\\\((\\\\p{Graph}\\\\[[^\\\\]]*\\\\])|(\\\\p{Graph}((\\\\'.*\\\\')|(\\\\\\\".*\\\\\\\")))|(\\\\p{Graph}{1,2}))\",\"attrs\":{\"TYPE\":\"KEYWORD3\",\"HASH_CHAR\":\"\\\\\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"ROFF_ESCAPE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"\\\\\\\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"HASH_CHARS\":\"0123456789\",\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"DIGIT\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"(\\\\d|\\\\.)+[icpPszfmnvM]?\"},{\"tag\":\"END\",\"text\":\"\"}]},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"HASH_CHARS\":\"0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstwxyz\",\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\\w+\"},{\"tag\":\"END\",\"text\":\"\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
