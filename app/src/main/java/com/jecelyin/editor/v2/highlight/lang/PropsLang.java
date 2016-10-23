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
public class PropsLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"FALSE\",\"NAME\":\"contextInsensitive\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"child\":[{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"\\\\s*[#!]\",\"attrs\":{\"TYPE\":\"COMMENT1\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"\\\\s*$\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"NO_WORD_BREAK\":\"TRUE\",\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD1\",\"AT_LINE_START\":\"TRUE\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\\s*([\\\\u0022-\\\\uFFFF&&[^:=]]|[\\\\\\\\][:=\\t])+?\"},{\"tag\":\"END\",\"text\":\"(?=(([:=])|(\\\\s+)))\",\"attrs\":{\"REGEXP\":\"TRUE\"}}]},{\"tag\":\"SEQ_REGEXP\",\"text\":\"((\\\\s*[:=]\\\\s*)|(\\\\s+))\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"[^\\\\\\\\]{1}$\",\"attrs\":{\"TYPE\":\"LITERAL1\"}},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\".\"},{\"tag\":\"END\",\"text\":\"[^\\\\\\\\]$\",\"attrs\":{\"REGEXP\":\"TRUE\"}}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
