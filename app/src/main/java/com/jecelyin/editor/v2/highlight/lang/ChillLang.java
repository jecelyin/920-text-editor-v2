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
public class ChillLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*/\",\"NAME\":\"commentEnd\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<>\"},{\"tag\":\"END\",\"text\":\"<>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"/*\"},{\"tag\":\"END\",\"text\":\"*/\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"H'\"},{\"tag\":\"END\",\"text\":\";\"}]},{\"tag\":\"SEQ\",\"text\":\")\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"(\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"]\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"[\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"+\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"-\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"/\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"*\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\".\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\",\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\";\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"^\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"@\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\":=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\":\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"/=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"AND\"},{\"tag\":\"KEYWORD1\",\"text\":\"BEGIN\"},{\"tag\":\"KEYWORD1\",\"text\":\"CASE\"},{\"tag\":\"KEYWORD1\",\"text\":\"DIV\"},{\"tag\":\"KEYWORD1\",\"text\":\"DO\"},{\"tag\":\"KEYWORD1\",\"text\":\"ELSE\"},{\"tag\":\"KEYWORD1\",\"text\":\"ELSIF\"},{\"tag\":\"KEYWORD1\",\"text\":\"END\"},{\"tag\":\"KEYWORD1\",\"text\":\"ESAC\"},{\"tag\":\"KEYWORD1\",\"text\":\"EXIT\"},{\"tag\":\"KEYWORD1\",\"text\":\"FI\"},{\"tag\":\"KEYWORD1\",\"text\":\"FOR\"},{\"tag\":\"KEYWORD1\",\"text\":\"GOTO\"},{\"tag\":\"KEYWORD1\",\"text\":\"IF\"},{\"tag\":\"KEYWORD1\",\"text\":\"IN\"},{\"tag\":\"KEYWORD1\",\"text\":\"MOD\"},{\"tag\":\"KEYWORD1\",\"text\":\"NOT\"},{\"tag\":\"KEYWORD1\",\"text\":\"OD\"},{\"tag\":\"KEYWORD1\",\"text\":\"OF\"},{\"tag\":\"KEYWORD1\",\"text\":\"ON\"},{\"tag\":\"KEYWORD1\",\"text\":\"OR\"},{\"tag\":\"KEYWORD1\",\"text\":\"OUT\"},{\"tag\":\"KEYWORD1\",\"text\":\"RESULT\"},{\"tag\":\"KEYWORD1\",\"text\":\"RETURN\"},{\"tag\":\"KEYWORD1\",\"text\":\"THEN\"},{\"tag\":\"KEYWORD1\",\"text\":\"THEN\"},{\"tag\":\"KEYWORD1\",\"text\":\"TO\"},{\"tag\":\"KEYWORD1\",\"text\":\"UNTIL\"},{\"tag\":\"KEYWORD1\",\"text\":\"USES\"},{\"tag\":\"KEYWORD1\",\"text\":\"WHILE\"},{\"tag\":\"KEYWORD1\",\"text\":\"WITH\"},{\"tag\":\"KEYWORD1\",\"text\":\"XOR\"},{\"tag\":\"KEYWORD2\",\"text\":\"ARRAY\"},{\"tag\":\"KEYWORD2\",\"text\":\"DCL\"},{\"tag\":\"KEYWORD2\",\"text\":\"GRANT\"},{\"tag\":\"KEYWORD2\",\"text\":\"LABEL\"},{\"tag\":\"KEYWORD2\",\"text\":\"MODULE\"},{\"tag\":\"KEYWORD2\",\"text\":\"NEWMODE\"},{\"tag\":\"KEYWORD2\",\"text\":\"PROC\"},{\"tag\":\"KEYWORD2\",\"text\":\"POWERSET\"},{\"tag\":\"KEYWORD2\",\"text\":\"SEIZE\"},{\"tag\":\"KEYWORD2\",\"text\":\"SET\"},{\"tag\":\"KEYWORD2\",\"text\":\"STRUCT\"},{\"tag\":\"KEYWORD2\",\"text\":\"SYN\"},{\"tag\":\"KEYWORD2\",\"text\":\"SYNMODE\"},{\"tag\":\"KEYWORD2\",\"text\":\"TYPE\"},{\"tag\":\"KEYWORD2\",\"text\":\"PACK\"},{\"tag\":\"KEYWORD3\",\"text\":\"BIN\"},{\"tag\":\"KEYWORD3\",\"text\":\"CHAR\"},{\"tag\":\"KEYWORD3\",\"text\":\"INT\"},{\"tag\":\"KEYWORD3\",\"text\":\"RANGE\"},{\"tag\":\"KEYWORD3\",\"text\":\"BOOL\"},{\"tag\":\"KEYWORD3\",\"text\":\"PTR\"},{\"tag\":\"KEYWORD3\",\"text\":\"REF\"},{\"tag\":\"LABEL\",\"text\":\"MODULE_DESCRIPTION_HEADER\"},{\"tag\":\"LABEL\",\"text\":\"PATCH_INFOS\"},{\"tag\":\"LABEL\",\"text\":\"LIO_INFOS\"},{\"tag\":\"LABEL\",\"text\":\"SWSG_INFOS\"},{\"tag\":\"LABEL\",\"text\":\"MSG_XREF\"},{\"tag\":\"LABEL\",\"text\":\"EJECT\"},{\"tag\":\"LITERAL2\",\"text\":\"FALSE\"},{\"tag\":\"LITERAL2\",\"text\":\"NULL\"},{\"tag\":\"LITERAL2\",\"text\":\"TRUE\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
