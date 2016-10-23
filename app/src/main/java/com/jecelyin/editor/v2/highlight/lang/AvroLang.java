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
public class AvroLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*/\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"//\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\",=;*\",\"NAME\":\"wordBreakChars\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"{\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"}\",\"NAME\":\"indentCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"(\",\"NAME\":\"unalignedOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\")\",\"NAME\":\"unalignedCloseBrackets\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DIGIT_RE\":\"(0[lL]?|[1-9]\\\\d{0,9}(\\\\d{0,9}[lL])?|0[xX]\\\\p{XDigit}{1,8}(\\\\p{XDigit}{0,8}[lL])?|0[0-7]{1,11}([0-7]{0,11}[lL])?|([0-9]+\\\\.[0-9]*|\\\\.[0-9]+)([eE][+-]?[0-9]+)?[fFdD]?|[0-9]+([eE][+-]?[0-9]+[fFdD]?|([eE][+-]?[0-9]+)?[fFdD]))\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SEQ\",\"text\":\"/**/\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"/*\"},{\"tag\":\"END\",\"text\":\"*/\"}]},{\"tag\":\"EOL_SPAN\",\"text\":\"//\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"@\",\"attrs\":{\"TYPE\":\"KEYWORD4\"}},{\"tag\":\"MARK_PREVIOUS\",\"text\":\"(\",\"attrs\":{\"TYPE\":\"FUNCTION\",\"MATCH_TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\")\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\")\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"(\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"}\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"{\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"[\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"]\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"NULL\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"`\"},{\"tag\":\"END\",\"text\":\"`\"}]},{\"tag\":\"SEQ\",\"text\":\"import idl\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"import protocol\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"import schema\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD2\",\"text\":\"throws\"},{\"tag\":\"KEYWORD2\",\"text\":\"oneway\"},{\"tag\":\"KEYWORD3\",\"text\":\"array\"},{\"tag\":\"KEYWORD3\",\"text\":\"boolean\"},{\"tag\":\"KEYWORD3\",\"text\":\"bytes\"},{\"tag\":\"KEYWORD3\",\"text\":\"double\"},{\"tag\":\"KEYWORD3\",\"text\":\"enum\"},{\"tag\":\"KEYWORD3\",\"text\":\"error\"},{\"tag\":\"KEYWORD3\",\"text\":\"fixed\"},{\"tag\":\"KEYWORD3\",\"text\":\"float\"},{\"tag\":\"KEYWORD3\",\"text\":\"int\"},{\"tag\":\"KEYWORD3\",\"text\":\"long\"},{\"tag\":\"KEYWORD2\",\"text\":\"map\"},{\"tag\":\"KEYWORD3\",\"text\":\"protocol\"},{\"tag\":\"KEYWORD3\",\"text\":\"record\"},{\"tag\":\"KEYWORD3\",\"text\":\"string\"},{\"tag\":\"KEYWORD3\",\"text\":\"union\"},{\"tag\":\"KEYWORD3\",\"text\":\"void\"},{\"tag\":\"KEYWORD4\",\"text\":\"null\"},{\"tag\":\"KEYWORD4\",\"text\":\"true\"},{\"tag\":\"KEYWORD4\",\"text\":\"false\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
