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
public class YamlLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\".+:$\",\"NAME\":\"indentNextLines\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"[{|>\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"}]\",\"NAME\":\"indentCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"false\",\"NAME\":\"ignoreWhitespace\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"noTabs\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"2\",\"NAME\":\"indentSize\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"2\",\"NAME\":\"tabSize\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"SEQ\",\"text\":\"...\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ\",\"text\":\"---\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"-( |$)\",\"attrs\":{\"AT_WHITESPACE_END\":\"TRUE\",\"DELEGATE\":\"VALUES\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"NAME\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"NAME\"},\"child\":[{\"tag\":\"SEQ_REGEXP\",\"text\":\"[^:\\\\[\\\\]{},'\\\"#]+:( |$)\",\"attrs\":{\"TYPE\":\"KEYWORD1\",\"DELEGATE\":\"VALUES\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"php::PHP\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<?php\"},{\"tag\":\"END\",\"text\":\"?>\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"ARRAYS\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"FALSE\",\"TYPE\":\"OPERATOR\",\"DELEGATE\":\"ARRAY\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"{\"},{\"tag\":\"END\",\"text\":\"}\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"FALSE\",\"TYPE\":\"OPERATOR\",\"DELEGATE\":\"ARRAY\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"[\"},{\"tag\":\"END\",\"text\":\"]\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"ARRAY\"},\"child\":[{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"VALUES\"}},{\"tag\":\"SEQ\",\"text\":\",\",\"attrs\":{\"TYPE\":\"OPERATOR\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"VALUES\",\"HIGHLIGHT_DIGITS\":\"TRUE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"COMMENT1\",\"AT_LINE_START\":\"FALSE\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"NAME\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"ARRAYS\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\t\",\"attrs\":{\"TYPE\":\"INVALID\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD3\",\"text\":\"~\"},{\"tag\":\"KEYWORD3\",\"text\":\"false\"},{\"tag\":\"KEYWORD3\",\"text\":\"n\"},{\"tag\":\"KEYWORD3\",\"text\":\"No\"},{\"tag\":\"KEYWORD3\",\"text\":\"off\"},{\"tag\":\"KEYWORD3\",\"text\":\"Y\"},{\"tag\":\"KEYWORD3\",\"text\":\"true\"},{\"tag\":\"KEYWORD3\",\"text\":\"Yes\"},{\"tag\":\"KEYWORD3\",\"text\":\"ON\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
