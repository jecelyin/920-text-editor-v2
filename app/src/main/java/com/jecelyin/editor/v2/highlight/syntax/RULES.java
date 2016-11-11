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

package com.jecelyin.editor.v2.highlight.syntax;

import com.jecelyin.editor.v2.highlight.XMLElement;

import java.util.HashMap;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class RULES implements XMLElement {
    public String ESCAPE;
    public String IGNORE_CASE;
    public String HIGHLIGHT_DIGITS;
    public String SET;
    public String DEFAULT;
    public String NO_WORD_SEP;
    public String DIGIT_RE;

    public SPAN[] SPAN;
    public MARK_PREVIOUS[] MARK_PREVIOUS;
    public EOL_SPAN[] EOL_SPAN;
    public SEQ[] SEQ;
    public KEYWORDS[] KEYWORDS;
    public SPAN_REGEXP[] SPAN_REGEXP;
    public SEQ_REGEXP[] SEQ_REGEXP;
    public IMPORT[] IMPORT;
    public MARK_FOLLOWING[] MARK_FOLLOWING;
    public EOL_SPAN_REGEXP[] EOL_SPAN_REGEXP;
    public PROPS[] PROPS;
    //WHITESPACE
    public TERMINATE[] TERMINATE;

    @Override
    public String tag() {
        return "RULES";
    }

    @Override
    public String text() {
        return null;
    }

    @Override
    public HashMap<String, String> attrs() {
        return null;
    }

    @Override
    public XMLElement[][] children() {
        return new XMLElement[][]{SPAN, MARK_PREVIOUS, EOL_SPAN, SEQ, SPAN_REGEXP, SEQ_REGEXP,
                IMPORT, MARK_FOLLOWING, EOL_SPAN_REGEXP, PROPS, TERMINATE};
    }
}
