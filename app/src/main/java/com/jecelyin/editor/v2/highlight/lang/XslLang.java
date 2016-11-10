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
public class XslLang implements LangDefine {
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
        RULES1.HIGHLIGHT_DIGITS = "FALSE";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        SPAN1.DELEGATE = "TASKS";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<!--";
        END END1 = new END();
        END1.text = "-->";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "KEYWORD2";
        SPAN_REGEXP1.DELEGATE = "XSLTAGS";
        SPAN_REGEXP1.HASH_CHAR = "<";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<(?=xsl:)";
        END END2 = new END();
        END2.text = ">";
        SPAN_REGEXP1.END = new END[] { END2, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.TYPE = "KEYWORD2";
        SPAN_REGEXP2.DELEGATE = "XSLTAGS";
        SPAN_REGEXP2.HASH_CHAR = "<";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<(?=/xsl:)";
        END END3 = new END();
        END3.text = ">";
        SPAN_REGEXP2.END = new END[] { END3, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "KEYWORD2";
        SPAN2.DELEGATE = "xml::CDATA";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "<![CDATA[";
        END END4 = new END();
        END4.text = "]]>";
        SPAN2.END = new END[] { END4, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "KEYWORD2";
        SPAN3.DELEGATE = "xml::DTD-TAGS";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "<!";
        END END5 = new END();
        END5.text = ">";
        SPAN3.END = new END[] { END5, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN SPAN4 = new SPAN();
        SPAN4.NO_WORD_BREAK = "TRUE";
        SPAN4.TYPE = "LITERAL3";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "&";
        END END6 = new END();
        END6.text = ";";
        SPAN4.END = new END[] { END6, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "LITERAL3";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "<?";
        END END7 = new END();
        END7.text = "?>";
        SPAN5.END = new END[] { END7, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN7, };

        SPAN SPAN6 = new SPAN();
        SPAN6.TYPE = "MARKUP";
        SPAN6.DELEGATE = "TAGS";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "<";
        END END8 = new END();
        END8.text = ">";
        SPAN6.END = new END[] { END8, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN8, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "TASKS";
        RULES1.DEFAULT = "COMMENT1";
        RULES1.IGNORE_CASE = "FALSE";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("COMMENT4", new String[]{"DEBUG:", "DONE:", "FIXME:", "IDEA:", "NOTE:", "QUESTION:", "TODO:", "XXX", "???", });
        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "TAGS";
        RULES1.HIGHLIGHT_DIGITS = "FALSE";
        RULES1.DEFAULT = "MARKUP";
        RULES1.NO_WORD_SEP = ".-_:";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "AVT";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "MARKUP";
        SPAN2.DELEGATE = "AVT";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "xmlns:";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "xmlns";
        SEQ2.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = ":";
        MARK_PREVIOUS1.TYPE = "LABEL";
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "AVT";
        RULES1.HIGHLIGHT_DIGITS = "FALSE";
        RULES1.DEFAULT = "KEYWORD3";
        RULES1.NO_WORD_SEP = ".-_:";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "{{";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "}}";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "OPERATOR";
        SPAN1.DELEGATE = "XPATH";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "{";
        END END1 = new END();
        END1.text = "}";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_WORD_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL3";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "&";
        END END2 = new END();
        END2.text = ";";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "XSLTAGS";
        RULES1.HIGHLIGHT_DIGITS = "FALSE";
        RULES1.DEFAULT = "KEYWORD2";
        RULES1.NO_WORD_SEP = ".-_:";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "KEYWORD2";
        SPAN1.DELEGATE = "AVT";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "KEYWORD2";
        SPAN2.DELEGATE = "AVT";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "KEYWORD2";
        SPAN_REGEXP1.DELEGATE = "XPATH";
        SPAN_REGEXP1.HASH_CHAR = "count";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "count[\\p{Space}]*=[\\p{Space}]*\"";
        END END3 = new END();
        END3.text = "\"";
        SPAN_REGEXP1.END = new END[] { END3, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.TYPE = "KEYWORD2";
        SPAN_REGEXP2.DELEGATE = "XPATH";
        SPAN_REGEXP2.HASH_CHAR = "count";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "count[\\p{Space}]*=[\\p{Space}]*'";
        END END4 = new END();
        END4.text = "'";
        SPAN_REGEXP2.END = new END[] { END4, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN_REGEXP SPAN_REGEXP3 = new SPAN_REGEXP();
        SPAN_REGEXP3.TYPE = "KEYWORD2";
        SPAN_REGEXP3.DELEGATE = "XPATH";
        SPAN_REGEXP3.HASH_CHAR = "from";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "from[\\p{Space}]*=[\\p{Space}]*\"";
        END END5 = new END();
        END5.text = "\"";
        SPAN_REGEXP3.END = new END[] { END5, };

        SPAN_REGEXP3.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN_REGEXP SPAN_REGEXP4 = new SPAN_REGEXP();
        SPAN_REGEXP4.TYPE = "KEYWORD2";
        SPAN_REGEXP4.DELEGATE = "XPATH";
        SPAN_REGEXP4.HASH_CHAR = "from";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "from[\\p{Space}]*=[\\p{Space}]*'";
        END END6 = new END();
        END6.text = "'";
        SPAN_REGEXP4.END = new END[] { END6, };

        SPAN_REGEXP4.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN_REGEXP SPAN_REGEXP5 = new SPAN_REGEXP();
        SPAN_REGEXP5.TYPE = "KEYWORD2";
        SPAN_REGEXP5.DELEGATE = "XPATH";
        SPAN_REGEXP5.HASH_CHAR = "group-adjacent";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "group-adjacent[\\p{Space}]*=[\\p{Space}]*\"";
        END END7 = new END();
        END7.text = "\"";
        SPAN_REGEXP5.END = new END[] { END7, };

        SPAN_REGEXP5.BEGIN = new BEGIN[] { BEGIN7, };

        SPAN_REGEXP SPAN_REGEXP6 = new SPAN_REGEXP();
        SPAN_REGEXP6.TYPE = "KEYWORD2";
        SPAN_REGEXP6.DELEGATE = "XPATH";
        SPAN_REGEXP6.HASH_CHAR = "group-adjacent";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "group-adjacent[\\p{Space}]*=[\\p{Space}]*'";
        END END8 = new END();
        END8.text = "'";
        SPAN_REGEXP6.END = new END[] { END8, };

        SPAN_REGEXP6.BEGIN = new BEGIN[] { BEGIN8, };

        SPAN_REGEXP SPAN_REGEXP7 = new SPAN_REGEXP();
        SPAN_REGEXP7.TYPE = "KEYWORD2";
        SPAN_REGEXP7.DELEGATE = "XPATH";
        SPAN_REGEXP7.HASH_CHAR = "group-by";
        BEGIN BEGIN9 = new BEGIN();
        BEGIN9.text = "group-by[\\p{Space}]*=[\\p{Space}]*\"";
        END END9 = new END();
        END9.text = "\"";
        SPAN_REGEXP7.END = new END[] { END9, };

        SPAN_REGEXP7.BEGIN = new BEGIN[] { BEGIN9, };

        SPAN_REGEXP SPAN_REGEXP8 = new SPAN_REGEXP();
        SPAN_REGEXP8.TYPE = "KEYWORD2";
        SPAN_REGEXP8.DELEGATE = "XPATH";
        SPAN_REGEXP8.HASH_CHAR = "group-by";
        BEGIN BEGIN10 = new BEGIN();
        BEGIN10.text = "group-by[\\p{Space}]*=[\\p{Space}]*'";
        END END10 = new END();
        END10.text = "'";
        SPAN_REGEXP8.END = new END[] { END10, };

        SPAN_REGEXP8.BEGIN = new BEGIN[] { BEGIN10, };

        SPAN_REGEXP SPAN_REGEXP9 = new SPAN_REGEXP();
        SPAN_REGEXP9.TYPE = "KEYWORD2";
        SPAN_REGEXP9.DELEGATE = "XPATH";
        SPAN_REGEXP9.HASH_CHAR = "group-ending-with";
        BEGIN BEGIN11 = new BEGIN();
        BEGIN11.text = "group-ending-with[\\p{Space}]*=[\\p{Space}]*\"";
        END END11 = new END();
        END11.text = "\"";
        SPAN_REGEXP9.END = new END[] { END11, };

        SPAN_REGEXP9.BEGIN = new BEGIN[] { BEGIN11, };

        SPAN_REGEXP SPAN_REGEXP10 = new SPAN_REGEXP();
        SPAN_REGEXP10.TYPE = "KEYWORD2";
        SPAN_REGEXP10.DELEGATE = "XPATH";
        SPAN_REGEXP10.HASH_CHAR = "group-ending-with";
        BEGIN BEGIN12 = new BEGIN();
        BEGIN12.text = "group-ending-with[\\p{Space}]*=[\\p{Space}]*'";
        END END12 = new END();
        END12.text = "'";
        SPAN_REGEXP10.END = new END[] { END12, };

        SPAN_REGEXP10.BEGIN = new BEGIN[] { BEGIN12, };

        SPAN_REGEXP SPAN_REGEXP11 = new SPAN_REGEXP();
        SPAN_REGEXP11.TYPE = "KEYWORD2";
        SPAN_REGEXP11.DELEGATE = "XPATH";
        SPAN_REGEXP11.HASH_CHAR = "group-starting-with";
        BEGIN BEGIN13 = new BEGIN();
        BEGIN13.text = "group-starting-with[\\p{Space}]*=[\\p{Space}]*\"";
        END END13 = new END();
        END13.text = "\"";
        SPAN_REGEXP11.END = new END[] { END13, };

        SPAN_REGEXP11.BEGIN = new BEGIN[] { BEGIN13, };

        SPAN_REGEXP SPAN_REGEXP12 = new SPAN_REGEXP();
        SPAN_REGEXP12.TYPE = "KEYWORD2";
        SPAN_REGEXP12.DELEGATE = "XPATH";
        SPAN_REGEXP12.HASH_CHAR = "group-starting-with";
        BEGIN BEGIN14 = new BEGIN();
        BEGIN14.text = "group-starting-with[\\p{Space}]*=[\\p{Space}]*'";
        END END14 = new END();
        END14.text = "'";
        SPAN_REGEXP12.END = new END[] { END14, };

        SPAN_REGEXP12.BEGIN = new BEGIN[] { BEGIN14, };

        SPAN_REGEXP SPAN_REGEXP13 = new SPAN_REGEXP();
        SPAN_REGEXP13.TYPE = "KEYWORD2";
        SPAN_REGEXP13.DELEGATE = "XPATH";
        SPAN_REGEXP13.HASH_CHAR = "match";
        BEGIN BEGIN15 = new BEGIN();
        BEGIN15.text = "match[\\p{Space}]*=[\\p{Space}]*\"";
        END END15 = new END();
        END15.text = "\"";
        SPAN_REGEXP13.END = new END[] { END15, };

        SPAN_REGEXP13.BEGIN = new BEGIN[] { BEGIN15, };

        SPAN_REGEXP SPAN_REGEXP14 = new SPAN_REGEXP();
        SPAN_REGEXP14.TYPE = "KEYWORD2";
        SPAN_REGEXP14.DELEGATE = "XPATH";
        SPAN_REGEXP14.HASH_CHAR = "match";
        BEGIN BEGIN16 = new BEGIN();
        BEGIN16.text = "match[\\p{Space}]*=[\\p{Space}]*'";
        END END16 = new END();
        END16.text = "'";
        SPAN_REGEXP14.END = new END[] { END16, };

        SPAN_REGEXP14.BEGIN = new BEGIN[] { BEGIN16, };

        SPAN_REGEXP SPAN_REGEXP15 = new SPAN_REGEXP();
        SPAN_REGEXP15.TYPE = "KEYWORD2";
        SPAN_REGEXP15.DELEGATE = "XPATH";
        SPAN_REGEXP15.HASH_CHAR = "select";
        BEGIN BEGIN17 = new BEGIN();
        BEGIN17.text = "select[\\p{Space}]*=[\\p{Space}]*\"";
        END END17 = new END();
        END17.text = "\"";
        SPAN_REGEXP15.END = new END[] { END17, };

        SPAN_REGEXP15.BEGIN = new BEGIN[] { BEGIN17, };

        SPAN_REGEXP SPAN_REGEXP16 = new SPAN_REGEXP();
        SPAN_REGEXP16.TYPE = "KEYWORD2";
        SPAN_REGEXP16.DELEGATE = "XPATH";
        SPAN_REGEXP16.HASH_CHAR = "select";
        BEGIN BEGIN18 = new BEGIN();
        BEGIN18.text = "select[\\p{Space}]*=[\\p{Space}]*'";
        END END18 = new END();
        END18.text = "'";
        SPAN_REGEXP16.END = new END[] { END18, };

        SPAN_REGEXP16.BEGIN = new BEGIN[] { BEGIN18, };

        SPAN_REGEXP SPAN_REGEXP17 = new SPAN_REGEXP();
        SPAN_REGEXP17.TYPE = "KEYWORD2";
        SPAN_REGEXP17.DELEGATE = "XPATH";
        SPAN_REGEXP17.HASH_CHAR = "test";
        BEGIN BEGIN19 = new BEGIN();
        BEGIN19.text = "test[\\p{Space}]*=[\\p{Space}]*\"";
        END END19 = new END();
        END19.text = "\"";
        SPAN_REGEXP17.END = new END[] { END19, };

        SPAN_REGEXP17.BEGIN = new BEGIN[] { BEGIN19, };

        SPAN_REGEXP SPAN_REGEXP18 = new SPAN_REGEXP();
        SPAN_REGEXP18.TYPE = "KEYWORD2";
        SPAN_REGEXP18.DELEGATE = "XPATH";
        SPAN_REGEXP18.HASH_CHAR = "test";
        BEGIN BEGIN20 = new BEGIN();
        BEGIN20.text = "test[\\p{Space}]*=[\\p{Space}]*'";
        END END20 = new END();
        END20.text = "'";
        SPAN_REGEXP18.END = new END[] { END20, };

        SPAN_REGEXP18.BEGIN = new BEGIN[] { BEGIN20, };

        SPAN_REGEXP SPAN_REGEXP19 = new SPAN_REGEXP();
        SPAN_REGEXP19.TYPE = "KEYWORD2";
        SPAN_REGEXP19.DELEGATE = "XPATH";
        SPAN_REGEXP19.HASH_CHAR = "use";
        BEGIN BEGIN21 = new BEGIN();
        BEGIN21.text = "use[\\p{Space}]*=[\\p{Space}]*\"";
        END END21 = new END();
        END21.text = "\"";
        SPAN_REGEXP19.END = new END[] { END21, };

        SPAN_REGEXP19.BEGIN = new BEGIN[] { BEGIN21, };

        SPAN_REGEXP SPAN_REGEXP20 = new SPAN_REGEXP();
        SPAN_REGEXP20.TYPE = "KEYWORD2";
        SPAN_REGEXP20.DELEGATE = "XPATH";
        SPAN_REGEXP20.HASH_CHAR = "use";
        BEGIN BEGIN22 = new BEGIN();
        BEGIN22.text = "use[\\p{Space}]*=[\\p{Space}]*'";
        END END22 = new END();
        END22.text = "'";
        SPAN_REGEXP20.END = new END[] { END22, };

        SPAN_REGEXP20.BEGIN = new BEGIN[] { BEGIN22, };

        SPAN_REGEXP SPAN_REGEXP21 = new SPAN_REGEXP();
        SPAN_REGEXP21.TYPE = "KEYWORD2";
        SPAN_REGEXP21.DELEGATE = "XPATH";
        SPAN_REGEXP21.HASH_CHAR = "value";
        BEGIN BEGIN23 = new BEGIN();
        BEGIN23.text = "value[\\p{Space}]*=[\\p{Space}]*\"";
        END END23 = new END();
        END23.text = "\"";
        SPAN_REGEXP21.END = new END[] { END23, };

        SPAN_REGEXP21.BEGIN = new BEGIN[] { BEGIN23, };

        SPAN_REGEXP SPAN_REGEXP22 = new SPAN_REGEXP();
        SPAN_REGEXP22.TYPE = "KEYWORD2";
        SPAN_REGEXP22.DELEGATE = "XPATH";
        SPAN_REGEXP22.HASH_CHAR = "select";
        BEGIN BEGIN24 = new BEGIN();
        BEGIN24.text = "select[\\p{Space}]*=[\\p{Space}]*'";
        END END24 = new END();
        END24.text = "'";
        SPAN_REGEXP22.END = new END[] { END24, };

        SPAN_REGEXP22.BEGIN = new BEGIN[] { BEGIN24, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "xmlns:";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "xmlns";
        SEQ2.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = ":";
        MARK_PREVIOUS1.TYPE = "LABEL";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"analyze-string", "apply-imports", "apply-templates", "attribute", "attribute-set", "call-template", "character-map", "choose", "comment", "copy", "copy-of", "decimal-format", "document", "element", "fallback", "for-each", "for-each-group", "function", "if", "import", "import-schema", "include", "key", "matching-substring", "message", "namespace", "namespace-alias", "next-match", "non-matching-substring", "number", "otherwise", "output", "output-character", "param", "perform-sort", "preserve-space", "processing-instruction", "result-document", "sequence", "sort", "strip-space", "stylesheet", "template", "text", "transform", "value-of", "variable", "when", "with-param", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, SPAN_REGEXP3, SPAN_REGEXP4, SPAN_REGEXP5, SPAN_REGEXP6, SPAN_REGEXP7, SPAN_REGEXP8, SPAN_REGEXP9, SPAN_REGEXP10, SPAN_REGEXP11, SPAN_REGEXP12, SPAN_REGEXP13, SPAN_REGEXP14, SPAN_REGEXP15, SPAN_REGEXP16, SPAN_REGEXP17, SPAN_REGEXP18, SPAN_REGEXP19, SPAN_REGEXP20, SPAN_REGEXP21, SPAN_REGEXP22, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES6() {
        RULES RULES1 = new RULES();
        RULES1.SET = "XPATH";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DEFAULT = "KEYWORD3";
        RULES1.DIGIT_RE = "[\\p{Digit}]+([\\p{Punct}][\\p{Digit}]+)?";
        RULES1.NO_WORD_SEP = ".-_";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "COMMENT2";
        SPAN3.DELEGATE = "XPATHCOMMENT2";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "(:";
        END END3 = new END();
        END3.text = ":)";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "::";
        MARK_PREVIOUS1.TYPE = "KEYWORD4";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "@";
        SEQ1.TYPE = "KEYWORD4";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "=";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "!=";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = ">";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "&gt;";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "&lt;";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "?";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "+";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "*";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "/";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "|";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = ",";
        SEQ12.TYPE = "OPERATOR";
        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "OPERATOR";
        SPAN4.DELEGATE = "XPATH";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "[";
        END END4 = new END();
        END4.text = "]";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.NO_WORD_BREAK = "TRUE";
        SPAN5.TYPE = "LITERAL3";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "&";
        END END5 = new END();
        END5.text = ";";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = ":";
        MARK_PREVIOUS2.TYPE = "LABEL";
        MARK_PREVIOUS MARK_PREVIOUS3 = new MARK_PREVIOUS();
        MARK_PREVIOUS3.text = "(";
        MARK_PREVIOUS3.TYPE = "FUNCTION";
        MARK_PREVIOUS3.MATCH_TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = ")";
        SEQ13.TYPE = "OPERATOR";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "$";
        MARK_FOLLOWING1.TYPE = "LITERAL2";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"and", "as", "castable", "div", "else", "eq", "every", "except", "for", "ge", "gt", "idiv", "if", "in", "instance", "intersect", "is", "isnot", "le", "lt", "mod", "nillable", "ne", "of", "or", "return", "satisfies", "some", "then", "to", "treat", "union", "-", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, MARK_PREVIOUS3, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES7() {
        RULES RULES1 = new RULES();
        RULES1.SET = "XPATHCOMMENT2";
        RULES1.DEFAULT = "COMMENT2";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT3";
        SPAN1.DELEGATE = "XPATHCOMMENT3";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "(:";
        END END1 = new END();
        END1.text = ":)";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES8() {
        RULES RULES1 = new RULES();
        RULES1.SET = "XPATHCOMMENT3";
        RULES1.DEFAULT = "COMMENT3";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT2";
        SPAN1.DELEGATE = "XPATHCOMMENT2";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "(:";
        END END1 = new END();
        END1.text = ":)";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), RULES6(), RULES7(), RULES8(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
