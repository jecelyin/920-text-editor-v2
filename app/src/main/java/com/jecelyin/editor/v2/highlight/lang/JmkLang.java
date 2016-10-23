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
public class JmkLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"{\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"}\",\"NAME\":\"indentCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"contextInsensitive\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"SEQ\",\"text\":\"{\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"}\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"(\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\")\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"-\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"cat\"},{\"tag\":\"KEYWORD1\",\"text\":\"copy\"},{\"tag\":\"KEYWORD1\",\"text\":\"create\"},{\"tag\":\"KEYWORD1\",\"text\":\"delall\"},{\"tag\":\"KEYWORD1\",\"text\":\"delete\"},{\"tag\":\"KEYWORD1\",\"text\":\"dirs\"},{\"tag\":\"KEYWORD1\",\"text\":\"equal\"},{\"tag\":\"KEYWORD1\",\"text\":\"else\"},{\"tag\":\"KEYWORD1\",\"text\":\"end\"},{\"tag\":\"KEYWORD1\",\"text\":\"exec\"},{\"tag\":\"KEYWORD1\",\"text\":\"first\"},{\"tag\":\"KEYWORD1\",\"text\":\"forname\"},{\"tag\":\"KEYWORD1\",\"text\":\"function\"},{\"tag\":\"KEYWORD1\",\"text\":\"getprop\"},{\"tag\":\"KEYWORD1\",\"text\":\"glob\"},{\"tag\":\"KEYWORD1\",\"text\":\"if\"},{\"tag\":\"KEYWORD1\",\"text\":\"join\"},{\"tag\":\"KEYWORD1\",\"text\":\"load\"},{\"tag\":\"KEYWORD1\",\"text\":\"mkdir\"},{\"tag\":\"KEYWORD1\",\"text\":\"mkdirs\"},{\"tag\":\"KEYWORD1\",\"text\":\"note\"},{\"tag\":\"KEYWORD1\",\"text\":\"patsubst\"},{\"tag\":\"KEYWORD1\",\"text\":\"rename\"},{\"tag\":\"KEYWORD1\",\"text\":\"rest\"},{\"tag\":\"KEYWORD1\",\"text\":\"subst\"},{\"tag\":\"KEYWORD1\",\"text\":\"then\"},{\"tag\":\"KEYWORD2\",\"text\":\"@\"},{\"tag\":\"KEYWORD2\",\"text\":\"?\"},{\"tag\":\"KEYWORD2\",\"text\":\"<\"},{\"tag\":\"KEYWORD2\",\"text\":\"%\"},{\"tag\":\"KEYWORD3\",\"text\":\"include\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
