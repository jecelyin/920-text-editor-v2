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
public class AspLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "<!--";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "-->";
        PROPERTY2.NAME = "commentEnd";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.IGNORE_CASE = "TRUE";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "<%@LANGUAGE=\"VBSCRIPT\"%";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "ASPVB";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "<%@LANGUAGE=\"JSCRIPT\"%";
        SEQ2.TYPE = "MARKUP";
        SEQ2.DELEGATE = "ASPJS";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "<%@LANGUAGE=\"JAVASCRIPT\"%";
        SEQ3.TYPE = "MARKUP";
        SEQ3.DELEGATE = "ASPJS";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "<%@LANGUAGE=\"PERLSCRIPT\"%";
        SEQ4.TYPE = "MARKUP";
        SEQ4.DELEGATE = "ASPPL";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "vbscript::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "MARKUP";
        SPAN2.DELEGATE = "vbscript::MAIN";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<script language=\"vbscript\" runat=\"server\">";
        END END2 = new END();
        END2.text = "</script>";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "MARKUP";
        SPAN3.DELEGATE = "javascript::MAIN";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<script language=\"jscript\" runat=\"server\">";
        END END3 = new END();
        END3.text = "</script>";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "MARKUP";
        SPAN4.DELEGATE = "javascript::MAIN";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "<script language=\"javascript\" runat=\"server\">";
        END END4 = new END();
        END4.text = "</script>";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "MARKUP";
        SPAN5.DELEGATE = "perl::MAIN";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "<script language=\"perlscript\" runat=\"server\">";
        END END5 = new END();
        END5.text = "</script>";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN SPAN6 = new SPAN();
        SPAN6.TYPE = "MARKUP";
        SPAN6.DELEGATE = "ASPVB_CSJS";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "<script language=\"jscript\">";
        END END6 = new END();
        END6.text = "</script>";
        SPAN6.END = new END[] { END6, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN7 = new SPAN();
        SPAN7.TYPE = "MARKUP";
        SPAN7.DELEGATE = "ASPVB_CSJS";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "<script language=\"javascript\">";
        END END7 = new END();
        END7.text = "</script>";
        SPAN7.END = new END[] { END7, };

        SPAN7.BEGIN = new BEGIN[] { BEGIN7, };

        SPAN SPAN8 = new SPAN();
        SPAN8.TYPE = "MARKUP";
        SPAN8.DELEGATE = "ASPVB_CSJS";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "<script>";
        END END8 = new END();
        END8.text = "</script>";
        SPAN8.END = new END[] { END8, };

        SPAN8.BEGIN = new BEGIN[] { BEGIN8, };

        SPAN SPAN9 = new SPAN();
        SPAN9.TYPE = "MARKUP";
        BEGIN BEGIN9 = new BEGIN();
        BEGIN9.text = "<!--#";
        END END9 = new END();
        END9.text = "-->";
        SPAN9.END = new END[] { END9, };

        SPAN9.BEGIN = new BEGIN[] { BEGIN9, };

        SPAN SPAN10 = new SPAN();
        SPAN10.TYPE = "COMMENT1";
        SPAN10.DELEGATE = "ASPVB_SGML";
        BEGIN BEGIN10 = new BEGIN();
        BEGIN10.text = "<!--";
        END END10 = new END();
        END10.text = "-->";
        SPAN10.END = new END[] { END10, };

        SPAN10.BEGIN = new BEGIN[] { BEGIN10, };

        SPAN SPAN11 = new SPAN();
        SPAN11.TYPE = "MARKUP";
        SPAN11.DELEGATE = "ASPVB_STYLE";
        BEGIN BEGIN11 = new BEGIN();
        BEGIN11.text = "<STYLE>";
        END END11 = new END();
        END11.text = "</STYLE>";
        SPAN11.END = new END[] { END11, };

        SPAN11.BEGIN = new BEGIN[] { BEGIN11, };

        SPAN SPAN12 = new SPAN();
        SPAN12.TYPE = "MARKUP";
        SPAN12.DELEGATE = "ASPVB_TAGS";
        BEGIN BEGIN12 = new BEGIN();
        BEGIN12.text = "<";
        END END12 = new END();
        END12.text = ">";
        SPAN12.END = new END[] { END12, };

        SPAN12.BEGIN = new BEGIN[] { BEGIN12, };

        SPAN SPAN13 = new SPAN();
        SPAN13.NO_WORD_BREAK = "TRUE";
        SPAN13.TYPE = "LITERAL2";
        BEGIN BEGIN13 = new BEGIN();
        BEGIN13.text = "&";
        END END13 = new END();
        END13.text = ";";
        SPAN13.END = new END[] { END13, };

        SPAN13.BEGIN = new BEGIN[] { BEGIN13, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, SPAN7, SPAN8, SPAN9, SPAN10, SPAN11, SPAN12, SPAN13, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPVB";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "vbscript::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "MARKUP";
        SPAN2.DELEGATE = "vbscript::MAIN";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<script language=\"vbscript\" runat=\"server\">";
        END END2 = new END();
        END2.text = "</script>";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "MARKUP";
        SPAN3.DELEGATE = "javascript::MAIN";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<script language=\"jscript\" runat=\"server\">";
        END END3 = new END();
        END3.text = "</script>";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "MARKUP";
        SPAN4.DELEGATE = "javascript::MAIN";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "<script language=\"javascript\" runat=\"server\">";
        END END4 = new END();
        END4.text = "</script>";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "MARKUP";
        SPAN5.DELEGATE = "perl::MAIN";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "<script language=\"perlscript\" runat=\"server\">";
        END END5 = new END();
        END5.text = "</script>";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN SPAN6 = new SPAN();
        SPAN6.TYPE = "MARKUP";
        SPAN6.DELEGATE = "ASPVB_CSJS";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "<script language=\"jscript\"";
        END END6 = new END();
        END6.text = "</script>";
        SPAN6.END = new END[] { END6, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN7 = new SPAN();
        SPAN7.TYPE = "MARKUP";
        SPAN7.DELEGATE = "ASPVB_CSJS";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "<script language=\"javascript\"";
        END END7 = new END();
        END7.text = "</script>";
        SPAN7.END = new END[] { END7, };

        SPAN7.BEGIN = new BEGIN[] { BEGIN7, };

        SPAN SPAN8 = new SPAN();
        SPAN8.TYPE = "MARKUP";
        SPAN8.DELEGATE = "ASPVB_CSJS";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "<script>";
        END END8 = new END();
        END8.text = "</script>";
        SPAN8.END = new END[] { END8, };

        SPAN8.BEGIN = new BEGIN[] { BEGIN8, };

        SPAN SPAN9 = new SPAN();
        SPAN9.TYPE = "MARKUP";
        BEGIN BEGIN9 = new BEGIN();
        BEGIN9.text = "<!--#";
        END END9 = new END();
        END9.text = "-->";
        SPAN9.END = new END[] { END9, };

        SPAN9.BEGIN = new BEGIN[] { BEGIN9, };

        SPAN SPAN10 = new SPAN();
        SPAN10.TYPE = "COMMENT1";
        SPAN10.DELEGATE = "ASPVB_SGML";
        BEGIN BEGIN10 = new BEGIN();
        BEGIN10.text = "<!--";
        END END10 = new END();
        END10.text = "-->";
        SPAN10.END = new END[] { END10, };

        SPAN10.BEGIN = new BEGIN[] { BEGIN10, };

        SPAN SPAN11 = new SPAN();
        SPAN11.TYPE = "MARKUP";
        SPAN11.DELEGATE = "ASPVB_STYLE";
        BEGIN BEGIN11 = new BEGIN();
        BEGIN11.text = "<STYLE>";
        END END11 = new END();
        END11.text = "</STYLE>";
        SPAN11.END = new END[] { END11, };

        SPAN11.BEGIN = new BEGIN[] { BEGIN11, };

        SPAN SPAN12 = new SPAN();
        SPAN12.TYPE = "MARKUP";
        SPAN12.DELEGATE = "ASPVB_TAGS";
        BEGIN BEGIN12 = new BEGIN();
        BEGIN12.text = "</";
        END END12 = new END();
        END12.text = ">";
        SPAN12.END = new END[] { END12, };

        SPAN12.BEGIN = new BEGIN[] { BEGIN12, };

        SPAN SPAN13 = new SPAN();
        SPAN13.TYPE = "MARKUP";
        SPAN13.DELEGATE = "ASPVB_TAGS";
        BEGIN BEGIN13 = new BEGIN();
        BEGIN13.text = "<";
        END END13 = new END();
        END13.text = ">";
        SPAN13.END = new END[] { END13, };

        SPAN13.BEGIN = new BEGIN[] { BEGIN13, };

        SPAN SPAN14 = new SPAN();
        SPAN14.NO_WORD_BREAK = "TRUE";
        SPAN14.TYPE = "LITERAL2";
        BEGIN BEGIN14 = new BEGIN();
        BEGIN14.text = "&";
        END END14 = new END();
        END14.text = ";";
        SPAN14.END = new END[] { END14, };

        SPAN14.BEGIN = new BEGIN[] { BEGIN14, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, SPAN7, SPAN8, SPAN9, SPAN10, SPAN11, SPAN12, SPAN13, SPAN14, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPJS";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "javascript::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "MARKUP";
        SPAN2.DELEGATE = "vbscript::MAIN";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<script language=\"vbscript\" runat=\"server\">";
        END END2 = new END();
        END2.text = "</script>";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "MARKUP";
        SPAN3.DELEGATE = "javascript::MAIN";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<script language=\"jscript\" runat=\"server\">";
        END END3 = new END();
        END3.text = "</script>";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "MARKUP";
        SPAN4.DELEGATE = "javascript::MAIN";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "<script language=\"javascript\" runat=\"server\">";
        END END4 = new END();
        END4.text = "</script>";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "MARKUP";
        SPAN5.DELEGATE = "perl::MAIN";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "<script language=\"perlscript\" runat=\"server\">";
        END END5 = new END();
        END5.text = "</script>";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN SPAN6 = new SPAN();
        SPAN6.TYPE = "MARKUP";
        SPAN6.DELEGATE = "ASPJS_CSJS";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "<script language=\"jscript\"";
        END END6 = new END();
        END6.text = "</script>";
        SPAN6.END = new END[] { END6, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN7 = new SPAN();
        SPAN7.TYPE = "MARKUP";
        SPAN7.DELEGATE = "ASPJS_CSJS";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "<script language=\"javascript\"";
        END END7 = new END();
        END7.text = "</script>";
        SPAN7.END = new END[] { END7, };

        SPAN7.BEGIN = new BEGIN[] { BEGIN7, };

        SPAN SPAN8 = new SPAN();
        SPAN8.TYPE = "MARKUP";
        SPAN8.DELEGATE = "ASPJS_CSJS";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "<script>";
        END END8 = new END();
        END8.text = "</script>";
        SPAN8.END = new END[] { END8, };

        SPAN8.BEGIN = new BEGIN[] { BEGIN8, };

        SPAN SPAN9 = new SPAN();
        SPAN9.TYPE = "MARKUP";
        BEGIN BEGIN9 = new BEGIN();
        BEGIN9.text = "<!--#";
        END END9 = new END();
        END9.text = "-->";
        SPAN9.END = new END[] { END9, };

        SPAN9.BEGIN = new BEGIN[] { BEGIN9, };

        SPAN SPAN10 = new SPAN();
        SPAN10.TYPE = "COMMENT1";
        SPAN10.DELEGATE = "ASPJS_SGML";
        BEGIN BEGIN10 = new BEGIN();
        BEGIN10.text = "<!--";
        END END10 = new END();
        END10.text = "-->";
        SPAN10.END = new END[] { END10, };

        SPAN10.BEGIN = new BEGIN[] { BEGIN10, };

        SPAN SPAN11 = new SPAN();
        SPAN11.TYPE = "MARKUP";
        SPAN11.DELEGATE = "ASPJS_STYLE";
        BEGIN BEGIN11 = new BEGIN();
        BEGIN11.text = "<STYLE>";
        END END11 = new END();
        END11.text = "</STYLE>";
        SPAN11.END = new END[] { END11, };

        SPAN11.BEGIN = new BEGIN[] { BEGIN11, };

        SPAN SPAN12 = new SPAN();
        SPAN12.TYPE = "MARKUP";
        SPAN12.DELEGATE = "ASPJS_TAGS";
        BEGIN BEGIN12 = new BEGIN();
        BEGIN12.text = "</";
        END END12 = new END();
        END12.text = ">";
        SPAN12.END = new END[] { END12, };

        SPAN12.BEGIN = new BEGIN[] { BEGIN12, };

        SPAN SPAN13 = new SPAN();
        SPAN13.TYPE = "MARKUP";
        SPAN13.DELEGATE = "ASPJS_TAGS";
        BEGIN BEGIN13 = new BEGIN();
        BEGIN13.text = "<";
        END END13 = new END();
        END13.text = ">";
        SPAN13.END = new END[] { END13, };

        SPAN13.BEGIN = new BEGIN[] { BEGIN13, };

        SPAN SPAN14 = new SPAN();
        SPAN14.NO_WORD_BREAK = "TRUE";
        SPAN14.TYPE = "LITERAL2";
        BEGIN BEGIN14 = new BEGIN();
        BEGIN14.text = "&";
        END END14 = new END();
        END14.text = ";";
        SPAN14.END = new END[] { END14, };

        SPAN14.BEGIN = new BEGIN[] { BEGIN14, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, SPAN7, SPAN8, SPAN9, SPAN10, SPAN11, SPAN12, SPAN13, SPAN14, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPPL";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "perl::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "MARKUP";
        SPAN2.DELEGATE = "vbscript::MAIN";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<script language=\"vbscript\" runat=\"server\">";
        END END2 = new END();
        END2.text = "</script>";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "MARKUP";
        SPAN3.DELEGATE = "javascript::MAIN";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<script language=\"jscript\" runat=\"server\">";
        END END3 = new END();
        END3.text = "</script>";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "MARKUP";
        SPAN4.DELEGATE = "javascript::MAIN";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "<script language=\"javascript\" runat=\"server\"";
        END END4 = new END();
        END4.text = "</script>";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "MARKUP";
        SPAN5.DELEGATE = "perl::MAIN";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "<script language=\"perlscript\" runat=\"server\">";
        END END5 = new END();
        END5.text = "</script>";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN SPAN6 = new SPAN();
        SPAN6.TYPE = "MARKUP";
        SPAN6.DELEGATE = "ASPPL_CSJS";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "<script language=\"jscript\"";
        END END6 = new END();
        END6.text = "</script>";
        SPAN6.END = new END[] { END6, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN7 = new SPAN();
        SPAN7.TYPE = "MARKUP";
        SPAN7.DELEGATE = "ASPPL_CSJS";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "<script language=\"javascript\"";
        END END7 = new END();
        END7.text = "</script>";
        SPAN7.END = new END[] { END7, };

        SPAN7.BEGIN = new BEGIN[] { BEGIN7, };

        SPAN SPAN8 = new SPAN();
        SPAN8.TYPE = "MARKUP";
        SPAN8.DELEGATE = "ASPPL_CSJS";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "<script>";
        END END8 = new END();
        END8.text = "</script>";
        SPAN8.END = new END[] { END8, };

        SPAN8.BEGIN = new BEGIN[] { BEGIN8, };

        SPAN SPAN9 = new SPAN();
        SPAN9.TYPE = "MARKUP";
        BEGIN BEGIN9 = new BEGIN();
        BEGIN9.text = "<!--#";
        END END9 = new END();
        END9.text = "-->";
        SPAN9.END = new END[] { END9, };

        SPAN9.BEGIN = new BEGIN[] { BEGIN9, };

        SPAN SPAN10 = new SPAN();
        SPAN10.TYPE = "COMMENT1";
        SPAN10.DELEGATE = "ASPPL_SGML";
        BEGIN BEGIN10 = new BEGIN();
        BEGIN10.text = "<!--";
        END END10 = new END();
        END10.text = "-->";
        SPAN10.END = new END[] { END10, };

        SPAN10.BEGIN = new BEGIN[] { BEGIN10, };

        SPAN SPAN11 = new SPAN();
        SPAN11.TYPE = "MARKUP";
        SPAN11.DELEGATE = "ASPPL_STYLE";
        BEGIN BEGIN11 = new BEGIN();
        BEGIN11.text = "<STYLE>";
        END END11 = new END();
        END11.text = "</STYLE>";
        SPAN11.END = new END[] { END11, };

        SPAN11.BEGIN = new BEGIN[] { BEGIN11, };

        SPAN SPAN12 = new SPAN();
        SPAN12.TYPE = "MARKUP";
        SPAN12.DELEGATE = "ASPPL_TAGS";
        BEGIN BEGIN12 = new BEGIN();
        BEGIN12.text = "</";
        END END12 = new END();
        END12.text = ">";
        SPAN12.END = new END[] { END12, };

        SPAN12.BEGIN = new BEGIN[] { BEGIN12, };

        SPAN SPAN13 = new SPAN();
        SPAN13.TYPE = "MARKUP";
        SPAN13.DELEGATE = "ASPPL_TAGS";
        BEGIN BEGIN13 = new BEGIN();
        BEGIN13.text = "<";
        END END13 = new END();
        END13.text = ">";
        SPAN13.END = new END[] { END13, };

        SPAN13.BEGIN = new BEGIN[] { BEGIN13, };

        SPAN SPAN14 = new SPAN();
        SPAN14.NO_WORD_BREAK = "TRUE";
        SPAN14.TYPE = "LITERAL2";
        BEGIN BEGIN14 = new BEGIN();
        BEGIN14.text = "&";
        END END14 = new END();
        END14.text = ";";
        SPAN14.END = new END[] { END14, };

        SPAN14.BEGIN = new BEGIN[] { BEGIN14, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, SPAN7, SPAN8, SPAN9, SPAN10, SPAN11, SPAN12, SPAN13, SPAN14, };

        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPVB_TAGS";
        RULES1.DEFAULT = "MARKUP";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "vbscript::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.DELEGATE = "ASPVB_LIT1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL1";
        SPAN3.DELEGATE = "ASPVB_LIT1";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES6() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPVB_LIT1";
        RULES1.DEFAULT = "LITERAL1";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "vbscript::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES7() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPJS_TAGS";
        RULES1.DEFAULT = "MARKUP";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "javascript::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.DELEGATE = "ASPJS_LIT1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL1";
        SPAN3.DELEGATE = "ASPJS_LIT1";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES8() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPJS_LIT1";
        RULES1.DEFAULT = "LITERAL1";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "javascript::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES9() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPPL_TAGS";
        RULES1.DEFAULT = "MARKUP";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "perl::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.DELEGATE = "ASPPL_LIT1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL1";
        SPAN3.DELEGATE = "ASPPL_LIT1";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES10() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPPL_LIT1";
        RULES1.DEFAULT = "LITERAL1";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "perl::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES11() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPVB_CSJS";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "vbscript::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "javascript::MAIN";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES12() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPJS_CSJS";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "javascript::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "javascript::MAIN";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES13() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPPL_CSJS";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "perl::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "javascript::MAIN";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES14() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPVB_STYLE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "vbscript::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "css::MAIN";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES15() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPJS_STYLE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "javascript::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "css::MAIN";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES16() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPPL_STYLE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "perl::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "css::MAIN";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES17() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPVB_SGML";
        RULES1.DEFAULT = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "vbscript::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES18() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPJS_SGML";
        RULES1.DEFAULT = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "javascript::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES19() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ASPPL_SGML";
        RULES1.DEFAULT = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "perl::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%";
        END END1 = new END();
        END1.text = "%>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), RULES6(), RULES7(), RULES8(), RULES9(), RULES10(), RULES11(), RULES12(), RULES13(), RULES14(), RULES15(), RULES16(), RULES17(), RULES18(), RULES19(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
