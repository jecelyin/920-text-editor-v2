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
public class SlaxLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*/\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\",/+=*\",\"NAME\":\"wordBreakChars\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"-_:.\",\"NAME\":\"noWordSep\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DEFAULT\":\"LITERAL3\",\"DIGIT_RE\":\"([0-9])*\\\\.?([0-9])+\",\"IGNORE_CASE\":\"TRUE\",\"NO_WORD_SEP\":\"-_:.\"},\"child\":[{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"leading-comments\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"strings\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"variables\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"templates\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"statements\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"xml-tags\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"trailing-comments\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"leading-comments\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"AT_WHITESPACE_END\":\"TRUE\",\"TYPE\":\"LITERAL3\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"/*\"},{\"tag\":\"END\",\"text\":\"*/\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"trailing-comments\"},\"child\":[{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL3\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"((;)|(\\\\})|(\\\\{)|(\\\\)))(\\\\s)*/\\\\*\"},{\"tag\":\"END\",\"text\":\"*/\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"strings\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL2\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"xml-tags\",\"DEFAULT\":\"KEYWORD3\"},\"child\":[{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD3\",\"DELEGATE\":\"inside-the-tag\"},\"child\":[{\"tag\":\"BEGIN\"},{\"tag\":\"END\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"inside-the-tag\",\"DEFAULT\":\"KEYWORD3\"},\"child\":[{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL3\",\"DELEGATE\":\"attribute\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"(\\\\s)+(?!>)\"},{\"tag\":\"END\",\"text\":\"=\"}]},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"strings\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"attribute\",\"DEFAULT\":\"KEYWORD4\"}},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"variables\"},\"child\":[{\"tag\":\"MARK_FOLLOWING\",\"text\":\"$\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"templates\"},\"child\":[{\"tag\":\"MARK_PREVIOUS\",\"text\":\"(\",\"attrs\":{\"TYPE\":\"FUNCTION\",\"MATCH_TYPE\":\"LITERAL3\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"statements\"},\"child\":[{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"if\"},{\"tag\":\"KEYWORD1\",\"text\":\"version\"},{\"tag\":\"KEYWORD1\",\"text\":\"ns\"},{\"tag\":\"KEYWORD1\",\"text\":\"param\"},{\"tag\":\"KEYWORD1\",\"text\":\"var\"},{\"tag\":\"KEYWORD1\",\"text\":\"template\"},{\"tag\":\"KEYWORD1\",\"text\":\"match\"},{\"tag\":\"KEYWORD1\",\"text\":\"else\"},{\"tag\":\"KEYWORD1\",\"text\":\"copy-of\"},{\"tag\":\"KEYWORD1\",\"text\":\"copy\"},{\"tag\":\"KEYWORD1\",\"text\":\"call\"},{\"tag\":\"KEYWORD1\",\"text\":\"apply-templates\"},{\"tag\":\"KEYWORD1\",\"text\":\"expr\"},{\"tag\":\"KEYWORD1\",\"text\":\"import\"},{\"tag\":\"KEYWORD1\",\"text\":\"input\"},{\"tag\":\"KEYWORD1\",\"text\":\"for-each\"},{\"tag\":\"KEYWORD1\",\"text\":\"mode\"},{\"tag\":\"KEYWORD1\",\"text\":\"priority\"},{\"tag\":\"KEYWORD1\",\"text\":\"extension\"},{\"tag\":\"KEYWORD1\",\"text\":\"preserve-space\"},{\"tag\":\"KEYWORD1\",\"text\":\"strip-space\"},{\"tag\":\"KEYWORD1\",\"text\":\"with\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
