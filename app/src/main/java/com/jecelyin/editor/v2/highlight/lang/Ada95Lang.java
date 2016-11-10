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
public class Ada95Lang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "--";
        PROPERTY1.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "--";
        EOL_SPAN1.TYPE = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = ")";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "(";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "..";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = ".all";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = ":=";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "/=";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "=>";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "=";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "<>";
        SEQ9.TYPE = "NULL";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "<<";
        SEQ10.TYPE = "LABEL";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = ">>";
        SEQ11.TYPE = "LABEL";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = ">=";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "<=";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = ">";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "<";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "&";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "+";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "-";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "/";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "**";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "*";
        SEQ21.TYPE = "OPERATOR";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "'access";
        SEQ22.TYPE = "KEYWORD3";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "'address";
        SEQ23.TYPE = "KEYWORD3";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "'adjacent";
        SEQ24.TYPE = "KEYWORD3";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "'aft";
        SEQ25.TYPE = "KEYWORD3";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = "'alignment";
        SEQ26.TYPE = "KEYWORD3";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "'base";
        SEQ27.TYPE = "KEYWORD3";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "'bit_order";
        SEQ28.TYPE = "KEYWORD3";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = "'body_version";
        SEQ29.TYPE = "KEYWORD3";
        SEQ SEQ30 = new SEQ();
        SEQ30.text = "'callable";
        SEQ30.TYPE = "KEYWORD3";
        SEQ SEQ31 = new SEQ();
        SEQ31.text = "'caller";
        SEQ31.TYPE = "KEYWORD3";
        SEQ SEQ32 = new SEQ();
        SEQ32.text = "'ceiling";
        SEQ32.TYPE = "KEYWORD3";
        SEQ SEQ33 = new SEQ();
        SEQ33.text = "'class";
        SEQ33.TYPE = "KEYWORD3";
        SEQ SEQ34 = new SEQ();
        SEQ34.text = "'component_size";
        SEQ34.TYPE = "KEYWORD3";
        SEQ SEQ35 = new SEQ();
        SEQ35.text = "'composed";
        SEQ35.TYPE = "KEYWORD3";
        SEQ SEQ36 = new SEQ();
        SEQ36.text = "'constrained";
        SEQ36.TYPE = "KEYWORD3";
        SEQ SEQ37 = new SEQ();
        SEQ37.text = "'copy_size";
        SEQ37.TYPE = "KEYWORD3";
        SEQ SEQ38 = new SEQ();
        SEQ38.text = "'count";
        SEQ38.TYPE = "KEYWORD3";
        SEQ SEQ39 = new SEQ();
        SEQ39.text = "'definite";
        SEQ39.TYPE = "KEYWORD3";
        SEQ SEQ40 = new SEQ();
        SEQ40.text = "'delta";
        SEQ40.TYPE = "KEYWORD3";
        SEQ SEQ41 = new SEQ();
        SEQ41.text = "'denorm";
        SEQ41.TYPE = "KEYWORD3";
        SEQ SEQ42 = new SEQ();
        SEQ42.text = "'digits";
        SEQ42.TYPE = "KEYWORD3";
        SEQ SEQ43 = new SEQ();
        SEQ43.text = "'exponent";
        SEQ43.TYPE = "KEYWORD3";
        SEQ SEQ44 = new SEQ();
        SEQ44.text = "'external_tag";
        SEQ44.TYPE = "KEYWORD3";
        SEQ SEQ45 = new SEQ();
        SEQ45.text = "'first";
        SEQ45.TYPE = "KEYWORD3";
        SEQ SEQ46 = new SEQ();
        SEQ46.text = "'first_bit";
        SEQ46.TYPE = "KEYWORD3";
        SEQ SEQ47 = new SEQ();
        SEQ47.text = "'floor";
        SEQ47.TYPE = "KEYWORD3";
        SEQ SEQ48 = new SEQ();
        SEQ48.text = "'fore";
        SEQ48.TYPE = "KEYWORD3";
        SEQ SEQ49 = new SEQ();
        SEQ49.text = "'fraction";
        SEQ49.TYPE = "KEYWORD3";
        SEQ SEQ50 = new SEQ();
        SEQ50.text = "'genetic";
        SEQ50.TYPE = "KEYWORD3";
        SEQ SEQ51 = new SEQ();
        SEQ51.text = "'identity";
        SEQ51.TYPE = "KEYWORD3";
        SEQ SEQ52 = new SEQ();
        SEQ52.text = "'image";
        SEQ52.TYPE = "KEYWORD3";
        SEQ SEQ53 = new SEQ();
        SEQ53.text = "'input";
        SEQ53.TYPE = "KEYWORD3";
        SEQ SEQ54 = new SEQ();
        SEQ54.text = "'last";
        SEQ54.TYPE = "KEYWORD3";
        SEQ SEQ55 = new SEQ();
        SEQ55.text = "'last_bit";
        SEQ55.TYPE = "KEYWORD3";
        SEQ SEQ56 = new SEQ();
        SEQ56.text = "'leading_part";
        SEQ56.TYPE = "KEYWORD3";
        SEQ SEQ57 = new SEQ();
        SEQ57.text = "'length";
        SEQ57.TYPE = "KEYWORD3";
        SEQ SEQ58 = new SEQ();
        SEQ58.text = "'machine";
        SEQ58.TYPE = "KEYWORD3";
        SEQ SEQ59 = new SEQ();
        SEQ59.text = "'machine_emax";
        SEQ59.TYPE = "KEYWORD3";
        SEQ SEQ60 = new SEQ();
        SEQ60.text = "'machine_emin";
        SEQ60.TYPE = "KEYWORD3";
        SEQ SEQ61 = new SEQ();
        SEQ61.text = "'machine_mantissa";
        SEQ61.TYPE = "KEYWORD3";
        SEQ SEQ62 = new SEQ();
        SEQ62.text = "'machine_overflows";
        SEQ62.TYPE = "KEYWORD3";
        SEQ SEQ63 = new SEQ();
        SEQ63.text = "'machine_radix";
        SEQ63.TYPE = "KEYWORD3";
        SEQ SEQ64 = new SEQ();
        SEQ64.text = "'machine_rounds";
        SEQ64.TYPE = "KEYWORD3";
        SEQ SEQ65 = new SEQ();
        SEQ65.text = "'max";
        SEQ65.TYPE = "KEYWORD3";
        SEQ SEQ66 = new SEQ();
        SEQ66.text = "'max_size_in_storage_elements";
        SEQ66.TYPE = "KEYWORD3";
        SEQ SEQ67 = new SEQ();
        SEQ67.text = "'min";
        SEQ67.TYPE = "KEYWORD3";
        SEQ SEQ68 = new SEQ();
        SEQ68.text = "'model";
        SEQ68.TYPE = "KEYWORD3";
        SEQ SEQ69 = new SEQ();
        SEQ69.text = "'model_emin";
        SEQ69.TYPE = "KEYWORD3";
        SEQ SEQ70 = new SEQ();
        SEQ70.text = "'model_epsilon";
        SEQ70.TYPE = "KEYWORD3";
        SEQ SEQ71 = new SEQ();
        SEQ71.text = "'model_mantissa";
        SEQ71.TYPE = "KEYWORD3";
        SEQ SEQ72 = new SEQ();
        SEQ72.text = "'model_small";
        SEQ72.TYPE = "KEYWORD3";
        SEQ SEQ73 = new SEQ();
        SEQ73.text = "'modulus";
        SEQ73.TYPE = "KEYWORD3";
        SEQ SEQ74 = new SEQ();
        SEQ74.text = "'output";
        SEQ74.TYPE = "KEYWORD3";
        SEQ SEQ75 = new SEQ();
        SEQ75.text = "'partition_id";
        SEQ75.TYPE = "KEYWORD3";
        SEQ SEQ76 = new SEQ();
        SEQ76.text = "'pos";
        SEQ76.TYPE = "KEYWORD3";
        SEQ SEQ77 = new SEQ();
        SEQ77.text = "'position";
        SEQ77.TYPE = "KEYWORD3";
        SEQ SEQ78 = new SEQ();
        SEQ78.text = "'pred";
        SEQ78.TYPE = "KEYWORD3";
        SEQ SEQ79 = new SEQ();
        SEQ79.text = "'range";
        SEQ79.TYPE = "KEYWORD3";
        SEQ SEQ80 = new SEQ();
        SEQ80.text = "'read";
        SEQ80.TYPE = "KEYWORD3";
        SEQ SEQ81 = new SEQ();
        SEQ81.text = "'remainder";
        SEQ81.TYPE = "KEYWORD3";
        SEQ SEQ82 = new SEQ();
        SEQ82.text = "'round";
        SEQ82.TYPE = "KEYWORD3";
        SEQ SEQ83 = new SEQ();
        SEQ83.text = "'rounding";
        SEQ83.TYPE = "KEYWORD3";
        SEQ SEQ84 = new SEQ();
        SEQ84.text = "'safe_first";
        SEQ84.TYPE = "KEYWORD3";
        SEQ SEQ85 = new SEQ();
        SEQ85.text = "'safe_last";
        SEQ85.TYPE = "KEYWORD3";
        SEQ SEQ86 = new SEQ();
        SEQ86.text = "'scale";
        SEQ86.TYPE = "KEYWORD3";
        SEQ SEQ87 = new SEQ();
        SEQ87.text = "'scaling";
        SEQ87.TYPE = "KEYWORD3";
        SEQ SEQ88 = new SEQ();
        SEQ88.text = "'signed_zeros";
        SEQ88.TYPE = "KEYWORD3";
        SEQ SEQ89 = new SEQ();
        SEQ89.text = "'size";
        SEQ89.TYPE = "KEYWORD3";
        SEQ SEQ90 = new SEQ();
        SEQ90.text = "'small";
        SEQ90.TYPE = "KEYWORD3";
        SEQ SEQ91 = new SEQ();
        SEQ91.text = "'storage_pool";
        SEQ91.TYPE = "KEYWORD3";
        SEQ SEQ92 = new SEQ();
        SEQ92.text = "'storage_size";
        SEQ92.TYPE = "KEYWORD3";
        SEQ SEQ93 = new SEQ();
        SEQ93.text = "'succ";
        SEQ93.TYPE = "KEYWORD3";
        SEQ SEQ94 = new SEQ();
        SEQ94.text = "'tag";
        SEQ94.TYPE = "KEYWORD3";
        SEQ SEQ95 = new SEQ();
        SEQ95.text = "'terminated";
        SEQ95.TYPE = "KEYWORD3";
        SEQ SEQ96 = new SEQ();
        SEQ96.text = "'truncation";
        SEQ96.TYPE = "KEYWORD3";
        SEQ SEQ97 = new SEQ();
        SEQ97.text = "'unbiased_rounding";
        SEQ97.TYPE = "KEYWORD3";
        SEQ SEQ98 = new SEQ();
        SEQ98.text = "'unchecked_access";
        SEQ98.TYPE = "KEYWORD3";
        SEQ SEQ99 = new SEQ();
        SEQ99.text = "'val";
        SEQ99.TYPE = "KEYWORD3";
        SEQ SEQ100 = new SEQ();
        SEQ100.text = "'valid";
        SEQ100.TYPE = "KEYWORD3";
        SEQ SEQ101 = new SEQ();
        SEQ101.text = "'value";
        SEQ101.TYPE = "KEYWORD3";
        SEQ SEQ102 = new SEQ();
        SEQ102.text = "'version";
        SEQ102.TYPE = "KEYWORD3";
        SEQ SEQ103 = new SEQ();
        SEQ103.text = "'wide_image";
        SEQ103.TYPE = "KEYWORD3";
        SEQ SEQ104 = new SEQ();
        SEQ104.text = "'wide_value";
        SEQ104.TYPE = "KEYWORD3";
        SEQ SEQ105 = new SEQ();
        SEQ105.text = "'wide_width";
        SEQ105.TYPE = "KEYWORD3";
        SEQ SEQ106 = new SEQ();
        SEQ106.text = "'width";
        SEQ106.TYPE = "KEYWORD3";
        SEQ SEQ107 = new SEQ();
        SEQ107.text = "'write";
        SEQ107.TYPE = "KEYWORD3";
        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"address", "boolean", "character", "duration", "float", "integer", "latin_1", "natural", "positive", "string", "time", });
        KEYWORDS1.add("LITERAL1", new String[]{"false", "null", "true", });
        KEYWORDS1.add("KEYWORD1", new String[]{"entry", "function", "procedure", });
        KEYWORDS1.add("KEYWORD2", new String[]{"abort", "abs", "abstract", "accept", "access", "aliased", "all", "and", "array", "at", "begin", "body", "case", "constant", "declare", "delay", "delta", "digits", "do", "else", "elsif", "end", "exception", "exit", "for", "goto", "if", "in", "is", "limited", "loop", "mod", "new", "not", "or", "others", "out", "package", "pragma", "private", "protected", "raise", "range", "record", "rem", "renames", "requeue", "return", "select", "separate", "string", "subtype", "tagged", "task", "terminate", "then", "type", "until", "use", "when", "while", "with", "xor", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, SEQ30, SEQ31, SEQ32, SEQ33, SEQ34, SEQ35, SEQ36, SEQ37, SEQ38, SEQ39, SEQ40, SEQ41, SEQ42, SEQ43, SEQ44, SEQ45, SEQ46, SEQ47, SEQ48, SEQ49, SEQ50, SEQ51, SEQ52, SEQ53, SEQ54, SEQ55, SEQ56, SEQ57, SEQ58, SEQ59, SEQ60, SEQ61, SEQ62, SEQ63, SEQ64, SEQ65, SEQ66, SEQ67, SEQ68, SEQ69, SEQ70, SEQ71, SEQ72, SEQ73, SEQ74, SEQ75, SEQ76, SEQ77, SEQ78, SEQ79, SEQ80, SEQ81, SEQ82, SEQ83, SEQ84, SEQ85, SEQ86, SEQ87, SEQ88, SEQ89, SEQ90, SEQ91, SEQ92, SEQ93, SEQ94, SEQ95, SEQ96, SEQ97, SEQ98, SEQ99, SEQ100, SEQ101, SEQ102, SEQ103, SEQ104, SEQ105, SEQ106, SEQ107, };

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
