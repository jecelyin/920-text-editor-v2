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
public class CLang implements LangDefine {
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
        PROPERTY7.VALUE = "(";
        PROPERTY7.NAME = "unalignedOpenBrackets";
        PROPERTY PROPERTY8 = new PROPERTY();
        PROPERTY8.VALUE = ")";
        PROPERTY8.NAME = "unalignedCloseBrackets";
        PROPERTY PROPERTY9 = new PROPERTY();
        PROPERTY9.VALUE = "(?!^\\s*(#|//)).*(\\b(if|while|for)\\s*\\(.*\\)|\\b(else|do)\\b)[^{;]*$";
        PROPERTY9.NAME = "indentNextLine";
        PROPERTY PROPERTY10 = new PROPERTY();
        PROPERTY10.VALUE = "^\\s*((case\\b.*|[\\p{Alpha}_][\\p{Alnum}_]*)\\s*:(?!:)).*$";
        PROPERTY10.NAME = "unindentThisLine";
        PROPERTY PROPERTY11 = new PROPERTY();
        PROPERTY11.VALUE = ":";
        PROPERTY11.NAME = "electricKeys";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, PROPERTY8, PROPERTY9, PROPERTY10, PROPERTY11, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[0-9][0-9a-zA-Z]*";
        RULES1.IGNORE_CASE = "FALSE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.AT_WHITESPACE_END = "TRUE";
        EOL_SPAN1.TYPE = "KEYWORD2";
        EOL_SPAN1.DELEGATE = "CPP";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "LEX";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "CORE";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "LEX";
        RULES1.IGNORE_CASE = "FALSE";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "COMMENTS";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "C_LEXER";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "C_LEXER";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[0-9][0-9a-zA-Z]*";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "L\"";
        END END1 = new END();
        END1.text = "\"";
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
        BEGIN3.text = "L'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.NO_LINE_BREAK = "TRUE";
        SPAN4.TYPE = "LITERAL1";
        SPAN4.ESCAPE = "\\";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "'";
        END END4 = new END();
        END4.text = "'";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "??(";
        SEQ1.TYPE = "LITERAL4";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "??/";
        SEQ2.TYPE = "LITERAL4";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "??)";
        SEQ3.TYPE = "LITERAL4";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "??'";
        SEQ4.TYPE = "LITERAL4";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "??<";
        SEQ5.TYPE = "LITERAL4";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "??!";
        SEQ6.TYPE = "LITERAL4";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "??>";
        SEQ7.TYPE = "LITERAL4";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "??-";
        SEQ8.TYPE = "LITERAL4";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "??=";
        SEQ9.TYPE = "LITERAL4";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "<:";
        SEQ10.TYPE = "LITERAL4";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = ":>";
        SEQ11.TYPE = "LITERAL4";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "<%";
        SEQ12.TYPE = "LITERAL4";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "%>";
        SEQ13.TYPE = "LITERAL4";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "%:";
        SEQ14.TYPE = "LITERAL4";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = ":";
        MARK_PREVIOUS1.AT_WHITESPACE_END = "TRUE";
        MARK_PREVIOUS1.TYPE = "LABEL";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = "(";
        MARK_PREVIOUS2.TYPE = "FUNCTION";
        MARK_PREVIOUS2.MATCH_TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "=";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "!";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "+";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "-";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "/";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "*";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = ">";
        SEQ21.TYPE = "OPERATOR";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "<";
        SEQ22.TYPE = "OPERATOR";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "%";
        SEQ23.TYPE = "OPERATOR";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "&";
        SEQ24.TYPE = "OPERATOR";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "|";
        SEQ25.TYPE = "OPERATOR";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = "^";
        SEQ26.TYPE = "OPERATOR";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "~";
        SEQ27.TYPE = "OPERATOR";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "?";
        SEQ28.TYPE = "OPERATOR";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = ":";
        SEQ29.TYPE = "OPERATOR";
        SEQ SEQ30 = new SEQ();
        SEQ30.text = ".";
        SEQ30.TYPE = "OPERATOR";
        SEQ SEQ31 = new SEQ();
        SEQ31.text = ",";
        SEQ31.TYPE = "OPERATOR";
        SEQ SEQ32 = new SEQ();
        SEQ32.text = "[";
        SEQ32.TYPE = "OPERATOR";
        SEQ SEQ33 = new SEQ();
        SEQ33.text = "]";
        SEQ33.TYPE = "OPERATOR";
        SEQ SEQ34 = new SEQ();
        SEQ34.text = ")";
        SEQ34.TYPE = "OPERATOR";
        SEQ SEQ35 = new SEQ();
        SEQ35.text = "}";
        SEQ35.TYPE = "OPERATOR";
        SEQ SEQ36 = new SEQ();
        SEQ36.text = "{";
        SEQ36.TYPE = "OPERATOR";
        SEQ SEQ37 = new SEQ();
        SEQ37.text = ";";
        SEQ37.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"__DATE__", "__FILE__", "__LINE__", "__STDC_HOSTED__", "__STDC_ISO_10646__", "__STDC_VERSION__", "__STDC__", "__TIME__", "__cplusplus", "BUFSIZ", "CLOCKS_PER_SEC", "EDOM", "EILSEQ", "EOF", "ERANGE", "EXIT_FAILURE", "EXIT_SUCCESS", "FILENAME_MAX", "FOPEN_MAX", "HUGE_VAL", "LC_ALL", "LC_COLLATE", "LC_CTYPE", "LC_MONETARY", "LC_NUMERIC", "LC_TIME", "L_tmpnam", "MB_CUR_MAX", "NULL", "RAND_MAX", "SEEK_CUR", "SEEK_END", "SEEK_SET", "SIGABRT", "SIGFPE", "SIGILL", "SIGINT", "SIGSEGV", "SIGTERM", "SIG_DFL", "SIG_ERR", "SIG_IGN", "TMP_MAX", "WCHAR_MAX", "WCHAR_MIN", "WEOF", "_IOFBF", "_IOLBF", "_IONBF", "assert", "errno", "offsetof", "setjmp", "stderr", "stdin", "stdout", "va_arg", "va_end", "va_start", "CHAR_BIT", "CHAR_MAX", "CHAR_MIN", "DBL_DIG", "DBL_EPSILON", "DBL_MANT_DIG", "DBL_MAX", "DBL_MAX_10_EXP", "DBL_MAX_EXP", "DBL_MIN", "DBL_MIN_10_EXP", "DBL_MIN_EXP", "FLT_DIG", "FLT_EPSILON", "FLT_MANT_DIG", "FLT_MAX", "FLT_MAX_10_EXP", "FLT_MAX_EXP", "FLT_MIN", "FLT_MIN_10_EXP", "FLT_MIN_EXP", "FLT_RADIX", "FLT_ROUNDS", "INT_MAX", "INT_MIN", "LDBL_DIG", "LDBL_EPSILON", "LDBL_MANT_DIG", "LDBL_MAX", "LDBL_MAX_10_EXP", "LDBL_MAX_EXP", "LDBL_MIN", "LDBL_MIN_10_EXP", "LDBL_MIN_EXP", "LONG_MAX", "LONG_MIN", "MB_LEN_MAX", "SCHAR_MAX", "SCHAR_MIN", "SHRT_MAX", "SHRT_MIN", "UCHAR_MAX", "UINT_MAX", "ULONG_MAX", "USRT_MAX", });
        KEYWORDS1.add("KEYWORD3", new String[]{"and", "and_eq", "bitand", "bitor", "compl", "not", "not_eq", "or", "or_eq", "xor", "xor_eq", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, SEQ30, SEQ31, SEQ32, SEQ33, SEQ34, SEQ35, SEQ36, SEQ37, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CORE";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[0-9][0-9a-zA-Z]*";
        RULES1.IGNORE_CASE = "FALSE";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"false", "true", });
        KEYWORDS1.add("KEYWORD1", new String[]{"auto", "break", "case", "const", "continue", "default", "do", "else", "for", "goto", "if", "inline", "register", "return", "sizeof", "static", "switch", "void", "volatile", "while", });
        KEYWORDS1.add("KEYWORD2", new String[]{"asm", "extern", });
        KEYWORDS1.add("KEYWORD3", new String[]{"bool", "char", "double", "enum", "float", "int", "long", "short", "signed", "struct", "union", "unsigned", "typedef", "restrict", "_Bool", "_Complex", "_Pragma", "_Imaginary", });
        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "COMMENTS";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "/**/";
        SEQ1.TYPE = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT3";
        SPAN1.DELEGATE = "doxygen::DOXYGEN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/**<";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "COMMENT3";
        SPAN2.DELEGATE = "doxygen::DOXYGEN";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "/**";
        END END2 = new END();
        END2.text = "*/";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "///<";
        EOL_SPAN1.TYPE = "COMMENT3";
        EOL_SPAN1.DELEGATE = "doxygen::DOXYGEN";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "///";
        EOL_SPAN2.TYPE = "COMMENT3";
        EOL_SPAN2.DELEGATE = "doxygen::DOXYGEN";
        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "COMMENT3";
        SPAN3.DELEGATE = "doxygen::DOXYGEN";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "/*!<";
        END END3 = new END();
        END3.text = "*/";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "COMMENT3";
        SPAN4.DELEGATE = "doxygen::DOXYGEN";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "/*!";
        END END4 = new END();
        END4.text = "*/";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        EOL_SPAN EOL_SPAN3 = new EOL_SPAN();
        EOL_SPAN3.text = "//!<";
        EOL_SPAN3.TYPE = "COMMENT3";
        EOL_SPAN3.DELEGATE = "doxygen::DOXYGEN";
        EOL_SPAN EOL_SPAN4 = new EOL_SPAN();
        EOL_SPAN4.text = "//!";
        EOL_SPAN4.TYPE = "COMMENT3";
        EOL_SPAN4.DELEGATE = "doxygen::DOXYGEN";
        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "COMMENT1";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "/*";
        END END5 = new END();
        END5.text = "*/";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        EOL_SPAN EOL_SPAN5 = new EOL_SPAN();
        EOL_SPAN5.text = "//";
        EOL_SPAN5.TYPE = "COMMENT1";
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, EOL_SPAN3, EOL_SPAN4, EOL_SPAN5, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES6() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CPP";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[0-9][0-9a-zA-Z]*";
        RULES1.IGNORE_CASE = "FALSE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP1 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP1.text = "include\\b";
        EOL_SPAN_REGEXP1.TYPE = "MARKUP";
        EOL_SPAN_REGEXP1.DELEGATE = "INCLUDE";
        EOL_SPAN_REGEXP1.HASH_CHAR = "include";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP2 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP2.text = "define\\b";
        EOL_SPAN_REGEXP2.TYPE = "MARKUP";
        EOL_SPAN_REGEXP2.DELEGATE = "DEFINE";
        EOL_SPAN_REGEXP2.HASH_CHAR = "define";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP3 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP3.text = "endif\\b";
        EOL_SPAN_REGEXP3.TYPE = "MARKUP";
        EOL_SPAN_REGEXP3.DELEGATE = "LEX";
        EOL_SPAN_REGEXP3.HASH_CHAR = "endif";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP4 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP4.text = "elif\\b";
        EOL_SPAN_REGEXP4.TYPE = "MARKUP";
        EOL_SPAN_REGEXP4.DELEGATE = "CONDITION";
        EOL_SPAN_REGEXP4.HASH_CHAR = "elif";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP5 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP5.text = "if\\b";
        EOL_SPAN_REGEXP5.TYPE = "MARKUP";
        EOL_SPAN_REGEXP5.DELEGATE = "CONDITION";
        EOL_SPAN_REGEXP5.HASH_CHAR = "if";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "LEX";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("MARKUP", new String[]{"ifdef", "ifndef", "else", "error", "line", "pragma", "undef", "warning", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.EOL_SPAN_REGEXP = new EOL_SPAN_REGEXP[] { EOL_SPAN_REGEXP1, EOL_SPAN_REGEXP2, EOL_SPAN_REGEXP3, EOL_SPAN_REGEXP4, EOL_SPAN_REGEXP5, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES7() {
        RULES RULES1 = new RULES();
        RULES1.SET = "INCLUDE";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[0-9][0-9a-zA-Z]*";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<";
        END END1 = new END();
        END1.text = ">";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "LEX";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        return RULES1;
    }

    private RULES RULES8() {
        RULES RULES1 = new RULES();
        RULES1.SET = "DEFINE";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[0-9][0-9a-zA-Z]*";
        RULES1.IGNORE_CASE = "FALSE";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "#";
        SEQ1.TYPE = "OPERATOR";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "LEX";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "CORE";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES9() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CONDITION";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[0-9][0-9a-zA-Z]*";
        RULES1.IGNORE_CASE = "FALSE";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "LEX";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD2", new String[]{"defined", "true", "false", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), RULES6(), RULES7(), RULES8(), RULES9(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
