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
public class BibtexLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "%";
        PROPERTY1.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "%";
        EOL_SPAN1.TYPE = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "FUNCTION";
        SPAN1.DELEGATE = "article";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "@article{";
        END END1 = new END();
        END1.text = "}";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "FUNCTION";
        SPAN2.DELEGATE = "article";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "@article(";
        END END2 = new END();
        END2.text = ")";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "FUNCTION";
        SPAN3.DELEGATE = "book";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "@book{";
        END END3 = new END();
        END3.text = "}";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "FUNCTION";
        SPAN4.DELEGATE = "book";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "@book(";
        END END4 = new END();
        END4.text = ")";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "FUNCTION";
        SPAN5.DELEGATE = "booklet";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "@booklet{";
        END END5 = new END();
        END5.text = "}";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN SPAN6 = new SPAN();
        SPAN6.TYPE = "FUNCTION";
        SPAN6.DELEGATE = "booklet";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "@booklet(";
        END END6 = new END();
        END6.text = ")";
        SPAN6.END = new END[] { END6, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN7 = new SPAN();
        SPAN7.TYPE = "FUNCTION";
        SPAN7.DELEGATE = "conference";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "@conference{";
        END END7 = new END();
        END7.text = "}";
        SPAN7.END = new END[] { END7, };

        SPAN7.BEGIN = new BEGIN[] { BEGIN7, };

        SPAN SPAN8 = new SPAN();
        SPAN8.TYPE = "FUNCTION";
        SPAN8.DELEGATE = "conference";
        BEGIN BEGIN8 = new BEGIN();
        BEGIN8.text = "@conference(";
        END END8 = new END();
        END8.text = ")";
        SPAN8.END = new END[] { END8, };

        SPAN8.BEGIN = new BEGIN[] { BEGIN8, };

        SPAN SPAN9 = new SPAN();
        SPAN9.TYPE = "FUNCTION";
        SPAN9.DELEGATE = "inbook";
        BEGIN BEGIN9 = new BEGIN();
        BEGIN9.text = "@inbook{";
        END END9 = new END();
        END9.text = "}";
        SPAN9.END = new END[] { END9, };

        SPAN9.BEGIN = new BEGIN[] { BEGIN9, };

        SPAN SPAN10 = new SPAN();
        SPAN10.TYPE = "FUNCTION";
        SPAN10.DELEGATE = "inbook";
        BEGIN BEGIN10 = new BEGIN();
        BEGIN10.text = "@inbook(";
        END END10 = new END();
        END10.text = ")";
        SPAN10.END = new END[] { END10, };

        SPAN10.BEGIN = new BEGIN[] { BEGIN10, };

        SPAN SPAN11 = new SPAN();
        SPAN11.TYPE = "FUNCTION";
        SPAN11.DELEGATE = "incollection";
        BEGIN BEGIN11 = new BEGIN();
        BEGIN11.text = "@incollection{";
        END END11 = new END();
        END11.text = "}";
        SPAN11.END = new END[] { END11, };

        SPAN11.BEGIN = new BEGIN[] { BEGIN11, };

        SPAN SPAN12 = new SPAN();
        SPAN12.TYPE = "FUNCTION";
        SPAN12.DELEGATE = "incollection";
        BEGIN BEGIN12 = new BEGIN();
        BEGIN12.text = "@incollection(";
        END END12 = new END();
        END12.text = ")";
        SPAN12.END = new END[] { END12, };

        SPAN12.BEGIN = new BEGIN[] { BEGIN12, };

        SPAN SPAN13 = new SPAN();
        SPAN13.TYPE = "FUNCTION";
        SPAN13.DELEGATE = "inproceedings";
        BEGIN BEGIN13 = new BEGIN();
        BEGIN13.text = "@inproceedings{";
        END END13 = new END();
        END13.text = "}";
        SPAN13.END = new END[] { END13, };

        SPAN13.BEGIN = new BEGIN[] { BEGIN13, };

        SPAN SPAN14 = new SPAN();
        SPAN14.TYPE = "FUNCTION";
        SPAN14.DELEGATE = "inproceedings";
        BEGIN BEGIN14 = new BEGIN();
        BEGIN14.text = "@inproceedings(";
        END END14 = new END();
        END14.text = ")";
        SPAN14.END = new END[] { END14, };

        SPAN14.BEGIN = new BEGIN[] { BEGIN14, };

        SPAN SPAN15 = new SPAN();
        SPAN15.TYPE = "FUNCTION";
        SPAN15.DELEGATE = "manual";
        BEGIN BEGIN15 = new BEGIN();
        BEGIN15.text = "@manual{";
        END END15 = new END();
        END15.text = "}";
        SPAN15.END = new END[] { END15, };

        SPAN15.BEGIN = new BEGIN[] { BEGIN15, };

        SPAN SPAN16 = new SPAN();
        SPAN16.TYPE = "FUNCTION";
        SPAN16.DELEGATE = "manual";
        BEGIN BEGIN16 = new BEGIN();
        BEGIN16.text = "@manual(";
        END END16 = new END();
        END16.text = ")";
        SPAN16.END = new END[] { END16, };

        SPAN16.BEGIN = new BEGIN[] { BEGIN16, };

        SPAN SPAN17 = new SPAN();
        SPAN17.TYPE = "FUNCTION";
        SPAN17.DELEGATE = "mastersthesis";
        BEGIN BEGIN17 = new BEGIN();
        BEGIN17.text = "@mastersthesis{";
        END END17 = new END();
        END17.text = "}";
        SPAN17.END = new END[] { END17, };

        SPAN17.BEGIN = new BEGIN[] { BEGIN17, };

        SPAN SPAN18 = new SPAN();
        SPAN18.TYPE = "FUNCTION";
        SPAN18.DELEGATE = "mastersthesis";
        BEGIN BEGIN18 = new BEGIN();
        BEGIN18.text = "@mastersthesis(";
        END END18 = new END();
        END18.text = ")";
        SPAN18.END = new END[] { END18, };

        SPAN18.BEGIN = new BEGIN[] { BEGIN18, };

        SPAN SPAN19 = new SPAN();
        SPAN19.TYPE = "FUNCTION";
        SPAN19.DELEGATE = "misc";
        BEGIN BEGIN19 = new BEGIN();
        BEGIN19.text = "@misc{";
        END END19 = new END();
        END19.text = "}";
        SPAN19.END = new END[] { END19, };

        SPAN19.BEGIN = new BEGIN[] { BEGIN19, };

        SPAN SPAN20 = new SPAN();
        SPAN20.TYPE = "FUNCTION";
        SPAN20.DELEGATE = "misc";
        BEGIN BEGIN20 = new BEGIN();
        BEGIN20.text = "@misc(";
        END END20 = new END();
        END20.text = ")";
        SPAN20.END = new END[] { END20, };

        SPAN20.BEGIN = new BEGIN[] { BEGIN20, };

        SPAN SPAN21 = new SPAN();
        SPAN21.TYPE = "FUNCTION";
        SPAN21.DELEGATE = "phdthesis";
        BEGIN BEGIN21 = new BEGIN();
        BEGIN21.text = "@phdthesis{";
        END END21 = new END();
        END21.text = "}";
        SPAN21.END = new END[] { END21, };

        SPAN21.BEGIN = new BEGIN[] { BEGIN21, };

        SPAN SPAN22 = new SPAN();
        SPAN22.TYPE = "FUNCTION";
        SPAN22.DELEGATE = "phdthesis";
        BEGIN BEGIN22 = new BEGIN();
        BEGIN22.text = "@phdthesis(";
        END END22 = new END();
        END22.text = ")";
        SPAN22.END = new END[] { END22, };

        SPAN22.BEGIN = new BEGIN[] { BEGIN22, };

        SPAN SPAN23 = new SPAN();
        SPAN23.TYPE = "FUNCTION";
        SPAN23.DELEGATE = "proceedings";
        BEGIN BEGIN23 = new BEGIN();
        BEGIN23.text = "@proceedings{";
        END END23 = new END();
        END23.text = "}";
        SPAN23.END = new END[] { END23, };

        SPAN23.BEGIN = new BEGIN[] { BEGIN23, };

        SPAN SPAN24 = new SPAN();
        SPAN24.TYPE = "FUNCTION";
        SPAN24.DELEGATE = "proceedings";
        BEGIN BEGIN24 = new BEGIN();
        BEGIN24.text = "@proceedings(";
        END END24 = new END();
        END24.text = ")";
        SPAN24.END = new END[] { END24, };

        SPAN24.BEGIN = new BEGIN[] { BEGIN24, };

        SPAN SPAN25 = new SPAN();
        SPAN25.TYPE = "FUNCTION";
        SPAN25.DELEGATE = "techreport";
        BEGIN BEGIN25 = new BEGIN();
        BEGIN25.text = "@techreport{";
        END END25 = new END();
        END25.text = "}";
        SPAN25.END = new END[] { END25, };

        SPAN25.BEGIN = new BEGIN[] { BEGIN25, };

        SPAN SPAN26 = new SPAN();
        SPAN26.TYPE = "FUNCTION";
        SPAN26.DELEGATE = "techreport";
        BEGIN BEGIN26 = new BEGIN();
        BEGIN26.text = "@techreport(";
        END END26 = new END();
        END26.text = ")";
        SPAN26.END = new END[] { END26, };

        SPAN26.BEGIN = new BEGIN[] { BEGIN26, };

        SPAN SPAN27 = new SPAN();
        SPAN27.TYPE = "FUNCTION";
        SPAN27.DELEGATE = "unpublished";
        BEGIN BEGIN27 = new BEGIN();
        BEGIN27.text = "@unpublished{";
        END END27 = new END();
        END27.text = "}";
        SPAN27.END = new END[] { END27, };

        SPAN27.BEGIN = new BEGIN[] { BEGIN27, };

        SPAN SPAN28 = new SPAN();
        SPAN28.TYPE = "FUNCTION";
        SPAN28.DELEGATE = "unpublished";
        BEGIN BEGIN28 = new BEGIN();
        BEGIN28.text = "@unpublished(";
        END END28 = new END();
        END28.text = ")";
        SPAN28.END = new END[] { END28, };

        SPAN28.BEGIN = new BEGIN[] { BEGIN28, };

        SPAN SPAN29 = new SPAN();
        SPAN29.TYPE = "FUNCTION";
        SPAN29.DELEGATE = "string";
        BEGIN BEGIN29 = new BEGIN();
        BEGIN29.text = "@string{";
        END END29 = new END();
        END29.text = "}";
        SPAN29.END = new END[] { END29, };

        SPAN29.BEGIN = new BEGIN[] { BEGIN29, };

        SPAN SPAN30 = new SPAN();
        SPAN30.TYPE = "FUNCTION";
        SPAN30.DELEGATE = "string";
        BEGIN BEGIN30 = new BEGIN();
        BEGIN30.text = "@string(";
        END END30 = new END();
        END30.text = ")";
        SPAN30.END = new END[] { END30, };

        SPAN30.BEGIN = new BEGIN[] { BEGIN30, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, SPAN7, SPAN8, SPAN9, SPAN10, SPAN11, SPAN12, SPAN13, SPAN14, SPAN15, SPAN16, SPAN17, SPAN18, SPAN19, SPAN20, SPAN21, SPAN22, SPAN23, SPAN24, SPAN25, SPAN26, SPAN27, SPAN28, SPAN29, SPAN30, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "article";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[1-9][0-9]*";
        SEQ_REGEXP1.HASH_CHARS = "123456789";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "annotation", "day", "keywords", "lccn", "location", "references", "url", });
        KEYWORDS1.add("KEYWORD2", new String[]{"address", "annote", "booktitle", "chapter", "crossref", "edition", "editor", "howpublished", "institution", "key", "organization", "publisher", "school", "series", "type", });
        KEYWORDS1.add("KEYWORD3", new String[]{"month", "note", "number", "pages", "volume", });
        KEYWORDS1.add("KEYWORD4", new String[]{"author", "journal", "title", "year", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "book";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[1-9][0-9]*";
        SEQ_REGEXP1.HASH_CHARS = "123456789";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "annotation", "day", "keywords", "lccn", "location", "references", "url", });
        KEYWORDS1.add("KEYWORD2", new String[]{"annote", "booktitle", "chapter", "crossref", "howpublished", "institution", "journal", "key", "organization", "pages", "school", "type", });
        KEYWORDS1.add("KEYWORD3", new String[]{"address", "edition", "month", "note", "number", "series", "volume", });
        KEYWORDS1.add("KEYWORD4", new String[]{"author", "editor", "publisher", "title", "year", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "booklet";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[1-9][0-9]*";
        SEQ_REGEXP1.HASH_CHARS = "123456789";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "annotation", "day", "keywords", "lccn", "location", "references", "url", });
        KEYWORDS1.add("KEYWORD2", new String[]{"annote", "booktitle", "chapter", "crossref", "edition", "editor", "institution", "journal", "key", "number", "organization", "pages", "publisher", "school", "series", "type", "volume", });
        KEYWORDS1.add("KEYWORD3", new String[]{"address", "author", "howpublished", "month", "note", "year", });
        KEYWORDS1.add("KEYWORD4", new String[]{"title", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "conference";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[1-9][0-9]*";
        SEQ_REGEXP1.HASH_CHARS = "123456789";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "annotation", "day", "keywords", "lccn", "location", "references", "url", });
        KEYWORDS1.add("KEYWORD2", new String[]{"annote", "chapter", "crossref", "edition", "howpublished", "institution", "journal", "key", "school", "type", });
        KEYWORDS1.add("KEYWORD3", new String[]{"address", "editor", "month", "note", "number", "organization", "pages", "publisher", "series", "volume", });
        KEYWORDS1.add("KEYWORD4", new String[]{"author", "booktitle", "title", "year", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES6() {
        RULES RULES1 = new RULES();
        RULES1.SET = "inbook";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[1-9][0-9]*";
        SEQ_REGEXP1.HASH_CHARS = "123456789";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "annotation", "day", "keywords", "lccn", "location", "references", "url", });
        KEYWORDS1.add("KEYWORD2", new String[]{"annote", "booktitle", "crossref", "howpublished", "institution", "journal", "key", "organization", "school", });
        KEYWORDS1.add("KEYWORD3", new String[]{"address", "edition", "month", "note", "number", "series", "type", "volume", });
        KEYWORDS1.add("KEYWORD4", new String[]{"author", "chapter", "editor", "pages", "publisher", "title", "year", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES7() {
        RULES RULES1 = new RULES();
        RULES1.SET = "incollection";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[1-9][0-9]*";
        SEQ_REGEXP1.HASH_CHARS = "123456789";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "annotation", "day", "keywords", "lccn", "location", "references", "url", });
        KEYWORDS1.add("KEYWORD2", new String[]{"annote", "crossref", "howpublished", "institution", "journal", "key", "organization", "school", });
        KEYWORDS1.add("KEYWORD3", new String[]{"address", "chapter", "edition", "editor", "month", "note", "number", "pages", "series", "type", "volume", });
        KEYWORDS1.add("KEYWORD4", new String[]{"author", "booktitle", "publisher", "title", "year", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES8() {
        RULES RULES1 = new RULES();
        RULES1.SET = "inproceedings";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[1-9][0-9]*";
        SEQ_REGEXP1.HASH_CHARS = "123456789";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "annotation", "day", "keywords", "lccn", "location", "references", "url", });
        KEYWORDS1.add("KEYWORD2", new String[]{"annote", "chapter", "crossref", "edition", "howpublished", "institution", "journal", "key", "school", "type", });
        KEYWORDS1.add("KEYWORD3", new String[]{"address", "editor", "month", "note", "number", "organization", "pages", "publisher", "series", "volume", });
        KEYWORDS1.add("KEYWORD4", new String[]{"author", "booktitle", "title", "year", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES9() {
        RULES RULES1 = new RULES();
        RULES1.SET = "manual";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[1-9][0-9]*";
        SEQ_REGEXP1.HASH_CHARS = "123456789";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "annotation", "day", "keywords", "lccn", "location", "references", "url", });
        KEYWORDS1.add("KEYWORD2", new String[]{"annote", "booktitle", "chapter", "crossref", "editor", "howpublished", "institution", "journal", "key", "number", "pages", "publisher", "school", "series", "type", "volume", });
        KEYWORDS1.add("KEYWORD3", new String[]{"address", "author", "edition", "month", "note", "organization", "year", });
        KEYWORDS1.add("KEYWORD4", new String[]{"title", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES10() {
        RULES RULES1 = new RULES();
        RULES1.SET = "mastersthesis";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[1-9][0-9]*";
        SEQ_REGEXP1.HASH_CHARS = "123456789";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "annotation", "day", "keywords", "lccn", "location", "references", "url", });
        KEYWORDS1.add("KEYWORD2", new String[]{"annote", "booktitle", "chapter", "crossref", "edition", "editor", "howpublished", "institution", "journal", "key", "number", "organization", "pages", "publisher", "series", "volume", });
        KEYWORDS1.add("KEYWORD3", new String[]{"address", "month", "note", "type", });
        KEYWORDS1.add("KEYWORD4", new String[]{"author", "school", "title", "year", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES11() {
        RULES RULES1 = new RULES();
        RULES1.SET = "misc";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[1-9][0-9]*";
        SEQ_REGEXP1.HASH_CHARS = "123456789";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "annotation", "day", "keywords", "lccn", "location", "references", "url", });
        KEYWORDS1.add("KEYWORD2", new String[]{"address", "annote", "booktitle", "chapter", "crossref", "edition", "editor", "institution", "journal", "key", "number", "organization", "pages", "publisher", "school", "series", "type", "volume", });
        KEYWORDS1.add("KEYWORD3", new String[]{"author", "howpublished", "month", "note", "title", "year", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES12() {
        RULES RULES1 = new RULES();
        RULES1.SET = "phdthesis";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[1-9][0-9]*";
        SEQ_REGEXP1.HASH_CHARS = "123456789";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "annotation", "day", "keywords", "lccn", "location", "references", "url", });
        KEYWORDS1.add("KEYWORD2", new String[]{"annote", "booktitle", "chapter", "crossref", "edition", "editor", "howpublished", "institution", "journal", "key", "number", "organization", "pages", "publisher", "series", "volume", });
        KEYWORDS1.add("KEYWORD3", new String[]{"address", "month", "note", "type", });
        KEYWORDS1.add("KEYWORD4", new String[]{"author", "school", "title", "year", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES13() {
        RULES RULES1 = new RULES();
        RULES1.SET = "proceedings";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[1-9][0-9]*";
        SEQ_REGEXP1.HASH_CHARS = "123456789";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "annotation", "day", "keywords", "lccn", "location", "references", "url", });
        KEYWORDS1.add("KEYWORD2", new String[]{"annote", "author", "booktitle", "chapter", "crossref", "edition", "howpublished", "institution", "journal", "key", "pages", "school", "type", });
        KEYWORDS1.add("KEYWORD3", new String[]{"address", "editor", "month", "note", "number", "organization", "publisher", "series", "volume", });
        KEYWORDS1.add("KEYWORD4", new String[]{"title", "year", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES14() {
        RULES RULES1 = new RULES();
        RULES1.SET = "techreport";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[1-9][0-9]*";
        SEQ_REGEXP1.HASH_CHARS = "123456789";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "annotation", "day", "keywords", "lccn", "location", "references", "url", });
        KEYWORDS1.add("KEYWORD2", new String[]{"annote", "booktitle", "chapter", "crossref", "edition", "editor", "howpublished", "journal", "key", "organization", "pages", "publisher", "school", "series", "volume", });
        KEYWORDS1.add("KEYWORD3", new String[]{"address", "month", "note", "number", "type", });
        KEYWORDS1.add("KEYWORD4", new String[]{"author", "institution", "title", "year", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES15() {
        RULES RULES1 = new RULES();
        RULES1.SET = "unpublished";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[1-9][0-9]*";
        SEQ_REGEXP1.HASH_CHARS = "123456789";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec", });
        KEYWORDS1.add("KEYWORD1", new String[]{"abstract", "annotation", "day", "keywords", "lccn", "location", "references", "url", });
        KEYWORDS1.add("KEYWORD2", new String[]{"address", "annote", "booktitle", "chapter", "crossref", "edition", "editor", "howpublished", "institution", "journal", "key", "number", "organization", "pages", "publisher", "school", "series", "type", "volume", });
        KEYWORDS1.add("KEYWORD3", new String[]{"month", "year", });
        KEYWORDS1.add("KEYWORD4", new String[]{"author", "note", "title", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES16() {
        RULES RULES1 = new RULES();
        RULES1.SET = "textbraced";
        RULES1.DEFAULT = "LITERAL2";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL3";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\\{";
        END END1 = new END();
        END1.text = "\\}";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "FALSE";
        SPAN3.TYPE = "LITERAL1";
        SPAN3.DELEGATE = "textquoted";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "\"";
        END END3 = new END();
        END3.text = "\"";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "\\\"";
        SEQ1.TYPE = "LITERAL3";
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES17() {
        RULES RULES1 = new RULES();
        RULES1.SET = "textquoted";
        RULES1.DEFAULT = "LITERAL1";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL3";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\\{";
        END END1 = new END();
        END1.text = "\\}";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "\\\"";
        SEQ1.TYPE = "LITERAL3";
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

        return RULES1;
    }

    private RULES RULES18() {
        RULES RULES1 = new RULES();
        RULES1.SET = "string";
        RULES1.DEFAULT = "LITERAL1";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "textquoted";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.DELEGATE = "textbraced";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{";
        END END2 = new END();
        END2.text = "}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "FALSE";
        SPAN3.TYPE = "LITERAL3";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "\\{";
        END END3 = new END();
        END3.text = "\\}";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ",";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "\\\"";
        SEQ3.TYPE = "LITERAL3";
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), RULES6(), RULES7(), RULES8(), RULES9(), RULES10(), RULES11(), RULES12(), RULES13(), RULES14(), RULES15(), RULES16(), RULES17(), RULES18(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
