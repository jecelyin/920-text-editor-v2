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
public class RelaxNgCompactLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"{\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"}\",\"NAME\":\"indentCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"false\",\"NAME\":\"doubleBracketIndent\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\",+-=<>/?^&*\",\"NAME\":\"wordBreakChars\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\\\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\\\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'''\"},{\"tag\":\"END\",\"text\":\"'''\"}]},{\"tag\":\"SEQ\",\"text\":\"+\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"*\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"?\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"&=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"&\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"|=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"|\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"-\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"\\\\\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"attribute\"},{\"tag\":\"KEYWORD1\",\"text\":\"default\"},{\"tag\":\"KEYWORD1\",\"text\":\"datatypes\"},{\"tag\":\"KEYWORD1\",\"text\":\"div\"},{\"tag\":\"KEYWORD1\",\"text\":\"element\"},{\"tag\":\"KEYWORD1\",\"text\":\"empty\"},{\"tag\":\"KEYWORD1\",\"text\":\"external\"},{\"tag\":\"KEYWORD1\",\"text\":\"grammar\"},{\"tag\":\"KEYWORD1\",\"text\":\"include\"},{\"tag\":\"KEYWORD1\",\"text\":\"inherit\"},{\"tag\":\"KEYWORD1\",\"text\":\"list\"},{\"tag\":\"KEYWORD1\",\"text\":\"mixed\"},{\"tag\":\"KEYWORD1\",\"text\":\"namespace\"},{\"tag\":\"KEYWORD1\",\"text\":\"notAllowed\"},{\"tag\":\"KEYWORD1\",\"text\":\"parent\"},{\"tag\":\"KEYWORD1\",\"text\":\"start\"},{\"tag\":\"KEYWORD2\",\"text\":\"string\"},{\"tag\":\"KEYWORD1\",\"text\":\"text\"},{\"tag\":\"KEYWORD2\",\"text\":\"token\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
