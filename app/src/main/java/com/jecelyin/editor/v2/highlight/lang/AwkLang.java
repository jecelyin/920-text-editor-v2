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
public class AwkLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"{\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"}\",\"NAME\":\"indentCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\",+-=<>/?^&*\",\"NAME\":\"wordBreakChars\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"contextInsensitive\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"!\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"+\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"-\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"/\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"*\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"%\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"&\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"|\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"^\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"~\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"}\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"{\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"MARK_PREVIOUS\",\"text\":\":\",\"attrs\":{\"AT_WHITESPACE_END\":\"TRUE\",\"TYPE\":\"LABEL\",\"MATCH_TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"break\"},{\"tag\":\"KEYWORD1\",\"text\":\"close\"},{\"tag\":\"KEYWORD1\",\"text\":\"continue\"},{\"tag\":\"KEYWORD1\",\"text\":\"delete\"},{\"tag\":\"KEYWORD1\",\"text\":\"do\"},{\"tag\":\"KEYWORD1\",\"text\":\"else\"},{\"tag\":\"KEYWORD1\",\"text\":\"exit\"},{\"tag\":\"KEYWORD1\",\"text\":\"fflush\"},{\"tag\":\"KEYWORD1\",\"text\":\"for\"},{\"tag\":\"KEYWORD1\",\"text\":\"huge\"},{\"tag\":\"KEYWORD1\",\"text\":\"if\"},{\"tag\":\"KEYWORD1\",\"text\":\"in\"},{\"tag\":\"KEYWORD1\",\"text\":\"function\"},{\"tag\":\"KEYWORD1\",\"text\":\"next\"},{\"tag\":\"KEYWORD1\",\"text\":\"nextfile\"},{\"tag\":\"KEYWORD1\",\"text\":\"print\"},{\"tag\":\"KEYWORD1\",\"text\":\"printf\"},{\"tag\":\"KEYWORD1\",\"text\":\"return\"},{\"tag\":\"KEYWORD1\",\"text\":\"while\"},{\"tag\":\"KEYWORD2\",\"text\":\"atan2\"},{\"tag\":\"KEYWORD2\",\"text\":\"cos\"},{\"tag\":\"KEYWORD2\",\"text\":\"exp\"},{\"tag\":\"KEYWORD2\",\"text\":\"gensub\"},{\"tag\":\"KEYWORD2\",\"text\":\"getline\"},{\"tag\":\"KEYWORD2\",\"text\":\"gsub\"},{\"tag\":\"KEYWORD2\",\"text\":\"index\"},{\"tag\":\"KEYWORD2\",\"text\":\"int\"},{\"tag\":\"KEYWORD2\",\"text\":\"length\"},{\"tag\":\"KEYWORD2\",\"text\":\"log\"},{\"tag\":\"KEYWORD2\",\"text\":\"match\"},{\"tag\":\"KEYWORD2\",\"text\":\"rand\"},{\"tag\":\"KEYWORD2\",\"text\":\"sin\"},{\"tag\":\"KEYWORD2\",\"text\":\"split\"},{\"tag\":\"KEYWORD2\",\"text\":\"sprintf\"},{\"tag\":\"KEYWORD2\",\"text\":\"sqrt\"},{\"tag\":\"KEYWORD2\",\"text\":\"srand\"},{\"tag\":\"KEYWORD2\",\"text\":\"sub\"},{\"tag\":\"KEYWORD2\",\"text\":\"substr\"},{\"tag\":\"KEYWORD2\",\"text\":\"system\"},{\"tag\":\"KEYWORD2\",\"text\":\"tolower\"},{\"tag\":\"KEYWORD2\",\"text\":\"toupper\"},{\"tag\":\"KEYWORD3\",\"text\":\"BEGIN\"},{\"tag\":\"KEYWORD3\",\"text\":\"END\"},{\"tag\":\"KEYWORD3\",\"text\":\"$0\"},{\"tag\":\"KEYWORD3\",\"text\":\"ARGC\"},{\"tag\":\"KEYWORD3\",\"text\":\"ARGIND\"},{\"tag\":\"KEYWORD3\",\"text\":\"ARGV\"},{\"tag\":\"KEYWORD3\",\"text\":\"CONVFMT\"},{\"tag\":\"KEYWORD3\",\"text\":\"ENVIRON\"},{\"tag\":\"KEYWORD3\",\"text\":\"ERRNO\"},{\"tag\":\"KEYWORD3\",\"text\":\"FIELDSWIDTH\"},{\"tag\":\"KEYWORD3\",\"text\":\"FILENAME\"},{\"tag\":\"KEYWORD3\",\"text\":\"FNR\"},{\"tag\":\"KEYWORD3\",\"text\":\"FS\"},{\"tag\":\"KEYWORD3\",\"text\":\"IGNORECASE\"},{\"tag\":\"KEYWORD3\",\"text\":\"NF\"},{\"tag\":\"KEYWORD3\",\"text\":\"NR\"},{\"tag\":\"KEYWORD3\",\"text\":\"OFMT\"},{\"tag\":\"KEYWORD3\",\"text\":\"OFS\"},{\"tag\":\"KEYWORD3\",\"text\":\"ORS\"},{\"tag\":\"KEYWORD3\",\"text\":\"RLENGTH\"},{\"tag\":\"KEYWORD3\",\"text\":\"RS\"},{\"tag\":\"KEYWORD3\",\"text\":\"RSTART\"},{\"tag\":\"KEYWORD3\",\"text\":\"RT\"},{\"tag\":\"KEYWORD3\",\"text\":\"SUBSEP\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
