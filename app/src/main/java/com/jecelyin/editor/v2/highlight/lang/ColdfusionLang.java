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
public class ColdfusionLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "<!--";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "-->";
        PROPERTY2.NAME = "commentEnd";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT4";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<!---";
        END END1 = new END();
        END1.text = "--->";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "COMMENT1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "/*";
        END END2 = new END();
        END2.text = "*/";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "//";
        EOL_SPAN1.TYPE = "COMMENT2";
        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "COMMENT3";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<!--";
        END END3 = new END();
        END3.text = "-->";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "KEYWORD3";
        SPAN4.DELEGATE = "cfscript::MAIN";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "<CFSCRIPT";
        END END4 = new END();
        END4.text = "</CFSCRIPT>";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "KEYWORD3";
        SPAN5.DELEGATE = "CFQUERY";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "<CFQUERY";
        END END5 = new END();
        END5.text = "/CFQUERY>";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN SPAN6 = new SPAN();
        SPAN6.TYPE = "KEYWORD3";
        SPAN6.DELEGATE = "CFTAGS";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "<CF";
        END END6 = new END();
        END6.text = ">";
        SPAN6.END = new END[] { END6, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN7 = new SPAN();
        SPAN7.TYPE = "KEYWORD3";
        SPAN7.DELEGATE = "CFTAGS";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "</CF";
        END END7 = new END();
        END7.text = ">";
        SPAN7.END = new END[] { END7, };

        SPAN7.BEGIN = new BEGIN[] { BEGIN7, };

        SPAN SPAN8 = new SPAN();
        SPAN8.TYPE = "MARKUP";
        SPAN8.DELEGATE = "html::JAVASCRIPT";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "<SCRIPT";
        END END8 = new END();
        END8.text = "</SCRIPT>";
        SPAN8.END = new END[] { END8, };

        SPAN8.BEGIN = new BEGIN[] { BEGIN8, };

        SPAN SPAN9 = new SPAN();
        SPAN9.TYPE = "MARKUP";
        SPAN9.DELEGATE = "html::CSS";
        BEGIN BEGIN9 = new BEGIN();
        BEGIN9.text = "<STYLE";
        END END9 = new END();
        END9.text = "</STYLE>";
        SPAN9.END = new END[] { END9, };

        SPAN9.BEGIN = new BEGIN[] { BEGIN9, };

        SPAN SPAN10 = new SPAN();
        SPAN10.TYPE = "MARKUP";
        SPAN10.DELEGATE = "TAGS";
        BEGIN BEGIN10 = new BEGIN();
        BEGIN10.text = "<";
        END END10 = new END();
        END10.text = ">";
        SPAN10.END = new END[] { END10, };

        SPAN10.BEGIN = new BEGIN[] { BEGIN10, };

        SPAN SPAN11 = new SPAN();
        SPAN11.NO_WORD_BREAK = "TRUE";
        SPAN11.TYPE = "LITERAL2";
        BEGIN BEGIN11 = new BEGIN();
        BEGIN11.text = "&";
        END END11 = new END();
        END11.text = ";";
        SPAN11.END = new END[] { END11, };

        SPAN11.BEGIN = new BEGIN[] { BEGIN11, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, SPAN7, SPAN8, SPAN9, SPAN10, SPAN11, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "TAGS";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DEFAULT = "MARKUP";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "KEYWORD3";
        SPAN3.DELEGATE = "CFTAGS";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<CF";
        END END3 = new END();
        END3.text = ">";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "KEYWORD3";
        SPAN4.DELEGATE = "CFTAGS";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "</CF";
        END END4 = new END();
        END4.text = ">";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CFQUERY";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DEFAULT = "KEYWORD3";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.HASH_CHARS = "<CF";
        SPAN_REGEXP1.TYPE = "KEYWORD3";
        SPAN_REGEXP1.DELEGATE = "CFTAGS";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<CF";
        END END3 = new END();
        END3.text = ">";
        SPAN_REGEXP1.END = new END[] { END3, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.HASH_CHARS = "</CF";
        SPAN_REGEXP2.TYPE = "KEYWORD3";
        SPAN_REGEXP2.DELEGATE = "CFTAGS";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "</CF";
        END END4 = new END();
        END4.text = ">";
        SPAN_REGEXP2.END = new END[] { END4, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "MARKUP";
        SPAN3.DELEGATE = "transact-sql::MAIN";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = ">";
        END END5 = new END();
        END5.text = "<";
        SPAN3.END = new END[] { END5, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN5, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CFTAGS";
        RULES1.DEFAULT = "KEYWORD3";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "##";
        SEQ2.TYPE = "KEYWORD3";
        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL2";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "#";
        END END3 = new END();
        END3.text = "#";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"IS", "EQ", "NEQ", "GT", "GTE", "LT", "LTE", "LESS", "GREATER", "THAN", "AND", "OR", "NOT", "XOR", });
        KEYWORDS1.add("KEYWORD2", new String[]{"ACos", "ASin", "Abort", "Abs", "AddSOAPRequestHeader", "AddSOAPResponseHeader", "AjaxLink", "AjaxOnLoad", "ApplicationStop", "ArrayAppend", "ArrayAvg", "ArrayClear", "ArrayContains", "ArrayDelete", "ArrayDeleteAt", "ArrayFind", "ArrayFindNoCase", "ArrayInsertAt", "ArrayIsDefined", "ArrayIsEmpty", "ArrayLen", "ArrayMax", "ArrayMin", "ArrayNew", "ArrayPrepend", "ArrayResize", "ArraySet", "ArraySort", "ArraySum", "ArraySwap", "ArrayToList", "Asc", "Atn", "BinaryDecode", "BinaryEncode", "BitAnd", "BitMaskClear", "BitMaskRead", "BitMaskSet", "BitNot", "BitOr", "BitSHLN", "BitSHRN", "BitXor", "CJustify", "CacheGet", "CacheGetAllIds", "CacheGetMetadata", "CacheGetProperties", "CacheGetSession", "CachePut", "CacheRemove", "CacheSetProperties", "Ceiling", "CharsetDecode", "CharsetEncode", "Chr", "Compare", "CompareNoCase", "Cos", "CreateDate", "CreateDateTime", "CreateODBCDate", "CreateODBCDateTime", "CreateODBCTime", "CreateObject", "CreateTime", "CreateTimeSpan", "CreateUUID", "DE", "DateAdd", "DateCompare", "DateConvert", "DateDiff", "DateFormat", "DatePart", "Day", "DayOfWeek", "DayOfWeekAsString", "DayOfYear", "DaysInMonth", "DaysInYear", "DecimalFormat", "DecrementValue", "Decrypt", "DecryptBinary", "DeleteClientVariable", "DeserializeJSON", "DirectoryCreate", "DirectoryDelete", "DirectoryExists", "DirectoryList", "DirectoryRename", "DollarFormat", "DotNetToCFType", "Duplicate", "Encrypt", "EncryptBinary", "EntityDelete", "EntityLoad", "EntityLoadByExample", "EntityLoadByPK", "EntityMerge", "EntityNew", "EntityReload", "EntitySave", "EntitytoQuery", "Evaluate", "Exp", "ExpandPath", "FileClose", "FileCopy", "FileDelete", "FileExists", "FileIsEOF", "FileMove", "FileOpen", "FileRead", "FileReadBinary", "FileReadLine", "FileSeek", "FileSetAccessMode", "FileSetAttribute", "FileSetLastModified", "FileSkipBytes", "FileUpload", "FileUploadAll", "FileWrite", "Find", "FindNoCase", "FindOneOf", "FirstDayOfMonth", "Fix", "FormatBaseN", "GenerateSecretKey", "GetAuthUser", "GetBaseTagData", "GetBaseTagList", "GetBaseTemplatePath", "GetClientVariablesList", "GetComponentMetaData", "GetContextRoot", "GetCurrentTemplatePath", "GetDirectoryFromPath", "GetEncoding", "GetException", "GetFileFromPath", "GetFileInfo", "GetFunctionCalledName", "GetFunctionList", "GetGatewayHelper", "GetHttpRequestData", "GetHttpTimeString", "GetLocalHostIP", "GetLocale", "GetLocaleDisplayName", "GetMetaData", "GetMetricData", "GetPageContext", "GetPrinterInfo", "GetProfileSections", "GetProfileString", "GetReadableImageFormats", "GetSOAPRequest", "GetSOAPRequestHeader", "GetSOAPResponse", "GetSOAPResponseHeader", "GetTempDirectory", "GetTempFile", "GetTemplatePath", "GetTickCount", "GetTimeZoneInfo", "GetToken", "GetUserRoles", "GetWriteableImageFormats", "HTMLCodeFormat", "HTMLEditFormat", "Hash", "Hour", "IIf", "ImageAddBorder", "ImageBlur", "ImageClearRect", "ImageCopy", "ImageCrop", "ImageDrawArc", "ImageDrawBeveledRect", "ImageDrawCubicCurve", "ImageDrawLine", "ImageDrawLines", "ImageDrawOval", "ImageDrawPoint", "ImageDrawQuadraticCurve", "ImageDrawRect", "ImageDrawRoundRect", "ImageDrawText", "ImageFlip", "ImageGetBlob", "ImageGetBufferedImage", "ImageGetEXIFTag", "ImageGetHeight", "ImageGetIPTCTag", "ImageGetWidth", "ImageGrayscale", "ImageInfo", "ImageNegative", "ImageNew", "ImageOverlay", "ImagePaste", "ImageRead", "ImageReadBase64", "ImageResize", "ImageRotate", "ImageRotateDrawingAxis", "ImageScaleToFit", "ImageSetAntialiasing", "ImageSetBackgroundColor", "ImageSetDrawingColor", "ImageSetDrawingStroke", "ImageSetDrawingTransparency", "ImageSharpen", "ImageShear", "ImageShearDrawingAxis", "ImageTranslate", "ImageTranslateDrawingAxis", "ImageWrite", "ImageWriteBase64", "ImageXORDrawingMode", "IncrementValue", "InputBaseN", "Insert", "Int", "IsArray", "IsBinary", "IsBoolean", "IsCustomFunction", "IsDDX", "IsDate", "IsDebugMode", "IsDefined", "IsImage", "IsImageFile", "IsInstanceOf", "IsJSON", "IsK2ServerABroker", "IsK2ServerDocCountExceeded", "IsK2ServerOnline", "IsLeapYear", "IsLocalHost", "IsNull", "IsNumeric", "IsNumericDate", "IsObject", "IsPDFFile", "IsPDFObject", "IsQuery", "IsSOAPRequest", "IsSimpleValue", "IsStruct", "IsUserInAnyRole", "IsUserInRole", "IsUserLoggedIn", "IsValid", "IsWDDX", "IsXML", "IsXmlAttribute", "IsXmlDoc", "IsXmlElem", "IsXmlNode", "IsXmlRoot", "JSStringFormat", "JavaCast", "LCase", "LJustify", "LSCurrencyFormat", "LSDateFormat", "LSEuroCurrencyFormat", "LSIsCurrency", "LSIsDate", "LSIsNumeric", "LSNumberFormat", "LSParseCurrency", "LSParseDateTime", "LSParseEuroCurrency", "LSParseNumber", "LSTimeFormat", "LTrim", "Left", "Len", "ListAppend", "ListChangeDelims", "ListContains", "ListContainsNoCase", "ListDeleteAt", "ListFind", "ListFindNoCase", "ListFirst", "ListGetAt", "ListInsertAt", "ListLast", "ListLen", "ListPrepend", "ListQualify", "ListRest", "ListSetAt", "ListSort", "ListToArray", "ListValueCount", "ListValueCountNoCase", "Location", "Log", "Log10", "Max", "Mid", "Min", "Minute", "Month", "MonthAsString", "Now", "NumberFormat", "ORMClearSession", "ORMCloseSession", "ORMEvictCollection", "ORMEvictEntity", "ORMEvictQueries", "ORMExecuteQuery", "ORMFlush", "ORMGetSession", "ORMGetSessionFactory", "ORMReload", "ObjectEquals", "ObjectLoad", "ObjectSave", "ParagraphFormat", "ParseDateTime", "Pi", "PrecisionEvaluate", "PreserveSingleQuotes", "Quarter", "QueryAddColumn", "QueryAddRow", "QueryConvertForGrid", "QueryNew", "QuerySetCell", "QuotedValueList", "REFind", "REFindNoCase", "REMatch", "REMatchNoCase", "REReplace", "REReplaceNoCase", "RJustify", "RTrim", "Rand", "RandRange", "Randomize", "ReleaseComObject", "RemoveChars", "RepeatString", "Replace", "ReplaceList", "ReplaceNoCase", "Reverse", "Right", "Round", "Second", "SendGatewayMessage", "SerializeJSON", "SetLocale", "SetProfileString", "SetVariable", "Sgn", "Sin", "Sleep", "SpanExcluding", "SpanIncluding", "SpreadsheetAddColumn", "SpreadsheetAddFreezePane", "SpreadsheetAddImage", "SpreadsheetAddInfo", "SpreadsheetAddRow", "SpreadsheetAddRows", "SpreadsheetAddSplitPane", "SpreadsheetCreateSheet", "SpreadsheetDeleteColumn", "SpreadsheetDeleteColumns", "SpreadsheetDeleteRow", "SpreadsheetDeleteRows", "SpreadsheetFormatCell", "SpreadsheetFormatCellRange", "SpreadsheetFormatColumn", "SpreadsheetFormatColumns", "SpreadsheetFormatRow", "SpreadsheetFormatRows", "SpreadsheetGetCellComment", "SpreadsheetGetCellFormula", "SpreadsheetGetCellValue", "SpreadsheetInfo", "SpreadsheetMergeCells", "SpreadsheetNew", "SpreadsheetRead", "SpreadsheetReadBinary", "SpreadsheetRemoveSheet", "SpreadsheetSetActiveSheet", "SpreadsheetSetActiveSheetNumber", "SpreadsheetSetCellComment", "SpreadsheetSetCellFormula", "SpreadsheetSetCellValue", "SpreadsheetSetColumnWidth", "SpreadsheetSetFooter", "SpreadsheetSetHeader", "SpreadsheetSetRowHeight", "SpreadsheetShiftColumns", "SpreadsheetShiftRows", "SpreadsheetWrite", "Sqr", "StripCR", "StructAppend", "StructClear", "StructCopy", "StructCount", "StructDelete", "StructFind", "StructFindKey", "StructFindValue", "StructGet", "StructInsert", "StructIsEmpty", "StructKeyArray", "StructKeyExists", "StructKeyList", "StructNew", "StructSort", "StructUpdate", "Tan", "Throw", "TimeFormat", "ToBase64", "ToBinary", "ToScript", "ToString", "Trace", "TransactionCommit", "TransactionRollback", "TransactionSetSavePoint", "Trim", "UCase", "URLDecode", "URLEncodedFormat", "URLSessionFormat", "Val", "ValueList", "VerifyClient", "Week", "Wrap", "WriteDump", "WriteLog", "WriteOutput", "XmlChildPos", "XmlElemNew", "XmlFormat", "XmlGetNodeType", "XmlNew", "XmlParse", "XmlSearch", "XmlTransform", "XmlValidate", "Year", "YesNoFormat", });
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
