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
public class RdLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"{\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"}\",\"NAME\":\"indentCloseBrackets\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SEQ\",\"text\":\"{\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"}\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"\\\\name\"},{\"tag\":\"KEYWORD1\",\"text\":\"\\\\alias\"},{\"tag\":\"KEYWORD1\",\"text\":\"\\\\title\"},{\"tag\":\"KEYWORD1\",\"text\":\"\\\\description\"},{\"tag\":\"KEYWORD1\",\"text\":\"\\\\synopsis\"},{\"tag\":\"KEYWORD1\",\"text\":\"\\\\usage\"},{\"tag\":\"KEYWORD1\",\"text\":\"\\\\arguments\"},{\"tag\":\"KEYWORD1\",\"text\":\"\\\\details\"},{\"tag\":\"KEYWORD1\",\"text\":\"\\\\value\"},{\"tag\":\"KEYWORD1\",\"text\":\"\\\\references\"},{\"tag\":\"KEYWORD1\",\"text\":\"\\\\note\"},{\"tag\":\"KEYWORD1\",\"text\":\"\\\\author\"},{\"tag\":\"KEYWORD1\",\"text\":\"\\\\seealso\"},{\"tag\":\"KEYWORD1\",\"text\":\"\\\\examples\"},{\"tag\":\"KEYWORD1\",\"text\":\"\\\\keyword\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\itemize\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\method\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\docType\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\format\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\source\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\itemize\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\section\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\enumerate\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\describe\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\tabular\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\link\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\item\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\eqn\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\deqn\"},{\"tag\":\"KEYWORD2\",\"text\":\"\\\\concept\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\emph\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\strong\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\bold\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\sQuote\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\dQuote\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\code\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\preformatted\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\kbd\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\samp\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\pkg\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\file\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\email\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\url\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\var\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\env\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\option\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\command\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\dfn\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\cite\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\acronym\"},{\"tag\":\"KEYWORD3\",\"text\":\"\\\\tab\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
