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
public class AssemblyAgcLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "#";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "true";
        PROPERTY2.NAME = "contextInsensitive";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "##";
        EOL_SPAN1.TYPE = "COMMENT2";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "#";
        EOL_SPAN2.TYPE = "COMMENT1";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[0-9A-Z+-/*=()?'.&]+";
        SEQ_REGEXP1.HASH_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890+-/*=()?'.&";
        SEQ_REGEXP1.TYPE = "LABEL";
        SEQ_REGEXP1.AT_LINE_START = "TRUE";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "[0-9+-]+";
        SEQ_REGEXP2.HASH_CHARS = " +-";
        SEQ_REGEXP2.TYPE = "COMMENT3";
        SEQ_REGEXP2.AT_LINE_START = "TRUE";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "[+-]*[0-7]+[ \\t]";
        SEQ_REGEXP3.HASH_CHARS = "+-01234567";
        SEQ_REGEXP3.AT_WORD_START = "TRUE";
        SEQ_REGEXP3.TYPE = "DIGIT";
        SEQ_REGEXP SEQ_REGEXP4 = new SEQ_REGEXP();
        SEQ_REGEXP4.text = "[+-]*[0-7]+$";
        SEQ_REGEXP4.HASH_CHARS = "+-01234567";
        SEQ_REGEXP4.AT_WORD_START = "TRUE";
        SEQ_REGEXP4.TYPE = "DIGIT";
        SEQ_REGEXP SEQ_REGEXP5 = new SEQ_REGEXP();
        SEQ_REGEXP5.text = "[+-]*[0-7]+[,$]";
        SEQ_REGEXP5.HASH_CHARS = "+-01234567";
        SEQ_REGEXP5.AT_WORD_START = "TRUE";
        SEQ_REGEXP5.TYPE = "DIGIT";
        SEQ_REGEXP SEQ_REGEXP6 = new SEQ_REGEXP();
        SEQ_REGEXP6.text = "[+-]*[0-9]+D[ \\t]";
        SEQ_REGEXP6.HASH_CHARS = "+-0123456789";
        SEQ_REGEXP6.AT_WORD_START = "TRUE";
        SEQ_REGEXP6.TYPE = "DIGIT";
        SEQ_REGEXP SEQ_REGEXP7 = new SEQ_REGEXP();
        SEQ_REGEXP7.text = "[+-]*[0-9]+D$";
        SEQ_REGEXP7.HASH_CHARS = "+-0123456789";
        SEQ_REGEXP7.AT_WORD_START = "TRUE";
        SEQ_REGEXP7.TYPE = "DIGIT";
        SEQ_REGEXP SEQ_REGEXP8 = new SEQ_REGEXP();
        SEQ_REGEXP8.text = "[+-]*[0-9]+D[,$]";
        SEQ_REGEXP8.HASH_CHARS = "+-0123456789";
        SEQ_REGEXP8.AT_WORD_START = "TRUE";
        SEQ_REGEXP8.TYPE = "DIGIT";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "+";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "-";
        SEQ2.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"OVIND", "XAQ", "-CCS", "AD", "ADS", "AUG", "BZF", "BZMF", "CA", "CAE", "CAF", "CCS", "COM", "CS", "DAS", "DCA", "DCOM", "DCS", "DDOUBL", "DIM", "DOUBLE", "DTCB", "DTCF", "DV", "DXCH", "EDRUPT", "EXTEND", "INCR", "INDEX", "INHINT", "LXCH", "MASK", "MP", "MSU", "NDX", "NOOP", "OVSK", "QXCH", "RAND", "READ", "RELINT", "RESUME", "RETURN", "ROR", "RXOR", "SQUARE", "SU", "TC", "TCR", "TCAA", "TCF", "TS", "WAND", "WOR", "WRITE", "XCH", "XLQ", "XXALQ", "ZL", "ZQ", });
        KEYWORDS1.add("FUNCTION", new String[]{"-CADR", "XCADR", "=", "=MINUS", "=ECADR", "-2CADR", "-GENADR", "2BCADR", "2CADR", "2DEC", "2DEC*", "2FCADR", "2OCT", "ADRES", "BANK", "BBCON", "BBCON*", "BLOCK", "BNKSUM", "CADR", "CHECK=", "COUNT", "COUNT*", "DEC", "DEC*", "EBANK=", "ECADR", "EQUALS", "ERASE", "FCADR", "GENADR", "MEMORY", "MM", "NV", "OCT", "OCTAL", "REMADR", "SBANK=", "SETLOC", "SUBRO", "VN", "-1DNADR", "-2DNADR", "-3DNADR", "-4DNADR", "-5DNADR", "-6DNADR", "-DNCHAN", "-DNPTR", "1DNADR", "2DNADR", "3DNADR", "4DNADR", "5DNADR", "6DNADR", "DNCHAN", "DNPTR", });
        KEYWORDS1.add("KEYWORD2", new String[]{"ABS*", "AST,1", "AST,2", "BOVF", "COMP", "COMP*", "COS*", "CROSS", "DBSU", "DMOVE", "DMOVE*", "DTS", "ITC", "ITC*", "ITCI", "ITCQ", "LOAD", "LODON", "NOLOD", "SHIFTL", "SHIFTR", "SMOVE", "SMOVE*", "SQUARE", "STZ", "SWITCH", "TEST", "TMOVE", "TRAD", "TSLC", "TSLT", "TSLT*", "TSRT", "TSRT*", "TSU", "TTS", "VMOVE", "VMOVE*", "VSLT", "VSLT*", "VSQ", "VSRT", "VSRT*", "VTS", "ABS", "ABVAL", "ACOS", "ARCCOS", "ARCSIN", "ASIN", "AXC,1", "AXC,2", "AXT,1", "AXT,2", "BDDV", "BDDV*", "BDSU", "BDSU*", "BHIZ", "BMN", "BOFCLR", "BOF", "BOFF", "BOFINV", "BOFSET", "BON", "BONCLR", "BONINV", "BONSET", "BOV", "BOVB", "BPL", "BVSU", "BVSU*", "BZE", "CALL", "CALRB", "CCALL", "CCALL*", "CGOTO", "CGOTO*", "CLEAR", "CLR", "CLRGO", "COS", "COSINE", "DAD", "DAD*", "DCOMP", "DDV", "DDV*", "DLOAD", "DLOAD*", "DMP", "DMP*", "DMPR", "DMPR*", "DOT", "DOT*", "DSQ", "DSU", "DSU*", "EXIT", "GOTO", "INCR,1", "INCR,2", "INVERT", "INVGO", "ITA", "LXA,1", "LXA,2", "LXC,1", "LXC,2", "MXV", "MXV*", "NORM", "NORM*", "PDDL", "PDDL*", "PDVL", "PDVL*", "PUSH", "ROUND", "RTB", "RVQ", "SET", "SETGO", "SETPD", "SIGN", "SIGN*", "SIN", "SINE", "SL1", "SL1R", "SL2", "SL2R", "SL3", "SL3R", "SL4", "SL4R", "SL", "SL*", "SLOAD", "SLOAD*", "SLR", "SLR*", "SQRT", "SR1", "SR1R", "SR2", "SR2R", "SR3", "SR3R", "SR4", "SR4R", "SR", "SR*", "SRR", "SRR*", "SSP", "SSP*", "STADR", "STCALL", "STODL", "STODL*", "STORE", "STOVL", "STOVL*", "STQ", "SXA,1", "SXA,2", "TAD", "TAD*", "TIX,1", "TIX,2", "TLOAD", "TLOAD*", "UNIT", "UNIT*", "V/SC", "V/SC*", "VAD", "VAD*", "VCOMP", "VDEF", "VLOAD", "VLOAD*", "VPROJ", "VPROJ*", "VSL", "VSL*", "VSL1", "VSL2", "VSL3", "VSL4", "VSL5", "VSL6", "VSL7", "VSL8", "VSQ", "VSR", "VSR*", "VSR1", "VSR2", "VSR3", "VSR4", "VSR5", "VSR6", "VSR7", "VSR8", "VSU", "VSU*", "VXM", "VXM*", "VXSC", "VXSC*", "VXV", "VXV*", "XAD,1", "XAD,2", "XCHX,1", "XCHX,2", "XSU,1", "XSU,2", });
        KEYWORDS1.add("KEYWORD3", new String[]{"D", "Z", "N", "SL", "BI", "EDH", "CLHP", "HP", "LP", "ZI", "IN0", "IN1", "IN2", "IN3", "IN4", "IN5", "OUT0", "OUT1", "OUT2", "OUT3", "OUT4", "RIP", "A", "L", "Q", "EB", "FB", "Z", "BB", "ARUPT", "LRUPT", "QRUPT", "ZRUPT", "BBRUPT", "BRUPT", "CYR", "SR", "CYL", "EDOP", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, SEQ_REGEXP4, SEQ_REGEXP5, SEQ_REGEXP6, SEQ_REGEXP7, SEQ_REGEXP8, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

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
