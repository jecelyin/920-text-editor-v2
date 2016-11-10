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
public class LatexLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "%";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "";
        PROPERTY2.NAME = "wordBreakChars";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "\\@_-:*<>";
        PROPERTY3.NAME = "noWordSep";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "FALSE";
        PROPERTY4.NAME = "deepIndent";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "FALSE";
        PROPERTY5.NAME = "doubleBracketIndent";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "FALSE";
        PROPERTY6.NAME = "lineUpClosingBrackets";
        PROPERTY PROPERTY7 = new PROPERTY();
        PROPERTY7.VALUE = "(";
        PROPERTY7.NAME = "unalignedOpenBrackets";
        PROPERTY PROPERTY8 = new PROPERTY();
        PROPERTY8.VALUE = ")";
        PROPERTY8.NAME = "unalignedCloseBrackets";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, PROPERTY8, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "FALSE";
        RULES1.IGNORE_CASE = "FALSE";
        RULES1.NO_WORD_SEP = "@_-:*";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.NO_LINE_BREAK = "TRUE";
        SPAN_REGEXP1.TYPE = "KEYWORD2";
        SPAN_REGEXP1.DELEGATE = "VerbatimRules";
        SPAN_REGEXP1.HASH_CHAR = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = ".verb[\\*]?([\\p{Punct}&&[^*]])";
        END END1 = new END();
        END1.text = "$1";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "KEYWORD1";
        SPAN1.DELEGATE = "VerbatimRules";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\\begin{verbatim*}";
        END END2 = new END();
        END2.text = "\\end{verbatim*}";
        SPAN1.END = new END[] { END2, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "KEYWORD1";
        SPAN2.DELEGATE = "VerbatimRules";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "\\begin{verbatim}";
        END END3 = new END();
        END3.text = "\\end{verbatim}";
        SPAN2.END = new END[] { END3, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "KEYWORD1";
        SPAN3.DELEGATE = "MathRules";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "$$";
        END END4 = new END();
        END4.text = "$$";
        SPAN3.END = new END[] { END4, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "KEYWORD1";
        SPAN4.DELEGATE = "MathRules";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "$";
        END END5 = new END();
        END5.text = "$";
        SPAN4.END = new END[] { END5, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "KEYWORD1";
        SPAN5.DELEGATE = "MathRules";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "\\(";
        END END6 = new END();
        END6.text = "\\)";
        SPAN5.END = new END[] { END6, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN6 = new SPAN();
        SPAN6.TYPE = "KEYWORD1";
        SPAN6.DELEGATE = "MathRules";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "\\[";
        END END7 = new END();
        END7.text = "\\]";
        SPAN6.END = new END[] { END7, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN7, };

        SPAN SPAN7 = new SPAN();
        SPAN7.TYPE = "KEYWORD1";
        SPAN7.DELEGATE = "MathRules";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "\\begin{math}";
        END END8 = new END();
        END8.text = "\\end{math}";
        SPAN7.END = new END[] { END8, };

        SPAN7.BEGIN = new BEGIN[] { BEGIN8, };

        SPAN SPAN8 = new SPAN();
        SPAN8.TYPE = "KEYWORD1";
        SPAN8.DELEGATE = "MathRules";
        BEGIN BEGIN9 = new BEGIN();
        BEGIN9.text = "\\begin{displaymath}";
        END END9 = new END();
        END9.text = "\\end{displaymath}";
        SPAN8.END = new END[] { END9, };

        SPAN8.BEGIN = new BEGIN[] { BEGIN9, };

        SPAN SPAN9 = new SPAN();
        SPAN9.TYPE = "KEYWORD1";
        SPAN9.DELEGATE = "MathRules";
        BEGIN BEGIN10 = new BEGIN();
        BEGIN10.text = "\\begin{equation*}";
        END END10 = new END();
        END10.text = "\\end{equation*}";
        SPAN9.END = new END[] { END10, };

        SPAN9.BEGIN = new BEGIN[] { BEGIN10, };

        SPAN SPAN10 = new SPAN();
        SPAN10.TYPE = "KEYWORD1";
        SPAN10.DELEGATE = "MathRules";
        BEGIN BEGIN11 = new BEGIN();
        BEGIN11.text = "\\begin{equation}";
        END END11 = new END();
        END11.text = "\\end{equation}";
        SPAN10.END = new END[] { END11, };

        SPAN10.BEGIN = new BEGIN[] { BEGIN11, };

        SPAN SPAN11 = new SPAN();
        SPAN11.TYPE = "KEYWORD1";
        SPAN11.DELEGATE = "MathRules";
        BEGIN BEGIN12 = new BEGIN();
        BEGIN12.text = "\\begin{eqnarray*}";
        END END12 = new END();
        END12.text = "\\end{eqnarray*}";
        SPAN11.END = new END[] { END12, };

        SPAN11.BEGIN = new BEGIN[] { BEGIN12, };

        SPAN SPAN12 = new SPAN();
        SPAN12.TYPE = "KEYWORD1";
        SPAN12.DELEGATE = "MathRules";
        BEGIN BEGIN13 = new BEGIN();
        BEGIN13.text = "\\begin{eqnarray}";
        END END13 = new END();
        END13.text = "\\end{eqnarray}";
        SPAN12.END = new END[] { END13, };

        SPAN12.BEGIN = new BEGIN[] { BEGIN13, };

        SPAN SPAN13 = new SPAN();
        SPAN13.TYPE = "KEYWORD1";
        SPAN13.DELEGATE = "MathRules";
        BEGIN BEGIN14 = new BEGIN();
        BEGIN14.text = "\\begin{align*}";
        END END14 = new END();
        END14.text = "\\end{align*}";
        SPAN13.END = new END[] { END14, };

        SPAN13.BEGIN = new BEGIN[] { BEGIN14, };

        SPAN SPAN14 = new SPAN();
        SPAN14.TYPE = "KEYWORD1";
        SPAN14.DELEGATE = "MathRules";
        BEGIN BEGIN15 = new BEGIN();
        BEGIN15.text = "\\begin{align}";
        END END15 = new END();
        END15.text = "\\end{align}";
        SPAN14.END = new END[] { END15, };

        SPAN14.BEGIN = new BEGIN[] { BEGIN15, };

        SPAN SPAN15 = new SPAN();
        SPAN15.TYPE = "KEYWORD1";
        SPAN15.DELEGATE = "MathRules";
        BEGIN BEGIN16 = new BEGIN();
        BEGIN16.text = "\\begin{alignat*}";
        END END16 = new END();
        END16.text = "\\end{alignat*}";
        SPAN15.END = new END[] { END16, };

        SPAN15.BEGIN = new BEGIN[] { BEGIN16, };

        SPAN SPAN16 = new SPAN();
        SPAN16.TYPE = "KEYWORD1";
        SPAN16.DELEGATE = "MathRules";
        BEGIN BEGIN17 = new BEGIN();
        BEGIN17.text = "\\begin{alignat}";
        END END17 = new END();
        END17.text = "\\end{alignat}";
        SPAN16.END = new END[] { END17, };

        SPAN16.BEGIN = new BEGIN[] { BEGIN17, };

        SPAN SPAN17 = new SPAN();
        SPAN17.TYPE = "KEYWORD1";
        SPAN17.DELEGATE = "MathRules";
        BEGIN BEGIN18 = new BEGIN();
        BEGIN18.text = "\\begin{flalign*}";
        END END18 = new END();
        END18.text = "\\end{flalign*}";
        SPAN17.END = new END[] { END18, };

        SPAN17.BEGIN = new BEGIN[] { BEGIN18, };

        SPAN SPAN18 = new SPAN();
        SPAN18.TYPE = "KEYWORD1";
        SPAN18.DELEGATE = "MathRules";
        BEGIN BEGIN19 = new BEGIN();
        BEGIN19.text = "\\begin{flalign}";
        END END19 = new END();
        END19.text = "\\end{flalign}";
        SPAN18.END = new END[] { END19, };

        SPAN18.BEGIN = new BEGIN[] { BEGIN19, };

        SPAN SPAN19 = new SPAN();
        SPAN19.TYPE = "KEYWORD1";
        SPAN19.DELEGATE = "MathRules";
        BEGIN BEGIN20 = new BEGIN();
        BEGIN20.text = "\\begin{gather*}";
        END END20 = new END();
        END20.text = "\\end{gather*}";
        SPAN19.END = new END[] { END20, };

        SPAN19.BEGIN = new BEGIN[] { BEGIN20, };

        SPAN SPAN20 = new SPAN();
        SPAN20.TYPE = "KEYWORD1";
        SPAN20.DELEGATE = "MathRules";
        BEGIN BEGIN21 = new BEGIN();
        BEGIN21.text = "\\begin{gather}";
        END END21 = new END();
        END21.text = "\\end{gather}";
        SPAN20.END = new END[] { END21, };

        SPAN20.BEGIN = new BEGIN[] { BEGIN21, };

        SPAN SPAN21 = new SPAN();
        SPAN21.TYPE = "KEYWORD1";
        SPAN21.DELEGATE = "MathRules";
        BEGIN BEGIN22 = new BEGIN();
        BEGIN22.text = "\\begin{multline*}";
        END END22 = new END();
        END22.text = "\\end{multline*}";
        SPAN21.END = new END[] { END22, };

        SPAN21.BEGIN = new BEGIN[] { BEGIN22, };

        SPAN SPAN22 = new SPAN();
        SPAN22.TYPE = "KEYWORD1";
        SPAN22.DELEGATE = "MathRules";
        BEGIN BEGIN23 = new BEGIN();
        BEGIN23.text = "\\begin{multline}";
        END END23 = new END();
        END23.text = "\\end{multline}";
        SPAN22.END = new END[] { END23, };

        SPAN22.BEGIN = new BEGIN[] { BEGIN23, };

        SPAN SPAN23 = new SPAN();
        SPAN23.NO_LINE_BREAK = "TRUE";
        SPAN23.TYPE = "KEYWORD4";
        SPAN23.DELEGATE = "LabelRules";
        BEGIN BEGIN24 = new BEGIN();
        BEGIN24.text = "\\label{";
        END END24 = new END();
        END24.text = "}";
        SPAN23.END = new END[] { END24, };

        SPAN23.BEGIN = new BEGIN[] { BEGIN24, };

        SPAN SPAN24 = new SPAN();
        SPAN24.NO_LINE_BREAK = "TRUE";
        SPAN24.TYPE = "KEYWORD4";
        SPAN24.DELEGATE = "LabelRules";
        BEGIN BEGIN25 = new BEGIN();
        BEGIN25.text = "\\cite{";
        END END25 = new END();
        END25.text = "}";
        SPAN24.END = new END[] { END25, };

        SPAN24.BEGIN = new BEGIN[] { BEGIN25, };

        SPAN SPAN25 = new SPAN();
        SPAN25.NO_LINE_BREAK = "TRUE";
        SPAN25.TYPE = "KEYWORD4";
        SPAN25.DELEGATE = "LabelRules";
        BEGIN BEGIN26 = new BEGIN();
        BEGIN26.text = "\\hyperlink{";
        END END26 = new END();
        END26.text = "}";
        SPAN25.END = new END[] { END26, };

        SPAN25.BEGIN = new BEGIN[] { BEGIN26, };

        SPAN SPAN26 = new SPAN();
        SPAN26.NO_LINE_BREAK = "TRUE";
        SPAN26.TYPE = "KEYWORD4";
        SPAN26.DELEGATE = "LabelRules";
        BEGIN BEGIN27 = new BEGIN();
        BEGIN27.text = "\\hypertarget{";
        END END27 = new END();
        END27.text = "}";
        SPAN26.END = new END[] { END27, };

        SPAN26.BEGIN = new BEGIN[] { BEGIN27, };

        SPAN SPAN27 = new SPAN();
        SPAN27.NO_LINE_BREAK = "TRUE";
        SPAN27.TYPE = "KEYWORD4";
        SPAN27.DELEGATE = "LabelRules";
        BEGIN BEGIN28 = new BEGIN();
        BEGIN28.text = "\\url{";
        END END28 = new END();
        END28.text = "}";
        SPAN27.END = new END[] { END28, };

        SPAN27.BEGIN = new BEGIN[] { BEGIN28, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.NO_LINE_BREAK = "TRUE";
        SPAN_REGEXP2.TYPE = "KEYWORD4";
        SPAN_REGEXP2.DELEGATE = "LabelRules";
        SPAN_REGEXP2.HASH_CHAR = "\\";
        BEGIN BEGIN29 = new BEGIN();
        BEGIN29.text = ".[\\p{Alnum}]*ref[\\*]?\\{";
        END END29 = new END();
        END29.text = "}";
        SPAN_REGEXP2.END = new END[] { END29, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN29, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "\\&";
        SEQ1.TYPE = "NULL";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "\\$";
        SEQ2.TYPE = "NULL";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "\\%";
        SEQ3.TYPE = "NULL";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "\\#";
        SEQ4.TYPE = "NULL";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "\\_";
        SEQ5.TYPE = "NULL";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "\\{";
        SEQ6.TYPE = "NULL";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "\\}";
        SEQ7.TYPE = "NULL";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "\\=";
        SEQ8.TYPE = "KEYWORD2";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "\\>";
        SEQ9.TYPE = "KEYWORD2";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "\\<";
        SEQ10.TYPE = "KEYWORD2";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "\\+";
        SEQ11.TYPE = "KEYWORD2";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "\\-";
        SEQ12.TYPE = "KEYWORD2";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "\\'";
        SEQ13.TYPE = "KEYWORD2";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "\\`";
        SEQ14.TYPE = "KEYWORD2";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "\\^";
        SEQ15.TYPE = "KEYWORD2";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "\\\"";
        SEQ16.TYPE = "KEYWORD2";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "\\~";
        SEQ17.TYPE = "KEYWORD2";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "\\.";
        SEQ18.TYPE = "KEYWORD2";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "\\a'";
        SEQ19.TYPE = "KEYWORD2";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "\\a`";
        SEQ20.TYPE = "KEYWORD2";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "\\a=";
        SEQ21.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "#[1-9]";
        SEQ_REGEXP1.TYPE = "DIGIT";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "\\\\";
        SEQ22.TYPE = "KEYWORD3";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "&";
        SEQ23.TYPE = "KEYWORD3";
        SPAN SPAN28 = new SPAN();
        SPAN28.TYPE = "COMMENT2";
        BEGIN BEGIN30 = new BEGIN();
        BEGIN30.text = "\\iffalse";
        END END30 = new END();
        END30.text = "\\fi";
        SPAN28.END = new END[] { END30, };

        SPAN28.BEGIN = new BEGIN[] { BEGIN30, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "%";
        EOL_SPAN1.TYPE = "COMMENT1";
        SPAN_REGEXP SPAN_REGEXP3 = new SPAN_REGEXP();
        SPAN_REGEXP3.TYPE = "LITERAL1";
        BEGIN BEGIN31 = new BEGIN();
        BEGIN31.text = "``";
        END END31 = new END();
        END31.text = "''|\"";
        END31.REGEXP = "TRUE";
        SPAN_REGEXP3.END = new END[] { END31, };

        SPAN_REGEXP3.BEGIN = new BEGIN[] { BEGIN31, };

        SPAN SPAN29 = new SPAN();
        SPAN29.TYPE = "LITERAL1";
        BEGIN BEGIN32 = new BEGIN();
        BEGIN32.text = "\"`";
        END END32 = new END();
        END32.text = "\"'";
        SPAN29.END = new END[] { END32, };

        SPAN29.BEGIN = new BEGIN[] { BEGIN32, };

        SPAN SPAN30 = new SPAN();
        SPAN30.TYPE = "LITERAL1";
        BEGIN BEGIN33 = new BEGIN();
        BEGIN33.text = "\"<";
        END END33 = new END();
        END33.text = "\">";
        SPAN30.END = new END[] { END33, };

        SPAN30.BEGIN = new BEGIN[] { BEGIN33, };

        SPAN SPAN31 = new SPAN();
        SPAN31.TYPE = "LITERAL1";
        BEGIN BEGIN34 = new BEGIN();
        BEGIN34.text = "\\glqq";
        END END34 = new END();
        END34.text = "\\grqq";
        SPAN31.END = new END[] { END34, };

        SPAN31.BEGIN = new BEGIN[] { BEGIN34, };

        SPAN SPAN32 = new SPAN();
        SPAN32.TYPE = "LITERAL1";
        BEGIN BEGIN35 = new BEGIN();
        BEGIN35.text = "\\glq";
        END END35 = new END();
        END35.text = "\\grq";
        SPAN32.END = new END[] { END35, };

        SPAN32.BEGIN = new BEGIN[] { BEGIN35, };

        SPAN SPAN33 = new SPAN();
        SPAN33.TYPE = "LITERAL1";
        BEGIN BEGIN36 = new BEGIN();
        BEGIN36.text = "\\flqq";
        END END36 = new END();
        END36.text = "\\frqq";
        SPAN33.END = new END[] { END36, };

        SPAN33.BEGIN = new BEGIN[] { BEGIN36, };

        SPAN SPAN34 = new SPAN();
        SPAN34.TYPE = "LITERAL1";
        BEGIN BEGIN37 = new BEGIN();
        BEGIN37.text = "\\flq";
        END END37 = new END();
        END37.text = "\\frq";
        SPAN34.END = new END[] { END37, };

        SPAN34.BEGIN = new BEGIN[] { BEGIN37, };

        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "(.begin\\{([\\p{Alnum}|@|\\*]*)\\})";
        SEQ_REGEXP2.TYPE = "KEYWORD1";
        SEQ_REGEXP2.HASH_CHAR = "\\";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "(.end\\{([\\p{Alnum}|@|\\*]*)\\})";
        SEQ_REGEXP3.TYPE = "KEYWORD1";
        SEQ_REGEXP3.HASH_CHAR = "\\";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "\\";
        MARK_FOLLOWING1.TYPE = "KEYWORD2";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "{";
        SEQ24.TYPE = "KEYWORD4";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "}";
        SEQ25.TYPE = "KEYWORD4";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = "[";
        SEQ26.TYPE = "KEYWORD4";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "]";
        SEQ27.TYPE = "KEYWORD4";
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, SPAN7, SPAN8, SPAN9, SPAN10, SPAN11, SPAN12, SPAN13, SPAN14, SPAN15, SPAN16, SPAN17, SPAN18, SPAN19, SPAN20, SPAN21, SPAN22, SPAN23, SPAN24, SPAN25, SPAN26, SPAN27, SPAN28, SPAN29, SPAN30, SPAN31, SPAN32, SPAN33, SPAN34, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, SPAN_REGEXP3, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "MathRules";
        RULES1.HIGHLIGHT_DIGITS = "FALSE";
        RULES1.DEFAULT = "LITERAL2";
        RULES1.IGNORE_CASE = "FALSE";
        RULES1.NO_WORD_SEP = "@:";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "KEYWORD4";
        SPAN1.DELEGATE = "LabelRules";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\\label{";
        END END1 = new END();
        END1.text = "}";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "\\&";
        SEQ1.TYPE = "LITERAL2";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "\\$";
        SEQ2.TYPE = "LITERAL2";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "\\%";
        SEQ3.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "#[1-9]";
        SEQ_REGEXP1.TYPE = "DIGIT";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "\\\\";
        SEQ4.TYPE = "KEYWORD3";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "&";
        SEQ5.TYPE = "KEYWORD3";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "\\label{";
        MARK_FOLLOWING1.TYPE = "LABEL";
        MARK_FOLLOWING1.MATCH_TYPE = "KEYWORD4";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "%";
        EOL_SPAN1.TYPE = "COMMENT1";
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "VerbatimRules";
        RULES1.DEFAULT = "LITERAL3";
        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "LabelRules";
        RULES1.DEFAULT = "LABEL";
        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
