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
public class RtfLang implements LangDefine {
        private RULES RULES1() {
        RULES RULES1 = new RULES();
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "{";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "}";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "\\\\'\\w\\d";
        SEQ_REGEXP1.TYPE = "LITERAL2";
        SEQ_REGEXP1.ESCAPE = "\\\\";
        SEQ_REGEXP1.HASH_CHAR = "\\'";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "\\*\\";
        MARK_FOLLOWING1.TYPE = "KEYWORD2";
        MARK_FOLLOWING MARK_FOLLOWING2 = new MARK_FOLLOWING();
        MARK_FOLLOWING2.text = "\\";
        MARK_FOLLOWING2.TYPE = "KEYWORD1";
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, MARK_FOLLOWING2, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {};
    }


}
