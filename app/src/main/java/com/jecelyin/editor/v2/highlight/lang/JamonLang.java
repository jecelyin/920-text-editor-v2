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
public class JamonLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "<%--";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "--%>";
        PROPERTY2.NAME = "commentEnd";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.DEFAULT = "LITERAL2";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "INLINE";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "OVERRIDES";
        IMPORT IMPORT3 = new IMPORT();
        IMPORT3.DELEGATE = "html::MAIN";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, IMPORT3, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "INLINE";
        RULES1.DEFAULT = "LITERAL2";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.DELEGATE = "java::MAIN";
        SPAN_REGEXP1.MATCH_TYPE = "OPERATOR";
        SPAN_REGEXP1.HASH_CHAR = "<";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%(args|class|import|java|xargs)>";
        END END1 = new END();
        END1.text = "</%$1>";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.DELEGATE = "java::MAIN";
        SPAN_REGEXP2.MATCH_TYPE = "OPERATOR";
        SPAN_REGEXP2.HASH_CHAR = "<";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<%(?:if|for|java)";
        END END2 = new END();
        END2.text = "%>";
        SPAN_REGEXP2.END = new END[] { END2, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "</%(?:if|for)>";
        SEQ_REGEXP1.TYPE = "OPERATOR";
        SEQ_REGEXP1.HASH_CHAR = "<";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "<%else>";
        SEQ1.TYPE = "OPERATOR";
        SPAN_REGEXP SPAN_REGEXP3 = new SPAN_REGEXP();
        SPAN_REGEXP3.TYPE = "KEYWORD2";
        SPAN_REGEXP3.MATCH_TYPE = "OPERATOR";
        SPAN_REGEXP3.HASH_CHAR = "<";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<%(?:abstract|def|doc|escape|extends|frag|method|override)";
        END END3 = new END();
        END3.text = ">";
        SPAN_REGEXP3.END = new END[] { END3, };

        SPAN_REGEXP3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN_REGEXP SPAN_REGEXP4 = new SPAN_REGEXP();
        SPAN_REGEXP4.MATCH_TYPE = "OPERATOR";
        SPAN_REGEXP4.HASH_CHAR = "<";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "</%(?:def|doc|frag|method|override)";
        END END4 = new END();
        END4.text = ">";
        SPAN_REGEXP4.END = new END[] { END4, };

        SPAN_REGEXP4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "OPERATOR";
        SPAN1.DELEGATE = "java::MAIN";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "<%";
        END END5 = new END();
        END5.text = "%>";
        SPAN1.END = new END[] { END5, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN_REGEXP SPAN_REGEXP5 = new SPAN_REGEXP();
        SPAN_REGEXP5.DELEGATE = "java::MAIN";
        SPAN_REGEXP5.MATCH_TYPE = "OPERATOR";
        SPAN_REGEXP5.HASH_CHAR = "<";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "<&\\|?";
        END END6 = new END();
        END6.text = "&>";
        SPAN_REGEXP5.END = new END[] { END6, };

        SPAN_REGEXP5.BEGIN = new BEGIN[] { BEGIN6, };

        SEQ SEQ2 = new SEQ();
        SEQ2.text = "</&>";
        SEQ2.TYPE = "OPERATOR";
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, SPAN_REGEXP3, SPAN_REGEXP4, SPAN_REGEXP5, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "OVERRIDES";
        RULES1.DEFAULT = "LITERAL2";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "CSS";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<style";
        END END1 = new END();
        END1.text = "</style>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "MARKUP";
        SPAN_REGEXP1.DELEGATE = "JAVASCRIPT";
        SPAN_REGEXP1.HASH_CHAR = "<";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<(?i)(script)";
        END END2 = new END();
        END2.text = "</$1>";
        SPAN_REGEXP1.END = new END[] { END2, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "MARKUP";
        SPAN2.DELEGATE = "TAGS";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<";
        END END3 = new END();
        END3.text = ">";
        SPAN2.END = new END[] { END3, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN3, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "JAVASCRIPT";
        RULES1.DEFAULT = "LITERAL1";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "INLINE";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "INLINE";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "javascript::MAIN";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CSS";
        RULES1.DEFAULT = "LITERAL1";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "INLINE";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "INLINE";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "css::MAIN";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES6() {
        RULES RULES1 = new RULES();
        RULES1.SET = "INLINE_MARKUP";
        RULES1.DEFAULT = "LITERAL1";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "KEYWORD2";
        SPAN_REGEXP1.MATCH_TYPE = "OPERATOR";
        SPAN_REGEXP1.HASH_CHAR = "<";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%(?:abstract|def|doc|escape|extends|frag|method|override)";
        END END1 = new END();
        END1.text = ">";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.MATCH_TYPE = "OPERATOR";
        SPAN_REGEXP2.HASH_CHAR = "<";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "</%(?:def|doc|frag|method|override)";
        END END2 = new END();
        END2.text = ">";
        SPAN_REGEXP2.END = new END[] { END2, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "OPERATOR";
        SPAN1.DELEGATE = "java::MAIN";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<%";
        END END3 = new END();
        END3.text = "%>";
        SPAN1.END = new END[] { END3, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN_REGEXP SPAN_REGEXP3 = new SPAN_REGEXP();
        SPAN_REGEXP3.DELEGATE = "java::MAIN";
        SPAN_REGEXP3.MATCH_TYPE = "OPERATOR";
        SPAN_REGEXP3.HASH_CHAR = "<";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "<&\\|?";
        END END4 = new END();
        END4.text = "&>";
        SPAN_REGEXP3.END = new END[] { END4, };

        SPAN_REGEXP3.BEGIN = new BEGIN[] { BEGIN4, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "</&>";
        SEQ1.TYPE = "OPERATOR";
        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, SPAN_REGEXP3, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES7() {
        RULES RULES1 = new RULES();
        RULES1.SET = "TAGS";
        RULES1.DEFAULT = "MARKUP";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "INLINE_MARKUP";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "INLINE_MARKUP";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "html::TAGS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), RULES6(), RULES7(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
