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
public class DssslLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"<!--\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"-->\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\";\",\"NAME\":\"lineComment\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\";\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<!--\"},{\"tag\":\"END\",\"text\":\"-->\"}]},{\"tag\":\"SEQ\",\"text\":\"'(\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"'\",\"attrs\":{\"TYPE\":\"LITERAL1\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"$\"},{\"tag\":\"END\",\"text\":\"$\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"%\"},{\"tag\":\"END\",\"text\":\"%\"}]},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"LITERAL2\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"DELEGATE\":\"xml::ENTITY-TAGS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<!ENTITY\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"DELEGATE\":\"xml::CDATA\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<![CDATA[\"},{\"tag\":\"END\",\"text\":\"]]>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"DELEGATE\":\"xml::DTD-TAGS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<!\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SEQ\",\"text\":\"<=\",\"attrs\":{\"TYPE\":\"NULL\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"xml::TAGS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<\\/style-specification\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"xml::TAGS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<\\/style-sheet\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"xml::TAGS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<style-specification\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"xml::TAGS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<external-specification\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"xml::TAGS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<style-sheet\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_WORD_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"&\"},{\"tag\":\"END\",\"text\":\";\"}]},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"and\"},{\"tag\":\"KEYWORD1\",\"text\":\"cond\"},{\"tag\":\"KEYWORD1\",\"text\":\"define\"},{\"tag\":\"KEYWORD1\",\"text\":\"else\"},{\"tag\":\"KEYWORD1\",\"text\":\"lambda\"},{\"tag\":\"KEYWORD1\",\"text\":\"or\"},{\"tag\":\"KEYWORD1\",\"text\":\"quote\"},{\"tag\":\"KEYWORD1\",\"text\":\"if\"},{\"tag\":\"KEYWORD1\",\"text\":\"let\"},{\"tag\":\"KEYWORD1\",\"text\":\"let*\"},{\"tag\":\"KEYWORD1\",\"text\":\"loop\"},{\"tag\":\"KEYWORD1\",\"text\":\"not\"},{\"tag\":\"KEYWORD1\",\"text\":\"list\"},{\"tag\":\"KEYWORD1\",\"text\":\"append\"},{\"tag\":\"KEYWORD1\",\"text\":\"children\"},{\"tag\":\"KEYWORD1\",\"text\":\"normalize\"},{\"tag\":\"KEYWORD2\",\"text\":\"car\"},{\"tag\":\"KEYWORD2\",\"text\":\"cdr\"},{\"tag\":\"KEYWORD2\",\"text\":\"cons\"},{\"tag\":\"KEYWORD2\",\"text\":\"node-list-first\"},{\"tag\":\"KEYWORD2\",\"text\":\"node-list-rest\"},{\"tag\":\"KEYWORD3\",\"text\":\"eq?\"},{\"tag\":\"KEYWORD3\",\"text\":\"null?\"},{\"tag\":\"KEYWORD3\",\"text\":\"pair?\"},{\"tag\":\"KEYWORD3\",\"text\":\"zero?\"},{\"tag\":\"KEYWORD3\",\"text\":\"equal?\"},{\"tag\":\"KEYWORD3\",\"text\":\"node-list-empty?\"},{\"tag\":\"FUNCTION\",\"text\":\"external-procedure\"},{\"tag\":\"FUNCTION\",\"text\":\"root\"},{\"tag\":\"FUNCTION\",\"text\":\"make\"},{\"tag\":\"FUNCTION\",\"text\":\"process-children\"},{\"tag\":\"FUNCTION\",\"text\":\"current-node\"},{\"tag\":\"FUNCTION\",\"text\":\"node\"},{\"tag\":\"FUNCTION\",\"text\":\"empty-sosofo\"},{\"tag\":\"FUNCTION\",\"text\":\"default\"},{\"tag\":\"FUNCTION\",\"text\":\"attribute-string\"},{\"tag\":\"FUNCTION\",\"text\":\"select-elements\"},{\"tag\":\"FUNCTION\",\"text\":\"with-mode\"},{\"tag\":\"FUNCTION\",\"text\":\"literal\"},{\"tag\":\"FUNCTION\",\"text\":\"process-node-list\"},{\"tag\":\"FUNCTION\",\"text\":\"element\"},{\"tag\":\"FUNCTION\",\"text\":\"mode\"},{\"tag\":\"FUNCTION\",\"text\":\"gi\"},{\"tag\":\"FUNCTION\",\"text\":\"sosofo-append\"},{\"tag\":\"FUNCTION\",\"text\":\"sequence\"},{\"tag\":\"LABEL\",\"text\":\"attributes:\"},{\"tag\":\"LABEL\",\"text\":\"gi:\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
