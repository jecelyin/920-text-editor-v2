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
public class PhpLang implements LangDefine {
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
        PROPERTY9.VALUE = "\\s*(((if|while|else\\s*(if)?|for(each)?|switch|declare)\\s*\\(.*\\)[^{:;]*)|(do\\s*[^\\({:;]*))";
        PROPERTY9.NAME = "indentNextLine";
        PROPERTY PROPERTY10 = new PROPERTY();
        PROPERTY10.VALUE = "true";
        PROPERTY10.NAME = "lineUpClosingBracket";
        PROPERTY PROPERTY11 = new PROPERTY();
        PROPERTY11.VALUE = "^.*(default:\\s*|case.*:.*)$";
        PROPERTY11.NAME = "unindentThisLine";
        PROPERTY PROPERTY12 = new PROPERTY();
        PROPERTY12.VALUE = ":";
        PROPERTY12.NAME = "electricKeys";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, PROPERTY8, PROPERTY9, PROPERTY10, PROPERTY11, PROPERTY12, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.IGNORE_CASE = "TRUE";
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "<!--";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "-->";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "";
        PROPERTY3.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, };

        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "PHP";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<?php";
        END END1 = new END();
        END1.text = "?>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "MARKUP";
        SPAN2.DELEGATE = "PHP";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<?";
        END END2 = new END();
        END2.text = "?>";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "MARKUP";
        SPAN3.DELEGATE = "PHP";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<?=";
        END END3 = new END();
        END3.text = "?>";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "MARKUP";
        SPAN4.DELEGATE = "PHP";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "<%";
        END END4 = new END();
        END4.text = "%>";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "MARKUP";
        SPAN5.DELEGATE = "PHP";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "<%=";
        END END5 = new END();
        END5.text = "%>";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "MARKUP";
        SPAN_REGEXP1.DELEGATE = "PHP";
        SPAN_REGEXP1.HASH_CHAR = "<SCRIPT";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "<SCRIPT\\s+LANGUAGE=\"?PHP\"?>";
        END END6 = new END();
        END6.text = "</SCRIPT>";
        SPAN_REGEXP1.END = new END[] { END6, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN6 = new SPAN();
        SPAN6.TYPE = "COMMENT1";
        SPAN6.DELEGATE = "COMMENT1+PHP";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "<!--";
        END END7 = new END();
        END7.text = "-->";
        SPAN6.END = new END[] { END7, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN7, };

        SPAN SPAN7 = new SPAN();
        SPAN7.TYPE = "MARKUP";
        SPAN7.DELEGATE = "JAVASCRIPT_OPENTAG";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "<SCRIPT";
        END END8 = new END();
        END8.text = "</SCRIPT>";
        SPAN7.END = new END[] { END8, };

        SPAN7.BEGIN = new BEGIN[] { BEGIN8, };

        SPAN SPAN8 = new SPAN();
        SPAN8.TYPE = "MARKUP";
        SPAN8.DELEGATE = "CSS_OPENTAG";
        BEGIN BEGIN9 = new BEGIN();
        BEGIN9.text = "<STYLE";
        END END9 = new END();
        END9.text = "</STYLE>";
        SPAN8.END = new END[] { END9, };

        SPAN8.BEGIN = new BEGIN[] { BEGIN9, };

        SPAN SPAN9 = new SPAN();
        SPAN9.TYPE = "LABEL";
        SPAN9.DELEGATE = "MAIN";
        BEGIN BEGIN10 = new BEGIN();
        BEGIN10.text = "<![CDATA[";
        END END10 = new END();
        END10.text = "]]>";
        SPAN9.END = new END[] { END10, };

        SPAN9.BEGIN = new BEGIN[] { BEGIN10, };

        SPAN SPAN10 = new SPAN();
        SPAN10.TYPE = "MARKUP";
        SPAN10.DELEGATE = "xml::DTD-TAGS";
        BEGIN BEGIN11 = new BEGIN();
        BEGIN11.text = "<!";
        END END11 = new END();
        END11.text = ">";
        SPAN10.END = new END[] { END11, };

        SPAN10.BEGIN = new BEGIN[] { BEGIN11, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "</?\\w+";
        SEQ_REGEXP1.TYPE = "MARKUP";
        SEQ_REGEXP1.DELEGATE = "TAGS";
        SEQ_REGEXP1.HASH_CHAR = "<";
        SPAN SPAN11 = new SPAN();
        SPAN11.NO_WORD_BREAK = "TRUE";
        SPAN11.TYPE = "LITERAL2";
        BEGIN BEGIN12 = new BEGIN();
        BEGIN12.text = "&";
        END END12 = new END();
        END12.text = ";";
        SPAN11.END = new END[] { END12, };

        SPAN11.BEGIN = new BEGIN[] { BEGIN12, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, SPAN7, SPAN8, SPAN9, SPAN10, SPAN11, };

        RULES1.PROPS = new PROPS[] { PROPS1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "TAGS";
        RULES1.DEFAULT = "MARKUP";
        RULES1.ESCAPE = "\\";
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "<!--";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "-->";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "";
        PROPERTY3.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "MAIN";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TO_LITERAL+PHP";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "TO_PHP";
        IMPORT IMPORT3 = new IMPORT();
        IMPORT3.DELEGATE = "INVALID_LT";
        IMPORT IMPORT4 = new IMPORT();
        IMPORT4.DELEGATE = "html::TAGS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, IMPORT3, IMPORT4, };

        RULES1.PROPS = new PROPS[] { PROPS1, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CSS_OPENTAG";
        RULES1.DEFAULT = "MARKUP";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "CSS";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TO_LITERAL+PHP";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CSS";
        RULES1.DEFAULT = "MARKUP";
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "";
        PROPERTY1.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, };

        SPAN SPAN1 = new SPAN();
        SPAN1.DELEGATE = "CSS";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "(";
        END END1 = new END();
        END1.text = ")";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TO_PHP";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "css::MAIN";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.PROPS = new PROPS[] { PROPS1, };

        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "OBJECT_PHP";
        RULES1.DEFAULT = "KEYWORD4";
        RULES1.ESCAPE = "\\";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "OPERATOR";
        SPAN1.DELEGATE = "PHP_EXPRESSION";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "[";
        END END1 = new END();
        END1.text = "]";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "OPERATOR";
        SPAN2.DELEGATE = "PHP_EXPRESSION";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "(";
        END END2 = new END();
        END2.text = ")";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "KEYWORD4";
        SPAN_REGEXP1.DELEGATE = "PHP_EXPRESSION";
        SPAN_REGEXP1.HASH_CHAR = "->";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "->\\s*\\{";
        END END3 = new END();
        END3.text = "}";
        SPAN_REGEXP1.END = new END[] { END3, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN3, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "->\\s*\\w+\\s*(?=\\()";
        SEQ_REGEXP1.TYPE = "FUNCTION";
        SEQ_REGEXP1.DELEGATE = "OBJECT_PHP";
        SEQ_REGEXP1.HASH_CHAR = "->";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "->\\w*";
        SEQ_REGEXP2.TYPE = "KEYWORD4";
        SEQ_REGEXP2.DELEGATE = "OBJECT_PHP";
        SEQ_REGEXP2.HASH_CHAR = "->";
        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "COMMENT1";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "/*";
        END END4 = new END();
        END4.text = "*/";
        SPAN3.END = new END[] { END4, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN4, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "//";
        EOL_SPAN1.TYPE = "COMMENT2";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "#";
        EOL_SPAN2.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "\\s";
        SEQ_REGEXP3.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "!";
        SEQ1.TYPE = "OPERATOR";
        SEQ1.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "%";
        SEQ2.TYPE = "OPERATOR";
        SEQ2.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "&";
        SEQ3.TYPE = "OPERATOR";
        SEQ3.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = ">";
        SEQ4.TYPE = "OPERATOR";
        SEQ4.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "<";
        SEQ5.TYPE = "OPERATOR";
        SEQ5.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "*";
        SEQ6.TYPE = "OPERATOR";
        SEQ6.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "/";
        SEQ7.TYPE = "OPERATOR";
        SEQ7.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "+";
        SEQ8.TYPE = "OPERATOR";
        SEQ8.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = ",";
        SEQ9.TYPE = "OPERATOR";
        SEQ9.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "-";
        SEQ10.TYPE = "OPERATOR";
        SEQ10.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = ".";
        SEQ11.TYPE = "OPERATOR";
        SEQ11.DELEGATE = "PHP_EXPRESSION";
        SEQ_REGEXP SEQ_REGEXP4 = new SEQ_REGEXP();
        SEQ_REGEXP4.text = "/(?!/)";
        SEQ_REGEXP4.TYPE = "OPERATOR";
        SEQ_REGEXP4.DELEGATE = "PHP_EXPRESSION";
        SEQ_REGEXP4.HASH_CHAR = "/";
        SEQ_REGEXP SEQ_REGEXP5 = new SEQ_REGEXP();
        SEQ_REGEXP5.text = ":(?!:)";
        SEQ_REGEXP5.TYPE = "OPERATOR";
        SEQ_REGEXP5.DELEGATE = "PHP_EXPRESSION";
        SEQ_REGEXP5.HASH_CHAR = ":";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = ";";
        SEQ12.TYPE = "OPERATOR";
        SEQ12.DELEGATE = "PHP";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "=";
        SEQ13.TYPE = "OPERATOR";
        SEQ13.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "?";
        SEQ14.TYPE = "OPERATOR";
        SEQ14.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "@";
        SEQ15.TYPE = "OPERATOR";
        SEQ15.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "[";
        SEQ16.TYPE = "OPERATOR";
        SEQ16.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "]";
        SEQ17.TYPE = "OPERATOR";
        SEQ17.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "^";
        SEQ18.TYPE = "OPERATOR";
        SEQ18.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "`";
        SEQ19.TYPE = "OPERATOR";
        SEQ19.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "{";
        SEQ20.TYPE = "OPERATOR";
        SEQ20.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "|";
        SEQ21.TYPE = "OPERATOR";
        SEQ21.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "}";
        SEQ22.TYPE = "OPERATOR";
        SEQ22.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "~";
        SEQ23.TYPE = "OPERATOR";
        SEQ23.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "\\";
        SEQ24.TYPE = "OPERATOR";
        SEQ24.DELEGATE = "PHP_EXPRESSION";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "PHP_EXPRESSION";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "PHP_VAR";
        IMPORT IMPORT3 = new IMPORT();
        IMPORT3.DELEGATE = "PHP_KEYWORDS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, IMPORT3, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, SEQ_REGEXP4, SEQ_REGEXP5, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, };

        return RULES1;
    }

    private RULES RULES6() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PHP_LITERAL2";
        RULES1.DEFAULT = "LITERAL2";
        RULES1.ESCAPE = "\\";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "LITERAL2";
        SPAN_REGEXP1.DELEGATE = "OBJECT_PHP";
        SPAN_REGEXP1.HASH_CHAR = "{";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\\{(?=\\$)";
        END END1 = new END();
        END1.text = "}";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[\\$]+\\{[a-zA-Z_\\x7f-\\xff][a-zA-Z0-9_\\x7f-\\xff]*\\}";
        SEQ_REGEXP1.TYPE = "KEYWORD3";
        SEQ_REGEXP1.HASH_CHAR = "$";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "PHP_VAR";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, };

        return RULES1;
    }

    private RULES RULES7() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PHP_LITERAL3";
        RULES1.DEFAULT = "LITERAL3";
        RULES1.ESCAPE = "\\";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "LITERAL3";
        SPAN_REGEXP1.DELEGATE = "OBJECT_PHP";
        SPAN_REGEXP1.HASH_CHAR = "{";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\\{(?=\\$)";
        END END1 = new END();
        END1.text = "}";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[\\$]+\\{[a-zA-Z_\\x7f-\\xff][a-zA-Z0-9_\\x7f-\\xff]*\\}";
        SEQ_REGEXP1.TYPE = "KEYWORD3";
        SEQ_REGEXP1.HASH_CHAR = "$";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "PHP_VAR";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, };

        return RULES1;
    }

    private RULES RULES8() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PHP_LITERAL4";
        RULES1.DEFAULT = "LITERAL4";
        RULES1.ESCAPE = "\\";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "LITERAL4";
        SPAN_REGEXP1.DELEGATE = "OBJECT_PHP";
        SPAN_REGEXP1.HASH_CHAR = "{";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\\{(?=\\$)";
        END END1 = new END();
        END1.text = "}";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[\\$]+\\{[a-zA-Z_\\x7f-\\xff][a-zA-Z0-9_\\x7f-\\xff]*\\}";
        SEQ_REGEXP1.TYPE = "KEYWORD3";
        SEQ_REGEXP1.HASH_CHAR = "$";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "PHP_VAR";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, };

        return RULES1;
    }

    private RULES RULES9() {
        RULES RULES1 = new RULES();
        RULES1.SET = "DEF_CLASS";
        RULES1.DEFAULT = "KEYWORD4";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "{";
        SEQ1.TYPE = "OPERATOR";
        SEQ1.DELEGATE = "PHP";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ";";
        SEQ2.TYPE = "INVALID";
        SEQ2.DELEGATE = "PHP";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "=";
        SEQ3.TYPE = "INVALID";
        SEQ3.DELEGATE = "PHP";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "PHP_COMMENTS";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"extends", "implements", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES10() {
        RULES RULES1 = new RULES();
        RULES1.SET = "DEF_FUNCTION";
        RULES1.DEFAULT = "FUNCTION";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ";";
        SEQ1.TYPE = "INVALID";
        SEQ1.DELEGATE = "PHP";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "&";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "(";
        SEQ3.TYPE = "OPERATOR";
        SEQ3.DELEGATE = "DEF_FUNCTION_ARGS";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "PHP_COMMENTS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, };

        return RULES1;
    }

    private RULES RULES11() {
        RULES RULES1 = new RULES();
        RULES1.SET = "DEF_FUNCTION_ARGS";
        RULES1.DEFAULT = "KEYWORD4";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ")";
        SEQ1.TYPE = "OPERATOR";
        SEQ1.DELEGATE = "PHP";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "=";
        SEQ2.TYPE = "OPERATOR";
        SEQ2.DELEGATE = "DEF_FUNCTION_ARGS_VALUE";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = ",";
        SEQ3.TYPE = "OPERATOR";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "PHP_VAR";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "PHP_COMMENTS";
        IMPORT IMPORT3 = new IMPORT();
        IMPORT3.DELEGATE = "PHP_TYPES";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, IMPORT3, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, };

        return RULES1;
    }

    private RULES RULES12() {
        RULES RULES1 = new RULES();
        RULES1.SET = "DEF_FUNCTION_ARGS_VALUE";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(0x[0-9a-f]+|([0-9]*\\.)?[0-9]+(e[+-]?[0-9]+)?)";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL1";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "'";
        END END1 = new END();
        END1.text = "'";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "KEYWORD4";
        SPAN_REGEXP1.DELEGATE = "DEF_FUNCTION_ARGS_VALUE_ARRAY";
        SPAN_REGEXP1.HASH_CHAR = "array";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "array\\s*\\(";
        END END3 = new END();
        END3.text = ")";
        SPAN_REGEXP1.END = new END[] { END3, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN3, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "null";
        SEQ1.TYPE = "KEYWORD4";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ2.DELEGATE = "DEF_FUNCTION_ARGS";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = ")";
        SEQ3.TYPE = "OPERATOR";
        SEQ3.DELEGATE = "PHP";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "PHP_COMMENTS";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "PHP_BASIC_KEYWORD1";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, };

        return RULES1;
    }

    private RULES RULES13() {
        RULES RULES1 = new RULES();
        RULES1.SET = "DEF_FUNCTION_ARGS_VALUE_ARRAY";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(0x[0-9a-f]+|([0-9]*\\.)?[0-9]+(e[+-]?[0-9]+)?)";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL1";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "'";
        END END1 = new END();
        END1.text = "'";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = ",";
        SEQ1.TYPE = "OPERATOR";
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES14() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PHP_COMMENTS";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "/**/";
        SEQ1.TYPE = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT3";
        SPAN1.DELEGATE = "PHPDOC";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/**";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "COMMENT1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "/*";
        END END2 = new END();
        END2.text = "*/";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "//";
        EOL_SPAN1.TYPE = "COMMENT2";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "#";
        EOL_SPAN2.TYPE = "COMMENT4";
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES15() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PHP_VAR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[\\$]+[a-zA-Z_\\x7f-\\xff][a-zA-Z0-9_\\x7f-\\xff]*";
        SEQ_REGEXP1.TYPE = "KEYWORD3";
        SEQ_REGEXP1.HASH_CHAR = "$";
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        return RULES1;
    }

    private RULES RULES16() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PHP";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(0x[0-9a-f]+|([0-9]*\\.)?[0-9]+(e[+-]?[0-9]+)?)";
        RULES1.ESCAPE = "\\";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "(class|interface)(\\s+|$)";
        SEQ_REGEXP1.HASH_CHARS = "ci";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "KEYWORD1";
        SEQ_REGEXP1.DELEGATE = "DEF_CLASS";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "(function)(\\s+|$)";
        SEQ_REGEXP2.AT_WORD_START = "TRUE";
        SEQ_REGEXP2.TYPE = "KEYWORD1";
        SEQ_REGEXP2.DELEGATE = "DEF_FUNCTION";
        SEQ_REGEXP2.HASH_CHAR = "function";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "PHP_EXPRESSION";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, };

        return RULES1;
    }

    private RULES RULES17() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PHP_EXPRESSION";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(0x[0-9a-f]+|([0-9]*\\.)?[0-9]+(e[+-]?[0-9]+)?)";
        RULES1.ESCAPE = "\\";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "/**/";
        SEQ1.TYPE = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT3";
        SPAN1.DELEGATE = "PHPDOC";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/**";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "COMMENT1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "/*";
        END END2 = new END();
        END2.text = "*/";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "//";
        EOL_SPAN1.TYPE = "COMMENT2";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "#";
        EOL_SPAN2.TYPE = "COMMENT4";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "?>";
        SEQ2.TYPE = "MARKUP";
        SEQ2.DELEGATE = "MAIN";
        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL1";
        SPAN3.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "LITERAL2";
        SPAN4.DELEGATE = "PHP_LITERAL2";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "\"";
        END END4 = new END();
        END4.text = "\"";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "LITERAL3";
        SPAN5.DELEGATE = "PHP_LITERAL3";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "`";
        END END5 = new END();
        END5.text = "`";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = "(";
        MARK_PREVIOUS2.TYPE = "FUNCTION";
        MARK_PREVIOUS2.MATCH_TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[\\$]+[a-zA-Z_\\x7f-\\xff][a-zA-Z0-9_\\x7f-\\xff]*\\s*(?=\\()";
        SEQ_REGEXP1.TYPE = "FUNCTION";
        SEQ_REGEXP1.HASH_CHAR = "$";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "LITERAL4";
        SPAN_REGEXP1.DELEGATE = "PHP_LITERAL4";
        SPAN_REGEXP1.HASH_CHAR = "<<<";
        BEGIN BEGIN6 = new BEGIN();
        END END6 = new END();
        END6.text = "$2";
        END6.AT_LINE_START = "TRUE";
        SPAN_REGEXP1.END = new END[] { END6, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.TYPE = "LITERAL1";
        SPAN_REGEXP2.HASH_CHAR = "<<<";
        BEGIN BEGIN7 = new BEGIN();
        END END7 = new END();
        END7.text = "$1";
        END7.AT_LINE_START = "TRUE";
        SPAN_REGEXP2.END = new END[] { END7, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN7, };

        SEQ SEQ3 = new SEQ();
        SEQ3.text = "!";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "%";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "&";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = ">";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "<";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "(array)";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "(bool)";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "(boolean)";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "(double)";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "(float)";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "(int)";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "(integer)";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "(object)";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "(real)";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "(string)";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "*";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "+";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = ",";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "-";
        SEQ21.TYPE = "OPERATOR";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = ".";
        SEQ22.TYPE = "OPERATOR";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "/";
        SEQ23.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = ":(?!:)";
        SEQ_REGEXP2.TYPE = "OPERATOR";
        SEQ_REGEXP2.HASH_CHAR = ":";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = ";";
        SEQ24.TYPE = "OPERATOR";
        SEQ24.DELEGATE = "PHP";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "=";
        SEQ25.TYPE = "OPERATOR";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = "?";
        SEQ26.TYPE = "OPERATOR";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "@";
        SEQ27.TYPE = "OPERATOR";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "[";
        SEQ28.TYPE = "OPERATOR";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = "]";
        SEQ29.TYPE = "OPERATOR";
        SEQ SEQ30 = new SEQ();
        SEQ30.text = "^";
        SEQ30.TYPE = "OPERATOR";
        SEQ SEQ31 = new SEQ();
        SEQ31.text = "`";
        SEQ31.TYPE = "OPERATOR";
        SEQ SEQ32 = new SEQ();
        SEQ32.text = "|";
        SEQ32.TYPE = "OPERATOR";
        SEQ SEQ33 = new SEQ();
        SEQ33.text = "~";
        SEQ33.TYPE = "OPERATOR";
        SEQ SEQ34 = new SEQ();
        SEQ34.text = "(";
        SEQ34.TYPE = "OPERATOR";
        SEQ SEQ35 = new SEQ();
        SEQ35.text = ")";
        SEQ35.TYPE = "OPERATOR";
        SEQ SEQ36 = new SEQ();
        SEQ36.text = "{";
        SEQ36.TYPE = "OPERATOR";
        SEQ SEQ37 = new SEQ();
        SEQ37.text = "}";
        SEQ37.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "new\\s+";
        SEQ_REGEXP3.AT_WORD_START = "TRUE";
        SEQ_REGEXP3.TYPE = "KEYWORD1";
        SEQ_REGEXP3.DELEGATE = "PHP_VAR_NEW_KW";
        SEQ_REGEXP3.HASH_CHAR = "new";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "PHP_VAR";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "PHP_KEYWORDS";
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, };

        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, SEQ30, SEQ31, SEQ32, SEQ33, SEQ34, SEQ35, SEQ36, SEQ37, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, };

        return RULES1;
    }

    private RULES RULES18() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PHP_VAR_NEW_KW";
        RULES1.DEFAULT = "KEYWORD4";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "(";
        SEQ1.TYPE = "OPERATOR";
        SEQ1.DELEGATE = "PHP_EXPRESSION";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ";";
        SEQ2.TYPE = "OPERATOR";
        SEQ2.DELEGATE = "PHP";
        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        return RULES1;
    }

    private RULES RULES19() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PHP_BASIC_KEYWORD1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"true", "false", "null", });
        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES20() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PHP_TYPES";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"array", "bool", "boolean", "callback", "double", "float", "int", "integer", "mixed", "number", "NULL", "object", "real", "resource", "string", });
        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES21() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PHP_KEYWORDS";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "KEYWORDS_VISIBILITY";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "PHP_BASIC_KEYWORD1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"and", "or", "xor", });
        KEYWORDS1.add("KEYWORD1", new String[]{"__CLASS__", "__DIR__", "__FILE__", "__FUNCTION__", "__LINE__", "__METHOD__", "__NAMESPACE__", "abstract", "array", "as", "break", "case", "catch", "cfunction", "class", "clone", "const", "continue", "declare", "default", "die", "do", "echo", "else", "elseif", "empty", "enddeclare", "endfor", "endforeach", "endif", "endswitch", "endwhile", "eval", "exception", "exit", "extends", "false", "final", "for", "foreach", "function", "global", "goto", "if", "implements", "include", "include_once", "instanceof", "interface", "isset", "list", "namespace", "new", "null", "old_function", "php_user_filter", "print", "private", "protected", "public", "require", "require_once", "return", "static", "switch", "throw", "true", "try", "unset", "use", "var", "while", });
        KEYWORDS1.add("KEYWORD2", new String[]{"__call", "__construct", "__getfunctions", "__getlastrequest", "__getlastresponse", "__gettypes", "__tostring", "abs", "acos", "acosh", "add", "add_namespace", "add_root", "addaction", "addcolor", "addcslashes", "addentry", "addfill", "addfunction", "addshape", "addslashes", "addstring", "aggregate", "aggregate_info", "aggregate_methods", "aggregate_methods_by_list", "aggregate_methods_by_regexp", "aggregate_properties", "aggregate_properties_by_list", "aggregate_properties_by_regexp", "aggregation_info", "align", "apache_child_terminate", "apache_get_modules", "apache_get_version", "apache_getenv", "apache_lookup_uri", "apache_note", "apache_request_headers", "apache_response_headers", "apache_setenv", "apd_breakpoint", "apd_callstack", "apd_clunk", "apd_continue", "apd_croak", "apd_dump_function_table", "apd_dump_persistent_resources", "apd_dump_regular_resources", "apd_echo", "apd_get_active_symbols", "apd_set_pprof_trace", "apd_set_session", "apd_set_session_trace", "apd_set_socket_session_trace", "append", "append_child", "append_sibling", "appendchild", "appenddata", "array_change_key_case", "array_chunk", "array_combine", "array_count_values", "array_diff", "array_diff_assoc", "array_diff_key", "array_diff_uassoc", "array_diff_ukey", "array_fill", "array_filter", "array_flip", "array_intersect", "array_intersect_assoc", "array_intersect_key", "array_intersect_uassoc", "array_intersect_ukey", "array_key_exists", "array_keys", "array_map", "array_merge", "array_merge_recursive", "array_multisort", "array_pad", "array_pop", "array_push", "array_rand", "array_reduce", "array_reverse", "array_search", "array_shift", "array_slice", "array_splice", "array_sum", "array_udiff", "array_udiff_assoc", "array_udiff_uassoc", "array_uintersect", "array_uintersect_assoc", "array_uintersect_uassoc", "array_unique", "array_unshift", "array_values", "array_walk", "array_walk_recursive", "arsort", "ascii2ebcdic", "asin", "asinh", "asort", "aspell_check", "aspell_check_raw", "aspell_new", "aspell_suggest", "assert", "assert_options", "assign", "assignelem", "asxml", "atan", "atan2", "atanh", "attreditable", "attributes", "base64_decode", "base64_encode", "base_convert", "basename", "bcadd", "bccomp", "bcdiv", "bcmod", "bcmul", "bcpow", "bcpowmod", "bcscale", "bcsqrt", "bcsub", "begintransaction", "bin2hex", "bind_textdomain_codeset", "bindcolumn", "bindec", "bindparam", "bindtextdomain", "bzclose", "bzcompress", "bzdecompress", "bzerrno", "bzerror", "bzerrstr", "bzflush", "bzopen", "bzread", "bzwrite", "cal_days_in_month", "cal_from_jd", "cal_info", "cal_to_jd", "call_user_func", "call_user_func_array", "call_user_method", "call_user_method_array", "ccvs_add", "ccvs_auth", "ccvs_command", "ccvs_count", "ccvs_delete", "ccvs_done", "ccvs_init", "ccvs_lookup", "ccvs_new", "ccvs_report", "ccvs_return", "ccvs_reverse", "ccvs_sale", "ccvs_status", "ccvs_textvalue", "ccvs_void", "ceil", "chdir", "checkdate", "checkdnsrr", "checkin", "checkout", "chgrp", "child_nodes", "children", "chmod", "chop", "chown", "chr", "chroot", "chunk_split", "class_exists", "class_implements", "class_parents", "classkit_import", "classkit_method_add", "classkit_method_copy", "classkit_method_redefine", "classkit_method_remove", "classkit_method_rename", "clearstatcache", "clone_node", "clonenode", "close", "closedir", "closelog", "com", "com_addref", "com_create_guid", "com_event_sink", "com_get", "com_get_active_object", "com_invoke", "com_isenum", "com_load", "com_load_typelib", "com_message_pump", "com_print_typeinfo", "com_propget", "com_propput", "com_propset", "com_release", "com_set", "commit", "compact", "connect", "connection_aborted", "connection_status", "connection_timeout", "constant", "content", "convert_cyr_string", "convert_uudecode", "convert_uuencode", "copy", "cos", "cosh", "count", "count_chars", "cpdf_add_annotation", "cpdf_add_outline", "cpdf_arc", "cpdf_begin_text", "cpdf_circle", "cpdf_clip", "cpdf_close", "cpdf_closepath", "cpdf_closepath_fill_stroke", "cpdf_closepath_stroke", "cpdf_continue_text", "cpdf_curveto", "cpdf_end_text", "cpdf_fill", "cpdf_fill_stroke", "cpdf_finalize", "cpdf_finalize_page", "cpdf_global_set_document_limits", "cpdf_import_jpeg", "cpdf_lineto", "cpdf_moveto", "cpdf_newpath", "cpdf_open", "cpdf_output_buffer", "cpdf_page_init", "cpdf_place_inline_image", "cpdf_rect", "cpdf_restore", "cpdf_rlineto", "cpdf_rmoveto", "cpdf_rotate", "cpdf_rotate_text", "cpdf_save", "cpdf_save_to_file", "cpdf_scale", "cpdf_set_action_url", "cpdf_set_char_spacing", "cpdf_set_creator", "cpdf_set_current_page", "cpdf_set_font", "cpdf_set_font_directories", "cpdf_set_font_map_file", "cpdf_set_horiz_scaling", "cpdf_set_keywords", "cpdf_set_leading", "cpdf_set_page_animation", "cpdf_set_subject", "cpdf_set_text_matrix", "cpdf_set_text_pos", "cpdf_set_text_rendering", "cpdf_set_text_rise", "cpdf_set_title", "cpdf_set_viewer_preferences", "cpdf_set_word_spacing", "cpdf_setdash", "cpdf_setflat", "cpdf_setgray", "cpdf_setgray_fill", "cpdf_setgray_stroke", "cpdf_setlinecap", "cpdf_setlinejoin", "cpdf_setlinewidth", "cpdf_setmiterlimit", "cpdf_setrgbcolor", "cpdf_setrgbcolor_fill", "cpdf_setrgbcolor_stroke", "cpdf_show", "cpdf_show_xy", "cpdf_stringwidth", "cpdf_stroke", "cpdf_text", "cpdf_translate", "crack_check", "crack_closedict", "crack_getlastmessage", "crack_opendict", "crc32", "create_attribute", "create_cdata_section", "create_comment", "create_element", "create_element_ns", "create_entity_reference", "create_function", "create_processing_instruction", "create_text_node", "createattribute", "createattributens", "createcdatasection", "createcomment", "createdocument", "createdocumentfragment", "createdocumenttype", "createelement", "createelementns", "createentityreference", "createprocessinginstruction", "createtextnode", "crypt", "ctype_alnum", "ctype_alpha", "ctype_cntrl", "ctype_digit", "ctype_graph", "ctype_lower", "ctype_print", "ctype_punct", "ctype_space", "ctype_upper", "ctype_xdigit", "curl_close", "curl_copy_handle", "curl_errno", "curl_error", "curl_exec", "curl_getinfo", "curl_init", "curl_multi_add_handle", "curl_multi_close", "curl_multi_exec", "curl_multi_getcontent", "curl_multi_info_read", "curl_multi_init", "curl_multi_remove_handle", "curl_multi_select", "curl_setopt", "curl_version", "current", "cybercash_base64_decode", "cybercash_base64_encode", "cybercash_decr", "cybercash_encr", "cyrus_authenticate", "cyrus_bind", "cyrus_close", "cyrus_connect", "cyrus_query", "cyrus_unbind", "data", "date", "date_sunrise", "date_sunset", "dba_close", "dba_delete", "dba_exists", "dba_fetch", "dba_firstkey", "dba_handlers", "dba_insert", "dba_key_split", "dba_list", "dba_nextkey", "dba_open", "dba_optimize", "dba_popen", "dba_replace", "dba_sync", "dbase_add_record", "dbase_close", "dbase_create", "dbase_delete_record", "dbase_get_header_info", "dbase_get_record", "dbase_get_record_with_names", "dbase_numfields", "dbase_numrecords", "dbase_open", "dbase_pack", "dbase_replace_record", "dblist", "dbmclose", "dbmdelete", "dbmexists", "dbmfetch", "dbmfirstkey", "dbminsert", "dbmnextkey", "dbmopen", "dbmreplace", "dbplus_add", "dbplus_aql", "dbplus_chdir", "dbplus_close", "dbplus_curr", "dbplus_errcode", "dbplus_errno", "dbplus_find", "dbplus_first", "dbplus_flush", "dbplus_freealllocks", "dbplus_freelock", "dbplus_freerlocks", "dbplus_getlock", "dbplus_getunique", "dbplus_info", "dbplus_last", "dbplus_lockrel", "dbplus_next", "dbplus_open", "dbplus_prev", "dbplus_rchperm", "dbplus_rcreate", "dbplus_rcrtexact", "dbplus_rcrtlike", "dbplus_resolve", "dbplus_restorepos", "dbplus_rkeys", "dbplus_ropen", "dbplus_rquery", "dbplus_rrename", "dbplus_rsecindex", "dbplus_runlink", "dbplus_rzap", "dbplus_savepos", "dbplus_setindex", "dbplus_setindexbynumber", "dbplus_sql", "dbplus_tcl", "dbplus_tremove", "dbplus_undo", "dbplus_undoprepare", "dbplus_unlockrel", "dbplus_unselect", "dbplus_update", "dbplus_xlockrel", "dbplus_xunlockrel", "dbstat", "dbx_close", "dbx_compare", "dbx_connect", "dbx_error", "dbx_escape_string", "dbx_fetch_row", "dbx_query", "dbx_sort", "dcgettext", "dcngettext", "dcstat", "deaggregate", "debug_backtrace", "debug_print_backtrace", "debug_zval_dump", "debugger_off", "debugger_on", "decbin", "dechex", "decoct", "decrement", "define", "define_syslog_variables", "defined", "deg2rad", "delete", "deletedata", "description", "dgettext", "dio_close", "dio_fcntl", "dio_open", "dio_read", "dio_seek", "dio_stat", "dio_tcsetattr", "dio_truncate", "dio_write", "dir", "dirname", "disk_free_space", "disk_total_space", "diskfreespace", "dl", "dngettext", "dns_check_record", "dns_get_mx", "dns_get_record", "doctype", "document_element", "dom_import_simplexml", "domxml_new_doc", "domxml_open_file", "domxml_open_mem", "domxml_version", "domxml_xmltree", "domxml_xslt_stylesheet", "domxml_xslt_stylesheet_doc", "domxml_xslt_stylesheet_file", "dotnet", "dotnet_load", "doubleval", "drawcurve", "drawcurveto", "drawline", "drawlineto", "dstanchors", "dstofsrcanchors", "dump_file", "dump_mem", "dump_node", "each", "easter_date", "easter_days", "ebcdic2ascii", "end", "entities", "eof", "erase", "ereg", "ereg_replace", "eregi", "eregi_replace", "error_log", "error_reporting", "errorcode", "errorinfo", "escapeshellarg", "escapeshellcmd", "exec", "execute", "exif_imagetype", "exif_read_data", "exif_tagname", "exif_thumbnail", "exp", "explode", "expm1", "export", "extension_loaded", "extract", "ezmlm_hash", "fam_cancel_monitor", "fam_close", "fam_monitor_collection", "fam_monitor_directory", "fam_monitor_file", "fam_next_event", "fam_open", "fam_pending", "fam_resume_monitor", "fam_suspend_monitor", "fbsql_affected_rows", "fbsql_autocommit", "fbsql_blob_size", "fbsql_change_user", "fbsql_clob_size", "fbsql_close", "fbsql_commit", "fbsql_connect", "fbsql_create_blob", "fbsql_create_clob", "fbsql_create_db", "fbsql_data_seek", "fbsql_database", "fbsql_database_password", "fbsql_db_query", "fbsql_db_status", "fbsql_drop_db", "fbsql_errno", "fbsql_error", "fbsql_fetch_array", "fbsql_fetch_assoc", "fbsql_fetch_field", "fbsql_fetch_lengths", "fbsql_fetch_object", "fbsql_fetch_row", "fbsql_field_flags", "fbsql_field_len", "fbsql_field_name", "fbsql_field_seek", "fbsql_field_table", "fbsql_field_type", "fbsql_free_result", "fbsql_get_autostart_info", "fbsql_hostname", "fbsql_insert_id", "fbsql_list_dbs", "fbsql_list_fields", "fbsql_list_tables", "fbsql_next_result", "fbsql_num_fields", "fbsql_num_rows", "fbsql_password", "fbsql_pconnect", "fbsql_query", "fbsql_read_blob", "fbsql_read_clob", "fbsql_result", "fbsql_rollback", "fbsql_select_db", "fbsql_set_lob_mode", "fbsql_set_password", "fbsql_set_transaction", "fbsql_start_db", "fbsql_stop_db", "fbsql_tablename", "fbsql_username", "fbsql_warnings", "fclose", "fdf_add_doc_javascript", "fdf_add_template", "fdf_close", "fdf_create", "fdf_enum_values", "fdf_errno", "fdf_error", "fdf_get_ap", "fdf_get_attachment", "fdf_get_encoding", "fdf_get_file", "fdf_get_flags", "fdf_get_opt", "fdf_get_status", "fdf_get_value", "fdf_get_version", "fdf_header", "fdf_next_field_name", "fdf_open", "fdf_open_string", "fdf_remove_item", "fdf_save", "fdf_save_string", "fdf_set_ap", "fdf_set_encoding", "fdf_set_file", "fdf_set_flags", "fdf_set_javascript_action", "fdf_set_on_import_javascript", "fdf_set_opt", "fdf_set_status", "fdf_set_submit_form_action", "fdf_set_target_frame", "fdf_set_value", "fdf_set_version", "feof", "fetch", "fetchall", "fetchsingle", "fflush", "fgetc", "fgetcsv", "fgets", "fgetss", "file", "file_exists", "file_get_contents", "file_put_contents", "fileatime", "filectime", "filegroup", "fileinode", "filemtime", "fileowner", "fileperms", "filepro", "filepro_fieldcount", "filepro_fieldname", "filepro_fieldtype", "filepro_fieldwidth", "filepro_retrieve", "filepro_rowcount", "filesize", "filetype", "find", "first_child", "floatval", "flock", "floor", "flush", "fmod", "fnmatch", "fopen", "fpassthru", "fprintf", "fputcsv", "fputs", "fread", "free", "frenchtojd", "fribidi_log2vis", "fscanf", "fseek", "fsockopen", "fstat", "ftell", "ftok", "ftp_alloc", "ftp_cdup", "ftp_chdir", "ftp_chmod", "ftp_close", "ftp_connect", "ftp_delete", "ftp_exec", "ftp_fget", "ftp_fput", "ftp_get", "ftp_get_option", "ftp_login", "ftp_mdtm", "ftp_mkdir", "ftp_nb_continue", "ftp_nb_fget", "ftp_nb_fput", "ftp_nb_get", "ftp_nb_put", "ftp_nlist", "ftp_pasv", "ftp_put", "ftp_pwd", "ftp_quit", "ftp_raw", "ftp_rawlist", "ftp_rename", "ftp_rmdir", "ftp_set_option", "ftp_site", "ftp_size", "ftp_ssl_connect", "ftp_systype", "ftruncate", "ftstat", "func_get_arg", "func_get_args", "func_num_args", "function_exists", "fwrite", "gd_info", "get", "get_attr", "get_attribute", "get_attribute_node", "get_browser", "get_cfg_var", "get_class", "get_class_methods", "get_class_vars", "get_content", "get_current_user", "get_declared_classes", "get_declared_interfaces", "get_defined_constants", "get_defined_functions", "get_defined_vars", "get_element_by_id", "get_elements_by_tagname", "get_extension_funcs", "get_headers", "get_html_translation_table", "get_include_path", "get_included_files", "get_loaded_extensions", "get_magic_quotes_gpc", "get_magic_quotes_runtime", "get_meta_tags", "get_nodes", "get_object_vars", "get_parent_class", "get_required_files", "get_resource_type", "getallheaders", "getatime", "getattr", "getattribute", "getattributenode", "getattributenodens", "getattributens", "getbuffering", "getchildren", "getcrc", "getctime", "getcwd", "getdate", "getdepth", "getelem", "getelementbyid", "getelementsbytagname", "getelementsbytagnamens", "getenv", "getfilename", "getfiletime", "getfunctions", "getgroup", "getheight", "gethostbyaddr", "gethostbyname", "gethostbynamel", "gethostos", "getimagesize", "getinneriterator", "getinode", "getiterator", "getlastmod", "getmethod", "getmtime", "getmxrr", "getmygid", "getmyinode", "getmypid", "getmyuid", "getname", "getnameditem", "getnameditemns", "getopt", "getowner", "getpackedsize", "getpath", "getpathname", "getperms", "getposition", "getprotobyname", "getprotobynumber", "getrandmax", "getrusage", "getservbyname", "getservbyport", "getshape1", "getshape2", "getsize", "getstats", "getsubiterator", "gettext", "gettimeofday", "gettype", "getunpackedsize", "getversion", "getwidth", "glob", "gmdate", "gmmktime", "gmp_abs", "gmp_add", "gmp_and", "gmp_clrbit", "gmp_cmp", "gmp_com", "gmp_div", "gmp_div_q", "gmp_div_qr", "gmp_div_r", "gmp_divexact", "gmp_fact", "gmp_gcd", "gmp_gcdext", "gmp_hamdist", "gmp_init", "gmp_intval", "gmp_invert", "gmp_jacobi", "gmp_legendre", "gmp_mod", "gmp_mul", "gmp_neg", "gmp_or", "gmp_perfect_square", "gmp_popcount", "gmp_pow", "gmp_powm", "gmp_prob_prime", "gmp_random", "gmp_scan0", "gmp_scan1", "gmp_setbit", "gmp_sign", "gmp_sqrt", "gmp_sqrtrem", "gmp_strval", "gmp_sub", "gmp_xor", "gmstrftime", "gregoriantojd", "gzclose", "gzcompress", "gzdeflate", "gzencode", "gzeof", "gzfile", "gzgetc", "gzgets", "gzgetss", "gzinflate", "gzopen", "gzpassthru", "gzputs", "gzread", "gzrewind", "gzseek", "gztell", "gzuncompress", "gzwrite", "handle", "has_attribute", "has_attributes", "has_child_nodes", "hasattribute", "hasattributens", "hasattributes", "haschildnodes", "haschildren", "hasfeature", "hasnext", "hassiblings", "header", "headers_list", "headers_sent", "hebrev", "hebrevc", "hexdec", "highlight_file", "highlight_string", "html_dump_mem", "html_entity_decode", "htmlentities", "htmlspecialchars", "http_build_query", "hw_array2objrec", "hw_changeobject", "hw_children", "hw_childrenobj", "hw_close", "hw_connect", "hw_connection_info", "hw_cp", "hw_deleteobject", "hw_docbyanchor", "hw_docbyanchorobj", "hw_document_attributes", "hw_document_bodytag", "hw_document_content", "hw_document_setcontent", "hw_document_size", "hw_dummy", "hw_edittext", "hw_error", "hw_errormsg", "hw_free_document", "hw_getanchors", "hw_getanchorsobj", "hw_getandlock", "hw_getchildcoll", "hw_getchildcollobj", "hw_getchilddoccoll", "hw_getchilddoccollobj", "hw_getobject", "hw_getobjectbyquery", "hw_getobjectbyquerycoll", "hw_getobjectbyquerycollobj", "hw_getobjectbyqueryobj", "hw_getparents", "hw_getparentsobj", "hw_getrellink", "hw_getremote", "hw_getremotechildren", "hw_getsrcbydestobj", "hw_gettext", "hw_getusername", "hw_identify", "hw_incollections", "hw_info", "hw_inscoll", "hw_insdoc", "hw_insertanchors", "hw_insertdocument", "hw_insertobject", "hw_mapid", "hw_modifyobject", "hw_mv", "hw_new_document", "hw_objrec2array", "hw_output_document", "hw_pconnect", "hw_pipedocument", "hw_root", "hw_setlinkroot", "hw_stat", "hw_unlock", "hw_who", "hwapi_hgcsp", "hwstat", "hypot", "ibase_add_user", "ibase_affected_rows", "ibase_backup", "ibase_blob_add", "ibase_blob_cancel", "ibase_blob_close", "ibase_blob_create", "ibase_blob_echo", "ibase_blob_get", "ibase_blob_import", "ibase_blob_info", "ibase_blob_open", "ibase_close", "ibase_commit", "ibase_commit_ret", "ibase_connect", "ibase_db_info", "ibase_delete_user", "ibase_drop_db", "ibase_errcode", "ibase_errmsg", "ibase_execute", "ibase_fetch_assoc", "ibase_fetch_object", "ibase_fetch_row", "ibase_field_info", "ibase_free_event_handler", "ibase_free_query", "ibase_free_result", "ibase_gen_id", "ibase_maintain_db", "ibase_modify_user", "ibase_name_result", "ibase_num_fields", "ibase_num_params", "ibase_param_info", "ibase_pconnect", "ibase_prepare", "ibase_query", "ibase_restore", "ibase_rollback", "ibase_rollback_ret", "ibase_server_info", "ibase_service_attach", "ibase_service_detach", "ibase_set_event_handler", "ibase_timefmt", "ibase_trans", "ibase_wait_event", "iconv", "iconv_get_encoding", "iconv_mime_decode", "iconv_mime_decode_headers", "iconv_mime_encode", "iconv_set_encoding", "iconv_strlen", "iconv_strpos", "iconv_strrpos", "iconv_substr", "id3_get_genre_id", "id3_get_genre_list", "id3_get_genre_name", "id3_get_tag", "id3_get_version", "id3_remove_tag", "id3_set_tag", "idate", "identify", "ifx_affected_rows", "ifx_blobinfile_mode", "ifx_byteasvarchar", "ifx_close", "ifx_connect", "ifx_copy_blob", "ifx_create_blob", "ifx_create_char", "ifx_do", "ifx_error", "ifx_errormsg", "ifx_fetch_row", "ifx_fieldproperties", "ifx_fieldtypes", "ifx_free_blob", "ifx_free_char", "ifx_free_result", "ifx_get_blob", "ifx_get_char", "ifx_getsqlca", "ifx_htmltbl_result", "ifx_nullformat", "ifx_num_fields", "ifx_num_rows", "ifx_pconnect", "ifx_prepare", "ifx_query", "ifx_textasvarchar", "ifx_update_blob", "ifx_update_char", "ifxus_close_slob", "ifxus_create_slob", "ifxus_free_slob", "ifxus_open_slob", "ifxus_read_slob", "ifxus_seek_slob", "ifxus_tell_slob", "ifxus_write_slob", "ignore_user_abort", "image2wbmp", "image_type_to_extension", "image_type_to_mime_type", "imagealphablending", "imageantialias", "imagearc", "imagechar", "imagecharup", "imagecolorallocate", "imagecolorallocatealpha", "imagecolorat", "imagecolorclosest", "imagecolorclosestalpha", "imagecolorclosesthwb", "imagecolordeallocate", "imagecolorexact", "imagecolorexactalpha", "imagecolormatch", "imagecolorresolve", "imagecolorresolvealpha", "imagecolorset", "imagecolorsforindex", "imagecolorstotal", "imagecolortransparent", "imagecopy", "imagecopymerge", "imagecopymergegray", "imagecopyresampled", "imagecopyresized", "imagecreate", "imagecreatefromgd", "imagecreatefromgd2", "imagecreatefromgd2part", "imagecreatefromgif", "imagecreatefromjpeg", "imagecreatefrompng", "imagecreatefromstring", "imagecreatefromwbmp", "imagecreatefromxbm", "imagecreatefromxpm", "imagecreatetruecolor", "imagedashedline", "imagedestroy", "imageellipse", "imagefill", "imagefilledarc", "imagefilledellipse", "imagefilledpolygon", "imagefilledrectangle", "imagefilltoborder", "imagefilter", "imagefontheight", "imagefontwidth", "imageftbbox", "imagefttext", "imagegammacorrect", "imagegd", "imagegd2", "imagegif", "imageinterlace", "imageistruecolor", "imagejpeg", "imagelayereffect", "imageline", "imageloadfont", "imagepalettecopy", "imagepng", "imagepolygon", "imagepsbbox", "imagepscopyfont", "imagepsencodefont", "imagepsextendfont", "imagepsfreefont", "imagepsloadfont", "imagepsslantfont", "imagepstext", "imagerectangle", "imagerotate", "imagesavealpha", "imagesetbrush", "imagesetpixel", "imagesetstyle", "imagesetthickness", "imagesettile", "imagestring", "imagestringup", "imagesx", "imagesy", "imagetruecolortopalette", "imagettfbbox", "imagettftext", "imagetypes", "imagewbmp", "imagexbm", "imap_8bit", "imap_alerts", "imap_append", "imap_base64", "imap_binary", "imap_body", "imap_bodystruct", "imap_check", "imap_clearflag_full", "imap_close", "imap_createmailbox", "imap_delete", "imap_deletemailbox", "imap_errors", "imap_expunge", "imap_fetch_overview", "imap_fetchbody", "imap_fetchheader", "imap_fetchstructure", "imap_get_quota", "imap_get_quotaroot", "imap_getacl", "imap_getmailboxes", "imap_getsubscribed", "imap_header", "imap_headerinfo", "imap_headers", "imap_last_error", "imap_list", "imap_listmailbox", "imap_listscan", "imap_listsubscribed", "imap_lsub", "imap_mail", "imap_mail_compose", "imap_mail_copy", "imap_mail_move", "imap_mailboxmsginfo", "imap_mime_header_decode", "imap_msgno", "imap_num_msg", "imap_num_recent", "imap_open", "imap_ping", "imap_qprint", "imap_renamemailbox", "imap_reopen", "imap_rfc822_parse_adrlist", "imap_rfc822_parse_headers", "imap_rfc822_write_address", "imap_scanmailbox", "imap_search", "imap_set_quota", "imap_setacl", "imap_setflag_full", "imap_sort", "imap_status", "imap_subscribe", "imap_thread", "imap_timeout", "imap_uid", "imap_undelete", "imap_unsubscribe", "imap_utf7_decode", "imap_utf7_encode", "imap_utf8", "implode", "import", "import_request_variables", "importnode", "in_array", "increment", "inet_ntop", "inet_pton", "info", "ingres_autocommit", "ingres_close", "ingres_commit", "ingres_connect", "ingres_fetch_array", "ingres_fetch_object", "ingres_fetch_row", "ingres_field_length", "ingres_field_name", "ingres_field_nullable", "ingres_field_precision", "ingres_field_scale", "ingres_field_type", "ingres_num_fields", "ingres_num_rows", "ingres_pconnect", "ingres_query", "ingres_rollback", "ini_alter", "ini_get", "ini_get_all", "ini_restore", "ini_set", "insert", "insert_before", "insertanchor", "insertbefore", "insertcollection", "insertdata", "insertdocument", "interface_exists", "internal_subset", "intval", "ip2long", "iptcembed", "iptcparse", "ircg_channel_mode", "ircg_disconnect", "ircg_eval_ecmascript_params", "ircg_fetch_error_msg", "ircg_get_username", "ircg_html_encode", "ircg_ignore_add", "ircg_ignore_del", "ircg_invite", "ircg_is_conn_alive", "ircg_join", "ircg_kick", "ircg_list", "ircg_lookup_format_messages", "ircg_lusers", "ircg_msg", "ircg_names", "ircg_nick", "ircg_nickname_escape", "ircg_nickname_unescape", "ircg_notice", "ircg_oper", "ircg_part", "ircg_pconnect", "ircg_register_format_messages", "ircg_set_current", "ircg_set_file", "ircg_set_on_die", "ircg_topic", "ircg_who", "ircg_whois", "is_a", "is_array", "is_blank_node", "is_bool", "is_callable", "is_dir", "is_double", "is_executable", "is_file", "is_finite", "is_float", "is_infinite", "is_int", "is_integer", "is_link", "is_long", "is_nan", "is_null", "is_numeric", "is_object", "is_readable", "is_real", "is_resource", "is_scalar", "is_soap_fault", "is_string", "is_subclass_of", "is_uploaded_file", "is_writable", "is_writeable", "isasp", "iscomment", "isdir", "isdot", "isexecutable", "isfile", "ishtml", "isid", "isjste", "islink", "isphp", "isreadable", "issamenode", "issupported", "istext", "iswhitespaceinelementcontent", "iswritable", "isxhtml", "isxml", "item", "iterator_count", "iterator_to_array", "java_last_exception_clear", "java_last_exception_get", "jddayofweek", "jdmonthname", "jdtofrench", "jdtogregorian", "jdtojewish", "jdtojulian", "jdtounix", "jewishtojd", "join", "jpeg2wbmp", "json_decode", "json_encode", "juliantojd", "key", "krsort", "ksort", "langdepvalue", "last_child", "lastinsertid", "lcg_value", "ldap_8859_to_t61", "ldap_add", "ldap_bind", "ldap_close", "ldap_compare", "ldap_connect", "ldap_count_entries", "ldap_delete", "ldap_dn2ufn", "ldap_err2str", "ldap_errno", "ldap_error", "ldap_explode_dn", "ldap_first_attribute", "ldap_first_entry", "ldap_first_reference", "ldap_free_result", "ldap_get_attributes", "ldap_get_dn", "ldap_get_entries", "ldap_get_option", "ldap_get_values", "ldap_get_values_len", "ldap_list", "ldap_mod_add", "ldap_mod_del", "ldap_mod_replace", "ldap_modify", "ldap_next_attribute", "ldap_next_entry", "ldap_next_reference", "ldap_parse_reference", "ldap_parse_result", "ldap_read", "ldap_rename", "ldap_sasl_bind", "ldap_search", "ldap_set_option", "ldap_set_rebind_proc", "ldap_sort", "ldap_start_tls", "ldap_t61_to_8859", "ldap_unbind", "levenshtein", "link", "linkinfo", "load", "loadhtml", "loadhtmlfile", "loadxml", "localeconv", "localtime", "lock", "log", "log10", "log1p", "long2ip", "lookupnamespaceuri", "lookupprefix", "lstat", "ltrim", "lzf_compress", "lzf_decompress", "lzf_optimized_for", "mail", "mailparse_determine_best_xfer_encoding", "mailparse_msg_create", "mailparse_msg_extract_part", "mailparse_msg_extract_part_file", "mailparse_msg_free", "mailparse_msg_get_part", "mailparse_msg_get_part_data", "mailparse_msg_get_structure", "mailparse_msg_parse", "mailparse_msg_parse_file", "mailparse_rfc822_parse_addresses", "mailparse_stream_encode", "mailparse_uudecode_all", "main", "max", "mb_convert_case", "mb_convert_encoding", "mb_convert_kana", "mb_convert_variables", "mb_decode_mimeheader", "mb_decode_numericentity", "mb_detect_encoding", "mb_detect_order", "mb_encode_mimeheader", "mb_encode_numericentity", "mb_ereg", "mb_ereg_match", "mb_ereg_replace", "mb_ereg_search", "mb_ereg_search_getpos", "mb_ereg_search_getregs", "mb_ereg_search_init", "mb_ereg_search_pos", "mb_ereg_search_regs", "mb_ereg_search_setpos", "mb_eregi", "mb_eregi_replace", "mb_get_info", "mb_http_input", "mb_http_output", "mb_internal_encoding", "mb_language", "mb_list_encodings", "mb_output_handler", "mb_parse_str", "mb_preferred_mime_name", "mb_regex_encoding", "mb_regex_set_options", "mb_send_mail", "mb_split", "mb_strcut", "mb_strimwidth", "mb_strlen", "mb_strpos", "mb_strrpos", "mb_strtolower", "mb_strtoupper", "mb_strwidth", "mb_substitute_character", "mb_substr", "mb_substr_count", "mcal_append_event", "mcal_close", "mcal_create_calendar", "mcal_date_compare", "mcal_date_valid", "mcal_day_of_week", "mcal_day_of_year", "mcal_days_in_month", "mcal_delete_calendar", "mcal_delete_event", "mcal_event_add_attribute", "mcal_event_init", "mcal_event_set_alarm", "mcal_event_set_category", "mcal_event_set_class", "mcal_event_set_description", "mcal_event_set_end", "mcal_event_set_recur_daily", "mcal_event_set_recur_monthly_mday", "mcal_event_set_recur_monthly_wday", "mcal_event_set_recur_none", "mcal_event_set_recur_weekly", "mcal_event_set_recur_yearly", "mcal_event_set_start", "mcal_event_set_title", "mcal_expunge", "mcal_fetch_current_stream_event", "mcal_fetch_event", "mcal_is_leap_year", "mcal_list_alarms", "mcal_list_events", "mcal_next_recurrence", "mcal_open", "mcal_popen", "mcal_rename_calendar", "mcal_reopen", "mcal_snooze", "mcal_store_event", "mcal_time_valid", "mcal_week_of_year", "mcrypt_cbc", "mcrypt_cfb", "mcrypt_create_iv", "mcrypt_decrypt", "mcrypt_ecb", "mcrypt_enc_get_algorithms_name", "mcrypt_enc_get_block_size", "mcrypt_enc_get_iv_size", "mcrypt_enc_get_key_size", "mcrypt_enc_get_modes_name", "mcrypt_enc_get_supported_key_sizes", "mcrypt_enc_is_block_algorithm", "mcrypt_enc_is_block_algorithm_mode", "mcrypt_enc_is_block_mode", "mcrypt_enc_self_test", "mcrypt_encrypt", "mcrypt_generic", "mcrypt_generic_deinit", "mcrypt_generic_end", "mcrypt_generic_init", "mcrypt_get_block_size", "mcrypt_get_cipher_name", "mcrypt_get_iv_size", "mcrypt_get_key_size", "mcrypt_list_algorithms", "mcrypt_list_modes", "mcrypt_module_close", "mcrypt_module_get_algo_block_size", "mcrypt_module_get_algo_key_size", "mcrypt_module_get_supported_key_sizes", "mcrypt_module_is_block_algorithm", "mcrypt_module_is_block_algorithm_mode", "mcrypt_module_is_block_mode", "mcrypt_module_open", "mcrypt_module_self_test", "mcrypt_ofb", "mcve_adduser", "mcve_adduserarg", "mcve_bt", "mcve_checkstatus", "mcve_chkpwd", "mcve_chngpwd", "mcve_completeauthorizations", "mcve_connect", "mcve_connectionerror", "mcve_deleteresponse", "mcve_deletetrans", "mcve_deleteusersetup", "mcve_deluser", "mcve_destroyconn", "mcve_destroyengine", "mcve_disableuser", "mcve_edituser", "mcve_enableuser", "mcve_force", "mcve_getcell", "mcve_getcellbynum", "mcve_getcommadelimited", "mcve_getheader", "mcve_getuserarg", "mcve_getuserparam", "mcve_gft", "mcve_gl", "mcve_gut", "mcve_initconn", "mcve_initengine", "mcve_initusersetup", "mcve_iscommadelimited", "mcve_liststats", "mcve_listusers", "mcve_maxconntimeout", "mcve_monitor", "mcve_numcolumns", "mcve_numrows", "mcve_override", "mcve_parsecommadelimited", "mcve_ping", "mcve_preauth", "mcve_preauthcompletion", "mcve_qc", "mcve_responseparam", "mcve_return", "mcve_returncode", "mcve_returnstatus", "mcve_sale", "mcve_setblocking", "mcve_setdropfile", "mcve_setip", "mcve_setssl", "mcve_setssl_files", "mcve_settimeout", "mcve_settle", "mcve_text_avs", "mcve_text_code", "mcve_text_cv", "mcve_transactionauth", "mcve_transactionavs", "mcve_transactionbatch", "mcve_transactioncv", "mcve_transactionid", "mcve_transactionitem", "mcve_transactionssent", "mcve_transactiontext", "mcve_transinqueue", "mcve_transnew", "mcve_transparam", "mcve_transsend", "mcve_ub", "mcve_uwait", "mcve_verifyconnection", "mcve_verifysslcert", "mcve_void", "md5", "md5_file", "mdecrypt_generic", "memcache_debug", "memory_get_usage", "memory_get_peak_usage", "metaphone", "method_exists", "mhash", "mhash_count", "mhash_get_block_size", "mhash_get_hash_name", "mhash_keygen_s2k", "microtime", "mime_content_type", "mimetype", "min", "ming_setcubicthreshold", "ming_setscale", "ming_useswfversion", "mkdir", "mktime", "money_format", "move", "move_uploaded_file", "movepen", "movepento", "moveto", "msession_connect", "msession_count", "msession_create", "msession_destroy", "msession_disconnect", "msession_find", "msession_get", "msession_get_array", "msession_get_data", "msession_inc", "msession_list", "msession_listvar", "msession_lock", "msession_plugin", "msession_randstr", "msession_set", "msession_set_array", "msession_set_data", "msession_timeout", "msession_uniq", "msession_unlock", "msg_get_queue", "msg_receive", "msg_remove_queue", "msg_send", "msg_set_queue", "msg_stat_queue", "msql", "msql_affected_rows", "msql_close", "msql_connect", "msql_create_db", "msql_createdb", "msql_data_seek", "msql_db_query", "msql_dbname", "msql_drop_db", "msql_error", "msql_fetch_array", "msql_fetch_field", "msql_fetch_object", "msql_fetch_row", "msql_field_flags", "msql_field_len", "msql_field_name", "msql_field_seek", "msql_field_table", "msql_field_type", "msql_fieldflags", "msql_fieldlen", "msql_fieldname", "msql_fieldtable", "msql_fieldtype", "msql_free_result", "msql_list_dbs", "msql_list_fields", "msql_list_tables", "msql_num_fields", "msql_num_rows", "msql_numfields", "msql_numrows", "msql_pconnect", "msql_query", "msql_regcase", "msql_result", "msql_select_db", "msql_tablename", "mssql_bind", "mssql_close", "mssql_connect", "mssql_data_seek", "mssql_execute", "mssql_fetch_array", "mssql_fetch_assoc", "mssql_fetch_batch", "mssql_fetch_field", "mssql_fetch_object", "mssql_fetch_row", "mssql_field_length", "mssql_field_name", "mssql_field_seek", "mssql_field_type", "mssql_free_result", "mssql_free_statement", "mssql_get_last_message", "mssql_guid_string", "mssql_init", "mssql_min_error_severity", "mssql_min_message_severity", "mssql_next_result", "mssql_num_fields", "mssql_num_rows", "mssql_pconnect", "mssql_query", "mssql_result", "mssql_rows_affected", "mssql_select_db", "mt_getrandmax", "mt_rand", "mt_srand", "multcolor", "muscat_close", "muscat_get", "muscat_give", "muscat_setup", "muscat_setup_net", "mysql_affected_rows", "mysql_change_user", "mysql_client_encoding", "mysql_close", "mysql_connect", "mysql_create_db", "mysql_data_seek", "mysql_db_name", "mysql_db_query", "mysql_drop_db", "mysql_errno", "mysql_error", "mysql_escape_string", "mysql_fetch_array", "mysql_fetch_assoc", "mysql_fetch_field", "mysql_fetch_lengths", "mysql_fetch_object", "mysql_fetch_row", "mysql_field_flags", "mysql_field_len", "mysql_field_name", "mysql_field_seek", "mysql_field_table", "mysql_field_type", "mysql_free_result", "mysql_get_client_info", "mysql_get_host_info", "mysql_get_proto_info", "mysql_get_server_info", "mysql_info", "mysql_insert_id", "mysql_list_dbs", "mysql_list_fields", "mysql_list_processes", "mysql_list_tables", "mysql_num_fields", "mysql_num_rows", "mysql_pconnect", "mysql_ping", "mysql_query", "mysql_real_escape_string", "mysql_result", "mysql_select_db", "mysql_stat", "mysql_tablename", "mysql_thread_id", "mysql_unbuffered_query", "mysqli_affected_rows", "mysqli_autocommit", "mysqli_bind_param", "mysqli_bind_result", "mysqli_change_user", "mysqli_character_set_name", "mysqli_client_encoding", "mysqli_close", "mysqli_commit", "mysqli_connect", "mysqli_connect_errno", "mysqli_connect_error", "mysqli_data_seek", "mysqli_debug", "mysqli_disable_reads_from_master", "mysqli_disable_rpl_parse", "mysqli_dump_debug_info", "mysqli_embedded_connect", "mysqli_enable_reads_from_master", "mysqli_enable_rpl_parse", "mysqli_errno", "mysqli_error", "mysqli_escape_string", "mysqli_execute", "mysqli_fetch", "mysqli_fetch_array", "mysqli_fetch_assoc", "mysqli_fetch_field", "mysqli_fetch_field_direct", "mysqli_fetch_fields", "mysqli_fetch_lengths", "mysqli_fetch_object", "mysqli_fetch_row", "mysqli_field_count", "mysqli_field_seek", "mysqli_field_tell", "mysqli_free_result", "mysqli_get_client_info", "mysqli_get_client_version", "mysqli_get_host_info", "mysqli_get_metadata", "mysqli_get_proto_info", "mysqli_get_server_info", "mysqli_get_server_version", "mysqli_info", "mysqli_init", "mysqli_insert_id", "mysqli_kill", "mysqli_master_query", "mysqli_more_results", "mysqli_multi_query", "mysqli_next_result", "mysqli_num_fields", "mysqli_num_rows", "mysqli_options", "mysqli_param_count", "mysqli_ping", "mysqli_prepare", "mysqli_query", "mysqli_real_connect", "mysqli_real_escape_string", "mysqli_real_query", "mysqli_report", "mysqli_rollback", "mysqli_rpl_parse_enabled", "mysqli_rpl_probe", "mysqli_rpl_query_type", "mysqli_select_db", "mysqli_send_long_data", "mysqli_send_query", "mysqli_server_end", "mysqli_server_init", "mysqli_set_opt", "mysqli_sqlstate", "mysqli_ssl_set", "mysqli_stat", "mysqli_stmt_affected_rows", "mysqli_stmt_bind_param", "mysqli_stmt_bind_result", "mysqli_stmt_close", "mysqli_stmt_data_seek", "mysqli_stmt_errno", "mysqli_stmt_error", "mysqli_stmt_execute", "mysqli_stmt_fetch", "mysqli_stmt_free_result", "mysqli_stmt_init", "mysqli_stmt_num_rows", "mysqli_stmt_param_count", "mysqli_stmt_prepare", "mysqli_stmt_reset", "mysqli_stmt_result_metadata", "mysqli_stmt_send_long_data", "mysqli_stmt_sqlstate", "mysqli_stmt_store_result", "mysqli_store_result", "mysqli_thread_id", "mysqli_thread_safe", "mysqli_use_result", "mysqli_warning_count", "name", "natcasesort", "natsort", "ncurses_addch", "ncurses_addchnstr", "ncurses_addchstr", "ncurses_addnstr", "ncurses_addstr", "ncurses_assume_default_colors", "ncurses_attroff", "ncurses_attron", "ncurses_attrset", "ncurses_baudrate", "ncurses_beep", "ncurses_bkgd", "ncurses_bkgdset", "ncurses_border", "ncurses_bottom_panel", "ncurses_can_change_color", "ncurses_cbreak", "ncurses_clear", "ncurses_clrtobot", "ncurses_clrtoeol", "ncurses_color_content", "ncurses_color_set", "ncurses_curs_set", "ncurses_def_prog_mode", "ncurses_def_shell_mode", "ncurses_define_key", "ncurses_del_panel", "ncurses_delay_output", "ncurses_delch", "ncurses_deleteln", "ncurses_delwin", "ncurses_doupdate", "ncurses_echo", "ncurses_echochar", "ncurses_end", "ncurses_erase", "ncurses_erasechar", "ncurses_filter", "ncurses_flash", "ncurses_flushinp", "ncurses_getch", "ncurses_getmaxyx", "ncurses_getmouse", "ncurses_getyx", "ncurses_halfdelay", "ncurses_has_colors", "ncurses_has_ic", "ncurses_has_il", "ncurses_has_key", "ncurses_hide_panel", "ncurses_hline", "ncurses_inch", "ncurses_init", "ncurses_init_color", "ncurses_init_pair", "ncurses_insch", "ncurses_insdelln", "ncurses_insertln", "ncurses_insstr", "ncurses_instr", "ncurses_isendwin", "ncurses_keyok", "ncurses_keypad", "ncurses_killchar", "ncurses_longname", "ncurses_meta", "ncurses_mouse_trafo", "ncurses_mouseinterval", "ncurses_mousemask", "ncurses_move", "ncurses_move_panel", "ncurses_mvaddch", "ncurses_mvaddchnstr", "ncurses_mvaddchstr", "ncurses_mvaddnstr", "ncurses_mvaddstr", "ncurses_mvcur", "ncurses_mvdelch", "ncurses_mvgetch", "ncurses_mvhline", "ncurses_mvinch", "ncurses_mvvline", "ncurses_mvwaddstr", "ncurses_napms", "ncurses_new_panel", "ncurses_newpad", "ncurses_newwin", "ncurses_nl", "ncurses_nocbreak", "ncurses_noecho", "ncurses_nonl", "ncurses_noqiflush", "ncurses_noraw", "ncurses_pair_content", "ncurses_panel_above", "ncurses_panel_below", "ncurses_panel_window", "ncurses_pnoutrefresh", "ncurses_prefresh", "ncurses_putp", "ncurses_qiflush", "ncurses_raw", "ncurses_refresh", "ncurses_replace_panel", "ncurses_reset_prog_mode", "ncurses_reset_shell_mode", "ncurses_resetty", "ncurses_savetty", "ncurses_scr_dump", "ncurses_scr_init", "ncurses_scr_restore", "ncurses_scr_set", "ncurses_scrl", "ncurses_show_panel", "ncurses_slk_attr", "ncurses_slk_attroff", "ncurses_slk_attron", "ncurses_slk_attrset", "ncurses_slk_clear", "ncurses_slk_color", "ncurses_slk_init", "ncurses_slk_noutrefresh", "ncurses_slk_refresh", "ncurses_slk_restore", "ncurses_slk_set", "ncurses_slk_touch", "ncurses_standend", "ncurses_standout", "ncurses_start_color", "ncurses_termattrs", "ncurses_termname", "ncurses_timeout", "ncurses_top_panel", "ncurses_typeahead", "ncurses_ungetch", "ncurses_ungetmouse", "ncurses_update_panels", "ncurses_use_default_colors", "ncurses_use_env", "ncurses_use_extended_names", "ncurses_vidattr", "ncurses_vline", "ncurses_waddch", "ncurses_waddstr", "ncurses_wattroff", "ncurses_wattron", "ncurses_wattrset", "ncurses_wborder", "ncurses_wclear", "ncurses_wcolor_set", "ncurses_werase", "ncurses_wgetch", "ncurses_whline", "ncurses_wmouse_trafo", "ncurses_wmove", "ncurses_wnoutrefresh", "ncurses_wrefresh", "ncurses_wstandend", "ncurses_wstandout", "ncurses_wvline", "next", "next_sibling", "nextframe", "ngettext", "nl2br", "nl_langinfo", "node_name", "node_type", "node_value", "normalize", "notations", "notes_body", "notes_copy_db", "notes_create_db", "notes_create_note", "notes_drop_db", "notes_find_note", "notes_header_info", "notes_list_msgs", "notes_mark_read", "notes_mark_unread", "notes_nav_create", "notes_search", "notes_unread", "notes_version", "nsapi_request_headers", "nsapi_response_headers", "nsapi_virtual", "number_format", "ob_clean", "ob_end_clean", "ob_end_flush", "ob_flush", "ob_get_clean", "ob_get_contents", "ob_get_flush", "ob_get_length", "ob_get_level", "ob_get_status", "ob_gzhandler", "ob_iconv_handler", "ob_implicit_flush", "ob_list_handlers", "ob_start", "ob_tidyhandler", "object", "objectbyanchor", "oci_bind_by_name", "oci_cancel", "oci_close", "oci_commit", "oci_connect", "oci_define_by_name", "oci_error", "oci_execute", "oci_fetch", "oci_fetch_all", "oci_fetch_array", "oci_fetch_assoc", "oci_fetch_object", "oci_fetch_row", "oci_field_is_null", "oci_field_name", "oci_field_precision", "oci_field_scale", "oci_field_size", "oci_field_type", "oci_field_type_raw", "oci_free_statement", "oci_internal_debug", "oci_lob_copy", "oci_lob_is_equal", "oci_new_collection", "oci_new_connect", "oci_new_cursor", "oci_new_descriptor", "oci_num_fields", "oci_num_rows", "oci_parse", "oci_password_change", "oci_pconnect", "oci_result", "oci_rollback", "oci_server_version", "oci_set_prefetch", "oci_statement_type", "ocibindbyname", "ocicancel", "ocicloselob", "ocicollappend", "ocicollassign", "ocicollassignelem", "ocicollgetelem", "ocicollmax", "ocicollsize", "ocicolltrim", "ocicolumnisnull", "ocicolumnname", "ocicolumnprecision", "ocicolumnscale", "ocicolumnsize", "ocicolumntype", "ocicolumntyperaw", "ocicommit", "ocidefinebyname", "ocierror", "ociexecute", "ocifetch", "ocifetchinto", "ocifetchstatement", "ocifreecollection", "ocifreecursor", "ocifreedesc", "ocifreestatement", "ociinternaldebug", "ociloadlob", "ocilogoff", "ocilogon", "ocinewcollection", "ocinewcursor", "ocinewdescriptor", "ocinlogon", "ocinumcols", "ociparse", "ociplogon", "ociresult", "ocirollback", "ocirowcount", "ocisavelob", "ocisavelobfile", "ociserverversion", "ocisetprefetch", "ocistatementtype", "ociwritelobtofile", "ociwritetemporarylob", "octdec", "odbc_autocommit", "odbc_binmode", "odbc_close", "odbc_close_all", "odbc_columnprivileges", "odbc_columns", "odbc_commit", "odbc_connect", "odbc_cursor", "odbc_data_source", "odbc_do", "odbc_error", "odbc_errormsg", "odbc_exec", "odbc_execute", "odbc_fetch_array", "odbc_fetch_into", "odbc_fetch_object", "odbc_fetch_row", "odbc_field_len", "odbc_field_name", "odbc_field_num", "odbc_field_precision", "odbc_field_scale", "odbc_field_type", "odbc_foreignkeys", "odbc_free_result", "odbc_gettypeinfo", "odbc_longreadlen", "odbc_next_result", "odbc_num_fields", "odbc_num_rows", "odbc_pconnect", "odbc_prepare", "odbc_primarykeys", "odbc_procedurecolumns", "odbc_procedures", "odbc_result", "odbc_result_all", "odbc_rollback", "odbc_setoption", "odbc_specialcolumns", "odbc_statistics", "odbc_tableprivileges", "odbc_tables", "offsetexists", "offsetget", "offsetset", "offsetunset", "openal_buffer_create", "openal_buffer_data", "openal_buffer_destroy", "openal_buffer_get", "openal_buffer_loadwav", "openal_context_create", "openal_context_current", "openal_context_destroy", "openal_context_process", "openal_context_suspend", "openal_device_close", "openal_device_open", "openal_listener_get", "openal_listener_set", "openal_source_create", "openal_source_destroy", "openal_source_get", "openal_source_pause", "openal_source_play", "openal_source_rewind", "openal_source_set", "openal_source_stop", "openal_stream", "opendir", "openlog", "openssl_csr_export", "openssl_csr_export_to_file", "openssl_csr_new", "openssl_csr_sign", "openssl_error_string", "openssl_free_key", "openssl_get_privatekey", "openssl_get_publickey", "openssl_open", "openssl_pkcs7_decrypt", "openssl_pkcs7_encrypt", "openssl_pkcs7_sign", "openssl_pkcs7_verify", "openssl_pkey_export", "openssl_pkey_export_to_file", "openssl_pkey_get_private", "openssl_pkey_get_public", "openssl_pkey_new", "openssl_private_decrypt", "openssl_private_encrypt", "openssl_public_decrypt", "openssl_public_encrypt", "openssl_seal", "openssl_sign", "openssl_verify", "openssl_x509_check_private_key", "openssl_x509_checkpurpose", "openssl_x509_export", "openssl_x509_export_to_file", "openssl_x509_free", "openssl_x509_parse", "openssl_x509_read", "ora_bind", "ora_close", "ora_columnname", "ora_columnsize", "ora_columntype", "ora_commit", "ora_commitoff", "ora_commiton", "ora_do", "ora_error", "ora_errorcode", "ora_exec", "ora_fetch", "ora_fetch_into", "ora_getcolumn", "ora_logoff", "ora_logon", "ora_numcols", "ora_numrows", "ora_open", "ora_parse", "ora_plogon", "ora_rollback", "ord", "output", "output_add_rewrite_var", "output_reset_rewrite_vars", "overload", "override_function", "ovrimos_close", "ovrimos_commit", "ovrimos_connect", "ovrimos_cursor", "ovrimos_exec", "ovrimos_execute", "ovrimos_fetch_into", "ovrimos_fetch_row", "ovrimos_field_len", "ovrimos_field_name", "ovrimos_field_num", "ovrimos_field_type", "ovrimos_free_result", "ovrimos_longreadlen", "ovrimos_num_fields", "ovrimos_num_rows", "ovrimos_prepare", "ovrimos_result", "ovrimos_result_all", "ovrimos_rollback", "owner_document", "pack", "parent_node", "parents", "parse_ini_file", "parse_str", "parse_url", "parsekit_compile_file", "parsekit_compile_string", "parsekit_func_arginfo", "passthru", "pathinfo", "pclose", "pcntl_alarm", "pcntl_exec", "pcntl_fork", "pcntl_getpriority", "pcntl_setpriority", "pcntl_signal", "pcntl_wait", "pcntl_waitpid", "pcntl_wexitstatus", "pcntl_wifexited", "pcntl_wifsignaled", "pcntl_wifstopped", "pcntl_wstopsig", "pcntl_wtermsig", "pconnect", "pdf_add_annotation", "pdf_add_bookmark", "pdf_add_launchlink", "pdf_add_locallink", "pdf_add_note", "pdf_add_outline", "pdf_add_pdflink", "pdf_add_thumbnail", "pdf_add_weblink", "pdf_arc", "pdf_arcn", "pdf_attach_file", "pdf_begin_page", "pdf_begin_pattern", "pdf_begin_template", "pdf_circle", "pdf_clip", "pdf_close", "pdf_close_image", "pdf_close_pdi", "pdf_close_pdi_page", "pdf_closepath", "pdf_closepath_fill_stroke", "pdf_closepath_stroke", "pdf_concat", "pdf_continue_text", "pdf_curveto", "pdf_delete", "pdf_end_page", "pdf_end_pattern", "pdf_end_template", "pdf_endpath", "pdf_fill", "pdf_fill_stroke", "pdf_findfont", "pdf_fit_pdi_page", "pdf_get_buffer", "pdf_get_font", "pdf_get_fontname", "pdf_get_fontsize", "pdf_get_image_height", "pdf_get_image_width", "pdf_get_majorversion", "pdf_get_minorversion", "pdf_get_parameter", "pdf_get_pdi_parameter", "pdf_get_pdi_value", "pdf_get_value", "pdf_initgraphics", "pdf_lineto", "pdf_load_font", "pdf_makespotcolor", "pdf_moveto", "pdf_new", "pdf_open", "pdf_open_ccitt", "pdf_open_file", "pdf_open_gif", "pdf_open_image", "pdf_open_image_file", "pdf_open_jpeg", "pdf_open_memory_image", "pdf_open_pdi", "pdf_open_pdi_page", "pdf_open_png", "pdf_open_tiff", "pdf_place_image", "pdf_place_pdi_page", "pdf_rect", "pdf_restore", "pdf_rotate", "pdf_save", "pdf_scale", "pdf_set_border_color", "pdf_set_border_dash", "pdf_set_border_style", "pdf_set_char_spacing", "pdf_set_duration", "pdf_set_font", "pdf_set_horiz_scaling", "pdf_set_info", "pdf_set_info_author", "pdf_set_info_creator", "pdf_set_info_keywords", "pdf_set_info_subject", "pdf_set_info_title", "pdf_set_leading", "pdf_set_parameter", "pdf_set_text_matrix", "pdf_set_text_pos", "pdf_set_text_rendering", "pdf_set_text_rise", "pdf_set_value", "pdf_set_word_spacing", "pdf_setcolor", "pdf_setdash", "pdf_setflat", "pdf_setfont", "pdf_setgray", "pdf_setgray_fill", "pdf_setgray_stroke", "pdf_setlinecap", "pdf_setlinejoin", "pdf_setlinewidth", "pdf_setmatrix", "pdf_setmiterlimit", "pdf_setpolydash", "pdf_setrgbcolor", "pdf_setrgbcolor_fill", "pdf_setrgbcolor_stroke", "pdf_show", "pdf_show_boxed", "pdf_show_xy", "pdf_skew", "pdf_stringwidth", "pdf_stroke", "pdf_translate", "pfpro_cleanup", "pfpro_init", "pfpro_process", "pfpro_process_raw", "pfpro_version", "pfsockopen", "pg_affected_rows", "pg_cancel_query", "pg_client_encoding", "pg_close", "pg_connect", "pg_connection_busy", "pg_connection_reset", "pg_connection_status", "pg_convert", "pg_copy_from", "pg_copy_to", "pg_dbname", "pg_delete", "pg_end_copy", "pg_escape_bytea", "pg_escape_string", "pg_fetch_all", "pg_fetch_array", "pg_fetch_assoc", "pg_fetch_object", "pg_fetch_result", "pg_fetch_row", "pg_field_is_null", "pg_field_name", "pg_field_num", "pg_field_prtlen", "pg_field_size", "pg_field_type", "pg_free_result", "pg_get_notify", "pg_get_pid", "pg_get_result", "pg_host", "pg_insert", "pg_last_error", "pg_last_notice", "pg_last_oid", "pg_lo_close", "pg_lo_create", "pg_lo_export", "pg_lo_import", "pg_lo_open", "pg_lo_read", "pg_lo_read_all", "pg_lo_seek", "pg_lo_tell", "pg_lo_unlink", "pg_lo_write", "pg_meta_data", "pg_num_fields", "pg_num_rows", "pg_options", "pg_parameter_status", "pg_pconnect", "pg_ping", "pg_port", "pg_put_line", "pg_query", "pg_result_error", "pg_result_seek", "pg_result_status", "pg_select", "pg_send_query", "pg_set_client_encoding", "pg_trace", "pg_tty", "pg_unescape_bytea", "pg_untrace", "pg_update", "pg_version", "php_check_syntax", "php_ini_scanned_files", "php_logo_guid", "php_sapi_name", "php_strip_whitespace", "php_uname", "phpcredits", "phpinfo", "phpversion", "pi", "png2wbmp", "popen", "pos", "posix_ctermid", "posix_get_last_error", "posix_getcwd", "posix_getegid", "posix_geteuid", "posix_getgid", "posix_getgrgid", "posix_getgrnam", "posix_getgroups", "posix_getlogin", "posix_getpgid", "posix_getpgrp", "posix_getpid", "posix_getppid", "posix_getpwnam", "posix_getpwuid", "posix_getrlimit", "posix_getsid", "posix_getuid", "posix_isatty", "posix_kill", "posix_mkfifo", "posix_setegid", "posix_seteuid", "posix_setgid", "posix_setpgid", "posix_setsid", "posix_setuid", "posix_strerror", "posix_times", "posix_ttyname", "posix_uname", "pow", "prefix", "preg_grep", "preg_match", "preg_match_all", "preg_quote", "preg_replace", "preg_replace_callback", "preg_split", "prepare", "prev", "previous_sibling", "print_r", "printer_abort", "printer_close", "printer_create_brush", "printer_create_dc", "printer_create_font", "printer_create_pen", "printer_delete_brush", "printer_delete_dc", "printer_delete_font", "printer_delete_pen", "printer_draw_bmp", "printer_draw_chord", "printer_draw_elipse", "printer_draw_line", "printer_draw_pie", "printer_draw_rectangle", "printer_draw_roundrect", "printer_draw_text", "printer_end_doc", "printer_end_page", "printer_get_option", "printer_list", "printer_logical_fontheight", "printer_open", "printer_select_brush", "printer_select_font", "printer_select_pen", "printer_set_option", "printer_start_doc", "printer_start_page", "printer_write", "printf", "proc_close", "proc_get_status", "proc_nice", "proc_open", "proc_terminate", "process", "property_exists", "pspell_add_to_personal", "pspell_add_to_session", "pspell_check", "pspell_clear_session", "pspell_config_create", "pspell_config_data_dir", "pspell_config_dict_dir", "pspell_config_ignore", "pspell_config_mode", "pspell_config_personal", "pspell_config_repl", "pspell_config_runtogether", "pspell_config_save_repl", "pspell_new", "pspell_new_config", "pspell_new_personal", "pspell_save_wordlist", "pspell_store_replacement", "pspell_suggest", "public_id", "putenv", "qdom_error", "qdom_tree", "query", "quoted_printable_decode", "quotemeta", "rad2deg", "rand", "range", "rar_close", "rar_entry_get", "rar_list", "rar_open", "rawurldecode", "rawurlencode", "read", "read_exif_data", "readdir", "readfile", "readgzfile", "readline", "readline_add_history", "readline_callback_handler_install", "readline_callback_handler_remove", "readline_callback_read_char", "readline_clear_history", "readline_completion_function", "readline_info", "readline_list_history", "readline_on_new_line", "readline_read_history", "readline_redisplay", "readline_write_history", "readlink", "realpath", "reason", "recode", "recode_file", "recode_string", "register_shutdown_function", "register_tick_function", "registernamespace", "relaxngvalidate", "relaxngvalidatesource", "remove", "remove_attribute", "remove_child", "removeattribute", "removeattributenode", "removeattributens", "removechild", "rename", "rename_function", "replace", "replace_child", "replace_node", "replacechild", "replacedata", "reset", "restore_error_handler", "restore_exception_handler", "restore_include_path", "result_dump_file", "result_dump_mem", "rewind", "rewinddir", "rmdir", "rollback", "rotate", "rotateto", "round", "rowcount", "rsort", "rtrim", "save", "savehtml", "savehtmlfile", "savexml", "scale", "scaleto", "scandir", "schemavalidate", "schemavalidatesource", "seek", "sem_acquire", "sem_get", "sem_release", "sem_remove", "serialize", "sesam_affected_rows", "sesam_commit", "sesam_connect", "sesam_diagnostic", "sesam_disconnect", "sesam_errormsg", "sesam_execimm", "sesam_fetch_array", "sesam_fetch_result", "sesam_fetch_row", "sesam_field_array", "sesam_field_name", "sesam_free_result", "sesam_num_fields", "sesam_query", "sesam_rollback", "sesam_seek_row", "sesam_settransaction", "session_cache_expire", "session_cache_limiter", "session_commit", "session_decode", "session_destroy", "session_encode", "session_get_cookie_params", "session_id", "session_is_registered", "session_module_name", "session_name", "session_regenerate_id", "session_register", "session_save_path", "session_set_cookie_params", "session_set_save_handler", "session_start", "session_unregister", "session_unset", "session_write_close", "set", "set_attribute", "set_content", "set_error_handler", "set_exception_handler", "set_file_buffer", "set_include_path", "set_magic_quotes_runtime", "set_name", "set_namespace", "set_time_limit", "setaction", "setattribute", "setattributenode", "setattributenodens", "setattributens", "setbackground", "setbounds", "setbuffering", "setclass", "setcolor", "setcommitedversion", "setcookie", "setdepth", "setdimension", "setdown", "setfont", "setframes", "setheight", "sethit", "setindentation", "setleftfill", "setleftmargin", "setline", "setlinespacing", "setlocale", "setmargins", "setname", "setover", "setpersistence", "setrate", "setratio", "setrawcookie", "setrightfill", "setrightmargin", "setspacing", "settype", "setup", "sha1", "sha1_file", "shell_exec", "shm_attach", "shm_detach", "shm_get_var", "shm_put_var", "shm_remove", "shm_remove_var", "shmop_close", "shmop_delete", "shmop_open", "shmop_read", "shmop_size", "shmop_write", "show_source", "shuffle", "similar_text", "simplexml_import_dom", "simplexml_load_file", "simplexml_load_string", "sin", "sinh", "size", "sizeof", "skewx", "skewxto", "skewy", "skewyto", "sleep", "snmp_get_quick_print", "snmp_get_valueretrieval", "snmp_read_mib", "snmp_set_enum_print", "snmp_set_oid_numeric_print", "snmp_set_quick_print", "snmp_set_valueretrieval", "snmpget", "snmpgetnext", "snmprealwalk", "snmpset", "snmpwalk", "snmpwalkoid", "socket_accept", "socket_bind", "socket_clear_error", "socket_close", "socket_connect", "socket_create", "socket_create_listen", "socket_create_pair", "socket_get_option", "socket_get_status", "socket_getpeername", "socket_getsockname", "socket_last_error", "socket_listen", "socket_read", "socket_recv", "socket_recvfrom", "socket_select", "socket_send", "socket_sendto", "socket_set_block", "socket_set_blocking", "socket_set_nonblock", "socket_set_option", "socket_set_timeout", "socket_shutdown", "socket_strerror", "socket_write", "sort", "soundex", "specified", "spl_classes", "split", "spliti", "splittext", "sprintf", "sql_regcase", "sqlite_array_query", "sqlite_busy_timeout", "sqlite_changes", "sqlite_close", "sqlite_column", "sqlite_create_aggregate", "sqlite_create_function", "sqlite_current", "sqlite_error_string", "sqlite_escape_string", "sqlite_exec", "sqlite_factory", "sqlite_fetch_all", "sqlite_fetch_array", "sqlite_fetch_column_types", "sqlite_fetch_object", "sqlite_fetch_single", "sqlite_fetch_string", "sqlite_field_name", "sqlite_has_more", "sqlite_has_prev", "sqlite_last_error", "sqlite_last_insert_rowid", "sqlite_libencoding", "sqlite_libversion", "sqlite_next", "sqlite_num_fields", "sqlite_num_rows", "sqlite_open", "sqlite_popen", "sqlite_prev", "sqlite_query", "sqlite_rewind", "sqlite_seek", "sqlite_single_query", "sqlite_udf_decode_binary", "sqlite_udf_encode_binary", "sqlite_unbuffered_query", "sqrt", "srand", "srcanchors", "srcsofdst", "sscanf", "stat", "str_ireplace", "str_pad", "str_repeat", "str_replace", "str_rot13", "str_shuffle", "str_split", "str_word_count", "strcasecmp", "strchr", "strcmp", "strcoll", "strcspn", "stream_context_create", "stream_context_get_default", "stream_context_get_options", "stream_context_set_option", "stream_context_set_params", "stream_copy_to_stream", "stream_filter_append", "stream_filter_prepend", "stream_filter_register", "stream_filter_remove", "stream_get_contents", "stream_get_filters", "stream_get_line", "stream_get_meta_data", "stream_get_transports", "stream_get_wrappers", "stream_register_wrapper", "stream_select", "stream_set_blocking", "stream_set_timeout", "stream_set_write_buffer", "stream_socket_accept", "stream_socket_client", "stream_socket_enable_crypto", "stream_socket_get_name", "stream_socket_recvfrom", "stream_socket_sendto", "stream_socket_server", "stream_wrapper_register", "stream_wrapper_restore", "stream_wrapper_unregister", "streammp3", "strftime", "strip_tags", "stripcslashes", "stripos", "stripslashes", "stristr", "strlen", "strnatcasecmp", "strnatcmp", "strncasecmp", "strncmp", "strpbrk", "strpos", "strptime", "strrchr", "strrev", "strripos", "strrpos", "strspn", "strstr", "strtok", "strtolower", "strtotime", "strtoupper", "strtr", "strval", "substr", "substr_compare", "substr_count", "substr_replace", "substringdata", "swf_actiongeturl", "swf_actiongotoframe", "swf_actiongotolabel", "swf_actionnextframe", "swf_actionplay", "swf_actionprevframe", "swf_actionsettarget", "swf_actionstop", "swf_actiontogglequality", "swf_actionwaitforframe", "swf_addbuttonrecord", "swf_addcolor", "swf_closefile", "swf_definebitmap", "swf_definefont", "swf_defineline", "swf_definepoly", "swf_definerect", "swf_definetext", "swf_endbutton", "swf_enddoaction", "swf_endshape", "swf_endsymbol", "swf_fontsize", "swf_fontslant", "swf_fonttracking", "swf_getbitmapinfo", "swf_getfontinfo", "swf_getframe", "swf_labelframe", "swf_lookat", "swf_modifyobject", "swf_mulcolor", "swf_nextid", "swf_oncondition", "swf_openfile", "swf_ortho", "swf_ortho2", "swf_perspective", "swf_placeobject", "swf_polarview", "swf_popmatrix", "swf_posround", "swf_pushmatrix", "swf_removeobject", "swf_rotate", "swf_scale", "swf_setfont", "swf_setframe", "swf_shapearc", "swf_shapecurveto", "swf_shapecurveto3", "swf_shapefillbitmapclip", "swf_shapefillbitmaptile", "swf_shapefilloff", "swf_shapefillsolid", "swf_shapelinesolid", "swf_shapelineto", "swf_shapemoveto", "swf_showframe", "swf_startbutton", "swf_startdoaction", "swf_startshape", "swf_startsymbol", "swf_textwidth", "swf_translate", "swf_viewport", "swfbutton_keypress", "sybase_affected_rows", "sybase_close", "sybase_connect", "sybase_data_seek", "sybase_deadlock_retry_count", "sybase_fetch_array", "sybase_fetch_assoc", "sybase_fetch_field", "sybase_fetch_object", "sybase_fetch_row", "sybase_field_seek", "sybase_free_result", "sybase_get_last_message", "sybase_min_client_severity", "sybase_min_error_severity", "sybase_min_message_severity", "sybase_min_server_severity", "sybase_num_fields", "sybase_num_rows", "sybase_pconnect", "sybase_query", "sybase_result", "sybase_select_db", "sybase_set_message_handler", "sybase_unbuffered_query", "symlink", "syslog", "system", "system_id", "tagname", "tan", "tanh", "target", "tcpwrap_check", "tell", "tempnam", "textdomain", "tidy_access_count", "tidy_clean_repair", "tidy_config_count", "tidy_diagnose", "tidy_error_count", "tidy_get_body", "tidy_get_config", "tidy_get_error_buffer", "tidy_get_head", "tidy_get_html", "tidy_get_html_ver", "tidy_get_output", "tidy_get_release", "tidy_get_root", "tidy_get_status", "tidy_getopt", "tidy_is_xhtml", "tidy_is_xml", "tidy_load_config", "tidy_parse_file", "tidy_parse_string", "tidy_repair_file", "tidy_repair_string", "tidy_reset_config", "tidy_save_config", "tidy_set_encoding", "tidy_setopt", "tidy_warning_count", "time", "time_nanosleep", "title", "tmpfile", "token_get_all", "token_name", "touch", "trigger_error", "trim", "truncate", "type", "uasort", "ucfirst", "ucwords", "udm_add_search_limit", "udm_alloc_agent", "udm_alloc_agent_array", "udm_api_version", "udm_cat_list", "udm_cat_path", "udm_check_charset", "udm_check_stored", "udm_clear_search_limits", "udm_close_stored", "udm_crc32", "udm_errno", "udm_error", "udm_find", "udm_free_agent", "udm_free_ispell_data", "udm_free_res", "udm_get_doc_count", "udm_get_res_field", "udm_get_res_param", "udm_hash32", "udm_load_ispell_data", "udm_open_stored", "udm_set_agent_param", "uksort", "umask", "uniqid", "unixtojd", "unlink", "unlink_node", "unlock", "unpack", "unregister_tick_function", "unserialize", "urldecode", "urlencode", "user", "user_error", "userlist", "usleep", "usort", "utf8_decode", "utf8_encode", "valid", "validate", "value", "values", "var_dump", "var_export", "variant_abs", "variant_add", "variant_and", "variant_cast", "variant_cat", "variant_cmp", "variant_date_from_timestamp", "variant_date_to_timestamp", "variant_div", "variant_eqv", "variant_fix", "variant_get_type", "variant_idiv", "variant_imp", "variant_int", "variant_mod", "variant_mul", "variant_neg", "variant_not", "variant_or", "variant_pow", "variant_round", "variant_set", "variant_set_type", "variant_sub", "variant_xor", "version_compare", "vfprintf", "virtual", "vpopmail_add_alias_domain", "vpopmail_add_alias_domain_ex", "vpopmail_add_domain", "vpopmail_add_domain_ex", "vpopmail_add_user", "vpopmail_alias_add", "vpopmail_alias_del", "vpopmail_alias_del_domain", "vpopmail_alias_get", "vpopmail_alias_get_all", "vpopmail_auth_user", "vpopmail_del_domain", "vpopmail_del_domain_ex", "vpopmail_del_user", "vpopmail_error", "vpopmail_passwd", "vpopmail_set_user_quota", "vprintf", "vsprintf", "w32api_deftype", "w32api_init_dtype", "w32api_invoke_function", "w32api_register_function", "w32api_set_call_method", "wddx_add_vars", "wddx_deserialize", "wddx_packet_end", "wddx_packet_start", "wddx_serialize_value", "wddx_serialize_vars", "wordwrap", "write", "writetemporary", "xattr_get", "xattr_list", "xattr_remove", "xattr_set", "xattr_supported", "xdiff_file_diff", "xdiff_file_diff_binary", "xdiff_file_merge3", "xdiff_file_patch", "xdiff_file_patch_binary", "xdiff_string_diff", "xdiff_string_diff_binary", "xdiff_string_merge3", "xdiff_string_patch", "xdiff_string_patch_binary", "xinclude", "xml_error_string", "xml_get_current_byte_index", "xml_get_current_column_number", "xml_get_current_line_number", "xml_get_error_code", "xml_parse", "xml_parse_into_struct", "xml_parser_create", "xml_parser_create_ns", "xml_parser_free", "xml_parser_get_option", "xml_parser_set_option", "xml_set_character_data_handler", "xml_set_default_handler", "xml_set_element_handler", "xml_set_end_namespace_decl_handler", "xml_set_external_entity_ref_handler", "xml_set_notation_decl_handler", "xml_set_object", "xml_set_processing_instruction_handler", "xml_set_start_namespace_decl_handler", "xml_set_unparsed_entity_decl_handler", "xmlrpc_decode", "xmlrpc_decode_request", "xmlrpc_encode", "xmlrpc_encode_request", "xmlrpc_get_type", "xmlrpc_is_fault", "xmlrpc_parse_method_descriptions", "xmlrpc_server_add_introspection_data", "xmlrpc_server_call_method", "xmlrpc_server_create", "xmlrpc_server_destroy", "xmlrpc_server_register_introspection_callback", "xmlrpc_server_register_method", "xmlrpc_set_type", "xpath", "xpath_eval", "xpath_eval_expression", "xpath_new_context", "xptr_eval", "xptr_new_context", "xsl_xsltprocessor_get_parameter", "xsl_xsltprocessor_has_exslt_support", "xsl_xsltprocessor_import_stylesheet", "xsl_xsltprocessor_register_php_functions", "xsl_xsltprocessor_remove_parameter", "xsl_xsltprocessor_set_parameter", "xsl_xsltprocessor_transform_to_doc", "xsl_xsltprocessor_transform_to_uri", "xsl_xsltprocessor_transform_to_xml", "xslt_backend_info", "xslt_backend_name", "xslt_backend_version", "xslt_create", "xslt_errno", "xslt_error", "xslt_free", "xslt_getopt", "xslt_process", "xslt_set_base", "xslt_set_encoding", "xslt_set_error_handler", "xslt_set_log", "xslt_set_object", "xslt_set_sax_handler", "xslt_set_sax_handlers", "xslt_set_scheme_handler", "xslt_set_scheme_handlers", "xslt_setopt", "yaz_addinfo", "yaz_ccl_conf", "yaz_ccl_parse", "yaz_close", "yaz_connect", "yaz_database", "yaz_element", "yaz_errno", "yaz_error", "yaz_es_result", "yaz_get_option", "yaz_hits", "yaz_itemorder", "yaz_present", "yaz_range", "yaz_record", "yaz_scan", "yaz_scan_result", "yaz_schema", "yaz_search", "yaz_set_option", "yaz_sort", "yaz_syntax", "yaz_wait", "yp_all", "yp_cat", "yp_err_string", "yp_errno", "yp_first", "yp_get_default_domain", "yp_master", "yp_match", "yp_next", "yp_order", "zend_logo_guid", "zend_version", "zip_close", "zip_entry_close", "zip_entry_compressedsize", "zip_entry_compressionmethod", "zip_entry_filesize", "zip_entry_name", "zip_entry_open", "zip_entry_read", "zip_open", "zip_read", "zlib_get_coding_type", "apache_request_headers", "apache_response_headers", "attr_get", "attr_set", "autocommit", "bind_param", "bind_result", "bzclose", "bzflush", "bzwrite", "change_user", "character_set_name", "checkdnsrr", "chop", "client_encoding", "close", "commit", "connect", "data_seek", "debug", "disable_reads_from_master", "disable_rpl_parse", "diskfreespace", "doubleval", "dump_debug_info", "enable_reads_from_master", "enable_rpl_parse", "escape_string", "execute", "fbird_add_user", "fbird_affected_rows", "fbird_backup", "fbird_blob_add", "fbird_blob_cancel", "fbird_blob_close", "fbird_blob_create", "fbird_blob_echo", "fbird_blob_get", "fbird_blob_import", "fbird_blob_info", "fbird_blob_open", "fbird_close", "fbird_commit", "fbird_commit_ret", "fbird_connect", "fbird_db_info", "fbird_delete_user", "fbird_drop_db", "fbird_errcode", "fbird_errmsg", "fbird_execute", "fbird_fetch_assoc", "fbird_fetch_object", "fbird_fetch_row", "fbird_field_info", "fbird_free_event_handler", "fbird_free_query", "fbird_free_result", "fbird_gen_id", "fbird_maintain_db", "fbird_modify_user", "fbird_name_result", "fbird_num_fields", "fbird_num_params", "fbird_num_rows", "fbird_param_info", "fbird_pconnect", "fbird_prepare", "fbird_query", "fbird_restore", "fbird_rollback", "fbird_rollback_ret", "fbird_server_info", "fbird_service_attach", "fbird_service_detach", "fbird_set_event_handler", "fbird_trans", "fbird_wait_event", "fbsql", "fbsql_tablename", "fetch", "fetch_array", "fetch_assoc", "fetch_field", "fetch_field_direct", "fetch_fields", "fetch_object", "fetch_row", "field_count", "field_seek", "fputs", "free", "free_result", "ftp_quit", "get_client_info", "get_required_files", "get_server_info", "getallheaders", "getmxrr", "gmp_div", "gzclose", "gzeof", "gzgetc", "gzgets", "gzgetss", "gzpassthru", "gzputs", "gzread", "gzrewind", "gzseek", "gztell", "gzwrite", "imap_create", "imap_fetchtext", "imap_header", "imap_listmailbox", "imap_listsubscribed", "imap_rename", "ini_alter", "init", "is_double", "is_int", "is_integer", "is_real", "is_writeable", "join", "key_exists", "kill", "ldap_close", "ldap_modify", "magic_quotes_runtime", "master_query", "ming_keypress", "ming_setcubicthreshold", "ming_setscale", "ming_useconstants", "ming_useswfversion", "more_results", "msql", "msql_affected_rows", "msql_createdb", "msql_dbname", "msql_dropdb", "msql_fieldflags", "msql_fieldlen", "msql_fieldname", "msql_fieldtable", "msql_fieldtype", "msql_freeresult", "msql_listdbs", "msql_listfields", "msql_listtables", "msql_numfields", "msql_numrows", "msql_regcase", "msql_selectdb", "msql_tablename", "mssql_affected_rows", "mssql_close", "mssql_connect", "mssql_data_seek", "mssql_deadlock_retry_count", "mssql_fetch_array", "mssql_fetch_assoc", "mssql_fetch_field", "mssql_fetch_object", "mssql_fetch_row", "mssql_field_seek", "mssql_free_result", "mssql_get_last_message", "mssql_min_client_severity", "mssql_min_error_severity", "mssql_min_message_severity", "mssql_min_server_severity", "mssql_num_fields", "mssql_num_rows", "mssql_pconnect", "mssql_query", "mssql_result", "mssql_select_db", "mssql_set_message_handler", "mssql_unbuffered_query", "multi_query", "mysql", "mysql_createdb", "mysql_db_name", "mysql_dbname", "mysql_dropdb", "mysql_fieldflags", "mysql_fieldlen", "mysql_fieldname", "mysql_fieldtable", "mysql_fieldtype", "mysql_freeresult", "mysql_listdbs", "mysql_listfields", "mysql_listtables", "mysql_numfields", "mysql_numrows", "mysql_selectdb", "mysql_table_name", "mysql_tablename", "mysqli", "mysqli_execute", "mysqli_fetch", "mysqli_set_opt", "next_result", "num_rows", "oci_free_cursor", "ocibindbyname", "ocicancel", "ocicollappend", "ocicollassignelem", "ocicollgetelem", "ocicollmax", "ocicollsize", "ocicolltrim", "ocicolumnisnull", "ocicolumnname", "ocicolumnprecision", "ocicolumnscale", "ocicolumnsize", "ocicolumntype", "ocicolumntyperaw", "ocicommit", "ocidefinebyname", "ocierror", "ociexecute", "ocifetch", "ocifetchstatement", "ocifreecollection", "ocifreecursor", "ocifreedesc", "ocifreestatement", "ociinternaldebug", "ociloadlob", "ocilogoff", "ocilogon", "ocinewcollection", "ocinewcursor", "ocinewdescriptor", "ocinlogon", "ocinumcols", "ociparse", "ocipasswordchange", "ociplogon", "ociresult", "ocirollback", "ocirowcount", "ocisavelob", "ocisavelobfile", "ociserverversion", "ocisetprefetch", "ocistatementtype", "ociwritelobtofile", "odbc_do", "odbc_field_precision", "openssl_free_key", "openssl_get_privatekey", "openssl_get_publickey", "options", "pg_clientencoding", "pg_cmdtuples", "pg_errormessage", "pg_exec", "pg_fieldisnull", "pg_fieldname", "pg_fieldnum", "pg_fieldprtlen", "pg_fieldsize", "pg_fieldtype", "pg_freeresult", "pg_getlastoid", "pg_loclose", "pg_locreate", "pg_loexport", "pg_loimport", "pg_loopen", "pg_loread", "pg_loreadall", "pg_lounlink", "pg_lowrite", "pg_numfields", "pg_numrows", "pg_result", "pg_setclientencoding", "ping", "pos", "posix_errno", "prepare", "query", "read_exif_data", "real_connect", "real_escape_string", "real_query", "recode", "reset", "result_metadata", "rollback", "rpl_parse_enabled", "rpl_probe", "rpl_query_type", "select_db", "send_long_data", "session_commit", "set_file_buffer", "set_local_infile_default", "set_local_infile_handler", "set_opt", "show_source", "sizeof", "slave_query", "snmpwalkoid", "socket_get_status", "socket_getopt", "socket_set_blocking", "socket_set_timeout", "socket_setopt", "sqlite_fetch_string", "sqlite_has_more", "ssl_set", "stat", "stmt", "stmt_init", "store_result", "strchr", "stream_register_wrapper", "thread_safe", "use_result", "user_error", "velocis_autocommit", "velocis_close", "velocis_commit", "velocis_connect", "velocis_exec", "velocis_fetch", "velocis_fieldname", "velocis_fieldnum", "velocis_freeresult", "velocis_off_autocommit", "velocis_result", "velocis_rollback", "virtual", "xdebug_break", "xdebug_call_class", "xdebug_call_file", "xdebug_call_function", "xdebug_call_line", "xdebug_disable", "xdebug_dump_function_profile", "xdebug_dump_function_trace", "xdebug_dump_superglobals", "xdebug_enable", "xdebug_get_code_coverage", "xdebug_get_function_count", "xdebug_get_function_profile", "xdebug_get_function_stack", "xdebug_get_function_trace", "xdebug_get_stack_depth", "xdebug_is_enabled", "xdebug_memory_usage", "xdebug_peak_memory_usage", "xdebug_print_function_stack", "xdebug_start_code_coverage", "xdebug_start_profiling", "xdebug_start_trace", "xdebug_stop_code_coverage", "xdebug_stop_profiling", "xdebug_stop_trace", "xdebug_time_index", "xdebug_var_dump", "assertCopy", "assertEqual", "assertError", "assertErrorPattern", "assertFalse", "assertIdentical", "assertIsA", "assertNoErrors", "assertNoUnwantedPattern", "assertNotA", "assertNotEqual", "assertNotIdentical", "assertNotNull", "assertNull", "assertReference", "assertTrue", "assertWantedPattern", "setReturnValue", "setReturnValueAt", "setReturnReference", "setReturnReferenceAt", "expectArguments", "expectArgumentsAt", "expectCallCount", "expectMaximumCallCount", "expectMinimumCallCount", "expectNever", "expectOnce", "expectAtLeastOnce", "tally", "dump", "error", "fail", "pass", "sendMessage", "setUp", "signal", "swallowErrors", "tearDown", "__autoload", "__destruct", "__get", "__set", "__sleep", "__wakeup", });
        KEYWORDS1.add("KEYWORD4", new String[]{"arrayiterator", "arrayobject", "cachingiterator", "cachingrecursiveiterator", "collection", "descriptor", "directoryiterator", "domattr", "domattribute", "domcharacterdata", "domdocument", "domdocumenttype", "domelement", "domimplementation", "domnamednodemap", "domnode", "domnodelist", "domprocessinginstruction", "domtext", "domxpath", "domxsltstylesheet", "filteriterator", "hw_api", "hw_api_attribute", "hw_api_content", "hw_api_error", "hw_api_object", "hw_api_reason", "limititerator", "lob", "memcache", "parentiterator", "pdo", "pdostatement", "rar", "recursivedirectoryiterator", "recursiveiteratoriterator", "simplexmlelement", "simplexmliterator", "soapclient", "soapfault", "soapheader", "soapparam", "soapserver", "soapvar", "swfaction", "swfbitmap", "swfbutton", "swfdisplayitem", "swffill", "swffont", "swfgradient", "swfmorph", "swfmovie", "swfshape", "swfsprite", "swftext", "swftextfield", "tidy", "tidy_node", "variant", "parent", "self", "stdClass", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES22() {
        RULES RULES1 = new RULES();
        RULES1.SET = "KEYWORDS_VISIBILITY";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"private", "protected", "public", });
        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES23() {
        RULES RULES1 = new RULES();
        RULES1.SET = "JAVASCRIPT_OPENTAG";
        RULES1.DEFAULT = "MARKUP";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ">";
        SEQ1.TYPE = "MARKUP";
        SEQ1.DELEGATE = "JAVASCRIPT";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TO_LITERAL+PHP";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "html::TAGS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES24() {
        RULES RULES1 = new RULES();
        RULES1.SET = "TO_LITERAL+PHP";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "LITERAL1+PHP";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "'";
        END END1 = new END();
        END1.text = "'";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "LITERAL2+PHP";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TO_PHP";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        return RULES1;
    }

    private RULES RULES25() {
        RULES RULES1 = new RULES();
        RULES1.SET = "JAVASCRIPT";
        RULES1.DEFAULT = "MARKUP";
        RULES1.ESCAPE = "\\";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TO_LITERAL+PHP";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "TO_PHP";
        IMPORT IMPORT3 = new IMPORT();
        IMPORT3.DELEGATE = "javascript::MAIN";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, IMPORT3, };

        return RULES1;
    }

    private RULES RULES26() {
        RULES RULES1 = new RULES();
        RULES1.SET = "LITERAL1+PHP";
        RULES1.DEFAULT = "LITERAL1";
        RULES1.ESCAPE = "\\";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TO_PHP";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        return RULES1;
    }

    private RULES RULES27() {
        RULES RULES1 = new RULES();
        RULES1.SET = "LITERAL2+PHP";
        RULES1.DEFAULT = "LITERAL2";
        RULES1.ESCAPE = "\\";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TO_PHP";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        return RULES1;
    }

    private RULES RULES28() {
        RULES RULES1 = new RULES();
        RULES1.SET = "COMMENT1+PHP";
        RULES1.DEFAULT = "COMMENT1";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "TO_PHP";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        return RULES1;
    }

    private RULES RULES29() {
        RULES RULES1 = new RULES();
        RULES1.SET = "TO_PHP";
        RULES1.DEFAULT = "MARKUP";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "MARKUP";
        SPAN1.DELEGATE = "PHP";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<?php";
        END END1 = new END();
        END1.text = "?>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "MARKUP";
        SPAN2.DELEGATE = "PHP";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "<?";
        END END2 = new END();
        END2.text = "?>";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "MARKUP";
        SPAN3.DELEGATE = "PHP";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "<%=";
        END END3 = new END();
        END3.text = "%>";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        return RULES1;
    }

    private RULES RULES30() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PHPDOC_BLOCK";
        RULES1.DEFAULT = "COMMENT4";
        RULES1.IGNORE_CASE = "TRUE";
        return RULES1;
    }

    private RULES RULES31() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PHPDOC";
        RULES1.DEFAULT = "COMMENT3";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<!--";
        END END1 = new END();
        END1.text = "-->";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "<<";
        SEQ1.TYPE = "COMMENT3";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "<=";
        SEQ2.TYPE = "COMMENT3";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "<";
        SEQ3.TYPE = "COMMENT3";
        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

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

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.NO_WORD_BREAK = "FALSE";
        SPAN_REGEXP1.TYPE = "LABEL";
        SPAN_REGEXP1.DELEGATE = "PHPDOC_BLOCK";
        SPAN_REGEXP1.HASH_CHAR = "@";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "@(?:param|throws|exception|serialField)(\\s)";
        END END4 = new END();
        END4.text = "$1";
        SPAN_REGEXP1.END = new END[] { END4, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.NO_WORD_BREAK = "FALSE";
        SPAN_REGEXP2.TYPE = "LABEL";
        SPAN_REGEXP2.DELEGATE = "PHPDOC_BLOCK";
        SPAN_REGEXP2.HASH_CHAR = "{@";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "\\{@(internal|link)\\s";
        END END5 = new END();
        END5.text = "}";
        SPAN_REGEXP2.END = new END[] { END5, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "MARKUP";
        SPAN4.DELEGATE = "PHP";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "<code>";
        END END6 = new END();
        END6.text = "</code>";
        SPAN4.END = new END[] { END6, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN6, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LABEL", new String[]{"@abstract", "@access", "@author", "@category", "@const", "@constant", "@copyright", "@deprecated", "@example", "@filesource", "@final", "@global", "@ignore", "@internal", "@license", "@link", "@name", "@package", "@param", "@return", "@see", "@since", "@static", "@staticvar", "@subpackage", "@throws", "@todo", "@tutorial", "@uses", "@var", "@version", });
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES32() {
        RULES RULES1 = new RULES();
        RULES1.SET = "INVALID_LT";
        RULES1.DEFAULT = "INVALID";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "<";
        SEQ1.TYPE = "INVALID";
        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), RULES6(), RULES7(), RULES8(), RULES9(), RULES10(), RULES11(), RULES12(), RULES13(), RULES14(), RULES15(), RULES16(), RULES17(), RULES18(), RULES19(), RULES20(), RULES21(), RULES22(), RULES23(), RULES24(), RULES25(), RULES26(), RULES27(), RULES28(), RULES29(), RULES30(), RULES31(), RULES32(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
