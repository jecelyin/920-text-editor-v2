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
public class VelocityPureLang implements LangDefine {
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
        PROPERTY4.VALUE = "^\\s*(#(foreach|if|elseif|else|beanshell|macro))\\s*\\(.*\\)\\s*";
        PROPERTY4.NAME = "indentNextLines";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "^\\s*#(end|elseif|else)\\b.*";
        PROPERTY5.NAME = "unindentThisLine";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT3";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "#**";
        END END1 = new END();
        END1.text = "*#";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "COMMENT1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "#*";
        END END2 = new END();
        END2.text = "*#";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "##";
        EOL_SPAN1.TYPE = "COMMENT2";
        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "TRUE";
        SPAN3.TYPE = "LITERAL1";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "\"";
        END END3 = new END();
        END3.text = "\"";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.NO_LINE_BREAK = "TRUE";
        SPAN4.TYPE = "FUNCTION";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "${";
        END END4 = new END();
        END4.text = "}";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "\\$!?[A-z][A-z0-9._-]*";
        SEQ_REGEXP1.TYPE = "FUNCTION";
        SEQ_REGEXP1.HASH_CHAR = "$";
        SPAN SPAN5 = new SPAN();
        SPAN5.NO_LINE_BREAK = "FALSE";
        SPAN5.TYPE = "KEYWORD4";
        SPAN5.DELEGATE = "java::MAIN";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "#beanshell";
        END END5 = new END();
        END5.text = "#end";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"#prompt", "#yes_no", "#today", "#caret", "#buffermode", });
        KEYWORDS1.add("KEYWORD1", new String[]{"#set", "#parse", "#include", "#stop", });
        KEYWORDS1.add("KEYWORD2", new String[]{"_jeditIndentation", "_jeditSelection", "_jeditTab", "buffer", "textarea", "view", });
        KEYWORDS1.add("KEYWORD3", new String[]{"#if", "#else", "#elseif", "#foreach", "in", "#end", });
        KEYWORDS1.add("KEYWORD4", new String[]{"#macro", "#beanshell", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, };

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
