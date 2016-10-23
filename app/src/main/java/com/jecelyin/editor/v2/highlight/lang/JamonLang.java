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
public class JamonLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"<%--\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"--%>\",\"NAME\":\"commentEnd\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"DEFAULT\":\"LITERAL2\"},\"child\":[{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"INLINE\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"OVERRIDES\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"html::MAIN\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"INLINE\",\"DEFAULT\":\"LITERAL2\"},\"child\":[{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"DELEGATE\":\"java::MAIN\",\"MATCH_TYPE\":\"OPERATOR\",\"HASH_CHAR\":\"<\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%(args|class|import|java|xargs)>\"},{\"tag\":\"END\",\"text\":\"<\\/%$1>\"}]},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"DELEGATE\":\"java::MAIN\",\"MATCH_TYPE\":\"OPERATOR\",\"HASH_CHAR\":\"<\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%(?:if|for|java)\"},{\"tag\":\"END\",\"text\":\"%>\"}]},{\"tag\":\"SEQ_REGEXP\",\"text\":\"<\\/%(?:if|for)>\",\"attrs\":{\"TYPE\":\"OPERATOR\",\"HASH_CHAR\":\"<\"}},{\"tag\":\"SEQ\",\"text\":\"<%else>\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"MATCH_TYPE\":\"OPERATOR\",\"HASH_CHAR\":\"<\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%(?:abstract|def|doc|escape|extends|frag|method|override)\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"MATCH_TYPE\":\"OPERATOR\",\"HASH_CHAR\":\"<\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<\\/%(?:def|doc|frag|method|override)\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"OPERATOR\",\"DELEGATE\":\"java::MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%\"},{\"tag\":\"END\",\"text\":\"%>\"}]},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"DELEGATE\":\"java::MAIN\",\"MATCH_TYPE\":\"OPERATOR\",\"HASH_CHAR\":\"<\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<&\\\\|?\"},{\"tag\":\"END\",\"text\":\"&>\"}]},{\"tag\":\"SEQ\",\"text\":\"<\\/&>\",\"attrs\":{\"TYPE\":\"OPERATOR\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"OVERRIDES\",\"DEFAULT\":\"LITERAL2\",\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"CSS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<style\"},{\"tag\":\"END\",\"text\":\"<\\/style>\"}]},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"JAVASCRIPT\",\"HASH_CHAR\":\"<\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<(?i)(script)\"},{\"tag\":\"END\",\"text\":\"<\\/$1>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"TAGS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<\"},{\"tag\":\"END\",\"text\":\">\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"JAVASCRIPT\",\"DEFAULT\":\"LITERAL1\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"DELEGATE\":\"INLINE\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"INLINE\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"javascript::MAIN\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"CSS\",\"DEFAULT\":\"LITERAL1\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"DELEGATE\":\"INLINE\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"INLINE\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"css::MAIN\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"INLINE_MARKUP\",\"DEFAULT\":\"LITERAL1\"},\"child\":[{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"MATCH_TYPE\":\"OPERATOR\",\"HASH_CHAR\":\"<\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%(?:abstract|def|doc|escape|extends|frag|method|override)\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"MATCH_TYPE\":\"OPERATOR\",\"HASH_CHAR\":\"<\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<\\/%(?:def|doc|frag|method|override)\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"OPERATOR\",\"DELEGATE\":\"java::MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<%\"},{\"tag\":\"END\",\"text\":\"%>\"}]},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"DELEGATE\":\"java::MAIN\",\"MATCH_TYPE\":\"OPERATOR\",\"HASH_CHAR\":\"<\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<&\\\\|?\"},{\"tag\":\"END\",\"text\":\"&>\"}]},{\"tag\":\"SEQ\",\"text\":\"<\\/&>\",\"attrs\":{\"TYPE\":\"OPERATOR\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"TAGS\",\"DEFAULT\":\"MARKUP\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"DELEGATE\":\"INLINE_MARKUP\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"INLINE_MARKUP\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"html::TAGS\"}}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
