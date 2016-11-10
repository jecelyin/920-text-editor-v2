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
public class DotLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "/*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "*/";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = ",+-=<>/?^&*";
        PROPERTY3.NAME = "wordBreakChars";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "[{";
        PROPERTY4.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "]}";
        PROPERTY5.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "(";
        PROPERTY6.NAME = "unalignedOpenBrackets";
        PROPERTY PROPERTY7 = new PROPERTY();
        PROPERTY7.VALUE = ")";
        PROPERTY7.NAME = "unalignedCloseBrackets";
        PROPERTY PROPERTY8 = new PROPERTY();
        PROPERTY8.VALUE = "(?!^\\s*(#|//|/\\*)).*((sub|di|)graph|node|edge)\\s+([\\[{<]).*";
        PROPERTY8.NAME = "indentNextLine";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, PROPERTY8, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[0-9][0-9a-zA-Z]*";
        RULES1.IGNORE_CASE = "FALSE";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "DOT_LEXER";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "KEYWORDS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "DOT_LEXER";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[0-9][0-9a-zA-Z]*";
        RULES1.IGNORE_CASE = "FALSE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "//";
        EOL_SPAN2.TYPE = "COMMENT2";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.NO_LINE_BREAK = "FALSE";
        SPAN_REGEXP1.TYPE = "COMMENT3";
        SPAN_REGEXP1.MATCH_TYPE = "COMMENT3";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/\\*";
        END END1 = new END();
        END1.text = "*/";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "->";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "[";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "]";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = ")";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "}";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "{";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = ";";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "=";
        SEQ8.TYPE = "OPERATOR";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "KEYWORD3";
        SPAN1.DELEGATE = "url::MAIN";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "URL=\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN1.END = new END[] { END2, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "\"";
        END END3 = new END();
        END3.text = "\"";
        SPAN2.END = new END[] { END3, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN3 = new SPAN();
        SPAN3.DELEGATE = "html::MAIN";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "<";
        END END4 = new END();
        END4.text = ">";
        SPAN3.END = new END[] { END4, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN4, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "KEYWORDS";
        RULES1.IGNORE_CASE = "TRUE";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"graph", "subgraph", "digraph", "node", "edge", });
        KEYWORDS1.add("KEYWORD2", new String[]{"strict", });
        KEYWORDS1.add("KEYWORD3", new String[]{"URL", "label", "shape", "style", "type", "rank", "tailport", "headport", });
        KEYWORDS1.add("KEYWORD4", new String[]{"same", "box", "polygon", "ellipse", "point", "egg", "triangle", "diamond", "trapezium", "parallelogram", "hexagon", "octagon", "doublecircle", "tripleoctagon", "invtriangle", "invtrapezium", "normal", "dot", "odot", "inv", "invdot", "invodot", "none", "antiquewhite1", "antiquewhite2", "antiquewhite3", "antiquewhite4", "azure1", "azure2", "azure3", "azure4", "bisque1", "bisque2", "bisque3", "bisque4", "blanchedalmond", "cornsilk1", "cornsilk2", "cornsilk3", "cornsilk4", "floralwhite", "gainsboro", "ghostwhite", "honeydew1", "honeydew2", "honeydew3", "honeydew4", "ivory1", "ivory2", "ivory3", "ivory4", "lavender", "lavenderblush1", "lavenderblush2", "lavenderblush3", "lavenderblush4", "lemonchiffon1", "lemonchiffon2", "lemonchiffon3", "lemonchiffon4", "linen", "mintcream", "mistyrose1", "mistyrose2", "mistyrose3", "mistyrose4", "moccasin", "navajowhite1", "navajowhite2", "navajowhite3", "navajowhite4", "oldlace", "papayawhip", "peachpuff1", "peachpuff2", "peachpuff3", "peachpuff4", "seashell1", "seashell2", "seashell3", "seashell4", "snow1", "snow2", "snow3", "snow4", "thistle1", "thistle2", "thistle3", "thistle4", "wheat1", "wheat2", "wheat3", "wheat4", "white", "whitesmoke", "coral1", "coral2", "coral3", "coral4", "crimson", "darksalmon", "deeppink1", "deeppink2", "deeppink3", "deeppink4", "firebrick1", "firebrick2", "firebrick3", "firebrick4", "hotpink1", "hotpink2", "hotpink3", "hotpink4", "indianred1", "indianred2", "indianred3", "indianred4", "lightpink1", "lightpink2", "lightpink3", "lightpink4", "lightsalmon1", "lightsalmon2", "lightsalmon3", "lightsalmon4", "maroon1", "maroon2", "maroon3", "maroon4", "mediumvioletred", "orangered1", "orangered2", "orangered3", "orangered4", "palevioletred1", "palevioletred2", "palevioletred3", "palevioletred4", "pink1", "pink2", "pink3", "pink4", "red1", "red2", "red3", "red4", "salmon1", "salmon2", "salmon3", "salmon4", "tomato1", "tomato2", "tomato3", "tomato4", "violetred1", "violetred2", "violetred3", "violetred4", "darkgoldenrod1", "darkgoldenrod2", "darkgoldenrod3", "darkgoldenrod4", "gold1", "gold2", "gold3", "gold4", "goldenrod1", "goldenrod2", "goldenrod3", "goldenrod4", "greenyellow", "lightgoldenrod1", "lightgoldenrod2", "lightgoldenrod3", "lightgoldenrod4", "lightgoldenrodyellow", "lightyellow1", "lightyellow2", "lightyellow3", "lightyellow4", "palegoldenrod", "yellow1", "yellow2", "yellow3", "yellow4", "yellowgreen", "blueviolet", "darkorchid1", "darkorchid2", "darkorchid3", "darkorchid4", "darkviolet", "magenta1", "magenta2", "magenta3", "magenta4", "mediumorchid1", "mediumorchid2", "mediumorchid3", "mediumorchid4", "mediumpurple1", "mediumpurple2", "mediumpurple3", "mediumpurple4", "mediumvioletred", "orchid1", "orchid2", "orchid3", "orchid4", "palevioletred1", "palevioletred2", "palevioletred3", "palevioletred4", "plum1", "plum2", "plum3", "plum4", "purple1", "purple2", "purple3", "purple4", "violet", "violetred1", "violetred2", "violetred3", "violetred4", "aliceblue", "blue1", "blue2", "blue3", "blue4", "blueviolet", "cadetblue1", "cadetblue2", "cadetblue3", "cadetblue4", "cornflowerblue", "darkslateblue", "deepskyblue1", "deepskyblue2", "deepskyblue3", "deepskyblue4", "dodgerblue1", "dodgerblue2", "dodgerblue3", "dodgerblue4", "indigo", "lightblue1", "lightblue2", "lightblue3", "lightblue4", "lightskyblue1", "lightskyblue2", "lightskyblue3", "lightskyblue4", "lightslateblue1", "lightslateblue2", "lightslateblue3", "lightslateblue4", "mediumblue", "mediumslateblue", "midnightblue", "navy", "navyblue", "powderblue", "royalblue1", "royalblue2", "royalblue3", "royalblue4", "skyblue1", "skyblue2", "skyblue3", "skyblue4", "slateblue1", "slateblue2", "slateblue3", "slateblue4", "steelblue1", "steelblue2", "steelblue3", "steelblue4", "chartreuse1", "chartreuse2", "chartreuse3", "chartreuse4", "darkgreen", "darkolivegreen1", "darkolivegreen2", "darkolivegreen3", "darkolivegreen4", "darkseagreen1", "darkseagreen2", "darkseagreen3", "darkseagreen4", "forestgreen", "green1", "green2", "green3", "green4", "greenyellow", "lawngreen", "lightseagreen", "limegreen", "mediumseagreen", "mediumspringgreen", "mintcream", "olivedrab1", "olivedrab2", "olivedrab3", "olivedrab4", "palegreen1", "palegreen2", "palegreen3", "palegreen4", "seagreen1", "seagreen2", "seagreen3", "seagreen4", "springgreen1", "springgreen2", "springgreen3", "springgreen4", "yellowgreen", "beige", "brown1", "brown2", "brown3", "brown4", "burlywood1", "burlywood2", "burlywood3", "burlywood4", "chocolate1", "chocolate2", "chocolate3", "chocolate4", "darkkhaki", "khaki1", "khaki2", "khaki3", "khaki4", "peru", "rosybrown1", "rosybrown2", "rosybrown3", "rosybrown4", "saddlebrown", "sandybrown", "sienna1", "sienna2", "sienna3", "sienna4", "tan1", "tan2", "tan3", "tan4", "darkslategray1", "darkslategray2", "darkslategray3", "darkslategray4", "dimgray", "gray", "gray0", "gray1", "gray2", "gray3", "gray4", "gray5", "gray6", "gray7", "gray8", "gray9", "gray10", "gray11", "gray12", "gray13", "gray14", "gray15", "gray16", "gray17", "gray18", "gray19", "gray20", "gray21", "gray22", "gray23", "gray24", "gray25", "gray26", "gray27", "gray28", "gray29", "gray30", "gray31", "gray32", "gray33", "gray34", "gray35", "gray36", "gray37", "gray38", "gray39", "gray40", "gray41", "gray42", "gray43", "gray44", "gray45", "gray46", "gray47", "gray48", "gray49", "gray50", "gray51", "gray52", "gray53", "gray54", "gray55", "gray56", "gray57", "gray58", "gray59", "gray60", "gray61", "gray62", "gray63", "gray64", "gray65", "gray66", "gray67", "gray68", "gray69", "gray70", "gray71", "gray72", "gray73", "gray74", "gray75", "gray76", "gray77", "gray78", "gray79", "gray80", "gray81", "gray82", "gray83", "gray84", "gray85", "gray86", "gray87", "gray88", "gray89", "gray90", "gray91", "gray92", "gray93", "gray94", "gray95", "gray96", "gray97", "gray98", "gray99", "gray100", "lightgray", "lightslategray", "slategray1", "slategray2", "slategray3", "slategray4", "aquamarine1", "aquamarine2", "aquamarine3", "aquamarine4", "cyan1", "cyan2", "cyan3", "cyan4", "darkturquoise", "lightcyan1", "lightcyan2", "lightcyan3", "lightcyan4", "mediumaquamarine", "mediumturquoise", "paleturquoise1", "paleturquoise2", "paleturquoise3", "paleturquoise4", "turquoise1", "turquoise2", "turquoise3", "turquoise4", "darkorange1", "darkorange2", "darkorange3", "darkorange4", "orange1", "orange2", "orange3", "orange4", "orangered1", "orangered2", "orangered3", "orangered4", "black", });
        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
