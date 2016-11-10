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
public class FactorLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "[{";
        PROPERTY1.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "]}";
        PROPERTY2.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "^(:|M:|C:|PREDICATE:)[^;]*";
        PROPERTY3.NAME = "indentNextLines";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "^.*;.*$";
        PROPERTY4.NAME = "unindentNextLines";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "true";
        PROPERTY5.NAME = "doubleBracketIndent";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "(";
        PROPERTY6.NAME = "commentStart";
        PROPERTY PROPERTY7 = new PROPERTY();
        PROPERTY7.VALUE = ")";
        PROPERTY7.NAME = "commentEnd";
        PROPERTY PROPERTY8 = new PROPERTY();
        PROPERTY8.VALUE = "!";
        PROPERTY8.NAME = "lineComment";
        PROPERTY PROPERTY9 = new PROPERTY();
        PROPERTY9.VALUE = "+-*=><;.?/'()%,_|";
        PROPERTY9.NAME = "noWordSep";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, PROPERTY8, PROPERTY9, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "-?\\d+([./]\\d+)?";
        RULES1.IGNORE_CASE = "FALSE";
        RULES1.NO_WORD_SEP = "+-*=><;.?/'()%,_";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#!";
        EOL_SPAN1.AT_WORD_START = "TRUE";
        EOL_SPAN1.TYPE = "COMMENT2";
        EOL_SPAN1.DELEGATE = "COMMENT";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "!";
        EOL_SPAN2.AT_WORD_START = "TRUE";
        EOL_SPAN2.TYPE = "COMMENT1";
        EOL_SPAN2.DELEGATE = "COMMENT";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "\\\\\\s+(\\S+)";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "MARKUP";
        SEQ_REGEXP1.HASH_CHAR = "\\";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = ":\\s+(\\S+)";
        SEQ_REGEXP2.AT_WORD_START = "TRUE";
        SEQ_REGEXP2.TYPE = "MARKUP";
        SEQ_REGEXP2.HASH_CHAR = ":";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "IN:\\s+(\\S+)";
        SEQ_REGEXP3.AT_WORD_START = "TRUE";
        SEQ_REGEXP3.TYPE = "MARKUP";
        SEQ_REGEXP3.HASH_CHAR = "IN:";
        SEQ_REGEXP SEQ_REGEXP4 = new SEQ_REGEXP();
        SEQ_REGEXP4.text = "USE:\\s+(\\S+)";
        SEQ_REGEXP4.AT_WORD_START = "TRUE";
        SEQ_REGEXP4.TYPE = "MARKUP";
        SEQ_REGEXP4.HASH_CHAR = "USE:";
        SEQ_REGEXP SEQ_REGEXP5 = new SEQ_REGEXP();
        SEQ_REGEXP5.text = "CHAR:\\s+(\\S+)";
        SEQ_REGEXP5.AT_WORD_START = "TRUE";
        SEQ_REGEXP5.TYPE = "LITERAL2";
        SEQ_REGEXP5.HASH_CHAR = "CHAR:";
        SEQ_REGEXP SEQ_REGEXP6 = new SEQ_REGEXP();
        SEQ_REGEXP6.text = "BIN:\\s+(\\S+)";
        SEQ_REGEXP6.AT_WORD_START = "TRUE";
        SEQ_REGEXP6.TYPE = "LITERAL2";
        SEQ_REGEXP6.HASH_CHAR = "BIN:";
        SEQ_REGEXP SEQ_REGEXP7 = new SEQ_REGEXP();
        SEQ_REGEXP7.text = "OCT:\\s+(\\S+)";
        SEQ_REGEXP7.AT_WORD_START = "TRUE";
        SEQ_REGEXP7.TYPE = "LITERAL2";
        SEQ_REGEXP7.HASH_CHAR = "OCT:";
        SEQ_REGEXP SEQ_REGEXP8 = new SEQ_REGEXP();
        SEQ_REGEXP8.text = "HEX:\\s+(\\S+)";
        SEQ_REGEXP8.AT_WORD_START = "TRUE";
        SEQ_REGEXP8.TYPE = "LITERAL2";
        SEQ_REGEXP8.HASH_CHAR = "HEX:";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "COMMENT3";
        SPAN1.DELEGATE = "STACK_EFFECT";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\\s+(";
        END END1 = new END();
        END1.text = ")";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        SPAN2.DELEGATE = "LITERAL";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "SBUF\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "TRUE";
        SPAN3.TYPE = "LITERAL1";
        SPAN3.DELEGATE = "LITERAL";
        SPAN3.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "\"";
        END END3 = new END();
        END3.text = "\"";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "MARKUP";
        SPAN4.DELEGATE = "USING";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "USING:";
        END END4 = new END();
        END4.text = ";";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "[";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "]";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "{";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "}";
        SEQ4.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("MARKUP", new String[]{";", });
        KEYWORDS1.add("KEYWORD1", new String[]{">r", "r>", });
        KEYWORDS1.add("LITERAL4", new String[]{"f", });
        KEYWORDS1.add("LITERAL3", new String[]{"t", });
        KEYWORDS1.add("COMMENT2", new String[]{"#!", });
        KEYWORDS1.add("COMMENT1", new String[]{"!", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, SEQ_REGEXP4, SEQ_REGEXP5, SEQ_REGEXP6, SEQ_REGEXP7, SEQ_REGEXP8, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "STACK_EFFECT";
        RULES1.DEFAULT = "COMMENT4";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "--";
        SEQ1.TYPE = "COMMENT3";
        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "LITERAL";
        RULES1.DEFAULT = "LITERAL1";
        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "COMMENT";
        RULES1.DEFAULT = "COMMENT1";
        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "USING";
        RULES1.DEFAULT = "LITERAL2";
        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
