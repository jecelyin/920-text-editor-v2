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
public class RedcodeLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = ";";
        PROPERTY1.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DEFAULT = "MARKUP";
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = ";redcode";
        EOL_SPAN1.TYPE = "COMMENT2";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = ";author";
        EOL_SPAN2.TYPE = "COMMENT2";
        EOL_SPAN EOL_SPAN3 = new EOL_SPAN();
        EOL_SPAN3.text = ";name";
        EOL_SPAN3.TYPE = "COMMENT2";
        EOL_SPAN EOL_SPAN4 = new EOL_SPAN();
        EOL_SPAN4.text = ";strategy";
        EOL_SPAN4.TYPE = "COMMENT2";
        EOL_SPAN EOL_SPAN5 = new EOL_SPAN();
        EOL_SPAN5.text = ";password";
        EOL_SPAN5.TYPE = "COMMENT2";
        EOL_SPAN EOL_SPAN6 = new EOL_SPAN();
        EOL_SPAN6.text = ";";
        EOL_SPAN6.TYPE = "COMMENT1";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ".AB";
        SEQ1.TYPE = "KEYWORD3";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ".BA";
        SEQ2.TYPE = "KEYWORD3";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = ".A";
        SEQ3.TYPE = "KEYWORD3";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = ".B";
        SEQ4.TYPE = "KEYWORD3";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = ".F";
        SEQ5.TYPE = "KEYWORD3";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = ".X";
        SEQ6.TYPE = "KEYWORD3";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = ".I";
        SEQ7.TYPE = "KEYWORD3";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = ",";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = ":";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "(";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = ")";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "+";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "-";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "/";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "%";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "==";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "!=";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "<=";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = ">=";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "<";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = ">";
        SEQ21.TYPE = "OPERATOR";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "&&";
        SEQ22.TYPE = "OPERATOR";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "||";
        SEQ23.TYPE = "OPERATOR";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "!";
        SEQ24.TYPE = "OPERATOR";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "=";
        SEQ25.TYPE = "OPERATOR";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = "$";
        SEQ26.TYPE = "LITERAL1";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "@";
        SEQ27.TYPE = "LITERAL1";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "#";
        SEQ28.TYPE = "LITERAL1";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = "*";
        SEQ29.TYPE = "LITERAL1";
        SEQ SEQ30 = new SEQ();
        SEQ30.text = "{";
        SEQ30.TYPE = "LITERAL1";
        SEQ SEQ31 = new SEQ();
        SEQ31.text = "}";
        SEQ31.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"CORESIZE", "MAXPROCESSES", "MAXCYCLES", "MAXLENGTH", "MINDISTANCE", "ROUNDS", "PSPACESIZE", "CURLINE", "VERSION", "WARRIORS", });
        KEYWORDS1.add("KEYWORD1", new String[]{"DAT", "MOV", "ADD", "SUB", "MUL", "DIV", "MOD", "JMP", "JMZ", "JMN", "DJN", "SPL", "SLT", "CMP", "SEQ", "SNE", "NOP", "LDP", "STP", });
        KEYWORDS1.add("KEYWORD2", new String[]{"EQU", "ORG", "FOR", "ROF", "END", "PIN", "CORESIZE", "MAXPROCESSES", "MAXCYCLES", "MAXLENGTH", "MINDISTANCE", "ROUNDS", "PSPACESIZE", "CURLINE", "VERSION", "WARRIORS", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, EOL_SPAN3, EOL_SPAN4, EOL_SPAN5, EOL_SPAN6, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, SEQ30, SEQ31, };

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
