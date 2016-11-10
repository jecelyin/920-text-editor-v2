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
public class SipLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "true";
        PROPERTY1.NAME = "contextInsensitive";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "\\d+";
        RULES1.IGNORE_CASE = "FALSE";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "=";
        MARK_PREVIOUS1.TYPE = "KEYWORD3";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"REGISTER", "INVITE", "ACK", "CANCEL", "OPTIONS", "BYE", "REFER", "NOTIFY", "MESSAGE", "SUBSCRIBE", "INFO", "PRACK", "UPDATE", "PUBLISH", });
        KEYWORDS1.add("KEYWORD2", new String[]{"Accept", "Accept-Contact", "Accept-Language", "Alert-Info", "Allow", "Allow-Events", "Authentication-Info", "Authorization", "Call-ID", "Call-Info", "Contact", "Content-Disposition", "Content-Encoding", "Content-Language", "Content-Length", "Content-Type", "CSeq", "Date", "Encryption", "Error-Info", "Event", "Expires", "From", "Hide", "In-Reply-To", "Max-Forwards", "Min-Expires", "Min-SE", "MIME-Version", "Organization", "P-Asserted-Identity", "P-Preferred-Identity", "Path", "Priority", "Privacy", "Proxy-Authenticate", "Proxy-Authentication-Info", "Proxy-Authorization", "Proxy-Require", "RAck", "Reason", "Record-Route", "Refer-Sub", "Refer-To", "Referred-By", "Reject-Contact", "Remote-Party-ID", "Replaces", "Reply-To", "Request-Disposition", "Require", "Retry-After", "Route", "RSeq", "Security-Client", "Security-Server", "Security-Verify", "Server", "Service-Route", "Session-Expires", "SIP-ETag", "SIP-If-Match", "Subject", "Subscription-State", "Supported", "Suppress-Body-If-Match", "Suppress-Notify-If-Match", "Timestamp", "To", "Unsupported", "User-Agent", "Via", "Warning", "WWW-Authenticate", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

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
