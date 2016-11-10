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
public class SchemeLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "#|";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "|#";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = ";";
        PROPERTY3.NAME = "lineComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "_-+?:*/!";
        PROPERTY4.NAME = "noWordSep";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "(";
        PROPERTY5.NAME = "unalignedOpenBrackets";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = ")";
        PROPERTY6.NAME = "unalignedCloseBrackets";
        PROPERTY PROPERTY7 = new PROPERTY();
        PROPERTY7.VALUE = "true";
        PROPERTY7.NAME = "multipleBracketIndent";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "FALSE";
        RULES1.NO_WORD_SEP = "_-+?:*/!";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "#|";
        END END1 = new END();
        END1.text = "|#";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "'(";
        SEQ1.TYPE = "NULL";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "'";
        MARK_FOLLOWING1.TYPE = "LITERAL1";
        MARK_FOLLOWING MARK_FOLLOWING2 = new MARK_FOLLOWING();
        MARK_FOLLOWING2.text = "#\\";
        MARK_FOLLOWING2.TYPE = "LITERAL1";
        MARK_FOLLOWING MARK_FOLLOWING3 = new MARK_FOLLOWING();
        MARK_FOLLOWING3.text = "#b";
        MARK_FOLLOWING3.TYPE = "LITERAL1";
        MARK_FOLLOWING MARK_FOLLOWING4 = new MARK_FOLLOWING();
        MARK_FOLLOWING4.text = "#d";
        MARK_FOLLOWING4.TYPE = "LITERAL1";
        MARK_FOLLOWING MARK_FOLLOWING5 = new MARK_FOLLOWING();
        MARK_FOLLOWING5.text = "#o";
        MARK_FOLLOWING5.TYPE = "LITERAL1";
        MARK_FOLLOWING MARK_FOLLOWING6 = new MARK_FOLLOWING();
        MARK_FOLLOWING6.text = "#x";
        MARK_FOLLOWING6.TYPE = "LITERAL1";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = ";";
        EOL_SPAN1.TYPE = "COMMENT1";
        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"#t", "#f", });
        KEYWORDS1.add("KEYWORD1", new String[]{"and", "begin", "case", "cond", "cond-expand", "define", "define-macro", "delay", "do", "else", "fluid-let", "if", "lambda", "let", "let*", "letrec", "or", "quasiquote", "quote", "set!", });
        KEYWORDS1.add("KEYWORD2", new String[]{"abs", "acos", "angle", "append", "apply", "asin", "assoc", "assq", "assv", "atan", "car", "cdr", "caar", "cadr", "cdar", "cddr", "caaar", "caadr", "cadar", "caddr", "cdaar", "cdadr", "cddar", "cdddr", "call-with-current-continuation", "call-with-input-file", "call-with-output-file", "call-with-values", "call/cc", "catch", "ceiling", "char->integer", "char-downcase", "char-upcase", "close-input-port", "close-output-port", "cons", "cos", "current-input-port", "current-output-port", "delete-file", "display", "dynamic-wind", "eval", "exit", "exact->inexact", "exp", "expt", "file-or-directory-modify-seconds", "floor", "force", "for-each", "gcd", "gensym", "get-output-string", "getenv", "imag-part", "integer->char", "lcm", "length", "list", "list->string", "list->vector", "list-ref", "list-tail", "load", "log", "magnitude", "make-polar", "make-rectangular", "make-string", "make-vector", "map", "max", "member", "memq", "memv", "min", "modulo", "newline", "nil", "not", "number->string", "open-input-file", "open-input-string", "open-output-file", "open-output-string", "peek-char", "quotient", "read", "read-char", "read-line", "real-part", "remainder", "reverse", "reverse!", "round", "set-car!", "set-cdr!", "sin", "sqrt", "string", "string->list", "string->number", "string->symbol", "string-append", "string-copy", "string-fill!", "string-length", "string-ref", "string-set!", "substring", "symbol->string", "system", "tan", "truncate", "values", "vector", "vector->list", "vector-fill!", "vector-length", "vector-ref", "vector-set!", "with-input-from-file", "with-output-to-file", "write", "write-char", });
        KEYWORDS1.add("KEYWORD3", new String[]{"boolean?", "char-alphabetic?", "char-ci<=?", "char-ci<?", "char-ci=?", "char-ci>=?", "char-ci>?", "char-lower-case?", "char-numeric?", "char-ready?", "char-upper-case?", "char-whitespace?", "char<=?", "char<?", "char=?", "char>=?", "char>?", "char?", "complex?", "eof-object?", "eq?", "equal?", "eqv?", "even?", "exact?", "file-exists?", "inexact?", "input-port?", "integer?", "list?", "negative?", "null?", "number?", "odd?", "output-port?", "pair?", "port?", "positive?", "procedure?", "rational?", "real?", "string-ci<=?", "string-ci<?", "string-ci=?", "string-ci>=?", "string-ci>?", "string<=?", "string<?", "string=?", "string>=?", "string>?", "string?", "symbol?", "vector?", "zero?", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, MARK_FOLLOWING2, MARK_FOLLOWING3, MARK_FOLLOWING4, MARK_FOLLOWING5, MARK_FOLLOWING6, };

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
