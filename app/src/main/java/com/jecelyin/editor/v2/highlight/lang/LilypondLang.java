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
public class LilypondLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "%{";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "%}";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "%";
        PROPERTY3.NAME = "lineComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "{";
        PROPERTY4.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "}";
        PROPERTY5.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "false";
        PROPERTY6.NAME = "doubleBracketIndent";
        PROPERTY PROPERTY7 = new PROPERTY();
        PROPERTY7.VALUE = ".*<<.*";
        PROPERTY7.NAME = "indentNextLines";
        PROPERTY PROPERTY8 = new PROPERTY();
        PROPERTY8.VALUE = ".*>>.*";
        PROPERTY8.NAME = "unindentThisLine";
        PROPERTY PROPERTY9 = new PROPERTY();
        PROPERTY9.VALUE = ".*>>.*";
        PROPERTY9.NAME = "unindentNextLines";
        PROPERTY PROPERTY10 = new PROPERTY();
        PROPERTY10.VALUE = "(?!(.*<<)).*>>.*";
        PROPERTY10.NAME = "unindentThisLine";
        PROPERTY PROPERTY11 = new PROPERTY();
        PROPERTY11.VALUE = ">";
        PROPERTY11.NAME = "electricKeys";
        PROPERTY PROPERTY12 = new PROPERTY();
        PROPERTY12.VALUE = "=";
        PROPERTY12.NAME = "wordBreakChars";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, PROPERTY8, PROPERTY9, PROPERTY10, PROPERTY11, PROPERTY12, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "COMMENT2";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "%{";
        END END1 = new END();
        END1.text = "%}";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "%";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = ";";
        EOL_SPAN2.TYPE = "COMMENT1";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "\\breve";
        SEQ1.TYPE = "DIGIT";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "\\longa";
        SEQ2.TYPE = "DIGIT";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "\\maxima";
        SEQ3.TYPE = "DIGIT";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "=";
        MARK_PREVIOUS1.AT_WHITESPACE_END = "TRUE";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = "=";
        MARK_PREVIOUS2.AT_WHITESPACE_END = "TRUE";
        MARK_PREVIOUS2.TYPE = "FUNCTION";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "{";
        SEQ4.TYPE = "MARKUP";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "}";
        SEQ5.TYPE = "MARKUP";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "[";
        SEQ6.TYPE = "MARKUP";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "]";
        SEQ7.TYPE = "MARKUP";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "<<";
        SEQ8.TYPE = "MARKUP";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = ">>";
        SEQ9.TYPE = "MARKUP";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "-<";
        SEQ10.TYPE = "NULL";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "->";
        SEQ11.TYPE = "NULL";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = ">";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "<";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "|";
        SEQ14.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "\"(\\\\\"|[^\\\\\"]|\\\\)+\"";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        SEQ_REGEXP1.HASH_CHAR = "\"";
        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ15 = new SEQ();
        SEQ15.text = "'";
        SEQ15.TYPE = "MARKUP";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = ",";
        SEQ16.TYPE = "MARKUP";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "[rRs]\\d*\\b";
        SEQ_REGEXP2.HASH_CHARS = "rRs";
        SEQ_REGEXP2.AT_WORD_START = "TRUE";
        SEQ_REGEXP2.TYPE = "LITERAL4";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "ly:";
        MARK_FOLLOWING1.TYPE = "FUNCTION";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "\\\\override\\b";
        SEQ_REGEXP3.TYPE = "KEYWORD1";
        SEQ_REGEXP3.HASH_CHAR = "\\override";
        SEQ_REGEXP SEQ_REGEXP4 = new SEQ_REGEXP();
        SEQ_REGEXP4.text = "\\\\version\\b";
        SEQ_REGEXP4.TYPE = "KEYWORD1";
        SEQ_REGEXP4.HASH_CHAR = "\\version";
        SEQ_REGEXP SEQ_REGEXP5 = new SEQ_REGEXP();
        SEQ_REGEXP5.text = "\\\\include\\b";
        SEQ_REGEXP5.TYPE = "KEYWORD1";
        SEQ_REGEXP5.HASH_CHAR = "\\include";
        SEQ_REGEXP SEQ_REGEXP6 = new SEQ_REGEXP();
        SEQ_REGEXP6.text = "\\\\invalid\\b";
        SEQ_REGEXP6.TYPE = "KEYWORD1";
        SEQ_REGEXP6.HASH_CHAR = "\\invalid";
        SEQ_REGEXP SEQ_REGEXP7 = new SEQ_REGEXP();
        SEQ_REGEXP7.text = "\\\\addquote\\b";
        SEQ_REGEXP7.TYPE = "KEYWORD1";
        SEQ_REGEXP7.HASH_CHAR = "\\addquote";
        SEQ_REGEXP SEQ_REGEXP8 = new SEQ_REGEXP();
        SEQ_REGEXP8.text = "\\\\alternative\\b";
        SEQ_REGEXP8.TYPE = "KEYWORD1";
        SEQ_REGEXP8.HASH_CHAR = "\\alternative";
        SEQ_REGEXP SEQ_REGEXP9 = new SEQ_REGEXP();
        SEQ_REGEXP9.text = "\\\\book\\b";
        SEQ_REGEXP9.TYPE = "KEYWORD1";
        SEQ_REGEXP9.HASH_CHAR = "\\book";
        SEQ_REGEXP SEQ_REGEXP10 = new SEQ_REGEXP();
        SEQ_REGEXP10.text = "\\\\~\\b";
        SEQ_REGEXP10.TYPE = "KEYWORD1";
        SEQ_REGEXP10.HASH_CHAR = "\\~";
        SEQ_REGEXP SEQ_REGEXP11 = new SEQ_REGEXP();
        SEQ_REGEXP11.text = "\\\\mark\\b";
        SEQ_REGEXP11.TYPE = "KEYWORD1";
        SEQ_REGEXP11.HASH_CHAR = "\\mark";
        SEQ_REGEXP SEQ_REGEXP12 = new SEQ_REGEXP();
        SEQ_REGEXP12.text = "\\\\default\\b";
        SEQ_REGEXP12.TYPE = "KEYWORD1";
        SEQ_REGEXP12.HASH_CHAR = "\\default";
        SEQ_REGEXP SEQ_REGEXP13 = new SEQ_REGEXP();
        SEQ_REGEXP13.text = "\\\\key\\b";
        SEQ_REGEXP13.TYPE = "KEYWORD1";
        SEQ_REGEXP13.HASH_CHAR = "\\key";
        SEQ_REGEXP SEQ_REGEXP14 = new SEQ_REGEXP();
        SEQ_REGEXP14.text = "\\\\skip\\b";
        SEQ_REGEXP14.TYPE = "KEYWORD1";
        SEQ_REGEXP14.HASH_CHAR = "\\skip";
        SEQ_REGEXP SEQ_REGEXP15 = new SEQ_REGEXP();
        SEQ_REGEXP15.text = "\\\\octave\\b";
        SEQ_REGEXP15.TYPE = "KEYWORD1";
        SEQ_REGEXP15.HASH_CHAR = "\\octave";
        SEQ_REGEXP SEQ_REGEXP16 = new SEQ_REGEXP();
        SEQ_REGEXP16.text = "\\\\partial\\b";
        SEQ_REGEXP16.TYPE = "KEYWORD1";
        SEQ_REGEXP16.HASH_CHAR = "\\partial";
        SEQ_REGEXP SEQ_REGEXP17 = new SEQ_REGEXP();
        SEQ_REGEXP17.text = "\\\\time\\b";
        SEQ_REGEXP17.TYPE = "KEYWORD1";
        SEQ_REGEXP17.HASH_CHAR = "\\time";
        SEQ_REGEXP SEQ_REGEXP18 = new SEQ_REGEXP();
        SEQ_REGEXP18.text = "\\\\change\\b";
        SEQ_REGEXP18.TYPE = "KEYWORD1";
        SEQ_REGEXP18.HASH_CHAR = "\\change";
        SEQ_REGEXP SEQ_REGEXP19 = new SEQ_REGEXP();
        SEQ_REGEXP19.text = "\\\\consists\\b";
        SEQ_REGEXP19.TYPE = "KEYWORD1";
        SEQ_REGEXP19.HASH_CHAR = "\\consists";
        SEQ_REGEXP SEQ_REGEXP20 = new SEQ_REGEXP();
        SEQ_REGEXP20.text = "\\\\remove\\b";
        SEQ_REGEXP20.TYPE = "KEYWORD1";
        SEQ_REGEXP20.HASH_CHAR = "\\remove";
        SEQ_REGEXP SEQ_REGEXP21 = new SEQ_REGEXP();
        SEQ_REGEXP21.text = "\\\\accepts\\b";
        SEQ_REGEXP21.TYPE = "KEYWORD1";
        SEQ_REGEXP21.HASH_CHAR = "\\accepts";
        SEQ_REGEXP SEQ_REGEXP22 = new SEQ_REGEXP();
        SEQ_REGEXP22.text = "\\\\defaultchild\\b";
        SEQ_REGEXP22.TYPE = "KEYWORD1";
        SEQ_REGEXP22.HASH_CHAR = "\\defaultchild";
        SEQ_REGEXP SEQ_REGEXP23 = new SEQ_REGEXP();
        SEQ_REGEXP23.text = "\\\\denies\\b";
        SEQ_REGEXP23.TYPE = "KEYWORD1";
        SEQ_REGEXP23.HASH_CHAR = "\\denies";
        SEQ_REGEXP SEQ_REGEXP24 = new SEQ_REGEXP();
        SEQ_REGEXP24.text = "\\\\alias\\b";
        SEQ_REGEXP24.TYPE = "KEYWORD1";
        SEQ_REGEXP24.HASH_CHAR = "\\alias";
        SEQ_REGEXP SEQ_REGEXP25 = new SEQ_REGEXP();
        SEQ_REGEXP25.text = "\\\\type\\b";
        SEQ_REGEXP25.TYPE = "KEYWORD1";
        SEQ_REGEXP25.HASH_CHAR = "\\type";
        SEQ_REGEXP SEQ_REGEXP26 = new SEQ_REGEXP();
        SEQ_REGEXP26.text = "\\\\description\\b";
        SEQ_REGEXP26.TYPE = "KEYWORD1";
        SEQ_REGEXP26.HASH_CHAR = "\\description";
        SEQ_REGEXP SEQ_REGEXP27 = new SEQ_REGEXP();
        SEQ_REGEXP27.text = "\\\\name\\b";
        SEQ_REGEXP27.TYPE = "KEYWORD1";
        SEQ_REGEXP27.HASH_CHAR = "\\name";
        SEQ_REGEXP SEQ_REGEXP28 = new SEQ_REGEXP();
        SEQ_REGEXP28.text = "\\\\context\\b";
        SEQ_REGEXP28.TYPE = "KEYWORD1";
        SEQ_REGEXP28.HASH_CHAR = "\\context";
        SEQ_REGEXP SEQ_REGEXP29 = new SEQ_REGEXP();
        SEQ_REGEXP29.text = "\\\\grobdescriptions\\b";
        SEQ_REGEXP29.TYPE = "KEYWORD1";
        SEQ_REGEXP29.HASH_CHAR = "\\grobdescriptions";
        SEQ_REGEXP SEQ_REGEXP30 = new SEQ_REGEXP();
        SEQ_REGEXP30.text = "\\\\markup\\b";
        SEQ_REGEXP30.TYPE = "KEYWORD1";
        SEQ_REGEXP30.HASH_CHAR = "\\markup";
        SEQ_REGEXP SEQ_REGEXP31 = new SEQ_REGEXP();
        SEQ_REGEXP31.text = "\\\\header\\b";
        SEQ_REGEXP31.TYPE = "KEYWORD1";
        SEQ_REGEXP31.HASH_CHAR = "\\header";
        SEQ_REGEXP SEQ_REGEXP32 = new SEQ_REGEXP();
        SEQ_REGEXP32.text = "\\\\notemode\\b";
        SEQ_REGEXP32.TYPE = "KEYWORD1";
        SEQ_REGEXP32.HASH_CHAR = "\\notemode";
        SEQ_REGEXP SEQ_REGEXP33 = new SEQ_REGEXP();
        SEQ_REGEXP33.text = "\\\\drummode\\b";
        SEQ_REGEXP33.TYPE = "KEYWORD1";
        SEQ_REGEXP33.HASH_CHAR = "\\drummode";
        SEQ_REGEXP SEQ_REGEXP34 = new SEQ_REGEXP();
        SEQ_REGEXP34.text = "\\\\figuremode\\b";
        SEQ_REGEXP34.TYPE = "KEYWORD1";
        SEQ_REGEXP34.HASH_CHAR = "\\figuremode";
        SEQ_REGEXP SEQ_REGEXP35 = new SEQ_REGEXP();
        SEQ_REGEXP35.text = "\\\\chordmode\\b";
        SEQ_REGEXP35.TYPE = "KEYWORD1";
        SEQ_REGEXP35.HASH_CHAR = "\\chordmode";
        SEQ_REGEXP SEQ_REGEXP36 = new SEQ_REGEXP();
        SEQ_REGEXP36.text = "\\\\lyricmode\\b";
        SEQ_REGEXP36.TYPE = "KEYWORD1";
        SEQ_REGEXP36.HASH_CHAR = "\\lyricmode";
        SEQ_REGEXP SEQ_REGEXP37 = new SEQ_REGEXP();
        SEQ_REGEXP37.text = "\\\\drums\\b";
        SEQ_REGEXP37.TYPE = "KEYWORD1";
        SEQ_REGEXP37.HASH_CHAR = "\\drums";
        SEQ_REGEXP SEQ_REGEXP38 = new SEQ_REGEXP();
        SEQ_REGEXP38.text = "\\\\figures\\b";
        SEQ_REGEXP38.TYPE = "KEYWORD1";
        SEQ_REGEXP38.HASH_CHAR = "\\figures";
        SEQ_REGEXP SEQ_REGEXP39 = new SEQ_REGEXP();
        SEQ_REGEXP39.text = "\\\\chords\\b";
        SEQ_REGEXP39.TYPE = "KEYWORD1";
        SEQ_REGEXP39.HASH_CHAR = "\\chords";
        SEQ_REGEXP SEQ_REGEXP40 = new SEQ_REGEXP();
        SEQ_REGEXP40.text = "\\\\lyrics\\b";
        SEQ_REGEXP40.TYPE = "KEYWORD1";
        SEQ_REGEXP40.HASH_CHAR = "\\lyrics";
        SEQ_REGEXP SEQ_REGEXP41 = new SEQ_REGEXP();
        SEQ_REGEXP41.text = "\\\\once\\b";
        SEQ_REGEXP41.TYPE = "KEYWORD1";
        SEQ_REGEXP41.HASH_CHAR = "\\once";
        SEQ_REGEXP SEQ_REGEXP42 = new SEQ_REGEXP();
        SEQ_REGEXP42.text = "\\\\revert\\b";
        SEQ_REGEXP42.TYPE = "KEYWORD1";
        SEQ_REGEXP42.HASH_CHAR = "\\revert";
        SEQ_REGEXP SEQ_REGEXP43 = new SEQ_REGEXP();
        SEQ_REGEXP43.text = "\\\\set\\b";
        SEQ_REGEXP43.TYPE = "KEYWORD1";
        SEQ_REGEXP43.HASH_CHAR = "\\set";
        SEQ_REGEXP SEQ_REGEXP44 = new SEQ_REGEXP();
        SEQ_REGEXP44.text = "\\\\unset\\b";
        SEQ_REGEXP44.TYPE = "KEYWORD1";
        SEQ_REGEXP44.HASH_CHAR = "\\unset";
        SEQ_REGEXP SEQ_REGEXP45 = new SEQ_REGEXP();
        SEQ_REGEXP45.text = "\\\\addlyrics\\b";
        SEQ_REGEXP45.TYPE = "KEYWORD1";
        SEQ_REGEXP45.HASH_CHAR = "\\addlyrics";
        SEQ_REGEXP SEQ_REGEXP46 = new SEQ_REGEXP();
        SEQ_REGEXP46.text = "\\\\objectid\\b";
        SEQ_REGEXP46.TYPE = "KEYWORD1";
        SEQ_REGEXP46.HASH_CHAR = "\\objectid";
        SEQ_REGEXP SEQ_REGEXP47 = new SEQ_REGEXP();
        SEQ_REGEXP47.text = "\\\\with\\b";
        SEQ_REGEXP47.TYPE = "KEYWORD1";
        SEQ_REGEXP47.HASH_CHAR = "\\with";
        SEQ_REGEXP SEQ_REGEXP48 = new SEQ_REGEXP();
        SEQ_REGEXP48.text = "\\\\rest\\b";
        SEQ_REGEXP48.TYPE = "KEYWORD1";
        SEQ_REGEXP48.HASH_CHAR = "\\rest";
        SEQ_REGEXP SEQ_REGEXP49 = new SEQ_REGEXP();
        SEQ_REGEXP49.text = "\\\\paper\\b";
        SEQ_REGEXP49.TYPE = "KEYWORD1";
        SEQ_REGEXP49.HASH_CHAR = "\\paper";
        SEQ_REGEXP SEQ_REGEXP50 = new SEQ_REGEXP();
        SEQ_REGEXP50.text = "\\\\midi\\b";
        SEQ_REGEXP50.TYPE = "KEYWORD1";
        SEQ_REGEXP50.HASH_CHAR = "\\midi";
        SEQ_REGEXP SEQ_REGEXP51 = new SEQ_REGEXP();
        SEQ_REGEXP51.text = "\\\\layout\\b";
        SEQ_REGEXP51.TYPE = "KEYWORD1";
        SEQ_REGEXP51.HASH_CHAR = "\\layout";
        SEQ_REGEXP SEQ_REGEXP52 = new SEQ_REGEXP();
        SEQ_REGEXP52.text = "\\\\new\\b";
        SEQ_REGEXP52.TYPE = "KEYWORD1";
        SEQ_REGEXP52.HASH_CHAR = "\\new";
        SEQ_REGEXP SEQ_REGEXP53 = new SEQ_REGEXP();
        SEQ_REGEXP53.text = "\\\\times\\b";
        SEQ_REGEXP53.TYPE = "KEYWORD1";
        SEQ_REGEXP53.HASH_CHAR = "\\times";
        SEQ_REGEXP SEQ_REGEXP54 = new SEQ_REGEXP();
        SEQ_REGEXP54.text = "\\\\transpose\\b";
        SEQ_REGEXP54.TYPE = "KEYWORD1";
        SEQ_REGEXP54.HASH_CHAR = "\\transpose";
        SEQ_REGEXP SEQ_REGEXP55 = new SEQ_REGEXP();
        SEQ_REGEXP55.text = "\\\\tag\\b";
        SEQ_REGEXP55.TYPE = "KEYWORD1";
        SEQ_REGEXP55.HASH_CHAR = "\\tag";
        SEQ_REGEXP SEQ_REGEXP56 = new SEQ_REGEXP();
        SEQ_REGEXP56.text = "\\\\relative\\b";
        SEQ_REGEXP56.TYPE = "KEYWORD1";
        SEQ_REGEXP56.HASH_CHAR = "\\relative";
        SEQ_REGEXP SEQ_REGEXP57 = new SEQ_REGEXP();
        SEQ_REGEXP57.text = "\\\\renameinput\\b";
        SEQ_REGEXP57.TYPE = "KEYWORD1";
        SEQ_REGEXP57.HASH_CHAR = "\\renameinput";
        SEQ_REGEXP SEQ_REGEXP58 = new SEQ_REGEXP();
        SEQ_REGEXP58.text = "\\\\repeat\\b";
        SEQ_REGEXP58.TYPE = "KEYWORD1";
        SEQ_REGEXP58.HASH_CHAR = "\\repeat";
        SEQ_REGEXP SEQ_REGEXP59 = new SEQ_REGEXP();
        SEQ_REGEXP59.text = "\\\\lyricsto\\b";
        SEQ_REGEXP59.TYPE = "KEYWORD1";
        SEQ_REGEXP59.HASH_CHAR = "\\lyricsto";
        SEQ_REGEXP SEQ_REGEXP60 = new SEQ_REGEXP();
        SEQ_REGEXP60.text = "\\\\score\\b";
        SEQ_REGEXP60.TYPE = "KEYWORD1";
        SEQ_REGEXP60.HASH_CHAR = "\\score";
        SEQ_REGEXP SEQ_REGEXP61 = new SEQ_REGEXP();
        SEQ_REGEXP61.text = "\\\\sequential\\b";
        SEQ_REGEXP61.TYPE = "KEYWORD1";
        SEQ_REGEXP61.HASH_CHAR = "\\sequential";
        SEQ_REGEXP SEQ_REGEXP62 = new SEQ_REGEXP();
        SEQ_REGEXP62.text = "\\\\simultaneous\\b";
        SEQ_REGEXP62.TYPE = "KEYWORD1";
        SEQ_REGEXP62.HASH_CHAR = "\\simultaneous";
        SEQ_REGEXP SEQ_REGEXP63 = new SEQ_REGEXP();
        SEQ_REGEXP63.text = "\\\\longa\\b";
        SEQ_REGEXP63.TYPE = "KEYWORD1";
        SEQ_REGEXP63.HASH_CHAR = "\\longa";
        SEQ_REGEXP SEQ_REGEXP64 = new SEQ_REGEXP();
        SEQ_REGEXP64.text = "\\\\breve\\b";
        SEQ_REGEXP64.TYPE = "KEYWORD1";
        SEQ_REGEXP64.HASH_CHAR = "\\breve";
        SEQ_REGEXP SEQ_REGEXP65 = new SEQ_REGEXP();
        SEQ_REGEXP65.text = "\\\\maxima\\b";
        SEQ_REGEXP65.TYPE = "KEYWORD1";
        SEQ_REGEXP65.HASH_CHAR = "\\maxima";
        SEQ_REGEXP SEQ_REGEXP66 = new SEQ_REGEXP();
        SEQ_REGEXP66.text = "\\\\tempo\\b";
        SEQ_REGEXP66.TYPE = "KEYWORD1";
        SEQ_REGEXP66.HASH_CHAR = "\\tempo";
        SEQ_REGEXP SEQ_REGEXP67 = new SEQ_REGEXP();
        SEQ_REGEXP67.text = "\\\\AncientRemoveEmptyStaffContext\\b";
        SEQ_REGEXP67.TYPE = "KEYWORD3";
        SEQ_REGEXP67.HASH_CHAR = "\\AncientRemoveEmptyStaffContext";
        SEQ_REGEXP SEQ_REGEXP68 = new SEQ_REGEXP();
        SEQ_REGEXP68.text = "\\\\RemoveEmptyRhythmicStaffContext\\b";
        SEQ_REGEXP68.TYPE = "KEYWORD3";
        SEQ_REGEXP68.HASH_CHAR = "\\RemoveEmptyRhythmicStaffContext";
        SEQ_REGEXP SEQ_REGEXP69 = new SEQ_REGEXP();
        SEQ_REGEXP69.text = "\\\\RemoveEmptyStaffContext\\b";
        SEQ_REGEXP69.TYPE = "KEYWORD3";
        SEQ_REGEXP69.HASH_CHAR = "\\RemoveEmptyStaffContext";
        SEQ_REGEXP SEQ_REGEXP70 = new SEQ_REGEXP();
        SEQ_REGEXP70.text = "\\\\accent\\b";
        SEQ_REGEXP70.TYPE = "KEYWORD3";
        SEQ_REGEXP70.HASH_CHAR = "\\accent";
        SEQ_REGEXP SEQ_REGEXP71 = new SEQ_REGEXP();
        SEQ_REGEXP71.text = "\\\\aeolian\\b";
        SEQ_REGEXP71.TYPE = "KEYWORD3";
        SEQ_REGEXP71.HASH_CHAR = "\\aeolian";
        SEQ_REGEXP SEQ_REGEXP72 = new SEQ_REGEXP();
        SEQ_REGEXP72.text = "\\\\afterGraceFraction\\b";
        SEQ_REGEXP72.TYPE = "KEYWORD3";
        SEQ_REGEXP72.HASH_CHAR = "\\afterGraceFraction";
        SEQ_REGEXP SEQ_REGEXP73 = new SEQ_REGEXP();
        SEQ_REGEXP73.text = "\\\\aikenHeads\\b";
        SEQ_REGEXP73.TYPE = "KEYWORD3";
        SEQ_REGEXP73.HASH_CHAR = "\\aikenHeads";
        SEQ_REGEXP SEQ_REGEXP74 = new SEQ_REGEXP();
        SEQ_REGEXP74.text = "\\\\arpeggio\\b";
        SEQ_REGEXP74.TYPE = "KEYWORD3";
        SEQ_REGEXP74.HASH_CHAR = "\\arpeggio";
        SEQ_REGEXP SEQ_REGEXP75 = new SEQ_REGEXP();
        SEQ_REGEXP75.text = "\\\\arpeggioArrowDown\\b";
        SEQ_REGEXP75.TYPE = "KEYWORD3";
        SEQ_REGEXP75.HASH_CHAR = "\\arpeggioArrowDown";
        SEQ_REGEXP SEQ_REGEXP76 = new SEQ_REGEXP();
        SEQ_REGEXP76.text = "\\\\arpeggioArrowUp\\b";
        SEQ_REGEXP76.TYPE = "KEYWORD3";
        SEQ_REGEXP76.HASH_CHAR = "\\arpeggioArrowUp";
        SEQ_REGEXP SEQ_REGEXP77 = new SEQ_REGEXP();
        SEQ_REGEXP77.text = "\\\\arpeggioBracket\\b";
        SEQ_REGEXP77.TYPE = "KEYWORD3";
        SEQ_REGEXP77.HASH_CHAR = "\\arpeggioBracket";
        SEQ_REGEXP SEQ_REGEXP78 = new SEQ_REGEXP();
        SEQ_REGEXP78.text = "\\\\arpeggioNormal\\b";
        SEQ_REGEXP78.TYPE = "KEYWORD3";
        SEQ_REGEXP78.HASH_CHAR = "\\arpeggioNormal";
        SEQ_REGEXP SEQ_REGEXP79 = new SEQ_REGEXP();
        SEQ_REGEXP79.text = "\\\\arpeggioParenthesis\\b";
        SEQ_REGEXP79.TYPE = "KEYWORD3";
        SEQ_REGEXP79.HASH_CHAR = "\\arpeggioParenthesis";
        SEQ_REGEXP SEQ_REGEXP80 = new SEQ_REGEXP();
        SEQ_REGEXP80.text = "\\\\autoBeamOff\\b";
        SEQ_REGEXP80.TYPE = "KEYWORD3";
        SEQ_REGEXP80.HASH_CHAR = "\\autoBeamOff";
        SEQ_REGEXP SEQ_REGEXP81 = new SEQ_REGEXP();
        SEQ_REGEXP81.text = "\\\\autoBeamOn\\b";
        SEQ_REGEXP81.TYPE = "KEYWORD3";
        SEQ_REGEXP81.HASH_CHAR = "\\autoBeamOn";
        SEQ_REGEXP SEQ_REGEXP82 = new SEQ_REGEXP();
        SEQ_REGEXP82.text = "\\\\balloonLengthOff\\b";
        SEQ_REGEXP82.TYPE = "KEYWORD3";
        SEQ_REGEXP82.HASH_CHAR = "\\balloonLengthOff";
        SEQ_REGEXP SEQ_REGEXP83 = new SEQ_REGEXP();
        SEQ_REGEXP83.text = "\\\\balloonLengthOn\\b";
        SEQ_REGEXP83.TYPE = "KEYWORD3";
        SEQ_REGEXP83.HASH_CHAR = "\\balloonLengthOn";
        SEQ_REGEXP SEQ_REGEXP84 = new SEQ_REGEXP();
        SEQ_REGEXP84.text = "\\\\bassFigureExtendersOff\\b";
        SEQ_REGEXP84.TYPE = "KEYWORD3";
        SEQ_REGEXP84.HASH_CHAR = "\\bassFigureExtendersOff";
        SEQ_REGEXP SEQ_REGEXP85 = new SEQ_REGEXP();
        SEQ_REGEXP85.text = "\\\\bassFigureExtendersOn\\b";
        SEQ_REGEXP85.TYPE = "KEYWORD3";
        SEQ_REGEXP85.HASH_CHAR = "\\bassFigureExtendersOn";
        SEQ_REGEXP SEQ_REGEXP86 = new SEQ_REGEXP();
        SEQ_REGEXP86.text = "\\\\bassFigureStaffAlignmentDown\\b";
        SEQ_REGEXP86.TYPE = "KEYWORD3";
        SEQ_REGEXP86.HASH_CHAR = "\\bassFigureStaffAlignmentDown";
        SEQ_REGEXP SEQ_REGEXP87 = new SEQ_REGEXP();
        SEQ_REGEXP87.text = "\\\\bassFigureStaffAlignmentNeutral\\b";
        SEQ_REGEXP87.TYPE = "KEYWORD3";
        SEQ_REGEXP87.HASH_CHAR = "\\bassFigureStaffAlignmentNeutral";
        SEQ_REGEXP SEQ_REGEXP88 = new SEQ_REGEXP();
        SEQ_REGEXP88.text = "\\\\bassFigureStaffAlignmentUp\\b";
        SEQ_REGEXP88.TYPE = "KEYWORD3";
        SEQ_REGEXP88.HASH_CHAR = "\\bassFigureStaffAlignmentUp";
        SEQ_REGEXP SEQ_REGEXP89 = new SEQ_REGEXP();
        SEQ_REGEXP89.text = "\\\\between-system-padding\\b";
        SEQ_REGEXP89.TYPE = "KEYWORD3";
        SEQ_REGEXP89.HASH_CHAR = "\\between-system-padding";
        SEQ_REGEXP SEQ_REGEXP90 = new SEQ_REGEXP();
        SEQ_REGEXP90.text = "\\\\between-system-space\\b";
        SEQ_REGEXP90.TYPE = "KEYWORD3";
        SEQ_REGEXP90.HASH_CHAR = "\\between-system-space";
        SEQ_REGEXP SEQ_REGEXP91 = new SEQ_REGEXP();
        SEQ_REGEXP91.text = "\\\\bigger\\b";
        SEQ_REGEXP91.TYPE = "KEYWORD3";
        SEQ_REGEXP91.HASH_CHAR = "\\bigger";
        SEQ_REGEXP SEQ_REGEXP92 = new SEQ_REGEXP();
        SEQ_REGEXP92.text = "\\\\blackTriangleMarkup\\b";
        SEQ_REGEXP92.TYPE = "KEYWORD3";
        SEQ_REGEXP92.HASH_CHAR = "\\blackTriangleMarkup";
        SEQ_REGEXP SEQ_REGEXP93 = new SEQ_REGEXP();
        SEQ_REGEXP93.text = "\\\\bookTitleMarkup\\b";
        SEQ_REGEXP93.TYPE = "KEYWORD3";
        SEQ_REGEXP93.HASH_CHAR = "\\bookTitleMarkup";
        SEQ_REGEXP SEQ_REGEXP94 = new SEQ_REGEXP();
        SEQ_REGEXP94.text = "\\\\bracketCloseSymbol\\b";
        SEQ_REGEXP94.TYPE = "KEYWORD3";
        SEQ_REGEXP94.HASH_CHAR = "\\bracketCloseSymbol";
        SEQ_REGEXP SEQ_REGEXP95 = new SEQ_REGEXP();
        SEQ_REGEXP95.text = "\\\\bracketOpenSymbol\\b";
        SEQ_REGEXP95.TYPE = "KEYWORD3";
        SEQ_REGEXP95.HASH_CHAR = "\\bracketOpenSymbol";
        SEQ_REGEXP SEQ_REGEXP96 = new SEQ_REGEXP();
        SEQ_REGEXP96.text = "\\\\break\\b";
        SEQ_REGEXP96.TYPE = "KEYWORD3";
        SEQ_REGEXP96.HASH_CHAR = "\\break";
        SEQ_REGEXP SEQ_REGEXP97 = new SEQ_REGEXP();
        SEQ_REGEXP97.text = "\\\\breve\\b";
        SEQ_REGEXP97.TYPE = "KEYWORD3";
        SEQ_REGEXP97.HASH_CHAR = "\\breve";
        SEQ_REGEXP SEQ_REGEXP98 = new SEQ_REGEXP();
        SEQ_REGEXP98.text = "\\\\cadenzaOff\\b";
        SEQ_REGEXP98.TYPE = "KEYWORD3";
        SEQ_REGEXP98.HASH_CHAR = "\\cadenzaOff";
        SEQ_REGEXP SEQ_REGEXP99 = new SEQ_REGEXP();
        SEQ_REGEXP99.text = "\\\\cadenzaOn\\b";
        SEQ_REGEXP99.TYPE = "KEYWORD3";
        SEQ_REGEXP99.HASH_CHAR = "\\cadenzaOn";
        SEQ_REGEXP SEQ_REGEXP100 = new SEQ_REGEXP();
        SEQ_REGEXP100.text = "\\\\center\\b";
        SEQ_REGEXP100.TYPE = "KEYWORD3";
        SEQ_REGEXP100.HASH_CHAR = "\\center";
        SEQ_REGEXP SEQ_REGEXP101 = new SEQ_REGEXP();
        SEQ_REGEXP101.text = "\\\\chordmodifiers\\b";
        SEQ_REGEXP101.TYPE = "KEYWORD3";
        SEQ_REGEXP101.HASH_CHAR = "\\chordmodifiers";
        SEQ_REGEXP SEQ_REGEXP102 = new SEQ_REGEXP();
        SEQ_REGEXP102.text = "\\\\cm\\b";
        SEQ_REGEXP102.TYPE = "KEYWORD3";
        SEQ_REGEXP102.HASH_CHAR = "\\cm";
        SEQ_REGEXP SEQ_REGEXP103 = new SEQ_REGEXP();
        SEQ_REGEXP103.text = "\\\\coda\\b";
        SEQ_REGEXP103.TYPE = "KEYWORD3";
        SEQ_REGEXP103.HASH_CHAR = "\\coda";
        SEQ_REGEXP SEQ_REGEXP104 = new SEQ_REGEXP();
        SEQ_REGEXP104.text = "\\\\compressFullBarRests\\b";
        SEQ_REGEXP104.TYPE = "KEYWORD3";
        SEQ_REGEXP104.HASH_CHAR = "\\compressFullBarRests";
        SEQ_REGEXP SEQ_REGEXP105 = new SEQ_REGEXP();
        SEQ_REGEXP105.text = "\\\\cr\\b";
        SEQ_REGEXP105.TYPE = "KEYWORD3";
        SEQ_REGEXP105.HASH_CHAR = "\\cr";
        SEQ_REGEXP SEQ_REGEXP106 = new SEQ_REGEXP();
        SEQ_REGEXP106.text = "\\\\cresc\\b";
        SEQ_REGEXP106.TYPE = "KEYWORD3";
        SEQ_REGEXP106.HASH_CHAR = "\\cresc";
        SEQ_REGEXP SEQ_REGEXP107 = new SEQ_REGEXP();
        SEQ_REGEXP107.text = "\\\\crescHairpin\\b";
        SEQ_REGEXP107.TYPE = "KEYWORD3";
        SEQ_REGEXP107.HASH_CHAR = "\\crescHairpin";
        SEQ_REGEXP SEQ_REGEXP108 = new SEQ_REGEXP();
        SEQ_REGEXP108.text = "\\\\crescTextCresc\\b";
        SEQ_REGEXP108.TYPE = "KEYWORD3";
        SEQ_REGEXP108.HASH_CHAR = "\\crescTextCresc";
        SEQ_REGEXP SEQ_REGEXP109 = new SEQ_REGEXP();
        SEQ_REGEXP109.text = "\\\\decr\\b";
        SEQ_REGEXP109.TYPE = "KEYWORD3";
        SEQ_REGEXP109.HASH_CHAR = "\\decr";
        SEQ_REGEXP SEQ_REGEXP110 = new SEQ_REGEXP();
        SEQ_REGEXP110.text = "\\\\defaultTimeSignature\\b";
        SEQ_REGEXP110.TYPE = "KEYWORD3";
        SEQ_REGEXP110.HASH_CHAR = "\\defaultTimeSignature";
        SEQ_REGEXP SEQ_REGEXP111 = new SEQ_REGEXP();
        SEQ_REGEXP111.text = "\\\\dim\\b";
        SEQ_REGEXP111.TYPE = "KEYWORD3";
        SEQ_REGEXP111.HASH_CHAR = "\\dim";
        SEQ_REGEXP SEQ_REGEXP112 = new SEQ_REGEXP();
        SEQ_REGEXP112.text = "\\\\dimHairpin\\b";
        SEQ_REGEXP112.TYPE = "KEYWORD3";
        SEQ_REGEXP112.HASH_CHAR = "\\dimHairpin";
        SEQ_REGEXP SEQ_REGEXP113 = new SEQ_REGEXP();
        SEQ_REGEXP113.text = "\\\\dimTextDecr\\b";
        SEQ_REGEXP113.TYPE = "KEYWORD3";
        SEQ_REGEXP113.HASH_CHAR = "\\dimTextDecr";
        SEQ_REGEXP SEQ_REGEXP114 = new SEQ_REGEXP();
        SEQ_REGEXP114.text = "\\\\dimTextDecresc\\b";
        SEQ_REGEXP114.TYPE = "KEYWORD3";
        SEQ_REGEXP114.HASH_CHAR = "\\dimTextDecresc";
        SEQ_REGEXP SEQ_REGEXP115 = new SEQ_REGEXP();
        SEQ_REGEXP115.text = "\\\\dimTextDim\\b";
        SEQ_REGEXP115.TYPE = "KEYWORD3";
        SEQ_REGEXP115.HASH_CHAR = "\\dimTextDim";
        SEQ_REGEXP SEQ_REGEXP116 = new SEQ_REGEXP();
        SEQ_REGEXP116.text = "\\\\dorian\\b";
        SEQ_REGEXP116.TYPE = "KEYWORD3";
        SEQ_REGEXP116.HASH_CHAR = "\\dorian";
        SEQ_REGEXP SEQ_REGEXP117 = new SEQ_REGEXP();
        SEQ_REGEXP117.text = "\\\\dotsDown\\b";
        SEQ_REGEXP117.TYPE = "KEYWORD3";
        SEQ_REGEXP117.HASH_CHAR = "\\dotsDown";
        SEQ_REGEXP SEQ_REGEXP118 = new SEQ_REGEXP();
        SEQ_REGEXP118.text = "\\\\dotsNeutral\\b";
        SEQ_REGEXP118.TYPE = "KEYWORD3";
        SEQ_REGEXP118.HASH_CHAR = "\\dotsNeutral";
        SEQ_REGEXP SEQ_REGEXP119 = new SEQ_REGEXP();
        SEQ_REGEXP119.text = "\\\\dotsUp\\b";
        SEQ_REGEXP119.TYPE = "KEYWORD3";
        SEQ_REGEXP119.HASH_CHAR = "\\dotsUp";
        SEQ_REGEXP SEQ_REGEXP120 = new SEQ_REGEXP();
        SEQ_REGEXP120.text = "\\\\down\\b";
        SEQ_REGEXP120.TYPE = "KEYWORD3";
        SEQ_REGEXP120.HASH_CHAR = "\\down";
        SEQ_REGEXP SEQ_REGEXP121 = new SEQ_REGEXP();
        SEQ_REGEXP121.text = "\\\\downbow\\b";
        SEQ_REGEXP121.TYPE = "KEYWORD3";
        SEQ_REGEXP121.HASH_CHAR = "\\downbow";
        SEQ_REGEXP SEQ_REGEXP122 = new SEQ_REGEXP();
        SEQ_REGEXP122.text = "\\\\downmordent\\b";
        SEQ_REGEXP122.TYPE = "KEYWORD3";
        SEQ_REGEXP122.HASH_CHAR = "\\downmordent";
        SEQ_REGEXP SEQ_REGEXP123 = new SEQ_REGEXP();
        SEQ_REGEXP123.text = "\\\\downprall\\b";
        SEQ_REGEXP123.TYPE = "KEYWORD3";
        SEQ_REGEXP123.HASH_CHAR = "\\downprall";
        SEQ_REGEXP SEQ_REGEXP124 = new SEQ_REGEXP();
        SEQ_REGEXP124.text = "\\\\drumPitchNames\\b";
        SEQ_REGEXP124.TYPE = "KEYWORD3";
        SEQ_REGEXP124.HASH_CHAR = "\\drumPitchNames";
        SEQ_REGEXP SEQ_REGEXP125 = new SEQ_REGEXP();
        SEQ_REGEXP125.text = "\\\\dutchPitchnames\\b";
        SEQ_REGEXP125.TYPE = "KEYWORD3";
        SEQ_REGEXP125.HASH_CHAR = "\\dutchPitchnames";
        SEQ_REGEXP SEQ_REGEXP126 = new SEQ_REGEXP();
        SEQ_REGEXP126.text = "\\\\dynamicDown\\b";
        SEQ_REGEXP126.TYPE = "KEYWORD3";
        SEQ_REGEXP126.HASH_CHAR = "\\dynamicDown";
        SEQ_REGEXP SEQ_REGEXP127 = new SEQ_REGEXP();
        SEQ_REGEXP127.text = "\\\\dynamicNeutral\\b";
        SEQ_REGEXP127.TYPE = "KEYWORD3";
        SEQ_REGEXP127.HASH_CHAR = "\\dynamicNeutral";
        SEQ_REGEXP SEQ_REGEXP128 = new SEQ_REGEXP();
        SEQ_REGEXP128.text = "\\\\dynamicUp\\b";
        SEQ_REGEXP128.TYPE = "KEYWORD3";
        SEQ_REGEXP128.HASH_CHAR = "\\dynamicUp";
        SEQ_REGEXP SEQ_REGEXP129 = new SEQ_REGEXP();
        SEQ_REGEXP129.text = "\\\\easyHeadsOff\\b";
        SEQ_REGEXP129.TYPE = "KEYWORD3";
        SEQ_REGEXP129.HASH_CHAR = "\\easyHeadsOff";
        SEQ_REGEXP SEQ_REGEXP130 = new SEQ_REGEXP();
        SEQ_REGEXP130.text = "\\\\easyHeadsOn\\b";
        SEQ_REGEXP130.TYPE = "KEYWORD3";
        SEQ_REGEXP130.HASH_CHAR = "\\easyHeadsOn";
        SEQ_REGEXP SEQ_REGEXP131 = new SEQ_REGEXP();
        SEQ_REGEXP131.text = "\\\\endcr\\b";
        SEQ_REGEXP131.TYPE = "KEYWORD3";
        SEQ_REGEXP131.HASH_CHAR = "\\endcr";
        SEQ_REGEXP SEQ_REGEXP132 = new SEQ_REGEXP();
        SEQ_REGEXP132.text = "\\\\endcresc\\b";
        SEQ_REGEXP132.TYPE = "KEYWORD3";
        SEQ_REGEXP132.HASH_CHAR = "\\endcresc";
        SEQ_REGEXP SEQ_REGEXP133 = new SEQ_REGEXP();
        SEQ_REGEXP133.text = "\\\\enddecr\\b";
        SEQ_REGEXP133.TYPE = "KEYWORD3";
        SEQ_REGEXP133.HASH_CHAR = "\\enddecr";
        SEQ_REGEXP SEQ_REGEXP134 = new SEQ_REGEXP();
        SEQ_REGEXP134.text = "\\\\enddim\\b";
        SEQ_REGEXP134.TYPE = "KEYWORD3";
        SEQ_REGEXP134.HASH_CHAR = "\\enddim";
        SEQ_REGEXP SEQ_REGEXP135 = new SEQ_REGEXP();
        SEQ_REGEXP135.text = "\\\\endincipit\\b";
        SEQ_REGEXP135.TYPE = "KEYWORD3";
        SEQ_REGEXP135.HASH_CHAR = "\\endincipit";
        SEQ_REGEXP SEQ_REGEXP136 = new SEQ_REGEXP();
        SEQ_REGEXP136.text = "\\\\escapedBiggerSymbol\\b";
        SEQ_REGEXP136.TYPE = "KEYWORD3";
        SEQ_REGEXP136.HASH_CHAR = "\\escapedBiggerSymbol";
        SEQ_REGEXP SEQ_REGEXP137 = new SEQ_REGEXP();
        SEQ_REGEXP137.text = "\\\\escapedExclamationSymbol\\b";
        SEQ_REGEXP137.TYPE = "KEYWORD3";
        SEQ_REGEXP137.HASH_CHAR = "\\escapedExclamationSymbol";
        SEQ_REGEXP SEQ_REGEXP138 = new SEQ_REGEXP();
        SEQ_REGEXP138.text = "\\\\escapedParenthesisCloseSymbol\\b";
        SEQ_REGEXP138.TYPE = "KEYWORD3";
        SEQ_REGEXP138.HASH_CHAR = "\\escapedParenthesisCloseSymbol";
        SEQ_REGEXP SEQ_REGEXP139 = new SEQ_REGEXP();
        SEQ_REGEXP139.text = "\\\\escapedParenthesisOpenSymbol\\b";
        SEQ_REGEXP139.TYPE = "KEYWORD3";
        SEQ_REGEXP139.HASH_CHAR = "\\escapedParenthesisOpenSymbol";
        SEQ_REGEXP SEQ_REGEXP140 = new SEQ_REGEXP();
        SEQ_REGEXP140.text = "\\\\escapedSmallerSymbol\\b";
        SEQ_REGEXP140.TYPE = "KEYWORD3";
        SEQ_REGEXP140.HASH_CHAR = "\\escapedSmallerSymbol";
        SEQ_REGEXP SEQ_REGEXP141 = new SEQ_REGEXP();
        SEQ_REGEXP141.text = "\\\\espressivo\\b";
        SEQ_REGEXP141.TYPE = "KEYWORD3";
        SEQ_REGEXP141.HASH_CHAR = "\\espressivo";
        SEQ_REGEXP SEQ_REGEXP142 = new SEQ_REGEXP();
        SEQ_REGEXP142.text = "\\\\evenHeaderMarkup\\b";
        SEQ_REGEXP142.TYPE = "KEYWORD3";
        SEQ_REGEXP142.HASH_CHAR = "\\evenHeaderMarkup";
        SEQ_REGEXP SEQ_REGEXP143 = new SEQ_REGEXP();
        SEQ_REGEXP143.text = "\\\\expandFullBarRests\\b";
        SEQ_REGEXP143.TYPE = "KEYWORD3";
        SEQ_REGEXP143.HASH_CHAR = "\\expandFullBarRests";
        SEQ_REGEXP SEQ_REGEXP144 = new SEQ_REGEXP();
        SEQ_REGEXP144.text = "\\\\f\\b";
        SEQ_REGEXP144.TYPE = "KEYWORD3";
        SEQ_REGEXP144.HASH_CHAR = "\\f";
        SEQ_REGEXP SEQ_REGEXP145 = new SEQ_REGEXP();
        SEQ_REGEXP145.text = "\\\\fermata\\b";
        SEQ_REGEXP145.TYPE = "KEYWORD3";
        SEQ_REGEXP145.HASH_CHAR = "\\fermata";
        SEQ_REGEXP SEQ_REGEXP146 = new SEQ_REGEXP();
        SEQ_REGEXP146.text = "\\\\fermataMarkup\\b";
        SEQ_REGEXP146.TYPE = "KEYWORD3";
        SEQ_REGEXP146.HASH_CHAR = "\\fermataMarkup";
        SEQ_REGEXP SEQ_REGEXP147 = new SEQ_REGEXP();
        SEQ_REGEXP147.text = "\\\\ff\\b";
        SEQ_REGEXP147.TYPE = "KEYWORD3";
        SEQ_REGEXP147.HASH_CHAR = "\\ff";
        SEQ_REGEXP SEQ_REGEXP148 = new SEQ_REGEXP();
        SEQ_REGEXP148.text = "\\\\fff\\b";
        SEQ_REGEXP148.TYPE = "KEYWORD3";
        SEQ_REGEXP148.HASH_CHAR = "\\fff";
        SEQ_REGEXP SEQ_REGEXP149 = new SEQ_REGEXP();
        SEQ_REGEXP149.text = "\\\\ffff\\b";
        SEQ_REGEXP149.TYPE = "KEYWORD3";
        SEQ_REGEXP149.HASH_CHAR = "\\ffff";
        SEQ_REGEXP SEQ_REGEXP150 = new SEQ_REGEXP();
        SEQ_REGEXP150.text = "\\\\first-page-number\\b";
        SEQ_REGEXP150.TYPE = "KEYWORD3";
        SEQ_REGEXP150.HASH_CHAR = "\\first-page-number";
        SEQ_REGEXP SEQ_REGEXP151 = new SEQ_REGEXP();
        SEQ_REGEXP151.text = "\\\\flageolet\\b";
        SEQ_REGEXP151.TYPE = "KEYWORD3";
        SEQ_REGEXP151.HASH_CHAR = "\\flageolet";
        SEQ_REGEXP SEQ_REGEXP152 = new SEQ_REGEXP();
        SEQ_REGEXP152.text = "\\\\fp\\b";
        SEQ_REGEXP152.TYPE = "KEYWORD3";
        SEQ_REGEXP152.HASH_CHAR = "\\fp";
        SEQ_REGEXP SEQ_REGEXP153 = new SEQ_REGEXP();
        SEQ_REGEXP153.text = "\\\\frenchChords\\b";
        SEQ_REGEXP153.TYPE = "KEYWORD3";
        SEQ_REGEXP153.HASH_CHAR = "\\frenchChords";
        SEQ_REGEXP SEQ_REGEXP154 = new SEQ_REGEXP();
        SEQ_REGEXP154.text = "\\\\fullJazzExceptions\\b";
        SEQ_REGEXP154.TYPE = "KEYWORD3";
        SEQ_REGEXP154.HASH_CHAR = "\\fullJazzExceptions";
        SEQ_REGEXP SEQ_REGEXP155 = new SEQ_REGEXP();
        SEQ_REGEXP155.text = "\\\\fz\\b";
        SEQ_REGEXP155.TYPE = "KEYWORD3";
        SEQ_REGEXP155.HASH_CHAR = "\\fz";
        SEQ_REGEXP SEQ_REGEXP156 = new SEQ_REGEXP();
        SEQ_REGEXP156.text = "\\\\germanChords\\b";
        SEQ_REGEXP156.TYPE = "KEYWORD3";
        SEQ_REGEXP156.HASH_CHAR = "\\germanChords";
        SEQ_REGEXP SEQ_REGEXP157 = new SEQ_REGEXP();
        SEQ_REGEXP157.text = "\\\\glissando\\b";
        SEQ_REGEXP157.TYPE = "KEYWORD3";
        SEQ_REGEXP157.HASH_CHAR = "\\glissando";
        SEQ_REGEXP SEQ_REGEXP158 = new SEQ_REGEXP();
        SEQ_REGEXP158.text = "\\\\harmonic\\b";
        SEQ_REGEXP158.TYPE = "KEYWORD3";
        SEQ_REGEXP158.HASH_CHAR = "\\harmonic";
        SEQ_REGEXP SEQ_REGEXP159 = new SEQ_REGEXP();
        SEQ_REGEXP159.text = "\\\\hideNotes\\b";
        SEQ_REGEXP159.TYPE = "KEYWORD3";
        SEQ_REGEXP159.HASH_CHAR = "\\hideNotes";
        SEQ_REGEXP SEQ_REGEXP160 = new SEQ_REGEXP();
        SEQ_REGEXP160.text = "\\\\hideStaffSwitch\\b";
        SEQ_REGEXP160.TYPE = "KEYWORD3";
        SEQ_REGEXP160.HASH_CHAR = "\\hideStaffSwitch";
        SEQ_REGEXP SEQ_REGEXP161 = new SEQ_REGEXP();
        SEQ_REGEXP161.text = "\\\\huge\\b";
        SEQ_REGEXP161.TYPE = "KEYWORD3";
        SEQ_REGEXP161.HASH_CHAR = "\\huge";
        SEQ_REGEXP SEQ_REGEXP162 = new SEQ_REGEXP();
        SEQ_REGEXP162.text = "\\\\ignatzekExceptionMusic\\b";
        SEQ_REGEXP162.TYPE = "KEYWORD3";
        SEQ_REGEXP162.HASH_CHAR = "\\ignatzekExceptionMusic";
        SEQ_REGEXP SEQ_REGEXP163 = new SEQ_REGEXP();
        SEQ_REGEXP163.text = "\\\\ignatzekExceptions\\b";
        SEQ_REGEXP163.TYPE = "KEYWORD3";
        SEQ_REGEXP163.HASH_CHAR = "\\ignatzekExceptions";
        SEQ_REGEXP SEQ_REGEXP164 = new SEQ_REGEXP();
        SEQ_REGEXP164.text = "\\\\improvisationOff\\b";
        SEQ_REGEXP164.TYPE = "KEYWORD3";
        SEQ_REGEXP164.HASH_CHAR = "\\improvisationOff";
        SEQ_REGEXP SEQ_REGEXP165 = new SEQ_REGEXP();
        SEQ_REGEXP165.text = "\\\\improvisationOn\\b";
        SEQ_REGEXP165.TYPE = "KEYWORD3";
        SEQ_REGEXP165.HASH_CHAR = "\\improvisationOn";
        SEQ_REGEXP SEQ_REGEXP166 = new SEQ_REGEXP();
        SEQ_REGEXP166.text = "\\\\in\\b";
        SEQ_REGEXP166.TYPE = "KEYWORD3";
        SEQ_REGEXP166.HASH_CHAR = "\\in";
        SEQ_REGEXP SEQ_REGEXP167 = new SEQ_REGEXP();
        SEQ_REGEXP167.text = "\\\\instrument-definitions\\b";
        SEQ_REGEXP167.TYPE = "KEYWORD3";
        SEQ_REGEXP167.HASH_CHAR = "\\instrument-definitions";
        SEQ_REGEXP SEQ_REGEXP168 = new SEQ_REGEXP();
        SEQ_REGEXP168.text = "\\\\ionian\\b";
        SEQ_REGEXP168.TYPE = "KEYWORD3";
        SEQ_REGEXP168.HASH_CHAR = "\\ionian";
        SEQ_REGEXP SEQ_REGEXP169 = new SEQ_REGEXP();
        SEQ_REGEXP169.text = "\\\\italianChords\\b";
        SEQ_REGEXP169.TYPE = "KEYWORD3";
        SEQ_REGEXP169.HASH_CHAR = "\\italianChords";
        SEQ_REGEXP SEQ_REGEXP170 = new SEQ_REGEXP();
        SEQ_REGEXP170.text = "\\\\laissezVibrer\\b";
        SEQ_REGEXP170.TYPE = "KEYWORD3";
        SEQ_REGEXP170.HASH_CHAR = "\\laissezVibrer";
        SEQ_REGEXP SEQ_REGEXP171 = new SEQ_REGEXP();
        SEQ_REGEXP171.text = "\\\\large\\b";
        SEQ_REGEXP171.TYPE = "KEYWORD3";
        SEQ_REGEXP171.HASH_CHAR = "\\large";
        SEQ_REGEXP SEQ_REGEXP172 = new SEQ_REGEXP();
        SEQ_REGEXP172.text = "\\\\left\\b";
        SEQ_REGEXP172.TYPE = "KEYWORD3";
        SEQ_REGEXP172.HASH_CHAR = "\\left";
        SEQ_REGEXP SEQ_REGEXP173 = new SEQ_REGEXP();
        SEQ_REGEXP173.text = "\\\\lheel\\b";
        SEQ_REGEXP173.TYPE = "KEYWORD3";
        SEQ_REGEXP173.HASH_CHAR = "\\lheel";
        SEQ_REGEXP SEQ_REGEXP174 = new SEQ_REGEXP();
        SEQ_REGEXP174.text = "\\\\lineprall\\b";
        SEQ_REGEXP174.TYPE = "KEYWORD3";
        SEQ_REGEXP174.HASH_CHAR = "\\lineprall";
        SEQ_REGEXP SEQ_REGEXP175 = new SEQ_REGEXP();
        SEQ_REGEXP175.text = "\\\\locrian\\b";
        SEQ_REGEXP175.TYPE = "KEYWORD3";
        SEQ_REGEXP175.HASH_CHAR = "\\locrian";
        SEQ_REGEXP SEQ_REGEXP176 = new SEQ_REGEXP();
        SEQ_REGEXP176.text = "\\\\longa\\b";
        SEQ_REGEXP176.TYPE = "KEYWORD3";
        SEQ_REGEXP176.HASH_CHAR = "\\longa";
        SEQ_REGEXP SEQ_REGEXP177 = new SEQ_REGEXP();
        SEQ_REGEXP177.text = "\\\\longfermata\\b";
        SEQ_REGEXP177.TYPE = "KEYWORD3";
        SEQ_REGEXP177.HASH_CHAR = "\\longfermata";
        SEQ_REGEXP SEQ_REGEXP178 = new SEQ_REGEXP();
        SEQ_REGEXP178.text = "\\\\ltoe\\b";
        SEQ_REGEXP178.TYPE = "KEYWORD3";
        SEQ_REGEXP178.HASH_CHAR = "\\ltoe";
        SEQ_REGEXP SEQ_REGEXP179 = new SEQ_REGEXP();
        SEQ_REGEXP179.text = "\\\\lydian\\b";
        SEQ_REGEXP179.TYPE = "KEYWORD3";
        SEQ_REGEXP179.HASH_CHAR = "\\lydian";
        SEQ_REGEXP SEQ_REGEXP180 = new SEQ_REGEXP();
        SEQ_REGEXP180.text = "\\\\major\\b";
        SEQ_REGEXP180.TYPE = "KEYWORD3";
        SEQ_REGEXP180.HASH_CHAR = "\\major";
        SEQ_REGEXP SEQ_REGEXP181 = new SEQ_REGEXP();
        SEQ_REGEXP181.text = "\\\\marcato\\b";
        SEQ_REGEXP181.TYPE = "KEYWORD3";
        SEQ_REGEXP181.HASH_CHAR = "\\marcato";
        SEQ_REGEXP SEQ_REGEXP182 = new SEQ_REGEXP();
        SEQ_REGEXP182.text = "\\\\maxima\\b";
        SEQ_REGEXP182.TYPE = "KEYWORD3";
        SEQ_REGEXP182.HASH_CHAR = "\\maxima";
        SEQ_REGEXP SEQ_REGEXP183 = new SEQ_REGEXP();
        SEQ_REGEXP183.text = "\\\\melisma\\b";
        SEQ_REGEXP183.TYPE = "KEYWORD3";
        SEQ_REGEXP183.HASH_CHAR = "\\melisma";
        SEQ_REGEXP SEQ_REGEXP184 = new SEQ_REGEXP();
        SEQ_REGEXP184.text = "\\\\melismaEnd\\b";
        SEQ_REGEXP184.TYPE = "KEYWORD3";
        SEQ_REGEXP184.HASH_CHAR = "\\melismaEnd";
        SEQ_REGEXP SEQ_REGEXP185 = new SEQ_REGEXP();
        SEQ_REGEXP185.text = "\\\\mergeDifferentlyDottedOff\\b";
        SEQ_REGEXP185.TYPE = "KEYWORD3";
        SEQ_REGEXP185.HASH_CHAR = "\\mergeDifferentlyDottedOff";
        SEQ_REGEXP SEQ_REGEXP186 = new SEQ_REGEXP();
        SEQ_REGEXP186.text = "\\\\mergeDifferentlyDottedOn\\b";
        SEQ_REGEXP186.TYPE = "KEYWORD3";
        SEQ_REGEXP186.HASH_CHAR = "\\mergeDifferentlyDottedOn";
        SEQ_REGEXP SEQ_REGEXP187 = new SEQ_REGEXP();
        SEQ_REGEXP187.text = "\\\\mergeDifferentlyHeadedOff\\b";
        SEQ_REGEXP187.TYPE = "KEYWORD3";
        SEQ_REGEXP187.HASH_CHAR = "\\mergeDifferentlyHeadedOff";
        SEQ_REGEXP SEQ_REGEXP188 = new SEQ_REGEXP();
        SEQ_REGEXP188.text = "\\\\mergeDifferentlyHeadedOn\\b";
        SEQ_REGEXP188.TYPE = "KEYWORD3";
        SEQ_REGEXP188.HASH_CHAR = "\\mergeDifferentlyHeadedOn";
        SEQ_REGEXP SEQ_REGEXP189 = new SEQ_REGEXP();
        SEQ_REGEXP189.text = "\\\\mf\\b";
        SEQ_REGEXP189.TYPE = "KEYWORD3";
        SEQ_REGEXP189.HASH_CHAR = "\\mf";
        SEQ_REGEXP SEQ_REGEXP190 = new SEQ_REGEXP();
        SEQ_REGEXP190.text = "\\\\midiDrumPitches\\b";
        SEQ_REGEXP190.TYPE = "KEYWORD3";
        SEQ_REGEXP190.HASH_CHAR = "\\midiDrumPitches";
        SEQ_REGEXP SEQ_REGEXP191 = new SEQ_REGEXP();
        SEQ_REGEXP191.text = "\\\\minor\\b";
        SEQ_REGEXP191.TYPE = "KEYWORD3";
        SEQ_REGEXP191.HASH_CHAR = "\\minor";
        SEQ_REGEXP SEQ_REGEXP192 = new SEQ_REGEXP();
        SEQ_REGEXP192.text = "\\\\mixolydian\\b";
        SEQ_REGEXP192.TYPE = "KEYWORD3";
        SEQ_REGEXP192.HASH_CHAR = "\\mixolydian";
        SEQ_REGEXP SEQ_REGEXP193 = new SEQ_REGEXP();
        SEQ_REGEXP193.text = "\\\\mm\\b";
        SEQ_REGEXP193.TYPE = "KEYWORD3";
        SEQ_REGEXP193.HASH_CHAR = "\\mm";
        SEQ_REGEXP SEQ_REGEXP194 = new SEQ_REGEXP();
        SEQ_REGEXP194.text = "\\\\mordent\\b";
        SEQ_REGEXP194.TYPE = "KEYWORD3";
        SEQ_REGEXP194.HASH_CHAR = "\\mordent";
        SEQ_REGEXP SEQ_REGEXP195 = new SEQ_REGEXP();
        SEQ_REGEXP195.text = "\\\\mp\\b";
        SEQ_REGEXP195.TYPE = "KEYWORD3";
        SEQ_REGEXP195.HASH_CHAR = "\\mp";
        SEQ_REGEXP SEQ_REGEXP196 = new SEQ_REGEXP();
        SEQ_REGEXP196.text = "\\\\newSpacingSection\\b";
        SEQ_REGEXP196.TYPE = "KEYWORD3";
        SEQ_REGEXP196.HASH_CHAR = "\\newSpacingSection";
        SEQ_REGEXP SEQ_REGEXP197 = new SEQ_REGEXP();
        SEQ_REGEXP197.text = "\\\\noBeam\\b";
        SEQ_REGEXP197.TYPE = "KEYWORD3";
        SEQ_REGEXP197.HASH_CHAR = "\\noBeam";
        SEQ_REGEXP SEQ_REGEXP198 = new SEQ_REGEXP();
        SEQ_REGEXP198.text = "\\\\noBreak\\b";
        SEQ_REGEXP198.TYPE = "KEYWORD3";
        SEQ_REGEXP198.HASH_CHAR = "\\noBreak";
        SEQ_REGEXP SEQ_REGEXP199 = new SEQ_REGEXP();
        SEQ_REGEXP199.text = "\\\\normalsize\\b";
        SEQ_REGEXP199.TYPE = "KEYWORD3";
        SEQ_REGEXP199.HASH_CHAR = "\\normalsize";
        SEQ_REGEXP SEQ_REGEXP200 = new SEQ_REGEXP();
        SEQ_REGEXP200.text = "\\\\numericTimeSignature\\b";
        SEQ_REGEXP200.TYPE = "KEYWORD3";
        SEQ_REGEXP200.HASH_CHAR = "\\numericTimeSignature";
        SEQ_REGEXP SEQ_REGEXP201 = new SEQ_REGEXP();
        SEQ_REGEXP201.text = "\\\\oddFooterMarkup\\b";
        SEQ_REGEXP201.TYPE = "KEYWORD3";
        SEQ_REGEXP201.HASH_CHAR = "\\oddFooterMarkup";
        SEQ_REGEXP SEQ_REGEXP202 = new SEQ_REGEXP();
        SEQ_REGEXP202.text = "\\\\oddHeaderMarkup\\b";
        SEQ_REGEXP202.TYPE = "KEYWORD3";
        SEQ_REGEXP202.HASH_CHAR = "\\oddHeaderMarkup";
        SEQ_REGEXP SEQ_REGEXP203 = new SEQ_REGEXP();
        SEQ_REGEXP203.text = "\\\\oneVoice\\b";
        SEQ_REGEXP203.TYPE = "KEYWORD3";
        SEQ_REGEXP203.HASH_CHAR = "\\oneVoice";
        SEQ_REGEXP SEQ_REGEXP204 = new SEQ_REGEXP();
        SEQ_REGEXP204.text = "\\\\open\\b";
        SEQ_REGEXP204.TYPE = "KEYWORD3";
        SEQ_REGEXP204.HASH_CHAR = "\\open";
        SEQ_REGEXP SEQ_REGEXP205 = new SEQ_REGEXP();
        SEQ_REGEXP205.text = "\\\\output-scale\\b";
        SEQ_REGEXP205.TYPE = "KEYWORD3";
        SEQ_REGEXP205.HASH_CHAR = "\\output-scale";
        SEQ_REGEXP SEQ_REGEXP206 = new SEQ_REGEXP();
        SEQ_REGEXP206.text = "\\\\p\\b";
        SEQ_REGEXP206.TYPE = "KEYWORD3";
        SEQ_REGEXP206.HASH_CHAR = "\\p";
        SEQ_REGEXP SEQ_REGEXP207 = new SEQ_REGEXP();
        SEQ_REGEXP207.text = "\\\\page-limit-inter-system-space\\b";
        SEQ_REGEXP207.TYPE = "KEYWORD3";
        SEQ_REGEXP207.HASH_CHAR = "\\page-limit-inter-system-space";
        SEQ_REGEXP SEQ_REGEXP208 = new SEQ_REGEXP();
        SEQ_REGEXP208.text = "\\\\page-top-space\\b";
        SEQ_REGEXP208.TYPE = "KEYWORD3";
        SEQ_REGEXP208.HASH_CHAR = "\\page-top-space";
        SEQ_REGEXP SEQ_REGEXP209 = new SEQ_REGEXP();
        SEQ_REGEXP209.text = "\\\\parenthesisCloseSymbol\\b";
        SEQ_REGEXP209.TYPE = "KEYWORD3";
        SEQ_REGEXP209.HASH_CHAR = "\\parenthesisCloseSymbol";
        SEQ_REGEXP SEQ_REGEXP210 = new SEQ_REGEXP();
        SEQ_REGEXP210.text = "\\\\parenthesisOpenSymbol\\b";
        SEQ_REGEXP210.TYPE = "KEYWORD3";
        SEQ_REGEXP210.HASH_CHAR = "\\parenthesisOpenSymbol";
        SEQ_REGEXP SEQ_REGEXP211 = new SEQ_REGEXP();
        SEQ_REGEXP211.text = "\\\\partialJazzExceptions\\b";
        SEQ_REGEXP211.TYPE = "KEYWORD3";
        SEQ_REGEXP211.HASH_CHAR = "\\partialJazzExceptions";
        SEQ_REGEXP SEQ_REGEXP212 = new SEQ_REGEXP();
        SEQ_REGEXP212.text = "\\\\partialJazzMusic\\b";
        SEQ_REGEXP212.TYPE = "KEYWORD3";
        SEQ_REGEXP212.HASH_CHAR = "\\partialJazzMusic";
        SEQ_REGEXP SEQ_REGEXP213 = new SEQ_REGEXP();
        SEQ_REGEXP213.text = "\\\\phrasingSlurDashed\\b";
        SEQ_REGEXP213.TYPE = "KEYWORD3";
        SEQ_REGEXP213.HASH_CHAR = "\\phrasingSlurDashed";
        SEQ_REGEXP SEQ_REGEXP214 = new SEQ_REGEXP();
        SEQ_REGEXP214.text = "\\\\phrasingSlurDotted\\b";
        SEQ_REGEXP214.TYPE = "KEYWORD3";
        SEQ_REGEXP214.HASH_CHAR = "\\phrasingSlurDotted";
        SEQ_REGEXP SEQ_REGEXP215 = new SEQ_REGEXP();
        SEQ_REGEXP215.text = "\\\\phrasingSlurDown\\b";
        SEQ_REGEXP215.TYPE = "KEYWORD3";
        SEQ_REGEXP215.HASH_CHAR = "\\phrasingSlurDown";
        SEQ_REGEXP SEQ_REGEXP216 = new SEQ_REGEXP();
        SEQ_REGEXP216.text = "\\\\phrasingSlurNeutral\\b";
        SEQ_REGEXP216.TYPE = "KEYWORD3";
        SEQ_REGEXP216.HASH_CHAR = "\\phrasingSlurNeutral";
        SEQ_REGEXP SEQ_REGEXP217 = new SEQ_REGEXP();
        SEQ_REGEXP217.text = "\\\\phrasingSlurSolid\\b";
        SEQ_REGEXP217.TYPE = "KEYWORD3";
        SEQ_REGEXP217.HASH_CHAR = "\\phrasingSlurSolid";
        SEQ_REGEXP SEQ_REGEXP218 = new SEQ_REGEXP();
        SEQ_REGEXP218.text = "\\\\phrasingSlurUp\\b";
        SEQ_REGEXP218.TYPE = "KEYWORD3";
        SEQ_REGEXP218.HASH_CHAR = "\\phrasingSlurUp";
        SEQ_REGEXP SEQ_REGEXP219 = new SEQ_REGEXP();
        SEQ_REGEXP219.text = "\\\\phrygian\\b";
        SEQ_REGEXP219.TYPE = "KEYWORD3";
        SEQ_REGEXP219.HASH_CHAR = "\\phrygian";
        SEQ_REGEXP SEQ_REGEXP220 = new SEQ_REGEXP();
        SEQ_REGEXP220.text = "\\\\pipeSymbol\\b";
        SEQ_REGEXP220.TYPE = "KEYWORD3";
        SEQ_REGEXP220.HASH_CHAR = "\\pipeSymbol";
        SEQ_REGEXP SEQ_REGEXP221 = new SEQ_REGEXP();
        SEQ_REGEXP221.text = "\\\\pitchnames\\b";
        SEQ_REGEXP221.TYPE = "KEYWORD3";
        SEQ_REGEXP221.HASH_CHAR = "\\pitchnames";
        SEQ_REGEXP SEQ_REGEXP222 = new SEQ_REGEXP();
        SEQ_REGEXP222.text = "\\\\portato\\b";
        SEQ_REGEXP222.TYPE = "KEYWORD3";
        SEQ_REGEXP222.HASH_CHAR = "\\portato";
        SEQ_REGEXP SEQ_REGEXP223 = new SEQ_REGEXP();
        SEQ_REGEXP223.text = "\\\\pp\\b";
        SEQ_REGEXP223.TYPE = "KEYWORD3";
        SEQ_REGEXP223.HASH_CHAR = "\\pp";
        SEQ_REGEXP SEQ_REGEXP224 = new SEQ_REGEXP();
        SEQ_REGEXP224.text = "\\\\ppp\\b";
        SEQ_REGEXP224.TYPE = "KEYWORD3";
        SEQ_REGEXP224.HASH_CHAR = "\\ppp";
        SEQ_REGEXP SEQ_REGEXP225 = new SEQ_REGEXP();
        SEQ_REGEXP225.text = "\\\\pppp\\b";
        SEQ_REGEXP225.TYPE = "KEYWORD3";
        SEQ_REGEXP225.HASH_CHAR = "\\pppp";
        SEQ_REGEXP SEQ_REGEXP226 = new SEQ_REGEXP();
        SEQ_REGEXP226.text = "\\\\ppppp\\b";
        SEQ_REGEXP226.TYPE = "KEYWORD3";
        SEQ_REGEXP226.HASH_CHAR = "\\ppppp";
        SEQ_REGEXP SEQ_REGEXP227 = new SEQ_REGEXP();
        SEQ_REGEXP227.text = "\\\\prall\\b";
        SEQ_REGEXP227.TYPE = "KEYWORD3";
        SEQ_REGEXP227.HASH_CHAR = "\\prall";
        SEQ_REGEXP SEQ_REGEXP228 = new SEQ_REGEXP();
        SEQ_REGEXP228.text = "\\\\pralldown\\b";
        SEQ_REGEXP228.TYPE = "KEYWORD3";
        SEQ_REGEXP228.HASH_CHAR = "\\pralldown";
        SEQ_REGEXP SEQ_REGEXP229 = new SEQ_REGEXP();
        SEQ_REGEXP229.text = "\\\\prallmordent\\b";
        SEQ_REGEXP229.TYPE = "KEYWORD3";
        SEQ_REGEXP229.HASH_CHAR = "\\prallmordent";
        SEQ_REGEXP SEQ_REGEXP230 = new SEQ_REGEXP();
        SEQ_REGEXP230.text = "\\\\prallprall\\b";
        SEQ_REGEXP230.TYPE = "KEYWORD3";
        SEQ_REGEXP230.HASH_CHAR = "\\prallprall";
        SEQ_REGEXP SEQ_REGEXP231 = new SEQ_REGEXP();
        SEQ_REGEXP231.text = "\\\\prallup\\b";
        SEQ_REGEXP231.TYPE = "KEYWORD3";
        SEQ_REGEXP231.HASH_CHAR = "\\prallup";
        SEQ_REGEXP SEQ_REGEXP232 = new SEQ_REGEXP();
        SEQ_REGEXP232.text = "\\\\predefinedFretboardsOff\\b";
        SEQ_REGEXP232.TYPE = "KEYWORD3";
        SEQ_REGEXP232.HASH_CHAR = "\\predefinedFretboardsOff";
        SEQ_REGEXP SEQ_REGEXP233 = new SEQ_REGEXP();
        SEQ_REGEXP233.text = "\\\\predefinedFretboardsOn\\b";
        SEQ_REGEXP233.TYPE = "KEYWORD3";
        SEQ_REGEXP233.HASH_CHAR = "\\predefinedFretboardsOn";
        SEQ_REGEXP SEQ_REGEXP234 = new SEQ_REGEXP();
        SEQ_REGEXP234.text = "\\\\print-first-page-number\\b";
        SEQ_REGEXP234.TYPE = "KEYWORD3";
        SEQ_REGEXP234.HASH_CHAR = "\\print-first-page-number";
        SEQ_REGEXP SEQ_REGEXP235 = new SEQ_REGEXP();
        SEQ_REGEXP235.text = "\\\\print-page-number\\b";
        SEQ_REGEXP235.TYPE = "KEYWORD3";
        SEQ_REGEXP235.HASH_CHAR = "\\print-page-number";
        SEQ_REGEXP SEQ_REGEXP236 = new SEQ_REGEXP();
        SEQ_REGEXP236.text = "\\\\pt\\b";
        SEQ_REGEXP236.TYPE = "KEYWORD3";
        SEQ_REGEXP236.HASH_CHAR = "\\pt";
        SEQ_REGEXP SEQ_REGEXP237 = new SEQ_REGEXP();
        SEQ_REGEXP237.text = "\\\\ragged-bottom\\b";
        SEQ_REGEXP237.TYPE = "KEYWORD3";
        SEQ_REGEXP237.HASH_CHAR = "\\ragged-bottom";
        SEQ_REGEXP SEQ_REGEXP238 = new SEQ_REGEXP();
        SEQ_REGEXP238.text = "\\\\ragged-last-bottom\\b";
        SEQ_REGEXP238.TYPE = "KEYWORD3";
        SEQ_REGEXP238.HASH_CHAR = "\\ragged-last-bottom";
        SEQ_REGEXP SEQ_REGEXP239 = new SEQ_REGEXP();
        SEQ_REGEXP239.text = "\\\\repeatTie\\b";
        SEQ_REGEXP239.TYPE = "KEYWORD3";
        SEQ_REGEXP239.HASH_CHAR = "\\repeatTie";
        SEQ_REGEXP SEQ_REGEXP240 = new SEQ_REGEXP();
        SEQ_REGEXP240.text = "\\\\reverseturn\\b";
        SEQ_REGEXP240.TYPE = "KEYWORD3";
        SEQ_REGEXP240.HASH_CHAR = "\\reverseturn";
        SEQ_REGEXP SEQ_REGEXP241 = new SEQ_REGEXP();
        SEQ_REGEXP241.text = "\\\\rfz\\b";
        SEQ_REGEXP241.TYPE = "KEYWORD3";
        SEQ_REGEXP241.HASH_CHAR = "\\rfz";
        SEQ_REGEXP SEQ_REGEXP242 = new SEQ_REGEXP();
        SEQ_REGEXP242.text = "\\\\rheel\\b";
        SEQ_REGEXP242.TYPE = "KEYWORD3";
        SEQ_REGEXP242.HASH_CHAR = "\\rheel";
        SEQ_REGEXP SEQ_REGEXP243 = new SEQ_REGEXP();
        SEQ_REGEXP243.text = "\\\\right\\b";
        SEQ_REGEXP243.TYPE = "KEYWORD3";
        SEQ_REGEXP243.HASH_CHAR = "\\right";
        SEQ_REGEXP SEQ_REGEXP244 = new SEQ_REGEXP();
        SEQ_REGEXP244.text = "\\\\rtoe\\b";
        SEQ_REGEXP244.TYPE = "KEYWORD3";
        SEQ_REGEXP244.HASH_CHAR = "\\rtoe";
        SEQ_REGEXP SEQ_REGEXP245 = new SEQ_REGEXP();
        SEQ_REGEXP245.text = "\\\\sacredHarpHeads\\b";
        SEQ_REGEXP245.TYPE = "KEYWORD3";
        SEQ_REGEXP245.HASH_CHAR = "\\sacredHarpHeads";
        SEQ_REGEXP SEQ_REGEXP246 = new SEQ_REGEXP();
        SEQ_REGEXP246.text = "\\\\scoreTitleMarkup\\b";
        SEQ_REGEXP246.TYPE = "KEYWORD3";
        SEQ_REGEXP246.HASH_CHAR = "\\scoreTitleMarkup";
        SEQ_REGEXP SEQ_REGEXP247 = new SEQ_REGEXP();
        SEQ_REGEXP247.text = "\\\\segno\\b";
        SEQ_REGEXP247.TYPE = "KEYWORD3";
        SEQ_REGEXP247.HASH_CHAR = "\\segno";
        SEQ_REGEXP SEQ_REGEXP248 = new SEQ_REGEXP();
        SEQ_REGEXP248.text = "\\\\semiGermanChords\\b";
        SEQ_REGEXP248.TYPE = "KEYWORD3";
        SEQ_REGEXP248.HASH_CHAR = "\\semiGermanChords";
        SEQ_REGEXP SEQ_REGEXP249 = new SEQ_REGEXP();
        SEQ_REGEXP249.text = "\\\\setDefaultDurationToQuarter\\b";
        SEQ_REGEXP249.TYPE = "KEYWORD3";
        SEQ_REGEXP249.HASH_CHAR = "\\setDefaultDurationToQuarter";
        SEQ_REGEXP SEQ_REGEXP250 = new SEQ_REGEXP();
        SEQ_REGEXP250.text = "\\\\sf\\b";
        SEQ_REGEXP250.TYPE = "KEYWORD3";
        SEQ_REGEXP250.HASH_CHAR = "\\sf";
        SEQ_REGEXP SEQ_REGEXP251 = new SEQ_REGEXP();
        SEQ_REGEXP251.text = "\\\\sff\\b";
        SEQ_REGEXP251.TYPE = "KEYWORD3";
        SEQ_REGEXP251.HASH_CHAR = "\\sff";
        SEQ_REGEXP SEQ_REGEXP252 = new SEQ_REGEXP();
        SEQ_REGEXP252.text = "\\\\sfp\\b";
        SEQ_REGEXP252.TYPE = "KEYWORD3";
        SEQ_REGEXP252.HASH_CHAR = "\\sfp";
        SEQ_REGEXP SEQ_REGEXP253 = new SEQ_REGEXP();
        SEQ_REGEXP253.text = "\\\\sfz\\b";
        SEQ_REGEXP253.TYPE = "KEYWORD3";
        SEQ_REGEXP253.HASH_CHAR = "\\sfz";
        SEQ_REGEXP SEQ_REGEXP254 = new SEQ_REGEXP();
        SEQ_REGEXP254.text = "\\\\shiftOff\\b";
        SEQ_REGEXP254.TYPE = "KEYWORD3";
        SEQ_REGEXP254.HASH_CHAR = "\\shiftOff";
        SEQ_REGEXP SEQ_REGEXP255 = new SEQ_REGEXP();
        SEQ_REGEXP255.text = "\\\\shiftOn\\b";
        SEQ_REGEXP255.TYPE = "KEYWORD3";
        SEQ_REGEXP255.HASH_CHAR = "\\shiftOn";
        SEQ_REGEXP SEQ_REGEXP256 = new SEQ_REGEXP();
        SEQ_REGEXP256.text = "\\\\shiftOnn\\b";
        SEQ_REGEXP256.TYPE = "KEYWORD3";
        SEQ_REGEXP256.HASH_CHAR = "\\shiftOnn";
        SEQ_REGEXP SEQ_REGEXP257 = new SEQ_REGEXP();
        SEQ_REGEXP257.text = "\\\\shiftOnnn\\b";
        SEQ_REGEXP257.TYPE = "KEYWORD3";
        SEQ_REGEXP257.HASH_CHAR = "\\shiftOnnn";
        SEQ_REGEXP SEQ_REGEXP258 = new SEQ_REGEXP();
        SEQ_REGEXP258.text = "\\\\shortfermata\\b";
        SEQ_REGEXP258.TYPE = "KEYWORD3";
        SEQ_REGEXP258.HASH_CHAR = "\\shortfermata";
        SEQ_REGEXP SEQ_REGEXP259 = new SEQ_REGEXP();
        SEQ_REGEXP259.text = "\\\\showStaffSwitch\\b";
        SEQ_REGEXP259.TYPE = "KEYWORD3";
        SEQ_REGEXP259.HASH_CHAR = "\\showStaffSwitch";
        SEQ_REGEXP SEQ_REGEXP260 = new SEQ_REGEXP();
        SEQ_REGEXP260.text = "\\\\signumcongruentiae\\b";
        SEQ_REGEXP260.TYPE = "KEYWORD3";
        SEQ_REGEXP260.HASH_CHAR = "\\signumcongruentiae";
        SEQ_REGEXP SEQ_REGEXP261 = new SEQ_REGEXP();
        SEQ_REGEXP261.text = "\\\\slashSeparator\\b";
        SEQ_REGEXP261.TYPE = "KEYWORD3";
        SEQ_REGEXP261.HASH_CHAR = "\\slashSeparator";
        SEQ_REGEXP SEQ_REGEXP262 = new SEQ_REGEXP();
        SEQ_REGEXP262.text = "\\\\slurDashed\\b";
        SEQ_REGEXP262.TYPE = "KEYWORD3";
        SEQ_REGEXP262.HASH_CHAR = "\\slurDashed";
        SEQ_REGEXP SEQ_REGEXP263 = new SEQ_REGEXP();
        SEQ_REGEXP263.text = "\\\\slurDotted\\b";
        SEQ_REGEXP263.TYPE = "KEYWORD3";
        SEQ_REGEXP263.HASH_CHAR = "\\slurDotted";
        SEQ_REGEXP SEQ_REGEXP264 = new SEQ_REGEXP();
        SEQ_REGEXP264.text = "\\\\slurDown\\b";
        SEQ_REGEXP264.TYPE = "KEYWORD3";
        SEQ_REGEXP264.HASH_CHAR = "\\slurDown";
        SEQ_REGEXP SEQ_REGEXP265 = new SEQ_REGEXP();
        SEQ_REGEXP265.text = "\\\\slurNeutral\\b";
        SEQ_REGEXP265.TYPE = "KEYWORD3";
        SEQ_REGEXP265.HASH_CHAR = "\\slurNeutral";
        SEQ_REGEXP SEQ_REGEXP266 = new SEQ_REGEXP();
        SEQ_REGEXP266.text = "\\\\slurSolid\\b";
        SEQ_REGEXP266.TYPE = "KEYWORD3";
        SEQ_REGEXP266.HASH_CHAR = "\\slurSolid";
        SEQ_REGEXP SEQ_REGEXP267 = new SEQ_REGEXP();
        SEQ_REGEXP267.text = "\\\\slurUp\\b";
        SEQ_REGEXP267.TYPE = "KEYWORD3";
        SEQ_REGEXP267.HASH_CHAR = "\\slurUp";
        SEQ_REGEXP SEQ_REGEXP268 = new SEQ_REGEXP();
        SEQ_REGEXP268.text = "\\\\small\\b";
        SEQ_REGEXP268.TYPE = "KEYWORD3";
        SEQ_REGEXP268.HASH_CHAR = "\\small";
        SEQ_REGEXP SEQ_REGEXP269 = new SEQ_REGEXP();
        SEQ_REGEXP269.text = "\\\\smaller\\b";
        SEQ_REGEXP269.TYPE = "KEYWORD3";
        SEQ_REGEXP269.HASH_CHAR = "\\smaller";
        SEQ_REGEXP SEQ_REGEXP270 = new SEQ_REGEXP();
        SEQ_REGEXP270.text = "\\\\sostenutoOff\\b";
        SEQ_REGEXP270.TYPE = "KEYWORD3";
        SEQ_REGEXP270.HASH_CHAR = "\\sostenutoOff";
        SEQ_REGEXP SEQ_REGEXP271 = new SEQ_REGEXP();
        SEQ_REGEXP271.text = "\\\\sostenutoOn\\b";
        SEQ_REGEXP271.TYPE = "KEYWORD3";
        SEQ_REGEXP271.HASH_CHAR = "\\sostenutoOn";
        SEQ_REGEXP SEQ_REGEXP272 = new SEQ_REGEXP();
        SEQ_REGEXP272.text = "\\\\sp\\b";
        SEQ_REGEXP272.TYPE = "KEYWORD3";
        SEQ_REGEXP272.HASH_CHAR = "\\sp";
        SEQ_REGEXP SEQ_REGEXP273 = new SEQ_REGEXP();
        SEQ_REGEXP273.text = "\\\\spp\\b";
        SEQ_REGEXP273.TYPE = "KEYWORD3";
        SEQ_REGEXP273.HASH_CHAR = "\\spp";
        SEQ_REGEXP SEQ_REGEXP274 = new SEQ_REGEXP();
        SEQ_REGEXP274.text = "\\\\staccatissimo\\b";
        SEQ_REGEXP274.TYPE = "KEYWORD3";
        SEQ_REGEXP274.HASH_CHAR = "\\staccatissimo";
        SEQ_REGEXP SEQ_REGEXP275 = new SEQ_REGEXP();
        SEQ_REGEXP275.text = "\\\\staccato\\b";
        SEQ_REGEXP275.TYPE = "KEYWORD3";
        SEQ_REGEXP275.HASH_CHAR = "\\staccato";
        SEQ_REGEXP SEQ_REGEXP276 = new SEQ_REGEXP();
        SEQ_REGEXP276.text = "\\\\start\\b";
        SEQ_REGEXP276.TYPE = "KEYWORD3";
        SEQ_REGEXP276.HASH_CHAR = "\\start";
        SEQ_REGEXP SEQ_REGEXP277 = new SEQ_REGEXP();
        SEQ_REGEXP277.text = "\\\\startAcciaccaturaMusic\\b";
        SEQ_REGEXP277.TYPE = "KEYWORD3";
        SEQ_REGEXP277.HASH_CHAR = "\\startAcciaccaturaMusic";
        SEQ_REGEXP SEQ_REGEXP278 = new SEQ_REGEXP();
        SEQ_REGEXP278.text = "\\\\startAppoggiaturaMusic\\b";
        SEQ_REGEXP278.TYPE = "KEYWORD3";
        SEQ_REGEXP278.HASH_CHAR = "\\startAppoggiaturaMusic";
        SEQ_REGEXP SEQ_REGEXP279 = new SEQ_REGEXP();
        SEQ_REGEXP279.text = "\\\\startGraceMusic\\b";
        SEQ_REGEXP279.TYPE = "KEYWORD3";
        SEQ_REGEXP279.HASH_CHAR = "\\startGraceMusic";
        SEQ_REGEXP SEQ_REGEXP280 = new SEQ_REGEXP();
        SEQ_REGEXP280.text = "\\\\startGroup\\b";
        SEQ_REGEXP280.TYPE = "KEYWORD3";
        SEQ_REGEXP280.HASH_CHAR = "\\startGroup";
        SEQ_REGEXP SEQ_REGEXP281 = new SEQ_REGEXP();
        SEQ_REGEXP281.text = "\\\\startStaff\\b";
        SEQ_REGEXP281.TYPE = "KEYWORD3";
        SEQ_REGEXP281.HASH_CHAR = "\\startStaff";
        SEQ_REGEXP SEQ_REGEXP282 = new SEQ_REGEXP();
        SEQ_REGEXP282.text = "\\\\startTextSpan\\b";
        SEQ_REGEXP282.TYPE = "KEYWORD3";
        SEQ_REGEXP282.HASH_CHAR = "\\startTextSpan";
        SEQ_REGEXP SEQ_REGEXP283 = new SEQ_REGEXP();
        SEQ_REGEXP283.text = "\\\\startTrillSpan\\b";
        SEQ_REGEXP283.TYPE = "KEYWORD3";
        SEQ_REGEXP283.HASH_CHAR = "\\startTrillSpan";
        SEQ_REGEXP SEQ_REGEXP284 = new SEQ_REGEXP();
        SEQ_REGEXP284.text = "\\\\stemDown\\b";
        SEQ_REGEXP284.TYPE = "KEYWORD3";
        SEQ_REGEXP284.HASH_CHAR = "\\stemDown";
        SEQ_REGEXP SEQ_REGEXP285 = new SEQ_REGEXP();
        SEQ_REGEXP285.text = "\\\\stemNeutral\\b";
        SEQ_REGEXP285.TYPE = "KEYWORD3";
        SEQ_REGEXP285.HASH_CHAR = "\\stemNeutral";
        SEQ_REGEXP SEQ_REGEXP286 = new SEQ_REGEXP();
        SEQ_REGEXP286.text = "\\\\stemUp\\b";
        SEQ_REGEXP286.TYPE = "KEYWORD3";
        SEQ_REGEXP286.HASH_CHAR = "\\stemUp";
        SEQ_REGEXP SEQ_REGEXP287 = new SEQ_REGEXP();
        SEQ_REGEXP287.text = "\\\\stop\\b";
        SEQ_REGEXP287.TYPE = "KEYWORD3";
        SEQ_REGEXP287.HASH_CHAR = "\\stop";
        SEQ_REGEXP SEQ_REGEXP288 = new SEQ_REGEXP();
        SEQ_REGEXP288.text = "\\\\stopAcciaccaturaMusic\\b";
        SEQ_REGEXP288.TYPE = "KEYWORD3";
        SEQ_REGEXP288.HASH_CHAR = "\\stopAcciaccaturaMusic";
        SEQ_REGEXP SEQ_REGEXP289 = new SEQ_REGEXP();
        SEQ_REGEXP289.text = "\\\\stopAppoggiaturaMusic\\b";
        SEQ_REGEXP289.TYPE = "KEYWORD3";
        SEQ_REGEXP289.HASH_CHAR = "\\stopAppoggiaturaMusic";
        SEQ_REGEXP SEQ_REGEXP290 = new SEQ_REGEXP();
        SEQ_REGEXP290.text = "\\\\stopGraceMusic\\b";
        SEQ_REGEXP290.TYPE = "KEYWORD3";
        SEQ_REGEXP290.HASH_CHAR = "\\stopGraceMusic";
        SEQ_REGEXP SEQ_REGEXP291 = new SEQ_REGEXP();
        SEQ_REGEXP291.text = "\\\\stopGroup\\b";
        SEQ_REGEXP291.TYPE = "KEYWORD3";
        SEQ_REGEXP291.HASH_CHAR = "\\stopGroup";
        SEQ_REGEXP SEQ_REGEXP292 = new SEQ_REGEXP();
        SEQ_REGEXP292.text = "\\\\stopStaff\\b";
        SEQ_REGEXP292.TYPE = "KEYWORD3";
        SEQ_REGEXP292.HASH_CHAR = "\\stopStaff";
        SEQ_REGEXP SEQ_REGEXP293 = new SEQ_REGEXP();
        SEQ_REGEXP293.text = "\\\\stopTextSpan\\b";
        SEQ_REGEXP293.TYPE = "KEYWORD3";
        SEQ_REGEXP293.HASH_CHAR = "\\stopTextSpan";
        SEQ_REGEXP SEQ_REGEXP294 = new SEQ_REGEXP();
        SEQ_REGEXP294.text = "\\\\stopTrillSpan\\b";
        SEQ_REGEXP294.TYPE = "KEYWORD3";
        SEQ_REGEXP294.HASH_CHAR = "\\stopTrillSpan";
        SEQ_REGEXP SEQ_REGEXP295 = new SEQ_REGEXP();
        SEQ_REGEXP295.text = "\\\\stopped\\b";
        SEQ_REGEXP295.TYPE = "KEYWORD3";
        SEQ_REGEXP295.HASH_CHAR = "\\stopped";
        SEQ_REGEXP SEQ_REGEXP296 = new SEQ_REGEXP();
        SEQ_REGEXP296.text = "\\\\sustainOff\\b";
        SEQ_REGEXP296.TYPE = "KEYWORD3";
        SEQ_REGEXP296.HASH_CHAR = "\\sustainOff";
        SEQ_REGEXP SEQ_REGEXP297 = new SEQ_REGEXP();
        SEQ_REGEXP297.text = "\\\\sustainOn\\b";
        SEQ_REGEXP297.TYPE = "KEYWORD3";
        SEQ_REGEXP297.HASH_CHAR = "\\sustainOn";
        SEQ_REGEXP SEQ_REGEXP298 = new SEQ_REGEXP();
        SEQ_REGEXP298.text = "\\\\tagline\\b";
        SEQ_REGEXP298.TYPE = "KEYWORD3";
        SEQ_REGEXP298.HASH_CHAR = "\\tagline";
        SEQ_REGEXP SEQ_REGEXP299 = new SEQ_REGEXP();
        SEQ_REGEXP299.text = "\\\\teeny\\b";
        SEQ_REGEXP299.TYPE = "KEYWORD3";
        SEQ_REGEXP299.HASH_CHAR = "\\teeny";
        SEQ_REGEXP SEQ_REGEXP300 = new SEQ_REGEXP();
        SEQ_REGEXP300.text = "\\\\tenuto\\b";
        SEQ_REGEXP300.TYPE = "KEYWORD3";
        SEQ_REGEXP300.HASH_CHAR = "\\tenuto";
        SEQ_REGEXP SEQ_REGEXP301 = new SEQ_REGEXP();
        SEQ_REGEXP301.text = "\\\\textLengthOff\\b";
        SEQ_REGEXP301.TYPE = "KEYWORD3";
        SEQ_REGEXP301.HASH_CHAR = "\\textLengthOff";
        SEQ_REGEXP SEQ_REGEXP302 = new SEQ_REGEXP();
        SEQ_REGEXP302.text = "\\\\textLengthOn\\b";
        SEQ_REGEXP302.TYPE = "KEYWORD3";
        SEQ_REGEXP302.HASH_CHAR = "\\textLengthOn";
        SEQ_REGEXP SEQ_REGEXP303 = new SEQ_REGEXP();
        SEQ_REGEXP303.text = "\\\\textSpannerDown\\b";
        SEQ_REGEXP303.TYPE = "KEYWORD3";
        SEQ_REGEXP303.HASH_CHAR = "\\textSpannerDown";
        SEQ_REGEXP SEQ_REGEXP304 = new SEQ_REGEXP();
        SEQ_REGEXP304.text = "\\\\textSpannerNeutral\\b";
        SEQ_REGEXP304.TYPE = "KEYWORD3";
        SEQ_REGEXP304.HASH_CHAR = "\\textSpannerNeutral";
        SEQ_REGEXP SEQ_REGEXP305 = new SEQ_REGEXP();
        SEQ_REGEXP305.text = "\\\\textSpannerUp\\b";
        SEQ_REGEXP305.TYPE = "KEYWORD3";
        SEQ_REGEXP305.HASH_CHAR = "\\textSpannerUp";
        SEQ_REGEXP SEQ_REGEXP306 = new SEQ_REGEXP();
        SEQ_REGEXP306.text = "\\\\thumb\\b";
        SEQ_REGEXP306.TYPE = "KEYWORD3";
        SEQ_REGEXP306.HASH_CHAR = "\\thumb";
        SEQ_REGEXP SEQ_REGEXP307 = new SEQ_REGEXP();
        SEQ_REGEXP307.text = "\\\\tieDashed\\b";
        SEQ_REGEXP307.TYPE = "KEYWORD3";
        SEQ_REGEXP307.HASH_CHAR = "\\tieDashed";
        SEQ_REGEXP SEQ_REGEXP308 = new SEQ_REGEXP();
        SEQ_REGEXP308.text = "\\\\tieDotted\\b";
        SEQ_REGEXP308.TYPE = "KEYWORD3";
        SEQ_REGEXP308.HASH_CHAR = "\\tieDotted";
        SEQ_REGEXP SEQ_REGEXP309 = new SEQ_REGEXP();
        SEQ_REGEXP309.text = "\\\\tieDown\\b";
        SEQ_REGEXP309.TYPE = "KEYWORD3";
        SEQ_REGEXP309.HASH_CHAR = "\\tieDown";
        SEQ_REGEXP SEQ_REGEXP310 = new SEQ_REGEXP();
        SEQ_REGEXP310.text = "\\\\tieNeutral\\b";
        SEQ_REGEXP310.TYPE = "KEYWORD3";
        SEQ_REGEXP310.HASH_CHAR = "\\tieNeutral";
        SEQ_REGEXP SEQ_REGEXP311 = new SEQ_REGEXP();
        SEQ_REGEXP311.text = "\\\\tieSolid\\b";
        SEQ_REGEXP311.TYPE = "KEYWORD3";
        SEQ_REGEXP311.HASH_CHAR = "\\tieSolid";
        SEQ_REGEXP SEQ_REGEXP312 = new SEQ_REGEXP();
        SEQ_REGEXP312.text = "\\\\tieUp\\b";
        SEQ_REGEXP312.TYPE = "KEYWORD3";
        SEQ_REGEXP312.HASH_CHAR = "\\tieUp";
        SEQ_REGEXP SEQ_REGEXP313 = new SEQ_REGEXP();
        SEQ_REGEXP313.text = "\\\\tildeSymbol\\b";
        SEQ_REGEXP313.TYPE = "KEYWORD3";
        SEQ_REGEXP313.HASH_CHAR = "\\tildeSymbol";
        SEQ_REGEXP SEQ_REGEXP314 = new SEQ_REGEXP();
        SEQ_REGEXP314.text = "\\\\tiny\\b";
        SEQ_REGEXP314.TYPE = "KEYWORD3";
        SEQ_REGEXP314.HASH_CHAR = "\\tiny";
        SEQ_REGEXP SEQ_REGEXP315 = new SEQ_REGEXP();
        SEQ_REGEXP315.text = "\\\\tocItemMarkup\\b";
        SEQ_REGEXP315.TYPE = "KEYWORD3";
        SEQ_REGEXP315.HASH_CHAR = "\\tocItemMarkup";
        SEQ_REGEXP SEQ_REGEXP316 = new SEQ_REGEXP();
        SEQ_REGEXP316.text = "\\\\tocTitleMarkup\\b";
        SEQ_REGEXP316.TYPE = "KEYWORD3";
        SEQ_REGEXP316.HASH_CHAR = "\\tocTitleMarkup";
        SEQ_REGEXP SEQ_REGEXP317 = new SEQ_REGEXP();
        SEQ_REGEXP317.text = "\\\\treCorde\\b";
        SEQ_REGEXP317.TYPE = "KEYWORD3";
        SEQ_REGEXP317.HASH_CHAR = "\\treCorde";
        SEQ_REGEXP SEQ_REGEXP318 = new SEQ_REGEXP();
        SEQ_REGEXP318.text = "\\\\trill\\b";
        SEQ_REGEXP318.TYPE = "KEYWORD3";
        SEQ_REGEXP318.HASH_CHAR = "\\trill";
        SEQ_REGEXP SEQ_REGEXP319 = new SEQ_REGEXP();
        SEQ_REGEXP319.text = "\\\\tupletDown\\b";
        SEQ_REGEXP319.TYPE = "KEYWORD3";
        SEQ_REGEXP319.HASH_CHAR = "\\tupletDown";
        SEQ_REGEXP SEQ_REGEXP320 = new SEQ_REGEXP();
        SEQ_REGEXP320.text = "\\\\tupletNeutral\\b";
        SEQ_REGEXP320.TYPE = "KEYWORD3";
        SEQ_REGEXP320.HASH_CHAR = "\\tupletNeutral";
        SEQ_REGEXP SEQ_REGEXP321 = new SEQ_REGEXP();
        SEQ_REGEXP321.text = "\\\\tupletUp\\b";
        SEQ_REGEXP321.TYPE = "KEYWORD3";
        SEQ_REGEXP321.HASH_CHAR = "\\tupletUp";
        SEQ_REGEXP SEQ_REGEXP322 = new SEQ_REGEXP();
        SEQ_REGEXP322.text = "\\\\turn\\b";
        SEQ_REGEXP322.TYPE = "KEYWORD3";
        SEQ_REGEXP322.HASH_CHAR = "\\turn";
        SEQ_REGEXP SEQ_REGEXP323 = new SEQ_REGEXP();
        SEQ_REGEXP323.text = "\\\\unHideNotes\\b";
        SEQ_REGEXP323.TYPE = "KEYWORD3";
        SEQ_REGEXP323.HASH_CHAR = "\\unHideNotes";
        SEQ_REGEXP SEQ_REGEXP324 = new SEQ_REGEXP();
        SEQ_REGEXP324.text = "\\\\unaCorda\\b";
        SEQ_REGEXP324.TYPE = "KEYWORD3";
        SEQ_REGEXP324.HASH_CHAR = "\\unaCorda";
        SEQ_REGEXP SEQ_REGEXP325 = new SEQ_REGEXP();
        SEQ_REGEXP325.text = "\\\\unit\\b";
        SEQ_REGEXP325.TYPE = "KEYWORD3";
        SEQ_REGEXP325.HASH_CHAR = "\\unit";
        SEQ_REGEXP SEQ_REGEXP326 = new SEQ_REGEXP();
        SEQ_REGEXP326.text = "\\\\up\\b";
        SEQ_REGEXP326.TYPE = "KEYWORD3";
        SEQ_REGEXP326.HASH_CHAR = "\\up";
        SEQ_REGEXP SEQ_REGEXP327 = new SEQ_REGEXP();
        SEQ_REGEXP327.text = "\\\\upbow\\b";
        SEQ_REGEXP327.TYPE = "KEYWORD3";
        SEQ_REGEXP327.HASH_CHAR = "\\upbow";
        SEQ_REGEXP SEQ_REGEXP328 = new SEQ_REGEXP();
        SEQ_REGEXP328.text = "\\\\upmordent\\b";
        SEQ_REGEXP328.TYPE = "KEYWORD3";
        SEQ_REGEXP328.HASH_CHAR = "\\upmordent";
        SEQ_REGEXP SEQ_REGEXP329 = new SEQ_REGEXP();
        SEQ_REGEXP329.text = "\\\\upprall\\b";
        SEQ_REGEXP329.TYPE = "KEYWORD3";
        SEQ_REGEXP329.HASH_CHAR = "\\upprall";
        SEQ_REGEXP SEQ_REGEXP330 = new SEQ_REGEXP();
        SEQ_REGEXP330.text = "\\\\varcoda\\b";
        SEQ_REGEXP330.TYPE = "KEYWORD3";
        SEQ_REGEXP330.HASH_CHAR = "\\varcoda";
        SEQ_REGEXP SEQ_REGEXP331 = new SEQ_REGEXP();
        SEQ_REGEXP331.text = "\\\\verylongfermata\\b";
        SEQ_REGEXP331.TYPE = "KEYWORD3";
        SEQ_REGEXP331.HASH_CHAR = "\\verylongfermata";
        SEQ_REGEXP SEQ_REGEXP332 = new SEQ_REGEXP();
        SEQ_REGEXP332.text = "\\\\voiceFour\\b";
        SEQ_REGEXP332.TYPE = "KEYWORD3";
        SEQ_REGEXP332.HASH_CHAR = "\\voiceFour";
        SEQ_REGEXP SEQ_REGEXP333 = new SEQ_REGEXP();
        SEQ_REGEXP333.text = "\\\\voiceFourStyle\\b";
        SEQ_REGEXP333.TYPE = "KEYWORD3";
        SEQ_REGEXP333.HASH_CHAR = "\\voiceFourStyle";
        SEQ_REGEXP SEQ_REGEXP334 = new SEQ_REGEXP();
        SEQ_REGEXP334.text = "\\\\voiceNeutralStyle\\b";
        SEQ_REGEXP334.TYPE = "KEYWORD3";
        SEQ_REGEXP334.HASH_CHAR = "\\voiceNeutralStyle";
        SEQ_REGEXP SEQ_REGEXP335 = new SEQ_REGEXP();
        SEQ_REGEXP335.text = "\\\\voiceOne\\b";
        SEQ_REGEXP335.TYPE = "KEYWORD3";
        SEQ_REGEXP335.HASH_CHAR = "\\voiceOne";
        SEQ_REGEXP SEQ_REGEXP336 = new SEQ_REGEXP();
        SEQ_REGEXP336.text = "\\\\voiceOneStyle\\b";
        SEQ_REGEXP336.TYPE = "KEYWORD3";
        SEQ_REGEXP336.HASH_CHAR = "\\voiceOneStyle";
        SEQ_REGEXP SEQ_REGEXP337 = new SEQ_REGEXP();
        SEQ_REGEXP337.text = "\\\\voiceThree\\b";
        SEQ_REGEXP337.TYPE = "KEYWORD3";
        SEQ_REGEXP337.HASH_CHAR = "\\voiceThree";
        SEQ_REGEXP SEQ_REGEXP338 = new SEQ_REGEXP();
        SEQ_REGEXP338.text = "\\\\voiceThreeStyle\\b";
        SEQ_REGEXP338.TYPE = "KEYWORD3";
        SEQ_REGEXP338.HASH_CHAR = "\\voiceThreeStyle";
        SEQ_REGEXP SEQ_REGEXP339 = new SEQ_REGEXP();
        SEQ_REGEXP339.text = "\\\\voiceTwo\\b";
        SEQ_REGEXP339.TYPE = "KEYWORD3";
        SEQ_REGEXP339.HASH_CHAR = "\\voiceTwo";
        SEQ_REGEXP SEQ_REGEXP340 = new SEQ_REGEXP();
        SEQ_REGEXP340.text = "\\\\voiceTwoStyle\\b";
        SEQ_REGEXP340.TYPE = "KEYWORD3";
        SEQ_REGEXP340.HASH_CHAR = "\\voiceTwoStyle";
        SEQ_REGEXP SEQ_REGEXP341 = new SEQ_REGEXP();
        SEQ_REGEXP341.text = "\\\\whiteTriangleMarkup\\b";
        SEQ_REGEXP341.TYPE = "KEYWORD3";
        SEQ_REGEXP341.HASH_CHAR = "\\whiteTriangleMarkup";
        SEQ_REGEXP SEQ_REGEXP342 = new SEQ_REGEXP();
        SEQ_REGEXP342.text = "\\\\acciaccatura\\b";
        SEQ_REGEXP342.TYPE = "KEYWORD3";
        SEQ_REGEXP342.HASH_CHAR = "\\acciaccatura";
        SEQ_REGEXP SEQ_REGEXP343 = new SEQ_REGEXP();
        SEQ_REGEXP343.text = "\\\\addChordShape\\b";
        SEQ_REGEXP343.TYPE = "KEYWORD3";
        SEQ_REGEXP343.HASH_CHAR = "\\addChordShape";
        SEQ_REGEXP SEQ_REGEXP344 = new SEQ_REGEXP();
        SEQ_REGEXP344.text = "\\\\addInstrumentDefinition\\b";
        SEQ_REGEXP344.TYPE = "KEYWORD3";
        SEQ_REGEXP344.HASH_CHAR = "\\addInstrumentDefinition";
        SEQ_REGEXP SEQ_REGEXP345 = new SEQ_REGEXP();
        SEQ_REGEXP345.text = "\\\\addQuote\\b";
        SEQ_REGEXP345.TYPE = "KEYWORD3";
        SEQ_REGEXP345.HASH_CHAR = "\\addQuote";
        SEQ_REGEXP SEQ_REGEXP346 = new SEQ_REGEXP();
        SEQ_REGEXP346.text = "\\\\afterGrace\\b";
        SEQ_REGEXP346.TYPE = "KEYWORD3";
        SEQ_REGEXP346.HASH_CHAR = "\\afterGrace";
        SEQ_REGEXP SEQ_REGEXP347 = new SEQ_REGEXP();
        SEQ_REGEXP347.text = "\\\\allowPageTurn\\b";
        SEQ_REGEXP347.TYPE = "KEYWORD3";
        SEQ_REGEXP347.HASH_CHAR = "\\allowPageTurn";
        SEQ_REGEXP SEQ_REGEXP348 = new SEQ_REGEXP();
        SEQ_REGEXP348.text = "\\\\applyContext\\b";
        SEQ_REGEXP348.TYPE = "KEYWORD3";
        SEQ_REGEXP348.HASH_CHAR = "\\applyContext";
        SEQ_REGEXP SEQ_REGEXP349 = new SEQ_REGEXP();
        SEQ_REGEXP349.text = "\\\\applyMusic\\b";
        SEQ_REGEXP349.TYPE = "KEYWORD3";
        SEQ_REGEXP349.HASH_CHAR = "\\applyMusic";
        SEQ_REGEXP SEQ_REGEXP350 = new SEQ_REGEXP();
        SEQ_REGEXP350.text = "\\\\applyOutput\\b";
        SEQ_REGEXP350.TYPE = "KEYWORD3";
        SEQ_REGEXP350.HASH_CHAR = "\\applyOutput";
        SEQ_REGEXP SEQ_REGEXP351 = new SEQ_REGEXP();
        SEQ_REGEXP351.text = "\\\\appoggiatura\\b";
        SEQ_REGEXP351.TYPE = "KEYWORD3";
        SEQ_REGEXP351.HASH_CHAR = "\\appoggiatura";
        SEQ_REGEXP SEQ_REGEXP352 = new SEQ_REGEXP();
        SEQ_REGEXP352.text = "\\\\assertBeamQuant\\b";
        SEQ_REGEXP352.TYPE = "KEYWORD3";
        SEQ_REGEXP352.HASH_CHAR = "\\assertBeamQuant";
        SEQ_REGEXP SEQ_REGEXP353 = new SEQ_REGEXP();
        SEQ_REGEXP353.text = "\\\\assertBeamSlope\\b";
        SEQ_REGEXP353.TYPE = "KEYWORD3";
        SEQ_REGEXP353.HASH_CHAR = "\\assertBeamSlope";
        SEQ_REGEXP SEQ_REGEXP354 = new SEQ_REGEXP();
        SEQ_REGEXP354.text = "\\\\autochange\\b";
        SEQ_REGEXP354.TYPE = "KEYWORD3";
        SEQ_REGEXP354.HASH_CHAR = "\\autochange";
        SEQ_REGEXP SEQ_REGEXP355 = new SEQ_REGEXP();
        SEQ_REGEXP355.text = "\\\\balloonGrobText\\b";
        SEQ_REGEXP355.TYPE = "KEYWORD3";
        SEQ_REGEXP355.HASH_CHAR = "\\balloonGrobText";
        SEQ_REGEXP SEQ_REGEXP356 = new SEQ_REGEXP();
        SEQ_REGEXP356.text = "\\\\balloonText\\b";
        SEQ_REGEXP356.TYPE = "KEYWORD3";
        SEQ_REGEXP356.HASH_CHAR = "\\balloonText";
        SEQ_REGEXP SEQ_REGEXP357 = new SEQ_REGEXP();
        SEQ_REGEXP357.text = "\\\\bar\\b";
        SEQ_REGEXP357.TYPE = "KEYWORD3";
        SEQ_REGEXP357.HASH_CHAR = "\\bar";
        SEQ_REGEXP SEQ_REGEXP358 = new SEQ_REGEXP();
        SEQ_REGEXP358.text = "\\\\barNumberCheck\\b";
        SEQ_REGEXP358.TYPE = "KEYWORD3";
        SEQ_REGEXP358.HASH_CHAR = "\\barNumberCheck";
        SEQ_REGEXP SEQ_REGEXP359 = new SEQ_REGEXP();
        SEQ_REGEXP359.text = "\\\\bendAfter\\b";
        SEQ_REGEXP359.TYPE = "KEYWORD3";
        SEQ_REGEXP359.HASH_CHAR = "\\bendAfter";
        SEQ_REGEXP SEQ_REGEXP360 = new SEQ_REGEXP();
        SEQ_REGEXP360.text = "\\\\breathe\\b";
        SEQ_REGEXP360.TYPE = "KEYWORD3";
        SEQ_REGEXP360.HASH_CHAR = "\\breathe";
        SEQ_REGEXP SEQ_REGEXP361 = new SEQ_REGEXP();
        SEQ_REGEXP361.text = "\\\\clef\\b";
        SEQ_REGEXP361.TYPE = "KEYWORD3";
        SEQ_REGEXP361.HASH_CHAR = "\\clef";
        SEQ_REGEXP SEQ_REGEXP362 = new SEQ_REGEXP();
        SEQ_REGEXP362.text = "\\\\cueDuring\\b";
        SEQ_REGEXP362.TYPE = "KEYWORD3";
        SEQ_REGEXP362.HASH_CHAR = "\\cueDuring";
        SEQ_REGEXP SEQ_REGEXP363 = new SEQ_REGEXP();
        SEQ_REGEXP363.text = "\\\\displayLilyMusic\\b";
        SEQ_REGEXP363.TYPE = "KEYWORD3";
        SEQ_REGEXP363.HASH_CHAR = "\\displayLilyMusic";
        SEQ_REGEXP SEQ_REGEXP364 = new SEQ_REGEXP();
        SEQ_REGEXP364.text = "\\\\displayMusic\\b";
        SEQ_REGEXP364.TYPE = "KEYWORD3";
        SEQ_REGEXP364.HASH_CHAR = "\\displayMusic";
        SEQ_REGEXP SEQ_REGEXP365 = new SEQ_REGEXP();
        SEQ_REGEXP365.text = "\\\\endSpanners\\b";
        SEQ_REGEXP365.TYPE = "KEYWORD3";
        SEQ_REGEXP365.HASH_CHAR = "\\endSpanners";
        SEQ_REGEXP SEQ_REGEXP366 = new SEQ_REGEXP();
        SEQ_REGEXP366.text = "\\\\featherDurations\\b";
        SEQ_REGEXP366.TYPE = "KEYWORD3";
        SEQ_REGEXP366.HASH_CHAR = "\\featherDurations";
        SEQ_REGEXP SEQ_REGEXP367 = new SEQ_REGEXP();
        SEQ_REGEXP367.text = "\\\\grace\\b";
        SEQ_REGEXP367.TYPE = "KEYWORD3";
        SEQ_REGEXP367.HASH_CHAR = "\\grace";
        SEQ_REGEXP SEQ_REGEXP368 = new SEQ_REGEXP();
        SEQ_REGEXP368.text = "\\\\includePageLayoutFile\\b";
        SEQ_REGEXP368.TYPE = "KEYWORD3";
        SEQ_REGEXP368.HASH_CHAR = "\\includePageLayoutFile";
        SEQ_REGEXP SEQ_REGEXP369 = new SEQ_REGEXP();
        SEQ_REGEXP369.text = "\\\\instrumentSwitch\\b";
        SEQ_REGEXP369.TYPE = "KEYWORD3";
        SEQ_REGEXP369.HASH_CHAR = "\\instrumentSwitch";
        SEQ_REGEXP SEQ_REGEXP370 = new SEQ_REGEXP();
        SEQ_REGEXP370.text = "\\\\keepWithTag\\b";
        SEQ_REGEXP370.TYPE = "KEYWORD3";
        SEQ_REGEXP370.HASH_CHAR = "\\keepWithTag";
        SEQ_REGEXP SEQ_REGEXP371 = new SEQ_REGEXP();
        SEQ_REGEXP371.text = "\\\\killCues\\b";
        SEQ_REGEXP371.TYPE = "KEYWORD3";
        SEQ_REGEXP371.HASH_CHAR = "\\killCues";
        SEQ_REGEXP SEQ_REGEXP372 = new SEQ_REGEXP();
        SEQ_REGEXP372.text = "\\\\label\\b";
        SEQ_REGEXP372.TYPE = "KEYWORD3";
        SEQ_REGEXP372.HASH_CHAR = "\\label";
        SEQ_REGEXP SEQ_REGEXP373 = new SEQ_REGEXP();
        SEQ_REGEXP373.text = "\\\\makeClusters\\b";
        SEQ_REGEXP373.TYPE = "KEYWORD3";
        SEQ_REGEXP373.HASH_CHAR = "\\makeClusters";
        SEQ_REGEXP SEQ_REGEXP374 = new SEQ_REGEXP();
        SEQ_REGEXP374.text = "\\\\musicMap\\b";
        SEQ_REGEXP374.TYPE = "KEYWORD3";
        SEQ_REGEXP374.HASH_CHAR = "\\musicMap";
        SEQ_REGEXP SEQ_REGEXP375 = new SEQ_REGEXP();
        SEQ_REGEXP375.text = "\\\\noPageBreak\\b";
        SEQ_REGEXP375.TYPE = "KEYWORD3";
        SEQ_REGEXP375.HASH_CHAR = "\\noPageBreak";
        SEQ_REGEXP SEQ_REGEXP376 = new SEQ_REGEXP();
        SEQ_REGEXP376.text = "\\\\noPageTurn\\b";
        SEQ_REGEXP376.TYPE = "KEYWORD3";
        SEQ_REGEXP376.HASH_CHAR = "\\noPageTurn";
        SEQ_REGEXP SEQ_REGEXP377 = new SEQ_REGEXP();
        SEQ_REGEXP377.text = "\\\\octaveCheck\\b";
        SEQ_REGEXP377.TYPE = "KEYWORD3";
        SEQ_REGEXP377.HASH_CHAR = "\\octaveCheck";
        SEQ_REGEXP SEQ_REGEXP378 = new SEQ_REGEXP();
        SEQ_REGEXP378.text = "\\\\oldaddlyrics\\b";
        SEQ_REGEXP378.TYPE = "KEYWORD3";
        SEQ_REGEXP378.HASH_CHAR = "\\oldaddlyrics";
        SEQ_REGEXP SEQ_REGEXP379 = new SEQ_REGEXP();
        SEQ_REGEXP379.text = "\\\\ottava\\b";
        SEQ_REGEXP379.TYPE = "KEYWORD3";
        SEQ_REGEXP379.HASH_CHAR = "\\ottava";
        SEQ_REGEXP SEQ_REGEXP380 = new SEQ_REGEXP();
        SEQ_REGEXP380.text = "\\\\overrideProperty\\b";
        SEQ_REGEXP380.TYPE = "KEYWORD3";
        SEQ_REGEXP380.HASH_CHAR = "\\overrideProperty";
        SEQ_REGEXP SEQ_REGEXP381 = new SEQ_REGEXP();
        SEQ_REGEXP381.text = "\\\\pageBreak\\b";
        SEQ_REGEXP381.TYPE = "KEYWORD3";
        SEQ_REGEXP381.HASH_CHAR = "\\pageBreak";
        SEQ_REGEXP SEQ_REGEXP382 = new SEQ_REGEXP();
        SEQ_REGEXP382.text = "\\\\pageTurn\\b";
        SEQ_REGEXP382.TYPE = "KEYWORD3";
        SEQ_REGEXP382.HASH_CHAR = "\\pageTurn";
        SEQ_REGEXP SEQ_REGEXP383 = new SEQ_REGEXP();
        SEQ_REGEXP383.text = "\\\\parallelMusic\\b";
        SEQ_REGEXP383.TYPE = "KEYWORD3";
        SEQ_REGEXP383.HASH_CHAR = "\\parallelMusic";
        SEQ_REGEXP SEQ_REGEXP384 = new SEQ_REGEXP();
        SEQ_REGEXP384.text = "\\\\parenthesize\\b";
        SEQ_REGEXP384.TYPE = "KEYWORD3";
        SEQ_REGEXP384.HASH_CHAR = "\\parenthesize";
        SEQ_REGEXP SEQ_REGEXP385 = new SEQ_REGEXP();
        SEQ_REGEXP385.text = "\\\\partcombine\\b";
        SEQ_REGEXP385.TYPE = "KEYWORD3";
        SEQ_REGEXP385.HASH_CHAR = "\\partcombine";
        SEQ_REGEXP SEQ_REGEXP386 = new SEQ_REGEXP();
        SEQ_REGEXP386.text = "\\\\pitchedTrill\\b";
        SEQ_REGEXP386.TYPE = "KEYWORD3";
        SEQ_REGEXP386.HASH_CHAR = "\\pitchedTrill";
        SEQ_REGEXP SEQ_REGEXP387 = new SEQ_REGEXP();
        SEQ_REGEXP387.text = "\\\\pointAndClickOff\\b";
        SEQ_REGEXP387.TYPE = "KEYWORD3";
        SEQ_REGEXP387.HASH_CHAR = "\\pointAndClickOff";
        SEQ_REGEXP SEQ_REGEXP388 = new SEQ_REGEXP();
        SEQ_REGEXP388.text = "\\\\pointAndClickOn\\b";
        SEQ_REGEXP388.TYPE = "KEYWORD3";
        SEQ_REGEXP388.HASH_CHAR = "\\pointAndClickOn";
        SEQ_REGEXP SEQ_REGEXP389 = new SEQ_REGEXP();
        SEQ_REGEXP389.text = "\\\\quoteDuring\\b";
        SEQ_REGEXP389.TYPE = "KEYWORD3";
        SEQ_REGEXP389.HASH_CHAR = "\\quoteDuring";
        SEQ_REGEXP SEQ_REGEXP390 = new SEQ_REGEXP();
        SEQ_REGEXP390.text = "\\\\removeWithTag\\b";
        SEQ_REGEXP390.TYPE = "KEYWORD3";
        SEQ_REGEXP390.HASH_CHAR = "\\removeWithTag";
        SEQ_REGEXP SEQ_REGEXP391 = new SEQ_REGEXP();
        SEQ_REGEXP391.text = "\\\\resetRelativeOctave\\b";
        SEQ_REGEXP391.TYPE = "KEYWORD3";
        SEQ_REGEXP391.HASH_CHAR = "\\resetRelativeOctave";
        SEQ_REGEXP SEQ_REGEXP392 = new SEQ_REGEXP();
        SEQ_REGEXP392.text = "\\\\rightHandFinger\\b";
        SEQ_REGEXP392.TYPE = "KEYWORD3";
        SEQ_REGEXP392.HASH_CHAR = "\\rightHandFinger";
        SEQ_REGEXP SEQ_REGEXP393 = new SEQ_REGEXP();
        SEQ_REGEXP393.text = "\\\\scaleDurations\\b";
        SEQ_REGEXP393.TYPE = "KEYWORD3";
        SEQ_REGEXP393.HASH_CHAR = "\\scaleDurations";
        SEQ_REGEXP SEQ_REGEXP394 = new SEQ_REGEXP();
        SEQ_REGEXP394.text = "\\\\scoreTweak\\b";
        SEQ_REGEXP394.TYPE = "KEYWORD3";
        SEQ_REGEXP394.HASH_CHAR = "\\scoreTweak";
        SEQ_REGEXP SEQ_REGEXP395 = new SEQ_REGEXP();
        SEQ_REGEXP395.text = "\\\\shiftDurations\\b";
        SEQ_REGEXP395.TYPE = "KEYWORD3";
        SEQ_REGEXP395.HASH_CHAR = "\\shiftDurations";
        SEQ_REGEXP SEQ_REGEXP396 = new SEQ_REGEXP();
        SEQ_REGEXP396.text = "\\\\spacingTweaks\\b";
        SEQ_REGEXP396.TYPE = "KEYWORD3";
        SEQ_REGEXP396.HASH_CHAR = "\\spacingTweaks";
        SEQ_REGEXP SEQ_REGEXP397 = new SEQ_REGEXP();
        SEQ_REGEXP397.text = "\\\\storePredefinedDiagram\\b";
        SEQ_REGEXP397.TYPE = "KEYWORD3";
        SEQ_REGEXP397.HASH_CHAR = "\\storePredefinedDiagram";
        SEQ_REGEXP SEQ_REGEXP398 = new SEQ_REGEXP();
        SEQ_REGEXP398.text = "\\\\tag\\b";
        SEQ_REGEXP398.TYPE = "KEYWORD3";
        SEQ_REGEXP398.HASH_CHAR = "\\tag";
        SEQ_REGEXP SEQ_REGEXP399 = new SEQ_REGEXP();
        SEQ_REGEXP399.text = "\\\\tocItem\\b";
        SEQ_REGEXP399.TYPE = "KEYWORD3";
        SEQ_REGEXP399.HASH_CHAR = "\\tocItem";
        SEQ_REGEXP SEQ_REGEXP400 = new SEQ_REGEXP();
        SEQ_REGEXP400.text = "\\\\transposedCueDuring\\b";
        SEQ_REGEXP400.TYPE = "KEYWORD3";
        SEQ_REGEXP400.HASH_CHAR = "\\transposedCueDuring";
        SEQ_REGEXP SEQ_REGEXP401 = new SEQ_REGEXP();
        SEQ_REGEXP401.text = "\\\\transposition\\b";
        SEQ_REGEXP401.TYPE = "KEYWORD3";
        SEQ_REGEXP401.HASH_CHAR = "\\transposition";
        SEQ_REGEXP SEQ_REGEXP402 = new SEQ_REGEXP();
        SEQ_REGEXP402.text = "\\\\tweak\\b";
        SEQ_REGEXP402.TYPE = "KEYWORD3";
        SEQ_REGEXP402.HASH_CHAR = "\\tweak";
        SEQ_REGEXP SEQ_REGEXP403 = new SEQ_REGEXP();
        SEQ_REGEXP403.text = "\\\\unfoldRepeats\\b";
        SEQ_REGEXP403.TYPE = "KEYWORD3";
        SEQ_REGEXP403.HASH_CHAR = "\\unfoldRepeats";
        SEQ_REGEXP SEQ_REGEXP404 = new SEQ_REGEXP();
        SEQ_REGEXP404.text = "\\\\withMusicProperty\\b";
        SEQ_REGEXP404.TYPE = "KEYWORD3";
        SEQ_REGEXP404.HASH_CHAR = "\\withMusicProperty";
        SEQ_REGEXP SEQ_REGEXP405 = new SEQ_REGEXP();
        SEQ_REGEXP405.text = "\\\\abs-fontsize\\b";
        SEQ_REGEXP405.TYPE = "KEYWORD4";
        SEQ_REGEXP405.HASH_CHAR = "\\abs-fontsize";
        SEQ_REGEXP SEQ_REGEXP406 = new SEQ_REGEXP();
        SEQ_REGEXP406.text = "\\\\arrow-head\\b";
        SEQ_REGEXP406.TYPE = "KEYWORD4";
        SEQ_REGEXP406.HASH_CHAR = "\\arrow-head";
        SEQ_REGEXP SEQ_REGEXP407 = new SEQ_REGEXP();
        SEQ_REGEXP407.text = "\\\\backslashed-digit\\b";
        SEQ_REGEXP407.TYPE = "KEYWORD4";
        SEQ_REGEXP407.HASH_CHAR = "\\backslashed-digit";
        SEQ_REGEXP SEQ_REGEXP408 = new SEQ_REGEXP();
        SEQ_REGEXP408.text = "\\\\beam\\b";
        SEQ_REGEXP408.TYPE = "KEYWORD4";
        SEQ_REGEXP408.HASH_CHAR = "\\beam";
        SEQ_REGEXP SEQ_REGEXP409 = new SEQ_REGEXP();
        SEQ_REGEXP409.text = "\\\\bold\\b";
        SEQ_REGEXP409.TYPE = "KEYWORD4";
        SEQ_REGEXP409.HASH_CHAR = "\\bold";
        SEQ_REGEXP SEQ_REGEXP410 = new SEQ_REGEXP();
        SEQ_REGEXP410.text = "\\\\box\\b";
        SEQ_REGEXP410.TYPE = "KEYWORD4";
        SEQ_REGEXP410.HASH_CHAR = "\\box";
        SEQ_REGEXP SEQ_REGEXP411 = new SEQ_REGEXP();
        SEQ_REGEXP411.text = "\\\\bracket\\b";
        SEQ_REGEXP411.TYPE = "KEYWORD4";
        SEQ_REGEXP411.HASH_CHAR = "\\bracket";
        SEQ_REGEXP SEQ_REGEXP412 = new SEQ_REGEXP();
        SEQ_REGEXP412.text = "\\\\caps\\b";
        SEQ_REGEXP412.TYPE = "KEYWORD4";
        SEQ_REGEXP412.HASH_CHAR = "\\caps";
        SEQ_REGEXP SEQ_REGEXP413 = new SEQ_REGEXP();
        SEQ_REGEXP413.text = "\\\\center-align\\b";
        SEQ_REGEXP413.TYPE = "KEYWORD4";
        SEQ_REGEXP413.HASH_CHAR = "\\center-align";
        SEQ_REGEXP SEQ_REGEXP414 = new SEQ_REGEXP();
        SEQ_REGEXP414.text = "\\\\center-column\\b";
        SEQ_REGEXP414.TYPE = "KEYWORD4";
        SEQ_REGEXP414.HASH_CHAR = "\\center-column";
        SEQ_REGEXP SEQ_REGEXP415 = new SEQ_REGEXP();
        SEQ_REGEXP415.text = "\\\\char\\b";
        SEQ_REGEXP415.TYPE = "KEYWORD4";
        SEQ_REGEXP415.HASH_CHAR = "\\char";
        SEQ_REGEXP SEQ_REGEXP416 = new SEQ_REGEXP();
        SEQ_REGEXP416.text = "\\\\circle\\b";
        SEQ_REGEXP416.TYPE = "KEYWORD4";
        SEQ_REGEXP416.HASH_CHAR = "\\circle";
        SEQ_REGEXP SEQ_REGEXP417 = new SEQ_REGEXP();
        SEQ_REGEXP417.text = "\\\\column\\b";
        SEQ_REGEXP417.TYPE = "KEYWORD4";
        SEQ_REGEXP417.HASH_CHAR = "\\column";
        SEQ_REGEXP SEQ_REGEXP418 = new SEQ_REGEXP();
        SEQ_REGEXP418.text = "\\\\combine\\b";
        SEQ_REGEXP418.TYPE = "KEYWORD4";
        SEQ_REGEXP418.HASH_CHAR = "\\combine";
        SEQ_REGEXP SEQ_REGEXP419 = new SEQ_REGEXP();
        SEQ_REGEXP419.text = "\\\\concat\\b";
        SEQ_REGEXP419.TYPE = "KEYWORD4";
        SEQ_REGEXP419.HASH_CHAR = "\\concat";
        SEQ_REGEXP SEQ_REGEXP420 = new SEQ_REGEXP();
        SEQ_REGEXP420.text = "\\\\dir-column\\b";
        SEQ_REGEXP420.TYPE = "KEYWORD4";
        SEQ_REGEXP420.HASH_CHAR = "\\dir-column";
        SEQ_REGEXP SEQ_REGEXP421 = new SEQ_REGEXP();
        SEQ_REGEXP421.text = "\\\\doubleflat\\b";
        SEQ_REGEXP421.TYPE = "KEYWORD4";
        SEQ_REGEXP421.HASH_CHAR = "\\doubleflat";
        SEQ_REGEXP SEQ_REGEXP422 = new SEQ_REGEXP();
        SEQ_REGEXP422.text = "\\\\doublesharp\\b";
        SEQ_REGEXP422.TYPE = "KEYWORD4";
        SEQ_REGEXP422.HASH_CHAR = "\\doublesharp";
        SEQ_REGEXP SEQ_REGEXP423 = new SEQ_REGEXP();
        SEQ_REGEXP423.text = "\\\\draw-circle\\b";
        SEQ_REGEXP423.TYPE = "KEYWORD4";
        SEQ_REGEXP423.HASH_CHAR = "\\draw-circle";
        SEQ_REGEXP SEQ_REGEXP424 = new SEQ_REGEXP();
        SEQ_REGEXP424.text = "\\\\draw-line\\b";
        SEQ_REGEXP424.TYPE = "KEYWORD4";
        SEQ_REGEXP424.HASH_CHAR = "\\draw-line";
        SEQ_REGEXP SEQ_REGEXP425 = new SEQ_REGEXP();
        SEQ_REGEXP425.text = "\\\\dynamic\\b";
        SEQ_REGEXP425.TYPE = "KEYWORD4";
        SEQ_REGEXP425.HASH_CHAR = "\\dynamic";
        SEQ_REGEXP SEQ_REGEXP426 = new SEQ_REGEXP();
        SEQ_REGEXP426.text = "\\\\epsfile\\b";
        SEQ_REGEXP426.TYPE = "KEYWORD4";
        SEQ_REGEXP426.HASH_CHAR = "\\epsfile";
        SEQ_REGEXP SEQ_REGEXP427 = new SEQ_REGEXP();
        SEQ_REGEXP427.text = "\\\\fill-line\\b";
        SEQ_REGEXP427.TYPE = "KEYWORD4";
        SEQ_REGEXP427.HASH_CHAR = "\\fill-line";
        SEQ_REGEXP SEQ_REGEXP428 = new SEQ_REGEXP();
        SEQ_REGEXP428.text = "\\\\filled-box\\b";
        SEQ_REGEXP428.TYPE = "KEYWORD4";
        SEQ_REGEXP428.HASH_CHAR = "\\filled-box";
        SEQ_REGEXP SEQ_REGEXP429 = new SEQ_REGEXP();
        SEQ_REGEXP429.text = "\\\\finger\\b";
        SEQ_REGEXP429.TYPE = "KEYWORD4";
        SEQ_REGEXP429.HASH_CHAR = "\\finger";
        SEQ_REGEXP SEQ_REGEXP430 = new SEQ_REGEXP();
        SEQ_REGEXP430.text = "\\\\flat\\b";
        SEQ_REGEXP430.TYPE = "KEYWORD4";
        SEQ_REGEXP430.HASH_CHAR = "\\flat";
        SEQ_REGEXP SEQ_REGEXP431 = new SEQ_REGEXP();
        SEQ_REGEXP431.text = "\\\\fontCaps\\b";
        SEQ_REGEXP431.TYPE = "KEYWORD4";
        SEQ_REGEXP431.HASH_CHAR = "\\fontCaps";
        SEQ_REGEXP SEQ_REGEXP432 = new SEQ_REGEXP();
        SEQ_REGEXP432.text = "\\\\fontsize\\b";
        SEQ_REGEXP432.TYPE = "KEYWORD4";
        SEQ_REGEXP432.HASH_CHAR = "\\fontsize";
        SEQ_REGEXP SEQ_REGEXP433 = new SEQ_REGEXP();
        SEQ_REGEXP433.text = "\\\\fraction\\b";
        SEQ_REGEXP433.TYPE = "KEYWORD4";
        SEQ_REGEXP433.HASH_CHAR = "\\fraction";
        SEQ_REGEXP SEQ_REGEXP434 = new SEQ_REGEXP();
        SEQ_REGEXP434.text = "\\\\fret-diagram\\b";
        SEQ_REGEXP434.TYPE = "KEYWORD4";
        SEQ_REGEXP434.HASH_CHAR = "\\fret-diagram";
        SEQ_REGEXP SEQ_REGEXP435 = new SEQ_REGEXP();
        SEQ_REGEXP435.text = "\\\\fret-diagram-terse\\b";
        SEQ_REGEXP435.TYPE = "KEYWORD4";
        SEQ_REGEXP435.HASH_CHAR = "\\fret-diagram-terse";
        SEQ_REGEXP SEQ_REGEXP436 = new SEQ_REGEXP();
        SEQ_REGEXP436.text = "\\\\fret-diagram-verbose\\b";
        SEQ_REGEXP436.TYPE = "KEYWORD4";
        SEQ_REGEXP436.HASH_CHAR = "\\fret-diagram-verbose";
        SEQ_REGEXP SEQ_REGEXP437 = new SEQ_REGEXP();
        SEQ_REGEXP437.text = "\\\\fromproperty\\b";
        SEQ_REGEXP437.TYPE = "KEYWORD4";
        SEQ_REGEXP437.HASH_CHAR = "\\fromproperty";
        SEQ_REGEXP SEQ_REGEXP438 = new SEQ_REGEXP();
        SEQ_REGEXP438.text = "\\\\general-align\\b";
        SEQ_REGEXP438.TYPE = "KEYWORD4";
        SEQ_REGEXP438.HASH_CHAR = "\\general-align";
        SEQ_REGEXP SEQ_REGEXP439 = new SEQ_REGEXP();
        SEQ_REGEXP439.text = "\\\\halign\\b";
        SEQ_REGEXP439.TYPE = "KEYWORD4";
        SEQ_REGEXP439.HASH_CHAR = "\\halign";
        SEQ_REGEXP SEQ_REGEXP440 = new SEQ_REGEXP();
        SEQ_REGEXP440.text = "\\\\harp-pedal\\b";
        SEQ_REGEXP440.TYPE = "KEYWORD4";
        SEQ_REGEXP440.HASH_CHAR = "\\harp-pedal";
        SEQ_REGEXP SEQ_REGEXP441 = new SEQ_REGEXP();
        SEQ_REGEXP441.text = "\\\\hbracket\\b";
        SEQ_REGEXP441.TYPE = "KEYWORD4";
        SEQ_REGEXP441.HASH_CHAR = "\\hbracket";
        SEQ_REGEXP SEQ_REGEXP442 = new SEQ_REGEXP();
        SEQ_REGEXP442.text = "\\\\hcenter-in\\b";
        SEQ_REGEXP442.TYPE = "KEYWORD4";
        SEQ_REGEXP442.HASH_CHAR = "\\hcenter-in";
        SEQ_REGEXP SEQ_REGEXP443 = new SEQ_REGEXP();
        SEQ_REGEXP443.text = "\\\\hspace\\b";
        SEQ_REGEXP443.TYPE = "KEYWORD4";
        SEQ_REGEXP443.HASH_CHAR = "\\hspace";
        SEQ_REGEXP SEQ_REGEXP444 = new SEQ_REGEXP();
        SEQ_REGEXP444.text = "\\\\huge\\b";
        SEQ_REGEXP444.TYPE = "KEYWORD4";
        SEQ_REGEXP444.HASH_CHAR = "\\huge";
        SEQ_REGEXP SEQ_REGEXP445 = new SEQ_REGEXP();
        SEQ_REGEXP445.text = "\\\\italic\\b";
        SEQ_REGEXP445.TYPE = "KEYWORD4";
        SEQ_REGEXP445.HASH_CHAR = "\\italic";
        SEQ_REGEXP SEQ_REGEXP446 = new SEQ_REGEXP();
        SEQ_REGEXP446.text = "\\\\justify\\b";
        SEQ_REGEXP446.TYPE = "KEYWORD4";
        SEQ_REGEXP446.HASH_CHAR = "\\justify";
        SEQ_REGEXP SEQ_REGEXP447 = new SEQ_REGEXP();
        SEQ_REGEXP447.text = "\\\\justify-field\\b";
        SEQ_REGEXP447.TYPE = "KEYWORD4";
        SEQ_REGEXP447.HASH_CHAR = "\\justify-field";
        SEQ_REGEXP SEQ_REGEXP448 = new SEQ_REGEXP();
        SEQ_REGEXP448.text = "\\\\justify-string\\b";
        SEQ_REGEXP448.TYPE = "KEYWORD4";
        SEQ_REGEXP448.HASH_CHAR = "\\justify-string";
        SEQ_REGEXP SEQ_REGEXP449 = new SEQ_REGEXP();
        SEQ_REGEXP449.text = "\\\\large\\b";
        SEQ_REGEXP449.TYPE = "KEYWORD4";
        SEQ_REGEXP449.HASH_CHAR = "\\large";
        SEQ_REGEXP SEQ_REGEXP450 = new SEQ_REGEXP();
        SEQ_REGEXP450.text = "\\\\larger\\b";
        SEQ_REGEXP450.TYPE = "KEYWORD4";
        SEQ_REGEXP450.HASH_CHAR = "\\larger";
        SEQ_REGEXP SEQ_REGEXP451 = new SEQ_REGEXP();
        SEQ_REGEXP451.text = "\\\\left-align\\b";
        SEQ_REGEXP451.TYPE = "KEYWORD4";
        SEQ_REGEXP451.HASH_CHAR = "\\left-align";
        SEQ_REGEXP SEQ_REGEXP452 = new SEQ_REGEXP();
        SEQ_REGEXP452.text = "\\\\left-column\\b";
        SEQ_REGEXP452.TYPE = "KEYWORD4";
        SEQ_REGEXP452.HASH_CHAR = "\\left-column";
        SEQ_REGEXP SEQ_REGEXP453 = new SEQ_REGEXP();
        SEQ_REGEXP453.text = "\\\\line\\b";
        SEQ_REGEXP453.TYPE = "KEYWORD4";
        SEQ_REGEXP453.HASH_CHAR = "\\line";
        SEQ_REGEXP SEQ_REGEXP454 = new SEQ_REGEXP();
        SEQ_REGEXP454.text = "\\\\lookup\\b";
        SEQ_REGEXP454.TYPE = "KEYWORD4";
        SEQ_REGEXP454.HASH_CHAR = "\\lookup";
        SEQ_REGEXP SEQ_REGEXP455 = new SEQ_REGEXP();
        SEQ_REGEXP455.text = "\\\\lower\\b";
        SEQ_REGEXP455.TYPE = "KEYWORD4";
        SEQ_REGEXP455.HASH_CHAR = "\\lower";
        SEQ_REGEXP SEQ_REGEXP456 = new SEQ_REGEXP();
        SEQ_REGEXP456.text = "\\\\magnify\\b";
        SEQ_REGEXP456.TYPE = "KEYWORD4";
        SEQ_REGEXP456.HASH_CHAR = "\\magnify";
        SEQ_REGEXP SEQ_REGEXP457 = new SEQ_REGEXP();
        SEQ_REGEXP457.text = "\\\\markalphabet\\b";
        SEQ_REGEXP457.TYPE = "KEYWORD4";
        SEQ_REGEXP457.HASH_CHAR = "\\markalphabet";
        SEQ_REGEXP SEQ_REGEXP458 = new SEQ_REGEXP();
        SEQ_REGEXP458.text = "\\\\markletter\\b";
        SEQ_REGEXP458.TYPE = "KEYWORD4";
        SEQ_REGEXP458.HASH_CHAR = "\\markletter";
        SEQ_REGEXP SEQ_REGEXP459 = new SEQ_REGEXP();
        SEQ_REGEXP459.text = "\\\\medium\\b";
        SEQ_REGEXP459.TYPE = "KEYWORD4";
        SEQ_REGEXP459.HASH_CHAR = "\\medium";
        SEQ_REGEXP SEQ_REGEXP460 = new SEQ_REGEXP();
        SEQ_REGEXP460.text = "\\\\musicglyph\\b";
        SEQ_REGEXP460.TYPE = "KEYWORD4";
        SEQ_REGEXP460.HASH_CHAR = "\\musicglyph";
        SEQ_REGEXP SEQ_REGEXP461 = new SEQ_REGEXP();
        SEQ_REGEXP461.text = "\\\\natural\\b";
        SEQ_REGEXP461.TYPE = "KEYWORD4";
        SEQ_REGEXP461.HASH_CHAR = "\\natural";
        SEQ_REGEXP SEQ_REGEXP462 = new SEQ_REGEXP();
        SEQ_REGEXP462.text = "\\\\normal-size-sub\\b";
        SEQ_REGEXP462.TYPE = "KEYWORD4";
        SEQ_REGEXP462.HASH_CHAR = "\\normal-size-sub";
        SEQ_REGEXP SEQ_REGEXP463 = new SEQ_REGEXP();
        SEQ_REGEXP463.text = "\\\\normal-size-super\\b";
        SEQ_REGEXP463.TYPE = "KEYWORD4";
        SEQ_REGEXP463.HASH_CHAR = "\\normal-size-super";
        SEQ_REGEXP SEQ_REGEXP464 = new SEQ_REGEXP();
        SEQ_REGEXP464.text = "\\\\normal-text\\b";
        SEQ_REGEXP464.TYPE = "KEYWORD4";
        SEQ_REGEXP464.HASH_CHAR = "\\normal-text";
        SEQ_REGEXP SEQ_REGEXP465 = new SEQ_REGEXP();
        SEQ_REGEXP465.text = "\\\\normalsize\\b";
        SEQ_REGEXP465.TYPE = "KEYWORD4";
        SEQ_REGEXP465.HASH_CHAR = "\\normalsize";
        SEQ_REGEXP SEQ_REGEXP466 = new SEQ_REGEXP();
        SEQ_REGEXP466.text = "\\\\note\\b";
        SEQ_REGEXP466.TYPE = "KEYWORD4";
        SEQ_REGEXP466.HASH_CHAR = "\\note";
        SEQ_REGEXP SEQ_REGEXP467 = new SEQ_REGEXP();
        SEQ_REGEXP467.text = "\\\\note-by-number\\b";
        SEQ_REGEXP467.TYPE = "KEYWORD4";
        SEQ_REGEXP467.HASH_CHAR = "\\note-by-number";
        SEQ_REGEXP SEQ_REGEXP468 = new SEQ_REGEXP();
        SEQ_REGEXP468.text = "\\\\null\\b";
        SEQ_REGEXP468.TYPE = "KEYWORD4";
        SEQ_REGEXP468.HASH_CHAR = "\\null";
        SEQ_REGEXP SEQ_REGEXP469 = new SEQ_REGEXP();
        SEQ_REGEXP469.text = "\\\\number\\b";
        SEQ_REGEXP469.TYPE = "KEYWORD4";
        SEQ_REGEXP469.HASH_CHAR = "\\number";
        SEQ_REGEXP SEQ_REGEXP470 = new SEQ_REGEXP();
        SEQ_REGEXP470.text = "\\\\on-the-fly\\b";
        SEQ_REGEXP470.TYPE = "KEYWORD4";
        SEQ_REGEXP470.HASH_CHAR = "\\on-the-fly";
        SEQ_REGEXP SEQ_REGEXP471 = new SEQ_REGEXP();
        SEQ_REGEXP471.text = "\\\\override\\b";
        SEQ_REGEXP471.TYPE = "KEYWORD4";
        SEQ_REGEXP471.HASH_CHAR = "\\override";
        SEQ_REGEXP SEQ_REGEXP472 = new SEQ_REGEXP();
        SEQ_REGEXP472.text = "\\\\pad-around\\b";
        SEQ_REGEXP472.TYPE = "KEYWORD4";
        SEQ_REGEXP472.HASH_CHAR = "\\pad-around";
        SEQ_REGEXP SEQ_REGEXP473 = new SEQ_REGEXP();
        SEQ_REGEXP473.text = "\\\\pad-markup\\b";
        SEQ_REGEXP473.TYPE = "KEYWORD4";
        SEQ_REGEXP473.HASH_CHAR = "\\pad-markup";
        SEQ_REGEXP SEQ_REGEXP474 = new SEQ_REGEXP();
        SEQ_REGEXP474.text = "\\\\pad-to-box\\b";
        SEQ_REGEXP474.TYPE = "KEYWORD4";
        SEQ_REGEXP474.HASH_CHAR = "\\pad-to-box";
        SEQ_REGEXP SEQ_REGEXP475 = new SEQ_REGEXP();
        SEQ_REGEXP475.text = "\\\\pad-x\\b";
        SEQ_REGEXP475.TYPE = "KEYWORD4";
        SEQ_REGEXP475.HASH_CHAR = "\\pad-x";
        SEQ_REGEXP SEQ_REGEXP476 = new SEQ_REGEXP();
        SEQ_REGEXP476.text = "\\\\page-ref\\b";
        SEQ_REGEXP476.TYPE = "KEYWORD4";
        SEQ_REGEXP476.HASH_CHAR = "\\page-ref";
        SEQ_REGEXP SEQ_REGEXP477 = new SEQ_REGEXP();
        SEQ_REGEXP477.text = "\\\\postscript\\b";
        SEQ_REGEXP477.TYPE = "KEYWORD4";
        SEQ_REGEXP477.HASH_CHAR = "\\postscript";
        SEQ_REGEXP SEQ_REGEXP478 = new SEQ_REGEXP();
        SEQ_REGEXP478.text = "\\\\put-adjacent\\b";
        SEQ_REGEXP478.TYPE = "KEYWORD4";
        SEQ_REGEXP478.HASH_CHAR = "\\put-adjacent";
        SEQ_REGEXP SEQ_REGEXP479 = new SEQ_REGEXP();
        SEQ_REGEXP479.text = "\\\\raise\\b";
        SEQ_REGEXP479.TYPE = "KEYWORD4";
        SEQ_REGEXP479.HASH_CHAR = "\\raise";
        SEQ_REGEXP SEQ_REGEXP480 = new SEQ_REGEXP();
        SEQ_REGEXP480.text = "\\\\right-align\\b";
        SEQ_REGEXP480.TYPE = "KEYWORD4";
        SEQ_REGEXP480.HASH_CHAR = "\\right-align";
        SEQ_REGEXP SEQ_REGEXP481 = new SEQ_REGEXP();
        SEQ_REGEXP481.text = "\\\\right-column\\b";
        SEQ_REGEXP481.TYPE = "KEYWORD4";
        SEQ_REGEXP481.HASH_CHAR = "\\right-column";
        SEQ_REGEXP SEQ_REGEXP482 = new SEQ_REGEXP();
        SEQ_REGEXP482.text = "\\\\roman\\b";
        SEQ_REGEXP482.TYPE = "KEYWORD4";
        SEQ_REGEXP482.HASH_CHAR = "\\roman";
        SEQ_REGEXP SEQ_REGEXP483 = new SEQ_REGEXP();
        SEQ_REGEXP483.text = "\\\\rotate\\b";
        SEQ_REGEXP483.TYPE = "KEYWORD4";
        SEQ_REGEXP483.HASH_CHAR = "\\rotate";
        SEQ_REGEXP SEQ_REGEXP484 = new SEQ_REGEXP();
        SEQ_REGEXP484.text = "\\\\rounded-box\\b";
        SEQ_REGEXP484.TYPE = "KEYWORD4";
        SEQ_REGEXP484.HASH_CHAR = "\\rounded-box";
        SEQ_REGEXP SEQ_REGEXP485 = new SEQ_REGEXP();
        SEQ_REGEXP485.text = "\\\\sans\\b";
        SEQ_REGEXP485.TYPE = "KEYWORD4";
        SEQ_REGEXP485.HASH_CHAR = "\\sans";
        SEQ_REGEXP SEQ_REGEXP486 = new SEQ_REGEXP();
        SEQ_REGEXP486.text = "\\\\score\\b";
        SEQ_REGEXP486.TYPE = "KEYWORD4";
        SEQ_REGEXP486.HASH_CHAR = "\\score";
        SEQ_REGEXP SEQ_REGEXP487 = new SEQ_REGEXP();
        SEQ_REGEXP487.text = "\\\\semiflat\\b";
        SEQ_REGEXP487.TYPE = "KEYWORD4";
        SEQ_REGEXP487.HASH_CHAR = "\\semiflat";
        SEQ_REGEXP SEQ_REGEXP488 = new SEQ_REGEXP();
        SEQ_REGEXP488.text = "\\\\semisharp\\b";
        SEQ_REGEXP488.TYPE = "KEYWORD4";
        SEQ_REGEXP488.HASH_CHAR = "\\semisharp";
        SEQ_REGEXP SEQ_REGEXP489 = new SEQ_REGEXP();
        SEQ_REGEXP489.text = "\\\\sesquiflat\\b";
        SEQ_REGEXP489.TYPE = "KEYWORD4";
        SEQ_REGEXP489.HASH_CHAR = "\\sesquiflat";
        SEQ_REGEXP SEQ_REGEXP490 = new SEQ_REGEXP();
        SEQ_REGEXP490.text = "\\\\sesquisharp\\b";
        SEQ_REGEXP490.TYPE = "KEYWORD4";
        SEQ_REGEXP490.HASH_CHAR = "\\sesquisharp";
        SEQ_REGEXP SEQ_REGEXP491 = new SEQ_REGEXP();
        SEQ_REGEXP491.text = "\\\\sharp\\b";
        SEQ_REGEXP491.TYPE = "KEYWORD4";
        SEQ_REGEXP491.HASH_CHAR = "\\sharp";
        SEQ_REGEXP SEQ_REGEXP492 = new SEQ_REGEXP();
        SEQ_REGEXP492.text = "\\\\simple\\b";
        SEQ_REGEXP492.TYPE = "KEYWORD4";
        SEQ_REGEXP492.HASH_CHAR = "\\simple";
        SEQ_REGEXP SEQ_REGEXP493 = new SEQ_REGEXP();
        SEQ_REGEXP493.text = "\\\\slashed-digit\\b";
        SEQ_REGEXP493.TYPE = "KEYWORD4";
        SEQ_REGEXP493.HASH_CHAR = "\\slashed-digit";
        SEQ_REGEXP SEQ_REGEXP494 = new SEQ_REGEXP();
        SEQ_REGEXP494.text = "\\\\small\\b";
        SEQ_REGEXP494.TYPE = "KEYWORD4";
        SEQ_REGEXP494.HASH_CHAR = "\\small";
        SEQ_REGEXP SEQ_REGEXP495 = new SEQ_REGEXP();
        SEQ_REGEXP495.text = "\\\\smallCaps\\b";
        SEQ_REGEXP495.TYPE = "KEYWORD4";
        SEQ_REGEXP495.HASH_CHAR = "\\smallCaps";
        SEQ_REGEXP SEQ_REGEXP496 = new SEQ_REGEXP();
        SEQ_REGEXP496.text = "\\\\smaller\\b";
        SEQ_REGEXP496.TYPE = "KEYWORD4";
        SEQ_REGEXP496.HASH_CHAR = "\\smaller";
        SEQ_REGEXP SEQ_REGEXP497 = new SEQ_REGEXP();
        SEQ_REGEXP497.text = "\\\\stencil\\b";
        SEQ_REGEXP497.TYPE = "KEYWORD4";
        SEQ_REGEXP497.HASH_CHAR = "\\stencil";
        SEQ_REGEXP SEQ_REGEXP498 = new SEQ_REGEXP();
        SEQ_REGEXP498.text = "\\\\strut\\b";
        SEQ_REGEXP498.TYPE = "KEYWORD4";
        SEQ_REGEXP498.HASH_CHAR = "\\strut";
        SEQ_REGEXP SEQ_REGEXP499 = new SEQ_REGEXP();
        SEQ_REGEXP499.text = "\\\\sub\\b";
        SEQ_REGEXP499.TYPE = "KEYWORD4";
        SEQ_REGEXP499.HASH_CHAR = "\\sub";
        SEQ_REGEXP SEQ_REGEXP500 = new SEQ_REGEXP();
        SEQ_REGEXP500.text = "\\\\super\\b";
        SEQ_REGEXP500.TYPE = "KEYWORD4";
        SEQ_REGEXP500.HASH_CHAR = "\\super";
        SEQ_REGEXP SEQ_REGEXP501 = new SEQ_REGEXP();
        SEQ_REGEXP501.text = "\\\\teeny\\b";
        SEQ_REGEXP501.TYPE = "KEYWORD4";
        SEQ_REGEXP501.HASH_CHAR = "\\teeny";
        SEQ_REGEXP SEQ_REGEXP502 = new SEQ_REGEXP();
        SEQ_REGEXP502.text = "\\\\text\\b";
        SEQ_REGEXP502.TYPE = "KEYWORD4";
        SEQ_REGEXP502.HASH_CHAR = "\\text";
        SEQ_REGEXP SEQ_REGEXP503 = new SEQ_REGEXP();
        SEQ_REGEXP503.text = "\\\\tied-lyric\\b";
        SEQ_REGEXP503.TYPE = "KEYWORD4";
        SEQ_REGEXP503.HASH_CHAR = "\\tied-lyric";
        SEQ_REGEXP SEQ_REGEXP504 = new SEQ_REGEXP();
        SEQ_REGEXP504.text = "\\\\tiny\\b";
        SEQ_REGEXP504.TYPE = "KEYWORD4";
        SEQ_REGEXP504.HASH_CHAR = "\\tiny";
        SEQ_REGEXP SEQ_REGEXP505 = new SEQ_REGEXP();
        SEQ_REGEXP505.text = "\\\\translate\\b";
        SEQ_REGEXP505.TYPE = "KEYWORD4";
        SEQ_REGEXP505.HASH_CHAR = "\\translate";
        SEQ_REGEXP SEQ_REGEXP506 = new SEQ_REGEXP();
        SEQ_REGEXP506.text = "\\\\translate-scaled\\b";
        SEQ_REGEXP506.TYPE = "KEYWORD4";
        SEQ_REGEXP506.HASH_CHAR = "\\translate-scaled";
        SEQ_REGEXP SEQ_REGEXP507 = new SEQ_REGEXP();
        SEQ_REGEXP507.text = "\\\\transparent\\b";
        SEQ_REGEXP507.TYPE = "KEYWORD4";
        SEQ_REGEXP507.HASH_CHAR = "\\transparent";
        SEQ_REGEXP SEQ_REGEXP508 = new SEQ_REGEXP();
        SEQ_REGEXP508.text = "\\\\triangle\\b";
        SEQ_REGEXP508.TYPE = "KEYWORD4";
        SEQ_REGEXP508.HASH_CHAR = "\\triangle";
        SEQ_REGEXP SEQ_REGEXP509 = new SEQ_REGEXP();
        SEQ_REGEXP509.text = "\\\\typewriter\\b";
        SEQ_REGEXP509.TYPE = "KEYWORD4";
        SEQ_REGEXP509.HASH_CHAR = "\\typewriter";
        SEQ_REGEXP SEQ_REGEXP510 = new SEQ_REGEXP();
        SEQ_REGEXP510.text = "\\\\underline\\b";
        SEQ_REGEXP510.TYPE = "KEYWORD4";
        SEQ_REGEXP510.HASH_CHAR = "\\underline";
        SEQ_REGEXP SEQ_REGEXP511 = new SEQ_REGEXP();
        SEQ_REGEXP511.text = "\\\\upright\\b";
        SEQ_REGEXP511.TYPE = "KEYWORD4";
        SEQ_REGEXP511.HASH_CHAR = "\\upright";
        SEQ_REGEXP SEQ_REGEXP512 = new SEQ_REGEXP();
        SEQ_REGEXP512.text = "\\\\vcenter\\b";
        SEQ_REGEXP512.TYPE = "KEYWORD4";
        SEQ_REGEXP512.HASH_CHAR = "\\vcenter";
        SEQ_REGEXP SEQ_REGEXP513 = new SEQ_REGEXP();
        SEQ_REGEXP513.text = "\\\\verbatim-file\\b";
        SEQ_REGEXP513.TYPE = "KEYWORD4";
        SEQ_REGEXP513.HASH_CHAR = "\\verbatim-file";
        SEQ_REGEXP SEQ_REGEXP514 = new SEQ_REGEXP();
        SEQ_REGEXP514.text = "\\\\whiteout\\b";
        SEQ_REGEXP514.TYPE = "KEYWORD4";
        SEQ_REGEXP514.HASH_CHAR = "\\whiteout";
        SEQ_REGEXP SEQ_REGEXP515 = new SEQ_REGEXP();
        SEQ_REGEXP515.text = "\\\\with-color\\b";
        SEQ_REGEXP515.TYPE = "KEYWORD4";
        SEQ_REGEXP515.HASH_CHAR = "\\with-color";
        SEQ_REGEXP SEQ_REGEXP516 = new SEQ_REGEXP();
        SEQ_REGEXP516.text = "\\\\with-dimensions\\b";
        SEQ_REGEXP516.TYPE = "KEYWORD4";
        SEQ_REGEXP516.HASH_CHAR = "\\with-dimensions";
        SEQ_REGEXP SEQ_REGEXP517 = new SEQ_REGEXP();
        SEQ_REGEXP517.text = "\\\\with-url\\b";
        SEQ_REGEXP517.TYPE = "KEYWORD4";
        SEQ_REGEXP517.HASH_CHAR = "\\with-url";
        SEQ_REGEXP SEQ_REGEXP518 = new SEQ_REGEXP();
        SEQ_REGEXP518.text = "\\\\wordwrap\\b";
        SEQ_REGEXP518.TYPE = "KEYWORD4";
        SEQ_REGEXP518.HASH_CHAR = "\\wordwrap";
        SEQ_REGEXP SEQ_REGEXP519 = new SEQ_REGEXP();
        SEQ_REGEXP519.text = "\\\\wordwrap-field\\b";
        SEQ_REGEXP519.TYPE = "KEYWORD4";
        SEQ_REGEXP519.HASH_CHAR = "\\wordwrap-field";
        SEQ_REGEXP SEQ_REGEXP520 = new SEQ_REGEXP();
        SEQ_REGEXP520.text = "\\\\wordwrap-string\\b";
        SEQ_REGEXP520.TYPE = "KEYWORD4";
        SEQ_REGEXP520.HASH_CHAR = "\\wordwrap-string";
        MARK_FOLLOWING MARK_FOLLOWING2 = new MARK_FOLLOWING();
        MARK_FOLLOWING2.text = "\\";
        MARK_FOLLOWING2.TYPE = "FUNCTION";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"#t", "#f", });
        KEYWORDS1.add("KEYWORD2", new String[]{"Forbid_line_break_engraver", "staff-symbol-referencer-interface", "clef-interface", "note-name-interface", "lyric-extender-interface", "mensural-ligature-interface", "Multi_measure_rest_engraver", "bass-figure-alignment-interface", "Slur_engraver", "Completion_heads_engraver", "rhythmic-grob-interface", "span-bar-interface", "Drum_note_performer", "InnerChoirStaff", "Score", "Bar_engraver", "Breathing_sign_engraver", "Staff", "spanner-interface", "Ligature_bracket_engraver", "Chord_name_engraver", "accidental-placement-interface", "Span_arpeggio_engraver", "MensuralVoice", "Stanza_number_engraver", "Grace_engraver", "Grace_beam_engraver", "script-interface", "Time_signature_engraver", "Stanza_number_align_engraver", "GregorianTranscriptionStaff", "Key_engraver", "cluster-beacon-interface", "TabVoice", "Dynamic_engraver", "rhythmic-head-interface", "Repeat_acknowledge_engraver", "dynamic-interface", "volta-bracket-interface", "bar-line-interface", "piano-pedal-interface", "font-interface", "VaticanaVoice", "staff-spacing-interface", "tie-interface", "Devnull", "dynamic-text-spanner-interface", "Script_row_engraver", "Stem_engraver", "grid-line-interface", "grob-interface", "custos-interface", "Font_size_engraver", "trill-pitch-accidental-interface", "Clef_engraver", "Text_engraver", "dynamic-line-spanner-interface", "Repeat_tie_engraver", "tablature-interface", "staff-symbol-interface", "rest-collision-interface", "Horizontal_bracket_engraver", "accidental-suggestion-interface", "Beam_performer", "Lyric_performer", "Piano_pedal_engraver", "vaticana-ligature-interface", "Tab_note_heads_engraver", "text-interface", "break-alignable-interface", "lyric-hyphen-interface", "grace-spacing-interface", "note-column-interface", "Vertical_align_engraver", "break-aligned-interface", "Staff_performer", "Ledger_line_engraver", "rest-interface", "Fingering_engraver", "figured-bass-continuation-interface", "metronome-mark-interface", "Key_performer", "Separating_line_group_engraver", "bend-after-interface", "DrumStaff", "unbreakable-spanner-interface", "trill-spanner-interface", "Grace_spacing_engraver", "Ambitus_engraver", "system-interface", "Swallow_engraver", "Cluster_spanner_engraver", "fret-diagram-interface", "gregorian-ligature-interface", "dots-interface", "percent-repeat-item-interface", "Time_signature_performer", "semi-tie-column-interface", "spacing-spanner-interface", "Staff_symbol_engraver", "mark-interface", "accidental-interface", "Text_spanner_engraver", "Swallow_performer", "system-start-text-interface", "Mensural_ligature_engraver", "chord-name-interface", "Lyric_engraver", "Translator", "script-column-interface", "Instrument_switch_engraver", "Grob_pq_engraver", "Volta_engraver", "breathing-sign-interface", "Span_bar_engraver", "Tab_harmonic_engraver", "Note_performer", "beam-interface", "note-collision-interface", "only-prebreak-interface", "stroke-finger-interface", "InnerStaffGroup", "tie-column-interface", "FretBoards", "Tie_engraver", "Laissez_vibrer_engraver", "slur-interface", "Custos_engraver", "Note_swallow_translator", "Rhythmic_column_engraver", "Default_bar_line_engraver", "note-spacing-interface", "FiguredBass", "vertically-spaceable-interface", "GregorianTranscriptionVoice", "stem-tremolo-interface", "measure-grouping-interface", "Spacing_engraver", "side-position-interface", "semi-tie-interface", "lyric-syllable-interface", "Engraver", "Pitched_trill_engraver", "ledger-line-spanner-interface", "stem-interface", "Extender_engraver", "Pitch_squash_engraver", "align-interface", "ambitus-interface", "Rest_swallow_translator", "string-number-interface", "self-alignment-interface", "Rest_collision_engraver", "hairpin-interface", "NoteNames", "Drum_notes_engraver", "arpeggio-interface", "Tweak_engraver", "ledgered-interface", "Global", "StaffGroup", "DrumVoice", "Voice", "GrandStaff", "Staff_collecting_engraver", "melody-spanner-interface", "Hara_kiri_engraver", "Figured_bass_position_engraver", "Tempo_performer", "New_dynamic_engraver", "Measure_grouping_engraver", "Hyphen_engraver", "Skip_event_swallow_translator", "Vaticana_ligature_engraver", "text-script-interface", "Tuplet_engraver", "Slur_performer", "spaceable-grob-interface", "Tie_performer", "Vertically_spaced_contexts_engraver", "Trill_spanner_engraver", "Spanner_break_forbid_engraver", "CueVoice", "ChoirStaff", "Glissando_engraver", "Balloon_engraver", "separation-item-interface", "Accidental_engraver", "Output_property_engraver", "hara-kiri-group-spanner-interface", "piano-pedal-script-interface", "system-start-delimiter-interface", "multi-measure-rest-interface", "Note_name_engraver", "Note_spacing_engraver", "Timing_translator", "Mark_engraver", "Control_track_performer", "Part_combine_engraver", "axis-group-interface", "note-head-interface", "horizontal-bracket-interface", "PianoStaff", "Slash_repeat_engraver", "Page_turn_engraver", "parentheses-interface", "key-signature-interface", "lyric-interface", "grid-point-interface", "item-interface", "Ottava_spanner_engraver", "Melody_engraver", "Percent_repeat_engraver", "tuplet-number-interface", "Rest_engraver", "stanza-number-interface", "enclosing-bracket-interface", "Break_align_engraver", "Piano_pedal_performer", "Paper_column_engraver", "pitched-trill-interface", "Grid_line_span_engraver", "Lyrics", "Instrument_name_engraver", "line-interface", "Bend_engraver", "Arpeggio_engraver", "key-cancellation-interface", "Grid_point_engraver", "Script_column_engraver", "Note_head_line_engraver", "spacing-options-interface", "Dot_column_engraver", "Chord_tremolo_engraver", "bass-figure-interface", "ottava-bracket-interface", "Bar_number_engraver", "Axis_group_engraver", "tuplet-bracket-interface", "Phrasing_slur_engraver", "Dynamic_align_engraver", "Piano_pedal_align_engraver", "Collision_engraver", "Dots_engraver", "New_fingering_engraver", "Figured_bass_engraver", "dot-column-interface", "multi-measure-interface", "Fretboard_engraver", "ligature-interface", "instrument-specific-markup-interface", "time-signature-interface", "Metronome_mark_engraver", "break-alignment-interface", "Auto_beam_engraver", "balloon-interface", "VaticanaStaff", "Script_engraver", "System_start_delimiter_engraver", "spacing-interface", "ligature-bracket-interface", "percent-repeat-interface", "ChordNames", "finger-interface", "TabStaff", "cluster-interface", "Beam_engraver", "RhythmicStaff", "String_number_engraver", "Dynamic_performer", "piano-pedal-bracket-interface", "Parenthesis_engraver", "Tab_staff_symbol_engraver", "paper-column-interface", "Note_heads_engraver", "MensuralStaff", "line-spanner-interface", "#:behaviour", "#:column", "#:condition", "#:depth", "#:exit-depth", "#:expression", "#:file-name", "#:file-regexp", "#:line", "#:procedure", "#:repeat-identical-behaviour", "#:single-shot", "#:skip-count", "$abs", "$acos", "$acosh", "$asin", "$asinh", "$atan", "$atan2", "$atanh", "$cos", "$cosh", "$exp", "$expt", "$log", "$sin", "$sinh", "$sqrt", "$tan", "$tanh", "%library-dir", "%make-void-port", "%package-data-dir", "%read-delimited!", "%read-line", "%search-load-path", "%site-dir", ",@", "->char-set", "1+", "1-", "<apply-trap>", "<entry-trap>", "<exit-trap>", "<group>-disable", "<group>-enable", "<group>-options", "<group>-set!", "<location-trap>", "<procedure-trap>", "<source-trap>", "<step-trap>", "<trap>", "abs", "accept", "access?", "acons", "acos", "acosh", "activate-readline", "add-duration", "add-duration!", "add-hook!", "alarm", "alist->hash-table", "alist-cons", "alist-copy", "alist-delete", "alist-delete!", "all-threads", "all-traps", "and", "and-let*", "angle", "any", "any->c32vector", "any->c64vector", "any->f32vector", "any->f64vector", "any->s16vector", "any->s32vector", "any->s64vector", "any->s8vector", "any->u16vector", "any->u32vector", "any->u64vector", "any->u8vector", "any-bits-set?", "append", "append!", "append-map", "append-map!", "append-reverse", "append-reverse!", "apply", "apply:nconc2last", "apropos-completion-function", "args-fold", "arithmetic-shift", "array->list", "array-contents", "array-copy!", "array-copy-in-order!", "array-dimensions", "array-equal?", "array-fill!", "array-for-each", "array-in-bounds?", "array-index-map!", "array-map!", "array-map-in-order!", "array-rank", "array-ref", "array-set!", "array-shape", "array-type", "array?", "ash", "asin", "asinh", "assoc", "assoc", "assoc-ref", "assoc-remove!", "assoc-set!", "assq", "assq-ref", "assq-remove!", "assq-set!", "assv", "assv-ref", "assv-remove!", "assv-set!", "async", "async-mark", "atan", "atanh", "backtrace", "backtrace", "basename", "begin", "begin-thread", "bind", "bind-textdomain-codeset", "bindtextdomain", "bit-count", "bit-count", "bit-count*", "bit-extract", "bit-field", "bit-invert!", "bit-position", "bit-set*!", "bit-set?", "bitvector", "bitvector->list", "bitvector-fill!", "bitvector-length", "bitvector-ref", "bitvector-set!", "bitvector?", "bitwise-and", "bitwise-if", "bitwise-ior", "bitwise-merge", "bitwise-not", "bitwise-xor", "boolean?", "booleans->integer", "break", "break", "break!", "broadcast-condition-variable", "bt", "c32vector", "c32vector->list", "c32vector-length", "c32vector-ref", "c32vector-set!", "c32vector?", "c64vector", "c64vector->list", "c64vector-length", "c64vector-ref", "c64vector-set!", "c64vector?", "caaaar", "caaadr", "caaar", "caadar", "caaddr", "caadr", "caar", "cadaar", "cadadr", "cadar", "caddar", "cadddr", "caddr", "cadr", "call-with-blocked-asyncs", "call-with-current-continuation", "call-with-input-file", "call-with-input-string", "call-with-new-thread", "call-with-output-file", "call-with-output-string", "call-with-unblocked-asyncs", "call-with-values", "call/cc", "car", "car+cdr", "case", "case-lambda", "catch", "cd", "cdaaar", "cdaadr", "cdaar", "cdadar", "cdaddr", "cdadr", "cdar", "cddaar", "cddadr", "cddar", "cdddar", "cddddr", "cdddr", "cddr", "cdr", "ceiling", "char->integer", "char-alphabetic?", "char-ci<=?", "char-ci<?", "char-ci=?", "char-ci>=?", "char-ci>?", "char-downcase", "char-is-both?", "char-lower-case?", "char-numeric?", "char-ready?", "char-set", "char-set->list", "char-set->string", "char-set-adjoin", "char-set-adjoin!", "char-set-any", "char-set-complement", "char-set-complement!", "char-set-contains?", "char-set-copy", "char-set-count", "char-set-cursor", "char-set-cursor-next", "char-set-delete", "char-set-delete!", "char-set-diff+intersection", "char-set-diff+intersection!", "char-set-difference", "char-set-difference!", "char-set-every", "char-set-filter", "char-set-filter!", "char-set-fold", "char-set-for-each", "char-set-hash", "char-set-intersection", "char-set-intersection!", "char-set-map", "char-set-ref", "char-set-size", "char-set-unfold", "char-set-unfold!", "char-set-union", "char-set-union!", "char-set-xor", "char-set-xor!", "char-set<=", "char-set=", "char-set?", "char-upcase", "char-upper-case?", "char-whitespace?", "char<=?", "char<?", "char=?", "char>=?", "char>?", "char?", "chdir", "chmod", "chown", "chroot", "circular-list", "circular-list?", "close", "close-fdes", "close-input-port", "close-output-port", "close-pipe", "close-port", "closedir", "closure?", "command-line", "complex?", "concatenate", "concatenate!", "cond", "cond-expand", "condition", "condition-has-type?", "condition-message", "condition-ref", "condition-type?", "connect", "cons", "cons*", "cons-source", "continue", "continue", "copy-bit", "copy-bit-field", "copy-file", "copy-random-state", "copy-time", "copy-tree", "cos", "cosh", "count", "crypt", "ctermid", "current-date", "current-dynamic-state", "current-error-port", "current-error-port", "current-input-port", "current-input-port", "current-julian-day", "current-load-port", "current-modified-julian-day", "current-module", "current-output-port", "current-output-port", "current-thread", "current-time", "current-time", "cuserid", "cut", "cute", "date->julian-day", "date->modified-julian-day", "date->string", "date->time-monotonic", "date->time-tai", "date->time-utc", "date-day", "date-hour", "date-minute", "date-month", "date-nanosecond", "date-second", "date-week-day", "date-week-number", "date-year", "date-year-day", "date-zone-offset", "date?", "debug", "debug-disable", "debug-enable", "debug-object?", "debug-options", "debug-options-interface", "debug-set!", "debug-trap", "default-duplicate-binding-handler", "define", "define*", "define*-public", "define-condition-type", "define-macro", "define-module", "define-public", "define-reader-ctor", "define-record-type", "defined?", "defmacro", "defmacro*", "defmacro*-public", "delay", "delete", "delete", "delete!", "delete!", "delete-duplicates", "delete-duplicates!", "delete-file", "delete1!", "delq", "delq!", "delq1!", "delv", "delv!", "delv1!", "denominator", "deq!", "directory-stream?", "dirname", "display", "display-application", "display-backtrace", "display-error", "dotted-list?", "doubly-weak-hash-table?", "down", "drain-input", "drop", "drop-right", "drop-right!", "drop-while", "dup", "dup->fdes", "dup->inport", "dup->outport", "dup->port", "dup2", "duplicate-port", "dynamic-args-call", "dynamic-call", "dynamic-func", "dynamic-link", "dynamic-object?", "dynamic-state?", "dynamic-unlink", "dynamic-wind", "effective-version", "eighth", "enclose-array", "end-of-char-set?", "endgrent", "endhostent", "endnetent", "endprotoent", "endpwent", "endservent", "enq!", "entity?", "environ", "eof-object?", "eq?", "equal?", "eqv?", "error", "error?", "eval", "eval-disable", "eval-enable", "eval-options", "eval-options-interface", "eval-options-interface", "eval-set!", "eval-string", "evaluate", "evaluator-traps-interface", "evaluator-traps-interface", "even?", "every", "exact->inexact", "exact?", "execl", "execle", "execlp", "exp", "expect", "expect-strings", "export", "expt", "extract-condition", "f32vector", "f32vector->list", "f32vector-length", "f32vector-ref", "f32vector-set!", "f32vector?", "f64vector", "f64vector->list", "f64vector-length", "f64vector-ref", "f64vector-set!", "f64vector?", "false-if-exception", "fchmod", "fchown", "fcntl", "fdes->inport", "fdes->outport", "fdes->ports", "fdopen", "feature?", "fflush", "fifth", "file-exists?", "file-port?", "filename-completion-function", "fileno", "filter", "filter!", "filter-map", "find", "find-tail", "finish", "first", "first-set-bit", "flock", "floor", "fluid-ref", "fluid-set!", "fluid?", "flush-all-ports", "fn", "fold", "fold-matches", "fold-right", "for-each", "for-each", "force", "force-output", "format", "fourth", "frame", "frame-arguments", "frame-evaluating-args?", "frame-next", "frame-number", "frame-overflow?", "frame-previous", "frame-procedure", "frame-procedure?", "frame-real?", "frame-source", "frame?", "fstat", "fsync", "ftell", "ftruncate", "ftw", "gc", "gc-live-object-stats", "gc-stats", "gcd", "gds-apropos", "gds-complete-symbol", "gds-debug-trap", "gds-down", "gds-eval-defun", "gds-eval-expression", "gds-eval-last-sexp", "gds-eval-region", "gds-evaluate", "gds-frame-args", "gds-frame-info", "gds-go", "gds-help-symbol", "gds-proc-source", "gds-select-stack-frame", "gds-step-file", "gds-step-into", "gds-step-over", "gds-up", "generalized-vector->list", "generalized-vector-length", "generalized-vector-ref", "generalized-vector-set!", "generalized-vector?", "gensym", "get-internal-real-time", "get-internal-run-time", "get-output-string", "get-print-state", "get-trap", "getcwd", "getegid", "getenv", "geteuid", "getgid", "getgr", "getgrent", "getgrgid", "getgrnam", "getgroups", "gethost", "gethostbyaddr", "gethostbyname", "gethostent", "gethostname", "getitimer", "getlogin", "getnet", "getnetbyaddr", "getnetbyname", "getnetent", "getopt-long", "getpass", "getpeername", "getpgrp", "getpid", "getppid", "getpriority", "getproto", "getprotobyname", "getprotobynumber", "getprotoent", "getpw", "getpwent", "getpwnam", "getpwuid", "getserv", "getservbyname", "getservbyport", "getservent", "getsockname", "getsockopt", "getter-with-setter", "gettext", "gettimeofday", "getuid", "GH_ALLOW_INTS", "gh_append", "gh_append2", "gh_append3", "gh_append4", "gh_apply", "gh_assoc", "gh_assq", "gh_assv", "gh_bool2scm", "gh_boolean_p", "gh_c", "gh_call0", "gh_call1", "gh_call2", "gh_call3", "gh_car", "gh_catch", "gh_cdr", "gh_char2scm", "gh_char_p", "gh_chars2byvect", "gh_cons", "GH_DEFER_INTS", "gh_define", "gh_double2scm", "gh_doubles2dvect", "gh_doubles2scm", "gh_enter", "gh_eq_p", "gh_equal_p", "gh_eqv_p", "gh_eval_file", "gh_eval_str", "gh_exact_p", "gh_floats2fvect", "gh_get_substr", "gh_inexact_p", "gh_ints2scm", "gh_is_eq", "gh_is_equal", "gh_is_eqv", "gh_length", "gh_list", "gh_list_p", "gh_list_ref", "gh_list_tail", "gh_list_to_vector", "gh_load", "gh_long2scm", "gh_longs2ivect", "gh_make_vector", "gh_member", "gh_memq", "gh_memv", "gh_new_procedure", "gh_null_p", "gh_obj_length", "gh_pair_p", "gh_procedure_p", "gh_repl", "gh_reverse", "gh_scm2bool", "gh_scm2char", "gh_scm2chars", "gh_scm2double", "gh_scm2doubles", "gh_scm2floats", "gh_scm2long", "gh_scm2longs", "gh_scm2newstr", "gh_scm2shorts", "gh_scm2ulong", "gh_set_car_x", "gh_set_cdr_x", "gh_set_substr", "gh_shorts2svect", "gh_str02scm", "gh_str2scm", "gh_string_equal_p", "gh_symbol2newstr", "gh_symbol2scm", "gh_symbol_p", "gh_throw", "gh_ulong2scm", "gh_ulongs2uvect", "gh_vector", "gh_vector_length", "gh_vector_p", "gh_vector_ref", "gh_vector_set", "gmtime", "group:gid", "group:mem", "group:name", "group:passwd", "GUILE_CHECK_RETVAL", "GUILE_FLAGS", "GUILE_MODULE_AVAILABLE", "GUILE_MODULE_CHECK", "GUILE_MODULE_EXPORTS", "GUILE_MODULE_REQUIRED", "GUILE_MODULE_REQUIRED_EXPORT", "GUILE_PROGS", "GUILE_SITE_DIR", "hash", "hash", "hash-by-identity", "hash-clear!", "hash-create-handle!", "hash-fold", "hash-for-each", "hash-for-each-handle", "hash-get-handle", "hash-map->list", "hash-ref", "hash-remove!", "hash-set!", "hash-table->alist", "hash-table-delete!", "hash-table-equivalence-function", "hash-table-exists?", "hash-table-fold", "hash-table-hash-function", "hash-table-keys", "hash-table-ref", "hash-table-ref/default", "hash-table-set!", "hash-table-size", "hash-table-update!", "hash-table-update!/default", "hash-table-values", "hash-table-walk", "hash-table?", "hashq", "hashq-create-handle!", "hashq-get-handle", "hashq-ref", "hashq-remove!", "hashq-set!", "hashv", "hashv-create-handle!", "hashv-get-handle", "hashv-ref", "hashv-remove!", "hashv-set!", "hashx-create-handle!", "hashx-get-handle", "hashx-ref", "hashx-remove!", "hashx-set!", "hook->list", "hook-empty?", "hook?", "hostent:addr-list", "hostent:addrtype", "hostent:aliases", "hostent:length", "hostent:name", "htonl", "htons", "if", "imag-part", "inet-aton", "inet-lnaof", "inet-makeaddr", "inet-netof", "inet-ntoa", "inet-ntop", "inet-pton", "inexact->exact", "inexact?", "inf", "inf?", "info args", "info frame", "input-port?", "install-trap", "integer->char", "integer->list", "integer-expt", "integer-length", "integer?", "interaction-environment", "iota", "isatty?", "join-thread", "julian-day->date", "julian-day->time-monotonic", "julian-day->time-tai", "julian-day->time-utc", "key", "keyword->string", "keyword->symbol", "keyword?", "keyword?", "kill", "lambda", "lambda*", "last", "last-pair", "last-stack-frame", "lazy-catch", "lchown", "lcm", "length", "length+", "let", "let*", "let*-values", "let-keywords", "let-keywords*", "let-optional", "let-optional*", "let-values", "letpar", "letrec", "link", "list", "list->array", "list->bitvector", "list->c32vector", "list->c64vector", "list->char-set", "list->char-set!", "list->f32vector", "list->f64vector", "list->integer", "list->s16vector", "list->s32vector", "list->s64vector", "list->s8vector", "list->stream", "list->string", "list->typed-array", "list->u16vector", "list->u32vector", "list->u64vector", "list->u8vector", "list->vector", "list->weak-vector", "list-cdr-ref", "list-cdr-set!", "list-copy", "list-copy", "list-head", "list-index", "list-matches", "list-ref", "list-set!", "list-tabulate", "list-tail", "list-traps", "list=", "list?", "listen", "load", "load-extension", "load-from-path", "local-eval", "localtime", "lock-mutex", "log", "log10", "log2-binary-factors", "logand", "logbit?", "logcount", "logior", "lognot", "logtest", "logxor", "lset-adjoin", "lset-diff+intersection", "lset-diff+intersection!", "lset-difference", "lset-difference!", "lset-intersection", "lset-intersection!", "lset-union", "lset-union!", "lset-xor", "lset-xor!", "lset<=", "lset=", "lstat", "macro-name", "macro-transformer", "macro-type", "macro?", "magnitude", "main_prog", "major-version", "make-arbiter", "make-array", "make-bitvector", "make-buffered-input-port", "make-c32vector", "make-c64vector", "make-class-object", "make-completion-function", "make-compound-condition", "make-condition", "make-condition-type", "make-condition-variable", "make-date", "make-doubly-weak-hash-table", "make-dynamic-state", "make-f32vector", "make-f64vector", "make-fluid", "make-guardian", "make-hash-table", "make-hash-table", "make-hook", "make-line-buffered-input-port", "make-list", "make-mutex", "make-object-property", "make-parameter", "make-polar", "make-procedure-with-setter", "make-q", "make-record-type", "make-rectangular", "make-recursive-mutex", "make-regexp", "make-s16vector", "make-s32vector", "make-s64vector", "make-s8vector", "make-shared-array", "make-socket-address", "make-soft-port", "make-stack", "make-stream", "make-string", "make-struct", "make-struct-layout", "make-subclass-object", "make-symbol", "make-thread", "make-time", "make-typed-array", "make-u16vector", "make-u32vector", "make-u64vector", "make-u8vector", "make-undefined-variable", "make-variable", "make-vector", "make-vtable", "make-vtable-vtable", "make-weak-key-hash-table", "make-weak-value-hash-table", "make-weak-vector", "malloc-stats", "map", "map", "map!", "map-in-order", "match:count", "match:end", "match:prefix", "match:start", "match:string", "match:substring", "match:suffix", "max", "member", "member", "memoized-environment", "memoized?", "memq", "memv", "merge", "merge!", "message-condition?", "micro-version", "min", "minor-version", "mkdir", "mknod", "mkstemp!", "mktime", "modified-julian-day->date", "modified-julian-day->time-monotonic", "modified-julian-day->time-tai", "modified-julian-day->time-utc", "module-use!", "modulo", "modulo-expt", "monitor", "move->fdes", "n-for-each-par-map", "n-par-for-each", "n-par-map", "nan", "nan?", "negative?", "netent:addrtype", "netent:aliases", "netent:name", "netent:net", "newline", "next", "nftw", "ngettext", "nice", "nil-car", "nil-cdr", "nil-cons", "nil-eq", "ninth", "not", "not-pair?", "ntohl", "ntohs", "null", "null-environment", "null-list?", "null?", "number->string", "number?", "numerator", "object->string", "object-properties", "object-property", "odd?", "open", "open-fdes", "open-file", "open-input-file", "open-input-output-pipe", "open-input-pipe", "open-input-string", "open-output-file", "open-output-pipe", "open-output-string", "open-pipe", "open-pipe*", "opendir", "operator?", "option", "option-names", "option-optional-arg?", "option-processor", "option-ref", "option-required-arg?", "or", "output-port?", "pair-fold", "pair-fold-right", "pair-for-each", "pair?", "par-for-each", "par-map", "parallel", "parameterize", "parse-path", "partition", "partition!", "passwd:dir", "passwd:gecos", "passwd:gid", "passwd:name", "passwd:passwd", "passwd:shell", "passwd:uid", "pause", "pclose", "peek-char", "pipe", "PKG_CHECK_MODULES", "popen", "port->fdes", "port->stream", "port-closed?", "port-column", "port-filename", "port-for-each", "port-line", "port-mode", "port-mode", "port-revealed", "port-with-print-state", "port?", "position", "positive?", "pretty-print", "primitive-_exit", "primitive-eval", "primitive-exit", "primitive-fork", "primitive-load", "primitive-load-path", "primitive-make-property", "primitive-move->fdes", "primitive-property-del!", "primitive-property-ref", "primitive-property-set!", "print-disable", "print-enable", "print-options", "print-options-interface", "print-options-interface", "print-set!", "procedure", "procedure->macro", "procedure->memoizing-macro", "procedure->syntax", "procedure-documentation", "procedure-environment", "procedure-name", "procedure-properties", "procedure-property", "procedure-source", "procedure-with-setter?", "procedure?", "program-arguments", "promise?", "proper-list?", "protoent:aliases", "protoent:name", "protoent:proto", "provide", "provided?", "PTR2SCM", "putenv", "pwd", "q-empty-check", "q-empty?", "q-front", "q-length", "q-pop!", "q-push!", "q-rear", "q-remove!", "q?", "quasiquote", "quit", "quote", "quotient", "raise", "random", "random:exp", "random:hollow-sphere!", "random:normal", "random:normal-vector!", "random:solid-sphere!", "random:uniform", "rational?", "rationalize", "re-export", "read", "read-char", "read-delimited", "read-delimited!", "read-disable", "read-disable", "read-enable", "read-enable", "read-hash-extend", "read-line", "read-line!", "read-options", "read-options", "read-options-interface", "read-options-interface", "read-set!", "read-set!", "read-string!/partial", "readdir", "readline", "readline-disable", "readline-enable", "readline-options", "readline-port", "readline-set!", "readlink", "real-part", "real?", "rec", "receive", "record-accessor", "record-constructor", "record-modifier", "record-predicate", "record-type-descriptor", "record-type-fields", "record-type-name", "record?", "recv!", "recvfrom!", "redirect-port", "reduce", "reduce-right", "regexp-exec", "regexp-match?", "regexp-quote", "regexp-substitute", "regexp-substitute/global", "regexp?", "release-arbiter", "release-port-handle", "remainder", "remove", "remove!", "remove-hook!", "rename", "rename-file", "require", "require-extension", "reset-hook!", "resolve-interface", "resolve-module", "restore-signals", "restricted-vector-sort!", "reverse", "reverse!", "reverse-bit-field", "reverse-list->string", "rewinddir", "rmdir", "rotate-bit-field", "round", "run-asyncs", "run-hook", "s16vector", "s16vector->list", "s16vector-length", "s16vector-ref", "s16vector-set!", "s16vector?", "s32vector", "s32vector->list", "s32vector-length", "s32vector-ref", "s32vector-set!", "s32vector?", "s64vector", "s64vector->list", "s64vector-length", "s64vector-ref", "s64vector-set!", "s64vector?", "s8vector", "s8vector->list", "s8vector-length", "s8vector-ref", "s8vector-set!", "s8vector?", "save-module-excursion", "scheme-report-environment", "search-path", "second", "seed->random-state", "seek", "select", "send", "sendto", "serious-condition?", "servent:aliases", "servent:name", "servent:port", "servent:proto", "set-buffered-input-continuation?!", "set-car!", "set-cdr!", "set-current-dynamic-state", "set-current-error-port", "set-current-input-port", "set-current-module", "set-current-output-port", "set-object-procedure!", "set-object-properties!", "set-object-property!", "set-port-column!", "set-port-filename!", "set-port-line!", "set-port-revealed!", "set-procedure-properties!", "set-procedure-property!", "set-program-arguments", "set-readline-input-port!", "set-readline-output-port!", "set-readline-prompt!", "set-source-properties!", "set-source-property!", "set-struct-vtable-name!", "set-symbol-property!", "set-time-nanosecond!", "set-time-second!", "set-time-type!", "set-tm:gmtoff", "set-tm:hour", "set-tm:isdst", "set-tm:mday", "set-tm:min", "set-tm:mon", "set-tm:sec", "set-tm:wday", "set-tm:yday", "set-tm:year", "set-tm:zone", "set-trace-layout", "set!", "setegid", "setenv", "seteuid", "setgid", "setgr", "setgrent", "setgroups", "sethost", "sethostent", "sethostname", "setitimer", "setlocale", "setnet", "setnetent", "setpgid", "setpriority", "setproto", "setprotoent", "setpw", "setpwent", "setserv", "setservent", "setsid", "setsockopt", "setter", "setuid", "setvbuf", "seventh", "shared-array-increments", "shared-array-offset", "shared-array-root", "shutdown", "sigaction", "signal-condition-variable", "simple-format", "sin", "sinh", "sixth", "sleep", "sloppy-assoc", "sloppy-assq", "sloppy-assv", "sockaddr:addr", "sockaddr:fam", "sockaddr:flowinfo", "sockaddr:path", "sockaddr:port", "sockaddr:scopeid", "socket", "socketpair", "sort", "sort!", "sort-list", "sort-list!", "sorted?", "source-properties", "source-property", "span", "span!", "split-at", "split-at!", "sqrt", "stable-sort", "stable-sort!", "stack-id", "stack-length", "stack-ref", "stack?", "start-stack", "stat", "stat:atime", "stat:blksize", "stat:blocks", "stat:ctime", "stat:dev", "stat:gid", "stat:ino", "stat:mode", "stat:mtime", "stat:nlink", "stat:perms", "stat:rdev", "stat:size", "stat:type", "stat:uid", "status:exit-val", "status:stop-sig", "status:term-sig", "step", "stream->list", "stream->list&length", "stream->reversed-list", "stream->reversed-list&length", "stream->vector", "stream-car", "stream-cdr", "stream-fold", "stream-for-each", "stream-map", "stream-null?", "strerror", "strftime", "string", "string->char-set", "string->char-set!", "string->date", "string->keyword", "string->list", "string->number", "string->symbol", "string-any", "string-append", "string-append/shared", "string-capitalize", "string-capitalize!", "string-ci->symbol", "string-ci-hash", "string-ci<", "string-ci<=", "string-ci<=?", "string-ci<>", "string-ci<?", "string-ci=", "string-ci=?", "string-ci>", "string-ci>=", "string-ci>=?", "string-ci>?", "string-compare", "string-compare-ci", "string-concatenate", "string-concatenate-reverse", "string-concatenate-reverse/shared", "string-concatenate/shared", "string-contains", "string-contains-ci", "string-copy", "string-copy!", "string-count", "string-delete", "string-downcase", "string-downcase!", "string-drop", "string-drop-right", "string-every", "string-fill!", "string-filter", "string-fold", "string-fold-right", "string-for-each", "string-for-each-index", "string-hash", "string-hash", "string-hash-ci", "string-index", "string-index-right", "string-join", "string-length", "string-map", "string-map!", "string-match", "string-null?", "string-pad", "string-pad-right", "string-prefix-ci?", "string-prefix-length", "string-prefix-length-ci", "string-prefix?", "string-ref", "string-replace", "string-reverse", "string-reverse!", "string-rindex", "string-set!", "string-skip", "string-skip-right", "string-split", "string-suffix-ci?", "string-suffix-length", "string-suffix-length-ci", "string-suffix?", "string-tabulate", "string-take", "string-take-right", "string-titlecase", "string-titlecase!", "string-tokenize", "string-trim", "string-trim-both", "string-trim-right", "string-unfold", "string-unfold-right", "string-upcase", "string-upcase!", "string-xcopy!", "string<", "string<=", "string<=?", "string<>>", "string<?", "string=", "string=?", "string>", "string>=", "string>=?", "string>?", "string?", "strptime", "struct-ref", "struct-set!", "struct-vtable", "struct-vtable-name", "struct-vtable-tag", "struct-vtable?", "struct?", "substring", "substring-fill!", "substring-move!", "substring/copy", "substring/read-only", "substring/shared", "subtract-duration", "subtract-duration!", "symbol->keyword", "symbol->string", "symbol-fref", "symbol-fset!", "symbol-hash", "symbol-interned?", "symbol-pref", "symbol-prefix-proc", "symbol-property", "symbol-property-remove!", "symbol-pset!", "symbol?", "symlink", "sync", "sync-q!", "system", "system*", "system-async-mark", "system-error-errno", "take", "take!", "take-right", "take-while", "take-while!", "tan", "tanh", "tc:depth", "tc:frame", "tc:real-depth", "tc:return-value", "tc:stack", "tc:type", "tcgetpgrp", "tcsetpgrp", "tenth", "textdomain", "third", "thread-exited?", "throw", "thunk?", "time-difference", "time-difference!", "time-monotonic->date", "time-monotonic->time-tai", "time-monotonic->time-tai!", "time-monotonic->time-utc", "time-monotonic->time-utc!", "time-nanosecond", "time-resolution", "time-second", "time-tai->date", "time-tai->julian-day", "time-tai->modified-julian-day", "time-tai->time-monotonic", "time-tai->time-monotonic!", "time-tai->time-utc", "time-tai->time-utc!", "time-type", "time-utc->date", "time-utc->julian-day", "time-utc->modified-julian-day", "time-utc->time-monotonic", "time-utc->time-monotonic!", "time-utc->time-tai", "time-utc->time-tai!", "time<=?", "time<?", "time=?", "time>=?", "time>?", "time?", "times", "tm:gmtoff", "tm:hour", "tm:isdst", "tm:mday", "tm:min", "tm:mon", "tm:sec", "tm:wday", "tm:yday", "tm:year", "tm:zone", "tmpnam", "tms:clock", "tms:cstime", "tms:cutime", "tms:stime", "tms:utime", "trace", "trace-at-exit", "trace-port", "trace-trap", "trace-until-exit", "trace/info", "trace/pid", "trace/real?", "trace/source", "trace/source-column", "trace/source-file-name", "trace/source-line", "trace/stack", "trace/stack-depth", "trace/stack-id", "trace/stack-real-depth", "trace/type", "transpose-array", "trap-disable", "trap-disable", "trap-enable", "trap-enable", "trap-here", "trap-set!", "trap-set!", "traps", "traps", "truncate", "truncate", "truncate-file", "try-arbiter", "try-mutex", "ttyname", "typed-array?", "tzset", "u16vector", "u16vector->list", "u16vector-length", "u16vector-ref", "u16vector-set!", "u16vector?", "u32vector", "u32vector->list", "u32vector-length", "u32vector-ref", "u32vector-set!", "u32vector?", "u64vector", "u64vector->list", "u64vector-length", "u64vector-ref", "u64vector-set!", "u64vector?", "u8vector", "u8vector->list", "u8vector-length", "u8vector-ref", "u8vector-set!", "u8vector?", "ucs-range->char-set", "ucs-range->char-set!", "umask", "uname", "unfold", "unfold-right", "uniform-array-read!", "uniform-array-write", "uniform-vector->list", "uniform-vector-length", "uniform-vector-read!", "uniform-vector-ref", "uniform-vector-set!", "uniform-vector-write", "uniform-vector?", "uninstall-trap", "unlink", "unlock-mutex", "unmemoize", "unquote", "unquote-splicing", "unread-char", "unread-char", "unread-string", "unread-string", "unsetenv", "untrace", "unzip1", "unzip2", "unzip3", "unzip4", "unzip5", "up", "use-modules", "use-syntax", "usleep", "utime", "utsname:machine", "utsname:nodename", "utsname:release", "utsname:sysname", "utsname:version", "values", "variable-bound?", "variable-ref", "variable-set!", "variable?", "vector", "vector->list", "vector->stream", "vector-copy", "vector-fill!", "vector-length", "vector-move-left!", "vector-move-right!", "vector-ref", "vector-set!", "vector?", "version", "wait-condition-variable", "waitpid", "weak-key-hash-table?", "weak-value-hash-table?", "weak-vector", "weak-vector?", "where", "while", "with-continuation-barrier", "with-dynamic-state", "with-error-to-file", "with-fluid*", "with-fluids", "with-fluids*", "with-input-from-file", "with-input-from-string", "with-mutex", "with-output-to-file", "with-output-to-string", "with-parameters*", "with-readline-completion-function", "with-throw-handler", "with-traps", "write", "write-char", "write-line", "write-string/partial", "xcons", "xsubstring", "yield", "zero?", "zip", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, SEQ_REGEXP4, SEQ_REGEXP5, SEQ_REGEXP6, SEQ_REGEXP7, SEQ_REGEXP8, SEQ_REGEXP9, SEQ_REGEXP10, SEQ_REGEXP11, SEQ_REGEXP12, SEQ_REGEXP13, SEQ_REGEXP14, SEQ_REGEXP15, SEQ_REGEXP16, SEQ_REGEXP17, SEQ_REGEXP18, SEQ_REGEXP19, SEQ_REGEXP20, SEQ_REGEXP21, SEQ_REGEXP22, SEQ_REGEXP23, SEQ_REGEXP24, SEQ_REGEXP25, SEQ_REGEXP26, SEQ_REGEXP27, SEQ_REGEXP28, SEQ_REGEXP29, SEQ_REGEXP30, SEQ_REGEXP31, SEQ_REGEXP32, SEQ_REGEXP33, SEQ_REGEXP34, SEQ_REGEXP35, SEQ_REGEXP36, SEQ_REGEXP37, SEQ_REGEXP38, SEQ_REGEXP39, SEQ_REGEXP40, SEQ_REGEXP41, SEQ_REGEXP42, SEQ_REGEXP43, SEQ_REGEXP44, SEQ_REGEXP45, SEQ_REGEXP46, SEQ_REGEXP47, SEQ_REGEXP48, SEQ_REGEXP49, SEQ_REGEXP50, SEQ_REGEXP51, SEQ_REGEXP52, SEQ_REGEXP53, SEQ_REGEXP54, SEQ_REGEXP55, SEQ_REGEXP56, SEQ_REGEXP57, SEQ_REGEXP58, SEQ_REGEXP59, SEQ_REGEXP60, SEQ_REGEXP61, SEQ_REGEXP62, SEQ_REGEXP63, SEQ_REGEXP64, SEQ_REGEXP65, SEQ_REGEXP66, SEQ_REGEXP67, SEQ_REGEXP68, SEQ_REGEXP69, SEQ_REGEXP70, SEQ_REGEXP71, SEQ_REGEXP72, SEQ_REGEXP73, SEQ_REGEXP74, SEQ_REGEXP75, SEQ_REGEXP76, SEQ_REGEXP77, SEQ_REGEXP78, SEQ_REGEXP79, SEQ_REGEXP80, SEQ_REGEXP81, SEQ_REGEXP82, SEQ_REGEXP83, SEQ_REGEXP84, SEQ_REGEXP85, SEQ_REGEXP86, SEQ_REGEXP87, SEQ_REGEXP88, SEQ_REGEXP89, SEQ_REGEXP90, SEQ_REGEXP91, SEQ_REGEXP92, SEQ_REGEXP93, SEQ_REGEXP94, SEQ_REGEXP95, SEQ_REGEXP96, SEQ_REGEXP97, SEQ_REGEXP98, SEQ_REGEXP99, SEQ_REGEXP100, SEQ_REGEXP101, SEQ_REGEXP102, SEQ_REGEXP103, SEQ_REGEXP104, SEQ_REGEXP105, SEQ_REGEXP106, SEQ_REGEXP107, SEQ_REGEXP108, SEQ_REGEXP109, SEQ_REGEXP110, SEQ_REGEXP111, SEQ_REGEXP112, SEQ_REGEXP113, SEQ_REGEXP114, SEQ_REGEXP115, SEQ_REGEXP116, SEQ_REGEXP117, SEQ_REGEXP118, SEQ_REGEXP119, SEQ_REGEXP120, SEQ_REGEXP121, SEQ_REGEXP122, SEQ_REGEXP123, SEQ_REGEXP124, SEQ_REGEXP125, SEQ_REGEXP126, SEQ_REGEXP127, SEQ_REGEXP128, SEQ_REGEXP129, SEQ_REGEXP130, SEQ_REGEXP131, SEQ_REGEXP132, SEQ_REGEXP133, SEQ_REGEXP134, SEQ_REGEXP135, SEQ_REGEXP136, SEQ_REGEXP137, SEQ_REGEXP138, SEQ_REGEXP139, SEQ_REGEXP140, SEQ_REGEXP141, SEQ_REGEXP142, SEQ_REGEXP143, SEQ_REGEXP144, SEQ_REGEXP145, SEQ_REGEXP146, SEQ_REGEXP147, SEQ_REGEXP148, SEQ_REGEXP149, SEQ_REGEXP150, SEQ_REGEXP151, SEQ_REGEXP152, SEQ_REGEXP153, SEQ_REGEXP154, SEQ_REGEXP155, SEQ_REGEXP156, SEQ_REGEXP157, SEQ_REGEXP158, SEQ_REGEXP159, SEQ_REGEXP160, SEQ_REGEXP161, SEQ_REGEXP162, SEQ_REGEXP163, SEQ_REGEXP164, SEQ_REGEXP165, SEQ_REGEXP166, SEQ_REGEXP167, SEQ_REGEXP168, SEQ_REGEXP169, SEQ_REGEXP170, SEQ_REGEXP171, SEQ_REGEXP172, SEQ_REGEXP173, SEQ_REGEXP174, SEQ_REGEXP175, SEQ_REGEXP176, SEQ_REGEXP177, SEQ_REGEXP178, SEQ_REGEXP179, SEQ_REGEXP180, SEQ_REGEXP181, SEQ_REGEXP182, SEQ_REGEXP183, SEQ_REGEXP184, SEQ_REGEXP185, SEQ_REGEXP186, SEQ_REGEXP187, SEQ_REGEXP188, SEQ_REGEXP189, SEQ_REGEXP190, SEQ_REGEXP191, SEQ_REGEXP192, SEQ_REGEXP193, SEQ_REGEXP194, SEQ_REGEXP195, SEQ_REGEXP196, SEQ_REGEXP197, SEQ_REGEXP198, SEQ_REGEXP199, SEQ_REGEXP200, SEQ_REGEXP201, SEQ_REGEXP202, SEQ_REGEXP203, SEQ_REGEXP204, SEQ_REGEXP205, SEQ_REGEXP206, SEQ_REGEXP207, SEQ_REGEXP208, SEQ_REGEXP209, SEQ_REGEXP210, SEQ_REGEXP211, SEQ_REGEXP212, SEQ_REGEXP213, SEQ_REGEXP214, SEQ_REGEXP215, SEQ_REGEXP216, SEQ_REGEXP217, SEQ_REGEXP218, SEQ_REGEXP219, SEQ_REGEXP220, SEQ_REGEXP221, SEQ_REGEXP222, SEQ_REGEXP223, SEQ_REGEXP224, SEQ_REGEXP225, SEQ_REGEXP226, SEQ_REGEXP227, SEQ_REGEXP228, SEQ_REGEXP229, SEQ_REGEXP230, SEQ_REGEXP231, SEQ_REGEXP232, SEQ_REGEXP233, SEQ_REGEXP234, SEQ_REGEXP235, SEQ_REGEXP236, SEQ_REGEXP237, SEQ_REGEXP238, SEQ_REGEXP239, SEQ_REGEXP240, SEQ_REGEXP241, SEQ_REGEXP242, SEQ_REGEXP243, SEQ_REGEXP244, SEQ_REGEXP245, SEQ_REGEXP246, SEQ_REGEXP247, SEQ_REGEXP248, SEQ_REGEXP249, SEQ_REGEXP250, SEQ_REGEXP251, SEQ_REGEXP252, SEQ_REGEXP253, SEQ_REGEXP254, SEQ_REGEXP255, SEQ_REGEXP256, SEQ_REGEXP257, SEQ_REGEXP258, SEQ_REGEXP259, SEQ_REGEXP260, SEQ_REGEXP261, SEQ_REGEXP262, SEQ_REGEXP263, SEQ_REGEXP264, SEQ_REGEXP265, SEQ_REGEXP266, SEQ_REGEXP267, SEQ_REGEXP268, SEQ_REGEXP269, SEQ_REGEXP270, SEQ_REGEXP271, SEQ_REGEXP272, SEQ_REGEXP273, SEQ_REGEXP274, SEQ_REGEXP275, SEQ_REGEXP276, SEQ_REGEXP277, SEQ_REGEXP278, SEQ_REGEXP279, SEQ_REGEXP280, SEQ_REGEXP281, SEQ_REGEXP282, SEQ_REGEXP283, SEQ_REGEXP284, SEQ_REGEXP285, SEQ_REGEXP286, SEQ_REGEXP287, SEQ_REGEXP288, SEQ_REGEXP289, SEQ_REGEXP290, SEQ_REGEXP291, SEQ_REGEXP292, SEQ_REGEXP293, SEQ_REGEXP294, SEQ_REGEXP295, SEQ_REGEXP296, SEQ_REGEXP297, SEQ_REGEXP298, SEQ_REGEXP299, SEQ_REGEXP300, SEQ_REGEXP301, SEQ_REGEXP302, SEQ_REGEXP303, SEQ_REGEXP304, SEQ_REGEXP305, SEQ_REGEXP306, SEQ_REGEXP307, SEQ_REGEXP308, SEQ_REGEXP309, SEQ_REGEXP310, SEQ_REGEXP311, SEQ_REGEXP312, SEQ_REGEXP313, SEQ_REGEXP314, SEQ_REGEXP315, SEQ_REGEXP316, SEQ_REGEXP317, SEQ_REGEXP318, SEQ_REGEXP319, SEQ_REGEXP320, SEQ_REGEXP321, SEQ_REGEXP322, SEQ_REGEXP323, SEQ_REGEXP324, SEQ_REGEXP325, SEQ_REGEXP326, SEQ_REGEXP327, SEQ_REGEXP328, SEQ_REGEXP329, SEQ_REGEXP330, SEQ_REGEXP331, SEQ_REGEXP332, SEQ_REGEXP333, SEQ_REGEXP334, SEQ_REGEXP335, SEQ_REGEXP336, SEQ_REGEXP337, SEQ_REGEXP338, SEQ_REGEXP339, SEQ_REGEXP340, SEQ_REGEXP341, SEQ_REGEXP342, SEQ_REGEXP343, SEQ_REGEXP344, SEQ_REGEXP345, SEQ_REGEXP346, SEQ_REGEXP347, SEQ_REGEXP348, SEQ_REGEXP349, SEQ_REGEXP350, SEQ_REGEXP351, SEQ_REGEXP352, SEQ_REGEXP353, SEQ_REGEXP354, SEQ_REGEXP355, SEQ_REGEXP356, SEQ_REGEXP357, SEQ_REGEXP358, SEQ_REGEXP359, SEQ_REGEXP360, SEQ_REGEXP361, SEQ_REGEXP362, SEQ_REGEXP363, SEQ_REGEXP364, SEQ_REGEXP365, SEQ_REGEXP366, SEQ_REGEXP367, SEQ_REGEXP368, SEQ_REGEXP369, SEQ_REGEXP370, SEQ_REGEXP371, SEQ_REGEXP372, SEQ_REGEXP373, SEQ_REGEXP374, SEQ_REGEXP375, SEQ_REGEXP376, SEQ_REGEXP377, SEQ_REGEXP378, SEQ_REGEXP379, SEQ_REGEXP380, SEQ_REGEXP381, SEQ_REGEXP382, SEQ_REGEXP383, SEQ_REGEXP384, SEQ_REGEXP385, SEQ_REGEXP386, SEQ_REGEXP387, SEQ_REGEXP388, SEQ_REGEXP389, SEQ_REGEXP390, SEQ_REGEXP391, SEQ_REGEXP392, SEQ_REGEXP393, SEQ_REGEXP394, SEQ_REGEXP395, SEQ_REGEXP396, SEQ_REGEXP397, SEQ_REGEXP398, SEQ_REGEXP399, SEQ_REGEXP400, SEQ_REGEXP401, SEQ_REGEXP402, SEQ_REGEXP403, SEQ_REGEXP404, SEQ_REGEXP405, SEQ_REGEXP406, SEQ_REGEXP407, SEQ_REGEXP408, SEQ_REGEXP409, SEQ_REGEXP410, SEQ_REGEXP411, SEQ_REGEXP412, SEQ_REGEXP413, SEQ_REGEXP414, SEQ_REGEXP415, SEQ_REGEXP416, SEQ_REGEXP417, SEQ_REGEXP418, SEQ_REGEXP419, SEQ_REGEXP420, SEQ_REGEXP421, SEQ_REGEXP422, SEQ_REGEXP423, SEQ_REGEXP424, SEQ_REGEXP425, SEQ_REGEXP426, SEQ_REGEXP427, SEQ_REGEXP428, SEQ_REGEXP429, SEQ_REGEXP430, SEQ_REGEXP431, SEQ_REGEXP432, SEQ_REGEXP433, SEQ_REGEXP434, SEQ_REGEXP435, SEQ_REGEXP436, SEQ_REGEXP437, SEQ_REGEXP438, SEQ_REGEXP439, SEQ_REGEXP440, SEQ_REGEXP441, SEQ_REGEXP442, SEQ_REGEXP443, SEQ_REGEXP444, SEQ_REGEXP445, SEQ_REGEXP446, SEQ_REGEXP447, SEQ_REGEXP448, SEQ_REGEXP449, SEQ_REGEXP450, SEQ_REGEXP451, SEQ_REGEXP452, SEQ_REGEXP453, SEQ_REGEXP454, SEQ_REGEXP455, SEQ_REGEXP456, SEQ_REGEXP457, SEQ_REGEXP458, SEQ_REGEXP459, SEQ_REGEXP460, SEQ_REGEXP461, SEQ_REGEXP462, SEQ_REGEXP463, SEQ_REGEXP464, SEQ_REGEXP465, SEQ_REGEXP466, SEQ_REGEXP467, SEQ_REGEXP468, SEQ_REGEXP469, SEQ_REGEXP470, SEQ_REGEXP471, SEQ_REGEXP472, SEQ_REGEXP473, SEQ_REGEXP474, SEQ_REGEXP475, SEQ_REGEXP476, SEQ_REGEXP477, SEQ_REGEXP478, SEQ_REGEXP479, SEQ_REGEXP480, SEQ_REGEXP481, SEQ_REGEXP482, SEQ_REGEXP483, SEQ_REGEXP484, SEQ_REGEXP485, SEQ_REGEXP486, SEQ_REGEXP487, SEQ_REGEXP488, SEQ_REGEXP489, SEQ_REGEXP490, SEQ_REGEXP491, SEQ_REGEXP492, SEQ_REGEXP493, SEQ_REGEXP494, SEQ_REGEXP495, SEQ_REGEXP496, SEQ_REGEXP497, SEQ_REGEXP498, SEQ_REGEXP499, SEQ_REGEXP500, SEQ_REGEXP501, SEQ_REGEXP502, SEQ_REGEXP503, SEQ_REGEXP504, SEQ_REGEXP505, SEQ_REGEXP506, SEQ_REGEXP507, SEQ_REGEXP508, SEQ_REGEXP509, SEQ_REGEXP510, SEQ_REGEXP511, SEQ_REGEXP512, SEQ_REGEXP513, SEQ_REGEXP514, SEQ_REGEXP515, SEQ_REGEXP516, SEQ_REGEXP517, SEQ_REGEXP518, SEQ_REGEXP519, SEQ_REGEXP520, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, };

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
