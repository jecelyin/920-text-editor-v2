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
public class OutlineLang implements LangDefine {
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
        PROPERTY4.VALUE = "true";
        PROPERTY4.NAME = "contextInsensitive";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP1 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP1.text = "^\\s{12}";
        EOL_SPAN_REGEXP1.TYPE = "COMMENT4";
        EOL_SPAN_REGEXP1.AT_LINE_START = "TRUE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP2 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP2.text = "^\\s{11}";
        EOL_SPAN_REGEXP2.TYPE = "COMMENT3";
        EOL_SPAN_REGEXP2.AT_LINE_START = "TRUE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP3 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP3.text = "^\\s{10}";
        EOL_SPAN_REGEXP3.TYPE = "COMMENT2";
        EOL_SPAN_REGEXP3.AT_LINE_START = "TRUE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP4 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP4.text = "^\\s{9}";
        EOL_SPAN_REGEXP4.TYPE = "COMMENT1";
        EOL_SPAN_REGEXP4.AT_LINE_START = "TRUE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP5 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP5.text = "^\\s{8}";
        EOL_SPAN_REGEXP5.TYPE = "LITERAL4";
        EOL_SPAN_REGEXP5.AT_LINE_START = "TRUE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP6 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP6.text = "^\\s{7}";
        EOL_SPAN_REGEXP6.TYPE = "LITERAL3";
        EOL_SPAN_REGEXP6.AT_LINE_START = "TRUE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP7 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP7.text = "^\\s{6}";
        EOL_SPAN_REGEXP7.TYPE = "LITERAL2";
        EOL_SPAN_REGEXP7.AT_LINE_START = "TRUE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP8 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP8.text = "^\\s{5}";
        EOL_SPAN_REGEXP8.TYPE = "LITERAL1";
        EOL_SPAN_REGEXP8.AT_LINE_START = "TRUE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP9 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP9.text = "^\\s{4}";
        EOL_SPAN_REGEXP9.TYPE = "KEYWORD4";
        EOL_SPAN_REGEXP9.AT_LINE_START = "TRUE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP10 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP10.text = "^\\s{3}";
        EOL_SPAN_REGEXP10.TYPE = "KEYWORD3";
        EOL_SPAN_REGEXP10.AT_LINE_START = "TRUE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP11 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP11.text = "^\\s{2}";
        EOL_SPAN_REGEXP11.TYPE = "KEYWORD2";
        EOL_SPAN_REGEXP11.AT_LINE_START = "TRUE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP12 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP12.text = "^\\s{1}";
        EOL_SPAN_REGEXP12.TYPE = "KEYWORD1";
        EOL_SPAN_REGEXP12.AT_LINE_START = "TRUE";
        EOL_SPAN_REGEXP EOL_SPAN_REGEXP13 = new EOL_SPAN_REGEXP();
        EOL_SPAN_REGEXP13.text = "^\\s{0}";
        EOL_SPAN_REGEXP13.TYPE = "LABEL";
        EOL_SPAN_REGEXP13.AT_LINE_START = "TRUE";
        RULES1.EOL_SPAN_REGEXP = new EOL_SPAN_REGEXP[] { EOL_SPAN_REGEXP1, EOL_SPAN_REGEXP2, EOL_SPAN_REGEXP3, EOL_SPAN_REGEXP4, EOL_SPAN_REGEXP5, EOL_SPAN_REGEXP6, EOL_SPAN_REGEXP7, EOL_SPAN_REGEXP8, EOL_SPAN_REGEXP9, EOL_SPAN_REGEXP10, EOL_SPAN_REGEXP11, EOL_SPAN_REGEXP12, EOL_SPAN_REGEXP13, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
