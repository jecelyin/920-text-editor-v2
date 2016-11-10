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
public class HaskellLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "{-";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "-}";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "--";
        PROPERTY3.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "FALSE";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT2";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "{-#";
        END END1 = new END();
        END1.text = "#-}";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "COMMENT1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "{-";
        END END2 = new END();
        END2.text = "-}";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "--";
        EOL_SPAN1.TYPE = "COMMENT1";
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
        SPAN4.NO_WORD_BREAK = "TRUE";
        SPAN4.TYPE = "LITERAL2";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "'";
        END END4 = new END();
        END4.text = "'";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "case(?![a-z_A-Z0-9'])";
        SEQ_REGEXP1.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "class(?![a-z_A-Z0-9'])";
        SEQ_REGEXP2.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "data(?![a-z_A-Z0-9'])";
        SEQ_REGEXP3.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP4 = new SEQ_REGEXP();
        SEQ_REGEXP4.text = "default(?![a-z_A-Z0-9'])";
        SEQ_REGEXP4.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP5 = new SEQ_REGEXP();
        SEQ_REGEXP5.text = "deriving(?![a-z_A-Z0-9'])";
        SEQ_REGEXP5.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP6 = new SEQ_REGEXP();
        SEQ_REGEXP6.text = "do(?![a-z_A-Z0-9'])";
        SEQ_REGEXP6.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP7 = new SEQ_REGEXP();
        SEQ_REGEXP7.text = "else(?![a-z_A-Z0-9'])";
        SEQ_REGEXP7.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP8 = new SEQ_REGEXP();
        SEQ_REGEXP8.text = "if(?![a-z_A-Z0-9'])";
        SEQ_REGEXP8.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP9 = new SEQ_REGEXP();
        SEQ_REGEXP9.text = "import(?![a-z_A-Z0-9'])";
        SEQ_REGEXP9.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP10 = new SEQ_REGEXP();
        SEQ_REGEXP10.text = "in(?![a-z_A-Z0-9'])";
        SEQ_REGEXP10.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP11 = new SEQ_REGEXP();
        SEQ_REGEXP11.text = "infix(?![a-z_A-Z0-9'])";
        SEQ_REGEXP11.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP12 = new SEQ_REGEXP();
        SEQ_REGEXP12.text = "infixl(?![a-z_A-Z0-9'])";
        SEQ_REGEXP12.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP13 = new SEQ_REGEXP();
        SEQ_REGEXP13.text = "infixr(?![a-z_A-Z0-9'])";
        SEQ_REGEXP13.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP14 = new SEQ_REGEXP();
        SEQ_REGEXP14.text = "instance(?![a-z_A-Z0-9'])";
        SEQ_REGEXP14.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP15 = new SEQ_REGEXP();
        SEQ_REGEXP15.text = "let(?![a-z_A-Z0-9'])";
        SEQ_REGEXP15.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP16 = new SEQ_REGEXP();
        SEQ_REGEXP16.text = "module(?![a-z_A-Z0-9'])";
        SEQ_REGEXP16.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP17 = new SEQ_REGEXP();
        SEQ_REGEXP17.text = "newtype(?![a-z_A-Z0-9'])";
        SEQ_REGEXP17.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP18 = new SEQ_REGEXP();
        SEQ_REGEXP18.text = "of(?![a-z_A-Z0-9'])";
        SEQ_REGEXP18.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP19 = new SEQ_REGEXP();
        SEQ_REGEXP19.text = "then(?![a-z_A-Z0-9'])";
        SEQ_REGEXP19.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP20 = new SEQ_REGEXP();
        SEQ_REGEXP20.text = "type(?![a-z_A-Z0-9'])";
        SEQ_REGEXP20.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP21 = new SEQ_REGEXP();
        SEQ_REGEXP21.text = "where(?![a-z_A-Z0-9'])";
        SEQ_REGEXP21.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP22 = new SEQ_REGEXP();
        SEQ_REGEXP22.text = "_(?![a-z_A-Z0-9'])";
        SEQ_REGEXP22.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP23 = new SEQ_REGEXP();
        SEQ_REGEXP23.text = "as(?![a-z_A-Z0-9'])";
        SEQ_REGEXP23.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP24 = new SEQ_REGEXP();
        SEQ_REGEXP24.text = "qualified(?![a-z_A-Z0-9'])";
        SEQ_REGEXP24.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP25 = new SEQ_REGEXP();
        SEQ_REGEXP25.text = "hiding(?![a-z_A-Z0-9'])";
        SEQ_REGEXP25.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP26 = new SEQ_REGEXP();
        SEQ_REGEXP26.text = "foreign(?![a-z_A-Z0-9'])";
        SEQ_REGEXP26.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP27 = new SEQ_REGEXP();
        SEQ_REGEXP27.text = "family(?![a-z_A-Z0-9'])";
        SEQ_REGEXP27.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP28 = new SEQ_REGEXP();
        SEQ_REGEXP28.text = "proc(?![a-z_A-Z0-9'])";
        SEQ_REGEXP28.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP29 = new SEQ_REGEXP();
        SEQ_REGEXP29.text = "rec(?![a-z_A-Z0-9'])";
        SEQ_REGEXP29.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP30 = new SEQ_REGEXP();
        SEQ_REGEXP30.text = "mdo(?![a-z_A-Z0-9'])";
        SEQ_REGEXP30.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP31 = new SEQ_REGEXP();
        SEQ_REGEXP31.text = "0[xXoO][0-9a-fA-F]+";
        SEQ_REGEXP31.TYPE = "DIGIT";
        SEQ_REGEXP SEQ_REGEXP32 = new SEQ_REGEXP();
        SEQ_REGEXP32.text = "[0-9]+(\\.[0-9]+)?([eE][+-]?[0-9]+)?";
        SEQ_REGEXP32.TYPE = "DIGIT";
        SEQ_REGEXP SEQ_REGEXP33 = new SEQ_REGEXP();
        SEQ_REGEXP33.text = "\\.\\.(?![!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:])";
        SEQ_REGEXP33.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP34 = new SEQ_REGEXP();
        SEQ_REGEXP34.text = ":(?![!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:])";
        SEQ_REGEXP34.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP35 = new SEQ_REGEXP();
        SEQ_REGEXP35.text = "::(?![!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:])";
        SEQ_REGEXP35.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP36 = new SEQ_REGEXP();
        SEQ_REGEXP36.text = "=(?![!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:])";
        SEQ_REGEXP36.TYPE = "KEYWORD4";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "\\";
        SEQ1.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP37 = new SEQ_REGEXP();
        SEQ_REGEXP37.text = "\\|(?![!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:])";
        SEQ_REGEXP37.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP38 = new SEQ_REGEXP();
        SEQ_REGEXP38.text = "<-(?![!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:])";
        SEQ_REGEXP38.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP39 = new SEQ_REGEXP();
        SEQ_REGEXP39.text = "->(?![!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:])";
        SEQ_REGEXP39.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP40 = new SEQ_REGEXP();
        SEQ_REGEXP40.text = "@(?![!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:])";
        SEQ_REGEXP40.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP41 = new SEQ_REGEXP();
        SEQ_REGEXP41.text = "~(?![!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:])";
        SEQ_REGEXP41.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP42 = new SEQ_REGEXP();
        SEQ_REGEXP42.text = "=>(?![!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:])";
        SEQ_REGEXP42.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP43 = new SEQ_REGEXP();
        SEQ_REGEXP43.text = "-(<{1,2})(?![!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:])";
        SEQ_REGEXP43.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP44 = new SEQ_REGEXP();
        SEQ_REGEXP44.text = "([A-Z][a-z_A-Z0-9']*\\.)*[!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~][!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:]*";
        SEQ_REGEXP44.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP45 = new SEQ_REGEXP();
        SEQ_REGEXP45.text = "`([A-Z][a-z_A-Z0-9']*\\.)*[a-z_][a-z_A-Z0-9']*`";
        SEQ_REGEXP45.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP46 = new SEQ_REGEXP();
        SEQ_REGEXP46.text = "([A-Z][a-z_A-Z0-9']*\\.)*[a-z_][a-z_A-Z0-9']*";
        SEQ_REGEXP46.TYPE = "NULL";
        SEQ_REGEXP SEQ_REGEXP47 = new SEQ_REGEXP();
        SEQ_REGEXP47.text = "[A-Z][a-z_A-Z0-9']*(\\.[A-Z][a-z_A-Z0-9']*)*";
        SEQ_REGEXP47.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP48 = new SEQ_REGEXP();
        SEQ_REGEXP48.text = "\\(\\s*([A-Z][a-z_A-Z0-9']*\\.)*[!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~]\\s*\\)";
        SEQ_REGEXP48.TYPE = "NULL";
        SEQ_REGEXP SEQ_REGEXP49 = new SEQ_REGEXP();
        SEQ_REGEXP49.text = "\\(\\s*([A-Z][a-z_A-Z0-9']*\\.)*[!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~][!#$%&\\*+/<=>?@\\\\\\^\\|\\-~:][!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:]*\\s*\\)";
        SEQ_REGEXP49.TYPE = "NULL";
        SEQ_REGEXP SEQ_REGEXP50 = new SEQ_REGEXP();
        SEQ_REGEXP50.text = "\\(\\s*([A-Z][a-z_A-Z0-9']*\\.)*[!#$%&\\*+/<=>?@\\\\\\^\\|\\-~][!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:][!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:]*\\s*\\)";
        SEQ_REGEXP50.TYPE = "NULL";
        SEQ_REGEXP SEQ_REGEXP51 = new SEQ_REGEXP();
        SEQ_REGEXP51.text = "\\(\\s*([A-Z][a-z_A-Z0-9']*\\.)*[!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~][!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:]{2,}\\)";
        SEQ_REGEXP51.TYPE = "NULL";
        SEQ_REGEXP SEQ_REGEXP52 = new SEQ_REGEXP();
        SEQ_REGEXP52.text = "([A-Z][a-z_A-Z0-9']*\\.)*:[!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:]*";
        SEQ_REGEXP52.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP53 = new SEQ_REGEXP();
        SEQ_REGEXP53.text = "\\(\\s*([A-Z][a-z_A-Z0-9']*\\.)*:[!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:]*\\s*\\)";
        SEQ_REGEXP53.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP54 = new SEQ_REGEXP();
        SEQ_REGEXP54.text = "\\((?!\\s*([!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~]\\s*\\)|[!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~][!#$%&\\*+/<=>?@\\\\\\^\\|\\-~:][!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:]*\\s*\\)|[!#$%&\\*+/<=>?@\\\\\\^\\|\\-~][!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:][!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:]*\\s*\\)|[!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~][!#$%&\\*+\\./<=>?@\\\\\\^\\|\\-~:]{2,}\\s*\\)))";
        SEQ_REGEXP54.TYPE = "KEYWORD3";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ")";
        SEQ2.TYPE = "KEYWORD3";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = ",";
        SEQ3.TYPE = "KEYWORD3";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "[";
        SEQ4.TYPE = "KEYWORD3";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "]";
        SEQ5.TYPE = "KEYWORD3";
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, SEQ_REGEXP4, SEQ_REGEXP5, SEQ_REGEXP6, SEQ_REGEXP7, SEQ_REGEXP8, SEQ_REGEXP9, SEQ_REGEXP10, SEQ_REGEXP11, SEQ_REGEXP12, SEQ_REGEXP13, SEQ_REGEXP14, SEQ_REGEXP15, SEQ_REGEXP16, SEQ_REGEXP17, SEQ_REGEXP18, SEQ_REGEXP19, SEQ_REGEXP20, SEQ_REGEXP21, SEQ_REGEXP22, SEQ_REGEXP23, SEQ_REGEXP24, SEQ_REGEXP25, SEQ_REGEXP26, SEQ_REGEXP27, SEQ_REGEXP28, SEQ_REGEXP29, SEQ_REGEXP30, SEQ_REGEXP31, SEQ_REGEXP32, SEQ_REGEXP33, SEQ_REGEXP34, SEQ_REGEXP35, SEQ_REGEXP36, SEQ_REGEXP37, SEQ_REGEXP38, SEQ_REGEXP39, SEQ_REGEXP40, SEQ_REGEXP41, SEQ_REGEXP42, SEQ_REGEXP43, SEQ_REGEXP44, SEQ_REGEXP45, SEQ_REGEXP46, SEQ_REGEXP47, SEQ_REGEXP48, SEQ_REGEXP49, SEQ_REGEXP50, SEQ_REGEXP51, SEQ_REGEXP52, SEQ_REGEXP53, SEQ_REGEXP54, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
