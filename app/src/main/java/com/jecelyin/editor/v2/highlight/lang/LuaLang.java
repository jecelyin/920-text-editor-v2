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
public class LuaLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "--";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "--[[";
        PROPERTY2.NAME = "commentStart";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "]]";
        PROPERTY3.NAME = "commentEnd";
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
        PROPERTY7.VALUE = "true";
        PROPERTY7.NAME = "doubleBracketIndent";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[\\p{Digit}]*(\\.[\\p{Digit}]*)?([eE][+-]?[\\p{Digit}]*)?";
        RULES1.IGNORE_CASE = "FALSE";
        RULES1.NO_WORD_SEP = "_:.";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.HASH_CHARS = "--[";
        SPAN_REGEXP1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "--\\[(=*)\\[";
        END END1 = new END();
        END1.text = "]$1]";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "--";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "#!";
        EOL_SPAN2.TYPE = "COMMENT2";
        EOL_SPAN2.AT_LINE_START = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL1";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN1.END = new END[] { END2, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN2.END = new END[] { END3, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.TYPE = "LITERAL1";
        SPAN_REGEXP2.HASH_CHAR = "[";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "\\[(=*)\\[";
        END END4 = new END();
        END4.text = "]$1]";
        SPAN_REGEXP2.END = new END[] { END4, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN4, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "+";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "-";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "*";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "/";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "^";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "..";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "<=";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "<";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = ">=";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = ">";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "==";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "~=";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "=";
        SEQ13.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = ")";
        SEQ14.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = "{";
        MARK_PREVIOUS2.TYPE = "FUNCTION";
        MARK_PREVIOUS2.MATCH_TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "}";
        SEQ15.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS3 = new MARK_PREVIOUS();
        MARK_PREVIOUS3.text = "\"";
        MARK_PREVIOUS3.TYPE = "FUNCTION";
        MARK_PREVIOUS3.MATCH_TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "\"";
        SEQ16.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS4 = new MARK_PREVIOUS();
        MARK_PREVIOUS4.text = "'";
        MARK_PREVIOUS4.TYPE = "FUNCTION";
        MARK_PREVIOUS4.MATCH_TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "'";
        SEQ17.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"do", "end", "while", "repeat", "until", "if", "then", "elseif", "else", "return", "break", "for", "in", "function", "local", "and", "or", "not", });
        KEYWORDS1.add("KEYWORD2", new String[]{"assert", "collectgarbage", "dofile", "error", "_G", "getfenv", "getmetatable", "gcinfo", "ipairs", "loadfile", "loadlib", "loadstring", "next", "pairs", "pcall", "print", "rawequal", "rawget", "rawset", "require", "setfenv", "setmetatable", "tonumber", "tostring", "type", "unpack", "xpcall", "_VERSION", "LUA_PATH", "_LOADED", "_REQUIREDNAME", "_ALERT", "_ERRORMESSAGE", "_PROMPT", "__add", "__sub", "__mul", "__div", "__pow", "__unm", "__concat", "__eq", "__lt", "__le", "__index", "__newindex", "__call", "__metatable", "__mode", "__tostring", "__fenv", "...", "arg", "coroutine.create", "coroutine.resume", "coroutine.status", "coroutine.wrap", "coroutine.yield", "string.byte", "string.char", "string.dump", "string.find", "string.len", "string.lower", "string.rep", "string.sub", "string.upper", "string.format", "string.gfind", "string.gsub", "table.concat", "table.foreach", "table.foreachi", "table.getn", "table.sort", "table.insert", "table.remove", "table.setn", "math.abs", "math.acos", "math.asin", "math.atan", "math.atan2", "math.ceil", "math.cos", "math.deg", "math.exp", "math.floor", "math.log", "math.log10", "math.max", "math.min", "math.mod", "math.pow", "math.rad", "math.sin", "math.sqrt", "math.tan", "math.frexp", "math.ldexp", "math.random", "math.randomseed", "math.pi", "io.close", "io.flush", "io.input", "io.lines", "io.open", "io.read", "io.tmpfile", "io.type", "io.write", "io.stdin", "io.stdout", "io.stderr", "os.clock", "os.date", "os.difftime", "os.execute", "os.exit", "os.getenv", "os.remove", "os.rename", "os.setlocale", "os.time", "os.tmpname", "debug.debug", "debug.gethook", "debug.getinfo", "debug.getlocal", "debug.getupvalue", "debug.setlocal", "debug.setupvalue", "debug.sethook", "debug.traceback", });
        KEYWORDS1.add("KEYWORD3", new String[]{"nil", "true", "false", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, MARK_PREVIOUS3, MARK_PREVIOUS4, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, };

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
