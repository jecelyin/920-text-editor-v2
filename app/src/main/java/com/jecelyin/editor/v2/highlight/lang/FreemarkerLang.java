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
public class FreemarkerLang implements LangDefine {
        private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "html::JAVASCRIPT";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<script";
        END END1 = new END();
        END1.text = "</script>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "MARKUP";
        SPAN2.DELEGATE = "html::JAVASCRIPT";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<Script";
        END END2 = new END();
        END2.text = "</Script>";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "MARKUP";
        SPAN3.DELEGATE = "html::JAVASCRIPT";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<SCRIPT";
        END END3 = new END();
        END3.text = "</SCRIPT>";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "MARKUP";
        SPAN4.DELEGATE = "html::CSS";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "<style";
        END END4 = new END();
        END4.text = "</style>";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "MARKUP";
        SPAN5.DELEGATE = "html::CSS";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "<Style";
        END END5 = new END();
        END5.text = "</Style>";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN SPAN6 = new SPAN();
        SPAN6.TYPE = "MARKUP";
        SPAN6.DELEGATE = "html::CSS";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "<STYLE";
        END END6 = new END();
        END6.text = "</STYLE>";
        SPAN6.END = new END[] { END6, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN7 = new SPAN();
        SPAN7.TYPE = "COMMENT2";
        SPAN7.DELEGATE = "xml::DTD-TAGS";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "<!--";
        END END7 = new END();
        END7.text = "-->";
        SPAN7.END = new END[] { END7, };

        SPAN7.BEGIN = new BEGIN[] { BEGIN7, };

        SPAN SPAN8 = new SPAN();
        SPAN8.TYPE = "KEYWORD2";
        SPAN8.DELEGATE = "xml::DTD-TAGS";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "<!";
        END END8 = new END();
        END8.text = ">";
        SPAN8.END = new END[] { END8, };

        SPAN8.BEGIN = new BEGIN[] { BEGIN8, };

        SPAN SPAN9 = new SPAN();
        SPAN9.TYPE = "KEYWORD1";
        SPAN9.DELEGATE = "EXPRESSION";
        BEGIN BEGIN9 = new BEGIN();
        BEGIN9.text = "${";
        END END9 = new END();
        END9.text = "}";
        SPAN9.END = new END[] { END9, };

        SPAN9.BEGIN = new BEGIN[] { BEGIN9, };

        SPAN SPAN10 = new SPAN();
        SPAN10.TYPE = "KEYWORD1";
        SPAN10.DELEGATE = "EXPRESSION";
        BEGIN BEGIN10 = new BEGIN();
        BEGIN10.text = "#{";
        END END10 = new END();
        END10.text = "}";
        SPAN10.END = new END[] { END10, };

        SPAN10.BEGIN = new BEGIN[] { BEGIN10, };

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "KEYWORD1";
        SPAN_REGEXP1.DELEGATE = "EXPRESSION";
        SPAN_REGEXP1.HASH_CHAR = "<#ftl";
        BEGIN BEGIN11 = new BEGIN();
        BEGIN11.text = "<#ftl\\b";
        END END11 = new END();
        END11.text = ">";
        SPAN_REGEXP1.END = new END[] { END11, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN11, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.TYPE = "KEYWORD1";
        SPAN_REGEXP2.DELEGATE = "EXPRESSION";
        SPAN_REGEXP2.HASH_CHAR = "<";
        BEGIN BEGIN12 = new BEGIN();
        BEGIN12.text = "<#?(if|elseif|switch|foreach|list|case|assign|local|global|setting|include|import|stop|escape|macro|function|transform|call|visit|recurse)(\\s|/|$)";
        END END12 = new END();
        END12.text = ">";
        SPAN_REGEXP2.END = new END[] { END12, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN12, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "</#?(assign|local|global|if|switch|foreach|list|escape|macro|function|transform|compress|noescape)>";
        SEQ_REGEXP1.TYPE = "KEYWORD1";
        SEQ_REGEXP1.HASH_CHAR = "</";
        SPAN_REGEXP SPAN_REGEXP3 = new SPAN_REGEXP();
        SPAN_REGEXP3.TYPE = "KEYWORD1";
        SPAN_REGEXP3.DELEGATE = "INVALID";
        SPAN_REGEXP3.HASH_CHAR = "<";
        BEGIN BEGIN13 = new BEGIN();
        BEGIN13.text = "<#?(else|compress|noescape|default|break|flush|nested|t|rt|lt|return|recurse)\\b";
        END END13 = new END();
        END13.text = ">";
        SPAN_REGEXP3.END = new END[] { END13, };

        SPAN_REGEXP3.BEGIN = new BEGIN[] { BEGIN13, };

        SPAN_REGEXP SPAN_REGEXP4 = new SPAN_REGEXP();
        SPAN_REGEXP4.TYPE = "KEYWORD1";
        SPAN_REGEXP4.DELEGATE = "INVALID";
        SPAN_REGEXP4.HASH_CHAR = "</@";
        BEGIN BEGIN14 = new BEGIN();
        BEGIN14.text = "</@(([_@\\p{Alpha}][_@\\p{Alnum}]*)(\\.[_@\\p{Alpha}][_@\\p{Alnum}]*)*?)?";
        END END14 = new END();
        END14.text = ">";
        SPAN_REGEXP4.END = new END[] { END14, };

        SPAN_REGEXP4.BEGIN = new BEGIN[] { BEGIN14, };

        SPAN_REGEXP SPAN_REGEXP5 = new SPAN_REGEXP();
        SPAN_REGEXP5.TYPE = "KEYWORD1";
        SPAN_REGEXP5.DELEGATE = "EXPRESSION";
        SPAN_REGEXP5.HASH_CHAR = "<@";
        BEGIN BEGIN15 = new BEGIN();
        BEGIN15.text = "<@([_@\\p{Alpha}][_@\\p{Alnum}]*)(\\.[_@\\p{Alpha}][_@\\p{Alnum}]*?)*";
        END END15 = new END();
        END15.text = ">";
        SPAN_REGEXP5.END = new END[] { END15, };

        SPAN_REGEXP5.BEGIN = new BEGIN[] { BEGIN15, };

        SPAN SPAN11 = new SPAN();
        SPAN11.TYPE = "COMMENT1";
        BEGIN BEGIN16 = new BEGIN();
        BEGIN16.text = "<#--";
        END END16 = new END();
        END16.text = "-->";
        SPAN11.END = new END[] { END16, };

        SPAN11.BEGIN = new BEGIN[] { BEGIN16, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "<stop>";
        SEQ1.TYPE = "KEYWORD1";
        SPAN SPAN12 = new SPAN();
        SPAN12.TYPE = "COMMENT1";
        BEGIN BEGIN17 = new BEGIN();
        BEGIN17.text = "<comment>";
        END END17 = new END();
        END17.text = "</comment>";
        SPAN12.END = new END[] { END17, };

        SPAN12.BEGIN = new BEGIN[] { BEGIN17, };

        SPAN SPAN13 = new SPAN();
        SPAN13.TYPE = "INVALID";
        BEGIN BEGIN18 = new BEGIN();
        BEGIN18.text = "<#";
        END END18 = new END();
        END18.text = ">";
        SPAN13.END = new END[] { END18, };

        SPAN13.BEGIN = new BEGIN[] { BEGIN18, };

        SPAN SPAN14 = new SPAN();
        SPAN14.TYPE = "INVALID";
        BEGIN BEGIN19 = new BEGIN();
        BEGIN19.text = "</#";
        END END19 = new END();
        END19.text = ">";
        SPAN14.END = new END[] { END19, };

        SPAN14.BEGIN = new BEGIN[] { BEGIN19, };

        SPAN SPAN15 = new SPAN();
        SPAN15.TYPE = "MARKUP";
        SPAN15.DELEGATE = "TAGS";
        BEGIN BEGIN20 = new BEGIN();
        BEGIN20.text = "<";
        END END20 = new END();
        END20.text = ">";
        SPAN15.END = new END[] { END20, };

        SPAN15.BEGIN = new BEGIN[] { BEGIN20, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, SPAN7, SPAN8, SPAN9, SPAN10, SPAN11, SPAN12, SPAN13, SPAN14, SPAN15, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, SPAN_REGEXP3, SPAN_REGEXP4, SPAN_REGEXP5, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "EXPRESSION";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DEFAULT = "KEYWORD2";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<#--";
        END END1 = new END();
        END1.text = "-->";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "COMMENT1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<!--";
        END END2 = new END();
        END2.text = "-->";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL1";
        SPAN3.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "\"";
        END END3 = new END();
        END3.text = "\"";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "OPERATOR";
        SPAN4.DELEGATE = "EXPRESSION";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "(";
        END END4 = new END();
        END4.text = ")";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "!";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "|";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "&";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "<";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = ">";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "*";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "/";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "-";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "+";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "%";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = ".";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = ":";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = ".";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = ".";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "[";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "]";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "{";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "}";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = ";";
        SEQ20.TYPE = "OPERATOR";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "?";
        MARK_FOLLOWING1.TYPE = "FUNCTION";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"gt", "gte", "lt", "lte", });
        KEYWORDS1.add("KEYWORD1", new String[]{"true", "false", "as", "in", "using", });
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "TAGS";
        RULES1.DEFAULT = "MARKUP";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "INQUOTE";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.DELEGATE = "INQUOTE";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "INQUOTE";
        RULES1.ESCAPE = "\\";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "KEYWORD1";
        SPAN1.DELEGATE = "EXPRESSION";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "${";
        END END1 = new END();
        END1.text = "}";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "KEYWORD1";
        SPAN2.DELEGATE = "EXPRESSION";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "#{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "INVALID";
        RULES1.DEFAULT = "INVALID";
        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {};
    }


}
