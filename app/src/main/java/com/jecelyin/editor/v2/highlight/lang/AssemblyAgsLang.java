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
public class AssemblyAgsLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"contextInsensitive\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"##\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"MARK_PREVIOUS\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LABEL\",\"AT_LINE_START\":\"TRUE\",\"MATCH_TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"+\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"-\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"FUNCTION\",\"text\":\"ORG\"},{\"tag\":\"FUNCTION\",\"text\":\"BSS\"},{\"tag\":\"FUNCTION\",\"text\":\"BES\"},{\"tag\":\"FUNCTION\",\"text\":\"SYN\"},{\"tag\":\"FUNCTION\",\"text\":\"EQU\"},{\"tag\":\"FUNCTION\",\"text\":\"DEFINE\"},{\"tag\":\"FUNCTION\",\"text\":\"DEC\"},{\"tag\":\"FUNCTION\",\"text\":\"OCT\"},{\"tag\":\"FUNCTION\",\"text\":\"END\"},{\"tag\":\"KEYWORD3\",\"text\":\"A\"},{\"tag\":\"KEYWORD3\",\"text\":\"Q\"},{\"tag\":\"KEYWORD3\",\"text\":\"INDEX\"},{\"tag\":\"KEYWORD1\",\"text\":\"ABS\"},{\"tag\":\"KEYWORD1\",\"text\":\"ADD\"},{\"tag\":\"KEYWORD1\",\"text\":\"ADZ\"},{\"tag\":\"KEYWORD1\",\"text\":\"ALS\"},{\"tag\":\"KEYWORD1\",\"text\":\"AXT\"},{\"tag\":\"KEYWORD1\",\"text\":\"CLA\"},{\"tag\":\"KEYWORD1\",\"text\":\"CLZ\"},{\"tag\":\"KEYWORD1\",\"text\":\"COM\"},{\"tag\":\"KEYWORD1\",\"text\":\"DLY\"},{\"tag\":\"KEYWORD1\",\"text\":\"DVP\"},{\"tag\":\"KEYWORD1\",\"text\":\"INP\"},{\"tag\":\"KEYWORD1\",\"text\":\"LDQ\"},{\"tag\":\"KEYWORD1\",\"text\":\"LLS\"},{\"tag\":\"KEYWORD1\",\"text\":\"LRS\"},{\"tag\":\"KEYWORD1\",\"text\":\"MPR\"},{\"tag\":\"KEYWORD1\",\"text\":\"MPY\"},{\"tag\":\"KEYWORD1\",\"text\":\"MPZ\"},{\"tag\":\"KEYWORD1\",\"text\":\"OUT\"},{\"tag\":\"KEYWORD1\",\"text\":\"STO\"},{\"tag\":\"KEYWORD1\",\"text\":\"STQ\"},{\"tag\":\"KEYWORD1\",\"text\":\"SUB\"},{\"tag\":\"KEYWORD1\",\"text\":\"SUZ\"},{\"tag\":\"KEYWORD1\",\"text\":\"TIX\"},{\"tag\":\"KEYWORD1\",\"text\":\"TMI\"},{\"tag\":\"KEYWORD1\",\"text\":\"TOV\"},{\"tag\":\"KEYWORD1\",\"text\":\"TRA\"},{\"tag\":\"KEYWORD1\",\"text\":\"TSQ\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
