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
public class OmnimarkLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "\\s*((PROCESS|MARKUP|EXTERNAL|DOCUMENT|DTD|ELEMENT|FIND|TRANSLATE)((-|\\s).*|\\s*)|(DO|ELSE|REPEAT|MATCH|CASE|USING|GROUP|DEFINE|MACRO)(\\s+.*|\\s*))";
        PROPERTY1.NAME = "indentNextLines";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = ";";
        PROPERTY2.NAME = "lineComment";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = ".-_";
        PROPERTY3.NAME = "noWordSep";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#!";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = ";";
        EOL_SPAN2.TYPE = "COMMENT1";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.NO_LINE_BREAK = "TRUE";
        SPAN_REGEXP1.TYPE = "INVALID";
        SPAN_REGEXP1.HASH_CHAR = "\"";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"((?!$)[^\"])*$";
        END END1 = new END();
        END1.text = "$";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.ESCAPE = "%";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN1.END = new END[] { END2, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.NO_LINE_BREAK = "TRUE";
        SPAN_REGEXP2.TYPE = "INVALID";
        SPAN_REGEXP2.HASH_CHAR = "'";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'((?!$)[^'])*$";
        END END3 = new END();
        END3.text = "$";
        SPAN_REGEXP2.END = new END[] { END3, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "'";
        END END4 = new END();
        END4.text = "'";
        SPAN2.END = new END[] { END4, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN4, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "&";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "|";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "+";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "=";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "/";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "<";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = ">";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "~";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "@";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "$";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "%";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "^";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "*";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "?";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "!";
        SEQ15.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"abs", "active", "and", "as", "base", "binary", "ceiling", "compiled-date", "complement", "creating", "creator", "date", "difference", "divide", "drop", "equal", "equals", "exists", "file", "floor", "greater-equal", "greater-than", "has", "hasnt", "is", "isnt", "item", "key", "last", "lastmost", "length", "less-equal", "less-than", "literal", "ln", "log10", "lookahead", "mask", "matches", "minus", "modulo", "name", "negate", "not", "number-of", "occurrence", "of", "or", "round", "shift", "sqrt", "status", "take", "this", "truncate", "ul", "unanchored", "union", "usemap", "with", });
        KEYWORDS1.add("KEYWORD1", new String[]{"activate", "again", "always", "assert", "case", "catch", "clear", "close", "copy", "copy-clear", "deactivate", "decrement", "discard", "do", "done", "else", "except", "exit", "flush", "for", "format", "halt", "halt-everything", "increment", "input", "join", "log", "match", "new", "next", "not-reached", "open", "output", "output-to", "over", "put", "remove", "reopen", "repeat", "reset", "rethrow", "return", "save", "save-clear", "scan", "select", "set", "sgml", "sgml-in", "sgml-out", "sgml-parse", "sgml-parser", "skip", "submit", "succeed", "suppress", "system-call", "test-system", "throw", "to", "unless", "using", "when", "xml-parse", });
        KEYWORDS1.add("KEYWORD2", new String[]{"#additional-info", "#appinfo", "#args", "#capacity", "#charset", "#class", "#command-line-names", "#console", "#current-input", "#current-output", "#data", "#doctype", "#document", "#dtd", "#empty", "#error", "#error-code", "#external-exception", "#file-name", "#first", "#group", "#implied", "#item", "#language-version", "#last", "#libpath", "#library", "#libvalue", "#line-number", "#main-input", "#main-output", "#markup-error-count", "#markup-error-total", "#markup-parser", "#markup-warning-count", "#markup-warning-total", "#message", "#none", "#output", "#platform-info", "#process-input", "#process-output", "#program-error", "#recovery-info", "#sgml", "#sgml-error-count", "#sgml-error-total", "#sgml-warning-count", "#sgml-warning-total", "#suppress", "#syntax", "#!", "after", "ancestor", "and", "another", "arg", "attached", "attribute", "attributes", "bcd", "before", "binary-input", "binary-mode", "binary-output", "break-width", "buffer", "buffered", "by", "catchable", "cdata-entity", "children", "closed", "conref", "content", "context-translate", "counter", "created", "cross-translate", "current", "data-attribute", "data-attributes", "data-content", "data-letters", "declare", "declared-conref", "declared-current", "declared-defaulted", "declared-fixed", "declared-implied", "declared-required", "default-entity", "defaulted", "defaulting", "define", "delimiter", "directory", "doctype", "document", "document-element", "document-end", "document-start", "domain-free", "down-translate", "dtd", "dtd-end", "dtd-start", "dtds", "element", "elements", "elsewhere", "empty", "entities", "entity", "epilog-start", "escape", "external", "external-data-entity", "external-entity", "external-function", "external-output-function", "external-text-entity", "false", "find", "find-end", "find-start", "function", "function-library", "general", "global", "group", "groups", "heralded-names", "id", "id-checking", "idref", "idrefs", "ignore", "implied", "in", "in-library", "include", "include-end", "include-guard", "include-start", "inclusion", "initial", "initial-size", "insertion-break", "instance", "integer", "internal", "invalid-data", "keyed", "letters", "library", "local", "macro", "macro-end", "marked-section", "markup-comment", "markup-error", "markup-parser", "markup-wrapper", "mixed", "modifiable", "name-letters", "namecase", "named", "names", "ndata-entity", "nested-referents", "newline", "nmtoken", "nmtokens", "no", "no-default-io", "non-implied", "notation", "number", "numbers", "nutoken", "nutokens", "opaque", "optional", "parameter", "parent", "past", "pattern", "plus", "preparent", "previous", "process", "process-end", "process-start", "processing-instruction", "prolog-end", "prolog-in-error", "proper", "public", "read-only", "readable", "referent", "referents", "referents-allowed", "referents-displayed", "referents-not-allowed", "remainder", "repeated", "replacement-break", "reversed", "sdata-entity", "sgml-comment", "sgml-declaration-end", "sgml-dtd", "sgml-dtds", "sgml-error", "silent-referent", "size", "source", "specified", "stream", "subdoc-entity", "subdocument", "subdocuments", "subelement", "switch", "symbol", "system", "text-mode", "thrown", "times", "token", "translate", "true", "unattached", "unbuffered", "up-translate", "value", "valued", "variable", "writable", "xml", "xml-dtd", "xml-dtds", "yes", });
        KEYWORDS1.add("KEYWORD3", new String[]{"any", "any-text", "blank", "cdata", "content-end", "content-start", "digit", "lc", "letter", "line-end", "line-start", "non-cdata", "non-sdata", "null", "pcdata", "rcdata", "sdata", "space", "text", "uc", "value-end", "value-start", "white-space", "word-end", "word-start", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, };

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
