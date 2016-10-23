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
public class ShtmlLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"<!--\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"-->\",\"NAME\":\"commentEnd\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD3\",\"DELEGATE\":\"SSI\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<!--#\"},{\"tag\":\"END\",\"text\":\"-->\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<!--\"},{\"tag\":\"END\",\"text\":\"-->\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"html::JAVASCRIPT\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<SCRIPT\"},{\"tag\":\"END\",\"text\":\"<\\/SCRIPT>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"html::CSS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<STYLE\"},{\"tag\":\"END\",\"text\":\"<\\/STYLE>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"DELEGATE\":\"xml::DTD-TAGS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<!\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"TAGS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_WORD_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"&\"},{\"tag\":\"END\",\"text\":\";\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"TAGS\",\"DEFAULT\":\"MARKUP\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"SSI\",\"DEFAULT\":\"KEYWORD3\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"DELEGATE\":\"SSI-EXPRESSION\",\"MATCH_TYPE\":\"OPERATOR\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"config\"},{\"tag\":\"KEYWORD1\",\"text\":\"echo\"},{\"tag\":\"KEYWORD1\",\"text\":\"exec\"},{\"tag\":\"KEYWORD1\",\"text\":\"flastmod\"},{\"tag\":\"KEYWORD1\",\"text\":\"fsize\"},{\"tag\":\"KEYWORD1\",\"text\":\"include\"},{\"tag\":\"KEYWORD2\",\"text\":\"cgi\"},{\"tag\":\"KEYWORD2\",\"text\":\"errmsg\"},{\"tag\":\"KEYWORD2\",\"text\":\"file\"},{\"tag\":\"KEYWORD2\",\"text\":\"sizefmt\"},{\"tag\":\"KEYWORD2\",\"text\":\"timefmt\"},{\"tag\":\"KEYWORD2\",\"text\":\"var\"},{\"tag\":\"KEYWORD2\",\"text\":\"cmd\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"SSI-EXPRESSION\",\"DEFAULT\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"MARK_FOLLOWING\",\"text\":\"$\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"!=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"&&\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"||\",\"attrs\":{\"TYPE\":\"OPERATOR\"}}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
