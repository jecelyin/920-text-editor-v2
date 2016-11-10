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
public class VisualbasicLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "'";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = ",+-=<>/?^&*";
        PROPERTY2.NAME = "wordBreakChars";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "\\s*(do until|else|elseif|for|function|if|select case|sub|while)\\s*(then)?.*";
        PROPERTY3.NAME = "indentNextLine";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "\\s*(end (if|select)|loop|wend)\\s*";
        PROPERTY4.NAME = "unindentNextLine";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "true";
        PROPERTY5.NAME = "contextInsensitive";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, };

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
        EOL_SPAN1.TYPE = "KEYWORD4";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "#else";
        EOL_SPAN2.TYPE = "KEYWORD4";
        EOL_SPAN EOL_SPAN3 = new EOL_SPAN();
        EOL_SPAN3.text = "#end";
        EOL_SPAN3.TYPE = "KEYWORD4";
        EOL_SPAN EOL_SPAN4 = new EOL_SPAN();
        EOL_SPAN4.text = "'";
        EOL_SPAN4.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN5 = new EOL_SPAN();
        EOL_SPAN5.text = "rem";
        EOL_SPAN5.TYPE = "COMMENT1";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "#\\d{1,4}/\\d{1,4}/\\d{1,4}( \\d{1,2}\\:\\d{1,2}(:\\d{1,2}| ?(am|pm))?)?#";
        SEQ_REGEXP1.HASH_CHARS = "#";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "KEYWORD3";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "-?(\\d+\\.\\d+([!@]|E[+-]\\d+)?|\\d+[&!@#]?|&H[0-9A-F]+&?|&O[0-7]+&?)";
        SEQ_REGEXP2.HASH_CHARS = "0123456789-&";
        SEQ_REGEXP2.AT_WORD_START = "TRUE";
        SEQ_REGEXP2.TYPE = "DIGIT";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "\\w+!\\w+\\b";
        SEQ_REGEXP3.HASH_CHARS = "abcdefghijklmnopqrstuvwxyz";
        SEQ_REGEXP3.AT_WORD_START = "TRUE";
        SEQ_REGEXP3.TYPE = "LITERAL4";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = ":";
        MARK_PREVIOUS1.TYPE = "LABEL";
        MARK_PREVIOUS1.AT_LINE_START = "TRUE";
        MARK_PREVIOUS1.MATCH_TYPE = "NULL";
        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = "(";
        MARK_PREVIOUS2.TYPE = "FUNCTION";
        MARK_PREVIOUS2.MATCH_TYPE = "NULL";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"*", "+", "-", "/", "=", "\\", "^", "&", ">", ">=", "<>", "<", "<=", "And", "Eqv", "Like", "Mod", "Not", "Or", "Xor", });
        KEYWORDS1.add("KEYWORD1", new String[]{"Abs", "Array", "Asc", "AscB", "AscW", "Atn", "Avg", "CBool", "CByte", "CCur", "CDate", "CDbl", "Cdec", "Choose", "Chr", "ChrB", "ChrW", "CInt", "CLng", "Command", "Cos", "Count", "CreateObject", "CSng", "CStr", "CurDir", "CVar", "CVDate", "CVErr", "DateAdd", "DateDiff", "DatePart", "DateSerial", "DateValue", "Day", "DDB", "Dir", "DoEvents", "Environ", "EOF", "Exp", "FileAttr", "FileDateTime", "FileLen", "Fix", "Format", "FreeFile", "FV", "GetAllStrings", "GetAttr", "GetAutoServerSettings", "GetObject", "GetSetting", "Hex", "Hour", "IIf", "IMEStatus", "Input", "InputB", "InputBox", "InStr", "InstB", "Int", "IPmt", "IsArray", "IsDate", "IsEmpty", "IsError", "IsMissing", "IsNull", "IsNumeric", "IsObject", "LBound", "LCase", "Left", "LeftB", "Len", "LenB", "LoadPicture", "Loc", "LOF", "Log", "LTrim", "Max", "Mid", "MidB", "Min", "Minute", "MIRR", "Month", "MsgBox", "Now", "NPer", "NPV", "Oct", "Partition", "Pmt", "PPmt", "PV", "QBColor", "Rate", "RGB", "Right", "RightB", "Rnd", "RTrim", "Second", "Seek", "Sgn", "Shell", "Sin", "SLN", "Space", "Spc", "Sqr", "StDev", "StDevP", "Str", "StrComp", "StrConv", "Switch", "Sum", "SYD", "Tab", "Tan", "Time", "Timer", "TimeSerial", "TimeValue", "Trim", "TypeName", "UBound", "UCase", "Val", "Var", "VarP", "VarType", "Weekday", "Year", });
        KEYWORDS1.add("KEYWORD2", new String[]{"Accept", "Activate", "Add", "AddCustom", "AddFile", "AddFromFile", "AddFromTemplate", "AddItem", "AddNew", "AddToAddInToolbar", "AddToolboxProgID", "Append", "AppendChunk", "Arrange", "Assert", "AsyncRead", "BatchUpdate", "BeginTrans", "Bind", "Cancel", "CancelAsyncRead", "CancelBatch", "CancelUpdate", "CanPropertyChange", "CaptureImage", "CellText", "CellValue", "Circle", "Clear", "ClearFields", "ClearSel", "ClearSelCols", "Clone", "Close", "Cls", "ColContaining", "ColumnSize", "CommandTimeout", "CommitTrans", "CompactDatabase", "Compose", "Connect", "ConnectionTimeout", "Copy", "CopyQueryDef", "CreateDatabase", "CreateDragImage", "CreateEmbed", "CreateField", "CreateGroup", "CreateIndex", "CreateLink", "CreatePreparedStatement", "CreatePropery", "CreateQuery", "CreateQueryDef", "CreateRelation", "CreateTableDef", "CreateUser", "CreateWorkspace", "CursorLocation", "Customize", "Delete", "DeleteColumnLabels", "DeleteColumns", "DeleteRowLabels", "DeleteRows", "DoVerb", "Drag", "Draw", "Edit", "EditCopy", "EditPaste", "EndDoc", "EnsureVisible", "EstablishConnection", "Execute", "ExtractIcon", "Fetch", "FetchVerbs", "Files", "FillCache", "Find", "FindFirst", "FindItem", "FindLast", "FindNext", "FindPrevious", "Forward", "GetBookmark", "GetChunk", "GetClipString", "GetData", "GetFirstVisible", "GetFormat", "GetHeader", "GetLineFromChar", "GetNumTicks", "GetRows", "GetSelectedPart", "GetText", "GetVisibleCount", "GoBack", "GoForward", "Hide", "HitTest", "HoldFields", "Idle", "InitializeLabels", "InsertColumnLabels", "InsertColumns", "InsertObjDlg", "InsertRowLabels", "InsertRows", "Item", "KillDoc", "Layout", "Line", "LinkExecute", "LinkPoke", "LinkRequest", "LinkSend", "Listen", "LoadFile", "LoadResData", "LoadResPicture", "LoadResString", "LogEvent", "MakeCompileFile", "MakeReplica", "MoreResults", "Move", "MoveData", "MoveFirst", "MoveLast", "MoveNext", "MovePrevious", "NavigateTo", "NewPage", "NewPassword", "NextRecordset", "OLEDrag", "OnAddinsUpdate", "OnConnection", "OnDisconnection", "OnStartupComplete", "Open", "OpenConnection", "OpenDatabase", "OpenQueryDef", "OpenRecordset", "OpenResultset", "OpenURL", "Overlay", "PaintPicture", "Paste", "PastSpecialDlg", "PeekData", "Play", "Point", "PopulatePartial", "PopupMenu", "Print", "PrintForm", "PropertyChanged", "PSet", "Quit", "Raise", "RandomDataFill", "RandomFillColumns", "RandomFillRows", "rdoCreateEnvironment", "rdoRegisterDataSource", "ReadFromFile", "ReadProperty", "Rebind", "ReFill", "Refresh", "RefreshLink", "RegisterDatabase", "Reload", "Remove", "RemoveAddInFromToolbar", "RemoveItem", "Render", "RepairDatabase", "Reply", "ReplyAll", "Requery", "ResetCustom", "ResetCustomLabel", "ResolveName", "RestoreToolbar", "Resync", "Rollback", "RollbackTrans", "RowBookmark", "RowContaining", "RowTop", "Save", "SaveAs", "SaveFile", "SaveToFile", "SaveToolbar", "SaveToOle1File", "Scale", "ScaleX", "ScaleY", "Scroll", "Select", "SelectAll", "SelectPart", "SelPrint", "Send", "SendData", "Set", "SetAutoServerSettings", "SetData", "SetFocus", "SetOption", "SetSize", "SetText", "SetViewport", "Show", "ShowColor", "ShowFont", "ShowHelp", "ShowOpen", "ShowPrinter", "ShowSave", "ShowWhatsThis", "SignOff", "SignOn", "Size", "Span", "SplitContaining", "StartLabelEdit", "StartLogging", "Stop", "Synchronize", "TextHeight", "TextWidth", "ToDefaults", "TwipsToChartPart", "TypeByChartType", "Update", "UpdateControls", "UpdateRecord", "UpdateRow", "Upto", "WhatsThisMode", "WriteProperty", "ZOrder", });
        KEYWORDS1.add("LITERAL3", new String[]{"adAddNew", "adAffectAll", "adAffectAllChapters", "adAffectCurrent", "adAffectGroup", "adApproxPosition", "adAsyncConnect", "adAsyncExecute", "adAsyncFetch", "adAsyncFetchNonBlocking", "adBSTR", "adBigInt", "adBinary", "adBookmark", "adBookmarkCurrent", "adBookmarkFirst", "adBookmarkLast", "adBoolean", "adChapter", "adChar", "adClipString", "adCmdFile", "adCmdStoredProc", "adCmdTable", "adCmdTableDirect", "adCmdText", "adCmdUnknown", "adCompareEqual", "adCompareGreaterThan", "adCompareLessThan", "adCompareNotComparable", "adCompareNotEqual", "adCriteriaAllCols", "adCriteriaKey", "adCriteriaTimeStamp", "adCriteriaUpdCols", "adCurrency", "adDBDate", "adDBFileTime", "adDBTime", "adDBTimeStamp", "adDate", "adDecimal", "adDelete", "adDouble", "adEditAdd", "adEditDelete", "adEditInProgress", "adEditNone", "adEmpty", "adErrBoundToCommand", "adErrDataConversion", "adErrFeatureNotAvailable", "adErrIllegalOperation", "adErrInTransaction", "adErrInvalidArgument", "adErrInvalidConnection", "adErrInvalidParamInfo", "adErrItemNotFound", "adErrNoCurrentRecord", "adErrNotExecuting", "adErrNotReentrant", "adErrObjectClosed", "adErrObjectInCollection", "adErrObjectNotSet", "adErrObjectOpen", "adErrOperationCancelled", "adErrProviderNotFound", "adErrStillConnecting", "adErrStillExecuting", "adErrUnsafeOperation", "adError", "adExecuteNoRecords", "adFileTime", "adFilterAffectedRecords", "adFilterConflictingRecords", "adFilterFetchedRecords", "adFilterNone", "adFilterPendingRecords", "adFilterPredicate", "adFind", "adFldCacheDeferred", "adFldFixed", "adFldIsNullable", "adFldKeyColumn", "adFldLong", "adFldMayBeNull", "adFldMayDefer", "adFldRowID", "adFldRowVersion", "adFldUnknownUpdatable", "adFldUpdatable", "adGUID", "adGetRowsRest", "adHoldRecords", "adIDispatch", "adIUnknown", "adIndex", "adInteger", "adLockBatchOptimistic", "adLockOptimistic", "adLockPessimistic", "adLockReadOnly", "adLongVarBinary", "adLongVarChar", "adLongVarWChar", "adMarshalAll", "adMarshalModifiedOnly", "adModeRead", "adModeReadWrite", "adModeShareDenyNone", "adModeShareDenyRead", "adModeShareDenyWrite", "adModeShareExclusive", "adModeUnknown", "adModeWrite", "adMovePrevious", "adNotify", "adNumeric", "adOpenDynamic", "adOpenForwardOnly", "adOpenKeyset", "adOpenStatic", "adParamInput", "adParamInputOutput", "adParamLong", "adParamNullable", "adParamOutput", "adParamReturnValue", "adParamSigned", "adParamUnknown", "adPersistADTG", "adPersistXML", "adPosBOF", "adPosEOF", "adPosUnknown", "adPriorityAboveNormal", "adPriorityBelowNormal", "adPriorityHighest", "adPriorityLowest", "adPriorityNormal", "adPromptAlways", "adPromptComplete", "adPromptCompleteRequired", "adPromptNever", "adPropNotSupported", "adPropOptional", "adPropRead", "adPropRequired", "adPropVariant", "adPropWrite", "adRecCanceled", "adRecCantRelease", "adRecConcurrencyViolation", "adRecDBDeleted", "adRecDeleted", "adRecIntegrityViolation", "adRecInvalid", "adRecMaxChangesExceeded", "adRecModified", "adRecMultipleChanges", "adRecNew", "adRecOK", "adRecObjectOpen", "adRecOutOfMemory", "adRecPendingChanges", "adRecPermissionDenied", "adRecSchemaViolation", "adRecUnmodified", "adRecalcAlways", "adRecalcUpFront", "adResync", "adResyncAll", "adResyncAllValues", "adResyncAutoIncrement", "adResyncConflicts", "adResyncInserts", "adResyncNone", "adResyncUnderlyingValues", "adResyncUpdates", "adRsnAddNew", "adRsnClose", "adRsnDelete", "adRsnFirstChange", "adRsnMove", "adRsnMoveFirst", "adRsnMoveLast", "adRsnMoveNext", "adRsnMovePrevious", "adRsnRequery", "adRsnResynch", "adRsnUndoAddNew", "adRsnUndoDelete", "adRsnUndoUpdate", "adRsnUpdate", "adRunAsync", "adSchemaAsserts", "adSchemaCatalogs", "adSchemaCharacterSets", "adSchemaCheckConstraints", "adSchemaCollations", "adSchemaColumnPrivileges", "adSchemaColumns", "adSchemaColumnsDomainUsage", "adSchemaConstraintColumnUsage", "adSchemaConstraintTableUsage", "adSchemaCubes", "adSchemaDBInfoKeywords", "adSchemaDBInfoLiterals", "adSchemaDimensions", "adSchemaForeignKeys", "adSchemaHierarchies", "adSchemaIndexes", "adSchemaKeyColumnUsage", "adSchemaLevels", "adSchemaMeasures", "adSchemaMembers", "adSchemaPrimaryKeys", "adSchemaProcedureColumns", "adSchemaProcedureParameters", "adSchemaProcedures", "adSchemaProperties", "adSchemaProviderSpecific", "adSchemaProviderTypes", "adSchemaReferentialConstraints", "adSchemaSQLLanguages", "adSchemaSchemata", "adSchemaStatistics", "adSchemaTableConstraints", "adSchemaTablePrivileges", "adSchemaTables", "adSchemaTranslations", "adSchemaUsagePrivileges", "adSchemaViewColumnUsage", "adSchemaViewTableUsage", "adSchemaViews", "adSearchBackward", "adSearchForward", "adSeek", "adSeekAfter", "adSeekAfterEQ", "adSeekBefore", "adSeekBeforeEQ", "adSeekFirstEQ", "adSeekLastEQ", "adSingle", "adSmallInt", "adStateClosed", "adStateConnecting", "adStateExecuting", "adStateFetching", "adStateOpen", "adStatusCancel", "adStatusCantDeny", "adStatusErrorsOccurred", "adStatusOK", "adStatusUnwantedEvent", "adStringHTML", "adStringXML", "adTinyInt", "adUnsignedBigInt", "adUnsignedInt", "adUnsignedSmallInt", "adUnsignedTinyInt", "adUpdate", "adUpdateBatch", "adUseClient", "adUseServer", "adUserDefined", "adVarBinary", "adVarChar", "adVarNumeric", "adVarWChar", "adVariant", "adWChar", "adXactAbortRetaining", "adXactBrowse", "adXactChaos", "adXactCommitRetaining", "adXactCursorStability", "adXactIsolated", "adXactReadCommitted", "adXactReadUncommitted", "adXactRepeatableRead", "adXactSerializable", "adXactUnspecified", "dbAppendOnly", "dbConsistent", "dbDenyRead", "dbDenyWrite", "dbExecDirect", "dbForwardOnly", "dbInconsistent", "dbOpenDynamic", "dbOpenDynaset", "dbOpenForwardOnly", "dbOpenSnapshot", "dbOpenTable", "dbOptimistic", "dbOptimisticBatch", "dbOptimisticValue", "dbPessimistic", "dbReadOnly", "dbRunAsync", "dbSeeChanges", "dbSQLPassThrough", "vbAbort", "vbAbortRetryIgnore", "vbApplicationModal", "vbCancel", "vbCritical", "vbDefaultButton1", "vbDefaultButton2", "vbDefaultButton3", "vbDefaultButton4", "vbExclamation", "vbFalse", "vbFirstFourDays", "vbFirstFullWeek", "vbFirstJan1", "vbFriday", "vbGeneralDate", "vbIgnore", "vbInformation", "vbLongDate", "vbLongTime", "vbMonday", "vbNo", "vbOK", "vbOKCancel", "vbOKOnly", "vbObjectError", "vbQuestion", "vbRetry", "vbRetryCancel", "vbSaturday", "vbShortDate", "vbShortTime", "vbSunday", "vbSystemModal", "vbThursday", "vbTrue", "vbTuesday", "vbUseDefault", "vbUseSystem", "vbUseSystemDayOfWeek", "vbWednesday", "vbYes", "vbYesNo", "vbYesNoCancel", "vbarray", "vbblack", "vbblue", "vbboolean", "vbbyte", "vbcr", "vbcrlf", "vbcurrency", "vbcyan", "vbdataobject", "vbdate", "vbdecimal", "vbdouble", "vbempty", "vberror", "vbformfeed", "vbgreen", "vbinteger", "vblf", "vblong", "vbmagenta", "vbnewline", "vbnull", "vbnullchar", "vbnullstring", "vbobject", "vbred", "vbsingle", "vbstring", "vbtab", "vbvariant", "vbverticaltab", "vbwhite", "vbyellow", });
        KEYWORDS1.add("KEYWORD3", new String[]{"AccessKeyPress", "AfterAddFile", "AfterChangeFileName", "AfterCloseFile", "AfterColEdit", "AfterColUpdate", "AfterDelete", "AfterInsert", "AfterLabelEdit", "AfterRemoveFile", "AfterUpdate", "AfterWriteFile", "AmbienChanged", "ApplyChanges", "Associate", "AsyncReadComplete", "AxisActivated", "AxisLabelActivated", "AxisLabelSelected", "AxisLabelUpdated", "AxisSelected", "AxisTitleActivated", "AxisTitleSelected", "AxisTitleUpdated", "AxisUpdated", "BeforeClick", "BeforeColEdit", "BeforeColUpdate", "BeforeConnect", "BeforeDelete", "BeforeInsert", "BeforeLabelEdit", "BeforeLoadFile", "BeforeUpdate", "ButtonClick", "ButtonCompleted", "ButtonGotFocus", "ButtonLostFocus", "Change", "ChartActivated", "ChartSelected", "ChartUpdated", "Click", "ColEdit", "Collapse", "ColResize", "ColumnClick", "Compare", "ConfigChageCancelled", "ConfigChanged", "ConnectionRequest", "DataArrival", "DataChanged", "DataUpdated", "DblClick", "Deactivate", "DeviceArrival", "DeviceOtherEvent", "DeviceQueryRemove", "DeviceQueryRemoveFailed", "DeviceRemoveComplete", "DeviceRemovePending", "DevModeChange", "Disconnect", "DisplayChanged", "Dissociate", "DoGetNewFileName", "Done", "DonePainting", "DownClick", "DragDrop", "DragOver", "DropDown", "EditProperty", "EnterCell", "EnterFocus", "Event", "ExitFocus", "Expand", "FootnoteActivated", "FootnoteSelected", "FootnoteUpdated", "GotFocus", "HeadClick", "InfoMessage", "Initialize", "IniProperties", "ItemActivated", "ItemAdded", "ItemCheck", "ItemClick", "ItemReloaded", "ItemRemoved", "ItemRenamed", "ItemSeletected", "KeyDown", "KeyPress", "KeyUp", "LeaveCell", "LegendActivated", "LegendSelected", "LegendUpdated", "LinkClose", "LinkError", "LinkNotify", "LinkOpen", "Load", "LostFocus", "MouseDown", "MouseMove", "MouseUp", "NodeClick", "ObjectMove", "OLECompleteDrag", "OLEDragDrop", "OLEDragOver", "OLEGiveFeedback", "OLESetData", "OLEStartDrag", "OnAddNew", "OnComm", "Paint", "PanelClick", "PanelDblClick", "PathChange", "PatternChange", "PlotActivated", "PlotSelected", "PlotUpdated", "PointActivated", "PointLabelActivated", "PointLabelSelected", "PointLabelUpdated", "PointSelected", "PointUpdated", "PowerQuerySuspend", "PowerResume", "PowerStatusChanged", "PowerSuspend", "QueryChangeConfig", "QueryComplete", "QueryCompleted", "QueryTimeout", "QueryUnload", "ReadProperties", "Reposition", "RequestChangeFileName", "RequestWriteFile", "Resize", "ResultsChanged", "RowColChange", "RowCurrencyChange", "RowResize", "RowStatusChanged", "SelChange", "SelectionChanged", "SendComplete", "SendProgress", "SeriesActivated", "SeriesSelected", "SeriesUpdated", "SettingChanged", "SplitChange", "StateChanged", "StatusUpdate", "SysColorsChanged", "Terminate", "TimeChanged", "TitleActivated", "TitleSelected", "TitleActivated", "UnboundAddData", "UnboundDeleteRow", "UnboundGetRelativeBookmark", "UnboundReadData", "UnboundWriteData", "Unload", "UpClick", "Updated", "Validate", "ValidationError", "WillAssociate", "WillChangeData", "WillDissociate", "WillExecute", "WillUpdateRows", "WithEvents", "WriteProperties", });
        KEYWORDS1.add("KEYWORD4", new String[]{"AppActivate", "Base", "Beep", "Call", "Case", "ChDir", "ChDrive", "Const", "Declare", "DefBool", "DefByte", "DefCur", "DefDate", "DefDbl", "DefDec", "DefInt", "DefLng", "DefObj", "DefSng", "DefStr", "Deftype", "DefVar", "DeleteSetting", "Dim", "Do", "Each", "Else", "ElseIf", "End", "Enum", "Erase", "Error", "Event", "Exit", "Explicit", "False", "FileCopy", "For", "ForEach", "Friend", "Function", "Get", "GoSub", "GoTo", "If", "Implements", "In", "Kill", "Let", "LineInput", "Lock", "Loop", "LSet", "MkDir", "Name", "New", "Next", "Nothing", "Null", "OnError", "On", "Option", "Private", "Property", "Public", "Put", "RaiseEvent", "Randomize", "ReDim", "Rem", "Reset", "Resume", "Return", "RmDir", "RSet", "SavePicture", "SaveSetting", "SendKeys", "SetAttr", "Static", "Sub", "Then", "To", "True", "Type", "Unlock", "Until", "Wend", "While", "Width", "With", "Write", "ADODB", "Boolean", "Byte", "Connection", "Currency", "Date", "Double", "Integer", "Long", "Recordset", "Single", "String", "Variant", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, EOL_SPAN3, EOL_SPAN4, EOL_SPAN5, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

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
