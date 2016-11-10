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
public class IcalLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "COMMENT";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = ",;:=+/?^*&";
        PROPERTY2.NAME = "wordBreakChars";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "75";
        PROPERTY3.NAME = "maxLineLen";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "hard";
        PROPERTY4.NAME = "wrap";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "1";
        PROPERTY5.NAME = "indentSize";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "1";
        PROPERTY6.NAME = "noTabs";
        PROPERTY PROPERTY7 = new PROPERTY();
        PROPERTY7.VALUE = "1";
        PROPERTY7.NAME = "tabSize";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.AT_LINE_START = "TRUE";
        SPAN1.DELEGATE = "VCALENDAR";
        SPAN1.MATCH_TYPE = "KEYWORD1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "BEGIN:VCALENDAR";
        END END1 = new END();
        END1.text = "END:VCALENDAR";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "VCALENDAR";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.AT_LINE_START = "TRUE";
        SPAN1.DELEGATE = "VTIMEZONE";
        SPAN1.MATCH_TYPE = "KEYWORD1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "BEGIN:VTIMEZONE";
        END END1 = new END();
        END1.text = "END:VTIMEZONE";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.AT_LINE_START = "TRUE";
        SPAN2.DELEGATE = "VEVENT";
        SPAN2.MATCH_TYPE = "KEYWORD1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "BEGIN:VEVENT";
        END END2 = new END();
        END2.text = "END:VEVENT";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "FALSE";
        SPAN3.AT_LINE_START = "TRUE";
        SPAN3.DELEGATE = "VEVENT";
        SPAN3.MATCH_TYPE = "KEYWORD1";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "BEGIN:VTODO";
        END END3 = new END();
        END3.text = "END:VTODO";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.NO_LINE_BREAK = "FALSE";
        SPAN4.AT_LINE_START = "TRUE";
        SPAN4.DELEGATE = "VEVENT";
        SPAN4.MATCH_TYPE = "KEYWORD1";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "BEGIN:VJOURNAL";
        END END4 = new END();
        END4.text = "END:VJOURNAL";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"GREGORIAN", "2.0", });
        KEYWORDS1.add("KEYWORD2", new String[]{"CALSCALE", "METHOD", "PRODID", "VERSION", });
        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "VTIMEZONE";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.AT_LINE_START = "TRUE";
        SPAN1.DELEGATE = "DAYLIGHT";
        SPAN1.MATCH_TYPE = "KEYWORD1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "BEGIN:DAYLIGHT";
        END END1 = new END();
        END1.text = "END:DAYLIGHT";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.AT_LINE_START = "TRUE";
        SPAN2.DELEGATE = "STANDARD";
        SPAN2.MATCH_TYPE = "KEYWORD1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "BEGIN:STANDARD";
        END END2 = new END();
        END2.text = "END:STANDARD";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "CUSTOM_KEYWORDS";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD2", new String[]{"TZID", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "DAYLIGHT";
        RULES1.IGNORE_CASE = "FALSE";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "VCALENDAR_KEYWORDS";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "VTIMEZONE_KEYWORDS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        return RULES1;
    }

    private RULES RULES5() {
        RULES RULES1 = new RULES();
        RULES1.SET = "STANDARD";
        RULES1.IGNORE_CASE = "FALSE";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "VCALENDAR_KEYWORDS";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "VTIMEZONE_KEYWORDS";
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        return RULES1;
    }

    private RULES RULES6() {
        RULES RULES1 = new RULES();
        RULES1.SET = "VEVENT";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.AT_LINE_START = "TRUE";
        SPAN1.DELEGATE = "VALARM";
        SPAN1.MATCH_TYPE = "KEYWORD1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "BEGIN:VALARM";
        END END1 = new END();
        END1.text = "END:VALARM";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "VCALENDAR_KEYWORDS";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "CUSTOM_KEYWORDS";
        IMPORT IMPORT3 = new IMPORT();
        IMPORT3.DELEGATE = "VEVENT_KEYWORDS";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"CONFIDENTIAL", "PRIVATE", "PUBLIC", "OPAQUE", "TRANSPARENT", });
        KEYWORDS1.add("KEYWORD2", new String[]{"ATTENDEE", "CATEGORIES", "CLASS", "COMPLETED", "CREATED", "DESCRIPTION", "DTEND", "DTSTAMP", "DTSTART", "DUE", "LAST-MODIFIED", "LOCATION", "PERCENT-COMPLETE", "PRIORITY", "RECURRENCE-ID", "SEQUENCE", "STATUS", "SUMMARY", "TRANSP", "UID", "URL", });
        KEYWORDS1.add("LITERAL3", new String[]{"FALSE", "TRUE", });
        KEYWORDS1.add("KEYWORD3", new String[]{"RSVP", "TZID", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, IMPORT3, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES7() {
        RULES RULES1 = new RULES();
        RULES1.SET = "VALARM";
        RULES1.IGNORE_CASE = "FALSE";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "RIGHT";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "CUSTOM_KEYWORDS";
        IMPORT IMPORT3 = new IMPORT();
        IMPORT3.DELEGATE = "VEVENT_KEYWORDS";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD2", new String[]{"ACTION", "DESCRIPTION", "TRIGGER", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, IMPORT3, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES8() {
        RULES RULES1 = new RULES();
        RULES1.SET = "RIGHT";
        RULES1.IGNORE_CASE = "FALSE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = ":";
        EOL_SPAN1.AT_LINE_START = "FALSE";
        EOL_SPAN1.DELEGATE = "RIGHT_TEXT";
        EOL_SPAN1.MATCH_TYPE = "OPERATOR";
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        return RULES1;
    }

    private RULES RULES9() {
        RULES RULES1 = new RULES();
        RULES1.SET = "RIGHT_TEXT";
        RULES1.DEFAULT = "LITERAL4";
        RULES1.IGNORE_CASE = "FALSE";
        return RULES1;
    }

    private RULES RULES10() {
        RULES RULES1 = new RULES();
        RULES1.SET = "VCALENDAR_KEYWORDS";
        RULES1.IGNORE_CASE = "FALSE";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL4", new String[]{"YEARLY", });
        KEYWORDS1.add("KEYWORD2", new String[]{"RRULE", });
        KEYWORDS1.add("KEYWORD4", new String[]{"BYDAY", "BYMONTH", "FREQ", "INTERVAL", });
        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES11() {
        RULES RULES1 = new RULES();
        RULES1.SET = "VTIMEZONE_KEYWORDS";
        RULES1.IGNORE_CASE = "FALSE";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD2", new String[]{"DTSTART", "TZNAME", "TZOFFSETFROM", "TZOFFSETTO", });
        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES12() {
        RULES RULES1 = new RULES();
        RULES1.SET = "VEVENT_KEYWORDS";
        RULES1.IGNORE_CASE = "FALSE";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"CONFIRMED", "PRIVATE", });
        KEYWORDS1.add("LITERAL3", new String[]{"DATE", "DURATION", });
        KEYWORDS1.add("KEYWORD3", new String[]{"VALUE", });
        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES13() {
        RULES RULES1 = new RULES();
        RULES1.SET = "CUSTOM_KEYWORDS";
        RULES1.IGNORE_CASE = "FALSE";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "X-[A-Za-z-]+";
        SEQ_REGEXP1.TYPE = "INVALID";
        SEQ_REGEXP1.AT_LINE_START = "TRUE";
        SEQ_REGEXP1.HASH_CHAR = "X";
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), RULES5(), RULES6(), RULES7(), RULES8(), RULES9(), RULES10(), RULES11(), RULES12(), RULES13(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
