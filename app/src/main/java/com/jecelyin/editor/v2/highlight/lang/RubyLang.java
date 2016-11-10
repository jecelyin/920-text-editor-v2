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
public class RubyLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "{";
        PROPERTY1.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "}";
        PROPERTY2.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "(";
        PROPERTY3.NAME = "unalignedOpenBrackets";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = ")";
        PROPERTY4.NAME = "unalignedCloseBrackets";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "true";
        PROPERTY5.NAME = "lineUpClosingBracket";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "=begin";
        PROPERTY6.NAME = "commentStart";
        PROPERTY PROPERTY7 = new PROPERTY();
        PROPERTY7.VALUE = "=end";
        PROPERTY7.NAME = "commentEnd";
        PROPERTY PROPERTY8 = new PROPERTY();
        PROPERTY8.VALUE = "#";
        PROPERTY8.NAME = "lineComment";
        PROPERTY PROPERTY9 = new PROPERTY();
        PROPERTY9.VALUE = "[^#]*\\s+do(\\s*|(\\s+\\|.+\\|\\s*))|\\s*(if\\s+.*|elsif.*|else.*|do(\\s*|\\s+.*)|case\\s+.*|when\\s+.*|while\\s+.*|for\\s+.*|until\\s+.*|loop\\s+.*|def\\s+.*|class\\s+.*|module\\s+.*|begin.*|unless\\s+.*|rescue.*|ensure.*)+";
        PROPERTY9.NAME = "indentNextLines";
        PROPERTY PROPERTY10 = new PROPERTY();
        PROPERTY10.VALUE = "^\\s*(else.*|end\\s*|elsif.*|rescue.*|when.*|ensure.*)$";
        PROPERTY10.NAME = "unindentThisLine";
        PROPERTY PROPERTY11 = new PROPERTY();
        PROPERTY11.VALUE = "^\\s*(end\\s*|else.*|rescue.*|elsif.*|when.*|ensure.*)$";
        PROPERTY11.NAME = "unindentNextLines";
        PROPERTY PROPERTY12 = new PROPERTY();
        PROPERTY12.VALUE = "^[^#]*([^$](:|\\+|~|\\*|-|%|<|>|&|\\^|\\.|=)|\\s(/|\\!|\\?|\\|)|\\b(not|and|or)|\\\\)\\s*$";
        PROPERTY12.NAME = "indentNextLine";
        PROPERTY PROPERTY13 = new PROPERTY();
        PROPERTY13.VALUE = "edfn";
        PROPERTY13.NAME = "electricKeys";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, PROPERTY8, PROPERTY9, PROPERTY10, PROPERTY11, PROPERTY12, PROPERTY13, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(0b[01]([01_]*[01])?)|(0x[\\p{XDigit}]([\\p{XDigit}_]*[\\p{XDigit}])?)|(0([0-7_]*[0-7])?)|(0d[0-9]([0-9_]*[0-9])?)|([1-9]([0-9_]*[0-9])?)|([0-9]([0-9_]*[0-9])?[Ee]([0-9]([0-9_]*[0-9])?)?)";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT2";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "=begin";
        END END1 = new END();
        END1.text = "=end";
        END1.AT_LINE_START = "TRUE";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "@";
        MARK_FOLLOWING1.TYPE = "KEYWORD4";
        MARK_FOLLOWING MARK_FOLLOWING2 = new MARK_FOLLOWING();
        MARK_FOLLOWING2.text = "\\bdef\\b";
        MARK_FOLLOWING2.TYPE = "FUNCTION";
        MARK_FOLLOWING2.MATCH_TYPE = "KEYWORD1";
        MARK_FOLLOWING MARK_FOLLOWING3 = new MARK_FOLLOWING();
        MARK_FOLLOWING3.text = "\\bundef\\b";
        MARK_FOLLOWING3.TYPE = "FUNCTION";
        MARK_FOLLOWING3.MATCH_TYPE = "KEYWORD1";
        MARK_FOLLOWING MARK_FOLLOWING4 = new MARK_FOLLOWING();
        MARK_FOLLOWING4.text = "\\bclass\\b";
        MARK_FOLLOWING4.TYPE = "FUNCTION";
        MARK_FOLLOWING4.MATCH_TYPE = "KEYWORD1";
        MARK_FOLLOWING MARK_FOLLOWING5 = new MARK_FOLLOWING();
        MARK_FOLLOWING5.text = "\\bmodule\\b";
        MARK_FOLLOWING5.TYPE = "FUNCTION";
        MARK_FOLLOWING5.MATCH_TYPE = "KEYWORD1";
        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.DELEGATE = "doubleQuoteLiteral";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL1";
        SPAN3.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "LITERAL1";
        SPAN_REGEXP1.DELEGATE = "doubleQuoteLiteral";
        SPAN_REGEXP1.HASH_CHAR = "%";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "%Q?\\(";
        END END4 = new END();
        END4.text = ")";
        SPAN_REGEXP1.END = new END[] { END4, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "LITERAL1";
        SPAN4.ESCAPE = "\\";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "%q(";
        END END5 = new END();
        END5.text = ")";
        SPAN4.END = new END[] { END5, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.TYPE = "LITERAL1";
        SPAN_REGEXP2.DELEGATE = "doubleQuoteLiteral";
        SPAN_REGEXP2.HASH_CHAR = "%";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "%Q?\\{";
        END END6 = new END();
        END6.text = "}";
        SPAN_REGEXP2.END = new END[] { END6, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "LITERAL1";
        SPAN5.ESCAPE = "\\";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "%q{";
        END END7 = new END();
        END7.text = "}";
        SPAN5.END = new END[] { END7, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN7, };

        SPAN_REGEXP SPAN_REGEXP3 = new SPAN_REGEXP();
        SPAN_REGEXP3.TYPE = "LITERAL1";
        SPAN_REGEXP3.DELEGATE = "doubleQuoteLiteral";
        SPAN_REGEXP3.HASH_CHAR = "%";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "%Q?\\[";
        END END8 = new END();
        END8.text = "]";
        SPAN_REGEXP3.END = new END[] { END8, };

        SPAN_REGEXP3.BEGIN = new BEGIN[] { BEGIN8, };

        SPAN SPAN6 = new SPAN();
        SPAN6.TYPE = "LITERAL1";
        SPAN6.ESCAPE = "\\";
        BEGIN BEGIN9 = new BEGIN();
        BEGIN9.text = "%q[";
        END END9 = new END();
        END9.text = "]";
        SPAN6.END = new END[] { END9, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN9, };

        SPAN_REGEXP SPAN_REGEXP4 = new SPAN_REGEXP();
        SPAN_REGEXP4.TYPE = "LITERAL1";
        SPAN_REGEXP4.DELEGATE = "doubleQuoteLiteral";
        SPAN_REGEXP4.HASH_CHAR = "%";
        BEGIN BEGIN10 = new BEGIN();
        BEGIN10.text = "%Q?<";
        END END10 = new END();
        END10.text = ">";
        SPAN_REGEXP4.END = new END[] { END10, };

        SPAN_REGEXP4.BEGIN = new BEGIN[] { BEGIN10, };

        SPAN SPAN7 = new SPAN();
        SPAN7.TYPE = "LITERAL1";
        SPAN7.ESCAPE = "\\";
        BEGIN BEGIN11 = new BEGIN();
        BEGIN11.text = "%q<";
        END END11 = new END();
        END11.text = ">";
        SPAN7.END = new END[] { END11, };

        SPAN7.BEGIN = new BEGIN[] { BEGIN11, };

        SPAN_REGEXP SPAN_REGEXP5 = new SPAN_REGEXP();
        SPAN_REGEXP5.TYPE = "LITERAL1";
        SPAN_REGEXP5.DELEGATE = "doubleQuoteLiteral";
        SPAN_REGEXP5.HASH_CHAR = "%Q";
        BEGIN BEGIN12 = new BEGIN();
        BEGIN12.text = "%Q([^\\p{Alnum}])";
        END END12 = new END();
        END12.text = "$1";
        SPAN_REGEXP5.END = new END[] { END12, };

        SPAN_REGEXP5.BEGIN = new BEGIN[] { BEGIN12, };

        SPAN_REGEXP SPAN_REGEXP6 = new SPAN_REGEXP();
        SPAN_REGEXP6.TYPE = "LITERAL1";
        SPAN_REGEXP6.ESCAPE = "\\";
        SPAN_REGEXP6.HASH_CHAR = "%q";
        BEGIN BEGIN13 = new BEGIN();
        BEGIN13.text = "%q([^\\p{Alnum}])";
        END END13 = new END();
        END13.text = "$1";
        SPAN_REGEXP6.END = new END[] { END13, };

        SPAN_REGEXP6.BEGIN = new BEGIN[] { BEGIN13, };

        SPAN_REGEXP SPAN_REGEXP7 = new SPAN_REGEXP();
        SPAN_REGEXP7.TYPE = "LITERAL1";
        SPAN_REGEXP7.DELEGATE = "doubleQuoteLiteral";
        SPAN_REGEXP7.HASH_CHAR = "%";
        BEGIN BEGIN14 = new BEGIN();
        BEGIN14.text = "%([^\\p{Alnum}\\p{Space}])";
        END END14 = new END();
        END14.text = "$1";
        SPAN_REGEXP7.END = new END[] { END14, };

        SPAN_REGEXP7.BEGIN = new BEGIN[] { BEGIN14, };

        SPAN SPAN8 = new SPAN();
        SPAN8.TYPE = "LITERAL1";
        SPAN8.DELEGATE = "doubleQuoteLiteral";
        BEGIN BEGIN15 = new BEGIN();
        BEGIN15.text = "%W(";
        END END15 = new END();
        END15.text = ")";
        SPAN8.END = new END[] { END15, };

        SPAN8.BEGIN = new BEGIN[] { BEGIN15, };

        SPAN SPAN9 = new SPAN();
        SPAN9.TYPE = "LITERAL1";
        SPAN9.ESCAPE = "\\";
        BEGIN BEGIN16 = new BEGIN();
        BEGIN16.text = "%w(";
        END END16 = new END();
        END16.text = ")";
        SPAN9.END = new END[] { END16, };

        SPAN9.BEGIN = new BEGIN[] { BEGIN16, };

        SPAN SPAN10 = new SPAN();
        SPAN10.TYPE = "LITERAL1";
        SPAN10.DELEGATE = "doubleQuoteLiteral";
        BEGIN BEGIN17 = new BEGIN();
        BEGIN17.text = "%W{";
        END END17 = new END();
        END17.text = "}";
        SPAN10.END = new END[] { END17, };

        SPAN10.BEGIN = new BEGIN[] { BEGIN17, };

        SPAN SPAN11 = new SPAN();
        SPAN11.TYPE = "LITERAL1";
        SPAN11.ESCAPE = "\\";
        BEGIN BEGIN18 = new BEGIN();
        BEGIN18.text = "%w{";
        END END18 = new END();
        END18.text = "}";
        SPAN11.END = new END[] { END18, };

        SPAN11.BEGIN = new BEGIN[] { BEGIN18, };

        SPAN SPAN12 = new SPAN();
        SPAN12.TYPE = "LITERAL1";
        SPAN12.DELEGATE = "doubleQuoteLiteral";
        BEGIN BEGIN19 = new BEGIN();
        BEGIN19.text = "%W[";
        END END19 = new END();
        END19.text = "]";
        SPAN12.END = new END[] { END19, };

        SPAN12.BEGIN = new BEGIN[] { BEGIN19, };

        SPAN SPAN13 = new SPAN();
        SPAN13.TYPE = "LITERAL1";
        SPAN13.ESCAPE = "\\";
        BEGIN BEGIN20 = new BEGIN();
        BEGIN20.text = "%w[";
        END END20 = new END();
        END20.text = "]";
        SPAN13.END = new END[] { END20, };

        SPAN13.BEGIN = new BEGIN[] { BEGIN20, };

        SPAN SPAN14 = new SPAN();
        SPAN14.TYPE = "LITERAL1";
        SPAN14.DELEGATE = "doubleQuoteLiteral";
        BEGIN BEGIN21 = new BEGIN();
        BEGIN21.text = "%W<";
        END END21 = new END();
        END21.text = ">";
        SPAN14.END = new END[] { END21, };

        SPAN14.BEGIN = new BEGIN[] { BEGIN21, };

        SPAN SPAN15 = new SPAN();
        SPAN15.TYPE = "LITERAL1";
        SPAN15.ESCAPE = "\\";
        BEGIN BEGIN22 = new BEGIN();
        BEGIN22.text = "%w<";
        END END22 = new END();
        END22.text = ">";
        SPAN15.END = new END[] { END22, };

        SPAN15.BEGIN = new BEGIN[] { BEGIN22, };

        SPAN_REGEXP SPAN_REGEXP8 = new SPAN_REGEXP();
        SPAN_REGEXP8.TYPE = "LITERAL1";
        SPAN_REGEXP8.DELEGATE = "doubleQuoteLiteral";
        SPAN_REGEXP8.HASH_CHAR = "%W";
        BEGIN BEGIN23 = new BEGIN();
        BEGIN23.text = "%W([^\\p{Alnum}\\p{Space}])";
        END END23 = new END();
        END23.text = "$1";
        SPAN_REGEXP8.END = new END[] { END23, };

        SPAN_REGEXP8.BEGIN = new BEGIN[] { BEGIN23, };

        SPAN_REGEXP SPAN_REGEXP9 = new SPAN_REGEXP();
        SPAN_REGEXP9.TYPE = "LITERAL1";
        SPAN_REGEXP9.ESCAPE = "\\";
        SPAN_REGEXP9.HASH_CHAR = "%w";
        BEGIN BEGIN24 = new BEGIN();
        BEGIN24.text = "%w([^\\p{Alnum}\\p{Space}])";
        END END24 = new END();
        END24.text = "$1";
        SPAN_REGEXP9.END = new END[] { END24, };

        SPAN_REGEXP9.BEGIN = new BEGIN[] { BEGIN24, };

        SPAN_REGEXP SPAN_REGEXP10 = new SPAN_REGEXP();
        SPAN_REGEXP10.TYPE = "LITERAL1";
        SPAN_REGEXP10.DELEGATE = "doubleQuoteLiteral";
        SPAN_REGEXP10.HASH_CHAR = "<<";
        BEGIN BEGIN25 = new BEGIN();
        BEGIN25.text = "<<-?\"([\\p{Graph}]+)\"";
        END END25 = new END();
        END25.text = "^\\S*$1$";
        END25.REGEXP = "TRUE";
        SPAN_REGEXP10.END = new END[] { END25, };

        SPAN_REGEXP10.BEGIN = new BEGIN[] { BEGIN25, };

        SPAN_REGEXP SPAN_REGEXP11 = new SPAN_REGEXP();
        SPAN_REGEXP11.TYPE = "LITERAL1";
        SPAN_REGEXP11.HASH_CHAR = "<<";
        BEGIN BEGIN26 = new BEGIN();
        BEGIN26.text = "<<-?'([\\p{Graph}]+)'";
        END END26 = new END();
        END26.text = "^\\S*$1$";
        END26.REGEXP = "TRUE";
        SPAN_REGEXP11.END = new END[] { END26, };

        SPAN_REGEXP11.BEGIN = new BEGIN[] { BEGIN26, };

        SPAN_REGEXP SPAN_REGEXP12 = new SPAN_REGEXP();
        SPAN_REGEXP12.TYPE = "LITERAL1";
        SPAN_REGEXP12.DELEGATE = "doubleQuoteLiteral";
        SPAN_REGEXP12.HASH_CHAR = "<<";
        BEGIN BEGIN27 = new BEGIN();
        BEGIN27.text = "<<-?([A-Za-z_]+)";
        END END27 = new END();
        END27.text = "^\\S*$1$";
        END27.REGEXP = "TRUE";
        SPAN_REGEXP12.END = new END[] { END27, };

        SPAN_REGEXP12.BEGIN = new BEGIN[] { BEGIN27, };

        SPAN SPAN16 = new SPAN();
        SPAN16.TYPE = "LITERAL2";
        SPAN16.DELEGATE = "BackquoteLiteral";
        BEGIN BEGIN28 = new BEGIN();
        BEGIN28.text = "`";
        END END28 = new END();
        END28.text = "`";
        SPAN16.END = new END[] { END28, };

        SPAN16.BEGIN = new BEGIN[] { BEGIN28, };

        SPAN SPAN17 = new SPAN();
        SPAN17.TYPE = "LITERAL2";
        SPAN17.DELEGATE = "BackquoteLiteral";
        BEGIN BEGIN29 = new BEGIN();
        BEGIN29.text = "%x(";
        END END29 = new END();
        END29.text = ")";
        SPAN17.END = new END[] { END29, };

        SPAN17.BEGIN = new BEGIN[] { BEGIN29, };

        SPAN SPAN18 = new SPAN();
        SPAN18.TYPE = "LITERAL2";
        SPAN18.DELEGATE = "BackquoteLiteral";
        BEGIN BEGIN30 = new BEGIN();
        BEGIN30.text = "%x{";
        END END30 = new END();
        END30.text = "}";
        SPAN18.END = new END[] { END30, };

        SPAN18.BEGIN = new BEGIN[] { BEGIN30, };

        SPAN SPAN19 = new SPAN();
        SPAN19.TYPE = "LITERAL2";
        SPAN19.DELEGATE = "BackquoteLiteral";
        BEGIN BEGIN31 = new BEGIN();
        BEGIN31.text = "%x[";
        END END31 = new END();
        END31.text = "]";
        SPAN19.END = new END[] { END31, };

        SPAN19.BEGIN = new BEGIN[] { BEGIN31, };

        SPAN SPAN20 = new SPAN();
        SPAN20.TYPE = "LITERAL2";
        SPAN20.DELEGATE = "BackquoteLiteral";
        BEGIN BEGIN32 = new BEGIN();
        BEGIN32.text = "%x<";
        END END32 = new END();
        END32.text = ">";
        SPAN20.END = new END[] { END32, };

        SPAN20.BEGIN = new BEGIN[] { BEGIN32, };

        SPAN_REGEXP SPAN_REGEXP13 = new SPAN_REGEXP();
        SPAN_REGEXP13.TYPE = "LITERAL2";
        SPAN_REGEXP13.DELEGATE = "BackquoteLiteral";
        SPAN_REGEXP13.HASH_CHAR = "%x";
        BEGIN BEGIN33 = new BEGIN();
        BEGIN33.text = "%x([^\\p{Alnum}\\p{Space}])";
        END END33 = new END();
        END33.text = "$1";
        SPAN_REGEXP13.END = new END[] { END33, };

        SPAN_REGEXP13.BEGIN = new BEGIN[] { BEGIN33, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "/=?($|\\s)";
        SEQ_REGEXP1.TYPE = "OPERATOR";
        SEQ_REGEXP1.HASH_CHAR = "/";
        SPAN SPAN21 = new SPAN();
        SPAN21.AT_WORD_START = "TRUE";
        SPAN21.TYPE = "LITERAL3";
        SPAN21.DELEGATE = "RegexpLiteral";
        BEGIN BEGIN34 = new BEGIN();
        BEGIN34.text = "/";
        END END34 = new END();
        END34.text = "/";
        SPAN21.END = new END[] { END34, };

        SPAN21.BEGIN = new BEGIN[] { BEGIN34, };

        SPAN SPAN22 = new SPAN();
        SPAN22.TYPE = "LITERAL3";
        SPAN22.DELEGATE = "RegexpLiteral";
        BEGIN BEGIN35 = new BEGIN();
        BEGIN35.text = "%r(";
        END END35 = new END();
        END35.text = ")";
        SPAN22.END = new END[] { END35, };

        SPAN22.BEGIN = new BEGIN[] { BEGIN35, };

        SPAN SPAN23 = new SPAN();
        SPAN23.TYPE = "LITERAL3";
        SPAN23.DELEGATE = "RegexpLiteral";
        BEGIN BEGIN36 = new BEGIN();
        BEGIN36.text = "%r{";
        END END36 = new END();
        END36.text = "}";
        SPAN23.END = new END[] { END36, };

        SPAN23.BEGIN = new BEGIN[] { BEGIN36, };

        SPAN SPAN24 = new SPAN();
        SPAN24.TYPE = "LITERAL3";
        SPAN24.DELEGATE = "RegexpLiteral";
        BEGIN BEGIN37 = new BEGIN();
        BEGIN37.text = "%r[";
        END END37 = new END();
        END37.text = "]";
        SPAN24.END = new END[] { END37, };

        SPAN24.BEGIN = new BEGIN[] { BEGIN37, };

        SPAN SPAN25 = new SPAN();
        SPAN25.TYPE = "LITERAL3";
        SPAN25.DELEGATE = "RegexpLiteral";
        BEGIN BEGIN38 = new BEGIN();
        BEGIN38.text = "%r<";
        END END38 = new END();
        END38.text = ">";
        SPAN25.END = new END[] { END38, };

        SPAN25.BEGIN = new BEGIN[] { BEGIN38, };

        SPAN_REGEXP SPAN_REGEXP14 = new SPAN_REGEXP();
        SPAN_REGEXP14.TYPE = "LITERAL3";
        SPAN_REGEXP14.DELEGATE = "RegexpLiteral";
        SPAN_REGEXP14.HASH_CHAR = "%r";
        BEGIN BEGIN39 = new BEGIN();
        BEGIN39.text = "%r([^\\p{Alnum}\\p{Space}])";
        END END39 = new END();
        END39.text = "$1";
        SPAN_REGEXP14.END = new END[] { END39, };

        SPAN_REGEXP14.BEGIN = new BEGIN[] { BEGIN39, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "COMMENT1";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "\\$-[0adFiIKlpvw](?![\\p{Alnum}_])";
        SEQ_REGEXP2.AT_WORD_START = "TRUE";
        SEQ_REGEXP2.TYPE = "KEYWORD3";
        SEQ_REGEXP2.HASH_CHAR = "$-";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "\\$[0-9!@&\\+`'=~/\\\\,\\.;<>_\\*\"\\$\\?\\:F](?![\\p{Alnum}_])";
        SEQ_REGEXP3.AT_WORD_START = "TRUE";
        SEQ_REGEXP3.TYPE = "KEYWORD3";
        SEQ_REGEXP3.HASH_CHAR = "$";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "defined?";
        SEQ1.AT_WORD_START = "TRUE";
        SEQ1.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP4 = new SEQ_REGEXP();
        SEQ_REGEXP4.text = "include(?![\\p{Alnum}_\\?])";
        SEQ_REGEXP4.AT_WORD_START = "TRUE";
        SEQ_REGEXP4.TYPE = "KEYWORD2";
        SEQ_REGEXP4.HASH_CHAR = "include";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "{";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "}";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "(";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = ")";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "::";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "===";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "=";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = ">>";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "<<";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "<=";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "+";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "-";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "/";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "**";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "*";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "%";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "&";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "|";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "!";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = ">";
        SEQ21.TYPE = "OPERATOR";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "<";
        SEQ22.TYPE = "OPERATOR";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "^";
        SEQ23.TYPE = "OPERATOR";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "~";
        SEQ24.TYPE = "OPERATOR";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "...";
        SEQ25.TYPE = "OPERATOR";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = "..";
        SEQ26.TYPE = "OPERATOR";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "]";
        SEQ27.TYPE = "OPERATOR";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "[";
        SEQ28.TYPE = "OPERATOR";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = "?";
        SEQ29.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP5 = new SEQ_REGEXP();
        SEQ_REGEXP5.text = ":[\\p{Alpha}_][\\p{Alnum}_]*[?]?";
        SEQ_REGEXP5.AT_WORD_START = "TRUE";
        SEQ_REGEXP5.TYPE = "LITERAL4";
        SEQ_REGEXP5.HASH_CHAR = ":";
        SPAN SPAN26 = new SPAN();
        SPAN26.AT_WORD_START = "TRUE";
        SPAN26.TYPE = "LITERAL4";
        BEGIN BEGIN40 = new BEGIN();
        BEGIN40.text = ":'";
        END END40 = new END();
        END40.text = "'";
        SPAN26.END = new END[] { END40, };

        SPAN26.BEGIN = new BEGIN[] { BEGIN40, };

        SPAN SPAN27 = new SPAN();
        SPAN27.AT_WORD_START = "TRUE";
        SPAN27.TYPE = "LITERAL4";
        SPAN27.DELEGATE = "doubleQuoteSymbol";
        BEGIN BEGIN41 = new BEGIN();
        BEGIN41.text = ":\"";
        END END41 = new END();
        END41.text = "\"";
        SPAN27.END = new END[] { END41, };

        SPAN27.BEGIN = new BEGIN[] { BEGIN41, };

        SPAN_REGEXP SPAN_REGEXP15 = new SPAN_REGEXP();
        SPAN_REGEXP15.TYPE = "LITERAL4";
        SPAN_REGEXP15.HASH_CHAR = "%s";
        BEGIN BEGIN42 = new BEGIN();
        BEGIN42.text = "%s([^\\p{Alnum}])";
        END END42 = new END();
        END42.text = "$1";
        SPAN_REGEXP15.END = new END[] { END42, };

        SPAN_REGEXP15.BEGIN = new BEGIN[] { BEGIN42, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"and", "not", "or", });
        KEYWORDS1.add("KEYWORD1", new String[]{"BEGIN", "END", "alias", "begin", "break", "case", "class", "def", "do", "else", "elsif", "end", "ensure", "for", "if", "in", "module", "next", "print", "puts", "redo", "rescue", "retry", "return", "then", "undef", "unless", "until", "when", "while", "yield", });
        KEYWORDS1.add("KEYWORD2", new String[]{"load", "require", "initialize", });
        KEYWORDS1.add("KEYWORD3", new String[]{"false", "nil", "self", "super", "true", "$defout", "$deferr", "$stderr", "$stdin", "$stdout", "$DEBUG", "$FILENAME", "$LOAD_PATH", "$SAFE", "$VERBOSE", "__FILE__", "__LINE__", "ARGF", "ARGV", "ENV", "DATA", "FALSE", "NIL", "RUBY_PLATFORM", "RUBY_RELEASE_DATE", "RUBY_VERSION", "STDERR", "STDIN", "STDOUT", "SCRIPT_LINES__", "TOPLEVEL_BINDING", "TRUE", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, SEQ_REGEXP4, SEQ_REGEXP5, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, SPAN7, SPAN8, SPAN9, SPAN10, SPAN11, SPAN12, SPAN13, SPAN14, SPAN15, SPAN16, SPAN17, SPAN18, SPAN19, SPAN20, SPAN21, SPAN22, SPAN23, SPAN24, SPAN25, SPAN26, SPAN27, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, MARK_FOLLOWING2, MARK_FOLLOWING3, MARK_FOLLOWING4, MARK_FOLLOWING5, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, SPAN_REGEXP3, SPAN_REGEXP4, SPAN_REGEXP5, SPAN_REGEXP6, SPAN_REGEXP7, SPAN_REGEXP8, SPAN_REGEXP9, SPAN_REGEXP10, SPAN_REGEXP11, SPAN_REGEXP12, SPAN_REGEXP13, SPAN_REGEXP14, SPAN_REGEXP15, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "doubleQuoteLiteral";
        RULES1.DEFAULT = "LITERAL1";
        RULES1.ESCAPE = "\\";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "OPERATOR";
        SPAN1.DELEGATE = "MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "#{";
        END END1 = new END();
        END1.text = "}";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "#@@";
        MARK_FOLLOWING1.TYPE = "KEYWORD4";
        MARK_FOLLOWING MARK_FOLLOWING2 = new MARK_FOLLOWING();
        MARK_FOLLOWING2.text = "#@";
        MARK_FOLLOWING2.TYPE = "KEYWORD4";
        MARK_FOLLOWING MARK_FOLLOWING3 = new MARK_FOLLOWING();
        MARK_FOLLOWING3.text = "#$";
        MARK_FOLLOWING3.TYPE = "NULL";
        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, MARK_FOLLOWING2, MARK_FOLLOWING3, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "doubleQuoteSymbol";
        RULES1.DEFAULT = "LITERAL4";
        RULES1.ESCAPE = "\\";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "OPERATOR";
        SPAN1.DELEGATE = "MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "#{";
        END END1 = new END();
        END1.text = "}";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "#@@";
        MARK_FOLLOWING1.TYPE = "KEYWORD4";
        MARK_FOLLOWING MARK_FOLLOWING2 = new MARK_FOLLOWING();
        MARK_FOLLOWING2.text = "#@";
        MARK_FOLLOWING2.TYPE = "KEYWORD4";
        MARK_FOLLOWING MARK_FOLLOWING3 = new MARK_FOLLOWING();
        MARK_FOLLOWING3.text = "#$";
        MARK_FOLLOWING3.TYPE = "NULL";
        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, MARK_FOLLOWING2, MARK_FOLLOWING3, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "BackquoteLiteral";
        RULES1.DEFAULT = "LITERAL2";
        RULES1.ESCAPE = "\\";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "OPERATOR";
        SPAN1.DELEGATE = "MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "#{";
        END END1 = new END();
        END1.text = "}";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "#@@";
        MARK_FOLLOWING1.TYPE = "KEYWORD4";
        MARK_FOLLOWING MARK_FOLLOWING2 = new MARK_FOLLOWING();
        MARK_FOLLOWING2.text = "#@";
        MARK_FOLLOWING2.TYPE = "KEYWORD4";
        MARK_FOLLOWING MARK_FOLLOWING3 = new MARK_FOLLOWING();
        MARK_FOLLOWING3.text = "#$";
        MARK_FOLLOWING3.TYPE = "NULL";
        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, MARK_FOLLOWING2, MARK_FOLLOWING3, };

        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "RegexpLiteral";
        RULES1.DEFAULT = "LITERAL3";
        RULES1.ESCAPE = "\\";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "OPERATOR";
        SPAN1.DELEGATE = "MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "#{";
        END END1 = new END();
        END1.text = "}";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "#@@";
        MARK_FOLLOWING1.TYPE = "KEYWORD4";
        MARK_FOLLOWING MARK_FOLLOWING2 = new MARK_FOLLOWING();
        MARK_FOLLOWING2.text = "#@";
        MARK_FOLLOWING2.TYPE = "KEYWORD4";
        MARK_FOLLOWING MARK_FOLLOWING3 = new MARK_FOLLOWING();
        MARK_FOLLOWING3.text = "#$";
        MARK_FOLLOWING3.TYPE = "NULL";
        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, MARK_FOLLOWING2, MARK_FOLLOWING3, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
