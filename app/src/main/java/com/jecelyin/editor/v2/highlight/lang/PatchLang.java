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
public class PatchLang implements LangDefine {
        private RULES RULES1() {
        RULES RULES1 = new RULES();
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "+++";
        EOL_SPAN1.TYPE = "LABEL";
        EOL_SPAN1.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "---";
        EOL_SPAN2.TYPE = "COMMENT1";
        EOL_SPAN2.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN3 = new EOL_SPAN();
        EOL_SPAN3.text = "Index:";
        EOL_SPAN3.TYPE = "KEYWORD3";
        EOL_SPAN3.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN4 = new EOL_SPAN();
        EOL_SPAN4.text = "+";
        EOL_SPAN4.TYPE = "LABEL";
        EOL_SPAN4.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN5 = new EOL_SPAN();
        EOL_SPAN5.text = ">";
        EOL_SPAN5.TYPE = "LABEL";
        EOL_SPAN5.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN6 = new EOL_SPAN();
        EOL_SPAN6.text = "-";
        EOL_SPAN6.TYPE = "COMMENT1";
        EOL_SPAN6.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN7 = new EOL_SPAN();
        EOL_SPAN7.text = "<";
        EOL_SPAN7.TYPE = "COMMENT1";
        EOL_SPAN7.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN8 = new EOL_SPAN();
        EOL_SPAN8.text = "!";
        EOL_SPAN8.TYPE = "LITERAL3";
        EOL_SPAN8.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN9 = new EOL_SPAN();
        EOL_SPAN9.text = "@@";
        EOL_SPAN9.TYPE = "LITERAL2";
        EOL_SPAN9.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN10 = new EOL_SPAN();
        EOL_SPAN10.text = "*";
        EOL_SPAN10.TYPE = "LABEL";
        EOL_SPAN10.AT_LINE_START = "TRUE";
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, EOL_SPAN3, EOL_SPAN4, EOL_SPAN5, EOL_SPAN6, EOL_SPAN7, EOL_SPAN8, EOL_SPAN9, EOL_SPAN10, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), };
    }


}
