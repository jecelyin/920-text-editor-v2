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
public class ForthLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "^:[^;]*";
        PROPERTY1.NAME = "indentNextLines";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "^.*;$";
        PROPERTY2.NAME = "unindentNextLines";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "(";
        PROPERTY3.NAME = "commentStart";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = ")";
        PROPERTY4.NAME = "commentEnd";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "|";
        PROPERTY5.NAME = "lineComment";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "+-*=><;.?/'()%,_|$";
        PROPERTY6.NAME = "noWordSep";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "|-?\\d+([./]\\d+)?";
        RULES1.IGNORE_CASE = "FALSE";
        RULES1.NO_WORD_SEP = "+-*=><;.?/'\"()%,_$";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "|";
        EOL_SPAN1.AT_WORD_START = "TRUE";
        EOL_SPAN1.TYPE = "COMMENT1";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "$";
        MARK_FOLLOWING1.AT_WORD_START = "TRUE";
        MARK_FOLLOWING1.TYPE = "DIGIT";
        MARK_FOLLOWING MARK_FOLLOWING2 = new MARK_FOLLOWING();
        MARK_FOLLOWING2.text = "'";
        MARK_FOLLOWING2.AT_WORD_START = "TRUE";
        MARK_FOLLOWING2.TYPE = "LITERAL3";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = ":\\s+(\\S+)";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "MARKUP";
        SEQ_REGEXP1.HASH_CHAR = ":";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT3";
        SPAN1.DELEGATE = "STACK_EFFECT";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "(";
        END END1 = new END();
        END1.text = ")";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.AT_WORD_START = "TRUE";
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "s\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.AT_WORD_START = "TRUE";
        SPAN3.NO_LINE_BREAK = "TRUE";
        SPAN3.TYPE = "LITERAL2";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = ".\"";
        END END3 = new END();
        END3.text = "\"";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.AT_WORD_START = "TRUE";
        SPAN4.NO_LINE_BREAK = "TRUE";
        SPAN4.TYPE = "LITERAL3";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "f\"";
        END END4 = new END();
        END4.text = "\"";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.AT_WORD_START = "TRUE";
        SPAN5.NO_LINE_BREAK = "TRUE";
        SPAN5.TYPE = "LITERAL3";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "m\"";
        END END5 = new END();
        END5.text = "\"";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN SPAN6 = new SPAN();
        SPAN6.AT_WORD_START = "TRUE";
        SPAN6.NO_LINE_BREAK = "TRUE";
        SPAN6.TYPE = "LITERAL4";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "\"";
        END END6 = new END();
        END6.text = "\"";
        SPAN6.END = new END[] { END6, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN6, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"if", "=if", "<if", ">if", "<>if", "then", "repeat", "until", "forth", "macro", });
        KEYWORDS1.add("MARKUP", new String[]{";", ";;", "0;", });
        KEYWORDS1.add("KEYWORD1", new String[]{"swap", "drop", "dup", "nip", "over", "rot", "-rot", "2dup", "2drop", "2over", "2swap", ">r", "r>", });
        KEYWORDS1.add("KEYWORD2", new String[]{"and", "or", "xor", ">>", "<<", "not", "+", "*", "negate", "-", "/", "mod", "/mod", "*/", "1+", "1-", "base", "hex", "decimal", "binary", "octal", });
        KEYWORDS1.add("KEYWORD3", new String[]{"@", "!", "c@", "c!", "+!", "cell+", "cells", "char+", "chars", });
        KEYWORDS1.add("KEYWORD4", new String[]{"[", "]", "create", "does>", "variable", "variable,", "literal", "last", "1,", "2,", "3,", ",", "here", "allot", "parse", "find", "compile", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, MARK_FOLLOWING2, };

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

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
