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
public class LispLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "#| ";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = " |#";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = ";";
        PROPERTY3.NAME = "lineComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "_-+?:";
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
        RULES1.DIGIT_RE = "-?\\d+([./]\\d+)?";
        RULES1.IGNORE_CASE = "FALSE";
        RULES1.NO_WORD_SEP = "_-+?:";
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
        MARK_FOLLOWING2.text = "&";
        MARK_FOLLOWING2.AT_WORD_START = "TRUE";
        MARK_FOLLOWING2.TYPE = "KEYWORD4";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "`";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "@";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "%";
        SEQ4.TYPE = "OPERATOR";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = ";;;;";
        EOL_SPAN1.TYPE = "COMMENT4";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = ";;;";
        EOL_SPAN2.TYPE = "COMMENT3";
        EOL_SPAN EOL_SPAN3 = new EOL_SPAN();
        EOL_SPAN3.text = ";;";
        EOL_SPAN3.TYPE = "COMMENT2";
        EOL_SPAN EOL_SPAN4 = new EOL_SPAN();
        EOL_SPAN4.text = ";";
        EOL_SPAN4.TYPE = "COMMENT1";
        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"t", "nil", });
        KEYWORDS1.add("KEYWORD1", new String[]{"defclass", "defconstant", "defgeneric", "define-compiler-macro", "define-condition", "define-method-combination", "define-modify-macro", "define-setf-expander", "define-symbol-macro", "defmacro", "defmethod", "defpackage", "defparameter", "defsetf", "defstruct", "deftype", "defun", "defvar", });
        KEYWORDS1.add("KEYWORD2", new String[]{"abort", "assert", "block", "break", "case", "catch", "ccase", "cerror", "cond", "ctypecase", "declaim", "declare", "do", "do*", "do-all-symbols", "do-external-symbols", "do-symbols", "dolist", "dotimes", "ecase", "error", "etypecase", "eval-when", "flet", "handler-bind", "handler-case", "if", "ignore-errors", "in-package", "labels", "lambda", "let", "let*", "locally", "loop", "macrolet", "multiple-value-bind", "proclaim", "prog", "prog*", "prog1", "prog2", "progn", "progv", "provide", "require", "restart-bind", "restart-case", "restart-name", "return", "return-from", "signal", "symbol-macrolet", "tagbody", "the", "throw", "typecase", "unless", "unwind-protect", "when", "with-accessors", "with-compilation-unit", "with-condition-restarts", "with-hash-table-iterator", "with-input-from-string", "with-open-file", "with-open-stream", "with-output-to-string", "with-package-iterator", "with-simple-restart", "with-slots", "with-standard-io-syntax", });
        KEYWORDS1.add("KEYWORD3", new String[]{"*", "**", "***", "*break-on-signals*", "*compile-file-pathname*", "*compile-file-truename*", "*compile-print*", "*compile-verbose*", "*debug-io*", "*debugger-hook*", "*default-pathname-defaults*", "*error-output*", "*features*", "*gensym-counter*", "*load-pathname*", "*load-print*", "*load-truename*", "*load-verbose*", "*macroexpand-hook*", "*modules*", "*package*", "*print-array*", "*print-base*", "*print-case*", "*print-circle*", "*print-escape*", "*print-gensym*", "*print-length*", "*print-level*", "*print-lines*", "*print-miser-width*", "*print-pprint-dispatch*", "*print-pretty*", "*print-radix*", "*print-readably*", "*print-right-margin*", "*query-io*", "*random-state*", "*read-base*", "*read-default-float-format*", "*read-eval*", "*read-suppress*", "*readtable*", "*standard-input*", "*standard-output*", "*terminal-io*", "*trace-output*", "+", "++", "+++", "-", "/", "//", "///", "/=", "1+", "1-", "<", "<=", "=", ">", ">=", "abs", "acons", "acos", "acosh", "add-method", "adjoin", "adjust-array", "adjustable-array-p", "allocate-instance", "alpha-char-p", "alphanumericp", "and", "append", "apply", "apropos", "apropos-list", "aref", "arithmetic-error", "arithmetic-error-operands", "arithmetic-error-operation", "array", "array-dimension", "array-dimension-limit", "array-dimensions", "array-displacement", "array-element-type", "array-has-fill-pointer-p", "array-in-bounds-p", "array-rank", "array-rank-limit", "array-row-major-index", "array-total-size", "array-total-size-limit", "arrayp", "ash", "asin", "asinh", "assoc", "assoc-if", "assoc-if-not", "atan", "atanh", "atom", "base-char", "base-string", "bignum", "bit", "bit-and", "bit-andc1", "bit-andc2", "bit-eqv", "bit-ior", "bit-nand", "bit-nor", "bit-not", "bit-orc1", "bit-orc2", "bit-vector", "bit-vector-p", "bit-xor", "boole", "boole-1", "boole-2", "boole-and", "boole-andc1", "boole-andc2", "boole-c1", "boole-c2", "boole-clr", "boole-eqv", "boole-ior", "boole-nand", "boole-nor", "boole-orc1", "boole-orc2", "boole-set", "boole-xor", "boolean", "both-case-p", "boundp", "broadcast-stream", "broadcast-stream-streams", "built-in-class", "butlast", "byte", "byte-position", "byte-size", "caaaar", "caaadr", "caaar", "caadar", "caaddr", "caadr", "caar", "cadaar", "cadadr", "cadar", "caddar", "cadddr", "caddr", "cadr", "call-arguments-limit", "call-method", "call-next-method", "car", "cdaaar", "cdaadr", "cdaar", "cdadar", "cdaddr", "cdadr", "cdar", "cddaar", "cddadr", "cddar", "cdddar", "cddddr", "cdddr", "cddr", "cdr", "ceiling", "cell-error", "cell-error-name", "change-class", "char", "char-code", "char-code-limit", "char-downcase", "char-equal", "char-greaterp", "char-int", "char-lessp", "char-name", "char-not-equal", "char-not-greaterp", "char-not-lessp", "char-upcase", "char/=", "char>", "char>=", "char<", "char<=", "char=", "character", "characterp", "check-type", "cis", "class", "class-name", "class-of", "clear-input", "clear-output", "close", "clrhash", "code-char", "coerce", "compilation-speed", "compile", "compile-file", "compile-file-pathname", "compiled-function", "compiled-function-p", "compiler-macro", "compiler-macro-function", "complement", "complex", "complexp", "compute-applicable-methods", "compute-restarts", "concatenate", "concatenated-stream", "concatenated-stream-streams", "condition", "conjugate", "cons", "consp", "constantly", "constantp", "continue", "control-error", "copy-alist", "copy-list", "copy-pprint-dispatch", "copy-readtable", "copy-seq", "copy-structure", "copy-symbol", "copy-tree", "cos", "cosh", "count", "count-if", "count-if-not", "debug", "decf", "declaration", "decode-float", "decode-universal-time", "delete", "delete-duplicates", "delete-file", "delete-if", "delete-if-not", "delete-package", "denominator", "deposit-field", "describe", "describe-object", "destructuring-bind", "digit-char", "digit-char-p", "directory", "directory-namestring", "disassemble", "division-by-zero", "documentation", "double-float", "double-float-epsilon", "double-float-negative-epsilon", "dpb", "dribble", "dynamic-extent", "echo-stream", "echo-stream-input-stream", "echo-stream-output-stream", "ed", "eighth", "elt", "encode-universal-time", "end-of-file", "endp", "enough-namestring", "ensure-directories-exist", "ensure-generic-function", "eq", "eql", "equal", "equalp", "eval", "evenp", "every", "exp", "export", "expt", "extended-char", "fboundp", "fceiling", "fdefinition", "ffloor", "fifth", "file-author", "file-error", "file-error-pathname", "file-length", "file-namestring", "file-position", "file-stream", "file-string-length", "file-write-date", "fill", "fill-pointer", "find", "find-all-symbols", "find-class", "find-if", "find-if-not", "find-method", "find-package", "find-restart", "find-symbol", "finish-output", "first", "fixnum", "float", "float-digits", "float-precision", "float-radix", "float-sign", "floating-point-inexact", "floating-point-invalid-operation", "floating-point-overflow", "floating-point-underflow", "floatp", "floor", "fmakunbound", "force-output", "format", "formatter", "fourth", "fresh-line", "fround", "ftruncate", "ftype", "funcall", "function", "function-keywords", "function-lambda-expression", "functionp", "gcd", "generic-function", "gensym", "gentemp", "get", "get-decoded-time", "get-dispatch-macro-character", "get-internal-real-time", "get-internal-run-time", "get-macro-character", "get-output-stream-string", "get-properties", "get-setf-expansion", "get-universal-time", "getf", "gethash", "go", "graphic-char-p", "hash-table", "hash-table-count", "hash-table-p", "hash-table-rehash-size", "hash-table-rehash-threshold", "hash-table-size", "hash-table-test", "host-namestring", "identity", "ignorable", "ignore", "imagpart", "import", "incf", "initialize-instance", "inline", "input-stream-p", "inspect", "integer", "integer-decode-float", "integer-length", "integerp", "interactive-stream-p", "intern", "internal-time-units-per-second", "intersection", "invalid-method-error", "invoke-debugger", "invoke-restart", "invoke-restart-interactively", "isqrt", "keyword", "keywordp", "lambda-list-keywords", "lambda-parameters-limit", "last", "lcm", "ldb", "ldb-test", "ldiff", "least-negative-double-float", "least-negative-long-float", "least-negative-normalized-double-float", "least-negative-normalized-long-float", "least-negative-normalized-short-float", "least-negative-normalized-single-float", "least-negative-short-float", "least-negative-single-float", "least-positive-double-float", "least-positive-long-float", "least-positive-normalized-double-float", "least-positive-normalized-long-float", "least-positive-normalized-short-float", "least-positive-normalized-single-float", "least-positive-short-float", "least-positive-single-float", "length", "lisp-implementation-type", "lisp-implementation-version", "list", "list*", "list-all-packages", "list-length", "listen", "listp", "load", "load-logical-pathname-translations", "load-time-value", "log", "logand", "logandc1", "logandc2", "logbitp", "logcount", "logeqv", "logical-pathname", "logical-pathname-translations", "logior", "lognand", "lognor", "lognot", "logorc1", "logorc2", "logtest", "logxor", "long-float", "long-float-epsilon", "long-float-negative-epsilon", "long-site-name", "loop-finish", "lower-case-p", "machine-instance", "machine-type", "machine-version", "macro-function", "macroexpand", "macroexpand-1", "make-array", "make-broadcast-stream", "make-concatenated-stream", "make-condition", "make-dispatch-macro-character", "make-echo-stream", "make-hash-table", "make-instance", "make-instances-obsolete", "make-list", "make-load-form", "make-load-form-saving-slots", "make-method", "make-package", "make-pathname", "make-random-state", "make-sequence", "make-string", "make-string-input-stream", "make-string-output-stream", "make-symbol", "make-synonym-stream", "make-two-way-stream", "makunbound", "map", "map-into", "mapc", "mapcan", "mapcar", "mapcon", "maphash", "mapl", "maplist", "mask-field", "max", "member", "member-if", "member-if-not", "merge", "merge-pathnames", "method", "method-combination", "method-combination-error", "method-qualifiers", "min", "minusp", "mismatch", "mod", "most-negative-double-float", "most-negative-fixnum", "most-negative-long-float", "most-negative-short-float", "most-negative-single-float", "most-positive-double-float", "most-positive-fixnum", "most-positive-long-float", "most-positive-short-float", "most-positive-single-float", "muffle-warning", "multiple-value-call", "multiple-value-list", "multiple-value-prog1", "multiple-value-setq", "multiple-values-limit", "name-char", "namestring", "nbutlast", "nconc", "next-method-p", "nintersection", "ninth", "no-applicable-method", "no-next-method", "not", "notany", "notevery", "notinline", "nreconc", "nreverse", "nset-difference", "nset-exclusive-or", "nstring-capitalize", "nstring-downcase", "nstring-upcase", "nsublis", "nsubst", "nsubst-if", "nsubst-if-not", "nsubstitute", "nsubstitute-if", "nsubstitute-if-not", "nth", "nth-value", "nthcdr", "null", "number", "numberp", "numerator", "nunion", "oddp", "open", "open-stream-p", "optimize", "or", "otherwise", "output-stream-p", "package", "package-error", "package-error-package", "package-name", "package-nicknames", "package-shadowing-symbols", "package-use-list", "package-used-by-list", "packagep", "pairlis", "parse-error", "parse-integer", "parse-namestring", "pathname", "pathname-device", "pathname-directory", "pathname-host", "pathname-match-p", "pathname-name", "pathname-type", "pathname-version", "pathnamep", "peek-char", "phase", "pi", "plusp", "pop", "position", "position-if", "position-if-not", "pprint", "pprint-dispatch", "pprint-exit-if-list-exhausted", "pprint-fill", "pprint-indent", "pprint-linear", "pprint-logical-block", "pprint-newline", "pprint-pop", "pprint-tab", "pprint-tabular", "prin1", "prin1-to-string", "princ", "princ-to-string", "print", "print-not-readable", "print-not-readable-object", "print-object", "print-unreadable-object", "probe-file", "program-error", "psetf", "psetq", "push", "pushnew", "quote", "random", "random-state", "random-state-p", "rassoc", "rassoc-if", "rassoc-if-not", "ratio", "rational", "rationalize", "rationalp", "read", "read-byte", "read-char", "read-char-no-hang", "read-delimited-list", "read-from-string", "read-line", "read-preserving-whitespace", "read-sequence", "reader-error", "readtable", "readtable-case", "readtablep", "real", "realp", "realpart", "reduce", "reinitialize-instance", "rem", "remf", "remhash", "remove", "remove-duplicates", "remove-if", "remove-if-not", "remove-method", "remprop", "rename-file", "rename-package", "replace", "rest", "restart", "revappend", "reverse", "room", "rotatef", "round", "row-major-aref", "rplaca", "rplacd", "safety", "satisfies", "sbit", "scale-float", "schar", "search", "second", "sequence", "serious-condition", "set", "set-difference", "set-dispatch-macro-character", "set-exclusive-or", "set-macro-character", "set-pprint-dispatch", "set-syntax-from-char", "setf", "setq", "seventh", "shadow", "shadowing-import", "shared-initialize", "shiftf", "short-float", "short-float-epsilon", "short-float-negative-epsilon", "short-site-name", "signed-byte", "signum", "simple-array", "simple-base-string", "simple-bit-vector", "simple-bit-vector-p", "simple-condition", "simple-condition-format-arguments", "simple-condition-format-control", "simple-error", "simple-string", "simple-string-p", "simple-type-error", "simple-vector", "simple-vector-p", "simple-warning", "sin", "single-float", "single-float-epsilon", "single-float-negative-epsilon", "sinh", "sixth", "sleep", "slot-boundp", "slot-exists-p", "slot-makunbound", "slot-missing", "slot-unbound", "slot-value", "software-type", "software-version", "some", "sort", "space", "special", "special-operator-p", "speed", "sqrt", "stable-sort", "standard", "standard-char", "standard-char-p", "standard-class", "standard-generic-function", "standard-method", "standard-object", "step", "storage-condition", "store-value", "stream", "stream-element-type", "stream-error", "stream-error-stream", "stream-external-format", "streamp", "string", "string-capitalize", "string-downcase", "string-equal", "string-greaterp", "string-left-trim", "string-lessp", "string-not-equal", "string-not-greaterp", "string-not-lessp", "string-right-trim", "string-stream", "string-trim", "string-upcase", "string/=", "string<", "string<=", "string=", "string>", "string>=", "stringp", "structure", "structure-class", "structure-object", "style-warning", "sublis", "subseq", "subsetp", "subst", "subst-if", "subst-if-not", "substitute", "substitute-if", "substitute-if-not", "subtypep", "svref", "sxhash", "symbol", "symbol-function", "symbol-name", "symbol-package", "symbol-plist", "symbol-value", "symbolp", "synonym-stream", "synonym-stream-symbol", "tailp", "tan", "tanh", "tenth", "terpri", "third", "time", "trace", "translate-logical-pathname", "translate-pathname", "tree-equal", "truename", "truncate", "two-way-stream", "two-way-stream-input-stream", "two-way-stream-output-stream", "type-error-datum", "type-error-expected-type", "type-error", "type-of", "typep", "type", "unbound-slot-instance", "unbound-slot", "unbound-variable", "undefined-function", "unexport", "unintern", "union", "unread-char", "unsigned-byte", "untrace", "unuse-package", "update-instance-for-different-class", "update-instance-for-redefined-class", "upgraded-array-element-type", "upgraded-complex-part-type", "upper-case-p", "use-package", "use-value", "user-homedir-pathname", "values", "values-list", "variable", "vector", "vector-pop", "vector-push", "vector-push-extend", "vectorp", "warn", "warning", "wild-pathname-p", "write", "write-byte", "write-char", "write-line", "write-sequence", "write-string", "write-to-string", "y-or-n-p", "yes-or-no-p", "zerop", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, EOL_SPAN3, EOL_SPAN4, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, MARK_FOLLOWING2, };

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
