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
public class GradleLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*/\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"//\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"{\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"}\",\"NAME\":\"indentCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"\\\\s*(((if|while)\\\\s*\\\\(|else\\\\s*|else\\\\s+if\\\\s*\\\\(|for\\\\s*\\\\(.*\\\\))[^{;]*)\",\"NAME\":\"indentNextLine\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"groovy::MAIN\"}},{\"tag\":\"MARK_PREVIOUS\",\"text\":\":\",\"attrs\":{\"TYPE\":\"LABEL\",\"MATCH_TYPE\":\"OPERATOR\"}},{\"tag\":\"MARK_PREVIOUS\",\"text\":\"{\",\"attrs\":{\"TYPE\":\"FUNCTION\",\"MATCH_TYPE\":\"NULL\"}},{\"tag\":\"SEQ\",\"text\":\":\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"FUNCTION\",\"text\":\"afterEvaluate\"},{\"tag\":\"FUNCTION\",\"text\":\"afterProject\"},{\"tag\":\"FUNCTION\",\"text\":\"afterTask\"},{\"tag\":\"FUNCTION\",\"text\":\"allProjects\"},{\"tag\":\"FUNCTION\",\"text\":\"apply\"},{\"tag\":\"FUNCTION\",\"text\":\"beforeTask\"},{\"tag\":\"FUNCTION\",\"text\":\"delete\"},{\"tag\":\"FUNCTION\",\"text\":\"doFirst\"},{\"tag\":\"FUNCTION\",\"text\":\"doLast\"},{\"tag\":\"FUNCTION\",\"text\":\"exclude\"},{\"tag\":\"FUNCTION\",\"text\":\"from\"},{\"tag\":\"FUNCTION\",\"text\":\"include\"},{\"tag\":\"FUNCTION\",\"text\":\"includeFlat\"},{\"tag\":\"FUNCTION\",\"text\":\"into\"},{\"tag\":\"FUNCTION\",\"text\":\"mavenRepo\"},{\"tag\":\"FUNCTION\",\"text\":\"onlyIf\"},{\"tag\":\"FUNCTION\",\"text\":\"task\"},{\"tag\":\"FUNCTION\",\"text\":\"whenReady\"},{\"tag\":\"FUNCTION\",\"text\":\"whenTaskAdded\"},{\"tag\":\"KEYWORD1\",\"text\":\"gradle\"},{\"tag\":\"KEYWORD1\",\"text\":\"project\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
