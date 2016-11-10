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
public class AssemblyR2000Lang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "#";
        PROPERTY1.NAME = "blockComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = ",()";
        PROPERTY2.NAME = "wordBreakChars";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "true";
        PROPERTY3.NAME = "contextInsensitive";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "COMMENT1";
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
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = ":";
        MARK_PREVIOUS1.TYPE = "LABEL";
        MARK_PREVIOUS1.AT_LINE_START = "TRUE";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{".align", ".ascii", ".asciiz", ".byte", ".data", ".double", ".extern", ".float", ".globl", ".half", ".kdata", ".ktext", ".space", ".text", ".word", });
        KEYWORDS1.add("FUNCTION", new String[]{"add", "addi", "addu", "addiu", "and", "andi", "div", "divu", "mul", "mulo", "mulou", "mult", "multu", "neg", "negu", "nor", "not", "or", "ori", "rem", "remu", "rol", "ror", "sll", "sllv", "sra", "srav", "srl", "srlv", "sub", "subu", "xor", "xori", "li", "lui", "seq", "sge", "sgt", "sgtu", "sle", "sleu", "slt", "slti", "sltu", "sltiu", "sne", "b", "bczt", "bczf", "beq", "beqz", "bge", "bgeu", "bgez", "bgezal", "bgt", "bgtu", "bgtz", "ble", "bleu", "blez", "bgezal", "bltzal", "blt", "bltu", "bltz", "bne", "bnez", "j", "jal", "jalr", "jr", "la", "lb", "blu", "lh", "lhu", "lw", "lwcz", "lwl", "lwr", "ulh", "ulhu", "ulw", "sb", "sd", "sh", "sw", "swcz", "swl", "swr", "ush", "usw", "move", "mfhi", "mflo", "mthi", "mtlo", "mfcz", "mfc1.d", "mtcz", "abs.d", "abs.s", "add.d", "add.s", "c.eq.d", "c.eq.s", "c.le.d", "c.le.s", "c.lt.d", "c.lt.s", "cvt.d.s", "cbt.d.w", "cvt.s.d", "cvt.s.w", "cvt.w.d", "cvt.w.s", "div.d", "div.s", "l.d", "l.s", "mov.d", "mov.s", "mul.d", "mul.s", "neg.d", "neg.s", "s.d", "s.s", "sub.d", "sub.s", "rfe", "syscall", "break", "nop", });
        KEYWORDS1.add("KEYWORD2", new String[]{"$zero", "$at", "$v0", "$v1", "$a0", "$a1", "$a2", "$a3", "$t0", "$t1", "$t2", "$t3", "$t4", "$t5", "$t6", "$t7", "$s0", "$s1", "$s2", "$s3", "$s4", "$s5", "$s6", "$s7", "$t8", "$t9", "$k0", "$k1", "$gp", "$sp", "$fp", "$ra", });
        KEYWORDS1.add("KEYWORD3", new String[]{"$f0", "$f1", "$f2", "$f3", "$f4", "$f5", "$f6", "$f7", "$f8", "$f9", "$f10", "$f11", "$f12", "$f13", "$f14", "$f15", "$f16", "$f17", "$f18", "$f19", "$f20", "$f21", "$f22", "$f23", "$f24", "$f25", "$f26", "$f27", "$f28", "$f29", "$f30", "$f31", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

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
