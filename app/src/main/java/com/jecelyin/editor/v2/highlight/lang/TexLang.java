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
public class TexLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"%\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"{}\",\"NAME\":\"wordBreakChars\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"MATH\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"$$\"},{\"tag\":\"END\",\"text\":\"$$\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"MATH\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"$\"},{\"tag\":\"END\",\"text\":\"$\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"MATH\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\\[\"},{\"tag\":\"END\",\"text\":\"\\\\]\"}]},{\"tag\":\"SEQ\",\"text\":\"\\\\$\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\\\\\\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\%\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\\iffalse\"},{\"tag\":\"END\",\"text\":\"\\\\fi\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD1\",\"DELEGATE\":\"VERBATIM\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\\begin{verbatim}\"},{\"tag\":\"END\",\"text\":\"\\\\end{verbatim}\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD1\",\"DELEGATE\":\"VERBATIM\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\\verb|\"},{\"tag\":\"END\",\"text\":\"|\"}]},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"\\\\\",\"attrs\":{\"TYPE\":\"KEYWORD1\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"%\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SEQ\",\"text\":\"{\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"}\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"[\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"]\",\"attrs\":{\"TYPE\":\"OPERATOR\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"MATH\",\"DEFAULT\":\"MARKUP\"},\"child\":[{\"tag\":\"SEQ\",\"text\":\"\\\\$\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\\\\\\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ\",\"text\":\"\\\\%\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"\\\\\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ\",\"text\":\")\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"(\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"{\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"}\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"[\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"]\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"!\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"+\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"-\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"/\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"*\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"&\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"|\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"^\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"~\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\".\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\",\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\";\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"?\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\":\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"'\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"\\\"\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"`\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"%\",\"attrs\":{\"TYPE\":\"COMMENT1\"}}]},{\"tag\":\"RULES\",\"attrs\":{\"SET\":\"VERBATIM\",\"DEFAULT\":\"NULL\"}}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
