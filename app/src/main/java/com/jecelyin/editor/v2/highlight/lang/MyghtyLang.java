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
public class MyghtyLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"<!--\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"-->\",\"NAME\":\"commentEnd\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"COMMENT2\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL4\",\"DELEGATE\":\"MYGHTY\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%attr>\"},{\"tag\":\"END\",\"text\":\"<\\/%attr>\"}]},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL4\",\"DELEGATE\":\"DEF\",\"HASH_CHAR\":\"<%\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%(def|closure|method)\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SEQ_REGEXP\",\"text\":\"<\\/%(def|closure|method)>\",\"attrs\":{\"TYPE\":\"LITERAL4\",\"HASH_CHAR\":\"<\\/%\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT4\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%doc>\"},{\"tag\":\"END\",\"text\":\"<\\/%doc>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL4\",\"DELEGATE\":\"MYGHTY\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%flags>\"},{\"tag\":\"END\",\"text\":\"<\\/%flags>\"}]},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL4\",\"DELEGATE\":\"MYGHTY\",\"HASH_CHAR\":\"<%python\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%python[^>]*>\"},{\"tag\":\"END\",\"text\":\"<\\/%python>\"}]},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL4\",\"DELEGATE\":\"MYGHTY\",\"HASH_CHAR\":\"<%\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%(args|cleanup|filter|global|init|once|requestlocal|requestonce|shared|threadlocal|threadonce)>\"},{\"tag\":\"END\",\"text\":\"<\\/%$1>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL3\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%text>\"},{\"tag\":\"END\",\"text\":\"<\\/%text>\"}]},{\"tag\":\"SEQ\",\"text\":\"<\\/&>\",\"attrs\":{\"TYPE\":\"LITERAL4\"}},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL4\",\"DELEGATE\":\"MYGHTY\",\"HASH_CHAR\":\"<&\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<&[|]?\"},{\"tag\":\"END\",\"text\":\"&>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL3\",\"DELEGATE\":\"MYGHTY\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%\"},{\"tag\":\"END\",\"text\":\"%>\"}]},{\"tag\":\"EOL_SPAN\",\"text\":\"%\",\"attrs\":{\"TYPE\":\"LITERAL4\",\"AT_LINE_START\":\"TRUE\",\"DELEGATE\":\"MYGHTY\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"html::MAIN\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"NULL\",\"text\":\"args\"},{\"tag\":\"NULL\",\"text\":\"attr\"},{\"tag\":\"NULL\",\"text\":\"cleanup\"},{\"tag\":\"NULL\",\"text\":\"closure\"},{\"tag\":\"NULL\",\"text\":\"def\"},{\"tag\":\"NULL\",\"text\":\"doc\"},{\"tag\":\"NULL\",\"text\":\"filter\"},{\"tag\":\"NULL\",\"text\":\"flags\"},{\"tag\":\"NULL\",\"text\":\"global\"},{\"tag\":\"NULL\",\"text\":\"init\"},{\"tag\":\"NULL\",\"text\":\"method\"},{\"tag\":\"NULL\",\"text\":\"once\"},{\"tag\":\"NULL\",\"text\":\"python\"},{\"tag\":\"NULL\",\"text\":\"requestlocal\"},{\"tag\":\"NULL\",\"text\":\"requestonce\"},{\"tag\":\"NULL\",\"text\":\"shared\"},{\"tag\":\"NULL\",\"text\":\"threadlocal\"},{\"tag\":\"NULL\",\"text\":\"threadonce\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"MYGHTY\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SEQ\",\"text\":\"@\",\"attrs\":{\"TYPE\":\"KEYWORD4\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"python::MAIN\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD4\",\"text\":\"ARGS\"},{\"tag\":\"KEYWORD4\",\"text\":\"MODULE\"},{\"tag\":\"KEYWORD4\",\"text\":\"SELF\"},{\"tag\":\"KEYWORD4\",\"text\":\"m\"},{\"tag\":\"KEYWORD4\",\"text\":\"r\"},{\"tag\":\"KEYWORD4\",\"text\":\"s\"},{\"tag\":\"KEYWORD4\",\"text\":\"u\"},{\"tag\":\"KEYWORD4\",\"text\":\"h\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"DEF\",\"DEFAULT\":\"FUNCTION\",\"IGNORE_CASE\":\"TRUE\"}}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
