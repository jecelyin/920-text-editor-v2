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
import com.jecelyin.editor.v2.highlight.syntax.*;
/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class NqcLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "/*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "*/";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "//";
        PROPERTY3.NAME = "lineComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = ",+-=<>/?^&*";
        PROPERTY4.NAME = "wordBreakChars";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "{";
        PROPERTY5.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "}";
        PROPERTY6.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY7 = new PROPERTY();
        PROPERTY7.VALUE = "\\s*(((if|while)\\s*\\(|else\\s*|else\\s+if\\s*\\(|for\\s*\\(.*\\))[^{;]*)";
        PROPERTY7.NAME = "indentNextLine";
        PROPERTY PROPERTY8 = new PROPERTY();
        PROPERTY8.VALUE = "false";
        PROPERTY8.NAME = "doubleBracketIndent";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, PROPERTY8, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(0x[\\p{XDigit}]+[lL]?|[\\p{Digit}]+(e[\\p{Digit}]*)?[lLdDfF]?)";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "TRUE";
        SPAN3.TYPE = "LITERAL1";
        SPAN3.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "//";
        EOL_SPAN2.TYPE = "COMMENT2";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "!";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = ">=";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "<=";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "+";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "-";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "/";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "*";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = ">";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "<";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "%";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "&";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "|";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "^";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "~";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "}";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "{";
        SEQ17.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = ":";
        MARK_PREVIOUS1.AT_WHITESPACE_END = "TRUE";
        MARK_PREVIOUS1.TYPE = "LABEL";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = "(";
        MARK_PREVIOUS2.TYPE = "FUNCTION";
        MARK_PREVIOUS2.MATCH_TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = ")";
        SEQ18.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"true", "false", "NULL", "SENSOR_1", "SENSOR_2", "SENSOR_3", "SENSOR_TYPE_NONE", "SENSOR_TYPE_TOUCH", "SENSOR_TYPE_TEMPERATURE", "SENSOR_TYPE_LIGHT", "SENSOR_TYPE_ROTATION", "SENSOR_MODE_RAW", "SENSOR_MODE_BOOL", "SENSOR_MODE_EDGE", "SENSOR_MODE_PULSE", "SENSOR_MODE_PERCENT", "SENSOR_MODE_FAHRENHEIT", "SENSOR_MODE_CELSIUS", "SENSOR_MODE_ROTATION", "SENSOR_TOUCH", "SENSOR_LIGHT", "SENSOR_EDGE", "SENSOR_PULSE", "SENSOR_FAHRENHEIT", "SENSOR_CELSIUS", "SENSOR_ROTATION", "OUT_A", "OUT_B", "OUT_C", "OUT_OFF", "OUT_ON", "OUT_FLOAT", "OUT_FWD", "OUT_REV", "OUT_TOOGLE", "OUT_FULL", "OUT_HALF", "OUT_LOW", "SOUND_CLICK", "SOUND_DOUBLE_BEEP", "SOUND_DOWN", "SOUND_UP", "SOUND_LOW_BEEP", "SOUND_FAST_UP", "DISPLAY_WATCH", "DISPLAY_OUT_A", "DISPLAY_OUT_B", "DISPLAY_OUT_C", "DISPLAY_SENSOR_1", "DISPLAY_SENSOR_2", "DISPLAY_SENSOR_3", "TX_POWER_LO", "TX_POWER_HI", "SERIAL_COMM_DEFAULT", "SERIAL_COMM_4800", "SERIAL_COMM_DUTY25", "SERIAL_COMM_76KHZ", "SERIAL_PACKET_PREAMBLE", "SERIAL_PACKET_DEFAULT", "SERIAL_PACKET_NEGATED", "SERIAL_PACKET_CHECKSUM", "SERIAL_PACKET_RCX", "SERIAL_PACKET_", "ACQUIRE_OUT_A", "ACQUIRE_OUT_B", "ACQUIRE_OUT_C", "ACQUIRE_SOUND", "ACQUIRE_USER_1", "ACQUIRE_USER_2", "ACQUIRE_USER_3", "ACQUIRE_USER_4", "EVENT_TYPE_PRESSED", "EVENT_TYPE_RELEASED", "EVENT_TYPE_PULSE", "EVENT_TYPE_EDGE", "EVENT_TYPE_FASTCHANGE", "EVENT_TYPE_LOW", "EVENT_TYPE_NORMAL", "EVENT_TYPE_HIGH", "EVENT_TYPE_CLICK", "EVENT_TYPE_DOUBLECLICK", "EVENT_TYPE_MESSAGE", "EVENT_1_PRESSED", "EVENT_1_RELEASED", "EVENT_2_PRESSED", "EVENT_2_RELEASED", "EVENT_LIGHT_HIGH", "EVENT_LIGHT_NORMAL", "EVENT_LIGHT_LOW", "EVENT_LIGHT_CLICK", "EVENT_LIGHT_DOUBLECLICK", "EVENT_COUNTER_0", "EVENT_COUNTER_1", "EVENT_TIMER_0", "EVENT_TIMER_1", "EVENT_TIMER_2", "EVENT_MESSAGE", });
        KEYWORDS1.add("KEYWORD1", new String[]{"__event_src", "__sensor", "__type", "abs", "aquire", "catch", "const", "break", "case", "continue", "default", "do", "else", "for", "monitor", "if", "return", "repeat", "sign", "start", "stop", "sub", "switch", "task", "while", });
        KEYWORDS1.add("KEYWORD2", new String[]{"asm", "inline", });
        KEYWORDS1.add("KEYWORD3", new String[]{"int", "void", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
