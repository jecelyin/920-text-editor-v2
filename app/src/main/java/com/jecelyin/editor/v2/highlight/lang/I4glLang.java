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
public class I4glLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "{";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "}";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "--";
        PROPERTY3.NAME = "lineComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "_";
        PROPERTY4.NAME = "noWordSep";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = ",+-=<>/?^&*";
        PROPERTY5.NAME = "wordBreakChars";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL1";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "'";
        END END1 = new END();
        END1.text = "'";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "--";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "#";
        EOL_SPAN2.TYPE = "COMMENT1";
        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "COMMENT1";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "{";
        END END3 = new END();
        END3.text = "}";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = ")";
        SEQ1.TYPE = "NULL";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "]";
        SEQ2.TYPE = "NULL";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "[";
        SEQ3.TYPE = "NULL";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = ".";
        SEQ4.TYPE = "NULL";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = ",";
        SEQ5.TYPE = "NULL";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = ";";
        SEQ6.TYPE = "NULL";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = ":";
        SEQ7.TYPE = "NULL";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "=";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "==";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "!=";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = ">=";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "<=";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "<>";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = ">";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "<";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "+";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "-";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "/";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "*";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "||";
        SEQ20.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = ")";
        SEQ21.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"FALSE", "NULL", "TRUE", });
        KEYWORDS1.add("KEYWORD1", new String[]{"ABORT", "ABS", "ABSOLUTE", "ACCEPT", "ACCESS", "ACOS", "ADA", "ADD", "AFTER", "ALL", "ALLOCATE", "ALTER", "AND", "ANSI", "ANY", "APPEND", "ARG_VAL", "ARRAY", "ARR_COUNT", "ARR_CURR", "AS", "ASC", "ASCENDING", "ASCII", "ASIN", "AT", "ATAN", "ATAN2", "ATTACH", "ATTRIBUTE", "ATTRIBUTES", "AUDIT", "AUTHORIZATION", "AUTO", "AUTONEXT", "AVERAGE", "AVG", "BEFORE", "BEGIN", "BETWEEN", "BLACK", "BLINK", "BLUE", "BOLD", "BORDER", "BOTH", "BOTTOM", "BREAK", "BUFFERED", "BY", "BYTE", "CALL", "CASCADE", "CASE", "CHAR", "CHARACTER", "CHARACTER_LENGTH", "CHAR_LENGTH", "CHECK", "CLASS_ORIGIN", "CLEAR", "CLIPPED", "CLOSE", "CLUSTER", "COBOL", "COLOR", "COLUMN", "COLUMNS", "COMMAND", "COMMENT", "COMMENTS", "COMMIT", "COMMITTED", "COMPOSITES", "COMPRESS", "CONCURRENT", "CONNECT", "CONNECTION", "CONNECTION_ALIAS", "CONSTRAINED", "CONSTRAINT", "CONSTRAINTS", "CONSTRUCT", "CONTINUE", "CONTROL", "COS", "COUNT", "CREATE", "CURRENT", "CURSOR", "CYAN", "DATA", "DATABASE", "DATASKIP", "DATE", "DATETIME", "DAY", "DBA", "DBINFO", "DBSERVERNAME", "DEALLOCATE", "DEBUG", "DEC", "DECIMAL", "DECLARE", "DEFAULT", "DEFAULTS", "DEFER", "DEFERRED", "DEFINE", "DELETE", "DELIMITER", "DELIMITERS", "DESC", "DESCENDING", "DESCRIBE", "DESCRIPTOR", "DETACH", "DIAGNOSTICS", "DIM", "DIRTY", "DISABLED", "DISCONNECT", "DISPLAY", "DISTINCT", "DISTRIBUTIONS", "DO", "DORMANT", "DOUBLE", "DOWN", "DOWNSHIFT", "DROP", "EACH", "ELIF", "ELSE", "ENABLED", "END", "ENTRY", "ERROR", "ERRORLOG", "ERR_GET", "ERR_PRINT", "ERR_QUIT", "ESC", "ESCAPE", "EVERY", "EXCEPTION", "EXCLUSIVE", "EXEC", "EXECUTE", "EXISTS", "EXIT", "EXP", "EXPLAIN", "EXPRESSION", "EXTEND", "EXTENT", "EXTERN", "EXTERNAL", "F1", "F10", "F11", "F12", "F13", "F14", "F15", "F16", "F17", "F18", "F19", "F2", "F20", "F21", "F22", "F23", "F24", "F25", "F26", "F27", "F28", "F29", "F3", "F30", "F31", "F32", "F33", "F34", "F35", "F36", "F37", "F38", "F39", "F4", "F40", "F41", "F42", "F43", "F44", "F45", "F46", "F47", "F48", "F49", "F5", "F50", "F51", "F52", "F53", "F54", "F55", "F56", "F57", "F58", "F59", "F6", "F60", "F61", "F62", "F63", "F64", "F7", "F8", "F9", "FALSE", "FETCH", "FGL_GETENV", "FGL_KEYVAL", "FGL_LASTKEY", "FIELD", "FIELD_TOUCHED", "FILE", "FILLFACTOR", "FILTERING", "FINISH", "FIRST", "FLOAT", "FLUSH", "FOR", "FOREACH", "FOREIGN", "FORM", "FORMAT", "FORMONLY", "FORTRAN", "FOUND", "FRACTION", "FRAGMENT", "FREE", "FROM", "FUNCTION", "GET_FLDBUF", "GLOBAL", "GLOBALS", "GO", "GOTO", "GRANT", "GREEN", "GROUP", "HAVING", "HEADER", "HELP", "HEX", "HIDE", "HIGH", "HOLD", "HOUR", "IDATA", "IF", "ILENGTH", "IMMEDIATE", "IN", "INCLUDE", "INDEX", "INDEXES", "INDICATOR", "INFIELD", "INIT", "INITIALIZE", "INPUT", "INSERT", "INSTRUCTIONS", "INT", "INTEGER", "INTERRUPT", "INTERVAL", "INTO", "INT_FLAG", "INVISIBLE", "IS", "ISAM", "ISOLATION", "ITYPE", "KEY", "LABEL", "LANGUAGE", "LAST", "LEADING", "LEFT", "LENGTH", "LET", "LIKE", "LINE", "LINENO", "LINES", "LOAD", "LOCATE", "LOCK", "LOG", "LOG10", "LOGN", "LONG", "LOW", "MAGENTA", "MAIN", "MARGIN", "MATCHES", "MAX", "MDY", "MEDIUM", "MEMORY", "MENU", "MESSAGE", "MESSAGE_LENGTH", "MESSAGE_TEXT", "MIN", "MINUTE", "MOD", "MODE", "MODIFY", "MODULE", "MONEY", "MONTH", "MORE", "NAME", "NCHAR", "NEED", "NEW", "NEXT", "NEXTPAGE", "NO", "NOCR", "NOENTRY", "NONE", "NORMAL", "NOT", "NOTFOUND", "NULL", "NULLABLE", "NUMBER", "NUMERIC", "NUM_ARGS", "NVARCHAR", "OCTET_LENGTH", "OF", "OFF", "OLD", "ON", "ONLY", "OPEN", "OPTIMIZATION", "OPTION", "OPTIONS", "OR", "ORDER", "OTHERWISE", "OUTER", "OUTPUT", "PAGE", "PAGENO", "PASCAL", "PAUSE", "PDQPRIORITY", "PERCENT", "PICTURE", "PIPE", "PLI", "POW", "PRECISION", "PREPARE", "PREVIOUS", "PREVPAGE", "PRIMARY", "PRINT", "PRINTER", "PRIOR", "PRIVATE", "PRIVILEGES", "PROCEDURE", "PROGRAM", "PROMPT", "PUBLIC", "PUT", "QUIT", "QUIT_FLAG", "RAISE", "RANGE", "READ", "READONLY", "REAL", "RECORD", "RECOVER", "RED", "REFERENCES", "REFERENCING", "REGISTER", "RELATIVE", "REMAINDER", "REMOVE", "RENAME", "REOPTIMIZATION", "REPEATABLE", "REPORT", "REQUIRED", "RESOLUTION", "RESOURCE", "RESTRICT", "RESUME", "RETURN", "RETURNED_SQLSTATE", "RETURNING", "REVERSE", "REVOKE", "RIGHT", "ROBIN", "ROLE", "ROLLBACK", "ROLLFORWARD", "ROOT", "ROUND", "ROW", "ROWID", "ROWIDS", "ROWS", "ROW_COUNT", "RUN", "SCALE", "SCHEMA", "SCREEN", "SCROLL", "SCR_LINE", "SECOND", "SECTION", "SELECT", "SERIAL", "SERIALIZABLE", "SERVER_NAME", "SESSION", "SET", "SET_COUNT", "SHARE", "SHORT", "SHOW", "SITENAME", "SIZE", "SIZEOF", "SKIP", "SLEEP", "SMALLFLOAT", "SMALLINT", "SOME", "SPACE", "SPACES", "SQL", "SQLAWARN", "SQLCA", "SQLCODE", "SQLERRD", "SQLERRM", "SQLERROR", "SQLERRP", "SQLSTATE", "SQLWARNING", "SQRT", "STABILITY", "START", "STARTLOG", "STATIC", "STATISTICS", "STATUS", "STDEV", "STEP", "STOP", "STRING", "STRUCT", "SUBCLASS_ORIGIN", "SUM", "SWITCH", "SYNONYM", "SYSTEM", "SysBlobs", "SysChecks", "SysColAuth", "SysColDepend", "SysColumns", "SysConstraints", "SysDefaults", "SysDepend", "SysDistrib", "SysFragAuth", "SysFragments", "SysIndexes", "SysObjState", "SysOpClstr", "SysProcAuth", "SysProcBody", "SysProcPlan", "SysProcedures", "SysReferences", "SysRoleAuth", "SysSynTable", "SysSynonyms", "SysTabAuth", "SysTables", "SysTrigBody", "SysTriggers", "SysUsers", "SysViews", "SysViolations", "TAB", "TABLE", "TABLES", "TAN", "TEMP", "TEXT", "THEN", "THROUGH", "THRU", "TIME", "TO", "TODAY", "TOP", "TOTAL", "TRACE", "TRAILER", "TRAILING", "TRANSACTION", "TRIGGER", "TRIGGERS", "TRIM", "TRUE", "TRUNC", "TYPE", "TYPEDEF", "UNCOMMITTED", "UNCONSTRAINED", "UNDERLINE", "UNION", "UNIQUE", "UNITS", "UNLOAD", "UNLOCK", "UNSIGNED", "UP", "UPDATE", "UPSHIFT", "USER", "USING", "VALIDATE", "VALUE", "VALUES", "VARCHAR", "VARIABLES", "VARIANCE", "VARYING", "VERIFY", "VIEW", "VIOLATIONS", "WAIT", "WAITING", "WARNING", "WEEKDAY", "WHEN", "WHENEVER", "WHERE", "WHILE", "WHITE", "WINDOW", "WITH", "WITHOUT", "WORDWRAP", "WORK", "WRAP", "WRITE", "YEAR", "YELLOW", "ZEROFILL", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, };

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
