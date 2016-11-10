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
public class ClipsLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = ";";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "\\s*(((if|while)\\s*\\(|else\\s*|else\\s+if\\s*\\(|for\\s*\\(.*\\))[^{;]*)";
        PROPERTY2.NAME = "indentNextLine";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "(0[lL]?|[1-9]\\d{0,9}(\\d{0,9}[lL])?|0[xX]\\p{XDigit}{1,8}(\\p{XDigit}{0,8}[lL])?|0[0-7]{1,11}([0-7]{0,11}[lL])?|([0-9]+\\.[0-9]*|\\.[0-9]+)([eE][+-]?[0-9]+)?[fFdD]?|[0-9]+([eE][+-]?[0-9]+[fFdD]?|([eE][+-]?[0-9]+)?[fFdD]))";
        RULES1.IGNORE_CASE = "FALSE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = ";";
        EOL_SPAN1.TYPE = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "'";
        END END1 = new END();
        END1.text = "'";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

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
        SPAN3.TYPE = "LITERAL2";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "[";
        END END3 = new END();
        END3.text = "]";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=>";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "?";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "><";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = ">";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = ">=";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "<";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "<=";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = ">-";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "+";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "-";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "*";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "/";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "=";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "**";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "~";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "\\";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "|";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "&";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = ":";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "$";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "(";
        SEQ21.TYPE = "MARKUP";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = ")";
        SEQ22.TYPE = "MARKUP";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "[";
        SEQ23.TYPE = "MARKUP";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "]";
        SEQ24.TYPE = "MARKUP";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "{";
        SEQ25.TYPE = "NULL";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = "}";
        SEQ26.TYPE = "NULL";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"deffacts", "deftemplate", "defglobal", "defrule", "deffunction", "defgeneric", "defmethod", "defclass", "definstance", "defmessage", "defmodule", "deffacts-module", "deffunction-module", "defgeneric-module", "defglobal-module", "definstances-module", "slot", "multislot", "default", "default-dynamic", "declare", "salience", "auto-focus", "object", "is-a", "pattern-match", "single-slot", "reactive", "non-reactive", "storage", "local", "shared", "access", "read-write", "read-only", "initialize-only", "propagation", "inherit", "non-inherit", "source", "exclusive", "composite", "visibility", "private", "public", "create-accessor", "?NONE", "read", "write", "?DEFAULT", "primary", "around", "before", "after", "import", "export", "?ALL", "type", "allowed-symbols", "allowed-strings", "allowed-lexemes", "allowed-integers", "allowed-floats", "allowed-numbers", "allowed-instance-names", "allowed-values", "?VARIABLE", });
        KEYWORDS1.add("KEYWORD2", new String[]{"if", "while", "then", "else", "or", "and", "eq", "evenp", "floatp", "integerp", "lexemep", "multifieldp", "neq", "not", "numberp", "oddp", "pointerp", "stringp", "symbolp", "switch", "while", });
        KEYWORDS1.add("KEYWORD3", new String[]{"assert", "bind", "class-abstractp", "class-existp", "class-subclasses", "class-superclasses", "defclass-module", "describe-classes", "get-class-defaults-mode", "get-defclass-list", "agenda", "list-defclasses", "ppdefclass", "set-class-defaults-mode", "slot-allowed-values", "slot-cardinality", "slot-default-value", "slot-direct-accessp", "slot-existp", "slot-facest", "slot-initablep", "slot-publicp", "slot-range", "slot-sources", "slot-types", "slot-writablep", "subsclassp", "undefclass", "get-deffacts-list", "list-deffacts", "ppdeffacts", "undeffacts", "get-deffunction-list", "list-deffunction", "ppdeffunction", "undeffunction", "get-defgeneric-list", "list-defgenerics", "ppdefgeneric", "preview-generic", "type", "undefgeneric", "get-defglobal-list", "get-reset-globals", "list-defglobals", "ppdefglobal", "set-reset-globals", "undefglobal", "get-definstances-list", "list-definstances", "ppdefinstances", "undefinstances", "call-next-handler", "get-defmessage-handler", "list-defmessage-handlers", "message-handler-existp", "handler-type", "next-handlerp", "override-next-handler", "ppdefmessage-handler", "undefmessage-handler", "call-next-method", "call-specific-method", "get-defmethod-list", "get-method-restrictions", "list-defmethods", "next-methodp", "override-next-method", "undefmethod", "preview-generic", "get-current-module", "get-defmodule-list", "list-defmodules", "ppdefmodules", "set-current-module", "defrule-module", "get-defrule-list", "get-incremental-reset", "list-defrules", "matches", "ppdefrule", "refresh", "remove-break", "set-break", "set-incremental-reset", "show-breaks", "undefrule", "deftemplate-module", "get-deftemaplate-list", "list-deftemplates", "ppdeftemplate", "undeftemplate", "apropos", "bacth", "batch*", "bload", "bsave", "clear", "exit", "get-auto-float-dividend", "get-dynamic-constraints-checking", "get-static-constraints-checking", "load", "load*", "options", "reset", "save", "set-auto-float-dividend", "set-dynamic-constriants-checking", "set-static-constriants-checking", "system", "assert-string", "dependencies", "dependents", "duplicate", "facts", "fact-existp", "fact-index", "fact-relation", "fact-slot-names", "fact-slot-value", "get-fact-duplication", "get-fact-list", "load-facts", "modify", "retract", "save-facts", "set-fact-duplication", "any-instancep", "class", "delayed-do-for-all-instances", "delete-instance", "direct-slot-delete$", "direct-slot-insert$", "direct-slot-replace$", "do-for-instance", "do-for-all-instances", "dynamic-get", "dynamic-put", "find-instance", "find-all-instances", "init-slot", "instance-address", "instance-addressp", "instance-existp", "instance-name", "instance-namep", "instance-name-to-symbol", "instancep", "instances", "load-instances", "make-intance", "ppinstance", "restore-instances", "save-instances", "send", "slot-delete$", "slot-insert$", "slot-replace$", "symbol-to-instance-name", "unmake-instance", "create$", "delete$", "delete-member$", "explode$", "first$", "implode$", "insert$", "length$", "member$", "nth$", "replace$", "rest$", "subseq$", "subsetp", "break", "loop-for-count", "progn", "progn$", "return", "get-profile-percent-threshold", "profile-contructs", "profile-info", "profile-reset", "set-profile-percent-threshold", "expand$", "get-sequence-operator-recognition", "aet-sequence-operator-recognition", "build", "check-syntax", "eval", "lowcase", "str-cat", "str-compare", "str-index", "str-length", "string-to-field", "sub-string", "sym-cat", "upcase", "fetch", "print-region", "toss", });
        KEYWORDS1.add("KEYWORD4", new String[]{"abs", "div", "float", "integer", "max", "min", "deg-grad", "deg-rad", "exp", "grad-deg", "log", "log10", "mod", "pi", "rad-deg", "round", "sqrt", "close", "format", "open", "printout", "read", "readline", "remove", "rename", "conserve-mem", "mem-used", "mem-requests", "release-mem", "funcall", "gensym", "gemsym*", "get-function-restriction", "length", "random", "seed", "setgen", "sort", "time", "timer", "acos", "acosh", "acot", "acoth", "acsc", "acsch", "asec", "asin", "asinh", "atan", "atanh", "cos", "cosh", "cot", "coth", "csc", "sec", "sech", "sin", "sinh", "tan", "tanh", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, };

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
