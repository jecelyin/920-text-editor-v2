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
public class RcpLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "/*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "*/";
        PROPERTY2.NAME = "commentEnd";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
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
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "/*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "//";
        PROPERTY2.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, };

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
        SPAN2.DELEGATE = "RCP_LITERAL";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL1";
        SPAN3.ESCAPE = "\\";
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
        SEQ3.text = "=";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "+";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "-";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "/";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "*";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "%";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "|";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "^";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "~";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "}";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "{";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = ",";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = ";";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "]";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "[";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "?";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "@";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = ":";
        SEQ20.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = ")";
        SEQ21.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"PREVTOP", "PREVBOTTOM", "PREVLEFT", "PREVRIGHT", "AUTO", "AUTOID", });
        KEYWORDS1.add("FUNCTION", new String[]{"ALERT", "APPLICATION", "APPLICATIONICONNAME", "AREA", "BITMAP", "BITMAPCOLOR", "BITMAPCOLOR16", "BITMAPCOLOR16K", "BITMAPFAMILY", "BITMAPFAMILYEX", "BITMAPFAMILYSPECIAL", "BITMAPGREY", "BITMAPGREY16", "BITMAPSCREENFAMILY", "BOOTSCREENFAMILY", "BUTTON", "BUTTONS", "BYTELIST", "CATEGORIES", "CHECKBOX", "COUNTRYLOCALISATION", "DATA", "FEATURE", "FIELD", "FONTINDEX", "FORM", "FORMBITMAP", "GADGET", "GENERATEHEADER", "GRAFFITIINPUTAREA", "GRAFFITISTATEINDICATOR", "HEX", "ICON", "ICONFAMILY", "ICONFAMILYEX", "INTEGER", "KEYBOARD", "LABEL", "LAUNCHERCATEGORY", "LIST", "LONGWORDLIST", "MENU", "MENUITEM", "MESSAGE", "MIDI", "NOGRAFFITISTATEINDICATOR", "PALETTETABLE", "POPUPLIST", "POPUPTRIGGER", "PULLDOWN", "PUSHBUTTON", "REPEATBUTTON", "RESETAUTOID", "SCROLLBAR", "SELECTORTRIGGER", "SLIDER", "SMALLICON", "SMALLICONFAMILY", "SMALLICONFAMILYEX", "STRING", "STRINGTABLE", "TABLE", "TITLE", "TRANSLATION", "TRAP", "VERSION", "WORDLIST", });
        KEYWORDS1.add("KEYWORD2", new String[]{"AT", "AUTOSHIFT", "BACKGROUNDID", "BITMAPID", "BOLDFRAME", "BPP", "CHECKED", "COLORTABLE", "COLUMNS", "COLUMNWIDTHS", "COMPRESS", "COMPRESSBEST", "COMPRESSPACKBITS", "COMPRESSRLE", "COMPRESSSCANLINE", "CONFIRMATION", "COUNTRY", "CREATOR", "CURRENCYDECIMALPLACES", "CURRENCYNAME", "CURRENCYSYMBOL", "CURRENCYUNIQUESYMBOL", "DATEFORMAT", "DAYLIGHTSAVINGS", "DEFAULTBTNID", "DEFAULTBUTTON", "DENSITY", "DISABLED", "DYNAMICSIZE", "EDITABLE", "ENTRY", "ERROR", "EXTENDED", "FEEDBACK", "FILE", "FONTID", "FORCECOMPRESS", "FRAME", "GRAFFITI", "GRAPHICAL", "GROUP", "HASSCROLLBAR", "HELPID", "ID", "INDEX", "INFORMATION", "KEYDOWNCHR", "KEYDOWNKEYCODE", "KEYDOWNMODIFIERS", "LANGUAGE", "LEFTALIGN", "LEFTANCHOR", "LONGDATEFORMAT", "MAX", "MAXCHARS", "MEASUREMENTSYSTEM", "MENUID", "MIN", "LOCALE", "MINUTESWESTOFGMT", "MODAL", "MULTIPLELINES", "NAME", "NOCOLORTABLE", "NOCOMPRESS", "NOFRAME", "NONEDITABLE", "NONEXTENDED", "NONUSABLE", "NOSAVEBEHIND", "NUMBER", "NUMBERFORMAT", "NUMERIC", "PAGESIZE", "RECTFRAME", "RIGHTALIGN", "RIGHTANCHOR", "ROWS", "SAVEBEHIND", "SEARCH", "SCREEN", "SELECTEDBITMAPID", "SINGLELINE", "THUMBID", "TRANSPARENTINDEX", "TIMEFORMAT", "UNDERLINED", "USABLE", "VALUE", "VERTICAL", "VISIBLEITEMS", "WARNING", "WEEKSTARTDAY", "FONT", "TRANSPARENT", });
        KEYWORDS1.add("KEYWORD3", new String[]{"BEGIN", "END", });
        KEYWORDS1.add("KEYWORD4", new String[]{"#include", "#define", "equ", "#undef", "#ifdef", "#ifndef", "#else", "#endif", "package", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.PROPS = new PROPS[] { PROPS1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "RCP_LITERAL";
        RULES1.DEFAULT = "LITERAL1";
        RULES1.ESCAPE = "\\";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "$";
        MARK_FOLLOWING1.TYPE = "KEYWORD3";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "\\";
        SEQ1.TYPE = "LITERAL1";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "=";
        SEQ2.TYPE = "LITERAL1";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "!";
        SEQ3.TYPE = "LITERAL1";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "=";
        SEQ4.TYPE = "LITERAL1";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "+";
        SEQ5.TYPE = "LITERAL1";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "-";
        SEQ6.TYPE = "LITERAL1";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "/";
        SEQ7.TYPE = "LITERAL1";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "*";
        SEQ8.TYPE = "LITERAL1";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "%";
        SEQ9.TYPE = "LITERAL1";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "|";
        SEQ10.TYPE = "LITERAL1";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "^";
        SEQ11.TYPE = "LITERAL1";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "~";
        SEQ12.TYPE = "LITERAL1";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = ".";
        SEQ13.TYPE = "LITERAL1";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "}";
        SEQ14.TYPE = "LITERAL1";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "{";
        SEQ15.TYPE = "LITERAL1";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = ",";
        SEQ16.TYPE = "LITERAL1";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = ";";
        SEQ17.TYPE = "LITERAL1";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "]";
        SEQ18.TYPE = "LITERAL1";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "[";
        SEQ19.TYPE = "LITERAL1";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "?";
        SEQ20.TYPE = "LITERAL1";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "@";
        SEQ21.TYPE = "LITERAL1";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = ":";
        SEQ22.TYPE = "LITERAL1";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = ")";
        SEQ23.TYPE = "LITERAL1";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "'";
        SEQ24.TYPE = "LITERAL1";
        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
