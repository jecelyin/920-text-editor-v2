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
public class FactorLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"[{\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"]}\",\"NAME\":\"indentCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"^(:|M:|C:|PREDICATE:)[^;]*\",\"NAME\":\"indentNextLines\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"^.*;.*$\",\"NAME\":\"unindentNextLines\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"doubleBracketIndent\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"(\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\")\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"!\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"+-*=><;.?/'()%,_|\",\"NAME\":\"noWordSep\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DIGIT_RE\":\"-?\\\\d+([./]\\\\d+)?\",\"IGNORE_CASE\":\"FALSE\",\"NO_WORD_SEP\":\"+-*=><;.?/'()%,_\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"#!\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"COMMENT2\",\"DELEGATE\":\"COMMENT\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"!\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"COMMENT1\",\"DELEGATE\":\"COMMENT\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\\\\\\\\\s+(\\\\S+)\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"MARKUP\",\"HASH_CHAR\":\"\\\\\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\":\\\\s+(\\\\S+)\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"MARKUP\",\"HASH_CHAR\":\":\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"IN:\\\\s+(\\\\S+)\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"MARKUP\",\"HASH_CHAR\":\"IN:\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"USE:\\\\s+(\\\\S+)\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"MARKUP\",\"HASH_CHAR\":\"USE:\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"CHAR:\\\\s+(\\\\S+)\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"LITERAL2\",\"HASH_CHAR\":\"CHAR:\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"BIN:\\\\s+(\\\\S+)\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"LITERAL2\",\"HASH_CHAR\":\"BIN:\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"OCT:\\\\s+(\\\\S+)\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"LITERAL2\",\"HASH_CHAR\":\"OCT:\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"HEX:\\\\s+(\\\\S+)\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"LITERAL2\",\"HASH_CHAR\":\"HEX:\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"COMMENT3\",\"DELEGATE\":\"STACK_EFFECT\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\\s+(\"},{\"tag\":\"END\",\"text\":\")\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"DELEGATE\":\"LITERAL\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"SBUF\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"DELEGATE\":\"LITERAL\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"USING\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"USING:\"},{\"tag\":\"END\",\"text\":\";\"}]},{\"tag\":\"SEQ\",\"text\":\"[\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"]\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"{\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"}\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\">r\"},{\"tag\":\"KEYWORD1\",\"text\":\"r>\"},{\"tag\":\"MARKUP\",\"text\":\";\"},{\"tag\":\"LITERAL3\",\"text\":\"t\"},{\"tag\":\"LITERAL4\",\"text\":\"f\"},{\"tag\":\"COMMENT2\",\"text\":\"#!\"},{\"tag\":\"COMMENT1\",\"text\":\"!\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"STACK_EFFECT\",\"DEFAULT\":\"COMMENT4\"},\"child\":[{\"tag\":\"SEQ\",\"text\":\"--\",\"attrs\":{\"TYPE\":\"COMMENT3\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"LITERAL\",\"DEFAULT\":\"LITERAL1\"}},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"COMMENT\",\"DEFAULT\":\"COMMENT1\"}},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"USING\",\"DEFAULT\":\"LITERAL2\"}}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
