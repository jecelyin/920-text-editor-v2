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
public class LexLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*/\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"//\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\",+-=<>/?^&*\",\"NAME\":\"wordBreakChars\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"{\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"}\",\"NAME\":\"indentCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"(\",\"NAME\":\"unalignedOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\")\",\"NAME\":\"unalignedCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"\\\\s*(((if|while)\\\\s*\\\\(|else\\\\s*|else\\\\s+if\\\\s*\\\\(|for\\\\s*\\\\(.*\\\\))[^{;]*)\",\"NAME\":\"indentNextLine\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"^.*(default:\\\\s*|case.*:.*)$\",\"NAME\":\"unindentThisLine\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\":\",\"NAME\":\"electricKeys\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"c::MAIN\"}},{\"tag\":\"SEQ\",\"text\":\"%%\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"%{\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"}%\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"%option\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%top\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"%x\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"ECHO\",\"attrs\":{\"TYPE\":\"KEYWORD4\"}},{\"tag\":\"SEQ\",\"text\":\"BEGIN\",\"attrs\":{\"TYPE\":\"KEYWORD4\"}},{\"tag\":\"SEQ\",\"text\":\"REJECT\",\"attrs\":{\"TYPE\":\"KEYWORD4\"}},{\"tag\":\"SEQ\",\"text\":\"YY_CURRENT_BUFFER\",\"attrs\":{\"TYPE\":\"LITERAL2\"}},{\"tag\":\"SEQ\",\"text\":\"YY_START\",\"attrs\":{\"TYPE\":\"LITERAL2\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"<\\\\w+>\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"HASH_CHAR\":\"<\"}}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
