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
public class HtmlLang implements LangDefine {
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
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<!--";
        END END1 = new END();
        END1.text = "-->";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "MARKUP";
        SPAN_REGEXP1.DELEGATE = "JAVASCRIPT";
        SPAN_REGEXP1.HASH_CHAR = "<";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<(?=SCRIPT\\b)";
        END END2 = new END();
        END2.text = "(?i)(?=</SCRIPT\\b)";
        END2.REGEXP = "TRUE";
        SPAN_REGEXP1.END = new END[] { END2, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.TYPE = "MARKUP";
        SPAN_REGEXP2.DELEGATE = "CSS";
        SPAN_REGEXP2.HASH_CHAR = "<";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<(?=STYLE\\b)";
        END END3 = new END();
        END3.text = "(?i)(?=</STYLE\\b)";
        END3.REGEXP = "TRUE";
        SPAN_REGEXP2.END = new END[] { END3, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "KEYWORD2";
        SPAN2.DELEGATE = "xml::DTD-TAGS";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "<!";
        END END4 = new END();
        END4.text = ">";
        SPAN2.END = new END[] { END4, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "MARKUP";
        SPAN3.DELEGATE = "TAGS";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "<";
        END END5 = new END();
        END5.text = ">";
        SPAN3.END = new END[] { END5, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN5, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "CHARACTER_ENTITIES";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "TAGS";
        RULES1.DEFAULT = "MARKUP";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.AT_WORD_START = "TRUE";
        SPAN_REGEXP1.TYPE = "MARKUP";
        SPAN_REGEXP1.DELEGATE = "css::PROPERTIES";
        SPAN_REGEXP1.HASH_CHAR = "style";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "style\\s*=\\s*([\"'])";
        END END1 = new END();
        END1.text = "$1";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.AT_WORD_START = "TRUE";
        SPAN_REGEXP2.TYPE = "MARKUP";
        SPAN_REGEXP2.DELEGATE = "javascript::MAIN";
        SPAN_REGEXP2.HASH_CHAR = "on";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "on[a-z]+\\s*=\\s*([\"'])";
        END END2 = new END();
        END2.text = "$1";
        SPAN_REGEXP2.END = new END[] { END2, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "ATTRIBUTE";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "\"";
        END END3 = new END();
        END3.text = "\"";
        SPAN1.END = new END[] { END3, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.DELEGATE = "ATTRIBUTE";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "'";
        END END4 = new END();
        END4.text = "'";
        SPAN2.END = new END[] { END4, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN4, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"a", "abbr", "acronym", "address", "applet", "area", "article", "aside", "audio", "b", "base", "basefont", "bdi", "bdo", "big", "blockquote", "body", "br", "button", "canvas", "caption", "center", "cite", "code", "col", "colgroup", "command", "data", "datalist", "dd", "del", "details", "dfn", "dir", "div", "dl", "dt", "em", "embed", "fieldset", "figcaption", "figure", "font", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "i", "iframe", "img", "input", "ins", "isindex", "kbd", "keygen", "label", "legend", "li", "link", "map", "mark", "menu", "meta", "meter", "nav", "noframes", "noscript", "object", "ol", "optgroup", "option", "output", "p", "param", "pre", "progress", "q", "rp", "rt", "ruby", "s", "samp", "script", "section", "select", "small", "source", "span", "strike", "strong", "style", "sub", "summary", "sup", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "time", "title", "tr", "track", "tt", "u", "ul", "var", "video", "wbr", });
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "JAVASCRIPT";
        RULES1.DEFAULT = "MARKUP";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "type(?=\\s*=\\s*['\"]?text/coffeescript)";
        SEQ_REGEXP1.TYPE = "MARKUP";
        SEQ_REGEXP1.DELEGATE = "COFFEESCRIPT_TAG";
        SEQ_REGEXP1.HASH_CHAR = "type";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "type(?=\\s*=\\s*['\"]?text/vbscript)";
        SEQ_REGEXP2.TYPE = "MARKUP";
        SEQ_REGEXP2.DELEGATE = "VBSCRIPT_TAG";
        SEQ_REGEXP2.HASH_CHAR = "type";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "language(?=\\s*=\\s*['\"]?vbscript)";
        SEQ_REGEXP3.TYPE = "MARKUP";
        SEQ_REGEXP3.DELEGATE = "VBSCRIPT_TAG";
        SEQ_REGEXP3.HASH_CHAR = "language";
        SEQ_REGEXP SEQ_REGEXP4 = new SEQ_REGEXP();
        SEQ_REGEXP4.text = "type(?=\\s*=\\s*['\"]?\\w+/python)";
        SEQ_REGEXP4.TYPE = "MARKUP";
        SEQ_REGEXP4.DELEGATE = "PYTHON_SCRIPT_TAG";
        SEQ_REGEXP4.HASH_CHAR = "type";
        SEQ_REGEXP SEQ_REGEXP5 = new SEQ_REGEXP();
        SEQ_REGEXP5.text = "type(?=\\s*=\\s*['\"]?\\w+/ruby)";
        SEQ_REGEXP5.TYPE = "MARKUP";
        SEQ_REGEXP5.DELEGATE = "RUBY_SCRIPT_TAG";
        SEQ_REGEXP5.HASH_CHAR = "type";
        SEQ_REGEXP SEQ_REGEXP6 = new SEQ_REGEXP();
        SEQ_REGEXP6.text = "type(?=\\s*=\\s*['\"]?application/xml)";
        SEQ_REGEXP6.TYPE = "MARKUP";
        SEQ_REGEXP6.DELEGATE = "XML_SCRIPT_TAG";
        SEQ_REGEXP6.HASH_CHAR = "type";
        SEQ_REGEXP SEQ_REGEXP7 = new SEQ_REGEXP();
        SEQ_REGEXP7.text = "type(?=\\s*=\\s*['\"]?\\w+/xquery)";
        SEQ_REGEXP7.TYPE = "MARKUP";
        SEQ_REGEXP7.DELEGATE = "XQUERY_SCRIPT_TAG";
        SEQ_REGEXP7.HASH_CHAR = "type";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "javascript::MAIN";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TAGS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, SEQ_REGEXP4, SEQ_REGEXP5, SEQ_REGEXP6, SEQ_REGEXP7, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "COFFEESCRIPT_TAG";
        RULES1.DEFAULT = "MARKUP";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "coffeescript::MAIN";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TAGS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PYTHON_SCRIPT_TAG";
        RULES1.DEFAULT = "MARKUP";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "python::MAIN";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TAGS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES6() {
        RULES RULES1 = new RULES();
        RULES1.SET = "RUBY_SCRIPT_TAG";
        RULES1.DEFAULT = "MARKUP";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "ruby::MAIN";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TAGS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES7() {
        RULES RULES1 = new RULES();
        RULES1.SET = "VBSCRIPT_TAG";
        RULES1.DEFAULT = "MARKUP";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "vbscript::MAIN";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TAGS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES8() {
        RULES RULES1 = new RULES();
        RULES1.SET = "XML_SCRIPT_TAG";
        RULES1.DEFAULT = "MARKUP";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "xml::MAIN";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TAGS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES9() {
        RULES RULES1 = new RULES();
        RULES1.SET = "XQUERY_SCRIPT_TAG";
        RULES1.DEFAULT = "MARKUP";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "xq::MAIN";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TAGS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES10() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CSS";
        RULES1.DEFAULT = "MARKUP";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "css::MAIN";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TAGS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES11() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ATTRIBUTE";
        RULES1.DEFAULT = "LITERAL1";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "CHARACTER_ENTITIES";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        return RULES1;
    }

    private RULES RULES12() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CHARACTER_ENTITIES";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "&(#\\d+|#x\\p{XDigit}+|\\p{Alnum}+);";
        SEQ_REGEXP1.TYPE = "LITERAL2";
        SEQ_REGEXP1.HASH_CHAR = "&";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "&";
        SEQ1.TYPE = "INVALID";
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), RULES6(), RULES7(), RULES8(), RULES9(), RULES10(), RULES11(), RULES12(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
