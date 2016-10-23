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
public class VelocityPureLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*#\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"##\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"^\\\\s*(#(foreach|if|elseif|else|beanshell|macro))\\\\s*\\\\(.*\\\\)\\\\s*\",\"NAME\":\"indentNextLines\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"^\\\\s*#(end|elseif|else)\\\\b.*\",\"NAME\":\"unindentThisLine\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT3\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"#**\"},{\"tag\":\"END\",\"text\":\"*#\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"#*\"},{\"tag\":\"END\",\"text\":\"*#\"}]},{\"tag\":\"EOL_SPAN\",\"text\":\"##\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"FUNCTION\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"${\"},{\"tag\":\"END\",\"text\":\"}\"}]},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\$!?[A-z][A-z0-9._-]*\",\"attrs\":{\"TYPE\":\"FUNCTION\",\"HASH_CHAR\":\"$\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"FALSE\",\"TYPE\":\"KEYWORD4\",\"DELEGATE\":\"java::MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"#beanshell\"},{\"tag\":\"END\",\"text\":\"#end\"}]},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD4\",\"text\":\"#macro\"},{\"tag\":\"KEYWORD4\",\"text\":\"#beanshell\"},{\"tag\":\"KEYWORD1\",\"text\":\"#set\"},{\"tag\":\"KEYWORD1\",\"text\":\"#parse\"},{\"tag\":\"KEYWORD1\",\"text\":\"#include\"},{\"tag\":\"KEYWORD1\",\"text\":\"#stop\"},{\"tag\":\"KEYWORD3\",\"text\":\"#if\"},{\"tag\":\"KEYWORD3\",\"text\":\"#else\"},{\"tag\":\"KEYWORD3\",\"text\":\"#elseif\"},{\"tag\":\"KEYWORD3\",\"text\":\"#foreach\"},{\"tag\":\"KEYWORD3\",\"text\":\"in\"},{\"tag\":\"KEYWORD3\",\"text\":\"#end\"},{\"tag\":\"LITERAL2\",\"text\":\"#prompt\"},{\"tag\":\"LITERAL2\",\"text\":\"#yes_no\"},{\"tag\":\"LITERAL2\",\"text\":\"#today\"},{\"tag\":\"LITERAL2\",\"text\":\"#caret\"},{\"tag\":\"LITERAL2\",\"text\":\"#buffermode\"},{\"tag\":\"KEYWORD2\",\"text\":\"_jeditIndentation\"},{\"tag\":\"KEYWORD2\",\"text\":\"_jeditSelection\"},{\"tag\":\"KEYWORD2\",\"text\":\"_jeditTab\"},{\"tag\":\"KEYWORD2\",\"text\":\"buffer\"},{\"tag\":\"KEYWORD2\",\"text\":\"textarea\"},{\"tag\":\"KEYWORD2\",\"text\":\"view\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
