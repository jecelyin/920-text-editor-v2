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
public class BatchLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "rem";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "(";
        PROPERTY2.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = ")";
        PROPERTY3.NAME = "indentCloseBrackets";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "FALSE";
        RULES1.IGNORE_CASE = "TRUE";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "@";
        SEQ1.TYPE = "KEYWORD3";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "+";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "|";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "&";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "!";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = ">";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "<";
        SEQ7.TYPE = "OPERATOR";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = ":";
        MARK_FOLLOWING1.AT_WORD_START = "TRUE";
        MARK_FOLLOWING1.TYPE = "LABEL";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP1 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP1.text = "REM\\s";
        EOL_SPAN_REGEXP1.AT_WHITESPACE_END = "TRUE";
        EOL_SPAN_REGEXP1.TYPE = "COMMENT1";
        EOL_SPAN_REGEXP1.HASH_CHAR = "REM";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ SEQ8 = new SEQ();
        SEQ8.text = "%0";
        SEQ8.TYPE = "KEYWORD2";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "%1";
        SEQ9.TYPE = "KEYWORD2";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "%2";
        SEQ10.TYPE = "KEYWORD2";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "%3";
        SEQ11.TYPE = "KEYWORD2";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "%4";
        SEQ12.TYPE = "KEYWORD2";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "%5";
        SEQ13.TYPE = "KEYWORD2";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "%6";
        SEQ14.TYPE = "KEYWORD2";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "%7";
        SEQ15.TYPE = "KEYWORD2";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "%8";
        SEQ16.TYPE = "KEYWORD2";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "%9";
        SEQ17.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "%%[\\p{Alpha}]";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "KEYWORD2";
        SEQ_REGEXP1.HASH_CHAR = "%%";
        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "KEYWORD2";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "%";
        END END2 = new END();
        END2.text = "%";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"cd", "chdir", "md", "mkdir", "cls", "for", "if", "echo", "echo.", "move", "copy", "move", "ren", "del", "set", "call", "exit", "setlocal", "shift", "endlocal", "pause", "not", });
        KEYWORDS1.add("KEYWORD2", new String[]{"defined", "exist", "errorlevel", "else", "in", "do", "NUL", "AUX", "PRN", });
        KEYWORDS1.add("FUNCTION", new String[]{"APPEND", "ATTRIB", "CHKDSK", "CHOICE", "DEBUG", "DEFRAG", "DELTREE", "DISKCOMP", "DISKCOPY", "DOSKEY", "DRVSPACE", "EMM386", "EXPAND", "FASTOPEN", "FC", "FDISK", "FIND", "FORMAT", "GRAPHICS", "KEYB", "LABEL", "LOADFIX", "MEM", "MODE", "MORE", "MOVE", "MSCDEX", "NLSFUNC", "POWER", "PRINT", "RD", "REPLACE", "RESTORE", "SETVER", "SHARE", "SORT", "SUBST", "SYS", "TREE", "UNDELETE", "UNFORMAT", "VSAFE", "XCOPY", });
        KEYWORDS1.add("KEYWORD3", new String[]{"goto", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.EOL_SPAN_REGEXP = new EOL_SPAN_REGEXP[] { EOL_SPAN_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, };

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
