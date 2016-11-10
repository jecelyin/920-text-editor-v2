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
public class MpostLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "%";
        PROPERTY1.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(0x[[:xdigit:]]+[lL]?|[[:digit:]]+(e[[:digit:]]*)?[lLdDfF]?(cm|in|pt|px)?)";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "tex::MAIN";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "btex";
        END END1 = new END();
        END1.text = "etex";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "path";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "pair";
        SEQ2.TYPE = "OPERATOR";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "%";
        EOL_SPAN1.TYPE = "COMMENT1";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "z[0-9]?";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "FUNCTION";
        SEQ_REGEXP1.HASH_CHAR = "z";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "x[0-9]?";
        SEQ_REGEXP2.AT_WORD_START = "TRUE";
        SEQ_REGEXP2.TYPE = "FUNCTION";
        SEQ_REGEXP2.HASH_CHAR = "x";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "y[0-9]?";
        SEQ_REGEXP3.AT_WORD_START = "TRUE";
        SEQ_REGEXP3.TYPE = "FUNCTION";
        SEQ_REGEXP3.HASH_CHAR = "y";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "CONTEXT";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "&";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "*";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "*";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "**";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "+";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "++";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "+-+";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "-";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = ".";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "/";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "<";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "<=";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "<>";
        SEQ15.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"rotatedaround", "abs", "angle", "arclength", "arctime", "ASCII", "bbox", "bluepart", "boolean", "bot", "ceiling", "center", "char", "cmykcolor", "colormodel", "color", "cosd", "cutafter", "intersection", "cutbefore", "intersection", "cyanpart", "cycle", "decimal", "dir", "direction", "directionpoint", "directiontime", "div", "dotprod", "floor", "fontsize", "greenpart", "greypart", "hex", "infont", "intersectionpoint", "intesctiontimes", "inverse", "known", "length", "ulft", "llft", "lft", "llcorner", "lrcorner", "magentapart", "makemakeconvex", "mexp", "mlog", "mod", "normaldeviate", "not", "numeric", "oct", "odd", "or", "of", "penoffset", "picture", "point", "postcontrol", "precontrol", "redpart", "reverse", "swapped", "rgbcolor", "rotated", "reflectedabout", "round", "lrt", "urt", "rt", "scaled", "scantokens", "token", "top", "to", "shifted", "sind", "slanted", "sqrt", "string", "str", "subof", "substring", "transformed", "transform", "ulcorner", "uniformdeviate", "unitvector", "unknown", "urcorner", "whatever", "xpart", "xxpart", "xypart", "yellowpart", "ypart", "yxpart", "yypart", "zscaled", "dashed", "pen", "suffix", "expr", });
        KEYWORDS1.add("KEYWORD1", new String[]{"beginfig", "endfig", "for", "upto", "downto", "def", "enddef", "vardef", "step", "until", "endfor", "bye", "if", "elseif", "else:", "fi", "exitif", "exitunless", "forever:", "forsuffixes", "end", "begingroup", "endgroup", "save", "unknown", "input", "newinternal", });
        KEYWORDS1.add("KEYWORD2", new String[]{"addto", "clip", "cutdraw", "draw", "drawarrow", "drawdblarrow", "fill", "filldraw", "interim", "let", "loggingall", "newinternal", "pickup", "save", "setbounds", "shipout", "show", "showdependencies", "showtoken", "showvariable", "special", "tracingall", "tracingnone", "undraw", "unfill", "unfilldraw", });
        KEYWORDS1.add("FUNCTION", new String[]{"boxit", "boxjoin", "bpath", "buildcycle", "circleit", "circleit", "circleit", "dashpattern", "decr", "dotlabel", "dotlabel", "dotlabels", "drawboxed", "contents", "drawdot", "drawoptions", "drawunboxed", "fixpos", "named", "fixsize", "image", "incr", "label", "label", "labels", "max", "max", "min", "min", "pic", "thelabel", "thelabel", });
        KEYWORDS1.add("KEYWORD3", new String[]{"ahangle", "ahlength", "bboxmargin", "charcode", "circmargin", "day", "defaultcolormodel", "defaultdx", "defaultdy", "defaultpen", "defaultscale", "labeloffset", "linecap", "linejoin", "miterlimit", "month", "mpprocset", "pausing", "prologues", "restoreclipcolor", "showstopping", "time", "tracingcapsules", "tracingchoices", "tracingcommands", "tracingequations", "tracinglostchars", "tracingmacros", "tracingonline", "tracingoutput", "tracingrestores", "tracingspecs", "tracingstats", "tracingtitles", "troffmode", "truecorners", "warningcheck", "year", "background", "currentpen", "currentpicture", "cuttings", "defaultfont", "extra_beginfig", "extra_endfig", });
        KEYWORDS1.add("KEYWORD4", new String[]{"beveled", "black", "blue", "bp", "butt", "cc", "cm", "dd", "ditto", "down", "epsilon", "evenly", "false", "fullcircle", "green", "halfcircle", "identity", "in", "infinity", "left", "mitered", "mm", "mpversion", "nullpicture", "origin", "pc", "pencircle", "pensquare", "pt", "quartercircle", "red", "right", "rounded", "and", "squared", "true", "unitsquare", "up", "white", "withdots", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, };

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
