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
public class VelocityLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "#*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "*#";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "##";
        PROPERTY3.NAME = "lineComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "^\\s*(#(foreach|if|elseif|else))\\s*\\(.*\\)\\s*";
        PROPERTY4.NAME = "indentNextLines";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "^\\s*#(end|elseif|else)\\b.*";
        PROPERTY5.NAME = "unindentThisLine";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, };

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

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "MARKUP";
        SPAN2.DELEGATE = "JAVASCRIPT";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<SCRIPT";
        END END2 = new END();
        END2.text = "</SCRIPT>";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "MARKUP";
        SPAN3.DELEGATE = "CSS";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<STYLE";
        END END3 = new END();
        END3.text = "</STYLE>";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "KEYWORD2";
        SPAN4.DELEGATE = "xml::DTD-TAGS";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "<!";
        END END4 = new END();
        END4.text = ">";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "MARKUP";
        SPAN5.DELEGATE = "html::TAGS";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "<";
        END END5 = new END();
        END5.text = ">";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN SPAN6 = new SPAN();
        SPAN6.NO_WORD_BREAK = "TRUE";
        SPAN6.TYPE = "LITERAL2";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "&";
        END END6 = new END();
        END6.text = ";";
        SPAN6.END = new END[] { END6, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN6, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "VELOCITY";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "VELOCITY";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT2";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "#*";
        END END1 = new END();
        END1.text = "*#";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "##";
        EOL_SPAN1.TYPE = "COMMENT3";
        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "KEYWORD3";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "${";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "\\$!?[A-z][A-z0-9._-]*";
        SEQ_REGEXP1.TYPE = "KEYWORD3";
        SEQ_REGEXP1.HASH_CHAR = "$";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"#set", "#foreach", "#end", "#if", "#else", "#elseif", "#parse", "#macro", "#stop", "#include", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "JAVASCRIPT";
        RULES1.DEFAULT = "MARKUP";
        RULES1.IGNORE_CASE = "TRUE";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "JAVASCRIPT2";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "SRC=";
        SEQ2.TYPE = "MARKUP";
        SEQ2.DELEGATE = "BACK_TO_HTML";
        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "JAVASCRIPT2";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(0x[\\p{XDigit}]+[lL]?|[\\p{Digit}]+(e[\\p{Digit}]*)?[lLdDfF]?)";
        RULES1.IGNORE_CASE = "FALSE";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "VELOCITY";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "javascript::MAIN";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "BACK_TO_HTML";
        RULES1.DEFAULT = "MARKUP";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "MAIN";
        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES6() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CSS";
        RULES1.DEFAULT = "MARKUP";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "CSS2";
        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES7() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CSS2";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[\\p{Digit}]+(pt|pc|in|mm|cm|em|ex|px|ms|s|%)";
        RULES1.IGNORE_CASE = "TRUE";
        RULES1.NO_WORD_SEP = "-_";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "VELOCITY";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "css::MAIN";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), RULES6(), RULES7(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
