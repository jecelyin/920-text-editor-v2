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
public class LiterateHaskellLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"{-\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"-}\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"--\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"8\",\"NAME\":\"tabSize\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"8\",\"NAME\":\"indentSize\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"DEFAULT\":\"COMMENT4\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\">\",\"attrs\":{\"AT_WHITESPACE_END\":\"TRUE\",\"TYPE\":\"FUNCTION\",\"DELEGATE\":\"haskell::MAIN\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"%\",\"attrs\":{\"TYPE\":\"COMMENT3\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL3\",\"DELEGATE\":\"haskell::MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\\begin{code}\"},{\"tag\":\"END\",\"text\":\"\\\\end{code}\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
