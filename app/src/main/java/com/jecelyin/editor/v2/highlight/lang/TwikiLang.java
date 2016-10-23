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
public class TwikiLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"noTabs\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"soft\",\"NAME\":\"wrap\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"FALSE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"html::MAIN\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"--\",\"attrs\":{\"TYPE\":\"COMMENT1\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"-{3}[+]{1,6}(?:!!)?\\\\s\",\"attrs\":{\"TYPE\":\"KEYWORD1\",\"AT_LINE_START\":\"TRUE\",\"HASH_CHAR\":\"---+\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\*[^\\\\s*][^*]*\\\\*\",\"attrs\":{\"TYPE\":\"KEYWORD4\",\"AT_LINE_START\":\"FALSE\",\"HASH_CHAR\":\"*\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"__\\\\w.*?\\\\w__\",\"attrs\":{\"TYPE\":\"KEYWORD4\",\"AT_LINE_START\":\"FALSE\",\"HASH_CHAR\":\"__\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"_\\\\w.*?\\\\w_\",\"attrs\":{\"TYPE\":\"KEYWORD4\",\"AT_LINE_START\":\"FALSE\",\"HASH_CHAR\":\"_\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"==\\\\w.*?\\\\w==\",\"attrs\":{\"TYPE\":\"KEYWORD4\",\"AT_LINE_START\":\"FALSE\",\"HASH_CHAR\":\"==\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"=\\\\w.*?\\\\w=\",\"attrs\":{\"TYPE\":\"KEYWORD4\",\"AT_LINE_START\":\"FALSE\",\"HASH_CHAR\":\"=\"}},{\"tag\":\"EOL_SPAN\",\"text\":\"---\",\"attrs\":{\"TYPE\":\"KEYWORD4\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"[A-Z][A-Z.]*[a-z.]+(?:[A-Z][A-Z.]*[a-z.]*[a-z])+\",\"attrs\":{\"HASH_CHARS\":\"ABCDEFGHIJKLMNOPQRSTUVWXYZ\",\"AT_WORD_START\":\"TRUE\",\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"KEYWORD3\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"[[\"},{\"tag\":\"END\",\"text\":\"]]\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<verbatim>\"},{\"tag\":\"END\",\"text\":\"<\\/verbatim>\"}]},{\"tag\":\"SEQ\",\"text\":\"<nop>\",\"attrs\":{\"TYPE\":\"LITERAL2\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"LITERAL2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"<noautolink>\"},{\"tag\":\"END\",\"text\":\"<\\/noautolink>\"}]},{\"tag\":\"SEQ_REGEXP\",\"text\":\"\\\\s{3}\\\\w(?:&nbsp;|-|\\\\w)*?\\\\w+:\\\\s\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"AT_LINE_START\":\"FALSE\",\"HASH_CHAR\":\" \"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"%[A-Z]+(?:\\\\{[^\\\\}]+\\\\})?%\",\"attrs\":{\"TYPE\":\"FUNCTION\",\"HASH_CHAR\":\"%\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"NULL\",\"text\":\"ATTACHURL\"},{\"tag\":\"NULL\",\"text\":\"ATTACHURLPATH\"},{\"tag\":\"NULL\",\"text\":\"BASETOPIC\"},{\"tag\":\"NULL\",\"text\":\"BASEWEB\"},{\"tag\":\"NULL\",\"text\":\"GMTIME\"},{\"tag\":\"NULL\",\"text\":\"HOMETOPIC\"},{\"tag\":\"NULL\",\"text\":\"HTTP_HOST\"},{\"tag\":\"NULL\",\"text\":\"INCLUDE\"},{\"tag\":\"NULL\",\"text\":\"INCLUDINGTOPIC\"},{\"tag\":\"NULL\",\"text\":\"INCLUDINGWEB\"},{\"tag\":\"NULL\",\"text\":\"MAINWEB\"},{\"tag\":\"NULL\",\"text\":\"NOTIFYTOPIC\"},{\"tag\":\"NULL\",\"text\":\"PUBURL\"},{\"tag\":\"NULL\",\"text\":\"PUBURLPATH\"},{\"tag\":\"NULL\",\"text\":\"REMOTE_ADDR\"},{\"tag\":\"NULL\",\"text\":\"REMOTE_PORT\"},{\"tag\":\"NULL\",\"text\":\"REMOTE_USER\"},{\"tag\":\"NULL\",\"text\":\"SCRIPTSUFFIX\"},{\"tag\":\"NULL\",\"text\":\"SCRIPTURL\"},{\"tag\":\"NULL\",\"text\":\"SCRIPTURLPATH\"},{\"tag\":\"NULL\",\"text\":\"SEARCH\"},{\"tag\":\"NULL\",\"text\":\"SERVERTIME\"},{\"tag\":\"NULL\",\"text\":\"SPACEDTOPIC\"},{\"tag\":\"NULL\",\"text\":\"STARTINCLUDE\"},{\"tag\":\"NULL\",\"text\":\"STATISTICSTOPIC\"},{\"tag\":\"NULL\",\"text\":\"STOPINCLUDE\"},{\"tag\":\"NULL\",\"text\":\"TOC\"},{\"tag\":\"NULL\",\"text\":\"TOPIC\"},{\"tag\":\"NULL\",\"text\":\"TOPICLIST\"},{\"tag\":\"NULL\",\"text\":\"TWIKIWEB\"},{\"tag\":\"NULL\",\"text\":\"URLENCODE\"},{\"tag\":\"NULL\",\"text\":\"URLPARAM\"},{\"tag\":\"NULL\",\"text\":\"USERNAME\"},{\"tag\":\"NULL\",\"text\":\"WEB\"},{\"tag\":\"NULL\",\"text\":\"WEBLIST\"},{\"tag\":\"NULL\",\"text\":\"WEBPREFSTOPIC\"},{\"tag\":\"NULL\",\"text\":\"WIKIHOMEURL\"},{\"tag\":\"NULL\",\"text\":\"WIKINAME\"},{\"tag\":\"NULL\",\"text\":\"WIKIPREFSTOPIC\"},{\"tag\":\"NULL\",\"text\":\"WIKITOOLNAME\"},{\"tag\":\"NULL\",\"text\":\"WIKIUSERNAME\"},{\"tag\":\"NULL\",\"text\":\"WIKIUSERSTOPIC\"},{\"tag\":\"NULL\",\"text\":\"WIKIVERSION\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
