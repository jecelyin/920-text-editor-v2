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
public class GettextLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"# \",\"NAME\":\"lineComment\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"#:\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"#.\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"#~\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"#,\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"%\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"$\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"@\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"DELEGATE\":\"QUOTED\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"msgid\"},{\"tag\":\"KEYWORD1\",\"text\":\"msgid_plural\"},{\"tag\":\"KEYWORD1\",\"text\":\"msgstr\"},{\"tag\":\"KEYWORD2\",\"text\":\"fuzzy\"},{\"tag\":\"KEYWORD2\",\"text\":\"c-format\"},{\"tag\":\"KEYWORD2\",\"text\":\"no-c-format\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"QUOTED\",\"DEFAULT\":\"LITERAL1\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\\\\\"\"},{\"tag\":\"END\",\"text\":\"\\\\\\\"\"}]},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"%\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"$\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"@\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
