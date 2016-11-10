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
public class Nsis2Lang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "/*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "*/";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = ";";
        PROPERTY3.NAME = "lineComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "\\s*(.*:|(function\\s+.*)|(section\\s+.*)|(subsection\\s+.*))";
        PROPERTY4.NAME = "indentNextLine";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DEFAULT = "NULL";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "/**/";
        SEQ1.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = ";";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "#";
        EOL_SPAN2.TYPE = "COMMENT2";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "$";
        MARK_FOLLOWING1.TYPE = "KEYWORD3";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "::";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = ":";
        MARK_PREVIOUS2.TYPE = "LABEL";
        MARK_PREVIOUS2.MATCH_TYPE = "OPERATOR";
        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.DELEGATE = "NSIS_LITERAL";
        SPAN2.ESCAPE = "$\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL1";
        SPAN3.DELEGATE = "NSIS_LITERAL";
        SPAN3.ESCAPE = "$\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "LITERAL1";
        SPAN4.DELEGATE = "NSIS_LITERAL";
        SPAN4.ESCAPE = "$\\";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "`";
        END END4 = new END();
        END4.text = "`";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("INVALID", new String[]{"dim", "uninstallexename", "subsection", "subsectionend", });
        KEYWORDS1.add("KEYWORD1", new String[]{"!ifdef", "!ifndef", "!if", "!else", "!endif", "!macro", "!macroend", "function", "functionend", "section", "sectiongroup", "sectionend", "sectiongroupend", "abort", "call", "clearerrors", "goto", "ifabort", "iferrors", "iffileexists", "ifrebootflag", "intcmp", "intcmpu", "iswindow", "messagebox", "reboot", "return", "quit", "seterrors", "strcmp", "strcmps", });
        KEYWORDS1.add("LITERAL3", new String[]{"ARCHIVE", "CENTER", "CONTROL", "CUR", "EXT", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12", "F13", "F14", "F15", "F16", "F17", "F18", "F19", "F20", "F21", "F22", "F23", "F24", "FILE_ATTRIBUTE_ARCHIVE", "MB_ABORTRETRYIGNORE", "RIGHT", "RO", "SET", "SHIFT", "SW_SHOWMAXIMIZED", "SW_SHOWMINIMIZED", "SW_SHOWNORMAL", "a", "admin", "all", "alwaysoff", "auto", "both", "bottom", "bzip2", "checkbox", "colored", "components", "current", "custom", "directory", "false", "force", "hide", "highest", "ifnewer", "instfiles", "license", "listonly", "manual", "nevershow", "none", "off", "on", "r", "radiobuttons", "show", "silent", "silentlog", "smooth", "textonly", "top", "true", "try", "uninstConfirm", "user", "w", "zlib", "$$", "$DESKTOP", "$EXEDIR", "$HWNDPARENT", "$PLUGINSDIR", "$PROGRAMFILES", "$QUICKLAUNCH", "$SMPROGRAMS", "$SMSTARTUP", "$STARTMENU", "$SYSDIR", "$TEMP", "$WINDIR", "$\\n", "$\\r", "${NSISDIR}", "ALT", "END", "FILE_ATTRIBUTE_HIDDEN", "FILE_ATTRIBUTE_NORMAL", "FILE_ATTRIBUTE_OFFLINE", "FILE_ATTRIBUTE_READONLY", "FILE_ATTRIBUTE_SYSTEM", "FILE_ATTRIBUTE_TEMPORARY", "HIDDEN", "HKCC", "HKCR", "HKCU", "HKDD", "HKLM", "HKPD", "HKU", "SHCTX", "IDABORT", "IDCANCEL", "IDIGNORE", "IDNO", "IDOK", "IDRETRY", "IDYES", "LEFT", "MB_DEFBUTTON1", "MB_DEFBUTTON2", "MB_DEFBUTTON3", "MB_DEFBUTTON4", "MB_ICONEXCLAMATION", "MB_ICONINFORMATION", "MB_ICONQUESTION", "MB_ICONSTOP", "MB_OK", "MB_OKCANCEL", "MB_RETRYCANCEL", "MB_RIGHT", "MB_SETFOREGROUND", "MB_TOPMOST", "MB_YESNO", "MB_YESNOCANCEL", "NORMAL", "OFFLINE", "READONLY", "SYSTEM", "TEMPORARY", });
        KEYWORDS1.add("KEYWORD2", new String[]{"!addincludedir", "!addplugindir", "!define", "!include", "!cd", "!echo", "!error", "!insertmacro", "!packhdr", "!system", "!warning", "!undef", "!verbose", "addbrandingimage", "addsize", "allowrootdirinstall", "allowskipfiles", "autoclosewindow", "bggradient", "brandingtext", "bringtofront", "callinstdll", "caption", "changeui", "checkbitmap", "completedtext", "componenttext", "copyfiles", "crccheck", "createdirectory", "createfont", "createshortcut", "delete", "deleteinisec", "deleteinistr", "deleteregkey", "deleteregvalue", "detailprint", "detailsbuttontext", "dirshow", "dirtext", "enumregkey", "enumregvalue", "exch", "exec", "execshell", "execwait", "expandenvstrings", "file", "fileclose", "fileerrortext", "fileopen", "fileread", "filereadbyte", "fileseek", "filewrite", "filewritebyte", "findclose", "findfirst", "findnext", "findwindow", "flushini", "getcurinsttype", "getcurrentaddress", "getdlgitem", "getdllversion", "getdllversionlocal", "getfiletime", "getfiletimelocal", "getfullpathname", "getfunctionaddress", "getlabeladdress", "gettempfilename", "getwindowtext", "hidewindow", "icon", "initpluginsdir", "installbuttontext", "installcolors", "installdir", "installdirregkey", "instprogressflags", "insttype", "insttypegettext", "insttypesettext", "intfmt", "intop", "langstring", "langstringup", "licensebkcolor", "licensedata", "licenseforceselection", "licensetext", "loadlanguagefile", "loadlanguagefile", "logset", "logtext", "miscbuttontext", "name", "nop", "outfile", "page", "plugindir", "pop", "push", "readenvstr", "readinistr", "readregdword", "readregstr", "regdll", "rename", "requestexecutionlevel", "reservefile", "rmdir", "searchpath", "sectiongetflags", "sectiongetinsttypes", "sectiongetsize", "sectiongettext", "sectionin", "sectionsetflags", "sectionsetinsttypes", "sectionsetsize", "sectionsettext", "sendmessage", "setautoclose", "setbkcolor", "setbrandingimage", "setcompress", "setcompressor", "setcurinsttype", "setdatablockoptimize", "setdatesave", "setdetailsprint", "setdetailsview", "seterrorlevel", "setfileattributes", "setfont", "setoutpath", "setoverwrite", "setpluginunload", "setrebootflag", "setregview", "setshellvarcontext", "setstaticbkcolor", "setwindowlong", "showinstdetails", "showuninstdetails", "showwindow", "silentinstall", "silentuninstall", "sleep", "spacetexts", "strcpy", "strlen", "subcaption", "uninstallbuttontext", "uninstallcaption", "uninstallicon", "uninstallsubcaption", "uninstalltext", "uninstpage", "unregdll", "var", "viaddversionkey", "videscription", "vicompanyname", "vicomments", "vilegalcopyrights", "vilegaltrademarks", "viproductname", "viproductversion", "windowicon", "writeinistr", "writeregbin", "writeregdword", "writeregexpandstr", "writeregstr", "writeuninstaller", "xpstyle", });
        KEYWORDS1.add("KEYWORD3", new String[]{"$0", "$1", "$2", "$3", "$4", "$5", "$6", "$7", "$8", "$9", "$INSTDIR", "$OUTDIR", "$CMDLINE", "$LANGUAGE", "$R0", "$R1", "$R2", "$R3", "$R4", "$R5", "$R6", "$R7", "$R8", "$R9", ".onguiinit", ".oninit", ".oninstfailed", ".oninstsuccess", ".onmouseoversection", ".onselchange", ".onuserabort", ".onverifyinstdir", "un.onguiinit", "un.oninit", "un.onuninstfailed", "un.onuninstsuccess", "un.onuserabort", });
        KEYWORDS1.add("KEYWORD4", new String[]{"/0", "/COMPONENTSONLYONCUSTOM", "/CUSTOMSTRING", "/FILESONLY", "/IMGID", "/ITALIC", "/LANG", "/NOCUSTOM", "/NOUNLOAD", "/REBOOTOK", "/RESIZETOFIT", "/RTL", "/SHORT", "/SILENT", "/STRIKE", "/TIMEOUT", "/TRIM", "/UNDERLINE", "/a", "/e", "/ifempty", "/nonfatal", "/oname", "/r", "/windows", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "NSIS_LITERAL";
        RULES1.DEFAULT = "LITERAL1";
        RULES1.ESCAPE = "$\\";
        RULES1.NO_WORD_SEP = "-{}_";
        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
