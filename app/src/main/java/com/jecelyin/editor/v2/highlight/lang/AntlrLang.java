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
public class AntlrLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*/\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"//\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"\",\"NAME\":\"wordBreakChars\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT2\",\"DELEGATE\":\"java::JAVADOC\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"/**\"},{\"tag\":\"END\",\"text\":\"*/\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"/*\"},{\"tag\":\"END\",\"text\":\"*/\"}]},{\"tag\":\"EOL_SPAN\",\"text\":\"//\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"SEQ\",\"text\":\"|\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\":\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD3\",\"text\":\"header\"},{\"tag\":\"KEYWORD3\",\"text\":\"options\"},{\"tag\":\"KEYWORD3\",\"text\":\"tokens\"},{\"tag\":\"KEYWORD1\",\"text\":\"abstract\"},{\"tag\":\"KEYWORD1\",\"text\":\"break\"},{\"tag\":\"KEYWORD1\",\"text\":\"case\"},{\"tag\":\"KEYWORD1\",\"text\":\"catch\"},{\"tag\":\"KEYWORD1\",\"text\":\"continue\"},{\"tag\":\"KEYWORD1\",\"text\":\"default\"},{\"tag\":\"KEYWORD1\",\"text\":\"do\"},{\"tag\":\"KEYWORD1\",\"text\":\"else\"},{\"tag\":\"KEYWORD1\",\"text\":\"extends\"},{\"tag\":\"KEYWORD1\",\"text\":\"final\"},{\"tag\":\"KEYWORD1\",\"text\":\"finally\"},{\"tag\":\"KEYWORD1\",\"text\":\"for\"},{\"tag\":\"KEYWORD1\",\"text\":\"if\"},{\"tag\":\"KEYWORD1\",\"text\":\"implements\"},{\"tag\":\"KEYWORD1\",\"text\":\"instanceof\"},{\"tag\":\"KEYWORD1\",\"text\":\"native\"},{\"tag\":\"KEYWORD1\",\"text\":\"new\"},{\"tag\":\"KEYWORD1\",\"text\":\"private\"},{\"tag\":\"KEYWORD1\",\"text\":\"protected\"},{\"tag\":\"KEYWORD1\",\"text\":\"public\"},{\"tag\":\"KEYWORD1\",\"text\":\"return\"},{\"tag\":\"KEYWORD1\",\"text\":\"static\"},{\"tag\":\"KEYWORD1\",\"text\":\"switch\"},{\"tag\":\"KEYWORD1\",\"text\":\"synchronized\"},{\"tag\":\"KEYWORD1\",\"text\":\"throw\"},{\"tag\":\"KEYWORD1\",\"text\":\"throws\"},{\"tag\":\"KEYWORD1\",\"text\":\"transient\"},{\"tag\":\"KEYWORD1\",\"text\":\"try\"},{\"tag\":\"KEYWORD1\",\"text\":\"volatile\"},{\"tag\":\"KEYWORD1\",\"text\":\"while\"},{\"tag\":\"KEYWORD1\",\"text\":\"package\"},{\"tag\":\"KEYWORD1\",\"text\":\"import\"},{\"tag\":\"KEYWORD2\",\"text\":\"boolean\"},{\"tag\":\"KEYWORD2\",\"text\":\"byte\"},{\"tag\":\"KEYWORD2\",\"text\":\"char\"},{\"tag\":\"KEYWORD2\",\"text\":\"class\"},{\"tag\":\"KEYWORD2\",\"text\":\"double\"},{\"tag\":\"KEYWORD2\",\"text\":\"float\"},{\"tag\":\"KEYWORD2\",\"text\":\"int\"},{\"tag\":\"KEYWORD2\",\"text\":\"interface\"},{\"tag\":\"KEYWORD2\",\"text\":\"long\"},{\"tag\":\"KEYWORD2\",\"text\":\"short\"},{\"tag\":\"KEYWORD2\",\"text\":\"void\"},{\"tag\":\"FUNCTION\",\"text\":\"assert\"},{\"tag\":\"KEYWORD1\",\"text\":\"strictfp\"},{\"tag\":\"LITERAL2\",\"text\":\"false\"},{\"tag\":\"LITERAL2\",\"text\":\"null\"},{\"tag\":\"LITERAL2\",\"text\":\"super\"},{\"tag\":\"LITERAL2\",\"text\":\"this\"},{\"tag\":\"LITERAL2\",\"text\":\"true\"},{\"tag\":\"INVALID\",\"text\":\"goto\"},{\"tag\":\"INVALID\",\"text\":\"const\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
