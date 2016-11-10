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
public class RebolLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "{[(";
        PROPERTY1.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "}])";
        PROPERTY2.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "comment {";
        PROPERTY3.NAME = "commentStart";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "}";
        PROPERTY4.NAME = "commentEnd";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = ";";
        PROPERTY5.NAME = "lineComment";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "_-";
        PROPERTY6.NAME = "noWordSep";
        PROPERTY PROPERTY7 = new PROPERTY();
        PROPERTY7.VALUE = ",+-=<>/?^&*";
        PROPERTY7.NAME = "wordBreakChars";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "FALSE";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "comment {";
        END END1 = new END();
        END1.text = "}";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "COMMENT1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "comment{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "TRUE";
        SPAN3.TYPE = "LITERAL1";
        SPAN3.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "\"";
        END END3 = new END();
        END3.text = "\"";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.NO_LINE_BREAK = "FALSE";
        SPAN4.TYPE = "LITERAL1";
        SPAN4.ESCAPE = "\\";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "{";
        END END4 = new END();
        END4.text = "}";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = ";";
        EOL_SPAN1.TYPE = "COMMENT1";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ">=";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "<=";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "<>";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "+";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "/";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "*";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = ">";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "<";
        SEQ9.TYPE = "OPERATOR";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "'";
        MARK_FOLLOWING1.TYPE = "LITERAL2";
        MARK_FOLLOWING1.MATCH_TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"true", "false", "self", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abs", "absolute", "add", "and~", "at", "back", "change", "clear", "complement", "copy", "cp", "divide", "fifth", "find", "first", "fourth", "head", "insert", "last", "make", "max", "maximum", "min", "minimum", "multiply", "negate", "next", "or~", "pick", "poke", "power", "random", "remainder", "remove", "second", "select", "skip", "sort", "subtract", "tail", "third", "to", "trim", "xor~", "alias", "all", "any", "arccosine", "arcsine", "arctangent", "bind", "break", "browse", "call", "caret-to-offset", "catch", "checksum", "close", "comment", "compose", "compress", "cosine", "debase", "decompress", "dehex", "detab", "dh-compute-key", "dh-generate-key", "dh-make-key", "difference", "disarm", "do", "dsa-generate-key", "dsa-make-key", "dsa-make-signature", "dsa-verify-signature", "either", "else", "enbase", "entab", "exclude", "exit", "exp", "foreach", "form", "free", "get", "get-modes", "halt", "hide", "if", "in", "intersect", "load", "log-10", "log-2", "log-e", "loop", "lowercase", "maximum-of", "minimum-of", "mold", "not", "now", "offset-to-caret", "open", "parse", "prin", "print", "protect", "q", "query", "quit", "read", "read-io", "recycle", "reduce", "repeat", "return", "reverse", "rsa-encrypt", "rsa-generate-key", "rsa-make-key", "save", "secure", "set", "set-modes", "show", "sine", "size-text", "square-root", "tangent", "textinfo", "throw", "to-hex", "to-local-file", "to-rebol-file", "trace", "try", "union", "unique", "unprotect", "unset", "until", "update", "uppercase", "use", "wait", "while", "write", "write-io", "basic-syntax-header", "crlf", "font-fixed", "font-sans-serif", "font-serif", "list-words", "outstr", "val", "value", "about", "alert", "alter", "append", "array", "ask", "boot-prefs", "build-tag", "center-face", "change-dir", "charset", "choose", "clean-path", "clear-fields", "confine", "confirm", "context", "cvs-date", "cvs-version", "decode-cgi", "decode-url", "deflag-face", "delete", "demo", "desktop", "dirize", "dispatch", "do-boot", "do-events", "do-face", "do-face-alt", "does", "dump-face", "dump-pane", "echo", "editor", "emailer", "emit", "extract", "find-by-type", "find-key-face", "find-window", "flag-face", "flash", "focus", "for", "forall", "forever", "forskip", "func", "function", "get-net-info", "get-style", "has", "help", "hide-popup", "import-email", "inform", "input", "insert-event-func", "join", "launch", "launch-thru", "layout", "license", "list-dir", "load-image", "load-prefs", "load-thru", "make-dir", "make-face", "net-error", "open-events", "parse-email-addrs", "parse-header", "parse-header-date", "parse-xml", "path-thru", "probe", "protect-system", "read-net", "read-thru", "reboot", "reform", "rejoin", "remold", "remove-event-func", "rename", "repend", "replace", "request", "request-color", "request-date", "request-download", "request-file", "request-list", "request-pass", "request-text", "resend", "save-prefs", "save-user", "scroll-para", "send", "set-font", "set-net", "set-para", "set-style", "set-user", "set-user-name", "show-popup", "source", "split-path", "stylize", "switch", "throw-on-error", "to-binary", "to-bitset", "to-block", "to-char", "to-date", "to-decimal", "to-email", "to-event", "to-file", "to-get-word", "to-hash", "to-idate", "to-image", "to-integer", "to-issue", "to-list", "to-lit-path", "to-lit-word", "to-logic", "to-money", "to-none", "to-pair", "to-paren", "to-path", "to-refinement", "to-set-path", "to-set-word", "to-string", "to-tag", "to-time", "to-tuple", "to-url", "to-word", "unfocus", "uninstall", "unview", "upgrade", "Usage", "vbug", "view", "view-install", "view-prefs", "what", "what-dir", "write-user", "return", "at", "space", "pad", "across", "below", "origin", "guide", "tabs", "indent", "style", "styles", "size", "sense", "backcolor", "do", "none", });
        KEYWORDS1.add("KEYWORD2", new String[]{"action?", "any-block?", "any-function?", "any-string?", "any-type?", "any-word?", "binary?", "bitset?", "block?", "char?", "datatype?", "date?", "decimal?", "email?", "empty?", "equal?", "error?", "even?", "event?", "file?", "function?", "get-word?", "greater-or-equal?", "greater?", "hash?", "head?", "image?", "index?", "integer?", "issue?", "length?", "lesser-or-equal?", "lesser?", "library?", "list?", "lit-path?", "lit-word?", "logic?", "money?", "native?", "negative?", "none?", "not-equal?", "number?", "object?", "odd?", "op?", "pair?", "paren?", "path?", "port?", "positive?", "refinement?", "routine?", "same?", "series?", "set-path?", "set-word?", "strict-equal?", "strict-not-equal?", "string?", "struct?", "tag?", "tail?", "time?", "tuple?", "unset?", "url?", "word?", "zero?", "connected?", "crypt-strength?", "exists-key?", "input?", "script?", "type?", "value?", "?", "??", "dir?", "exists-thru?", "exists?", "flag-face?", "found?", "in-window?", "info?", "inside?", "link-app?", "link?", "modified?", "offset?", "outside?", "screen-offset?", "size?", "span?", "view?", "viewed?", "win-offset?", "within?", });
        KEYWORDS1.add("KEYWORD3", new String[]{"action!", "any-block!", "any-function!", "any-string!", "any-type!", "any-word!", "binary!", "bitset!", "block!", "char!", "datatype!", "date!", "decimal!", "email!", "error!", "event!", "file!", "function!", "get-word!", "hash!", "image!", "integer!", "issue!", "library!", "list!", "lit-path!", "lit-word!", "logic!", "money!", "native!", "none!", "number!", "object!", "op!", "pair!", "paren!", "path!", "port!", "refinement!", "routine!", "series!", "set-path!", "set-word!", "string!", "struct!", "symbol!", "tag!", "time!", "tuple!", "unset!", "url!", "word!", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, };

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
