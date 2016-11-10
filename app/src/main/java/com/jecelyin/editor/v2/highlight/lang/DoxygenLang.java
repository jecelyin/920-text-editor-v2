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
public class DoxygenLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "#";
        PROPERTY1.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "FALSE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "COMMENT1";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "=";
        MARK_PREVIOUS1.TYPE = "KEYWORD1";
        MARK_PREVIOUS1.AT_LINE_START = "TRUE";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = "+=";
        MARK_PREVIOUS2.TYPE = "KEYWORD1";
        MARK_PREVIOUS2.AT_LINE_START = "TRUE";
        MARK_PREVIOUS2.MATCH_TYPE = "OPERATOR";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "TRUE";
        SPAN3.TYPE = "LITERAL1";
        SPAN3.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "`";
        END END3 = new END();
        END3.text = "`";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD2", new String[]{"YES", });
        KEYWORDS1.add("KEYWORD3", new String[]{"NO", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "DOXYGEN";
        RULES1.DEFAULT = "COMMENT3";
        RULES1.IGNORE_CASE = "TRUE";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "*";
        SEQ1.TYPE = "COMMENT3";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "COMMENT1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<!--";
        END END2 = new END();
        END2.text = "-->";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ2 = new SEQ();
        SEQ2.text = "<<";
        SEQ2.TYPE = "COMMENT3";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "<=";
        SEQ3.TYPE = "COMMENT3";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "<";
        SEQ4.TYPE = "COMMENT3";
        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "TRUE";
        SPAN3.TYPE = "MARKUP";
        SPAN3.DELEGATE = "xml::TAGS";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<";
        END END3 = new END();
        END3.text = ">";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LABEL", new String[]{"\\a", "\\addindex", "\\addtogroup", "\\anchor", "\\arg", "\\attention", "\\author", "\\b", "\\brief", "\\bug", "\\c", "\\callgraph", "\\callergraph", "\\category", "\\class", "\\code", "\\cond", "\\copybrief", "\\copydetails", "\\copydoc", "\\date", "\\def", "\\defgroup", "\\deprecated", "\\details", "\\dir", "\\dontinclude", "\\dot", "\\dotfile", "\\e", "\\else", "\\elseif", "\\em", "\\endcode", "\\endcond", "\\enddot", "\\endhtmlonly", "\\endif", "\\endlatexonly", "\\endlink", "\\endmanonly", "\\endmsc", "\\endverbatim", "\\endxmlonly", "\\enum", "\\example", "\\exception", "\\extends", "\\f$", "\\f[", "\\f]", "\\f{", "\\f}", "\\file", "\\fn", "\\headerfile", "\\hideinitializer", "\\htmlinclude", "\\htmlonly", "\\if", "\\ifnot", "\\image", "\\implements", "\\include", "\\includelineno", "\\ingroup", "\\internal", "\\invariant", "\\interface", "\\latexonly", "\\li", "\\line", "\\link", "\\mainpage", "\\manonly", "\\memberof", "\\msc", "\\n", "\\name", "\\namespace", "\\nosubgrouping", "\\note", "\\overload", "\\p", "\\package", "\\page", "\\par", "\\paragraph", "\\param", "\\param[in]", "\\param[out]", "\\param[in,out]", "\\post", "\\pre", "\\private", "\\privatesection", "\\property", "\\protected", "\\protectedsection", "\\protocol", "\\public", "\\publicsection", "\\ref", "\\relates", "\\relatesalso", "\\remarks", "\\return", "\\retval", "\\sa", "\\section", "\\see", "\\showinitializer", "\\since", "\\skip", "\\skipline", "\\struct", "\\subpage", "\\subsection", "\\subsubsection", "\\test", "\\throw", "\\todo", "\\tparam", "\\typedef", "\\union", "\\until", "\\var", "\\verbatim", "\\verbinclude", "\\version", "\\warning", "\\weakgroup", "\\xmlonly", "\\xrefitem", "\\$", "\\@", "\\\\", "\\&", "\\~", "\\<", "\\>", "\\#", "\\%", "\\\"", "@a", "@addindex", "@addtogroup", "@anchor", "@arg", "@attention", "@author", "@b", "@brief", "@bug", "@c", "@callgraph", "@callergraph", "@category", "@class", "@code", "@cond", "@copybrief", "@copydetails", "@copydoc", "@date", "@def", "@defgroup", "@deprecated", "@details", "@dir", "@dontinclude", "@dot", "@dotfile", "@e", "@else", "@elseif", "@em", "@endcode", "@endcond", "@enddot", "@endhtmlonly", "@endif", "@endlatexonly", "@endlink", "@endmanonly", "@endmsc", "@endverbatim", "@endxmlonly", "@enum", "@example", "@exception", "@extends", "@f$", "@f[", "@f]", "@f{", "@f}", "@file", "@fn", "@headerfile", "@hideinitializer", "@htmlinclude", "@htmlonly", "@if", "@ifnot", "@image", "@implements", "@include", "@includelineno", "@ingroup", "@internal", "@invariant", "@interface", "@latexonly", "@li", "@line", "@link", "@mainpage", "@manonly", "@memberof", "@msc", "@n", "@name", "@namespace", "@nosubgrouping", "@note", "@overload", "@p", "@package", "@page", "@par", "@paragraph", "@param", "@param[in]", "@param[out]", "@param[in,out]", "@post", "@pre", "@private", "@privatesection", "@property", "@protected", "@protectedsection", "@protocol", "@public", "@publicsection", "@ref", "@relates", "@relatesalso", "@remarks", "@return", "@retval", "@sa", "@section", "@see", "@showinitializer", "@since", "@skip", "@skipline", "@struct", "@subpage", "@subsection", "@subsubsection", "@test", "@throw", "@todo", "@tparam", "@typedef", "@union", "@until", "@var", "@verbatim", "@verbinclude", "@version", "@warning", "@weakgroup", "@xmlonly", "@xrefitem", "@$", "@@", "@\\", "@&", "@~", "@<", "@>", "@#", "@%", });
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
