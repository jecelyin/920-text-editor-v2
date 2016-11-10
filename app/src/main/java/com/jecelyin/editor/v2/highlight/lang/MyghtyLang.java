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
public class MyghtyLang implements LangDefine {
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
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "COMMENT2";
        EOL_SPAN1.AT_LINE_START = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL4";
        SPAN1.DELEGATE = "MYGHTY";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<%attr>";
        END END1 = new END();
        END1.text = "</%attr>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "LITERAL4";
        SPAN_REGEXP1.DELEGATE = "DEF";
        SPAN_REGEXP1.HASH_CHAR = "<%";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<%(def|closure|method)";
        END END2 = new END();
        END2.text = ">";
        SPAN_REGEXP1.END = new END[] { END2, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "</%(def|closure|method)>";
        SEQ_REGEXP1.TYPE = "LITERAL4";
        SEQ_REGEXP1.HASH_CHAR = "</%";
        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "COMMENT4";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<%doc>";
        END END3 = new END();
        END3.text = "</%doc>";
        SPAN2.END = new END[] { END3, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL4";
        SPAN3.DELEGATE = "MYGHTY";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "<%flags>";
        END END4 = new END();
        END4.text = "</%flags>";
        SPAN3.END = new END[] { END4, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.TYPE = "LITERAL4";
        SPAN_REGEXP2.DELEGATE = "MYGHTY";
        SPAN_REGEXP2.HASH_CHAR = "<%python";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "<%python[^>]*>";
        END END5 = new END();
        END5.text = "</%python>";
        SPAN_REGEXP2.END = new END[] { END5, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN_REGEXP SPAN_REGEXP3 = new SPAN_REGEXP();
        SPAN_REGEXP3.TYPE = "LITERAL4";
        SPAN_REGEXP3.DELEGATE = "MYGHTY";
        SPAN_REGEXP3.HASH_CHAR = "<%";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "<%(args|cleanup|filter|global|init|once|requestlocal|requestonce|shared|threadlocal|threadonce)>";
        END END6 = new END();
        END6.text = "</%$1>";
        SPAN_REGEXP3.END = new END[] { END6, };

        SPAN_REGEXP3.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "LITERAL3";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "<%text>";
        END END7 = new END();
        END7.text = "</%text>";
        SPAN4.END = new END[] { END7, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN7, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "</&>";
        SEQ1.TYPE = "LITERAL4";
        SPAN_REGEXP SPAN_REGEXP4 = new SPAN_REGEXP();
        SPAN_REGEXP4.TYPE = "LITERAL4";
        SPAN_REGEXP4.DELEGATE = "MYGHTY";
        SPAN_REGEXP4.HASH_CHAR = "<&";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "<&[|]?";
        END END8 = new END();
        END8.text = "&>";
        SPAN_REGEXP4.END = new END[] { END8, };

        SPAN_REGEXP4.BEGIN = new BEGIN[] { BEGIN8, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "LITERAL3";
        SPAN5.DELEGATE = "MYGHTY";
        BEGIN BEGIN9 = new BEGIN();
        BEGIN9.text = "<%";
        END END9 = new END();
        END9.text = "%>";
        SPAN5.END = new END[] { END9, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN9, };

        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "%";
        EOL_SPAN2.TYPE = "LITERAL4";
        EOL_SPAN2.AT_LINE_START = "TRUE";
        EOL_SPAN2.DELEGATE = "MYGHTY";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "html::MAIN";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("NULL", new String[]{"args", "attr", "cleanup", "closure", "def", "doc", "filter", "flags", "global", "init", "method", "once", "python", "requestlocal", "requestonce", "shared", "threadlocal", "threadonce", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, SPAN_REGEXP3, SPAN_REGEXP4, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "MYGHTY";
        RULES1.IGNORE_CASE = "FALSE";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "@";
        SEQ1.TYPE = "KEYWORD4";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "python::MAIN";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD4", new String[]{"ARGS", "MODULE", "SELF", "m", "r", "s", "u", "h", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "DEF";
        RULES1.DEFAULT = "FUNCTION";
        RULES1.IGNORE_CASE = "TRUE";
        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
