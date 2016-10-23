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
public class JhtmlLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"<!--\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"-->\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"\\\\s*(<\\\\s*(droplet|oparam))\\\\s+.*\",\"NAME\":\"indentNextLines\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"NULL\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<!--#\"},{\"tag\":\"END\",\"text\":\"-->\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<!--\"},{\"tag\":\"END\",\"text\":\"-->\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"java::MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"`\"},{\"tag\":\"END\",\"text\":\"`\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"java::MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<java>\"},{\"tag\":\"END\",\"text\":\"<\\/java>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"html::JAVASCRIPT\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<SCRIPT\"},{\"tag\":\"END\",\"text\":\"<\\/SCRIPT>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"html::CSS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<STYLE\"},{\"tag\":\"END\",\"text\":\"<\\/STYLE>\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"DELEGATE\":\"xml::DTD-TAGS\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<!\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"JHTML\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<\"},{\"tag\":\"END\",\"text\":\">\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_WORD_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"&\"},{\"tag\":\"END\",\"text\":\";\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"JHTML\",\"DEFAULT\":\"MARKUP\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<!--\"},{\"tag\":\"END\",\"text\":\"-->\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"DELEGATE\":\"ATTRVALUE\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL1\",\"DELEGATE\":\"ATTRVALUE\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"SEQ\",\"text\":\"/\",\"attrs\":{\"TYPE\":\"MARKUP\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"importbean\"},{\"tag\":\"KEYWORD1\",\"text\":\"droplet\"},{\"tag\":\"KEYWORD1\",\"text\":\"param\"},{\"tag\":\"KEYWORD1\",\"text\":\"oparam\"},{\"tag\":\"KEYWORD1\",\"text\":\"valueof\"},{\"tag\":\"KEYWORD1\",\"text\":\"setvalue\"},{\"tag\":\"KEYWORD1\",\"text\":\"servlet\"},{\"tag\":\"KEYWORD2\",\"text\":\"bean\"},{\"tag\":\"KEYWORD2\",\"text\":\"submitvalue\"},{\"tag\":\"KEYWORD2\",\"text\":\"declareparam\"},{\"tag\":\"KEYWORD2\",\"text\":\"synchronized\"},{\"tag\":\"KEYWORD2\",\"text\":\"priority\"},{\"tag\":\"KEYWORD2\",\"text\":\"converter\"},{\"tag\":\"KEYWORD2\",\"text\":\"date\"},{\"tag\":\"KEYWORD2\",\"text\":\"number\"},{\"tag\":\"KEYWORD2\",\"text\":\"required\"},{\"tag\":\"KEYWORD2\",\"text\":\"nullable\"},{\"tag\":\"KEYWORD2\",\"text\":\"currency\"},{\"tag\":\"KEYWORD2\",\"text\":\"currencyConversion\"},{\"tag\":\"KEYWORD2\",\"text\":\"euro\"},{\"tag\":\"KEYWORD2\",\"text\":\"locale\"},{\"tag\":\"KEYWORD2\",\"text\":\"symbol\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"ATTRVALUE\",\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DEFAULT\":\"LITERAL1\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"java::MAIN\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"`\"},{\"tag\":\"END\",\"text\":\"`\"}]},{\"tag\":\"SEQ\",\"text\":\"param:\",\"attrs\":{\"TYPE\":\"LABEL\"}},{\"tag\":\"SEQ\",\"text\":\"bean:\",\"attrs\":{\"TYPE\":\"LABEL\"}}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
