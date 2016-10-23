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
public class RegexLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"FORCED_NUMBER\",\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SEQ\",\"text\":\",\",\"attrs\":{\"TYPE\":\"OPERATOR\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SEQ\",\"text\":\"\\\\\\\\\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\(\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\)\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\[\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\]\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\{\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\}\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\^\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\$\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\?\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\+\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\*\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\.\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\|\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\"^\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"$\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"?\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"*\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"+\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"|\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\b\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\d\",\"attrs\":{\"TYPE\":\"DIGIT\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\D\",\"attrs\":{\"TYPE\":\"LITERAL2\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\w\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ\",\"text\":\".\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\W\",\"attrs\":{\"TYPE\":\"LITERAL3\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\s\",\"attrs\":{\"TYPE\":\"KEYWORD4\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\S\",\"attrs\":{\"TYPE\":\"LITERAL4\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"FUNCTION\",\"DELEGATE\":\"MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"[^\"},{\"tag\":\"END\",\"text\":\"]\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"FUNCTION\",\"DELEGATE\":\"MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"(?=\"},{\"tag\":\"END\",\"text\":\")\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"FUNCTION\",\"DELEGATE\":\"MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"(?!\"},{\"tag\":\"END\",\"text\":\")\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"FUNCTION\",\"DELEGATE\":\"MAIN\"},\"child\":[{\"tag\":\"BEGIN\"},{\"tag\":\"END\",\"text\":\")\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"FUNCTION\",\"DELEGATE\":\"MAIN\"},\"child\":[{\"tag\":\"BEGIN\"},{\"tag\":\"END\",\"text\":\")\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"FUNCTION\",\"DELEGATE\":\"MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"(?:\"},{\"tag\":\"END\",\"text\":\")\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"OPERATOR\",\"DELEGATE\":\"FORCED_NUMBER\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"{\"},{\"tag\":\"END\",\"text\":\"}\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"OPERATOR\",\"DELEGATE\":\"MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"[\"},{\"tag\":\"END\",\"text\":\"]\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"FUNCTION\",\"DELEGATE\":\"MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"(\"},{\"tag\":\"END\",\"text\":\")\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
