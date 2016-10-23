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
public class OutlineLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*/\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"//\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"contextInsensitive\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"^\\\\s{12}\",\"attrs\":{\"TYPE\":\"COMMENT4\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"^\\\\s{11}\",\"attrs\":{\"TYPE\":\"COMMENT3\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"^\\\\s{10}\",\"attrs\":{\"TYPE\":\"COMMENT2\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"^\\\\s{9}\",\"attrs\":{\"TYPE\":\"COMMENT1\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"^\\\\s{8}\",\"attrs\":{\"TYPE\":\"LITERAL4\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"^\\\\s{7}\",\"attrs\":{\"TYPE\":\"LITERAL3\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"^\\\\s{6}\",\"attrs\":{\"TYPE\":\"LITERAL2\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"^\\\\s{5}\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"^\\\\s{4}\",\"attrs\":{\"TYPE\":\"KEYWORD4\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"^\\\\s{3}\",\"attrs\":{\"TYPE\":\"KEYWORD3\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"^\\\\s{2}\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"^\\\\s{1}\",\"attrs\":{\"TYPE\":\"KEYWORD1\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"^\\\\s{0}\",\"attrs\":{\"TYPE\":\"LABEL\",\"AT_LINE_START\":\"TRUE\"}}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
