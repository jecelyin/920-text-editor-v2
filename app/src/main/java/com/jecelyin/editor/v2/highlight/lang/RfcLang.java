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
public class RfcLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"contextInsensitive\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\[Page \\\\d+\\\\]\",\"attrs\":{\"TYPE\":\"KEYWORD3\",\"HASH_CHAR\":\"[\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\[RFC\\\\d+\\\\]\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"HASH_CHAR\":\"[\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"FALSE\",\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\d.*\",\"attrs\":{\"TYPE\":\"MARKUP\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"MUST\"},{\"tag\":\"KEYWORD1\",\"text\":\"MUST NOT\"},{\"tag\":\"KEYWORD1\",\"text\":\"REQUIRED\"},{\"tag\":\"KEYWORD1\",\"text\":\"SHALL\"},{\"tag\":\"KEYWORD1\",\"text\":\"SHALL NOT\"},{\"tag\":\"KEYWORD1\",\"text\":\"SHOULD\"},{\"tag\":\"KEYWORD1\",\"text\":\"SHOULD NOT\"},{\"tag\":\"KEYWORD1\",\"text\":\"RECOMMENDED\"},{\"tag\":\"KEYWORD1\",\"text\":\"MAY\"},{\"tag\":\"KEYWORD1\",\"text\":\"OPTIONAL\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
