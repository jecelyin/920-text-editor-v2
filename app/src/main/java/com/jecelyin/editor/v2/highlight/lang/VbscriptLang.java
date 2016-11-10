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
public class VbscriptLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "'";
        PROPERTY1.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, };

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
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#if";
        EOL_SPAN1.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "#else";
        EOL_SPAN2.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN3 = new EOL_SPAN();
        EOL_SPAN3.text = "#end";
        EOL_SPAN3.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN4 = new EOL_SPAN();
        EOL_SPAN4.text = "'";
        EOL_SPAN4.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN5 = new EOL_SPAN();
        EOL_SPAN5.text = "rem";
        EOL_SPAN5.TYPE = "COMMENT1";
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
        SEQ7.text = ".";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "+";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "-";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "*";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "/";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "\\";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "^";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "&";
        SEQ14.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = ":";
        MARK_PREVIOUS1.TYPE = "LABEL";
        MARK_PREVIOUS1.AT_LINE_START = "TRUE";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"is", "mod", "and", "or", "not", "xor", "imp", });
        KEYWORDS1.add("LITERAL2", new String[]{"vbblack", "vbred", "vbgreen", "vbyellow", "vbblue", "vbmagenta", "vbcyan", "vbwhite", "vbGeneralDate", "vbLongDate", "vbShortDate", "vbLongTime", "vbShortTime", "vbObjectError", "vbOKOnly", "vbOKCancel", "vbAbortRetryIgnore", "vbYesNoCancel", "vbYesNo", "vbRetryCancel", "vbCritical", "vbQuestion", "vbExclamation", "vbInformation", "vbDefaultButton1", "vbDefaultButton2", "vbDefaultButton3", "vbDefaultButton4", "vbApplicationModal", "vbSystemModal", "vbOK", "vbCancel", "vbAbort", "vbRetry", "vbIgnore", "vbYes", "vbNo", "vbUseDefault", "vbTrue", "vbFalse", "vbcr", "vbcrlf", "vbformfeed", "vblf", "vbnewline", "vbnullchar", "vbnullstring", "vbtab", "vbverticaltab", "vbempty", "vbnull", "vbinteger", "vblong", "vbsingle", "vbdouble", "vbcurrency", "vbdate", "vbstring", "vbobject", "vberror", "vbboolean", "vbvariant", "vbdataobject", "vbdecimal", "vbbyte", "vbarray", "adOpenForwardOnly", "adOpenKeyset", "adOpenDynamic", "adOpenStatic", "adLockReadOnly", "adLockPessimistic", "adLockOptimistic", "adLockBatchOptimistic", "adRunAsync", "adAsyncExecute", "adAsyncFetch", "adAsyncFetchNonBlocking", "adExecuteNoRecords", "adStateClosed", "adStateOpen", "adStateConnecting", "adStateExecuting", "adStateFetching", "adUseServer", "adUseClient", "adEmpty", "adTinyInt", "adSmallInt", "adInteger", "adBigInt", "adUnsignedTinyInt", "adUnsignedSmallInt", "adUnsignedInt", "adUnsignedBigInt", "adSingle", "adDouble", "adCurrency", "adDecimal", "adNumeric", "adBoolean", "adError", "adUserDefined", "adVariant", "adIDispatch", "adIUnknown", "adGUID", "adDate", "adDBDate", "adDBTime", "adDBTimeStamp", "adBSTR", "adChar", "adVarChar", "adLongVarChar", "adWChar", "adVarWChar", "adLongVarWChar", "adBinary", "adVarBinary", "adLongVarBinary", "adChapter", "adFileTime", "adDBFileTime", "adPropVariant", "adVarNumeric", "adPersistADTG", "adPersistXML", "adParamSigned", "adParamNullable", "adParamLong", "adParamUnknown", "adParamInput", "adParamOutput", "adParamInputOutput", "adParamReturnValue", "adCmdUnknown", "adCmdText", "adCmdTable", "adCmdStoredProc", "adCmdFile", "adCmdTableDirect", });
        KEYWORDS1.add("KEYWORD1", new String[]{"if", "then", "else", "elseif", "select", "case", "for", "to", "step", "next", "each", "in", "do", "while", "until", "loop", "wend", "exit", "end", "function", "sub", "class", "property", "get", "let", "set", "byval", "byref", "const", "dim", "redim", "preserve", "as", "set", "with", "new", "public", "default", "private", "rem", "call", "execute", "eval", "on", "error", "goto", "resume", "option", "explicit", "erase", "randomize", });
        KEYWORDS1.add("KEYWORD2", new String[]{"Err", "array", "lbound", "ubound", "cbool", "cbyte", "ccur", "cdate", "cdbl", "cint", "clng", "csng", "cstr", "hex", "oct", "date", "time", "dateadd", "datediff", "datepart", "dateserial", "datevalue", "day", "month", "monthname", "weekday", "weekdayname", "year", "hour", "minute", "second", "now", "timeserial", "timevalue", "formatcurrency", "formatdatetime", "formatnumber", "formatpercent", "inputbox", "loadpicture", "msgbox", "atn", "cos", "sin", "tan", "exp", "log", "sqr", "rnd", "rgb", "createobject", "getobject", "getref", "abs", "int", "fix", "round", "sgn", "scriptengine", "scriptenginebuildversion", "scriptenginemajorversion", "scriptengineminorversion", "asc", "ascb", "ascw", "chr", "chrb", "chrw", "filter", "instr", "instrb", "instrrev", "join", "len", "lenb", "lcase", "ucase", "left", "leftb", "mid", "midb", "right", "rightb", "replace", "space", "split", "strcomp", "string", "strreverse", "ltrim", "rtrim", "trim", "isarray", "isdate", "isempty", "isnull", "isnumeric", "isobject", "typename", "vartype", });
        KEYWORDS1.add("KEYWORD3", new String[]{"false", "true", "empty", "nothing", "null", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, EOL_SPAN3, EOL_SPAN4, EOL_SPAN5, };

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
