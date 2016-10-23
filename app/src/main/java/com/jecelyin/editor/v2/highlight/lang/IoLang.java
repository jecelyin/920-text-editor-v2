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
public class IoLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*/\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"//\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"(\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\")\",\"NAME\":\"indentCloseBrackets\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"//\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"/*\"},{\"tag\":\"END\",\"text\":\"*/\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL2\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL2\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\\\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\\\"\\\"\"}]},{\"tag\":\"SEQ\",\"text\":\"`\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"~\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"@\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"@@\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"$\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"%\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"^\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"&\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"*\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"-\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"+\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"/\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"{\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"}\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"[\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"]\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"|\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"?\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"Block\"},{\"tag\":\"KEYWORD1\",\"text\":\"Buffer\"},{\"tag\":\"KEYWORD1\",\"text\":\"CFunction\"},{\"tag\":\"KEYWORD1\",\"text\":\"Date\"},{\"tag\":\"KEYWORD1\",\"text\":\"Duration\"},{\"tag\":\"KEYWORD1\",\"text\":\"File\"},{\"tag\":\"KEYWORD1\",\"text\":\"Future\"},{\"tag\":\"KEYWORD1\",\"text\":\"List\"},{\"tag\":\"KEYWORD1\",\"text\":\"LinkedList\"},{\"tag\":\"KEYWORD1\",\"text\":\"Map\"},{\"tag\":\"KEYWORD1\",\"text\":\"Nop\"},{\"tag\":\"KEYWORD1\",\"text\":\"Message\"},{\"tag\":\"KEYWORD1\",\"text\":\"Nil\"},{\"tag\":\"KEYWORD1\",\"text\":\"Number\"},{\"tag\":\"KEYWORD1\",\"text\":\"Object\"},{\"tag\":\"KEYWORD1\",\"text\":\"String\"},{\"tag\":\"KEYWORD1\",\"text\":\"WeakLink\"},{\"tag\":\"KEYWORD1\",\"text\":\"block\"},{\"tag\":\"KEYWORD1\",\"text\":\"method\"},{\"tag\":\"KEYWORD2\",\"text\":\"while\"},{\"tag\":\"KEYWORD2\",\"text\":\"foreach\"},{\"tag\":\"KEYWORD2\",\"text\":\"if\"},{\"tag\":\"KEYWORD2\",\"text\":\"else\"},{\"tag\":\"KEYWORD2\",\"text\":\"do\"},{\"tag\":\"KEYWORD3\",\"text\":\"super\"},{\"tag\":\"KEYWORD3\",\"text\":\"self\"},{\"tag\":\"KEYWORD3\",\"text\":\"clone\"},{\"tag\":\"KEYWORD3\",\"text\":\"proto\"},{\"tag\":\"KEYWORD3\",\"text\":\"setSlot\"},{\"tag\":\"KEYWORD3\",\"text\":\"hasSlot\"},{\"tag\":\"KEYWORD3\",\"text\":\"type\"},{\"tag\":\"KEYWORD3\",\"text\":\"write\"},{\"tag\":\"KEYWORD3\",\"text\":\"print\"},{\"tag\":\"KEYWORD3\",\"text\":\"forward\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
