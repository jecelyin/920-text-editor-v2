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
public class VhdlLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "VHDL";
        PROPERTY1.NAME = "label";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "--";
        PROPERTY2.NAME = "lineComment";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "true";
        PROPERTY3.NAME = "contextInsensitive";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.IGNORE_CASE = "TRUE";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.AT_WORD_START = "TRUE";
        SPAN_REGEXP1.NO_LINE_BREAK = "TRUE";
        SPAN_REGEXP1.TYPE = "LITERAL4";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "[box]?\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.AT_WORD_START = "TRUE";
        SPAN_REGEXP2.NO_LINE_BREAK = "TRUE";
        SPAN_REGEXP2.TYPE = "LITERAL4";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "[box]?%";
        END END2 = new END();
        END2.text = "%";
        SPAN_REGEXP2.END = new END[] { END2, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "(?:'[\\x20-\\x7e\\xa0-\\xff]')";
        SEQ_REGEXP1.TYPE = "LITERAL1";
        SEQ_REGEXP1.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "'left\\b";
        SEQ_REGEXP2.TYPE = "KEYWORD3";
        SEQ_REGEXP2.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "'right\\b";
        SEQ_REGEXP3.TYPE = "KEYWORD3";
        SEQ_REGEXP3.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP4 = new SEQ_REGEXP();
        SEQ_REGEXP4.text = "'low\\b";
        SEQ_REGEXP4.TYPE = "KEYWORD3";
        SEQ_REGEXP4.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP5 = new SEQ_REGEXP();
        SEQ_REGEXP5.text = "'high\\b";
        SEQ_REGEXP5.TYPE = "KEYWORD3";
        SEQ_REGEXP5.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP6 = new SEQ_REGEXP();
        SEQ_REGEXP6.text = "'ascending\\b";
        SEQ_REGEXP6.TYPE = "KEYWORD3";
        SEQ_REGEXP6.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP7 = new SEQ_REGEXP();
        SEQ_REGEXP7.text = "'image\\b";
        SEQ_REGEXP7.TYPE = "KEYWORD3";
        SEQ_REGEXP7.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP8 = new SEQ_REGEXP();
        SEQ_REGEXP8.text = "'value\\b";
        SEQ_REGEXP8.TYPE = "KEYWORD3";
        SEQ_REGEXP8.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP9 = new SEQ_REGEXP();
        SEQ_REGEXP9.text = "'pos\\b";
        SEQ_REGEXP9.TYPE = "KEYWORD3";
        SEQ_REGEXP9.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP10 = new SEQ_REGEXP();
        SEQ_REGEXP10.text = "'val\\b";
        SEQ_REGEXP10.TYPE = "KEYWORD3";
        SEQ_REGEXP10.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP11 = new SEQ_REGEXP();
        SEQ_REGEXP11.text = "'succ\\b";
        SEQ_REGEXP11.TYPE = "KEYWORD3";
        SEQ_REGEXP11.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP12 = new SEQ_REGEXP();
        SEQ_REGEXP12.text = "'pred\\b";
        SEQ_REGEXP12.TYPE = "KEYWORD3";
        SEQ_REGEXP12.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP13 = new SEQ_REGEXP();
        SEQ_REGEXP13.text = "'leftof\\b";
        SEQ_REGEXP13.TYPE = "KEYWORD3";
        SEQ_REGEXP13.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP14 = new SEQ_REGEXP();
        SEQ_REGEXP14.text = "'rightof\\b";
        SEQ_REGEXP14.TYPE = "KEYWORD3";
        SEQ_REGEXP14.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP15 = new SEQ_REGEXP();
        SEQ_REGEXP15.text = "'base\\b";
        SEQ_REGEXP15.TYPE = "KEYWORD3";
        SEQ_REGEXP15.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP16 = new SEQ_REGEXP();
        SEQ_REGEXP16.text = "'delayed\\b";
        SEQ_REGEXP16.TYPE = "KEYWORD3";
        SEQ_REGEXP16.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP17 = new SEQ_REGEXP();
        SEQ_REGEXP17.text = "'stable\\b";
        SEQ_REGEXP17.TYPE = "KEYWORD3";
        SEQ_REGEXP17.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP18 = new SEQ_REGEXP();
        SEQ_REGEXP18.text = "'quiet\\b";
        SEQ_REGEXP18.TYPE = "KEYWORD3";
        SEQ_REGEXP18.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP19 = new SEQ_REGEXP();
        SEQ_REGEXP19.text = "'transaction\\b";
        SEQ_REGEXP19.TYPE = "KEYWORD3";
        SEQ_REGEXP19.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP20 = new SEQ_REGEXP();
        SEQ_REGEXP20.text = "'event\\b";
        SEQ_REGEXP20.TYPE = "KEYWORD3";
        SEQ_REGEXP20.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP21 = new SEQ_REGEXP();
        SEQ_REGEXP21.text = "'active\\b";
        SEQ_REGEXP21.TYPE = "KEYWORD3";
        SEQ_REGEXP21.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP22 = new SEQ_REGEXP();
        SEQ_REGEXP22.text = "'last_event\\b";
        SEQ_REGEXP22.TYPE = "KEYWORD3";
        SEQ_REGEXP22.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP23 = new SEQ_REGEXP();
        SEQ_REGEXP23.text = "'last_active\\b";
        SEQ_REGEXP23.TYPE = "KEYWORD3";
        SEQ_REGEXP23.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP24 = new SEQ_REGEXP();
        SEQ_REGEXP24.text = "'last_value\\b";
        SEQ_REGEXP24.TYPE = "KEYWORD3";
        SEQ_REGEXP24.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP25 = new SEQ_REGEXP();
        SEQ_REGEXP25.text = "'driving\\b";
        SEQ_REGEXP25.TYPE = "KEYWORD3";
        SEQ_REGEXP25.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP26 = new SEQ_REGEXP();
        SEQ_REGEXP26.text = "'driving_value\\b";
        SEQ_REGEXP26.TYPE = "KEYWORD3";
        SEQ_REGEXP26.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP27 = new SEQ_REGEXP();
        SEQ_REGEXP27.text = "'range\\b";
        SEQ_REGEXP27.TYPE = "KEYWORD3";
        SEQ_REGEXP27.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP28 = new SEQ_REGEXP();
        SEQ_REGEXP28.text = "'reverse_range\\b";
        SEQ_REGEXP28.TYPE = "KEYWORD3";
        SEQ_REGEXP28.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP29 = new SEQ_REGEXP();
        SEQ_REGEXP29.text = "'length\\b";
        SEQ_REGEXP29.TYPE = "KEYWORD3";
        SEQ_REGEXP29.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP30 = new SEQ_REGEXP();
        SEQ_REGEXP30.text = "'simple_name\\b";
        SEQ_REGEXP30.TYPE = "KEYWORD3";
        SEQ_REGEXP30.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP31 = new SEQ_REGEXP();
        SEQ_REGEXP31.text = "'path_name\\b";
        SEQ_REGEXP31.TYPE = "KEYWORD3";
        SEQ_REGEXP31.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP32 = new SEQ_REGEXP();
        SEQ_REGEXP32.text = "'instance_name\\b";
        SEQ_REGEXP32.TYPE = "KEYWORD3";
        SEQ_REGEXP32.HASH_CHAR = "'";
        SEQ_REGEXP SEQ_REGEXP33 = new SEQ_REGEXP();
        SEQ_REGEXP33.text = "'foreign\\b";
        SEQ_REGEXP33.TYPE = "KEYWORD3";
        SEQ_REGEXP33.HASH_CHAR = "'";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "'";
        MARK_FOLLOWING1.TYPE = "KEYWORD4";
        MARK_FOLLOWING1.MATCH_TYPE = "KEYWORD3";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "--";
        EOL_SPAN1.TYPE = "COMMENT1";
        SEQ_REGEXP SEQ_REGEXP34 = new SEQ_REGEXP();
        SEQ_REGEXP34.text = "(\\w|\\w[\\w\\d_]*[\\w\\d])\\s*(?=:)(?!:=)(?!:\\s*\\d)(?=:\\s*(if\\b|case\\b|while\\b|for\\b|loop\\b|next\\b|null\\b|block\\b|process\\b|wait\\b|postponed\\b|assert\\b|with\\b|entity\\b|component\\b|configuration\\b|exit\\b|return\\b|(?:(?:\\w[\\w\\d_]*\\w|\\w)\\s*<=)))";
        SEQ_REGEXP34.AT_WHITESPACE_END = "TRUE";
        SEQ_REGEXP34.TYPE = "LABEL";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "(";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ")";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "=>";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "**";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = ":=";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "/=";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = ">=";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "<=";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "<>";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "=";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = ":";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = ">";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "<";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "+";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "-";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "/";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "*";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "&";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "|";
        SEQ19.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP35 = new SEQ_REGEXP();
        SEQ_REGEXP35.text = "\\d{1,2}#(?:(?:[\\da-f][\\da-f_]*\\.?[\\da-f_]*[\\da-f])|[\\da-f])#(?:e[+-]?(?:\\d[\\d_]*\\d|\\d))?";
        SEQ_REGEXP35.AT_WORD_START = "TRUE";
        SEQ_REGEXP35.TYPE = "DIGIT";
        SEQ_REGEXP SEQ_REGEXP36 = new SEQ_REGEXP();
        SEQ_REGEXP36.text = "\\d{1,2}:(?:(?:[\\da-f][\\da-f_]*\\.?[\\da-f_]*[\\da-f])|[\\da-f]):(?:e[+-]?(?:\\d[\\d_]*\\d|\\d))?";
        SEQ_REGEXP36.AT_WORD_START = "TRUE";
        SEQ_REGEXP36.TYPE = "DIGIT";
        SEQ_REGEXP SEQ_REGEXP37 = new SEQ_REGEXP();
        SEQ_REGEXP37.text = "(?:(?:\\d[\\d_]*\\.?[\\d_]*\\d)|\\d)(?:e[+-]?(?:\\d[\\d_]*\\d|\\d))?";
        SEQ_REGEXP37.AT_WORD_START = "TRUE";
        SEQ_REGEXP37.TYPE = "DIGIT";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"abs", "and", "mod", "nand", "nor", "not", "or", "rem", "xor", "rol", "ror", "sll", "srl", "sla", "sra", "xnor", });
        KEYWORDS1.add("LITERAL2", new String[]{"left", "right", "std_input", "std_output", "math_e", "math_1_over_e", "math_pi", "math_2_pi", "math_1_over_pi", "math_pi_over_2", "math_pi_over_3", "math_pi_over_4", "math_3_pi_over_2", "math_log_of_2", "math_log_of_10", "math_log2_of_e", "math_log10_of_e", "math_sqrt_2", "math_1_over_sqrt_2", "math_sqrt_pi", "math_deg_to_rad", "math_rad_to_deg", "math_cbase_1", "math_cbase_j", "math_czero", });
        KEYWORDS1.add("LITERAL1", new String[]{"false", "true", "nul", "soh", "stx", "etx", "eot", "enq", "ack", "bel", "bs", "ht", "lf", "vt", "ff", "cr", "so", "si", "dle", "dc1", "dc2", "dc3", "dc4", "nak", "syn", "etb", "can", "em", "sub", "esc", "fsp", "gsp", "rsp", "usp", "del", "c128", "c129", "c130", "c131", "c132", "c133", "c134", "c135", "c136", "c137", "c138", "c139", "c140", "c141", "c142", "c143", "c144", "c145", "c146", "c147", "c148", "c149", "c150", "c151", "c152", "c153", "c154", "c155", "c156", "c157", "c158", "c159", "note", "warning", "error", "failure", "read_mode", "write_mode", "append_mode", "open_ok", "status_error", "name_error", "mode_error", });
        KEYWORDS1.add("KEYWORD1", new String[]{"access", "after", "alias", "all", "architecture", "array", "assert", "attribute", "begin", "block", "body", "buffer", "bus", "case", "component", "configuration", "constant", "disconnect", "downto", "else", "elsif", "end", "entity", "exit", "file", "for", "function", "generate", "generic", "guarded", "if", "in", "inout", "is", "label", "library", "linkage", "loop", "map", "new", "next", "null", "of", "on", "open", "others", "out", "package", "port", "procedure", "process", "range", "record", "register", "report", "return", "select", "severity", "signal", "subtype", "then", "to", "transport", "type", "units", "until", "use", "variable", "wait", "when", "while", "with", "group", "impure", "inertial", "literal", "postponed", "pure", "reject", "shared", "unaffected", "protected", });
        KEYWORDS1.add("FUNCTION", new String[]{"deallocate", "now", "file_open", "file_close", "read", "write", "endfile", "to_bit", "to_bitvector", "to_stdulogic", "to_stdlogicvector", "to_stdulogicvector", "to_x01", "to_x01z", "to_ux01", "rising_edge", "falling_edge", "is_x", "shift_left", "shift_right", "rotate_left", "rotate_right", "resize", "std_match", "to_integer", "to_unsigned", "to_signed", "readline", "writeline", "oread", "owrite", "hread", "hwrite", "conv_integer", "conv_unsigned", "conv_signed", "conv_std_logic_vector", "shl", "shr", "ext", "sxt", "sign", "ceil", "floor", "round", "trunc", "realmax", "realmin", "uniform", "sqrt", "cbrt", "exp", "log", "log2", "log10", "sin", "cos", "tan", "arcsin", "arccos", "arctan", "sinh", "cosh", "tanh", "arcsinh", "arccosh", "arctanh", "cmplx", "get_principal_value", "complex_to_polar", "polar_to_complex", "conj", });
        KEYWORDS1.add("KEYWORD2", new String[]{"bit", "bit_vector", "boolean", "character", "delay_length", "file_open_kind", "file_open_status", "integer", "natural", "positive", "real", "severity_level", "string", "time", "std_logic", "std_ulogic", "std_logic_vector", "std_ulogic_vector", "x01", "x01z", "ux01", "ux01z", "signed", "unsigned", "line", "text", "side", "width", "signed", "unsigned", "small_int", "complex", "positive_real", "principal_value", "complex_polar", "re", "im", "mag", "arg", });
        KEYWORDS1.add("LITERAL3", new String[]{"input", "output", });
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, SEQ_REGEXP4, SEQ_REGEXP5, SEQ_REGEXP6, SEQ_REGEXP7, SEQ_REGEXP8, SEQ_REGEXP9, SEQ_REGEXP10, SEQ_REGEXP11, SEQ_REGEXP12, SEQ_REGEXP13, SEQ_REGEXP14, SEQ_REGEXP15, SEQ_REGEXP16, SEQ_REGEXP17, SEQ_REGEXP18, SEQ_REGEXP19, SEQ_REGEXP20, SEQ_REGEXP21, SEQ_REGEXP22, SEQ_REGEXP23, SEQ_REGEXP24, SEQ_REGEXP25, SEQ_REGEXP26, SEQ_REGEXP27, SEQ_REGEXP28, SEQ_REGEXP29, SEQ_REGEXP30, SEQ_REGEXP31, SEQ_REGEXP32, SEQ_REGEXP33, SEQ_REGEXP34, SEQ_REGEXP35, SEQ_REGEXP36, SEQ_REGEXP37, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, };

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
