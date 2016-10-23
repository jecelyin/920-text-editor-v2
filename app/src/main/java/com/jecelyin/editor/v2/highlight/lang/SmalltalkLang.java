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
public class SmalltalkLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"\\\"\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"\\\"\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"[\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"]\",\"NAME\":\"indentCloseBrackets\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"FALSE\",\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SEQ\",\"text\":\":=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"_\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"==\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"+\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"-\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"/\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"*\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"MARK_PREVIOUS\",\"text\":\":\",\"attrs\":{\"TYPE\":\"KEYWORD3\",\"MATCH_TYPE\":\"OPERATOR\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"LABEL\",\"MATCH_TYPE\":\"OPERATOR\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"$\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"MATCH_TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"true\"},{\"tag\":\"KEYWORD1\",\"text\":\"false\"},{\"tag\":\"KEYWORD1\",\"text\":\"nil\"},{\"tag\":\"KEYWORD2\",\"text\":\"self\"},{\"tag\":\"KEYWORD2\",\"text\":\"super\"},{\"tag\":\"KEYWORD3\",\"text\":\"isNil\"},{\"tag\":\"KEYWORD3\",\"text\":\"not\"},{\"tag\":\"LITERAL2\",\"text\":\"Smalltalk\"},{\"tag\":\"LITERAL2\",\"text\":\"Transcript\"},{\"tag\":\"LITERAL2\",\"text\":\"Date\"},{\"tag\":\"LITERAL2\",\"text\":\"Time\"},{\"tag\":\"LITERAL2\",\"text\":\"Boolean\"},{\"tag\":\"LITERAL2\",\"text\":\"True\"},{\"tag\":\"LITERAL2\",\"text\":\"False\"},{\"tag\":\"LITERAL2\",\"text\":\"Character\"},{\"tag\":\"LITERAL2\",\"text\":\"String\"},{\"tag\":\"LITERAL2\",\"text\":\"Array\"},{\"tag\":\"LITERAL2\",\"text\":\"Symbol\"},{\"tag\":\"LITERAL2\",\"text\":\"Integer\"},{\"tag\":\"LITERAL2\",\"text\":\"Object\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
