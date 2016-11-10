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
public class OccamLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "--";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "";
        PROPERTY3.NAME = "blockComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = ".";
        PROPERTY4.NAME = "noWordSep";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "FALSE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "--";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "#";
        EOL_SPAN2.TYPE = "COMMENT2";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "'";
        END END1 = new END();
        END1.text = "'";
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

        SEQ SEQ1 = new SEQ();
        SEQ1.text = ":=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "=";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = ">>";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "<<";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "<>";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "><";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = ">";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "<";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = ">=";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "<=";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "+";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "-";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "/";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "\\";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "*";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "?";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "!";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "/\\";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "\\/";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "~";
        SEQ20.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"FALSE", "TRUE", });
        KEYWORDS1.add("KEYWORD1", new String[]{"ALT", "ASM", "CASE", "FUNCTION", "IF", "INLINE", "PAR", "PLACED", "PRI", "PROC", "RESULT", "SEQ", "VALOF", "WHILE", });
        KEYWORDS1.add("KEYWORD2", new String[]{"AT", "ELSE", "FOR", "FROM", "IS", "PLACE", "PORT", "PROTOCOL", "SKIP", "STOP", "VAL", "AFTER", "AND", "ANY", "BITAND", "BITNOT", "BITOR", "BOOL", "BYTE", "BYTESIN", "CHAN", "DATA", "INT", "INT32", "INT16", "INT64", "MINUS", "MOSTNEG", "MOSTPOS", "NOT", "PLUS", "OF", "OFFSETOF", "OR", "PACKED", "REAL32", "REAL64", "RECORD", "REM", "RESHAPES", "RETYPES", "ROUND", "SIZE", "TIMER", "TIMES", "TRUNC", "TYPE", "BUCKET", "CLAIM", "ENROLL", "EVENT", "FALL", "FLUSH", "GRANT", "INITIAL", "RESOURCE", "SEMAPHORE", "SHARED", "SYNC", });
        KEYWORDS1.add("KEYWORD3", new String[]{"LONGADD", "LONGSUB", "ASHIFTRIGHT", "ASHIFTLEFT", "ROTATERIGHT", "ROTATELEFT", "LONGSUM", "LONGDIFF", "LONGPROD", "LONGDIV", "SHIFTLEFT", "SHIFTRIGHT", "NORMALISE", "ABS", "DABS", "SCALEB", "DSCALEB", "COPYSIGN", "DCOPYSIGN", "SQRT", "DSQRT", "MINUSX", "DMINUSX", "NEXTAFTER", "DNEXTAFTER", "MULBY2", "DMULBY2", "DIVBY2", "DDIVBY2", "LOGB", "DLOGB", "ISNAN", "DISNAN", "NOTFINITE", "DNOTFINITE", "ORDERED", "DORDERED", "FLOATING.UNPACK", "DFLOATING.UNPACK", "ARGUMENT.REDUCE", "DARGUMENT.REDUCE", "FPINT", "DFPINT", "REAL32OP", "REAL64OP", "IEEE32OP", "IEEE64OP", "REAL32REM", "REAL64REM", "IEEE32REM", "IEEE64REM", "REAL32EQ", "REAL64EQ", "REAL32GT", "REAL64GT", "IEEECOMPARE", "DIEEECOMPARE", "ALOG", "DALOG", "ALOG10", "DALOG10", "EXP", "DEXP", "TAN", "DTAN", "SIN", "DSIN", "ASIN", "DASIN", "COS", "DCOS", "SINH", "DSINH", "COSH", "DCOSH", "TANH", "DTANH", "ATAN", "DATAN", "ATAN2", "DATAN2", "RAN", "DRAN", "POWER", "DPOWER", "INTTOSTRING", "INT16TOSTRING", "INT32TOSTRING", "INT64TOSTRING", "STRINGTOINT", "STRINGTOINT16", "STRINGTOINT32", "STRINGTOINT64", "HEXTOSTRING", "HEX16TOSTRING", "HEX32TOSTRING", "HEX64TOSTRING", "STRINGTOHEX", "STRINGTOHEX16", "STRINGTOHEX32", "STRINGTOHEX64", "STRINGTOREAL32", "STRINGTOREAL64", "REAL32TOSTRING", "REAL64TOSTRING", "STRINGTOBOOL", "BOOLTOSTRING", "RESCHEDULE", "ASSERT", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, };

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
