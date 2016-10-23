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
public class SqlLoaderLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*/\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"--\",\"NAME\":\"lineComment\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"/*\"},{\"tag\":\"END\",\"text\":\"*/\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"DELEGATE\":\"pl-sql::MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"EOL_SPAN\",\"text\":\"--\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SEQ\",\"text\":\"+\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"-\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"/\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"*\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"%\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"&\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"|\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"^\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"~\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"!=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"!>\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"!<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\":=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"LOAD\"},{\"tag\":\"KEYWORD1\",\"text\":\"DATA\"},{\"tag\":\"KEYWORD1\",\"text\":\"INFILE\"},{\"tag\":\"KEYWORD1\",\"text\":\"BADFILE\"},{\"tag\":\"KEYWORD1\",\"text\":\"DISCARDFILE\"},{\"tag\":\"KEYWORD1\",\"text\":\"INTO\"},{\"tag\":\"KEYWORD1\",\"text\":\"TABLE\"},{\"tag\":\"KEYWORD1\",\"text\":\"FIELDS\"},{\"tag\":\"KEYWORD1\",\"text\":\"TERMINATED\"},{\"tag\":\"KEYWORD1\",\"text\":\"BY\"},{\"tag\":\"KEYWORD1\",\"text\":\"OPTIONALLY\"},{\"tag\":\"KEYWORD1\",\"text\":\"ENCLOSED\"},{\"tag\":\"KEYWORD1\",\"text\":\"EXTERNAL\"},{\"tag\":\"KEYWORD1\",\"text\":\"TRAILING\"},{\"tag\":\"KEYWORD1\",\"text\":\"NULLCOLS\"},{\"tag\":\"KEYWORD1\",\"text\":\"NULLIF\"},{\"tag\":\"KEYWORD1\",\"text\":\"DATA\"},{\"tag\":\"KEYWORD1\",\"text\":\"BLANKS\"},{\"tag\":\"KEYWORD1\",\"text\":\"INSERT\"},{\"tag\":\"KEYWORD1\",\"text\":\"INTO\"},{\"tag\":\"KEYWORD1\",\"text\":\"POSITION\"},{\"tag\":\"KEYWORD1\",\"text\":\"WHEN\"},{\"tag\":\"KEYWORD1\",\"text\":\"APPEND\"},{\"tag\":\"KEYWORD1\",\"text\":\"REPLACE\"},{\"tag\":\"KEYWORD1\",\"text\":\"EOF\"},{\"tag\":\"KEYWORD1\",\"text\":\"LOBFILE\"},{\"tag\":\"KEYWORD1\",\"text\":\"TRUNCATE\"},{\"tag\":\"KEYWORD1\",\"text\":\"COLUMN\"},{\"tag\":\"KEYWORD1\",\"text\":\"COUNT\"},{\"tag\":\"KEYWORD1\",\"text\":\"AND\"},{\"tag\":\"KEYWORD1\",\"text\":\"SDF\"},{\"tag\":\"KEYWORD1\",\"text\":\"OR\"},{\"tag\":\"KEYWORD1\",\"text\":\"SYSDATE\"},{\"tag\":\"KEYWORD1\",\"text\":\"binary\"},{\"tag\":\"KEYWORD1\",\"text\":\"bit\"},{\"tag\":\"KEYWORD1\",\"text\":\"blob\"},{\"tag\":\"KEYWORD1\",\"text\":\"boolean\"},{\"tag\":\"KEYWORD1\",\"text\":\"char\"},{\"tag\":\"KEYWORD1\",\"text\":\"character\"},{\"tag\":\"KEYWORD1\",\"text\":\"constant\"},{\"tag\":\"KEYWORD1\",\"text\":\"date\"},{\"tag\":\"KEYWORD1\",\"text\":\"datetime\"},{\"tag\":\"KEYWORD1\",\"text\":\"decimal\"},{\"tag\":\"KEYWORD1\",\"text\":\"double\"},{\"tag\":\"KEYWORD1\",\"text\":\"filler\"},{\"tag\":\"KEYWORD1\",\"text\":\"float\"},{\"tag\":\"KEYWORD1\",\"text\":\"image\"},{\"tag\":\"KEYWORD1\",\"text\":\"int\"},{\"tag\":\"KEYWORD1\",\"text\":\"integer\"},{\"tag\":\"KEYWORD1\",\"text\":\"money\"},{\"tag\":\"KEYWORD1\",\"text\":\"numeric\"},{\"tag\":\"KEYWORD1\",\"text\":\"nchar\"},{\"tag\":\"KEYWORD1\",\"text\":\"nvarchar\"},{\"tag\":\"KEYWORD1\",\"text\":\"ntext\"},{\"tag\":\"KEYWORD1\",\"text\":\"object\"},{\"tag\":\"KEYWORD1\",\"text\":\"pls_integer\"},{\"tag\":\"KEYWORD1\",\"text\":\"raw\"},{\"tag\":\"KEYWORD1\",\"text\":\"real\"},{\"tag\":\"KEYWORD1\",\"text\":\"smalldatetime\"},{\"tag\":\"KEYWORD1\",\"text\":\"smallint\"},{\"tag\":\"KEYWORD1\",\"text\":\"smallmoney\"},{\"tag\":\"KEYWORD1\",\"text\":\"sequence\"},{\"tag\":\"KEYWORD1\",\"text\":\"text\"},{\"tag\":\"KEYWORD1\",\"text\":\"timestamp\"},{\"tag\":\"KEYWORD1\",\"text\":\"tinyint\"},{\"tag\":\"KEYWORD1\",\"text\":\"uniqueidentifier\"},{\"tag\":\"KEYWORD1\",\"text\":\"varbinary\"},{\"tag\":\"KEYWORD1\",\"text\":\"varchar\"},{\"tag\":\"KEYWORD1\",\"text\":\"varchar2\"},{\"tag\":\"KEYWORD1\",\"text\":\"varray\"},{\"tag\":\"KEYWORD1\",\"text\":\"zoned\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
