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
public class FoxproLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "&&";
        PROPERTY1.NAME = "blockComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "\\s*(((if|do\\swhile|do\\scase|try)\\s*\\(|else\\s*|elseif\\s*\\|case|catch(|for\\s*\\(.*\\))[^{;]*)";
        PROPERTY2.NAME = "indentNextLine";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "&&";
        PROPERTY3.NAME = "lineComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "true";
        PROPERTY4.NAME = "contextInsensitive";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, };

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

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

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
        EOL_SPAN4.text = "#define";
        EOL_SPAN4.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN5 = new EOL_SPAN();
        EOL_SPAN5.text = "#include";
        EOL_SPAN5.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN6 = new EOL_SPAN();
        EOL_SPAN6.text = "#Elif";
        EOL_SPAN6.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN7 = new EOL_SPAN();
        EOL_SPAN7.text = "#Else";
        EOL_SPAN7.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN8 = new EOL_SPAN();
        EOL_SPAN8.text = "#Endif";
        EOL_SPAN8.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN9 = new EOL_SPAN();
        EOL_SPAN9.text = "#If";
        EOL_SPAN9.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN10 = new EOL_SPAN();
        EOL_SPAN10.text = "#Itsexpression";
        EOL_SPAN10.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN11 = new EOL_SPAN();
        EOL_SPAN11.text = "#Readclauses";
        EOL_SPAN11.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN12 = new EOL_SPAN();
        EOL_SPAN12.text = "#Region";
        EOL_SPAN12.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN13 = new EOL_SPAN();
        EOL_SPAN13.text = "#Section";
        EOL_SPAN13.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN14 = new EOL_SPAN();
        EOL_SPAN14.text = "#Undef";
        EOL_SPAN14.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN15 = new EOL_SPAN();
        EOL_SPAN15.text = "#Wname";
        EOL_SPAN15.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN16 = new EOL_SPAN();
        EOL_SPAN16.text = "&&";
        EOL_SPAN16.TYPE = "COMMENT1";
        EOL_SPAN16.AT_LINE_START = "FALSE";
        EOL_SPAN EOL_SPAN17 = new EOL_SPAN();
        EOL_SPAN17.text = "*";
        EOL_SPAN17.AT_WHITESPACE_END = "TRUE";
        EOL_SPAN17.TYPE = "COMMENT1";
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
        SEQ14.text = "+";
        SEQ14.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = ":";
        MARK_PREVIOUS1.TYPE = "LABEL";
        MARK_PREVIOUS1.AT_LINE_START = "TRUE";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"is", "mod", "and", "or", "not", "xor", "imp", "?", });
        KEYWORDS1.add("FUNCTION", new String[]{"Function", "Procedure", "EndFunc", "EndProc", });
        KEYWORDS1.add("KEYWORD3", new String[]{"if", "then", "else", "elseif", "select", "case", "for", "to", "step", "next", "each", "in", "do", "while", "until", "loop", "wend", "exit", "end", "endif", "class", "property", "get", "let", "set", "byval", "byref", "const", "dim", "redim", "preserve", "as", "set", "with", "new", "public", "default", "private", "rem", "call", "execute", "eval", "on", "error", "goto", "resume", "option", "explicit", "erase", "randomize", "false", "true", "empty", "nothing", "null", "Activate", "ActivateCell", "AddColumn", "AddItem", "AddListItem", "AddObject", "AfterCloseTables", "AfterDock", "AfterRowColChange", "BeforeDock", "BeforeOpenTables", "BeforeRowColChange", "Box", "Circle", "Clear", "Click", "CloneObject", "CloseEditor", "CloseTables", "Cls", "DblClick", "Deactivate", "Delete", "DeleteColumn", "Deleted", "Destroy", "Dock", "DoScroll", "DoVerb", "DownClick", "Drag", "DragDrop", "DragOver", "Draw", "DropDown", "Error", "ErrorMessage", "FormatChange", "GotFocus", "Hide", "IndexToItemId", "Init", "InteractiveChange", "ItemIdToIndex", "KeyPress", "Line", "Load", "LostFocus", "Message", "MouseDown", "MouseMove", "MouseUp", "Move", "Moved", "OpenEditor", "OpenTables", "Paint", "Point", "Print", "ProgrammaticChange", "PSet", "QueryUnload", "RangeHigh", "RangeLow", "ReadActivate", "ReadDeactivate", "ReadExpression", "ReadMethod", "ReadShow", "ReadValid", "ReadWhen", "Refresh", "Release", "RemoveItem", "RemoveListItem", "RemoveObject", "Requery", "Reset", "Resize", "RightClick", "SaveAs", "SaveAsClass", "Scrolled", "SetAll", "SetFocus", "Show", "TextHeight", "TextWidth", "Timer", "UIEnable", "UnDock", "Unload", "UpClick", "Valid", "When", "WriteExpression", "WriteMethod", "ZOrder", "DataToClip", "DoCmd", "MiddleClick", "MouseWheel", "RequestData", "SetVar", "ShowWhatsThis", "WhatsThisMode", "AddProperty", "NewObject", "CommandTargetExec", "CommandTargetQueryStas", "ContainerRelease", "EnterFocus", "ExitFocus", "HideDoc", "Run", "ShowDoc", "ClearData", "GetData", "GetFormat", "SetData", "SetFormat", "OLECompleteDrag", "OLEGiveFeedback", "OLESetData", "OLEStartDrag", "OLEDrag", "OLEDragDrop", "OLEDragOver", "SetMain", "AfterBuild", "BeforeBuild", "QueryAddFile", "QueryModifyFile", "QueryRemoveFile", "QueryRunFile", "Add", "AddToSCC", "CheckIn", "CheckOut", "GetLatestVersion", "RemoveFromSCC", "UndoCheckOut", "Modify", "Accelerate", "ActiveColumn", "ActiveControl", "ActiveForm", "ActiveObjectId", "ActivePage", "ActiveRow", "Alias", "Alignment", "AllowResize", "AllowTabs", "AlwaysOnTop", "ATGetColors", "ATListColors", "AutoActivate", "AutoCenter", "AutoCloseTables", "AutoOpenTables", "AutoRelease", "AutoSize", "AvailNum", "BackColor", "BackStyle", "BaseClass", "BorderColor", "BorderStyle", "BorderWidth", "Bound", "BoundColumn", "BrowseAlignment", "BrowseCellMarg", "BrowseDestWidth", "BufferMode", "BufferModeOverride", "ButtonCount", "ButtonIndex", "Buttons", "CanAccelerate", "Cancel", "CanGetFocus", "CanLoseFocus", "Caption", "ChildAlias", "ChildOrder", "Class", "ClassLibrary", "ClipControls", "ClipRect", "Closable", "ColorScheme", "ColorSource", "ColumnCount", "ColumnHeaders", "ColumnLines", "ColumnOrder", "Columns", "ColumnWidths", "Comment", "ControlBox", "ControlCount", "ControlIndex", "Controls", "ControlSource", "CurrentControl", "CurrentX", "CurrentY", "CursorSource", "Curvature", "Database", "DataSession", "DataSessionId", "DataSourceObj", "DataType", "Default", "DefButton", "DefButtonOrig", "DefHeight", "DefineWindows", "DefLeft", "DefTop", "DefWidth", "DeleteMark", "Desktop", "Dirty", "DisabledBackColor", "DisabledByEOF", "DisabledForeColor", "DisabledItemBackColor", "DisabledItemForeColor", "DisabledPicture", "DisplayValue", "DispPageHeight", "DispPageWidth", "Docked", "DockPosition", "DoCreate", "DocumentFile", "DownPicture", "DragIcon", "DragMode", "DragState", "DrawMode", "DrawStyle", "DrawWidth", "DynamicAlignment", "DynamicBackColor", "DynamicCurrentControl", "DynamicFontBold", "DynamicFontItalic", "DynamicFontName", "DynamicFontOutline", "DynamicFontShadow", "DynamicFontSize", "DynamicFontStrikethru", "DynamicFontUnderline", "DynamicForeColor", "EditFlags", "Enabled", "EnabledByReadLock", "EnvLevel", "ErasePage", "FillColor", "FillStyle", "Filter", "FirstElement", "FontBold", "FontItalic", "FontName", "FontOutline", "FontShadow", "FontSize", "FontStrikethru", "FontUnderline", "ForceFocus", "ForeColor", "Format", "FormCount", "FormIndex", "FormPageCount", "FormPageIndex", "Forms", "FoxFont", "GoFirst", "GoLast", "GridLineColor", "GridLines", "GridLineWidth", "HalfHeightCaption", "HasClip", "HeaderGap", "HeaderHeight", "Height", "HelpContextID", "HideSelection", "Highlight", "HostName", "HotKey", "HPROJ", "HWnd", "Icon", "IgnoreInsert", "Increment", "IncrementalSearch", "InitialSelectedAlias", "InputMask", "InResize", "Interval", "ItemBackColor", "ItemData", "ItemForeColor", "ItemIDData", "JustReadLocked", "KeyboardHighValue", "KeyboardLowValue", "KeyPreview", "Left", "LeftColumn", "LineSlant", "LinkMaster", "List", "ListCount", "ListIndex", "ListItem", "ListItemId", "LockDataSource", "LockScreen", "Margin", "MaxButton", "MaxHeight", "MaxLeft", "MaxLength", "MaxTop", "MaxWidth", "MDIForm", "MemoWindow", "MinButton", "MinHeight", "MinWidth", "MousePointer", "Movable", "MoverBars", "MultiSelect", "Name", "NapTime", "NewIndex", "NewItemId", "NoDataOnLoad", "NoDefine", "NotifyContainer", "NumberOfElements", "OleClass", "OleClassId", "OleControlContainer", "OleIDispatchIncoming", "OleIDispatchOutgoing", "OleIDispInValue", "OleIDispOutValue", "OLETypeAllowed", "OneToMany", "OnResize", "OpenWindow", "PageCount", "PageHeight", "PageOrder", "Pages", "PageWidth", "Panel", "PanelLink", "Parent", "ParentAlias", "ParentClass", "Partition", "PasswordChar", "Picture", "ReadColors", "ReadCycle", "ReadFiller", "ReadLock", "ReadMouse", "ReadOnly", "ReadSave", "ReadSize", "ReadTimeout", "RecordMark", "RecordSource", "RecordSourceType", "Rect", "RelationalExpr", "RelativeColumn", "RelativeRow", "ReleaseErase", "ReleaseType", "ReleaseWindows", "Resizable", "RowHeight", "RowSource", "RowSourceType", "ScaleMode", "ScrollBars", "Selected", "SelectedBackColor", "SelectedForeColor", "SelectedID", "SelectedItemBackColor", "SelectedItemForeColor", "SelectOnEntry", "SelfEdit", "SelLength", "SelStart", "SelText", "ShowTips", "Sizable", "Skip", "SkipForm", "Sorted", "SourceType", "Sparse", "SpecialEffect", "SpinnerHighValue", "SpinnerLowValue", "StatusBarText", "Stretch", "Style", "SystemRefCount", "Tabhit", "TabIndex", "Tabs", "TabStop", "TabStretch", "Tag", "TerminateRead", "ToolTipText", "Top", "TopIndex", "TopItemId", "UnlockDataSource", "Value", "ValueDirty", "View", "Visible", "WasActive", "WasOpen", "Width", "WindowList", "WindowNTIList", "WindowState", "WindowType", "WordWrap", "ZOrderSet", "AllowAddNew", "AllowHeaderSizing", "AllowRowSizing", "Application", "AutoVerbMenu", "AutoYield", "BoundTo", "DateFormat", "DateMark", "DefaultFilePath", "FullName", "Hours", "IMEMode", "IntegralHeight", "ItemTips", "MouseIcon", "NullDisplay", "OLERequestPendingTimou", "OLEServerBusyRaiseErro", "OLEServerBusyTimout", "OpenViews", "RightToLeft", "SDIForm", "ShowWindow", "SplitBar", "StrictDateEntry", "TabStyle", "WhatsThisButton", "WhatsThisHelp", "WhatsThisHelpID", "DisplayCount", "ContinuousScroll", "HscrollSmallChange", "TitleBar", "VscrollSmallChange", "ViewPortTop", "ViewPortLeft", "ViewPortHeight", "ViewPortWidth", "SetViewPort", "Scrolled", "StartMode", "ServerName", "OLEDragMode", "OLEDragPicture", "OLEDropEffects", "OLEDropHasData", "OLEDropMode", "ActiveProject", "Projects", "AutoIncrement", "BuildDateTime", "Debug", "Encrypted", "Files", "HomeDir", "MainClass", "MainFile", "ProjectHookClass", "ProjectHookLibrary", "SCCProvider", "ServerHelpFile", "ServerProject", "TypeLibCLSID", "TypeLibDesc", "TypeLibName", "VersionComments", "VersionCompany", "VersionCopyright", "VersionDescription", "VersionNumber", "VersionProduct", "VersionTrademarks", "Item", "CodePage", "Description", "FileClass", "FileClassLibrary", "LastModified", "SCCStatus", "CLSID", "Instancing", "ProgID", "ServerClass", "ServerClassLibrary", "ThreadID", "ProcessID", "AddLineFeeds", "MULTILOCKS", "FULLPATH", "UNIQUE", "CLASSLIB", "LIBRARY", "structure", "last", "production", "path", "date", "datetime", "rest", "fields", "array", "free", "structure", "ASCENDING", "window", "nowait", "between", "dbf", "noconsole", "dif", "xls", "csv", "delimited", "right", "decimal", "additive", "between", "noupdate", "Abs", "Accept", "Access", "Aclass", "Acopy", "Acos", "Adatabases", "Adbobjects", "Add", "Addrelationtoenv", "Addtabletoenv", "Adel", "Adir", "Aelement", "Aerror", "Afields", "Afont", "Again", "Ains", "Ainstance", "Alen", "All", "Alltrim", "Alter", "Amembers", "Ansitooem", "Append", "Aprinters", "Ascan", "Aselobj", "Asin", "Asort", "Assist", "Asubscript", "Asynchronous", "Atan", "Atc", "Atcline", "Atline", "Atn2", "Aused", "Autoform", "Autoreport", "Average", "Bar", "BatchMode", "BatchUpdateCount", "Begin", "Bell", "BellSound", "Bitand", "Bitclear", "Bitlshift", "Bitnot", "Bitor", "Bitrshift", "Bitset", "Bittest", "Bitxor", "Bof", "Bottom", "Browse", "BrowseRefresh", "Buffering", "Build", "BuilderLock", "By", "Calculate", "Call", "Capslock", "Case", "Cd", "Cdow", "Ceiling", "Central", "Century", "Change", "Char", "Chdir", "Checkbox", "Chr", "Chrsaw", "Chrtran", "Close", "Cmonth", "Cntbar", "Cntpad", "Col", "Column", "ComboBox", "CommandButton", "CommandGroup", "Compile", "Completed", "Compobj", "Compute", "Concat", "ConnectBusy", "ConnectHandle", "ConnectName", "ConnectString", "ConnectTimeOut", "Container", "Continue", "Control", "Copy", "Cos", "Cot", "Count", "Cpconvert", "Cpcurrent", "CPDialog", "Cpdbf", "Cpnotrans", "Create", "Createobject", "CrsBuffering", "CrsFetchMemo", "CrsFetchSize", "CrsMaxRows", "CrsMethodUsed", "CrsNumBatch", "CrsShareConnection", "CrsUseMemoSize", "CrsWhereClause", "Ctod", "Ctot", "Curdate", "Curdir", "CurrLeft", "CurrSymbol", "Cursor", "Curtime", "Curval", "Custom", "DataEnvironment", "Databases", "Datetime", "Day", "Dayname", "Dayofmonth", "Dayofweek", "Dayofyear", "Dbalias", "Dbused", "DB_BufLockRow", "DB_BufLockTable", "DB_BufOff", "DB_BufOptRow", "DB_BufOptTable", "DB_Complette", "DB_DeleteInsert", "DB_KeyAndModified", "DB_KeyAndTimestamp", "DB_KeyAndUpdatable", "DB_LocalSQL", "DB_NoPrompt", "DB_Prompt", "DB_RemoteSQL", "DB_TransAuto", "DB_TransManual", "DB_TransNone", "DB_Update", "Ddeaborttrans", "Ddeadvise", "Ddeenabled", "Ddeexecute", "Ddeinitiate", "Ddelasterror", "Ddepoke", "Dderequest", "Ddesetoption", "Ddesetservice", "Ddesettopic", "Ddeterminate", "Declare", "DefaultValue", "Define", "Degrees", "DeleteTrigger", "Desc", "Description", "Difference", "Dimension", "Dir", "Directory", "Diskspace", "Display", "DispLogin", "DispWarnings", "Distinct", "Dmy", "Do", "Doc", "Dow", "Drop", "Dtoc", "Dtor", "Dtos", "Dtot", "Edit", "EditBox", "Eject", "Elif", "Else", "Empty", "End", "Endcase", "Enddefine", "Enddo", "Endfor", "Endif", "Endprintjob", "Endscan", "Endtext", "Endwith", "Eof", "Erase", "Evaluate", "Exact", "Exclusive", "Exit", "Exp", "Export", "External", "Fchsize", "Fclose", "Fcount", "Fcreate", "Feof", "Ferror", "FetchMemo", "FetchSize", "Fflush", "Fgets", "File", "Filer", "Find", "Fklabel", "Fkmax", "Fldlist", "Flock", "Floor", "Flush", "FontClass", "Fontmetric", "Fopen", "For", "Form", "FormsClass", "Formset", "FormSetClass", "FormSetLib", "FormsLib", "Found", "Foxcode", "Foxdoc", "Foxgen", "Foxgraph", "FoxPro", "Foxview", "Fputs", "Fread", "From", "Fseek", "Fsize", "Fv", "Fwrite", "Gather", "General", "Getbar", "Getcolor", "Getcp", "Getdir", "Getenv", "Getexpr", "Getfile", "Getfldstate", "Getfont", "Getnextmodified", "Getobject", "Getpad", "Getpict", "Getprinter", "Go", "Gomonth", "Goto", "Graph", "Grid", "GridHorz", "GridShow", "GridShowPos", "GridSnap", "GridVert", "Header", "Help", "HelpOn", "HelpTo", "Hour", "IdleTimeOut", "Idxcollate", "If", "Ifdef", "Ifndef", "Iif", "Image", "Import", "Include", "Indbc", "Index", "Inkey", "Inlist", "Input", "Insert", "InsertTrigger", "Insmode", "Into", "Isalpha", "Iscolor", "Isdigit", "Isexclusive", "Islower", "Isnull", "Isreadonly", "Isupper", "Join", "Keyboard", "KeyField", "KeyFieldList", "Keymatch", "Label", "Lastkey", "LastProject", "Lcase", "Len", "Length", "Lineno", "ListBox", "Local", "Locate", "Locfile", "Log", "Log10", "Logout", "Lookup", "Loop", "Lower", "Lparameters", "Ltrim", "Lupdate", "Mail", "MaxRecords", "Mcol", "Md", "Mdown", "Mdx", "Mdy", "Memlines", "Memo", "Menu", "Messagebox", "Minute", "Mkdir", "Mline", "Modify", "Month", "Monthname", "Mouse", "Mrkbar", "Mrkpad", "Mrow", "Mton", "Mwindow", "Native", "Ndx", "Network", "Next", "Nodefault", "Normalize", "Note", "Now", "Ntom", "NullString", "Numlock", "Nvl", "Objnum", "Objref", "Objtoclient", "Objvar", "Occurs", "ODBChdbc", "ODBChstmt", "Oemtoansi", "Off", "Oldval", "OleBaseControl", "OleBoundControl", "OleClassIDispOut", "OleControl", "On", "Open", "OptionButton", "OptionGroup", "Oracle", "Order", "Os", "Otherwise", "Pack", "PacketSize", "Padc", "Padl", "Padr", "Page", "PageFrame", "Parameters", "Payment", "Pcol", "Percent", "Pi", "Pivot", "Play", "Pop", "Power", "PrimaryKey", "Printjob", "Printstatus", "Private", "Prmbar", "Prmpad", "Program", "ProjectClick", "Proper", "Protected", "Prow", "Prtinfo", "Public", "Push", "Putfile", "Pv", "Qpr", "Quater", "QueryTimeOut", "Quit", "Radians", "Rand", "Rat", "Ratline", "Rd", "Rdlevel", "Read", "Readkey", "Recall", "Reccount", "RecentlyUsedFiles", "Recno", "Recsize", "RectClass", "Regional", "Reindex", "RelatedChild", "RelatedTable", "RelatedTag", "Relation", "Remove", "Rename", "Repeat", "Replace", "Replicate", "Report", "Reprocess", "ResHeight", "ResourceOn", "ResourceTo", "Restore", "Resume", "ResWidth", "Retry", "Return", "Rgbscheme", "Rlock", "Rmdir", "Rollback", "Round", "Rtod", "Rtrim", "RuleExpression", "RuleText", "Run", "Runscript", "Rview", "Save", "Safety", "ScaleUnits", "Scan", "Scatter", "Scols", "Scroll", "Sec", "Second", "Seek", "Select", "SendUpdates", "Separator", "Set", "SetDefault", "Setfldstate", "Setup", "Shape", "Shared", "ShareConnection", "ShowOLEControls", "ShowOLEInsertable", "ShowVCXs", "Sign", "Sin", "Size", "Skpbar", "Skppad", "Sort", "Soundex", "SourceName", "Spinner", "SQLAsynchronous", "SQLBatchMode", "Sqlcommit", "SQLConnectTimeOut", "SQLDispLogin", "SQLDispWarnings", "SQLIdleTimeOut", "Sqll", "SQLQueryTimeOut", "Sqlrollback", "Sqlstringconnect", "SQLTransactions", "SQLWaitTime", "Sqrt", "Srows", "StatusBar", "Status", "Store", "Str", "Strtran", "Stuff", "Substr", "Substring", "Sum", "Suspend", "Sys", "Sysmetric", "Table", "TableRefresh", "Tablerevert", "Tableupdate", "TabOrdering", "Talk", "Tan", "Target", "Text", "TextBox", "Timestamp", "Timestampdiff", "To", "Toolbar", "Total", "Transaction", "Transform", "Trim", "Truncate", "Ttoc", "Ttod", "Txnlevel", "Txtwidth", "Type", "Ucase", "Undefine", "Unlock", "Unpack", "Updatable", "UpdatableFieldList", "Update", "Updated", "UpdateName", "UpdateNameList", "UpdateTrigger", "UpdateType", "Upper", "Upsizing", "Use", "Used", "UseMemoSize", "Val", "Validate", "Values", "Varread", "Version", "Wait", "WaitTime", "Wborder", "Wchild", "Wcols", "Week", "Wexist", "Wfont", "Where", "WhereType", "While", "Windcmd", "Windhelp", "Windmemo", "Windmenu", "Windmodify", "Windquery", "Windscreen", "Windsnip", "Windstproc", "With", "WizardPrompt", "Wlast", "Wlcol", "Wlrow", "Wmaximum", "Wminimum", "Wontop", "Woutput", "Wparent", "Wread", "Wrows", "Wtitle", "Wvisible", "Year", "Zap", "[", "]", "^", "_Alignment", "_Asciicols", "_Asciirows", "_Assist", "_Beautify", "_Box", "_Browser", "_Builder", "_Calcmem", "_Calcvalue", "_Cliptext", "_Converter", "_Curobj", "_Dblclick", "_Diarydate", "_Dos", "_Foxdoc", "_Foxgraph", "_Gengraph", "_Genmenu", "_Genpd", "_Genscrn", "_Genxtab", "_Indent", "_Lmargin", "_Mac", "_Mbrowse", "_Mbr_appnd", "_Mbr_cpart", "_Mbr_delet", "_Mbr_font", "_Mbr_goto", "_Mbr_grid", "_Mbr_link", "_Mbr_mode", "_Mbr_mvfld", "_Mbr_mvprt", "_Mbr_seek", "_Mbr_sp100", "_Mbr_sp200", "_Mbr_szfld", "_Mdata", "_Mda_appnd", "_Mda_avg", "_Mda_brow", "_Mda_calc", "_Mda_copy", "_Mda_count", "_Mda_label", "_Mda_pack", "_Mda_reprt", "_Mda_rindx", "_Mda_setup", "_Mda_sort", "_Mda_sp100", "_Mda_sp200", "_Mda_sp300", "_Mda_sum", "_Mda_total", "_Mdiary", "_Medit", "_Med_clear", "_Med_copy", "_Med_cut", "_Med_cvtst", "_Med_find", "_Med_finda", "_Med_goto", "_Med_insob", "_Med_link", "_Med_obj", "_Med_paste", "_Med_pref", "_Med_pstlk", "_Med_redo", "_Med_repl", "_Med_repla", "_Med_slcta", "_Med_sp100", "_Med_sp200", "_Med_sp300", "_Med_sp400", "_Med_sp500", "_Med_undo", "_Mfile", "_Mfiler", "_Mfirst", "_Mfi_clall", "_Mfi_close", "_Mfi_export", "_Mfi_import", "_Mfi_new", "_Mfi_open", "_Mfi_pgset", "_Mfi_prevu", "_Mfi_print", "_Mfi_quit", "_Mfi_revrt", "_Mfi_savas", "_Mfi_save", "_Mfi_send", "_Mfi_setup", "_Mfi_sp100", "_Mfi_sp200", "_Mfi_sp300", "_Mfi_sp400", "_Mlabel", "_Mlast", "_Mline", "_Mmacro", "_Mmbldr", "_Mprog", "_Mproj", "_Mpr_beaut", "_Mpr_cancl", "_Mpr_compl", "_Mpr_do", "_Mpr_docum", "_Mpr_formwz", "_Mpr_gener", "_Mpr_graph", "_Mpr_resum", "_Mpr_sp100", "_Mpr_sp200", "_Mpr_sp300", "_Mpr_suspend", "_Mrc_appnd", "_Mrc_chnge", "_Mrc_cont", "_Mrc_delet", "_Mrc_goto", "_Mrc_locat", "_Mrc_recal", "_Mrc_repl", "_Mrc_seek", "_Mrc_sp100", "_Mrc_sp200", "_Mrecord", "_Mreport", "_Mrqbe", "_Mscreen", "_Msm_data", "_Msm_edit", "_Msm_file", "_Msm_format", "_Msm_prog", "_Msm_recrd", "_Msm_systm", "_Msm_text", "_Msm_tools", "_Msm_view", "_Msm_windo", "_Mst_about", "_Mst_ascii", "_Mst_calcu", "_Mst_captr", "_Mst_dbase", "_Mst_diary", "_Mst_filer", "_Mst_help", "_Mst_hphow", "_Mst_hpsch", "_Mst_macro", "_Mst_office", "_Mst_puzzl", "_Mst_sp100", "_Mst_sp200", "_Mst_sp300", "_Mst_specl", "_Msysmenu", "_Msystem", "_Mtable", "_Mtb_appnd", "_Mtb_cpart", "_Mtb_delet", "_Mtb_delrc", "_Mtb_goto", "_Mtb_link", "_Mtb_mvfld", "_Mtb_mvprt", "_Mtb_props", "_Mtb_recal", "_Mtb_sp100", "_Mtb_sp200", "_Mtb_sp300", "_Mtb_sp400", "_Mtb_szfld", "_Mwindow", "_Mwizards", "_Mwi_arran", "_Mwi_clear", "_Mwi_cmd", "_Mwi_color", "_Mwi_debug", "_Mwi_hide", "_Mwi_hidea", "_Mwi_min", "_Mwi_move", "_Mwi_rotat", "_Mwi_showa", "_Mwi_size", "_Mwi_sp100", "_Mwi_sp200", "_Mwi_toolb", "_Mwi_trace", "_Mwi_view", "_Mwi_zoom", "_Mwz_all", "_Mwz_form", "_Mwz_foxdoc", "_Mwz_import", "_Mwz_label", "_Mwz_mail", "_Mwz_pivot", "_Mwz_query", "_Mwz_reprt", "_Mwz_setup", "_Mwz_table", "_Mwz_upsizing", "_Netware", "_Oracle", "_Padvance", "_Pageno", "_Pbpage", "_Pcolno", "_Pcopies", "_Pdparms", "_Pdriver", "_Pdsetup", "_Pecode", "_Peject", "_Pepage", "_Pform", "_Plength", "_Plineno", "_Ploffset", "_Ppitch", "_Pquality", "_Pretext", "_Pscode", "_Pspacing", "_Pwait", "_Rmargin", "_Screen", "_Shell", "_Spellchk", "_Sqlserver", "_Startup", "_Tabs", "_Tally", "_Text", "_Throttle", "_Transport", "_Triggerlevel", "_Unix", "_Windows", "_Wizard", "_Wrap", "French", "German", "Italian", "Japan", "Usa", "Lparameter", "This", "Thisform", "Thisformset", "F", "T", "N", "Y", "OlePublic", "Hidden", "Each", "DoEvents", "Dll", "Outer", "At_c", "Atcc", "Ratc", "Leftc", "Rightc", "Substrc", "Stuffc", "Lenc", "Chrtranc", "IsLeadByte", "IMEStatus", "Strconv", "BinToC", "CToBin", "IsFLocked", "IsRLocked", "LoadPicture", "SavePicture", "Assert", "DoDefault", "_WebMenu", "_scctext", "_WebVFPHomePage", "_WebVfpOnlineSupport", "_WebDevOnly", "_WebMsftHomePage", "_Coverage", "_vfp", "Bintoc", "Resources", "Ctobin", "Createoffline", "Debugout", "Doevents", "Dropoffline", "Each", "Isflocked", "Isrlocked", "Loadpicture", "Revertoffline", "Savepicture", "Asserts", "Coverage", "Eventtracking", "DBGetProp", "DBSetProp", "CursorGetProp", "CursorSetProp", "Addbs", "Agetclass", "Agetfileversion", "Alines", "Amouseobj", "Anetresources", "Avcxclasses", "Comclassinfo", "Createobjectex", "Defaultext", "Drivetype", "Filetostr", "Forceext", "Forcepath", "Gethost", "Indexseek", "Ishosted", "Justdrive", "Justext", "Justfname", "Justpath", "Juststem", "Newobject", "Olereturnerror", "Strtofile", "Vartype", "_Coverage", "_Gallery", "_Genhtml", "_Getexpr", "_Include", "_Runactivedoc", "ProjectHook", "ActiveDoc", "HyperLink", "Session", "Mtdll", "ADOCKTIP", "ADirtip", "ADockState", "AEvents", "AFONTTIP", "ALanguage", "AProcInfo", "AStackInfo", "ATagInfo", "Adlls", "Alentip", "Amemberstip", "Amemberstip2", "Ascantip", "Aselobjtip", "Asessions", "Asorttip", "Asorttip2", "BINDEVENTTIP", "BindEvent", "COMARRAYTIP", "COMPROPTIP", "Candidate", "Cdx", "ComArray", "ComReturnError", "Comprop", "CreateBinary", "CursorToXML", "DIRTIP", "Descending", "DisplayPath", "EditSource", "EventHandler", "Evl", "ExecScript", "FCREATETIP", "FIELDTIP", "FILETIP", "FOPENTIP", "FSEEKTIP", "Fdate", "Ftime", "GetCursorAdapter", "GetInterface", "GetPem", "GetWordCount", "GetWordNum", "InputBox", "IsBlank", "IsMouse", "Like", "Likec", "Memory", "Msgboxtip", "Pcount", "PemStatus", "Popup", "Quarter", "RaiseEvent", "RemoveProperty", "SQLCancel", "SQLColumns", "SQLDisconnect", "SQLExec", "SQLGetProp", "SQLMoreResults", "SQLPrepare", "SQLSetProp", "SQLTables", "STRTOFILETIP", "Seconds", "StrExTip", "StrExtract", "Strtrantip", "Tagcount", "Tagno", "Textmerge", "Try", "UnBindEvents", "WDockable", "XMLTIP", "XMLTIP2", "XMLTIP3", "XMLTIP4", "XMLTIP5", "XMLTIP6", "XMLToCursor", "XMLUpdategram", "Blank", "Catch", "Dotip", "EndTry", "Finally", "Implements", "Opendatatip", "Repltip", "Throw", "Usetip", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, EOL_SPAN3, EOL_SPAN4, EOL_SPAN5, EOL_SPAN6, EOL_SPAN7, EOL_SPAN8, EOL_SPAN9, EOL_SPAN10, EOL_SPAN11, EOL_SPAN12, EOL_SPAN13, EOL_SPAN14, EOL_SPAN15, EOL_SPAN16, EOL_SPAN17, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

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
