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
public class CssLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "/*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "*/";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "{";
        PROPERTY3.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "}";
        PROPERTY4.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "-";
        PROPERTY5.NAME = "noWordSep";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "_";
        PROPERTY6.NAME = "noWordSep";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "-?\\d+(\\.\\d+)?(pt|pc|in|mm|cm|em|ex|px|ms|s|%|)";
        RULES1.IGNORE_CASE = "TRUE";
        RULES1.NO_WORD_SEP = "-_%";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = ".";
        MARK_FOLLOWING1.TYPE = "LITERAL1";
        MARK_FOLLOWING MARK_FOLLOWING2 = new MARK_FOLLOWING();
        MARK_FOLLOWING2.text = "#";
        MARK_FOLLOWING2.TYPE = "LITERAL2";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ":";
        SEQ2.TYPE = "OPERATOR";
        SEQ2.DELEGATE = "PSEUDO";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = ",";
        SEQ3.TYPE = "OPERATOR";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "OPERATOR";
        SPAN1.DELEGATE = "PROPERTIES";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "{";
        END END1 = new END();
        END1.text = "}";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "GLOBAL";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "html::TAGS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, MARK_FOLLOWING2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PSEUDO";
        SEQ SEQ1 = new SEQ();
        SEQ1.TYPE = "NULL";
        SEQ1.DELEGATE = "MAIN";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ2.DELEGATE = "MAIN";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "{";
        SEQ3.TYPE = "OPERATOR";
        SEQ3.DELEGATE = "PROPERTIES";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "KEYWORD4";
        SPAN_REGEXP1.HASH_CHAR = "lang";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "lang\\s*\\(";
        END END1 = new END();
        END1.text = ")";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.TYPE = "KEYWORD4";
        SPAN_REGEXP2.HASH_CHAR = "lang";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "lang\\s*\\(";
        END END2 = new END();
        END2.text = ")";
        SPAN_REGEXP2.END = new END[] { END2, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN2, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "GLOBAL";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD4", new String[]{"after", "before", "first-child", "last-child", "link", "visited", "active", "hover", "focus", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PROPERTIES";
        RULES1.ESCAPE = "\\";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "}";
        SEQ1.TYPE = "OPERATOR";
        SEQ1.DELEGATE = "MAIN";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ":";
        SEQ2.TYPE = "OPERATOR";
        SEQ2.DELEGATE = "PROP_VALUE";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "GLOBAL";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("INVALID", new String[]{"alignment-adjust", "alignment-baseline", "backface-visibility", "baseline-shift", "bookmark-label", "bookmark-level", "bookmark-target", "border-image", "border-image-outset", "border-image-repeat", "border-image-slice", "border-image-source", "border-image-width", "box-decoration-break", "box-flex-group", "box-lines", "color-profile", "column-fill", "crop", "dominant-baseline", "drop-initial-after-adjust", "drop-initial-after-align", "drop-initial-before-adjust", "drop-initial-before-align", "drop-initial-size", "drop-initial-value", "fit", "fit-position", "float-offset", "font-stretch", "font-size-adjust", "grid-columns", "grid-rows", "hanging-punctuation", "hyphenate-after", "hyphenate-before", "hyphenate-characters", "hyphenate-lines", "hyphenate-resource", "hyphens", "icon", "image-orientation", "image-resolution", "inline-box-align", "line-stacking", "line-stacking-ruby", "line-stacking-shift", "line-stacking-strategy", "mark", "mark-after", "mark-before", "marks", "marquee-direction", "marquee-play-count", "marquee-speed", "marquee-style", "move-to", "nav-down", "nav-index", "nav-left", "nav-right", "nav-up", "overflow-style", "page", "page-policy", "phonemes", "punctuation-trim", "rest", "rest-after", "rest-before", "rotation", "rotation-point", "ruby-align", "ruby-overhang", "ruby-position", "ruby-span", "size", "string-set", "target", "target-name", "target-new", "target-position", "text-align-last", "text-emphasis", "text-height", "text-outline", "text-wrap", "voice-balance", "voice-duration", "voice-pitch", "voice-pitch-range", "voice-rate", "voice-stress", "voice-volume", });
        KEYWORDS1.add("KEYWORD2", new String[]{"background", "background-attachment", "background-color", "background-image", "background-position", "background-repeat", "background-origin", "background-clip", "background-size", "color", "opacity", "rendering-intent", "font", "font-family", "font-size", "font-style", "font-variant", "font-weight", "font-stretch", "src", "definition-src", "unicode-range", "panose-1", "stemv", "stemh", "units-per-em", "slope", "cap-height", "x-height", "ascent", "descent", "baseline", "centerline", "mathline", "topline", "letter-spacing", "text-align", "text-shadow", "text-decoration", "text-indent", "text-justify", "text-overflow", "text-transform", "word-break", "word-spacing", "word-wrap", "letter-spacing", "white-space", "border", "bottom", "border", "border-bottom", "border-bottom-color", "border-bottom-style", "border-bottom-width", "border-collapse", "border-color", "border-left", "border-left-color", "border-left-style", "border-left-width", "border-right", "border-right-color", "border-right-style", "border-right-width", "border-spacing", "border-style", "border-top", "border-top-color", "border-top-style", "border-top-width", "border-width", "border-bottom-left-radius", "border-bottom-right-radius", "border-radius", "border-top-left-radius", "border-top-right-radius", "box-align", "box-direction", "box-flex", "box-ordinal-group", "box-orient", "box-pack", "box-sizing", "box-shadow", "clear", "float", "height", "margin", "margin-bottom", "margin-left", "margin-right", "margin-top", "padding", "padding-bottom", "padding-left", "padding-right", "padding-top", "column-count", "column-fill", "column-gap", "column-rule", "column-rule-color", "column-rule-style", "column-rule-width", "column-span", "column-width", "columns", "handing-punctuation", "display", "position", "top", "right", "bottom", "left", "float", "z-index", "direction", "unicode-bidi", "width", "min-width", "max-width", "height", "min-height", "max-height", "line-height", "vertical-align", "overflow", "overflow-x", "overflow-y", "clip", "visibility", "perspective", "perspective-origin", "transform", "transform-origin", "transform-style", "transition", "transition-property", "transition-duration", "transition-timing-function", "transition-delay", "page-break-before", "page-break-after", "page-break-inside", "orphans", "widows", "caption-side", "table-layout", "border-collapse", "border-spacing", "empty-cells", "speak-headers", "cursor", "outline", "outline-width", "outline-style", "outline-color", "outline-offset", "azimuth", "volume", "speak", "pause", "pause-before", "pause-after", "cue", "cue-before", "cue-after", "play-during", "elevation", "speech-rate", "voice-family", "pitch", "pitch-range", "stress", "richness", "speak-punctuation", "speak-numeral", "speak-header-cell", "animation", "animation-name", "animation-duration", "animation-timing-function", "animation-delay", "animation-iteration-count", "animation-direction", "animation-play-state", "appearance", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PROP_VALUE";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "-?\\d+(\\.\\d+)?(pt|pc|in|mm|cm|em|ex|px|ms|s|%|)";
        RULES1.NO_WORD_SEP = "-_%";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.HASH_CHARS = "\"'";
        SPAN_REGEXP1.TYPE = "LITERAL1";
        SPAN_REGEXP1.ESCAPE = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "([\"'])";
        END END1 = new END();
        END1.text = "$1";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.TYPE = "LITERAL1";
        SPAN_REGEXP2.ESCAPE = "\\";
        SPAN_REGEXP2.MATCH_TYPE = "KEYWORD1";
        SPAN_REGEXP2.HASH_CHAR = "url(";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "url\\((?=\\s*[^\"'])";
        END END2 = new END();
        END2.text = ")";
        SPAN_REGEXP2.END = new END[] { END2, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN_REGEXP SPAN_REGEXP3 = new SPAN_REGEXP();
        SPAN_REGEXP3.TYPE = "FUNCTION";
        SPAN_REGEXP3.DELEGATE = "javascript::MAIN";
        SPAN_REGEXP3.HASH_CHAR = "expression";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "expression\\s*\\(";
        END END3 = new END();
        END3.text = ")";
        SPAN_REGEXP3.END = new END[] { END3, };

        SPAN_REGEXP3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN_REGEXP SPAN_REGEXP4 = new SPAN_REGEXP();
        SPAN_REGEXP4.TYPE = "KEYWORD1";
        SPAN_REGEXP4.DELEGATE = "PROP_VALUE";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "[\\w-]+\\(";
        END END4 = new END();
        END4.text = ")";
        SPAN_REGEXP4.END = new END[] { END4, };

        SPAN_REGEXP4.BEGIN = new BEGIN[] { BEGIN4, };

        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "#";
        MARK_FOLLOWING1.TYPE = "DIGIT";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "!\\s*important";
        SEQ_REGEXP1.TYPE = "KEYWORD2";
        SEQ_REGEXP1.HASH_CHAR = "!";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ";";
        SEQ1.TYPE = "OPERATOR";
        SEQ1.DELEGATE = "PROPERTIES";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "}";
        SEQ2.TYPE = "INVALID";
        SEQ2.DELEGATE = "MAIN";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "GLOBAL";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"rgb", "rgba", "hsl", "hsla", "url", });
        KEYWORDS1.add("KEYWORD3", new String[]{"above", "absolute", "absolute-colorimetric", "adjacent", "after", "after-edge", "all", "allow-end", "alphabetic", "alphabetical", "alternate", "always", "armenian", "attr", "auto", "avoid", "back", "balance", "baseline", "before", "before-edge", "behind", "bidi-override", "blink", "block", "block-axis", "block-line-height", "blur", "bold", "bolder", "border-box", "border-box", "both", "bottom", "break-all", "break-word", "button", "capitalize", "caps-height", "caption", "center", "center bottom", "center center", "center top", "central", "circle", "clip", "close-quote", "collapse", "color", "condensed", "consider-shifts", "contain", "content", "content-box", "counter", "cover", "crop", "cross", "crosshair", "cubic-bezier", "current", "cursive", "dashed", "decimal", "decimal-leading-zero", "default", "disc", "disregard-shifts", "distribute", "distribute-letter", "distribute-space", "dotted", "double", "resize", "e-resize", "ease", "ease-in", "ease-in-out", "ease-out", "ellipsis", "embed", "end", "end-edge", "exclude-ruby", "extra-condensed", "extra-expanded", "family-name", "fantasy", "fast", "field", "fill", "first", "fixed", "flat", "font-family", "font-size", "forward", "front", "georgian", "grid-height", "groove", "h-shadow", "hanging", "help", "here", "hidden", "hide", "high", "horizontal", "hyphenate", "icon", "ideographic", "include-ruby", "infinite", "inherit", "initial", "inline", "inline-axis", "inline-block", "inline-line-height", "inline-table", "inset", "inside", "integer", "inter-cluster", "inter-ideograph", "inter-word", "italic", "justify", "kashida", "landscape", "large", "larger", "last", "left", "left bottom", "left center", "left top", "leftwards", "length", "lighter", "line-edge", "line-through", "linear", "list-item", "loud", "low", "lower-alpha", "lower-greek", "lower-latin", "lower-roman", "lowercase", "ltr", "manual", "mathematical", "max-height", "max-size", "medium", "meet", "menu", "message-box", "middle", "modal", "moderate", "monospace", "move", "multiple", "n-resize", "name", "narrower", "ne-resize", "new", "no-change", "no-close-quote", "no-content", "no-display", "no-limit", "no-open-quote", "no-repeat", "none", "normal", "nowrap", "nw-resize", "oblique", "open-quote", "outset", "outside", "overline", "padding-box", "page-size", "parent", "paused", "percentage", "perceptual", "pointer", "portrait", "pre", "pre-line", "pre-wrap", "preserve-3d", "progress", "reduced", "relative", "relative-colorimetric", "repeat", "repeat-x", "repeat-y", "reset-size", "reverse", "ridge", "right", "right bottom", "right center", "right top", "rightwards", "root", "round", "rtl", "run-in", "running", "s-resize", "sans-serif", "saturation", "scroll", "se-resize", "self", "semi-condensed", "semi-expanded", "separate", "serif", "shape", "show", "silent", "single", "slice", "slide", "slow", "small", "small-caps", "small-caption", "smaller", "soft", "solid", "spread", "square", "start", "static", "status-bar", "stretch", "strong", "sub", "super", "suppress", "sw-resize", "tab", "table", "table-caption", "table-cell", "table-column", "table-column-group", "table-footer-group", "table-header-group", "table-row", "table-row-group", "text", "text-after-edge", "text-before-edge", "text-bottom", "text-size", "text-top", "thick", "thin", "top", "transparent", "ultra-condensed", "ultra-expanded", "underline", "unrestricted", "upper-alpha", "upper-latin", "upper-roman", "uppercase", "url", "use-script", "v-shadow", "vertical", "visible", "w-resize", "wait", "weak", "wider", "window", "x-fast", "x-high", "x-large", "x-loud", "x-low", "x-slow", "x-small", "x-soft", "x-strong", "x-weak", "xx-large", "xx-small", });
        KEYWORDS1.add("KEYWORD4", new String[]{"aliceblue", "antiquewhite", "aqua", "aquamarine", "azure", "beige", "bisque", "black", "blanchedalmond", "blue", "blueviolet", "brown", "burlywood", "cadetblue", "chartreuse", "chocolate", "coral", "cornflowerblue", "cornsilk", "crimson", "cyan", "darkblue", "darkcyan", "darkgoldenrod", "darkgray", "darkgreen", "darkgrey", "darkkhaki", "darkmagenta", "darkolivegreen", "darkorange", "darkorchid", "darkred", "darksalmon", "darkseagreen", "darkslateblue", "darkslategray", "darkslategrey", "darkturquoise", "darkviolet", "deeppink", "deepskyblue", "dimgray", "dimgrey", "dodgerblue", "firebrick", "floralwhite", "forestgreen", "fuchsia", "gainsboro", "ghostwhite", "gold", "goldenrod", "gray", "green", "greenyellow", "grey", "honeydew", "hotpink", "indianred", "indigo", "ivory", "khaki", "lavender", "lavenderblush", "lawngreen", "lemonchiffon", "lightblue", "lightcoral", "lightcyan", "lightgoldenrodyellow", "lightgray", "lightgreen", "lightgrey", "lightpink", "lightsalmon", "lightseagreen", "lightskyblue", "lightslategray", "lightslategrey", "lightsteelblue", "lightyellow", "lime", "limegreen", "linen", "magenta", "maroon", "mediumaquamarine", "mediumblue", "mediumorchid", "mediumpurple", "mediumseagreen", "mediumslateblue", "mediumspringgreen", "mediumturquoise", "mediumvioletred", "midnightblue", "mintcream", "mistyrose", "moccasin", "navajowhite", "navy", "oldlace", "olive", "olivedrab", "orange", "orangered", "orchid", "palegoldenrod", "palegreen", "paleturquoise", "palevioletred", "papayawhip", "peachpuff", "peru", "pink", "plum", "powderblue", "purple", "red", "rosybrown", "royalblue", "saddlebrown", "salmon", "sandybrown", "seagreen", "seashell", "sienna", "silver", "skyblue", "slateblue", "slategray", "slategrey", "snow", "springgreen", "steelblue", "tan", "teal", "thistle", "tomato", "turquoise", "violet", "wheat", "white", "whitesmoke", "yellow", "yellowgreen", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, SPAN_REGEXP3, SPAN_REGEXP4, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "GLOBAL";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ":";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ";";
        SEQ2.TYPE = "NULL";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "NULL";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "(";
        END END1 = new END();
        END1.text = ")";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ SEQ3 = new SEQ();
        SEQ3.text = "{";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "}";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = ",";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = ".";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "!";
        SEQ7.TYPE = "OPERATOR";
        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "COMMENT1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "/*";
        END END2 = new END();
        END2.text = "*/";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD2", new String[]{"content", "quotes", "counter-reset", "counter-increment", "marker-offset", "list-style", "list-style-image", "list-style-position", "list-style-type", "@import", "@media", "@page", "@font-face", });
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
