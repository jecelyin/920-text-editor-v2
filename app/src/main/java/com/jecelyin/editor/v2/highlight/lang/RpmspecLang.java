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
public class RpmspecLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "#";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "true";
        PROPERTY2.NAME = "contextInsensitive";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN1.AT_LINE_START = "TRUE";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "<";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ">";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "=";
        SEQ3.TYPE = "OPERATOR";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "ATTR";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "%attr(";
        END END1 = new END();
        END1.text = ")";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "MARKUP";
        SPAN2.DELEGATE = "VERIFY";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "%verify(";
        END END2 = new END();
        END2.text = ")";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "Source";
        MARK_FOLLOWING1.TYPE = "KEYWORD1";
        MARK_FOLLOWING1.AT_LINE_START = "TRUE";
        MARK_FOLLOWING MARK_FOLLOWING2 = new MARK_FOLLOWING();
        MARK_FOLLOWING2.text = "Patch";
        MARK_FOLLOWING2.TYPE = "KEYWORD1";
        MARK_FOLLOWING2.AT_LINE_START = "TRUE";
        MARK_FOLLOWING MARK_FOLLOWING3 = new MARK_FOLLOWING();
        MARK_FOLLOWING3.text = "%patch";
        MARK_FOLLOWING3.TYPE = "FUNCTION";
        MARK_FOLLOWING3.AT_LINE_START = "TRUE";
        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "TRUE";
        SPAN3.TYPE = "KEYWORD2";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "${";
        END END3 = new END();
        END3.text = "}";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.NO_LINE_BREAK = "TRUE";
        SPAN4.TYPE = "KEYWORD3";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "%{";
        END END4 = new END();
        END4.text = "}";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        MARK_FOLLOWING MARK_FOLLOWING4 = new MARK_FOLLOWING();
        MARK_FOLLOWING4.text = "$#";
        MARK_FOLLOWING4.TYPE = "KEYWORD2";
        MARK_FOLLOWING MARK_FOLLOWING5 = new MARK_FOLLOWING();
        MARK_FOLLOWING5.text = "$?";
        MARK_FOLLOWING5.TYPE = "KEYWORD2";
        MARK_FOLLOWING MARK_FOLLOWING6 = new MARK_FOLLOWING();
        MARK_FOLLOWING6.text = "$*";
        MARK_FOLLOWING6.TYPE = "KEYWORD2";
        MARK_FOLLOWING MARK_FOLLOWING7 = new MARK_FOLLOWING();
        MARK_FOLLOWING7.text = "$<";
        MARK_FOLLOWING7.TYPE = "KEYWORD2";
        MARK_FOLLOWING MARK_FOLLOWING8 = new MARK_FOLLOWING();
        MARK_FOLLOWING8.text = "$";
        MARK_FOLLOWING8.TYPE = "KEYWORD2";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("MARKUP", new String[]{"%doc", "%config", "%docdir", "%dir", "%package", });
        KEYWORDS1.add("LABEL", new String[]{"%prep", "%install", "%description", "%build", "%files", "%clean", "%pre", "%post", "%preun", "%postun", "%verifyscript", });
        KEYWORDS1.add("KEYWORD1", new String[]{"Summary:", "Name:", "Version:", "Release:", "Copyright:", "Group:", "URL:", "Packager:", "Prefix:", "Distribution:", "Vendor:", "Icon:", "Provides:", "Requires:", "Serial:", "Conflicts:", "AutoReqProv:", "BuildArch:", "ExcludeArch:", "ExclusiveArch:", "ExclusiveOS:", "BuildRoot:", "NoSource:", "NoPatch:", });
        KEYWORDS1.add("FUNCTION", new String[]{"%setup", "%ifarch", "%ifnarch", "%ifos", "%ifnos", "%else", "%endif", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, MARK_FOLLOWING2, MARK_FOLLOWING3, MARK_FOLLOWING4, MARK_FOLLOWING5, MARK_FOLLOWING6, MARK_FOLLOWING7, MARK_FOLLOWING8, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "ATTR";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ",";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "-";
        SEQ2.TYPE = "OPERATOR";
        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "VERIFY";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"not", });
        KEYWORDS1.add("KEYWORD2", new String[]{"owner", "group", "mode", "md5", "size", "maj", "min", "symlink", "mtime", });
        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
