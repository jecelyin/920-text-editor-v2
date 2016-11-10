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
public class YabLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "'";
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
        RULES1.ESCAPE = "\\";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "rem";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "//";
        EOL_SPAN2.TYPE = "COMMENT2";
        EOL_SPAN EOL_SPAN3 = new EOL_SPAN();
        EOL_SPAN3.text = "documentation";
        EOL_SPAN3.TYPE = "COMMENT3";
        EOL_SPAN3.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN4 = new EOL_SPAN();
        EOL_SPAN4.text = "docu";
        EOL_SPAN4.TYPE = "COMMENT3";
        EOL_SPAN4.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN5 = new EOL_SPAN();
        EOL_SPAN5.text = "doc";
        EOL_SPAN5.TYPE = "COMMENT3";
        EOL_SPAN5.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN6 = new EOL_SPAN();
        EOL_SPAN6.text = "#";
        EOL_SPAN6.TYPE = "COMMENT4";
        EOL_SPAN6.AT_LINE_START = "TRUE";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "<";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "<=";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = ">=";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = ">";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "=";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "<>";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "+";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "-";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "*";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "/";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "**";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "^";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "and(";
        SEQ13.AT_WORD_START = "TRUE";
        SEQ13.TYPE = "FUNCTION";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "&";
        SEQ14.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = ":";
        MARK_PREVIOUS1.TYPE = "LABEL";
        MARK_PREVIOUS1.AT_LINE_START = "TRUE";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"let", "mod", });
        KEYWORDS1.add("LITERAL2", new String[]{"euler", "pi", });
        KEYWORDS1.add("KEYWORD1", new String[]{"case", "default", "else", "elseif", "elsif", "endif", "fi", "if", "switch", "then", "gosub", "goto", "label", "return", "bind", "compile", "break", "continue", "do", "each", "for", "in", "loop", "next", "repeat", "step", "to", "until", "wend", "while", "end", "exit", "pause", "sleep", "wait", "export", "import", "local", "numparam", "numparams", "static", "sub", "subroutine", "const", "dim", "redim", "execute$", "execute", "system", "system$", "beep", "bell", "clear", "data", "erase", "error", "explicit", "getscreen$", "goto", "interrupt", "on", "option", "putscreen", "randomize", "read", "restore", "resume", "screen", "@", "as", "at", "close", "eof", "inkey$", "input", "line", "mouseb", "mousemod", "mousex", "mousey", "open", "peek$", "peek", "poke", "print", "printer", "reading", "seek", "tell", "using", "writing", "backcolor", "backcolour", "box", "circle", "clear", "color", "colour", "curve", "dot", "fill", "getbit$", "line", "new", "origin", "putbit", "rectangle", "reverse", "text", "triangle", "window", });
        KEYWORDS1.add("KEYWORD2", new String[]{"documentation", "docu", "doc", "arraydimension", "arraydim", "arraysize", });
        KEYWORDS1.add("FUNCTION", new String[]{"bin$", "dec", "hex$", "str$", "date$", "time$", "abs", "acos", "asin", "atan", "bin$", "cos", "dec", "eor", "exp", "fix", "frac", "int", "log", "max", "min", "ran", "sgn", "sig", "sin", "sqr", "sqrt", "tan", "asc", "chr$", "glob", "hex$", "instr", "left$", "len", "lower$", "ltrim$", "mid$", "right$", "rinstr", "rtrim$", "split", "token", "trim$", "upper$", "val", });
        KEYWORDS1.add("KEYWORD3", new String[]{"rem", "docu$", "and", "eor", "imp", "not", "or", "xor", "false", "true", });
        KEYWORDS1.add("KEYWORD4", new String[]{"alotta", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, EOL_SPAN3, EOL_SPAN4, EOL_SPAN5, EOL_SPAN6, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, };

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
