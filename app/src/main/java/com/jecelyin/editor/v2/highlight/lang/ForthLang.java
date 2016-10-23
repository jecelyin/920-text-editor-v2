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
public class ForthLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"^:[^;]*\",\"NAME\":\"indentNextLines\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"^.*;$\",\"NAME\":\"unindentNextLines\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"(\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\")\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"|\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"+-*=><;.?/'()%,_|$\",\"NAME\":\"noWordSep\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DIGIT_RE\":\"|-?\\\\d+([./]\\\\d+)?\",\"IGNORE_CASE\":\"FALSE\",\"NO_WORD_SEP\":\"+-*=><;.?/'\\\"()%,_$\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"|\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"COMMENT1\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"$\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"DIGIT\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"'\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"LITERAL3\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\":\\\\s+(\\\\S+)\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"MARKUP\",\"HASH_CHAR\":\":\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT3\",\"DELEGATE\":\"STACK_EFFECT\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"(\"},{\"tag\":\"END\",\"text\":\")\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"s\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\".\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL3\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"f\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL3\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"m\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"AT_WORD_START\":\"TRUE\",\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL4\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"MARKUP\",\"text\":\";\"},{\"tag\":\"MARKUP\",\"text\":\";;\"},{\"tag\":\"MARKUP\",\"text\":\"0;\"},{\"tag\":\"KEYWORD1\",\"text\":\"swap\"},{\"tag\":\"KEYWORD1\",\"text\":\"drop\"},{\"tag\":\"KEYWORD1\",\"text\":\"dup\"},{\"tag\":\"KEYWORD1\",\"text\":\"nip\"},{\"tag\":\"KEYWORD1\",\"text\":\"over\"},{\"tag\":\"KEYWORD1\",\"text\":\"rot\"},{\"tag\":\"KEYWORD1\",\"text\":\"-rot\"},{\"tag\":\"KEYWORD1\",\"text\":\"2dup\"},{\"tag\":\"KEYWORD1\",\"text\":\"2drop\"},{\"tag\":\"KEYWORD1\",\"text\":\"2over\"},{\"tag\":\"KEYWORD1\",\"text\":\"2swap\"},{\"tag\":\"KEYWORD1\",\"text\":\">r\"},{\"tag\":\"KEYWORD1\",\"text\":\"r>\"},{\"tag\":\"KEYWORD2\",\"text\":\"and\"},{\"tag\":\"KEYWORD2\",\"text\":\"or\"},{\"tag\":\"KEYWORD2\",\"text\":\"xor\"},{\"tag\":\"KEYWORD2\",\"text\":\">>\"},{\"tag\":\"KEYWORD2\",\"text\":\"<<\"},{\"tag\":\"KEYWORD2\",\"text\":\"not\"},{\"tag\":\"KEYWORD2\",\"text\":\"+\"},{\"tag\":\"KEYWORD2\",\"text\":\"*\"},{\"tag\":\"KEYWORD2\",\"text\":\"negate\"},{\"tag\":\"KEYWORD2\",\"text\":\"-\"},{\"tag\":\"KEYWORD2\",\"text\":\"/\"},{\"tag\":\"KEYWORD2\",\"text\":\"mod\"},{\"tag\":\"KEYWORD2\",\"text\":\"/mod\"},{\"tag\":\"KEYWORD2\",\"text\":\"*/\"},{\"tag\":\"KEYWORD2\",\"text\":\"1+\"},{\"tag\":\"KEYWORD2\",\"text\":\"1-\"},{\"tag\":\"KEYWORD2\",\"text\":\"base\"},{\"tag\":\"KEYWORD2\",\"text\":\"hex\"},{\"tag\":\"KEYWORD2\",\"text\":\"decimal\"},{\"tag\":\"KEYWORD2\",\"text\":\"binary\"},{\"tag\":\"KEYWORD2\",\"text\":\"octal\"},{\"tag\":\"KEYWORD3\",\"text\":\"@\"},{\"tag\":\"KEYWORD3\",\"text\":\"!\"},{\"tag\":\"KEYWORD3\",\"text\":\"c@\"},{\"tag\":\"KEYWORD3\",\"text\":\"c!\"},{\"tag\":\"KEYWORD3\",\"text\":\"+!\"},{\"tag\":\"KEYWORD3\",\"text\":\"cell+\"},{\"tag\":\"KEYWORD3\",\"text\":\"cells\"},{\"tag\":\"KEYWORD3\",\"text\":\"char+\"},{\"tag\":\"KEYWORD3\",\"text\":\"chars\"},{\"tag\":\"KEYWORD4\",\"text\":\"[\"},{\"tag\":\"KEYWORD4\",\"text\":\"]\"},{\"tag\":\"KEYWORD4\",\"text\":\"create\"},{\"tag\":\"KEYWORD4\",\"text\":\"does>\"},{\"tag\":\"KEYWORD4\",\"text\":\"variable\"},{\"tag\":\"KEYWORD4\",\"text\":\"variable,\"},{\"tag\":\"KEYWORD4\",\"text\":\"literal\"},{\"tag\":\"KEYWORD4\",\"text\":\"last\"},{\"tag\":\"KEYWORD4\",\"text\":\"1,\"},{\"tag\":\"KEYWORD4\",\"text\":\"2,\"},{\"tag\":\"KEYWORD4\",\"text\":\"3,\"},{\"tag\":\"KEYWORD4\",\"text\":\",\"},{\"tag\":\"KEYWORD4\",\"text\":\"here\"},{\"tag\":\"KEYWORD4\",\"text\":\"allot\"},{\"tag\":\"KEYWORD4\",\"text\":\"parse\"},{\"tag\":\"KEYWORD4\",\"text\":\"find\"},{\"tag\":\"KEYWORD4\",\"text\":\"compile\"},{\"tag\":\"OPERATOR\",\"text\":\"if\"},{\"tag\":\"OPERATOR\",\"text\":\"=if\"},{\"tag\":\"OPERATOR\",\"text\":\"<if\"},{\"tag\":\"OPERATOR\",\"text\":\">if\"},{\"tag\":\"OPERATOR\",\"text\":\"<>if\"},{\"tag\":\"OPERATOR\",\"text\":\"then\"},{\"tag\":\"OPERATOR\",\"text\":\"repeat\"},{\"tag\":\"OPERATOR\",\"text\":\"until\"},{\"tag\":\"OPERATOR\",\"text\":\"forth\"},{\"tag\":\"OPERATOR\",\"text\":\"macro\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"STACK_EFFECT\",\"DEFAULT\":\"COMMENT4\"},\"child\":[{\"tag\":\"SEQ\",\"text\":\"--\",\"attrs\":{\"TYPE\":\"COMMENT3\"}}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
