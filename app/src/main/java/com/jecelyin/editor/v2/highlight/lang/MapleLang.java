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
public class MapleLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "//";
        PROPERTY1.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "FALSE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "FALSE";
        SPAN2.TYPE = "LITERAL1";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "FALSE";
        SPAN3.TYPE = "LITERAL1";
        SPAN3.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "`";
        END END3 = new END();
        END3.text = "`";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "COMMENT1";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "+";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "-";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "*";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "/";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "^";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "<>";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "<=";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "<";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = ">=";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = ">";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "=";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "$";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "@@";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "@";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "||";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = ":=";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "::";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = ":-";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "&";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "!";
        SEQ20.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"Catalan", "constants", "Digits", "FAIL", "false", "gamma", "I", "infinity", "integrate", "lasterror", "libname", "`mod`", "NULL", "Order", "Pi", "printlevel", "true", "undefined", });
        KEYWORDS1.add("KEYWORD1", new String[]{"and", "or", "xor", "union", "intersect", "minus", "mod", "not", "assuming", "break", "by", "catch", "description", "do", "done", "elif", "else", "end", "error", "export", "fi", "finally", "for", "from", "global", "if", "implies", "in", "local", "module", "next", "od", "option", "options", "proc", "quit", "read", "return", "save", "stop", "subset", "then", "to", "try", "use", "while", });
        KEYWORDS1.add("FUNCTION", new String[]{"about", "ans", "add", "addcoords", "additionally", "addproperty", "addressof", "AFactor", "AFactors", "AIrreduc", "AiryAi", "AiryAiZeros", "AiryBi", "AiryBiZeros", "algebraic", "algsubs", "alias", "allvalues", "anames", "AngerJ", "antihermitian", "antisymm", "apply", "applyop", "applyrule", "arccos", "arccosh", "arccot", "arccoth", "arccsc", "arccsch", "arcsec", "arcsech", "arcsin", "arcsinh", "arctan", "arctanh", "argument", "Array", "array", "ArrayDims", "ArrayElems", "ArrayIndFns", "ArrayOptions", "assign", "assigned", "asspar", "assume", "asympt", "attributes", "band", "Berlekamp", "bernoulli", "bernstein", "BesselI", "BesselJ", "BesselJZeros", "BesselK", "BesselY", "BesselYZeros", "Beta", "branches", "C", "cat", "ceil", "changecoords", "charfcn", "ChebyshevT", "ChebyShevU", "CheckArgs", "Chi", "chrem", "Ci", "close", "coeff", "coeffs", "coeftayl", "collect", "combine", "comparray", "compiletable", "compoly", "CompSeq", "conjugate", "constant", "Content", "content", "convergs", "convert", "coords", "copy", "CopySign", "cos", "cosh", "cot", "coth", "coulditbe", "csc", "csch", "csgn", "currentdir", "curry", "CylinderD", "CylinderU", "CylinderV", "D", "dawson", "Default0", "DefaultOverflow", "DefaultUnderflow", "define", "define_external", "degree", "denom", "depends", "DESol", "Det", "diagon", "Diff", "diff", "diffop", "Digits", "dilog", "dinterp", "Dirac", "disassemble", "discont", "discrim", "dismantle", "DistDeg", "Divide", "divide", "dsolve", "efficiency", "Ei", "Eigenvals", "eliminate", "ellipsoid", "EllipticCE", "EllipticCK", "EllipticCPi", "EllipticE", "EllipticF", "EllipticK", "EllipticModulus", "EllipticNome", "EllipticPi", "elliptic_int", "entries", "erf", "erfc", "erfi", "euler", "eulermac", "Eval", "eval", "evala", "evalapply", "evalb", "evalc", "evalf", "evalfint", "evalhf", "evalm", "evaln", "evalr", "evalrC", "events", "Excel", "exists", "exp", "Expand", "expand", "expandoff", "expandon", "exports", "extract", "extrema", "Factor", "factor", "Factors", "factors", "fclose", "fdiscont", "feof", "fflush", "FFT", "filepos", "fixdiv", "float", "floor", "fnormal", "fold", "fopen", "forall", "forget", "fprintf", "frac", "freeze", "frem", "fremove", "FresnelC", "Fresnelf", "Fresnelg", "FresnelS", "FromInert", "frontend", "fscanf", "fsolve", "galois", "GAMMA", "GaussAGM", "Gausselim", "Gaussjord", "gc", "Gcd", "gcd", "Gcdex", "gcdex", "GegenbauerC", "genpoly", "getenv", "GetResultDataType", "GetResultShape", "GF", "Greek", "HankelH1", "HankelH2", "harmonic", "has", "hasfun", "hasoption", "hastype", "heap", "Heaviside", "Hermite", "HermiteH", "hermitian", "Hessenberg", "hfarray", "history", "hypergeom", "icontent", "identity", "IEEEdiffs", "ifactor", "ifactors", "iFFT", "igcd", "igcdex", "ilcm", "ilog10", "ilog2", "ilog", "Im", "implicitdiff", "ImportMatrix", "ImportVector", "indets", "index", "indexed", "indices", "inifcn", "ininame", "initialcondition", "initialize", "insert", "int", "intat", "interface", "Interp", "interp", "Inverse", "invfunc", "invztrans", "iostatus", "iperfpow", "iquo", "iratrecon", "irem", "iroot", "Irreduc", "irreduc", "is", "iscont", "isdifferential", "IsMatrixShape", "isolate", "isolve", "ispoly", "isprime", "isqrfree", "isqrt", "issqr", "ithprime", "JacobiAM", "JacobiCD", "JacobiCN", "JacobiCS", "JacobiDC", "JacobiDN", "JacobiDS", "JacobiNC", "JacobiND", "JacobiNS", "JacobiP", "JacobiSC", "JacobiSD", "JacobiSN", "JacobiTheta1", "JacobiTheta2", "JacobiTheta3", "JacobiTheta4", "JacobiZeta", "KelvinBei", "KelvinBer", "KelvinHei", "KelvinHer", "KelvinKei", "KelvinKer", "KummerM", "KummerU", "LaguerreL", "LambertW", "latex", "lattice", "lcm", "Lcm", "lcoeff", "leadterm", "LegendreP", "LegendreQ", "length", "LerchPhi", "lexorder", "lhs", "CLi", "Limit", "limit", "Linsolve", "ln", "lnGAMMA", "log", "log10", "LommelS1", "Lommels2", "lprint", "map", "map2", "Maple_floats", "match", "MatlabMatrix", "Matrix", "matrix", "MatrixOptions", "max", "maximize", "maxnorm", "maxorder", "MeijerG", "member", "min", "minimize", "mkdir", "ModifiedMeijerG", "modp", "modp1", "modp2", "modpol", "mods", "module", "MOLS", "msolve", "mtaylor", "mul", "NextAfter", "nextprime", "nops", "norm", "norm", "Normal", "normal", "nprintf", "Nullspace", "numboccur", "numer", "NumericClass", "NumericEvent", "NumericEventHandler", "NumericException", "numerics", "NumericStatus", "odetest", "op", "open", "order", "OrderedNE", "parse", "patmatch", "pclose", "PDEplot_options", "pdesolve", "pdetest", "pdsolve", "piecewise", "plot", "plot3d", "plotsetup", "pochhammer", "pointto", "poisson", "polar", "polylog", "polynom", "Power", "Powmod", "powmod", "Prem", "prem", "Preprocessor", "prevprime", "Primitive", "Primpart", "primpart", "print", "printf", "ProbSplit", "procbody", "ProcessOptions", "procmake", "Product", "product", "proot", "property", "protect", "Psi", "psqrt", "queue", "Quo", "quo", "radfield", "radnormal", "radsimp", "rand", "randomize", "Randpoly", "randpoly", "Randprime", "range", "ratinterp", "rationalize", "Ratrecon", "ratrecon", "Re", "readbytes", "readdata", "readlib", "readline", "readstat", "realroot", "Record", "Reduce", "references", "release", "Rem", "rem", "remove", "repository", "requires", "residue", "RESol", "Resultant", "resultant", "rhs", "rmdir", "root", "rootbound", "RootOf", "Roots", "roots", "round", "Rounding", "rsolve", "rtable", "rtable_algebra", "rtable_dims", "rtable_elems", "rtable_indfns", "rtable_options", "rtable_printf", "rtable_scanf", "SampleRTable", "savelib", "Scale10", "Scale2", "scalar", "scan", "scanf", "SearchText", "searchtext", "sec", "sech", "select", "selectfun", "selectremove", "seq", "series", "setattribute", "SFloatExponent", "SFloatMantissa", "shale", "Shi", "showprofile", "showtime", "Si", "sign", "signum", "Simplify", "simplify", "sin", "sinh", "singular", "sinterp", "smartplot3d", "Smith", "solve", "solvefor", "sort", "sparse", "spec_eval_rule", "spline", "spreadsheet", "SPrem", "sprem", "sprintf", "Sqrfree", "sqrfree", "sqrt", "sscanf", "Ssi", "ssystem", "storage", "string", "StruveH", "StruveL", "sturm", "sturmseq", "subs", "subsindets", "subsop", "substring", "subtype", "Sum", "sum", "surd", "Svd", "symmdiff", "symmetric", "syntax", "system", "table", "tan", "tang", "taylor", "testeq", "testfloat", "TEXT", "thaw", "thiele", "time", "timelimit", "ToInert", "TopologicalSort", "traperror", "triangular", "trigsubs", "trunc", "type", "typematch", "unames", "unapply", "unassign", "undefined", "unit", "Unordered", "unprotect", "update", "UseHardwareFloats", "userinfo", "value", "Vector", "vector", "verify", "WeierstrassP", "WeberE", "WeierstrassPPrime", "WeierstrassSigma", "WeierstrassZeta", "whattype", "WhittakerM", "WhittakerW", "with", "worksheet", "writebytes", "writedata", "writeline", "writestat", "writeto", "zero", "Zeta", "zip", "ztrans", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, };

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
