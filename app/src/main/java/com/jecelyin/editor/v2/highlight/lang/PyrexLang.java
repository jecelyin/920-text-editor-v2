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
public class PyrexLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"\\\\s*[^#]{3,}:\\\\s*(#.*)?\",\"NAME\":\"indentNextLines\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#\",\"NAME\":\"lineComment\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"python::MAIN\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD4\",\"text\":\"cdef\"},{\"tag\":\"KEYWORD4\",\"text\":\"char\"},{\"tag\":\"KEYWORD4\",\"text\":\"cinclude\"},{\"tag\":\"KEYWORD4\",\"text\":\"ctypedef\"},{\"tag\":\"KEYWORD4\",\"text\":\"double\"},{\"tag\":\"KEYWORD4\",\"text\":\"enum\"},{\"tag\":\"KEYWORD4\",\"text\":\"extern\"},{\"tag\":\"KEYWORD4\",\"text\":\"float\"},{\"tag\":\"KEYWORD4\",\"text\":\"include\"},{\"tag\":\"KEYWORD4\",\"text\":\"private\"},{\"tag\":\"KEYWORD4\",\"text\":\"public\"},{\"tag\":\"KEYWORD4\",\"text\":\"short\"},{\"tag\":\"KEYWORD4\",\"text\":\"signed\"},{\"tag\":\"KEYWORD4\",\"text\":\"sizeof\"},{\"tag\":\"KEYWORD4\",\"text\":\"struct\"},{\"tag\":\"KEYWORD4\",\"text\":\"union\"},{\"tag\":\"KEYWORD4\",\"text\":\"unsigned\"},{\"tag\":\"KEYWORD4\",\"text\":\"void\"},{\"tag\":\"LITERAL3\",\"text\":\"NULL\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
