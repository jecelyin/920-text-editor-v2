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
public class ApdlLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "!";
        PROPERTY1.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = ":";
        EOL_SPAN1.TYPE = "LABEL";
        EOL_SPAN1.AT_LINE_START = "TRUE";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "!";
        EOL_SPAN2.TYPE = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "'";
        END END1 = new END();
        END1.text = "'";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "*ABBR";
        SEQ1.AT_WORD_START = "TRUE";
        SEQ1.TYPE = "KEYWORD1";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "*ABB";
        SEQ2.AT_WORD_START = "TRUE";
        SEQ2.TYPE = "KEYWORD1";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "*AFUN";
        SEQ3.AT_WORD_START = "TRUE";
        SEQ3.TYPE = "KEYWORD1";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "*AFU";
        SEQ4.AT_WORD_START = "TRUE";
        SEQ4.TYPE = "KEYWORD1";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "*ASK";
        SEQ5.AT_WORD_START = "TRUE";
        SEQ5.TYPE = "KEYWORD1";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "*CFCLOS";
        SEQ6.AT_WORD_START = "TRUE";
        SEQ6.TYPE = "KEYWORD1";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "*CFC";
        SEQ7.AT_WORD_START = "TRUE";
        SEQ7.TYPE = "KEYWORD1";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "*CFOPEN";
        SEQ8.AT_WORD_START = "TRUE";
        SEQ8.TYPE = "KEYWORD1";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "*CFO";
        SEQ9.AT_WORD_START = "TRUE";
        SEQ9.TYPE = "KEYWORD1";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "*CFWRITE";
        SEQ10.AT_WORD_START = "TRUE";
        SEQ10.TYPE = "KEYWORD1";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "*CFW";
        SEQ11.AT_WORD_START = "TRUE";
        SEQ11.TYPE = "KEYWORD1";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "*CREATE";
        SEQ12.AT_WORD_START = "TRUE";
        SEQ12.TYPE = "KEYWORD1";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "*CRE";
        SEQ13.AT_WORD_START = "TRUE";
        SEQ13.TYPE = "KEYWORD1";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "*CYCLE";
        SEQ14.AT_WORD_START = "TRUE";
        SEQ14.TYPE = "KEYWORD1";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "*CYC";
        SEQ15.AT_WORD_START = "TRUE";
        SEQ15.TYPE = "KEYWORD1";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "*DEL";
        SEQ16.AT_WORD_START = "TRUE";
        SEQ16.TYPE = "KEYWORD1";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "*DIM";
        SEQ17.AT_WORD_START = "TRUE";
        SEQ17.TYPE = "KEYWORD1";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "*DO";
        SEQ18.AT_WORD_START = "TRUE";
        SEQ18.TYPE = "KEYWORD1";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "*ELSEIF";
        SEQ19.AT_WORD_START = "TRUE";
        SEQ19.TYPE = "KEYWORD1";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "*ELSE";
        SEQ20.AT_WORD_START = "TRUE";
        SEQ20.TYPE = "KEYWORD1";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "*ENDDO";
        SEQ21.AT_WORD_START = "TRUE";
        SEQ21.TYPE = "KEYWORD1";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "*ENDIF";
        SEQ22.AT_WORD_START = "TRUE";
        SEQ22.TYPE = "KEYWORD1";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "*END";
        SEQ23.AT_WORD_START = "TRUE";
        SEQ23.TYPE = "KEYWORD1";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "*EVAL";
        SEQ24.AT_WORD_START = "TRUE";
        SEQ24.TYPE = "KEYWORD1";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "*EVA";
        SEQ25.AT_WORD_START = "TRUE";
        SEQ25.TYPE = "KEYWORD1";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = "*EXIT";
        SEQ26.AT_WORD_START = "TRUE";
        SEQ26.TYPE = "KEYWORD1";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "*EXI";
        SEQ27.AT_WORD_START = "TRUE";
        SEQ27.TYPE = "KEYWORD1";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "*GET";
        SEQ28.AT_WORD_START = "TRUE";
        SEQ28.TYPE = "KEYWORD1";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = "*GO";
        SEQ29.AT_WORD_START = "TRUE";
        SEQ29.TYPE = "KEYWORD1";
        SEQ SEQ30 = new SEQ();
        SEQ30.text = "*IF";
        SEQ30.AT_WORD_START = "TRUE";
        SEQ30.TYPE = "KEYWORD1";
        SEQ SEQ31 = new SEQ();
        SEQ31.text = "*LIST";
        SEQ31.AT_WORD_START = "TRUE";
        SEQ31.TYPE = "KEYWORD1";
        SEQ SEQ32 = new SEQ();
        SEQ32.text = "*LIS";
        SEQ32.AT_WORD_START = "TRUE";
        SEQ32.TYPE = "KEYWORD1";
        SEQ SEQ33 = new SEQ();
        SEQ33.text = "*MFOURI";
        SEQ33.AT_WORD_START = "TRUE";
        SEQ33.TYPE = "KEYWORD1";
        SEQ SEQ34 = new SEQ();
        SEQ34.text = "*MFO";
        SEQ34.AT_WORD_START = "TRUE";
        SEQ34.TYPE = "KEYWORD1";
        SEQ SEQ35 = new SEQ();
        SEQ35.text = "*MFUN";
        SEQ35.AT_WORD_START = "TRUE";
        SEQ35.TYPE = "KEYWORD1";
        SEQ SEQ36 = new SEQ();
        SEQ36.text = "*MFU";
        SEQ36.AT_WORD_START = "TRUE";
        SEQ36.TYPE = "KEYWORD1";
        SEQ SEQ37 = new SEQ();
        SEQ37.text = "*MOONEY";
        SEQ37.AT_WORD_START = "TRUE";
        SEQ37.TYPE = "KEYWORD1";
        SEQ SEQ38 = new SEQ();
        SEQ38.text = "*MOO";
        SEQ38.AT_WORD_START = "TRUE";
        SEQ38.TYPE = "KEYWORD1";
        SEQ SEQ39 = new SEQ();
        SEQ39.text = "*MOPER";
        SEQ39.AT_WORD_START = "TRUE";
        SEQ39.TYPE = "KEYWORD1";
        SEQ SEQ40 = new SEQ();
        SEQ40.text = "*MOP";
        SEQ40.AT_WORD_START = "TRUE";
        SEQ40.TYPE = "KEYWORD1";
        SEQ SEQ41 = new SEQ();
        SEQ41.text = "*MSG";
        SEQ41.AT_WORD_START = "TRUE";
        SEQ41.TYPE = "KEYWORD1";
        SEQ SEQ42 = new SEQ();
        SEQ42.text = "*REPEAT";
        SEQ42.AT_WORD_START = "TRUE";
        SEQ42.TYPE = "KEYWORD1";
        SEQ SEQ43 = new SEQ();
        SEQ43.text = "*REP";
        SEQ43.AT_WORD_START = "TRUE";
        SEQ43.TYPE = "KEYWORD1";
        SEQ SEQ44 = new SEQ();
        SEQ44.text = "*SET";
        SEQ44.AT_WORD_START = "TRUE";
        SEQ44.TYPE = "KEYWORD1";
        SEQ SEQ45 = new SEQ();
        SEQ45.text = "*STATUS";
        SEQ45.AT_WORD_START = "TRUE";
        SEQ45.TYPE = "KEYWORD1";
        SEQ SEQ46 = new SEQ();
        SEQ46.text = "*STA";
        SEQ46.AT_WORD_START = "TRUE";
        SEQ46.TYPE = "KEYWORD1";
        SEQ SEQ47 = new SEQ();
        SEQ47.text = "*TREAD";
        SEQ47.AT_WORD_START = "TRUE";
        SEQ47.TYPE = "KEYWORD1";
        SEQ SEQ48 = new SEQ();
        SEQ48.text = "*TRE";
        SEQ48.AT_WORD_START = "TRUE";
        SEQ48.TYPE = "KEYWORD1";
        SEQ SEQ49 = new SEQ();
        SEQ49.text = "*ULIB";
        SEQ49.AT_WORD_START = "TRUE";
        SEQ49.TYPE = "KEYWORD1";
        SEQ SEQ50 = new SEQ();
        SEQ50.text = "*ULI";
        SEQ50.AT_WORD_START = "TRUE";
        SEQ50.TYPE = "KEYWORD1";
        SEQ SEQ51 = new SEQ();
        SEQ51.text = "*USE";
        SEQ51.AT_WORD_START = "TRUE";
        SEQ51.TYPE = "KEYWORD1";
        SEQ SEQ52 = new SEQ();
        SEQ52.text = "*VABS";
        SEQ52.AT_WORD_START = "TRUE";
        SEQ52.TYPE = "KEYWORD1";
        SEQ SEQ53 = new SEQ();
        SEQ53.text = "*VAB";
        SEQ53.AT_WORD_START = "TRUE";
        SEQ53.TYPE = "KEYWORD1";
        SEQ SEQ54 = new SEQ();
        SEQ54.text = "*VCOL";
        SEQ54.AT_WORD_START = "TRUE";
        SEQ54.TYPE = "KEYWORD1";
        SEQ SEQ55 = new SEQ();
        SEQ55.text = "*VCO";
        SEQ55.AT_WORD_START = "TRUE";
        SEQ55.TYPE = "KEYWORD1";
        SEQ SEQ56 = new SEQ();
        SEQ56.text = "*VCUM";
        SEQ56.AT_WORD_START = "TRUE";
        SEQ56.TYPE = "KEYWORD1";
        SEQ SEQ57 = new SEQ();
        SEQ57.text = "*VCU";
        SEQ57.AT_WORD_START = "TRUE";
        SEQ57.TYPE = "KEYWORD1";
        SEQ SEQ58 = new SEQ();
        SEQ58.text = "*VEDIT";
        SEQ58.AT_WORD_START = "TRUE";
        SEQ58.TYPE = "KEYWORD1";
        SEQ SEQ59 = new SEQ();
        SEQ59.text = "*VED";
        SEQ59.AT_WORD_START = "TRUE";
        SEQ59.TYPE = "KEYWORD1";
        SEQ SEQ60 = new SEQ();
        SEQ60.text = "*VFACT";
        SEQ60.AT_WORD_START = "TRUE";
        SEQ60.TYPE = "KEYWORD1";
        SEQ SEQ61 = new SEQ();
        SEQ61.text = "*VFA";
        SEQ61.AT_WORD_START = "TRUE";
        SEQ61.TYPE = "KEYWORD1";
        SEQ SEQ62 = new SEQ();
        SEQ62.text = "*VFILL";
        SEQ62.AT_WORD_START = "TRUE";
        SEQ62.TYPE = "KEYWORD1";
        SEQ SEQ63 = new SEQ();
        SEQ63.text = "*VFI";
        SEQ63.AT_WORD_START = "TRUE";
        SEQ63.TYPE = "KEYWORD1";
        SEQ SEQ64 = new SEQ();
        SEQ64.text = "*VFUN";
        SEQ64.AT_WORD_START = "TRUE";
        SEQ64.TYPE = "KEYWORD1";
        SEQ SEQ65 = new SEQ();
        SEQ65.text = "*VFU";
        SEQ65.AT_WORD_START = "TRUE";
        SEQ65.TYPE = "KEYWORD1";
        SEQ SEQ66 = new SEQ();
        SEQ66.text = "*VGET";
        SEQ66.AT_WORD_START = "TRUE";
        SEQ66.TYPE = "KEYWORD1";
        SEQ SEQ67 = new SEQ();
        SEQ67.text = "*VGE";
        SEQ67.AT_WORD_START = "TRUE";
        SEQ67.TYPE = "KEYWORD1";
        SEQ SEQ68 = new SEQ();
        SEQ68.text = "*VITRP";
        SEQ68.AT_WORD_START = "TRUE";
        SEQ68.TYPE = "KEYWORD1";
        SEQ SEQ69 = new SEQ();
        SEQ69.text = "*VIT";
        SEQ69.AT_WORD_START = "TRUE";
        SEQ69.TYPE = "KEYWORD1";
        SEQ SEQ70 = new SEQ();
        SEQ70.text = "*VLEN";
        SEQ70.AT_WORD_START = "TRUE";
        SEQ70.TYPE = "KEYWORD1";
        SEQ SEQ71 = new SEQ();
        SEQ71.text = "*VLE";
        SEQ71.AT_WORD_START = "TRUE";
        SEQ71.TYPE = "KEYWORD1";
        SEQ SEQ72 = new SEQ();
        SEQ72.text = "*VMASK";
        SEQ72.AT_WORD_START = "TRUE";
        SEQ72.TYPE = "KEYWORD1";
        SEQ SEQ73 = new SEQ();
        SEQ73.text = "*VMA";
        SEQ73.AT_WORD_START = "TRUE";
        SEQ73.TYPE = "KEYWORD1";
        SEQ SEQ74 = new SEQ();
        SEQ74.text = "*VOPER";
        SEQ74.AT_WORD_START = "TRUE";
        SEQ74.TYPE = "KEYWORD1";
        SEQ SEQ75 = new SEQ();
        SEQ75.text = "*VOP";
        SEQ75.AT_WORD_START = "TRUE";
        SEQ75.TYPE = "KEYWORD1";
        SEQ SEQ76 = new SEQ();
        SEQ76.text = "*VPLOT";
        SEQ76.AT_WORD_START = "TRUE";
        SEQ76.TYPE = "KEYWORD1";
        SEQ SEQ77 = new SEQ();
        SEQ77.text = "*VPL";
        SEQ77.AT_WORD_START = "TRUE";
        SEQ77.TYPE = "KEYWORD1";
        SEQ SEQ78 = new SEQ();
        SEQ78.text = "*VPUT";
        SEQ78.AT_WORD_START = "TRUE";
        SEQ78.TYPE = "KEYWORD1";
        SEQ SEQ79 = new SEQ();
        SEQ79.text = "*VPU";
        SEQ79.AT_WORD_START = "TRUE";
        SEQ79.TYPE = "KEYWORD1";
        SEQ SEQ80 = new SEQ();
        SEQ80.text = "*VREAD";
        SEQ80.AT_WORD_START = "TRUE";
        SEQ80.TYPE = "KEYWORD1";
        SEQ SEQ81 = new SEQ();
        SEQ81.text = "*VRE";
        SEQ81.AT_WORD_START = "TRUE";
        SEQ81.TYPE = "KEYWORD1";
        SEQ SEQ82 = new SEQ();
        SEQ82.text = "*VSCFUN";
        SEQ82.AT_WORD_START = "TRUE";
        SEQ82.TYPE = "KEYWORD1";
        SEQ SEQ83 = new SEQ();
        SEQ83.text = "*VSC";
        SEQ83.AT_WORD_START = "TRUE";
        SEQ83.TYPE = "KEYWORD1";
        SEQ SEQ84 = new SEQ();
        SEQ84.text = "*VSTAT";
        SEQ84.AT_WORD_START = "TRUE";
        SEQ84.TYPE = "KEYWORD1";
        SEQ SEQ85 = new SEQ();
        SEQ85.text = "*VST";
        SEQ85.AT_WORD_START = "TRUE";
        SEQ85.TYPE = "KEYWORD1";
        SEQ SEQ86 = new SEQ();
        SEQ86.text = "*VWRITE";
        SEQ86.AT_WORD_START = "TRUE";
        SEQ86.TYPE = "KEYWORD1";
        SEQ SEQ87 = new SEQ();
        SEQ87.text = "*VWR";
        SEQ87.AT_WORD_START = "TRUE";
        SEQ87.TYPE = "KEYWORD1";
        SEQ SEQ88 = new SEQ();
        SEQ88.text = "/ANFILE";
        SEQ88.AT_WORD_START = "TRUE";
        SEQ88.TYPE = "KEYWORD1";
        SEQ SEQ89 = new SEQ();
        SEQ89.text = "/ANF";
        SEQ89.AT_WORD_START = "TRUE";
        SEQ89.TYPE = "KEYWORD1";
        SEQ SEQ90 = new SEQ();
        SEQ90.text = "/ANGLE";
        SEQ90.AT_WORD_START = "TRUE";
        SEQ90.TYPE = "KEYWORD1";
        SEQ SEQ91 = new SEQ();
        SEQ91.text = "/ANG";
        SEQ91.AT_WORD_START = "TRUE";
        SEQ91.TYPE = "KEYWORD1";
        SEQ SEQ92 = new SEQ();
        SEQ92.text = "/ANNOT";
        SEQ92.AT_WORD_START = "TRUE";
        SEQ92.TYPE = "KEYWORD1";
        SEQ SEQ93 = new SEQ();
        SEQ93.text = "/ANN";
        SEQ93.AT_WORD_START = "TRUE";
        SEQ93.TYPE = "KEYWORD1";
        SEQ SEQ94 = new SEQ();
        SEQ94.text = "/ANUM";
        SEQ94.AT_WORD_START = "TRUE";
        SEQ94.TYPE = "KEYWORD1";
        SEQ SEQ95 = new SEQ();
        SEQ95.text = "/ANU";
        SEQ95.AT_WORD_START = "TRUE";
        SEQ95.TYPE = "KEYWORD1";
        SEQ SEQ96 = new SEQ();
        SEQ96.text = "/ASSIGN";
        SEQ96.AT_WORD_START = "TRUE";
        SEQ96.TYPE = "KEYWORD1";
        SEQ SEQ97 = new SEQ();
        SEQ97.text = "/ASS";
        SEQ97.AT_WORD_START = "TRUE";
        SEQ97.TYPE = "KEYWORD1";
        SEQ SEQ98 = new SEQ();
        SEQ98.text = "/AUTO";
        SEQ98.AT_WORD_START = "TRUE";
        SEQ98.TYPE = "KEYWORD1";
        SEQ SEQ99 = new SEQ();
        SEQ99.text = "/AUT";
        SEQ99.AT_WORD_START = "TRUE";
        SEQ99.TYPE = "KEYWORD1";
        SEQ SEQ100 = new SEQ();
        SEQ100.text = "/AUX15";
        SEQ100.AT_WORD_START = "TRUE";
        SEQ100.TYPE = "KEYWORD1";
        SEQ SEQ101 = new SEQ();
        SEQ101.text = "/AUX2";
        SEQ101.AT_WORD_START = "TRUE";
        SEQ101.TYPE = "KEYWORD1";
        SEQ SEQ102 = new SEQ();
        SEQ102.text = "/AUX";
        SEQ102.AT_WORD_START = "TRUE";
        SEQ102.TYPE = "KEYWORD1";
        SEQ SEQ103 = new SEQ();
        SEQ103.text = "/AXLAB";
        SEQ103.AT_WORD_START = "TRUE";
        SEQ103.TYPE = "KEYWORD1";
        SEQ SEQ104 = new SEQ();
        SEQ104.text = "/AXL";
        SEQ104.AT_WORD_START = "TRUE";
        SEQ104.TYPE = "KEYWORD1";
        SEQ SEQ105 = new SEQ();
        SEQ105.text = "/BATCH";
        SEQ105.AT_WORD_START = "TRUE";
        SEQ105.TYPE = "KEYWORD1";
        SEQ SEQ106 = new SEQ();
        SEQ106.text = "/BAT";
        SEQ106.AT_WORD_START = "TRUE";
        SEQ106.TYPE = "KEYWORD1";
        SEQ SEQ107 = new SEQ();
        SEQ107.text = "/CLABEL";
        SEQ107.AT_WORD_START = "TRUE";
        SEQ107.TYPE = "KEYWORD1";
        SEQ SEQ108 = new SEQ();
        SEQ108.text = "/CLA";
        SEQ108.AT_WORD_START = "TRUE";
        SEQ108.TYPE = "KEYWORD1";
        SEQ SEQ109 = new SEQ();
        SEQ109.text = "/CLEAR";
        SEQ109.AT_WORD_START = "TRUE";
        SEQ109.TYPE = "KEYWORD1";
        SEQ SEQ110 = new SEQ();
        SEQ110.text = "/CLE";
        SEQ110.AT_WORD_START = "TRUE";
        SEQ110.TYPE = "KEYWORD1";
        SEQ SEQ111 = new SEQ();
        SEQ111.text = "/CLOG";
        SEQ111.AT_WORD_START = "TRUE";
        SEQ111.TYPE = "KEYWORD1";
        SEQ SEQ112 = new SEQ();
        SEQ112.text = "/CLO";
        SEQ112.AT_WORD_START = "TRUE";
        SEQ112.TYPE = "KEYWORD1";
        SEQ SEQ113 = new SEQ();
        SEQ113.text = "/CMAP";
        SEQ113.AT_WORD_START = "TRUE";
        SEQ113.TYPE = "KEYWORD1";
        SEQ SEQ114 = new SEQ();
        SEQ114.text = "/CMA";
        SEQ114.AT_WORD_START = "TRUE";
        SEQ114.TYPE = "KEYWORD1";
        SEQ SEQ115 = new SEQ();
        SEQ115.text = "/COLOR";
        SEQ115.AT_WORD_START = "TRUE";
        SEQ115.TYPE = "KEYWORD1";
        SEQ SEQ116 = new SEQ();
        SEQ116.text = "/COL";
        SEQ116.AT_WORD_START = "TRUE";
        SEQ116.TYPE = "KEYWORD1";
        SEQ SEQ117 = new SEQ();
        SEQ117.text = "/COM";
        SEQ117.AT_WORD_START = "TRUE";
        SEQ117.TYPE = "KEYWORD1";
        SEQ SEQ118 = new SEQ();
        SEQ118.text = "/CONFIG";
        SEQ118.AT_WORD_START = "TRUE";
        SEQ118.TYPE = "KEYWORD1";
        SEQ SEQ119 = new SEQ();
        SEQ119.text = "/CONTOUR";
        SEQ119.AT_WORD_START = "TRUE";
        SEQ119.TYPE = "KEYWORD1";
        SEQ SEQ120 = new SEQ();
        SEQ120.text = "/CON";
        SEQ120.AT_WORD_START = "TRUE";
        SEQ120.TYPE = "KEYWORD1";
        SEQ SEQ121 = new SEQ();
        SEQ121.text = "/COPY";
        SEQ121.AT_WORD_START = "TRUE";
        SEQ121.TYPE = "KEYWORD1";
        SEQ SEQ122 = new SEQ();
        SEQ122.text = "/COP";
        SEQ122.AT_WORD_START = "TRUE";
        SEQ122.TYPE = "KEYWORD1";
        SEQ SEQ123 = new SEQ();
        SEQ123.text = "/CPLANE";
        SEQ123.AT_WORD_START = "TRUE";
        SEQ123.TYPE = "KEYWORD1";
        SEQ SEQ124 = new SEQ();
        SEQ124.text = "/CPL";
        SEQ124.AT_WORD_START = "TRUE";
        SEQ124.TYPE = "KEYWORD1";
        SEQ SEQ125 = new SEQ();
        SEQ125.text = "/CTYPE";
        SEQ125.AT_WORD_START = "TRUE";
        SEQ125.TYPE = "KEYWORD1";
        SEQ SEQ126 = new SEQ();
        SEQ126.text = "/CTY";
        SEQ126.AT_WORD_START = "TRUE";
        SEQ126.TYPE = "KEYWORD1";
        SEQ SEQ127 = new SEQ();
        SEQ127.text = "/CVAL";
        SEQ127.AT_WORD_START = "TRUE";
        SEQ127.TYPE = "KEYWORD1";
        SEQ SEQ128 = new SEQ();
        SEQ128.text = "/CVA";
        SEQ128.AT_WORD_START = "TRUE";
        SEQ128.TYPE = "KEYWORD1";
        SEQ SEQ129 = new SEQ();
        SEQ129.text = "/DELETE";
        SEQ129.AT_WORD_START = "TRUE";
        SEQ129.TYPE = "KEYWORD1";
        SEQ SEQ130 = new SEQ();
        SEQ130.text = "/DEL";
        SEQ130.AT_WORD_START = "TRUE";
        SEQ130.TYPE = "KEYWORD1";
        SEQ SEQ131 = new SEQ();
        SEQ131.text = "/DEVDISP";
        SEQ131.AT_WORD_START = "TRUE";
        SEQ131.TYPE = "KEYWORD1";
        SEQ SEQ132 = new SEQ();
        SEQ132.text = "/DEVICE";
        SEQ132.AT_WORD_START = "TRUE";
        SEQ132.TYPE = "KEYWORD1";
        SEQ SEQ133 = new SEQ();
        SEQ133.text = "/DEV";
        SEQ133.AT_WORD_START = "TRUE";
        SEQ133.TYPE = "KEYWORD1";
        SEQ SEQ134 = new SEQ();
        SEQ134.text = "/DIST";
        SEQ134.AT_WORD_START = "TRUE";
        SEQ134.TYPE = "KEYWORD1";
        SEQ SEQ135 = new SEQ();
        SEQ135.text = "/DIS";
        SEQ135.AT_WORD_START = "TRUE";
        SEQ135.TYPE = "KEYWORD1";
        SEQ SEQ136 = new SEQ();
        SEQ136.text = "/DSCALE";
        SEQ136.AT_WORD_START = "TRUE";
        SEQ136.TYPE = "KEYWORD1";
        SEQ SEQ137 = new SEQ();
        SEQ137.text = "/DSC";
        SEQ137.AT_WORD_START = "TRUE";
        SEQ137.TYPE = "KEYWORD1";
        SEQ SEQ138 = new SEQ();
        SEQ138.text = "/DV3D";
        SEQ138.AT_WORD_START = "TRUE";
        SEQ138.TYPE = "KEYWORD1";
        SEQ SEQ139 = new SEQ();
        SEQ139.text = "/DV3";
        SEQ139.AT_WORD_START = "TRUE";
        SEQ139.TYPE = "KEYWORD1";
        SEQ SEQ140 = new SEQ();
        SEQ140.text = "/EDGE";
        SEQ140.AT_WORD_START = "TRUE";
        SEQ140.TYPE = "KEYWORD1";
        SEQ SEQ141 = new SEQ();
        SEQ141.text = "/EDG";
        SEQ141.AT_WORD_START = "TRUE";
        SEQ141.TYPE = "KEYWORD1";
        SEQ SEQ142 = new SEQ();
        SEQ142.text = "/EFACET";
        SEQ142.AT_WORD_START = "TRUE";
        SEQ142.TYPE = "KEYWORD1";
        SEQ SEQ143 = new SEQ();
        SEQ143.text = "/EFA";
        SEQ143.AT_WORD_START = "TRUE";
        SEQ143.TYPE = "KEYWORD1";
        SEQ SEQ144 = new SEQ();
        SEQ144.text = "/EOF";
        SEQ144.AT_WORD_START = "TRUE";
        SEQ144.TYPE = "KEYWORD1";
        SEQ SEQ145 = new SEQ();
        SEQ145.text = "/ERASE";
        SEQ145.AT_WORD_START = "TRUE";
        SEQ145.TYPE = "KEYWORD1";
        SEQ SEQ146 = new SEQ();
        SEQ146.text = "/ERA";
        SEQ146.AT_WORD_START = "TRUE";
        SEQ146.TYPE = "KEYWORD1";
        SEQ SEQ147 = new SEQ();
        SEQ147.text = "/ESHAPE";
        SEQ147.AT_WORD_START = "TRUE";
        SEQ147.TYPE = "KEYWORD1";
        SEQ SEQ148 = new SEQ();
        SEQ148.text = "/ESH";
        SEQ148.AT_WORD_START = "TRUE";
        SEQ148.TYPE = "KEYWORD1";
        SEQ SEQ149 = new SEQ();
        SEQ149.text = "/EXIT";
        SEQ149.AT_WORD_START = "TRUE";
        SEQ149.TYPE = "KEYWORD1";
        SEQ SEQ150 = new SEQ();
        SEQ150.text = "/EXI";
        SEQ150.AT_WORD_START = "TRUE";
        SEQ150.TYPE = "KEYWORD1";
        SEQ SEQ151 = new SEQ();
        SEQ151.text = "/EXPAND";
        SEQ151.AT_WORD_START = "TRUE";
        SEQ151.TYPE = "KEYWORD1";
        SEQ SEQ152 = new SEQ();
        SEQ152.text = "/EXP";
        SEQ152.AT_WORD_START = "TRUE";
        SEQ152.TYPE = "KEYWORD1";
        SEQ SEQ153 = new SEQ();
        SEQ153.text = "/FACET";
        SEQ153.AT_WORD_START = "TRUE";
        SEQ153.TYPE = "KEYWORD1";
        SEQ SEQ154 = new SEQ();
        SEQ154.text = "/FAC";
        SEQ154.AT_WORD_START = "TRUE";
        SEQ154.TYPE = "KEYWORD1";
        SEQ SEQ155 = new SEQ();
        SEQ155.text = "/FDELE";
        SEQ155.AT_WORD_START = "TRUE";
        SEQ155.TYPE = "KEYWORD1";
        SEQ SEQ156 = new SEQ();
        SEQ156.text = "/FDE";
        SEQ156.AT_WORD_START = "TRUE";
        SEQ156.TYPE = "KEYWORD1";
        SEQ SEQ157 = new SEQ();
        SEQ157.text = "/FILNAME";
        SEQ157.AT_WORD_START = "TRUE";
        SEQ157.TYPE = "KEYWORD1";
        SEQ SEQ158 = new SEQ();
        SEQ158.text = "/FIL";
        SEQ158.AT_WORD_START = "TRUE";
        SEQ158.TYPE = "KEYWORD1";
        SEQ SEQ159 = new SEQ();
        SEQ159.text = "/FOCUS";
        SEQ159.AT_WORD_START = "TRUE";
        SEQ159.TYPE = "KEYWORD1";
        SEQ SEQ160 = new SEQ();
        SEQ160.text = "/FOC";
        SEQ160.AT_WORD_START = "TRUE";
        SEQ160.TYPE = "KEYWORD1";
        SEQ SEQ161 = new SEQ();
        SEQ161.text = "/FORMAT";
        SEQ161.AT_WORD_START = "TRUE";
        SEQ161.TYPE = "KEYWORD1";
        SEQ SEQ162 = new SEQ();
        SEQ162.text = "/FOR";
        SEQ162.AT_WORD_START = "TRUE";
        SEQ162.TYPE = "KEYWORD1";
        SEQ SEQ163 = new SEQ();
        SEQ163.text = "/FTYPE";
        SEQ163.AT_WORD_START = "TRUE";
        SEQ163.TYPE = "KEYWORD1";
        SEQ SEQ164 = new SEQ();
        SEQ164.text = "/FTY";
        SEQ164.AT_WORD_START = "TRUE";
        SEQ164.TYPE = "KEYWORD1";
        SEQ SEQ165 = new SEQ();
        SEQ165.text = "/GCMD";
        SEQ165.AT_WORD_START = "TRUE";
        SEQ165.TYPE = "KEYWORD1";
        SEQ SEQ166 = new SEQ();
        SEQ166.text = "/GCM";
        SEQ166.AT_WORD_START = "TRUE";
        SEQ166.TYPE = "KEYWORD1";
        SEQ SEQ167 = new SEQ();
        SEQ167.text = "/GCOLUMN";
        SEQ167.AT_WORD_START = "TRUE";
        SEQ167.TYPE = "KEYWORD1";
        SEQ SEQ168 = new SEQ();
        SEQ168.text = "/GCO";
        SEQ168.AT_WORD_START = "TRUE";
        SEQ168.TYPE = "KEYWORD1";
        SEQ SEQ169 = new SEQ();
        SEQ169.text = "/GFILE";
        SEQ169.AT_WORD_START = "TRUE";
        SEQ169.TYPE = "KEYWORD1";
        SEQ SEQ170 = new SEQ();
        SEQ170.text = "/GFI";
        SEQ170.AT_WORD_START = "TRUE";
        SEQ170.TYPE = "KEYWORD1";
        SEQ SEQ171 = new SEQ();
        SEQ171.text = "/GFORMAT";
        SEQ171.AT_WORD_START = "TRUE";
        SEQ171.TYPE = "KEYWORD1";
        SEQ SEQ172 = new SEQ();
        SEQ172.text = "/GFO";
        SEQ172.AT_WORD_START = "TRUE";
        SEQ172.TYPE = "KEYWORD1";
        SEQ SEQ173 = new SEQ();
        SEQ173.text = "/GLINE";
        SEQ173.AT_WORD_START = "TRUE";
        SEQ173.TYPE = "KEYWORD1";
        SEQ SEQ174 = new SEQ();
        SEQ174.text = "/GLI";
        SEQ174.AT_WORD_START = "TRUE";
        SEQ174.TYPE = "KEYWORD1";
        SEQ SEQ175 = new SEQ();
        SEQ175.text = "/GMARKER";
        SEQ175.AT_WORD_START = "TRUE";
        SEQ175.TYPE = "KEYWORD1";
        SEQ SEQ176 = new SEQ();
        SEQ176.text = "/GMA";
        SEQ176.AT_WORD_START = "TRUE";
        SEQ176.TYPE = "KEYWORD1";
        SEQ SEQ177 = new SEQ();
        SEQ177.text = "/GOLIST";
        SEQ177.AT_WORD_START = "TRUE";
        SEQ177.TYPE = "KEYWORD1";
        SEQ SEQ178 = new SEQ();
        SEQ178.text = "/GOL";
        SEQ178.AT_WORD_START = "TRUE";
        SEQ178.TYPE = "KEYWORD1";
        SEQ SEQ179 = new SEQ();
        SEQ179.text = "/GOPR";
        SEQ179.AT_WORD_START = "TRUE";
        SEQ179.TYPE = "KEYWORD1";
        SEQ SEQ180 = new SEQ();
        SEQ180.text = "/GOP";
        SEQ180.AT_WORD_START = "TRUE";
        SEQ180.TYPE = "KEYWORD1";
        SEQ SEQ181 = new SEQ();
        SEQ181.text = "/GO";
        SEQ181.AT_WORD_START = "TRUE";
        SEQ181.TYPE = "KEYWORD1";
        SEQ SEQ182 = new SEQ();
        SEQ182.text = "/GRAPHICS";
        SEQ182.AT_WORD_START = "TRUE";
        SEQ182.TYPE = "KEYWORD1";
        SEQ SEQ183 = new SEQ();
        SEQ183.text = "/GRA";
        SEQ183.AT_WORD_START = "TRUE";
        SEQ183.TYPE = "KEYWORD1";
        SEQ SEQ184 = new SEQ();
        SEQ184.text = "/GRESUME";
        SEQ184.AT_WORD_START = "TRUE";
        SEQ184.TYPE = "KEYWORD1";
        SEQ SEQ185 = new SEQ();
        SEQ185.text = "/GRE";
        SEQ185.AT_WORD_START = "TRUE";
        SEQ185.TYPE = "KEYWORD1";
        SEQ SEQ186 = new SEQ();
        SEQ186.text = "/GRID";
        SEQ186.AT_WORD_START = "TRUE";
        SEQ186.TYPE = "KEYWORD1";
        SEQ SEQ187 = new SEQ();
        SEQ187.text = "/GRI";
        SEQ187.AT_WORD_START = "TRUE";
        SEQ187.TYPE = "KEYWORD1";
        SEQ SEQ188 = new SEQ();
        SEQ188.text = "/GROPT";
        SEQ188.AT_WORD_START = "TRUE";
        SEQ188.TYPE = "KEYWORD1";
        SEQ SEQ189 = new SEQ();
        SEQ189.text = "/GRO";
        SEQ189.AT_WORD_START = "TRUE";
        SEQ189.TYPE = "KEYWORD1";
        SEQ SEQ190 = new SEQ();
        SEQ190.text = "/GRTYP";
        SEQ190.AT_WORD_START = "TRUE";
        SEQ190.TYPE = "KEYWORD1";
        SEQ SEQ191 = new SEQ();
        SEQ191.text = "/GRT";
        SEQ191.AT_WORD_START = "TRUE";
        SEQ191.TYPE = "KEYWORD1";
        SEQ SEQ192 = new SEQ();
        SEQ192.text = "/GSAVE";
        SEQ192.AT_WORD_START = "TRUE";
        SEQ192.TYPE = "KEYWORD1";
        SEQ SEQ193 = new SEQ();
        SEQ193.text = "/GSA";
        SEQ193.AT_WORD_START = "TRUE";
        SEQ193.TYPE = "KEYWORD1";
        SEQ SEQ194 = new SEQ();
        SEQ194.text = "/GST";
        SEQ194.AT_WORD_START = "TRUE";
        SEQ194.TYPE = "KEYWORD1";
        SEQ SEQ195 = new SEQ();
        SEQ195.text = "/GTHK";
        SEQ195.AT_WORD_START = "TRUE";
        SEQ195.TYPE = "KEYWORD1";
        SEQ SEQ196 = new SEQ();
        SEQ196.text = "/GTH";
        SEQ196.AT_WORD_START = "TRUE";
        SEQ196.TYPE = "KEYWORD1";
        SEQ SEQ197 = new SEQ();
        SEQ197.text = "/GTYPE";
        SEQ197.AT_WORD_START = "TRUE";
        SEQ197.TYPE = "KEYWORD1";
        SEQ SEQ198 = new SEQ();
        SEQ198.text = "/GTY";
        SEQ198.AT_WORD_START = "TRUE";
        SEQ198.TYPE = "KEYWORD1";
        SEQ SEQ199 = new SEQ();
        SEQ199.text = "/HEADER";
        SEQ199.AT_WORD_START = "TRUE";
        SEQ199.TYPE = "KEYWORD1";
        SEQ SEQ200 = new SEQ();
        SEQ200.text = "/HEA";
        SEQ200.AT_WORD_START = "TRUE";
        SEQ200.TYPE = "KEYWORD1";
        SEQ SEQ201 = new SEQ();
        SEQ201.text = "/INPUT";
        SEQ201.AT_WORD_START = "TRUE";
        SEQ201.TYPE = "KEYWORD1";
        SEQ SEQ202 = new SEQ();
        SEQ202.text = "/INP";
        SEQ202.AT_WORD_START = "TRUE";
        SEQ202.TYPE = "KEYWORD1";
        SEQ SEQ203 = new SEQ();
        SEQ203.text = "/LARC";
        SEQ203.AT_WORD_START = "TRUE";
        SEQ203.TYPE = "KEYWORD1";
        SEQ SEQ204 = new SEQ();
        SEQ204.text = "/LAR";
        SEQ204.AT_WORD_START = "TRUE";
        SEQ204.TYPE = "KEYWORD1";
        SEQ SEQ205 = new SEQ();
        SEQ205.text = "/LIGHT";
        SEQ205.AT_WORD_START = "TRUE";
        SEQ205.TYPE = "KEYWORD1";
        SEQ SEQ206 = new SEQ();
        SEQ206.text = "/LIG";
        SEQ206.AT_WORD_START = "TRUE";
        SEQ206.TYPE = "KEYWORD1";
        SEQ SEQ207 = new SEQ();
        SEQ207.text = "/LINE";
        SEQ207.AT_WORD_START = "TRUE";
        SEQ207.TYPE = "KEYWORD1";
        SEQ SEQ208 = new SEQ();
        SEQ208.text = "/LIN";
        SEQ208.AT_WORD_START = "TRUE";
        SEQ208.TYPE = "KEYWORD1";
        SEQ SEQ209 = new SEQ();
        SEQ209.text = "/LSPEC";
        SEQ209.AT_WORD_START = "TRUE";
        SEQ209.TYPE = "KEYWORD1";
        SEQ SEQ210 = new SEQ();
        SEQ210.text = "/LSP";
        SEQ210.AT_WORD_START = "TRUE";
        SEQ210.TYPE = "KEYWORD1";
        SEQ SEQ211 = new SEQ();
        SEQ211.text = "/LSYMBOL";
        SEQ211.AT_WORD_START = "TRUE";
        SEQ211.TYPE = "KEYWORD1";
        SEQ SEQ212 = new SEQ();
        SEQ212.text = "/LSY";
        SEQ212.AT_WORD_START = "TRUE";
        SEQ212.TYPE = "KEYWORD1";
        SEQ SEQ213 = new SEQ();
        SEQ213.text = "/MENU";
        SEQ213.AT_WORD_START = "TRUE";
        SEQ213.TYPE = "KEYWORD1";
        SEQ SEQ214 = new SEQ();
        SEQ214.text = "/MEN";
        SEQ214.AT_WORD_START = "TRUE";
        SEQ214.TYPE = "KEYWORD1";
        SEQ SEQ215 = new SEQ();
        SEQ215.text = "/MPLIB";
        SEQ215.AT_WORD_START = "TRUE";
        SEQ215.TYPE = "KEYWORD1";
        SEQ SEQ216 = new SEQ();
        SEQ216.text = "/MPL";
        SEQ216.AT_WORD_START = "TRUE";
        SEQ216.TYPE = "KEYWORD1";
        SEQ SEQ217 = new SEQ();
        SEQ217.text = "/MREP";
        SEQ217.AT_WORD_START = "TRUE";
        SEQ217.TYPE = "KEYWORD1";
        SEQ SEQ218 = new SEQ();
        SEQ218.text = "/MRE";
        SEQ218.AT_WORD_START = "TRUE";
        SEQ218.TYPE = "KEYWORD1";
        SEQ SEQ219 = new SEQ();
        SEQ219.text = "/MSTART";
        SEQ219.AT_WORD_START = "TRUE";
        SEQ219.TYPE = "KEYWORD1";
        SEQ SEQ220 = new SEQ();
        SEQ220.text = "/MST";
        SEQ220.AT_WORD_START = "TRUE";
        SEQ220.TYPE = "KEYWORD1";
        SEQ SEQ221 = new SEQ();
        SEQ221.text = "/NERR";
        SEQ221.AT_WORD_START = "TRUE";
        SEQ221.TYPE = "KEYWORD1";
        SEQ SEQ222 = new SEQ();
        SEQ222.text = "/NER";
        SEQ222.AT_WORD_START = "TRUE";
        SEQ222.TYPE = "KEYWORD1";
        SEQ SEQ223 = new SEQ();
        SEQ223.text = "/NOERASE";
        SEQ223.AT_WORD_START = "TRUE";
        SEQ223.TYPE = "KEYWORD1";
        SEQ SEQ224 = new SEQ();
        SEQ224.text = "/NOE";
        SEQ224.AT_WORD_START = "TRUE";
        SEQ224.TYPE = "KEYWORD1";
        SEQ SEQ225 = new SEQ();
        SEQ225.text = "/NOLIST";
        SEQ225.AT_WORD_START = "TRUE";
        SEQ225.TYPE = "KEYWORD1";
        SEQ SEQ226 = new SEQ();
        SEQ226.text = "/NOL";
        SEQ226.AT_WORD_START = "TRUE";
        SEQ226.TYPE = "KEYWORD1";
        SEQ SEQ227 = new SEQ();
        SEQ227.text = "/NOPR";
        SEQ227.AT_WORD_START = "TRUE";
        SEQ227.TYPE = "KEYWORD1";
        SEQ SEQ228 = new SEQ();
        SEQ228.text = "/NOP";
        SEQ228.AT_WORD_START = "TRUE";
        SEQ228.TYPE = "KEYWORD1";
        SEQ SEQ229 = new SEQ();
        SEQ229.text = "/NORMAL";
        SEQ229.AT_WORD_START = "TRUE";
        SEQ229.TYPE = "KEYWORD1";
        SEQ SEQ230 = new SEQ();
        SEQ230.text = "/NOR";
        SEQ230.AT_WORD_START = "TRUE";
        SEQ230.TYPE = "KEYWORD1";
        SEQ SEQ231 = new SEQ();
        SEQ231.text = "/NUMBER";
        SEQ231.AT_WORD_START = "TRUE";
        SEQ231.TYPE = "KEYWORD1";
        SEQ SEQ232 = new SEQ();
        SEQ232.text = "/NUM";
        SEQ232.AT_WORD_START = "TRUE";
        SEQ232.TYPE = "KEYWORD1";
        SEQ SEQ233 = new SEQ();
        SEQ233.text = "/OPT";
        SEQ233.AT_WORD_START = "TRUE";
        SEQ233.TYPE = "KEYWORD1";
        SEQ SEQ234 = new SEQ();
        SEQ234.text = "/OUTPUT";
        SEQ234.AT_WORD_START = "TRUE";
        SEQ234.TYPE = "KEYWORD1";
        SEQ SEQ235 = new SEQ();
        SEQ235.text = "/OUt";
        SEQ235.AT_WORD_START = "TRUE";
        SEQ235.TYPE = "KEYWORD1";
        SEQ SEQ236 = new SEQ();
        SEQ236.text = "/PAGE";
        SEQ236.AT_WORD_START = "TRUE";
        SEQ236.TYPE = "KEYWORD1";
        SEQ SEQ237 = new SEQ();
        SEQ237.text = "/PAG";
        SEQ237.AT_WORD_START = "TRUE";
        SEQ237.TYPE = "KEYWORD1";
        SEQ SEQ238 = new SEQ();
        SEQ238.text = "/PBC";
        SEQ238.AT_WORD_START = "TRUE";
        SEQ238.TYPE = "KEYWORD1";
        SEQ SEQ239 = new SEQ();
        SEQ239.text = "/PBF";
        SEQ239.AT_WORD_START = "TRUE";
        SEQ239.TYPE = "KEYWORD1";
        SEQ SEQ240 = new SEQ();
        SEQ240.text = "/PCIRCLE";
        SEQ240.AT_WORD_START = "TRUE";
        SEQ240.TYPE = "KEYWORD1";
        SEQ SEQ241 = new SEQ();
        SEQ241.text = "/PCI";
        SEQ241.AT_WORD_START = "TRUE";
        SEQ241.TYPE = "KEYWORD1";
        SEQ SEQ242 = new SEQ();
        SEQ242.text = "/PCOPY";
        SEQ242.AT_WORD_START = "TRUE";
        SEQ242.TYPE = "KEYWORD1";
        SEQ SEQ243 = new SEQ();
        SEQ243.text = "/PCO";
        SEQ243.AT_WORD_START = "TRUE";
        SEQ243.TYPE = "KEYWORD1";
        SEQ SEQ244 = new SEQ();
        SEQ244.text = "/PLOPTS";
        SEQ244.AT_WORD_START = "TRUE";
        SEQ244.TYPE = "KEYWORD1";
        SEQ SEQ245 = new SEQ();
        SEQ245.text = "/PLO";
        SEQ245.AT_WORD_START = "TRUE";
        SEQ245.TYPE = "KEYWORD1";
        SEQ SEQ246 = new SEQ();
        SEQ246.text = "/PMACRO";
        SEQ246.AT_WORD_START = "TRUE";
        SEQ246.TYPE = "KEYWORD1";
        SEQ SEQ247 = new SEQ();
        SEQ247.text = "/PMA";
        SEQ247.AT_WORD_START = "TRUE";
        SEQ247.TYPE = "KEYWORD1";
        SEQ SEQ248 = new SEQ();
        SEQ248.text = "/PMETH";
        SEQ248.AT_WORD_START = "TRUE";
        SEQ248.TYPE = "KEYWORD1";
        SEQ SEQ249 = new SEQ();
        SEQ249.text = "/PME";
        SEQ249.AT_WORD_START = "TRUE";
        SEQ249.TYPE = "KEYWORD1";
        SEQ SEQ250 = new SEQ();
        SEQ250.text = "/PMORE";
        SEQ250.AT_WORD_START = "TRUE";
        SEQ250.TYPE = "KEYWORD1";
        SEQ SEQ251 = new SEQ();
        SEQ251.text = "/PMO";
        SEQ251.AT_WORD_START = "TRUE";
        SEQ251.TYPE = "KEYWORD1";
        SEQ SEQ252 = new SEQ();
        SEQ252.text = "/PNUM";
        SEQ252.AT_WORD_START = "TRUE";
        SEQ252.TYPE = "KEYWORD1";
        SEQ SEQ253 = new SEQ();
        SEQ253.text = "/PNU";
        SEQ253.AT_WORD_START = "TRUE";
        SEQ253.TYPE = "KEYWORD1";
        SEQ SEQ254 = new SEQ();
        SEQ254.text = "/POLYGON";
        SEQ254.AT_WORD_START = "TRUE";
        SEQ254.TYPE = "KEYWORD1";
        SEQ SEQ255 = new SEQ();
        SEQ255.text = "/POL";
        SEQ255.AT_WORD_START = "TRUE";
        SEQ255.TYPE = "KEYWORD1";
        SEQ SEQ256 = new SEQ();
        SEQ256.text = "/POST26";
        SEQ256.AT_WORD_START = "TRUE";
        SEQ256.TYPE = "KEYWORD1";
        SEQ SEQ257 = new SEQ();
        SEQ257.text = "/POST1";
        SEQ257.AT_WORD_START = "TRUE";
        SEQ257.TYPE = "KEYWORD1";
        SEQ SEQ258 = new SEQ();
        SEQ258.text = "/POS";
        SEQ258.AT_WORD_START = "TRUE";
        SEQ258.TYPE = "KEYWORD1";
        SEQ SEQ259 = new SEQ();
        SEQ259.text = "/PREP7";
        SEQ259.AT_WORD_START = "TRUE";
        SEQ259.TYPE = "KEYWORD1";
        SEQ SEQ260 = new SEQ();
        SEQ260.text = "/PRE";
        SEQ260.AT_WORD_START = "TRUE";
        SEQ260.TYPE = "KEYWORD1";
        SEQ SEQ261 = new SEQ();
        SEQ261.text = "/PSEARCH";
        SEQ261.AT_WORD_START = "TRUE";
        SEQ261.TYPE = "KEYWORD1";
        SEQ SEQ262 = new SEQ();
        SEQ262.text = "/PSE";
        SEQ262.AT_WORD_START = "TRUE";
        SEQ262.TYPE = "KEYWORD1";
        SEQ SEQ263 = new SEQ();
        SEQ263.text = "/PSF";
        SEQ263.AT_WORD_START = "TRUE";
        SEQ263.TYPE = "KEYWORD1";
        SEQ SEQ264 = new SEQ();
        SEQ264.text = "/PSPEC";
        SEQ264.AT_WORD_START = "TRUE";
        SEQ264.TYPE = "KEYWORD1";
        SEQ SEQ265 = new SEQ();
        SEQ265.text = "/PSP";
        SEQ265.AT_WORD_START = "TRUE";
        SEQ265.TYPE = "KEYWORD1";
        SEQ SEQ266 = new SEQ();
        SEQ266.text = "/PSTATUS";
        SEQ266.AT_WORD_START = "TRUE";
        SEQ266.TYPE = "KEYWORD1";
        SEQ SEQ267 = new SEQ();
        SEQ267.text = "/PST";
        SEQ267.AT_WORD_START = "TRUE";
        SEQ267.TYPE = "KEYWORD1";
        SEQ SEQ268 = new SEQ();
        SEQ268.text = "/PSYMB";
        SEQ268.AT_WORD_START = "TRUE";
        SEQ268.TYPE = "KEYWORD1";
        SEQ SEQ269 = new SEQ();
        SEQ269.text = "/PSY";
        SEQ269.AT_WORD_START = "TRUE";
        SEQ269.TYPE = "KEYWORD1";
        SEQ SEQ270 = new SEQ();
        SEQ270.text = "/PWEDGE";
        SEQ270.AT_WORD_START = "TRUE";
        SEQ270.TYPE = "KEYWORD1";
        SEQ SEQ271 = new SEQ();
        SEQ271.text = "/PWE";
        SEQ271.AT_WORD_START = "TRUE";
        SEQ271.TYPE = "KEYWORD1";
        SEQ SEQ272 = new SEQ();
        SEQ272.text = "/QUIT";
        SEQ272.AT_WORD_START = "TRUE";
        SEQ272.TYPE = "KEYWORD1";
        SEQ SEQ273 = new SEQ();
        SEQ273.text = "/QUI";
        SEQ273.AT_WORD_START = "TRUE";
        SEQ273.TYPE = "KEYWORD1";
        SEQ SEQ274 = new SEQ();
        SEQ274.text = "/RATIO";
        SEQ274.AT_WORD_START = "TRUE";
        SEQ274.TYPE = "KEYWORD1";
        SEQ SEQ275 = new SEQ();
        SEQ275.text = "/RAT";
        SEQ275.AT_WORD_START = "TRUE";
        SEQ275.TYPE = "KEYWORD1";
        SEQ SEQ276 = new SEQ();
        SEQ276.text = "/RENAME";
        SEQ276.AT_WORD_START = "TRUE";
        SEQ276.TYPE = "KEYWORD1";
        SEQ SEQ277 = new SEQ();
        SEQ277.text = "/REN";
        SEQ277.AT_WORD_START = "TRUE";
        SEQ277.TYPE = "KEYWORD1";
        SEQ SEQ278 = new SEQ();
        SEQ278.text = "/REPLOT";
        SEQ278.AT_WORD_START = "TRUE";
        SEQ278.TYPE = "KEYWORD1";
        SEQ SEQ279 = new SEQ();
        SEQ279.text = "/REP";
        SEQ279.AT_WORD_START = "TRUE";
        SEQ279.TYPE = "KEYWORD1";
        SEQ SEQ280 = new SEQ();
        SEQ280.text = "/RESET";
        SEQ280.AT_WORD_START = "TRUE";
        SEQ280.TYPE = "KEYWORD1";
        SEQ SEQ281 = new SEQ();
        SEQ281.text = "/RES";
        SEQ281.AT_WORD_START = "TRUE";
        SEQ281.TYPE = "KEYWORD1";
        SEQ SEQ282 = new SEQ();
        SEQ282.text = "/RGB";
        SEQ282.AT_WORD_START = "TRUE";
        SEQ282.TYPE = "KEYWORD1";
        SEQ SEQ283 = new SEQ();
        SEQ283.text = "/RUNST";
        SEQ283.AT_WORD_START = "TRUE";
        SEQ283.TYPE = "KEYWORD1";
        SEQ SEQ284 = new SEQ();
        SEQ284.text = "/RUN";
        SEQ284.AT_WORD_START = "TRUE";
        SEQ284.TYPE = "KEYWORD1";
        SEQ SEQ285 = new SEQ();
        SEQ285.text = "/SECLIB";
        SEQ285.AT_WORD_START = "TRUE";
        SEQ285.TYPE = "KEYWORD1";
        SEQ SEQ286 = new SEQ();
        SEQ286.text = "/SEC";
        SEQ286.AT_WORD_START = "TRUE";
        SEQ286.TYPE = "KEYWORD1";
        SEQ SEQ287 = new SEQ();
        SEQ287.text = "/SEG";
        SEQ287.AT_WORD_START = "TRUE";
        SEQ287.TYPE = "KEYWORD1";
        SEQ SEQ288 = new SEQ();
        SEQ288.text = "/SHADE";
        SEQ288.AT_WORD_START = "TRUE";
        SEQ288.TYPE = "KEYWORD1";
        SEQ SEQ289 = new SEQ();
        SEQ289.text = "/SHA";
        SEQ289.AT_WORD_START = "TRUE";
        SEQ289.TYPE = "KEYWORD1";
        SEQ SEQ290 = new SEQ();
        SEQ290.text = "/SHOWDISP";
        SEQ290.AT_WORD_START = "TRUE";
        SEQ290.TYPE = "KEYWORD1";
        SEQ SEQ291 = new SEQ();
        SEQ291.text = "/SHOW";
        SEQ291.AT_WORD_START = "TRUE";
        SEQ291.TYPE = "KEYWORD1";
        SEQ SEQ292 = new SEQ();
        SEQ292.text = "/SHO";
        SEQ292.AT_WORD_START = "TRUE";
        SEQ292.TYPE = "KEYWORD1";
        SEQ SEQ293 = new SEQ();
        SEQ293.text = "/SHRINK";
        SEQ293.AT_WORD_START = "TRUE";
        SEQ293.TYPE = "KEYWORD1";
        SEQ SEQ294 = new SEQ();
        SEQ294.text = "/SHR";
        SEQ294.AT_WORD_START = "TRUE";
        SEQ294.TYPE = "KEYWORD1";
        SEQ SEQ295 = new SEQ();
        SEQ295.text = "/SOLU";
        SEQ295.AT_WORD_START = "TRUE";
        SEQ295.TYPE = "KEYWORD1";
        SEQ SEQ296 = new SEQ();
        SEQ296.text = "/SOL";
        SEQ296.AT_WORD_START = "TRUE";
        SEQ296.TYPE = "KEYWORD1";
        SEQ SEQ297 = new SEQ();
        SEQ297.text = "/SSCALE";
        SEQ297.AT_WORD_START = "TRUE";
        SEQ297.TYPE = "KEYWORD1";
        SEQ SEQ298 = new SEQ();
        SEQ298.text = "/SSC";
        SEQ298.AT_WORD_START = "TRUE";
        SEQ298.TYPE = "KEYWORD1";
        SEQ SEQ299 = new SEQ();
        SEQ299.text = "/STATUS";
        SEQ299.AT_WORD_START = "TRUE";
        SEQ299.TYPE = "KEYWORD1";
        SEQ SEQ300 = new SEQ();
        SEQ300.text = "/STA";
        SEQ300.AT_WORD_START = "TRUE";
        SEQ300.TYPE = "KEYWORD1";
        SEQ SEQ301 = new SEQ();
        SEQ301.text = "/STITLE";
        SEQ301.AT_WORD_START = "TRUE";
        SEQ301.TYPE = "KEYWORD1";
        SEQ SEQ302 = new SEQ();
        SEQ302.text = "/STI";
        SEQ302.AT_WORD_START = "TRUE";
        SEQ302.TYPE = "KEYWORD1";
        SEQ SEQ303 = new SEQ();
        SEQ303.text = "/SYP";
        SEQ303.AT_WORD_START = "TRUE";
        SEQ303.TYPE = "KEYWORD1";
        SEQ SEQ304 = new SEQ();
        SEQ304.text = "/SYS";
        SEQ304.AT_WORD_START = "TRUE";
        SEQ304.TYPE = "KEYWORD1";
        SEQ SEQ305 = new SEQ();
        SEQ305.text = "/TITLE";
        SEQ305.AT_WORD_START = "TRUE";
        SEQ305.TYPE = "KEYWORD1";
        SEQ SEQ306 = new SEQ();
        SEQ306.text = "/TIT";
        SEQ306.AT_WORD_START = "TRUE";
        SEQ306.TYPE = "KEYWORD1";
        SEQ SEQ307 = new SEQ();
        SEQ307.text = "/TLABEL";
        SEQ307.AT_WORD_START = "TRUE";
        SEQ307.TYPE = "KEYWORD1";
        SEQ SEQ308 = new SEQ();
        SEQ308.text = "/TLA";
        SEQ308.AT_WORD_START = "TRUE";
        SEQ308.TYPE = "KEYWORD1";
        SEQ SEQ309 = new SEQ();
        SEQ309.text = "/TRIAD";
        SEQ309.AT_WORD_START = "TRUE";
        SEQ309.TYPE = "KEYWORD1";
        SEQ SEQ310 = new SEQ();
        SEQ310.text = "/TRI";
        SEQ310.AT_WORD_START = "TRUE";
        SEQ310.TYPE = "KEYWORD1";
        SEQ SEQ311 = new SEQ();
        SEQ311.text = "/TRLCY";
        SEQ311.AT_WORD_START = "TRUE";
        SEQ311.TYPE = "KEYWORD1";
        SEQ SEQ312 = new SEQ();
        SEQ312.text = "/TRL";
        SEQ312.AT_WORD_START = "TRUE";
        SEQ312.TYPE = "KEYWORD1";
        SEQ SEQ313 = new SEQ();
        SEQ313.text = "/TSPEC";
        SEQ313.AT_WORD_START = "TRUE";
        SEQ313.TYPE = "KEYWORD1";
        SEQ SEQ314 = new SEQ();
        SEQ314.text = "/TSP";
        SEQ314.AT_WORD_START = "TRUE";
        SEQ314.TYPE = "KEYWORD1";
        SEQ SEQ315 = new SEQ();
        SEQ315.text = "/TYPE";
        SEQ315.AT_WORD_START = "TRUE";
        SEQ315.TYPE = "KEYWORD1";
        SEQ SEQ316 = new SEQ();
        SEQ316.text = "/TYP";
        SEQ316.AT_WORD_START = "TRUE";
        SEQ316.TYPE = "KEYWORD1";
        SEQ SEQ317 = new SEQ();
        SEQ317.text = "/UCMD";
        SEQ317.AT_WORD_START = "TRUE";
        SEQ317.TYPE = "KEYWORD1";
        SEQ SEQ318 = new SEQ();
        SEQ318.text = "/UCM";
        SEQ318.AT_WORD_START = "TRUE";
        SEQ318.TYPE = "KEYWORD1";
        SEQ SEQ319 = new SEQ();
        SEQ319.text = "/UIS";
        SEQ319.AT_WORD_START = "TRUE";
        SEQ319.TYPE = "KEYWORD1";
        SEQ SEQ320 = new SEQ();
        SEQ320.text = "/UI";
        SEQ320.AT_WORD_START = "TRUE";
        SEQ320.TYPE = "KEYWORD1";
        SEQ SEQ321 = new SEQ();
        SEQ321.text = "/UNITS";
        SEQ321.AT_WORD_START = "TRUE";
        SEQ321.TYPE = "KEYWORD1";
        SEQ SEQ322 = new SEQ();
        SEQ322.text = "/UNI";
        SEQ322.AT_WORD_START = "TRUE";
        SEQ322.TYPE = "KEYWORD1";
        SEQ SEQ323 = new SEQ();
        SEQ323.text = "/USER";
        SEQ323.AT_WORD_START = "TRUE";
        SEQ323.TYPE = "KEYWORD1";
        SEQ SEQ324 = new SEQ();
        SEQ324.text = "/USE";
        SEQ324.AT_WORD_START = "TRUE";
        SEQ324.TYPE = "KEYWORD1";
        SEQ SEQ325 = new SEQ();
        SEQ325.text = "/VCONE";
        SEQ325.AT_WORD_START = "TRUE";
        SEQ325.TYPE = "KEYWORD1";
        SEQ SEQ326 = new SEQ();
        SEQ326.text = "/VCO";
        SEQ326.AT_WORD_START = "TRUE";
        SEQ326.TYPE = "KEYWORD1";
        SEQ SEQ327 = new SEQ();
        SEQ327.text = "/VIEW";
        SEQ327.AT_WORD_START = "TRUE";
        SEQ327.TYPE = "KEYWORD1";
        SEQ SEQ328 = new SEQ();
        SEQ328.text = "/VIE";
        SEQ328.AT_WORD_START = "TRUE";
        SEQ328.TYPE = "KEYWORD1";
        SEQ SEQ329 = new SEQ();
        SEQ329.text = "/VSCALE";
        SEQ329.AT_WORD_START = "TRUE";
        SEQ329.TYPE = "KEYWORD1";
        SEQ SEQ330 = new SEQ();
        SEQ330.text = "/VSC";
        SEQ330.AT_WORD_START = "TRUE";
        SEQ330.TYPE = "KEYWORD1";
        SEQ SEQ331 = new SEQ();
        SEQ331.text = "/VUP";
        SEQ331.AT_WORD_START = "TRUE";
        SEQ331.TYPE = "KEYWORD1";
        SEQ SEQ332 = new SEQ();
        SEQ332.text = "/WAIT";
        SEQ332.AT_WORD_START = "TRUE";
        SEQ332.TYPE = "KEYWORD1";
        SEQ SEQ333 = new SEQ();
        SEQ333.text = "/WAI";
        SEQ333.AT_WORD_START = "TRUE";
        SEQ333.TYPE = "KEYWORD1";
        SEQ SEQ334 = new SEQ();
        SEQ334.text = "/WINDOW";
        SEQ334.AT_WORD_START = "TRUE";
        SEQ334.TYPE = "KEYWORD1";
        SEQ SEQ335 = new SEQ();
        SEQ335.text = "/WIN";
        SEQ335.AT_WORD_START = "TRUE";
        SEQ335.TYPE = "KEYWORD1";
        SEQ SEQ336 = new SEQ();
        SEQ336.text = "/XRANGE";
        SEQ336.AT_WORD_START = "TRUE";
        SEQ336.TYPE = "KEYWORD1";
        SEQ SEQ337 = new SEQ();
        SEQ337.text = "/XRA";
        SEQ337.AT_WORD_START = "TRUE";
        SEQ337.TYPE = "KEYWORD1";
        SEQ SEQ338 = new SEQ();
        SEQ338.text = "/YRANGE";
        SEQ338.AT_WORD_START = "TRUE";
        SEQ338.TYPE = "KEYWORD1";
        SEQ SEQ339 = new SEQ();
        SEQ339.text = "/YRA";
        SEQ339.AT_WORD_START = "TRUE";
        SEQ339.TYPE = "KEYWORD1";
        SEQ SEQ340 = new SEQ();
        SEQ340.text = "/ZOOM";
        SEQ340.AT_WORD_START = "TRUE";
        SEQ340.TYPE = "KEYWORD1";
        SEQ SEQ341 = new SEQ();
        SEQ341.text = "/ZOO";
        SEQ341.AT_WORD_START = "TRUE";
        SEQ341.TYPE = "KEYWORD1";
        SEQ SEQ342 = new SEQ();
        SEQ342.text = "+";
        SEQ342.TYPE = "OPERATOR";
        SEQ SEQ343 = new SEQ();
        SEQ343.text = "-";
        SEQ343.TYPE = "OPERATOR";
        SEQ SEQ344 = new SEQ();
        SEQ344.text = "$";
        SEQ344.TYPE = "OPERATOR";
        SEQ SEQ345 = new SEQ();
        SEQ345.text = "=";
        SEQ345.TYPE = "OPERATOR";
        SEQ SEQ346 = new SEQ();
        SEQ346.text = "(";
        SEQ346.TYPE = "OPERATOR";
        SEQ SEQ347 = new SEQ();
        SEQ347.text = ")";
        SEQ347.TYPE = "OPERATOR";
        SEQ SEQ348 = new SEQ();
        SEQ348.text = ",";
        SEQ348.TYPE = "OPERATOR";
        SEQ SEQ349 = new SEQ();
        SEQ349.text = ";";
        SEQ349.TYPE = "NULL";
        SEQ SEQ350 = new SEQ();
        SEQ350.text = "*";
        SEQ350.TYPE = "OPERATOR";
        SEQ SEQ351 = new SEQ();
        SEQ351.text = "/";
        SEQ351.TYPE = "OPERATOR";
        SEQ SEQ352 = new SEQ();
        SEQ352.text = "%C";
        SEQ352.TYPE = "KEYWORD2";
        SEQ SEQ353 = new SEQ();
        SEQ353.text = "%G";
        SEQ353.TYPE = "KEYWORD2";
        SEQ SEQ354 = new SEQ();
        SEQ354.text = "%I";
        SEQ354.TYPE = "KEYWORD2";
        SEQ SEQ355 = new SEQ();
        SEQ355.text = "%/";
        SEQ355.TYPE = "KEYWORD2";
        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "FUNCTION";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "%";
        END END2 = new END();
        END2.text = "%";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"A", "AADD", "AADD", "AATT", "AATT", "ABBR", "ABBRES", "ABBS", "ABBSAV", "ABS", "ACCA", "ACCAT", "ACEL", "ACEL", "ACLE", "ACLEAR", "ADAP", "ADAPT", "ADD", "ADDA", "ADDAM", "ADEL", "ADELE", "ADGL", "ADGL", "ADRA", "ADRAG", "AFIL", "AFILLT", "AFLI", "AFLIST", "AFSU", "AFSURF", "AGEN", "AGEN", "AGLU", "AGLUE", "AINA", "AINA", "AINP", "AINP", "AINV", "AINV", "AL", "ALIS", "ALIST", "ALLS", "ALLSEL", "ALPF", "ALPFILL", "ALPH", "ALPHAD", "AMAP", "AMAP", "AMES", "AMESH", "ANCN", "ANCNTR", "ANCU", "ANCUT", "ANDA", "ANDATA", "ANDS", "ANDSCL", "ANDY", "ANDYNA", "ANFL", "ANFLOW", "ANIM", "ANIM", "ANIS", "ANISOS", "ANMO", "ANMODE", "ANOR", "ANORM", "ANTI", "ANTIME", "ANTY", "ANTYPE", "AOFF", "AOFFST", "AOVL", "AOVLAP", "APLO", "APLOT", "APPE", "APPEND", "APTN", "APTN", "ARCL", "ARCLEN", "ARCO", "ARCOLLAPSE", "ARCT", "ARCTRM", "ARDE", "ARDETACH", "AREA", "AREAS", "AREF", "AREFINE", "AREV", "AREVERSE", "ARFI", "ARFILL", "ARME", "ARMERGE", "AROT", "AROTAT", "ARSC", "ARSCALE", "ARSP", "ARSPLIT", "ARSY", "ARSYM", "ASBA", "ASBA", "ASBL", "ASBL", "ASBV", "ASBV", "ASBW", "ASBW", "ASEL", "ASEL", "ASKI", "ASKIN", "ASLL", "ASLL", "ASLV", "ASLV", "ASUB", "ASUB", "ASUM", "ASUM", "ATAN", "ATAN", "ATRA", "ATRAN", "ATYP", "ATYPE", "AUTO", "AUTOTS", "AVPR", "AVPRIN", "AVRE", "AVRES", "BELL", "BELLOW", "BEND", "BEND", "BETA", "BETAD", "BF", "BFA", "BFAD", "BFADELE", "BFAL", "BFALIST", "BFCU", "BFCUM", "BFDE", "BFDELE", "BFE", "BFEC", "BFECUM", "BFED", "BFEDELE", "BFEL", "BFELIST", "BFES", "BFESCAL", "BFIN", "BFINT", "BFK", "BFKD", "BFKDELE", "BFKL", "BFKLIST", "BFL", "BFLD", "BFLDELE", "BFLI", "BFLIST", "BFLL", "BFLLIST", "BFSC", "BFSCALE", "BFTR", "BFTRAN", "BFUN", "BFUNIF", "BFV", "BFVD", "BFVDELE", "BFVL", "BFVLIST", "BIOO", "BIOOPT", "BIOT", "BIOT", "BLC4", "BLC4", "BLC5", "BLC5", "BLOC", "BLOCK", "BOOL", "BOOL", "BOPT", "BOPTN", "BRAN", "BRANCH", "BSPL", "BSPLIN", "BTOL", "BTOL", "BUCO", "BUCOPT", "CALC", "CALC", "CBDO", "CBDOF", "CDRE", "CDREAD", "CDWR", "CDWRITE", "CE", "CECM", "CECMOD", "CECY", "CECYC", "CEDE", "CEDELE", "CEIN", "CEINTF", "CELI", "CELIST", "CENT", "CENTER", "CEQN", "CEQN", "CERI", "CERIG", "CESG", "CESGEN", "CFAC", "CFACT", "CGLO", "CGLOC", "CGOM", "CGOMGA", "CHEC", "CHECK", "CHKM", "CHKMSH", "CIRC", "CIRCLE", "CLOC", "CLOCAL", "CLOG", "CLOG", "CLRM", "CLRMSHLN", "CM", "CMDE", "CMDELE", "CMED", "CMEDIT", "CMGR", "CMGRP", "CMLI", "CMLIST", "CMPL", "CMPLOT", "CMSE", "CMSEL", "CNVT", "CNVTOL", "CON4", "CON4", "CONE", "CONE", "CONJ", "CONJUG", "COUP", "COUPLE", "COVA", "COVAL", "CP", "CPDE", "CPDELE", "CPIN", "CPINTF", "CPLG", "CPLGEN", "CPLI", "CPLIST", "CPNG", "CPNGEN", "CPSG", "CPSGEN", "CQC", "CRPL", "CRPLIM", "CS", "CSCI", "CSCIR", "CSDE", "CSDELE", "CSKP", "CSKP", "CSLI", "CSLIST", "CSWP", "CSWPLA", "CSYS", "CSYS", "CURR2D", "CURR", "CUTC", "CUTCONTROL", "CVAR", "CVAR", "CYCG", "CYCGEN", "CYCS", "CYCSOL", "CYL4", "CYL4", "CYL5", "CYL5", "CYLI", "CYLIND", "D", "DA", "DADE", "DADELE", "DALI", "DALIST", "DATA", "DATA", "DATA", "DATADEF", "DCGO", "DCGOMG", "DCUM", "DCUM", "DDEL", "DDELE", "DEAC", "DEACT", "DEFI", "DEFINE", "DELT", "DELTIM", "DERI", "DERIV", "DESI", "DESIZE", "DESO", "DESOL", "DETA", "DETAB", "DIG", "DIGI", "DIGIT", "DISP", "DISPLAY", "DK", "DKDE", "DKDELE", "DKLI", "DKLIST", "DL", "DLDE", "DLDELE", "DLIS", "DLIST", "DLLI", "DLLIST", "DMOV", "DMOVE", "DMPR", "DMPRAT", "DNSO", "DNSOL", "DOF", "DOFS", "DOFSEL", "DOME", "DOMEGA", "DSCA", "DSCALE", "DSET", "DSET", "DSUM", "DSUM", "DSUR", "DSURF", "DSYM", "DSYM", "DSYS", "DSYS", "DTRA", "DTRAN", "DUMP", "DUMP", "DYNO", "DYNOPT", "E", "EALI", "EALIVE", "EDBO", "EDBOUND", "EDBV", "EDBVIS", "EDCD", "EDCDELE", "EDCG", "EDCGEN", "EDCL", "EDCLIST", "EDCO", "EDCONTACT", "EDCP", "EDCPU", "EDCR", "EDCRB", "EDCS", "EDCSC", "EDCT", "EDCTS", "EDCU", "EDCURVE", "EDDA", "EDDAMP", "EDDR", "EDDRELAX", "EDEL", "EDELE", "EDEN", "EDENERGY", "EDFP", "EDFPLOT", "EDHG", "EDHGLS", "EDHI", "EDHIST", "EDHT", "EDHTIME", "EDIN", "EDINT", "EDIV", "EDIVELO", "EDLC", "EDLCS", "EDLD", "EDLDPLOT", "EDLO", "EDLOAD", "EDMP", "EDMP", "EDND", "EDNDTSD", "EDNR", "EDNROT", "EDOP", "EDOPT", "EDOU", "EDOUT", "EDRE", "EDREAD", "EDRS", "EDRST", "EDSH", "EDSHELL", "EDSO", "EDSOLV", "EDST", "EDSTART", "EDWE", "EDWELD", "EDWR", "EDWRITE", "EGEN", "EGEN", "EINT", "EINTF", "EKIL", "EKILL", "ELEM", "ELEM", "ELIS", "ELIST", "EMAG", "EMAGERR", "EMF", "EMID", "EMID", "EMIS", "EMIS", "EMOD", "EMODIF", "EMOR", "EMORE", "EMSY", "EMSYM", "EMUN", "EMUNIT", "EN", "ENGE", "ENGEN", "ENOR", "ENORM", "ENSY", "ENSYM", "EPLO", "EPLOT", "EQSL", "EQSLV", "ERAS", "ERASE", "EREA", "EREAD", "EREF", "EREFINE", "ERES", "ERESX", "ERNO", "ERNORM", "ERRA", "ERRANG", "ESEL", "ESEL", "ESIZ", "ESIZE", "ESLA", "ESLA", "ESLL", "ESLL", "ESLN", "ESLN", "ESLV", "ESLV", "ESOL", "ESOL", "ESOR", "ESORT", "ESTI", "ESTIF", "ESUR", "ESURF", "ESYM", "ESYM", "ESYS", "ESYS", "ET", "ETAB", "ETABLE", "ETCH", "ETCHG", "ETDE", "ETDELE", "ETLI", "ETLIST", "ETYP", "ETYPE", "EUSO", "EUSORT", "EWRI", "EWRITE", "EXP", "EXPA", "EXPA", "EXPAND", "EXPASS", "EXPS", "EXPSOL", "EXTO", "EXTOPT", "EXTR", "EXTREM", "FATI", "FATIGUE", "FCUM", "FCUM", "FDEL", "FDELE", "FE", "FEBO", "FEBODY", "FECO", "FECONS", "FEFO", "FEFOR", "FELI", "FELIST", "FESU", "FESURF", "FILE", "FILE", "FILE", "FILE", "FILEAUX2", "FILEDISP", "FILL", "FILL", "FILL", "FILLDATA", "FINI", "FINISH", "FITE", "FITEM", "FK", "FKDE", "FKDELE", "FKLI", "FKLIST", "FL", "FLAN", "FLANGE", "FLDA", "FLDATA", "FLDATA10", "FLDATA11", "FLDATA12", "FLDATA13", "FLDATA14", "FLDATA15", "FLDATA16", "FLDATA17", "FLDATA18", "FLDATA19", "FLDATA1", "FLDATA20", "FLDATA20A", "FLDATA21", "FLDATA22", "FLDATA23", "FLDATA24", "FLDATA24A", "FLDATA24B", "FLDATA24C", "FLDATA24D", "FLDATA25", "FLDATA26", "FLDATA27", "FLDATA28", "FLDATA29", "FLDATA2", "FLDATA30", "FLDATA31", "FLDATA32", "FLDATA33", "FLDATA37", "FLDATA3", "FLDATA4", "FLDATA4A", "FLDATA5", "FLDATA6", "FLDATA7", "FLDATA8", "FLDATA9", "FLDATA", "FLIS", "FLIST", "FLLI", "FLLIST", "FLOC", "FLOCHECK", "FLOT", "FLOTRAN", "FLRE", "FLREAD", "FLST", "FLST", "FLUX", "FLUXV", "FMAG", "FMAG", "FMAGBC", "FMAGSUM", "FOR2", "FOR2D", "FORC", "FORCE", "FORM", "FORM", "FP", "FPLI", "FPLIST", "FREQ", "FREQ", "FS", "FSCA", "FSCALE", "FSDE", "FSDELE", "FSLI", "FSLIST", "FSNO", "FSNODE", "FSPL", "FSPLOT", "FSSE", "FSSECT", "FSUM", "FSUM", "FTCA", "FTCALC", "FTRA", "FTRAN", "FTSI", "FTSIZE", "FTWR", "FTWRITE", "FVME", "FVMESH", "GAP", "GAPF", "GAPFINISH", "GAPL", "GAPLIST", "GAPM", "GAPMERGE", "GAPO", "GAPOPT", "GAPP", "GAPPLOT", "GAUG", "GAUGE", "GCGE", "GCGEN", "GENO", "GENOPT", "GEOM", "GEOM", "GEOM", "GEOMETRY", "GP", "GPDE", "GPDELE", "GPLI", "GPLIST", "GPLO", "GPLOT", "GRP", "GSUM", "GSUM", "HARF", "HARFRQ", "HELP", "HELP", "HELP", "HELPDISP", "HFSW", "HFSWEEP", "HMAG", "HMAGSOLV", "HPGL", "HPGL", "HPTC", "HPTCREATE", "HPTD", "HPTDELETE", "HRCP", "HRCPLX", "HREX", "HREXP", "HROP", "HROPT", "HROU", "HROUT", "IC", "ICDE", "ICDELE", "ICLI", "ICLIST", "IGES", "IGES", "IGESIN", "IGESOUT", "IMAG", "IMAGIN", "IMME", "IMMED", "IMPD", "IMPD", "INRE", "INRES", "INRT", "INRTIA", "INT1", "INT1", "INTS", "INTSRF", "IOPT", "IOPTN", "IRLF", "IRLF", "IRLI", "IRLIST", "K", "KATT", "KATT", "KBC", "KBET", "KBETW", "KCAL", "KCALC", "KCEN", "KCENTER", "KCLE", "KCLEAR", "KDEL", "KDELE", "KDIS", "KDIST", "KESI", "KESIZE", "KEYO", "KEYOPT", "KEYP", "KEYPTS", "KEYW", "KEYW", "KFIL", "KFILL", "KGEN", "KGEN", "KL", "KLIS", "KLIST", "KMES", "KMESH", "KMOD", "KMODIF", "KMOV", "KMOVE", "KNOD", "KNODE", "KPLO", "KPLOT", "KPSC", "KPSCALE", "KREF", "KREFINE", "KSCA", "KSCALE", "KSCO", "KSCON", "KSEL", "KSEL", "KSLL", "KSLL", "KSLN", "KSLN", "KSUM", "KSUM", "KSYM", "KSYMM", "KTRA", "KTRAN", "KUSE", "KUSE", "KWPA", "KWPAVE", "KWPL", "KWPLAN", "L2AN", "L2ANG", "L2TA", "L2TAN", "L", "LANG", "LANG", "LARC", "LARC", "LARE", "LAREA", "LARG", "LARGE", "LATT", "LATT", "LAYE", "LAYE", "LAYER", "LAYERP26", "LAYL", "LAYLIST", "LAYP", "LAYPLOT", "LCAB", "LCABS", "LCAS", "LCASE", "LCCA", "LCCA", "LCCALC", "LCCAT", "LCDE", "LCDEF", "LCFA", "LCFACT", "LCFI", "LCFILE", "LCLE", "LCLEAR", "LCOM", "LCOMB", "LCOP", "LCOPER", "LCSE", "LCSEL", "LCSL", "LCSL", "LCSU", "LCSUM", "LCWR", "LCWRITE", "LCZE", "LCZERO", "LDEL", "LDELE", "LDIV", "LDIV", "LDRA", "LDRAG", "LDRE", "LDREAD", "LESI", "LESIZE", "LEXT", "LEXTND", "LFIL", "LFILLT", "LFSU", "LFSURF", "LGEN", "LGEN", "LGLU", "LGLUE", "LGWR", "LGWRITE", "LINA", "LINA", "LINE", "LINE", "LINE", "LINES", "LINL", "LINL", "LINP", "LINP", "LINV", "LINV", "LLIS", "LLIST", "LMAT", "LMATRIX", "LMES", "LMESH", "LNCO", "LNCOLLAPSE", "LNDE", "LNDETACH", "LNFI", "LNFILL", "LNME", "LNMERGE", "LNSP", "LNSPLIT", "LNSR", "LNSRCH", "LOCA", "LOCAL", "LOVL", "LOVLAP", "LPLO", "LPLOT", "LPTN", "LPTN", "LREF", "LREFINE", "LREV", "LREVERSE", "LROT", "LROTAT", "LSBA", "LSBA", "LSBL", "LSBL", "LSBV", "LSBV", "LSBW", "LSBW", "LSCL", "LSCLEAR", "LSDE", "LSDELE", "LSEL", "LSEL", "LSLA", "LSLA", "LSLK", "LSLK", "LSOP", "LSOPER", "LSRE", "LSREAD", "LSSC", "LSSCALE", "LSSO", "LSSOLVE", "LSTR", "LSTR", "LSUM", "LSUM", "LSWR", "LSWRITE", "LSYM", "LSYMM", "LTAN", "LTAN", "LTRA", "LTRAN", "LUMP", "LUMPM", "LVSC", "LVSCALE", "LWPL", "LWPLAN", "M", "MAGO", "MAGOPT", "MAGS", "MAGSOLV", "MAST", "MASTER", "MAT", "MATE", "MATER", "MDAM", "MDAMP", "MDEL", "MDELE", "MESH", "MESHING", "MGEN", "MGEN", "MITE", "MITER", "MLIS", "MLIST", "MMF", "MODE", "MODE", "MODM", "MODMSH", "MODO", "MODOPT", "MONI", "MONITOR", "MOPT", "MOPT", "MOVE", "MOVE", "MP", "MPAM", "MPAMOD", "MPCH", "MPCHG", "MPDA", "MPDATA", "MPDE", "MPDELE", "MPDR", "MPDRES", "MPLI", "MPLIST", "MPMO", "MPMOD", "MPPL", "MPPLOT", "MPRE", "MPREAD", "MPRI", "MPRINT", "MPTE", "MPTEMP", "MPTG", "MPTGEN", "MPTR", "MPTRES", "MPUN", "MPUNDO", "MPWR", "MPWRITE", "MSAD", "MSADV", "MSCA", "MSCAP", "MSDA", "MSDATA", "MSHA", "MSHAPE", "MSHK", "MSHKEY", "MSHM", "MSHMID", "MSHP", "MSHPATTERN", "MSME", "MSMETH", "MSNO", "MSNOMF", "MSPR", "MSPROP", "MSQU", "MSQUAD", "MSRE", "MSRELAX", "MSSO", "MSSOLU", "MSSP", "MSSPEC", "MSTE", "MSTERM", "MSVA", "MSVARY", "MXPA", "MXPAND", "N", "NANG", "NANG", "NCNV", "NCNV", "NDEL", "NDELE", "NDIS", "NDIST", "NEQI", "NEQIT", "NFOR", "NFORCE", "NGEN", "NGEN", "NKPT", "NKPT", "NLGE", "NLGEOM", "NLIS", "NLIST", "NLOG", "NLOG", "NLOP", "NLOPT", "NMOD", "NMODIF", "NOCO", "NOCOLOR", "NODE", "NODES", "NOOR", "NOORDER", "NPLO", "NPLOT", "NPRI", "NPRINT", "NREA", "NREAD", "NREF", "NREFINE", "NRLS", "NRLSUM", "NROP", "NROPT", "NROT", "NROTAT", "NRRA", "NRRANG", "NSCA", "NSCALE", "NSEL", "NSEL", "NSLA", "NSLA", "NSLE", "NSLE", "NSLK", "NSLK", "NSLL", "NSLL", "NSLV", "NSLV", "NSOL", "NSOL", "NSOR", "NSORT", "NSTO", "NSTORE", "NSUB", "NSUBST", "NSVR", "NSVR", "NSYM", "NSYM", "NUMC", "NUMCMP", "NUME", "NUMEXP", "NUMM", "NUMMRG", "NUMO", "NUMOFF", "NUMS", "NUMSTR", "NUMV", "NUMVAR", "NUSO", "NUSORT", "NWPA", "NWPAVE", "NWPL", "NWPLAN", "NWRI", "NWRITE", "nx", "ny", "nz", "OMEG", "OMEGA", "OPAD", "OPADD", "OPAN", "OPANL", "OPCL", "OPCLR", "OPDA", "OPDATA", "OPDE", "OPDEL", "OPEQ", "OPEQN", "OPER", "OPERATE", "OPEX", "OPEXE", "OPFA", "OPFACT", "OPFR", "OPFRST", "OPGR", "OPGRAD", "OPKE", "OPKEEP", "OPLF", "OPLFA", "OPLG", "OPLGR", "OPLI", "OPLIST", "OPLO", "OPLOOP", "OPLS", "OPLSW", "OPMA", "OPMAKE", "OPNC", "OPNCONTROL", "OPPR", "OPPRNT", "OPRA", "OPRAND", "OPRE", "OPRESU", "OPRF", "OPRFA", "OPRG", "OPRGR", "OPRS", "OPRSW", "OPSA", "OPSAVE", "OPSE", "OPSEL", "OPSU", "OPSUBP", "OPSW", "OPSWEEP", "OPTY", "OPTYPE", "OPUS", "OPUSER", "OPVA", "OPVAR", "OUTO", "OUTOPT", "OUTP", "OUTPR", "OUTR", "OUTRES", "PADE", "PADELE", "PAGE", "PAGET", "PAPU", "PAPUT", "PARE", "PARESU", "PARR", "PARRES", "PARS", "PARSAV", "PASA", "PASAVE", "PATH", "PATH", "PCAL", "PCALC", "PCIR", "PCIRC", "PCON", "PCONV", "PCOR", "PCORRO", "PCRO", "PCROSS", "PDEF", "PDEF", "PDOT", "PDOT", "PDRA", "PDRAG", "PERB", "PERBC2D", "PEXC", "PEXCLUDE", "PFAC", "PFACT", "PFLU", "PFLUID", "PGAP", "PGAP", "PHYS", "PHYSICS", "PINC", "PINCLUDE", "PINS", "PINSUL", "PIPE", "PIPE", "PIVC", "PIVCHECK", "PLAN", "PLANEWAVE", "PLCO", "PLCONV", "PLCP", "PLCPLX", "PLCR", "PLCRACK", "PLDI", "PLDISP", "PLES", "PLESOL", "PLET", "PLETAB", "PLF2", "PLF2D", "PLLS", "PLLS", "PLNS", "PLNSOL", "PLOT", "PLOT", "PLOT", "PLOTTING", "PLPA", "PLPA", "PLPAGM", "PLPATH", "PLSE", "PLSECT", "PLTI", "PLTIME", "PLTR", "PLTRAC", "PLVA", "PLVA", "PLVAR", "PLVAROPT", "PLVE", "PLVECT", "PMAP", "PMAP", "PMET", "PMETH", "PMGT", "PMGTRAN", "PMOP", "PMOPTS", "POIN", "POINT", "POLY", "POLY", "POPT", "POPT", "PORT", "PORTOPT", "POWE", "POWERH", "PPAT", "PPATH", "PPLO", "PPLOT", "PPRA", "PPRANGE", "PPRE", "PPRES", "PRAN", "PRANGE", "PRCO", "PRCONV", "PRCP", "PRCPLX", "PREC", "PRECISION", "PRED", "PRED", "PRER", "PRERR", "PRES", "PRESOL", "PRET", "PRETAB", "PRI2", "PRI2", "PRIM", "PRIM", "PRIN", "PRINT", "PRIS", "PRISM", "PRIT", "PRITER", "PRNL", "PRNLD", "PRNS", "PRNSOL", "PROD", "PROD", "PRPA", "PRPATH", "PRRF", "PRRFOR", "PRRS", "PRRSOL", "PRSE", "PRSECT", "PRSS", "PRSSOL", "PRTI", "PRTIME", "PRVA", "PRVA", "PRVAR", "PRVAROPT", "PRVE", "PRVECT", "PSCR", "PSCR", "PSDC", "PSDCOM", "PSDF", "PSDFRQ", "PSDR", "PSDRES", "PSDS", "PSDSPL", "PSDU", "PSDUNIT", "PSDV", "PSDVAL", "PSDW", "PSDWAV", "PSEL", "PSEL", "PSOL", "PSOLVE", "PSPE", "PSPEC", "PSPR", "PSPRNG", "PSTR", "PSTRES", "PTEM", "PTEMP", "PTXY", "PTXY", "PUNI", "PUNIT", "PVEC", "PVECT", "QDVA", "QDVAL", "QFAC", "QFACT", "QUAD", "QUAD", "QUOT", "QUOT", "R", "RACE", "RACE", "RALL", "RALL", "RAPP", "RAPPND", "RBE3", "RBE3", "RCON", "RCON", "RDEL", "RDELE", "REAL", "REAL", "REAL", "REALVAR", "RECT", "RECTNG", "REDU", "REDUCE", "REFL", "REFLCOEF", "REOR", "REORDER", "RESE", "RESET", "RESP", "RESP", "RESU", "RESUME", "REXP", "REXPORT", "RFIL", "RFILSZ", "RFOR", "RFORCE", "RIGI", "RIGID", "RIMP", "RIMPORT", "RITE", "RITER", "RLIS", "RLIST", "RMEM", "RMEMRY", "RMOD", "RMODIF", "RMOR", "RMORE", "ROCK", "ROCK", "RPOL", "RPOLY", "RPR4", "RPR4", "RPRI", "RPRISM", "RPSD", "RPSD", "RSPE", "RSPEED", "RSTA", "RSTAT", "RSYS", "RSYS", "RTIM", "RTIMST", "RUN", "RWFR", "RWFRNT", "SABS", "SABS", "SADD", "SADD", "SALL", "SALLOW", "SARP", "SARPLOT", "SAVE", "SAVE", "SBCL", "SBCLIST", "SBCT", "SBCTRAN", "SDEL", "SDELETE", "SE", "SECD", "SECDATA", "SECN", "SECNUM", "SECO", "SECOFFSET", "SECP", "SECPLOT", "SECR", "SECREAD", "SECT", "SECTYPE", "SECW", "SECWRITE", "SED", "SEDL", "SEDLIST", "SEEX", "SEEXP", "SELI", "SELIST", "SELM", "SELM", "SENE", "SENERGY", "SEOP", "SEOPT", "SESY", "SESYMM", "SET", "SETR", "SETRAN", "SEXP", "SEXP", "SF", "SFA", "SFAC", "SFACT", "SFAD", "SFADELE", "SFAL", "SFALIST", "SFBE", "SFBEAM", "SFCA", "SFCALC", "SFCU", "SFCUM", "SFDE", "SFDELE", "SFE", "SFED", "SFEDELE", "SFEL", "SFELIST", "SFFU", "SFFUN", "SFGR", "SFGRAD", "SFL", "SFLD", "SFLDELE", "SFLI", "SFLIST", "SFLL", "SFLLIST", "SFSC", "SFSCALE", "SFTR", "SFTRAN", "SHEL", "SHELL", "SHPP", "SHPP", "SLIS", "SLIST", "SLPP", "SLPPLOT", "SLSP", "SLSPLOT", "SMAL", "SMALL", "SMAX", "SMAX", "SMBO", "SMBODY", "SMCO", "SMCONS", "SMFO", "SMFOR", "SMIN", "SMIN", "SMRT", "SMRTSIZE", "SMSU", "SMSURF", "SMUL", "SMULT", "SOLC", "SOLCONTROL", "SOLU", "SOLU", "SOLU", "SOLUOPT", "SOLV", "SOLVE", "SORT", "SORT", "SOUR", "SOURCE", "SPAC", "SPACE", "SPAR", "SPARM", "SPEC", "SPEC", "SPH4", "SPH4", "SPH5", "SPH5", "SPHE", "SPHERE", "SPLI", "SPLINE", "SPOI", "SPOINT", "SPOP", "SPOPT", "SPRE", "SPREAD", "SPTO", "SPTOPT", "SQRT", "SQRT", "SRCS", "SRCS", "SRSS", "SRSS", "SSLN", "SSLN", "SSTI", "SSTIF", "SSUM", "SSUM", "STAT", "STAT", "STEF", "STEF", "STOR", "STORE", "SUBO", "SUBOPT", "SUBS", "SUBSET", "SUMT", "SUMTYPE", "SV", "SVTY", "SVTYP", "TALL", "TALLOW", "TB", "TBCO", "TBCOPY", "TBDA", "TBDATA", "TBDE", "TBDELE", "TBLE", "TBLE", "TBLI", "TBLIST", "TBMO", "TBMODIF", "TBPL", "TBPLOT", "TBPT", "TBPT", "TBTE", "TBTEMP", "TCHG", "TCHG", "TEE", "TERM", "TERM", "TIME", "TIME", "TIME", "TIMERANGE", "TIMI", "TIMINT", "TIMP", "TIMP", "TINT", "TINTP", "TOFF", "TOFFST", "TOPD", "TOPDEF", "TOPE", "TOPEXE", "TOPI", "TOPITER", "TORQ2D", "TORQ", "TORQ", "TORQ", "TORQC2D", "TORQSUM", "TORU", "TORUS", "TOTA", "TOTAL", "TRAN", "TRAN", "TRANS", "TRANSFER", "TREF", "TREF", "TRNO", "TRNOPT", "TRPD", "TRPDEL", "TRPL", "TRPLIS", "TRPO", "TRPOIN", "TRTI", "TRTIME", "TSHA", "TSHAP", "TSRE", "TSRES", "TUNI", "TUNIF", "TVAR", "TVAR", "TYPE", "TYPE", "UIMP", "UIMP", "UPCO", "UPCOORD", "UPGE", "UPGEOM", "USRC", "USRCAL", "V", "VA", "VADD", "VADD", "VALV", "VALVE", "VARD", "VARDEL", "VARN", "VARNAM", "VATT", "VATT", "VCLE", "VCLEAR", "VCRO", "VCROSS", "VCVF", "VCVFILL", "VDDA", "VDDAM", "VDEL", "VDELE", "VDGL", "VDGL", "VDOT", "VDOT", "VDRA", "VDRAG", "VEXT", "VEXT", "VGEN", "VGEN", "VGET", "VGET", "VGLU", "VGLUE", "VIMP", "VIMP", "VINP", "VINP", "VINV", "VINV", "VLIS", "VLIST", "VLSC", "VLSCALE", "VMES", "VMESH", "VOFF", "VOFFST", "VOLU", "VOLUMES", "VOVL", "VOVLAP", "VPLO", "VPLOT", "VPTN", "VPTN", "VPUT", "VPUT", "VROT", "VROTAT", "VSBA", "VSBA", "VSBV", "VSBV", "VSBW", "VSBW", "VSEL", "VSEL", "VSLA", "VSLA", "VSUM", "VSUM", "VSWE", "VSWEEP", "VSYM", "VSYMM", "VTRA", "VTRAN", "VTYP", "VTYPE", "WAVE", "WAVES", "WERA", "WERASE", "WFRO", "WFRONT", "WMOR", "WMORE", "WPAV", "WPAVE", "WPCS", "WPCSYS", "WPLA", "WPLANE", "WPOF", "WPOFFS", "WPRO", "WPROTA", "WPST", "WPSTYL", "WRIT", "WRITE", "WSOR", "WSORT", "WSTA", "WSTART", "XVAR", "XVAR", "XVAROPT", "ex", "ey", "ez", "nuxy", "nuxz", "nuyz", "gxy", "gxz", "gyz", "alpx", "alpy", "alpz", "kxx", "kyy", "kzz", "dens", "damp", "mu", "prxy", });
        KEYWORDS1.add("KEYWORD2", new String[]{"ANGLEK", "ANGLEN", "AREAKP", "AREAND", "ARFACE", "ARNEXT", "ARNODE", "AX", "AY", "AZ", "CENTRX", "CENTRY", "CENTRZ", "DISTEN", "DISTKP", "DISTND", "ELADJ", "ELNEXT", "ENDS", "ENEARN", "ENEXTN", "ENKE", "KNEAR", "KP", "KPNEXT", "KX", "KY", "KZ", "LOC", "LSNEXT", "LSX", "LSY", "LSZ", "LX", "LY", "LZ", "MAG", "NDFACE", "NDNEXT", "NELEM", "NMFACE", "NNEAR", "NODE", "NORMKX", "NORMKY", "NORMKZ", "NORMNX", "NORMNY", "NORMNZ", "NX", "NY", "NZ", "PRES", "ROTX", "ROTY", "ROTZ", "TEMP", "UX", "UY", "UZ", "VLNEXT", "VOLT", "VX", "VY", "VZ", });
        KEYWORDS1.add("KEYWORD3", new String[]{"all", "new", "change", "rad", "deg", "hpt", "all", "below", "volu", "area", "line", "kp", "elem", "node", ",save", "resume", "off", "on", "dele", ",save", "scale", "xorig", "yorig", "snap", "stat", "defa", "refr", "static", "buckle", "modal", "harmic", "trans", "substr", "spectr", "new", "rest", "dege", "first", "next", "last", "near", "list", "velo", "acel", "off", ",l", "u", "off", "smooth", "clean", "on", "off", "tight", "x", "y", "z", "sepo", "delete", "keep", "s", ",r", ",a", "u", "all", "none", "inve", "stat", "area", "ext", "loc", "x", "y", "z", "hpt", ",mat", ",type", ",real", ",esys", "acca", "s", ",r", ",a", "u", "emat", "esav", "full", "redm", "mode", "rdsp", "rfrq", "tri", "rst", "rth", "rmg", "erot", "osav", "rfl", "seld", "default", "fine", "off", "on", "x", "y", "list", "lr", "sr", "temp", "flue", "hgen", "js", "vltg", "mvdi", "chrgd", "forc", "repl", "add", "igno", "stat", "new", "sum", "defa", "stat", "keep", "nwarn", "version", "no", "yes", "rv52", "rv51", "subsp", "lanb", "reduc", "all", "db", "solid", "comb", "geom", "cm", ",mat", "load", "blocked", "unblocked", "any", "all", "all", "uxyz", "rxyz", "ux", "uy", "uz", "rotx", "roty", "rotz", "append", ",esel", "warn", "err", "start", "nostart", "cart", "cylin", "sphe", "toro", "volu", "area", "line", "kp", "elem", "node", "create", "add", "dele", ",n", "p", "s", ",r", ",a", "u", "all", "none", "stat", "u", "rot", ",f", ",m", "temp", "heat", "pres", "v", "flow", "vf", "volt", "emf", "curr", "amps", "curt", "mag", ",a", "flux", "csg", "vltg", "axes", "axnum", "num", "outl", "elem", "line", "area", "volu", "isurf", "wbak", "u", "rot", "temp", "pres", "v", "enke", "ends", "sp01", "sp02", "sp03", "sp04", "sp05", "sp06", "volt", "mag", ",a", "emf", "curr", ",f", ",m", "heat", "flow", "vf", "amps", "flux", "csg", "curt", "vltg", "mast", ",cp", ",ce", "nfor", "nmom", "rfor", "rmom", "path", "grbak", "grid", "axlab", "curve", "cm", "cntr", "smax", "smin", "mred", "cblu", "ygre", "dgra", "mage", "cyan", "yell", "lgra", "bmag", "gcya", "oran", "whit", "blue", "gree", "red", "blac", "nres", "nbuf", "nproc", "locfl", "szbio", "ncont", "order", "fsplit", "mxnd", "mxel", "mxkp", "mxls", "mxar", "mxvl", "mxrl", "mxcp", "mxce", "nlcontrol", "high", "next", "any", "all", "all", "ux", "uy", "uz", "rotx", "roty", "rotz", "temp", "pres", "vx", "vy", "vz", "volt", "emf", "curr", "mag", "ax", "ay", "az", "enke", "ends", "sp01", "sp02", "sp03", "sp04", "sp05", "sp06", "p", "symm", "asym", "delete", "s", ",a", "u", "stat", "rot", "disp", "v", "en", "fx", "fy", "fz", ",f", "mx", "my", "mz", ",m", "forc", "heat", "flow", "amps", "chrg", "flux", "csgx", "csgy", "csgz", "csg", "disp", "velo", "acel", "all", "plslimit", "crplimit", "dsplimit", "npoint", "noiterpredict", "repl", "add", "igno", "all", "_prm", "off", "on", "defa", "stat", "off", "on", "all", "p", "s", "x", "y", "z", "xy", "yz", "zx", "epel", "eppl", "epcr", "epth", "epsw", "nl", "sepl", "srat", "hpres", "epeq", "psv", "plwk", "tg", "tf", "pg", "ef", ",d", "h", "b", "fmag", ",f", ",m", "heat", "flow", "amps", "flux", "vf", "csg", "u", "rot", "temp", "pres", "volt", "mag", "v", ",a", "enke", "ends", "s", "int", "eqv", "sum", "ttot", "hflu", "hflm", "cond", "pcoe", "ptot", "mach", "strm", "dens", "visc", "evis", "cmuv", "econ", "yplu", "tauw", "dither", "font", "text", "off", "on", "vector", "dither", "anim", "font", "text", "off", "on", "array", "char", "table", "time", "x", "y", "z", "temp", "velocity", "pressure", "auto", "off", "user", "disp", "velo", "acel", "symm", "asym", "x", "y", "z", "head", "all", "anim", "dgen", "dlist", "add", "dele", "list", "slide", "cycl", "ants", "assc", "asts", "drawbead", "ents", "ess", "ests", "nts", "osts", "rntr", "rotr", "se", "ss", "sts", "tdns", "tdss", "tnts", "tsts", "add", "dele", "list", "off", "on", "all", "ansys", "dyna", "all", "p", "off", "on", "list", "dele", "fx", "fy", "fz", "mx", "my", "mz", "ux", "uy", "uz", "rotx", "roty", "rotz", "vx", "vy", "vz", "ax", "ay", "az", "aclx", "acly", "aclz", "omgx", "omgy", "omgz", "press", "rbux", "rbuy", "rbuz", "rbrx", "rbry", "rbrz", "rbvx", "rbvy", "rbvz", "rbfx", "rbfy", "rbfz", "rbmx", "rbmy", "rbmz", "add", "dele", "list", "hgls", "rigid", "cable", "ortho", "add", "dele", "list", "all", "ux", "uy", "uz", "rotx", "roty", "rotz", "ansys", "taurus", "both", "glstat", "bndout", "rwforc", "deforc", ",matsum", "ncforc", "rcforc", "defgeo", "spcforc", "swforc", "rbdout", "gceout", "sleout", "jntforc", "nodout", "elout", "add", "dele", "list", "ansys", "taurus", "both", "pcreate", "pupdate", "plist", "all", "p", "eq", "ne", "lt", "gt", "le", "ge", "ablt", "abgt", "add", "remove", "all", "either", "both", "p", "all", ",mat", ",type", ",real", ",esys", "secnum", "p", "mks", "muzro", "epzro", "all", "p", "front", "sparse", "jcg", "jcgout", "iccg", "pcg", "pcgout", "iter", "all", "p", "off", "smooth", "clean", "on", "defa", "yes", "no", "on", "off", "s", ",r", ",a", "u", "all", "none", "inve", "stat", "p", "elem", "adj", ",type", "ename", ",mat", ",real", ",esys", "live", "layer", "sec", "pinc", "pexc", "sfe", "pres", "conv", "hflux", "fsi", "impd", "shld", "mxwf", "chrgs", "inf", "bfe", "temp", "flue", "hgen", "js", "mvdi", "chrgd", "etab", "s", ",r", ",a", "u", "all", "active", "inactive", "corner", "mid", "p", "s", "x", "y", "z", "xy", "yz", "zx", "int", "eqv", "epel", "eppl", "epcr", "epth", "nl", "sepl", "srat", "hpres", "epeq", "psv", "plwk", "cont", "stat", "pene", "pres", "sfric", "stot", "slide", "tg", "sum", "tf", "pg", "ef", ",d", "h", "b", "fmag", ",f", ",m", "heat", "flow", "amps", "flux", "vf", "csg", "sene", "kene", "jheat", "js", "jt", "mre", "volu", "bfe", "temp", "etab", "top", "bottom", "reverse", "tri", "all", "p", "refl", "stat", "eras", "u", "x", "y", "z", "rot", "temp", "pres", "volt", "mag", "v", ",a", "curr", "emf", "enke", "ends", "sp01", "sp02", "sp03", "sp04", "sp05", "sp06", "ttot", "hflu", "hflm", "cond", "pcoe", "ptot", "mach", "strm", "dens", "visc", "evis", "econ", "yplu", "tauw", "lmd1", "lmd2", "lmd3", "lmd4", "lmd5", "lmd6", "emd1", "emd2", "emd3", "emd4", "emd5", "emd6", "s", "xy", "yz", "zx", "int", "eqv", "epto", "epel", "eppl", "epcr", "epth", "epsw", "nl", "sepl", "srat", "hpres", "epeq", "psv", "plwk", "tg", "sum", "tf", "pg", "ef", ",d", "h", "b", "fmag", "serr", "sdsg", "terr", "tdsg", ",f", ",m", "heat", "flow", "amps", "flux", "vf", "csg", "sene", "aene", "tene", "kene", "jheat", "js", "jt", "mre", "volu", "cent", "bfe", "smisc", "nmisc", "surf", "cont", "stat", "pene", "sfric", "stot", "slide", "gap", "topo", "eti", "ite", "tts", "stt", "mtt", "fts", "ets", "all", "elem", "short", "long1", "model", "solu", "all", "nosave", "rect", "polar", "modal", "full", "half", "off", "on", "yes", "no", "on", "off", "stat", "attr", "esize", "aclear", "all", "p", "fx", "fy", "fz", "mx", "my", "mz", "heat", "flow", "amps", "chrg", "flux", "csgx", "csgy", "csgz", "fine", "norml", "wire", "repl", "add", "igno", "stat", "emat", "esav", "full", "sub", "mode", "tri", "dsub", "usub", "osav", "seld", "keep", "dele", "all", "p", "solu", "flow", "turb", "temp", "comp", "swrl", "tran", "spec", "true", "t", "false", ",f", "iter", "exec", "appe", "over", "term", "pres", "temp", "vx", "vy", "vz", "enke", "ends", "time", "step", "istep", "bc", "numb", "glob", "tend", "appe", "sumf", "over", "pres", "temp", "vx", "vy", "vz", "enke", "ends", "step", "appe", "sumf", "over", "outp", "sumf", "debg", "resi", "dens", "visc", "cond", "evis", "econ", "ttot", "hflu", "hflm", "spht", "strm", "mach", "ptot", "pcoe", "yplu", "tauw", "lmd", "emd", "conv", "outp", "iter", "land", "bloc", "bnow", "prot", "dens", "visc", "cond", "spht", "constant", "liquid", "table", "powl", "carr", "bing", "usrv", "air", "air_b", "air-si", "air-si_b", "air-cm", "air-cm_b", "air-mm", "air-mm_b", "air-ft", "air-ft_b", "air-in", "air-in_b", "cmix", "user", "nomi", "dens", "visc", "cond", "spht", "cof1", "dens", "visc", "cond", "spht", "cof2", "dens", "visc", "cond", "spht", "cof3", "dens", "visc", "cond", "spht", "prop", "ivis", "ufrq", "vary", "dens", "visc", "cond", "spht", "t", ",f", "temp", "nomi", "bulk", "ttot", "pres", "refe", "bulk", "beta", "gamm", "comp", "meth", "pres", "temp", "vx", "vy", "vz", "enke", "ends", "tdma", "pres", "temp", "vx", "vy", "vz", "enke", "ends", "srch", "pres", "temp", "vx", "vy", "vz", "enke", "ends", "pgmr", "fill", "modp", "conv", "pres", "temp", "vx", "vy", "vz", "enke", "ends", "maxi", "pres", "temp", "vx", "vy", "vz", "enke", "ends", "delt", "pres", "temp", "vx", "vy", "vz", "enke", "ends", "turb", "modl", "rati", "inin", "insf", "sctk", "sctd", "cmu", "c1", "c2", "buc3", "buc4", "beta", "kapp", "ewll", "wall", "vand", "tran", "zels", "rngt", "sctk", "sctd", "cmu", "c1", "c2", "beta", "etai", "nket", "sctk", "sctd", "c2", "c1mx", "girt", "sctk", "sctd", "g0", "g1", "g2", "g3", "g4", "szlt", "sctk", "sctd", "szl1", "szl2", "szl3", "relx", "vx", "vy", "vz", "pres", "temp", "enke", "ends", "evis", "econ", "dens", "visc", "cond", "spht", "stab", "turb", "mome", "pres", "temp", "visc", "prin", "vx", "vy", "vz", "pres", "temp", "enke", "ends", "dens", "visc", "cond", "spht", "evis", "econ", "modr", "vx", "vy", "vz", "pres", "temp", "enke", "ends", "dens", "visc", "cond", "spht", "evis", "econ", "ttot", "t", ",f", "modv", "vx", "vy", "vz", "sp01", "sp02", "sp03", "sp04", "sp05", "sp06", "pres", "temp", "enke", "ends", "dens", "visc", "cond", "spht", "evis", "econ", "ttot", "lmd", "emd", "quad", "momd", "moms", "prsd", "prss", "thrd", "thrs", "trbd", "trbs", "capp", "velo", "temp", "pres", "umin", "umax", "vmin", "vmax", "wmin", "wmax", "tmin", "tmax", "pmin", "pmax", "rest", "nset", "iter", "lstp", "time", "rfil", "wfil", "over", "clear", "advm", "mome", "turb", "pres", "temp", "msu", "supg", "all", "p", "all", "noor", "order", "all", "auto", "user", "total", "static", "damp", "inert", "reco", "ten", "long", "g", ",f", "e", "all", "all", "rsys", "emat", "esav", "full", "redm", "sub", "mode", "tri", "dsub", "usub", "erot", "osav", "seld", "all", "ext", "int", "open", "closed", "toler", "iter", "toler", "oesele", "merge", "remain", "open", "closed", "all", "tree", "off", "tri", "bot", "all", "active", "int", "imme", "menu", "prkey", "units", "rout", "time", "wall", "cpu", "dbase", "ldate", "dbase", "ltime", "rev", "title", "jobnam", "parm", "max", "basic", "loc", ",type", "dim", "x", "y", "z", "cmd", "stat", "nargs", "field", "comp", "ncomp", "name", ",type", "nscomp", "sname", "graph", "active", "angle", "contour", "dist", "dscale", "dmult", "edge", "focus", "gline", "mode", "normal", "range", "xmin", "ymin", "xmax", "ymax", "ratio", "sscale", "smult", ",type", "vcone", "view", "vscale", "vratio", "display", "erase", "ndist", "number", "plopts", "seg", "shrink", "active", ",csys", ",dsys", ",mat", ",type", ",real", ",esys", ",cp", ",ce", "wfront", "max", "rms", "cdsy", "loc", "ang", "xy", "yz", "zx", "attr", "node", "loc", ",nsel", "nxth", "nxtl", ",f", "fx", "mx", "csgx", ",d", "ux", "rotx", "vx", "ax", "hgen", "num", "max", "min", "count", "mxloc", "mnloc", "elem", "cent", "adj", "attr", "leng", "lproj", "area", "aproj", "volu", ",esel", "nxth", "nxtl", "hgen", "hcoe", "tbulk", "pres", "shpar", "angd", "aspe", "jacr", "maxa", "para", "warp", "num", ",ksel", "nxth", "nxtl", "div", "kp", "ior", "imc", "irp", "ixv", "iyv", "izv", "nrelm", "line", ",lsel", "area", ",asel", "loop", "volu", ",vsel", "shell", "etyp", "rcon", "ex", "alpx", "reft", "prxy", "nuxy", "gxy", "damp", "mu", "dnes", "c", "enth", "kxx", "hf", "emis", "qrate", "visc", "sonc", "rsvx", "perx", "murx", "mgxx", "lsst", "temp", "fldata", "flow", "turb", "temp", "comp", "swrl", "tran", "spec", "exec", "appe", "over", "pres", "temp", "vx", "vy", "vz", "enke", "ends", "step", "istep", "bc", "numb", "glob", "tend", "appe", "sumf", "over", "sumf", "debg", "resi", "dens", "visc", "cond", "evis", "econ", "ttot", "hflu", "hflm", "spht", "strm", "mach", "ptot", "pcoe", "yplu", "tauw", "lmd", "emd", "outp", "iter", "dens", "visc", "cond", "ivis", "ufrq", "nomi", "bulk", "ttot", "refe", "beta", "comp", "fill", "modp", "modl", "rati", "inin", "insf", "sctk", "sctd", "cmu", "c1", "c2", "buc3", "buc4", "beta", "kapp", "ewll", "wall", "vand", "tran", "zels", "sctk", "sctd", "cmu", "c1", "c2", "etai", "c1mx", "g0", "g1", "g2", "g3", "g4", "szl1", "szl2", "szl3", "evis", "econ", "mome", "sp01", "sp02", "sp03", "sp04", "sp05", "sp06", "momd", "moms", "prsd", "prss", "thrd", "thrs", "trbd", "trbs", "velo", "umin", "umax", "vmin", "vmax", "wmin", "wmax", "tmin", "tmax", "pmin", "pmax", "nset", "iter", "lstp", "time", "rfil", "wfil", "over", "clear", "msdata", "spec", "ugas", "msprop", "cond", "mdif", "spht", "nomi", "cof1", "cof2", "cof3", "msspec", "name", "molw", "schm", "msrelax", "conc", "emdi", "stab", "mssolu", "nswe", "maxi", "nsrc", "conv", "delt", "msmeth", "mscap", "key", "upp", "low", "msvary", "msnomf", "active", "anty", "solu", "dtime", "ncmls", "ncmss", "eqit", "ncmit", "cnvg", "mxdvl", "resfrq", "reseig", "dsprm", "focv", "mocv", "hfcv", "mfcv", "cscv", "cucv", "ffcv", "dicv", "rocv", "tecv", "vmcv", "smcv", "vocv", "prcv", "vecv", "nc48", "nc49", "crprat", "psinc", "elem", "mtot", "mc", "ior", "imc", "fmc", "mmor", "mmmc", "mode", "freq", "pfact", "mcoef", "damp", "active", ",set", "lstp", "sbst", "time", "rsys", "node", "u", "sum", "rot", "ntemp", "volt", "mag", "v", ",a", "curr", "emf", "rf", "fx", "fy", "fz", "mx", "my", "mz", "s", "int", "eqv", "epto", "epel", "eppl", "epcr", "epth", "epsw", "nl", "sepl", "srat", "hpres", "epeq", "psv", "plwk", "tg", "tf", "pg", "ef", ",d", "h", "b", "fmag", "hs", "bfe", "ttot", "hflu", "hflm", "conc", "pcoe", "ptot", "mach", "strm", "evis", "cmuv", "econ", "yplu", "tauw", "elem", "serr", "sdsg", "terr", "tdsg", "sene", "tene", "kene", "jheat", "js", "volu", "etab", "smisc", "nmisc", "etab", "ncol", "nleng", "sort", "max", "min", "imax", "imin", "ssum", "item", "fsum", "path", "last", "nval", "kcalc", "k", "intsrf", "plnsol", "bmax", "bmin", "prerr", "sepc", "tepc", "sersm", "tersm", "sensm", "tensm", "section", "inside", "sx", "sy", "sz", "sxxy", "syz", "szx", "center", "outside", "vari", "extrem", "vmax", "tmax", "vmin", "tmin", "vlast", "tlast", "cvar", "rtime", "itime", "t", "rset", "iset", "nsets", "opt", "total", "feas", "term", "best", "topo", "act", "conv", "comp", "porv", "loads", "runst", "rspeed", "mips", "smflop", "vmflop", "rfilsz", "emat", "erot", "esav", "full", "mode", "rdsp", "redm", "rfrq", "rgeom", "rst", "tri", "rtimst", "tfirst", "titer", "eqprep", ",solve", "bsub", "eigen", "elform", "elstrs", "nelm", "rmemry", "wsreq", "wsavail", "dbpsize", "dbpdisk", "dbpmem", "dbsize", "dbmem", "scrsize", "scravail", "iomem", "iopsiz", "iobuf", "rwfrnt", "rms", "mean", ",nsel", ",esel", ",ksel", ",lsel", ",asel", ",vsel", "ndnext", "elnext", "kpnext", "lsnext", "arnext", "vlnext", "centrx", "centry", "centrz", "nx", "ny", "nz", "kx", "ky", "kz", "lx", "ly", "lz", "lsx", "lsy", "lsz", "node", "kp", "distnd", "distkp", "disten", "anglen", "anglek", "nnear", "knear", "enearn", "areand", "areakp", "arnode", "normnx", "normny", "normnz", "normkx", "normky", "normkz", "enextn", "nelem", "eladj", "ndface", "nmface", "arface", "ux", "uy", "uz", "rotx", "roty", "rotz", "temp", "pres", "vx", "vy", "vz", "enke", "ends", "volt", "mag", "ax", "ay", "az", "g", ",f", "e", "all", "stop", "p", "fx", "fy", "fz", "mx", "my", "mz", "all", "full", "power", "axdv", "axnm", "axnsc", "ascal", "logx", "logy", "fill", "cgrid", "dig1", "dig2", "view", "revx", "revy", "divx", "divy", "ltyp", "off", "on", "front", "disp", "velo", "acel", "on", "off", "axis", "grid", "curve", "all", "node", "elem", "keyp", "line", "area", "volu", "grph", "on", "off", "model", "paper", "color", "direct", "line", "area", "coord", "ratio", "all", "p", "all", "full", "reduc", "msup", "on", "off", "all", "p", "ux", "uy", "uz", "rotx", "roty", "rotz", "temp", "pres", "vx", "vy", "vz", "enke", "ends", "sp01", "so02", "sp03", "sp04", "sp05", "sp06", "volt", "mag", "ax", "ay", "az", "all", "p", "disp", "velo", "eq", "ne", "lt", "gt", "le", "ge", "ablt", "abgt", "stop", "exit", "cycle", "then", "all", "basic", "nsol", "rsol", "esol", "nload", "strs", "epel", "epth", "eppl", "epcr", "fgrad", "fflux", "misc", "pres", "stat", "defa", "merg", "yes", "no", "solid", "gtoler", "file", "iges", "stat", "small", "p", "p", "ratio", "dist", "p", "kp", "line", "all", "p", "coord", "hpt", "stat", "all", "p", "off", "smooth", "clean", "on", "off", "s", ",r", ",a", "u", "all", "none", "inve", "stat", "p", ",mat", ",type", ",real", ",esys", "all", "kp", "ext", "hpt", "loc", "x", "y", "z", "s", ",r", ",a", "u", "all", "p", "x", "y", "z", "p", "fcmax", "all", "p", "erase", "stat", "all", "zero", "squa", "sqrt", "lprin", "add", "sub", "srss", "min", "max", "abmn", "abmx", "all", "mult", "s", ",r", ",a", "u", "all", "none", "inve", "stat", "temp", "forc", "hgen", "hflu", "ehflu", "js", "pres", "reac", "hflm", "last", "none", "comment", "remove", "radius", "layer", "hpt", "orient", "off", "on", "auto", "cart", "cylin", "sphe", "toro", "all", "p", "off", "smooth", "clean", "on", "p", "all", "sepo", "delete", "keep", "solid", "fe", "iner", "lfact", "lsopt", "all", "s", ",r", ",a", "u", "all", "none", "inve", "stat", "p", "line", "ext", "loc", "x", "y", "z", "tan1", "tan2", "ndiv", "space", ",mat", ",type", ",real", ",esys", "sec", "lenght", "radius", "hpt", "lcca", "s", ",r", ",a", "u", "stat", "init", "x", "y", "z", "all", "p", "off", "on", "all", "p", "ux", "uy", "uz", "rotx", "roty", "rotz", "temp", "fx", "fy", "fz", "mx", "my", "mz", "heat", "all", "p", "on", "grph", "fit", "eval", "copy", "tran", "stat", "nocheck", "check", "detach", "subsp", "lanb", "reduc", "unsym", "damp", "off", "on", "mult", "solv", "sort", "covar", "corr", "expnd", "tetexpnd", "trans", "iesz", "amesh", "default", "main", "alternate", "alt2", "qmesh", "vmesh", "split", "lsmo", "clear", "pyra", "timp", "stat", "defa", "p", "ex", "ey", "ez", "alpx", "alpy", "alpz", "reft", "prxy", "pryz", "prxz", "nuxy", "nuyz", "nuzx", "gxy", "gyz", "gxz", "damp", "mu", "dens", "c", "enth", "kxx", "kyy", "kzz", "hf", "emis", "qrate", "visc", "sonc", "rsvx", "rsvy", "rsvz", "perx", "pery", "perz", "murx", "mury", "murz", "mgxx", "mgyy", "mgzz", "lsst", "all", "read", "write", "stat", "all", "evlt", "msu", "supg", "off", "on", "info", "note", "warn", "error", "fatal", "ui", "2d", "3d", "dens", "visc", "cond", "mdif", "spht", "constant", "liquid", "gas", "main", "input", "grph", "tool", "zoom", "work", "wpset", "abbr", "parm", "sele", "anno", "hard", "help", "off", "on", "dens", "visc", "cond", "mdif", "off", "on", "no", "yes", "all", "p", "off", "on", "all", "p", "coord", "all", "p", "off", "smooth", "clean", "on", "disp", "velo", "acel", "auto", "full", "modi", "init", "on", "off", "s", ",r", ",a", "u", "all", "none", "inve", "stat", "node", "ext", "loc", "x", "y", "z", "ang", "xy", "yz", "zx", ",m", ",cp", ",ce", ",d", "u", "ux", "uy", "uz", "rot", "rotx", "roty", "rotz", "temp", "pres", "volt", "mag", "v", "vx", "vy", "vz", ",a", "ax", "ay", "az", "curr", "emf", "enke", "ends", ",f", "fx", "fy", "fz", ",m", "mx", "my", "mz", "heat", "flow", "amps", "flux", "csg", "csgx", "csgy", "csgz", "chrg", "chrgd", ",bf", "temp", "flue", "hgen", "js", "jsx", "jsy", "jsz", "mvdi", "int", "eqv", "epto", "epel", "eppl", "epcr", "epth", "epsw", "nl", "sepl", "srat", "hpres", "epeq", "psv", "plwk", "cont", "pene", "sfric", "stot", "slide", "tg", "tf", "pg", "ef", ",d", "h", "b", "fmag", "topo", "ttot", "hflu", "hflm", "cond", "pcoe", "ptot", "mach", "strm", "dens", "visc", "evis", "cmuv", "econ", "yplu", "tauw", "s", ",r", ",a", "u", "all", "active", "inactive", "corner", "mid", "off", "on", "x", "y", "z", "all", "p", "node", "elem", "kp", "line", "area", "volu", ",mat", ",type", ",real", ",cp", ",ce", "all", "low", "high", ",csys", "defa", "yes", "no", "p", "all", "full", "best", "last", ",n", "off", "on", "main", "2fac", "3fac", "top", "prep", "ignore", "process", "scalar", "all", "temp", "off", "on", "full", "subp", "first", "rand", "run", "fact", "grad", "sweep", "user", "dv", "sv", "obj", "del", "basic", "nsol", "rsol", "esol", "nload", "veng", "all", "none", "last", "stat", "erase", "term", "append", "all", "basic", "nsol", "rsol", "esol", "nload", "strs", "epel", "epth", "eppl", "epcr", "fgrad", "fflux", "misc", "none", "all", "last", "all", "name", "points", "table", "label", "all", "path", "new", "change", "scalar", "all", "s", "all", "u", "ux", "uy", "uz", "rot", "rotx", "roty", "rotz", "temp", "pres", "v", "vx", "vy", "vz", "sp01", "sp02", "sp03", "sp04", "sp05", "sp06", "enke", "ends", "volt", "mag", ",a", "chrg", ",f", "forc", "fx", "fy", "fz", ",m", "mome", "mx", "my", "mz", "heat", "flow", "amps", "flux", "csg", "mast", ",cp", ",ce", "nfor", "nmom", "rfor", "rmom", "path", "acel", "acelx", "acely", "acelz", "omeg", "omegx", "omegy", "omegz", "all", "temp", "flue", "hgen", "js", "jsx", "jsy", "jsz", "phase", "mvdi", "chrgd", "vltg", "forc", "add", "mult", "div", "exp", "deri", "intg", "sin", "cos", "asin", "acos", "log", "stat", "erase", "dele", "se", "s", "epel", "u", "rot", "eqv", "sum", "p", "top", "mid", "bot", "x", "y", "z", "xy", "yz", "xz", "int", "now", "avg", "noav", "u", "x", "y", "z", "sum", "rot", "temp", "pres", "volt", "mag", "v", ",a", "curr", "emf", "enke", "ends", "xy", "yz", "xz", "eqv", "epto", "epel", "eppl", "epcr", "epth", "epsw", "nl", "sepl", "srat", "hpres", "epeq", "psv", "plwk", "tg", "tf", "pg", "ef", ",d", "h", "b", "fmag", "etab", "bfe", "ttot", "hflu", "hflm", "cond", "pcoe", "ptot", "mach", "strm", "dens", "visc", "evis", "cmuv", "econ", "yplu", "tauw", "spht", "x", "y", "z", "all", "stat", "p", "base", "node", "wave", "spat", "write", "read", "list", "delete", "clear", "status", "all", "stat", "p", "on", "off", "all", "se", "s", "epel", "u", "rot", "top", "mid", "bot", "xy", "yz", "xz", "int", "eqv", "epel", "u", "rot", "s", "x", "y", "z", "xy", "yz", "xz", "int", "eqv", "epto", "epel", "eppl", "epcr", "epth", "epsw", "nl", "sepl", "srat", "hpres", "epeq", "psv", "plwk", "cont", "stat", "pene", "pres", "sfric", "stot", "slide", "gap", "tg", "tf", "pg", "ef", ",d", "h", "b", "fmag", "serr", "sdsg", "terr", "tdsg", ",f", ",m", "heat", "flow", "amps", "flux", "vf", "csg", "sene", "tene", "kene", "jheat", "js", "jt", "mre", "volu", "cent", "bfe", "temp", "smisc", "nmisc", "topo", "noav", "avg", "u", "x", "y", "z", "sum", "rot", "temp", "pres", "volt", "mag", "v", "y", "enke", "ends", "sp01", "sp02", "sp03", "sp04", "sp05", "sp06", "s", "int", "eqv", "epto", "xy", "yz", "xz", "epel", "eppl", "epcr", "epth", "epsw", "nl", "sepl", "srat", "hpres", "epeq", "psv", "plwk", "cont", "stat", "pene", "pres", "sfric", "stot", "slide", "gap", "tg", "tf", "pg", "ef", ",d", "h", "b", "fmag", "bfe", "temp", "topo", "ttot", "hflu", "hflm", "cond", "pcoe", "ptot", "mach", "strm", "dens", "visc", "spht", "evis", "cmuv", "econ", "yplu", "tauw", "lmd1", "lmd2", "lmd3", "lmd4", "lmd5", "lmd6", "emd1", "emd2", "emd3", "emd4", "emd5", "emd6", "leg1", "leg2", "info", "frame", "title", "minm", "logo", "wins", "wp", "off", "on", "auto", "all", "node", "xg", "yg", "zg", "s", "s", "x", "y", "z", "xy", "yz", "xz", "int", "eqv", "fluid", "elec", "magn", "temp", "pres", "v", "x", "y", "z", "sum", "enke", "ends", "ttot", "cond", "pcoe", "ptot", "mach", "strm", "dens", "visc", "spht", "evis", "cmuv", "econ", "volt", "rast", "vect", "elem", "node", "off", "on", "u", "rot", "v", ",a", "s", "epto", "epel", "eppl", "epcr", "epth", "tg", "tf", "pg", "ef", ",d", "h", "b", "fmag", "js", "jt", "uniform", "accurate", "on", "off", "stat", "node", "elem", ",mat", ",type", ",real", ",esys", "loc", "kp", "line", "area", "volu", "sval", "tabnam", "off", "on", "b31.1", "nc", "coax", "te10", "te11circ", "tm01circ", "pick", "off", "on", "s", "epto", "epel", "eppl", "epcr", "epsw", "nl", "cont", "tg", "tf", "pg", "ef", ",d", "h", "b", "fmag", ",f", ",m", "heat", "flow", "amps", "flux", "vf", "csg", "forc", "bfe", "elem", "serr", "sdsg", "terr", "tdsg", "sene", "tene", "kene", "jheat", "js", "jt", "mre", "volu", "cent", "smisc", "nmisc", "topo", "fx", "fy", "fz", ",f", "mx", "ym", "mz", ",m", "heat", "flow", "vfx", "vfy", "vfz", "vf", "amps", "curt", "vltg", "flux", "csgx", "csgy", "csgz", "csg", "u", "x", "y", "z", "comp", "rot", "temp", "pres", "volt", "mag", "v", ",a", "curr", "emf", "enke", "ends", "sp01", "sp02", "sp03", "sp04", "sp05", "sp06", "dof", "s", "comp", "prin", "epto", "epel", "eppl", "epcr", "epth", "epsw", "nl", "cont", "tg", "tf", "pg", "ef", ",d", "h", "b", "fmag", "bfe", "topo", "ttot", "hflu", "hflm", "cond", "pcoe", "ptot", "mach", "strm", "dens", "visc", "spht", "evis", "cmuv", "econ", "yplu", "tauw", "lmd", "emd", "u", "rot", "v", ",a", "s", "epto", "epel", "eppl", "epcr", "epth", "tg", "tf", "pg", "ef", ",d", "h", "b", "fmag", "js", "jt", "cmap", "lwid", "color", "tranx", "trany", "rotate", "scale", "tiff", "epsi", "disp", "velo", "acel", "rel", "abs", "off", "disp", "velo", "acel", "accg", "forc", "pres", "off", "s", ",r", ",a", "u", "all", "none", "inv", "pres", "norm", "tanx", "tany", "conv", "hcoef", "tbulk", "rad", "emis", "tamb", "hflux", "fsi", "impd", "shld", "cond", "mur", "mxwf", "inf", "chrgs", "mci", "cgsol", "eigdamp", "eigexp", "eigfull", "eigreduc", "eigunsym", "elform", "elprep", "redwrite", "triang", "tran", "rot", "off", "on", "cs", "ndir", ",esys", "ldir", "layr", "pcon", "econ", "dot", "xnod", "defa", "stat", "none", "stat", "dele", "ftin", "metric", "norm", "tang", "radi", "p", "all", "ux", "uy", "uz", "rotx", "roty", "rotz", "uxyz", "rxyz", "all", "all", "resize", "fast", "off", "dyna", "p", ",f", "x", "y", "z", ",m", "heat", "flow", "amps", "flux", "vf", "csg", "vltg", "durt", "index", "cntr", "all", "ux", "uy", "uz", "rotx", "roty", "rotz", "none", "all", "off", "dyna", "elem", "stress", "all", "solu", "factor", "area", "narrow", "read", "status", "cent", "shrc", "origin", "user", "library", "mesh", "beam", "rect", "quad", "csolid", "ctube", "chan", "i", "z", ",l", "t", "hats", "hrec", "asec", "mesh", "all", "off", "on", "singl", "multi", "delet", "off", "stat", "pc", "x", "y", "z", "first", "last", "next", "near", "list", "none", "all", "p", "pres", "conv", "hflux", "rad", "fsi", "impd", "ptot", "mxwf", "mci", "chrgs", "inf", "port", "shld", "all", "p", "pres", "conv", "hflux", "rad", "fsi", "impd", "mxwf", "mci", "mxwf", "chrgs", "inf", "port", "shld", ",sf", "ms", "all", "p", "all", "pres", "conv", "hflux", "selv", "chrgs", "mxwf", "inf", "repl", "add", "igno", "stat", "all", "p", "pres", "conv", "hflux", "rad", "mxwf", "chrgs", "mci", "inf", "selv", "fsi", "impd", "port", "shld", "all", "p", "pres", "conv", "hflux", "rad", "mxwf", "chrgs", "mci", "inf", "selv", "fsi", "impd", "port", "shld", "pres", "conv", "hflux", "chrgs", "status", "x", "y", "z", "all", "p", "pres", "conv", "hflux", "rad", "fsi", "impd", "mci", "mxwf", "chrgs", "inf", "port", "shdl", "selv", "facet", "gouraud", "phong", "top", "mid", "bot", "term", "file", "off", "pscr", "hpgl", "hpgl2", "vrml", "hpgl", "hpgl2", "interleaf", "postscript", "dump", "on", "warn", "off", "silent", "status", "summary", "default", "object", "modify", "angd", "aspect", "paral", "maxang", "jacrat", "warp", "all", "yes", "no", "factor", "radius", "length", "stat", "defa", "off", "on", "on", "off", "allf", "aldlf", "arcl", "cnvg", "crprat", "cscv", "cucv", "dicv", "dsprm", "dtime", "eqit", "ffcv", "focv", "hfcv", "nc48", "nc49", "ncmit", "ncmls", "ncmss", "mfcv", "mocv", "mxdvl", "prcv", "psinc", "resfrq", "reseig", "rocv", "smcv", "tecv", "vecv", "vocv", "vmcv", "sprs", "mprs", "ddam", "psd", "no", "yes", "disp", "velo", "acel", "all", "off", "on", "argx", "all", "title", "units", "mem", "db", "config", "global", "solu", "phys", "merge", "new", "appen", "alloc", "psd", "all", "part", "none", "first", "last", "next", "near", "list", "velo", "acel", "comp", "prin", "bkin", "mkin", "miso", "biso", "aniso", "dp", "melas", "user", "kinh", "anand", "creep", "swell", "bh", "piez", "fail", "mooney", "water", "anel", "concr", "hflm", "fcon", "pflow", "evisc", "plaw", "foam", "honey", "comp", "nl", "eos", "all", "mkin", "kinh", "melas", "miso", "bkin", "biso", "bh", "nb", "mh", "sbh", "snb", "smh", "defi", "dele", "wt", "uft", "copy", "loop", "noprom", "off", "on", "all", "struc", "therm", "elect", "mag", "fluid", "all", "p", "all", "p", "orig", "off", "lbot", "rbot", "ltop", "rtop", "elem", "area", "volu", "isurf", "cm", "curve", "full", "reduc", "msup", "damp", "nodamp", "all", "p", "iine", "line", "para", "arc", "carc", "circ", "tria", "tri6", "quad", "qua8", "cyli", "cone", "sphe", "pilo", "basic", "sect", "hidc", "hidd", "hidp", "cap", "zbuf", "zcap", "zqsl", "hqsl", "help", "view", "wpse", "wpvi", "result", "query", "copy", "anno", "select", ",nsel", ",esel", ",ksel", ",lsel", ",asel", ",vsel", "refresh", "s", ",r", ",a", "u", "node", "element", "grid", "format", "pscr", "tiff", "epsi", "bmp", "wmf", "emf", "screen", "full", "graph", "color", "mono", "grey", "krev", "norm", "reverse", "orient", "landscape", "portrait", "compress", "yes", "no", "msgpop", "replot", "abort", "dyna", "pick", "on", "off", "stat", "defa", "user", "si", "cgs", "bft", "bin", "off", "on", "all", "usrefl", "userfl", "usercv", "userpr", "userfx", "userch", "userfd", "userou", "usermc", "usolbeg", "uldbeg", "ussbeg", "uitbeg", "uitfin", "ussfin", "uldfin", "usolfin", "uanbeg", "uanfin", "uelmatx", "all", "p", "data", "ramp", "rand", "gdis", "tria", "beta", "gamm", "acos", "asin", "asort", "atan", "comp", "copy", "cos", "cosh", "dircos", "dsort", "euler", "exp", "expa", "log", "log10", "nint", "not", "pwr", "sin", "sinh", "sqrt", "tan", "tanh", "tang", "norm", "local", "global", "all", "p", "node", "loc", "x", "y", "z", "ang", "xy", "yz", "zx", ",nsel", "elem", "cent", "adj", "attr", "geom", ",esel", "shpar", "kp", "div", ",ksel", "line", "leng", ",lsel", "area", "loop", ",asel", "volu", "shell", "volu", ",vsel", "cdsy", "rcon", "const", "const", "bkin", "mkin", "miso", "biso", "aniso", "dp", "melas", "user", "kinh", "anand", "creep", "swell", "bh", "piez", "fail", "mooney", "water", "anel", "concr", "hflm", "fcon", "pflow", "evisc", "plaw", "foam", "honey", "comp", "nl", "eos", "u", "rot", "temp", "pres", "volt", "mag", "v", ",a", "curr", "emf", "enke", "ends", "s", "int", "eqv", "epto", "epel", "eppl", "epcr", "epth", "epsw", "nl", "sepl", "srat", "hpres", "epeq", "psv", "plwk", "hs", "bfe", "tg", "tf", "pg", "ef", ",d", "h", "b", "fmag", "ttot", "hflu", "hflm", "cond", "pcoe", "ptot", "mach", "strm", "dens", "visc", "evis", "econ", "yplu", "tauw", "etab", "all", "p", "all", "wp", "add", "sub", "mult", "div", "min", "max", "lt", "le", "eq", "ne", "ge", "gt", "der1", "der2", "int1", "int2", "dot", "cross", "gath", "scat", "all", "p", "all", "dege", "node", "u", "x", "y", "z", "rot", "temp", "pres", "volt", "mag", "v", ",a", "curr", "emf", "enke", "ends", "s", "xy", "yz", "xz", "int", "eqv", "epto", "epel", "eppl", "epcr", "epth", "epsw", "nl", "sepl", "srat", "hpres", "epeq", "psv", "plwk", "tg", "tf", "pg", "ef", ",d", "h", "b", "fmag", "ttot", "hflu", "hflm", "cond", "pcoe", "ptot", "mach", "strm", "dens", "visc", "evis", "econ", "yplu", "tauw", "elem", "etab", "all", "p", "all", "p", "sepo", "delete", "keep", "max", "min", "lmax", "lmin", "first", "last", "sum", "medi", "mean", "vari", "stdv", "rms", "num", "s", ",r", ",a", "u", "all", "none", "inve", "stat", "p", "volu", "loc", "x", "y", "z", ",mat", ",type", ",real", ",esys", "default", "fine", "p", "x", "y", "z", "all", "p", "-x", "-y", "-z", "max", "rms", "off", "on", "full", "left", "righ", "top", "bot", "ltop", "lbot", "rtop", "rbot", "squa", "dele", "p", "x", "y", "z", "all", "max", "rms", "all", "all", "off", "back", "scrn", "rect", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, SEQ30, SEQ31, SEQ32, SEQ33, SEQ34, SEQ35, SEQ36, SEQ37, SEQ38, SEQ39, SEQ40, SEQ41, SEQ42, SEQ43, SEQ44, SEQ45, SEQ46, SEQ47, SEQ48, SEQ49, SEQ50, SEQ51, SEQ52, SEQ53, SEQ54, SEQ55, SEQ56, SEQ57, SEQ58, SEQ59, SEQ60, SEQ61, SEQ62, SEQ63, SEQ64, SEQ65, SEQ66, SEQ67, SEQ68, SEQ69, SEQ70, SEQ71, SEQ72, SEQ73, SEQ74, SEQ75, SEQ76, SEQ77, SEQ78, SEQ79, SEQ80, SEQ81, SEQ82, SEQ83, SEQ84, SEQ85, SEQ86, SEQ87, SEQ88, SEQ89, SEQ90, SEQ91, SEQ92, SEQ93, SEQ94, SEQ95, SEQ96, SEQ97, SEQ98, SEQ99, SEQ100, SEQ101, SEQ102, SEQ103, SEQ104, SEQ105, SEQ106, SEQ107, SEQ108, SEQ109, SEQ110, SEQ111, SEQ112, SEQ113, SEQ114, SEQ115, SEQ116, SEQ117, SEQ118, SEQ119, SEQ120, SEQ121, SEQ122, SEQ123, SEQ124, SEQ125, SEQ126, SEQ127, SEQ128, SEQ129, SEQ130, SEQ131, SEQ132, SEQ133, SEQ134, SEQ135, SEQ136, SEQ137, SEQ138, SEQ139, SEQ140, SEQ141, SEQ142, SEQ143, SEQ144, SEQ145, SEQ146, SEQ147, SEQ148, SEQ149, SEQ150, SEQ151, SEQ152, SEQ153, SEQ154, SEQ155, SEQ156, SEQ157, SEQ158, SEQ159, SEQ160, SEQ161, SEQ162, SEQ163, SEQ164, SEQ165, SEQ166, SEQ167, SEQ168, SEQ169, SEQ170, SEQ171, SEQ172, SEQ173, SEQ174, SEQ175, SEQ176, SEQ177, SEQ178, SEQ179, SEQ180, SEQ181, SEQ182, SEQ183, SEQ184, SEQ185, SEQ186, SEQ187, SEQ188, SEQ189, SEQ190, SEQ191, SEQ192, SEQ193, SEQ194, SEQ195, SEQ196, SEQ197, SEQ198, SEQ199, SEQ200, SEQ201, SEQ202, SEQ203, SEQ204, SEQ205, SEQ206, SEQ207, SEQ208, SEQ209, SEQ210, SEQ211, SEQ212, SEQ213, SEQ214, SEQ215, SEQ216, SEQ217, SEQ218, SEQ219, SEQ220, SEQ221, SEQ222, SEQ223, SEQ224, SEQ225, SEQ226, SEQ227, SEQ228, SEQ229, SEQ230, SEQ231, SEQ232, SEQ233, SEQ234, SEQ235, SEQ236, SEQ237, SEQ238, SEQ239, SEQ240, SEQ241, SEQ242, SEQ243, SEQ244, SEQ245, SEQ246, SEQ247, SEQ248, SEQ249, SEQ250, SEQ251, SEQ252, SEQ253, SEQ254, SEQ255, SEQ256, SEQ257, SEQ258, SEQ259, SEQ260, SEQ261, SEQ262, SEQ263, SEQ264, SEQ265, SEQ266, SEQ267, SEQ268, SEQ269, SEQ270, SEQ271, SEQ272, SEQ273, SEQ274, SEQ275, SEQ276, SEQ277, SEQ278, SEQ279, SEQ280, SEQ281, SEQ282, SEQ283, SEQ284, SEQ285, SEQ286, SEQ287, SEQ288, SEQ289, SEQ290, SEQ291, SEQ292, SEQ293, SEQ294, SEQ295, SEQ296, SEQ297, SEQ298, SEQ299, SEQ300, SEQ301, SEQ302, SEQ303, SEQ304, SEQ305, SEQ306, SEQ307, SEQ308, SEQ309, SEQ310, SEQ311, SEQ312, SEQ313, SEQ314, SEQ315, SEQ316, SEQ317, SEQ318, SEQ319, SEQ320, SEQ321, SEQ322, SEQ323, SEQ324, SEQ325, SEQ326, SEQ327, SEQ328, SEQ329, SEQ330, SEQ331, SEQ332, SEQ333, SEQ334, SEQ335, SEQ336, SEQ337, SEQ338, SEQ339, SEQ340, SEQ341, SEQ342, SEQ343, SEQ344, SEQ345, SEQ346, SEQ347, SEQ348, SEQ349, SEQ350, SEQ351, SEQ352, SEQ353, SEQ354, SEQ355, };

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
