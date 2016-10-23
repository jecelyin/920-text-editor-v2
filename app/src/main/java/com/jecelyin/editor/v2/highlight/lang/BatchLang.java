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
public class BatchLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"rem\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"(\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\")\",\"NAME\":\"indentCloseBrackets\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"FALSE\",\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"SEQ\",\"text\":\"@\",\"attrs\":{\"TYPE\":\"KEYWORD3\"}},{\"tag\":\"SEQ\",\"text\":\"+\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"|\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"&\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"!\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\":\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"LABEL\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"REM\\\\s\",\"attrs\":{\"AT_WHITESPACE_END\":\"TRUE\",\"TYPE\":\"COMMENT1\",\"HASH_CHAR\":\"REM\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SEQ\",\"text\":\"%0\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"%1\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"%2\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"%3\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"%4\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"%5\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"%6\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"%7\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"%8\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"%9\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"%%[\\\\p{Alpha}]\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"KEYWORD2\",\"HASH_CHAR\":\"%%\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"%\"},{\"tag\":\"END\",\"text\":\"%\"}]},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"cd\"},{\"tag\":\"KEYWORD1\",\"text\":\"chdir\"},{\"tag\":\"KEYWORD1\",\"text\":\"md\"},{\"tag\":\"KEYWORD1\",\"text\":\"mkdir\"},{\"tag\":\"KEYWORD1\",\"text\":\"cls\"},{\"tag\":\"KEYWORD1\",\"text\":\"for\"},{\"tag\":\"KEYWORD1\",\"text\":\"if\"},{\"tag\":\"KEYWORD1\",\"text\":\"echo\"},{\"tag\":\"KEYWORD1\",\"text\":\"echo.\"},{\"tag\":\"KEYWORD1\",\"text\":\"move\"},{\"tag\":\"KEYWORD1\",\"text\":\"copy\"},{\"tag\":\"KEYWORD1\",\"text\":\"move\"},{\"tag\":\"KEYWORD1\",\"text\":\"ren\"},{\"tag\":\"KEYWORD1\",\"text\":\"del\"},{\"tag\":\"KEYWORD1\",\"text\":\"set\"},{\"tag\":\"KEYWORD1\",\"text\":\"call\"},{\"tag\":\"KEYWORD1\",\"text\":\"exit\"},{\"tag\":\"KEYWORD1\",\"text\":\"setlocal\"},{\"tag\":\"KEYWORD1\",\"text\":\"shift\"},{\"tag\":\"KEYWORD1\",\"text\":\"endlocal\"},{\"tag\":\"KEYWORD1\",\"text\":\"pause\"},{\"tag\":\"KEYWORD2\",\"text\":\"defined\"},{\"tag\":\"KEYWORD2\",\"text\":\"exist\"},{\"tag\":\"KEYWORD2\",\"text\":\"errorlevel\"},{\"tag\":\"KEYWORD2\",\"text\":\"else\"},{\"tag\":\"KEYWORD2\",\"text\":\"in\"},{\"tag\":\"KEYWORD2\",\"text\":\"do\"},{\"tag\":\"KEYWORD2\",\"text\":\"NUL\"},{\"tag\":\"KEYWORD2\",\"text\":\"AUX\"},{\"tag\":\"KEYWORD2\",\"text\":\"PRN\"},{\"tag\":\"KEYWORD1\",\"text\":\"not\"},{\"tag\":\"KEYWORD3\",\"text\":\"goto\"},{\"tag\":\"FUNCTION\",\"text\":\"APPEND\"},{\"tag\":\"FUNCTION\",\"text\":\"ATTRIB\"},{\"tag\":\"FUNCTION\",\"text\":\"CHKDSK\"},{\"tag\":\"FUNCTION\",\"text\":\"CHOICE\"},{\"tag\":\"FUNCTION\",\"text\":\"DEBUG\"},{\"tag\":\"FUNCTION\",\"text\":\"DEFRAG\"},{\"tag\":\"FUNCTION\",\"text\":\"DELTREE\"},{\"tag\":\"FUNCTION\",\"text\":\"DISKCOMP\"},{\"tag\":\"FUNCTION\",\"text\":\"DISKCOPY\"},{\"tag\":\"FUNCTION\",\"text\":\"DOSKEY\"},{\"tag\":\"FUNCTION\",\"text\":\"DRVSPACE\"},{\"tag\":\"FUNCTION\",\"text\":\"EMM386\"},{\"tag\":\"FUNCTION\",\"text\":\"EXPAND\"},{\"tag\":\"FUNCTION\",\"text\":\"FASTOPEN\"},{\"tag\":\"FUNCTION\",\"text\":\"FC\"},{\"tag\":\"FUNCTION\",\"text\":\"FDISK\"},{\"tag\":\"FUNCTION\",\"text\":\"FIND\"},{\"tag\":\"FUNCTION\",\"text\":\"FORMAT\"},{\"tag\":\"FUNCTION\",\"text\":\"GRAPHICS\"},{\"tag\":\"FUNCTION\",\"text\":\"KEYB\"},{\"tag\":\"FUNCTION\",\"text\":\"LABEL\"},{\"tag\":\"FUNCTION\",\"text\":\"LOADFIX\"},{\"tag\":\"FUNCTION\",\"text\":\"MEM\"},{\"tag\":\"FUNCTION\",\"text\":\"MODE\"},{\"tag\":\"FUNCTION\",\"text\":\"MORE\"},{\"tag\":\"FUNCTION\",\"text\":\"MOVE\"},{\"tag\":\"FUNCTION\",\"text\":\"MSCDEX\"},{\"tag\":\"FUNCTION\",\"text\":\"NLSFUNC\"},{\"tag\":\"FUNCTION\",\"text\":\"POWER\"},{\"tag\":\"FUNCTION\",\"text\":\"PRINT\"},{\"tag\":\"FUNCTION\",\"text\":\"RD\"},{\"tag\":\"FUNCTION\",\"text\":\"REPLACE\"},{\"tag\":\"FUNCTION\",\"text\":\"RESTORE\"},{\"tag\":\"FUNCTION\",\"text\":\"SETVER\"},{\"tag\":\"FUNCTION\",\"text\":\"SHARE\"},{\"tag\":\"FUNCTION\",\"text\":\"SORT\"},{\"tag\":\"FUNCTION\",\"text\":\"SUBST\"},{\"tag\":\"FUNCTION\",\"text\":\"SYS\"},{\"tag\":\"FUNCTION\",\"text\":\"TREE\"},{\"tag\":\"FUNCTION\",\"text\":\"UNDELETE\"},{\"tag\":\"FUNCTION\",\"text\":\"UNFORMAT\"},{\"tag\":\"FUNCTION\",\"text\":\"VSAFE\"},{\"tag\":\"FUNCTION\",\"text\":\"XCOPY\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
