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
public class FortranLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "C";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = ",+-=<>/?^&*";
        PROPERTY2.NAME = "wordBreakChars";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "\\s*((if\\s*\\(.*\\)\\s*then|else\\s*|do\\s*)*)";
        PROPERTY3.NAME = "indentNextLines";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "FALSE";
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "C";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN1.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "!";
        EOL_SPAN2.TYPE = "COMMENT1";
        EOL_SPAN2.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN3 = new EOL_SPAN();
        EOL_SPAN3.text = "*";
        EOL_SPAN3.TYPE = "COMMENT1";
        EOL_SPAN3.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN4 = new EOL_SPAN();
        EOL_SPAN4.text = "!";
        EOL_SPAN4.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN5 = new EOL_SPAN();
        EOL_SPAN5.text = "D";
        EOL_SPAN5.TYPE = "COMMENT2";
        EOL_SPAN5.AT_LINE_START = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "<=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ">=";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = ">";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "<";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "&";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "/=";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "==";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = ".lt.";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = ".gt.";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = ".eq.";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = ".ne.";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = ".le.";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = ".ge.";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = ".AND.";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = ".OR.";
        SEQ15.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"INCLUDE", "PROGRAM", "MODULE", "SUBROUTINE", "FUNCTION", "CONTAINS", "USE", "CALL", "RETURN", "IMPLICIT", "EXPLICIT", "NONE", "DATA", "PARAMETER", "ALLOCATE", "ALLOCATABLE", "ALLOCATED", "DEALLOCATE", "INTEGER", "REAL", "DOUBLE", "PRECISION", "COMPLEX", "LOGICAL", "CHARACTER", "DIMENSION", "KIND", "CASE", "SELECT", "DEFAULT", "CONTINUE", "CYCLE", "DO", "WHILE", "ELSE", "IF", "ELSEIF", "THEN", "ELSEWHERE", "END", "ENDIF", "ENDDO", "FORALL", "WHERE", "EXIT", "GOTO", "PAUSE", "STOP", "BACKSPACE", "CLOSE", "ENDFILE", "INQUIRE", "OPEN", "PRINT", "READ", "REWIND", "WRITE", "FORMAT", "AIMAG", "AINT", "AMAX0", "AMIN0", "ANINT", "CEILING", "CMPLX", "CONJG", "DBLE", "DCMPLX", "DFLOAT", "DIM", "DPROD", "FLOAT", "FLOOR", "IFIX", "IMAG", "INT", "LOGICAL", "MODULO", "NINT", "REAL", "SIGN", "SNGL", "TRANSFER", "ZEXT", "ABS", "ACOS", "AIMAG", "AINT", "ALOG", "ALOG10", "AMAX0", "AMAX1", "AMIN0", "AMIN1", "AMOD", "ANINT", "ASIN", "ATAN", "ATAN2", "CABS", "CCOS", "CHAR", "CLOG", "CMPLX", "CONJG", "COS", "COSH", "CSIN", "CSQRT", "DABS", "DACOS", "DASIN", "DATAN", "DATAN2", "DBLE", "DCOS", "DCOSH", "DDIM", "DEXP", "DIM", "DINT", "DLOG", "DLOG10", "DMAX1", "DMIN1", "DMOD", "DNINT", "DPROD", "DREAL", "DSIGN", "DSIN", "DSINH", "DSQRT", "DTAN", "DTANH", "EXP", "FLOAT", "IABS", "ICHAR", "IDIM", "IDINT", "IDNINT", "IFIX", "INDEX", "INT", "ISIGN", "LEN", "LGE", "LGT", "LLE", "LLT", "LOG", "LOG10", "MAX", "MAX0", "MAX1", "MIN", "MIN0", "MIN1", "MOD", "NINT", "REAL", "SIGN", "SIN", "SINH", "SNGL", "SQRT", "TAN", "TANH", ".false.", ".true.", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, EOL_SPAN3, EOL_SPAN4, EOL_SPAN5, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, };

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
