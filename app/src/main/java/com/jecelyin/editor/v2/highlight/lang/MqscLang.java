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
public class MqscLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "*";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "true";
        PROPERTY2.NAME = "contextInsensitive";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "*";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN1.AT_LINE_START = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.ESCAPE = "\\";
        SPAN1.MATCH_TYPE = "OPERATOR";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "('";
        END END1 = new END();
        END1.text = "')";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL2";
        SPAN2.ESCAPE = "\\";
        SPAN2.MATCH_TYPE = "OPERATOR";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "(";
        END END2 = new END();
        END2.text = ")";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = "+";
        SEQ1.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("MARKUP", new String[]{"altdate", "alttime", "applicid", "appltype", "authorev", "batches", "batchint", "batchsz", "boqname", "bothresh", "bufsrcvd", "bufssent", "bytsrcvd", "bytssent", "ccsid", "chad", "chadev", "chadexit", "channel", "chltype", "chstada", "chstati", "clusdate", "clusinfo", "clusnl", "clusqmgr", "clusqt", "cluster", "clustime", "clwldata", "clwlexit", "clwlwen", "cmdlevel", "commandq", "conname", "convert", "crdate", "crtime", "curdepth", "curluwid", "curmsgs", "curseqno", "deadq", "defbind", "defprty", "defpsist", "defsopt", "deftype", "defxmitq", "descr", "discint", "distl", "envrdata", "get", "hardenbo", "hbint", "indoubt", "inhibtev", "initq", "ipprocs", "jobname", "localev", "longrts", "longrty", "longtmr", "lstluwid", "lstmsgda", "lstmsgti", "lstseqno", "maxdepth", "maxhands", "maxmsgl", "maxprty", "maxumsgs", "mcaname", "mcastat", "mcatype", "mcauser", "modename", "mrdata", "mrexit", "mrrty", "mrtmr", "msgdata", "msgdlvsq", "msgexit", "msgs", "namcount", "names", "netprty", "npmspeed", "opprocs", "password", "perfmev", "platform", "process", "put", "putaut", "qdepthhi", "qdepthlo", "qdphiev", "qdploev", "qdpmaxev", "qmid", "qmname", "qmtype", "qsvciev", "qsvcint", "qtype", "rcvdata", "rcvexit", "remoteev", "repos", "reposnl", "retintvl", "rname", "rqmname", "scope", "scydata", "scyexit", "senddata", "sendexit", "seqwrap", "share", "shortrts", "shortrty", "shorttmr", "status", "stopreq", "strstpev", "suspend", "syncpt", "targq", "tpname", "trigdata", "trigdpth", "trigger", "trigint", "trigmpri", "trigtype", "trptype", "type", "usage", "userdata", "userid", "xmitq", });
        KEYWORDS1.add("KEYWORD1", new String[]{"all", "alter", "alt", "clear", "define", "def", "delete", "display", "dis", "end", "like", "ping", "refresh", "ref", "replace", "reset", "resolve", "resume", "start", "stop", "suspend", });
        KEYWORDS1.add("KEYWORD2", new String[]{"channel", "chl", "chstatus", "chst", "clusqmgr", "process", "proc", "namelist", "nl", "qalias", "qa", "qcluster", "qc", "qlocal", "ql", "qmodel", "qm", "qmgr", "qremote", "qr", "queue", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, };

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
