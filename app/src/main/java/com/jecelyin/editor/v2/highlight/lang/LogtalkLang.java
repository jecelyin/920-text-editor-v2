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
public class LogtalkLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "%";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "/*";
        PROPERTY2.NAME = "commentStart";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "*/";
        PROPERTY3.NAME = "commentEnd";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "4";
        PROPERTY4.NAME = "tabSize";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "4";
        PROPERTY5.NAME = "indentSize";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "((^\\s*:-\\s(object|protocol|category)\\(.*,$)|.*\\s:-$)";
        PROPERTY6.NAME = "indentNextLine";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.SET = "MAIN";
        RULES1.IGNORE_CASE = "FALSE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "%";
        EOL_SPAN1.TYPE = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "^\\s*:-\\s(category|object|protocol)(?=[(])";
        SEQ_REGEXP1.AT_WORD_START = "TRUE";
        SEQ_REGEXP1.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "^\\s*:-\\send_(category|object|protocol)(?=[.])";
        SEQ_REGEXP2.AT_WORD_START = "TRUE";
        SEQ_REGEXP2.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "^\\s*:-\\smodule(?=[(])";
        SEQ_REGEXP3.AT_WORD_START = "TRUE";
        SEQ_REGEXP3.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP4 = new SEQ_REGEXP();
        SEQ_REGEXP4.text = "^\\s*:-\\sp(ublic|r(otected|ivate))(?=[(])";
        SEQ_REGEXP4.AT_WORD_START = "TRUE";
        SEQ_REGEXP4.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP5 = new SEQ_REGEXP();
        SEQ_REGEXP5.text = "^\\s*:-\\s(el)?if(?=[(])";
        SEQ_REGEXP5.AT_WORD_START = "TRUE";
        SEQ_REGEXP5.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP6 = new SEQ_REGEXP();
        SEQ_REGEXP6.text = "^\\s*:-\\se(lse|ndif)(?=[.])";
        SEQ_REGEXP6.AT_WORD_START = "TRUE";
        SEQ_REGEXP6.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP7 = new SEQ_REGEXP();
        SEQ_REGEXP7.text = "^\\s*:-\\se(n(coding|sure_loaded)|xport)(?=[(])";
        SEQ_REGEXP7.AT_WORD_START = "TRUE";
        SEQ_REGEXP7.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP8 = new SEQ_REGEXP();
        SEQ_REGEXP8.text = "^\\s*:-\\sin(fo|itialization)(?=[(])";
        SEQ_REGEXP8.AT_WORD_START = "TRUE";
        SEQ_REGEXP8.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP9 = new SEQ_REGEXP();
        SEQ_REGEXP9.text = "^\\s*:-\\s(dynamic|synchronized|threaded)(?=[.])";
        SEQ_REGEXP9.AT_WORD_START = "TRUE";
        SEQ_REGEXP9.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP10 = new SEQ_REGEXP();
        SEQ_REGEXP10.text = "^\\s*:-\\s(alias|d(ynamic|iscontiguous)|m(eta_predicate|ode|ultifile)|s(et_(logtalk|prolog)_flag|ynchronized))(?=[(])";
        SEQ_REGEXP10.AT_WORD_START = "TRUE";
        SEQ_REGEXP10.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP11 = new SEQ_REGEXP();
        SEQ_REGEXP11.text = "^\\s*:-\\sop(?=[(])";
        SEQ_REGEXP11.AT_WORD_START = "TRUE";
        SEQ_REGEXP11.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP12 = new SEQ_REGEXP();
        SEQ_REGEXP12.text = "^\\s*:-\\s(calls|reexport|use(s|_module))(?=[(])";
        SEQ_REGEXP12.AT_WORD_START = "TRUE";
        SEQ_REGEXP12.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP13 = new SEQ_REGEXP();
        SEQ_REGEXP13.text = "(complements|extends|i(nstantiates|mp(lements|orts))|specializes)(?=[(])";
        SEQ_REGEXP13.AT_WORD_START = "TRUE";
        SEQ_REGEXP13.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP14 = new SEQ_REGEXP();
        SEQ_REGEXP14.text = "\\b(after|before)(?=[(])";
        SEQ_REGEXP14.AT_WORD_START = "TRUE";
        SEQ_REGEXP14.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP15 = new SEQ_REGEXP();
        SEQ_REGEXP15.text = "\\b(parameter|this|se(lf|nder))(?=[(])";
        SEQ_REGEXP15.AT_WORD_START = "TRUE";
        SEQ_REGEXP15.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP16 = new SEQ_REGEXP();
        SEQ_REGEXP16.text = "\\b(current_predicate|predicate_property)(?=[(])";
        SEQ_REGEXP16.AT_WORD_START = "TRUE";
        SEQ_REGEXP16.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP17 = new SEQ_REGEXP();
        SEQ_REGEXP17.text = "\\b(expand_(goal|term)|(goal|term)_expansion|phrase)(?=[(])";
        SEQ_REGEXP17.AT_WORD_START = "TRUE";
        SEQ_REGEXP17.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP18 = new SEQ_REGEXP();
        SEQ_REGEXP18.text = "\\b(abolish|c(reate|urrent))_(object|protocol|category)(?=[(])";
        SEQ_REGEXP18.AT_WORD_START = "TRUE";
        SEQ_REGEXP18.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP19 = new SEQ_REGEXP();
        SEQ_REGEXP19.text = "\\b(object|protocol|category)_property(?=[(])";
        SEQ_REGEXP19.AT_WORD_START = "TRUE";
        SEQ_REGEXP19.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP20 = new SEQ_REGEXP();
        SEQ_REGEXP20.text = "\\bcomplements_object(?=[(])";
        SEQ_REGEXP20.AT_WORD_START = "TRUE";
        SEQ_REGEXP20.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP21 = new SEQ_REGEXP();
        SEQ_REGEXP21.text = "\\bextends_(object|protocol|category)(?=[(])";
        SEQ_REGEXP21.AT_WORD_START = "TRUE";
        SEQ_REGEXP21.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP22 = new SEQ_REGEXP();
        SEQ_REGEXP22.text = "\\bimp(lements_protocol|orts_category)(?=[(])";
        SEQ_REGEXP22.AT_WORD_START = "TRUE";
        SEQ_REGEXP22.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP23 = new SEQ_REGEXP();
        SEQ_REGEXP23.text = "\\b(instantiat|specializ)es_class(?=[(])";
        SEQ_REGEXP23.AT_WORD_START = "TRUE";
        SEQ_REGEXP23.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP24 = new SEQ_REGEXP();
        SEQ_REGEXP24.text = "\\b(current_event|(abolish|define)_events)(?=[(])";
        SEQ_REGEXP24.AT_WORD_START = "TRUE";
        SEQ_REGEXP24.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP25 = new SEQ_REGEXP();
        SEQ_REGEXP25.text = "\\b(current|set)_logtalk_flag(?=[(])";
        SEQ_REGEXP25.AT_WORD_START = "TRUE";
        SEQ_REGEXP25.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP26 = new SEQ_REGEXP();
        SEQ_REGEXP26.text = "\\blogtalk_(compile|l(ibrary_path|oad))(?=[(])";
        SEQ_REGEXP26.AT_WORD_START = "TRUE";
        SEQ_REGEXP26.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP27 = new SEQ_REGEXP();
        SEQ_REGEXP27.text = "\\b(clause|retract(all)?)(?=[(])";
        SEQ_REGEXP27.AT_WORD_START = "TRUE";
        SEQ_REGEXP27.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP28 = new SEQ_REGEXP();
        SEQ_REGEXP28.text = "\\ba(bolish|ssert(a|z))(?=[(])";
        SEQ_REGEXP28.AT_WORD_START = "TRUE";
        SEQ_REGEXP28.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP29 = new SEQ_REGEXP();
        SEQ_REGEXP29.text = "\\b(ca(ll|tch)|throw)(?=[(])";
        SEQ_REGEXP29.AT_WORD_START = "TRUE";
        SEQ_REGEXP29.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP30 = new SEQ_REGEXP();
        SEQ_REGEXP30.text = "\\b(fail|true)\\b";
        SEQ_REGEXP30.AT_WORD_START = "TRUE";
        SEQ_REGEXP30.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP31 = new SEQ_REGEXP();
        SEQ_REGEXP31.text = "\\b((bag|set)of|f(ind|or)all)(?=[(])";
        SEQ_REGEXP31.AT_WORD_START = "TRUE";
        SEQ_REGEXP31.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP32 = new SEQ_REGEXP();
        SEQ_REGEXP32.text = "\\bthreaded(_(call|once|ignore|exit|peek|wait|notify))?(?=[(])";
        SEQ_REGEXP32.AT_WORD_START = "TRUE";
        SEQ_REGEXP32.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP33 = new SEQ_REGEXP();
        SEQ_REGEXP33.text = "\\bunify_with_occurs_check(?=[(])";
        SEQ_REGEXP33.AT_WORD_START = "TRUE";
        SEQ_REGEXP33.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP34 = new SEQ_REGEXP();
        SEQ_REGEXP34.text = "\\b(functor|arg|copy_term)(?=[(])";
        SEQ_REGEXP34.AT_WORD_START = "TRUE";
        SEQ_REGEXP34.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP35 = new SEQ_REGEXP();
        SEQ_REGEXP35.text = "\\b(rem|mod|abs|sign)(?=[(])";
        SEQ_REGEXP35.AT_WORD_START = "TRUE";
        SEQ_REGEXP35.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP36 = new SEQ_REGEXP();
        SEQ_REGEXP36.text = "\\bfloat(_(integer|fractional)_part)?(?=[(])";
        SEQ_REGEXP36.AT_WORD_START = "TRUE";
        SEQ_REGEXP36.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP37 = new SEQ_REGEXP();
        SEQ_REGEXP37.text = "\\b(floor|truncate|round|ceiling)(?=[(])";
        SEQ_REGEXP37.AT_WORD_START = "TRUE";
        SEQ_REGEXP37.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP38 = new SEQ_REGEXP();
        SEQ_REGEXP38.text = "\\b(cos|atan|exp|log|s(in|qrt))(?=[(])";
        SEQ_REGEXP38.AT_WORD_START = "TRUE";
        SEQ_REGEXP38.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP39 = new SEQ_REGEXP();
        SEQ_REGEXP39.text = "\\b(var|atom(ic)?|integer|float|compound|n(onvar|umber))(?=[(])";
        SEQ_REGEXP39.AT_WORD_START = "TRUE";
        SEQ_REGEXP39.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP40 = new SEQ_REGEXP();
        SEQ_REGEXP40.text = "\\b(current|set)_(in|out)put(?=[(])";
        SEQ_REGEXP40.AT_WORD_START = "TRUE";
        SEQ_REGEXP40.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP41 = new SEQ_REGEXP();
        SEQ_REGEXP41.text = "\\b(open|close)(?=[(])";
        SEQ_REGEXP41.AT_WORD_START = "TRUE";
        SEQ_REGEXP41.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP42 = new SEQ_REGEXP();
        SEQ_REGEXP42.text = "\\bflush_output(?=[(])";
        SEQ_REGEXP42.AT_WORD_START = "TRUE";
        SEQ_REGEXP42.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP43 = new SEQ_REGEXP();
        SEQ_REGEXP43.text = "\\b(flush_output|at_end_of_stream)\\b";
        SEQ_REGEXP43.AT_WORD_START = "TRUE";
        SEQ_REGEXP43.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP44 = new SEQ_REGEXP();
        SEQ_REGEXP44.text = "\\b(stream_property|at_end_of_stream|set_stream_position)(?=[(])";
        SEQ_REGEXP44.AT_WORD_START = "TRUE";
        SEQ_REGEXP44.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP45 = new SEQ_REGEXP();
        SEQ_REGEXP45.text = "\\b(nl|(get|peek|put)_(byte|c(har|ode)))(?=[(])";
        SEQ_REGEXP45.AT_WORD_START = "TRUE";
        SEQ_REGEXP45.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP46 = new SEQ_REGEXP();
        SEQ_REGEXP46.text = "\\bnl\\b";
        SEQ_REGEXP46.AT_WORD_START = "TRUE";
        SEQ_REGEXP46.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP47 = new SEQ_REGEXP();
        SEQ_REGEXP47.text = "\\bread(_term)?(?=[(])";
        SEQ_REGEXP47.AT_WORD_START = "TRUE";
        SEQ_REGEXP47.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP48 = new SEQ_REGEXP();
        SEQ_REGEXP48.text = "\\bwrite(q|_(canonical|term))?(?=[(])";
        SEQ_REGEXP48.AT_WORD_START = "TRUE";
        SEQ_REGEXP48.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP49 = new SEQ_REGEXP();
        SEQ_REGEXP49.text = "\\b(current_)?op(?=[(])";
        SEQ_REGEXP49.AT_WORD_START = "TRUE";
        SEQ_REGEXP49.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP50 = new SEQ_REGEXP();
        SEQ_REGEXP50.text = "\\b(current_)?char_conversion(?=[(])";
        SEQ_REGEXP50.AT_WORD_START = "TRUE";
        SEQ_REGEXP50.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP51 = new SEQ_REGEXP();
        SEQ_REGEXP51.text = "\\batom_(length|c(hars|o(ncat|des)))(?=[(])";
        SEQ_REGEXP51.AT_WORD_START = "TRUE";
        SEQ_REGEXP51.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP52 = new SEQ_REGEXP();
        SEQ_REGEXP52.text = "\\b(char_code|sub_atom)(?=[(])";
        SEQ_REGEXP52.AT_WORD_START = "TRUE";
        SEQ_REGEXP52.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP53 = new SEQ_REGEXP();
        SEQ_REGEXP53.text = "\\bnumber_c(hars|odes)(?=[(])";
        SEQ_REGEXP53.AT_WORD_START = "TRUE";
        SEQ_REGEXP53.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP54 = new SEQ_REGEXP();
        SEQ_REGEXP54.text = "\\b(set|current)_prolog_flag(?=[(])";
        SEQ_REGEXP54.AT_WORD_START = "TRUE";
        SEQ_REGEXP54.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP55 = new SEQ_REGEXP();
        SEQ_REGEXP55.text = "\\bhalt\\b";
        SEQ_REGEXP55.AT_WORD_START = "TRUE";
        SEQ_REGEXP55.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP56 = new SEQ_REGEXP();
        SEQ_REGEXP56.text = "\\bhalt(?=[(])";
        SEQ_REGEXP56.AT_WORD_START = "TRUE";
        SEQ_REGEXP56.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP57 = new SEQ_REGEXP();
        SEQ_REGEXP57.text = "\\bonce(?=[(])";
        SEQ_REGEXP57.AT_WORD_START = "TRUE";
        SEQ_REGEXP57.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP58 = new SEQ_REGEXP();
        SEQ_REGEXP58.text = "\\brepeat\\b";
        SEQ_REGEXP58.AT_WORD_START = "TRUE";
        SEQ_REGEXP58.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP59 = new SEQ_REGEXP();
        SEQ_REGEXP59.text = "[_A-Z]+[a-zA-Z0-9]*";
        SEQ_REGEXP59.HASH_CHARS = "_ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SEQ_REGEXP59.AT_WORD_START = "TRUE";
        SEQ_REGEXP59.TYPE = "MARKUP";
        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "TRUE";
        SPAN3.TYPE = "LITERAL1";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "\"";
        END END3 = new END();
        END3.text = "\"";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "OPERATOR";
        SPAN4.DELEGATE = "MAIN";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "{";
        END END4 = new END();
        END4.text = "}";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SEQ_REGEXP SEQ_REGEXP60 = new SEQ_REGEXP();
        SEQ_REGEXP60.text = "0'.";
        SEQ_REGEXP60.AT_WORD_START = "TRUE";
        SEQ_REGEXP60.TYPE = "DIGIT";
        SEQ_REGEXP60.HASH_CHAR = "0";
        SEQ_REGEXP SEQ_REGEXP61 = new SEQ_REGEXP();
        SEQ_REGEXP61.text = "0b[0-1]+";
        SEQ_REGEXP61.AT_WORD_START = "TRUE";
        SEQ_REGEXP61.TYPE = "DIGIT";
        SEQ_REGEXP61.HASH_CHAR = "0";
        SEQ_REGEXP SEQ_REGEXP62 = new SEQ_REGEXP();
        SEQ_REGEXP62.text = "0o[0-7]+";
        SEQ_REGEXP62.AT_WORD_START = "TRUE";
        SEQ_REGEXP62.TYPE = "DIGIT";
        SEQ_REGEXP62.HASH_CHAR = "0";
        SEQ_REGEXP SEQ_REGEXP63 = new SEQ_REGEXP();
        SEQ_REGEXP63.text = "0x\\p{XDigit}+";
        SEQ_REGEXP63.AT_WORD_START = "TRUE";
        SEQ_REGEXP63.TYPE = "DIGIT";
        SEQ_REGEXP63.HASH_CHAR = "0";
        SEQ_REGEXP SEQ_REGEXP64 = new SEQ_REGEXP();
        SEQ_REGEXP64.text = "\\d+(\\.\\d+)?([eE]([-+])?\\d+)?";
        SEQ_REGEXP64.AT_WORD_START = "TRUE";
        SEQ_REGEXP64.TYPE = "DIGIT";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "::";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "^^";
        SEQ2.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP65 = new SEQ_REGEXP();
        SEQ_REGEXP65.text = ":(?![:-])";
        SEQ_REGEXP65.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "!";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = ",";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = ";";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "-->";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "->";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "=";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "\\=";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "@=<";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "==";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "\\==";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "@<";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "@>";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "@>=";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "=..";
        SEQ16.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP66 = new SEQ_REGEXP();
        SEQ_REGEXP66.text = "\\bis\\b";
        SEQ_REGEXP66.AT_WORD_START = "TRUE";
        SEQ_REGEXP66.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "=:=";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "=\\=";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "<";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "=<";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = ">";
        SEQ21.TYPE = "OPERATOR";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = ">=";
        SEQ22.TYPE = "OPERATOR";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "\\+";
        SEQ23.TYPE = "OPERATOR";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "+";
        SEQ24.TYPE = "OPERATOR";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "-";
        SEQ25.TYPE = "OPERATOR";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = "*";
        SEQ26.TYPE = "OPERATOR";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "//";
        SEQ27.TYPE = "OPERATOR";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "/";
        SEQ28.TYPE = "OPERATOR";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = "**";
        SEQ29.TYPE = "OPERATOR";
        SEQ SEQ30 = new SEQ();
        SEQ30.text = ">>";
        SEQ30.TYPE = "OPERATOR";
        SEQ SEQ31 = new SEQ();
        SEQ31.text = "<<";
        SEQ31.TYPE = "OPERATOR";
        SEQ SEQ32 = new SEQ();
        SEQ32.text = "/\\";
        SEQ32.TYPE = "OPERATOR";
        SEQ SEQ33 = new SEQ();
        SEQ33.text = "\\/";
        SEQ33.TYPE = "OPERATOR";
        SEQ SEQ34 = new SEQ();
        SEQ34.text = "\\";
        SEQ34.TYPE = "OPERATOR";
        SEQ SEQ35 = new SEQ();
        SEQ35.text = ".";
        SEQ35.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP67 = new SEQ_REGEXP();
        SEQ_REGEXP67.text = "\\s:-($|\\s)";
        SEQ_REGEXP67.TYPE = "OPERATOR";
        SEQ SEQ36 = new SEQ();
        SEQ36.text = "+";
        SEQ36.TYPE = "OPERATOR";
        SEQ SEQ37 = new SEQ();
        SEQ37.text = "-";
        SEQ37.TYPE = "OPERATOR";
        SEQ SEQ38 = new SEQ();
        SEQ38.text = "?";
        SEQ38.TYPE = "OPERATOR";
        SEQ SEQ39 = new SEQ();
        SEQ39.text = "@";
        SEQ39.TYPE = "OPERATOR";
        SEQ SEQ40 = new SEQ();
        SEQ40.text = "^";
        SEQ40.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("NULL", new String[]{"abolish", "abolish_category", "abolish_events", "abolish_object", "abolish_protocol", "after", "alias", "arg", "asserta", "assertz", "atom", "atomic", "atom_chars", "atom_codes", "atom_concat", "atom_length", "at_end_of_stream", "bagof", "before", "call", "calls", "catch", "category", "category_property", "char_code", "char_conversion", "clause", "close", "complements", "complements_object", "compound", "copy_term", "create_category", "create_object", "create_protocol", "current_category", "current_char_conversion", "current_event", "current_input", "current_logtalk_flag", "current_object", "current_op", "current_output", "current_predicate", "current_prolog_flag", "current_protocol", "define_events", "discontiguous", "dynamic", "encoding", "end_category", "end_object", "end_protocol", "expand_term", "extends", "extends_object", "extends_protocol", "extends_category", "fail", "findall", "float", "flush_output", "forall", "functor", "get_byte", "get_char", "get_code", "halt", "implements", "implements_protocol", "imports", "imports_category", "info", "initialization", "instantiates", "instantiates_class", "integer", "logtalk_compile", "logtalk_library_path", "logtalk_load", "meta_predicate", "mode", "nl", "nonvar", "number", "number_chars", "number_codes", "object", "object_property", "once", "op", "open", "parameter", "peek_byte", "peek_char", "peek_code", "phrase", "predicate_property", "private", "protected", "protocol", "protocol_property", "public", "put_byte", "put_char", "put_code", "read", "read_term", "repeat", "retract", "retractall", "self", "sender", "setof", "set_input", "set_logtalk_flag", "set_output", "set_prolog_flag", "set_stream_position", "specializes", "specializes_class", "stream_property", "sub_atom", "synchronized", "goal_expansion", "term_expansion", "this", "threaded", "threaded_call", "threaded_once", "threaded_ignore", "threaded_exit", "threaded_peek", "threaded_wait", "threaded_notify", "throw", "true", "unify_with_occurs_check", "uses", "var", "write", "writeq", "write_canonical", "abs", "atan", "ceiling", "cos", "exp", "float_fractional_part", "float_integer_part", "floor", "log", "mod", "rem", "round", "sign", "sin", "sqrt", "truncate", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, SEQ_REGEXP4, SEQ_REGEXP5, SEQ_REGEXP6, SEQ_REGEXP7, SEQ_REGEXP8, SEQ_REGEXP9, SEQ_REGEXP10, SEQ_REGEXP11, SEQ_REGEXP12, SEQ_REGEXP13, SEQ_REGEXP14, SEQ_REGEXP15, SEQ_REGEXP16, SEQ_REGEXP17, SEQ_REGEXP18, SEQ_REGEXP19, SEQ_REGEXP20, SEQ_REGEXP21, SEQ_REGEXP22, SEQ_REGEXP23, SEQ_REGEXP24, SEQ_REGEXP25, SEQ_REGEXP26, SEQ_REGEXP27, SEQ_REGEXP28, SEQ_REGEXP29, SEQ_REGEXP30, SEQ_REGEXP31, SEQ_REGEXP32, SEQ_REGEXP33, SEQ_REGEXP34, SEQ_REGEXP35, SEQ_REGEXP36, SEQ_REGEXP37, SEQ_REGEXP38, SEQ_REGEXP39, SEQ_REGEXP40, SEQ_REGEXP41, SEQ_REGEXP42, SEQ_REGEXP43, SEQ_REGEXP44, SEQ_REGEXP45, SEQ_REGEXP46, SEQ_REGEXP47, SEQ_REGEXP48, SEQ_REGEXP49, SEQ_REGEXP50, SEQ_REGEXP51, SEQ_REGEXP52, SEQ_REGEXP53, SEQ_REGEXP54, SEQ_REGEXP55, SEQ_REGEXP56, SEQ_REGEXP57, SEQ_REGEXP58, SEQ_REGEXP59, SEQ_REGEXP60, SEQ_REGEXP61, SEQ_REGEXP62, SEQ_REGEXP63, SEQ_REGEXP64, SEQ_REGEXP65, SEQ_REGEXP66, SEQ_REGEXP67, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, SEQ30, SEQ31, SEQ32, SEQ33, SEQ34, SEQ35, SEQ36, SEQ37, SEQ38, SEQ39, SEQ40, };

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
