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
public class PtlLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"\\\\s*[^#]{3,}:\\\\s*(#.*)?\",\"NAME\":\"indentNextLines\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"contextInsensitive\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"python::MAIN\"}},{\"tag\":\"SEQ\",\"text\":\"[html]\",\"attrs\":{\"TYPE\":\"KEYWORD4\"}},{\"tag\":\"SEQ\",\"text\":\"[plain]\",\"attrs\":{\"TYPE\":\"KEYWORD4\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"LITERAL4\",\"text\":\"_q_access\"},{\"tag\":\"LITERAL4\",\"text\":\"_q_exports\"},{\"tag\":\"LITERAL4\",\"text\":\"_q_index\"},{\"tag\":\"LITERAL4\",\"text\":\"_q_lookup\"},{\"tag\":\"LITERAL4\",\"text\":\"_q_resolve\"},{\"tag\":\"LITERAL4\",\"text\":\"_q_exception_handler\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
