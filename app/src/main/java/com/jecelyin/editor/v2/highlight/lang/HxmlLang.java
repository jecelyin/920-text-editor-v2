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
public class HxmlLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"contextInsensitive\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"attrs\":{\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"--next\"},{\"tag\":\"KEYWORD1\",\"text\":\"-cpp\"},{\"tag\":\"KEYWORD1\",\"text\":\"-js\"},{\"tag\":\"KEYWORD1\",\"text\":\"-as3\"},{\"tag\":\"KEYWORD1\",\"text\":\"-swf\"},{\"tag\":\"KEYWORD1\",\"text\":\"-swf9\"},{\"tag\":\"KEYWORD1\",\"text\":\"-neko\"},{\"tag\":\"KEYWORD1\",\"text\":\"-php\"},{\"tag\":\"KEYWORD1\",\"text\":\"-xml\"},{\"tag\":\"KEYWORD2\",\"text\":\"-cp\"},{\"tag\":\"KEYWORD2\",\"text\":\"-main\"},{\"tag\":\"KEYWORD2\",\"text\":\"-lib\"},{\"tag\":\"KEYWORD2\",\"text\":\"-D\"},{\"tag\":\"KEYWORD2\",\"text\":\"-v\"},{\"tag\":\"KEYWORD2\",\"text\":\"-debug\"},{\"tag\":\"KEYWORD2\",\"text\":\"-swf-version\"},{\"tag\":\"KEYWORD2\",\"text\":\"-swf-header\"},{\"tag\":\"KEYWORD2\",\"text\":\"-swf-lib\"},{\"tag\":\"KEYWORD2\",\"text\":\"-x\"},{\"tag\":\"KEYWORD2\",\"text\":\"-resource\"},{\"tag\":\"KEYWORD2\",\"text\":\"-exclude\"},{\"tag\":\"KEYWORD2\",\"text\":\"-prompt\"},{\"tag\":\"KEYWORD2\",\"text\":\"-cmd\"},{\"tag\":\"KEYWORD3\",\"text\":\"--flash-strict\"},{\"tag\":\"KEYWORD3\",\"text\":\"--no-traces\"},{\"tag\":\"KEYWORD3\",\"text\":\"--flash-use-stage\"},{\"tag\":\"KEYWORD3\",\"text\":\"--neko-source\"},{\"tag\":\"KEYWORD3\",\"text\":\"--gen-hx-classes\"},{\"tag\":\"KEYWORD3\",\"text\":\"--display\"},{\"tag\":\"KEYWORD3\",\"text\":\"--no-output\"},{\"tag\":\"KEYWORD3\",\"text\":\"--times\"},{\"tag\":\"KEYWORD3\",\"text\":\"--no-inline\"},{\"tag\":\"KEYWORD3\",\"text\":\"--no-opt\"},{\"tag\":\"KEYWORD3\",\"text\":\"--php-front\"},{\"tag\":\"KEYWORD3\",\"text\":\"--js-namespace\"},{\"tag\":\"KEYWORD3\",\"text\":\"--remap\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
