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
public class SasLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "(.*%?do.*;|\\s*proc .*;|\\s*data .*;|\\s*%macro\\s?.*;|define event \\S+\\s*;)";
        PROPERTY1.NAME = "indentNextLines";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "^\\s*(else.*|end\\s*|elsif.*|rescue.*|when.*)$";
        PROPERTY2.NAME = "unindentThisLine";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "^\\s*(end\\s*|else.*|rescue.*|elsif.*|when.*)$";
        PROPERTY3.NAME = "unindentNextLines";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "/*";
        PROPERTY4.NAME = "commentStart";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "*/";
        PROPERTY5.NAME = "commentEnd";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "*";
        PROPERTY6.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "TRUE";
        RULES1.NO_WORD_SEP = "_";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.AT_WHITESPACE_END = "TRUE";
        SPAN_REGEXP1.TYPE = "COMMENT2";
        SPAN_REGEXP1.HASH_CHAR = "*";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "[*][^;]*[;][\\s]*[*]";
        END END1 = new END();
        END1.text = ";";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.AT_WHITESPACE_END = "TRUE";
        SPAN_REGEXP2.TYPE = "COMMENT2";
        SPAN_REGEXP2.HASH_CHAR = "/*";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "([/][*][*][/][\\s]*[*])|([/][*](.)*[*][/][\\s]*[*])";
        END END2 = new END();
        END2.text = ";";
        SPAN_REGEXP2.END = new END[] { END2, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN_REGEXP SPAN_REGEXP3 = new SPAN_REGEXP();
        SPAN_REGEXP3.AT_WHITESPACE_END = "TRUE";
        SPAN_REGEXP3.TYPE = "COMMENT2";
        SPAN_REGEXP3.HASH_CHAR = "*";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "[*]";
        END END3 = new END();
        END3.text = ";";
        SPAN_REGEXP3.END = new END[] { END3, };

        SPAN_REGEXP3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN_REGEXP SPAN_REGEXP4 = new SPAN_REGEXP();
        SPAN_REGEXP4.TYPE = "COMMENT2";
        SPAN_REGEXP4.HASH_CHAR = ";";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "[;][\\s]*[*][^;]*[;][\\s]*[*]";
        END END4 = new END();
        END4.text = ";";
        SPAN_REGEXP4.END = new END[] { END4, };

        SPAN_REGEXP4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN_REGEXP SPAN_REGEXP5 = new SPAN_REGEXP();
        SPAN_REGEXP5.TYPE = "COMMENT2";
        SPAN_REGEXP5.HASH_CHAR = ";";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "[;][\\s]*[/][*](.)*[*][/][\\s]*[*]";
        END END5 = new END();
        END5.text = ";";
        SPAN_REGEXP5.END = new END[] { END5, };

        SPAN_REGEXP5.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN_REGEXP SPAN_REGEXP6 = new SPAN_REGEXP();
        SPAN_REGEXP6.TYPE = "COMMENT2";
        SPAN_REGEXP6.HASH_CHAR = ";";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "[;][\\s]*[*]";
        END END6 = new END();
        END6.text = ";";
        SPAN_REGEXP6.END = new END[] { END6, };

        SPAN_REGEXP6.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT2";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "%*";
        END END7 = new END();
        END7.text = ";";
        SPAN1.END = new END[] { END7, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN7, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "COMMENT1";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "/*";
        END END8 = new END();
        END8.text = "*/";
        SPAN2.END = new END[] { END8, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN8, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "FALSE";
        SPAN3.TYPE = "LITERAL1";
        BEGIN BEGIN9 = new BEGIN();
        BEGIN9.text = "'";
        END END9 = new END();
        END9.text = "'";
        SPAN3.END = new END[] { END9, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN9, };

        SPAN SPAN4 = new SPAN();
        SPAN4.NO_LINE_BREAK = "FALSE";
        SPAN4.TYPE = "LITERAL2";
        BEGIN BEGIN10 = new BEGIN();
        BEGIN10.text = "\"";
        END END10 = new END();
        END10.text = "\"";
        SPAN4.END = new END[] { END10, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN10, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "PROC ANOVA";
        SEQ1.AT_WORD_START = "TRUE";
        SEQ1.TYPE = "KEYWORD1";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "PROC APPEND";
        SEQ2.AT_WORD_START = "TRUE";
        SEQ2.TYPE = "KEYWORD1";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "PROC BOXPLOT";
        SEQ3.AT_WORD_START = "TRUE";
        SEQ3.TYPE = "KEYWORD1";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "PROC CONTENTS";
        SEQ4.AT_WORD_START = "TRUE";
        SEQ4.TYPE = "KEYWORD1";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "PROC DATASETS";
        SEQ5.AT_WORD_START = "TRUE";
        SEQ5.TYPE = "KEYWORD1";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "PROC DELETE";
        SEQ6.AT_WORD_START = "TRUE";
        SEQ6.TYPE = "KEYWORD1";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "PROC FORMAT";
        SEQ7.AT_WORD_START = "TRUE";
        SEQ7.TYPE = "KEYWORD1";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "PROC FREQ";
        SEQ8.AT_WORD_START = "TRUE";
        SEQ8.TYPE = "KEYWORD1";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "PROC IMPORT";
        SEQ9.AT_WORD_START = "TRUE";
        SEQ9.TYPE = "KEYWORD1";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "PROC MEANS";
        SEQ10.AT_WORD_START = "TRUE";
        SEQ10.TYPE = "KEYWORD1";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "PROC PRINTTO";
        SEQ11.AT_WORD_START = "TRUE";
        SEQ11.TYPE = "KEYWORD1";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "PROC PRINT";
        SEQ12.AT_WORD_START = "TRUE";
        SEQ12.TYPE = "KEYWORD1";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "PROC REPORT";
        SEQ13.AT_WORD_START = "TRUE";
        SEQ13.TYPE = "KEYWORD1";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "PROC SORT";
        SEQ14.AT_WORD_START = "TRUE";
        SEQ14.TYPE = "KEYWORD1";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "PROC SQL";
        SEQ15.AT_WORD_START = "TRUE";
        SEQ15.TYPE = "KEYWORD1";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "PROC UNIVARIATE";
        SEQ16.AT_WORD_START = "TRUE";
        SEQ16.TYPE = "KEYWORD1";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "DATA";
        SEQ17.AT_WHITESPACE_END = "TRUE";
        SEQ17.TYPE = "KEYWORD1";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "%INCLUDE";
        SEQ18.AT_WORD_START = "TRUE";
        SEQ18.TYPE = "FUNCTION";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "PROC";
        SEQ19.AT_WORD_START = "TRUE";
        SEQ19.TYPE = "KEYWORD1";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "RUN;";
        SEQ20.AT_WORD_START = "TRUE";
        SEQ20.TYPE = "KEYWORD1";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "QUIT;";
        SEQ21.AT_WORD_START = "TRUE";
        SEQ21.TYPE = "KEYWORD1";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "%macro";
        SEQ22.AT_WORD_START = "TRUE";
        SEQ22.TYPE = "KEYWORD1";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "%mend";
        SEQ23.AT_WORD_START = "TRUE";
        SEQ23.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "%\\S+\\s*\\(";
        SEQ_REGEXP1.AT_WHITESPACE_END = "TRUE";
        SEQ_REGEXP1.TYPE = "KEYWORD3";
        SEQ_REGEXP1.HASH_CHAR = "%";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "(&*\\w+)+(\\.+|,|;|\\s|$|\\}|\\))";
        SEQ_REGEXP2.TYPE = "MARKUP";
        SEQ_REGEXP2.HASH_CHAR = "&";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "(DATA)[\\s]*[=]";
        SEQ_REGEXP3.TYPE = "KEYWORD2";
        SEQ_REGEXP3.HASH_CHAR = "DATA";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "=";
        SEQ24.TYPE = "OPERATOR";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "<";
        SEQ25.TYPE = "OPERATOR";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = ">";
        SEQ26.TYPE = "OPERATOR";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "|";
        SEQ27.TYPE = "OPERATOR";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "~";
        SEQ28.TYPE = "OPERATOR";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = "^";
        SEQ29.TYPE = "OPERATOR";
        SEQ SEQ30 = new SEQ();
        SEQ30.text = "@";
        SEQ30.TYPE = "OPERATOR";
        SEQ SEQ31 = new SEQ();
        SEQ31.text = "?";
        SEQ31.TYPE = "OPERATOR";
        SEQ SEQ32 = new SEQ();
        SEQ32.text = "/";
        SEQ32.TYPE = "OPERATOR";
        SEQ SEQ33 = new SEQ();
        SEQ33.text = ".";
        SEQ33.TYPE = "OPERATOR";
        SEQ SEQ34 = new SEQ();
        SEQ34.text = "-";
        SEQ34.TYPE = "OPERATOR";
        SEQ SEQ35 = new SEQ();
        SEQ35.text = "+";
        SEQ35.TYPE = "OPERATOR";
        SEQ SEQ36 = new SEQ();
        SEQ36.text = "*";
        SEQ36.TYPE = "OPERATOR";
        SEQ SEQ37 = new SEQ();
        SEQ37.text = "!";
        SEQ37.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD2", new String[]{"$ASCII", "$BINARY", "$CB", "$CHAR", "$CHARZB", "$EBCDIC", "$HEX", "$OCTAL", "$VARYING", "_ALL_", "_CHARACTER_", "_CMD_", "_ERROR_", "_I_", "_INFILE_", "_LAST_", "_MSG_", "_N_", "_NULL_", "_NUMERIC_", "_TEMPORARY_", "_TYPE_", "=DATA", "ABORT", "ADD", "ADJRSQ", "AND", "ARRAY", "ATTRIB", "BACKWARD", "BINARY", "BLOCKSIZE", "BY", "BZ", "CALL", "CARDS", "CARDS4", "CHAR", "CLASS", "COL", "COLLIN", "COLUMN", "COMMA", "COMMAX", "CREATE", "DATA", "DATA=", "DATE", "DATAFILE", "DATETIME", "DDMMYY", "DECENDING", "DEFINE", "DELETE", "DELIMITER", "DISPLAY", "DLM", "DO", "DROP", "ELSE", "END", "ENDSAS", "EOF", "EOV", "EQ", "ERRORS", "FILE", "FILENAME", "FILEVAR", "FIRST.", "FIRSTOBS", "FOOTNOTE", "FOOTNOTE1", "FOOTNOTE2", "FOOTNOTE3", "FORM", "FORMAT", "FORMCHAR", "FORMDELIM", "FORMDLIM", "FORWARD", "FROM", "GO", "GROUP", "GT", "HBAR", "HEX", "HPCT", "HVAR", "IB", "ID", "IEEE", "IF", "IN", "INFILE", "INFORMAT", "INTO", "INPUT", "INR", "INVALUE", "JOIN", "JULIAN", "KEEP", "LABEL", "LAG", "LAST.", "LEFT", "LENGTH", "LIB", "LIBNAME", "LINE", "LINESIZE", "LINK", "LIST", "LOSTCARD", "LRECL", "LS", "MACRO", "MACROGEN", "MAXDEC", "MAXR", "MEDIAN", "MEMTYPE", "MERGE", "MERROR", "MISSOVE", "MLOGIC", "MMDDYY", "MODE", "MODEL", "MONYY", "MPRINT", "MRECALL", "NE", "NEW", "NO", "NOBS", "NOCENTER", "NOCUM", "NODATE", "NODUP", "NODUPKEY", "NOINT", "NONUMBER", "NOPAD", "NOPRINT", "NOROW", "NOT", "NOTITLE", "NOTITLES", "NOXSYNC", "NOXWAIT", "NUMBER", "NWAY", "OBS", "OPTION", "OPTIONS", "OR", "ORDER", "OTHERWISE", "OUT", "OUTPUT", "OVER", "PAD", "PAD2", "PAGESIZE", "PD", "PERCENT", "PIB", "PK", "POINT", "POSITION", "PRINTER", "PRXMATCH", "PRXCHANGE", "PS", "PUT", "R", "RB", "RECFM", "REG", "REGR", "RENAME", "REPLACE", "RETAIN", "RETURN", "REUSE", "REVERSE", "RSQUARE", "RUN", "SASAUTOS", "SCAN", "SELECT", "SELECTION", "SERROR", "SET", "SIMPLE", "SLE", "SLS", "START", "STDIN", "STOP", "STOPOVER", "SUBSTR", "SYMBOL", "SYMBOLGEN", "SYMGET", "SYMPUT", "SYMPUTX", "T", "TABLE", "TABLES", "THEN", "TITLE", "TITLE1", "TITLE2", "TITLE3", "TITLE4", "TITLE5", "TO", "TOL", "TRIM", "UNFORMATTED", "UNTIL", "UPDATE", "UPCASE", "VALUE", "VAR", "WHEN", "WHERE", "WHILE", "WINDOW", "WORK", "X", "XSYNC", "XWAIT", "YES", "YYMMDD", "GOPTIONS", "AXIS1", "AXIS2", "SYMBOL1", "SET", });
        KEYWORDS1.add("KEYWORD3", new String[]{"%ABORT", "%BQUOTE", "%DO", "%ELSE", "%END", "%EVAL", "%Global", "%GOTO", "%IF", "%INC", "%INCLUDE", "%INDEX", "%INPUT", "%LENGTH", "%LET", "%LOCAL", "%LOWCASE", "%MACRO", "%MEND", "%NRBQUOTE", "%NRQUOTE", "%NRSTR", "%PUT", "%QSCAN", "%QSUBSTR", "%Quote", "%RUN", "%SCAN", "%STR", "%SUBSTR", "%SYMDEL", "%SYSEXEC", "%SYSFUNC", "%THEN", "%TO", "%UNTIL", "%WHILE", "%WINDOW", "%UPCASE", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, SPAN_REGEXP3, SPAN_REGEXP4, SPAN_REGEXP5, SPAN_REGEXP6, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, SEQ30, SEQ31, SEQ32, SEQ33, SEQ34, SEQ35, SEQ36, SEQ37, };

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
