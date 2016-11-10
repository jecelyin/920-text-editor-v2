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
public class RoffLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "true";
        PROPERTY1.NAME = "noTabs";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "\\\\#";
        PROPERTY2.NAME = "lineComment";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = ",+-=<>/?^&*";
        PROPERTY3.NAME = "wordBreakChars";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "FALSE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "\\#";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "\\\"";
        EOL_SPAN2.TYPE = "COMMENT1";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP1 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP1.text = "\\.\\s*\\w+";
        EOL_SPAN_REGEXP1.TYPE = "KEYWORD1";
        EOL_SPAN_REGEXP1.AT_LINE_START = "TRUE";
        EOL_SPAN_REGEXP1.DELEGATE = "ROFF_ESCAPE";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "\\\\((\\p{Graph}\\[[^\\]]*\\])|(\\p{Graph}((\\'.*\\')|(\\\".*\\\")))|(\\p{Graph}{1,2}))";
        SEQ_REGEXP1.TYPE = "KEYWORD3";
        SEQ_REGEXP1.HASH_CHAR = "\\";
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.EOL_SPAN_REGEXP = new EOL_SPAN_REGEXP[] { EOL_SPAN_REGEXP1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ROFF_ESCAPE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "\\\"";
        EOL_SPAN1.TYPE = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.HASH_CHARS = "0123456789";
        SPAN_REGEXP1.NO_LINE_BREAK = "TRUE";
        SPAN_REGEXP1.TYPE = "DIGIT";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "(\\d|\\.)+[icpPszfmnvM]?";
        END END2 = new END();
        SPAN_REGEXP1.END = new END[] { END2, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.HASH_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstwxyz";
        SPAN_REGEXP2.NO_LINE_BREAK = "TRUE";
        SPAN_REGEXP2.TYPE = "KEYWORD2";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "\\w+";
        END END3 = new END();
        SPAN_REGEXP2.END = new END[] { END3, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN3, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
