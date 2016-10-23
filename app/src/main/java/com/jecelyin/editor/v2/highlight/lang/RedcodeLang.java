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
public class RedcodeLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\";\",\"NAME\":\"lineComment\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DEFAULT\":\"MARKUP\",\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\";redcode\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"EOL_SPAN\",\"text\":\";author\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"EOL_SPAN\",\"text\":\";name\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"EOL_SPAN\",\"text\":\";strategy\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"EOL_SPAN\",\"text\":\";password\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"EOL_SPAN\",\"text\":\";\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SEQ\",\"text\":\".AB\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ\",\"text\":\".BA\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ\",\"text\":\".A\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ\",\"text\":\".B\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ\",\"text\":\".F\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ\",\"text\":\".X\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ\",\"text\":\".I\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ\",\"text\":\",\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\":\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"(\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\")\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"+\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"-\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"/\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"%\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"==\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"!=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"&&\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"||\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"!\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"$\",\"attrs\":{\"TYPE\":\"LITERAL1\"}},{\"tag\":\"SEQ\",\"text\":\"@\",\"attrs\":{\"TYPE\":\"LITERAL1\"}},{\"tag\":\"SEQ\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"LITERAL1\"}},{\"tag\":\"SEQ\",\"text\":\"*\",\"attrs\":{\"TYPE\":\"LITERAL1\"}},{\"tag\":\"SEQ\",\"text\":\"{\",\"attrs\":{\"TYPE\":\"LITERAL1\"}},{\"tag\":\"SEQ\",\"text\":\"}\",\"attrs\":{\"TYPE\":\"LITERAL1\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"LITERAL2\",\"text\":\"CORESIZE\"},{\"tag\":\"LITERAL2\",\"text\":\"MAXPROCESSES\"},{\"tag\":\"LITERAL2\",\"text\":\"MAXCYCLES\"},{\"tag\":\"LITERAL2\",\"text\":\"MAXLENGTH\"},{\"tag\":\"LITERAL2\",\"text\":\"MINDISTANCE\"},{\"tag\":\"LITERAL2\",\"text\":\"ROUNDS\"},{\"tag\":\"LITERAL2\",\"text\":\"PSPACESIZE\"},{\"tag\":\"LITERAL2\",\"text\":\"CURLINE\"},{\"tag\":\"LITERAL2\",\"text\":\"VERSION\"},{\"tag\":\"LITERAL2\",\"text\":\"WARRIORS\"},{\"tag\":\"KEYWORD1\",\"text\":\"DAT\"},{\"tag\":\"KEYWORD1\",\"text\":\"MOV\"},{\"tag\":\"KEYWORD1\",\"text\":\"ADD\"},{\"tag\":\"KEYWORD1\",\"text\":\"SUB\"},{\"tag\":\"KEYWORD1\",\"text\":\"MUL\"},{\"tag\":\"KEYWORD1\",\"text\":\"DIV\"},{\"tag\":\"KEYWORD1\",\"text\":\"MOD\"},{\"tag\":\"KEYWORD1\",\"text\":\"JMP\"},{\"tag\":\"KEYWORD1\",\"text\":\"JMZ\"},{\"tag\":\"KEYWORD1\",\"text\":\"JMN\"},{\"tag\":\"KEYWORD1\",\"text\":\"DJN\"},{\"tag\":\"KEYWORD1\",\"text\":\"SPL\"},{\"tag\":\"KEYWORD1\",\"text\":\"SLT\"},{\"tag\":\"KEYWORD1\",\"text\":\"CMP\"},{\"tag\":\"KEYWORD1\",\"text\":\"SEQ\"},{\"tag\":\"KEYWORD1\",\"text\":\"SNE\"},{\"tag\":\"KEYWORD1\",\"text\":\"NOP\"},{\"tag\":\"KEYWORD1\",\"text\":\"LDP\"},{\"tag\":\"KEYWORD1\",\"text\":\"STP\"},{\"tag\":\"KEYWORD2\",\"text\":\"EQU\"},{\"tag\":\"KEYWORD2\",\"text\":\"ORG\"},{\"tag\":\"KEYWORD2\",\"text\":\"FOR\"},{\"tag\":\"KEYWORD2\",\"text\":\"ROF\"},{\"tag\":\"KEYWORD2\",\"text\":\"END\"},{\"tag\":\"KEYWORD2\",\"text\":\"PIN\"},{\"tag\":\"KEYWORD2\",\"text\":\"CORESIZE\"},{\"tag\":\"KEYWORD2\",\"text\":\"MAXPROCESSES\"},{\"tag\":\"KEYWORD2\",\"text\":\"MAXCYCLES\"},{\"tag\":\"KEYWORD2\",\"text\":\"MAXLENGTH\"},{\"tag\":\"KEYWORD2\",\"text\":\"MINDISTANCE\"},{\"tag\":\"KEYWORD2\",\"text\":\"ROUNDS\"},{\"tag\":\"KEYWORD2\",\"text\":\"PSPACESIZE\"},{\"tag\":\"KEYWORD2\",\"text\":\"CURLINE\"},{\"tag\":\"KEYWORD2\",\"text\":\"VERSION\"},{\"tag\":\"KEYWORD2\",\"text\":\"WARRIORS\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
