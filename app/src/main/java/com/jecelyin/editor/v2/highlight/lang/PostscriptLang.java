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
public class PostscriptLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"%\",\"NAME\":\"lineComment\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"%!\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"%?\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"%%\",\"attrs\":{\"TYPE\":\"COMMENT2\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"%\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"DELEGATE\":\"LITERAL\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"(\"},{\"tag\":\"END\",\"text\":\")\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"/\",\"attrs\":{\"TYPE\":\"LABEL\"}},{\"tag\":\"SEQ\",\"text\":\"}\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"{\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"]\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"[\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"pop\"},{\"tag\":\"KEYWORD1\",\"text\":\"exch\"},{\"tag\":\"KEYWORD1\",\"text\":\"dup\"},{\"tag\":\"KEYWORD1\",\"text\":\"copy\"},{\"tag\":\"KEYWORD1\",\"text\":\"roll\"},{\"tag\":\"KEYWORD1\",\"text\":\"clear\"},{\"tag\":\"KEYWORD1\",\"text\":\"count\"},{\"tag\":\"KEYWORD1\",\"text\":\"mark\"},{\"tag\":\"KEYWORD1\",\"text\":\"cleartomark\"},{\"tag\":\"KEYWORD1\",\"text\":\"counttomark\"},{\"tag\":\"KEYWORD1\",\"text\":\"exec\"},{\"tag\":\"KEYWORD1\",\"text\":\"if\"},{\"tag\":\"KEYWORD1\",\"text\":\"ifelse\"},{\"tag\":\"KEYWORD1\",\"text\":\"for\"},{\"tag\":\"KEYWORD1\",\"text\":\"repeat\"},{\"tag\":\"KEYWORD1\",\"text\":\"loop\"},{\"tag\":\"KEYWORD1\",\"text\":\"exit\"},{\"tag\":\"KEYWORD1\",\"text\":\"stop\"},{\"tag\":\"KEYWORD1\",\"text\":\"stopped\"},{\"tag\":\"KEYWORD1\",\"text\":\"countexecstack\"},{\"tag\":\"KEYWORD1\",\"text\":\"execstack\"},{\"tag\":\"KEYWORD1\",\"text\":\"quit\"},{\"tag\":\"KEYWORD1\",\"text\":\"start\"},{\"tag\":\"OPERATOR\",\"text\":\"add\"},{\"tag\":\"OPERATOR\",\"text\":\"div\"},{\"tag\":\"OPERATOR\",\"text\":\"idiv\"},{\"tag\":\"OPERATOR\",\"text\":\"mod\"},{\"tag\":\"OPERATOR\",\"text\":\"mul\"},{\"tag\":\"OPERATOR\",\"text\":\"sub\"},{\"tag\":\"OPERATOR\",\"text\":\"abs\"},{\"tag\":\"OPERATOR\",\"text\":\"ned\"},{\"tag\":\"OPERATOR\",\"text\":\"ceiling\"},{\"tag\":\"OPERATOR\",\"text\":\"floor\"},{\"tag\":\"OPERATOR\",\"text\":\"round\"},{\"tag\":\"OPERATOR\",\"text\":\"truncate\"},{\"tag\":\"OPERATOR\",\"text\":\"sqrt\"},{\"tag\":\"OPERATOR\",\"text\":\"atan\"},{\"tag\":\"OPERATOR\",\"text\":\"cos\"},{\"tag\":\"OPERATOR\",\"text\":\"sin\"},{\"tag\":\"OPERATOR\",\"text\":\"exp\"},{\"tag\":\"OPERATOR\",\"text\":\"ln\"},{\"tag\":\"OPERATOR\",\"text\":\"log\"},{\"tag\":\"OPERATOR\",\"text\":\"rand\"},{\"tag\":\"OPERATOR\",\"text\":\"srand\"},{\"tag\":\"OPERATOR\",\"text\":\"rrand\"},{\"tag\":\"LITERAL2\",\"text\":\"true\"},{\"tag\":\"LITERAL2\",\"text\":\"false\"},{\"tag\":\"LITERAL2\",\"text\":\"NULL\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"LITERAL\",\"DEFAULT\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"DELEGATE\":\"LITERAL\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"(\"},{\"tag\":\"END\",\"text\":\")\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
