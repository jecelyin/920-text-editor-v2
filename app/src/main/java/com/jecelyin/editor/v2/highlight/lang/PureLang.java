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
public class PureLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*/\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"//\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#!\",\"NAME\":\"lineComment\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"/*\"},{\"tag\":\"END\",\"text\":\"*/\"}]},{\"tag\":\"EOL_SPAN\",\"text\":\"//\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"#!\",\"attrs\":{\"TYPE\":\"COMMENT3\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SEQ\",\"text\":\".\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"&\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"`\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"'\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"+\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"-\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"*\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"/\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"%\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"^\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"|\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"~\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"!\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"$\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\":\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"?\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\",\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"OPERATOR\",\"text\":\"or\"},{\"tag\":\"OPERATOR\",\"text\":\"and\"},{\"tag\":\"OPERATOR\",\"text\":\"div\"},{\"tag\":\"OPERATOR\",\"text\":\"mod\"},{\"tag\":\"OPERATOR\",\"text\":\"not\"},{\"tag\":\"KEYWORD1\",\"text\":\"case\"},{\"tag\":\"KEYWORD1\",\"text\":\"of\"},{\"tag\":\"KEYWORD1\",\"text\":\"when\"},{\"tag\":\"KEYWORD1\",\"text\":\"with\"},{\"tag\":\"KEYWORD1\",\"text\":\"end\"},{\"tag\":\"KEYWORD1\",\"text\":\"if\"},{\"tag\":\"KEYWORD1\",\"text\":\"then\"},{\"tag\":\"KEYWORD1\",\"text\":\"else\"},{\"tag\":\"KEYWORD1\",\"text\":\"otherwise\"},{\"tag\":\"KEYWORD1\",\"text\":\"catch\"},{\"tag\":\"KEYWORD1\",\"text\":\"throw\"},{\"tag\":\"KEYWORD1\",\"text\":\"quote\"},{\"tag\":\"KEYWORD2\",\"text\":\"bigint\"},{\"tag\":\"KEYWORD2\",\"text\":\"bool\"},{\"tag\":\"KEYWORD2\",\"text\":\"char\"},{\"tag\":\"KEYWORD2\",\"text\":\"double\"},{\"tag\":\"KEYWORD2\",\"text\":\"expr\"},{\"tag\":\"KEYWORD2\",\"text\":\"short\"},{\"tag\":\"KEYWORD2\",\"text\":\"int\"},{\"tag\":\"KEYWORD2\",\"text\":\"long\"},{\"tag\":\"KEYWORD2\",\"text\":\"string\"},{\"tag\":\"KEYWORD2\",\"text\":\"pointer\"},{\"tag\":\"KEYWORD2\",\"text\":\"matrix\"},{\"tag\":\"KEYWORD2\",\"text\":\"dmatrix\"},{\"tag\":\"KEYWORD2\",\"text\":\"cmatrix\"},{\"tag\":\"KEYWORD2\",\"text\":\"imatrix\"},{\"tag\":\"KEYWORD3\",\"text\":\"const\"},{\"tag\":\"KEYWORD3\",\"text\":\"def\"},{\"tag\":\"KEYWORD3\",\"text\":\"extern\"},{\"tag\":\"KEYWORD3\",\"text\":\"infix\"},{\"tag\":\"KEYWORD3\",\"text\":\"infixl\"},{\"tag\":\"KEYWORD3\",\"text\":\"infixr\"},{\"tag\":\"KEYWORD3\",\"text\":\"let\"},{\"tag\":\"KEYWORD3\",\"text\":\"namespace\"},{\"tag\":\"KEYWORD3\",\"text\":\"nonfix\"},{\"tag\":\"KEYWORD3\",\"text\":\"outfix\"},{\"tag\":\"KEYWORD3\",\"text\":\"private\"},{\"tag\":\"KEYWORD3\",\"text\":\"public\"},{\"tag\":\"KEYWORD3\",\"text\":\"prefix\"},{\"tag\":\"KEYWORD3\",\"text\":\"postfix\"},{\"tag\":\"KEYWORD3\",\"text\":\"using\"},{\"tag\":\"LITERAL2\",\"text\":\"true\"},{\"tag\":\"LITERAL2\",\"text\":\"false\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
