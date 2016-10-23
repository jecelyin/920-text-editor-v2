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
public class PspLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"<!--\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"-->\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"\\\\s*[^#]{3,}:\\\\s*(#.*)?\",\"NAME\":\"indentNextLines\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL4\",\"DELEGATE\":\"DIRECTIVE\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%@\"},{\"tag\":\"END\",\"text\":\"%>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%--\"},{\"tag\":\"END\",\"text\":\"--%>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL3\",\"DELEGATE\":\"python::MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%\"},{\"tag\":\"END\",\"text\":\"%>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"javascript::MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<script language=\\\"jscript\\\">\"},{\"tag\":\"END\",\"text\":\"<\\/script>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"javascript::MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<script language=\\\"javascript\\\">\"},{\"tag\":\"END\",\"text\":\"<\\/script>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"javascript::MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<script>\"},{\"tag\":\"END\",\"text\":\"<\\/script>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<!--#\"},{\"tag\":\"END\",\"text\":\"-->\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<!--\"},{\"tag\":\"END\",\"text\":\"-->\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"css::MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<STYLE>\"},{\"tag\":\"END\",\"text\":\"<\\/STYLE>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"TAGS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_WORD_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"&\"},{\"tag\":\"END\",\"text\":\";\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"TAGS\",\"DEFAULT\":\"MARKUP\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%--\"},{\"tag\":\"END\",\"text\":\"--%>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL3\",\"DELEGATE\":\"python::MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%\"},{\"tag\":\"END\",\"text\":\"%>\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"DIRECTIVE\",\"DEFAULT\":\"LITERAL4\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD4\",\"text\":\"include\"},{\"tag\":\"KEYWORD4\",\"text\":\"file\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
