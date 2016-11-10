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
public class VerilogLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "(.*:\\s*)|(\\s*(begin|fork|task|table|specify|primitive|module|generate|function|case[xz]?)\\b.*)|(\\s*(always|if|else|for|forever|initial|repeat|while)\\b[^;]*)";
        PROPERTY1.NAME = "indentNextLines";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "/*";
        PROPERTY2.NAME = "commentStart";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "*/";
        PROPERTY3.NAME = "commentEnd";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "//";
        PROPERTY4.NAME = "lineComment";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "_'";
        PROPERTY5.NAME = "noWordSep";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = ",+-=<>/?^&*";
        PROPERTY6.NAME = "wordBreakChars";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "([\\p{Digit}]|_|[a-fA-F])+";
        RULES1.IGNORE_CASE = "FALSE";
        RULES1.NO_WORD_SEP = "'";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "//";
        EOL_SPAN1.TYPE = "COMMENT2";
        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL1";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "'d";
        SEQ1.TYPE = "DIGIT";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "'h";
        SEQ2.TYPE = "DIGIT";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "'b";
        SEQ3.TYPE = "DIGIT";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "'o";
        SEQ4.TYPE = "DIGIT";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = ")";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "=";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "!";
        SEQ7.TYPE = "OPERATOR";
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
        SEQ12.text = ">";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "<";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "%";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "&";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "|";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "^";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "~";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "}";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "{";
        SEQ20.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"always", "assign", "begin", "case", "casex", "casez", "default", "deassign", "disable", "else", "end", "endcase", "endfunction", "endgenerate", "endmodule", "endprimitive", "endspecify", "endtable", "endtask", "for", "force", "forever", "fork", "function", "generate", "if", "initial", "join", "macromodule", "module", "negedge", "posedge", "primitive", "repeat", "release", "specify", "table", "task", "wait", "while", });
        KEYWORDS1.add("KEYWORD2", new String[]{"`include", "`define", "`undef", "`ifdef", "`ifndef", "`else", "`elsif", "`endif", "`timescale", "`resetall", "`signed", "`unsigned", "`celldefine", "`endcelldefine", "`default_nettype", "`unconnected_drive", "`nounconnected_drive", "`protect", "`endprotect", "`protected", "`endprotected", "`remove_gatename", "`noremove_gatename", "`remove_netname", "`noremove_netname", "`expand_vectornets", "`noexpand_vectornets", "`autoexpand_vectornets", });
        KEYWORDS1.add("FUNCTION", new String[]{"$stop", "$finish", "$time", "$stime", "$realtime", "$settrace", "$cleartrace", "$showscopes", "$showvars", "$monitoron", "$monitoroff", "$random", "$printtimescale", "$timeformat", "and", "nand", "or", "nor", "xor", "xnor", "buf", "bufif0", "bufif1", "not", "notif0", "notif1", "nmos", "pmos", "cmos", "rnmos", "rpmos", "rcmos", "tran", "tranif0", "tranif1", "rtran", "rtranif0", "rtranif1", "pullup", "pulldown", });
        KEYWORDS1.add("KEYWORD3", new String[]{"integer", "reg", "time", "realtime", "defparam", "parameter", "event", "wire", "wand", "wor", "tri", "triand", "trior", "tri0", "tri1", "trireg", "vectored", "scalared", "input", "output", "inout", "logic", "supply0", "supply1", "strong0", "strong1", "pull0", "pull1", "weak0", "weak1", "highz0", "highz1", "small", "medium", "large", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

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
