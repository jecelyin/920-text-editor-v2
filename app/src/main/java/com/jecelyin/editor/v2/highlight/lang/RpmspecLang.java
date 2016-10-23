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
public class RpmspecLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"#\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"true\",\"NAME\":\"contextInsensitive\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"COMMENT1\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"SEQ\",\"text\":\"<\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\">\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"MARKUP\",\"DELEGATE\":\"ATTR\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"%attr(\"},{\"tag\":\"END\",\"text\":\")\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"MARKUP\",\"DELEGATE\":\"VERIFY\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"%verify(\"},{\"tag\":\"END\",\"text\":\")\"}]},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"Source\",\"attrs\":{\"TYPE\":\"KEYWORD1\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"Patch\",\"attrs\":{\"TYPE\":\"KEYWORD1\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"%patch\",\"attrs\":{\"TYPE\":\"FUNCTION\",\"AT_LINE_START\":\"TRUE\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD2\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"${\"},{\"tag\":\"END\",\"text\":\"}\"}]},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"TRUE\",\"TYPE\":\"KEYWORD3\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"%{\"},{\"tag\":\"END\",\"text\":\"}\"}]},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"$#\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"$?\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"$*\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"$<\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"MARK_FOLLOWING\",\"text\":\"$\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"Summary:\"},{\"tag\":\"KEYWORD1\",\"text\":\"Name:\"},{\"tag\":\"KEYWORD1\",\"text\":\"Version:\"},{\"tag\":\"KEYWORD1\",\"text\":\"Release:\"},{\"tag\":\"KEYWORD1\",\"text\":\"Copyright:\"},{\"tag\":\"KEYWORD1\",\"text\":\"Group:\"},{\"tag\":\"KEYWORD1\",\"text\":\"URL:\"},{\"tag\":\"KEYWORD1\",\"text\":\"Packager:\"},{\"tag\":\"KEYWORD1\",\"text\":\"Prefix:\"},{\"tag\":\"KEYWORD1\",\"text\":\"Distribution:\"},{\"tag\":\"KEYWORD1\",\"text\":\"Vendor:\"},{\"tag\":\"KEYWORD1\",\"text\":\"Icon:\"},{\"tag\":\"KEYWORD1\",\"text\":\"Provides:\"},{\"tag\":\"KEYWORD1\",\"text\":\"Requires:\"},{\"tag\":\"KEYWORD1\",\"text\":\"Serial:\"},{\"tag\":\"KEYWORD1\",\"text\":\"Conflicts:\"},{\"tag\":\"KEYWORD1\",\"text\":\"AutoReqProv:\"},{\"tag\":\"KEYWORD1\",\"text\":\"BuildArch:\"},{\"tag\":\"KEYWORD1\",\"text\":\"ExcludeArch:\"},{\"tag\":\"KEYWORD1\",\"text\":\"ExclusiveArch:\"},{\"tag\":\"KEYWORD1\",\"text\":\"ExclusiveOS:\"},{\"tag\":\"KEYWORD1\",\"text\":\"BuildRoot:\"},{\"tag\":\"KEYWORD1\",\"text\":\"NoSource:\"},{\"tag\":\"KEYWORD1\",\"text\":\"NoPatch:\"},{\"tag\":\"LABEL\",\"text\":\"%prep\"},{\"tag\":\"LABEL\",\"text\":\"%install\"},{\"tag\":\"LABEL\",\"text\":\"%description\"},{\"tag\":\"LABEL\",\"text\":\"%build\"},{\"tag\":\"LABEL\",\"text\":\"%files\"},{\"tag\":\"LABEL\",\"text\":\"%clean\"},{\"tag\":\"LABEL\",\"text\":\"%pre\"},{\"tag\":\"LABEL\",\"text\":\"%post\"},{\"tag\":\"LABEL\",\"text\":\"%preun\"},{\"tag\":\"LABEL\",\"text\":\"%postun\"},{\"tag\":\"LABEL\",\"text\":\"%verifyscript\"},{\"tag\":\"FUNCTION\",\"text\":\"%setup\"},{\"tag\":\"FUNCTION\",\"text\":\"%ifarch\"},{\"tag\":\"FUNCTION\",\"text\":\"%ifnarch\"},{\"tag\":\"FUNCTION\",\"text\":\"%ifos\"},{\"tag\":\"FUNCTION\",\"text\":\"%ifnos\"},{\"tag\":\"FUNCTION\",\"text\":\"%else\"},{\"tag\":\"FUNCTION\",\"text\":\"%endif\"},{\"tag\":\"MARKUP\",\"text\":\"%doc\"},{\"tag\":\"MARKUP\",\"text\":\"%config\"},{\"tag\":\"MARKUP\",\"text\":\"%docdir\"},{\"tag\":\"MARKUP\",\"text\":\"%dir\"},{\"tag\":\"MARKUP\",\"text\":\"%package\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"ATTR\",\"HIGHLIGHT_DIGITS\":\"TRUE\"},\"child\":[{\"tag\":\"SEQ\",\"text\":\",\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"-\",\"attrs\":{\"TYPE\":\"OPERATOR\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"VERIFY\"},\"child\":[{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD2\",\"text\":\"owner\"},{\"tag\":\"KEYWORD2\",\"text\":\"group\"},{\"tag\":\"KEYWORD2\",\"text\":\"mode\"},{\"tag\":\"KEYWORD2\",\"text\":\"md5\"},{\"tag\":\"KEYWORD2\",\"text\":\"size\"},{\"tag\":\"KEYWORD2\",\"text\":\"maj\"},{\"tag\":\"KEYWORD2\",\"text\":\"min\"},{\"tag\":\"KEYWORD2\",\"text\":\"symlink\"},{\"tag\":\"KEYWORD2\",\"text\":\"mtime\"},{\"tag\":\"OPERATOR\",\"text\":\"not\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
