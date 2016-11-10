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
public class ObjectiveCLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "/*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "*/";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "//";
        PROPERTY3.NAME = "lineComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = ",+-=<>/?^&*";
        PROPERTY4.NAME = "wordBreakChars";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "{";
        PROPERTY5.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "}";
        PROPERTY6.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY7 = new PROPERTY();
        PROPERTY7.VALUE = "(";
        PROPERTY7.NAME = "unalignedOpenBrackets";
        PROPERTY PROPERTY8 = new PROPERTY();
        PROPERTY8.VALUE = ")";
        PROPERTY8.NAME = "unalignedCloseBrackets";
        PROPERTY PROPERTY9 = new PROPERTY();
        PROPERTY9.VALUE = "\\s*(((if|while)\\s*\\(|else\\s*|else\\s+if\\s*\\(|for\\s*\\(.*\\))[^{;]*)";
        PROPERTY9.NAME = "indentNextLine";
        PROPERTY PROPERTY10 = new PROPERTY();
        PROPERTY10.VALUE = "^.*(default:\\s*|case.*:.*)$";
        PROPERTY10.NAME = "unindentThisLine";
        PROPERTY PROPERTY11 = new PROPERTY();
        PROPERTY11.VALUE = ":";
        PROPERTY11.NAME = "electricKeys";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, PROPERTY8, PROPERTY9, PROPERTY10, PROPERTY11, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[0-9][0-9a-zA-Z]*";
        RULES1.IGNORE_CASE = "FALSE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.AT_WHITESPACE_END = "TRUE";
        EOL_SPAN1.TYPE = "KEYWORD2";
        EOL_SPAN1.DELEGATE = "CPP";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "c::LEX";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "c::CORE";
        IMPORT IMPORT3 = new IMPORT();
        IMPORT3.DELEGATE = "CORE";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, IMPORT3, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CORE";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[0-9][0-9a-zA-Z]*";
        RULES1.IGNORE_CASE = "FALSE";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"TRUE", "FALSE", "YES", "NO", "NULL", "nil", "Nil", });
        KEYWORDS1.add("KEYWORD1", new String[]{"oneway", "in", "out", "inout", "bycopy", "byref", "self", "super", "@interface", "@implementation", "@protocol", "@end", "@private", "@protected", "@public", "@class", "@selector", "@endcode", "@defs", });
        KEYWORDS1.add("KEYWORD3", new String[]{"id", "Class", "SEL", "IMP", "BOOL", });
        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CPP";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[0-9][0-9a-zA-Z]*";
        RULES1.IGNORE_CASE = "FALSE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP1 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP1.text = "include\\b";
        EOL_SPAN_REGEXP1.TYPE = "MARKUP";
        EOL_SPAN_REGEXP1.DELEGATE = "c::INCLUDE";
        EOL_SPAN_REGEXP1.HASH_CHAR = "include";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP2 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP2.text = "import\\b";
        EOL_SPAN_REGEXP2.TYPE = "MARKUP";
        EOL_SPAN_REGEXP2.DELEGATE = "c::INCLUDE";
        EOL_SPAN_REGEXP2.HASH_CHAR = "import";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP3 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP3.text = "define\\b";
        EOL_SPAN_REGEXP3.TYPE = "MARKUP";
        EOL_SPAN_REGEXP3.DELEGATE = "DEFINE";
        EOL_SPAN_REGEXP3.HASH_CHAR = "define";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP4 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP4.text = "endif\\b";
        EOL_SPAN_REGEXP4.TYPE = "MARKUP";
        EOL_SPAN_REGEXP4.DELEGATE = "c::LEX";
        EOL_SPAN_REGEXP4.HASH_CHAR = "endif";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP5 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP5.text = "elif\\b";
        EOL_SPAN_REGEXP5.TYPE = "MARKUP";
        EOL_SPAN_REGEXP5.DELEGATE = "c::CONDITION";
        EOL_SPAN_REGEXP5.HASH_CHAR = "elif";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP6 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP6.text = "if\\b";
        EOL_SPAN_REGEXP6.TYPE = "MARKUP";
        EOL_SPAN_REGEXP6.DELEGATE = "c::CONDITION";
        EOL_SPAN_REGEXP6.HASH_CHAR = "if";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "c::LEX";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("MARKUP", new String[]{"ifdef", "ifndef", "else", "error", "line", "pragma", "undef", "warning", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.EOL_SPAN_REGEXP = new EOL_SPAN_REGEXP[] { EOL_SPAN_REGEXP1, EOL_SPAN_REGEXP2, EOL_SPAN_REGEXP3, EOL_SPAN_REGEXP4, EOL_SPAN_REGEXP5, EOL_SPAN_REGEXP6, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "DEFINE";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[0-9][0-9a-zA-Z]*";
        RULES1.IGNORE_CASE = "FALSE";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "#";
        SEQ1.TYPE = "OPERATOR";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "c::LEX";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "c::CORE";
        IMPORT IMPORT3 = new IMPORT();
        IMPORT3.DELEGATE = "CORE";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, IMPORT3, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
