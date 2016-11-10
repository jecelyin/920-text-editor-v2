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
public class SgmlLang implements LangDefine {
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
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<!--";
        END END1 = new END();
        END1.text = "-->";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "KEYWORD2";
        SPAN2.DELEGATE = "xml::ENTITY-TAGS";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<!ENTITY";
        END END2 = new END();
        END2.text = ">";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "KEYWORD2";
        SPAN3.DELEGATE = "xml::CDATA";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<![CDATA[";
        END END3 = new END();
        END3.text = "]]>";
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
        SPAN5.DELEGATE = "xml::TAGS";
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

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
