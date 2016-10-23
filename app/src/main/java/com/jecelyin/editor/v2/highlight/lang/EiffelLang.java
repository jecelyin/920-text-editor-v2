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
public class EiffelLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"--\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"contextInsensitive\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"--\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\",\"ESCAPE\":\"\\\\\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"'\"},{\"tag\":\"END\",\"text\":\"'\"}]},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"alias\"},{\"tag\":\"KEYWORD1\",\"text\":\"all\"},{\"tag\":\"KEYWORD1\",\"text\":\"and\"},{\"tag\":\"KEYWORD1\",\"text\":\"as\"},{\"tag\":\"KEYWORD1\",\"text\":\"check\"},{\"tag\":\"KEYWORD1\",\"text\":\"class\"},{\"tag\":\"KEYWORD1\",\"text\":\"creation\"},{\"tag\":\"KEYWORD1\",\"text\":\"debug\"},{\"tag\":\"KEYWORD1\",\"text\":\"deferred\"},{\"tag\":\"KEYWORD1\",\"text\":\"do\"},{\"tag\":\"KEYWORD1\",\"text\":\"else\"},{\"tag\":\"KEYWORD1\",\"text\":\"elseif\"},{\"tag\":\"KEYWORD1\",\"text\":\"end\"},{\"tag\":\"KEYWORD1\",\"text\":\"ensure\"},{\"tag\":\"KEYWORD1\",\"text\":\"expanded\"},{\"tag\":\"KEYWORD1\",\"text\":\"export\"},{\"tag\":\"KEYWORD1\",\"text\":\"external\"},{\"tag\":\"KEYWORD1\",\"text\":\"feature\"},{\"tag\":\"KEYWORD1\",\"text\":\"from\"},{\"tag\":\"KEYWORD1\",\"text\":\"frozen\"},{\"tag\":\"KEYWORD1\",\"text\":\"if\"},{\"tag\":\"KEYWORD1\",\"text\":\"implies\"},{\"tag\":\"KEYWORD1\",\"text\":\"indexing\"},{\"tag\":\"KEYWORD1\",\"text\":\"infix\"},{\"tag\":\"KEYWORD1\",\"text\":\"inherit\"},{\"tag\":\"KEYWORD1\",\"text\":\"inspect\"},{\"tag\":\"KEYWORD1\",\"text\":\"invariant\"},{\"tag\":\"KEYWORD1\",\"text\":\"is\"},{\"tag\":\"KEYWORD1\",\"text\":\"like\"},{\"tag\":\"KEYWORD1\",\"text\":\"local\"},{\"tag\":\"KEYWORD1\",\"text\":\"loop\"},{\"tag\":\"KEYWORD1\",\"text\":\"not\"},{\"tag\":\"KEYWORD1\",\"text\":\"obsolete\"},{\"tag\":\"KEYWORD1\",\"text\":\"old\"},{\"tag\":\"KEYWORD1\",\"text\":\"once\"},{\"tag\":\"KEYWORD1\",\"text\":\"or\"},{\"tag\":\"KEYWORD1\",\"text\":\"prefix\"},{\"tag\":\"KEYWORD1\",\"text\":\"redefine\"},{\"tag\":\"KEYWORD1\",\"text\":\"rename\"},{\"tag\":\"KEYWORD1\",\"text\":\"require\"},{\"tag\":\"KEYWORD1\",\"text\":\"rescue\"},{\"tag\":\"KEYWORD1\",\"text\":\"retry\"},{\"tag\":\"KEYWORD1\",\"text\":\"select\"},{\"tag\":\"KEYWORD1\",\"text\":\"separate\"},{\"tag\":\"KEYWORD1\",\"text\":\"then\"},{\"tag\":\"KEYWORD1\",\"text\":\"undefine\"},{\"tag\":\"KEYWORD1\",\"text\":\"until\"},{\"tag\":\"KEYWORD1\",\"text\":\"variant\"},{\"tag\":\"KEYWORD1\",\"text\":\"when\"},{\"tag\":\"KEYWORD1\",\"text\":\"xor\"},{\"tag\":\"LITERAL2\",\"text\":\"current\"},{\"tag\":\"LITERAL2\",\"text\":\"false\"},{\"tag\":\"LITERAL2\",\"text\":\"precursor\"},{\"tag\":\"LITERAL2\",\"text\":\"result\"},{\"tag\":\"LITERAL2\",\"text\":\"strip\"},{\"tag\":\"LITERAL2\",\"text\":\"true\"},{\"tag\":\"LITERAL2\",\"text\":\"unique\"},{\"tag\":\"LITERAL2\",\"text\":\"void\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
