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
public class RestLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\".. \",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\".*::$\",\"NAME\":\"indentNextLines\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"FALSE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"__\",\"attrs\":{\"TYPE\":\"KEYWORD3\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN\",\"text\":\".. _\",\"attrs\":{\"TYPE\":\"KEYWORD3\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"={3,}\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"===\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"-{3,}\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"---\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"~{3,}\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"~~~\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"#{3,}\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"###\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\"{3,}\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"\\\"\\\"\\\"\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\^{3,}\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"^^^\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\+{3,}\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"+++\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\*{3,}\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"***\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\.\\\\.\\\\s\\\\|[^|]+\\\\|\",\"attrs\":{\"TYPE\":\"LITERAL3\",\"AT_LINE_START\":\"TRUE\",\"HASH_CHAR\":\"..\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\|[^|]+\\\\|\",\"attrs\":{\"TYPE\":\"LITERAL4\",\"AT_LINE_START\":\"FALSE\",\"HASH_CHAR\":\"|\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\.\\\\.\\\\s[A-z][A-z0-9-_]+::\",\"attrs\":{\"TYPE\":\"LITERAL2\",\"AT_LINE_START\":\"TRUE\",\"HASH_CHAR\":\"..\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\*\\\\*[^*]+\\\\*\\\\*\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"AT_LINE_START\":\"FALSE\",\"HASH_CHAR\":\"**\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\*[^\\\\s*][^*]*\\\\*\",\"attrs\":{\"TYPE\":\"KEYWORD4\",\"AT_LINE_START\":\"FALSE\",\"HASH_CHAR\":\"*\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"..\",\"attrs\":{\"TYPE\":\"COMMENT1\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"`[A-z0-9]+[^`]+`_{1,2}\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"`\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\[[0-9]+\\\\]_\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"[\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\[#[A-z0-9_]*\\\\]_\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"[#\"}},{\"tag\":\"SEQ\",\"text\":\"[*]_\",\"attrs\":{\"TYPE\":\"LABEL\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\[[A-z][A-z0-9_-]*\\\\]_\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"[\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"``\"},{\"tag\":\"END\",\"text\":\"``\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"`\"},{\"tag\":\"END\",\"text\":\"`\"}]},{\"tag\":\"SEQ_REGEXP\",\"text\":\"`{3,}\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"```\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\":[A-z][A-z0-9 \\t=\\\\s\\\\t_]*:\",\"attrs\":{\"TYPE\":\"KEYWORD1\",\"HASH_CHAR\":\":\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\+-[+-]+\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"+-\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\+=[+=]+\",\"attrs\":{\"TYPE\":\"LABEL\",\"HASH_CHAR\":\"+?\"}}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
