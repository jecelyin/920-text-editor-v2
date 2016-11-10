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
public class AssemblyM68kLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = ";";
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
        RULES1.DIGIT_RE = "(0x\\p{XDigit}+|\\d+)";
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = ";";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "*";
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

        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "$";
        MARK_FOLLOWING1.TYPE = "KEYWORD2";
        MARK_FOLLOWING1.AT_LINE_START = "TRUE";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = ":";
        MARK_PREVIOUS1.TYPE = "LABEL";
        MARK_PREVIOUS1.AT_LINE_START = "TRUE";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ",";
        SEQ1.TYPE = "NULL";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ":";
        SEQ2.TYPE = "NULL";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "(";
        SEQ3.TYPE = "NULL";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = ")";
        SEQ4.TYPE = "NULL";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "]";
        SEQ5.TYPE = "NULL";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "[";
        SEQ6.TYPE = "NULL";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "$";
        SEQ7.TYPE = "NULL";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "+";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "-";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "/";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "*";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "%";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "|";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "^";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "&";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "~";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "!";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "=";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "<";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = ">";
        SEQ20.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"OPT", "INCLUDE", "FAIL", "END", "REG", "PAGE", "LIST", "NOLIST", "SPC", "TTL", "ORG", "EQU", "SET", "DS", "DC", "FOR", "ENDF", "IF", "THEN", "ELSE", "ENDI", "REPEAT", "UNTIL", "WHILE", "DO", "ENDW", "MACRO", });
        KEYWORDS1.add("FUNCTION", new String[]{"ABCD", "ADD", "ADD.B", "ADD.W", "ADD.L", "ADDA", "ADDA.W", "ADDA.L", "ADDI", "ADDI.B", "ADDI.W", "ADDI.L", "ADDQ", "ADDQ.B", "ADDQ.W", "ADDQ.L", "ADDX", "ADDX.B", "ADDX.W", "ADDX.L", "AND", "AND.B", "AND.W", "AND.L", "ANDI", "ANDI.B", "ANDI.W", "ANDI.L", "ASL", "ASL.B", "ASL.W", "ASL.L", "ASR", "ASR.B", "ASR.W", "ASR.L", "BCC", "BCS", "BEQ", "BGE", "BGT", "BHI", "BLE", "BLS", "BLT", "BMI", "BNE", "BPL", "BVC", "BVS", "BCHG", "BCLR", "BFCHG", "BFCLR", "BFEXTS", "BFEXTU", "BFFF0", "BFINS", "BFSET", "BFTST", "BGND", "BKPT", "BRA", "BSET", "BSR", "BTST", "CALLM", "CAS", "CAS2", "CHK", "CHK2", "CINV", "CLR", "CLR.B", "CLR.W", "CLR.L", "CMP", "CMP.B", "CMP.W", "CMP.L", "CMPA", "CMPA.W", "CMPA.L", "CMPI", "CMPI.B", "CMPI.W", "CMPI.L", "CMPM", "CMPM.B", "CMPM.W", "CMPM.L", "CMP2", "CMP2.B", "CMP2.W", "CMP2.L", "CPUSH", "DBCC", "DBCS", "DBEQ", "DBGE", "DBGT", "DBHI", "DBLE", "DBLS", "DBLT", "DBMI", "DBNE", "DBPL", "DBVC", "DBVS", "DIVS", "DIVSL", "DIVU", "DIVUL", "EOR", "EOR.B", "EOR.W", "EOR.L", "EORI", "EORI.B", "EORI.W", "EORI.L", "EXG", "EXT", "EXTB", "FABS", "FSABS", "FDABS", "FACOS", "FADD", "FSADD", "FDADD", "FASIN", "FATAN", "FATANH", "FCMP", "FCOS", "FCOSH", "FDIV", "FSDIV", "FDDIV", "FETOX", "FETOXM1", "FGETEXP", "FGETMAN", "FINT", "FINTRZ", "FLOG10", "FLOG2", "FLOGN", "FLOGNP1", "FMOD", "FMOVE", "FSMOVE", "FDMOVE", "FMOVECR", "FMOVEM", "FMUL", "FSMUL", "FDMUL", "FNEG", "FSNEG", "FDNEG", "FNOP", "FREM", "FRESTORE", "FSAVE", "FSCALE", "FSGLMUL", "FSIN", "FSINCOS", "FSINH", "FSQRT", "FSSQRT", "FDSQRT", "FSUB", "FSSUB", "FDSUB", "FTAN", "FTANH", "FTENTOX", "FTST", "FTWOTOX", "ILLEGAL", "JMP", "JSR", "LEA", "LINK", "LPSTOP", "LSL", "LSL.B", "LSL.W", "LSL.L", "LSR", "LSR.B", "LSR.W", "LSR.L", "MOVE", "MOVE.B", "MOVE.W", "MOVE.L", "MOVEA", "MOVEA.W", "MOVEA.L", "MOVE16", "MOVEC", "MOVEM", "MOVEP", "MOVEQ", "MOVES", "MULS", "MULU", "NBCD", "NEG", "NEG.B", "NEG.W", "NEG.L", "NEGX", "NEGX.B", "NEGX.W", "NEGX.L", "NOP", "NOT", "NOT.B", "NOT.W", "NOT.L", "OR", "OR.B", "OR.W", "OR.L", "ORI", "ORI.B", "ORI.W", "ORI.L", "PACK", "PEA", "PFLUSH", "PFLUSHA", "PFLUSHR", "PFLUSHS", "PLOAD", "PMOVE", "PRESTORE", "PSAVE", "PTEST", "PVALID", "RESET", "ROL", "ROL.B", "ROL.W", "ROL.L", "ROR", "ROR.B", "ROR.W", "ROR.L", "ROXL", "ROXL.B", "ROXL.W", "ROXL.L", "ROXR", "ROXR.B", "ROXR.W", "ROXR.L", "RTD", "RTE", "RTM", "RTR", "RTS", "SBCD", "SCC", "SCS", "SEQ", "SF", "SGE", "SGT", "SHI", "SLE", "SLS", "SLT", "SMI", "SNE", "SPL", "ST", "SVC", "SVS", "STOP", "SUB", "SUB.B", "SUB.W", "SUB.L", "SUBA", "SUBI", "SUBI.B", "SUBI.W", "SUBI.L", "SUBQ", "SUBQ.B", "SUBQ.W", "SUBQ.L", "SUBX", "SUBX.B", "SUBX.W", "SUBX.L", "SWAP", "TAS", "TBLS", "TBLSN", "TBLU", "TBLUN", "TRAP", "TRAPCC", "TRAPCS", "TRAPEQ", "TRAPF", "TRAPGE", "TRAPGT", "TRAPHI", "TRAPLE", "TRAPLS", "TRAPLT", "TRAPMI", "TRAPNE", "TRAPPL", "TRAPT", "TRAPVC", "TRAPVS", "TRAPV", "TST", "TST.B", "TST.W", "TST.L", "UNLK", "UNPK", });
        KEYWORDS1.add("KEYWORD3", new String[]{"D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "FP0", "FP1", "FP2", "FP3", "FP4", "FP5", "FP6", "FP7", "SP", "CCR", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, };

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
