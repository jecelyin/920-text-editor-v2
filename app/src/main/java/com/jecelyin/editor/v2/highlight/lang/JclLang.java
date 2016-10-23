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
public class JclLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\",+-=<>/?^&*\",\"NAME\":\"wordBreakChars\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"FALSE\",\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"//*\",\"attrs\":{\"TYPE\":\"COMMENT1\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"FALSE\",\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"&\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"|\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\",\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD2\",\"text\":\"COMMAND\"},{\"tag\":\"KEYWORD2\",\"text\":\"CNTL\"},{\"tag\":\"KEYWORD2\",\"text\":\"DD\"},{\"tag\":\"KEYWORD2\",\"text\":\"ENCNTL\"},{\"tag\":\"KEYWORD2\",\"text\":\"EXEC\"},{\"tag\":\"KEYWORD2\",\"text\":\"IF\"},{\"tag\":\"KEYWORD2\",\"text\":\"THEN\"},{\"tag\":\"KEYWORD2\",\"text\":\"ELSE\"},{\"tag\":\"KEYWORD2\",\"text\":\"ENDIF\"},{\"tag\":\"KEYWORD2\",\"text\":\"INCLUDE\"},{\"tag\":\"KEYWORD2\",\"text\":\"JCLIB\"},{\"tag\":\"KEYWORD2\",\"text\":\"JOB\"},{\"tag\":\"KEYWORD2\",\"text\":\"MSG\"},{\"tag\":\"KEYWORD2\",\"text\":\"OUTPUT\"},{\"tag\":\"KEYWORD2\",\"text\":\"PEND\"},{\"tag\":\"KEYWORD2\",\"text\":\"PROC\"},{\"tag\":\"KEYWORD2\",\"text\":\"SET\"},{\"tag\":\"KEYWORD2\",\"text\":\"XMIT\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
