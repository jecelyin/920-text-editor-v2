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
public class MoinLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"##\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"soft\",\"NAME\":\"wrap\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"FALSE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"##\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"#pragma\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD4\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"[[\"},{\"tag\":\"END\",\"text\":\"]]\"}]},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\s+(?:\\\\(|\\\\)|\\\\w)[\\\\p{Alnum}\\\\p{Blank}.()]+::\",\"attrs\":{\"TYPE\":\"LABEL\",\"AT_LINE_START\":\"TRUE\",\"HASH_CHAR\":\" \"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"{{{\"},{\"tag\":\"END\",\"text\":\"}}}\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL2\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"`\"},{\"tag\":\"END\",\"text\":\"`\"}]},{\"tag\":\"SEQ_REGEXP\",\"text\":\"('{2,5})[^']+\\\\1[^']\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"HASH_CHAR\":\"''\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"-{4,}\",\"attrs\":{\"TYPE\":\"LITERAL4\",\"HASH_CHAR\":\"----\"}},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD1\",\"AT_LINE_START\":\"TRUE\",\"HASH_CHAR\":\"=\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"(={1,5})\"},{\"tag\":\"END\",\"text\":\"$1\"}]},{\"tag\":\"SEQ_REGEXP\",\"text\":\"[A-Z][a-z]+[A-Z][a-zA-Z]+\",\"attrs\":{\"HASH_CHARS\":\"ABCDEFGHIJKLMNOPQRSTUVWXYZ\",\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"[\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"]\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD3\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"[\"},{\"tag\":\"END\",\"text\":\"]\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
