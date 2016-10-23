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
public class AssemblyParrotLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"contextInsensitive\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DIGIT_RE\":\"(0x[\\\\p{XDigit}]+|[\\\\p{Digit}]+)\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"MARK_PREVIOUS\",\"text\":\":\",\"attrs\":{\"TYPE\":\"LABEL\",\"AT_LINE_START\":\"TRUE\",\"MATCH_TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\",\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"[ISNP]\\\\d{1,2}\",\"attrs\":{\"HASH_CHARS\":\"ISNP\",\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"LITERAL2\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"abs\"},{\"tag\":\"KEYWORD1\",\"text\":\"acos\"},{\"tag\":\"KEYWORD1\",\"text\":\"add\"},{\"tag\":\"KEYWORD1\",\"text\":\"and\"},{\"tag\":\"KEYWORD1\",\"text\":\"asec\"},{\"tag\":\"KEYWORD1\",\"text\":\"asin\"},{\"tag\":\"KEYWORD1\",\"text\":\"atan\"},{\"tag\":\"KEYWORD1\",\"text\":\"bounds\"},{\"tag\":\"KEYWORD1\",\"text\":\"branch\"},{\"tag\":\"KEYWORD1\",\"text\":\"bsr\"},{\"tag\":\"KEYWORD1\",\"text\":\"chopm\"},{\"tag\":\"KEYWORD1\",\"text\":\"cleari\"},{\"tag\":\"KEYWORD1\",\"text\":\"clearn\"},{\"tag\":\"KEYWORD1\",\"text\":\"clearp\"},{\"tag\":\"KEYWORD1\",\"text\":\"clears\"},{\"tag\":\"KEYWORD1\",\"text\":\"clone\"},{\"tag\":\"KEYWORD1\",\"text\":\"close\"},{\"tag\":\"KEYWORD1\",\"text\":\"cmod\"},{\"tag\":\"KEYWORD1\",\"text\":\"concat\"},{\"tag\":\"KEYWORD1\",\"text\":\"cos\"},{\"tag\":\"KEYWORD1\",\"text\":\"cosh\"},{\"tag\":\"KEYWORD1\",\"text\":\"debug\"},{\"tag\":\"KEYWORD1\",\"text\":\"dec\"},{\"tag\":\"KEYWORD1\",\"text\":\"div\"},{\"tag\":\"KEYWORD1\",\"text\":\"end\"},{\"tag\":\"KEYWORD1\",\"text\":\"entrytype\"},{\"tag\":\"KEYWORD1\",\"text\":\"eq\"},{\"tag\":\"KEYWORD1\",\"text\":\"err\"},{\"tag\":\"KEYWORD1\",\"text\":\"exp\"},{\"tag\":\"KEYWORD1\",\"text\":\"find_global\"},{\"tag\":\"KEYWORD1\",\"text\":\"find_type\"},{\"tag\":\"KEYWORD1\",\"text\":\"ge\"},{\"tag\":\"KEYWORD1\",\"text\":\"getfile\"},{\"tag\":\"KEYWORD1\",\"text\":\"getline\"},{\"tag\":\"KEYWORD1\",\"text\":\"getpackage\"},{\"tag\":\"KEYWORD1\",\"text\":\"gt\"},{\"tag\":\"KEYWORD1\",\"text\":\"if\"},{\"tag\":\"KEYWORD1\",\"text\":\"inc\"},{\"tag\":\"KEYWORD1\",\"text\":\"index\"},{\"tag\":\"KEYWORD1\",\"text\":\"jsr\"},{\"tag\":\"KEYWORD1\",\"text\":\"jump\"},{\"tag\":\"KEYWORD1\",\"text\":\"le\"},{\"tag\":\"KEYWORD1\",\"text\":\"length\"},{\"tag\":\"KEYWORD1\",\"text\":\"ln\"},{\"tag\":\"KEYWORD1\",\"text\":\"log2\"},{\"tag\":\"KEYWORD1\",\"text\":\"log10\"},{\"tag\":\"KEYWORD1\",\"text\":\"lt\"},{\"tag\":\"KEYWORD1\",\"text\":\"mod\"},{\"tag\":\"KEYWORD1\",\"text\":\"mul\"},{\"tag\":\"KEYWORD1\",\"text\":\"ne\"},{\"tag\":\"KEYWORD1\",\"text\":\"new\"},{\"tag\":\"KEYWORD1\",\"text\":\"newinterp\"},{\"tag\":\"KEYWORD1\",\"text\":\"noop\"},{\"tag\":\"KEYWORD1\",\"text\":\"not\"},{\"tag\":\"KEYWORD1\",\"text\":\"not\"},{\"tag\":\"KEYWORD1\",\"text\":\"open\"},{\"tag\":\"KEYWORD1\",\"text\":\"or\"},{\"tag\":\"KEYWORD1\",\"text\":\"ord\"},{\"tag\":\"KEYWORD1\",\"text\":\"pack\"},{\"tag\":\"KEYWORD1\",\"text\":\"pop\"},{\"tag\":\"KEYWORD1\",\"text\":\"popi\"},{\"tag\":\"KEYWORD1\",\"text\":\"popn\"},{\"tag\":\"KEYWORD1\",\"text\":\"popp\"},{\"tag\":\"KEYWORD1\",\"text\":\"pops\"},{\"tag\":\"KEYWORD1\",\"text\":\"pow\"},{\"tag\":\"KEYWORD1\",\"text\":\"print\"},{\"tag\":\"KEYWORD1\",\"text\":\"profile\"},{\"tag\":\"KEYWORD1\",\"text\":\"push\"},{\"tag\":\"KEYWORD1\",\"text\":\"pushi\"},{\"tag\":\"KEYWORD1\",\"text\":\"pushn\"},{\"tag\":\"KEYWORD1\",\"text\":\"pushp\"},{\"tag\":\"KEYWORD1\",\"text\":\"pushs\"},{\"tag\":\"KEYWORD1\",\"text\":\"read\"},{\"tag\":\"KEYWORD1\",\"text\":\"readline\"},{\"tag\":\"KEYWORD1\",\"text\":\"repeat\"},{\"tag\":\"KEYWORD1\",\"text\":\"restore\"},{\"tag\":\"KEYWORD1\",\"text\":\"ret\"},{\"tag\":\"KEYWORD1\",\"text\":\"rotate_up\"},{\"tag\":\"KEYWORD1\",\"text\":\"runinterp\"},{\"tag\":\"KEYWORD1\",\"text\":\"save\"},{\"tag\":\"KEYWORD1\",\"text\":\"sec\"},{\"tag\":\"KEYWORD1\",\"text\":\"sech\"},{\"tag\":\"KEYWORD1\",\"text\":\"set\"},{\"tag\":\"KEYWORD1\",\"text\":\"set_keyed\"},{\"tag\":\"KEYWORD1\",\"text\":\"setfile\"},{\"tag\":\"KEYWORD1\",\"text\":\"setline\"},{\"tag\":\"KEYWORD1\",\"text\":\"setpackage\"},{\"tag\":\"KEYWORD1\",\"text\":\"shl\"},{\"tag\":\"KEYWORD1\",\"text\":\"shr\"},{\"tag\":\"KEYWORD1\",\"text\":\"sin\"},{\"tag\":\"KEYWORD1\",\"text\":\"sinh\"},{\"tag\":\"KEYWORD1\",\"text\":\"sleep\"},{\"tag\":\"KEYWORD1\",\"text\":\"sub\"},{\"tag\":\"KEYWORD1\",\"text\":\"substr\"},{\"tag\":\"KEYWORD1\",\"text\":\"tan\"},{\"tag\":\"KEYWORD1\",\"text\":\"tanh\"},{\"tag\":\"KEYWORD1\",\"text\":\"time\"},{\"tag\":\"KEYWORD1\",\"text\":\"trace\"},{\"tag\":\"KEYWORD1\",\"text\":\"typeof\"},{\"tag\":\"KEYWORD1\",\"text\":\"unless\"},{\"tag\":\"KEYWORD1\",\"text\":\"warningsoff\"},{\"tag\":\"KEYWORD1\",\"text\":\"warningson\"},{\"tag\":\"KEYWORD1\",\"text\":\"write\"},{\"tag\":\"KEYWORD1\",\"text\":\"xor\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
