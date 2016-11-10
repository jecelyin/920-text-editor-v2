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
public class ObjectrexxLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "\\s*(if|loop|do|else|select|otherwise|catch|finally|class|method|properties)(.*)";
        PROPERTY1.NAME = "indentNextLines";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "/*";
        PROPERTY2.NAME = "commentStart";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "*/";
        PROPERTY3.NAME = "commentEnd";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "--";
        PROPERTY4.NAME = "lineComment";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = ",+-=<>/?^&*";
        PROPERTY5.NAME = "wordBreakChars";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(0x[\\p{XDigit}]+[lL]?|[\\p{Digit}]+(e[\\p{Digit}]*)?[lLdDfF]?)";
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
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "TRUE";
        SPAN3.TYPE = "LITERAL1";
        SPAN3.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "--";
        EOL_SPAN2.TYPE = "COMMENT1";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "!";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = ">=";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "<=";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "+";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "-";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "/";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "*";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = ">";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "<";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "%";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "&";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "|";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "^";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "~";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "}";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "{";
        SEQ17.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "::";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = ":";
        MARK_PREVIOUS2.AT_WHITESPACE_END = "TRUE";
        MARK_PREVIOUS2.TYPE = "LABEL";
        MARK_PREVIOUS2.MATCH_TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS3 = new MARK_PREVIOUS();
        MARK_PREVIOUS3.text = "(";
        MARK_PREVIOUS3.TYPE = "FUNCTION";
        MARK_PREVIOUS3.MATCH_TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = ")";
        SEQ18.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"Address", "Arg", "Call", "Do", "Drop", "Exit", "Expose", "Forward", "Guard", "If", "Interpret", "Iterate", "Leave", "Nop", "Numeric", "Parse", "Procedure", "pull", "Push", "Queue", "Raise", "reply", "Return", "Say", "Seleect", "Signal", "Trace", "use", "Class", "Method", "Requires", "Routine", "Result", "RC", "Self", "Sigl", "Super", });
        KEYWORDS1.add("KEYWORD2", new String[]{"Abbrev", "Abs", "Address", "Arg", "Beep", "BitAnd", "BitOr", "BitXor", "B2X", "Center", "ChangeStr", "CharIn", "CharOut", "Chars", "Compare", "Consition", "Copies", "CountStr", "C2D", "C2X", "DataType", "Date", "DelStr", "DelWord", "Digits", "Directory", "D2C", "D2X", "ErrorText", "FileSpec", "Form", "Format", "Fuzz", "Insert", "LastPos", "Left", "Length", "LineIn", "LineOut", "Lines", "Max", "Min", "Overlay", "Pos", "Queued", "Random", "Reverse", "Right", "Sign", "SourceLine", "Space", "Stream", "Strip", "SubStr", "SubWord", "Symbol", "Time", "Trace", "Translate", "Trunc", "Value", "Var", "Verify", "Word", "WordIndex", "WordLength", "WordPos", "Words", "XRange", "X2B", "X2C", "X2D", "RxFuncAdd", "RxFuncDrop", "RxFuncQuery", "RxMessageBox", "RxWinExec", "SysAddRexxMacro", "SysBootDrive", "SysClearRexxMacroSpace", "SysCloseEventSem", "SysCloseMutexSem", "SysCls", "SysCreateEventSem", "SysCreateMutexSem", "SysCurPos", "SysCurState", "SysDriveInfo", "SysDriveMap", "SysDropFuncs", "SysDropRexxMacro", "SysDumpVariables", "SysFileDelete", "SysFileSearch", "SysFileSystemType", "SysFileTree", "SysFromUnicode", "SysToUnicode", "SysGetErrortext", "SysGetFileDateTime", "SysGetKey", "SysIni", "SysLoadFuncs", "SysLoadRexxMacroSpace", "SysMkDir", "SysOpenEventSem", "SysOpenMutexSem", "SysPostEventSem", "SysPulseEventSem", "SysQueryProcess", "SysQueryRexxMacro", "SysReleaseMutexSem", "SysReorderRexxMacro", "SysRequestMutexSem", "SysResetEventSem", "SysRmDir", "SysSaveRexxMacroSpace", "SysSearchPath", "SysSetFileDateTime", "SysSetPriority", "SysSleep", "SysStemCopy", "SysStemDelete", "SysStemInsert", "SysStemSort", "SysSwitchSession", "SysSystemDirectory", "SysTempFileName", "SysTextScreenRead", "SysTextScreenSize", "SysUtilVersion", "SysVersion", "SysVolumeLabel", "SysWaitEventSem", "SysWaitNamedPipe", "SysWinDecryptFile", "SysWinEncryptFile", "SysWinVer", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, MARK_PREVIOUS3, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, };

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
