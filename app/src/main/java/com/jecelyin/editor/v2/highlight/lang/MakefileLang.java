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
public class MakefileLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#\",\"NAME\":\"lineComment\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SPAN_REGEXP\",\"text\":\"\",\"attrs\":{\"TYPE\":\"FUNCTION\",\"DELEGATE\":\"MAIN\",\"HASH_CHAR\":\"$\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\\$\\\\([a-zA-Z][\\\\w-]*\"},{\"tag\":\"END\",\"text\":\")\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD2\",\"DELEGATE\":\"VARIABLE\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"$(\"},{\"tag\":\"END\",\"text\":\")\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD2\",\"DELEGATE\":\"VARIABLE\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"${\"},{\"tag\":\"END\",\"text\":\"}\"}]},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"$\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"`\"},{\"tag\":\"END\",\"text\":\"`\"}]},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\":=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"+=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"?=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"MARK_PREVIOUS\",\"text\":\":\",\"attrs\":{\"TYPE\":\"LABEL\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"subst\"},{\"tag\":\"KEYWORD1\",\"text\":\"addprefix\"},{\"tag\":\"KEYWORD1\",\"text\":\"addsuffix\"},{\"tag\":\"KEYWORD1\",\"text\":\"basename\"},{\"tag\":\"KEYWORD1\",\"text\":\"dir\"},{\"tag\":\"KEYWORD1\",\"text\":\"filter\"},{\"tag\":\"KEYWORD1\",\"text\":\"filter-out\"},{\"tag\":\"KEYWORD1\",\"text\":\"findstring\"},{\"tag\":\"KEYWORD1\",\"text\":\"firstword\"},{\"tag\":\"KEYWORD1\",\"text\":\"foreach\"},{\"tag\":\"KEYWORD1\",\"text\":\"join\"},{\"tag\":\"KEYWORD1\",\"text\":\"notdir\"},{\"tag\":\"KEYWORD1\",\"text\":\"origin\"},{\"tag\":\"KEYWORD1\",\"text\":\"patsubst\"},{\"tag\":\"KEYWORD1\",\"text\":\"shell\"},{\"tag\":\"KEYWORD1\",\"text\":\"sort\"},{\"tag\":\"KEYWORD1\",\"text\":\"strip\"},{\"tag\":\"KEYWORD1\",\"text\":\"suffix\"},{\"tag\":\"KEYWORD1\",\"text\":\"wildcard\"},{\"tag\":\"KEYWORD1\",\"text\":\"word\"},{\"tag\":\"KEYWORD1\",\"text\":\"words\"},{\"tag\":\"KEYWORD1\",\"text\":\"ifeq\"},{\"tag\":\"KEYWORD1\",\"text\":\"ifneq\"},{\"tag\":\"KEYWORD1\",\"text\":\"else\"},{\"tag\":\"KEYWORD1\",\"text\":\"endif\"},{\"tag\":\"KEYWORD1\",\"text\":\"define\"},{\"tag\":\"KEYWORD1\",\"text\":\"endef\"},{\"tag\":\"KEYWORD1\",\"text\":\"ifdef\"},{\"tag\":\"KEYWORD1\",\"text\":\"ifndef\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"VARIABLE\",\"DEFAULT\":\"KEYWORD2\",\"ESCAPE\":\"\\\\\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD2\",\"DELEGATE\":\"VARIABLE\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"$(\"},{\"tag\":\"END\",\"text\":\")\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD2\",\"DELEGATE\":\"VARIABLE\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"${\"},{\"tag\":\"END\",\"text\":\"}\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
