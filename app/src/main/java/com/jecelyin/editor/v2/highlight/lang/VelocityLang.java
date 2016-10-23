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
public class VelocityLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*#\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"##\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"^\\\\s*(#(foreach|if|elseif|else))\\\\s*\\\\(.*\\\\)\\\\s*\",\"NAME\":\"indentNextLines\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"^\\\\s*#(end|elseif|else)\\\\b.*\",\"NAME\":\"unindentThisLine\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<!--\"},{\"tag\":\"END\",\"text\":\"-->\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"JAVASCRIPT\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<SCRIPT\"},{\"tag\":\"END\",\"text\":\"<\\/SCRIPT>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"CSS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<STYLE\"},{\"tag\":\"END\",\"text\":\"<\\/STYLE>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"DELEGATE\":\"xml::DTD-TAGS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<!\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"html::TAGS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_WORD_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"&\"},{\"tag\":\"END\",\"text\":\";\"}]},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"VELOCITY\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"VELOCITY\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"#*\"},{\"tag\":\"END\",\"text\":\"*#\"}]},{\"tag\":\"EOL_SPAN\",\"text\":\"##\",\"attrs\":{\"TYPE\":\"COMMENT3\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD3\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"${\"},{\"tag\":\"END\",\"text\":\"}\"}]},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\$!?[A-z][A-z0-9._-]*\",\"attrs\":{\"TYPE\":\"KEYWORD3\",\"HASH_CHAR\":\"$\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"#set\"},{\"tag\":\"KEYWORD1\",\"text\":\"#foreach\"},{\"tag\":\"KEYWORD1\",\"text\":\"#end\"},{\"tag\":\"KEYWORD1\",\"text\":\"#if\"},{\"tag\":\"KEYWORD1\",\"text\":\"#else\"},{\"tag\":\"KEYWORD1\",\"text\":\"#elseif\"},{\"tag\":\"KEYWORD1\",\"text\":\"#parse\"},{\"tag\":\"KEYWORD1\",\"text\":\"#macro\"},{\"tag\":\"KEYWORD1\",\"text\":\"#stop\"},{\"tag\":\"KEYWORD1\",\"text\":\"#include\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"JAVASCRIPT\",\"DEFAULT\":\"MARKUP\",\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"JAVASCRIPT2\"}},{\"tag\":\"SEQ\",\"text\":\"SRC=\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"BACK_TO_HTML\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"JAVASCRIPT2\",\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DIGIT_RE\":\"(0x[\\\\p{XDigit}]+[lL]?|[\\\\p{Digit}]+(e[\\\\p{Digit}]*)?[lLdDfF]?)\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"VELOCITY\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"javascript::MAIN\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"BACK_TO_HTML\",\"DEFAULT\":\"MARKUP\"},\"child\":[{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"MAIN\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"CSS\",\"DEFAULT\":\"MARKUP\"},\"child\":[{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"CSS2\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"CSS2\",\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DIGIT_RE\":\"[\\\\p{Digit}]+(pt|pc|in|mm|cm|em|ex|px|ms|s|%)\",\"IGNORE_CASE\":\"TRUE\",\"NO_WORD_SEP\":\"-_\"},\"child\":[{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"VELOCITY\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"css::MAIN\"}}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
