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
public class JflexLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*/\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"//\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\",+-=<>/?^&*\",\"NAME\":\"wordBreakChars\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"{\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"}\",\"NAME\":\"indentCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"(\",\"NAME\":\"unalignedOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\")\",\"NAME\":\"unalignedCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"\\\\s*(((if|while)\\\\s*\\\\(|else\\\\s*|else\\\\s+if\\\\s*\\\\(|for\\\\s*\\\\(.*\\\\))[^{;]*)\",\"NAME\":\"indentNextLine\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"^.*(default:\\\\s*|case.*:.*)$\",\"NAME\":\"unindentThisLine\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\":\",\"NAME\":\"electricKeys\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"java::MAIN\"}},{\"tag\":\"SEQ\",\"text\":\"%%\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"%class\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%class\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%implements\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%extends\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%public\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%abstract\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%final\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%apiprivate\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%unicode\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%line\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%char\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%cup\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%column\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%standalone\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"ignorecase\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%type\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%debug\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%%\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"<\\\\w+>\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"HASH_CHAR\":\"<\"}}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
