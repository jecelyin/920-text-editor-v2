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
public class CilLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "{";
        PROPERTY1.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "}";
        PROPERTY2.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "/*";
        PROPERTY3.NAME = "commentStart";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "*/";
        PROPERTY4.NAME = "commentEnd";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "//";
        PROPERTY5.NAME = "lineComment";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = ",+\\\\";
        PROPERTY6.NAME = "wordBreakChars";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "'";
        END END1 = new END();
        END1.text = "'";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "//";
        EOL_SPAN1.TYPE = "COMMENT2";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ")";
        SEQ1.TYPE = "OPERATOR";
        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = ":";
        MARK_PREVIOUS2.TYPE = "LABEL";
        MARK_PREVIOUS2.AT_LINE_START = "TRUE";
        MARK_PREVIOUS2.MATCH_TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"&", "*", "}", "{", });
        KEYWORDS1.add("KEYWORD1", new String[]{"public", "private", "family", "assembly", "famandassem", "famorassem", "autochar", "abstract", "ansi", "beforefieldinit", "explicit", "interface", "nested", "rtspecialname", "sealed", "sequential", "serializable", "specialname", "unicode", "final", "hidebysig", "newslot", "pinvokeimpl", "static", "virtual", "cil", "forwardref", "internalcall", "managed", "native", "noinlining", "runtime", "synchronized", "unmanaged", "typedref", "cdecl", "fastcall", "stdcall", "thiscall", "platformapi", "initonly", "literal", "marshal", "notserialized", "addon", "removeon", "catch", "fault", "filter", "handler", });
        KEYWORDS1.add("KEYWORD2", new String[]{".assembly", ".assembly extern", ".class", ".class extern", ".field", ".method", ".property", ".get", ".set", ".other", ".ctor", ".corflags", ".custom", ".data", ".file", ".mresource", ".module", ".module extern", ".subsystem", ".vtfixup", ".publickeytoken", ".ver", ".hash algorithm", ".culture", ".namespace", ".event", ".fire", ".override", ".try", ".catch", ".finally", ".locals", ".maxstack", ".entrypoint", ".pack", ".size", ".file alignment", ".imagebase", ".language", ".namespace", });
        KEYWORDS1.add("FUNCTION", new String[]{"add", "add.ovf", "add.ovf.un", "div", "div.un", "mul", "mul.ovf", "mul.ovf.un", "sub", "sub.ovf", "sub.ovf.un", "and", "not", "or", "xor", "beq", "beq.s", "bge", "bge.s", "bge.un", "bge.un.s", "bgt", "bgt.s", "bgt.un", "bgt.un.s", "ble", "ble.s", "ble.un", "ble.un.s", "blt", "blt.s", "blt.un", "blt.un.s", "bne.un", "bne.un.s", "br", "brfalse", "brfalse.s", "brtrue", "brtrue.s", "br.s", "conv.i", "conv.i1", "conv.i2", "conv.i4", "conv.i8", "conv.ovf.i", "conv.ovf.i1", "conv.ovf.i1.un", "conv.ovf.i2", "conv.ovf.i2.un", "conv.ovf.i4", "conv.ovf.i4.un", "conv.ovf.i8", "conv.ovf.i8.un", "conv.ovf.i.un", "conv.ovf.u", "conv.ovf.u1", "conv.ovf.u1.un", "conv.ovf.u2", "conv.ovf.u2.un", "conv.ovf.u4", "conv.ovf.u4.un", "conv.ovf.u8", "conv.ovf.u8.un", "conv.ovf.u.un", "conv.r4", "conv.r8", "conv.r.un", "conv.u", "conv.u1", "conv.u2", "conv.u4", "conv.u8", "ldarg", "ldarga", "ldarga.s", "ldarg.0", "ldarg.1", "ldarg.2", "ldarg.3", "ldarg.s", "ldc.i4", "ldc.i4.0", "ldc.i4.1", "ldc.i4.2", "ldc.i4.3", "ldc.i4.4", "ldc.i4.5", "ldc.i4.6", "ldc.i4.7", "ldc.i4.8", "ldc.i4.m1", "ldc.i4.s", "ldc.i8", "ldc.r4", "ldc.r8", "ldelema", "ldelem.i", "ldelem.i1", "ldelem.i2", "ldelem.i4", "ldelem.i8", "ldelem.r4", "ldelem.r8", "ldelem.ref", "ldelem.u1", "ldelem.u2", "ldelem.u4", "ldfld", "ldflda", "ldftn", "ldind.i", "ldind.i1", "ldind.i2", "ldind.i4", "ldind.i8", "ldind.r4", "ldind.r8", "ldind.ref", "ldind.u1", "ldind.u2", "ldind.u4", "ldlen", "ldloc", "ldloca", "ldloca.s", "ldloc.0", "ldloc.1", "ldloc.2", "ldloc.3", "ldloc.s", "ldnull", "ldobj", "ldsfld", "ldsflda", "ldstr", "ldtoken", "ldvirtftn", "starg", "starg.s", "stelem.i", "stelem.i1", "stelem.i2", "stelem.i4", "stelem.i8", "stelem.r4", "stelem.r8", "stelem.ref", "stfld", "stind.i", "stind.i1", "stind.i2", "stind.i4", "stind.i8", "stind.r4", "stind.r8", "stind.ref", "stloc", "stloc.0", "stloc.1", "stloc.2", "stloc.3", "stloc.s", "stobj", "stsfld", "call", "calli", "callvirt", "castclass", "ceq", "cgt", "cgt.un", "ckfinite", "clt", "clt.un", "cpblk", "cpobj", "initblk", "initobj", "newarr", "newobj", "dup", "endfilter", "isinst", "box", "unbox", "arglist", "break", "jmp", "ret", "leave", "leave.s", "localloc", "mkrefany", "neg", "switch", "nop", "pop", "refanytype", "refanyval", "rem", "rem.un", "throw", "rethrow", "endfinally", "shl", "shr", "shr.un", "sizeof", "tailcall", "unaligned", "volatile", });
        KEYWORDS1.add("KEYWORD3", new String[]{"string", "object", "bool", "true", "false", "bytearray", "char", "float32", "float64", "int8", "int16", "int32", "int64", "nullref", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

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
