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

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class SipLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"contextInsensitive\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DIGIT_RE\":\"\\\\d+\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"MARK_PREVIOUS\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"KEYWORD3\",\"MATCH_TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"REGISTER\"},{\"tag\":\"KEYWORD1\",\"text\":\"INVITE\"},{\"tag\":\"KEYWORD1\",\"text\":\"ACK\"},{\"tag\":\"KEYWORD1\",\"text\":\"CANCEL\"},{\"tag\":\"KEYWORD1\",\"text\":\"OPTIONS\"},{\"tag\":\"KEYWORD1\",\"text\":\"BYE\"},{\"tag\":\"KEYWORD1\",\"text\":\"REFER\"},{\"tag\":\"KEYWORD1\",\"text\":\"NOTIFY\"},{\"tag\":\"KEYWORD1\",\"text\":\"MESSAGE\"},{\"tag\":\"KEYWORD1\",\"text\":\"SUBSCRIBE\"},{\"tag\":\"KEYWORD1\",\"text\":\"INFO\"},{\"tag\":\"KEYWORD1\",\"text\":\"PRACK\"},{\"tag\":\"KEYWORD1\",\"text\":\"UPDATE\"},{\"tag\":\"KEYWORD1\",\"text\":\"PUBLISH\"},{\"tag\":\"KEYWORD2\",\"text\":\"Accept\"},{\"tag\":\"KEYWORD2\",\"text\":\"Accept-Contact\"},{\"tag\":\"KEYWORD2\",\"text\":\"Accept-Language\"},{\"tag\":\"KEYWORD2\",\"text\":\"Alert-Info\"},{\"tag\":\"KEYWORD2\",\"text\":\"Allow\"},{\"tag\":\"KEYWORD2\",\"text\":\"Allow-Events\"},{\"tag\":\"KEYWORD2\",\"text\":\"Authentication-Info\"},{\"tag\":\"KEYWORD2\",\"text\":\"Authorization\"},{\"tag\":\"KEYWORD2\",\"text\":\"Call-ID\"},{\"tag\":\"KEYWORD2\",\"text\":\"Call-Info\"},{\"tag\":\"KEYWORD2\",\"text\":\"Contact\"},{\"tag\":\"KEYWORD2\",\"text\":\"Content-Disposition\"},{\"tag\":\"KEYWORD2\",\"text\":\"Content-Encoding\"},{\"tag\":\"KEYWORD2\",\"text\":\"Content-Language\"},{\"tag\":\"KEYWORD2\",\"text\":\"Content-Length\"},{\"tag\":\"KEYWORD2\",\"text\":\"Content-Type\"},{\"tag\":\"KEYWORD2\",\"text\":\"CSeq\"},{\"tag\":\"KEYWORD2\",\"text\":\"Date\"},{\"tag\":\"KEYWORD2\",\"text\":\"Encryption\"},{\"tag\":\"KEYWORD2\",\"text\":\"Error-Info\"},{\"tag\":\"KEYWORD2\",\"text\":\"Event\"},{\"tag\":\"KEYWORD2\",\"text\":\"Expires\"},{\"tag\":\"KEYWORD2\",\"text\":\"From\"},{\"tag\":\"KEYWORD2\",\"text\":\"Hide\"},{\"tag\":\"KEYWORD2\",\"text\":\"In-Reply-To\"},{\"tag\":\"KEYWORD2\",\"text\":\"Max-Forwards\"},{\"tag\":\"KEYWORD2\",\"text\":\"Min-Expires\"},{\"tag\":\"KEYWORD2\",\"text\":\"Min-SE\"},{\"tag\":\"KEYWORD2\",\"text\":\"MIME-Version\"},{\"tag\":\"KEYWORD2\",\"text\":\"Organization\"},{\"tag\":\"KEYWORD2\",\"text\":\"P-Asserted-Identity\"},{\"tag\":\"KEYWORD2\",\"text\":\"P-Preferred-Identity\"},{\"tag\":\"KEYWORD2\",\"text\":\"Path\"},{\"tag\":\"KEYWORD2\",\"text\":\"Priority\"},{\"tag\":\"KEYWORD2\",\"text\":\"Privacy\"},{\"tag\":\"KEYWORD2\",\"text\":\"Proxy-Authenticate\"},{\"tag\":\"KEYWORD2\",\"text\":\"Proxy-Authentication-Info\"},{\"tag\":\"KEYWORD2\",\"text\":\"Proxy-Authorization\"},{\"tag\":\"KEYWORD2\",\"text\":\"Proxy-Require\"},{\"tag\":\"KEYWORD2\",\"text\":\"RAck\"},{\"tag\":\"KEYWORD2\",\"text\":\"Reason\"},{\"tag\":\"KEYWORD2\",\"text\":\"Record-Route\"},{\"tag\":\"KEYWORD2\",\"text\":\"Refer-Sub\"},{\"tag\":\"KEYWORD2\",\"text\":\"Refer-To\"},{\"tag\":\"KEYWORD2\",\"text\":\"Referred-By\"},{\"tag\":\"KEYWORD2\",\"text\":\"Reject-Contact\"},{\"tag\":\"KEYWORD2\",\"text\":\"Remote-Party-ID\"},{\"tag\":\"KEYWORD2\",\"text\":\"Replaces\"},{\"tag\":\"KEYWORD2\",\"text\":\"Reply-To\"},{\"tag\":\"KEYWORD2\",\"text\":\"Request-Disposition\"},{\"tag\":\"KEYWORD2\",\"text\":\"Require\"},{\"tag\":\"KEYWORD2\",\"text\":\"Retry-After\"},{\"tag\":\"KEYWORD2\",\"text\":\"Route\"},{\"tag\":\"KEYWORD2\",\"text\":\"RSeq\"},{\"tag\":\"KEYWORD2\",\"text\":\"Security-Client\"},{\"tag\":\"KEYWORD2\",\"text\":\"Security-Server\"},{\"tag\":\"KEYWORD2\",\"text\":\"Security-Verify\"},{\"tag\":\"KEYWORD2\",\"text\":\"Server\"},{\"tag\":\"KEYWORD2\",\"text\":\"Service-Route\"},{\"tag\":\"KEYWORD2\",\"text\":\"Session-Expires\"},{\"tag\":\"KEYWORD2\",\"text\":\"SIP-ETag\"},{\"tag\":\"KEYWORD2\",\"text\":\"SIP-If-Match\"},{\"tag\":\"KEYWORD2\",\"text\":\"Subject\"},{\"tag\":\"KEYWORD2\",\"text\":\"Subscription-State\"},{\"tag\":\"KEYWORD2\",\"text\":\"Supported\"},{\"tag\":\"KEYWORD2\",\"text\":\"Suppress-Body-If-Match\"},{\"tag\":\"KEYWORD2\",\"text\":\"Suppress-Notify-If-Match\"},{\"tag\":\"KEYWORD2\",\"text\":\"Timestamp\"},{\"tag\":\"KEYWORD2\",\"text\":\"To\"},{\"tag\":\"KEYWORD2\",\"text\":\"Unsupported\"},{\"tag\":\"KEYWORD2\",\"text\":\"User-Agent\"},{\"tag\":\"KEYWORD2\",\"text\":\"Via\"},{\"tag\":\"KEYWORD2\",\"text\":\"Warning\"},{\"tag\":\"KEYWORD2\",\"text\":\"WWW-Authenticate\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
