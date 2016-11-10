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
public class PlaintexLang implements LangDefine {
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
        RULES1.IGNORE_CASE = "FALSE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "%";
        EOL_SPAN1.TYPE = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "OPERATOR";
        SPAN1.DELEGATE = "MATH";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "$$";
        END END1 = new END();
        END1.text = "$$";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "OPERATOR";
        SPAN2.DELEGATE = "MATH";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "$";
        END END2 = new END();
        END2.text = "$";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "\\\\[a-zA-Z@]{25}[a-zA-Z@]*";
        SEQ_REGEXP1.HASH_CHARS = "\\";
        SEQ_REGEXP1.TYPE = "LABEL";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "\\interfootnotelinepenalty";
        SEQ1.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "\\\\[a-zA-Z@]{24}";
        SEQ_REGEXP2.HASH_CHARS = "\\";
        SEQ_REGEXP2.TYPE = "LABEL";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "\\interdisplaylinepenalty";
        SEQ2.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "\\\\[a-zA-Z@]{23}";
        SEQ_REGEXP3.HASH_CHARS = "\\";
        SEQ_REGEXP3.TYPE = "LABEL";
        SEQ_REGEXP SEQ_REGEXP4 = new SEQ_REGEXP();
        SEQ_REGEXP4.text = "\\\\[a-zA-Z@]{22}";
        SEQ_REGEXP4.HASH_CHARS = "\\";
        SEQ_REGEXP4.TYPE = "LABEL";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "\\belowdisplayshortskip";
        SEQ3.TYPE = "KEYWORD4";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "\\abovedisplayshortskip";
        SEQ4.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP5 = new SEQ_REGEXP();
        SEQ_REGEXP5.text = "\\\\[a-zA-Z@]{21}";
        SEQ_REGEXP5.HASH_CHARS = "\\";
        SEQ_REGEXP5.TYPE = "LABEL";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "\\doublehyphendemerits";
        SEQ5.TYPE = "KEYWORD4";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "\\abovedisplayshortskip";
        SEQ6.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP6 = new SEQ_REGEXP();
        SEQ_REGEXP6.text = "\\\\[a-zA-Z@]{20}";
        SEQ_REGEXP6.HASH_CHARS = "\\";
        SEQ_REGEXP6.TYPE = "LABEL";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "\\normallineskiplimit";
        SEQ7.TYPE = "KEYWORD1";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "\\finalhyphendemerits";
        SEQ8.TYPE = "KEYWORD4";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "\\displaywidowpenalty";
        SEQ9.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP7 = new SEQ_REGEXP();
        SEQ_REGEXP7.text = "\\\\[a-zA-Z@]{19}";
        SEQ_REGEXP7.HASH_CHARS = "\\";
        SEQ_REGEXP7.TYPE = "LABEL";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "\\postdisplaypenalty";
        SEQ10.TYPE = "KEYWORD4";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "\\nulldelimiterspace";
        SEQ11.TYPE = "KEYWORD4";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "\\normalbaselineskip";
        SEQ12.TYPE = "KEYWORD1";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "\\Longleftrightarrow";
        SEQ13.TYPE = "KEYWORD1";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "\\longleftrightarrow";
        SEQ14.TYPE = "KEYWORD1";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "\\delimitershortfall";
        SEQ15.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP8 = new SEQ_REGEXP();
        SEQ_REGEXP8.text = "\\\\[a-zA-Z@]{18}";
        SEQ_REGEXP8.HASH_CHARS = "\\";
        SEQ_REGEXP8.TYPE = "LABEL";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "\\tracingparagraphs";
        SEQ16.TYPE = "KEYWORD4";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "\\scriptscriptstyle";
        SEQ17.TYPE = "KEYWORD1";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "\\rightleftharpoons";
        SEQ18.TYPE = "KEYWORD1";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "\\predisplaypenalty";
        SEQ19.TYPE = "KEYWORD1";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "\\errorcontextlines";
        SEQ20.TYPE = "KEYWORD4";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "\\defaulthyphenchar";
        SEQ21.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP9 = new SEQ_REGEXP();
        SEQ_REGEXP9.text = "\\\\[a-zA-Z@]{17}";
        SEQ_REGEXP9.HASH_CHARS = "\\";
        SEQ_REGEXP9.TYPE = "LABEL";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "\\tracinglostchars";
        SEQ22.TYPE = "KEYWORD4";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "\\scriptscriptfont";
        SEQ23.TYPE = "KEYWORD1";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "\\rightharpoondown";
        SEQ24.TYPE = "KEYWORD1";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "\\predisplaypenaty";
        SEQ25.TYPE = "KEYWORD4";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = "\\pagefilllstretch";
        SEQ26.TYPE = "KEYWORD1";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "\\offinterlineskip";
        SEQ27.TYPE = "KEYWORD1";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "\\nonfrenchspacing";
        SEQ28.TYPE = "KEYWORD1";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = "\\interlinepenalty";
        SEQ29.TYPE = "KEYWORD4";
        SEQ SEQ30 = new SEQ();
        SEQ30.text = "\\emergencystretch";
        SEQ30.TYPE = "KEYWORD4";
        SEQ SEQ31 = new SEQ();
        SEQ31.text = "\\belowdisplayskip";
        SEQ31.TYPE = "KEYWORD4";
        SEQ SEQ32 = new SEQ();
        SEQ32.text = "\\allocationnumber";
        SEQ32.TYPE = "KEYWORD1";
        SEQ SEQ33 = new SEQ();
        SEQ33.text = "\\abovedisplayskip";
        SEQ33.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP10 = new SEQ_REGEXP();
        SEQ_REGEXP10.text = "\\\\[a-zA-Z@]{16}";
        SEQ_REGEXP10.HASH_CHARS = "\\";
        SEQ_REGEXP10.TYPE = "LABEL";
        SEQ SEQ34 = new SEQ();
        SEQ34.text = "\\tracingrestores";
        SEQ34.TYPE = "KEYWORD4";
        SEQ SEQ35 = new SEQ();
        SEQ35.text = "\\tracingcommands";
        SEQ35.TYPE = "KEYWORD4";
        SEQ SEQ36 = new SEQ();
        SEQ36.text = "\\smallskipamount";
        SEQ36.TYPE = "KEYWORD1";
        SEQ SEQ37 = new SEQ();
        SEQ37.text = "\\pagefillstretch";
        SEQ37.TYPE = "KEYWORD1";
        SEQ SEQ38 = new SEQ();
        SEQ38.text = "\\normalbaselines";
        SEQ38.TYPE = "KEYWORD1";
        SEQ SEQ39 = new SEQ();
        SEQ39.text = "\\nointerlineskip";
        SEQ39.TYPE = "KEYWORD1";
        SEQ SEQ40 = new SEQ();
        SEQ40.text = "\\leftharpoondown";
        SEQ40.TYPE = "KEYWORD1";
        SEQ SEQ41 = new SEQ();
        SEQ41.text = "\\insertpenalties";
        SEQ41.TYPE = "KEYWORD1";
        SEQ SEQ42 = new SEQ();
        SEQ42.text = "\\floatingpenalty";
        SEQ42.TYPE = "KEYWORD4";
        SEQ SEQ43 = new SEQ();
        SEQ43.text = "\\exhyphenpenalty";
        SEQ43.TYPE = "KEYWORD4";
        SEQ SEQ44 = new SEQ();
        SEQ44.text = "\\delimiterfactor";
        SEQ44.TYPE = "KEYWORD4";
        SEQ SEQ45 = new SEQ();
        SEQ45.text = "\\defaultskewchar";
        SEQ45.TYPE = "KEYWORD4";
        SEQ SEQ46 = new SEQ();
        SEQ46.text = "\\bigtriangledown";
        SEQ46.TYPE = "KEYWORD1";
        SEQ SEQ47 = new SEQ();
        SEQ47.text = "\\afterassignment";
        SEQ47.TYPE = "KEYWORD1";
        SEQ SEQ48 = new SEQ();
        SEQ48.text = "\\abovewithdelims";
        SEQ48.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP11 = new SEQ_REGEXP();
        SEQ_REGEXP11.text = "\\\\[a-zA-Z@]{15}";
        SEQ_REGEXP11.HASH_CHARS = "\\";
        SEQ_REGEXP11.TYPE = "LABEL";
        SEQ SEQ49 = new SEQ();
        SEQ49.text = "\\splitfirstmark";
        SEQ49.TYPE = "KEYWORD1";
        SEQ SEQ50 = new SEQ();
        SEQ50.text = "\\showboxbreadth";
        SEQ50.TYPE = "KEYWORD4";
        SEQ SEQ51 = new SEQ();
        SEQ51.text = "\\righthyphenmin";
        SEQ51.TYPE = "KEYWORD4";
        SEQ SEQ52 = new SEQ();
        SEQ52.text = "\\rightharpoonup";
        SEQ52.TYPE = "KEYWORD1";
        SEQ SEQ53 = new SEQ();
        SEQ53.text = "\\rightarrowfill";
        SEQ53.TYPE = "KEYWORD1";
        SEQ SEQ54 = new SEQ();
        SEQ54.text = "\\removelastskip";
        SEQ54.TYPE = "KEYWORD1";
        SEQ SEQ55 = new SEQ();
        SEQ55.text = "\\predisplaysize";
        SEQ55.TYPE = "KEYWORD4";
        SEQ SEQ56 = new SEQ();
        SEQ56.text = "\\pagefilstretch";
        SEQ56.TYPE = "KEYWORD1";
        SEQ SEQ57 = new SEQ();
        SEQ57.text = "\\overwithdelims";
        SEQ57.TYPE = "KEYWORD1";
        SEQ SEQ58 = new SEQ();
        SEQ58.text = "\\overrightarrow";
        SEQ58.TYPE = "KEYWORD1";
        SEQ SEQ59 = new SEQ();
        SEQ59.text = "\\normallineskip";
        SEQ59.TYPE = "KEYWORD1";
        SEQ SEQ60 = new SEQ();
        SEQ60.text = "\\longrightarrow";
        SEQ60.TYPE = "KEYWORD1";
        SEQ SEQ61 = new SEQ();
        SEQ61.text = "\\Longrightarrow";
        SEQ61.TYPE = "KEYWORD1";
        SEQ SEQ62 = new SEQ();
        SEQ62.text = "\\Leftrightarrow";
        SEQ62.TYPE = "KEYWORD1";
        SEQ SEQ63 = new SEQ();
        SEQ63.text = "\\leftrightarrow";
        SEQ63.TYPE = "KEYWORD1";
        SEQ SEQ64 = new SEQ();
        SEQ64.text = "\\hookrightarrow";
        SEQ64.TYPE = "KEYWORD1";
        SEQ SEQ65 = new SEQ();
        SEQ65.text = "\\holdinginserts";
        SEQ65.TYPE = "KEYWORD4";
        SEQ SEQ66 = new SEQ();
        SEQ66.text = "\\atopwithdelims";
        SEQ66.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP12 = new SEQ_REGEXP();
        SEQ_REGEXP12.text = "\\\\[a-zA-Z@]{14}";
        SEQ_REGEXP12.HASH_CHARS = "\\";
        SEQ_REGEXP12.TYPE = "LABEL";
        SEQ SEQ67 = new SEQ();
        SEQ67.text = "\\ttraggedright";
        SEQ67.TYPE = "KEYWORD1";
        SEQ SEQ68 = new SEQ();
        SEQ68.text = "\\triangleright";
        SEQ68.TYPE = "KEYWORD1";
        SEQ SEQ69 = new SEQ();
        SEQ69.text = "\\tracingoutput";
        SEQ69.TYPE = "KEYWORD4";
        SEQ SEQ70 = new SEQ();
        SEQ70.text = "\\tracingonline";
        SEQ70.TYPE = "KEYWORD4";
        SEQ SEQ71 = new SEQ();
        SEQ71.text = "\\tracingmacros";
        SEQ71.TYPE = "KEYWORD4";
        SEQ SEQ72 = new SEQ();
        SEQ72.text = "\\splitmaxdepth";
        SEQ72.TYPE = "KEYWORD4";
        SEQ SEQ73 = new SEQ();
        SEQ73.text = "\\overleftarrow";
        SEQ73.TYPE = "KEYWORD1";
        SEQ SEQ74 = new SEQ();
        SEQ74.text = "\\outputpenalty";
        SEQ74.TYPE = "KEYWORD4";
        SEQ SEQ75 = new SEQ();
        SEQ75.text = "\\nopagenumbers";
        SEQ75.TYPE = "KEYWORD1";
        SEQ SEQ76 = new SEQ();
        SEQ76.text = "\\medskipamount";
        SEQ76.TYPE = "KEYWORD1";
        SEQ SEQ77 = new SEQ();
        SEQ77.text = "\\maxdeadcycles";
        SEQ77.TYPE = "KEYWORD4";
        SEQ SEQ78 = new SEQ();
        SEQ78.text = "\\magnification";
        SEQ78.TYPE = "KEYWORD1";
        SEQ SEQ79 = new SEQ();
        SEQ79.text = "\\Longleftarrow";
        SEQ79.TYPE = "KEYWORD1";
        SEQ SEQ80 = new SEQ();
        SEQ80.text = "\\longleftarrow";
        SEQ80.TYPE = "KEYWORD1";
        SEQ SEQ81 = new SEQ();
        SEQ81.text = "\\lineskiplimit";
        SEQ81.TYPE = "KEYWORD4";
        SEQ SEQ82 = new SEQ();
        SEQ82.text = "\\lefthyphenmin";
        SEQ82.TYPE = "KEYWORD4";
        SEQ SEQ83 = new SEQ();
        SEQ83.text = "\\leftharpoonup";
        SEQ83.TYPE = "KEYWORD1";
        SEQ SEQ84 = new SEQ();
        SEQ84.text = "\\leftarrowfill";
        SEQ84.TYPE = "KEYWORD1";
        SEQ SEQ85 = new SEQ();
        SEQ85.text = "\\hyphenpenalty";
        SEQ85.TYPE = "KEYWORD4";
        SEQ SEQ86 = new SEQ();
        SEQ86.text = "\\hookleftarrow";
        SEQ86.TYPE = "KEYWORD1";
        SEQ SEQ87 = new SEQ();
        SEQ87.text = "\\frenchspacing";
        SEQ87.TYPE = "KEYWORD1";
        SEQ SEQ88 = new SEQ();
        SEQ88.text = "\\errorstopmode";
        SEQ88.TYPE = "KEYWORD1";
        SEQ SEQ89 = new SEQ();
        SEQ89.text = "\\downbracefill";
        SEQ89.TYPE = "KEYWORD1";
        SEQ SEQ90 = new SEQ();
        SEQ90.text = "\\displaylimits";
        SEQ90.TYPE = "KEYWORD1";
        SEQ SEQ91 = new SEQ();
        SEQ91.text = "\\displayindent";
        SEQ91.TYPE = "KEYWORD4";
        SEQ SEQ92 = new SEQ();
        SEQ92.text = "\\discretionary";
        SEQ92.TYPE = "KEYWORD1";
        SEQ SEQ93 = new SEQ();
        SEQ93.text = "\\brokenpenalty";
        SEQ93.TYPE = "KEYWORD4";
        SEQ SEQ94 = new SEQ();
        SEQ94.text = "\\bigtriangleup";
        SEQ94.TYPE = "KEYWORD1";
        SEQ SEQ95 = new SEQ();
        SEQ95.text = "\\bigskipamount";
        SEQ95.TYPE = "KEYWORD1";
        SEQ SEQ96 = new SEQ();
        SEQ96.text = "\\advancepageno";
        SEQ96.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP13 = new SEQ_REGEXP();
        SEQ_REGEXP13.text = "\\\\[a-zA-Z@]{13}";
        SEQ_REGEXP13.HASH_CHARS = "\\";
        SEQ_REGEXP13.TYPE = "LABEL";
        SEQ SEQ97 = new SEQ();
        SEQ97.text = "\\widowpenalty";
        SEQ97.TYPE = "KEYWORD4";
        SEQ SEQ98 = new SEQ();
        SEQ98.text = "\\triangleleft";
        SEQ98.TYPE = "KEYWORD1";
        SEQ SEQ99 = new SEQ();
        SEQ99.text = "\\tracingstats";
        SEQ99.TYPE = "KEYWORD4";
        SEQ SEQ100 = new SEQ();
        SEQ100.text = "\\tracingpages";
        SEQ100.TYPE = "KEYWORD4";
        SEQ SEQ101 = new SEQ();
        SEQ101.text = "\\splittopskip";
        SEQ101.TYPE = "KEYWORD4";
        SEQ SEQ102 = new SEQ();
        SEQ102.text = "\\splitbotmark";
        SEQ102.TYPE = "KEYWORD1";
        SEQ SEQ103 = new SEQ();
        SEQ103.text = "\\showboxdepth";
        SEQ103.TYPE = "KEYWORD4";
        SEQ SEQ104 = new SEQ();
        SEQ104.text = "\\romannumeral";
        SEQ104.TYPE = "KEYWORD1";
        SEQ SEQ105 = new SEQ();
        SEQ105.text = "\\raggedbottom";
        SEQ105.TYPE = "KEYWORD1";
        SEQ SEQ106 = new SEQ();
        SEQ106.text = "\\pretolerance";
        SEQ106.TYPE = "KEYWORD4";
        SEQ SEQ107 = new SEQ();
        SEQ107.text = "\\pagecontents";
        SEQ107.TYPE = "KEYWORD1";
        SEQ SEQ108 = new SEQ();
        SEQ108.text = "\\overfullrule";
        SEQ108.TYPE = "KEYWORD4";
        SEQ SEQ109 = new SEQ();
        SEQ109.text = "\\normalbottom";
        SEQ109.TYPE = "KEYWORD1";
        SEQ SEQ110 = new SEQ();
        SEQ110.text = "\\negthinspace";
        SEQ110.TYPE = "KEYWORD1";
        SEQ SEQ111 = new SEQ();
        SEQ111.text = "\\mathsurround";
        SEQ111.TYPE = "KEYWORD4";
        SEQ SEQ112 = new SEQ();
        SEQ112.text = "\\makeheadline";
        SEQ112.TYPE = "KEYWORD1";
        SEQ SEQ113 = new SEQ();
        SEQ113.text = "\\makefootline";
        SEQ113.TYPE = "KEYWORD1";
        SEQ SEQ114 = new SEQ();
        SEQ114.text = "\\ignorespaces";
        SEQ114.TYPE = "KEYWORD1";
        SEQ SEQ115 = new SEQ();
        SEQ115.text = "\\footnoterule";
        SEQ115.TYPE = "KEYWORD1";
        SEQ SEQ116 = new SEQ();
        SEQ116.text = "\\everydisplay";
        SEQ116.TYPE = "KEYWORD4";
        SEQ SEQ117 = new SEQ();
        SEQ117.text = "\\dosupereject";
        SEQ117.TYPE = "KEYWORD1";
        SEQ SEQ118 = new SEQ();
        SEQ118.text = "\\displaywidth";
        SEQ118.TYPE = "KEYWORD4";
        SEQ SEQ119 = new SEQ();
        SEQ119.text = "\\displaystyle";
        SEQ119.TYPE = "KEYWORD1";
        SEQ SEQ120 = new SEQ();
        SEQ120.text = "\\displaylines";
        SEQ120.TYPE = "KEYWORD1";
        SEQ SEQ121 = new SEQ();
        SEQ121.text = "\\bordermatrix";
        SEQ121.TYPE = "KEYWORD1";
        SEQ SEQ122 = new SEQ();
        SEQ122.text = "\\binoppenalty";
        SEQ122.TYPE = "KEYWORD4";
        SEQ SEQ123 = new SEQ();
        SEQ123.text = "\\beginsection";
        SEQ123.TYPE = "KEYWORD1";
        SEQ SEQ124 = new SEQ();
        SEQ124.text = "\\baselineskip";
        SEQ124.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP14 = new SEQ_REGEXP();
        SEQ_REGEXP14.text = "\\\\[a-zA-Z@]{12}";
        SEQ_REGEXP14.HASH_CHARS = "\\";
        SEQ_REGEXP14.TYPE = "LABEL";
        SEQ SEQ125 = new SEQ();
        SEQ125.text = "\\Updownarrow";
        SEQ125.TYPE = "KEYWORD1";
        SEQ SEQ126 = new SEQ();
        SEQ126.text = "\\updownarrow";
        SEQ126.TYPE = "KEYWORD1";
        SEQ SEQ127 = new SEQ();
        SEQ127.text = "\\upbracefill";
        SEQ127.TYPE = "KEYWORD1";
        SEQ SEQ128 = new SEQ();
        SEQ128.text = "\\thickmuskip";
        SEQ128.TYPE = "KEYWORD4";
        SEQ SEQ129 = new SEQ();
        SEQ129.text = "\\spacefactor";
        SEQ129.TYPE = "KEYWORD1";
        SEQ SEQ130 = new SEQ();
        SEQ130.text = "\\showhyphens";
        SEQ130.TYPE = "KEYWORD1";
        SEQ SEQ131 = new SEQ();
        SEQ131.text = "\\scriptstyle";
        SEQ131.TYPE = "KEYWORD1";
        SEQ SEQ132 = new SEQ();
        SEQ132.text = "\\scriptspace";
        SEQ132.TYPE = "KEYWORD4";
        SEQ SEQ133 = new SEQ();
        SEQ133.text = "\\raggedright";
        SEQ133.TYPE = "KEYWORD1";
        SEQ SEQ134 = new SEQ();
        SEQ134.text = "\\plainoutput";
        SEQ134.TYPE = "KEYWORD1";
        SEQ SEQ135 = new SEQ();
        SEQ135.text = "\\parfillskip";
        SEQ135.TYPE = "KEYWORD4";
        SEQ SEQ136 = new SEQ();
        SEQ136.text = "\\pagestretch";
        SEQ136.TYPE = "KEYWORD1";
        SEQ SEQ137 = new SEQ();
        SEQ137.text = "\\nonstopmode";
        SEQ137.TYPE = "KEYWORD1";
        SEQ SEQ138 = new SEQ();
        SEQ138.text = "\\newlinechar";
        SEQ138.TYPE = "COMMENT2";
        SEQ SEQ139 = new SEQ();
        SEQ139.text = "\\mathpalette";
        SEQ139.TYPE = "KEYWORD1";
        SEQ SEQ140 = new SEQ();
        SEQ140.text = "\\mathchardef";
        SEQ140.TYPE = "FUNCTION";
        SEQ SEQ141 = new SEQ();
        SEQ141.text = "\\magstephalf";
        SEQ141.TYPE = "KEYWORD1";
        SEQ SEQ142 = new SEQ();
        SEQ142.text = "\\linepenalty";
        SEQ142.TYPE = "KEYWORD4";
        SEQ SEQ143 = new SEQ();
        SEQ143.text = "\\lastpenalty";
        SEQ143.TYPE = "KEYWORD1";
        SEQ SEQ144 = new SEQ();
        SEQ144.text = "\\hyphenation";
        SEQ144.TYPE = "KEYWORD1";
        SEQ SEQ145 = new SEQ();
        SEQ145.text = "\\expandafter";
        SEQ145.TYPE = "KEYWORD1";
        SEQ SEQ146 = new SEQ();
        SEQ146.text = "\\endlinechar";
        SEQ146.TYPE = "KEYWORD4";
        SEQ SEQ147 = new SEQ();
        SEQ147.text = "\\diamondsuit";
        SEQ147.TYPE = "KEYWORD1";
        SEQ SEQ148 = new SEQ();
        SEQ148.text = "\\clubpenalty";
        SEQ148.TYPE = "KEYWORD4";
        SEQ SEQ149 = new SEQ();
        SEQ149.text = "\\boxmaxdepth";
        SEQ149.TYPE = "KEYWORD4";
        SEQ SEQ150 = new SEQ();
        SEQ150.text = "\\adjdemerits";
        SEQ150.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP15 = new SEQ_REGEXP();
        SEQ_REGEXP15.text = "\\\\[a-zA-Z@]{11}";
        SEQ_REGEXP15.HASH_CHARS = "\\";
        SEQ_REGEXP15.TYPE = "LABEL";
        SEQ SEQ151 = new SEQ();
        SEQ151.text = "\\xspaceskip";
        SEQ151.TYPE = "KEYWORD4";
        SEQ SEQ152 = new SEQ();
        SEQ152.text = "\\varepsilon";
        SEQ152.TYPE = "KEYWORD1";
        SEQ SEQ153 = new SEQ();
        SEQ153.text = "\\underbrace";
        SEQ153.TYPE = "KEYWORD1";
        SEQ SEQ154 = new SEQ();
        SEQ154.text = "\\tracingall";
        SEQ154.TYPE = "KEYWORD1";
        SEQ SEQ155 = new SEQ();
        SEQ155.text = "\\thinmuskip";
        SEQ155.TYPE = "KEYWORD4";
        SEQ SEQ156 = new SEQ();
        SEQ156.text = "\\textindent";
        SEQ156.TYPE = "KEYWORD1";
        SEQ SEQ157 = new SEQ();
        SEQ157.text = "\\supereject";
        SEQ157.TYPE = "KEYWORD1";
        SEQ SEQ158 = new SEQ();
        SEQ158.text = "\\sqsupseteq";
        SEQ158.TYPE = "KEYWORD1";
        SEQ SEQ159 = new SEQ();
        SEQ159.text = "\\smallbreak";
        SEQ159.TYPE = "KEYWORD1";
        SEQ SEQ160 = new SEQ();
        SEQ160.text = "\\scrollmode";
        SEQ160.TYPE = "KEYWORD1";
        SEQ SEQ161 = new SEQ();
        SEQ161.text = "\\scriptfont";
        SEQ161.TYPE = "KEYWORD1";
        SEQ SEQ162 = new SEQ();
        SEQ162.text = "\\rmoustache";
        SEQ162.TYPE = "KEYWORD1";
        SEQ SEQ163 = new SEQ();
        SEQ163.text = "\\Rightarrow";
        SEQ163.TYPE = "KEYWORD1";
        SEQ SEQ164 = new SEQ();
        SEQ164.text = "\\rightarrow";
        SEQ164.TYPE = "KEYWORD1";
        SEQ SEQ165 = new SEQ();
        SEQ165.text = "\\relpenalty";
        SEQ165.TYPE = "KEYWORD4";
        SEQ SEQ166 = new SEQ();
        SEQ166.text = "\\pageshrink";
        SEQ166.TYPE = "KEYWORD1";
        SEQ SEQ167 = new SEQ();
        SEQ167.text = "\\pageinsert";
        SEQ167.TYPE = "KEYWORD1";
        SEQ SEQ168 = new SEQ();
        SEQ168.text = "\\obeyspaces";
        SEQ168.TYPE = "KEYWORD1";
        SEQ SEQ169 = new SEQ();
        SEQ169.text = "\\mathhexbox";
        SEQ169.TYPE = "KEYWORD1";
        SEQ SEQ170 = new SEQ();
        SEQ170.text = "\\mathchoice";
        SEQ170.TYPE = "KEYWORD1";
        SEQ SEQ171 = new SEQ();
        SEQ171.text = "\\mathaccent";
        SEQ171.TYPE = "KEYWORD1";
        SEQ SEQ172 = new SEQ();
        SEQ172.text = "\\mapstochar";
        SEQ172.TYPE = "KEYWORD1";
        SEQ SEQ173 = new SEQ();
        SEQ173.text = "\\longmapsto";
        SEQ173.TYPE = "KEYWORD1";
        SEQ SEQ174 = new SEQ();
        SEQ174.text = "\\lmoustache";
        SEQ174.TYPE = "KEYWORD1";
        SEQ SEQ175 = new SEQ();
        SEQ175.text = "\\leqalignno";
        SEQ175.TYPE = "KEYWORD1";
        SEQ SEQ176 = new SEQ();
        SEQ176.text = "\\leavevmode";
        SEQ176.TYPE = "KEYWORD1";
        SEQ SEQ177 = new SEQ();
        SEQ177.text = "\\hyphenchar";
        SEQ177.TYPE = "KEYWORD1";
        SEQ SEQ178 = new SEQ();
        SEQ178.text = "\\hangindent";
        SEQ178.TYPE = "KEYWORD4";
        SEQ SEQ179 = new SEQ();
        SEQ179.text = "\\globaldefs";
        SEQ179.TYPE = "KEYWORD4";
        SEQ SEQ180 = new SEQ();
        SEQ180.text = "\\fmtversion";
        SEQ180.TYPE = "KEYWORD1";
        SEQ SEQ181 = new SEQ();
        SEQ181.text = "\\escapechar";
        SEQ181.TYPE = "KEYWORD4";
        SEQ SEQ182 = new SEQ();
        SEQ182.text = "\\errmessage";
        SEQ182.TYPE = "KEYWORD1";
        SEQ SEQ183 = new SEQ();
        SEQ183.text = "\\dospecials";
        SEQ183.TYPE = "KEYWORD1";
        SEQ SEQ184 = new SEQ();
        SEQ184.text = "\\deadcycles";
        SEQ184.TYPE = "KEYWORD1";
        SEQ SEQ185 = new SEQ();
        SEQ185.text = "\\centerline";
        SEQ185.TYPE = "KEYWORD1";
        SEQ SEQ186 = new SEQ();
        SEQ186.text = "\\begingroup";
        SEQ186.TYPE = "KEYWORD1";
        SEQ SEQ187 = new SEQ();
        SEQ187.text = "\\allowbreak";
        SEQ187.TYPE = "KEYWORD1";
        SEQ SEQ188 = new SEQ();
        SEQ188.text = "\\aftergroup";
        SEQ188.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP16 = new SEQ_REGEXP();
        SEQ_REGEXP16.text = "\\\\[a-zA-Z@]{10}";
        SEQ_REGEXP16.HASH_CHARS = "\\";
        SEQ_REGEXP16.TYPE = "LABEL";
        SEQ SEQ189 = new SEQ();
        SEQ189.text = "\\widetilde";
        SEQ189.TYPE = "KEYWORD1";
        SEQ SEQ190 = new SEQ();
        SEQ190.text = "\\vfootnote";
        SEQ190.TYPE = "KEYWORD1";
        SEQ SEQ191 = new SEQ();
        SEQ191.text = "\\uppercase";
        SEQ191.TYPE = "KEYWORD1";
        SEQ SEQ192 = new SEQ();
        SEQ192.text = "\\unpenalty";
        SEQ192.TYPE = "KEYWORD1";
        SEQ SEQ193 = new SEQ();
        SEQ193.text = "\\underline";
        SEQ193.TYPE = "KEYWORD1";
        SEQ SEQ194 = new SEQ();
        SEQ194.text = "\\undefined";
        SEQ194.TYPE = "KEYWORD1";
        SEQ SEQ195 = new SEQ();
        SEQ195.text = "\\topinsert";
        SEQ195.TYPE = "KEYWORD1";
        SEQ SEQ196 = new SEQ();
        SEQ196.text = "\\tolerance";
        SEQ196.TYPE = "KEYWORD4";
        SEQ SEQ197 = new SEQ();
        SEQ197.text = "\\thinspace";
        SEQ197.TYPE = "KEYWORD1";
        SEQ SEQ198 = new SEQ();
        SEQ198.text = "\\textstyle";
        SEQ198.TYPE = "KEYWORD1";
        SEQ SEQ199 = new SEQ();
        SEQ199.text = "\\spadesuit";
        SEQ199.TYPE = "KEYWORD1";
        SEQ SEQ200 = new SEQ();
        SEQ200.text = "\\spaceskip";
        SEQ200.TYPE = "KEYWORD4";
        SEQ SEQ201 = new SEQ();
        SEQ201.text = "\\smallskip";
        SEQ201.TYPE = "KEYWORD1";
        SEQ SEQ202 = new SEQ();
        SEQ202.text = "\\showlists";
        SEQ202.TYPE = "KEYWORD1";
        SEQ SEQ203 = new SEQ();
        SEQ203.text = "\\rightskip";
        SEQ203.TYPE = "KEYWORD4";
        SEQ SEQ204 = new SEQ();
        SEQ204.text = "\\rightline";
        SEQ204.TYPE = "KEYWORD1";
        SEQ SEQ205 = new SEQ();
        SEQ205.text = "\\prevdepth";
        SEQ205.TYPE = "KEYWORD1";
        SEQ SEQ206 = new SEQ();
        SEQ206.text = "\\preloaded";
        SEQ206.TYPE = "KEYWORD1";
        SEQ SEQ207 = new SEQ();
        SEQ207.text = "\\parindent";
        SEQ207.TYPE = "KEYWORD4";
        SEQ SEQ208 = new SEQ();
        SEQ208.text = "\\pagetotal";
        SEQ208.TYPE = "KEYWORD1";
        SEQ SEQ209 = new SEQ();
        SEQ209.text = "\\pagedepth";
        SEQ209.TYPE = "KEYWORD1";
        SEQ SEQ210 = new SEQ();
        SEQ210.text = "\\overbrace";
        SEQ210.TYPE = "KEYWORD1";
        SEQ SEQ211 = new SEQ();
        SEQ211.text = "\\obeylines";
        SEQ211.TYPE = "KEYWORD1";
        SEQ SEQ212 = new SEQ();
        SEQ212.text = "\\nonscript";
        SEQ212.TYPE = "KEYWORD1";
        SEQ SEQ213 = new SEQ();
        SEQ213.text = "\\newmuskip";
        SEQ213.TYPE = "FUNCTION";
        SEQ SEQ214 = new SEQ();
        SEQ214.text = "\\newinsert";
        SEQ214.TYPE = "FUNCTION";
        SEQ SEQ215 = new SEQ();
        SEQ215.text = "\\muskipdef";
        SEQ215.TYPE = "FUNCTION";
        SEQ SEQ216 = new SEQ();
        SEQ216.text = "\\multispan";
        SEQ216.TYPE = "KEYWORD1";
        SEQ SEQ217 = new SEQ();
        SEQ217.text = "\\moveright";
        SEQ217.TYPE = "KEYWORD1";
        SEQ SEQ218 = new SEQ();
        SEQ218.text = "\\midinsert";
        SEQ218.TYPE = "KEYWORD1";
        SEQ SEQ219 = new SEQ();
        SEQ219.text = "\\medmuskip";
        SEQ219.TYPE = "KEYWORD4";
        SEQ SEQ220 = new SEQ();
        SEQ220.text = "\\mathstrut";
        SEQ220.TYPE = "KEYWORD1";
        SEQ SEQ221 = new SEQ();
        SEQ221.text = "\\mathpunct";
        SEQ221.TYPE = "KEYWORD1";
        SEQ SEQ222 = new SEQ();
        SEQ222.text = "\\mathinner";
        SEQ222.TYPE = "KEYWORD1";
        SEQ SEQ223 = new SEQ();
        SEQ223.text = "\\mathclose";
        SEQ223.TYPE = "KEYWORD1";
        SEQ SEQ224 = new SEQ();
        SEQ224.text = "\\lowercase";
        SEQ224.TYPE = "KEYWORD1";
        SEQ SEQ225 = new SEQ();
        SEQ225.text = "\\looseness";
        SEQ225.TYPE = "KEYWORD4";
        SEQ SEQ226 = new SEQ();
        SEQ226.text = "\\Leftarrow";
        SEQ226.TYPE = "KEYWORD1";
        SEQ SEQ227 = new SEQ();
        SEQ227.text = "\\leftarrow";
        SEQ227.TYPE = "KEYWORD1";
        SEQ SEQ228 = new SEQ();
        SEQ228.text = "\\immediate";
        SEQ228.TYPE = "KEYWORD1";
        SEQ SEQ229 = new SEQ();
        SEQ229.text = "\\hrulefill";
        SEQ229.TYPE = "KEYWORD1";
        SEQ SEQ230 = new SEQ();
        SEQ230.text = "\\hidewidth";
        SEQ230.TYPE = "KEYWORD1";
        SEQ SEQ231 = new SEQ();
        SEQ231.text = "\\heartsuit";
        SEQ231.TYPE = "KEYWORD1";
        SEQ SEQ232 = new SEQ();
        SEQ232.text = "\\hangafter";
        SEQ232.TYPE = "KEYWORD4";
        SEQ SEQ233 = new SEQ();
        SEQ233.text = "\\goodbreak";
        SEQ233.TYPE = "KEYWORD1";
        SEQ SEQ234 = new SEQ();
        SEQ234.text = "\\futurelet";
        SEQ234.TYPE = "COMMENT3";
        SEQ SEQ235 = new SEQ();
        SEQ235.text = "\\footstrut";
        SEQ235.TYPE = "KEYWORD1";
        SEQ SEQ236 = new SEQ();
        SEQ236.text = "\\fontdimen";
        SEQ236.TYPE = "KEYWORD1";
        SEQ SEQ237 = new SEQ();
        SEQ237.text = "\\firstmark";
        SEQ237.TYPE = "KEYWORD1";
        SEQ SEQ238 = new SEQ();
        SEQ238.text = "\\everyvbox";
        SEQ238.TYPE = "KEYWORD4";
        SEQ SEQ239 = new SEQ();
        SEQ239.text = "\\everymath";
        SEQ239.TYPE = "KEYWORD4";
        SEQ SEQ240 = new SEQ();
        SEQ240.text = "\\everyhbox";
        SEQ240.TYPE = "KEYWORD4";
        SEQ SEQ241 = new SEQ();
        SEQ241.text = "\\eqalignno";
        SEQ241.TYPE = "KEYWORD1";
        SEQ SEQ242 = new SEQ();
        SEQ242.text = "\\endinsert";
        SEQ242.TYPE = "KEYWORD1";
        SEQ SEQ243 = new SEQ();
        SEQ243.text = "\\endcsname";
        SEQ243.TYPE = "FUNCTION";
        SEQ SEQ244 = new SEQ();
        SEQ244.text = "\\Downarrow";
        SEQ244.TYPE = "KEYWORD1";
        SEQ SEQ245 = new SEQ();
        SEQ245.text = "\\downarrow";
        SEQ245.TYPE = "KEYWORD1";
        SEQ SEQ246 = new SEQ();
        SEQ246.text = "\\delimiter";
        SEQ246.TYPE = "KEYWORD1";
        SEQ SEQ247 = new SEQ();
        SEQ247.text = "\\copyright";
        SEQ247.TYPE = "KEYWORD1";
        SEQ SEQ248 = new SEQ();
        SEQ248.text = "\\cleartabs";
        SEQ248.TYPE = "KEYWORD1";
        SEQ SEQ249 = new SEQ();
        SEQ249.text = "\\centering";
        SEQ249.TYPE = "KEYWORD1";
        SEQ SEQ250 = new SEQ();
        SEQ250.text = "\\bracevert";
        SEQ250.TYPE = "KEYWORD1";
        SEQ SEQ251 = new SEQ();
        SEQ251.text = "\\bigotimes";
        SEQ251.TYPE = "KEYWORD1";
        SEQ SEQ252 = new SEQ();
        SEQ252.text = "\\batchmode";
        SEQ252.TYPE = "KEYWORD1";
        SEQ SEQ253 = new SEQ();
        SEQ253.text = "\\backslash";
        SEQ253.TYPE = "KEYWORD2";
        SEQ SEQ254 = new SEQ();
        SEQ254.text = "\\Arrowvert";
        SEQ254.TYPE = "KEYWORD1";
        SEQ SEQ255 = new SEQ();
        SEQ255.text = "\\arrowvert";
        SEQ255.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP17 = new SEQ_REGEXP();
        SEQ_REGEXP17.text = "\\\\muskip([0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
        SEQ_REGEXP17.HASH_CHARS = "\\";
        SEQ_REGEXP17.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP18 = new SEQ_REGEXP();
        SEQ_REGEXP18.text = "\\\\[a-zA-Z@]{9}";
        SEQ_REGEXP18.HASH_CHARS = "\\";
        SEQ_REGEXP18.TYPE = "LABEL";
        SEQ SEQ256 = new SEQ();
        SEQ256.text = "\\xleaders";
        SEQ256.TYPE = "KEYWORD1";
        SEQ SEQ257 = new SEQ();
        SEQ257.text = "\\vphantom";
        SEQ257.TYPE = "KEYWORD1";
        SEQ SEQ258 = new SEQ();
        SEQ258.text = "\\vbadness";
        SEQ258.TYPE = "KEYWORD4";
        SEQ SEQ259 = new SEQ();
        SEQ259.text = "\\vartheta";
        SEQ259.TYPE = "KEYWORD1";
        SEQ SEQ260 = new SEQ();
        SEQ260.text = "\\varsigma";
        SEQ260.TYPE = "KEYWORD1";
        SEQ SEQ261 = new SEQ();
        SEQ261.text = "\\underbar";
        SEQ261.TYPE = "KEYWORD1";
        SEQ SEQ262 = new SEQ();
        SEQ262.text = "\\triangle";
        SEQ262.TYPE = "KEYWORD1";
        SEQ SEQ263 = new SEQ();
        SEQ263.text = "\\textfont";
        SEQ263.TYPE = "KEYWORD1";
        SEQ SEQ264 = new SEQ();
        SEQ264.text = "\\tabsdone";
        SEQ264.TYPE = "KEYWORD1";
        SEQ SEQ265 = new SEQ();
        SEQ265.text = "\\tabalign";
        SEQ265.TYPE = "KEYWORD1";
        SEQ SEQ266 = new SEQ();
        SEQ266.text = "\\supseteq";
        SEQ266.TYPE = "KEYWORD1";
        SEQ SEQ267 = new SEQ();
        SEQ267.text = "\\subseteq";
        SEQ267.TYPE = "KEYWORD1";
        SEQ SEQ268 = new SEQ();
        SEQ268.text = "\\strutbox";
        SEQ268.TYPE = "KEYWORD1";
        SEQ SEQ269 = new SEQ();
        SEQ269.text = "\\smallint";
        SEQ269.TYPE = "KEYWORD1";
        SEQ SEQ270 = new SEQ();
        SEQ270.text = "\\skewchar";
        SEQ270.TYPE = "KEYWORD1";
        SEQ SEQ271 = new SEQ();
        SEQ271.text = "\\setminus";
        SEQ271.TYPE = "KEYWORD1";
        SEQ SEQ272 = new SEQ();
        SEQ272.text = "\\proclaim";
        SEQ272.TYPE = "KEYWORD1";
        SEQ SEQ273 = new SEQ();
        SEQ273.text = "\\prevgraf";
        SEQ273.TYPE = "KEYWORD1";
        SEQ SEQ274 = new SEQ();
        SEQ274.text = "\\patterns";
        SEQ274.TYPE = "KEYWORD1";
        SEQ SEQ275 = new SEQ();
        SEQ275.text = "\\parshape";
        SEQ275.TYPE = "KEYWORD1";
        SEQ SEQ276 = new SEQ();
        SEQ276.text = "\\parallel";
        SEQ276.TYPE = "KEYWORD1";
        SEQ SEQ277 = new SEQ();
        SEQ277.text = "\\pagegoal";
        SEQ277.TYPE = "KEYWORD1";
        SEQ SEQ278 = new SEQ();
        SEQ278.text = "\\pagebody";
        SEQ278.TYPE = "KEYWORD1";
        SEQ SEQ279 = new SEQ();
        SEQ279.text = "\\overline";
        SEQ279.TYPE = "KEYWORD1";
        SEQ SEQ280 = new SEQ();
        SEQ280.text = "\\oldstyle";
        SEQ280.TYPE = "KEYWORD1";
        SEQ SEQ281 = new SEQ();
        SEQ281.text = "\\nolimits";
        SEQ281.TYPE = "KEYWORD1";
        SEQ SEQ282 = new SEQ();
        SEQ282.text = "\\noindent";
        SEQ282.TYPE = "KEYWORD1";
        SEQ SEQ283 = new SEQ();
        SEQ283.text = "\\noexpand";
        SEQ283.TYPE = "KEYWORD1";
        SEQ SEQ284 = new SEQ();
        SEQ284.text = "\\newwrite";
        SEQ284.TYPE = "COMMENT2";
        SEQ SEQ285 = new SEQ();
        SEQ285.text = "\\newdimen";
        SEQ285.TYPE = "COMMENT2";
        SEQ SEQ286 = new SEQ();
        SEQ286.text = "\\newcount";
        SEQ286.TYPE = "COMMENT2";
        SEQ SEQ287 = new SEQ();
        SEQ287.text = "\\narrower";
        SEQ287.TYPE = "KEYWORD1";
        SEQ SEQ288 = new SEQ();
        SEQ288.text = "\\moveleft";
        SEQ288.TYPE = "KEYWORD1";
        SEQ SEQ289 = new SEQ();
        SEQ289.text = "\\medbreak";
        SEQ289.TYPE = "KEYWORD1";
        SEQ SEQ290 = new SEQ();
        SEQ290.text = "\\maxdimen";
        SEQ290.TYPE = "KEYWORD1";
        SEQ SEQ291 = new SEQ();
        SEQ291.text = "\\maxdepth";
        SEQ291.TYPE = "KEYWORD4";
        SEQ SEQ292 = new SEQ();
        SEQ292.text = "\\mathopen";
        SEQ292.TYPE = "KEYWORD1";
        SEQ SEQ293 = new SEQ();
        SEQ293.text = "\\mathcode";
        SEQ293.TYPE = "KEYWORD1";
        SEQ SEQ294 = new SEQ();
        SEQ294.text = "\\mathchar";
        SEQ294.TYPE = "KEYWORD1";
        SEQ SEQ295 = new SEQ();
        SEQ295.text = "\\lineskip";
        SEQ295.TYPE = "KEYWORD1";
        SEQ SEQ296 = new SEQ();
        SEQ296.text = "\\leftskip";
        SEQ296.TYPE = "KEYWORD4";
        SEQ SEQ297 = new SEQ();
        SEQ297.text = "\\leftline";
        SEQ297.TYPE = "KEYWORD4";
        SEQ SEQ298 = new SEQ();
        SEQ298.text = "\\lastskip";
        SEQ298.TYPE = "KEYWORD1";
        SEQ SEQ299 = new SEQ();
        SEQ299.text = "\\lastkern";
        SEQ299.TYPE = "KEYWORD1";
        SEQ SEQ300 = new SEQ();
        SEQ300.text = "\\language";
        SEQ300.TYPE = "KEYWORD4";
        SEQ SEQ301 = new SEQ();
        SEQ301.text = "\\itemitem";
        SEQ301.TYPE = "KEYWORD1";
        SEQ SEQ302 = new SEQ();
        SEQ302.text = "\\hphantom";
        SEQ302.TYPE = "KEYWORD1";
        SEQ SEQ303 = new SEQ();
        SEQ303.text = "\\hideskip";
        SEQ303.TYPE = "KEYWORD1";
        SEQ SEQ304 = new SEQ();
        SEQ304.text = "\\headline";
        SEQ304.TYPE = "KEYWORD1";
        SEQ SEQ305 = new SEQ();
        SEQ305.text = "\\hbadness";
        SEQ305.TYPE = "KEYWORD4";
        SEQ SEQ306 = new SEQ();
        SEQ306.text = "\\footnote";
        SEQ306.TYPE = "KEYWORD1";
        SEQ SEQ307 = new SEQ();
        SEQ307.text = "\\footline";
        SEQ307.TYPE = "KEYWORD1";
        SEQ SEQ308 = new SEQ();
        SEQ308.text = "\\multiply";
        SEQ308.TYPE = "KEYWORD1";
        SEQ SEQ309 = new SEQ();
        SEQ309.text = "\\fontname";
        SEQ309.TYPE = "KEYWORD1";
        SEQ SEQ310 = new SEQ();
        SEQ310.text = "\\filbreak";
        SEQ310.TYPE = "KEYWORD1";
        SEQ SEQ311 = new SEQ();
        SEQ311.text = "\\everypar";
        SEQ311.TYPE = "KEYWORD4";
        SEQ SEQ312 = new SEQ();
        SEQ312.text = "\\everyjob";
        SEQ312.TYPE = "KEYWORD4";
        SEQ SEQ313 = new SEQ();
        SEQ313.text = "\\endinput";
        SEQ313.TYPE = "KEYWORD1";
        SEQ SEQ314 = new SEQ();
        SEQ314.text = "\\endgroup";
        SEQ314.TYPE = "KEYWORD1";
        SEQ SEQ315 = new SEQ();
        SEQ315.text = "\\emptyset";
        SEQ315.TYPE = "KEYWORD1";
        SEQ SEQ316 = new SEQ();
        SEQ316.text = "\\dimendef";
        SEQ316.TYPE = "FUNCTION";
        SEQ SEQ317 = new SEQ();
        SEQ317.text = "\\countdef";
        SEQ317.TYPE = "FUNCTION";
        SEQ SEQ318 = new SEQ();
        SEQ318.text = "\\clubsuit";
        SEQ318.TYPE = "KEYWORD1";
        SEQ SEQ319 = new SEQ();
        SEQ319.text = "\\closeout";
        SEQ319.TYPE = "KEYWORD1";
        SEQ SEQ320 = new SEQ();
        SEQ320.text = "\\cleaders";
        SEQ320.TYPE = "KEYWORD1";
        SEQ SEQ321 = new SEQ();
        SEQ321.text = "\\buildrel";
        SEQ321.TYPE = "KEYWORD1";
        SEQ SEQ322 = new SEQ();
        SEQ322.text = "\\bigwedge";
        SEQ322.TYPE = "KEYWORD1";
        SEQ SEQ323 = new SEQ();
        SEQ323.text = "\\biguplus";
        SEQ323.TYPE = "KEYWORD1";
        SEQ SEQ324 = new SEQ();
        SEQ324.text = "\\bigsqcup";
        SEQ324.TYPE = "KEYWORD1";
        SEQ SEQ325 = new SEQ();
        SEQ325.text = "\\bigoplus";
        SEQ325.TYPE = "KEYWORD1";
        SEQ SEQ326 = new SEQ();
        SEQ326.text = "\\bigbreak";
        SEQ326.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP19 = new SEQ_REGEXP();
        SEQ_REGEXP19.text = "\\\\muskip[0-9][0-9]";
        SEQ_REGEXP19.HASH_CHARS = "\\";
        SEQ_REGEXP19.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP20 = new SEQ_REGEXP();
        SEQ_REGEXP20.text = "\\\\dimen([0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
        SEQ_REGEXP20.HASH_CHARS = "\\";
        SEQ_REGEXP20.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP21 = new SEQ_REGEXP();
        SEQ_REGEXP21.text = "\\\\count([0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
        SEQ_REGEXP21.HASH_CHARS = "\\";
        SEQ_REGEXP21.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP22 = new SEQ_REGEXP();
        SEQ_REGEXP22.text = "\\\\[a-zA-Z@]{8}";
        SEQ_REGEXP22.HASH_CHARS = "\\";
        SEQ_REGEXP22.TYPE = "LABEL";
        SEQ SEQ327 = new SEQ();
        SEQ327.text = "\\widehat";
        SEQ327.TYPE = "KEYWORD1";
        SEQ SEQ328 = new SEQ();
        SEQ328.text = "\\voffset";
        SEQ328.TYPE = "KEYWORD4";
        SEQ SEQ329 = new SEQ();
        SEQ329.text = "\\vfilneg";
        SEQ329.TYPE = "KEYWORD1";
        SEQ SEQ330 = new SEQ();
        SEQ330.text = "\\vcenter";
        SEQ330.TYPE = "KEYWORD1";
        SEQ SEQ331 = new SEQ();
        SEQ331.text = "\\vadjust";
        SEQ331.TYPE = "KEYWORD1";
        SEQ SEQ332 = new SEQ();
        SEQ332.text = "\\Upsilon";
        SEQ332.TYPE = "KEYWORD1";
        SEQ SEQ333 = new SEQ();
        SEQ333.text = "\\upsilon";
        SEQ333.TYPE = "KEYWORD1";
        SEQ SEQ334 = new SEQ();
        SEQ334.text = "\\Uparrow";
        SEQ334.TYPE = "KEYWORD1";
        SEQ SEQ335 = new SEQ();
        SEQ335.text = "\\uparrow";
        SEQ335.TYPE = "KEYWORD1";
        SEQ SEQ336 = new SEQ();
        SEQ336.text = "\\unvcopy";
        SEQ336.TYPE = "KEYWORD1";
        SEQ SEQ337 = new SEQ();
        SEQ337.text = "\\unhcopy";
        SEQ337.TYPE = "KEYWORD1";
        SEQ SEQ338 = new SEQ();
        SEQ338.text = "\\topskip";
        SEQ338.TYPE = "KEYWORD4";
        SEQ SEQ339 = new SEQ();
        SEQ339.text = "\\topmark";
        SEQ339.TYPE = "KEYWORD1";
        SEQ SEQ340 = new SEQ();
        SEQ340.text = "\\toksdef";
        SEQ340.TYPE = "FUNCTION";
        SEQ SEQ341 = new SEQ();
        SEQ341.text = "\\tabsyet";
        SEQ341.TYPE = "KEYWORD1";
        SEQ SEQ342 = new SEQ();
        SEQ342.text = "\\tabskip";
        SEQ342.TYPE = "KEYWORD4";
        SEQ SEQ343 = new SEQ();
        SEQ343.text = "\\swarrow";
        SEQ343.TYPE = "KEYWORD1";
        SEQ SEQ344 = new SEQ();
        SEQ344.text = "\\special";
        SEQ344.TYPE = "KEYWORD1";
        SEQ SEQ345 = new SEQ();
        SEQ345.text = "\\skipdef";
        SEQ345.TYPE = "FUNCTION";
        SEQ SEQ346 = new SEQ();
        SEQ346.text = "\\showthe";
        SEQ346.TYPE = "KEYWORD1";
        SEQ SEQ347 = new SEQ();
        SEQ347.text = "\\showbox";
        SEQ347.TYPE = "KEYWORD1";
        SEQ SEQ348 = new SEQ();
        SEQ348.text = "\\shipout";
        SEQ348.TYPE = "KEYWORD1";
        SEQ SEQ349 = new SEQ();
        SEQ349.text = "\\sevensy";
        SEQ349.TYPE = "KEYWORD1";
        SEQ SEQ350 = new SEQ();
        SEQ350.text = "\\sevenrm";
        SEQ350.TYPE = "KEYWORD1";
        SEQ SEQ351 = new SEQ();
        SEQ351.text = "\\sevenbf";
        SEQ351.TYPE = "KEYWORD1";
        SEQ SEQ352 = new SEQ();
        SEQ352.text = "\\settabs";
        SEQ352.TYPE = "KEYWORD1";
        SEQ SEQ353 = new SEQ();
        SEQ353.text = "\\searrow";
        SEQ353.TYPE = "KEYWORD1";
        SEQ SEQ354 = new SEQ();
        SEQ354.text = "\\rootbox";
        SEQ354.TYPE = "KEYWORD1";
        SEQ SEQ355 = new SEQ();
        SEQ355.text = "\\radical";
        SEQ355.TYPE = "KEYWORD1";
        SEQ SEQ356 = new SEQ();
        SEQ356.text = "\\pmatrix";
        SEQ356.TYPE = "KEYWORD1";
        SEQ SEQ357 = new SEQ();
        SEQ357.text = "\\phantom";
        SEQ357.TYPE = "KEYWORD1";
        SEQ SEQ358 = new SEQ();
        SEQ358.text = "\\penalty";
        SEQ358.TYPE = "KEYWORD1";
        SEQ SEQ359 = new SEQ();
        SEQ359.text = "\\pausing";
        SEQ359.TYPE = "KEYWORD4";
        SEQ SEQ360 = new SEQ();
        SEQ360.text = "\\partial";
        SEQ360.TYPE = "KEYWORD1";
        SEQ SEQ361 = new SEQ();
        SEQ361.text = "\\parskip";
        SEQ361.TYPE = "KEYWORD4";
        SEQ SEQ362 = new SEQ();
        SEQ362.text = "\\openout";
        SEQ362.TYPE = "KEYWORD1";
        SEQ SEQ363 = new SEQ();
        SEQ363.text = "\\ooalign";
        SEQ363.TYPE = "KEYWORD1";
        SEQ SEQ364 = new SEQ();
        SEQ364.text = "\\nwarrow";
        SEQ364.TYPE = "KEYWORD1";
        SEQ SEQ365 = new SEQ();
        SEQ365.text = "\\nobreak";
        SEQ365.TYPE = "KEYWORD1";
        SEQ SEQ366 = new SEQ();
        SEQ366.text = "\\noalign";
        SEQ366.TYPE = "KEYWORD1";
        SEQ SEQ367 = new SEQ();
        SEQ367.text = "\\newtoks";
        SEQ367.TYPE = "COMMENT2";
        SEQ SEQ368 = new SEQ();
        SEQ368.text = "\\newskip";
        SEQ368.TYPE = "COMMENT2";
        SEQ SEQ369 = new SEQ();
        SEQ369.text = "\\newread";
        SEQ369.TYPE = "COMMENT2";
        SEQ SEQ370 = new SEQ();
        SEQ370.text = "\\newhelp";
        SEQ370.TYPE = "COMMENT2";
        SEQ SEQ371 = new SEQ();
        SEQ371.text = "\\nearrow";
        SEQ371.TYPE = "KEYWORD1";
        SEQ SEQ372 = new SEQ();
        SEQ372.text = "\\natural";
        SEQ372.TYPE = "KEYWORD1";
        SEQ SEQ373 = new SEQ();
        SEQ373.text = "\\mscount";
        SEQ373.TYPE = "KEYWORD1";
        SEQ SEQ374 = new SEQ();
        SEQ374.text = "\\message";
        SEQ374.TYPE = "KEYWORD1";
        SEQ SEQ375 = new SEQ();
        SEQ375.text = "\\medskip";
        SEQ375.TYPE = "KEYWORD1";
        SEQ SEQ376 = new SEQ();
        SEQ376.text = "\\meaning";
        SEQ376.TYPE = "KEYWORD1";
        SEQ SEQ377 = new SEQ();
        SEQ377.text = "\\mathrel";
        SEQ377.TYPE = "KEYWORD1";
        SEQ SEQ378 = new SEQ();
        SEQ378.text = "\\mathord";
        SEQ378.TYPE = "KEYWORD1";
        SEQ SEQ379 = new SEQ();
        SEQ379.text = "\\mathbin";
        SEQ379.TYPE = "KEYWORD1";
        SEQ SEQ380 = new SEQ();
        SEQ380.text = "\\magstep";
        SEQ380.TYPE = "KEYWORD1";
        SEQ SEQ381 = new SEQ();
        SEQ381.text = "\\leaders";
        SEQ381.TYPE = "KEYWORD1";
        SEQ SEQ382 = new SEQ();
        SEQ382.text = "\\lastbox";
        SEQ382.TYPE = "KEYWORD1";
        SEQ SEQ383 = new SEQ();
        SEQ383.text = "\\joinrel";
        SEQ383.TYPE = "KEYWORD1";
        SEQ SEQ384 = new SEQ();
        SEQ384.text = "\\jobname";
        SEQ384.TYPE = "KEYWORD1";
        SEQ SEQ385 = new SEQ();
        SEQ385.text = "\\iterate";
        SEQ385.TYPE = "KEYWORD1";
        SEQ SEQ386 = new SEQ();
        SEQ386.text = "\\ifvmode";
        SEQ386.TYPE = "KEYWORD3";
        SEQ SEQ387 = new SEQ();
        SEQ387.text = "\\ifmmode";
        SEQ387.TYPE = "KEYWORD3";
        SEQ SEQ388 = new SEQ();
        SEQ388.text = "\\ifinner";
        SEQ388.TYPE = "KEYWORD3";
        SEQ SEQ389 = new SEQ();
        SEQ389.text = "\\ifhmode";
        SEQ389.TYPE = "KEYWORD3";
        SEQ SEQ390 = new SEQ();
        SEQ390.text = "\\iffalse";
        SEQ390.TYPE = "KEYWORD3";
        SEQ SEQ391 = new SEQ();
        SEQ391.text = "\\hoffset";
        SEQ391.TYPE = "KEYWORD4";
        SEQ SEQ392 = new SEQ();
        SEQ392.text = "\\hfilneg";
        SEQ392.TYPE = "KEYWORD1";
        SEQ SEQ393 = new SEQ();
        SEQ393.text = "\\footins";
        SEQ393.TYPE = "KEYWORD1";
        SEQ SEQ394 = new SEQ();
        SEQ394.text = "\\fmtname";
        SEQ394.TYPE = "KEYWORD1";
        SEQ SEQ395 = new SEQ();
        SEQ395.text = "\\everycr";
        SEQ395.TYPE = "KEYWORD4";
        SEQ SEQ396 = new SEQ();
        SEQ396.text = "\\errhelp";
        SEQ396.TYPE = "KEYWORD4";
        SEQ SEQ397 = new SEQ();
        SEQ397.text = "\\eqalign";
        SEQ397.TYPE = "KEYWORD1";
        SEQ SEQ398 = new SEQ();
        SEQ398.text = "\\epsilon";
        SEQ398.TYPE = "KEYWORD1";
        SEQ SEQ399 = new SEQ();
        SEQ399.text = "\\enspace";
        SEQ399.TYPE = "KEYWORD1";
        SEQ SEQ400 = new SEQ();
        SEQ400.text = "\\endline";
        SEQ400.TYPE = "KEYWORD1";
        SEQ SEQ401 = new SEQ();
        SEQ401.text = "\\endgraf";
        SEQ401.TYPE = "KEYWORD1";
        SEQ SEQ402 = new SEQ();
        SEQ402.text = "\\dotfill";
        SEQ402.TYPE = "KEYWORD1";
        SEQ SEQ403 = new SEQ();
        SEQ403.text = "\\diamond";
        SEQ403.TYPE = "KEYWORD1";
        SEQ SEQ404 = new SEQ();
        SEQ404.text = "\\delcode";
        SEQ404.TYPE = "KEYWORD1";
        SEQ SEQ405 = new SEQ();
        SEQ405.text = "\\ddagger";
        SEQ405.TYPE = "KEYWORD1";
        SEQ SEQ406 = new SEQ();
        SEQ406.text = "\\columns";
        SEQ406.TYPE = "KEYWORD1";
        SEQ SEQ407 = new SEQ();
        SEQ407.text = "\\closein";
        SEQ407.TYPE = "KEYWORD1";
        SEQ SEQ408 = new SEQ();
        SEQ408.text = "\\chardef";
        SEQ408.TYPE = "FUNCTION";
        SEQ SEQ409 = new SEQ();
        SEQ409.text = "\\cdprime";
        SEQ409.TYPE = "KEYWORD2";
        SEQ SEQ410 = new SEQ();
        SEQ410.text = "\\catcode";
        SEQ410.TYPE = "KEYWORD1";
        SEQ SEQ411 = new SEQ();
        SEQ411.text = "\\braceru";
        SEQ411.TYPE = "KEYWORD1";
        SEQ SEQ412 = new SEQ();
        SEQ412.text = "\\bracerd";
        SEQ412.TYPE = "KEYWORD1";
        SEQ SEQ413 = new SEQ();
        SEQ413.text = "\\bracelu";
        SEQ413.TYPE = "KEYWORD1";
        SEQ SEQ414 = new SEQ();
        SEQ414.text = "\\braceld";
        SEQ414.TYPE = "KEYWORD1";
        SEQ SEQ415 = new SEQ();
        SEQ415.text = "\\botmark";
        SEQ415.TYPE = "KEYWORD1";
        SEQ SEQ416 = new SEQ();
        SEQ416.text = "\\bigskip";
        SEQ416.TYPE = "KEYWORD1";
        SEQ SEQ417 = new SEQ();
        SEQ417.text = "\\bigodot";
        SEQ417.TYPE = "KEYWORD1";
        SEQ SEQ418 = new SEQ();
        SEQ418.text = "\\bigcirc";
        SEQ418.TYPE = "KEYWORD1";
        SEQ SEQ419 = new SEQ();
        SEQ419.text = "\\advance";
        SEQ419.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP23 = new SEQ_REGEXP();
        SEQ_REGEXP23.text = "\\\\muskip[0-9]";
        SEQ_REGEXP23.HASH_CHARS = "\\";
        SEQ_REGEXP23.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP24 = new SEQ_REGEXP();
        SEQ_REGEXP24.text = "\\\\dimen[0-9][0-9]";
        SEQ_REGEXP24.HASH_CHARS = "\\";
        SEQ_REGEXP24.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP25 = new SEQ_REGEXP();
        SEQ_REGEXP25.text = "\\\\count[0-9][0-9]";
        SEQ_REGEXP25.HASH_CHARS = "\\";
        SEQ_REGEXP25.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP26 = new SEQ_REGEXP();
        SEQ_REGEXP26.text = "\\\\toks([0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
        SEQ_REGEXP26.HASH_CHARS = "\\";
        SEQ_REGEXP26.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP27 = new SEQ_REGEXP();
        SEQ_REGEXP27.text = "\\\\skip([0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
        SEQ_REGEXP27.HASH_CHARS = "\\";
        SEQ_REGEXP27.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP28 = new SEQ_REGEXP();
        SEQ_REGEXP28.text = "\\\\char([0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
        SEQ_REGEXP28.HASH_CHARS = "\\";
        SEQ_REGEXP28.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP29 = new SEQ_REGEXP();
        SEQ_REGEXP29.text = "\\\\char'[0-7][0-7]";
        SEQ_REGEXP29.HASH_CHARS = "\\";
        SEQ_REGEXP29.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP30 = new SEQ_REGEXP();
        SEQ_REGEXP30.text = "\\\\char\"[0-9A-Fa-f][0-9A-Fa-f]";
        SEQ_REGEXP30.HASH_CHARS = "\\";
        SEQ_REGEXP30.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP31 = new SEQ_REGEXP();
        SEQ_REGEXP31.text = "\\\\[a-zA-Z@]{7}";
        SEQ_REGEXP31.HASH_CHARS = "\\";
        SEQ_REGEXP31.TYPE = "LABEL";
        SEQ SEQ420 = new SEQ();
        SEQ420.text = "\\vsplit";
        SEQ420.TYPE = "KEYWORD1";
        SEQ SEQ421 = new SEQ();
        SEQ421.text = "\\varrho";
        SEQ421.TYPE = "KEYWORD1";
        SEQ SEQ422 = new SEQ();
        SEQ422.text = "\\varphi";
        SEQ422.TYPE = "KEYWORD1";
        SEQ SEQ423 = new SEQ();
        SEQ423.text = "\\valign";
        SEQ423.TYPE = "KEYWORD1";
        SEQ SEQ424 = new SEQ();
        SEQ424.text = "\\utilde";
        SEQ424.TYPE = "KEYWORD2";
        SEQ SEQ425 = new SEQ();
        SEQ425.text = "\\unvbox";
        SEQ425.TYPE = "KEYWORD1";
        SEQ SEQ426 = new SEQ();
        SEQ426.text = "\\unskip";
        SEQ426.TYPE = "KEYWORD1";
        SEQ SEQ427 = new SEQ();
        SEQ427.text = "\\unkern";
        SEQ427.TYPE = "KEYWORD1";
        SEQ SEQ428 = new SEQ();
        SEQ428.text = "\\unhbox";
        SEQ428.TYPE = "KEYWORD1";
        SEQ SEQ429 = new SEQ();
        SEQ429.text = "\\uchyph";
        SEQ429.TYPE = "KEYWORD4";
        SEQ SEQ430 = new SEQ();
        SEQ430.text = "\\uccode";
        SEQ430.TYPE = "KEYWORD1";
        SEQ SEQ431 = new SEQ();
        SEQ431.text = "\\topins";
        SEQ431.TYPE = "KEYWORD1";
        SEQ SEQ432 = new SEQ();
        SEQ432.text = "\\supset";
        SEQ432.TYPE = "KEYWORD1";
        SEQ SEQ433 = new SEQ();
        SEQ433.text = "\\succeq";
        SEQ433.TYPE = "KEYWORD1";
        SEQ SEQ434 = new SEQ();
        SEQ434.text = "\\subset";
        SEQ434.TYPE = "KEYWORD1";
        SEQ SEQ435 = new SEQ();
        SEQ435.text = "\\string";
        SEQ435.TYPE = "KEYWORD1";
        SEQ SEQ436 = new SEQ();
        SEQ436.text = "\\sfcode";
        SEQ436.TYPE = "KEYWORD1";
        SEQ SEQ437 = new SEQ();
        SEQ437.text = "\\seveni";
        SEQ437.TYPE = "KEYWORD1";
        SEQ SEQ438 = new SEQ();
        SEQ438.text = "\\setbox";
        SEQ438.TYPE = "KEYWORD1";
        SEQ SEQ439 = new SEQ();
        SEQ439.text = "\\rgroup";
        SEQ439.TYPE = "KEYWORD1";
        SEQ SEQ440 = new SEQ();
        SEQ440.text = "\\rfloor";
        SEQ440.TYPE = "KEYWORD1";
        SEQ SEQ441 = new SEQ();
        SEQ441.text = "\\repeat";
        SEQ441.TYPE = "KEYWORD1";
        SEQ SEQ442 = new SEQ();
        SEQ442.text = "\\Relbar";
        SEQ442.TYPE = "KEYWORD1";
        SEQ SEQ443 = new SEQ();
        SEQ443.text = "\\relbar";
        SEQ443.TYPE = "KEYWORD1";
        SEQ SEQ444 = new SEQ();
        SEQ444.text = "\\rbrack";
        SEQ444.TYPE = "KEYWORD1";
        SEQ SEQ445 = new SEQ();
        SEQ445.text = "\\rbrace";
        SEQ445.TYPE = "KEYWORD1";
        SEQ SEQ446 = new SEQ();
        SEQ446.text = "\\rangle";
        SEQ446.TYPE = "KEYWORD1";
        SEQ SEQ447 = new SEQ();
        SEQ447.text = "\\propto";
        SEQ447.TYPE = "KEYWORD1";
        SEQ SEQ448 = new SEQ();
        SEQ448.text = "\\preceq";
        SEQ448.TYPE = "KEYWORD1";
        SEQ SEQ449 = new SEQ();
        SEQ449.text = "\\pageno";
        SEQ449.TYPE = "KEYWORD1";
        SEQ SEQ450 = new SEQ();
        SEQ450.text = "\\output";
        SEQ450.TYPE = "KEYWORD4";
        SEQ SEQ451 = new SEQ();
        SEQ451.text = "\\otimes";
        SEQ451.TYPE = "KEYWORD1";
        SEQ SEQ452 = new SEQ();
        SEQ452.text = "\\oslash";
        SEQ452.TYPE = "KEYWORD1";
        SEQ SEQ453 = new SEQ();
        SEQ453.text = "\\openup";
        SEQ453.TYPE = "KEYWORD1";
        SEQ SEQ454 = new SEQ();
        SEQ454.text = "\\openin";
        SEQ454.TYPE = "KEYWORD1";
        SEQ SEQ455 = new SEQ();
        SEQ455.text = "\\ominus";
        SEQ455.TYPE = "KEYWORD1";
        SEQ SEQ456 = new SEQ();
        SEQ456.text = "\\ointop";
        SEQ456.TYPE = "KEYWORD1";
        SEQ SEQ457 = new SEQ();
        SEQ457.text = "\\oalign";
        SEQ457.TYPE = "KEYWORD1";
        SEQ SEQ458 = new SEQ();
        SEQ458.text = "\\number";
        SEQ458.TYPE = "KEYWORD1";
        SEQ SEQ459 = new SEQ();
        SEQ459.text = "\\newfam";
        SEQ459.TYPE = "COMMENT2";
        SEQ SEQ460 = new SEQ();
        SEQ460.text = "\\newbox";
        SEQ460.TYPE = "COMMENT2";
        SEQ SEQ461 = new SEQ();
        SEQ461.text = "\\muskip";
        SEQ461.TYPE = "COMMENT4";
        SEQ SEQ462 = new SEQ();
        SEQ462.text = "\\models";
        SEQ462.TYPE = "KEYWORD1";
        SEQ SEQ463 = new SEQ();
        SEQ463.text = "\\matrix";
        SEQ463.TYPE = "KEYWORD1";
        SEQ SEQ464 = new SEQ();
        SEQ464.text = "\\mathop";
        SEQ464.TYPE = "KEYWORD1";
        SEQ SEQ465 = new SEQ();
        SEQ465.text = "\\mapsto";
        SEQ465.TYPE = "KEYWORD1";
        SEQ SEQ466 = new SEQ();
        SEQ466.text = "\\limsup";
        SEQ466.TYPE = "KEYWORD1";
        SEQ SEQ467 = new SEQ();
        SEQ467.text = "\\limits";
        SEQ467.TYPE = "KEYWORD1";
        SEQ SEQ468 = new SEQ();
        SEQ468.text = "\\liminf";
        SEQ468.TYPE = "KEYWORD1";
        SEQ SEQ469 = new SEQ();
        SEQ469.text = "\\lgroup";
        SEQ469.TYPE = "KEYWORD1";
        SEQ SEQ470 = new SEQ();
        SEQ470.text = "\\lfhook";
        SEQ470.TYPE = "KEYWORD2";
        SEQ SEQ471 = new SEQ();
        SEQ471.text = "\\lfloor";
        SEQ471.TYPE = "KEYWORD1";
        SEQ SEQ472 = new SEQ();
        SEQ472.text = "\\lccode";
        SEQ472.TYPE = "KEYWORD1";
        SEQ SEQ473 = new SEQ();
        SEQ473.text = "\\lbrack";
        SEQ473.TYPE = "KEYWORD1";
        SEQ SEQ474 = new SEQ();
        SEQ474.text = "\\lbrace";
        SEQ474.TYPE = "KEYWORD1";
        SEQ SEQ475 = new SEQ();
        SEQ475.text = "\\langle";
        SEQ475.TYPE = "KEYWORD1";
        SEQ SEQ476 = new SEQ();
        SEQ476.text = "\\Lambda";
        SEQ476.TYPE = "KEYWORD1";
        SEQ SEQ477 = new SEQ();
        SEQ477.text = "\\lambda";
        SEQ477.TYPE = "KEYWORD1";
        SEQ SEQ478 = new SEQ();
        SEQ478.text = "\\insert";
        SEQ478.TYPE = "KEYWORD1";
        SEQ SEQ479 = new SEQ();
        SEQ479.text = "\\indent";
        SEQ479.TYPE = "KEYWORD1";
        SEQ SEQ480 = new SEQ();
        SEQ480.text = "\\ifvoid";
        SEQ480.TYPE = "KEYWORD3";
        SEQ SEQ481 = new SEQ();
        SEQ481.text = "\\ifvbox";
        SEQ481.TYPE = "KEYWORD3";
        SEQ SEQ482 = new SEQ();
        SEQ482.text = "\\iftrue";
        SEQ482.TYPE = "KEYWORD3";
        SEQ SEQ483 = new SEQ();
        SEQ483.text = "\\ifhbox";
        SEQ483.TYPE = "KEYWORD3";
        SEQ SEQ484 = new SEQ();
        SEQ484.text = "\\ifcase";
        SEQ484.TYPE = "KEYWORD3";
        SEQ SEQ485 = new SEQ();
        SEQ485.text = "\\ialign";
        SEQ485.TYPE = "KEYWORD1";
        SEQ SEQ486 = new SEQ();
        SEQ486.text = "\\halign";
        SEQ486.TYPE = "KEYWORD1";
        SEQ SEQ487 = new SEQ();
        SEQ487.text = "\\global";
        SEQ487.TYPE = "FUNCTION";
        SEQ SEQ488 = new SEQ();
        SEQ488.text = "\\forall";
        SEQ488.TYPE = "KEYWORD1";
        SEQ SEQ489 = new SEQ();
        SEQ489.text = "\\fivesy";
        SEQ489.TYPE = "KEYWORD1";
        SEQ SEQ490 = new SEQ();
        SEQ490.text = "\\fiverm";
        SEQ490.TYPE = "KEYWORD1";
        SEQ SEQ491 = new SEQ();
        SEQ491.text = "\\fivebf";
        SEQ491.TYPE = "KEYWORD1";
        SEQ SEQ492 = new SEQ();
        SEQ492.text = "\\exists";
        SEQ492.TYPE = "KEYWORD1";
        SEQ SEQ493 = new SEQ();
        SEQ493.text = "\\enskip";
        SEQ493.TYPE = "KEYWORD1";
        SEQ SEQ494 = new SEQ();
        SEQ494.text = "\\egroup";
        SEQ494.TYPE = "KEYWORD1";
        SEQ SEQ495 = new SEQ();
        SEQ495.text = "\\divide";
        SEQ495.TYPE = "KEYWORD1";
        SEQ SEQ496 = new SEQ();
        SEQ496.text = "\\dagger";
        SEQ496.TYPE = "KEYWORD1";
        SEQ SEQ497 = new SEQ();
        SEQ497.text = "\\csname";
        SEQ497.TYPE = "FUNCTION";
        SEQ SEQ498 = new SEQ();
        SEQ498.text = "\\cprime";
        SEQ498.TYPE = "KEYWORD2";
        SEQ SEQ499 = new SEQ();
        SEQ499.text = "\\coprod";
        SEQ499.TYPE = "KEYWORD1";
        SEQ SEQ500 = new SEQ();
        SEQ500.text = "\\choose";
        SEQ500.TYPE = "KEYWORD1";
        SEQ SEQ501 = new SEQ();
        SEQ501.text = "\\cfudot";
        SEQ501.TYPE = "KEYWORD2";
        SEQ SEQ502 = new SEQ();
        SEQ502.text = "\\candra";
        SEQ502.TYPE = "KEYWORD2";
        SEQ SEQ503 = new SEQ();
        SEQ503.text = "\\bullet";
        SEQ503.TYPE = "KEYWORD1";
        SEQ SEQ504 = new SEQ();
        SEQ504.text = "\\bowtie";
        SEQ504.TYPE = "KEYWORD1";
        SEQ SEQ505 = new SEQ();
        SEQ505.text = "\\bigvee";
        SEQ505.TYPE = "KEYWORD1";
        SEQ SEQ506 = new SEQ();
        SEQ506.text = "\\bigcup";
        SEQ506.TYPE = "KEYWORD1";
        SEQ SEQ507 = new SEQ();
        SEQ507.text = "\\bigcap";
        SEQ507.TYPE = "KEYWORD1";
        SEQ SEQ508 = new SEQ();
        SEQ508.text = "\\bgroup";
        SEQ508.TYPE = "KEYWORD1";
        SEQ SEQ509 = new SEQ();
        SEQ509.text = "\\arctan";
        SEQ509.TYPE = "KEYWORD1";
        SEQ SEQ510 = new SEQ();
        SEQ510.text = "\\arcsin";
        SEQ510.TYPE = "KEYWORD1";
        SEQ SEQ511 = new SEQ();
        SEQ511.text = "\\arccos";
        SEQ511.TYPE = "KEYWORD1";
        SEQ SEQ512 = new SEQ();
        SEQ512.text = "\\approx";
        SEQ512.TYPE = "KEYWORD1";
        SEQ SEQ513 = new SEQ();
        SEQ513.text = "\\acudot";
        SEQ513.TYPE = "KEYWORD2";
        SEQ SEQ514 = new SEQ();
        SEQ514.text = "\\active";
        SEQ514.TYPE = "KEYWORD1";
        SEQ SEQ515 = new SEQ();
        SEQ515.text = "\\accent";
        SEQ515.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP32 = new SEQ_REGEXP();
        SEQ_REGEXP32.text = "\\\\dimen[0-9]";
        SEQ_REGEXP32.HASH_CHARS = "\\";
        SEQ_REGEXP32.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP33 = new SEQ_REGEXP();
        SEQ_REGEXP33.text = "\\\\count[0-9]";
        SEQ_REGEXP33.HASH_CHARS = "\\";
        SEQ_REGEXP33.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP34 = new SEQ_REGEXP();
        SEQ_REGEXP34.text = "\\\\toks[0-9][0-9]";
        SEQ_REGEXP34.HASH_CHARS = "\\";
        SEQ_REGEXP34.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP35 = new SEQ_REGEXP();
        SEQ_REGEXP35.text = "\\\\skip[0-9][0-9]";
        SEQ_REGEXP35.HASH_CHARS = "\\";
        SEQ_REGEXP35.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP36 = new SEQ_REGEXP();
        SEQ_REGEXP36.text = "\\\\box([0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
        SEQ_REGEXP36.HASH_CHARS = "\\";
        SEQ_REGEXP36.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP37 = new SEQ_REGEXP();
        SEQ_REGEXP37.text = "\\\\char[0-9][0-9]";
        SEQ_REGEXP37.HASH_CHARS = "\\";
        SEQ_REGEXP37.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP38 = new SEQ_REGEXP();
        SEQ_REGEXP38.text = "\\\\char'[0-7]";
        SEQ_REGEXP38.HASH_CHARS = "\\";
        SEQ_REGEXP38.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP39 = new SEQ_REGEXP();
        SEQ_REGEXP39.text = "\\\\char\"[0-9A-Fa-f]";
        SEQ_REGEXP39.HASH_CHARS = "\\";
        SEQ_REGEXP39.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP40 = new SEQ_REGEXP();
        SEQ_REGEXP40.text = "\\\\[a-zA-Z@]{6}";
        SEQ_REGEXP40.HASH_CHARS = "\\";
        SEQ_REGEXP40.TYPE = "LABEL";
        SEQ SEQ516 = new SEQ();
        SEQ516.text = "\\write";
        SEQ516.TYPE = "KEYWORD1";
        SEQ SEQ517 = new SEQ();
        SEQ517.text = "\\wedge";
        SEQ517.TYPE = "KEYWORD1";
        SEQ SEQ518 = new SEQ();
        SEQ518.text = "\\vskip";
        SEQ518.TYPE = "KEYWORD1";
        SEQ SEQ519 = new SEQ();
        SEQ519.text = "\\vsize";
        SEQ519.TYPE = "KEYWORD4";
        SEQ SEQ520 = new SEQ();
        SEQ520.text = "\\vrule";
        SEQ520.TYPE = "KEYWORD1";
        SEQ SEQ521 = new SEQ();
        SEQ521.text = "\\vglue";
        SEQ521.TYPE = "KEYWORD1";
        SEQ SEQ522 = new SEQ();
        SEQ522.text = "\\vfuzz";
        SEQ522.TYPE = "KEYWORD4";
        SEQ SEQ523 = new SEQ();
        SEQ523.text = "\\vfill";
        SEQ523.TYPE = "KEYWORD1";
        SEQ SEQ524 = new SEQ();
        SEQ524.text = "\\vdots";
        SEQ524.TYPE = "KEYWORD1";
        SEQ SEQ525 = new SEQ();
        SEQ525.text = "\\vdash";
        SEQ525.TYPE = "KEYWORD1";
        SEQ SEQ526 = new SEQ();
        SEQ526.text = "\\varpi";
        SEQ526.TYPE = "KEYWORD1";
        SEQ SEQ527 = new SEQ();
        SEQ527.text = "\\uplus";
        SEQ527.TYPE = "KEYWORD1";
        SEQ SEQ528 = new SEQ();
        SEQ528.text = "\\ttfam";
        SEQ528.TYPE = "KEYWORD1";
        SEQ SEQ529 = new SEQ();
        SEQ529.text = "\\times";
        SEQ529.TYPE = "KEYWORD1";
        SEQ SEQ530 = new SEQ();
        SEQ530.text = "\\tilde";
        SEQ530.TYPE = "KEYWORD1";
        SEQ SEQ531 = new SEQ();
        SEQ531.text = "\\Theta";
        SEQ531.TYPE = "KEYWORD1";
        SEQ SEQ532 = new SEQ();
        SEQ532.text = "\\theta";
        SEQ532.TYPE = "KEYWORD1";
        SEQ SEQ533 = new SEQ();
        SEQ533.text = "\\tentt";
        SEQ533.TYPE = "KEYWORD1";
        SEQ SEQ534 = new SEQ();
        SEQ534.text = "\\tensy";
        SEQ534.TYPE = "KEYWORD1";
        SEQ SEQ535 = new SEQ();
        SEQ535.text = "\\tensl";
        SEQ535.TYPE = "KEYWORD1";
        SEQ SEQ536 = new SEQ();
        SEQ536.text = "\\tenrm";
        SEQ536.TYPE = "KEYWORD1";
        SEQ SEQ537 = new SEQ();
        SEQ537.text = "\\tenit";
        SEQ537.TYPE = "KEYWORD1";
        SEQ SEQ538 = new SEQ();
        SEQ538.text = "\\tenex";
        SEQ538.TYPE = "KEYWORD1";
        SEQ SEQ539 = new SEQ();
        SEQ539.text = "\\tenbf";
        SEQ539.TYPE = "KEYWORD1";
        SEQ SEQ540 = new SEQ();
        SEQ540.text = "\\strut";
        SEQ540.TYPE = "KEYWORD1";
        SEQ SEQ541 = new SEQ();
        SEQ541.text = "\\sqcup";
        SEQ541.TYPE = "KEYWORD1";
        SEQ SEQ542 = new SEQ();
        SEQ542.text = "\\sqcap";
        SEQ542.TYPE = "KEYWORD1";
        SEQ SEQ543 = new SEQ();
        SEQ543.text = "\\space";
        SEQ543.TYPE = "KEYWORD1";
        SEQ SEQ544 = new SEQ();
        SEQ544.text = "\\smile";
        SEQ544.TYPE = "KEYWORD1";
        SEQ SEQ545 = new SEQ();
        SEQ545.text = "\\smash";
        SEQ545.TYPE = "KEYWORD1";
        SEQ SEQ546 = new SEQ();
        SEQ546.text = "\\slfam";
        SEQ546.TYPE = "KEYWORD1";
        SEQ SEQ547 = new SEQ();
        SEQ547.text = "\\slash";
        SEQ547.TYPE = "KEYWORD1";
        SEQ SEQ548 = new SEQ();
        SEQ548.text = "\\simeq";
        SEQ548.TYPE = "KEYWORD1";
        SEQ SEQ549 = new SEQ();
        SEQ549.text = "\\Sigma";
        SEQ549.TYPE = "KEYWORD1";
        SEQ SEQ550 = new SEQ();
        SEQ550.text = "\\sigma";
        SEQ550.TYPE = "KEYWORD1";
        SEQ SEQ551 = new SEQ();
        SEQ551.text = "\\sharp";
        SEQ551.TYPE = "KEYWORD1";
        SEQ SEQ552 = new SEQ();
        SEQ552.text = "\\right";
        SEQ552.TYPE = "KEYWORD1";
        SEQ SEQ553 = new SEQ();
        SEQ553.text = "\\rhook";
        SEQ553.TYPE = "KEYWORD1";
        SEQ SEQ554 = new SEQ();
        SEQ554.text = "\\relax";
        SEQ554.TYPE = "KEYWORD1";
        SEQ SEQ555 = new SEQ();
        SEQ555.text = "\\rceil";
        SEQ555.TYPE = "KEYWORD1";
        SEQ SEQ556 = new SEQ();
        SEQ556.text = "\\raise";
        SEQ556.TYPE = "KEYWORD1";
        SEQ SEQ557 = new SEQ();
        SEQ557.text = "\\qquad";
        SEQ557.TYPE = "KEYWORD1";
        SEQ SEQ558 = new SEQ();
        SEQ558.text = "\\prime";
        SEQ558.TYPE = "KEYWORD1";
        SEQ SEQ559 = new SEQ();
        SEQ559.text = "\\outer";
        SEQ559.TYPE = "FUNCTION";
        SEQ SEQ560 = new SEQ();
        SEQ560.text = "\\oplus";
        SEQ560.TYPE = "KEYWORD1";
        SEQ SEQ561 = new SEQ();
        SEQ561.text = "\\Omega";
        SEQ561.TYPE = "KEYWORD1";
        SEQ SEQ562 = new SEQ();
        SEQ562.text = "\\omega";
        SEQ562.TYPE = "KEYWORD1";
        SEQ SEQ563 = new SEQ();
        SEQ563.text = "\\notin";
        SEQ563.TYPE = "KEYWORD1";
        SEQ SEQ564 = new SEQ();
        SEQ564.text = "\\newif";
        SEQ564.TYPE = "COMMENT2";
        SEQ SEQ565 = new SEQ();
        SEQ565.text = "\\nabla";
        SEQ565.TYPE = "KEYWORD1";
        SEQ SEQ566 = new SEQ();
        SEQ566.text = "\\mskip";
        SEQ566.TYPE = "KEYWORD1";
        SEQ SEQ567 = new SEQ();
        SEQ567.text = "\\month";
        SEQ567.TYPE = "KEYWORD4";
        SEQ SEQ568 = new SEQ();
        SEQ568.text = "\\mkern";
        SEQ568.TYPE = "KEYWORD1";
        SEQ SEQ569 = new SEQ();
        SEQ569.text = "\\lower";
        SEQ569.TYPE = "KEYWORD1";
        SEQ SEQ570 = new SEQ();
        SEQ570.text = "\\lhook";
        SEQ570.TYPE = "KEYWORD1";
        SEQ SEQ571 = new SEQ();
        SEQ571.text = "\\leqno";
        SEQ571.TYPE = "KEYWORD1";
        SEQ SEQ572 = new SEQ();
        SEQ572.text = "\\ldots";
        SEQ572.TYPE = "KEYWORD1";
        SEQ SEQ573 = new SEQ();
        SEQ573.text = "\\ldotp";
        SEQ573.TYPE = "KEYWORD1";
        SEQ SEQ574 = new SEQ();
        SEQ574.text = "\\lceil";
        SEQ574.TYPE = "KEYWORD1";
        SEQ SEQ575 = new SEQ();
        SEQ575.text = "\\kappa";
        SEQ575.TYPE = "KEYWORD1";
        SEQ SEQ576 = new SEQ();
        SEQ576.text = "\\jmath";
        SEQ576.TYPE = "KEYWORD1";
        SEQ SEQ577 = new SEQ();
        SEQ577.text = "\\itfam";
        SEQ577.TYPE = "KEYWORD1";
        SEQ SEQ578 = new SEQ();
        SEQ578.text = "\\intop";
        SEQ578.TYPE = "KEYWORD1";
        SEQ SEQ579 = new SEQ();
        SEQ579.text = "\\input";
        SEQ579.TYPE = "KEYWORD1";
        SEQ SEQ580 = new SEQ();
        SEQ580.text = "\\infty";
        SEQ580.TYPE = "KEYWORD1";
        SEQ SEQ581 = new SEQ();
        SEQ581.text = "\\imath";
        SEQ581.TYPE = "KEYWORD1";
        SEQ SEQ582 = new SEQ();
        SEQ582.text = "\\ifodd";
        SEQ582.TYPE = "KEYWORD3";
        SEQ SEQ583 = new SEQ();
        SEQ583.text = "\\ifnum";
        SEQ583.TYPE = "KEYWORD3";
        SEQ SEQ584 = new SEQ();
        SEQ584.text = "\\ifeof";
        SEQ584.TYPE = "KEYWORD3";
        SEQ SEQ585 = new SEQ();
        SEQ585.text = "\\ifdim";
        SEQ585.TYPE = "KEYWORD3";
        SEQ SEQ586 = new SEQ();
        SEQ586.text = "\\ifcat";
        SEQ586.TYPE = "KEYWORD3";
        SEQ SEQ587 = new SEQ();
        SEQ587.text = "\\hskip";
        SEQ587.TYPE = "KEYWORD1";
        SEQ SEQ588 = new SEQ();
        SEQ588.text = "\\hsize";
        SEQ588.TYPE = "KEYWORD4";
        SEQ SEQ589 = new SEQ();
        SEQ589.text = "\\hrule";
        SEQ589.TYPE = "KEYWORD1";
        SEQ SEQ590 = new SEQ();
        SEQ590.text = "\\hglue";
        SEQ590.TYPE = "KEYWORD1";
        SEQ SEQ591 = new SEQ();
        SEQ591.text = "\\hfuzz";
        SEQ591.TYPE = "KEYWORD4";
        SEQ SEQ592 = new SEQ();
        SEQ592.text = "\\hfill";
        SEQ592.TYPE = "KEYWORD1";
        SEQ SEQ593 = new SEQ();
        SEQ593.text = "\\grave";
        SEQ593.TYPE = "KEYWORD1";
        SEQ SEQ594 = new SEQ();
        SEQ594.text = "\\Gamma";
        SEQ594.TYPE = "KEYWORD1";
        SEQ SEQ595 = new SEQ();
        SEQ595.text = "\\gamma";
        SEQ595.TYPE = "KEYWORD1";
        SEQ SEQ596 = new SEQ();
        SEQ596.text = "\\frown";
        SEQ596.TYPE = "KEYWORD1";
        SEQ SEQ597 = new SEQ();
        SEQ597.text = "\\folio";
        SEQ597.TYPE = "KEYWORD1";
        SEQ SEQ598 = new SEQ();
        SEQ598.text = "\\fivei";
        SEQ598.TYPE = "KEYWORD1";
        SEQ SEQ599 = new SEQ();
        SEQ599.text = "\\equiv";
        SEQ599.TYPE = "KEYWORD1";
        SEQ SEQ600 = new SEQ();
        SEQ600.text = "\\empty";
        SEQ600.TYPE = "KEYWORD1";
        SEQ SEQ601 = new SEQ();
        SEQ601.text = "\\eject";
        SEQ601.TYPE = "KEYWORD1";
        SEQ SEQ602 = new SEQ();
        SEQ602.text = "\\doteq";
        SEQ602.TYPE = "KEYWORD1";
        SEQ SEQ603 = new SEQ();
        SEQ603.text = "\\dimen";
        SEQ603.TYPE = "COMMENT4";
        SEQ SEQ604 = new SEQ();
        SEQ604.text = "\\Delta";
        SEQ604.TYPE = "KEYWORD1";
        SEQ SEQ605 = new SEQ();
        SEQ605.text = "\\delta";
        SEQ605.TYPE = "KEYWORD1";
        SEQ SEQ606 = new SEQ();
        SEQ606.text = "\\ddots";
        SEQ606.TYPE = "KEYWORD1";
        SEQ SEQ607 = new SEQ();
        SEQ607.text = "\\dashv";
        SEQ607.TYPE = "KEYWORD1";
        SEQ SEQ608 = new SEQ();
        SEQ608.text = "\\count";
        SEQ608.TYPE = "COMMENT4";
        SEQ SEQ609 = new SEQ();
        SEQ609.text = "\\colon";
        SEQ609.TYPE = "KEYWORD1";
        SEQ SEQ610 = new SEQ();
        SEQ610.text = "\\check";
        SEQ610.TYPE = "KEYWORD1";
        SEQ SEQ611 = new SEQ();
        SEQ611.text = "\\cdots";
        SEQ611.TYPE = "KEYWORD1";
        SEQ SEQ612 = new SEQ();
        SEQ612.text = "\\cdotp";
        SEQ612.TYPE = "KEYWORD1";
        SEQ SEQ613 = new SEQ();
        SEQ613.text = "\\cases";
        SEQ613.TYPE = "KEYWORD1";
        SEQ SEQ614 = new SEQ();
        SEQ614.text = "\\breve";
        SEQ614.TYPE = "KEYWORD1";
        SEQ SEQ615 = new SEQ();
        SEQ615.text = "\\break";
        SEQ615.TYPE = "KEYWORD1";
        SEQ SEQ616 = new SEQ();
        SEQ616.text = "\\brack";
        SEQ616.TYPE = "KEYWORD1";
        SEQ SEQ617 = new SEQ();
        SEQ617.text = "\\brace";
        SEQ617.TYPE = "KEYWORD1";
        SEQ SEQ618 = new SEQ();
        SEQ618.text = "\\Biggr";
        SEQ618.TYPE = "KEYWORD1";
        SEQ SEQ619 = new SEQ();
        SEQ619.text = "\\biggr";
        SEQ619.TYPE = "KEYWORD1";
        SEQ SEQ620 = new SEQ();
        SEQ620.text = "\\Biggm";
        SEQ620.TYPE = "KEYWORD1";
        SEQ SEQ621 = new SEQ();
        SEQ621.text = "\\biggm";
        SEQ621.TYPE = "KEYWORD1";
        SEQ SEQ622 = new SEQ();
        SEQ622.text = "\\Biggl";
        SEQ622.TYPE = "KEYWORD1";
        SEQ SEQ623 = new SEQ();
        SEQ623.text = "\\biggl";
        SEQ623.TYPE = "KEYWORD1";
        SEQ SEQ624 = new SEQ();
        SEQ624.text = "\\bffam";
        SEQ624.TYPE = "KEYWORD1";
        SEQ SEQ625 = new SEQ();
        SEQ625.text = "\\asymp";
        SEQ625.TYPE = "KEYWORD1";
        SEQ SEQ626 = new SEQ();
        SEQ626.text = "\\angle";
        SEQ626.TYPE = "KEYWORD1";
        SEQ SEQ627 = new SEQ();
        SEQ627.text = "\\amalg";
        SEQ627.TYPE = "KEYWORD1";
        SEQ SEQ628 = new SEQ();
        SEQ628.text = "\\alpha";
        SEQ628.TYPE = "KEYWORD1";
        SEQ SEQ629 = new SEQ();
        SEQ629.text = "\\aleph";
        SEQ629.TYPE = "KEYWORD1";
        SEQ SEQ630 = new SEQ();
        SEQ630.text = "\\acute";
        SEQ630.TYPE = "KEYWORD1";
        SEQ SEQ631 = new SEQ();
        SEQ631.text = "\\above";
        SEQ631.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP41 = new SEQ_REGEXP();
        SEQ_REGEXP41.text = "\\\\toks[0-9]";
        SEQ_REGEXP41.HASH_CHARS = "\\";
        SEQ_REGEXP41.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP42 = new SEQ_REGEXP();
        SEQ_REGEXP42.text = "\\\\skip[0-9]";
        SEQ_REGEXP42.HASH_CHARS = "\\";
        SEQ_REGEXP42.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP43 = new SEQ_REGEXP();
        SEQ_REGEXP43.text = "\\\\box[0-9][0-9]";
        SEQ_REGEXP43.HASH_CHARS = "\\";
        SEQ_REGEXP43.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP44 = new SEQ_REGEXP();
        SEQ_REGEXP44.text = "\\\\char[0-9]";
        SEQ_REGEXP44.HASH_CHARS = "\\";
        SEQ_REGEXP44.TYPE = "KEYWORD2";
        SEQ SEQ632 = new SEQ();
        SEQ632.text = "\\char'";
        SEQ632.TYPE = "KEYWORD2";
        SEQ SEQ633 = new SEQ();
        SEQ633.text = "\\char\"";
        SEQ633.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP45 = new SEQ_REGEXP();
        SEQ_REGEXP45.text = "\\\\[a-zA-Z@]{5}";
        SEQ_REGEXP45.HASH_CHARS = "\\";
        SEQ_REGEXP45.TYPE = "LABEL";
        SEQ SEQ634 = new SEQ();
        SEQ634.text = "\\zeta";
        SEQ634.TYPE = "KEYWORD1";
        SEQ SEQ635 = new SEQ();
        SEQ635.text = "\\year";
        SEQ635.TYPE = "KEYWORD4";
        SEQ SEQ636 = new SEQ();
        SEQ636.text = "\\xdef";
        SEQ636.TYPE = "FUNCTION";
        SEQ SEQ637 = new SEQ();
        SEQ637.text = "\\wlog";
        SEQ637.TYPE = "KEYWORD1";
        SEQ SEQ638 = new SEQ();
        SEQ638.text = "\\vtop";
        SEQ638.TYPE = "KEYWORD1";
        SEQ SEQ639 = new SEQ();
        SEQ639.text = "\\vfil";
        SEQ639.TYPE = "KEYWORD1";
        SEQ SEQ640 = new SEQ();
        SEQ640.text = "\\vert";
        SEQ640.TYPE = "KEYWORD1";
        SEQ SEQ641 = new SEQ();
        SEQ641.text = "\\Vert";
        SEQ641.TYPE = "KEYWORD1";
        SEQ SEQ642 = new SEQ();
        SEQ642.text = "\\vbox";
        SEQ642.TYPE = "KEYWORD1";
        SEQ SEQ643 = new SEQ();
        SEQ643.text = "\\uarc";
        SEQ643.TYPE = "KEYWORD2";
        SEQ SEQ644 = new SEQ();
        SEQ644.text = "\\toks";
        SEQ644.TYPE = "KEYWORD4";
        SEQ SEQ645 = new SEQ();
        SEQ645.text = "\\time";
        SEQ645.TYPE = "KEYWORD4";
        SEQ SEQ646 = new SEQ();
        SEQ646.text = "\\teni";
        SEQ646.TYPE = "KEYWORD1";
        SEQ SEQ647 = new SEQ();
        SEQ647.text = "\\tanh";
        SEQ647.TYPE = "KEYWORD1";
        SEQ SEQ648 = new SEQ();
        SEQ648.text = "\\tabs";
        SEQ648.TYPE = "KEYWORD1";
        SEQ SEQ649 = new SEQ();
        SEQ649.text = "\\surd";
        SEQ649.TYPE = "KEYWORD1";
        SEQ SEQ650 = new SEQ();
        SEQ650.text = "\\succ";
        SEQ650.TYPE = "KEYWORD1";
        SEQ SEQ651 = new SEQ();
        SEQ651.text = "\\star";
        SEQ651.TYPE = "KEYWORD1";
        SEQ SEQ652 = new SEQ();
        SEQ652.text = "\\sqrt";
        SEQ652.TYPE = "KEYWORD1";
        SEQ SEQ653 = new SEQ();
        SEQ653.text = "\\span";
        SEQ653.TYPE = "KEYWORD1";
        SEQ SEQ654 = new SEQ();
        SEQ654.text = "\\skip";
        SEQ654.TYPE = "KEYWORD4";
        SEQ SEQ655 = new SEQ();
        SEQ655.text = "\\skew";
        SEQ655.TYPE = "KEYWORD1";
        SEQ SEQ656 = new SEQ();
        SEQ656.text = "\\sinh";
        SEQ656.TYPE = "KEYWORD1";
        SEQ SEQ657 = new SEQ();
        SEQ657.text = "\\show";
        SEQ657.TYPE = "KEYWORD1";
        SEQ SEQ658 = new SEQ();
        SEQ658.text = "\\root";
        SEQ658.TYPE = "KEYWORD1";
        SEQ SEQ659 = new SEQ();
        SEQ659.text = "\\rlap";
        SEQ659.TYPE = "KEYWORD1";
        SEQ SEQ660 = new SEQ();
        SEQ660.text = "\\read";
        SEQ660.TYPE = "KEYWORD1";
        SEQ SEQ661 = new SEQ();
        SEQ661.text = "\\quad";
        SEQ661.TYPE = "KEYWORD1";
        SEQ SEQ662 = new SEQ();
        SEQ662.text = "\\prod";
        SEQ662.TYPE = "KEYWORD1";
        SEQ SEQ663 = new SEQ();
        SEQ663.text = "\\prec";
        SEQ663.TYPE = "KEYWORD1";
        SEQ SEQ664 = new SEQ();
        SEQ664.text = "\\pmod";
        SEQ664.TYPE = "KEYWORD1";
        SEQ SEQ665 = new SEQ();
        SEQ665.text = "\\perp";
        SEQ665.TYPE = "KEYWORD1";
        SEQ SEQ666 = new SEQ();
        SEQ666.text = "\\owns";
        SEQ666.TYPE = "KEYWORD1";
        SEQ SEQ667 = new SEQ();
        SEQ667.text = "\\over";
        SEQ667.TYPE = "KEYWORD1";
        SEQ SEQ668 = new SEQ();
        SEQ668.text = "\\omit";
        SEQ668.TYPE = "KEYWORD1";
        SEQ SEQ669 = new SEQ();
        SEQ669.text = "\\oint";
        SEQ669.TYPE = "KEYWORD1";
        SEQ SEQ670 = new SEQ();
        SEQ670.text = "\\odot";
        SEQ670.TYPE = "KEYWORD1";
        SEQ SEQ671 = new SEQ();
        SEQ671.text = "\\null";
        SEQ671.TYPE = "KEYWORD1";
        SEQ SEQ672 = new SEQ();
        SEQ672.text = "\\next";
        SEQ672.TYPE = "KEYWORD1";
        SEQ SEQ673 = new SEQ();
        SEQ673.text = "\\mark";
        SEQ673.TYPE = "KEYWORD1";
        SEQ SEQ674 = new SEQ();
        SEQ674.text = "\\loop";
        SEQ674.TYPE = "KEYWORD1";
        SEQ SEQ675 = new SEQ();
        SEQ675.text = "\\long";
        SEQ675.TYPE = "FUNCTION";
        SEQ SEQ676 = new SEQ();
        SEQ676.text = "\\lnot";
        SEQ676.TYPE = "KEYWORD1";
        SEQ SEQ677 = new SEQ();
        SEQ677.text = "\\llap";
        SEQ677.TYPE = "KEYWORD1";
        SEQ SEQ678 = new SEQ();
        SEQ678.text = "\\line";
        SEQ678.TYPE = "KEYWORD1";
        SEQ SEQ679 = new SEQ();
        SEQ679.text = "\\left";
        SEQ679.TYPE = "KEYWORD1";
        SEQ SEQ680 = new SEQ();
        SEQ680.text = "\\land";
        SEQ680.TYPE = "KEYWORD1";
        SEQ SEQ681 = new SEQ();
        SEQ681.text = "\\kern";
        SEQ681.TYPE = "KEYWORD1";
        SEQ SEQ682 = new SEQ();
        SEQ682.text = "\\item";
        SEQ682.TYPE = "KEYWORD1";
        SEQ SEQ683 = new SEQ();
        SEQ683.text = "\\iota";
        SEQ683.TYPE = "KEYWORD1";
        SEQ SEQ684 = new SEQ();
        SEQ684.text = "\\hfil";
        SEQ684.TYPE = "KEYWORD1";
        SEQ SEQ685 = new SEQ();
        SEQ685.text = "\\hbox";
        SEQ685.TYPE = "KEYWORD1";
        SEQ SEQ686 = new SEQ();
        SEQ686.text = "\\hbar";
        SEQ686.TYPE = "KEYWORD1";
        SEQ SEQ687 = new SEQ();
        SEQ687.text = "\\hang";
        SEQ687.TYPE = "KEYWORD1";
        SEQ SEQ688 = new SEQ();
        SEQ688.text = "\\gets";
        SEQ688.TYPE = "KEYWORD1";
        SEQ SEQ689 = new SEQ();
        SEQ689.text = "\\gdef";
        SEQ689.TYPE = "FUNCTION";
        SEQ SEQ690 = new SEQ();
        SEQ690.text = "\\font";
        SEQ690.TYPE = "KEYWORD1";
        SEQ SEQ691 = new SEQ();
        SEQ691.text = "\\flat";
        SEQ691.TYPE = "KEYWORD1";
        SEQ SEQ692 = new SEQ();
        SEQ692.text = "\\eqno";
        SEQ692.TYPE = "KEYWORD1";
        SEQ SEQ693 = new SEQ();
        SEQ693.text = "\\else";
        SEQ693.TYPE = "KEYWORD3";
        SEQ SEQ694 = new SEQ();
        SEQ694.text = "\\edef";
        SEQ694.TYPE = "FUNCTION";
        SEQ SEQ695 = new SEQ();
        SEQ695.text = "\\dump";
        SEQ695.TYPE = "KEYWORD1";
        SEQ SEQ696 = new SEQ();
        SEQ696.text = "\\dots";
        SEQ696.TYPE = "KEYWORD1";
        SEQ SEQ697 = new SEQ();
        SEQ697.text = "\\ddot";
        SEQ697.TYPE = "KEYWORD1";
        SEQ SEQ698 = new SEQ();
        SEQ698.text = "\\ddag";
        SEQ698.TYPE = "KEYWORD1";
        SEQ SEQ699 = new SEQ();
        SEQ699.text = "\\dbar";
        SEQ699.TYPE = "KEYWORD2";
        SEQ SEQ700 = new SEQ();
        SEQ700.text = "\\Dbar";
        SEQ700.TYPE = "KEYWORD2";
        SEQ SEQ701 = new SEQ();
        SEQ701.text = "\\crcr";
        SEQ701.TYPE = "KEYWORD1";
        SEQ SEQ702 = new SEQ();
        SEQ702.text = "\\coth";
        SEQ702.TYPE = "KEYWORD1";
        SEQ SEQ703 = new SEQ();
        SEQ703.text = "\\cosh";
        SEQ703.TYPE = "KEYWORD1";
        SEQ SEQ704 = new SEQ();
        SEQ704.text = "\\copy";
        SEQ704.TYPE = "KEYWORD1";
        SEQ SEQ705 = new SEQ();
        SEQ705.text = "\\cong";
        SEQ705.TYPE = "KEYWORD1";
        SEQ SEQ706 = new SEQ();
        SEQ706.text = "\\circ";
        SEQ706.TYPE = "KEYWORD1";
        SEQ SEQ707 = new SEQ();
        SEQ707.text = "\\char";
        SEQ707.TYPE = "KEYWORD2";
        SEQ SEQ708 = new SEQ();
        SEQ708.text = "\\cfac";
        SEQ708.TYPE = "KEYWORD2";
        SEQ SEQ709 = new SEQ();
        SEQ709.text = "\\cdot";
        SEQ709.TYPE = "KEYWORD1";
        SEQ SEQ710 = new SEQ();
        SEQ710.text = "\\body";
        SEQ710.TYPE = "KEYWORD1";
        SEQ SEQ711 = new SEQ();
        SEQ711.text = "\\bmod";
        SEQ711.TYPE = "KEYWORD1";
        SEQ SEQ712 = new SEQ();
        SEQ712.text = "\\Bigr";
        SEQ712.TYPE = "KEYWORD1";
        SEQ SEQ713 = new SEQ();
        SEQ713.text = "\\bigr";
        SEQ713.TYPE = "KEYWORD1";
        SEQ SEQ714 = new SEQ();
        SEQ714.text = "\\Bigm";
        SEQ714.TYPE = "KEYWORD1";
        SEQ SEQ715 = new SEQ();
        SEQ715.text = "\\bigm";
        SEQ715.TYPE = "KEYWORD1";
        SEQ SEQ716 = new SEQ();
        SEQ716.text = "\\Bigl";
        SEQ716.TYPE = "KEYWORD1";
        SEQ SEQ717 = new SEQ();
        SEQ717.text = "\\bigl";
        SEQ717.TYPE = "KEYWORD1";
        SEQ SEQ718 = new SEQ();
        SEQ718.text = "\\Bigg";
        SEQ718.TYPE = "KEYWORD1";
        SEQ SEQ719 = new SEQ();
        SEQ719.text = "\\bigg";
        SEQ719.TYPE = "KEYWORD1";
        SEQ SEQ720 = new SEQ();
        SEQ720.text = "\\beta";
        SEQ720.TYPE = "KEYWORD1";
        SEQ SEQ721 = new SEQ();
        SEQ721.text = "\\atop";
        SEQ721.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP46 = new SEQ_REGEXP();
        SEQ_REGEXP46.text = "\\\\box[0-9]";
        SEQ_REGEXP46.HASH_CHARS = "\\";
        SEQ_REGEXP46.TYPE = "COMMENT4";
        SEQ SEQ722 = new SEQ();
        SEQ722.text = "\\char";
        SEQ722.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP47 = new SEQ_REGEXP();
        SEQ_REGEXP47.text = "(\\u005E|\\x5E)(\\u005E|\\x5E)([0-9a-f])([0-9a-f])";
        SEQ_REGEXP47.HASH_CHARS = "^";
        SEQ_REGEXP47.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP48 = new SEQ_REGEXP();
        SEQ_REGEXP48.text = "\\\\[a-zA-Z@]{4}";
        SEQ_REGEXP48.HASH_CHARS = "\\";
        SEQ_REGEXP48.TYPE = "LABEL";
        SEQ SEQ723 = new SEQ();
        SEQ723.text = "\\vss";
        SEQ723.TYPE = "KEYWORD1";
        SEQ SEQ724 = new SEQ();
        SEQ724.text = "\\vee";
        SEQ724.TYPE = "KEYWORD1";
        SEQ SEQ725 = new SEQ();
        SEQ725.text = "\\vec";
        SEQ725.TYPE = "KEYWORD1";
        SEQ SEQ726 = new SEQ();
        SEQ726.text = "\\top";
        SEQ726.TYPE = "KEYWORD1";
        SEQ SEQ727 = new SEQ();
        SEQ727.text = "\\the";
        SEQ727.TYPE = "KEYWORD1";
        SEQ SEQ728 = new SEQ();
        SEQ728.text = "\\TeX";
        SEQ728.TYPE = "KEYWORD1";
        SEQ SEQ729 = new SEQ();
        SEQ729.text = "\\tau";
        SEQ729.TYPE = "KEYWORD1";
        SEQ SEQ730 = new SEQ();
        SEQ730.text = "\\tan";
        SEQ730.TYPE = "KEYWORD1";
        SEQ SEQ731 = new SEQ();
        SEQ731.text = "\\sup";
        SEQ731.TYPE = "KEYWORD1";
        SEQ SEQ732 = new SEQ();
        SEQ732.text = "\\sum";
        SEQ732.TYPE = "KEYWORD1";
        SEQ SEQ733 = new SEQ();
        SEQ733.text = "\\sin";
        SEQ733.TYPE = "KEYWORD1";
        SEQ SEQ734 = new SEQ();
        SEQ734.text = "\\sim";
        SEQ734.TYPE = "KEYWORD1";
        SEQ SEQ735 = new SEQ();
        SEQ735.text = "\\sec";
        SEQ735.TYPE = "KEYWORD1";
        SEQ SEQ736 = new SEQ();
        SEQ736.text = "\\rho";
        SEQ736.TYPE = "KEYWORD1";
        SEQ SEQ737 = new SEQ();
        SEQ737.text = "\\Psi";
        SEQ737.TYPE = "KEYWORD1";
        SEQ SEQ738 = new SEQ();
        SEQ738.text = "\\psi";
        SEQ738.TYPE = "KEYWORD1";
        SEQ SEQ739 = new SEQ();
        SEQ739.text = "\\Phi";
        SEQ739.TYPE = "KEYWORD1";
        SEQ SEQ740 = new SEQ();
        SEQ740.text = "\\phi";
        SEQ740.TYPE = "KEYWORD1";
        SEQ SEQ741 = new SEQ();
        SEQ741.text = "\\par";
        SEQ741.TYPE = "LITERAL3";
        SEQ SEQ742 = new SEQ();
        SEQ742.text = "\\not";
        SEQ742.TYPE = "KEYWORD1";
        SEQ SEQ743 = new SEQ();
        SEQ743.text = "\\neq";
        SEQ743.TYPE = "KEYWORD1";
        SEQ SEQ744 = new SEQ();
        SEQ744.text = "\\neg";
        SEQ744.TYPE = "KEYWORD1";
        SEQ SEQ745 = new SEQ();
        SEQ745.text = "\\mit";
        SEQ745.TYPE = "KEYWORD1";
        SEQ SEQ746 = new SEQ();
        SEQ746.text = "\\min";
        SEQ746.TYPE = "KEYWORD1";
        SEQ SEQ747 = new SEQ();
        SEQ747.text = "\\mid";
        SEQ747.TYPE = "KEYWORD1";
        SEQ SEQ748 = new SEQ();
        SEQ748.text = "\\max";
        SEQ748.TYPE = "KEYWORD1";
        SEQ SEQ749 = new SEQ();
        SEQ749.text = "\\mag";
        SEQ749.TYPE = "KEYWORD4";
        SEQ SEQ750 = new SEQ();
        SEQ750.text = "\\lor";
        SEQ750.TYPE = "KEYWORD1";
        SEQ SEQ751 = new SEQ();
        SEQ751.text = "\\log";
        SEQ751.TYPE = "KEYWORD1";
        SEQ SEQ752 = new SEQ();
        SEQ752.text = "\\lim";
        SEQ752.TYPE = "KEYWORD1";
        SEQ SEQ753 = new SEQ();
        SEQ753.text = "\\let";
        SEQ753.TYPE = "COMMENT3";
        SEQ SEQ754 = new SEQ();
        SEQ754.text = "\\leq";
        SEQ754.TYPE = "KEYWORD1";
        SEQ SEQ755 = new SEQ();
        SEQ755.text = "\\ker";
        SEQ755.TYPE = "KEYWORD1";
        SEQ SEQ756 = new SEQ();
        SEQ756.text = "\\jot";
        SEQ756.TYPE = "KEYWORD1";
        SEQ SEQ757 = new SEQ();
        SEQ757.text = "\\int";
        SEQ757.TYPE = "KEYWORD1";
        SEQ SEQ758 = new SEQ();
        SEQ758.text = "\\inf";
        SEQ758.TYPE = "KEYWORD1";
        SEQ SEQ759 = new SEQ();
        SEQ759.text = "\\ifx";
        SEQ759.TYPE = "KEYWORD3";
        SEQ SEQ760 = new SEQ();
        SEQ760.text = "\\iff";
        SEQ760.TYPE = "KEYWORD3";
        SEQ SEQ761 = new SEQ();
        SEQ761.text = "\\hss";
        SEQ761.TYPE = "KEYWORD1";
        SEQ SEQ762 = new SEQ();
        SEQ762.text = "\\hom";
        SEQ762.TYPE = "KEYWORD1";
        SEQ SEQ763 = new SEQ();
        SEQ763.text = "\\hat";
        SEQ763.TYPE = "KEYWORD1";
        SEQ SEQ764 = new SEQ();
        SEQ764.text = "\\geq";
        SEQ764.TYPE = "KEYWORD1";
        SEQ SEQ765 = new SEQ();
        SEQ765.text = "\\gcd";
        SEQ765.TYPE = "KEYWORD1";
        SEQ SEQ766 = new SEQ();
        SEQ766.text = "\\fam";
        SEQ766.TYPE = "KEYWORD4";
        SEQ SEQ767 = new SEQ();
        SEQ767.text = "\\exp";
        SEQ767.TYPE = "KEYWORD1";
        SEQ SEQ768 = new SEQ();
        SEQ768.text = "\\eth";
        SEQ768.TYPE = "KEYWORD2";
        SEQ SEQ769 = new SEQ();
        SEQ769.text = "\\eta";
        SEQ769.TYPE = "KEYWORD1";
        SEQ SEQ770 = new SEQ();
        SEQ770.text = "\\end";
        SEQ770.TYPE = "KEYWORD1";
        SEQ SEQ771 = new SEQ();
        SEQ771.text = "\\ell";
        SEQ771.TYPE = "KEYWORD1";
        SEQ SEQ772 = new SEQ();
        SEQ772.text = "\\dot";
        SEQ772.TYPE = "KEYWORD1";
        SEQ SEQ773 = new SEQ();
        SEQ773.text = "\\div";
        SEQ773.TYPE = "KEYWORD1";
        SEQ SEQ774 = new SEQ();
        SEQ774.text = "\\dim";
        SEQ774.TYPE = "KEYWORD1";
        SEQ SEQ775 = new SEQ();
        SEQ775.text = "\\det";
        SEQ775.TYPE = "KEYWORD1";
        SEQ SEQ776 = new SEQ();
        SEQ776.text = "\\deg";
        SEQ776.TYPE = "KEYWORD1";
        SEQ SEQ777 = new SEQ();
        SEQ777.text = "\\def";
        SEQ777.TYPE = "FUNCTION";
        SEQ SEQ778 = new SEQ();
        SEQ778.text = "\\day";
        SEQ778.TYPE = "KEYWORD4";
        SEQ SEQ779 = new SEQ();
        SEQ779.text = "\\dag";
        SEQ779.TYPE = "KEYWORD1";
        SEQ SEQ780 = new SEQ();
        SEQ780.text = "\\cup";
        SEQ780.TYPE = "KEYWORD1";
        SEQ SEQ781 = new SEQ();
        SEQ781.text = "\\csc";
        SEQ781.TYPE = "KEYWORD1";
        SEQ SEQ782 = new SEQ();
        SEQ782.text = "\\cot";
        SEQ782.TYPE = "KEYWORD1";
        SEQ SEQ783 = new SEQ();
        SEQ783.text = "\\cos";
        SEQ783.TYPE = "KEYWORD1";
        SEQ SEQ784 = new SEQ();
        SEQ784.text = "\\chi";
        SEQ784.TYPE = "KEYWORD1";
        SEQ SEQ785 = new SEQ();
        SEQ785.text = "\\cap";
        SEQ785.TYPE = "KEYWORD1";
        SEQ SEQ786 = new SEQ();
        SEQ786.text = "\\cal";
        SEQ786.TYPE = "KEYWORD1";
        SEQ SEQ787 = new SEQ();
        SEQ787.text = "\\bye";
        SEQ787.TYPE = "KEYWORD1";
        SEQ SEQ788 = new SEQ();
        SEQ788.text = "\\box";
        SEQ788.TYPE = "COMMENT4";
        SEQ SEQ789 = new SEQ();
        SEQ789.text = "\\bot";
        SEQ789.TYPE = "KEYWORD1";
        SEQ SEQ790 = new SEQ();
        SEQ790.text = "\\Big";
        SEQ790.TYPE = "KEYWORD1";
        SEQ SEQ791 = new SEQ();
        SEQ791.text = "\\big";
        SEQ791.TYPE = "KEYWORD1";
        SEQ SEQ792 = new SEQ();
        SEQ792.text = "\\bar";
        SEQ792.TYPE = "KEYWORD1";
        SEQ SEQ793 = new SEQ();
        SEQ793.text = "\\ast";
        SEQ793.TYPE = "KEYWORD1";
        SEQ SEQ794 = new SEQ();
        SEQ794.text = "\\arg";
        SEQ794.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP49 = new SEQ_REGEXP();
        SEQ_REGEXP49.text = "(\\u005E|\\x5E)(\\u005E|\\x5E)(\\p{ASCII}|\\u0000-\\u007F)";
        SEQ_REGEXP49.HASH_CHARS = "^";
        SEQ_REGEXP49.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP50 = new SEQ_REGEXP();
        SEQ_REGEXP50.text = "\\\\[a-zA-Z@]{3}";
        SEQ_REGEXP50.HASH_CHARS = "\\";
        SEQ_REGEXP50.TYPE = "LABEL";
        SEQ SEQ795 = new SEQ();
        SEQ795.text = "\\Xi";
        SEQ795.TYPE = "KEYWORD1";
        SEQ SEQ796 = new SEQ();
        SEQ796.text = "\\xi";
        SEQ796.TYPE = "KEYWORD1";
        SEQ SEQ797 = new SEQ();
        SEQ797.text = "\\wr";
        SEQ797.TYPE = "KEYWORD1";
        SEQ SEQ798 = new SEQ();
        SEQ798.text = "\\wp";
        SEQ798.TYPE = "KEYWORD1";
        SEQ SEQ799 = new SEQ();
        SEQ799.text = "\\wd";
        SEQ799.TYPE = "KEYWORD1";
        SEQ SEQ800 = new SEQ();
        SEQ800.text = "\\tt";
        SEQ800.TYPE = "KEYWORD1";
        SEQ SEQ801 = new SEQ();
        SEQ801.text = "\\to";
        SEQ801.TYPE = "KEYWORD1";
        SEQ SEQ802 = new SEQ();
        SEQ802.text = "\\sp";
        SEQ802.TYPE = "KEYWORD1";
        SEQ SEQ803 = new SEQ();
        SEQ803.text = "\\sl";
        SEQ803.TYPE = "KEYWORD1";
        SEQ SEQ804 = new SEQ();
        SEQ804.text = "\\sb";
        SEQ804.TYPE = "KEYWORD1";
        SEQ SEQ805 = new SEQ();
        SEQ805.text = "\\rq";
        SEQ805.TYPE = "KEYWORD1";
        SEQ SEQ806 = new SEQ();
        SEQ806.text = "\\rm";
        SEQ806.TYPE = "KEYWORD1";
        SEQ SEQ807 = new SEQ();
        SEQ807.text = "\\Re";
        SEQ807.TYPE = "KEYWORD1";
        SEQ SEQ808 = new SEQ();
        SEQ808.text = "\\Pr";
        SEQ808.TYPE = "KEYWORD1";
        SEQ SEQ809 = new SEQ();
        SEQ809.text = "\\pm";
        SEQ809.TYPE = "KEYWORD1";
        SEQ SEQ810 = new SEQ();
        SEQ810.text = "\\Pi";
        SEQ810.TYPE = "KEYWORD1";
        SEQ SEQ811 = new SEQ();
        SEQ811.text = "\\pi";
        SEQ811.TYPE = "KEYWORD1";
        SEQ SEQ812 = new SEQ();
        SEQ812.text = "\\or";
        SEQ812.TYPE = "KEYWORD3";
        SEQ SEQ813 = new SEQ();
        SEQ813.text = "\\of";
        SEQ813.TYPE = "KEYWORD1";
        SEQ SEQ814 = new SEQ();
        SEQ814.text = "\\nu";
        SEQ814.TYPE = "KEYWORD1";
        SEQ SEQ815 = new SEQ();
        SEQ815.text = "\\ni";
        SEQ815.TYPE = "KEYWORD1";
        SEQ SEQ816 = new SEQ();
        SEQ816.text = "\\ne";
        SEQ816.TYPE = "KEYWORD1";
        SEQ SEQ817 = new SEQ();
        SEQ817.text = "\\mu";
        SEQ817.TYPE = "KEYWORD1";
        SEQ SEQ818 = new SEQ();
        SEQ818.text = "\\mp";
        SEQ818.TYPE = "KEYWORD1";
        SEQ SEQ819 = new SEQ();
        SEQ819.text = "\\lq";
        SEQ819.TYPE = "KEYWORD1";
        SEQ SEQ820 = new SEQ();
        SEQ820.text = "\\ln";
        SEQ820.TYPE = "KEYWORD1";
        SEQ SEQ821 = new SEQ();
        SEQ821.text = "\\ll";
        SEQ821.TYPE = "KEYWORD1";
        SEQ SEQ822 = new SEQ();
        SEQ822.text = "\\lg";
        SEQ822.TYPE = "KEYWORD1";
        SEQ SEQ823 = new SEQ();
        SEQ823.text = "\\le";
        SEQ823.TYPE = "KEYWORD1";
        SEQ SEQ824 = new SEQ();
        SEQ824.text = "\\it";
        SEQ824.TYPE = "KEYWORD1";
        SEQ SEQ825 = new SEQ();
        SEQ825.text = "\\in";
        SEQ825.TYPE = "KEYWORD1";
        SEQ SEQ826 = new SEQ();
        SEQ826.text = "\\Im";
        SEQ826.TYPE = "KEYWORD1";
        SEQ SEQ827 = new SEQ();
        SEQ827.text = "\\if";
        SEQ827.TYPE = "KEYWORD3";
        SEQ SEQ828 = new SEQ();
        SEQ828.text = "\\ht";
        SEQ828.TYPE = "KEYWORD1";
        SEQ SEQ829 = new SEQ();
        SEQ829.text = "\\gg";
        SEQ829.TYPE = "KEYWORD1";
        SEQ SEQ830 = new SEQ();
        SEQ830.text = "\\ge";
        SEQ830.TYPE = "KEYWORD1";
        SEQ SEQ831 = new SEQ();
        SEQ831.text = "\\fi";
        SEQ831.TYPE = "KEYWORD3";
        SEQ SEQ832 = new SEQ();
        SEQ832.text = "\\dp";
        SEQ832.TYPE = "KEYWORD1";
        SEQ SEQ833 = new SEQ();
        SEQ833.text = "\\do";
        SEQ833.TYPE = "KEYWORD1";
        SEQ SEQ834 = new SEQ();
        SEQ834.text = "\\cr";
        SEQ834.TYPE = "KEYWORD1";
        SEQ SEQ835 = new SEQ();
        SEQ835.text = "\\bf";
        SEQ835.TYPE = "KEYWORD1";
        SEQ SEQ836 = new SEQ();
        SEQ836.text = "\\AE";
        SEQ836.TYPE = "KEYWORD2";
        SEQ SEQ837 = new SEQ();
        SEQ837.text = "\\ae";
        SEQ837.TYPE = "KEYWORD2";
        SEQ SEQ838 = new SEQ();
        SEQ838.text = "\\AA";
        SEQ838.TYPE = "KEYWORD2";
        SEQ SEQ839 = new SEQ();
        SEQ839.text = "\\aa";
        SEQ839.TYPE = "KEYWORD2";
        SEQ SEQ840 = new SEQ();
        SEQ840.text = "\\OE";
        SEQ840.TYPE = "KEYWORD2";
        SEQ SEQ841 = new SEQ();
        SEQ841.text = "\\oe";
        SEQ841.TYPE = "KEYWORD2";
        SEQ SEQ842 = new SEQ();
        SEQ842.text = "\\ss";
        SEQ842.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP51 = new SEQ_REGEXP();
        SEQ_REGEXP51.text = "\\\\[a-zA-Z@]{2}";
        SEQ_REGEXP51.HASH_CHARS = "\\";
        SEQ_REGEXP51.TYPE = "LABEL";
        SEQ SEQ843 = new SEQ();
        SEQ843.text = "\\S";
        SEQ843.TYPE = "KEYWORD1";
        SEQ SEQ844 = new SEQ();
        SEQ844.text = "\\P";
        SEQ844.TYPE = "KEYWORD1";
        SEQ SEQ845 = new SEQ();
        SEQ845.text = "\\=";
        SEQ845.TYPE = "KEYWORD2";
        SEQ SEQ846 = new SEQ();
        SEQ846.text = "\\'";
        SEQ846.TYPE = "KEYWORD2";
        SEQ SEQ847 = new SEQ();
        SEQ847.text = "\\\"";
        SEQ847.TYPE = "KEYWORD2";
        SEQ SEQ848 = new SEQ();
        SEQ848.text = "\\~";
        SEQ848.TYPE = "KEYWORD2";
        SEQ SEQ849 = new SEQ();
        SEQ849.text = "\\`";
        SEQ849.TYPE = "KEYWORD2";
        SEQ SEQ850 = new SEQ();
        SEQ850.text = "\\^";
        SEQ850.TYPE = "KEYWORD2";
        SEQ SEQ851 = new SEQ();
        SEQ851.text = "\\.";
        SEQ851.TYPE = "KEYWORD2";
        SEQ SEQ852 = new SEQ();
        SEQ852.text = "\\H";
        SEQ852.TYPE = "KEYWORD2";
        SEQ SEQ853 = new SEQ();
        SEQ853.text = "\\c";
        SEQ853.TYPE = "KEYWORD2";
        SEQ SEQ854 = new SEQ();
        SEQ854.text = "\\d";
        SEQ854.TYPE = "KEYWORD2";
        SEQ SEQ855 = new SEQ();
        SEQ855.text = "\\b";
        SEQ855.TYPE = "KEYWORD2";
        SEQ SEQ856 = new SEQ();
        SEQ856.text = "\\v";
        SEQ856.TYPE = "KEYWORD2";
        SEQ SEQ857 = new SEQ();
        SEQ857.text = "\\u";
        SEQ857.TYPE = "KEYWORD2";
        SEQ SEQ858 = new SEQ();
        SEQ858.text = "\\t";
        SEQ858.TYPE = "KEYWORD2";
        SEQ SEQ859 = new SEQ();
        SEQ859.text = "\\r";
        SEQ859.TYPE = "KEYWORD2";
        SEQ SEQ860 = new SEQ();
        SEQ860.text = "\\k";
        SEQ860.TYPE = "KEYWORD2";
        SEQ SEQ861 = new SEQ();
        SEQ861.text = "\\O";
        SEQ861.TYPE = "KEYWORD2";
        SEQ SEQ862 = new SEQ();
        SEQ862.text = "\\o";
        SEQ862.TYPE = "KEYWORD2";
        SEQ SEQ863 = new SEQ();
        SEQ863.text = "\\L";
        SEQ863.TYPE = "KEYWORD2";
        SEQ SEQ864 = new SEQ();
        SEQ864.text = "\\l";
        SEQ864.TYPE = "KEYWORD2";
        SEQ SEQ865 = new SEQ();
        SEQ865.text = "\\j";
        SEQ865.TYPE = "KEYWORD2";
        SEQ SEQ866 = new SEQ();
        SEQ866.text = "\\i";
        SEQ866.TYPE = "KEYWORD2";
        SEQ SEQ867 = new SEQ();
        SEQ867.text = "\\?";
        SEQ867.TYPE = "KEYWORD1";
        SEQ SEQ868 = new SEQ();
        SEQ868.text = "\\>";
        SEQ868.TYPE = "KEYWORD1";
        SEQ SEQ869 = new SEQ();
        SEQ869.text = "\\<";
        SEQ869.TYPE = "KEYWORD1";
        SEQ SEQ870 = new SEQ();
        SEQ870.text = "\\;";
        SEQ870.TYPE = "KEYWORD1";
        SEQ SEQ871 = new SEQ();
        SEQ871.text = "\\:";
        SEQ871.TYPE = "KEYWORD1";
        SEQ SEQ872 = new SEQ();
        SEQ872.text = "\\/";
        SEQ872.TYPE = "KEYWORD1";
        SEQ SEQ873 = new SEQ();
        SEQ873.text = "\\-";
        SEQ873.TYPE = "KEYWORD1";
        SEQ SEQ874 = new SEQ();
        SEQ874.text = "\\,";
        SEQ874.TYPE = "KEYWORD1";
        SEQ SEQ875 = new SEQ();
        SEQ875.text = "\\+";
        SEQ875.TYPE = "KEYWORD1";
        SEQ SEQ876 = new SEQ();
        SEQ876.text = "\\*";
        SEQ876.TYPE = "KEYWORD1";
        SEQ SEQ877 = new SEQ();
        SEQ877.text = "\\)";
        SEQ877.TYPE = "KEYWORD1";
        SEQ SEQ878 = new SEQ();
        SEQ878.text = "\\(";
        SEQ878.TYPE = "KEYWORD1";
        SEQ SEQ879 = new SEQ();
        SEQ879.text = "\\!";
        SEQ879.TYPE = "KEYWORD1";
        SEQ SEQ880 = new SEQ();
        SEQ880.text = "\\|";
        SEQ880.TYPE = "KEYWORD1";
        SEQ SEQ881 = new SEQ();
        SEQ881.text = "\\\\";
        SEQ881.TYPE = "KEYWORD1";
        SEQ SEQ882 = new SEQ();
        SEQ882.text = "\\#";
        SEQ882.TYPE = "KEYWORD2";
        SEQ SEQ883 = new SEQ();
        SEQ883.text = "\\$";
        SEQ883.TYPE = "KEYWORD2";
        SEQ SEQ884 = new SEQ();
        SEQ884.text = "\\%";
        SEQ884.TYPE = "KEYWORD2";
        SEQ SEQ885 = new SEQ();
        SEQ885.text = "\\&";
        SEQ885.TYPE = "KEYWORD2";
        SEQ SEQ886 = new SEQ();
        SEQ886.text = "\\{";
        SEQ886.TYPE = "KEYWORD2";
        SEQ SEQ887 = new SEQ();
        SEQ887.text = "\\}";
        SEQ887.TYPE = "KEYWORD2";
        SEQ SEQ888 = new SEQ();
        SEQ888.text = "\\_";
        SEQ888.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP52 = new SEQ_REGEXP();
        SEQ_REGEXP52.text = "`\\p{ASCII}";
        SEQ_REGEXP52.HASH_CHARS = "`";
        SEQ_REGEXP52.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP53 = new SEQ_REGEXP();
        SEQ_REGEXP53.text = "#[1-9]";
        SEQ_REGEXP53.HASH_CHARS = "#";
        SEQ_REGEXP53.TYPE = "DIGIT";
        SEQ_REGEXP SEQ_REGEXP54 = new SEQ_REGEXP();
        SEQ_REGEXP54.text = "\\\\[a-zA-Z@]{1}";
        SEQ_REGEXP54.HASH_CHARS = "\\";
        SEQ_REGEXP54.TYPE = "LABEL";
        SEQ SEQ889 = new SEQ();
        SEQ889.text = "`";
        SEQ889.TYPE = "LITERAL3";
        SEQ SEQ890 = new SEQ();
        SEQ890.text = "!";
        SEQ890.TYPE = "LITERAL3";
        SEQ SEQ891 = new SEQ();
        SEQ891.text = ".";
        SEQ891.TYPE = "LITERAL3";
        SEQ SEQ892 = new SEQ();
        SEQ892.text = ",";
        SEQ892.TYPE = "LITERAL3";
        SEQ SEQ893 = new SEQ();
        SEQ893.text = ";";
        SEQ893.TYPE = "LITERAL3";
        SEQ SEQ894 = new SEQ();
        SEQ894.text = "?";
        SEQ894.TYPE = "LITERAL3";
        SEQ SEQ895 = new SEQ();
        SEQ895.text = ":";
        SEQ895.TYPE = "LITERAL3";
        SEQ SEQ896 = new SEQ();
        SEQ896.text = "'";
        SEQ896.TYPE = "LITERAL3";
        SEQ SEQ897 = new SEQ();
        SEQ897.text = "\"";
        SEQ897.TYPE = "LITERAL3";
        SEQ SEQ898 = new SEQ();
        SEQ898.text = "\\";
        SEQ898.TYPE = "LITERAL3";
        SEQ SEQ899 = new SEQ();
        SEQ899.text = "(";
        SEQ899.TYPE = "LITERAL4";
        SEQ SEQ900 = new SEQ();
        SEQ900.text = ")";
        SEQ900.TYPE = "LITERAL4";
        SEQ SEQ901 = new SEQ();
        SEQ901.text = "=";
        SEQ901.TYPE = "LITERAL4";
        SEQ SEQ902 = new SEQ();
        SEQ902.text = "+";
        SEQ902.TYPE = "LITERAL4";
        SEQ SEQ903 = new SEQ();
        SEQ903.text = "-";
        SEQ903.TYPE = "LITERAL4";
        SEQ SEQ904 = new SEQ();
        SEQ904.text = ">";
        SEQ904.TYPE = "LITERAL4";
        SEQ SEQ905 = new SEQ();
        SEQ905.text = "<";
        SEQ905.TYPE = "LITERAL4";
        SEQ SEQ906 = new SEQ();
        SEQ906.text = "{";
        SEQ906.TYPE = "OPERATOR";
        SEQ SEQ907 = new SEQ();
        SEQ907.text = "}";
        SEQ907.TYPE = "OPERATOR";
        SEQ SEQ908 = new SEQ();
        SEQ908.text = "[";
        SEQ908.TYPE = "OPERATOR";
        SEQ SEQ909 = new SEQ();
        SEQ909.text = "]";
        SEQ909.TYPE = "OPERATOR";
        SEQ SEQ910 = new SEQ();
        SEQ910.text = "&";
        SEQ910.TYPE = "LITERAL1";
        SEQ SEQ911 = new SEQ();
        SEQ911.text = "^";
        SEQ911.TYPE = "LITERAL1";
        SEQ SEQ912 = new SEQ();
        SEQ912.text = "_";
        SEQ912.TYPE = "LITERAL1";
        SEQ SEQ913 = new SEQ();
        SEQ913.text = "~";
        SEQ913.TYPE = "LITERAL1";
        SEQ_REGEXP SEQ_REGEXP55 = new SEQ_REGEXP();
        SEQ_REGEXP55.text = "(\\d+?\\.\\d*pt|\\d*\\.\\d+?pt|\\d*pt)";
        SEQ_REGEXP55.HASH_CHARS = "0123456789.";
        SEQ_REGEXP55.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP56 = new SEQ_REGEXP();
        SEQ_REGEXP56.text = "(\\d+?\\.\\d*pc|\\d*\\.\\d+?pc|\\d*pc)";
        SEQ_REGEXP56.HASH_CHARS = "0123456789.";
        SEQ_REGEXP56.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP57 = new SEQ_REGEXP();
        SEQ_REGEXP57.text = "(\\d+?\\.\\d*in|\\d*\\.\\d+?in|\\d*in)";
        SEQ_REGEXP57.HASH_CHARS = "0123456789.";
        SEQ_REGEXP57.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP58 = new SEQ_REGEXP();
        SEQ_REGEXP58.text = "(\\d+?\\.\\d*bp|\\d*\\.\\d+?bp|\\d*bp)";
        SEQ_REGEXP58.HASH_CHARS = "0123456789.";
        SEQ_REGEXP58.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP59 = new SEQ_REGEXP();
        SEQ_REGEXP59.text = "(\\d+?\\.\\d*cm|\\d*\\.\\d+?cm|\\d*cm)";
        SEQ_REGEXP59.HASH_CHARS = "0123456789.";
        SEQ_REGEXP59.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP60 = new SEQ_REGEXP();
        SEQ_REGEXP60.text = "(\\d+?\\.\\d*mm|\\d*\\.\\d+?mm|\\d*mm)";
        SEQ_REGEXP60.HASH_CHARS = "0123456789.";
        SEQ_REGEXP60.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP61 = new SEQ_REGEXP();
        SEQ_REGEXP61.text = "(\\d+?\\.\\d*dd|\\d*\\.\\d+?dd|\\d*dd)";
        SEQ_REGEXP61.HASH_CHARS = "0123456789.";
        SEQ_REGEXP61.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP62 = new SEQ_REGEXP();
        SEQ_REGEXP62.text = "(\\d+?\\.\\d*cc|\\d*\\.\\d+?cc|\\d*cc)";
        SEQ_REGEXP62.HASH_CHARS = "0123456789.";
        SEQ_REGEXP62.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP63 = new SEQ_REGEXP();
        SEQ_REGEXP63.text = "(\\d+?\\.\\d*sp|\\d*\\.\\d+?sp|\\d*sp)";
        SEQ_REGEXP63.HASH_CHARS = "0123456789.";
        SEQ_REGEXP63.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP64 = new SEQ_REGEXP();
        SEQ_REGEXP64.text = "(\\d+?\\.\\d*ex|\\d*\\.\\d+?ex|\\d*ex)";
        SEQ_REGEXP64.HASH_CHARS = "0123456789.";
        SEQ_REGEXP64.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP65 = new SEQ_REGEXP();
        SEQ_REGEXP65.text = "(\\d+?\\.\\d*em|\\d*\\.\\d+?em|\\d*em)";
        SEQ_REGEXP65.HASH_CHARS = "0123456789.";
        SEQ_REGEXP65.TYPE = "LITERAL2";
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, SEQ_REGEXP4, SEQ_REGEXP5, SEQ_REGEXP6, SEQ_REGEXP7, SEQ_REGEXP8, SEQ_REGEXP9, SEQ_REGEXP10, SEQ_REGEXP11, SEQ_REGEXP12, SEQ_REGEXP13, SEQ_REGEXP14, SEQ_REGEXP15, SEQ_REGEXP16, SEQ_REGEXP17, SEQ_REGEXP18, SEQ_REGEXP19, SEQ_REGEXP20, SEQ_REGEXP21, SEQ_REGEXP22, SEQ_REGEXP23, SEQ_REGEXP24, SEQ_REGEXP25, SEQ_REGEXP26, SEQ_REGEXP27, SEQ_REGEXP28, SEQ_REGEXP29, SEQ_REGEXP30, SEQ_REGEXP31, SEQ_REGEXP32, SEQ_REGEXP33, SEQ_REGEXP34, SEQ_REGEXP35, SEQ_REGEXP36, SEQ_REGEXP37, SEQ_REGEXP38, SEQ_REGEXP39, SEQ_REGEXP40, SEQ_REGEXP41, SEQ_REGEXP42, SEQ_REGEXP43, SEQ_REGEXP44, SEQ_REGEXP45, SEQ_REGEXP46, SEQ_REGEXP47, SEQ_REGEXP48, SEQ_REGEXP49, SEQ_REGEXP50, SEQ_REGEXP51, SEQ_REGEXP52, SEQ_REGEXP53, SEQ_REGEXP54, SEQ_REGEXP55, SEQ_REGEXP56, SEQ_REGEXP57, SEQ_REGEXP58, SEQ_REGEXP59, SEQ_REGEXP60, SEQ_REGEXP61, SEQ_REGEXP62, SEQ_REGEXP63, SEQ_REGEXP64, SEQ_REGEXP65, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, SEQ30, SEQ31, SEQ32, SEQ33, SEQ34, SEQ35, SEQ36, SEQ37, SEQ38, SEQ39, SEQ40, SEQ41, SEQ42, SEQ43, SEQ44, SEQ45, SEQ46, SEQ47, SEQ48, SEQ49, SEQ50, SEQ51, SEQ52, SEQ53, SEQ54, SEQ55, SEQ56, SEQ57, SEQ58, SEQ59, SEQ60, SEQ61, SEQ62, SEQ63, SEQ64, SEQ65, SEQ66, SEQ67, SEQ68, SEQ69, SEQ70, SEQ71, SEQ72, SEQ73, SEQ74, SEQ75, SEQ76, SEQ77, SEQ78, SEQ79, SEQ80, SEQ81, SEQ82, SEQ83, SEQ84, SEQ85, SEQ86, SEQ87, SEQ88, SEQ89, SEQ90, SEQ91, SEQ92, SEQ93, SEQ94, SEQ95, SEQ96, SEQ97, SEQ98, SEQ99, SEQ100, SEQ101, SEQ102, SEQ103, SEQ104, SEQ105, SEQ106, SEQ107, SEQ108, SEQ109, SEQ110, SEQ111, SEQ112, SEQ113, SEQ114, SEQ115, SEQ116, SEQ117, SEQ118, SEQ119, SEQ120, SEQ121, SEQ122, SEQ123, SEQ124, SEQ125, SEQ126, SEQ127, SEQ128, SEQ129, SEQ130, SEQ131, SEQ132, SEQ133, SEQ134, SEQ135, SEQ136, SEQ137, SEQ138, SEQ139, SEQ140, SEQ141, SEQ142, SEQ143, SEQ144, SEQ145, SEQ146, SEQ147, SEQ148, SEQ149, SEQ150, SEQ151, SEQ152, SEQ153, SEQ154, SEQ155, SEQ156, SEQ157, SEQ158, SEQ159, SEQ160, SEQ161, SEQ162, SEQ163, SEQ164, SEQ165, SEQ166, SEQ167, SEQ168, SEQ169, SEQ170, SEQ171, SEQ172, SEQ173, SEQ174, SEQ175, SEQ176, SEQ177, SEQ178, SEQ179, SEQ180, SEQ181, SEQ182, SEQ183, SEQ184, SEQ185, SEQ186, SEQ187, SEQ188, SEQ189, SEQ190, SEQ191, SEQ192, SEQ193, SEQ194, SEQ195, SEQ196, SEQ197, SEQ198, SEQ199, SEQ200, SEQ201, SEQ202, SEQ203, SEQ204, SEQ205, SEQ206, SEQ207, SEQ208, SEQ209, SEQ210, SEQ211, SEQ212, SEQ213, SEQ214, SEQ215, SEQ216, SEQ217, SEQ218, SEQ219, SEQ220, SEQ221, SEQ222, SEQ223, SEQ224, SEQ225, SEQ226, SEQ227, SEQ228, SEQ229, SEQ230, SEQ231, SEQ232, SEQ233, SEQ234, SEQ235, SEQ236, SEQ237, SEQ238, SEQ239, SEQ240, SEQ241, SEQ242, SEQ243, SEQ244, SEQ245, SEQ246, SEQ247, SEQ248, SEQ249, SEQ250, SEQ251, SEQ252, SEQ253, SEQ254, SEQ255, SEQ256, SEQ257, SEQ258, SEQ259, SEQ260, SEQ261, SEQ262, SEQ263, SEQ264, SEQ265, SEQ266, SEQ267, SEQ268, SEQ269, SEQ270, SEQ271, SEQ272, SEQ273, SEQ274, SEQ275, SEQ276, SEQ277, SEQ278, SEQ279, SEQ280, SEQ281, SEQ282, SEQ283, SEQ284, SEQ285, SEQ286, SEQ287, SEQ288, SEQ289, SEQ290, SEQ291, SEQ292, SEQ293, SEQ294, SEQ295, SEQ296, SEQ297, SEQ298, SEQ299, SEQ300, SEQ301, SEQ302, SEQ303, SEQ304, SEQ305, SEQ306, SEQ307, SEQ308, SEQ309, SEQ310, SEQ311, SEQ312, SEQ313, SEQ314, SEQ315, SEQ316, SEQ317, SEQ318, SEQ319, SEQ320, SEQ321, SEQ322, SEQ323, SEQ324, SEQ325, SEQ326, SEQ327, SEQ328, SEQ329, SEQ330, SEQ331, SEQ332, SEQ333, SEQ334, SEQ335, SEQ336, SEQ337, SEQ338, SEQ339, SEQ340, SEQ341, SEQ342, SEQ343, SEQ344, SEQ345, SEQ346, SEQ347, SEQ348, SEQ349, SEQ350, SEQ351, SEQ352, SEQ353, SEQ354, SEQ355, SEQ356, SEQ357, SEQ358, SEQ359, SEQ360, SEQ361, SEQ362, SEQ363, SEQ364, SEQ365, SEQ366, SEQ367, SEQ368, SEQ369, SEQ370, SEQ371, SEQ372, SEQ373, SEQ374, SEQ375, SEQ376, SEQ377, SEQ378, SEQ379, SEQ380, SEQ381, SEQ382, SEQ383, SEQ384, SEQ385, SEQ386, SEQ387, SEQ388, SEQ389, SEQ390, SEQ391, SEQ392, SEQ393, SEQ394, SEQ395, SEQ396, SEQ397, SEQ398, SEQ399, SEQ400, SEQ401, SEQ402, SEQ403, SEQ404, SEQ405, SEQ406, SEQ407, SEQ408, SEQ409, SEQ410, SEQ411, SEQ412, SEQ413, SEQ414, SEQ415, SEQ416, SEQ417, SEQ418, SEQ419, SEQ420, SEQ421, SEQ422, SEQ423, SEQ424, SEQ425, SEQ426, SEQ427, SEQ428, SEQ429, SEQ430, SEQ431, SEQ432, SEQ433, SEQ434, SEQ435, SEQ436, SEQ437, SEQ438, SEQ439, SEQ440, SEQ441, SEQ442, SEQ443, SEQ444, SEQ445, SEQ446, SEQ447, SEQ448, SEQ449, SEQ450, SEQ451, SEQ452, SEQ453, SEQ454, SEQ455, SEQ456, SEQ457, SEQ458, SEQ459, SEQ460, SEQ461, SEQ462, SEQ463, SEQ464, SEQ465, SEQ466, SEQ467, SEQ468, SEQ469, SEQ470, SEQ471, SEQ472, SEQ473, SEQ474, SEQ475, SEQ476, SEQ477, SEQ478, SEQ479, SEQ480, SEQ481, SEQ482, SEQ483, SEQ484, SEQ485, SEQ486, SEQ487, SEQ488, SEQ489, SEQ490, SEQ491, SEQ492, SEQ493, SEQ494, SEQ495, SEQ496, SEQ497, SEQ498, SEQ499, SEQ500, SEQ501, SEQ502, SEQ503, SEQ504, SEQ505, SEQ506, SEQ507, SEQ508, SEQ509, SEQ510, SEQ511, SEQ512, SEQ513, SEQ514, SEQ515, SEQ516, SEQ517, SEQ518, SEQ519, SEQ520, SEQ521, SEQ522, SEQ523, SEQ524, SEQ525, SEQ526, SEQ527, SEQ528, SEQ529, SEQ530, SEQ531, SEQ532, SEQ533, SEQ534, SEQ535, SEQ536, SEQ537, SEQ538, SEQ539, SEQ540, SEQ541, SEQ542, SEQ543, SEQ544, SEQ545, SEQ546, SEQ547, SEQ548, SEQ549, SEQ550, SEQ551, SEQ552, SEQ553, SEQ554, SEQ555, SEQ556, SEQ557, SEQ558, SEQ559, SEQ560, SEQ561, SEQ562, SEQ563, SEQ564, SEQ565, SEQ566, SEQ567, SEQ568, SEQ569, SEQ570, SEQ571, SEQ572, SEQ573, SEQ574, SEQ575, SEQ576, SEQ577, SEQ578, SEQ579, SEQ580, SEQ581, SEQ582, SEQ583, SEQ584, SEQ585, SEQ586, SEQ587, SEQ588, SEQ589, SEQ590, SEQ591, SEQ592, SEQ593, SEQ594, SEQ595, SEQ596, SEQ597, SEQ598, SEQ599, SEQ600, SEQ601, SEQ602, SEQ603, SEQ604, SEQ605, SEQ606, SEQ607, SEQ608, SEQ609, SEQ610, SEQ611, SEQ612, SEQ613, SEQ614, SEQ615, SEQ616, SEQ617, SEQ618, SEQ619, SEQ620, SEQ621, SEQ622, SEQ623, SEQ624, SEQ625, SEQ626, SEQ627, SEQ628, SEQ629, SEQ630, SEQ631, SEQ632, SEQ633, SEQ634, SEQ635, SEQ636, SEQ637, SEQ638, SEQ639, SEQ640, SEQ641, SEQ642, SEQ643, SEQ644, SEQ645, SEQ646, SEQ647, SEQ648, SEQ649, SEQ650, SEQ651, SEQ652, SEQ653, SEQ654, SEQ655, SEQ656, SEQ657, SEQ658, SEQ659, SEQ660, SEQ661, SEQ662, SEQ663, SEQ664, SEQ665, SEQ666, SEQ667, SEQ668, SEQ669, SEQ670, SEQ671, SEQ672, SEQ673, SEQ674, SEQ675, SEQ676, SEQ677, SEQ678, SEQ679, SEQ680, SEQ681, SEQ682, SEQ683, SEQ684, SEQ685, SEQ686, SEQ687, SEQ688, SEQ689, SEQ690, SEQ691, SEQ692, SEQ693, SEQ694, SEQ695, SEQ696, SEQ697, SEQ698, SEQ699, SEQ700, SEQ701, SEQ702, SEQ703, SEQ704, SEQ705, SEQ706, SEQ707, SEQ708, SEQ709, SEQ710, SEQ711, SEQ712, SEQ713, SEQ714, SEQ715, SEQ716, SEQ717, SEQ718, SEQ719, SEQ720, SEQ721, SEQ722, SEQ723, SEQ724, SEQ725, SEQ726, SEQ727, SEQ728, SEQ729, SEQ730, SEQ731, SEQ732, SEQ733, SEQ734, SEQ735, SEQ736, SEQ737, SEQ738, SEQ739, SEQ740, SEQ741, SEQ742, SEQ743, SEQ744, SEQ745, SEQ746, SEQ747, SEQ748, SEQ749, SEQ750, SEQ751, SEQ752, SEQ753, SEQ754, SEQ755, SEQ756, SEQ757, SEQ758, SEQ759, SEQ760, SEQ761, SEQ762, SEQ763, SEQ764, SEQ765, SEQ766, SEQ767, SEQ768, SEQ769, SEQ770, SEQ771, SEQ772, SEQ773, SEQ774, SEQ775, SEQ776, SEQ777, SEQ778, SEQ779, SEQ780, SEQ781, SEQ782, SEQ783, SEQ784, SEQ785, SEQ786, SEQ787, SEQ788, SEQ789, SEQ790, SEQ791, SEQ792, SEQ793, SEQ794, SEQ795, SEQ796, SEQ797, SEQ798, SEQ799, SEQ800, SEQ801, SEQ802, SEQ803, SEQ804, SEQ805, SEQ806, SEQ807, SEQ808, SEQ809, SEQ810, SEQ811, SEQ812, SEQ813, SEQ814, SEQ815, SEQ816, SEQ817, SEQ818, SEQ819, SEQ820, SEQ821, SEQ822, SEQ823, SEQ824, SEQ825, SEQ826, SEQ827, SEQ828, SEQ829, SEQ830, SEQ831, SEQ832, SEQ833, SEQ834, SEQ835, SEQ836, SEQ837, SEQ838, SEQ839, SEQ840, SEQ841, SEQ842, SEQ843, SEQ844, SEQ845, SEQ846, SEQ847, SEQ848, SEQ849, SEQ850, SEQ851, SEQ852, SEQ853, SEQ854, SEQ855, SEQ856, SEQ857, SEQ858, SEQ859, SEQ860, SEQ861, SEQ862, SEQ863, SEQ864, SEQ865, SEQ866, SEQ867, SEQ868, SEQ869, SEQ870, SEQ871, SEQ872, SEQ873, SEQ874, SEQ875, SEQ876, SEQ877, SEQ878, SEQ879, SEQ880, SEQ881, SEQ882, SEQ883, SEQ884, SEQ885, SEQ886, SEQ887, SEQ888, SEQ889, SEQ890, SEQ891, SEQ892, SEQ893, SEQ894, SEQ895, SEQ896, SEQ897, SEQ898, SEQ899, SEQ900, SEQ901, SEQ902, SEQ903, SEQ904, SEQ905, SEQ906, SEQ907, SEQ908, SEQ909, SEQ910, SEQ911, SEQ912, SEQ913, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "MATH";
        RULES1.DEFAULT = "MARKUP";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "%";
        EOL_SPAN1.TYPE = "COMMENT1";
        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "\\\\[a-zA-Z@]{25}[a-zA-Z@]*";
        SEQ_REGEXP1.HASH_CHARS = "\\";
        SEQ_REGEXP1.TYPE = "LABEL";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "\\interfootnotelinepenalty";
        SEQ1.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP2 = new SEQ_REGEXP();
        SEQ_REGEXP2.text = "\\\\[a-zA-Z@]{24}";
        SEQ_REGEXP2.HASH_CHARS = "\\";
        SEQ_REGEXP2.TYPE = "LABEL";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "\\interdisplaylinepenalty";
        SEQ2.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP3 = new SEQ_REGEXP();
        SEQ_REGEXP3.text = "\\\\[a-zA-Z@]{23}";
        SEQ_REGEXP3.HASH_CHARS = "\\";
        SEQ_REGEXP3.TYPE = "LABEL";
        SEQ_REGEXP SEQ_REGEXP4 = new SEQ_REGEXP();
        SEQ_REGEXP4.text = "\\\\[a-zA-Z@]{22}";
        SEQ_REGEXP4.HASH_CHARS = "\\";
        SEQ_REGEXP4.TYPE = "LABEL";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "\\belowdisplayshortskip";
        SEQ3.TYPE = "KEYWORD4";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "\\abovedisplayshortskip";
        SEQ4.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP5 = new SEQ_REGEXP();
        SEQ_REGEXP5.text = "\\\\[a-zA-Z@]{21}";
        SEQ_REGEXP5.HASH_CHARS = "\\";
        SEQ_REGEXP5.TYPE = "LABEL";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "\\doublehyphendemerits";
        SEQ5.TYPE = "KEYWORD4";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "\\abovedisplayshortskip";
        SEQ6.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP6 = new SEQ_REGEXP();
        SEQ_REGEXP6.text = "\\\\[a-zA-Z@]{20}";
        SEQ_REGEXP6.HASH_CHARS = "\\";
        SEQ_REGEXP6.TYPE = "LABEL";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "\\normallineskiplimit";
        SEQ7.TYPE = "KEYWORD1";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "\\finalhyphendemerits";
        SEQ8.TYPE = "KEYWORD4";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "\\displaywidowpenalty";
        SEQ9.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP7 = new SEQ_REGEXP();
        SEQ_REGEXP7.text = "\\\\[a-zA-Z@]{19}";
        SEQ_REGEXP7.HASH_CHARS = "\\";
        SEQ_REGEXP7.TYPE = "LABEL";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "\\postdisplaypenalty";
        SEQ10.TYPE = "KEYWORD4";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "\\nulldelimiterspace";
        SEQ11.TYPE = "KEYWORD4";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "\\normalbaselineskip";
        SEQ12.TYPE = "KEYWORD1";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "\\Longleftrightarrow";
        SEQ13.TYPE = "KEYWORD1";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "\\longleftrightarrow";
        SEQ14.TYPE = "KEYWORD1";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "\\delimitershortfall";
        SEQ15.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP8 = new SEQ_REGEXP();
        SEQ_REGEXP8.text = "\\\\[a-zA-Z@]{18}";
        SEQ_REGEXP8.HASH_CHARS = "\\";
        SEQ_REGEXP8.TYPE = "LABEL";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "\\tracingparagraphs";
        SEQ16.TYPE = "KEYWORD4";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "\\scriptscriptstyle";
        SEQ17.TYPE = "KEYWORD1";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "\\rightleftharpoons";
        SEQ18.TYPE = "KEYWORD1";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "\\predisplaypenalty";
        SEQ19.TYPE = "KEYWORD1";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "\\errorcontextlines";
        SEQ20.TYPE = "KEYWORD4";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "\\defaulthyphenchar";
        SEQ21.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP9 = new SEQ_REGEXP();
        SEQ_REGEXP9.text = "\\\\[a-zA-Z@]{17}";
        SEQ_REGEXP9.HASH_CHARS = "\\";
        SEQ_REGEXP9.TYPE = "LABEL";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "\\tracinglostchars";
        SEQ22.TYPE = "KEYWORD4";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "\\scriptscriptfont";
        SEQ23.TYPE = "KEYWORD1";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "\\rightharpoondown";
        SEQ24.TYPE = "KEYWORD1";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "\\predisplaypenaty";
        SEQ25.TYPE = "KEYWORD4";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = "\\pagefilllstretch";
        SEQ26.TYPE = "KEYWORD1";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "\\offinterlineskip";
        SEQ27.TYPE = "KEYWORD1";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "\\nonfrenchspacing";
        SEQ28.TYPE = "KEYWORD1";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = "\\interlinepenalty";
        SEQ29.TYPE = "KEYWORD4";
        SEQ SEQ30 = new SEQ();
        SEQ30.text = "\\emergencystretch";
        SEQ30.TYPE = "KEYWORD4";
        SEQ SEQ31 = new SEQ();
        SEQ31.text = "\\belowdisplayskip";
        SEQ31.TYPE = "KEYWORD4";
        SEQ SEQ32 = new SEQ();
        SEQ32.text = "\\allocationnumber";
        SEQ32.TYPE = "KEYWORD1";
        SEQ SEQ33 = new SEQ();
        SEQ33.text = "\\abovedisplayskip";
        SEQ33.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP10 = new SEQ_REGEXP();
        SEQ_REGEXP10.text = "\\\\[a-zA-Z@]{16}";
        SEQ_REGEXP10.HASH_CHARS = "\\";
        SEQ_REGEXP10.TYPE = "LABEL";
        SEQ SEQ34 = new SEQ();
        SEQ34.text = "\\tracingrestores";
        SEQ34.TYPE = "KEYWORD4";
        SEQ SEQ35 = new SEQ();
        SEQ35.text = "\\tracingcommands";
        SEQ35.TYPE = "KEYWORD4";
        SEQ SEQ36 = new SEQ();
        SEQ36.text = "\\smallskipamount";
        SEQ36.TYPE = "KEYWORD1";
        SEQ SEQ37 = new SEQ();
        SEQ37.text = "\\pagefillstretch";
        SEQ37.TYPE = "KEYWORD1";
        SEQ SEQ38 = new SEQ();
        SEQ38.text = "\\normalbaselines";
        SEQ38.TYPE = "KEYWORD1";
        SEQ SEQ39 = new SEQ();
        SEQ39.text = "\\nointerlineskip";
        SEQ39.TYPE = "KEYWORD1";
        SEQ SEQ40 = new SEQ();
        SEQ40.text = "\\leftharpoondown";
        SEQ40.TYPE = "KEYWORD1";
        SEQ SEQ41 = new SEQ();
        SEQ41.text = "\\insertpenalties";
        SEQ41.TYPE = "KEYWORD1";
        SEQ SEQ42 = new SEQ();
        SEQ42.text = "\\floatingpenalty";
        SEQ42.TYPE = "KEYWORD4";
        SEQ SEQ43 = new SEQ();
        SEQ43.text = "\\exhyphenpenalty";
        SEQ43.TYPE = "KEYWORD4";
        SEQ SEQ44 = new SEQ();
        SEQ44.text = "\\delimiterfactor";
        SEQ44.TYPE = "KEYWORD4";
        SEQ SEQ45 = new SEQ();
        SEQ45.text = "\\defaultskewchar";
        SEQ45.TYPE = "KEYWORD4";
        SEQ SEQ46 = new SEQ();
        SEQ46.text = "\\bigtriangledown";
        SEQ46.TYPE = "KEYWORD1";
        SEQ SEQ47 = new SEQ();
        SEQ47.text = "\\afterassignment";
        SEQ47.TYPE = "KEYWORD1";
        SEQ SEQ48 = new SEQ();
        SEQ48.text = "\\abovewithdelims";
        SEQ48.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP11 = new SEQ_REGEXP();
        SEQ_REGEXP11.text = "\\\\[a-zA-Z@]{15}";
        SEQ_REGEXP11.HASH_CHARS = "\\";
        SEQ_REGEXP11.TYPE = "LABEL";
        SEQ SEQ49 = new SEQ();
        SEQ49.text = "\\splitfirstmark";
        SEQ49.TYPE = "KEYWORD1";
        SEQ SEQ50 = new SEQ();
        SEQ50.text = "\\showboxbreadth";
        SEQ50.TYPE = "KEYWORD4";
        SEQ SEQ51 = new SEQ();
        SEQ51.text = "\\righthyphenmin";
        SEQ51.TYPE = "KEYWORD4";
        SEQ SEQ52 = new SEQ();
        SEQ52.text = "\\rightharpoonup";
        SEQ52.TYPE = "KEYWORD1";
        SEQ SEQ53 = new SEQ();
        SEQ53.text = "\\rightarrowfill";
        SEQ53.TYPE = "KEYWORD1";
        SEQ SEQ54 = new SEQ();
        SEQ54.text = "\\removelastskip";
        SEQ54.TYPE = "KEYWORD1";
        SEQ SEQ55 = new SEQ();
        SEQ55.text = "\\predisplaysize";
        SEQ55.TYPE = "KEYWORD4";
        SEQ SEQ56 = new SEQ();
        SEQ56.text = "\\pagefilstretch";
        SEQ56.TYPE = "KEYWORD1";
        SEQ SEQ57 = new SEQ();
        SEQ57.text = "\\overwithdelims";
        SEQ57.TYPE = "KEYWORD1";
        SEQ SEQ58 = new SEQ();
        SEQ58.text = "\\overrightarrow";
        SEQ58.TYPE = "KEYWORD1";
        SEQ SEQ59 = new SEQ();
        SEQ59.text = "\\normallineskip";
        SEQ59.TYPE = "KEYWORD1";
        SEQ SEQ60 = new SEQ();
        SEQ60.text = "\\longrightarrow";
        SEQ60.TYPE = "KEYWORD1";
        SEQ SEQ61 = new SEQ();
        SEQ61.text = "\\Longrightarrow";
        SEQ61.TYPE = "KEYWORD1";
        SEQ SEQ62 = new SEQ();
        SEQ62.text = "\\Leftrightarrow";
        SEQ62.TYPE = "KEYWORD1";
        SEQ SEQ63 = new SEQ();
        SEQ63.text = "\\leftrightarrow";
        SEQ63.TYPE = "KEYWORD1";
        SEQ SEQ64 = new SEQ();
        SEQ64.text = "\\hookrightarrow";
        SEQ64.TYPE = "KEYWORD1";
        SEQ SEQ65 = new SEQ();
        SEQ65.text = "\\holdinginserts";
        SEQ65.TYPE = "KEYWORD4";
        SEQ SEQ66 = new SEQ();
        SEQ66.text = "\\atopwithdelims";
        SEQ66.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP12 = new SEQ_REGEXP();
        SEQ_REGEXP12.text = "\\\\[a-zA-Z@]{14}";
        SEQ_REGEXP12.HASH_CHARS = "\\";
        SEQ_REGEXP12.TYPE = "LABEL";
        SEQ SEQ67 = new SEQ();
        SEQ67.text = "\\ttraggedright";
        SEQ67.TYPE = "KEYWORD1";
        SEQ SEQ68 = new SEQ();
        SEQ68.text = "\\triangleright";
        SEQ68.TYPE = "KEYWORD1";
        SEQ SEQ69 = new SEQ();
        SEQ69.text = "\\tracingoutput";
        SEQ69.TYPE = "KEYWORD4";
        SEQ SEQ70 = new SEQ();
        SEQ70.text = "\\tracingonline";
        SEQ70.TYPE = "KEYWORD4";
        SEQ SEQ71 = new SEQ();
        SEQ71.text = "\\tracingmacros";
        SEQ71.TYPE = "KEYWORD4";
        SEQ SEQ72 = new SEQ();
        SEQ72.text = "\\splitmaxdepth";
        SEQ72.TYPE = "KEYWORD4";
        SEQ SEQ73 = new SEQ();
        SEQ73.text = "\\overleftarrow";
        SEQ73.TYPE = "KEYWORD1";
        SEQ SEQ74 = new SEQ();
        SEQ74.text = "\\outputpenalty";
        SEQ74.TYPE = "KEYWORD4";
        SEQ SEQ75 = new SEQ();
        SEQ75.text = "\\nopagenumbers";
        SEQ75.TYPE = "KEYWORD1";
        SEQ SEQ76 = new SEQ();
        SEQ76.text = "\\medskipamount";
        SEQ76.TYPE = "KEYWORD1";
        SEQ SEQ77 = new SEQ();
        SEQ77.text = "\\maxdeadcycles";
        SEQ77.TYPE = "KEYWORD4";
        SEQ SEQ78 = new SEQ();
        SEQ78.text = "\\magnification";
        SEQ78.TYPE = "KEYWORD1";
        SEQ SEQ79 = new SEQ();
        SEQ79.text = "\\Longleftarrow";
        SEQ79.TYPE = "KEYWORD1";
        SEQ SEQ80 = new SEQ();
        SEQ80.text = "\\longleftarrow";
        SEQ80.TYPE = "KEYWORD1";
        SEQ SEQ81 = new SEQ();
        SEQ81.text = "\\lineskiplimit";
        SEQ81.TYPE = "KEYWORD4";
        SEQ SEQ82 = new SEQ();
        SEQ82.text = "\\lefthyphenmin";
        SEQ82.TYPE = "KEYWORD4";
        SEQ SEQ83 = new SEQ();
        SEQ83.text = "\\leftharpoonup";
        SEQ83.TYPE = "KEYWORD1";
        SEQ SEQ84 = new SEQ();
        SEQ84.text = "\\leftarrowfill";
        SEQ84.TYPE = "KEYWORD1";
        SEQ SEQ85 = new SEQ();
        SEQ85.text = "\\hyphenpenalty";
        SEQ85.TYPE = "KEYWORD4";
        SEQ SEQ86 = new SEQ();
        SEQ86.text = "\\hookleftarrow";
        SEQ86.TYPE = "KEYWORD1";
        SEQ SEQ87 = new SEQ();
        SEQ87.text = "\\frenchspacing";
        SEQ87.TYPE = "KEYWORD1";
        SEQ SEQ88 = new SEQ();
        SEQ88.text = "\\errorstopmode";
        SEQ88.TYPE = "KEYWORD1";
        SEQ SEQ89 = new SEQ();
        SEQ89.text = "\\downbracefill";
        SEQ89.TYPE = "KEYWORD1";
        SEQ SEQ90 = new SEQ();
        SEQ90.text = "\\displaylimits";
        SEQ90.TYPE = "KEYWORD1";
        SEQ SEQ91 = new SEQ();
        SEQ91.text = "\\displayindent";
        SEQ91.TYPE = "KEYWORD4";
        SEQ SEQ92 = new SEQ();
        SEQ92.text = "\\discretionary";
        SEQ92.TYPE = "KEYWORD1";
        SEQ SEQ93 = new SEQ();
        SEQ93.text = "\\brokenpenalty";
        SEQ93.TYPE = "KEYWORD4";
        SEQ SEQ94 = new SEQ();
        SEQ94.text = "\\bigtriangleup";
        SEQ94.TYPE = "KEYWORD1";
        SEQ SEQ95 = new SEQ();
        SEQ95.text = "\\bigskipamount";
        SEQ95.TYPE = "KEYWORD1";
        SEQ SEQ96 = new SEQ();
        SEQ96.text = "\\advancepageno";
        SEQ96.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP13 = new SEQ_REGEXP();
        SEQ_REGEXP13.text = "\\\\[a-zA-Z@]{13}";
        SEQ_REGEXP13.HASH_CHARS = "\\";
        SEQ_REGEXP13.TYPE = "LABEL";
        SEQ SEQ97 = new SEQ();
        SEQ97.text = "\\widowpenalty";
        SEQ97.TYPE = "KEYWORD4";
        SEQ SEQ98 = new SEQ();
        SEQ98.text = "\\triangleleft";
        SEQ98.TYPE = "KEYWORD1";
        SEQ SEQ99 = new SEQ();
        SEQ99.text = "\\tracingstats";
        SEQ99.TYPE = "KEYWORD4";
        SEQ SEQ100 = new SEQ();
        SEQ100.text = "\\tracingpages";
        SEQ100.TYPE = "KEYWORD4";
        SEQ SEQ101 = new SEQ();
        SEQ101.text = "\\splittopskip";
        SEQ101.TYPE = "KEYWORD4";
        SEQ SEQ102 = new SEQ();
        SEQ102.text = "\\splitbotmark";
        SEQ102.TYPE = "KEYWORD1";
        SEQ SEQ103 = new SEQ();
        SEQ103.text = "\\showboxdepth";
        SEQ103.TYPE = "KEYWORD4";
        SEQ SEQ104 = new SEQ();
        SEQ104.text = "\\romannumeral";
        SEQ104.TYPE = "KEYWORD1";
        SEQ SEQ105 = new SEQ();
        SEQ105.text = "\\raggedbottom";
        SEQ105.TYPE = "KEYWORD1";
        SEQ SEQ106 = new SEQ();
        SEQ106.text = "\\pretolerance";
        SEQ106.TYPE = "KEYWORD4";
        SEQ SEQ107 = new SEQ();
        SEQ107.text = "\\pagecontents";
        SEQ107.TYPE = "KEYWORD1";
        SEQ SEQ108 = new SEQ();
        SEQ108.text = "\\overfullrule";
        SEQ108.TYPE = "KEYWORD4";
        SEQ SEQ109 = new SEQ();
        SEQ109.text = "\\normalbottom";
        SEQ109.TYPE = "KEYWORD1";
        SEQ SEQ110 = new SEQ();
        SEQ110.text = "\\negthinspace";
        SEQ110.TYPE = "KEYWORD1";
        SEQ SEQ111 = new SEQ();
        SEQ111.text = "\\mathsurround";
        SEQ111.TYPE = "KEYWORD4";
        SEQ SEQ112 = new SEQ();
        SEQ112.text = "\\makeheadline";
        SEQ112.TYPE = "KEYWORD1";
        SEQ SEQ113 = new SEQ();
        SEQ113.text = "\\makefootline";
        SEQ113.TYPE = "KEYWORD1";
        SEQ SEQ114 = new SEQ();
        SEQ114.text = "\\ignorespaces";
        SEQ114.TYPE = "KEYWORD1";
        SEQ SEQ115 = new SEQ();
        SEQ115.text = "\\footnoterule";
        SEQ115.TYPE = "KEYWORD1";
        SEQ SEQ116 = new SEQ();
        SEQ116.text = "\\everydisplay";
        SEQ116.TYPE = "KEYWORD4";
        SEQ SEQ117 = new SEQ();
        SEQ117.text = "\\dosupereject";
        SEQ117.TYPE = "KEYWORD1";
        SEQ SEQ118 = new SEQ();
        SEQ118.text = "\\displaywidth";
        SEQ118.TYPE = "KEYWORD4";
        SEQ SEQ119 = new SEQ();
        SEQ119.text = "\\displaystyle";
        SEQ119.TYPE = "KEYWORD1";
        SEQ SEQ120 = new SEQ();
        SEQ120.text = "\\displaylines";
        SEQ120.TYPE = "KEYWORD1";
        SEQ SEQ121 = new SEQ();
        SEQ121.text = "\\bordermatrix";
        SEQ121.TYPE = "KEYWORD1";
        SEQ SEQ122 = new SEQ();
        SEQ122.text = "\\binoppenalty";
        SEQ122.TYPE = "KEYWORD4";
        SEQ SEQ123 = new SEQ();
        SEQ123.text = "\\beginsection";
        SEQ123.TYPE = "KEYWORD1";
        SEQ SEQ124 = new SEQ();
        SEQ124.text = "\\baselineskip";
        SEQ124.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP14 = new SEQ_REGEXP();
        SEQ_REGEXP14.text = "\\\\[a-zA-Z@]{12}";
        SEQ_REGEXP14.HASH_CHARS = "\\";
        SEQ_REGEXP14.TYPE = "LABEL";
        SEQ SEQ125 = new SEQ();
        SEQ125.text = "\\Updownarrow";
        SEQ125.TYPE = "KEYWORD1";
        SEQ SEQ126 = new SEQ();
        SEQ126.text = "\\updownarrow";
        SEQ126.TYPE = "KEYWORD1";
        SEQ SEQ127 = new SEQ();
        SEQ127.text = "\\upbracefill";
        SEQ127.TYPE = "KEYWORD1";
        SEQ SEQ128 = new SEQ();
        SEQ128.text = "\\thickmuskip";
        SEQ128.TYPE = "KEYWORD4";
        SEQ SEQ129 = new SEQ();
        SEQ129.text = "\\spacefactor";
        SEQ129.TYPE = "KEYWORD1";
        SEQ SEQ130 = new SEQ();
        SEQ130.text = "\\showhyphens";
        SEQ130.TYPE = "KEYWORD1";
        SEQ SEQ131 = new SEQ();
        SEQ131.text = "\\scriptstyle";
        SEQ131.TYPE = "KEYWORD1";
        SEQ SEQ132 = new SEQ();
        SEQ132.text = "\\scriptspace";
        SEQ132.TYPE = "KEYWORD4";
        SEQ SEQ133 = new SEQ();
        SEQ133.text = "\\raggedright";
        SEQ133.TYPE = "KEYWORD1";
        SEQ SEQ134 = new SEQ();
        SEQ134.text = "\\plainoutput";
        SEQ134.TYPE = "KEYWORD1";
        SEQ SEQ135 = new SEQ();
        SEQ135.text = "\\parfillskip";
        SEQ135.TYPE = "KEYWORD4";
        SEQ SEQ136 = new SEQ();
        SEQ136.text = "\\pagestretch";
        SEQ136.TYPE = "KEYWORD1";
        SEQ SEQ137 = new SEQ();
        SEQ137.text = "\\nonstopmode";
        SEQ137.TYPE = "KEYWORD1";
        SEQ SEQ138 = new SEQ();
        SEQ138.text = "\\newlinechar";
        SEQ138.TYPE = "COMMENT2";
        SEQ SEQ139 = new SEQ();
        SEQ139.text = "\\mathpalette";
        SEQ139.TYPE = "KEYWORD1";
        SEQ SEQ140 = new SEQ();
        SEQ140.text = "\\mathchardef";
        SEQ140.TYPE = "FUNCTION";
        SEQ SEQ141 = new SEQ();
        SEQ141.text = "\\magstephalf";
        SEQ141.TYPE = "KEYWORD1";
        SEQ SEQ142 = new SEQ();
        SEQ142.text = "\\linepenalty";
        SEQ142.TYPE = "KEYWORD4";
        SEQ SEQ143 = new SEQ();
        SEQ143.text = "\\lastpenalty";
        SEQ143.TYPE = "KEYWORD1";
        SEQ SEQ144 = new SEQ();
        SEQ144.text = "\\hyphenation";
        SEQ144.TYPE = "KEYWORD1";
        SEQ SEQ145 = new SEQ();
        SEQ145.text = "\\expandafter";
        SEQ145.TYPE = "KEYWORD1";
        SEQ SEQ146 = new SEQ();
        SEQ146.text = "\\endlinechar";
        SEQ146.TYPE = "KEYWORD4";
        SEQ SEQ147 = new SEQ();
        SEQ147.text = "\\diamondsuit";
        SEQ147.TYPE = "KEYWORD1";
        SEQ SEQ148 = new SEQ();
        SEQ148.text = "\\clubpenalty";
        SEQ148.TYPE = "KEYWORD4";
        SEQ SEQ149 = new SEQ();
        SEQ149.text = "\\boxmaxdepth";
        SEQ149.TYPE = "KEYWORD4";
        SEQ SEQ150 = new SEQ();
        SEQ150.text = "\\adjdemerits";
        SEQ150.TYPE = "KEYWORD4";
        SEQ_REGEXP SEQ_REGEXP15 = new SEQ_REGEXP();
        SEQ_REGEXP15.text = "\\\\[a-zA-Z@]{11}";
        SEQ_REGEXP15.HASH_CHARS = "\\";
        SEQ_REGEXP15.TYPE = "LABEL";
        SEQ SEQ151 = new SEQ();
        SEQ151.text = "\\xspaceskip";
        SEQ151.TYPE = "KEYWORD4";
        SEQ SEQ152 = new SEQ();
        SEQ152.text = "\\varepsilon";
        SEQ152.TYPE = "KEYWORD1";
        SEQ SEQ153 = new SEQ();
        SEQ153.text = "\\underbrace";
        SEQ153.TYPE = "KEYWORD1";
        SEQ SEQ154 = new SEQ();
        SEQ154.text = "\\tracingall";
        SEQ154.TYPE = "KEYWORD1";
        SEQ SEQ155 = new SEQ();
        SEQ155.text = "\\thinmuskip";
        SEQ155.TYPE = "KEYWORD4";
        SEQ SEQ156 = new SEQ();
        SEQ156.text = "\\textindent";
        SEQ156.TYPE = "KEYWORD1";
        SEQ SEQ157 = new SEQ();
        SEQ157.text = "\\supereject";
        SEQ157.TYPE = "KEYWORD1";
        SEQ SEQ158 = new SEQ();
        SEQ158.text = "\\sqsupseteq";
        SEQ158.TYPE = "KEYWORD1";
        SEQ SEQ159 = new SEQ();
        SEQ159.text = "\\smallbreak";
        SEQ159.TYPE = "KEYWORD1";
        SEQ SEQ160 = new SEQ();
        SEQ160.text = "\\scrollmode";
        SEQ160.TYPE = "KEYWORD1";
        SEQ SEQ161 = new SEQ();
        SEQ161.text = "\\scriptfont";
        SEQ161.TYPE = "KEYWORD1";
        SEQ SEQ162 = new SEQ();
        SEQ162.text = "\\rmoustache";
        SEQ162.TYPE = "KEYWORD1";
        SEQ SEQ163 = new SEQ();
        SEQ163.text = "\\Rightarrow";
        SEQ163.TYPE = "KEYWORD1";
        SEQ SEQ164 = new SEQ();
        SEQ164.text = "\\rightarrow";
        SEQ164.TYPE = "KEYWORD1";
        SEQ SEQ165 = new SEQ();
        SEQ165.text = "\\relpenalty";
        SEQ165.TYPE = "KEYWORD4";
        SEQ SEQ166 = new SEQ();
        SEQ166.text = "\\pageshrink";
        SEQ166.TYPE = "KEYWORD1";
        SEQ SEQ167 = new SEQ();
        SEQ167.text = "\\pageinsert";
        SEQ167.TYPE = "KEYWORD1";
        SEQ SEQ168 = new SEQ();
        SEQ168.text = "\\obeyspaces";
        SEQ168.TYPE = "KEYWORD1";
        SEQ SEQ169 = new SEQ();
        SEQ169.text = "\\mathhexbox";
        SEQ169.TYPE = "KEYWORD1";
        SEQ SEQ170 = new SEQ();
        SEQ170.text = "\\mathchoice";
        SEQ170.TYPE = "KEYWORD1";
        SEQ SEQ171 = new SEQ();
        SEQ171.text = "\\mathaccent";
        SEQ171.TYPE = "KEYWORD1";
        SEQ SEQ172 = new SEQ();
        SEQ172.text = "\\mapstochar";
        SEQ172.TYPE = "KEYWORD1";
        SEQ SEQ173 = new SEQ();
        SEQ173.text = "\\longmapsto";
        SEQ173.TYPE = "KEYWORD1";
        SEQ SEQ174 = new SEQ();
        SEQ174.text = "\\lmoustache";
        SEQ174.TYPE = "KEYWORD1";
        SEQ SEQ175 = new SEQ();
        SEQ175.text = "\\leqalignno";
        SEQ175.TYPE = "KEYWORD1";
        SEQ SEQ176 = new SEQ();
        SEQ176.text = "\\leavevmode";
        SEQ176.TYPE = "KEYWORD1";
        SEQ SEQ177 = new SEQ();
        SEQ177.text = "\\hyphenchar";
        SEQ177.TYPE = "KEYWORD1";
        SEQ SEQ178 = new SEQ();
        SEQ178.text = "\\hangindent";
        SEQ178.TYPE = "KEYWORD4";
        SEQ SEQ179 = new SEQ();
        SEQ179.text = "\\globaldefs";
        SEQ179.TYPE = "KEYWORD4";
        SEQ SEQ180 = new SEQ();
        SEQ180.text = "\\fmtversion";
        SEQ180.TYPE = "KEYWORD1";
        SEQ SEQ181 = new SEQ();
        SEQ181.text = "\\escapechar";
        SEQ181.TYPE = "KEYWORD4";
        SEQ SEQ182 = new SEQ();
        SEQ182.text = "\\errmessage";
        SEQ182.TYPE = "KEYWORD1";
        SEQ SEQ183 = new SEQ();
        SEQ183.text = "\\dospecials";
        SEQ183.TYPE = "KEYWORD1";
        SEQ SEQ184 = new SEQ();
        SEQ184.text = "\\deadcycles";
        SEQ184.TYPE = "KEYWORD1";
        SEQ SEQ185 = new SEQ();
        SEQ185.text = "\\centerline";
        SEQ185.TYPE = "KEYWORD1";
        SEQ SEQ186 = new SEQ();
        SEQ186.text = "\\begingroup";
        SEQ186.TYPE = "KEYWORD1";
        SEQ SEQ187 = new SEQ();
        SEQ187.text = "\\allowbreak";
        SEQ187.TYPE = "KEYWORD1";
        SEQ SEQ188 = new SEQ();
        SEQ188.text = "\\aftergroup";
        SEQ188.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP16 = new SEQ_REGEXP();
        SEQ_REGEXP16.text = "\\\\[a-zA-Z@]{10}";
        SEQ_REGEXP16.HASH_CHARS = "\\";
        SEQ_REGEXP16.TYPE = "LABEL";
        SEQ SEQ189 = new SEQ();
        SEQ189.text = "\\widetilde";
        SEQ189.TYPE = "KEYWORD1";
        SEQ SEQ190 = new SEQ();
        SEQ190.text = "\\vfootnote";
        SEQ190.TYPE = "KEYWORD1";
        SEQ SEQ191 = new SEQ();
        SEQ191.text = "\\uppercase";
        SEQ191.TYPE = "KEYWORD1";
        SEQ SEQ192 = new SEQ();
        SEQ192.text = "\\unpenalty";
        SEQ192.TYPE = "KEYWORD1";
        SEQ SEQ193 = new SEQ();
        SEQ193.text = "\\underline";
        SEQ193.TYPE = "KEYWORD1";
        SEQ SEQ194 = new SEQ();
        SEQ194.text = "\\undefined";
        SEQ194.TYPE = "KEYWORD1";
        SEQ SEQ195 = new SEQ();
        SEQ195.text = "\\topinsert";
        SEQ195.TYPE = "KEYWORD1";
        SEQ SEQ196 = new SEQ();
        SEQ196.text = "\\tolerance";
        SEQ196.TYPE = "KEYWORD4";
        SEQ SEQ197 = new SEQ();
        SEQ197.text = "\\thinspace";
        SEQ197.TYPE = "KEYWORD1";
        SEQ SEQ198 = new SEQ();
        SEQ198.text = "\\textstyle";
        SEQ198.TYPE = "KEYWORD1";
        SEQ SEQ199 = new SEQ();
        SEQ199.text = "\\spadesuit";
        SEQ199.TYPE = "KEYWORD1";
        SEQ SEQ200 = new SEQ();
        SEQ200.text = "\\spaceskip";
        SEQ200.TYPE = "KEYWORD4";
        SEQ SEQ201 = new SEQ();
        SEQ201.text = "\\smallskip";
        SEQ201.TYPE = "KEYWORD1";
        SEQ SEQ202 = new SEQ();
        SEQ202.text = "\\showlists";
        SEQ202.TYPE = "KEYWORD1";
        SEQ SEQ203 = new SEQ();
        SEQ203.text = "\\rightskip";
        SEQ203.TYPE = "KEYWORD4";
        SEQ SEQ204 = new SEQ();
        SEQ204.text = "\\rightline";
        SEQ204.TYPE = "KEYWORD1";
        SEQ SEQ205 = new SEQ();
        SEQ205.text = "\\prevdepth";
        SEQ205.TYPE = "KEYWORD1";
        SEQ SEQ206 = new SEQ();
        SEQ206.text = "\\preloaded";
        SEQ206.TYPE = "KEYWORD1";
        SEQ SEQ207 = new SEQ();
        SEQ207.text = "\\parindent";
        SEQ207.TYPE = "KEYWORD4";
        SEQ SEQ208 = new SEQ();
        SEQ208.text = "\\pagetotal";
        SEQ208.TYPE = "KEYWORD1";
        SEQ SEQ209 = new SEQ();
        SEQ209.text = "\\pagedepth";
        SEQ209.TYPE = "KEYWORD1";
        SEQ SEQ210 = new SEQ();
        SEQ210.text = "\\overbrace";
        SEQ210.TYPE = "KEYWORD1";
        SEQ SEQ211 = new SEQ();
        SEQ211.text = "\\obeylines";
        SEQ211.TYPE = "KEYWORD1";
        SEQ SEQ212 = new SEQ();
        SEQ212.text = "\\nonscript";
        SEQ212.TYPE = "KEYWORD1";
        SEQ SEQ213 = new SEQ();
        SEQ213.text = "\\newmuskip";
        SEQ213.TYPE = "FUNCTION";
        SEQ SEQ214 = new SEQ();
        SEQ214.text = "\\newinsert";
        SEQ214.TYPE = "FUNCTION";
        SEQ SEQ215 = new SEQ();
        SEQ215.text = "\\muskipdef";
        SEQ215.TYPE = "FUNCTION";
        SEQ SEQ216 = new SEQ();
        SEQ216.text = "\\multispan";
        SEQ216.TYPE = "KEYWORD1";
        SEQ SEQ217 = new SEQ();
        SEQ217.text = "\\moveright";
        SEQ217.TYPE = "KEYWORD1";
        SEQ SEQ218 = new SEQ();
        SEQ218.text = "\\midinsert";
        SEQ218.TYPE = "KEYWORD1";
        SEQ SEQ219 = new SEQ();
        SEQ219.text = "\\medmuskip";
        SEQ219.TYPE = "KEYWORD4";
        SEQ SEQ220 = new SEQ();
        SEQ220.text = "\\mathstrut";
        SEQ220.TYPE = "KEYWORD1";
        SEQ SEQ221 = new SEQ();
        SEQ221.text = "\\mathpunct";
        SEQ221.TYPE = "KEYWORD1";
        SEQ SEQ222 = new SEQ();
        SEQ222.text = "\\mathinner";
        SEQ222.TYPE = "KEYWORD1";
        SEQ SEQ223 = new SEQ();
        SEQ223.text = "\\mathclose";
        SEQ223.TYPE = "KEYWORD1";
        SEQ SEQ224 = new SEQ();
        SEQ224.text = "\\lowercase";
        SEQ224.TYPE = "KEYWORD1";
        SEQ SEQ225 = new SEQ();
        SEQ225.text = "\\looseness";
        SEQ225.TYPE = "KEYWORD4";
        SEQ SEQ226 = new SEQ();
        SEQ226.text = "\\Leftarrow";
        SEQ226.TYPE = "KEYWORD1";
        SEQ SEQ227 = new SEQ();
        SEQ227.text = "\\leftarrow";
        SEQ227.TYPE = "KEYWORD1";
        SEQ SEQ228 = new SEQ();
        SEQ228.text = "\\immediate";
        SEQ228.TYPE = "KEYWORD1";
        SEQ SEQ229 = new SEQ();
        SEQ229.text = "\\hrulefill";
        SEQ229.TYPE = "KEYWORD1";
        SEQ SEQ230 = new SEQ();
        SEQ230.text = "\\hidewidth";
        SEQ230.TYPE = "KEYWORD1";
        SEQ SEQ231 = new SEQ();
        SEQ231.text = "\\heartsuit";
        SEQ231.TYPE = "KEYWORD1";
        SEQ SEQ232 = new SEQ();
        SEQ232.text = "\\hangafter";
        SEQ232.TYPE = "KEYWORD4";
        SEQ SEQ233 = new SEQ();
        SEQ233.text = "\\goodbreak";
        SEQ233.TYPE = "KEYWORD1";
        SEQ SEQ234 = new SEQ();
        SEQ234.text = "\\futurelet";
        SEQ234.TYPE = "COMMENT3";
        SEQ SEQ235 = new SEQ();
        SEQ235.text = "\\footstrut";
        SEQ235.TYPE = "KEYWORD1";
        SEQ SEQ236 = new SEQ();
        SEQ236.text = "\\fontdimen";
        SEQ236.TYPE = "KEYWORD1";
        SEQ SEQ237 = new SEQ();
        SEQ237.text = "\\firstmark";
        SEQ237.TYPE = "KEYWORD1";
        SEQ SEQ238 = new SEQ();
        SEQ238.text = "\\everyvbox";
        SEQ238.TYPE = "KEYWORD4";
        SEQ SEQ239 = new SEQ();
        SEQ239.text = "\\everymath";
        SEQ239.TYPE = "KEYWORD4";
        SEQ SEQ240 = new SEQ();
        SEQ240.text = "\\everyhbox";
        SEQ240.TYPE = "KEYWORD4";
        SEQ SEQ241 = new SEQ();
        SEQ241.text = "\\eqalignno";
        SEQ241.TYPE = "KEYWORD1";
        SEQ SEQ242 = new SEQ();
        SEQ242.text = "\\endinsert";
        SEQ242.TYPE = "KEYWORD1";
        SEQ SEQ243 = new SEQ();
        SEQ243.text = "\\endcsname";
        SEQ243.TYPE = "FUNCTION";
        SEQ SEQ244 = new SEQ();
        SEQ244.text = "\\Downarrow";
        SEQ244.TYPE = "KEYWORD1";
        SEQ SEQ245 = new SEQ();
        SEQ245.text = "\\downarrow";
        SEQ245.TYPE = "KEYWORD1";
        SEQ SEQ246 = new SEQ();
        SEQ246.text = "\\delimiter";
        SEQ246.TYPE = "KEYWORD1";
        SEQ SEQ247 = new SEQ();
        SEQ247.text = "\\copyright";
        SEQ247.TYPE = "KEYWORD1";
        SEQ SEQ248 = new SEQ();
        SEQ248.text = "\\cleartabs";
        SEQ248.TYPE = "KEYWORD1";
        SEQ SEQ249 = new SEQ();
        SEQ249.text = "\\centering";
        SEQ249.TYPE = "KEYWORD1";
        SEQ SEQ250 = new SEQ();
        SEQ250.text = "\\bracevert";
        SEQ250.TYPE = "KEYWORD1";
        SEQ SEQ251 = new SEQ();
        SEQ251.text = "\\bigotimes";
        SEQ251.TYPE = "KEYWORD1";
        SEQ SEQ252 = new SEQ();
        SEQ252.text = "\\batchmode";
        SEQ252.TYPE = "KEYWORD1";
        SEQ SEQ253 = new SEQ();
        SEQ253.text = "\\backslash";
        SEQ253.TYPE = "KEYWORD2";
        SEQ SEQ254 = new SEQ();
        SEQ254.text = "\\Arrowvert";
        SEQ254.TYPE = "KEYWORD1";
        SEQ SEQ255 = new SEQ();
        SEQ255.text = "\\arrowvert";
        SEQ255.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP17 = new SEQ_REGEXP();
        SEQ_REGEXP17.text = "\\\\muskip([0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
        SEQ_REGEXP17.HASH_CHARS = "\\";
        SEQ_REGEXP17.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP18 = new SEQ_REGEXP();
        SEQ_REGEXP18.text = "\\\\[a-zA-Z@]{9}";
        SEQ_REGEXP18.HASH_CHARS = "\\";
        SEQ_REGEXP18.TYPE = "LABEL";
        SEQ SEQ256 = new SEQ();
        SEQ256.text = "\\xleaders";
        SEQ256.TYPE = "KEYWORD1";
        SEQ SEQ257 = new SEQ();
        SEQ257.text = "\\vphantom";
        SEQ257.TYPE = "KEYWORD1";
        SEQ SEQ258 = new SEQ();
        SEQ258.text = "\\vbadness";
        SEQ258.TYPE = "KEYWORD4";
        SEQ SEQ259 = new SEQ();
        SEQ259.text = "\\vartheta";
        SEQ259.TYPE = "KEYWORD1";
        SEQ SEQ260 = new SEQ();
        SEQ260.text = "\\varsigma";
        SEQ260.TYPE = "KEYWORD1";
        SEQ SEQ261 = new SEQ();
        SEQ261.text = "\\underbar";
        SEQ261.TYPE = "KEYWORD1";
        SEQ SEQ262 = new SEQ();
        SEQ262.text = "\\triangle";
        SEQ262.TYPE = "KEYWORD1";
        SEQ SEQ263 = new SEQ();
        SEQ263.text = "\\textfont";
        SEQ263.TYPE = "KEYWORD1";
        SEQ SEQ264 = new SEQ();
        SEQ264.text = "\\tabsdone";
        SEQ264.TYPE = "KEYWORD1";
        SEQ SEQ265 = new SEQ();
        SEQ265.text = "\\tabalign";
        SEQ265.TYPE = "KEYWORD1";
        SEQ SEQ266 = new SEQ();
        SEQ266.text = "\\supseteq";
        SEQ266.TYPE = "KEYWORD1";
        SEQ SEQ267 = new SEQ();
        SEQ267.text = "\\subseteq";
        SEQ267.TYPE = "KEYWORD1";
        SEQ SEQ268 = new SEQ();
        SEQ268.text = "\\strutbox";
        SEQ268.TYPE = "KEYWORD1";
        SEQ SEQ269 = new SEQ();
        SEQ269.text = "\\smallint";
        SEQ269.TYPE = "KEYWORD1";
        SEQ SEQ270 = new SEQ();
        SEQ270.text = "\\skewchar";
        SEQ270.TYPE = "KEYWORD1";
        SEQ SEQ271 = new SEQ();
        SEQ271.text = "\\setminus";
        SEQ271.TYPE = "KEYWORD1";
        SEQ SEQ272 = new SEQ();
        SEQ272.text = "\\proclaim";
        SEQ272.TYPE = "KEYWORD1";
        SEQ SEQ273 = new SEQ();
        SEQ273.text = "\\prevgraf";
        SEQ273.TYPE = "KEYWORD1";
        SEQ SEQ274 = new SEQ();
        SEQ274.text = "\\patterns";
        SEQ274.TYPE = "KEYWORD1";
        SEQ SEQ275 = new SEQ();
        SEQ275.text = "\\parshape";
        SEQ275.TYPE = "KEYWORD1";
        SEQ SEQ276 = new SEQ();
        SEQ276.text = "\\parallel";
        SEQ276.TYPE = "KEYWORD1";
        SEQ SEQ277 = new SEQ();
        SEQ277.text = "\\pagegoal";
        SEQ277.TYPE = "KEYWORD1";
        SEQ SEQ278 = new SEQ();
        SEQ278.text = "\\pagebody";
        SEQ278.TYPE = "KEYWORD1";
        SEQ SEQ279 = new SEQ();
        SEQ279.text = "\\overline";
        SEQ279.TYPE = "KEYWORD1";
        SEQ SEQ280 = new SEQ();
        SEQ280.text = "\\oldstyle";
        SEQ280.TYPE = "KEYWORD1";
        SEQ SEQ281 = new SEQ();
        SEQ281.text = "\\nolimits";
        SEQ281.TYPE = "KEYWORD1";
        SEQ SEQ282 = new SEQ();
        SEQ282.text = "\\noindent";
        SEQ282.TYPE = "KEYWORD1";
        SEQ SEQ283 = new SEQ();
        SEQ283.text = "\\noexpand";
        SEQ283.TYPE = "KEYWORD1";
        SEQ SEQ284 = new SEQ();
        SEQ284.text = "\\newwrite";
        SEQ284.TYPE = "COMMENT2";
        SEQ SEQ285 = new SEQ();
        SEQ285.text = "\\newdimen";
        SEQ285.TYPE = "COMMENT2";
        SEQ SEQ286 = new SEQ();
        SEQ286.text = "\\newcount";
        SEQ286.TYPE = "COMMENT2";
        SEQ SEQ287 = new SEQ();
        SEQ287.text = "\\narrower";
        SEQ287.TYPE = "KEYWORD1";
        SEQ SEQ288 = new SEQ();
        SEQ288.text = "\\moveleft";
        SEQ288.TYPE = "KEYWORD1";
        SEQ SEQ289 = new SEQ();
        SEQ289.text = "\\medbreak";
        SEQ289.TYPE = "KEYWORD1";
        SEQ SEQ290 = new SEQ();
        SEQ290.text = "\\maxdimen";
        SEQ290.TYPE = "KEYWORD1";
        SEQ SEQ291 = new SEQ();
        SEQ291.text = "\\maxdepth";
        SEQ291.TYPE = "KEYWORD4";
        SEQ SEQ292 = new SEQ();
        SEQ292.text = "\\mathopen";
        SEQ292.TYPE = "KEYWORD1";
        SEQ SEQ293 = new SEQ();
        SEQ293.text = "\\mathcode";
        SEQ293.TYPE = "KEYWORD1";
        SEQ SEQ294 = new SEQ();
        SEQ294.text = "\\mathchar";
        SEQ294.TYPE = "KEYWORD1";
        SEQ SEQ295 = new SEQ();
        SEQ295.text = "\\lineskip";
        SEQ295.TYPE = "KEYWORD1";
        SEQ SEQ296 = new SEQ();
        SEQ296.text = "\\leftskip";
        SEQ296.TYPE = "KEYWORD4";
        SEQ SEQ297 = new SEQ();
        SEQ297.text = "\\leftline";
        SEQ297.TYPE = "KEYWORD4";
        SEQ SEQ298 = new SEQ();
        SEQ298.text = "\\lastskip";
        SEQ298.TYPE = "KEYWORD1";
        SEQ SEQ299 = new SEQ();
        SEQ299.text = "\\lastkern";
        SEQ299.TYPE = "KEYWORD1";
        SEQ SEQ300 = new SEQ();
        SEQ300.text = "\\language";
        SEQ300.TYPE = "KEYWORD4";
        SEQ SEQ301 = new SEQ();
        SEQ301.text = "\\itemitem";
        SEQ301.TYPE = "KEYWORD1";
        SEQ SEQ302 = new SEQ();
        SEQ302.text = "\\hphantom";
        SEQ302.TYPE = "KEYWORD1";
        SEQ SEQ303 = new SEQ();
        SEQ303.text = "\\hideskip";
        SEQ303.TYPE = "KEYWORD1";
        SEQ SEQ304 = new SEQ();
        SEQ304.text = "\\headline";
        SEQ304.TYPE = "KEYWORD1";
        SEQ SEQ305 = new SEQ();
        SEQ305.text = "\\hbadness";
        SEQ305.TYPE = "KEYWORD4";
        SEQ SEQ306 = new SEQ();
        SEQ306.text = "\\footnote";
        SEQ306.TYPE = "KEYWORD1";
        SEQ SEQ307 = new SEQ();
        SEQ307.text = "\\footline";
        SEQ307.TYPE = "KEYWORD1";
        SEQ SEQ308 = new SEQ();
        SEQ308.text = "\\multiply";
        SEQ308.TYPE = "KEYWORD1";
        SEQ SEQ309 = new SEQ();
        SEQ309.text = "\\fontname";
        SEQ309.TYPE = "KEYWORD1";
        SEQ SEQ310 = new SEQ();
        SEQ310.text = "\\filbreak";
        SEQ310.TYPE = "KEYWORD1";
        SEQ SEQ311 = new SEQ();
        SEQ311.text = "\\everypar";
        SEQ311.TYPE = "KEYWORD4";
        SEQ SEQ312 = new SEQ();
        SEQ312.text = "\\everyjob";
        SEQ312.TYPE = "KEYWORD4";
        SEQ SEQ313 = new SEQ();
        SEQ313.text = "\\endinput";
        SEQ313.TYPE = "KEYWORD1";
        SEQ SEQ314 = new SEQ();
        SEQ314.text = "\\endgroup";
        SEQ314.TYPE = "KEYWORD1";
        SEQ SEQ315 = new SEQ();
        SEQ315.text = "\\emptyset";
        SEQ315.TYPE = "KEYWORD1";
        SEQ SEQ316 = new SEQ();
        SEQ316.text = "\\dimendef";
        SEQ316.TYPE = "FUNCTION";
        SEQ SEQ317 = new SEQ();
        SEQ317.text = "\\countdef";
        SEQ317.TYPE = "FUNCTION";
        SEQ SEQ318 = new SEQ();
        SEQ318.text = "\\clubsuit";
        SEQ318.TYPE = "KEYWORD1";
        SEQ SEQ319 = new SEQ();
        SEQ319.text = "\\closeout";
        SEQ319.TYPE = "KEYWORD1";
        SEQ SEQ320 = new SEQ();
        SEQ320.text = "\\cleaders";
        SEQ320.TYPE = "KEYWORD1";
        SEQ SEQ321 = new SEQ();
        SEQ321.text = "\\buildrel";
        SEQ321.TYPE = "KEYWORD1";
        SEQ SEQ322 = new SEQ();
        SEQ322.text = "\\bigwedge";
        SEQ322.TYPE = "KEYWORD1";
        SEQ SEQ323 = new SEQ();
        SEQ323.text = "\\biguplus";
        SEQ323.TYPE = "KEYWORD1";
        SEQ SEQ324 = new SEQ();
        SEQ324.text = "\\bigsqcup";
        SEQ324.TYPE = "KEYWORD1";
        SEQ SEQ325 = new SEQ();
        SEQ325.text = "\\bigoplus";
        SEQ325.TYPE = "KEYWORD1";
        SEQ SEQ326 = new SEQ();
        SEQ326.text = "\\bigbreak";
        SEQ326.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP19 = new SEQ_REGEXP();
        SEQ_REGEXP19.text = "\\\\muskip[0-9][0-9]";
        SEQ_REGEXP19.HASH_CHARS = "\\";
        SEQ_REGEXP19.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP20 = new SEQ_REGEXP();
        SEQ_REGEXP20.text = "\\\\dimen([0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
        SEQ_REGEXP20.HASH_CHARS = "\\";
        SEQ_REGEXP20.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP21 = new SEQ_REGEXP();
        SEQ_REGEXP21.text = "\\\\count([0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
        SEQ_REGEXP21.HASH_CHARS = "\\";
        SEQ_REGEXP21.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP22 = new SEQ_REGEXP();
        SEQ_REGEXP22.text = "\\\\[a-zA-Z@]{8}";
        SEQ_REGEXP22.HASH_CHARS = "\\";
        SEQ_REGEXP22.TYPE = "LABEL";
        SEQ SEQ327 = new SEQ();
        SEQ327.text = "\\widehat";
        SEQ327.TYPE = "KEYWORD1";
        SEQ SEQ328 = new SEQ();
        SEQ328.text = "\\voffset";
        SEQ328.TYPE = "KEYWORD4";
        SEQ SEQ329 = new SEQ();
        SEQ329.text = "\\vfilneg";
        SEQ329.TYPE = "KEYWORD1";
        SEQ SEQ330 = new SEQ();
        SEQ330.text = "\\vcenter";
        SEQ330.TYPE = "KEYWORD1";
        SEQ SEQ331 = new SEQ();
        SEQ331.text = "\\vadjust";
        SEQ331.TYPE = "KEYWORD1";
        SEQ SEQ332 = new SEQ();
        SEQ332.text = "\\Upsilon";
        SEQ332.TYPE = "KEYWORD1";
        SEQ SEQ333 = new SEQ();
        SEQ333.text = "\\upsilon";
        SEQ333.TYPE = "KEYWORD1";
        SEQ SEQ334 = new SEQ();
        SEQ334.text = "\\Uparrow";
        SEQ334.TYPE = "KEYWORD1";
        SEQ SEQ335 = new SEQ();
        SEQ335.text = "\\uparrow";
        SEQ335.TYPE = "KEYWORD1";
        SEQ SEQ336 = new SEQ();
        SEQ336.text = "\\unvcopy";
        SEQ336.TYPE = "KEYWORD1";
        SEQ SEQ337 = new SEQ();
        SEQ337.text = "\\unhcopy";
        SEQ337.TYPE = "KEYWORD1";
        SEQ SEQ338 = new SEQ();
        SEQ338.text = "\\topskip";
        SEQ338.TYPE = "KEYWORD4";
        SEQ SEQ339 = new SEQ();
        SEQ339.text = "\\topmark";
        SEQ339.TYPE = "KEYWORD1";
        SEQ SEQ340 = new SEQ();
        SEQ340.text = "\\toksdef";
        SEQ340.TYPE = "FUNCTION";
        SEQ SEQ341 = new SEQ();
        SEQ341.text = "\\tabsyet";
        SEQ341.TYPE = "KEYWORD1";
        SEQ SEQ342 = new SEQ();
        SEQ342.text = "\\tabskip";
        SEQ342.TYPE = "KEYWORD4";
        SEQ SEQ343 = new SEQ();
        SEQ343.text = "\\swarrow";
        SEQ343.TYPE = "KEYWORD1";
        SEQ SEQ344 = new SEQ();
        SEQ344.text = "\\special";
        SEQ344.TYPE = "KEYWORD1";
        SEQ SEQ345 = new SEQ();
        SEQ345.text = "\\skipdef";
        SEQ345.TYPE = "FUNCTION";
        SEQ SEQ346 = new SEQ();
        SEQ346.text = "\\showthe";
        SEQ346.TYPE = "KEYWORD1";
        SEQ SEQ347 = new SEQ();
        SEQ347.text = "\\showbox";
        SEQ347.TYPE = "KEYWORD1";
        SEQ SEQ348 = new SEQ();
        SEQ348.text = "\\shipout";
        SEQ348.TYPE = "KEYWORD1";
        SEQ SEQ349 = new SEQ();
        SEQ349.text = "\\sevensy";
        SEQ349.TYPE = "KEYWORD1";
        SEQ SEQ350 = new SEQ();
        SEQ350.text = "\\sevenrm";
        SEQ350.TYPE = "KEYWORD1";
        SEQ SEQ351 = new SEQ();
        SEQ351.text = "\\sevenbf";
        SEQ351.TYPE = "KEYWORD1";
        SEQ SEQ352 = new SEQ();
        SEQ352.text = "\\settabs";
        SEQ352.TYPE = "KEYWORD1";
        SEQ SEQ353 = new SEQ();
        SEQ353.text = "\\searrow";
        SEQ353.TYPE = "KEYWORD1";
        SEQ SEQ354 = new SEQ();
        SEQ354.text = "\\rootbox";
        SEQ354.TYPE = "KEYWORD1";
        SEQ SEQ355 = new SEQ();
        SEQ355.text = "\\radical";
        SEQ355.TYPE = "KEYWORD1";
        SEQ SEQ356 = new SEQ();
        SEQ356.text = "\\pmatrix";
        SEQ356.TYPE = "KEYWORD1";
        SEQ SEQ357 = new SEQ();
        SEQ357.text = "\\phantom";
        SEQ357.TYPE = "KEYWORD1";
        SEQ SEQ358 = new SEQ();
        SEQ358.text = "\\penalty";
        SEQ358.TYPE = "KEYWORD1";
        SEQ SEQ359 = new SEQ();
        SEQ359.text = "\\pausing";
        SEQ359.TYPE = "KEYWORD4";
        SEQ SEQ360 = new SEQ();
        SEQ360.text = "\\partial";
        SEQ360.TYPE = "KEYWORD1";
        SEQ SEQ361 = new SEQ();
        SEQ361.text = "\\parskip";
        SEQ361.TYPE = "KEYWORD4";
        SEQ SEQ362 = new SEQ();
        SEQ362.text = "\\openout";
        SEQ362.TYPE = "KEYWORD1";
        SEQ SEQ363 = new SEQ();
        SEQ363.text = "\\ooalign";
        SEQ363.TYPE = "KEYWORD1";
        SEQ SEQ364 = new SEQ();
        SEQ364.text = "\\nwarrow";
        SEQ364.TYPE = "KEYWORD1";
        SEQ SEQ365 = new SEQ();
        SEQ365.text = "\\nobreak";
        SEQ365.TYPE = "KEYWORD1";
        SEQ SEQ366 = new SEQ();
        SEQ366.text = "\\noalign";
        SEQ366.TYPE = "KEYWORD1";
        SEQ SEQ367 = new SEQ();
        SEQ367.text = "\\newtoks";
        SEQ367.TYPE = "COMMENT2";
        SEQ SEQ368 = new SEQ();
        SEQ368.text = "\\newskip";
        SEQ368.TYPE = "COMMENT2";
        SEQ SEQ369 = new SEQ();
        SEQ369.text = "\\newread";
        SEQ369.TYPE = "COMMENT2";
        SEQ SEQ370 = new SEQ();
        SEQ370.text = "\\newhelp";
        SEQ370.TYPE = "COMMENT2";
        SEQ SEQ371 = new SEQ();
        SEQ371.text = "\\nearrow";
        SEQ371.TYPE = "KEYWORD1";
        SEQ SEQ372 = new SEQ();
        SEQ372.text = "\\natural";
        SEQ372.TYPE = "KEYWORD1";
        SEQ SEQ373 = new SEQ();
        SEQ373.text = "\\mscount";
        SEQ373.TYPE = "KEYWORD1";
        SEQ SEQ374 = new SEQ();
        SEQ374.text = "\\message";
        SEQ374.TYPE = "KEYWORD1";
        SEQ SEQ375 = new SEQ();
        SEQ375.text = "\\medskip";
        SEQ375.TYPE = "KEYWORD1";
        SEQ SEQ376 = new SEQ();
        SEQ376.text = "\\meaning";
        SEQ376.TYPE = "KEYWORD1";
        SEQ SEQ377 = new SEQ();
        SEQ377.text = "\\mathrel";
        SEQ377.TYPE = "KEYWORD1";
        SEQ SEQ378 = new SEQ();
        SEQ378.text = "\\mathord";
        SEQ378.TYPE = "KEYWORD1";
        SEQ SEQ379 = new SEQ();
        SEQ379.text = "\\mathbin";
        SEQ379.TYPE = "KEYWORD1";
        SEQ SEQ380 = new SEQ();
        SEQ380.text = "\\magstep";
        SEQ380.TYPE = "KEYWORD1";
        SEQ SEQ381 = new SEQ();
        SEQ381.text = "\\leaders";
        SEQ381.TYPE = "KEYWORD1";
        SEQ SEQ382 = new SEQ();
        SEQ382.text = "\\lastbox";
        SEQ382.TYPE = "KEYWORD1";
        SEQ SEQ383 = new SEQ();
        SEQ383.text = "\\joinrel";
        SEQ383.TYPE = "KEYWORD1";
        SEQ SEQ384 = new SEQ();
        SEQ384.text = "\\jobname";
        SEQ384.TYPE = "KEYWORD1";
        SEQ SEQ385 = new SEQ();
        SEQ385.text = "\\iterate";
        SEQ385.TYPE = "KEYWORD1";
        SEQ SEQ386 = new SEQ();
        SEQ386.text = "\\ifvmode";
        SEQ386.TYPE = "KEYWORD3";
        SEQ SEQ387 = new SEQ();
        SEQ387.text = "\\ifmmode";
        SEQ387.TYPE = "KEYWORD3";
        SEQ SEQ388 = new SEQ();
        SEQ388.text = "\\ifinner";
        SEQ388.TYPE = "KEYWORD3";
        SEQ SEQ389 = new SEQ();
        SEQ389.text = "\\ifhmode";
        SEQ389.TYPE = "KEYWORD3";
        SEQ SEQ390 = new SEQ();
        SEQ390.text = "\\iffalse";
        SEQ390.TYPE = "KEYWORD3";
        SEQ SEQ391 = new SEQ();
        SEQ391.text = "\\hoffset";
        SEQ391.TYPE = "KEYWORD4";
        SEQ SEQ392 = new SEQ();
        SEQ392.text = "\\hfilneg";
        SEQ392.TYPE = "KEYWORD1";
        SEQ SEQ393 = new SEQ();
        SEQ393.text = "\\footins";
        SEQ393.TYPE = "KEYWORD1";
        SEQ SEQ394 = new SEQ();
        SEQ394.text = "\\fmtname";
        SEQ394.TYPE = "KEYWORD1";
        SEQ SEQ395 = new SEQ();
        SEQ395.text = "\\everycr";
        SEQ395.TYPE = "KEYWORD4";
        SEQ SEQ396 = new SEQ();
        SEQ396.text = "\\errhelp";
        SEQ396.TYPE = "KEYWORD4";
        SEQ SEQ397 = new SEQ();
        SEQ397.text = "\\eqalign";
        SEQ397.TYPE = "KEYWORD1";
        SEQ SEQ398 = new SEQ();
        SEQ398.text = "\\epsilon";
        SEQ398.TYPE = "KEYWORD1";
        SEQ SEQ399 = new SEQ();
        SEQ399.text = "\\enspace";
        SEQ399.TYPE = "KEYWORD1";
        SEQ SEQ400 = new SEQ();
        SEQ400.text = "\\endline";
        SEQ400.TYPE = "KEYWORD1";
        SEQ SEQ401 = new SEQ();
        SEQ401.text = "\\endgraf";
        SEQ401.TYPE = "KEYWORD1";
        SEQ SEQ402 = new SEQ();
        SEQ402.text = "\\dotfill";
        SEQ402.TYPE = "KEYWORD1";
        SEQ SEQ403 = new SEQ();
        SEQ403.text = "\\diamond";
        SEQ403.TYPE = "KEYWORD1";
        SEQ SEQ404 = new SEQ();
        SEQ404.text = "\\delcode";
        SEQ404.TYPE = "KEYWORD1";
        SEQ SEQ405 = new SEQ();
        SEQ405.text = "\\ddagger";
        SEQ405.TYPE = "KEYWORD1";
        SEQ SEQ406 = new SEQ();
        SEQ406.text = "\\columns";
        SEQ406.TYPE = "KEYWORD1";
        SEQ SEQ407 = new SEQ();
        SEQ407.text = "\\closein";
        SEQ407.TYPE = "KEYWORD1";
        SEQ SEQ408 = new SEQ();
        SEQ408.text = "\\chardef";
        SEQ408.TYPE = "FUNCTION";
        SEQ SEQ409 = new SEQ();
        SEQ409.text = "\\cdprime";
        SEQ409.TYPE = "KEYWORD2";
        SEQ SEQ410 = new SEQ();
        SEQ410.text = "\\catcode";
        SEQ410.TYPE = "KEYWORD1";
        SEQ SEQ411 = new SEQ();
        SEQ411.text = "\\braceru";
        SEQ411.TYPE = "KEYWORD1";
        SEQ SEQ412 = new SEQ();
        SEQ412.text = "\\bracerd";
        SEQ412.TYPE = "KEYWORD1";
        SEQ SEQ413 = new SEQ();
        SEQ413.text = "\\bracelu";
        SEQ413.TYPE = "KEYWORD1";
        SEQ SEQ414 = new SEQ();
        SEQ414.text = "\\braceld";
        SEQ414.TYPE = "KEYWORD1";
        SEQ SEQ415 = new SEQ();
        SEQ415.text = "\\botmark";
        SEQ415.TYPE = "KEYWORD1";
        SEQ SEQ416 = new SEQ();
        SEQ416.text = "\\bigskip";
        SEQ416.TYPE = "KEYWORD1";
        SEQ SEQ417 = new SEQ();
        SEQ417.text = "\\bigodot";
        SEQ417.TYPE = "KEYWORD1";
        SEQ SEQ418 = new SEQ();
        SEQ418.text = "\\bigcirc";
        SEQ418.TYPE = "KEYWORD1";
        SEQ SEQ419 = new SEQ();
        SEQ419.text = "\\advance";
        SEQ419.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP23 = new SEQ_REGEXP();
        SEQ_REGEXP23.text = "\\\\muskip[0-9]";
        SEQ_REGEXP23.HASH_CHARS = "\\";
        SEQ_REGEXP23.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP24 = new SEQ_REGEXP();
        SEQ_REGEXP24.text = "\\\\dimen[0-9][0-9]";
        SEQ_REGEXP24.HASH_CHARS = "\\";
        SEQ_REGEXP24.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP25 = new SEQ_REGEXP();
        SEQ_REGEXP25.text = "\\\\count[0-9][0-9]";
        SEQ_REGEXP25.HASH_CHARS = "\\";
        SEQ_REGEXP25.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP26 = new SEQ_REGEXP();
        SEQ_REGEXP26.text = "\\\\toks([0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
        SEQ_REGEXP26.HASH_CHARS = "\\";
        SEQ_REGEXP26.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP27 = new SEQ_REGEXP();
        SEQ_REGEXP27.text = "\\\\skip([0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
        SEQ_REGEXP27.HASH_CHARS = "\\";
        SEQ_REGEXP27.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP28 = new SEQ_REGEXP();
        SEQ_REGEXP28.text = "\\\\char([0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
        SEQ_REGEXP28.HASH_CHARS = "\\";
        SEQ_REGEXP28.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP29 = new SEQ_REGEXP();
        SEQ_REGEXP29.text = "\\\\char'[0-7][0-7]";
        SEQ_REGEXP29.HASH_CHARS = "\\";
        SEQ_REGEXP29.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP30 = new SEQ_REGEXP();
        SEQ_REGEXP30.text = "\\\\char\"[0-9A-Fa-f][0-9A-Fa-f]";
        SEQ_REGEXP30.HASH_CHARS = "\\";
        SEQ_REGEXP30.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP31 = new SEQ_REGEXP();
        SEQ_REGEXP31.text = "\\\\[a-zA-Z@]{7}";
        SEQ_REGEXP31.HASH_CHARS = "\\";
        SEQ_REGEXP31.TYPE = "LABEL";
        SEQ SEQ420 = new SEQ();
        SEQ420.text = "\\vsplit";
        SEQ420.TYPE = "KEYWORD1";
        SEQ SEQ421 = new SEQ();
        SEQ421.text = "\\varrho";
        SEQ421.TYPE = "KEYWORD1";
        SEQ SEQ422 = new SEQ();
        SEQ422.text = "\\varphi";
        SEQ422.TYPE = "KEYWORD1";
        SEQ SEQ423 = new SEQ();
        SEQ423.text = "\\valign";
        SEQ423.TYPE = "KEYWORD1";
        SEQ SEQ424 = new SEQ();
        SEQ424.text = "\\utilde";
        SEQ424.TYPE = "KEYWORD2";
        SEQ SEQ425 = new SEQ();
        SEQ425.text = "\\unvbox";
        SEQ425.TYPE = "KEYWORD1";
        SEQ SEQ426 = new SEQ();
        SEQ426.text = "\\unskip";
        SEQ426.TYPE = "KEYWORD1";
        SEQ SEQ427 = new SEQ();
        SEQ427.text = "\\unkern";
        SEQ427.TYPE = "KEYWORD1";
        SEQ SEQ428 = new SEQ();
        SEQ428.text = "\\unhbox";
        SEQ428.TYPE = "KEYWORD1";
        SEQ SEQ429 = new SEQ();
        SEQ429.text = "\\uchyph";
        SEQ429.TYPE = "KEYWORD4";
        SEQ SEQ430 = new SEQ();
        SEQ430.text = "\\uccode";
        SEQ430.TYPE = "KEYWORD1";
        SEQ SEQ431 = new SEQ();
        SEQ431.text = "\\topins";
        SEQ431.TYPE = "KEYWORD1";
        SEQ SEQ432 = new SEQ();
        SEQ432.text = "\\supset";
        SEQ432.TYPE = "KEYWORD1";
        SEQ SEQ433 = new SEQ();
        SEQ433.text = "\\succeq";
        SEQ433.TYPE = "KEYWORD1";
        SEQ SEQ434 = new SEQ();
        SEQ434.text = "\\subset";
        SEQ434.TYPE = "KEYWORD1";
        SEQ SEQ435 = new SEQ();
        SEQ435.text = "\\string";
        SEQ435.TYPE = "KEYWORD1";
        SEQ SEQ436 = new SEQ();
        SEQ436.text = "\\sfcode";
        SEQ436.TYPE = "KEYWORD1";
        SEQ SEQ437 = new SEQ();
        SEQ437.text = "\\seveni";
        SEQ437.TYPE = "KEYWORD1";
        SEQ SEQ438 = new SEQ();
        SEQ438.text = "\\setbox";
        SEQ438.TYPE = "KEYWORD1";
        SEQ SEQ439 = new SEQ();
        SEQ439.text = "\\rgroup";
        SEQ439.TYPE = "KEYWORD1";
        SEQ SEQ440 = new SEQ();
        SEQ440.text = "\\rfloor";
        SEQ440.TYPE = "KEYWORD1";
        SEQ SEQ441 = new SEQ();
        SEQ441.text = "\\repeat";
        SEQ441.TYPE = "KEYWORD1";
        SEQ SEQ442 = new SEQ();
        SEQ442.text = "\\Relbar";
        SEQ442.TYPE = "KEYWORD1";
        SEQ SEQ443 = new SEQ();
        SEQ443.text = "\\relbar";
        SEQ443.TYPE = "KEYWORD1";
        SEQ SEQ444 = new SEQ();
        SEQ444.text = "\\rbrack";
        SEQ444.TYPE = "KEYWORD1";
        SEQ SEQ445 = new SEQ();
        SEQ445.text = "\\rbrace";
        SEQ445.TYPE = "KEYWORD1";
        SEQ SEQ446 = new SEQ();
        SEQ446.text = "\\rangle";
        SEQ446.TYPE = "KEYWORD1";
        SEQ SEQ447 = new SEQ();
        SEQ447.text = "\\propto";
        SEQ447.TYPE = "KEYWORD1";
        SEQ SEQ448 = new SEQ();
        SEQ448.text = "\\preceq";
        SEQ448.TYPE = "KEYWORD1";
        SEQ SEQ449 = new SEQ();
        SEQ449.text = "\\pageno";
        SEQ449.TYPE = "KEYWORD1";
        SEQ SEQ450 = new SEQ();
        SEQ450.text = "\\output";
        SEQ450.TYPE = "KEYWORD4";
        SEQ SEQ451 = new SEQ();
        SEQ451.text = "\\otimes";
        SEQ451.TYPE = "KEYWORD1";
        SEQ SEQ452 = new SEQ();
        SEQ452.text = "\\oslash";
        SEQ452.TYPE = "KEYWORD1";
        SEQ SEQ453 = new SEQ();
        SEQ453.text = "\\openup";
        SEQ453.TYPE = "KEYWORD1";
        SEQ SEQ454 = new SEQ();
        SEQ454.text = "\\openin";
        SEQ454.TYPE = "KEYWORD1";
        SEQ SEQ455 = new SEQ();
        SEQ455.text = "\\ominus";
        SEQ455.TYPE = "KEYWORD1";
        SEQ SEQ456 = new SEQ();
        SEQ456.text = "\\ointop";
        SEQ456.TYPE = "KEYWORD1";
        SEQ SEQ457 = new SEQ();
        SEQ457.text = "\\oalign";
        SEQ457.TYPE = "KEYWORD1";
        SEQ SEQ458 = new SEQ();
        SEQ458.text = "\\number";
        SEQ458.TYPE = "KEYWORD1";
        SEQ SEQ459 = new SEQ();
        SEQ459.text = "\\newfam";
        SEQ459.TYPE = "COMMENT2";
        SEQ SEQ460 = new SEQ();
        SEQ460.text = "\\newbox";
        SEQ460.TYPE = "COMMENT2";
        SEQ SEQ461 = new SEQ();
        SEQ461.text = "\\muskip";
        SEQ461.TYPE = "COMMENT4";
        SEQ SEQ462 = new SEQ();
        SEQ462.text = "\\models";
        SEQ462.TYPE = "KEYWORD1";
        SEQ SEQ463 = new SEQ();
        SEQ463.text = "\\matrix";
        SEQ463.TYPE = "KEYWORD1";
        SEQ SEQ464 = new SEQ();
        SEQ464.text = "\\mathop";
        SEQ464.TYPE = "KEYWORD1";
        SEQ SEQ465 = new SEQ();
        SEQ465.text = "\\mapsto";
        SEQ465.TYPE = "KEYWORD1";
        SEQ SEQ466 = new SEQ();
        SEQ466.text = "\\limsup";
        SEQ466.TYPE = "KEYWORD1";
        SEQ SEQ467 = new SEQ();
        SEQ467.text = "\\limits";
        SEQ467.TYPE = "KEYWORD1";
        SEQ SEQ468 = new SEQ();
        SEQ468.text = "\\liminf";
        SEQ468.TYPE = "KEYWORD1";
        SEQ SEQ469 = new SEQ();
        SEQ469.text = "\\lgroup";
        SEQ469.TYPE = "KEYWORD1";
        SEQ SEQ470 = new SEQ();
        SEQ470.text = "\\lfhook";
        SEQ470.TYPE = "KEYWORD2";
        SEQ SEQ471 = new SEQ();
        SEQ471.text = "\\lfloor";
        SEQ471.TYPE = "KEYWORD1";
        SEQ SEQ472 = new SEQ();
        SEQ472.text = "\\lccode";
        SEQ472.TYPE = "KEYWORD1";
        SEQ SEQ473 = new SEQ();
        SEQ473.text = "\\lbrack";
        SEQ473.TYPE = "KEYWORD1";
        SEQ SEQ474 = new SEQ();
        SEQ474.text = "\\lbrace";
        SEQ474.TYPE = "KEYWORD1";
        SEQ SEQ475 = new SEQ();
        SEQ475.text = "\\langle";
        SEQ475.TYPE = "KEYWORD1";
        SEQ SEQ476 = new SEQ();
        SEQ476.text = "\\Lambda";
        SEQ476.TYPE = "KEYWORD1";
        SEQ SEQ477 = new SEQ();
        SEQ477.text = "\\lambda";
        SEQ477.TYPE = "KEYWORD1";
        SEQ SEQ478 = new SEQ();
        SEQ478.text = "\\insert";
        SEQ478.TYPE = "KEYWORD1";
        SEQ SEQ479 = new SEQ();
        SEQ479.text = "\\indent";
        SEQ479.TYPE = "KEYWORD1";
        SEQ SEQ480 = new SEQ();
        SEQ480.text = "\\ifvoid";
        SEQ480.TYPE = "KEYWORD3";
        SEQ SEQ481 = new SEQ();
        SEQ481.text = "\\ifvbox";
        SEQ481.TYPE = "KEYWORD3";
        SEQ SEQ482 = new SEQ();
        SEQ482.text = "\\iftrue";
        SEQ482.TYPE = "KEYWORD3";
        SEQ SEQ483 = new SEQ();
        SEQ483.text = "\\ifhbox";
        SEQ483.TYPE = "KEYWORD3";
        SEQ SEQ484 = new SEQ();
        SEQ484.text = "\\ifcase";
        SEQ484.TYPE = "KEYWORD3";
        SEQ SEQ485 = new SEQ();
        SEQ485.text = "\\ialign";
        SEQ485.TYPE = "KEYWORD1";
        SEQ SEQ486 = new SEQ();
        SEQ486.text = "\\halign";
        SEQ486.TYPE = "KEYWORD1";
        SEQ SEQ487 = new SEQ();
        SEQ487.text = "\\global";
        SEQ487.TYPE = "FUNCTION";
        SEQ SEQ488 = new SEQ();
        SEQ488.text = "\\forall";
        SEQ488.TYPE = "KEYWORD1";
        SEQ SEQ489 = new SEQ();
        SEQ489.text = "\\fivesy";
        SEQ489.TYPE = "KEYWORD1";
        SEQ SEQ490 = new SEQ();
        SEQ490.text = "\\fiverm";
        SEQ490.TYPE = "KEYWORD1";
        SEQ SEQ491 = new SEQ();
        SEQ491.text = "\\fivebf";
        SEQ491.TYPE = "KEYWORD1";
        SEQ SEQ492 = new SEQ();
        SEQ492.text = "\\exists";
        SEQ492.TYPE = "KEYWORD1";
        SEQ SEQ493 = new SEQ();
        SEQ493.text = "\\enskip";
        SEQ493.TYPE = "KEYWORD1";
        SEQ SEQ494 = new SEQ();
        SEQ494.text = "\\egroup";
        SEQ494.TYPE = "KEYWORD1";
        SEQ SEQ495 = new SEQ();
        SEQ495.text = "\\divide";
        SEQ495.TYPE = "KEYWORD1";
        SEQ SEQ496 = new SEQ();
        SEQ496.text = "\\dagger";
        SEQ496.TYPE = "KEYWORD1";
        SEQ SEQ497 = new SEQ();
        SEQ497.text = "\\csname";
        SEQ497.TYPE = "FUNCTION";
        SEQ SEQ498 = new SEQ();
        SEQ498.text = "\\cprime";
        SEQ498.TYPE = "KEYWORD2";
        SEQ SEQ499 = new SEQ();
        SEQ499.text = "\\coprod";
        SEQ499.TYPE = "KEYWORD1";
        SEQ SEQ500 = new SEQ();
        SEQ500.text = "\\choose";
        SEQ500.TYPE = "KEYWORD1";
        SEQ SEQ501 = new SEQ();
        SEQ501.text = "\\cfudot";
        SEQ501.TYPE = "KEYWORD2";
        SEQ SEQ502 = new SEQ();
        SEQ502.text = "\\candra";
        SEQ502.TYPE = "KEYWORD2";
        SEQ SEQ503 = new SEQ();
        SEQ503.text = "\\bullet";
        SEQ503.TYPE = "KEYWORD1";
        SEQ SEQ504 = new SEQ();
        SEQ504.text = "\\bowtie";
        SEQ504.TYPE = "KEYWORD1";
        SEQ SEQ505 = new SEQ();
        SEQ505.text = "\\bigvee";
        SEQ505.TYPE = "KEYWORD1";
        SEQ SEQ506 = new SEQ();
        SEQ506.text = "\\bigcup";
        SEQ506.TYPE = "KEYWORD1";
        SEQ SEQ507 = new SEQ();
        SEQ507.text = "\\bigcap";
        SEQ507.TYPE = "KEYWORD1";
        SEQ SEQ508 = new SEQ();
        SEQ508.text = "\\bgroup";
        SEQ508.TYPE = "KEYWORD1";
        SEQ SEQ509 = new SEQ();
        SEQ509.text = "\\arctan";
        SEQ509.TYPE = "KEYWORD1";
        SEQ SEQ510 = new SEQ();
        SEQ510.text = "\\arcsin";
        SEQ510.TYPE = "KEYWORD1";
        SEQ SEQ511 = new SEQ();
        SEQ511.text = "\\arccos";
        SEQ511.TYPE = "KEYWORD1";
        SEQ SEQ512 = new SEQ();
        SEQ512.text = "\\approx";
        SEQ512.TYPE = "KEYWORD1";
        SEQ SEQ513 = new SEQ();
        SEQ513.text = "\\acudot";
        SEQ513.TYPE = "KEYWORD2";
        SEQ SEQ514 = new SEQ();
        SEQ514.text = "\\active";
        SEQ514.TYPE = "KEYWORD1";
        SEQ SEQ515 = new SEQ();
        SEQ515.text = "\\accent";
        SEQ515.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP32 = new SEQ_REGEXP();
        SEQ_REGEXP32.text = "\\\\dimen[0-9]";
        SEQ_REGEXP32.HASH_CHARS = "\\";
        SEQ_REGEXP32.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP33 = new SEQ_REGEXP();
        SEQ_REGEXP33.text = "\\\\count[0-9]";
        SEQ_REGEXP33.HASH_CHARS = "\\";
        SEQ_REGEXP33.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP34 = new SEQ_REGEXP();
        SEQ_REGEXP34.text = "\\\\toks[0-9][0-9]";
        SEQ_REGEXP34.HASH_CHARS = "\\";
        SEQ_REGEXP34.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP35 = new SEQ_REGEXP();
        SEQ_REGEXP35.text = "\\\\skip[0-9][0-9]";
        SEQ_REGEXP35.HASH_CHARS = "\\";
        SEQ_REGEXP35.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP36 = new SEQ_REGEXP();
        SEQ_REGEXP36.text = "\\\\box([0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
        SEQ_REGEXP36.HASH_CHARS = "\\";
        SEQ_REGEXP36.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP37 = new SEQ_REGEXP();
        SEQ_REGEXP37.text = "\\\\char[0-9][0-9]";
        SEQ_REGEXP37.HASH_CHARS = "\\";
        SEQ_REGEXP37.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP38 = new SEQ_REGEXP();
        SEQ_REGEXP38.text = "\\\\char'[0-7]";
        SEQ_REGEXP38.HASH_CHARS = "\\";
        SEQ_REGEXP38.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP39 = new SEQ_REGEXP();
        SEQ_REGEXP39.text = "\\\\char\"[0-9A-Fa-f]";
        SEQ_REGEXP39.HASH_CHARS = "\\";
        SEQ_REGEXP39.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP40 = new SEQ_REGEXP();
        SEQ_REGEXP40.text = "\\\\[a-zA-Z@]{6}";
        SEQ_REGEXP40.HASH_CHARS = "\\";
        SEQ_REGEXP40.TYPE = "LABEL";
        SEQ SEQ516 = new SEQ();
        SEQ516.text = "\\write";
        SEQ516.TYPE = "KEYWORD1";
        SEQ SEQ517 = new SEQ();
        SEQ517.text = "\\wedge";
        SEQ517.TYPE = "KEYWORD1";
        SEQ SEQ518 = new SEQ();
        SEQ518.text = "\\vskip";
        SEQ518.TYPE = "KEYWORD1";
        SEQ SEQ519 = new SEQ();
        SEQ519.text = "\\vsize";
        SEQ519.TYPE = "KEYWORD4";
        SEQ SEQ520 = new SEQ();
        SEQ520.text = "\\vrule";
        SEQ520.TYPE = "KEYWORD1";
        SEQ SEQ521 = new SEQ();
        SEQ521.text = "\\vglue";
        SEQ521.TYPE = "KEYWORD1";
        SEQ SEQ522 = new SEQ();
        SEQ522.text = "\\vfuzz";
        SEQ522.TYPE = "KEYWORD4";
        SEQ SEQ523 = new SEQ();
        SEQ523.text = "\\vfill";
        SEQ523.TYPE = "KEYWORD1";
        SEQ SEQ524 = new SEQ();
        SEQ524.text = "\\vdots";
        SEQ524.TYPE = "KEYWORD1";
        SEQ SEQ525 = new SEQ();
        SEQ525.text = "\\vdash";
        SEQ525.TYPE = "KEYWORD1";
        SEQ SEQ526 = new SEQ();
        SEQ526.text = "\\varpi";
        SEQ526.TYPE = "KEYWORD1";
        SEQ SEQ527 = new SEQ();
        SEQ527.text = "\\uplus";
        SEQ527.TYPE = "KEYWORD1";
        SEQ SEQ528 = new SEQ();
        SEQ528.text = "\\ttfam";
        SEQ528.TYPE = "KEYWORD1";
        SEQ SEQ529 = new SEQ();
        SEQ529.text = "\\times";
        SEQ529.TYPE = "KEYWORD1";
        SEQ SEQ530 = new SEQ();
        SEQ530.text = "\\tilde";
        SEQ530.TYPE = "KEYWORD1";
        SEQ SEQ531 = new SEQ();
        SEQ531.text = "\\Theta";
        SEQ531.TYPE = "KEYWORD1";
        SEQ SEQ532 = new SEQ();
        SEQ532.text = "\\theta";
        SEQ532.TYPE = "KEYWORD1";
        SEQ SEQ533 = new SEQ();
        SEQ533.text = "\\tentt";
        SEQ533.TYPE = "KEYWORD1";
        SEQ SEQ534 = new SEQ();
        SEQ534.text = "\\tensy";
        SEQ534.TYPE = "KEYWORD1";
        SEQ SEQ535 = new SEQ();
        SEQ535.text = "\\tensl";
        SEQ535.TYPE = "KEYWORD1";
        SEQ SEQ536 = new SEQ();
        SEQ536.text = "\\tenrm";
        SEQ536.TYPE = "KEYWORD1";
        SEQ SEQ537 = new SEQ();
        SEQ537.text = "\\tenit";
        SEQ537.TYPE = "KEYWORD1";
        SEQ SEQ538 = new SEQ();
        SEQ538.text = "\\tenex";
        SEQ538.TYPE = "KEYWORD1";
        SEQ SEQ539 = new SEQ();
        SEQ539.text = "\\tenbf";
        SEQ539.TYPE = "KEYWORD1";
        SEQ SEQ540 = new SEQ();
        SEQ540.text = "\\strut";
        SEQ540.TYPE = "KEYWORD1";
        SEQ SEQ541 = new SEQ();
        SEQ541.text = "\\sqcup";
        SEQ541.TYPE = "KEYWORD1";
        SEQ SEQ542 = new SEQ();
        SEQ542.text = "\\sqcap";
        SEQ542.TYPE = "KEYWORD1";
        SEQ SEQ543 = new SEQ();
        SEQ543.text = "\\space";
        SEQ543.TYPE = "KEYWORD1";
        SEQ SEQ544 = new SEQ();
        SEQ544.text = "\\smile";
        SEQ544.TYPE = "KEYWORD1";
        SEQ SEQ545 = new SEQ();
        SEQ545.text = "\\smash";
        SEQ545.TYPE = "KEYWORD1";
        SEQ SEQ546 = new SEQ();
        SEQ546.text = "\\slfam";
        SEQ546.TYPE = "KEYWORD1";
        SEQ SEQ547 = new SEQ();
        SEQ547.text = "\\slash";
        SEQ547.TYPE = "KEYWORD1";
        SEQ SEQ548 = new SEQ();
        SEQ548.text = "\\simeq";
        SEQ548.TYPE = "KEYWORD1";
        SEQ SEQ549 = new SEQ();
        SEQ549.text = "\\Sigma";
        SEQ549.TYPE = "KEYWORD1";
        SEQ SEQ550 = new SEQ();
        SEQ550.text = "\\sigma";
        SEQ550.TYPE = "KEYWORD1";
        SEQ SEQ551 = new SEQ();
        SEQ551.text = "\\sharp";
        SEQ551.TYPE = "KEYWORD1";
        SEQ SEQ552 = new SEQ();
        SEQ552.text = "\\right";
        SEQ552.TYPE = "KEYWORD1";
        SEQ SEQ553 = new SEQ();
        SEQ553.text = "\\rhook";
        SEQ553.TYPE = "KEYWORD1";
        SEQ SEQ554 = new SEQ();
        SEQ554.text = "\\relax";
        SEQ554.TYPE = "KEYWORD1";
        SEQ SEQ555 = new SEQ();
        SEQ555.text = "\\rceil";
        SEQ555.TYPE = "KEYWORD1";
        SEQ SEQ556 = new SEQ();
        SEQ556.text = "\\raise";
        SEQ556.TYPE = "KEYWORD1";
        SEQ SEQ557 = new SEQ();
        SEQ557.text = "\\qquad";
        SEQ557.TYPE = "KEYWORD1";
        SEQ SEQ558 = new SEQ();
        SEQ558.text = "\\prime";
        SEQ558.TYPE = "KEYWORD1";
        SEQ SEQ559 = new SEQ();
        SEQ559.text = "\\outer";
        SEQ559.TYPE = "FUNCTION";
        SEQ SEQ560 = new SEQ();
        SEQ560.text = "\\oplus";
        SEQ560.TYPE = "KEYWORD1";
        SEQ SEQ561 = new SEQ();
        SEQ561.text = "\\Omega";
        SEQ561.TYPE = "KEYWORD1";
        SEQ SEQ562 = new SEQ();
        SEQ562.text = "\\omega";
        SEQ562.TYPE = "KEYWORD1";
        SEQ SEQ563 = new SEQ();
        SEQ563.text = "\\notin";
        SEQ563.TYPE = "KEYWORD1";
        SEQ SEQ564 = new SEQ();
        SEQ564.text = "\\newif";
        SEQ564.TYPE = "COMMENT2";
        SEQ SEQ565 = new SEQ();
        SEQ565.text = "\\nabla";
        SEQ565.TYPE = "KEYWORD1";
        SEQ SEQ566 = new SEQ();
        SEQ566.text = "\\mskip";
        SEQ566.TYPE = "KEYWORD1";
        SEQ SEQ567 = new SEQ();
        SEQ567.text = "\\month";
        SEQ567.TYPE = "KEYWORD4";
        SEQ SEQ568 = new SEQ();
        SEQ568.text = "\\mkern";
        SEQ568.TYPE = "KEYWORD1";
        SEQ SEQ569 = new SEQ();
        SEQ569.text = "\\lower";
        SEQ569.TYPE = "KEYWORD1";
        SEQ SEQ570 = new SEQ();
        SEQ570.text = "\\lhook";
        SEQ570.TYPE = "KEYWORD1";
        SEQ SEQ571 = new SEQ();
        SEQ571.text = "\\leqno";
        SEQ571.TYPE = "KEYWORD1";
        SEQ SEQ572 = new SEQ();
        SEQ572.text = "\\ldots";
        SEQ572.TYPE = "KEYWORD1";
        SEQ SEQ573 = new SEQ();
        SEQ573.text = "\\ldotp";
        SEQ573.TYPE = "KEYWORD1";
        SEQ SEQ574 = new SEQ();
        SEQ574.text = "\\lceil";
        SEQ574.TYPE = "KEYWORD1";
        SEQ SEQ575 = new SEQ();
        SEQ575.text = "\\kappa";
        SEQ575.TYPE = "KEYWORD1";
        SEQ SEQ576 = new SEQ();
        SEQ576.text = "\\jmath";
        SEQ576.TYPE = "KEYWORD1";
        SEQ SEQ577 = new SEQ();
        SEQ577.text = "\\itfam";
        SEQ577.TYPE = "KEYWORD1";
        SEQ SEQ578 = new SEQ();
        SEQ578.text = "\\intop";
        SEQ578.TYPE = "KEYWORD1";
        SEQ SEQ579 = new SEQ();
        SEQ579.text = "\\input";
        SEQ579.TYPE = "KEYWORD1";
        SEQ SEQ580 = new SEQ();
        SEQ580.text = "\\infty";
        SEQ580.TYPE = "KEYWORD1";
        SEQ SEQ581 = new SEQ();
        SEQ581.text = "\\imath";
        SEQ581.TYPE = "KEYWORD1";
        SEQ SEQ582 = new SEQ();
        SEQ582.text = "\\ifodd";
        SEQ582.TYPE = "KEYWORD3";
        SEQ SEQ583 = new SEQ();
        SEQ583.text = "\\ifnum";
        SEQ583.TYPE = "KEYWORD3";
        SEQ SEQ584 = new SEQ();
        SEQ584.text = "\\ifeof";
        SEQ584.TYPE = "KEYWORD3";
        SEQ SEQ585 = new SEQ();
        SEQ585.text = "\\ifdim";
        SEQ585.TYPE = "KEYWORD3";
        SEQ SEQ586 = new SEQ();
        SEQ586.text = "\\ifcat";
        SEQ586.TYPE = "KEYWORD3";
        SEQ SEQ587 = new SEQ();
        SEQ587.text = "\\hskip";
        SEQ587.TYPE = "KEYWORD1";
        SEQ SEQ588 = new SEQ();
        SEQ588.text = "\\hsize";
        SEQ588.TYPE = "KEYWORD4";
        SEQ SEQ589 = new SEQ();
        SEQ589.text = "\\hrule";
        SEQ589.TYPE = "KEYWORD1";
        SEQ SEQ590 = new SEQ();
        SEQ590.text = "\\hglue";
        SEQ590.TYPE = "KEYWORD1";
        SEQ SEQ591 = new SEQ();
        SEQ591.text = "\\hfuzz";
        SEQ591.TYPE = "KEYWORD4";
        SEQ SEQ592 = new SEQ();
        SEQ592.text = "\\hfill";
        SEQ592.TYPE = "KEYWORD1";
        SEQ SEQ593 = new SEQ();
        SEQ593.text = "\\grave";
        SEQ593.TYPE = "KEYWORD1";
        SEQ SEQ594 = new SEQ();
        SEQ594.text = "\\Gamma";
        SEQ594.TYPE = "KEYWORD1";
        SEQ SEQ595 = new SEQ();
        SEQ595.text = "\\gamma";
        SEQ595.TYPE = "KEYWORD1";
        SEQ SEQ596 = new SEQ();
        SEQ596.text = "\\frown";
        SEQ596.TYPE = "KEYWORD1";
        SEQ SEQ597 = new SEQ();
        SEQ597.text = "\\folio";
        SEQ597.TYPE = "KEYWORD1";
        SEQ SEQ598 = new SEQ();
        SEQ598.text = "\\fivei";
        SEQ598.TYPE = "KEYWORD1";
        SEQ SEQ599 = new SEQ();
        SEQ599.text = "\\equiv";
        SEQ599.TYPE = "KEYWORD1";
        SEQ SEQ600 = new SEQ();
        SEQ600.text = "\\empty";
        SEQ600.TYPE = "KEYWORD1";
        SEQ SEQ601 = new SEQ();
        SEQ601.text = "\\eject";
        SEQ601.TYPE = "KEYWORD1";
        SEQ SEQ602 = new SEQ();
        SEQ602.text = "\\doteq";
        SEQ602.TYPE = "KEYWORD1";
        SEQ SEQ603 = new SEQ();
        SEQ603.text = "\\dimen";
        SEQ603.TYPE = "COMMENT4";
        SEQ SEQ604 = new SEQ();
        SEQ604.text = "\\Delta";
        SEQ604.TYPE = "KEYWORD1";
        SEQ SEQ605 = new SEQ();
        SEQ605.text = "\\delta";
        SEQ605.TYPE = "KEYWORD1";
        SEQ SEQ606 = new SEQ();
        SEQ606.text = "\\ddots";
        SEQ606.TYPE = "KEYWORD1";
        SEQ SEQ607 = new SEQ();
        SEQ607.text = "\\dashv";
        SEQ607.TYPE = "KEYWORD1";
        SEQ SEQ608 = new SEQ();
        SEQ608.text = "\\count";
        SEQ608.TYPE = "COMMENT4";
        SEQ SEQ609 = new SEQ();
        SEQ609.text = "\\colon";
        SEQ609.TYPE = "KEYWORD1";
        SEQ SEQ610 = new SEQ();
        SEQ610.text = "\\check";
        SEQ610.TYPE = "KEYWORD1";
        SEQ SEQ611 = new SEQ();
        SEQ611.text = "\\cdots";
        SEQ611.TYPE = "KEYWORD1";
        SEQ SEQ612 = new SEQ();
        SEQ612.text = "\\cdotp";
        SEQ612.TYPE = "KEYWORD1";
        SEQ SEQ613 = new SEQ();
        SEQ613.text = "\\cases";
        SEQ613.TYPE = "KEYWORD1";
        SEQ SEQ614 = new SEQ();
        SEQ614.text = "\\breve";
        SEQ614.TYPE = "KEYWORD1";
        SEQ SEQ615 = new SEQ();
        SEQ615.text = "\\break";
        SEQ615.TYPE = "KEYWORD1";
        SEQ SEQ616 = new SEQ();
        SEQ616.text = "\\brack";
        SEQ616.TYPE = "KEYWORD1";
        SEQ SEQ617 = new SEQ();
        SEQ617.text = "\\brace";
        SEQ617.TYPE = "KEYWORD1";
        SEQ SEQ618 = new SEQ();
        SEQ618.text = "\\Biggr";
        SEQ618.TYPE = "KEYWORD1";
        SEQ SEQ619 = new SEQ();
        SEQ619.text = "\\biggr";
        SEQ619.TYPE = "KEYWORD1";
        SEQ SEQ620 = new SEQ();
        SEQ620.text = "\\Biggm";
        SEQ620.TYPE = "KEYWORD1";
        SEQ SEQ621 = new SEQ();
        SEQ621.text = "\\biggm";
        SEQ621.TYPE = "KEYWORD1";
        SEQ SEQ622 = new SEQ();
        SEQ622.text = "\\Biggl";
        SEQ622.TYPE = "KEYWORD1";
        SEQ SEQ623 = new SEQ();
        SEQ623.text = "\\biggl";
        SEQ623.TYPE = "KEYWORD1";
        SEQ SEQ624 = new SEQ();
        SEQ624.text = "\\bffam";
        SEQ624.TYPE = "KEYWORD1";
        SEQ SEQ625 = new SEQ();
        SEQ625.text = "\\asymp";
        SEQ625.TYPE = "KEYWORD1";
        SEQ SEQ626 = new SEQ();
        SEQ626.text = "\\angle";
        SEQ626.TYPE = "KEYWORD1";
        SEQ SEQ627 = new SEQ();
        SEQ627.text = "\\amalg";
        SEQ627.TYPE = "KEYWORD1";
        SEQ SEQ628 = new SEQ();
        SEQ628.text = "\\alpha";
        SEQ628.TYPE = "KEYWORD1";
        SEQ SEQ629 = new SEQ();
        SEQ629.text = "\\aleph";
        SEQ629.TYPE = "KEYWORD1";
        SEQ SEQ630 = new SEQ();
        SEQ630.text = "\\acute";
        SEQ630.TYPE = "KEYWORD1";
        SEQ SEQ631 = new SEQ();
        SEQ631.text = "\\above";
        SEQ631.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP41 = new SEQ_REGEXP();
        SEQ_REGEXP41.text = "\\\\toks[0-9]";
        SEQ_REGEXP41.HASH_CHARS = "\\";
        SEQ_REGEXP41.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP42 = new SEQ_REGEXP();
        SEQ_REGEXP42.text = "\\\\skip[0-9]";
        SEQ_REGEXP42.HASH_CHARS = "\\";
        SEQ_REGEXP42.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP43 = new SEQ_REGEXP();
        SEQ_REGEXP43.text = "\\\\box[0-9][0-9]";
        SEQ_REGEXP43.HASH_CHARS = "\\";
        SEQ_REGEXP43.TYPE = "COMMENT4";
        SEQ_REGEXP SEQ_REGEXP44 = new SEQ_REGEXP();
        SEQ_REGEXP44.text = "\\\\char[0-9]";
        SEQ_REGEXP44.HASH_CHARS = "\\";
        SEQ_REGEXP44.TYPE = "KEYWORD2";
        SEQ SEQ632 = new SEQ();
        SEQ632.text = "\\char'";
        SEQ632.TYPE = "KEYWORD2";
        SEQ SEQ633 = new SEQ();
        SEQ633.text = "\\char\"";
        SEQ633.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP45 = new SEQ_REGEXP();
        SEQ_REGEXP45.text = "\\\\[a-zA-Z@]{5}";
        SEQ_REGEXP45.HASH_CHARS = "\\";
        SEQ_REGEXP45.TYPE = "LABEL";
        SEQ SEQ634 = new SEQ();
        SEQ634.text = "\\zeta";
        SEQ634.TYPE = "KEYWORD1";
        SEQ SEQ635 = new SEQ();
        SEQ635.text = "\\year";
        SEQ635.TYPE = "KEYWORD4";
        SEQ SEQ636 = new SEQ();
        SEQ636.text = "\\xdef";
        SEQ636.TYPE = "FUNCTION";
        SEQ SEQ637 = new SEQ();
        SEQ637.text = "\\wlog";
        SEQ637.TYPE = "KEYWORD1";
        SEQ SEQ638 = new SEQ();
        SEQ638.text = "\\vtop";
        SEQ638.TYPE = "KEYWORD1";
        SEQ SEQ639 = new SEQ();
        SEQ639.text = "\\vfil";
        SEQ639.TYPE = "KEYWORD1";
        SEQ SEQ640 = new SEQ();
        SEQ640.text = "\\vert";
        SEQ640.TYPE = "KEYWORD1";
        SEQ SEQ641 = new SEQ();
        SEQ641.text = "\\Vert";
        SEQ641.TYPE = "KEYWORD1";
        SEQ SEQ642 = new SEQ();
        SEQ642.text = "\\vbox";
        SEQ642.TYPE = "KEYWORD1";
        SEQ SEQ643 = new SEQ();
        SEQ643.text = "\\uarc";
        SEQ643.TYPE = "KEYWORD2";
        SEQ SEQ644 = new SEQ();
        SEQ644.text = "\\toks";
        SEQ644.TYPE = "KEYWORD4";
        SEQ SEQ645 = new SEQ();
        SEQ645.text = "\\time";
        SEQ645.TYPE = "KEYWORD4";
        SEQ SEQ646 = new SEQ();
        SEQ646.text = "\\teni";
        SEQ646.TYPE = "KEYWORD1";
        SEQ SEQ647 = new SEQ();
        SEQ647.text = "\\tanh";
        SEQ647.TYPE = "KEYWORD1";
        SEQ SEQ648 = new SEQ();
        SEQ648.text = "\\tabs";
        SEQ648.TYPE = "KEYWORD1";
        SEQ SEQ649 = new SEQ();
        SEQ649.text = "\\surd";
        SEQ649.TYPE = "KEYWORD1";
        SEQ SEQ650 = new SEQ();
        SEQ650.text = "\\succ";
        SEQ650.TYPE = "KEYWORD1";
        SEQ SEQ651 = new SEQ();
        SEQ651.text = "\\star";
        SEQ651.TYPE = "KEYWORD1";
        SEQ SEQ652 = new SEQ();
        SEQ652.text = "\\sqrt";
        SEQ652.TYPE = "KEYWORD1";
        SEQ SEQ653 = new SEQ();
        SEQ653.text = "\\span";
        SEQ653.TYPE = "KEYWORD1";
        SEQ SEQ654 = new SEQ();
        SEQ654.text = "\\skip";
        SEQ654.TYPE = "KEYWORD4";
        SEQ SEQ655 = new SEQ();
        SEQ655.text = "\\skew";
        SEQ655.TYPE = "KEYWORD1";
        SEQ SEQ656 = new SEQ();
        SEQ656.text = "\\sinh";
        SEQ656.TYPE = "KEYWORD1";
        SEQ SEQ657 = new SEQ();
        SEQ657.text = "\\show";
        SEQ657.TYPE = "KEYWORD1";
        SEQ SEQ658 = new SEQ();
        SEQ658.text = "\\root";
        SEQ658.TYPE = "KEYWORD1";
        SEQ SEQ659 = new SEQ();
        SEQ659.text = "\\rlap";
        SEQ659.TYPE = "KEYWORD1";
        SEQ SEQ660 = new SEQ();
        SEQ660.text = "\\read";
        SEQ660.TYPE = "KEYWORD1";
        SEQ SEQ661 = new SEQ();
        SEQ661.text = "\\quad";
        SEQ661.TYPE = "KEYWORD1";
        SEQ SEQ662 = new SEQ();
        SEQ662.text = "\\prod";
        SEQ662.TYPE = "KEYWORD1";
        SEQ SEQ663 = new SEQ();
        SEQ663.text = "\\prec";
        SEQ663.TYPE = "KEYWORD1";
        SEQ SEQ664 = new SEQ();
        SEQ664.text = "\\pmod";
        SEQ664.TYPE = "KEYWORD1";
        SEQ SEQ665 = new SEQ();
        SEQ665.text = "\\perp";
        SEQ665.TYPE = "KEYWORD1";
        SEQ SEQ666 = new SEQ();
        SEQ666.text = "\\owns";
        SEQ666.TYPE = "KEYWORD1";
        SEQ SEQ667 = new SEQ();
        SEQ667.text = "\\over";
        SEQ667.TYPE = "KEYWORD1";
        SEQ SEQ668 = new SEQ();
        SEQ668.text = "\\omit";
        SEQ668.TYPE = "KEYWORD1";
        SEQ SEQ669 = new SEQ();
        SEQ669.text = "\\oint";
        SEQ669.TYPE = "KEYWORD1";
        SEQ SEQ670 = new SEQ();
        SEQ670.text = "\\odot";
        SEQ670.TYPE = "KEYWORD1";
        SEQ SEQ671 = new SEQ();
        SEQ671.text = "\\null";
        SEQ671.TYPE = "KEYWORD1";
        SEQ SEQ672 = new SEQ();
        SEQ672.text = "\\next";
        SEQ672.TYPE = "KEYWORD1";
        SEQ SEQ673 = new SEQ();
        SEQ673.text = "\\mark";
        SEQ673.TYPE = "KEYWORD1";
        SEQ SEQ674 = new SEQ();
        SEQ674.text = "\\loop";
        SEQ674.TYPE = "KEYWORD1";
        SEQ SEQ675 = new SEQ();
        SEQ675.text = "\\long";
        SEQ675.TYPE = "FUNCTION";
        SEQ SEQ676 = new SEQ();
        SEQ676.text = "\\lnot";
        SEQ676.TYPE = "KEYWORD1";
        SEQ SEQ677 = new SEQ();
        SEQ677.text = "\\llap";
        SEQ677.TYPE = "KEYWORD1";
        SEQ SEQ678 = new SEQ();
        SEQ678.text = "\\line";
        SEQ678.TYPE = "KEYWORD1";
        SEQ SEQ679 = new SEQ();
        SEQ679.text = "\\left";
        SEQ679.TYPE = "KEYWORD1";
        SEQ SEQ680 = new SEQ();
        SEQ680.text = "\\land";
        SEQ680.TYPE = "KEYWORD1";
        SEQ SEQ681 = new SEQ();
        SEQ681.text = "\\kern";
        SEQ681.TYPE = "KEYWORD1";
        SEQ SEQ682 = new SEQ();
        SEQ682.text = "\\item";
        SEQ682.TYPE = "KEYWORD1";
        SEQ SEQ683 = new SEQ();
        SEQ683.text = "\\iota";
        SEQ683.TYPE = "KEYWORD1";
        SEQ SEQ684 = new SEQ();
        SEQ684.text = "\\hfil";
        SEQ684.TYPE = "KEYWORD1";
        SEQ SEQ685 = new SEQ();
        SEQ685.text = "\\hbox";
        SEQ685.TYPE = "KEYWORD1";
        SEQ SEQ686 = new SEQ();
        SEQ686.text = "\\hbar";
        SEQ686.TYPE = "KEYWORD1";
        SEQ SEQ687 = new SEQ();
        SEQ687.text = "\\hang";
        SEQ687.TYPE = "KEYWORD1";
        SEQ SEQ688 = new SEQ();
        SEQ688.text = "\\gets";
        SEQ688.TYPE = "KEYWORD1";
        SEQ SEQ689 = new SEQ();
        SEQ689.text = "\\gdef";
        SEQ689.TYPE = "FUNCTION";
        SEQ SEQ690 = new SEQ();
        SEQ690.text = "\\font";
        SEQ690.TYPE = "KEYWORD1";
        SEQ SEQ691 = new SEQ();
        SEQ691.text = "\\flat";
        SEQ691.TYPE = "KEYWORD1";
        SEQ SEQ692 = new SEQ();
        SEQ692.text = "\\eqno";
        SEQ692.TYPE = "KEYWORD1";
        SEQ SEQ693 = new SEQ();
        SEQ693.text = "\\else";
        SEQ693.TYPE = "KEYWORD3";
        SEQ SEQ694 = new SEQ();
        SEQ694.text = "\\edef";
        SEQ694.TYPE = "FUNCTION";
        SEQ SEQ695 = new SEQ();
        SEQ695.text = "\\dump";
        SEQ695.TYPE = "KEYWORD1";
        SEQ SEQ696 = new SEQ();
        SEQ696.text = "\\dots";
        SEQ696.TYPE = "KEYWORD1";
        SEQ SEQ697 = new SEQ();
        SEQ697.text = "\\ddot";
        SEQ697.TYPE = "KEYWORD1";
        SEQ SEQ698 = new SEQ();
        SEQ698.text = "\\ddag";
        SEQ698.TYPE = "KEYWORD1";
        SEQ SEQ699 = new SEQ();
        SEQ699.text = "\\dbar";
        SEQ699.TYPE = "KEYWORD2";
        SEQ SEQ700 = new SEQ();
        SEQ700.text = "\\Dbar";
        SEQ700.TYPE = "KEYWORD2";
        SEQ SEQ701 = new SEQ();
        SEQ701.text = "\\crcr";
        SEQ701.TYPE = "KEYWORD1";
        SEQ SEQ702 = new SEQ();
        SEQ702.text = "\\coth";
        SEQ702.TYPE = "KEYWORD1";
        SEQ SEQ703 = new SEQ();
        SEQ703.text = "\\cosh";
        SEQ703.TYPE = "KEYWORD1";
        SEQ SEQ704 = new SEQ();
        SEQ704.text = "\\copy";
        SEQ704.TYPE = "KEYWORD1";
        SEQ SEQ705 = new SEQ();
        SEQ705.text = "\\cong";
        SEQ705.TYPE = "KEYWORD1";
        SEQ SEQ706 = new SEQ();
        SEQ706.text = "\\circ";
        SEQ706.TYPE = "KEYWORD1";
        SEQ SEQ707 = new SEQ();
        SEQ707.text = "\\char";
        SEQ707.TYPE = "KEYWORD2";
        SEQ SEQ708 = new SEQ();
        SEQ708.text = "\\cfac";
        SEQ708.TYPE = "KEYWORD2";
        SEQ SEQ709 = new SEQ();
        SEQ709.text = "\\cdot";
        SEQ709.TYPE = "KEYWORD1";
        SEQ SEQ710 = new SEQ();
        SEQ710.text = "\\body";
        SEQ710.TYPE = "KEYWORD1";
        SEQ SEQ711 = new SEQ();
        SEQ711.text = "\\bmod";
        SEQ711.TYPE = "KEYWORD1";
        SEQ SEQ712 = new SEQ();
        SEQ712.text = "\\Bigr";
        SEQ712.TYPE = "KEYWORD1";
        SEQ SEQ713 = new SEQ();
        SEQ713.text = "\\bigr";
        SEQ713.TYPE = "KEYWORD1";
        SEQ SEQ714 = new SEQ();
        SEQ714.text = "\\Bigm";
        SEQ714.TYPE = "KEYWORD1";
        SEQ SEQ715 = new SEQ();
        SEQ715.text = "\\bigm";
        SEQ715.TYPE = "KEYWORD1";
        SEQ SEQ716 = new SEQ();
        SEQ716.text = "\\Bigl";
        SEQ716.TYPE = "KEYWORD1";
        SEQ SEQ717 = new SEQ();
        SEQ717.text = "\\bigl";
        SEQ717.TYPE = "KEYWORD1";
        SEQ SEQ718 = new SEQ();
        SEQ718.text = "\\Bigg";
        SEQ718.TYPE = "KEYWORD1";
        SEQ SEQ719 = new SEQ();
        SEQ719.text = "\\bigg";
        SEQ719.TYPE = "KEYWORD1";
        SEQ SEQ720 = new SEQ();
        SEQ720.text = "\\beta";
        SEQ720.TYPE = "KEYWORD1";
        SEQ SEQ721 = new SEQ();
        SEQ721.text = "\\atop";
        SEQ721.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP46 = new SEQ_REGEXP();
        SEQ_REGEXP46.text = "\\\\box[0-9]";
        SEQ_REGEXP46.HASH_CHARS = "\\";
        SEQ_REGEXP46.TYPE = "COMMENT4";
        SEQ SEQ722 = new SEQ();
        SEQ722.text = "\\char";
        SEQ722.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP47 = new SEQ_REGEXP();
        SEQ_REGEXP47.text = "(\\u005E|\\x5E)(\\u005E|\\x5E)([0-9a-f])([0-9a-f])";
        SEQ_REGEXP47.HASH_CHARS = "^";
        SEQ_REGEXP47.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP48 = new SEQ_REGEXP();
        SEQ_REGEXP48.text = "\\\\[a-zA-Z@]{4}";
        SEQ_REGEXP48.HASH_CHARS = "\\";
        SEQ_REGEXP48.TYPE = "LABEL";
        SEQ SEQ723 = new SEQ();
        SEQ723.text = "\\vss";
        SEQ723.TYPE = "KEYWORD1";
        SEQ SEQ724 = new SEQ();
        SEQ724.text = "\\vee";
        SEQ724.TYPE = "KEYWORD1";
        SEQ SEQ725 = new SEQ();
        SEQ725.text = "\\vec";
        SEQ725.TYPE = "KEYWORD1";
        SEQ SEQ726 = new SEQ();
        SEQ726.text = "\\top";
        SEQ726.TYPE = "KEYWORD1";
        SEQ SEQ727 = new SEQ();
        SEQ727.text = "\\the";
        SEQ727.TYPE = "KEYWORD1";
        SEQ SEQ728 = new SEQ();
        SEQ728.text = "\\TeX";
        SEQ728.TYPE = "KEYWORD1";
        SEQ SEQ729 = new SEQ();
        SEQ729.text = "\\tau";
        SEQ729.TYPE = "KEYWORD1";
        SEQ SEQ730 = new SEQ();
        SEQ730.text = "\\tan";
        SEQ730.TYPE = "KEYWORD1";
        SEQ SEQ731 = new SEQ();
        SEQ731.text = "\\sup";
        SEQ731.TYPE = "KEYWORD1";
        SEQ SEQ732 = new SEQ();
        SEQ732.text = "\\sum";
        SEQ732.TYPE = "KEYWORD1";
        SEQ SEQ733 = new SEQ();
        SEQ733.text = "\\sin";
        SEQ733.TYPE = "KEYWORD1";
        SEQ SEQ734 = new SEQ();
        SEQ734.text = "\\sim";
        SEQ734.TYPE = "KEYWORD1";
        SEQ SEQ735 = new SEQ();
        SEQ735.text = "\\sec";
        SEQ735.TYPE = "KEYWORD1";
        SEQ SEQ736 = new SEQ();
        SEQ736.text = "\\rho";
        SEQ736.TYPE = "KEYWORD1";
        SEQ SEQ737 = new SEQ();
        SEQ737.text = "\\Psi";
        SEQ737.TYPE = "KEYWORD1";
        SEQ SEQ738 = new SEQ();
        SEQ738.text = "\\psi";
        SEQ738.TYPE = "KEYWORD1";
        SEQ SEQ739 = new SEQ();
        SEQ739.text = "\\Phi";
        SEQ739.TYPE = "KEYWORD1";
        SEQ SEQ740 = new SEQ();
        SEQ740.text = "\\phi";
        SEQ740.TYPE = "KEYWORD1";
        SEQ SEQ741 = new SEQ();
        SEQ741.text = "\\par";
        SEQ741.TYPE = "LITERAL3";
        SEQ SEQ742 = new SEQ();
        SEQ742.text = "\\not";
        SEQ742.TYPE = "KEYWORD1";
        SEQ SEQ743 = new SEQ();
        SEQ743.text = "\\neq";
        SEQ743.TYPE = "KEYWORD1";
        SEQ SEQ744 = new SEQ();
        SEQ744.text = "\\neg";
        SEQ744.TYPE = "KEYWORD1";
        SEQ SEQ745 = new SEQ();
        SEQ745.text = "\\mit";
        SEQ745.TYPE = "KEYWORD1";
        SEQ SEQ746 = new SEQ();
        SEQ746.text = "\\min";
        SEQ746.TYPE = "KEYWORD1";
        SEQ SEQ747 = new SEQ();
        SEQ747.text = "\\mid";
        SEQ747.TYPE = "KEYWORD1";
        SEQ SEQ748 = new SEQ();
        SEQ748.text = "\\max";
        SEQ748.TYPE = "KEYWORD1";
        SEQ SEQ749 = new SEQ();
        SEQ749.text = "\\mag";
        SEQ749.TYPE = "KEYWORD4";
        SEQ SEQ750 = new SEQ();
        SEQ750.text = "\\lor";
        SEQ750.TYPE = "KEYWORD1";
        SEQ SEQ751 = new SEQ();
        SEQ751.text = "\\log";
        SEQ751.TYPE = "KEYWORD1";
        SEQ SEQ752 = new SEQ();
        SEQ752.text = "\\lim";
        SEQ752.TYPE = "KEYWORD1";
        SEQ SEQ753 = new SEQ();
        SEQ753.text = "\\let";
        SEQ753.TYPE = "COMMENT3";
        SEQ SEQ754 = new SEQ();
        SEQ754.text = "\\leq";
        SEQ754.TYPE = "KEYWORD1";
        SEQ SEQ755 = new SEQ();
        SEQ755.text = "\\ker";
        SEQ755.TYPE = "KEYWORD1";
        SEQ SEQ756 = new SEQ();
        SEQ756.text = "\\jot";
        SEQ756.TYPE = "KEYWORD1";
        SEQ SEQ757 = new SEQ();
        SEQ757.text = "\\int";
        SEQ757.TYPE = "KEYWORD1";
        SEQ SEQ758 = new SEQ();
        SEQ758.text = "\\inf";
        SEQ758.TYPE = "KEYWORD1";
        SEQ SEQ759 = new SEQ();
        SEQ759.text = "\\ifx";
        SEQ759.TYPE = "KEYWORD3";
        SEQ SEQ760 = new SEQ();
        SEQ760.text = "\\iff";
        SEQ760.TYPE = "KEYWORD3";
        SEQ SEQ761 = new SEQ();
        SEQ761.text = "\\hss";
        SEQ761.TYPE = "KEYWORD1";
        SEQ SEQ762 = new SEQ();
        SEQ762.text = "\\hom";
        SEQ762.TYPE = "KEYWORD1";
        SEQ SEQ763 = new SEQ();
        SEQ763.text = "\\hat";
        SEQ763.TYPE = "KEYWORD1";
        SEQ SEQ764 = new SEQ();
        SEQ764.text = "\\geq";
        SEQ764.TYPE = "KEYWORD1";
        SEQ SEQ765 = new SEQ();
        SEQ765.text = "\\gcd";
        SEQ765.TYPE = "KEYWORD1";
        SEQ SEQ766 = new SEQ();
        SEQ766.text = "\\fam";
        SEQ766.TYPE = "KEYWORD4";
        SEQ SEQ767 = new SEQ();
        SEQ767.text = "\\exp";
        SEQ767.TYPE = "KEYWORD1";
        SEQ SEQ768 = new SEQ();
        SEQ768.text = "\\eth";
        SEQ768.TYPE = "KEYWORD2";
        SEQ SEQ769 = new SEQ();
        SEQ769.text = "\\eta";
        SEQ769.TYPE = "KEYWORD1";
        SEQ SEQ770 = new SEQ();
        SEQ770.text = "\\end";
        SEQ770.TYPE = "KEYWORD1";
        SEQ SEQ771 = new SEQ();
        SEQ771.text = "\\ell";
        SEQ771.TYPE = "KEYWORD1";
        SEQ SEQ772 = new SEQ();
        SEQ772.text = "\\dot";
        SEQ772.TYPE = "KEYWORD1";
        SEQ SEQ773 = new SEQ();
        SEQ773.text = "\\div";
        SEQ773.TYPE = "KEYWORD1";
        SEQ SEQ774 = new SEQ();
        SEQ774.text = "\\dim";
        SEQ774.TYPE = "KEYWORD1";
        SEQ SEQ775 = new SEQ();
        SEQ775.text = "\\det";
        SEQ775.TYPE = "KEYWORD1";
        SEQ SEQ776 = new SEQ();
        SEQ776.text = "\\deg";
        SEQ776.TYPE = "KEYWORD1";
        SEQ SEQ777 = new SEQ();
        SEQ777.text = "\\def";
        SEQ777.TYPE = "FUNCTION";
        SEQ SEQ778 = new SEQ();
        SEQ778.text = "\\day";
        SEQ778.TYPE = "KEYWORD4";
        SEQ SEQ779 = new SEQ();
        SEQ779.text = "\\dag";
        SEQ779.TYPE = "KEYWORD1";
        SEQ SEQ780 = new SEQ();
        SEQ780.text = "\\cup";
        SEQ780.TYPE = "KEYWORD1";
        SEQ SEQ781 = new SEQ();
        SEQ781.text = "\\csc";
        SEQ781.TYPE = "KEYWORD1";
        SEQ SEQ782 = new SEQ();
        SEQ782.text = "\\cot";
        SEQ782.TYPE = "KEYWORD1";
        SEQ SEQ783 = new SEQ();
        SEQ783.text = "\\cos";
        SEQ783.TYPE = "KEYWORD1";
        SEQ SEQ784 = new SEQ();
        SEQ784.text = "\\chi";
        SEQ784.TYPE = "KEYWORD1";
        SEQ SEQ785 = new SEQ();
        SEQ785.text = "\\cap";
        SEQ785.TYPE = "KEYWORD1";
        SEQ SEQ786 = new SEQ();
        SEQ786.text = "\\cal";
        SEQ786.TYPE = "KEYWORD1";
        SEQ SEQ787 = new SEQ();
        SEQ787.text = "\\bye";
        SEQ787.TYPE = "KEYWORD1";
        SEQ SEQ788 = new SEQ();
        SEQ788.text = "\\box";
        SEQ788.TYPE = "COMMENT4";
        SEQ SEQ789 = new SEQ();
        SEQ789.text = "\\bot";
        SEQ789.TYPE = "KEYWORD1";
        SEQ SEQ790 = new SEQ();
        SEQ790.text = "\\Big";
        SEQ790.TYPE = "KEYWORD1";
        SEQ SEQ791 = new SEQ();
        SEQ791.text = "\\big";
        SEQ791.TYPE = "KEYWORD1";
        SEQ SEQ792 = new SEQ();
        SEQ792.text = "\\bar";
        SEQ792.TYPE = "KEYWORD1";
        SEQ SEQ793 = new SEQ();
        SEQ793.text = "\\ast";
        SEQ793.TYPE = "KEYWORD1";
        SEQ SEQ794 = new SEQ();
        SEQ794.text = "\\arg";
        SEQ794.TYPE = "KEYWORD1";
        SEQ_REGEXP SEQ_REGEXP49 = new SEQ_REGEXP();
        SEQ_REGEXP49.text = "(\\u005E|\\x5E)(\\u005E|\\x5E)(\\p{ASCII}|\\u0000-\\u007F)";
        SEQ_REGEXP49.HASH_CHARS = "^";
        SEQ_REGEXP49.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP50 = new SEQ_REGEXP();
        SEQ_REGEXP50.text = "\\\\[a-zA-Z@]{3}";
        SEQ_REGEXP50.HASH_CHARS = "\\";
        SEQ_REGEXP50.TYPE = "LABEL";
        SEQ SEQ795 = new SEQ();
        SEQ795.text = "\\Xi";
        SEQ795.TYPE = "KEYWORD1";
        SEQ SEQ796 = new SEQ();
        SEQ796.text = "\\xi";
        SEQ796.TYPE = "KEYWORD1";
        SEQ SEQ797 = new SEQ();
        SEQ797.text = "\\wr";
        SEQ797.TYPE = "KEYWORD1";
        SEQ SEQ798 = new SEQ();
        SEQ798.text = "\\wp";
        SEQ798.TYPE = "KEYWORD1";
        SEQ SEQ799 = new SEQ();
        SEQ799.text = "\\wd";
        SEQ799.TYPE = "KEYWORD1";
        SEQ SEQ800 = new SEQ();
        SEQ800.text = "\\tt";
        SEQ800.TYPE = "KEYWORD1";
        SEQ SEQ801 = new SEQ();
        SEQ801.text = "\\to";
        SEQ801.TYPE = "KEYWORD1";
        SEQ SEQ802 = new SEQ();
        SEQ802.text = "\\sp";
        SEQ802.TYPE = "KEYWORD1";
        SEQ SEQ803 = new SEQ();
        SEQ803.text = "\\sl";
        SEQ803.TYPE = "KEYWORD1";
        SEQ SEQ804 = new SEQ();
        SEQ804.text = "\\sb";
        SEQ804.TYPE = "KEYWORD1";
        SEQ SEQ805 = new SEQ();
        SEQ805.text = "\\rq";
        SEQ805.TYPE = "KEYWORD1";
        SEQ SEQ806 = new SEQ();
        SEQ806.text = "\\rm";
        SEQ806.TYPE = "KEYWORD1";
        SEQ SEQ807 = new SEQ();
        SEQ807.text = "\\Re";
        SEQ807.TYPE = "KEYWORD1";
        SEQ SEQ808 = new SEQ();
        SEQ808.text = "\\Pr";
        SEQ808.TYPE = "KEYWORD1";
        SEQ SEQ809 = new SEQ();
        SEQ809.text = "\\pm";
        SEQ809.TYPE = "KEYWORD1";
        SEQ SEQ810 = new SEQ();
        SEQ810.text = "\\Pi";
        SEQ810.TYPE = "KEYWORD1";
        SEQ SEQ811 = new SEQ();
        SEQ811.text = "\\pi";
        SEQ811.TYPE = "KEYWORD1";
        SEQ SEQ812 = new SEQ();
        SEQ812.text = "\\or";
        SEQ812.TYPE = "KEYWORD3";
        SEQ SEQ813 = new SEQ();
        SEQ813.text = "\\of";
        SEQ813.TYPE = "KEYWORD1";
        SEQ SEQ814 = new SEQ();
        SEQ814.text = "\\nu";
        SEQ814.TYPE = "KEYWORD1";
        SEQ SEQ815 = new SEQ();
        SEQ815.text = "\\ni";
        SEQ815.TYPE = "KEYWORD1";
        SEQ SEQ816 = new SEQ();
        SEQ816.text = "\\ne";
        SEQ816.TYPE = "KEYWORD1";
        SEQ SEQ817 = new SEQ();
        SEQ817.text = "\\mu";
        SEQ817.TYPE = "KEYWORD1";
        SEQ SEQ818 = new SEQ();
        SEQ818.text = "\\mp";
        SEQ818.TYPE = "KEYWORD1";
        SEQ SEQ819 = new SEQ();
        SEQ819.text = "\\lq";
        SEQ819.TYPE = "KEYWORD1";
        SEQ SEQ820 = new SEQ();
        SEQ820.text = "\\ln";
        SEQ820.TYPE = "KEYWORD1";
        SEQ SEQ821 = new SEQ();
        SEQ821.text = "\\ll";
        SEQ821.TYPE = "KEYWORD1";
        SEQ SEQ822 = new SEQ();
        SEQ822.text = "\\lg";
        SEQ822.TYPE = "KEYWORD1";
        SEQ SEQ823 = new SEQ();
        SEQ823.text = "\\le";
        SEQ823.TYPE = "KEYWORD1";
        SEQ SEQ824 = new SEQ();
        SEQ824.text = "\\it";
        SEQ824.TYPE = "KEYWORD1";
        SEQ SEQ825 = new SEQ();
        SEQ825.text = "\\in";
        SEQ825.TYPE = "KEYWORD1";
        SEQ SEQ826 = new SEQ();
        SEQ826.text = "\\Im";
        SEQ826.TYPE = "KEYWORD1";
        SEQ SEQ827 = new SEQ();
        SEQ827.text = "\\if";
        SEQ827.TYPE = "KEYWORD3";
        SEQ SEQ828 = new SEQ();
        SEQ828.text = "\\ht";
        SEQ828.TYPE = "KEYWORD1";
        SEQ SEQ829 = new SEQ();
        SEQ829.text = "\\gg";
        SEQ829.TYPE = "KEYWORD1";
        SEQ SEQ830 = new SEQ();
        SEQ830.text = "\\ge";
        SEQ830.TYPE = "KEYWORD1";
        SEQ SEQ831 = new SEQ();
        SEQ831.text = "\\fi";
        SEQ831.TYPE = "KEYWORD3";
        SEQ SEQ832 = new SEQ();
        SEQ832.text = "\\dp";
        SEQ832.TYPE = "KEYWORD1";
        SEQ SEQ833 = new SEQ();
        SEQ833.text = "\\do";
        SEQ833.TYPE = "KEYWORD1";
        SEQ SEQ834 = new SEQ();
        SEQ834.text = "\\cr";
        SEQ834.TYPE = "KEYWORD1";
        SEQ SEQ835 = new SEQ();
        SEQ835.text = "\\bf";
        SEQ835.TYPE = "KEYWORD1";
        SEQ SEQ836 = new SEQ();
        SEQ836.text = "\\AE";
        SEQ836.TYPE = "KEYWORD2";
        SEQ SEQ837 = new SEQ();
        SEQ837.text = "\\ae";
        SEQ837.TYPE = "KEYWORD2";
        SEQ SEQ838 = new SEQ();
        SEQ838.text = "\\AA";
        SEQ838.TYPE = "KEYWORD2";
        SEQ SEQ839 = new SEQ();
        SEQ839.text = "\\aa";
        SEQ839.TYPE = "KEYWORD2";
        SEQ SEQ840 = new SEQ();
        SEQ840.text = "\\OE";
        SEQ840.TYPE = "KEYWORD2";
        SEQ SEQ841 = new SEQ();
        SEQ841.text = "\\oe";
        SEQ841.TYPE = "KEYWORD2";
        SEQ SEQ842 = new SEQ();
        SEQ842.text = "\\ss";
        SEQ842.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP51 = new SEQ_REGEXP();
        SEQ_REGEXP51.text = "\\\\[a-zA-Z@]{2}";
        SEQ_REGEXP51.HASH_CHARS = "\\";
        SEQ_REGEXP51.TYPE = "LABEL";
        SEQ SEQ843 = new SEQ();
        SEQ843.text = "\\S";
        SEQ843.TYPE = "KEYWORD1";
        SEQ SEQ844 = new SEQ();
        SEQ844.text = "\\P";
        SEQ844.TYPE = "KEYWORD1";
        SEQ SEQ845 = new SEQ();
        SEQ845.text = "\\=";
        SEQ845.TYPE = "KEYWORD2";
        SEQ SEQ846 = new SEQ();
        SEQ846.text = "\\'";
        SEQ846.TYPE = "KEYWORD2";
        SEQ SEQ847 = new SEQ();
        SEQ847.text = "\\\"";
        SEQ847.TYPE = "KEYWORD2";
        SEQ SEQ848 = new SEQ();
        SEQ848.text = "\\~";
        SEQ848.TYPE = "KEYWORD2";
        SEQ SEQ849 = new SEQ();
        SEQ849.text = "\\`";
        SEQ849.TYPE = "KEYWORD2";
        SEQ SEQ850 = new SEQ();
        SEQ850.text = "\\^";
        SEQ850.TYPE = "KEYWORD2";
        SEQ SEQ851 = new SEQ();
        SEQ851.text = "\\.";
        SEQ851.TYPE = "KEYWORD2";
        SEQ SEQ852 = new SEQ();
        SEQ852.text = "\\H";
        SEQ852.TYPE = "KEYWORD2";
        SEQ SEQ853 = new SEQ();
        SEQ853.text = "\\c";
        SEQ853.TYPE = "KEYWORD2";
        SEQ SEQ854 = new SEQ();
        SEQ854.text = "\\d";
        SEQ854.TYPE = "KEYWORD2";
        SEQ SEQ855 = new SEQ();
        SEQ855.text = "\\b";
        SEQ855.TYPE = "KEYWORD2";
        SEQ SEQ856 = new SEQ();
        SEQ856.text = "\\v";
        SEQ856.TYPE = "KEYWORD2";
        SEQ SEQ857 = new SEQ();
        SEQ857.text = "\\u";
        SEQ857.TYPE = "KEYWORD2";
        SEQ SEQ858 = new SEQ();
        SEQ858.text = "\\t";
        SEQ858.TYPE = "KEYWORD2";
        SEQ SEQ859 = new SEQ();
        SEQ859.text = "\\r";
        SEQ859.TYPE = "KEYWORD2";
        SEQ SEQ860 = new SEQ();
        SEQ860.text = "\\k";
        SEQ860.TYPE = "KEYWORD2";
        SEQ SEQ861 = new SEQ();
        SEQ861.text = "\\O";
        SEQ861.TYPE = "KEYWORD2";
        SEQ SEQ862 = new SEQ();
        SEQ862.text = "\\o";
        SEQ862.TYPE = "KEYWORD2";
        SEQ SEQ863 = new SEQ();
        SEQ863.text = "\\L";
        SEQ863.TYPE = "KEYWORD2";
        SEQ SEQ864 = new SEQ();
        SEQ864.text = "\\l";
        SEQ864.TYPE = "KEYWORD2";
        SEQ SEQ865 = new SEQ();
        SEQ865.text = "\\j";
        SEQ865.TYPE = "KEYWORD2";
        SEQ SEQ866 = new SEQ();
        SEQ866.text = "\\i";
        SEQ866.TYPE = "KEYWORD2";
        SEQ SEQ867 = new SEQ();
        SEQ867.text = "\\?";
        SEQ867.TYPE = "KEYWORD1";
        SEQ SEQ868 = new SEQ();
        SEQ868.text = "\\>";
        SEQ868.TYPE = "KEYWORD1";
        SEQ SEQ869 = new SEQ();
        SEQ869.text = "\\<";
        SEQ869.TYPE = "KEYWORD1";
        SEQ SEQ870 = new SEQ();
        SEQ870.text = "\\;";
        SEQ870.TYPE = "KEYWORD1";
        SEQ SEQ871 = new SEQ();
        SEQ871.text = "\\:";
        SEQ871.TYPE = "KEYWORD1";
        SEQ SEQ872 = new SEQ();
        SEQ872.text = "\\/";
        SEQ872.TYPE = "KEYWORD1";
        SEQ SEQ873 = new SEQ();
        SEQ873.text = "\\-";
        SEQ873.TYPE = "KEYWORD1";
        SEQ SEQ874 = new SEQ();
        SEQ874.text = "\\,";
        SEQ874.TYPE = "KEYWORD1";
        SEQ SEQ875 = new SEQ();
        SEQ875.text = "\\+";
        SEQ875.TYPE = "KEYWORD1";
        SEQ SEQ876 = new SEQ();
        SEQ876.text = "\\*";
        SEQ876.TYPE = "KEYWORD1";
        SEQ SEQ877 = new SEQ();
        SEQ877.text = "\\)";
        SEQ877.TYPE = "KEYWORD1";
        SEQ SEQ878 = new SEQ();
        SEQ878.text = "\\(";
        SEQ878.TYPE = "KEYWORD1";
        SEQ SEQ879 = new SEQ();
        SEQ879.text = "\\!";
        SEQ879.TYPE = "KEYWORD1";
        SEQ SEQ880 = new SEQ();
        SEQ880.text = "\\|";
        SEQ880.TYPE = "KEYWORD1";
        SEQ SEQ881 = new SEQ();
        SEQ881.text = "\\\\";
        SEQ881.TYPE = "KEYWORD1";
        SEQ SEQ882 = new SEQ();
        SEQ882.text = "\\#";
        SEQ882.TYPE = "KEYWORD2";
        SEQ SEQ883 = new SEQ();
        SEQ883.text = "\\$";
        SEQ883.TYPE = "KEYWORD2";
        SEQ SEQ884 = new SEQ();
        SEQ884.text = "\\%";
        SEQ884.TYPE = "KEYWORD2";
        SEQ SEQ885 = new SEQ();
        SEQ885.text = "\\&";
        SEQ885.TYPE = "KEYWORD2";
        SEQ SEQ886 = new SEQ();
        SEQ886.text = "\\{";
        SEQ886.TYPE = "KEYWORD2";
        SEQ SEQ887 = new SEQ();
        SEQ887.text = "\\}";
        SEQ887.TYPE = "KEYWORD2";
        SEQ SEQ888 = new SEQ();
        SEQ888.text = "\\_";
        SEQ888.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP52 = new SEQ_REGEXP();
        SEQ_REGEXP52.text = "`\\p{ASCII}";
        SEQ_REGEXP52.HASH_CHARS = "`";
        SEQ_REGEXP52.TYPE = "KEYWORD2";
        SEQ_REGEXP SEQ_REGEXP53 = new SEQ_REGEXP();
        SEQ_REGEXP53.text = "#[1-9]";
        SEQ_REGEXP53.HASH_CHARS = "#";
        SEQ_REGEXP53.TYPE = "DIGIT";
        SEQ_REGEXP SEQ_REGEXP54 = new SEQ_REGEXP();
        SEQ_REGEXP54.text = "\\\\[a-zA-Z@]{1}";
        SEQ_REGEXP54.HASH_CHARS = "\\";
        SEQ_REGEXP54.TYPE = "LABEL";
        SEQ SEQ889 = new SEQ();
        SEQ889.text = "`";
        SEQ889.TYPE = "LITERAL3";
        SEQ SEQ890 = new SEQ();
        SEQ890.text = "!";
        SEQ890.TYPE = "LITERAL3";
        SEQ SEQ891 = new SEQ();
        SEQ891.text = ".";
        SEQ891.TYPE = "LITERAL3";
        SEQ SEQ892 = new SEQ();
        SEQ892.text = ",";
        SEQ892.TYPE = "LITERAL3";
        SEQ SEQ893 = new SEQ();
        SEQ893.text = ";";
        SEQ893.TYPE = "LITERAL3";
        SEQ SEQ894 = new SEQ();
        SEQ894.text = "?";
        SEQ894.TYPE = "LITERAL3";
        SEQ SEQ895 = new SEQ();
        SEQ895.text = ":";
        SEQ895.TYPE = "LITERAL3";
        SEQ SEQ896 = new SEQ();
        SEQ896.text = "'";
        SEQ896.TYPE = "LITERAL3";
        SEQ SEQ897 = new SEQ();
        SEQ897.text = "\"";
        SEQ897.TYPE = "LITERAL3";
        SEQ SEQ898 = new SEQ();
        SEQ898.text = "\\";
        SEQ898.TYPE = "LITERAL3";
        SEQ SEQ899 = new SEQ();
        SEQ899.text = "(";
        SEQ899.TYPE = "LITERAL4";
        SEQ SEQ900 = new SEQ();
        SEQ900.text = ")";
        SEQ900.TYPE = "LITERAL4";
        SEQ SEQ901 = new SEQ();
        SEQ901.text = "=";
        SEQ901.TYPE = "LITERAL4";
        SEQ SEQ902 = new SEQ();
        SEQ902.text = "+";
        SEQ902.TYPE = "LITERAL4";
        SEQ SEQ903 = new SEQ();
        SEQ903.text = "-";
        SEQ903.TYPE = "LITERAL4";
        SEQ SEQ904 = new SEQ();
        SEQ904.text = ">";
        SEQ904.TYPE = "LITERAL4";
        SEQ SEQ905 = new SEQ();
        SEQ905.text = "<";
        SEQ905.TYPE = "LITERAL4";
        SEQ SEQ906 = new SEQ();
        SEQ906.text = "{";
        SEQ906.TYPE = "OPERATOR";
        SEQ SEQ907 = new SEQ();
        SEQ907.text = "}";
        SEQ907.TYPE = "OPERATOR";
        SEQ SEQ908 = new SEQ();
        SEQ908.text = "[";
        SEQ908.TYPE = "OPERATOR";
        SEQ SEQ909 = new SEQ();
        SEQ909.text = "]";
        SEQ909.TYPE = "OPERATOR";
        SEQ SEQ910 = new SEQ();
        SEQ910.text = "&";
        SEQ910.TYPE = "LITERAL1";
        SEQ SEQ911 = new SEQ();
        SEQ911.text = "^";
        SEQ911.TYPE = "LITERAL1";
        SEQ SEQ912 = new SEQ();
        SEQ912.text = "_";
        SEQ912.TYPE = "LITERAL1";
        SEQ SEQ913 = new SEQ();
        SEQ913.text = "~";
        SEQ913.TYPE = "LITERAL1";
        SEQ_REGEXP SEQ_REGEXP55 = new SEQ_REGEXP();
        SEQ_REGEXP55.text = "(\\d+?\\.\\d*pt|\\d*\\.\\d+?pt|\\d*pt)";
        SEQ_REGEXP55.HASH_CHARS = "0123456789.";
        SEQ_REGEXP55.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP56 = new SEQ_REGEXP();
        SEQ_REGEXP56.text = "(\\d+?\\.\\d*pc|\\d*\\.\\d+?pc|\\d*pc)";
        SEQ_REGEXP56.HASH_CHARS = "0123456789.";
        SEQ_REGEXP56.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP57 = new SEQ_REGEXP();
        SEQ_REGEXP57.text = "(\\d+?\\.\\d*in|\\d*\\.\\d+?in|\\d*in)";
        SEQ_REGEXP57.HASH_CHARS = "0123456789.";
        SEQ_REGEXP57.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP58 = new SEQ_REGEXP();
        SEQ_REGEXP58.text = "(\\d+?\\.\\d*bp|\\d*\\.\\d+?bp|\\d*bp)";
        SEQ_REGEXP58.HASH_CHARS = "0123456789.";
        SEQ_REGEXP58.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP59 = new SEQ_REGEXP();
        SEQ_REGEXP59.text = "(\\d+?\\.\\d*cm|\\d*\\.\\d+?cm|\\d*cm)";
        SEQ_REGEXP59.HASH_CHARS = "0123456789.";
        SEQ_REGEXP59.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP60 = new SEQ_REGEXP();
        SEQ_REGEXP60.text = "(\\d+?\\.\\d*mm|\\d*\\.\\d+?mm|\\d*mm)";
        SEQ_REGEXP60.HASH_CHARS = "0123456789.";
        SEQ_REGEXP60.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP61 = new SEQ_REGEXP();
        SEQ_REGEXP61.text = "(\\d+?\\.\\d*dd|\\d*\\.\\d+?dd|\\d*dd)";
        SEQ_REGEXP61.HASH_CHARS = "0123456789.";
        SEQ_REGEXP61.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP62 = new SEQ_REGEXP();
        SEQ_REGEXP62.text = "(\\d+?\\.\\d*cc|\\d*\\.\\d+?cc|\\d*cc)";
        SEQ_REGEXP62.HASH_CHARS = "0123456789.";
        SEQ_REGEXP62.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP63 = new SEQ_REGEXP();
        SEQ_REGEXP63.text = "(\\d+?\\.\\d*sp|\\d*\\.\\d+?sp|\\d*sp)";
        SEQ_REGEXP63.HASH_CHARS = "0123456789.";
        SEQ_REGEXP63.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP64 = new SEQ_REGEXP();
        SEQ_REGEXP64.text = "(\\d+?\\.\\d*ex|\\d*\\.\\d+?ex|\\d*ex)";
        SEQ_REGEXP64.HASH_CHARS = "0123456789.";
        SEQ_REGEXP64.TYPE = "LITERAL2";
        SEQ_REGEXP SEQ_REGEXP65 = new SEQ_REGEXP();
        SEQ_REGEXP65.text = "(\\d+?\\.\\d*em|\\d*\\.\\d+?em|\\d*em)";
        SEQ_REGEXP65.HASH_CHARS = "0123456789.";
        SEQ_REGEXP65.TYPE = "LITERAL2";
        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, SEQ_REGEXP2, SEQ_REGEXP3, SEQ_REGEXP4, SEQ_REGEXP5, SEQ_REGEXP6, SEQ_REGEXP7, SEQ_REGEXP8, SEQ_REGEXP9, SEQ_REGEXP10, SEQ_REGEXP11, SEQ_REGEXP12, SEQ_REGEXP13, SEQ_REGEXP14, SEQ_REGEXP15, SEQ_REGEXP16, SEQ_REGEXP17, SEQ_REGEXP18, SEQ_REGEXP19, SEQ_REGEXP20, SEQ_REGEXP21, SEQ_REGEXP22, SEQ_REGEXP23, SEQ_REGEXP24, SEQ_REGEXP25, SEQ_REGEXP26, SEQ_REGEXP27, SEQ_REGEXP28, SEQ_REGEXP29, SEQ_REGEXP30, SEQ_REGEXP31, SEQ_REGEXP32, SEQ_REGEXP33, SEQ_REGEXP34, SEQ_REGEXP35, SEQ_REGEXP36, SEQ_REGEXP37, SEQ_REGEXP38, SEQ_REGEXP39, SEQ_REGEXP40, SEQ_REGEXP41, SEQ_REGEXP42, SEQ_REGEXP43, SEQ_REGEXP44, SEQ_REGEXP45, SEQ_REGEXP46, SEQ_REGEXP47, SEQ_REGEXP48, SEQ_REGEXP49, SEQ_REGEXP50, SEQ_REGEXP51, SEQ_REGEXP52, SEQ_REGEXP53, SEQ_REGEXP54, SEQ_REGEXP55, SEQ_REGEXP56, SEQ_REGEXP57, SEQ_REGEXP58, SEQ_REGEXP59, SEQ_REGEXP60, SEQ_REGEXP61, SEQ_REGEXP62, SEQ_REGEXP63, SEQ_REGEXP64, SEQ_REGEXP65, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, SEQ30, SEQ31, SEQ32, SEQ33, SEQ34, SEQ35, SEQ36, SEQ37, SEQ38, SEQ39, SEQ40, SEQ41, SEQ42, SEQ43, SEQ44, SEQ45, SEQ46, SEQ47, SEQ48, SEQ49, SEQ50, SEQ51, SEQ52, SEQ53, SEQ54, SEQ55, SEQ56, SEQ57, SEQ58, SEQ59, SEQ60, SEQ61, SEQ62, SEQ63, SEQ64, SEQ65, SEQ66, SEQ67, SEQ68, SEQ69, SEQ70, SEQ71, SEQ72, SEQ73, SEQ74, SEQ75, SEQ76, SEQ77, SEQ78, SEQ79, SEQ80, SEQ81, SEQ82, SEQ83, SEQ84, SEQ85, SEQ86, SEQ87, SEQ88, SEQ89, SEQ90, SEQ91, SEQ92, SEQ93, SEQ94, SEQ95, SEQ96, SEQ97, SEQ98, SEQ99, SEQ100, SEQ101, SEQ102, SEQ103, SEQ104, SEQ105, SEQ106, SEQ107, SEQ108, SEQ109, SEQ110, SEQ111, SEQ112, SEQ113, SEQ114, SEQ115, SEQ116, SEQ117, SEQ118, SEQ119, SEQ120, SEQ121, SEQ122, SEQ123, SEQ124, SEQ125, SEQ126, SEQ127, SEQ128, SEQ129, SEQ130, SEQ131, SEQ132, SEQ133, SEQ134, SEQ135, SEQ136, SEQ137, SEQ138, SEQ139, SEQ140, SEQ141, SEQ142, SEQ143, SEQ144, SEQ145, SEQ146, SEQ147, SEQ148, SEQ149, SEQ150, SEQ151, SEQ152, SEQ153, SEQ154, SEQ155, SEQ156, SEQ157, SEQ158, SEQ159, SEQ160, SEQ161, SEQ162, SEQ163, SEQ164, SEQ165, SEQ166, SEQ167, SEQ168, SEQ169, SEQ170, SEQ171, SEQ172, SEQ173, SEQ174, SEQ175, SEQ176, SEQ177, SEQ178, SEQ179, SEQ180, SEQ181, SEQ182, SEQ183, SEQ184, SEQ185, SEQ186, SEQ187, SEQ188, SEQ189, SEQ190, SEQ191, SEQ192, SEQ193, SEQ194, SEQ195, SEQ196, SEQ197, SEQ198, SEQ199, SEQ200, SEQ201, SEQ202, SEQ203, SEQ204, SEQ205, SEQ206, SEQ207, SEQ208, SEQ209, SEQ210, SEQ211, SEQ212, SEQ213, SEQ214, SEQ215, SEQ216, SEQ217, SEQ218, SEQ219, SEQ220, SEQ221, SEQ222, SEQ223, SEQ224, SEQ225, SEQ226, SEQ227, SEQ228, SEQ229, SEQ230, SEQ231, SEQ232, SEQ233, SEQ234, SEQ235, SEQ236, SEQ237, SEQ238, SEQ239, SEQ240, SEQ241, SEQ242, SEQ243, SEQ244, SEQ245, SEQ246, SEQ247, SEQ248, SEQ249, SEQ250, SEQ251, SEQ252, SEQ253, SEQ254, SEQ255, SEQ256, SEQ257, SEQ258, SEQ259, SEQ260, SEQ261, SEQ262, SEQ263, SEQ264, SEQ265, SEQ266, SEQ267, SEQ268, SEQ269, SEQ270, SEQ271, SEQ272, SEQ273, SEQ274, SEQ275, SEQ276, SEQ277, SEQ278, SEQ279, SEQ280, SEQ281, SEQ282, SEQ283, SEQ284, SEQ285, SEQ286, SEQ287, SEQ288, SEQ289, SEQ290, SEQ291, SEQ292, SEQ293, SEQ294, SEQ295, SEQ296, SEQ297, SEQ298, SEQ299, SEQ300, SEQ301, SEQ302, SEQ303, SEQ304, SEQ305, SEQ306, SEQ307, SEQ308, SEQ309, SEQ310, SEQ311, SEQ312, SEQ313, SEQ314, SEQ315, SEQ316, SEQ317, SEQ318, SEQ319, SEQ320, SEQ321, SEQ322, SEQ323, SEQ324, SEQ325, SEQ326, SEQ327, SEQ328, SEQ329, SEQ330, SEQ331, SEQ332, SEQ333, SEQ334, SEQ335, SEQ336, SEQ337, SEQ338, SEQ339, SEQ340, SEQ341, SEQ342, SEQ343, SEQ344, SEQ345, SEQ346, SEQ347, SEQ348, SEQ349, SEQ350, SEQ351, SEQ352, SEQ353, SEQ354, SEQ355, SEQ356, SEQ357, SEQ358, SEQ359, SEQ360, SEQ361, SEQ362, SEQ363, SEQ364, SEQ365, SEQ366, SEQ367, SEQ368, SEQ369, SEQ370, SEQ371, SEQ372, SEQ373, SEQ374, SEQ375, SEQ376, SEQ377, SEQ378, SEQ379, SEQ380, SEQ381, SEQ382, SEQ383, SEQ384, SEQ385, SEQ386, SEQ387, SEQ388, SEQ389, SEQ390, SEQ391, SEQ392, SEQ393, SEQ394, SEQ395, SEQ396, SEQ397, SEQ398, SEQ399, SEQ400, SEQ401, SEQ402, SEQ403, SEQ404, SEQ405, SEQ406, SEQ407, SEQ408, SEQ409, SEQ410, SEQ411, SEQ412, SEQ413, SEQ414, SEQ415, SEQ416, SEQ417, SEQ418, SEQ419, SEQ420, SEQ421, SEQ422, SEQ423, SEQ424, SEQ425, SEQ426, SEQ427, SEQ428, SEQ429, SEQ430, SEQ431, SEQ432, SEQ433, SEQ434, SEQ435, SEQ436, SEQ437, SEQ438, SEQ439, SEQ440, SEQ441, SEQ442, SEQ443, SEQ444, SEQ445, SEQ446, SEQ447, SEQ448, SEQ449, SEQ450, SEQ451, SEQ452, SEQ453, SEQ454, SEQ455, SEQ456, SEQ457, SEQ458, SEQ459, SEQ460, SEQ461, SEQ462, SEQ463, SEQ464, SEQ465, SEQ466, SEQ467, SEQ468, SEQ469, SEQ470, SEQ471, SEQ472, SEQ473, SEQ474, SEQ475, SEQ476, SEQ477, SEQ478, SEQ479, SEQ480, SEQ481, SEQ482, SEQ483, SEQ484, SEQ485, SEQ486, SEQ487, SEQ488, SEQ489, SEQ490, SEQ491, SEQ492, SEQ493, SEQ494, SEQ495, SEQ496, SEQ497, SEQ498, SEQ499, SEQ500, SEQ501, SEQ502, SEQ503, SEQ504, SEQ505, SEQ506, SEQ507, SEQ508, SEQ509, SEQ510, SEQ511, SEQ512, SEQ513, SEQ514, SEQ515, SEQ516, SEQ517, SEQ518, SEQ519, SEQ520, SEQ521, SEQ522, SEQ523, SEQ524, SEQ525, SEQ526, SEQ527, SEQ528, SEQ529, SEQ530, SEQ531, SEQ532, SEQ533, SEQ534, SEQ535, SEQ536, SEQ537, SEQ538, SEQ539, SEQ540, SEQ541, SEQ542, SEQ543, SEQ544, SEQ545, SEQ546, SEQ547, SEQ548, SEQ549, SEQ550, SEQ551, SEQ552, SEQ553, SEQ554, SEQ555, SEQ556, SEQ557, SEQ558, SEQ559, SEQ560, SEQ561, SEQ562, SEQ563, SEQ564, SEQ565, SEQ566, SEQ567, SEQ568, SEQ569, SEQ570, SEQ571, SEQ572, SEQ573, SEQ574, SEQ575, SEQ576, SEQ577, SEQ578, SEQ579, SEQ580, SEQ581, SEQ582, SEQ583, SEQ584, SEQ585, SEQ586, SEQ587, SEQ588, SEQ589, SEQ590, SEQ591, SEQ592, SEQ593, SEQ594, SEQ595, SEQ596, SEQ597, SEQ598, SEQ599, SEQ600, SEQ601, SEQ602, SEQ603, SEQ604, SEQ605, SEQ606, SEQ607, SEQ608, SEQ609, SEQ610, SEQ611, SEQ612, SEQ613, SEQ614, SEQ615, SEQ616, SEQ617, SEQ618, SEQ619, SEQ620, SEQ621, SEQ622, SEQ623, SEQ624, SEQ625, SEQ626, SEQ627, SEQ628, SEQ629, SEQ630, SEQ631, SEQ632, SEQ633, SEQ634, SEQ635, SEQ636, SEQ637, SEQ638, SEQ639, SEQ640, SEQ641, SEQ642, SEQ643, SEQ644, SEQ645, SEQ646, SEQ647, SEQ648, SEQ649, SEQ650, SEQ651, SEQ652, SEQ653, SEQ654, SEQ655, SEQ656, SEQ657, SEQ658, SEQ659, SEQ660, SEQ661, SEQ662, SEQ663, SEQ664, SEQ665, SEQ666, SEQ667, SEQ668, SEQ669, SEQ670, SEQ671, SEQ672, SEQ673, SEQ674, SEQ675, SEQ676, SEQ677, SEQ678, SEQ679, SEQ680, SEQ681, SEQ682, SEQ683, SEQ684, SEQ685, SEQ686, SEQ687, SEQ688, SEQ689, SEQ690, SEQ691, SEQ692, SEQ693, SEQ694, SEQ695, SEQ696, SEQ697, SEQ698, SEQ699, SEQ700, SEQ701, SEQ702, SEQ703, SEQ704, SEQ705, SEQ706, SEQ707, SEQ708, SEQ709, SEQ710, SEQ711, SEQ712, SEQ713, SEQ714, SEQ715, SEQ716, SEQ717, SEQ718, SEQ719, SEQ720, SEQ721, SEQ722, SEQ723, SEQ724, SEQ725, SEQ726, SEQ727, SEQ728, SEQ729, SEQ730, SEQ731, SEQ732, SEQ733, SEQ734, SEQ735, SEQ736, SEQ737, SEQ738, SEQ739, SEQ740, SEQ741, SEQ742, SEQ743, SEQ744, SEQ745, SEQ746, SEQ747, SEQ748, SEQ749, SEQ750, SEQ751, SEQ752, SEQ753, SEQ754, SEQ755, SEQ756, SEQ757, SEQ758, SEQ759, SEQ760, SEQ761, SEQ762, SEQ763, SEQ764, SEQ765, SEQ766, SEQ767, SEQ768, SEQ769, SEQ770, SEQ771, SEQ772, SEQ773, SEQ774, SEQ775, SEQ776, SEQ777, SEQ778, SEQ779, SEQ780, SEQ781, SEQ782, SEQ783, SEQ784, SEQ785, SEQ786, SEQ787, SEQ788, SEQ789, SEQ790, SEQ791, SEQ792, SEQ793, SEQ794, SEQ795, SEQ796, SEQ797, SEQ798, SEQ799, SEQ800, SEQ801, SEQ802, SEQ803, SEQ804, SEQ805, SEQ806, SEQ807, SEQ808, SEQ809, SEQ810, SEQ811, SEQ812, SEQ813, SEQ814, SEQ815, SEQ816, SEQ817, SEQ818, SEQ819, SEQ820, SEQ821, SEQ822, SEQ823, SEQ824, SEQ825, SEQ826, SEQ827, SEQ828, SEQ829, SEQ830, SEQ831, SEQ832, SEQ833, SEQ834, SEQ835, SEQ836, SEQ837, SEQ838, SEQ839, SEQ840, SEQ841, SEQ842, SEQ843, SEQ844, SEQ845, SEQ846, SEQ847, SEQ848, SEQ849, SEQ850, SEQ851, SEQ852, SEQ853, SEQ854, SEQ855, SEQ856, SEQ857, SEQ858, SEQ859, SEQ860, SEQ861, SEQ862, SEQ863, SEQ864, SEQ865, SEQ866, SEQ867, SEQ868, SEQ869, SEQ870, SEQ871, SEQ872, SEQ873, SEQ874, SEQ875, SEQ876, SEQ877, SEQ878, SEQ879, SEQ880, SEQ881, SEQ882, SEQ883, SEQ884, SEQ885, SEQ886, SEQ887, SEQ888, SEQ889, SEQ890, SEQ891, SEQ892, SEQ893, SEQ894, SEQ895, SEQ896, SEQ897, SEQ898, SEQ899, SEQ900, SEQ901, SEQ902, SEQ903, SEQ904, SEQ905, SEQ906, SEQ907, SEQ908, SEQ909, SEQ910, SEQ911, SEQ912, SEQ913, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
