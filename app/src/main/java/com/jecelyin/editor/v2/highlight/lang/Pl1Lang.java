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
public class Pl1Lang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "/*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "*/";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = ",+-=<>/?^&*";
        PROPERTY3.NAME = "wordBreakChars";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "FALSE";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL1";
        SPAN3.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "\"";
        END END3 = new END();
        END3.text = "\"";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        EOL_SPAN_REGEXP EOL_SPAN_REGEXP1 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP1.text = "\\* *process";
        EOL_SPAN_REGEXP1.TYPE = "KEYWORD2";
        EOL_SPAN_REGEXP1.AT_LINE_START = "TRUE";
        EOL_SPAN_REGEXP1.HASH_CHAR = "*";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "+";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "-";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "*";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "/";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = ">";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "<";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "^";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "¬";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "&";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "|";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = ".";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = ",";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = ";";
        SEQ14.TYPE = "OPERATOR";
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
        SEQ15.text = ")";
        SEQ15.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"alias", "alloc", "allocate", "attach", "begin", "by", "byname", "call", "close", "copy", "dcl", "declare", "default", "define", "delay", "delete", "detach", "dft", "display", "do", "downthru", "else", "end", "entry", "exit", "fetch", "flush", "format", "free", "from", "get", "go", "goto", "if", "ignore", "%include", "into", "iterate", "key", "keyfrom", "keyto", "leave", "line", "locate", "loop", "name", "on", "open", "ordinal", "other", "otherwise", "package", "page", "proc", "procedure", "put", "read", "release", "repeat", "reply", "resignal", "return", "revert", "rewrite", "select", "set", "signal", "skip", "snap", "stop", "string", "structure", "then", "thread", "to", "tstack", "unlock", "until", "upthru", "wait", "when", "while", "write", });
        KEYWORDS1.add("KEYWORD2", new String[]{"A", "abnormal", "aligned", "anycond", "anycondition", "area", "asgn", "asm", "assembler", "assignable", "attn", "attention", "auto", "automatic", "b", "b3", "b4", "based", "bigendian", "bin", "binary", "bit", "buf", "buffered", "builtin", "bx", "byaddr", "byvalue", "C", "cdecl", "cell", "char", "character", "charg", "chargraphic", "cobol", "column", "complex", "cond", "condition", "conn", "connected", "controlled", "conv", "conversion", "cplx", "ctl", "data", "date", "dec", "decimal", "def", "defined", "descriptor", "descriptors", "dim", "dimension", "direct", "E", "edit", "endfile", "endpage", "env", "environment", "error", "exclusive", "exports", "ext", "external", "F", "fetchable", "file", "finish", "fixed", "fixedoverflow", "float", "fofl", "format", "fortran", "fromalien", "g", "generic", "graphic", "gx", "handle", "hexadec", "ieee", "imported", "init", "initial", "inline", "input", "inter", "internal", "invalidop", "irred", "irreducible", "keyed", "L", "label", "like", "limited", "linesize", "linkage", "list", "littleendian", "m", "main", "native", "nonasgn", "nocharg", "nochargraphic", "nodescriptor", "noexecops", "nomap", "nomapin", "nomapout", "nonasgn", "nonassignable", "nonconn", "nonconnected", "nonnative", "nonvar", "nonvarying", "normal", "offset", "ofl", "optional", "options", "optlink", "order", "output", "overflow", "P", "pagesize", "parameter", "pic", "picture", "pointer", "pos", "position", "prec", "precision", "print", "ptr", "R", "range", "real", "record", "recursive", "red", "reducible", "reentrant", "refer", "reorder", "reserved", "reserves", "retcode", "returns", "seql", "sequential", "signed", "size", "static", "stdcall", "storage", "stream", "strg", "stringrange", "strz", "stringsize", "subrg", "subscriptrange", "system", "task", "title", "transmit", "type", "ufl", "unal", "unaligned", "unbuf", "unbuffered", "undefinedfile", "underflow", "undf", "union", "unsigned", "update", "value", "var", "variable", "varying", "varyingz", "varz", "wchar", "widechar", "winmain", "wx", "x", "xn", "xu", "zdiv", "zerodivide", });
        KEYWORDS1.add("KEYWORD3", new String[]{"abs", "acos", "acosf", "add", "addr", "address", "addrdata", "all", "allocation", "allocn", "allocsize", "any", "asin", "asinf", "atan", "atand", "atanf", "atanh", "availablearea", "binaryvalue", "bind", "binvalue", "bitlocation", "bitloc", "bool", "byte", "cast", "cds", "ceil", "center", "centre", "centreleft", "centreleft", "centreright", "centerright", "charg", "chargraphic", "chargval", "checkstg", "collate", "compare", "conjg", "cos", "cosd", "cosf", "cosh", "count", "cs", "cstg", "currentsize", "currentstorage", "datafield", "date", "datetime", "days", "daystodate", "daystosecs", "divide", "empty", "entryaddr", "epsilon", "erfc", "exp", "expf", "exponent", "fileddint", "fileddtest", "fileddword", "fileid", "fileopen", "fileread", "fileseek", "filetell", "filewrite", "first", "floor", "gamma", "getenv", "hbound", "hex", "heximage", "high", "huge", "iand", "ieor", "imag", "index", "inot", "ior", "isigned", "isll", "ismain", "isrl", "iunsigned", "last", "lbound", "left", "length", "lineno", "loc", "location", "log", "logf", "loggamma", "log2", "log10", "log10f", "low", "lowercase", "lower2", "max", "maxexp", "maxlength", "min", "minexp", "mod", "mpstr", "multiply", "new", "null", "offestadd", "offestdiff", "offestsubtract", "offestvalue", "omitted", "onchar", "oncode", "oncondond", "oncondid", "oncount", "onfile", "ongsource", "onkey", "onloc", "onsource", "onsubcode", "onwchar", "onwsource", "ordinalname", "ordinalpred", "ordinalsucc", "packagename", "pageno", "places", "pliascii", "plianc", "plickpt", "plidelete", "plidump", "pliebcdic", "plifill", "plifree", "plimove", "pliover", "plirest", "pliretc", "pliretv", "plisaxa", "plisaxb", "plisrta", "plisrtb", "plisrtc", "plisrtd", "pointeradd", "ptradd", "pointerdiff", "ptrdiff", "pointersubtract", "ptrsubtract", "pointervalue", "ptrvalue", "poly", "pred", "present", "procname", "procedurename", "prod", "putenv", "radix", "raise", "random", "rank", "rem", "repattern", "respec", "reverse", "right", "round", "samekey", "scale", "search", "searchr", "secs", "secstodate", "secstodays", "sign", "signed", "sin", "sind", "sinf", "sinh", "size", "sourcefile", "sourceline", "sqrt", "sqrtf", "stg", "storage", "string", "substr", "subtract", "succ", "sum", "sysnull", "tally", "tan", "tand", "tanf", "tanh", "threadid", "time", "tiny", "translate", "trim", "trunc", "type", "unallocated", "unspec", "uppercase", "valid", "validdate", "varglist", "vargsizer", "verify", "verifyr", "wcharval", "weekday", "whigh", "wlow", "y4date", "y4julian", "y4year", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, };

        RULES1.EOL_SPAN_REGEXP = new EOL_SPAN_REGEXP[] { EOL_SPAN_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

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
