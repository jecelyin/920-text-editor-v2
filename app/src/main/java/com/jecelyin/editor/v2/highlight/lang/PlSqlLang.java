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
public class PlSqlLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "/*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "*/";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "--";
        PROPERTY3.NAME = "lineComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "\\s*(.*THEN|ELSE|LOOP).*";
        PROPERTY4.NAME = "indentNextLines";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "^\\s*(ELSE|ELSIF|END IF|END LOOP).*";
        PROPERTY5.NAME = "unindentNextLines";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "^\\s*(ELSE|ELSIF|END IF|END LOOP).*";
        PROPERTY6.NAME = "unindentThisLine";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LABEL";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*+";
        END END1 = new END();
        END1.text = "*/";
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

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL1";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "LITERAL1";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "\"";
        END END4 = new END();
        END4.text = "\"";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.NO_LINE_BREAK = "TRUE";
        SPAN5.TYPE = "LITERAL1";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "[";
        END END5 = new END();
        END5.text = "]";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "--+";
        EOL_SPAN1.TYPE = "LABEL";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "--";
        EOL_SPAN2.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN3 = new EOL_SPAN();
        EOL_SPAN3.text = "REM";
        EOL_SPAN3.TYPE = "COMMENT1";
        EOL_SPAN3.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN4 = new EOL_SPAN();
        EOL_SPAN4.text = "REMARK";
        EOL_SPAN4.TYPE = "COMMENT1";
        EOL_SPAN4.AT_LINE_START = "TRUE";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "+";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "-";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "/";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "*";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "=";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = ">";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "<";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "%";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "&";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "|";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "^";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "~";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "!=";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "!>";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "!<";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = ":=";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = ".";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "(";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = ")";
        SEQ19.TYPE = "OPERATOR";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "@@";
        MARK_FOLLOWING1.AT_WHITESPACE_END = "TRUE";
        MARK_FOLLOWING1.TYPE = "LABEL";
        MARK_FOLLOWING1.AT_LINE_START = "TRUE";
        MARK_FOLLOWING MARK_FOLLOWING2 = new MARK_FOLLOWING();
        MARK_FOLLOWING2.text = "@";
        MARK_FOLLOWING2.AT_WHITESPACE_END = "TRUE";
        MARK_FOLLOWING2.TYPE = "LABEL";
        MARK_FOLLOWING2.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN5 = new EOL_SPAN();
        EOL_SPAN5.text = "!";
        EOL_SPAN5.AT_LINE_START = "TRUE";
        EOL_SPAN5.DELEGATE = "shellscript::MAIN";
        EOL_SPAN EOL_SPAN6 = new EOL_SPAN();
        EOL_SPAN6.text = "host";
        EOL_SPAN6.AT_LINE_START = "TRUE";
        EOL_SPAN6.DELEGATE = "shellscript::MAIN";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = ":";
        MARK_PREVIOUS1.TYPE = "LABEL";
        MARK_PREVIOUS1.AT_LINE_START = "TRUE";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("NULL", new String[]{".SQL", });
        KEYWORDS1.add("KEYWORD1", new String[]{"ABORT", "ACCESS", "ACCEPT", "ADD", "ALTER", "ARRAY", "ARRAY_LEN", "AS", "ASC", "ASSERT", "ASSIGN", "AT", "AUDIT", "AUTHORIZATION", "AVG", "BASE_TABLE", "BEGIN", "BINARY_INTEGER", "BODY", "BREAK", "BREAKS", "BTITLE", "CASE", "CALL", "CENTER", "CHAR", "CHAR_BASE", "CHECK", "CLEAR", "CLOSE", "CLUSTER", "CLUSTERS", "CMPVAR", "COL", "COLAUTH", "COLUMN", "COLUMNS", "COMMENT", "COMMIT", "COMPRESS", "COMPUTE", "CONSTANT", "CONSTRAINT", "CONTINUE", "COUNT", "CREATE", "CURRENT", "CURRVAL", "CURSOR", "DATABASE", "DATA_BASE", "DATE", "DBA", "DEBUGOFF", "DEBUGON", "DECLARE", "DEFAULT", "DEFINITION", "DELAY", "DELETE", "DESC", "EXPLAIN", "DIGITS", "DISPOSE", "DISTINCT", "DO", "DROP", "DUMP", "ELSE", "ELSIF", "END", "ENTRY", "ERRORS", "EXCEPTION", "EXCEPTION_INIT", "EXCLUSIVE", "EXECUTE", "EXIT", "EXTERNAL", "FALSE", "FETCH", "FILE", "FOR", "FOREIGN", "FORM", "FORMAT", "FROM", "FUNCTION", "GENERIC", "GOTO", "GRANT", "GREATEST", "GROUP", "HAVING", "HEADING", "IDENTIFIED", "IDENTITYCOL", "IF", "IMMEDIATE", "INCREMENT", "INDEX", "INDEXES", "INDICATOR", "INITIAL", "INSERT", "INTERFACE", "INTO", "IS", "KEY", "LEAST", "LEVEL", "LIMITED", "LOCK", "LONG", "LOOP", "MATCHED", "MAX", "MAXEXTENTS", "MERGE", "MEMBER", "MIN", "MINUS", "MLSLABEL", "MOD", "MODIFY", "MORE", "NATURAL", "NATURALN", "NEW", "NEW_VALUE", "NEXT", "NEXTVAL", "NOAUDIT", "NOCOMPRESS", "NOPRINT", "NOWAIT", "NULL", "NUMBER", "NUMBER_BASE", "OF", "OFFLINE", "ON", "OFF", "ONLINE", "OPEN", "OPTION", "ORDER", "ORGANIZATION", "OTHERS", "OUT", "PACKAGE", "PAGE", "PARTITION", "PCTFREE", "PCTINCREASE", "PLAN", "POSITIVE", "POSITIVEN", "PRAGMA", "PRINT", "PRIMARY", "PRIOR", "PRIVATE", "PRIVILEGES", "PROCEDURE", "PROMPT", "PUBLIC", "QUOTED_IDENTIFIER", "RAISE", "RANGE", "RAW", "RECORD", "REF", "REFERENCES", "RELEASE", "REMR", "RENAME", "RESOURCE", "RETURN", "REVERSE", "REVOKE", "ROLLBACK", "ROW", "ROWID", "ROWLABEL", "ROWNUM", "ROWS", "ROWTYPE", "RUN", "SAVEPOINT", "SCHEMA", "SELECT", "SEPERATE", "SEQUENCE", "SESSION", "SET", "SHARE", "SHOW", "SIGNTYPE", "SKIP", "SPACE", "SPOOL", "SQL", "SQLCODE", "SQLERRM", "SQLERROR", "STATEMENT", "STDDEV", "STORAGE", "SUBTYPE", "SUCCESSFULL", "SUM", "SYNONYM", "SYSDATE", "TABAUTH", "TABLE", "TABLES", "TABLESPACE", "TASK", "TERMINATE", "THEN", "TO", "TRIGGER", "TRUE", "TRUNCATE", "TTITLE", "TYPE", "UID", "UNION", "UNIQUE", "UNDEFINE", "UPDATE", "UPDATETEXT", "USE", "USER", "USING", "VALIDATE", "VALUES", "VARIANCE", "VIEW", "VIEWS", "WHEN", "WHENEVER", "WHERE", "WHILE", "WITH", "WORK", "WRITE", "XOR", "binary", "bit", "blob", "boolean", "char", "character", "datetime", "decimal", "float", "image", "int", "integer", "money", "numeric", "nchar", "nvarchar", "ntext", "object", "pls_integer", "real", "smalldatetime", "smallint", "smallmoney", "text", "timestamp", "tinyint", "uniqueidentifier", "varbinary", "varchar", "varchar2", "varray", "ALL", "AND", "ANY", "BETWEEN", "BY", "CONNECT", "EXISTS", "IN", "INTERSECT", "LIKE", "NOT", "NULL", "OR", "START", "UNION", "WITH", "NOTFOUND", "ISOPEN", "JOIN", "LEFT", "RIGHT", "FULL", "OUTER", "CROSS", });
        KEYWORDS1.add("KEYWORD2", new String[]{"ABS", "ACOS", "ADD_MONTHS", "ASCII", "ASIN", "ATAN", "ATAN2", "BITAND", "CEIL", "CHARTOROWID", "CHR", "CONCAT", "CONVERT", "COS", "COSH", "DECODE", "DEFINE", "DUAL", "FLOOR", "HEXTORAW", "INITCAP", "INSTR", "INSTRB", "LAST_DAY", "LENGTH", "LENGTHB", "LN", "LOG", "LOWER", "LPAD", "LTRIM", "MOD", "MONTHS_BETWEEN", "NEW_TIME", "NEXT_DAY", "NLSSORT", "NSL_INITCAP", "NLS_LOWER", "NLS_UPPER", "NVL", "POWER", "RAWTOHEX", "REPLACE", "ROUND", "ROWIDTOCHAR", "RPAD", "RTRIM", "SIGN", "SOUNDEX", "SIN", "SINH", "SQRT", "SUBSTR", "SUBSTRB", "TAN", "TANH", "TO_CHAR", "TO_DATE", "TO_MULTIBYTE", "TO_NUMBER", "TO_SINGLE_BYTE", "TRANSLATE", "TRUNC", "UPPER", });
        KEYWORDS1.add("FUNCTION", new String[]{"OPEN_CURSOR", "PARSE", "BIND_VARIABLE", "BIND_ARRAY", "DEFINE_COLUMN", "DEFINE_COLUMN_LONG", "DEFINE_ARRAY", "EXECUTE", "FETCH_ROWS", "EXECUTE_AND_FETCH", "VARIABLE_VALUE", "COLUMN_VALUE", "COLUMN_VALUE_LONG", "CLOSE_CURSOR", "DEFINE_COLUMN_CHAR", "COLUMN_VALUE_CHAR", "START_PROFILER", "STOP_PROFILER", "ROLLUP_RUN", });
        KEYWORDS1.add("KEYWORD3", new String[]{"DBMS_SQL", "DBMS_PROFILER", "_EDITOR", "ARRAYSIZE", "AUTOTRACE", "DBMS_OUTPUT", "ECHO", "ENABLE", "FCLOSE", "FCLOSE_ALL", "FEED", "FEEDBACK", "FILE_TYPE", "FOPEN", "HEAD", "INVALID_OPERATION", "INVALID_PATH", "LINESIZE", "PAGESIZE", "PAGES", "PAUSE", "DOC", "PUTF", "PUT_LINE", "SERVEROUTPUT", "SQL.PNO", "UTL_FILE", "VER", "VERIFY", "WRITE_ERROR", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, EOL_SPAN3, EOL_SPAN4, EOL_SPAN5, EOL_SPAN6, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, MARK_FOLLOWING2, };

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
