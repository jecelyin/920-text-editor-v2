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
public class PowerdynamoLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "{";
        PROPERTY1.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "}";
        PROPERTY2.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = " @ %^*()+=|\\{}[]:;,.?$&";
        PROPERTY3.NAME = "wordBreakChars";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "<!--";
        PROPERTY4.NAME = "commentStart";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "-->";
        PROPERTY5.NAME = "commentEnd";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "//";
        PROPERTY6.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LABEL";
        SPAN1.DELEGATE = "powerdynamo-script";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<!--script";
        END END1 = new END();
        END1.text = "-->";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LABEL";
        SPAN2.DELEGATE = "powerdynamo-tag-data";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<!--data";
        END END2 = new END();
        END2.text = "-->";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LABEL";
        SPAN3.DELEGATE = "powerdynamo-tag-document";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<!--document";
        END END3 = new END();
        END3.text = "-->";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "LABEL";
        SPAN4.DELEGATE = "powerdynamo-script";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "<!--evaluate";
        END END4 = new END();
        END4.text = "-->";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "LABEL";
        SPAN5.DELEGATE = "powerdynamo-script";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "<!--execute";
        END END5 = new END();
        END5.text = "-->";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN SPAN6 = new SPAN();
        SPAN6.TYPE = "LABEL";
        SPAN6.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "<!--formatting";
        END END6 = new END();
        END6.text = "-->";
        SPAN6.END = new END[] { END6, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN7 = new SPAN();
        SPAN7.TYPE = "LABEL";
        SPAN7.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "<!--/formatting";
        END END7 = new END();
        END7.text = "-->";
        SPAN7.END = new END[] { END7, };

        SPAN7.BEGIN = new BEGIN[] { BEGIN7, };

        SPAN SPAN8 = new SPAN();
        SPAN8.TYPE = "LABEL";
        SPAN8.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "<!--include";
        END END8 = new END();
        END8.text = "-->";
        SPAN8.END = new END[] { END8, };

        SPAN8.BEGIN = new BEGIN[] { BEGIN8, };

        SPAN SPAN9 = new SPAN();
        SPAN9.TYPE = "LABEL";
        SPAN9.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN9 = new BEGIN();
        BEGIN9.text = "<!--label";
        END END9 = new END();
        END9.text = "-->";
        SPAN9.END = new END[] { END9, };

        SPAN9.BEGIN = new BEGIN[] { BEGIN9, };

        SPAN SPAN10 = new SPAN();
        SPAN10.TYPE = "LABEL";
        SPAN10.DELEGATE = "transact-sql::MAIN";
        BEGIN BEGIN10 = new BEGIN();
        BEGIN10.text = "<!--sql";
        END END10 = new END();
        END10.text = "-->";
        SPAN10.END = new END[] { END10, };

        SPAN10.BEGIN = new BEGIN[] { BEGIN10, };

        SPAN SPAN11 = new SPAN();
        SPAN11.TYPE = "LABEL";
        SPAN11.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN11 = new BEGIN();
        BEGIN11.text = "<!--sql_error_code";
        END END11 = new END();
        END11.text = "-->";
        SPAN11.END = new END[] { END11, };

        SPAN11.BEGIN = new BEGIN[] { BEGIN11, };

        SPAN SPAN12 = new SPAN();
        SPAN12.TYPE = "LABEL";
        SPAN12.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN12 = new BEGIN();
        BEGIN12.text = "<!--sql_error_info";
        END END12 = new END();
        END12.text = "-->";
        SPAN12.END = new END[] { END12, };

        SPAN12.BEGIN = new BEGIN[] { BEGIN12, };

        SPAN SPAN13 = new SPAN();
        SPAN13.TYPE = "LABEL";
        SPAN13.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN13 = new BEGIN();
        BEGIN13.text = "<!--sql_state";
        END END13 = new END();
        END13.text = "-->";
        SPAN13.END = new END[] { END13, };

        SPAN13.BEGIN = new BEGIN[] { BEGIN13, };

        SPAN SPAN14 = new SPAN();
        SPAN14.TYPE = "LABEL";
        SPAN14.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN14 = new BEGIN();
        BEGIN14.text = "<!--sql_on_no_error";
        END END14 = new END();
        END14.text = "-->";
        SPAN14.END = new END[] { END14, };

        SPAN14.BEGIN = new BEGIN[] { BEGIN14, };

        SPAN SPAN15 = new SPAN();
        SPAN15.TYPE = "LABEL";
        SPAN15.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN15 = new BEGIN();
        BEGIN15.text = "<!--/sql_on_no_error";
        END END15 = new END();
        END15.text = "-->";
        SPAN15.END = new END[] { END15, };

        SPAN15.BEGIN = new BEGIN[] { BEGIN15, };

        SPAN SPAN16 = new SPAN();
        SPAN16.TYPE = "LABEL";
        SPAN16.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN16 = new BEGIN();
        BEGIN16.text = "<!--sql_on_error";
        END END16 = new END();
        END16.text = "-->";
        SPAN16.END = new END[] { END16, };

        SPAN16.BEGIN = new BEGIN[] { BEGIN16, };

        SPAN SPAN17 = new SPAN();
        SPAN17.TYPE = "LABEL";
        SPAN17.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN17 = new BEGIN();
        BEGIN17.text = "<!--/sql_on_error";
        END END17 = new END();
        END17.text = "-->";
        SPAN17.END = new END[] { END17, };

        SPAN17.BEGIN = new BEGIN[] { BEGIN17, };

        SPAN SPAN18 = new SPAN();
        SPAN18.TYPE = "LABEL";
        SPAN18.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN18 = new BEGIN();
        BEGIN18.text = "<!--sql_on_no_rows";
        END END18 = new END();
        END18.text = "-->";
        SPAN18.END = new END[] { END18, };

        SPAN18.BEGIN = new BEGIN[] { BEGIN18, };

        SPAN SPAN19 = new SPAN();
        SPAN19.TYPE = "LABEL";
        SPAN19.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN19 = new BEGIN();
        BEGIN19.text = "<!--/sql_on_no_rows";
        END END19 = new END();
        END19.text = "-->";
        SPAN19.END = new END[] { END19, };

        SPAN19.BEGIN = new BEGIN[] { BEGIN19, };

        SPAN SPAN20 = new SPAN();
        SPAN20.TYPE = "LABEL";
        SPAN20.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN20 = new BEGIN();
        BEGIN20.text = "<!--sql_on_rows";
        END END20 = new END();
        END20.text = "-->";
        SPAN20.END = new END[] { END20, };

        SPAN20.BEGIN = new BEGIN[] { BEGIN20, };

        SPAN SPAN21 = new SPAN();
        SPAN21.TYPE = "LABEL";
        SPAN21.DELEGATE = "powerdynamo-tag-general";
        BEGIN BEGIN21 = new BEGIN();
        BEGIN21.text = "<!--/sql_on_rows";
        END END21 = new END();
        END21.text = "-->";
        SPAN21.END = new END[] { END21, };

        SPAN21.BEGIN = new BEGIN[] { BEGIN21, };

        SPAN SPAN22 = new SPAN();
        SPAN22.TYPE = "COMMENT1";
        BEGIN BEGIN22 = new BEGIN();
        BEGIN22.text = "<!--";
        END END22 = new END();
        END22.text = "-->";
        SPAN22.END = new END[] { END22, };

        SPAN22.BEGIN = new BEGIN[] { BEGIN22, };

        SPAN SPAN23 = new SPAN();
        SPAN23.TYPE = "MARKUP";
        SPAN23.DELEGATE = "html::JAVASCRIPT";
        BEGIN BEGIN23 = new BEGIN();
        BEGIN23.text = "<SCRIPT";
        END END23 = new END();
        END23.text = "</SCRIPT>";
        SPAN23.END = new END[] { END23, };

        SPAN23.BEGIN = new BEGIN[] { BEGIN23, };

        SPAN SPAN24 = new SPAN();
        SPAN24.TYPE = "MARKUP";
        SPAN24.DELEGATE = "html::CSS";
        BEGIN BEGIN24 = new BEGIN();
        BEGIN24.text = "<STYLE";
        END END24 = new END();
        END24.text = "</STYLE>";
        SPAN24.END = new END[] { END24, };

        SPAN24.BEGIN = new BEGIN[] { BEGIN24, };

        SPAN SPAN25 = new SPAN();
        SPAN25.TYPE = "KEYWORD2";
        SPAN25.DELEGATE = "xml::DTD-TAGS";
        BEGIN BEGIN25 = new BEGIN();
        BEGIN25.text = "<!";
        END END25 = new END();
        END25.text = ">";
        SPAN25.END = new END[] { END25, };

        SPAN25.BEGIN = new BEGIN[] { BEGIN25, };

        SPAN SPAN26 = new SPAN();
        SPAN26.TYPE = "MARKUP";
        SPAN26.DELEGATE = "TAGS";
        BEGIN BEGIN26 = new BEGIN();
        BEGIN26.text = "<";
        END END26 = new END();
        END26.text = ">";
        SPAN26.END = new END[] { END26, };

        SPAN26.BEGIN = new BEGIN[] { BEGIN26, };

        SPAN SPAN27 = new SPAN();
        SPAN27.NO_WORD_BREAK = "TRUE";
        SPAN27.TYPE = "LITERAL2";
        BEGIN BEGIN27 = new BEGIN();
        BEGIN27.text = "&";
        END END27 = new END();
        END27.text = ";";
        SPAN27.END = new END[] { END27, };

        SPAN27.BEGIN = new BEGIN[] { BEGIN27, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, SPAN7, SPAN8, SPAN9, SPAN10, SPAN11, SPAN12, SPAN13, SPAN14, SPAN15, SPAN16, SPAN17, SPAN18, SPAN19, SPAN20, SPAN21, SPAN22, SPAN23, SPAN24, SPAN25, SPAN26, SPAN27, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "TAGS";
        RULES1.DEFAULT = "MARKUP";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LABEL";
        SPAN1.DELEGATE = "powerdynamo-script";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<!--script";
        END END1 = new END();
        END1.text = "--?>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.DELEGATE = "TAGS_LITERAL";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL1";
        SPAN3.DELEGATE = "TAGS_LITERAL";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "TAGS_LITERAL";
        RULES1.DEFAULT = "LITERAL1";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LABEL";
        SPAN1.DELEGATE = "powerdynamo-script";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<!--script";
        END END1 = new END();
        END1.text = "?-->";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "powerdynamo-script";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
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

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "//";
        EOL_SPAN1.TYPE = "COMMENT1";
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
        SEQ5.text = "=";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "+";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "-";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "/";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "*";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = ">";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "<";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "%";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "&";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "|";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "^";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "~";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = ".";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "}";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "{";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = ",";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = ";";
        SEQ21.TYPE = "OPERATOR";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "]";
        SEQ22.TYPE = "OPERATOR";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "[";
        SEQ23.TYPE = "OPERATOR";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "?";
        SEQ24.TYPE = "OPERATOR";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "@";
        SEQ25.TYPE = "OPERATOR";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = ":";
        SEQ26.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = ")";
        SEQ27.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "break", "byte", "boolean", "catch", "case", "class", "char", "continue", "default", "double", "do", "else", "exists", "extends", "false", "file", "final", "float", "for", "finally", "function", "if", "import", "implements", "int", "interface", "instanceof", "long", "length", "native", "new", "null", "package", "private", "protected", "public", "return", "switch", "synchronized", "short", "static", "super", "try", "true", "this", "throw", "throws", "threadsafe", "transient", "var", "void", "while", });
        KEYWORDS1.add("KEYWORD2", new String[]{"", "document", "connection", "file", "query", "session", "site", "system", "typeof", });
        KEYWORDS1.add("KEYWORD3", new String[]{"AskQuestion", "autoCommit", "Close", "Commit", "Connect", "CreateConnection", "CreateDocument", "CreatePropertySheet", "CreateQuery", "CreateWizard", "cachedOutputTimeOut", "charAt", "connected", "connection", "connectionId", "connectionName", "connectionType", "connectParameters", "contentType", "DeleteConnection", "DeleteDocument", "Disconnect", "database", "dataSource", "dataSourceList", "description", "Exec", "Execute", "ExportTo", "eof", "errorNumber", "errorString", "GetColumnCount", "GetColumnIndex", "GetColumnLabel", "GetConnection", "GetConnectionIdList", "GetConnectionNameList", "GetCWD", "GetDirectory", "GetDocument", "GetEmpty", "GetEnv", "GetErrorCode", "GetErrorInfo", "GetEventList", "GetFilePtr", "GetGenerated", "GetRootDocument", "GetRowCount", "GetServerVariable", "GetState", "GetSupportedMoves", "GetValue", "ImportFrom", "Include", "id", "indexOf", "lastIndexOf", "lastModified", "length", "location", "Move", "MoveFirst", "MoveLast", "MoveNext", "MovePrevious", "MoveRelative", "mode", "name", "OnEvent", "Open", "Opened", "parent", "password", "ReadChar", "ReadLine", "Refresh", "Rollback", "redirect", "Seek", "SetEnv", "SetSQL", "ShowMessage", "substring", "server", "simulateCursors", "size", "source", "status", "timeOut", "toLowerCase", "toUpperCase", "type", "userId", "value", "WriteLine", "Write", "write", "writeln", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "powerdynamo-tag-general";
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

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD2", new String[]{"NAME", });
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES6() {
        RULES RULES1 = new RULES();
        RULES1.SET = "powerdynamo-tag-data";
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

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD2", new String[]{"NAME", "QUERY", });
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES7() {
        RULES RULES1 = new RULES();
        RULES1.SET = "powerdynamo-tag-document";
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

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD2", new String[]{"CONTENT_TYPE", "REDIRECT", "STATUS", "CACHED_OUTPUT_TIMEOUT", });
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), RULES6(), RULES7(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
