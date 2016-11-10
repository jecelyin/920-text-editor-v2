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
public class InterlisLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "/*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "*/";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "!!";
        PROPERTY3.NAME = "blockComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "FALSE";
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
        EOL_SPAN1.text = "!!";
        EOL_SPAN1.TYPE = "COMMENT1";
        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "COMMENT2";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "//";
        END END3 = new END();
        END3.text = "//";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "->";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "<-";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "..";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = ".";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = ",";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "=";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = ";";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = ":";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "*";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "[";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "]";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "(";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = ")";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = ">";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "!=";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "#";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "%";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "(";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = ")";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "*";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = ",";
        SEQ21.TYPE = "OPERATOR";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "--";
        SEQ22.TYPE = "OPERATOR";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "-<#>";
        SEQ23.TYPE = "OPERATOR";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "-<>";
        SEQ24.TYPE = "OPERATOR";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "->";
        SEQ25.TYPE = "OPERATOR";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = ".";
        SEQ26.TYPE = "OPERATOR";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "..";
        SEQ27.TYPE = "OPERATOR";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "/";
        SEQ28.TYPE = "OPERATOR";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = ":";
        SEQ29.TYPE = "OPERATOR";
        SEQ SEQ30 = new SEQ();
        SEQ30.text = ":=";
        SEQ30.TYPE = "OPERATOR";
        SEQ SEQ31 = new SEQ();
        SEQ31.text = ";";
        SEQ31.TYPE = "OPERATOR";
        SEQ SEQ32 = new SEQ();
        SEQ32.text = "<";
        SEQ32.TYPE = "OPERATOR";
        SEQ SEQ33 = new SEQ();
        SEQ33.text = "<=";
        SEQ33.TYPE = "OPERATOR";
        SEQ SEQ34 = new SEQ();
        SEQ34.text = "<>";
        SEQ34.TYPE = "OPERATOR";
        SEQ SEQ35 = new SEQ();
        SEQ35.text = "=";
        SEQ35.TYPE = "OPERATOR";
        SEQ SEQ36 = new SEQ();
        SEQ36.text = "==";
        SEQ36.TYPE = "OPERATOR";
        SEQ SEQ37 = new SEQ();
        SEQ37.text = ">";
        SEQ37.TYPE = "OPERATOR";
        SEQ SEQ38 = new SEQ();
        SEQ38.text = ">=";
        SEQ38.TYPE = "OPERATOR";
        SEQ SEQ39 = new SEQ();
        SEQ39.text = "[";
        SEQ39.TYPE = "OPERATOR";
        SEQ SEQ40 = new SEQ();
        SEQ40.text = "\\";
        SEQ40.TYPE = "OPERATOR";
        SEQ SEQ41 = new SEQ();
        SEQ41.text = "]";
        SEQ41.TYPE = "OPERATOR";
        SEQ SEQ42 = new SEQ();
        SEQ42.text = "{";
        SEQ42.TYPE = "OPERATOR";
        SEQ SEQ43 = new SEQ();
        SEQ43.text = "}";
        SEQ43.TYPE = "OPERATOR";
        SEQ SEQ44 = new SEQ();
        SEQ44.text = "~";
        SEQ44.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"ANY", "ARCS", "AREA", "BASE", "BLANK", "CODE", "CONTINUE", "CONTOUR", "COORD2", "COORD3", "DATE", "DEFAULT", "DEGREES", "DERIVATIVES", "DIM1", "DIM2", "DOMAIN", "END", "FIX", "FONT", "FORMAT", "FREE", "GRADS", "HALIGNMENT", "I16", "I32", "IDENT", "LINEATTR", "LINESIZE", "MODEL", "NO", "OPTIONAL", "OVERLAPS", "PERIPHERY", "POLYLINE", "RADIANS", "STRAIGHTS", "SURFACE", "TABLE", "TEXT", "TID", "TIDSIZE", "TOPIC", "TRANSFER", "UNDEFINED", "VALIGNMENT", "VERTEX", "VERTEXINFO", "VIEW", "WITH", "WITHOUT", "ABSTRACT", "ACCORDING", "AGGREGATES", "AGGREGATION", "ALL", "AND", "ANY", "ANYCLASS", "ANYSTRUCTURE", "ARCS", "AREA", "AS", "ASSOCIATION", "AT", "ATTRIBUTE", "ATTRIBUTES", "BAG", "BASE", "BASED", "BASKET", "BINARY", "BLACKBOX", "BOOLEAN", "BY", "CARDINALITY", "CIRCULAR", "CLASS", "CLOCKWISE", "CONSTRAINT", "CONSTRAINTS", "CONTINUE", "CONTINUOUS", "CONTRACTED", "COORD", "COUNTERCLOCKWISE", "DEFINED", "DEPENDS", "DERIVED", "DIRECTED", "DOMAIN", "END", "ENUMTREEVAL", "ENUMVAL", "EQUAL", "EXISTENCE", "EXTENDED", "EXTENDS", "EXTERNAL", "FINAL", "FIRST", "FORM", "FROM", "FUNCTION", "GRAPHIC", "HALIGNMENT", "HIDING", "IMPORTS", "IN", "INHERITANCE", "INSPECTION", "INTERLIS", "JOIN", "LAST", "LINE", "LIST", "LNBASE", "LOCAL", "MANDATORY", "METAOBJECT", "MODEL", "MTEXT", "NAME", "NOT", "NO", "NULL", "NUMERIC", "OBJECT", "OF", "OID", "ON", "OR", "ORDERED", "OTHERS", "OVERLAPS", "PARAMETER", "PARENT", "PI", "POLYLINE", "PROJECTION", "REFERENCE", "REFSYSTEM", "REQUIRED", "RESTRICTED", "ROTATION", "SET", "SIGN", "STRAIGHTS", "STRUCTURE", "SUBDIVISION", "SURFACE", "SYMBOLOGY", "TEXT", "THATAREA", "THIS", "THISAREA", "TO", "TOPIC", "TRANSIENT", "TRANSLATION", "TYPE", "UNDEFINED", "UNION", "UNIQUE", "UNIT", "UNQUALIFIED", "URI", "VALIGNMENT", "VERSION", "VERTEX", "VIEW", "WHEN", "WHERE", "WITH", "WITHOUT", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, SEQ30, SEQ31, SEQ32, SEQ33, SEQ34, SEQ35, SEQ36, SEQ37, SEQ38, SEQ39, SEQ40, SEQ41, SEQ42, SEQ43, SEQ44, };

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
