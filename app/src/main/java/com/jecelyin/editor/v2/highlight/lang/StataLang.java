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
public class StataLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "/*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "*/";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "* ";
        PROPERTY3.NAME = "lineComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "{";
        PROPERTY4.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "}";
        PROPERTY5.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "false";
        PROPERTY6.NAME = "doubleBracketIndent";
        PROPERTY PROPERTY7 = new PROPERTY();
        PROPERTY7.VALUE = ",+-=<>/?^&*";
        PROPERTY7.NAME = "wordBreakChars";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(([\\.]?[0-9]+)([eE]?)([-+]*)([0-9]*)) | (([0-9]+\\.*[0-9]*|\\.[0-9]+)([+-]?[eE]?[0-9]+)) | ((([0-9]+\\.[0-9]*|\\.[0-9]+))[Ee]?)";
        RULES1.IGNORE_CASE = "FALSE";
        RULES1.NO_WORD_SEP = "`'_?";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "KEYWORD4";
        SPAN_REGEXP1.DELEGATE = "SEMICOLON_ENV";
        SPAN_REGEXP1.HASH_CHAR = "#d";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "#d[\\s]*[;]";
        END END1 = new END();
        END1.text = "#d cr";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.TYPE = "KEYWORD4";
        SPAN_REGEXP2.DELEGATE = "SEMICOLON_ENV";
        SPAN_REGEXP2.HASH_CHAR = "#del";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "#del[\\s]*[;]";
        END END2 = new END();
        END2.text = "#del cr";
        SPAN_REGEXP2.END = new END[] { END2, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN_REGEXP SPAN_REGEXP3 = new SPAN_REGEXP();
        SPAN_REGEXP3.TYPE = "KEYWORD4";
        SPAN_REGEXP3.DELEGATE = "SEMICOLON_ENV";
        SPAN_REGEXP3.HASH_CHAR = "#del";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "#deli?m?i?t?[\\s]*[;]";
        END END3 = new END();
        END3.text = "#delimit cr";
        SPAN_REGEXP3.END = new END[] { END3, };

        SPAN_REGEXP3.BEGIN = new BEGIN[] { BEGIN3, };

        EOL_SPAN_REGEXP EOL_SPAN_REGEXP1 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP1.text = "mata[\\s]*[:]*[\\s]*(?=[\\w]+)";
        EOL_SPAN_REGEXP1.AT_WHITESPACE_END = "TRUE";
        EOL_SPAN_REGEXP1.TYPE = "KEYWORD1";
        EOL_SPAN_REGEXP1.DELEGATE = "MATA_ENV";
        EOL_SPAN_REGEXP1.HASH_CHAR = "mata";
        SPAN_REGEXP SPAN_REGEXP4 = new SPAN_REGEXP();
        SPAN_REGEXP4.AT_WHITESPACE_END = "TRUE";
        SPAN_REGEXP4.TYPE = "KEYWORD3";
        SPAN_REGEXP4.DELEGATE = "MATA_ENV";
        SPAN_REGEXP4.HASH_CHAR = "mata";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "mata[\\s]*([:]|$)";
        END END4 = new END();
        END4.text = "end";
        SPAN_REGEXP4.END = new END[] { END4, };

        SPAN_REGEXP4.BEGIN = new BEGIN[] { BEGIN4, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "*";
        EOL_SPAN1.AT_WHITESPACE_END = "TRUE";
        EOL_SPAN1.TYPE = "COMMENT1";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "UNIVERSAL";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "KEYWORDLIST";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        RULES1.EOL_SPAN_REGEXP = new EOL_SPAN_REGEXP[] { EOL_SPAN_REGEXP1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, SPAN_REGEXP3, SPAN_REGEXP4, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "UNIVERSAL";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(([\\.]?[0-9]+)([eE]?)([-+]*)([0-9]*)) | (([0-9]+\\.*[0-9]*|\\.[0-9]+)([+-]?[eE]?[0-9]+)) | ((([0-9]+\\.[0-9]*|\\.[0-9]+))[Ee]?)";
        RULES1.IGNORE_CASE = "FALSE";
        RULES1.NO_WORD_SEP = "`'_?";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "//";
        EOL_SPAN1.AT_WHITESPACE_END = "TRUE";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP1 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP1.text = "[\\s]///";
        EOL_SPAN_REGEXP1.TYPE = "COMMENT1";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP2 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP2.text = "[\\s]//";
        EOL_SPAN_REGEXP2.TYPE = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT2";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = ".ado";
        SEQ1.TYPE = "NULL";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ".dct";
        SEQ2.TYPE = "NULL";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = ".do";
        SEQ3.TYPE = "NULL";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = ".dta";
        SEQ4.TYPE = "NULL";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = ".gph";
        SEQ5.TYPE = "NULL";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = ".grec";
        SEQ6.TYPE = "NULL";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = ".log";
        SEQ7.TYPE = "NULL";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = ".mata";
        SEQ8.TYPE = "NULL";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = ".mlib";
        SEQ9.TYPE = "NULL";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = ".mmat";
        SEQ10.TYPE = "NULL";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = ".mo";
        SEQ11.TYPE = "NULL";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = ".out";
        SEQ12.TYPE = "NULL";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = ".raw";
        SEQ13.TYPE = "NULL";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = ".mo";
        SEQ14.TYPE = "NULL";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = ".smcl";
        SEQ15.TYPE = "NULL";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = ".sthlp";
        SEQ16.TYPE = "NULL";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = ".ster";
        SEQ17.TYPE = "NULL";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = ".";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "=";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "!";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = ">=";
        SEQ21.TYPE = "OPERATOR";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "<=";
        SEQ22.TYPE = "OPERATOR";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "+";
        SEQ23.TYPE = "OPERATOR";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "-";
        SEQ24.TYPE = "OPERATOR";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "/";
        SEQ25.TYPE = "OPERATOR";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = ">";
        SEQ26.TYPE = "OPERATOR";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "<";
        SEQ27.TYPE = "OPERATOR";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "&";
        SEQ28.TYPE = "OPERATOR";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = "|";
        SEQ29.TYPE = "OPERATOR";
        SEQ SEQ30 = new SEQ();
        SEQ30.text = "^";
        SEQ30.TYPE = "OPERATOR";
        SEQ SEQ31 = new SEQ();
        SEQ31.text = "~";
        SEQ31.TYPE = "OPERATOR";
        SEQ SEQ32 = new SEQ();
        SEQ32.text = "*";
        SEQ32.TYPE = "OPERATOR";
        SEQ SEQ33 = new SEQ();
        SEQ33.text = ";";
        SEQ33.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "%[^ )]+";
        SEQ_REGEXP1.TYPE = "OPERATOR";
        SEQ_REGEXP1.HASH_CHAR = "%";
        SEQ SEQ34 = new SEQ();
        SEQ34.text = ",";
        SEQ34.TYPE = "NULL";
        SEQ SEQ35 = new SEQ();
        SEQ35.text = "]";
        SEQ35.TYPE = "NULL";
        SEQ SEQ36 = new SEQ();
        SEQ36.text = "[";
        SEQ36.TYPE = "NULL";
        SEQ SEQ37 = new SEQ();
        SEQ37.text = "?";
        SEQ37.TYPE = "NULL";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "L(([\\d]*[.])|([(][\\d]+/[\\d]+[)][.]))";
        SEQ_REGEXP2.AT_WORD_START = "TRUE";
        SEQ_REGEXP2.TYPE = "OPERATOR";
        SEQ_REGEXP2.HASH_CHAR = "L";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "F(([\\d]*[.])|([(][\\d]+/[\\d]+[)][.]))";
        SEQ_REGEXP3.AT_WORD_START = "TRUE";
        SEQ_REGEXP3.TYPE = "OPERATOR";
        SEQ_REGEXP3.HASH_CHAR = "F";
        SEQ_REGEXP SEQ_REGEXP4 = new SEQ_REGEXP();
        SEQ_REGEXP4.text = "D(([\\d]*[.])|([(][\\d]+/[\\d]+[)][.]))";
        SEQ_REGEXP4.AT_WORD_START = "TRUE";
        SEQ_REGEXP4.TYPE = "OPERATOR";
        SEQ_REGEXP4.HASH_CHAR = "D";
        SEQ_REGEXP SEQ_REGEXP5 = new SEQ_REGEXP();
        SEQ_REGEXP5.text = "S(([\\d]*[.])|([(][\\d]+/[\\d]+[)][.]))";
        SEQ_REGEXP5.AT_WORD_START = "TRUE";
        SEQ_REGEXP5.TYPE = "OPERATOR";
        SEQ_REGEXP5.HASH_CHAR = "S";
        SEQ_REGEXP SEQ_REGEXP6 = new SEQ_REGEXP();
        SEQ_REGEXP6.text = "loca?l?((\\s+\\w+)|$)";
        SEQ_REGEXP6.AT_WORD_START = "TRUE";
        SEQ_REGEXP6.TYPE = "LITERAL4";
        SEQ_REGEXP6.HASH_CHAR = "loc";
        SEQ_REGEXP SEQ_REGEXP7 = new SEQ_REGEXP();
        SEQ_REGEXP7.text = "glo?b?a?l?((\\s+\\w+)|$)";
        SEQ_REGEXP7.AT_WORD_START = "TRUE";
        SEQ_REGEXP7.TYPE = "LITERAL4";
        SEQ_REGEXP7.HASH_CHAR = "gl";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "foreach";
        MARK_FOLLOWING1.TYPE = "LITERAL4";
        MARK_FOLLOWING1.MATCH_TYPE = "KEYWORD2";
        MARK_FOLLOWING MARK_FOLLOWING2 = new MARK_FOLLOWING();
        MARK_FOLLOWING2.text = "foreach";
        MARK_FOLLOWING2.TYPE = "LITERAL4";
        MARK_FOLLOWING2.MATCH_TYPE = "KEYWORD2";
        MARK_FOLLOWING MARK_FOLLOWING3 = new MARK_FOLLOWING();
        MARK_FOLLOWING3.text = "forv";
        MARK_FOLLOWING3.TYPE = "LITERAL4";
        MARK_FOLLOWING3.MATCH_TYPE = "KEYWORD2";
        MARK_FOLLOWING MARK_FOLLOWING4 = new MARK_FOLLOWING();
        MARK_FOLLOWING4.text = "forv";
        MARK_FOLLOWING4.TYPE = "LITERAL4";
        MARK_FOLLOWING4.MATCH_TYPE = "KEYWORD2";
        MARK_FOLLOWING MARK_FOLLOWING5 = new MARK_FOLLOWING();
        MARK_FOLLOWING5.text = "forvalues";
        MARK_FOLLOWING5.TYPE = "LITERAL4";
        MARK_FOLLOWING5.MATCH_TYPE = "KEYWORD2";
        MARK_FOLLOWING MARK_FOLLOWING6 = new MARK_FOLLOWING();
        MARK_FOLLOWING6.text = "forvalues";
        MARK_FOLLOWING6.TYPE = "LITERAL4";
        MARK_FOLLOWING6.MATCH_TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP8 = new SEQ_REGEXP();
        SEQ_REGEXP8.text = "tempvar((\\s+\\w+)+|$)";
        SEQ_REGEXP8.AT_WHITESPACE_END = "TRUE";
        SEQ_REGEXP8.TYPE = "LITERAL4";
        SEQ_REGEXP8.HASH_CHAR = "tempvar";
        SEQ_REGEXP SEQ_REGEXP9 = new SEQ_REGEXP();
        SEQ_REGEXP9.text = "tempname((\\s+\\w+)+|$)";
        SEQ_REGEXP9.AT_WHITESPACE_END = "TRUE";
        SEQ_REGEXP9.TYPE = "LITERAL4";
        SEQ_REGEXP9.HASH_CHAR = "tempname";
        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL4";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "${";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        MARK_FOLLOWING MARK_FOLLOWING7 = new MARK_FOLLOWING();
        MARK_FOLLOWING7.text = "$";
        MARK_FOLLOWING7.TYPE = "LITERAL4";
        MARK_FOLLOWING7.MATCH_TYPE = "RULE";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "NULL";
        SEQ SEQ38 = new SEQ();
        SEQ38.text = ")";
        SEQ38.TYPE = "NULL";
        SEQ_REGEXP SEQ_REGEXP10 = new SEQ_REGEXP();
        SEQ_REGEXP10.text = "capt?u?r?e?[\\s]+log([\\s]+|$)";
        SEQ_REGEXP10.AT_WHITESPACE_END = "TRUE";
        SEQ_REGEXP10.TYPE = "KEYWORD3";
        SEQ_REGEXP10.HASH_CHAR = "cap";
        SEQ_REGEXP SEQ_REGEXP11 = new SEQ_REGEXP();
        SEQ_REGEXP11.text = "run?([\\s]+|$)";
        SEQ_REGEXP11.AT_WHITESPACE_END = "TRUE";
        SEQ_REGEXP11.TYPE = "KEYWORD3";
        SEQ_REGEXP11.HASH_CHAR = "ru";
        SEQ_REGEXP SEQ_REGEXP12 = new SEQ_REGEXP();
        SEQ_REGEXP12.text = "log([\\s]+|$)";
        SEQ_REGEXP12.AT_WORD_START = "TRUE";
        SEQ_REGEXP12.TYPE = "KEYWORD3";
        SEQ_REGEXP12.HASH_CHAR = "log";
        SEQ_REGEXP SEQ_REGEXP13 = new SEQ_REGEXP();
        SEQ_REGEXP13.text = "do([\\s]+|$)";
        SEQ_REGEXP13.AT_WORD_START = "TRUE";
        SEQ_REGEXP13.TYPE = "KEYWORD3";
        SEQ_REGEXP13.HASH_CHAR = "do";
        SEQ_REGEXP SEQ_REGEXP14 = new SEQ_REGEXP();
        SEQ_REGEXP14.text = "set[\\s]+(obs)(([\\s]+(?![\\D]+))|$)";
        SEQ_REGEXP14.AT_WORD_START = "TRUE";
        SEQ_REGEXP14.TYPE = "KEYWORD3";
        SEQ_REGEXP14.HASH_CHAR = "set";
        SEQ_REGEXP SEQ_REGEXP15 = new SEQ_REGEXP();
        SEQ_REGEXP15.text = "label([\\s]+(drop)([\\s]+|$))";
        SEQ_REGEXP15.AT_WORD_START = "TRUE";
        SEQ_REGEXP15.TYPE = "KEYWORD2";
        SEQ_REGEXP15.HASH_CHAR = "label";
        SEQ_REGEXP SEQ_REGEXP16 = new SEQ_REGEXP();
        SEQ_REGEXP16.text = "macro([\\s]+(drop)([\\s]+|$))";
        SEQ_REGEXP16.AT_WORD_START = "TRUE";
        SEQ_REGEXP16.TYPE = "KEYWORD1";
        SEQ_REGEXP16.HASH_CHAR = "macro";
        SEQ_REGEXP SEQ_REGEXP17 = new SEQ_REGEXP();
        SEQ_REGEXP17.text = "drop([\\s]+(?!if|[=])|$)";
        SEQ_REGEXP17.AT_WORD_START = "TRUE";
        SEQ_REGEXP17.TYPE = "KEYWORD3";
        SEQ_REGEXP17.HASH_CHAR = "drop";
        SEQ_REGEXP SEQ_REGEXP18 = new SEQ_REGEXP();
        SEQ_REGEXP18.text = "keep([\\s]+(?!if|[=])|$)";
        SEQ_REGEXP18.AT_WORD_START = "TRUE";
        SEQ_REGEXP18.TYPE = "KEYWORD3";
        SEQ_REGEXP18.HASH_CHAR = "keep";
        SEQ_REGEXP SEQ_REGEXP19 = new SEQ_REGEXP();
        SEQ_REGEXP19.text = "set(?!([\\s]+[\\w]+[\\s]*[=]))";
        SEQ_REGEXP19.AT_WHITESPACE_END = "TRUE";
        SEQ_REGEXP19.TYPE = "KEYWORD4";
        SEQ_REGEXP19.HASH_CHAR = "set";
        SEQ_REGEXP SEQ_REGEXP20 = new SEQ_REGEXP();
        SEQ_REGEXP20.text = "mata[\\s]+set([\\s]+|$)";
        SEQ_REGEXP20.AT_WHITESPACE_END = "TRUE";
        SEQ_REGEXP20.TYPE = "KEYWORD4";
        SEQ_REGEXP20.HASH_CHAR = "mata";
        SEQ_REGEXP SEQ_REGEXP21 = new SEQ_REGEXP();
        SEQ_REGEXP21.text = "shell([\\s]+|$)";
        SEQ_REGEXP21.AT_WHITESPACE_END = "TRUE";
        SEQ_REGEXP21.TYPE = "KEYWORD4";
        SEQ_REGEXP21.HASH_CHAR = "shell";
        SEQ_REGEXP SEQ_REGEXP22 = new SEQ_REGEXP();
        SEQ_REGEXP22.text = "sysdir([\\s]+|$)";
        SEQ_REGEXP22.AT_WHITESPACE_END = "TRUE";
        SEQ_REGEXP22.TYPE = "KEYWORD4";
        SEQ_REGEXP22.HASH_CHAR = "sysdir";
        SEQ_REGEXP SEQ_REGEXP23 = new SEQ_REGEXP();
        SEQ_REGEXP23.text = "c\\((\\w+)\\)";
        SEQ_REGEXP23.AT_WORD_START = "TRUE";
        SEQ_REGEXP23.TYPE = "KEYWORD2";
        SEQ_REGEXP23.HASH_CHAR = "c";
        SEQ_REGEXP SEQ_REGEXP24 = new SEQ_REGEXP();
        SEQ_REGEXP24.text = "str(\\d+)";
        SEQ_REGEXP24.AT_WORD_START = "TRUE";
        SEQ_REGEXP24.TYPE = "KEYWORD2";
        SEQ_REGEXP24.HASH_CHAR = "str";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "STRINGMACRO";
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, SEQ_REGEXP4, SEQ_REGEXP5, SEQ_REGEXP6, SEQ_REGEXP7, SEQ_REGEXP8, SEQ_REGEXP9, SEQ_REGEXP10, SEQ_REGEXP11, SEQ_REGEXP12, SEQ_REGEXP13, SEQ_REGEXP14, SEQ_REGEXP15, SEQ_REGEXP16, SEQ_REGEXP17, SEQ_REGEXP18, SEQ_REGEXP19, SEQ_REGEXP20, SEQ_REGEXP21, SEQ_REGEXP22, SEQ_REGEXP23, SEQ_REGEXP24, };

        RULES1.EOL_SPAN_REGEXP = new EOL_SPAN_REGEXP[] { EOL_SPAN_REGEXP1, EOL_SPAN_REGEXP2, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, SEQ30, SEQ31, SEQ32, SEQ33, SEQ34, SEQ35, SEQ36, SEQ37, SEQ38, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, MARK_FOLLOWING2, MARK_FOLLOWING3, MARK_FOLLOWING4, MARK_FOLLOWING5, MARK_FOLLOWING6, MARK_FOLLOWING7, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "SEMICOLON_ENV";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(([\\.]?[0-9]+)([eE]?)([-+]*)([0-9]*)) | (([0-9]+\\.*[0-9]*|\\.[0-9]+)([+-]?[eE]?[0-9]+)) | ((([0-9]+\\.[0-9]*|\\.[0-9]+))[Ee]?)";
        RULES1.IGNORE_CASE = "FALSE";
        RULES1.NO_WORD_SEP = "`'_?";
        SPAN SPAN1 = new SPAN();
        SPAN1.AT_WHITESPACE_END = "TRUE";
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "*";
        END END1 = new END();
        END1.text = ";";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        EOL_SPAN_REGEXP EOL_SPAN_REGEXP1 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP1.text = "[\\s]///";
        EOL_SPAN_REGEXP1.TYPE = "COMMENT1";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP2 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP2.text = "[\\s]//";
        EOL_SPAN_REGEXP2.TYPE = "COMMENT1";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "UNIVERSAL";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "KEYWORDLIST";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        RULES1.EOL_SPAN_REGEXP = new EOL_SPAN_REGEXP[] { EOL_SPAN_REGEXP1, EOL_SPAN_REGEXP2, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "MATA_ENV";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(([\\.]?[0-9]+)([eE]?)([-+]*)([0-9]*)) | (([0-9]+\\.*[0-9]*|\\.[0-9]+)([+-]?[eE]?[0-9]+)) | ((([0-9]+\\.[0-9]*|\\.[0-9]+))[Ee]?)";
        RULES1.IGNORE_CASE = "FALSE";
        RULES1.NO_WORD_SEP = "`'_?";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "do([\\s]+|$)";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "KEYWORD2";
        SEQ_REGEXP1.HASH_CHAR = "do";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "UNIVERSAL";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"array", "colvector", "external", "mata", "matrix", "mlib", "pointer", "real", "rowvector", "scalar", "string", "struct", "transmorphic", "vector", "version", "void", "delete", "describe", });
        KEYWORDS1.add("KEYWORD2", new String[]{"if", "else", "for", "goto", "while", "this", "do", "return", "break", "continue", "add", "create", "index", "replace", "using", "byte", "int", "long", "float", "double", "quad", "short", "boolean", "complex", "const", "aggregate", "case", "catch", "class", "default", "delegate", "case", "eltypedef", "enum", "explicit", "export", "external", "friend", "function", "inline", "namespace", "new", "NULL", "numeric", "operator", "orgtypedef", "pointer", "polymorphic", "pragma", "private", "protected", "public", "signed", "static", "super", "switch", "template", "throw", "transmorphic", "try", "typedef", "typename", "union", "unsigned", "virtual", "volatile", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "KEYWORDLIST";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(([\\.]?[0-9]+)([eE]?)([-+]*)([0-9]*)) | (([0-9]+\\.*[0-9]*|\\.[0-9]+)([+-]?[eE]?[0-9]+)) | ((([0-9]+\\.[0-9]*|\\.[0-9]+))[Ee]?)";
        RULES1.IGNORE_CASE = "FALSE";
        RULES1.NO_WORD_SEP = "`'_?";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"di", "disp", "display", "outtex", "outreg", "printf", "count", "describe", "list", "errprintf", "more", "cmdlog", "close", "_rc", "_b", "_coef", "_cons", "_n", "_N", "_pi", "_rc", "_se", "_3dax0", "_3daxmin", "_3daxout", "_3daxtbl", "_3ddflts", "_3dmkdta", "_3dmnmx", "_3dproj", "_3drproj", "_3drshow", "_3dshad", "_3dsvusr", "__GEEBT", "__GEERC", "__GEEUC", "_a_cls_msg", "_ac", "_addgph", "_addl", "_addop", "_adjksm", "_assert", "_assert_mreldif", "_assert_mreldifp", "_assert_mreldifs", "_assert_obs", "_assert_streq", "_at", "_bigtab", "_binperfect", "_binperfout", "_biplotmat", "_brr_sum", "_bs_display", "_bs_sum", "_bsqreg", "_btcmd", "_byobs", "_byoptnotallowed", "_ca_parse_normalize", "_ca_process_mlabel", "_callerr", "_cci", "_check4gropts", "_check_eformopt", "_choice_table", "_ckirfset", "_cknotsvaroi", "_ckvec", "_clsarr2list", "_cmdxel", "_coef_table", "_coef_table_header", "_column", "_confirm_date", "_confirm_number_or_date", "_copy_mat_stripes", "_cpmatnm", "_cr1form", "_cr1invt", "_cr1se", "_cr1t", "_crc2use", "_crc4fld", "_crcacnt", "_crcar1", "_crcause", "_crcbcrt", "_crcbin", "_crcbygr", "_crcchi2", "_crcchkt", "_crcchkw", "_crcci", "_crccip", "_crceprs", "_crcexn1", "_crcexn2", "_crcexn4", "_crcexn5", "_crcexn6", "_crcexn7", "_crcexn8", "_crcexn9", "_crcexna", "_crcexnb", "_crcexnc", "_crcexnd", "_crcexne", "_crcexnf", "_crcexnt", "_crcgldv", "_crcglil", "_crcichi", "_crcird", "_crcirr", "_crcksm", "_crclf", "_crcmeq", "_crcmiss", "_crcnlou", "_crcnms2", "_crcnuse", "_crcor", "_crcphdr", "_crcplst", "_crcra", "_crcrd", "_crcrnfd", "_crcrr", "_crcrsfl", "_crcseq", "_crcshdr", "_crcslbl", "_crcsrv2", "_crcsrvc", "_crcstep", "_crcswxx", "_crct", "_crctmge", "_crcunab", "_crcunit", "_crcvarl", "_crcwsrv", "_crczsku", "_cu_c0", "_cvar", "_date2elapsed", "_diag2mat", "_diparm", "_diparm_8", "_dm_create", "_dots", "_e2r", "_egennoby", "_evlist", "_exp_list_expand", "_exp_list_parse", "_find_tsops", "_fr_area_parse_and_log", "_fr_aspect_parse_and_log", "_fr_draw_rect", "_fr_droplines_draw", "_fr_erasearr", "_fr_legend_parse_and_log", "_fr_merged_implicit", "_fr_runlog", "_fr_sztextbox_parse_and_log", "_fr_tbstyle_parse_and_log", "_fr_tedits_parse_and_log", "_fr_textbox_parse_and_log", "_fr_title_parse_and_log", "_fr_x_log_cleanup", "_fr_x_log_create", "_fracchk", "_fraccox", "_fracddp", "_fracdis", "_fracdv", "_fracin", "_fracmdp", "_fracord", "_fracpp", "_fracpv", "_fracrep", "_fracwgt", "_fracxo", "_frr_sztextbox_pnl", "_gany", "_ganycount", "_ganymatch", "_ganyvalue", "_gconcat", "_gcount", "_gcut", "_gdiff", "_gends", "_geqany", "_get_diparmopts", "_get_diparmopts_8", "_get_eformopts", "_get_eqspec", "_get_gropts", "_get_irf", "_get_offopt", "_getbv", "_getcovcorr", "_getfilename", "_getnewlabelname", "_getrhs", "_getrres", "_getvarcns", "_getxel", "_getxel2", "_gfill", "_ggroup", "_giqr", "_gkurt", "_gladder", "_glmfl", "_glmilnk", "_glmmapf", "_glmmapl", "_glmresd", "_glmrpt", "_glmwgt", "_gm_edit", "_gm_log", "_gma", "_gmad", "_gmax", "_gmdev", "_gmdmean", "_gmdmed", "_gmean", "_gmedian", "_gmin", "_gmode", "_gmtr", "_gneqany", "_gpc", "_gpctile", "_gr_arrowhead", "_gr_atomize_styles", "_gr_common_axes", "_gr_drawrect", "_gr_linkstyles", "_gr_symbol_of", "_grank", "_grank2", "_grfirst", "_grlast", "_grmax", "_grmean", "_grmin", "_grmiss", "_grmiss2", "_grobs", "_growfirst", "_growlast", "_growmax", "_growmean", "_growmin", "_growmiss", "_grownonmiss", "_growsd", "_growtotal", "_grsd", "_grsum", "_gs_addgrname", "_gs_bygraph", "_gs_clean_graphlist", "_gs_default_bands", "_gs_islivefile", "_gs_parse_and_log_axoptions", "_gs_parse_and_log_axtitle", "_gs_parse_and_log_lines", "_gs_parse_and_log_tickset", "_gs_rdfilehdr", "_gs_wrfilehdr", "_gs_x_create", "_gsd", "_gseq", "_gskew", "_gsrank", "_gstd", "_gsum", "_gtag", "_gtma", "_gtotal", "_gtrank", "_hadamard_verify", "_hu", "_hub", "_hube", "_huber", "_hw_comp", "_hw_opt_d0", "_hwsa_comp", "_hwsa_opt_d0", "_hwsm_comp", "_hwsm_opt_d0", "_inlist", "_invlist", "_isfit", "_ivreg_project", "_jk_nlegend", "_jk_pseudo", "_jk_sum", "_jprfpdt", "_jprfpdx", "_jprfpfp", "_jprfpgn", "_jprfpin", "_jprfplx", "_jprfpmm", "_jprfppp", "_jprfpre", "_jprfprp", "_jprfpse", "_jprfptp", "_jprfpxo", "_jprglef", "_jprglfl", "_jprglil", "_jprglld", "_jprglwz", "_jprxrpa", "_kalman1", "_ksmwrk", "_labels2names", "_ldrtest", "_linemax", "_line", "_lines", "_loop_brr", "_loop_jknife", "_loop_jknife2", "_loop_jknife_fw", "_loop_jknife_iw", "_loop_rw", "_lrtest7", "_m2matrix", "_m2scalar", "_maked", "_mat_clean_coleq", "_matplot", "_matsort", "_mdisplay", "_mds_classical", "_mds_dataheader", "_mds_display", "_mds_display_classical", "_mds_euclidean", "_mds_parse_dopts", "_mds_parse_method", "_mds_parse_s2d", "_mds_s2d", "_me_der", "_me_der2", "_me_derb", "_me_derd", "_me_l_der", "_me_l_der2", "_mfrmvec", "_mka2", "_mkg", "_mkkmn", "_mksigma", "_mkvec", "_mprobitestimator", "_mtest", "_mvec", "_newey", "_nlout", "_no_estat", "_no_predict", "_nobs", "_on_colon_parse", "_opnum", "_parmlist", "_parse_optexp", "_parsevl", "_parsewt", "_partset", "_pctile", "_pk_p", "_plotpos", "_pred_me", "_pred_missings", "_pred_rules", "_pred_se", "_predict", "_prefix_check4esample", "_prefix_checkopt", "_prefix_clear", "_prefix_command", "_prefix_depvarblocklist", "_prefix_display", "_prefix_expand", "_prefix_explist", "_prefix_footnote", "_prefix_getchars", "_prefix_getmat", "_prefix_legend", "_prefix_mlogit", "_prefix_model_test", "_prefix_note", "_prefix_reject", "_prefix_relabel_eqns", "_prefix_run_error", "_prefix_saving", "_prefix_title", "_prefix_varblocklist", "_prefix_vcenotallowed", "_qreg", "_qregwls", "_qsort_index", "_qsur", "_r2e", "_repart", "_repost", "_resample_warn", "_restore_labels", "_result", "_returnclear", "_rmcoll", "_rmcollright", "_rmdcoll", "_robksm", "_robust", "_robust2", "_roccom1", "_roccom1_8", "_rocsen", "_rotate_clear", "_rotate_text", "_score_spec", "_sep_varsylags", "_set_irf_vars", "_sfran", "_shortenpath", "_sigfm", "_small2dotz", "_stata_internalerror", "_stcurv", "_strip_labels", "_sttrend", "_stubstar2names", "_subchar", "_sum_table", "_sumaccum", "_sunflower_binar", "_svar_cnsmac", "_svar_eqmac", "_svar_newcns", "_svar_post", "_svard2", "_svariden", "_svaridenlr", "_svarlrd2", "_svd", "_svy", "_svy2", "_svy_check_cmdopts", "_svy_check_fpc", "_svy_check_postw", "_svy_check_predict", "_svy_check_vce", "_svy_fpc_note", "_svy_ftest", "_svy_ivreg_first", "_svy_mkdeff", "_svy_mkmeff", "_svy_mkvmsp", "_svy_mkvsrs", "_svy_newrule", "_svy_setup", "_svy_singleton_note", "_svy_subpop", "_svy_subpop_note", "_svy_summarize", "_svy_summarize_legend", "_svy_tabulate", "_svydes_dlg", "_svylc", "_svyset", "_sw_lik", "_sw_lik2", "_sw_ood", "_ts", "_ts_dexp", "_ts_dsmp", "_ts_exp", "_ts_flag", "_ts_gdat", "_ts_hw", "_ts_hwsa", "_ts_hwsm", "_ts_meqn", "_ts_pars", "_ts_peri", "_tsheadr", "_tsinchk", "_tsma", "_ttest", "_ttest1", "_ttest2", "_tutends", "_tx_mtr1", "_tx_mtr2", "_tx_mtr3", "_tx_mtr4", "_tx_mtr5", "_tx_rpl", "_var_mka", "_varbsf", "_vardisprmse", "_varfcast", "_varfcast_clear", "_varfcast_fcast", "_varfcast_graph", "_varirf", "_varsim", "_vce_parserun", "_vec_ckgraph", "_vec_dreduced", "_vec_grcroots", "_vec_opck", "_vec_pgparse", "_vec_pgridplots", "_vec_postvar", "_vecauxdisp", "_vecfcast_compute", "_vecfcast_compute_w", "_vecgetacns", "_vecgetcv", "_vecgtn", "_vecmka", "_vecmkapvp", "_vecmkce", "_vecmkgam", "_vecmksi", "_vecmktrend", "_vecortho", "_vecpclean", "_vectparse", "_vecu", "_virf_add", "_virf_char", "_virf_fck", "_virf_mknewfile", "_virf_nlen", "_virf_use", "_wkapm", "_writenum", "_wsrvcrv", "_xtreg_chk_cl", "_xtreg_chk_cl2", "_xtrenorm", "about", "abs", "ac", "ac_7", "acprplot", "acprplot_7", "adjust", "ado", "adopath", "adoupdate", "alpha", "ameans", "an", "ano", "anov", "anova", "anova_estat", "anova_terms", "anovadef", "aorder", "arch", "arch_dr", "arch_estat", "arch_p", "archlm", "areg", "areg_p", "args", "arima", "arima_dr", "arima_estat", "arima_p", "as", "asmprobit", "asmprobit_estat", "asmprobit_lf", "asmprobit_mfx__dlg", "asmprobit_p", "ass", "asse", "asser", "assert", "avplot", "avplot_7", "avplots", "avplots_7", "bcskew0", "be", "bee", "beep", "bgodfrey", "binreg", "bip0_lf", "bip0_lf7", "biplot", "bipp_lf", "bipp_lf7", "bipr_lf", "bipr_lf7", "bipr_p", "bipr_p7", "biprobit", "biprobit7", "bitest", "bitesti", "bitowt", "blogit", "bmemsize", "boot", "bootsamp", "bootstrap", "bootstrap_8", "boxco_l", "boxco_p", "boxcox", "boxcox_6", "boxcox_p", "bprobit", "break", "brier", "brr", "brrstat", "bs", "bs_7", "bsampl_w", "bsample", "bsample_7", "bsqreg", "bstat", "bstat_7", "bstat_8", "bstrap", "bstrap_7", "c_local", "ca", "ca_estat", "ca_p", "cabiplot", "camat", "canon", "canon_8", "canon_8_p", "canon_estat", "canon_p", "caprojection", "cat", "cc", "cchart", "cchart_7", "cci", "cd", "censobs_table", "centile", "cf", "char", "chdir", "checkdlgfiles", "checkestimationsample", "checkhlpfiles", "checksum", "ci", "cii", "cksum", "clear", "clo", "clocal", "clog", "clog_lf", "clog_p", "clogi", "clogi_sw", "clogit", "clogit_lf", "clogit_p", "clogitp", "clogl_sw", "cloglog", "clonevar", "clslistarray", "cluster", "cluster_measures", "cluster_stop", "cluster_tree", "cluster_tree_8", "clustermat", "cnr", "cnre", "cnreg", "cnreg_p", "cnreg_sw", "cnsreg", "codebook", "collaps4", "collapse", "colormult_nb", "colormult_nw", "conf", "confi", "confir", "confirm", "conren", "cons", "const", "constr", "constra", "constrai", "constrain", "constraint", "contract", "copy", "copyright", "copysource", "cor", "corc", "corr", "corr2data", "corr_anti", "corr_kmo", "corr_smc", "corre", "correl", "correla", "correlat", "correlate", "corrgram", "cou", "coun", "count", "cox", "cox_p", "cox_sw", "coxbase", "coxhaz", "coxvar", "cp", "cprplot", "cprplot_7", "crc", "cross", "cs", "cscript", "cscript_log", "csi", "ct", "ct_is", "ctset", "ctst_5", "ctst_st", "cttost", "cumsp", "cumsp_7", "cumul", "cusum", "cusum_7", "cutil", "d", "datetof", "db", "dbeta", "de", "debug", "debugbuf", "dec", "deco", "decod", "decode", "deff", "des", "desc", "descr", "descri", "describ", "describe", "destring", "dfbeta", "dfgls", "dfuller", "diff", "dir", "dirstats", "discard", "disp_res", "disp_s", "doe", "doed", "doedi", "doedit", "dotplot", "dotplot_7", "dprobit", "drawnorm", "ds", "ds_util", "dstdize", "duplicates", "durbina", "dwstat", "dydx", "dynre", "dynren", "ed", "edi", "edit", "egen", "eivreg", "emdef", "en", "enc", "enco", "encod", "encode", "enter", "ereg", "ereg_lf", "ereg_p", "ereg_sw", "ereghet", "ereghet_glf", "ereghet_glf_sh", "ereghet_gp", "ereghet_ilf", "ereghet_ilf_sh", "ereghet_ip", "err", "erro", "error", "estimates", "estimate", "estimat", "estima", "estim", "esti", "est", "est_cfexist", "est_cfname", "est_clickable", "est_expand", "est_hold", "est_table", "est_unhold", "est_unholdok", "estat", "estat_default", "estat_summ", "estat_vce_only", "esti", "estim", "estima", "estimat", "estimate", "etodow", "etof", "etomdy", "ex", "exec", "execu", "execut", "execute", "exi", "exit", "expandcl", "export", "fac", "fact", "facto", "factor", "factor_estat", "factor_p", "factor_pca_rotated", "factor_rotate", "factormat", "failure", "fcast", "fcast_compute", "fcast_graph", "fft", "fh_st", "fillin", "find_hlp_file", "findit", "findit_7", "fit", "for5_0", "force", "form", "forma", "format", "fpredict", "frac_154", "frac_adj", "frac_chk", "frac_cox", "frac_ddp", "frac_dis", "frac_dv", "frac_in", "frac_mun", "frac_pp", "frac_pq", "frac_pv", "frac_wgt", "frac_xo", "fracgen", "fracplot", "fracplot_7", "fracpoly", "fracpred", "fron_ex", "fron_hn", "fron_p", "fron_tn", "fron_tn2", "frontier", "ftodate", "ftoe", "ftomdy", "ftowdate", "g", "gamhet_glf", "gamhet_gp", "gamhet_ilf", "gamhet_ip", "gamma", "gamma_d2", "gamma_lf", "gamma_p", "gamma_sw", "gammahet", "gdi_hexagon", "gdi_spokes", "ge", "gen", "gene", "gener", "genera", "generat", "generate", "genrank", "genstd", "genvmean", "gettoken", "gl", "gladder", "gladder_7", "glim_l01", "glim_l02", "glim_l03", "glim_l04", "glim_l05", "glim_l06", "glim_l07", "glim_l08", "glim_l09", "glim_l10", "glim_l11", "glim_l12", "glim_lf", "glim_mu", "glim_nw1", "glim_nw2", "glim_nw3", "glim_p", "glim_v1", "glim_v2", "glim_v3", "glim_v4", "glim_v5", "glim_v6", "glim_v7", "glm", "glm_6", "glm_p", "glm_sw", "glmpred", "glogit", "glogit_8", "glogit_p", "gmeans", "gnbre_lf", "gnbreg", "gnbreg_5", "gnbreg_p", "gomp_lf", "gompe_sw", "gomper_p", "gompertz", "gompertzhet", "gomphet_glf", "gomphet_glf_sh", "gomphet_gp", "gomphet_ilf", "gomphet_ilf_sh", "gomphet_ip", "gph", "gphdot", "gphpen", "gphprint", "gprobi_p", "gprobit", "gprobit_8", "gr", "gr_copy", "gr_current", "gr_db", "gr_describe", "gr_dir", "gr_draw", "gr_draw_replay", "gr_drop", "gr_edit", "gr_editviewopts", "gr_example", "gr_example2", "gr_export", "gr_print", "gr_qscheme", "gr_query", "gr_read", "gr_rename", "gr_replay", "gr_save", "gr_set", "gr_setscheme", "gr_table", "gr_undo", "gr_use", "gra", "grap", "graph", "grebar", "greigen", "greigen_7", "greigen_8", "grmeanby", "grmeanby_7", "gs_fileinfo", "gs_filetype", "gs_graphinfo", "gs_stat", "gsort", "gwood", "h", "hadimvo", "hareg", "hausman", "he", "heck_d2", "heckma_p", "heckman", "heckp_lf", "heckpr_p", "heckprob", "hel", "help", "helpchk", "hereg", "hetpr_lf", "hetpr_p", "hetprob", "hettest", "hilite", "hist", "hist_7", "histogram", "hlogit", "hlu", "hmeans", "hotel", "hotelling", "hprobit", "hreg", "hsearch", "icd9", "icd9_ff", "icd9p", "id", "iis", "impute", "imtest", "inbase", "inf", "infi", "infil", "infile", "infix", "inflate", "inp", "inpu", "input", "ins", "insh", "inshe", "inshee", "insheet", "insp", "inspe", "inspec", "inspect", "integ", "inten", "intreg", "intreg_7", "intreg_p", "intrg2_ll", "intrg_ll", "intrg_ll2", "ipolate", "iqreg", "ir", "irf", "irf_create", "irfm", "iri", "is_svy", "is_svysum", "isid", "istdize", "ivprob_1_lf", "ivprob_lf", "ivprobit", "ivprobit_p", "ivreg", "ivreg_footnote", "ivtob_1_lf", "ivtob_lf", "ivtobit", "ivtobit_p", "jackknife", "jacknife", "jknife", "jknife_6", "jknife_8", "jkstat", "joinby", "kalarma1", "kap", "kap_3", "kapmeier", "kappa", "kapwgt", "kdensity", "kdensity_7", "ksm", "ksmirnov", "ktau", "kwallis", "l", "la", "labelbook", "ladder", "level", "levels", "levelsof", "leverage", "lfit", "lfit_p", "li", "lincom", "line", "linktest", "lis", "list", "lloghet_glf", "lloghet_glf_sh", "lloghet_gp", "lloghet_ilf", "lloghet_ilf_sh", "lloghet_ip", "llogi_sw", "llogis_p", "llogist", "llogistic", "llogistichet", "lnorm_lf", "lnorm_sw", "lnorma_p", "lnormal", "lnormalhet", "lnormhet_glf", "lnormhet_glf_sh", "lnormhet_gp", "lnormhet_ilf", "lnormhet_ilf_sh", "lnormhet_ip", "lnskew0", "lo", "loadingplot", "logi", "logis_lf", "logistic", "logistic_p", "logit", "logit_estat", "logit_p", "loglogs", "logrank", "loneway", "loo", "look", "lookfor", "looku", "lookup", "lowess", "lowess_7", "lpredict", "lrecomp", "lroc", "lroc_7", "lrtest", "lsens", "lsens_7", "lsens_x", "lstat", "ltable", "ltable_7", "ltriang", "lv", "lvr2plot", "lvr2plot_7", "ma", "mac", "macr", "macro", "makecns", "man", "manova_estat", "manova_p", "mantel", "mark", "markout", "marksample", "mat", "mat_capp", "mat_order", "mat_rapp", "mata", "mata_matdescribe", "mata_matsave", "mata_matuse", "matalabel", "matcproc", "matlist", "matname", "matr", "matri", "matrix", "matrix_input__dlg", "matsize", "matstrik", "mcc", "mcci", "md0_", "md1_", "md1debu_", "md1debug_", "md2_", "md2debu_", "md2debug_", "mds", "mds_estat", "mds_p", "mdsconfig", "mdslong", "mdsmat", "mdsshepard", "mdytoe", "mdytof", "me_derd", "mean", "means", "median", "memory", "memsize", "meqparse", "mfp", "mfx", "mhelp", "mhodds", "mixed_ll", "mixed_ll_reparm", "mkassert", "mkdir", "mkmat", "mkspline", "ml", "ml_5", "ml_adjs", "ml_bhhhs", "ml_c_d", "ml_check", "ml_clear", "ml_cnt", "ml_debug", "ml_defd", "ml_e0", "ml_e0_bfgs", "ml_e0_cycle", "ml_e0_dfp", "ml_e0i", "ml_e1", "ml_e1_bfgs", "ml_e1_bhhh", "ml_e1_cycle", "ml_e1_dfp", "ml_e2", "ml_e2_cycle", "ml_ebfg0", "ml_ebfr0", "ml_ebfr1", "ml_ebh0q", "ml_ebhh0", "ml_ebhr0", "ml_ebr0i", "ml_ecr0i", "ml_edfp0", "ml_edfr0", "ml_edfr1", "ml_edr0i", "ml_eds", "ml_eer0i", "ml_egr0i", "ml_elf", "ml_elf_bfgs", "ml_elf_bhhh", "ml_elf_cycle", "ml_elf_dfp", "ml_elfi", "ml_elfs", "ml_enr0i", "ml_enrr0", "ml_erdu0", "ml_erdu0_bfgs", "ml_erdu0_bhhh", "ml_erdu0_bhhhq", "ml_erdu0_cycle", "ml_erdu0_dfp", "ml_erdu0_nrbfgs", "ml_exde", "ml_footnote", "ml_geqnr", "ml_grad0", "ml_graph", "ml_hbhhh", "ml_hd0", "ml_hold", "ml_init", "ml_inv", "ml_log", "ml_max", "ml_mlout", "ml_mlout_8", "ml_model", "ml_nb0", "ml_opt", "ml_p", "ml_plot", "ml_query", "ml_rdgrd", "ml_repor", "ml_s_e", "ml_score", "ml_searc", "ml_technique", "ml_unhold", "mleval", "mlf_", "mlmatsum", "mlog", "mlogi", "mlogit", "mlogit_footnote", "mlogit_p", "mlopts", "mlsum", "mlvecsum", "mmerge", "mnl0_", "mor", "more", "mov", "move", "mprobit", "mprobit_lf", "mprobit_p", "mrdu0_", "mrdu1_", "mvdecode", "mvencode", "mvreg", "mvreg_estat", "n", "nbreg", "nbreg_al", "nbreg_lf", "nbreg_p", "nbreg_sw", "nestreg", "net", "newey", "newey_7", "newey_p", "news", "nl", "nl_7", "nl_9", "nl_9_p", "nl_p", "nl_p_7", "nlcom", "nlcom_p", "nlexp2", "nlexp2_7", "nlexp2a", "nlexp2a_7", "nlexp3", "nlexp3_7", "nlgom3", "nlgom3_7", "nlgom4", "nlgom4_7", "nlinit", "nllog3", "nllog3_7", "nllog4", "nllog4_7", "nlog_rd", "nlogit", "nlogit_p", "nlogitgen", "nlogittree", "nlpred", "no", "nobreak", "noi", "nois", "noisi", "noisil", "noisily", "nostop", "note", "notes", "notify", "nptrend", "numlabel", "numlist", "off", "old_ver", "olo", "olog", "ologi", "ologi_sw", "ologit", "ologit_p", "ologitp", "on", "one", "onew", "onewa", "oneway", "op_colnm", "op_comp", "op_diff", "op_inv", "op_str", "opr", "opro", "oprob", "oprob_sw", "oprobi", "oprobi_p", "oprobit", "oprobitp", "opts_exclusive", "order", "orthog", "orthpoly", "ou", "out", "outf", "outfi", "outfil", "outfile", "outs", "outsh", "outshe", "outshee", "outsheet", "ovtest", "pac", "pac_7", "palette", "par", "pars", "parse", "parse_dissim", "pause", "pca", "pca_8", "pca_display", "pca_estat", "pca_p", "pca_rotate", "pcamat", "pchart", "pchart_7", "pchi", "pchi_7", "pcorr", "pctile", "pentium", "pergram", "pergram_7", "permute", "permute_8", "personal", "peto_st", "pkcollapse", "pkcross", "pkequiv", "pkexamine", "pkexamine_7", "pkshape", "pksumm", "pksumm_7", "pl", "playsnd", "plo", "plot", "plug", "plugi", "plugin", "pnorm", "pnorm_7", "poisgof", "poiss_lf", "poiss_sw", "poisso_p", "poisson", "poisson_estat", "pop", "popu", "popup", "post", "postclose", "postfile", "pperron", "pr", "prais", "prais_e", "prais_e2", "prais_p", "pred", "predi", "predic", "predict", "predictnl", "print", "printgr", "priorest", "pro", "prob", "probi", "probit", "probit_estat", "probit_p", "proc_time", "procoverlay", "procrustes", "procrustes_estat", "procrustes_p", "profiler", "prop", "proportion", "prove", "prtest", "prtesti", "push", "pwcorr", "pwd", "q", "qby", "qbys", "qchi", "qchi_7", "qladder", "qladder_7", "qnorm", "qnorm_7", "qqplot", "qqplot_7", "qreg", "qreg_c", "qreg_p", "qreg_sw", "qu", "quadchk", "quantile", "quantile_7", "que", "quer", "query", "qui", "quie", "quiet", "quietl", "quietly", "range", "ranksum", "ratio", "rchart", "rchart_7", "rcof", "rc_spline", "recast", "reg", "reg3", "reg3_p", "regdw", "regr", "regre", "regre_p2", "regres", "regres_p", "regress", "regress_estat", "regriv_p", "remap", "ren", "rena", "renam", "rename", "renpfix", "repeat", "reshape", "ret", "retu", "retur", "return", "robvar", "robust", "roccomp", "roccomp_7", "roccomp_8", "rocf_lf", "rocfit", "rocfit_8", "rocgold", "rocplot", "rocplot_7", "roctab", "roctab_7", "rolling", "rologit", "rologit_p", "rot", "rota", "rotat", "rotate", "rotatemat", "rreg", "rreg_p", "rvfplot", "rvfplot_7", "rvpplot", "rvpplot_7", "sa", "safesum", "sample", "sampsi", "savedresults", "saveold", "say", "sc", "sca", "scal", "scala", "scalar", "scatter", "scm_mine", "sco", "scob_lf", "scob_p", "scobi_sw", "scobit", "scor", "score", "scoreplot", "scoreplot_help", "scree", "screeplot", "screeplot_help", "sdtest", "sdtesti", "se", "search", "separate", "seperate", "serrbar", "serrbar_7", "set_defaults", "sfrancia", "sh", "she", "shel", "shewhart", "shewhart_7", "showpoint", "signestimationsample", "signrank", "signtest", "simul", "simul_7", "simulate", "simulate_8", "simulinit", "sktest", "sleep", "slogit", "slogit_d2", "slogit_p", "smooth", "snapspan", "spbase", "spearman", "speedchk1", "speekchk2", "spikeplot", "spikeplot_7", "spikeplt", "spline", "spline_x", "split", "sqreg", "sqreg_p", "sret", "sretu", "sretur", "sreturn", "ssc", "st", "st_ct", "st_hc", "st_hcd", "st_hcd_sh", "st_is", "st_issys", "st_note", "st_promo", "st_set", "st_show", "st_smpl", "st_subid", "stack", "stackdepth", "stackreset", "statsby", "statsby_8", "stbase", "stci", "stci_7", "stcox", "stcox_estat", "stcox_fr", "stcox_fr_ll", "stcox_p", "stcox_sw", "stcoxkm", "stcoxkm_7", "stcstat", "stcurv", "stcurve", "stcurve_7", "stdes", "stem", "stepwise", "stereg", "stfill", "stgen", "stinit", "stir", "stjoin", "stmc", "stmh", "stphplot", "stphplot_7", "stphtest", "stphtest_7", "stptime", "strate", "strate_7", "streg", "streg_sw", "streset", "sts", "sts_7", "stset", "stsplit", "stsum", "sttocc", "sttoct", "stvary", "stweib", "su", "subwin", "suest", "suest_8", "sum", "summ", "summa", "summar", "summari", "summariz", "summarize", "sunflower", "sureg", "survcurv", "survsum", "svar", "svar_p", "svmat", "svy", "svy_disp", "svy_dreg", "svy_est", "svy_est_7", "svy_estat", "svy_get", "svy_gnbreg_p", "svy_head", "svy_header", "svy_heckman_p", "svy_heckprob_p", "svy_intreg_p", "svy_ivreg_p", "svy_logistic_p", "svy_logit_p", "svy_mlogit_p", "svy_nbreg_p", "svy_ologit_p", "svy_oprobit_p", "svy_poisson_p", "svy_probit_p", "svy_regress_p", "svy_sub", "svy_sub_7", "svy_x", "svy_x_7", "svy_x_p", "svydes", "svydes_8", "svygen", "svygnbreg", "svyheckman", "svyheckprob", "svyintreg", "svyintreg_7", "svyintrg", "svyivreg", "svylc", "svylog_p", "svylogit", "svymarkout", "svymarkout_8", "svymean", "svymlog", "svymlogit", "svynbreg", "svyolog", "svyologit", "svyoprob", "svyoprobit", "svyopts", "svypois", "svypois_7", "svypoisson", "svyprobit", "svyprobt", "svyprop", "svyprop_7", "svyratio", "svyreg", "svyreg_p", "svyregress", "svyset", "svyset_7", "svyset_8", "svytab", "svytab_7", "svytest", "svytotal", "sw", "sw_8", "swcnreg", "swcox", "swereg", "swilk", "swlogis", "swlogit", "swologit", "swoprbt", "swpois", "swprobit", "swqreg", "swtobit", "swweib", "symmetry", "symmi", "symplot", "symplot_7", "syntax", "sysdescribe", "sysuse", "szroeter", "ta", "tab", "tab1", "tab2", "tab_or", "tabd", "tabdi", "tabdis", "tabdisp", "tabi", "table", "tabodds", "tabodds_7", "tabstat", "tabu", "tabul", "tabula", "tabulat", "tabulate", "te", "tempfile", "tempname", "tempvar", "tes", "test", "testnl", "testparm", "teststd", "tetrachoric", "time_it", "timer", "tis", "tob", "tobi", "tobit", "tobit_p", "tobit_sw", "token", "tokeni", "tokeniz", "tokenize", "tostring", "total", "touch", "treat_ll", "treatr_p", "treatreg", "trim", "trnb_cons", "trnb_mean", "trpoiss_d2", "trunc_ll", "truncr_p", "truncreg", "tsappend", "tset", "tsfill", "tsline", "tsline_ex", "tsreport", "tsrevar", "tsrline", "tsset", "tssmooth", "tsunab", "ttest", "ttesti", "tut_chk", "tut_wait", "tutorial", "tw", "tware_st", "two", "twoway", "twoway__fpfit_serset", "twoway__function_gen", "twoway__histogram_gen", "twoway__ipoint_serset", "twoway__ipoints_serset", "twoway__kdensity_gen", "twoway__lfit_serset", "twoway__normgen_gen", "twoway__pci_serset", "twoway__qfit_serset", "twoway__scatteri_serset", "twoway__sunflower_gen", "twoway_ksm_serset", "ty", "typ", "type", "typeof", "u", "unab", "unabbrev", "unidiff", "update", "us", "uselabel", "var", "var_mkcompanion", "var_p", "varbasic", "varfcast", "vargranger", "varirf", "varirf_add", "varirf_cgraph", "varirf_create", "varirf_ctable", "varirf_describe", "varirf_dir", "varirf_drop", "varirf_erase", "varirf_graph", "varirf_ograph", "varirf_rename", "varirf_set", "varirf_table", "varlmar", "varnorm", "varsoc", "varstable", "varstable_w", "varstable_w2", "varwle", "vce", "vec", "vec_fevd", "vec_mkphi", "vec_p", "vec_p_w", "vecirf_create", "veclmar", "veclmar_w", "vecnorm", "vecnorm_w", "vecrank", "vecstable", "verinst", "vers", "versi", "versio", "version", "viewsource", "vif", "vwls", "wdatetof", "wdctl", "wdlg", "wdupdate", "webdescribe", "webseek", "webuse", "weib1_lf", "weib2_lf", "weib_lf", "weib_lf0", "weibhet_glf", "weibhet_glf_sh", "weibhet_glfa", "weibhet_glfa_sh", "weibhet_gp", "weibhet_ilf", "weibhet_ilf_sh", "weibhet_ilfa", "weibhet_ilfa_sh", "weibhet_ip", "weibu_sw", "weibul_p", "weibull", "weibull_c", "weibull_s", "weibullhet", "wh", "whelp", "whi", "whic", "which", "who", "wilc_st", "wilcoxon", "win", "wind", "windo", "window", "winexec", "wmenu", "wntestb", "wntestb_7", "wntestq", "xchart", "xchart_7", "xcorr", "xcorr_7", "xi", "xi_6", "xpose", "xt_iis", "xt_tis", "xtab_p", "xtabond", "xtabond2", "xtbin_p", "xtclog", "xtcloglog", "xtcloglog_8", "xtcloglog_d2", "xtcloglog_pa_p", "xtcloglog_re_p", "xtcnt_p", "xtcorr", "xtdata", "xtdes", "xtdpdsys", "xtfisher", "xtfront_p", "xtfrontier", "xtgee", "xtgee_elink", "xtgee_estat", "xtgee_makeivar", "xtgee_p", "xtgee_plink", "xtgls", "xtgls_p", "xthaus", "xthausman", "xtht_p", "xthtaylor", "xtile", "xtint_p", "xtintreg", "xtintreg_8", "xtintreg_d2", "xtintreg_p", "xtivp_1", "xtivp_2", "xtivreg", "xtline", "xtline_ex", "xtlogit", "xtlogit_8", "xtlogit_d2", "xtlogit_fe_p", "xtlogit_pa_p", "xtlogit_re_p", "xtlsdvc", "xtmixed", "xtmixed_estat", "xtmixed_p", "xtnb_fe", "xtnb_lf", "xtnbreg", "xtnbreg_pa_p", "xtnbreg_refe_p", "xtpcse", "xtpcse_p", "xtpois", "xtpoisson", "xtpoisson_d2", "xtpoisson_pa_p", "xtpoisson_refe_p", "xtpred", "xtprobit", "xtprobit_8", "xtprobit_d2", "xtprobit_re_p", "xtps_fe", "xtps_lf", "xtps_ren", "xtps_ren_8", "xtrar_p", "xtrc", "xtrc_p", "xtrch_p", "xtrchh", "xtrefe_p", "xtreg", "xtreg_be", "xtreg_fe", "xtreg_ml", "xtreg_pa_p", "xtreg_re", "xtregar", "xtrere_p", "xtserial", "xtset", "xtsf_ll", "xtsf_llti", "xtsum", "xttab", "xttest0", "xttest2", "xttest3", "xttobit", "xttobit_8", "xttobit_p", "xttrans", "xwin", "xwind", "xwindo", "xwindow", "y_ado", "yx", "yxview__barlike_draw", "yxview_area_draw", "yxview_bar_draw", "yxview_dot_draw", "yxview_dropline_draw", "yxview_function_draw", "yxview_iarrow_draw", "yxview_ilabels_draw", "yxview_normal_draw", "yxview_pcarrow_draw", "yxview_pcbarrow_draw", "yxview_pccapsym_draw", "yxview_pcscatter_draw", "yxview_pcspike_draw", "yxview_rarea_draw", "yxview_rbar_draw", "yxview_rbarm_draw", "yxview_rcap_draw", "yxview_rcapsym_draw", "yxview_rconnected_draw", "yxview_rline_draw", "yxview_rscatter_draw", "yxview_rspike_draw", "yxview_spike_draw", "yxview_sunflower_draw", "zap_s", "zinb", "zinb_llf", "zinb_plf", "zip", "zip_llf", "zip_p", "zip_plf", "zt_ct_5", "zt_hc_5", "zt_hcd_5", "zt_is_5", "zt_iss_5", "zt_sho_5", "zt_smp_5", "ztbase_5", "ztcox_5", "ztdes_5", "ztereg_5", "ztfill_5", "ztgen_5", "ztir_5", "ztjoin_5", "ztnb", "ztnb_p", "ztp", "ztp_p", "zts_5", "ztset_5", "ztspli_5", "ztsum_5", "zttoct_5", "ztvary_5", "ztweib_5", "inp", "res", "txt", "basec", "basechazard", "basehc", "bases", "basesurv", "eff", "effects", "esr", "tvc", "strata", "efron", "shared", "sh", "offset", "breslow", "bre", "texp", "exactm", "exactp", "con", "noadjust", "noadj", "noshow", "nosh", "mgale", "mg", "phtest", "sch", "schoenfeld", "scaledsch", "sca", "stphplot", "stcoxkm", "z", "zero", "noneg", "nonegative", "nolnt", "nolntime", "addplot", "ties", "tie", "sep", "separate", "_gsqelemcount", "_gsqepicount", "_gsqgapcount", "_gsqgaplength", "_gsqitemcount", "_gsqlength", "est2one", "est2rowlbl", "est2tex", "est2vec", "estsimp", "maketex", "matload", "matsave", "newey2", "outtable", "outtable7", "outtex", "outtex6", "relogit", "relogitq", "renvars", "setx", "setxhl", "simqi", "sp_adj", "spbase", "spline", "sqclusterdat", "sqclustermat", "sqdes", "sqindexplot", "sqom", "sqparcoord", "sqset", "sqstatlist", "sqstatsum", "sqstattab1", "sqstattab2", "sqstattabsum", "sqtab", "sumqi", "sutex", "sutex6", "tlogit", "xtfevd", "xtserial", "xttest1", "nokeep", "fe", "re", "pairwise", "gmm", "distribution", "loglogistic", "lognormal", "exponential", "nohr", "schoenfeld", "scaledsch", "basechazard", "basesurv", "basehc", "esr", "time0", "origin", "dropline", "bar", "hbar", "allc", "allcategories", "yalt", "xalt", "yalternate", "xalternate", "exclude0", "yrev", "yreverse", "blab", "blabel", "yvar", "yvaroptions", "nolabel", "nolab", "dot", "box", "pie", "combine", "printcolor", "yax", "xax", "yaxis", "xaxis", "legend", "msymbol", "ytic", "xtic", "ytick", "xtick", "lpattern", "ti", "tick", "mlab", "mlabel", "mtick", "mtic", "yscale", "xscale", "tscale", "ysc", "xsc", "tsc", "ylab", "xlab", "ylabel", "xlabel", "yti", "xti", "ytitle", "xtitle", });
        KEYWORDS1.add("KEYWORD2", new String[]{"_estimates", "_return", "accum", "adopath", "args", "break", "by", "byable", "bys", "bysort", "class", "cap", "capture", "char", "class", "classutil", "comments", "compare", "compress", "confirm", "continue", "creturn", "define", "discard", "dissimilarity", "drop", "eigenvalues", "else", "end", "ereturn", "expand", "file", "findfile", "for", "foreach", "forvalues", "get", "if", "in", "keep", "lab", "labe", "label", "loc", "loca", "local", "odbc", "outfix", "program", "properties", "recode", "replace", "return", "rmsg", "rownames", "serset", "so", "sor", "sort", "sortpreserve", "svd", "symeigen", "trace", "unabcmd", "utility", "while", "runtest", "byte", "int", "long", "float", "double", });
        KEYWORDS1.add("LITERAL3", new String[]{"dir", "chdir", "mkdir", "rmdir", "pwd", "fileexists", "cat", "unlink", "ls", });
        KEYWORDS1.add("KEYWORD3", new String[]{"ap", "app", "appe", "appen", "append", "erase", "mer", "merg", "merge", "preserve", "restore", "rm", "using", "use", "save", "sav", "xmlsave", "xmluse", });
        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES6() {
        RULES RULES1 = new RULES();
        RULES1.SET = "STRINGMACRO";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL3";
        SPAN1.DELEGATE = "COM-QUOTE";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "`\"";
        END END1 = new END();
        END1.text = "\"'";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.DELEGATE = "DUB-QUOTE";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "MACROS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        return RULES1;
    }

    private RULES RULES7() {
        RULES RULES1 = new RULES();
        RULES1.SET = "COM-QUOTE";
        RULES1.DEFAULT = "LITERAL3";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "FUNCTION";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ")";
        SEQ1.TYPE = "FUNCTION";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "MACROS";
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES8() {
        RULES RULES1 = new RULES();
        RULES1.SET = "DUB-QUOTE";
        RULES1.DEFAULT = "LITERAL1";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "MACROS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        return RULES1;
    }

    private RULES RULES9() {
        RULES RULES1 = new RULES();
        RULES1.SET = "MACROS";
        RULES1.DEFAULT = "LITERAL4";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL4";
        SPAN1.DELEGATE = "EXPRESSION";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "`=";
        END END1 = new END();
        END1.text = "'";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL4";
        SPAN2.DELEGATE = "GIVEUP";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "`:";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL4";
        SPAN3.DELEGATE = "MACROS";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "`";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "\\$[a-zA-Z]\\w*";
        SEQ_REGEXP1.TYPE = "LITERAL4";
        SEQ_REGEXP1.HASH_CHAR = "$";
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        return RULES1;
    }

    private RULES RULES10() {
        RULES RULES1 = new RULES();
        RULES1.SET = "EXPRESSION";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DEFAULT = "NULL";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.HASH_CHARS = "abcdefghijklmnopqrstuvwxyz_";
        SPAN_REGEXP1.TYPE = "FUNCTION";
        SPAN_REGEXP1.DELEGATE = "EXPRESSION";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\\w*\\(";
        END END1 = new END();
        END1.text = ")";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "STRINGMACRO";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, };

        return RULES1;
    }

    private RULES RULES11() {
        RULES RULES1 = new RULES();
        RULES1.SET = "GIVEUP";
        RULES1.DEFAULT = "NULL";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "STRINGMACRO";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), RULES6(), RULES7(), RULES8(), RULES9(), RULES10(), RULES11(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
