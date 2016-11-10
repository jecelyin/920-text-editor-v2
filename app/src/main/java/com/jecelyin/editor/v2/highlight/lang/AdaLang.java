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
public class AdaLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "--";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = ".*(begin|declare|do|else|elsif|exception|generic|is|loop|private|record|select|tagged|then|with|=>|:=)\\s*(--.*)?$";
        PROPERTY2.NAME = "indentNextLines";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "^\\s*end\\b.*;";
        PROPERTY3.NAME = "unindentThisLine";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "^\\s*end\\b.*;";
        PROPERTY4.NAME = "unindentNextLines";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = ";";
        PROPERTY5.NAME = "electricKeys";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "--#";
        EOL_SPAN1.TYPE = "COMMENT2";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "--";
        EOL_SPAN2.TYPE = "COMMENT1";
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
        SEQ35.text = "'compose";
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
        SEQ50.text = "'has_same_storage";
        SEQ50.TYPE = "KEYWORD3";
        SEQ SEQ51 = new SEQ();
        SEQ51.text = "'identity";
        SEQ51.TYPE = "KEYWORD3";
        SEQ SEQ52 = new SEQ();
        SEQ52.text = "'image";
        SEQ52.TYPE = "KEYWORD3";
        SEQ SEQ53 = new SEQ();
        SEQ53.text = "'class'input";
        SEQ53.TYPE = "KEYWORD3";
        SEQ SEQ54 = new SEQ();
        SEQ54.text = "'input";
        SEQ54.TYPE = "KEYWORD3";
        SEQ SEQ55 = new SEQ();
        SEQ55.text = "'last";
        SEQ55.TYPE = "KEYWORD3";
        SEQ SEQ56 = new SEQ();
        SEQ56.text = "'last_bit";
        SEQ56.TYPE = "KEYWORD3";
        SEQ SEQ57 = new SEQ();
        SEQ57.text = "'leading_part";
        SEQ57.TYPE = "KEYWORD3";
        SEQ SEQ58 = new SEQ();
        SEQ58.text = "'length";
        SEQ58.TYPE = "KEYWORD3";
        SEQ SEQ59 = new SEQ();
        SEQ59.text = "'machine";
        SEQ59.TYPE = "KEYWORD3";
        SEQ SEQ60 = new SEQ();
        SEQ60.text = "'machine_emax";
        SEQ60.TYPE = "KEYWORD3";
        SEQ SEQ61 = new SEQ();
        SEQ61.text = "'machine_emin";
        SEQ61.TYPE = "KEYWORD3";
        SEQ SEQ62 = new SEQ();
        SEQ62.text = "'machine_mantissa";
        SEQ62.TYPE = "KEYWORD3";
        SEQ SEQ63 = new SEQ();
        SEQ63.text = "'machine_overflows";
        SEQ63.TYPE = "KEYWORD3";
        SEQ SEQ64 = new SEQ();
        SEQ64.text = "'machine_radix";
        SEQ64.TYPE = "KEYWORD3";
        SEQ SEQ65 = new SEQ();
        SEQ65.text = "'machine_rounding";
        SEQ65.TYPE = "KEYWORD3";
        SEQ SEQ66 = new SEQ();
        SEQ66.text = "'machine_rounds";
        SEQ66.TYPE = "KEYWORD3";
        SEQ SEQ67 = new SEQ();
        SEQ67.text = "'max";
        SEQ67.TYPE = "KEYWORD3";
        SEQ SEQ68 = new SEQ();
        SEQ68.text = "'max_alignment_for_allocation";
        SEQ68.TYPE = "KEYWORD3";
        SEQ SEQ69 = new SEQ();
        SEQ69.text = "'max_size_in_storage_elements";
        SEQ69.TYPE = "KEYWORD3";
        SEQ SEQ70 = new SEQ();
        SEQ70.text = "'min";
        SEQ70.TYPE = "KEYWORD3";
        SEQ SEQ71 = new SEQ();
        SEQ71.text = "'mod";
        SEQ71.TYPE = "KEYWORD3";
        SEQ SEQ72 = new SEQ();
        SEQ72.text = "'model";
        SEQ72.TYPE = "KEYWORD3";
        SEQ SEQ73 = new SEQ();
        SEQ73.text = "'model_emin";
        SEQ73.TYPE = "KEYWORD3";
        SEQ SEQ74 = new SEQ();
        SEQ74.text = "'model_epsilon";
        SEQ74.TYPE = "KEYWORD3";
        SEQ SEQ75 = new SEQ();
        SEQ75.text = "'model_mantissa";
        SEQ75.TYPE = "KEYWORD3";
        SEQ SEQ76 = new SEQ();
        SEQ76.text = "'model_small";
        SEQ76.TYPE = "KEYWORD3";
        SEQ SEQ77 = new SEQ();
        SEQ77.text = "'modulus";
        SEQ77.TYPE = "KEYWORD3";
        SEQ SEQ78 = new SEQ();
        SEQ78.text = "'old";
        SEQ78.TYPE = "KEYWORD3";
        SEQ SEQ79 = new SEQ();
        SEQ79.text = "'class'output";
        SEQ79.TYPE = "KEYWORD3";
        SEQ SEQ80 = new SEQ();
        SEQ80.text = "'output";
        SEQ80.TYPE = "KEYWORD3";
        SEQ SEQ81 = new SEQ();
        SEQ81.text = "'overlaps_storage";
        SEQ81.TYPE = "KEYWORD3";
        SEQ SEQ82 = new SEQ();
        SEQ82.text = "'partition_id";
        SEQ82.TYPE = "KEYWORD3";
        SEQ SEQ83 = new SEQ();
        SEQ83.text = "'pos";
        SEQ83.TYPE = "KEYWORD3";
        SEQ SEQ84 = new SEQ();
        SEQ84.text = "'position";
        SEQ84.TYPE = "KEYWORD3";
        SEQ SEQ85 = new SEQ();
        SEQ85.text = "'pred";
        SEQ85.TYPE = "KEYWORD3";
        SEQ SEQ86 = new SEQ();
        SEQ86.text = "'priority";
        SEQ86.TYPE = "KEYWORD3";
        SEQ SEQ87 = new SEQ();
        SEQ87.text = "'range";
        SEQ87.TYPE = "KEYWORD3";
        SEQ SEQ88 = new SEQ();
        SEQ88.text = "'class'read";
        SEQ88.TYPE = "KEYWORD3";
        SEQ SEQ89 = new SEQ();
        SEQ89.text = "'read";
        SEQ89.TYPE = "KEYWORD3";
        SEQ SEQ90 = new SEQ();
        SEQ90.text = "'remainder";
        SEQ90.TYPE = "KEYWORD3";
        SEQ SEQ91 = new SEQ();
        SEQ91.text = "'result";
        SEQ91.TYPE = "KEYWORD3";
        SEQ SEQ92 = new SEQ();
        SEQ92.text = "'round";
        SEQ92.TYPE = "KEYWORD3";
        SEQ SEQ93 = new SEQ();
        SEQ93.text = "'rounding";
        SEQ93.TYPE = "KEYWORD3";
        SEQ SEQ94 = new SEQ();
        SEQ94.text = "'safe_first";
        SEQ94.TYPE = "KEYWORD3";
        SEQ SEQ95 = new SEQ();
        SEQ95.text = "'safe_last";
        SEQ95.TYPE = "KEYWORD3";
        SEQ SEQ96 = new SEQ();
        SEQ96.text = "'scale";
        SEQ96.TYPE = "KEYWORD3";
        SEQ SEQ97 = new SEQ();
        SEQ97.text = "'scaling";
        SEQ97.TYPE = "KEYWORD3";
        SEQ SEQ98 = new SEQ();
        SEQ98.text = "'signed_zeros";
        SEQ98.TYPE = "KEYWORD3";
        SEQ SEQ99 = new SEQ();
        SEQ99.text = "'size";
        SEQ99.TYPE = "KEYWORD3";
        SEQ SEQ100 = new SEQ();
        SEQ100.text = "'small";
        SEQ100.TYPE = "KEYWORD3";
        SEQ SEQ101 = new SEQ();
        SEQ101.text = "'storage_pool";
        SEQ101.TYPE = "KEYWORD3";
        SEQ SEQ102 = new SEQ();
        SEQ102.text = "'storage_size";
        SEQ102.TYPE = "KEYWORD3";
        SEQ SEQ103 = new SEQ();
        SEQ103.text = "'stream_size";
        SEQ103.TYPE = "KEYWORD3";
        SEQ SEQ104 = new SEQ();
        SEQ104.text = "'succ";
        SEQ104.TYPE = "KEYWORD3";
        SEQ SEQ105 = new SEQ();
        SEQ105.text = "'tag";
        SEQ105.TYPE = "KEYWORD3";
        SEQ SEQ106 = new SEQ();
        SEQ106.text = "'terminated";
        SEQ106.TYPE = "KEYWORD3";
        SEQ SEQ107 = new SEQ();
        SEQ107.text = "'truncation";
        SEQ107.TYPE = "KEYWORD3";
        SEQ SEQ108 = new SEQ();
        SEQ108.text = "'unbiased_rounding";
        SEQ108.TYPE = "KEYWORD3";
        SEQ SEQ109 = new SEQ();
        SEQ109.text = "'unchecked_access";
        SEQ109.TYPE = "KEYWORD3";
        SEQ SEQ110 = new SEQ();
        SEQ110.text = "'val";
        SEQ110.TYPE = "KEYWORD3";
        SEQ SEQ111 = new SEQ();
        SEQ111.text = "'valid";
        SEQ111.TYPE = "KEYWORD3";
        SEQ SEQ112 = new SEQ();
        SEQ112.text = "'value";
        SEQ112.TYPE = "KEYWORD3";
        SEQ SEQ113 = new SEQ();
        SEQ113.text = "'version";
        SEQ113.TYPE = "KEYWORD3";
        SEQ SEQ114 = new SEQ();
        SEQ114.text = "'wide_image";
        SEQ114.TYPE = "KEYWORD3";
        SEQ SEQ115 = new SEQ();
        SEQ115.text = "'wide_value";
        SEQ115.TYPE = "KEYWORD3";
        SEQ SEQ116 = new SEQ();
        SEQ116.text = "'wide_width";
        SEQ116.TYPE = "KEYWORD3";
        SEQ SEQ117 = new SEQ();
        SEQ117.text = "'width";
        SEQ117.TYPE = "KEYWORD3";
        SEQ SEQ118 = new SEQ();
        SEQ118.text = "'wide_wide_image";
        SEQ118.TYPE = "KEYWORD3";
        SEQ SEQ119 = new SEQ();
        SEQ119.text = "'wide_wide_value";
        SEQ119.TYPE = "KEYWORD3";
        SEQ SEQ120 = new SEQ();
        SEQ120.text = "'wide_wide_width";
        SEQ120.TYPE = "KEYWORD3";
        SEQ SEQ121 = new SEQ();
        SEQ121.text = "'class'write";
        SEQ121.TYPE = "KEYWORD3";
        SEQ SEQ122 = new SEQ();
        SEQ122.text = "'write";
        SEQ122.TYPE = "KEYWORD3";
        SEQ SEQ123 = new SEQ();
        SEQ123.text = "pragma all_calls_remote";
        SEQ123.TYPE = "KEYWORD3";
        SEQ SEQ124 = new SEQ();
        SEQ124.text = "pragma assert";
        SEQ124.TYPE = "KEYWORD3";
        SEQ SEQ125 = new SEQ();
        SEQ125.text = "pragma assertion_policy";
        SEQ125.TYPE = "KEYWORD3";
        SEQ SEQ126 = new SEQ();
        SEQ126.text = "pragma asynchronous";
        SEQ126.TYPE = "KEYWORD3";
        SEQ SEQ127 = new SEQ();
        SEQ127.text = "pragma atomic";
        SEQ127.TYPE = "KEYWORD3";
        SEQ SEQ128 = new SEQ();
        SEQ128.text = "pragma atomic_components";
        SEQ128.TYPE = "KEYWORD3";
        SEQ SEQ129 = new SEQ();
        SEQ129.text = "pragma attach_handler";
        SEQ129.TYPE = "KEYWORD3";
        SEQ SEQ130 = new SEQ();
        SEQ130.text = "pragma controlled";
        SEQ130.TYPE = "KEYWORD3";
        SEQ SEQ131 = new SEQ();
        SEQ131.text = "pragma convention";
        SEQ131.TYPE = "KEYWORD3";
        SEQ SEQ132 = new SEQ();
        SEQ132.text = "pragma cpu";
        SEQ132.TYPE = "KEYWORD3";
        SEQ SEQ133 = new SEQ();
        SEQ133.text = "pragma default_storage_pool";
        SEQ133.TYPE = "KEYWORD3";
        SEQ SEQ134 = new SEQ();
        SEQ134.text = "pragma detect_blocking";
        SEQ134.TYPE = "KEYWORD3";
        SEQ SEQ135 = new SEQ();
        SEQ135.text = "pragma discard_names";
        SEQ135.TYPE = "KEYWORD3";
        SEQ SEQ136 = new SEQ();
        SEQ136.text = "pragma dispatching_domain";
        SEQ136.TYPE = "KEYWORD3";
        SEQ SEQ137 = new SEQ();
        SEQ137.text = "pragma elaborate";
        SEQ137.TYPE = "KEYWORD3";
        SEQ SEQ138 = new SEQ();
        SEQ138.text = "pragma elaborate_all";
        SEQ138.TYPE = "KEYWORD3";
        SEQ SEQ139 = new SEQ();
        SEQ139.text = "pragma elaborate_body";
        SEQ139.TYPE = "KEYWORD3";
        SEQ SEQ140 = new SEQ();
        SEQ140.text = "pragma export";
        SEQ140.TYPE = "KEYWORD3";
        SEQ SEQ141 = new SEQ();
        SEQ141.text = "pragma import";
        SEQ141.TYPE = "KEYWORD3";
        SEQ SEQ142 = new SEQ();
        SEQ142.text = "pragma independent";
        SEQ142.TYPE = "KEYWORD3";
        SEQ SEQ143 = new SEQ();
        SEQ143.text = "pragam independent_components";
        SEQ143.TYPE = "KEYWORD3";
        SEQ SEQ144 = new SEQ();
        SEQ144.text = "pragma inline";
        SEQ144.TYPE = "KEYWORD3";
        SEQ SEQ145 = new SEQ();
        SEQ145.text = "pragma inspection_point";
        SEQ145.TYPE = "KEYWORD3";
        SEQ SEQ146 = new SEQ();
        SEQ146.text = "pragma interrupt_handler";
        SEQ146.TYPE = "KEYWORD3";
        SEQ SEQ147 = new SEQ();
        SEQ147.text = "pragma interrupt_priority";
        SEQ147.TYPE = "KEYWORD3";
        SEQ SEQ148 = new SEQ();
        SEQ148.text = "pragma linker_options";
        SEQ148.TYPE = "KEYWORD3";
        SEQ SEQ149 = new SEQ();
        SEQ149.text = "pragma list";
        SEQ149.TYPE = "KEYWORD3";
        SEQ SEQ150 = new SEQ();
        SEQ150.text = "pragma locking_policy";
        SEQ150.TYPE = "KEYWORD3";
        SEQ SEQ151 = new SEQ();
        SEQ151.text = "pragma no_return";
        SEQ151.TYPE = "KEYWORD3";
        SEQ SEQ152 = new SEQ();
        SEQ152.text = "pragma normalize_scalars";
        SEQ152.TYPE = "KEYWORD3";
        SEQ SEQ153 = new SEQ();
        SEQ153.text = "pragma optimize";
        SEQ153.TYPE = "KEYWORD3";
        SEQ SEQ154 = new SEQ();
        SEQ154.text = "pragma pack";
        SEQ154.TYPE = "KEYWORD3";
        SEQ SEQ155 = new SEQ();
        SEQ155.text = "pragma page";
        SEQ155.TYPE = "KEYWORD3";
        SEQ SEQ156 = new SEQ();
        SEQ156.text = "pragma partition_elaboration_policy";
        SEQ156.TYPE = "KEYWORD3";
        SEQ SEQ157 = new SEQ();
        SEQ157.text = "pragma preelaborate_initialization";
        SEQ157.TYPE = "KEYWORD3";
        SEQ SEQ158 = new SEQ();
        SEQ158.text = "pragma preelaborate";
        SEQ158.TYPE = "KEYWORD3";
        SEQ SEQ159 = new SEQ();
        SEQ159.text = "pragma priority";
        SEQ159.TYPE = "KEYWORD3";
        SEQ SEQ160 = new SEQ();
        SEQ160.text = "pragma priority_specific_dispatching";
        SEQ160.TYPE = "KEYWORD3";
        SEQ SEQ161 = new SEQ();
        SEQ161.text = "pragma profile";
        SEQ161.TYPE = "KEYWORD3";
        SEQ SEQ162 = new SEQ();
        SEQ162.text = "pragma pure";
        SEQ162.TYPE = "KEYWORD3";
        SEQ SEQ163 = new SEQ();
        SEQ163.text = "pragma queuing_policy";
        SEQ163.TYPE = "KEYWORD3";
        SEQ SEQ164 = new SEQ();
        SEQ164.text = "pragma relative_deadline";
        SEQ164.TYPE = "KEYWORD3";
        SEQ SEQ165 = new SEQ();
        SEQ165.text = "pragma remote_call_interface";
        SEQ165.TYPE = "KEYWORD3";
        SEQ SEQ166 = new SEQ();
        SEQ166.text = "pragma remote_types";
        SEQ166.TYPE = "KEYWORD3";
        SEQ SEQ167 = new SEQ();
        SEQ167.text = "pragma restrictions";
        SEQ167.TYPE = "KEYWORD3";
        SEQ SEQ168 = new SEQ();
        SEQ168.text = "pragma reviewable";
        SEQ168.TYPE = "KEYWORD3";
        SEQ SEQ169 = new SEQ();
        SEQ169.text = "pragma shared_passive";
        SEQ169.TYPE = "KEYWORD3";
        SEQ SEQ170 = new SEQ();
        SEQ170.text = "pragma storage_size";
        SEQ170.TYPE = "KEYWORD3";
        SEQ SEQ171 = new SEQ();
        SEQ171.text = "pragma suppress";
        SEQ171.TYPE = "KEYWORD3";
        SEQ SEQ172 = new SEQ();
        SEQ172.text = "pragma task_dispatching_policy";
        SEQ172.TYPE = "KEYWORD3";
        SEQ SEQ173 = new SEQ();
        SEQ173.text = "pragma unchecked_union";
        SEQ173.TYPE = "KEYWORD3";
        SEQ SEQ174 = new SEQ();
        SEQ174.text = "pragma unsuppress";
        SEQ174.TYPE = "KEYWORD3";
        SEQ SEQ175 = new SEQ();
        SEQ175.text = "pragma volatile";
        SEQ175.TYPE = "KEYWORD3";
        SEQ SEQ176 = new SEQ();
        SEQ176.text = "pragma volatile_components";
        SEQ176.TYPE = "KEYWORD3";
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
        KEYWORDS1.add("LITERAL2", new String[]{"address", "boolean", "character", "duration", "float", "integer", "latin_1", "natural", "positive", "string", "time", "wide_character", "wide_wide_character", "wide_string", "wide_wide_string", "constraint_error", "program_error", "storage_error", "tasking_error", });
        KEYWORDS1.add("LITERAL1", new String[]{"false", "true", });
        KEYWORDS1.add("KEYWORD1", new String[]{"entry", "function", "procedure", });
        KEYWORDS1.add("KEYWORD2", new String[]{"abort", "abs", "abstract", "accept", "access", "aliased", "all", "and", "array", "at", "begin", "body", "case", "constant", "declare", "delay", "delta", "digits", "do", "else", "elsif", "end", "exception", "exit", "for", "generic", "goto", "if", "in", "interface", "is", "limited", "loop", "mod", "new", "not", "null", "of", "or", "others", "out", "overriding", "package", "private", "protected", "raise", "range", "record", "rem", "renames", "requeue", "return", "reverse", "select", "separate", "some", "subtype", "synchronized", "tagged", "task", "terminate", "then", "type", "until", "use", "when", "while", "with", "xor", });
        KEYWORDS1.add("KEYWORD3", new String[]{"pragma", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, SEQ30, SEQ31, SEQ32, SEQ33, SEQ34, SEQ35, SEQ36, SEQ37, SEQ38, SEQ39, SEQ40, SEQ41, SEQ42, SEQ43, SEQ44, SEQ45, SEQ46, SEQ47, SEQ48, SEQ49, SEQ50, SEQ51, SEQ52, SEQ53, SEQ54, SEQ55, SEQ56, SEQ57, SEQ58, SEQ59, SEQ60, SEQ61, SEQ62, SEQ63, SEQ64, SEQ65, SEQ66, SEQ67, SEQ68, SEQ69, SEQ70, SEQ71, SEQ72, SEQ73, SEQ74, SEQ75, SEQ76, SEQ77, SEQ78, SEQ79, SEQ80, SEQ81, SEQ82, SEQ83, SEQ84, SEQ85, SEQ86, SEQ87, SEQ88, SEQ89, SEQ90, SEQ91, SEQ92, SEQ93, SEQ94, SEQ95, SEQ96, SEQ97, SEQ98, SEQ99, SEQ100, SEQ101, SEQ102, SEQ103, SEQ104, SEQ105, SEQ106, SEQ107, SEQ108, SEQ109, SEQ110, SEQ111, SEQ112, SEQ113, SEQ114, SEQ115, SEQ116, SEQ117, SEQ118, SEQ119, SEQ120, SEQ121, SEQ122, SEQ123, SEQ124, SEQ125, SEQ126, SEQ127, SEQ128, SEQ129, SEQ130, SEQ131, SEQ132, SEQ133, SEQ134, SEQ135, SEQ136, SEQ137, SEQ138, SEQ139, SEQ140, SEQ141, SEQ142, SEQ143, SEQ144, SEQ145, SEQ146, SEQ147, SEQ148, SEQ149, SEQ150, SEQ151, SEQ152, SEQ153, SEQ154, SEQ155, SEQ156, SEQ157, SEQ158, SEQ159, SEQ160, SEQ161, SEQ162, SEQ163, SEQ164, SEQ165, SEQ166, SEQ167, SEQ168, SEQ169, SEQ170, SEQ171, SEQ172, SEQ173, SEQ174, SEQ175, SEQ176, };

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
