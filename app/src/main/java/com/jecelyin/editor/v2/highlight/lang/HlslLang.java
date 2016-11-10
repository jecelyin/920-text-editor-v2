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
public class HlslLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "/*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "*/";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "//";
        PROPERTY3.NAME = "lineComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = ".,+-*/=<>?^&[]{}";
        PROPERTY4.NAME = "wordBreakChars";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "{";
        PROPERTY5.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "}";
        PROPERTY6.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY7 = new PROPERTY();
        PROPERTY7.VALUE = "\\s*(((if|while)\\s*\\(|else\\s*|else\\s+if\\s*\\(|for\\s*\\(.*\\))[^{;]*)";
        PROPERTY7.NAME = "indentNextLine";
        PROPERTY PROPERTY8 = new PROPERTY();
        PROPERTY8.VALUE = "false";
        PROPERTY8.NAME = "doubleBracketIndent";
        PROPERTY PROPERTY9 = new PROPERTY();
        PROPERTY9.VALUE = "true";
        PROPERTY9.NAME = "lineUpClosingBracket";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, PROPERTY8, PROPERTY9, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "((0[xX][0-9a-fA-F]+|\\d+)[uUIL]?|\\d+([eE]\\d*)?[hHfF]?)";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "TRUE";
        SPAN3.TYPE = "LITERAL1";
        SPAN3.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "##";
        SEQ1.TYPE = "KEYWORD2";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "#@";
        SEQ2.TYPE = "KEYWORD2";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "KEYWORD2";
        EOL_SPAN1.DELEGATE = "Preprocessor";
        SPAN SPAN4 = new SPAN();
        SPAN4.AT_WORD_START = "TRUE";
        SPAN4.EXCLUDE_MATCH = "FALSE";
        SPAN4.TYPE = "KEYWORD1";
        SPAN4.DELEGATE = "Asm";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "asm";
        END END4 = new END();
        END4.text = "}";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.AT_WORD_START = "TRUE";
        SPAN5.EXCLUDE_MATCH = "FALSE";
        SPAN5.TYPE = "KEYWORD1";
        SPAN5.DELEGATE = "Asm";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "ASM";
        END END5 = new END();
        END5.text = "}";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        SPAN SPAN6 = new SPAN();
        SPAN6.AT_WORD_START = "TRUE";
        SPAN6.EXCLUDE_MATCH = "FALSE";
        SPAN6.TYPE = "KEYWORD1";
        SPAN6.DELEGATE = "Asm";
        BEGIN BEGIN6 = new BEGIN();
        BEGIN6.text = "Asm";
        END END6 = new END();
        END6.text = "}";
        SPAN6.END = new END[] { END6, };

        SPAN6.BEGIN = new BEGIN[] { BEGIN6, };

        SPAN SPAN7 = new SPAN();
        SPAN7.AT_WORD_START = "TRUE";
        SPAN7.EXCLUDE_MATCH = "FALSE";
        SPAN7.TYPE = "KEYWORD1";
        SPAN7.DELEGATE = "Asm";
        BEGIN BEGIN7 = new BEGIN();
        BEGIN7.text = "asm_fragment";
        END END7 = new END();
        END7.text = "}";
        SPAN7.END = new END[] { END7, };

        SPAN7.BEGIN = new BEGIN[] { BEGIN7, };

        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "//";
        EOL_SPAN2.TYPE = "COMMENT2";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "++";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "--";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "&&";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "||";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "==";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "::";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "<<";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "<<=";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = ">>";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = ">>=";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "...";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "<=";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = ">=";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "!=";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "*=";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "/=";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "+=";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "-=";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "%=";
        SEQ21.TYPE = "OPERATOR";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "&=";
        SEQ22.TYPE = "OPERATOR";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "|=";
        SEQ23.TYPE = "OPERATOR";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "^=";
        SEQ24.TYPE = "OPERATOR";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "->";
        SEQ25.TYPE = "OPERATOR";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = "}";
        SEQ26.TYPE = "OPERATOR";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "{";
        SEQ27.TYPE = "OPERATOR";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "+";
        SEQ28.TYPE = "OPERATOR";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = "-";
        SEQ29.TYPE = "OPERATOR";
        SEQ SEQ30 = new SEQ();
        SEQ30.text = "*";
        SEQ30.TYPE = "OPERATOR";
        SEQ SEQ31 = new SEQ();
        SEQ31.text = "/";
        SEQ31.TYPE = "OPERATOR";
        SEQ SEQ32 = new SEQ();
        SEQ32.text = "%";
        SEQ32.TYPE = "OPERATOR";
        SEQ SEQ33 = new SEQ();
        SEQ33.text = "=";
        SEQ33.TYPE = "OPERATOR";
        SEQ SEQ34 = new SEQ();
        SEQ34.text = "<";
        SEQ34.TYPE = "OPERATOR";
        SEQ SEQ35 = new SEQ();
        SEQ35.text = ">";
        SEQ35.TYPE = "OPERATOR";
        SEQ SEQ36 = new SEQ();
        SEQ36.text = "!";
        SEQ36.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.EXCLUDE_MATCH = "TRUE";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = ".(([xyzw]{1,4})|([rgba]{1,4})|((_m[0123][0123])+)|((_[1234][1234])+))(?!\\p{Alnum})";
        SEQ_REGEXP1.TYPE = "OPERATOR";
        SEQ_REGEXP1.HASH_CHAR = ".";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "bool[1234](x[1234])?\\b";
        SEQ_REGEXP2.AT_WORD_START = "TRUE";
        SEQ_REGEXP2.TYPE = "KEYWORD2";
        SEQ_REGEXP2.HASH_CHAR = "bool";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "int[1234](x[1234])?\\b";
        SEQ_REGEXP3.AT_WORD_START = "TRUE";
        SEQ_REGEXP3.TYPE = "KEYWORD2";
        SEQ_REGEXP3.HASH_CHAR = "int";
        SEQ_REGEXP SEQ_REGEXP4 = new SEQ_REGEXP();
        SEQ_REGEXP4.text = "half[1234](x[1234])?\\b";
        SEQ_REGEXP4.AT_WORD_START = "TRUE";
        SEQ_REGEXP4.TYPE = "KEYWORD2";
        SEQ_REGEXP4.HASH_CHAR = "half";
        SEQ_REGEXP SEQ_REGEXP5 = new SEQ_REGEXP();
        SEQ_REGEXP5.text = "float[1234](x[1234])?\\b";
        SEQ_REGEXP5.AT_WORD_START = "TRUE";
        SEQ_REGEXP5.TYPE = "KEYWORD2";
        SEQ_REGEXP5.HASH_CHAR = "float";
        SEQ_REGEXP SEQ_REGEXP6 = new SEQ_REGEXP();
        SEQ_REGEXP6.text = "double[1234](x[1234])?\\b";
        SEQ_REGEXP6.AT_WORD_START = "TRUE";
        SEQ_REGEXP6.TYPE = "KEYWORD2";
        SEQ_REGEXP6.HASH_CHAR = "double";
        SEQ_REGEXP SEQ_REGEXP7 = new SEQ_REGEXP();
        SEQ_REGEXP7.text = ":\\s*(register\\s*\\(\\w+(\\s*\\,\\s*\\w+\\s*)?\\)|\\w+)";
        SEQ_REGEXP7.TYPE = "KEYWORD1";
        SEQ_REGEXP7.HASH_CHAR = ":";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"abs", "acos", "all", "any", "asin", "atan", "atan2", "ceil", "clamp", "clip", "cos", "cosh", "cross", "D3DCOLORtoUBYTE4", "ddx", "ddy", "degrees", "determinant", "distance", "dot", "exp", "exp2", "faceforward", "floor", "fmod", "frac", "frexp", "fwidth", "isfinite", "isinf", "isnan", "ldexp", "length", "lerp", "lit", "log", "log10", "log2", "max", "min", "modf", "mul", "noise", "normalize", "pow", "radians", "reflect", "refract", "round", "rsqrt", "saturate", "sign", "sin", "sincos", "sinh", "smoothstep", "sqrt", "step", "tan", "tanh", "transpose", });
        KEYWORDS1.add("LITERAL1", new String[]{"false", "true", "NULL", });
        KEYWORDS1.add("KEYWORD1", new String[]{"discard", "do", "else", "for", "if", "return", "typedef", "while", "compile", "compile_fragment", "register", "sampler_state", "stateblock_state", "technique", "Technique", "TECHNIQUE", "pass", "Pass", "PASS", "decl", "Decl", "DECL", });
        KEYWORDS1.add("INVALID", new String[]{"auto", "break", "case", "catch", "char", "class", "const_cast", "continue", "default", "delete", "dynamic_cast", "enum", "explicit", "friend", "goto", "long", "mutable", "namespace", "new", "operator", "private", "protected", "public", "reinterpret_cast", "short", "signed", "sizeof", "static_cast", "switch", "template", "this", "throw", "try", "typename", "union", "unsigned", "using", "virtual", });
        KEYWORDS1.add("KEYWORD2", new String[]{"void", "bool", "int", "half", "float", "double", "vector", "matrix", });
        KEYWORDS1.add("LITERAL3", new String[]{"tex1D", "tex1Dgrad", "tex1Dbias", "tex1Dgrad", "tex1Dlod", "tex1Dproj", "tex2D", "tex2D", "tex2Dbias", "tex2Dgrad", "tex2Dlod", "tex2Dproj", "tex3D", "tex3D", "tex3Dbias", "tex3Dgrad", "tex3Dlod", "tex3Dproj", "texCUBE", "texCUBE", "texCUBEbias", "texCUBEgrad", "texCUBElod", "texCUBEproj", });
        KEYWORDS1.add("KEYWORD3", new String[]{"string", "texture", "texture1D", "texture2D", "texture3D", "textureCUBE", "sampler", "sampler1D", "sampler2D", "sampler3D", "samplerCUBE", "pixelfragment", "vertexfragment", "pixelshader", "vertexshader", "stateblock", "struct", });
        KEYWORDS1.add("KEYWORD4", new String[]{"static", "uniform", "extern", "volatile", "inline", "shared", "const", "row_major", "column_major", "in", "inout", "out", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, SEQ_REGEXP4, SEQ_REGEXP5, SEQ_REGEXP6, SEQ_REGEXP7, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, SPAN6, SPAN7, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, SEQ30, SEQ31, SEQ32, SEQ33, SEQ34, SEQ35, SEQ36, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "Include";
        RULES1.DEFAULT = "KEYWORD2";
        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "Preprocessor";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DEFAULT = "KEYWORD2";
        RULES1.DIGIT_RE = "((0x[[:xdigit:]]+|[[:digit:]]+)[uUIL]?|[[:digit:]]+([eE][[:digit:]]*)?[hHfF]?)";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "include";
        EOL_SPAN1.TYPE = "MARKUP";
        EOL_SPAN1.DELEGATE = "Include";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("MARKUP", new String[]{"define", "elif", "else", "endif", "error", "if", "ifdef", "ifndef", "line", "pragma", "undef", });
        KEYWORDS1.add("LITERAL1", new String[]{"pack_matrix", "warning", "def", "defined", "D3DX", "D3DX_VERSION", "DIRECT3D", "DIRECT3D_VERSION", "__FILE__", "__LINE__", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES4() {
        RULES RULES1 = new RULES();
        RULES1.SET = "Asm";
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DEFAULT = "NULL";
        RULES1.DIGIT_RE = "((0x[[:xdigit:]]+|[[:digit:]]+)[uUIL]?|[[:digit:]]+([eE][[:digit:]]*)?[hHfF]?)";
        RULES1.IGNORE_CASE = "FALSE";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "{";
        SEQ1.TYPE = "OPERATOR";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "//";
        EOL_SPAN1.TYPE = "COMMENT2";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = ";";
        EOL_SPAN2.TYPE = "COMMENT2";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "+";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "-";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = ",";
        SEQ4.TYPE = "OPERATOR";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = ".(([xyzw]{1,4}))";
        SEQ_REGEXP1.TYPE = "OPERATOR";
        SEQ_REGEXP1.HASH_CHAR = ".";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "abs(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP2.AT_WORD_START = "TRUE";
        SEQ_REGEXP2.TYPE = "FUNCTION";
        SEQ_REGEXP2.HASH_CHAR = "abs";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "add(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP3.AT_WORD_START = "TRUE";
        SEQ_REGEXP3.TYPE = "FUNCTION";
        SEQ_REGEXP3.HASH_CHAR = "add";
        SEQ_REGEXP SEQ_REGEXP4 = new SEQ_REGEXP();
        SEQ_REGEXP4.text = "bem(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP4.AT_WORD_START = "TRUE";
        SEQ_REGEXP4.TYPE = "FUNCTION";
        SEQ_REGEXP4.HASH_CHAR = "bem";
        SEQ_REGEXP SEQ_REGEXP5 = new SEQ_REGEXP();
        SEQ_REGEXP5.text = "break_comp(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP5.AT_WORD_START = "TRUE";
        SEQ_REGEXP5.TYPE = "FUNCTION";
        SEQ_REGEXP5.HASH_CHAR = "break_comp";
        SEQ_REGEXP SEQ_REGEXP6 = new SEQ_REGEXP();
        SEQ_REGEXP6.text = "breakp(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP6.AT_WORD_START = "TRUE";
        SEQ_REGEXP6.TYPE = "FUNCTION";
        SEQ_REGEXP6.HASH_CHAR = "breakp";
        SEQ_REGEXP SEQ_REGEXP7 = new SEQ_REGEXP();
        SEQ_REGEXP7.text = "callnz(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP7.AT_WORD_START = "TRUE";
        SEQ_REGEXP7.TYPE = "FUNCTION";
        SEQ_REGEXP7.HASH_CHAR = "callnz";
        SEQ_REGEXP SEQ_REGEXP8 = new SEQ_REGEXP();
        SEQ_REGEXP8.text = "cmp(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP8.AT_WORD_START = "TRUE";
        SEQ_REGEXP8.TYPE = "FUNCTION";
        SEQ_REGEXP8.HASH_CHAR = "cmp";
        SEQ_REGEXP SEQ_REGEXP9 = new SEQ_REGEXP();
        SEQ_REGEXP9.text = "cnd(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP9.AT_WORD_START = "TRUE";
        SEQ_REGEXP9.TYPE = "FUNCTION";
        SEQ_REGEXP9.HASH_CHAR = "cnd";
        SEQ_REGEXP SEQ_REGEXP10 = new SEQ_REGEXP();
        SEQ_REGEXP10.text = "crs(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP10.AT_WORD_START = "TRUE";
        SEQ_REGEXP10.TYPE = "FUNCTION";
        SEQ_REGEXP10.HASH_CHAR = "crs";
        SEQ_REGEXP SEQ_REGEXP11 = new SEQ_REGEXP();
        SEQ_REGEXP11.text = "dp2add(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP11.AT_WORD_START = "TRUE";
        SEQ_REGEXP11.TYPE = "FUNCTION";
        SEQ_REGEXP11.HASH_CHAR = "dp2add";
        SEQ_REGEXP SEQ_REGEXP12 = new SEQ_REGEXP();
        SEQ_REGEXP12.text = "dp3(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP12.AT_WORD_START = "TRUE";
        SEQ_REGEXP12.TYPE = "FUNCTION";
        SEQ_REGEXP12.HASH_CHAR = "dp3";
        SEQ_REGEXP SEQ_REGEXP13 = new SEQ_REGEXP();
        SEQ_REGEXP13.text = "dp4(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP13.AT_WORD_START = "TRUE";
        SEQ_REGEXP13.TYPE = "FUNCTION";
        SEQ_REGEXP13.HASH_CHAR = "dp4";
        SEQ_REGEXP SEQ_REGEXP14 = new SEQ_REGEXP();
        SEQ_REGEXP14.text = "dst(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP14.AT_WORD_START = "TRUE";
        SEQ_REGEXP14.TYPE = "FUNCTION";
        SEQ_REGEXP14.HASH_CHAR = "dst";
        SEQ_REGEXP SEQ_REGEXP15 = new SEQ_REGEXP();
        SEQ_REGEXP15.text = "dsx(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP15.AT_WORD_START = "TRUE";
        SEQ_REGEXP15.TYPE = "FUNCTION";
        SEQ_REGEXP15.HASH_CHAR = "dsx";
        SEQ_REGEXP SEQ_REGEXP16 = new SEQ_REGEXP();
        SEQ_REGEXP16.text = "dsy(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP16.AT_WORD_START = "TRUE";
        SEQ_REGEXP16.TYPE = "FUNCTION";
        SEQ_REGEXP16.HASH_CHAR = "dsy";
        SEQ_REGEXP SEQ_REGEXP17 = new SEQ_REGEXP();
        SEQ_REGEXP17.text = "else(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP17.AT_WORD_START = "TRUE";
        SEQ_REGEXP17.TYPE = "FUNCTION";
        SEQ_REGEXP17.HASH_CHAR = "else";
        SEQ_REGEXP SEQ_REGEXP18 = new SEQ_REGEXP();
        SEQ_REGEXP18.text = "endif(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP18.AT_WORD_START = "TRUE";
        SEQ_REGEXP18.TYPE = "FUNCTION";
        SEQ_REGEXP18.HASH_CHAR = "endif";
        SEQ_REGEXP SEQ_REGEXP19 = new SEQ_REGEXP();
        SEQ_REGEXP19.text = "endloop(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP19.AT_WORD_START = "TRUE";
        SEQ_REGEXP19.TYPE = "FUNCTION";
        SEQ_REGEXP19.HASH_CHAR = "endloop";
        SEQ_REGEXP SEQ_REGEXP20 = new SEQ_REGEXP();
        SEQ_REGEXP20.text = "endrep(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP20.AT_WORD_START = "TRUE";
        SEQ_REGEXP20.TYPE = "FUNCTION";
        SEQ_REGEXP20.HASH_CHAR = "endrep";
        SEQ_REGEXP SEQ_REGEXP21 = new SEQ_REGEXP();
        SEQ_REGEXP21.text = "exp(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP21.AT_WORD_START = "TRUE";
        SEQ_REGEXP21.TYPE = "FUNCTION";
        SEQ_REGEXP21.HASH_CHAR = "exp";
        SEQ_REGEXP SEQ_REGEXP22 = new SEQ_REGEXP();
        SEQ_REGEXP22.text = "frc(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP22.AT_WORD_START = "TRUE";
        SEQ_REGEXP22.TYPE = "FUNCTION";
        SEQ_REGEXP22.HASH_CHAR = "frc";
        SEQ_REGEXP SEQ_REGEXP23 = new SEQ_REGEXP();
        SEQ_REGEXP23.text = "if(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP23.AT_WORD_START = "TRUE";
        SEQ_REGEXP23.TYPE = "FUNCTION";
        SEQ_REGEXP23.HASH_CHAR = "if";
        SEQ_REGEXP SEQ_REGEXP24 = new SEQ_REGEXP();
        SEQ_REGEXP24.text = "label(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP24.AT_WORD_START = "TRUE";
        SEQ_REGEXP24.TYPE = "FUNCTION";
        SEQ_REGEXP24.HASH_CHAR = "label";
        SEQ_REGEXP SEQ_REGEXP25 = new SEQ_REGEXP();
        SEQ_REGEXP25.text = "lit(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP25.AT_WORD_START = "TRUE";
        SEQ_REGEXP25.TYPE = "FUNCTION";
        SEQ_REGEXP25.HASH_CHAR = "lit";
        SEQ_REGEXP SEQ_REGEXP26 = new SEQ_REGEXP();
        SEQ_REGEXP26.text = "logp(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP26.AT_WORD_START = "TRUE";
        SEQ_REGEXP26.TYPE = "FUNCTION";
        SEQ_REGEXP26.HASH_CHAR = "logp";
        SEQ_REGEXP SEQ_REGEXP27 = new SEQ_REGEXP();
        SEQ_REGEXP27.text = "loop(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP27.AT_WORD_START = "TRUE";
        SEQ_REGEXP27.TYPE = "FUNCTION";
        SEQ_REGEXP27.HASH_CHAR = "loop";
        SEQ_REGEXP SEQ_REGEXP28 = new SEQ_REGEXP();
        SEQ_REGEXP28.text = "lrp(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP28.AT_WORD_START = "TRUE";
        SEQ_REGEXP28.TYPE = "FUNCTION";
        SEQ_REGEXP28.HASH_CHAR = "lrp";
        SEQ_REGEXP SEQ_REGEXP29 = new SEQ_REGEXP();
        SEQ_REGEXP29.text = "m3x2(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP29.AT_WORD_START = "TRUE";
        SEQ_REGEXP29.TYPE = "FUNCTION";
        SEQ_REGEXP29.HASH_CHAR = "m3x2";
        SEQ_REGEXP SEQ_REGEXP30 = new SEQ_REGEXP();
        SEQ_REGEXP30.text = "m3x3(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP30.AT_WORD_START = "TRUE";
        SEQ_REGEXP30.TYPE = "FUNCTION";
        SEQ_REGEXP30.HASH_CHAR = "m3x3";
        SEQ_REGEXP SEQ_REGEXP31 = new SEQ_REGEXP();
        SEQ_REGEXP31.text = "m3x4(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP31.AT_WORD_START = "TRUE";
        SEQ_REGEXP31.TYPE = "FUNCTION";
        SEQ_REGEXP31.HASH_CHAR = "m3x4";
        SEQ_REGEXP SEQ_REGEXP32 = new SEQ_REGEXP();
        SEQ_REGEXP32.text = "m4x3(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP32.AT_WORD_START = "TRUE";
        SEQ_REGEXP32.TYPE = "FUNCTION";
        SEQ_REGEXP32.HASH_CHAR = "m4x3";
        SEQ_REGEXP SEQ_REGEXP33 = new SEQ_REGEXP();
        SEQ_REGEXP33.text = "m4x4(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP33.AT_WORD_START = "TRUE";
        SEQ_REGEXP33.TYPE = "FUNCTION";
        SEQ_REGEXP33.HASH_CHAR = "m4x4";
        SEQ_REGEXP SEQ_REGEXP34 = new SEQ_REGEXP();
        SEQ_REGEXP34.text = "mad(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP34.AT_WORD_START = "TRUE";
        SEQ_REGEXP34.TYPE = "FUNCTION";
        SEQ_REGEXP34.HASH_CHAR = "mad";
        SEQ_REGEXP SEQ_REGEXP35 = new SEQ_REGEXP();
        SEQ_REGEXP35.text = "mov(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP35.AT_WORD_START = "TRUE";
        SEQ_REGEXP35.TYPE = "FUNCTION";
        SEQ_REGEXP35.HASH_CHAR = "mov";
        SEQ_REGEXP SEQ_REGEXP36 = new SEQ_REGEXP();
        SEQ_REGEXP36.text = "max(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP36.AT_WORD_START = "TRUE";
        SEQ_REGEXP36.TYPE = "FUNCTION";
        SEQ_REGEXP36.HASH_CHAR = "max";
        SEQ_REGEXP SEQ_REGEXP37 = new SEQ_REGEXP();
        SEQ_REGEXP37.text = "min(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP37.AT_WORD_START = "TRUE";
        SEQ_REGEXP37.TYPE = "FUNCTION";
        SEQ_REGEXP37.HASH_CHAR = "min";
        SEQ_REGEXP SEQ_REGEXP38 = new SEQ_REGEXP();
        SEQ_REGEXP38.text = "mova(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP38.AT_WORD_START = "TRUE";
        SEQ_REGEXP38.TYPE = "FUNCTION";
        SEQ_REGEXP38.HASH_CHAR = "mova";
        SEQ_REGEXP SEQ_REGEXP39 = new SEQ_REGEXP();
        SEQ_REGEXP39.text = "mul(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP39.AT_WORD_START = "TRUE";
        SEQ_REGEXP39.TYPE = "FUNCTION";
        SEQ_REGEXP39.HASH_CHAR = "mul";
        SEQ_REGEXP SEQ_REGEXP40 = new SEQ_REGEXP();
        SEQ_REGEXP40.text = "nop(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP40.AT_WORD_START = "TRUE";
        SEQ_REGEXP40.TYPE = "FUNCTION";
        SEQ_REGEXP40.HASH_CHAR = "nop";
        SEQ_REGEXP SEQ_REGEXP41 = new SEQ_REGEXP();
        SEQ_REGEXP41.text = "nrm(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP41.AT_WORD_START = "TRUE";
        SEQ_REGEXP41.TYPE = "FUNCTION";
        SEQ_REGEXP41.HASH_CHAR = "nrm";
        SEQ_REGEXP SEQ_REGEXP42 = new SEQ_REGEXP();
        SEQ_REGEXP42.text = "phase(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP42.AT_WORD_START = "TRUE";
        SEQ_REGEXP42.TYPE = "FUNCTION";
        SEQ_REGEXP42.HASH_CHAR = "phase";
        SEQ_REGEXP SEQ_REGEXP43 = new SEQ_REGEXP();
        SEQ_REGEXP43.text = "pow(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP43.AT_WORD_START = "TRUE";
        SEQ_REGEXP43.TYPE = "FUNCTION";
        SEQ_REGEXP43.HASH_CHAR = "pow";
        SEQ_REGEXP SEQ_REGEXP44 = new SEQ_REGEXP();
        SEQ_REGEXP44.text = "rcp(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP44.AT_WORD_START = "TRUE";
        SEQ_REGEXP44.TYPE = "FUNCTION";
        SEQ_REGEXP44.HASH_CHAR = "rcp";
        SEQ_REGEXP SEQ_REGEXP45 = new SEQ_REGEXP();
        SEQ_REGEXP45.text = "rep(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP45.AT_WORD_START = "TRUE";
        SEQ_REGEXP45.TYPE = "FUNCTION";
        SEQ_REGEXP45.HASH_CHAR = "rep";
        SEQ_REGEXP SEQ_REGEXP46 = new SEQ_REGEXP();
        SEQ_REGEXP46.text = "ret(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP46.AT_WORD_START = "TRUE";
        SEQ_REGEXP46.TYPE = "FUNCTION";
        SEQ_REGEXP46.HASH_CHAR = "ret";
        SEQ_REGEXP SEQ_REGEXP47 = new SEQ_REGEXP();
        SEQ_REGEXP47.text = "rsq(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP47.AT_WORD_START = "TRUE";
        SEQ_REGEXP47.TYPE = "FUNCTION";
        SEQ_REGEXP47.HASH_CHAR = "rsq";
        SEQ_REGEXP SEQ_REGEXP48 = new SEQ_REGEXP();
        SEQ_REGEXP48.text = "setp_comp(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP48.AT_WORD_START = "TRUE";
        SEQ_REGEXP48.TYPE = "FUNCTION";
        SEQ_REGEXP48.HASH_CHAR = "setp_comp";
        SEQ_REGEXP SEQ_REGEXP49 = new SEQ_REGEXP();
        SEQ_REGEXP49.text = "sge(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP49.AT_WORD_START = "TRUE";
        SEQ_REGEXP49.TYPE = "FUNCTION";
        SEQ_REGEXP49.HASH_CHAR = "sge";
        SEQ_REGEXP SEQ_REGEXP50 = new SEQ_REGEXP();
        SEQ_REGEXP50.text = "sgn(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP50.AT_WORD_START = "TRUE";
        SEQ_REGEXP50.TYPE = "FUNCTION";
        SEQ_REGEXP50.HASH_CHAR = "sgn";
        SEQ_REGEXP SEQ_REGEXP51 = new SEQ_REGEXP();
        SEQ_REGEXP51.text = "sincos(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP51.AT_WORD_START = "TRUE";
        SEQ_REGEXP51.TYPE = "FUNCTION";
        SEQ_REGEXP51.HASH_CHAR = "sincos";
        SEQ_REGEXP SEQ_REGEXP52 = new SEQ_REGEXP();
        SEQ_REGEXP52.text = "slt(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP52.AT_WORD_START = "TRUE";
        SEQ_REGEXP52.TYPE = "FUNCTION";
        SEQ_REGEXP52.HASH_CHAR = "slt";
        SEQ_REGEXP SEQ_REGEXP53 = new SEQ_REGEXP();
        SEQ_REGEXP53.text = "sub(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP53.AT_WORD_START = "TRUE";
        SEQ_REGEXP53.TYPE = "FUNCTION";
        SEQ_REGEXP53.HASH_CHAR = "sub";
        SEQ_REGEXP SEQ_REGEXP54 = new SEQ_REGEXP();
        SEQ_REGEXP54.text = "neg(_pp|_sat|_x2|_x4|_x8|_bx2|_d2|_d4|_d8)*\\b";
        SEQ_REGEXP54.AT_WORD_START = "TRUE";
        SEQ_REGEXP54.TYPE = "FUNCTION";
        SEQ_REGEXP54.HASH_CHAR = "neg";
        SEQ_REGEXP SEQ_REGEXP55 = new SEQ_REGEXP();
        SEQ_REGEXP55.text = "tex\\w*";
        SEQ_REGEXP55.AT_WORD_START = "TRUE";
        SEQ_REGEXP55.TYPE = "KEYWORD2";
        SEQ_REGEXP55.HASH_CHAR = "tex";
        SEQ_REGEXP SEQ_REGEXP56 = new SEQ_REGEXP();
        SEQ_REGEXP56.text = "ps\\w*";
        SEQ_REGEXP56.AT_WORD_START = "TRUE";
        SEQ_REGEXP56.TYPE = "KEYWORD1";
        SEQ_REGEXP56.HASH_CHAR = "ps";
        SEQ_REGEXP SEQ_REGEXP57 = new SEQ_REGEXP();
        SEQ_REGEXP57.text = "vs\\w*";
        SEQ_REGEXP57.AT_WORD_START = "TRUE";
        SEQ_REGEXP57.TYPE = "KEYWORD1";
        SEQ_REGEXP57.HASH_CHAR = "vs";
        SEQ_REGEXP SEQ_REGEXP58 = new SEQ_REGEXP();
        SEQ_REGEXP58.text = "def\\w*";
        SEQ_REGEXP58.AT_WORD_START = "TRUE";
        SEQ_REGEXP58.TYPE = "KEYWORD1";
        SEQ_REGEXP58.HASH_CHAR = "def";
        SEQ_REGEXP SEQ_REGEXP59 = new SEQ_REGEXP();
        SEQ_REGEXP59.text = "dcl\\w*";
        SEQ_REGEXP59.AT_WORD_START = "TRUE";
        SEQ_REGEXP59.TYPE = "KEYWORD1";
        SEQ_REGEXP59.HASH_CHAR = "dcl";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, SEQ_REGEXP4, SEQ_REGEXP5, SEQ_REGEXP6, SEQ_REGEXP7, SEQ_REGEXP8, SEQ_REGEXP9, SEQ_REGEXP10, SEQ_REGEXP11, SEQ_REGEXP12, SEQ_REGEXP13, SEQ_REGEXP14, SEQ_REGEXP15, SEQ_REGEXP16, SEQ_REGEXP17, SEQ_REGEXP18, SEQ_REGEXP19, SEQ_REGEXP20, SEQ_REGEXP21, SEQ_REGEXP22, SEQ_REGEXP23, SEQ_REGEXP24, SEQ_REGEXP25, SEQ_REGEXP26, SEQ_REGEXP27, SEQ_REGEXP28, SEQ_REGEXP29, SEQ_REGEXP30, SEQ_REGEXP31, SEQ_REGEXP32, SEQ_REGEXP33, SEQ_REGEXP34, SEQ_REGEXP35, SEQ_REGEXP36, SEQ_REGEXP37, SEQ_REGEXP38, SEQ_REGEXP39, SEQ_REGEXP40, SEQ_REGEXP41, SEQ_REGEXP42, SEQ_REGEXP43, SEQ_REGEXP44, SEQ_REGEXP45, SEQ_REGEXP46, SEQ_REGEXP47, SEQ_REGEXP48, SEQ_REGEXP49, SEQ_REGEXP50, SEQ_REGEXP51, SEQ_REGEXP52, SEQ_REGEXP53, SEQ_REGEXP54, SEQ_REGEXP55, SEQ_REGEXP56, SEQ_REGEXP57, SEQ_REGEXP58, SEQ_REGEXP59, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), RULES4(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
