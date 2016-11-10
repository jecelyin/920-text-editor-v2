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
public class MacroschedulerLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "/*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "*/";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "//";
        PROPERTY3.NAME = "lineComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "{";
        PROPERTY4.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "}";
        PROPERTY5.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "(";
        PROPERTY6.NAME = "unalignedOpenBrackets";
        PROPERTY PROPERTY7 = new PROPERTY();
        PROPERTY7.VALUE = ")";
        PROPERTY7.NAME = "unalignedCloseBrackets";
        PROPERTY PROPERTY8 = new PROPERTY();
        PROPERTY8.VALUE = "\\s*(((if|while)\\s*\\(|else\\s*|else\\s+if\\s*\\(|for\\s*\\(.*\\))[^{;]*)";
        PROPERTY8.NAME = "indentNextLine";
        PROPERTY PROPERTY9 = new PROPERTY();
        PROPERTY9.VALUE = "^.*(default:\\s*|case.*:.*)$";
        PROPERTY9.NAME = "unindentThisLine";
        PROPERTY PROPERTY10 = new PROPERTY();
        PROPERTY10.VALUE = ":";
        PROPERTY10.NAME = "electricKeys";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, PROPERTY8, PROPERTY9, PROPERTY10, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(0x[\\p{XDigit}]+[lL]?|[\\p{Digit}]+(e[\\p{Digit}]*)?[lLdDfF]?)";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "///";
        EOL_SPAN1.TYPE = "COMMENT3";
        EOL_SPAN1.DELEGATE = "DOC_COMMENT";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "//";
        EOL_SPAN2.TYPE = "COMMENT2";
        EOL_SPAN EOL_SPAN3 = new EOL_SPAN();
        EOL_SPAN3.text = "///";
        EOL_SPAN3.TYPE = "COMMENT4";
        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL3";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "@\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "TRUE";
        SPAN3.TYPE = "LITERAL1";
        SPAN3.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "\"";
        END END3 = new END();
        END3.text = "\"";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.NO_LINE_BREAK = "TRUE";
        SPAN4.TYPE = "LITERAL1";
        SPAN4.ESCAPE = "\\";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "'";
        END END4 = new END();
        END4.text = "'";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        EOL_SPAN EOL_SPAN4 = new EOL_SPAN();
        EOL_SPAN4.text = "#if";
        EOL_SPAN4.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN5 = new EOL_SPAN();
        EOL_SPAN5.text = "#else";
        EOL_SPAN5.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN6 = new EOL_SPAN();
        EOL_SPAN6.text = "#endif";
        EOL_SPAN6.TYPE = "KEYWORD2";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "~";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "!";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = ":";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = ";";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "{";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "}";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = ",";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = ".";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "!";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "[";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "]";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "+";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "-";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = ">";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "<";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "=";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "*";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "/";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "\\";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "^";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "|";
        SEQ21.TYPE = "OPERATOR";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "&";
        SEQ22.TYPE = "OPERATOR";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "%";
        SEQ23.TYPE = "OPERATOR";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "?";
        SEQ24.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = ")";
        SEQ25.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"false", "null", "this", "true", });
        KEYWORDS1.add("KEYWORD1", new String[]{"AddDialogHandler", "AddTrayHandler", "AddTrayIcon", "AppendFile", "ArrayCount", "ArraySort", "Ascii", "Ask", "Assigned", "BlockInput", "CSVFileToArray", "CapsOff", "CapsOn", "ChangeDirectory", "CloseDialog", "CloseWindow", "CompareBitmaps", "ConCat", "CopyFile", "CopyFolder", "CountFiles", "CreateDir", "Crypt", "DBClose", "DBConnect", "DBExec", "DBQuery", "DDEPoke", "DDERequest", "DateStamp", "Day", "DayOfWeek", "DelTrayIcon", "DeleteFile", "DeleteFolder", "Dialog", "EditIniFile", "Else", "End", "EndDialog", "EndIf", "EndWhile", "ExecuteFile", "Exit", "ExportData", "ExtractFileExt", "ExtractFileName", "ExtractFilePath", "FTPDelFile", "FTPGetDirList", "FTPGetFile", "FTPMakeDir", "FTPPutFile", "FTPRemoveDir", "FTPRenameFile", "FileDate", "FileSize", "FileTime", "FindImagePos", "FindWindowWithText", "GetActiveWindow", "GetCaretPos", "GetCheckBox", "GetClipBoard", "GetControlText", "GetCursorPos", "GetDate", "GetDialogAction", "GetDialogProperty", "GetEnvVar", "GetFileList", "GetFocusedObject", "GetListItem", "GetPixelColor", "GetRectCheckSum", "GetScreenRes", "GetTextAtPoint", "GetTextInRect", "GetTextReset", "GetTime", "GetTreeNode", "GetWindowHandle", "GetWindowList", "GetWindowNames", "GetWindowPos", "GetWindowProcess", "GetWindowSize", "GetWindowText", "GetWindowTextEx", "GoSub", "Goto", "HTTPRequest", "Hour", "If", "IfDirExists", "IfFileChanged", "IfFileExists", "IfWindowOpen", "Input", "IsConnectedToInternet", "KillProcess", "LClick", "LDblClick", "LDown", "LTrim", "LUp", "LabelToVar", "Len", "Length", "LibFree", "LibFunc", "LibFuncW", "LibLoad", "LowerCase", "MClick", "MDblClick", "MDown", "MUp", "Macro", "Message", "MessageModal", "MidStr", "Min", "Month", "MouseMove", "MouseMoveRel", "MouseOver", "MoveFile", "MoveWindow", "NumOff", "NumOn", "OnEvent", "PlayWav", "Position", "Press", "ProcessExists", "PushButton", "PutClipBoard", "RClick", "RDblClick", "RDown", "RGB", "RTrim", "RUp", "ReadFile", "ReadIniFile", "ReadLn", "RegEx", "RegistryDelKey", "RegistryDelVal", "RegistryReadKey", "RegistryWriteKey", "Release", "Remark", "RenameFile", "Repeat", "ResetDialogAction", "ResizeWindow", "RetrievePOP3", "RunProgram", "SMTPSendMail", "ScreenCapture", "ScrollOff", "ScrollOn", "Sec", "SelectMenu", "Send", "SendText", "Separate", "SetCheckBox", "SetControlText", "SetDialogObjectColor", "SetDialogObjectFocus", "SetDialogObjectFont", "SetDialogObjectVisible", "SetDialogProperty", "SetEnvVar", "SetFocus", "Show", "ShutDownWindows", "SkipLabel", "SoWrite", "SoWriteLn", "StringReplace", "TelnetClose", "TelnetConnect", "TelnetSend", "TelnetWaitFor", "TimeStamp", "Toolbar", "Trim", "Until", "UpperCase", "Wait", "WaitClipBoard", "WaitCursorChanged", "WaitKeyDown", "WaitPixelColor", "WaitProcessExists", "WaitProcessTerminated", "WaitReady", "WaitRectChanged", "WaitScreenImage", "WaitScreenText", "WaitWindowChanged", "WaitWindowClosed", "WaitWindowOpen", "While", "WindowAction", "WriteLn", "XLAddSheet", "XLCreate", "XLDelCol", "XLDelRow", "XLDelSheet", "XLGetCell", "XLGetSheetDims", "XLOpen", "XLQuit", "XLRun", "XLSave", "XLSetCell", "Year", });
        KEYWORDS1.add("KEYWORD2", new String[]{"Include", "Label", "VBEnd", "VBEval", "VBRun", "VBStart", });
        KEYWORDS1.add("KEYWORD3", new String[]{"Abs", "Add", "ArcTan", "Cos", "Exp", "Frac", "Int", "Let", "Ln", "Pi", "Power", "Random", "Round", "Sin", "Sqr", "Sqrt", "Sub", "Trunc", "Base64", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, EOL_SPAN3, EOL_SPAN4, EOL_SPAN5, EOL_SPAN6, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "DOC_COMMENT";
        RULES1.DEFAULT = "COMMENT3";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<--";
        END END1 = new END();
        END1.text = "-->";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "MARKUP";
        SPAN2.DELEGATE = "xml::TAGS";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<";
        END END2 = new END();
        END2.text = ">";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
