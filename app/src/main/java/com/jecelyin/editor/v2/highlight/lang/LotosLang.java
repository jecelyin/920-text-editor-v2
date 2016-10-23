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
public class LotosLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"(*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*)\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"\\\\s*(let|library|process|specification|type|>>).*|\\\\s*(\\\\(|\\\\[\\\\]|\\\\[>|\\\\|\\\\||\\\\|\\\\|\\\\||\\\\|\\\\[.*\\\\]\\\\||\\\\[.*\\\\]\\\\s*->)\\\\s*\",\"NAME\":\"indentNextLines\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"FALSE\",\"IGNORE_CASE\":\"TRUE\"},\"child\":[{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"TYPE\":\"COMMENT1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"(*\"},{\"tag\":\"END\",\"text\":\"*)\"}]},{\"tag\":\"SEQ\",\"text\":\">>\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"[>\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"|||\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"||\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"|[\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"]|\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"[]\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"accept\"},{\"tag\":\"KEYWORD1\",\"text\":\"actualizedby\"},{\"tag\":\"KEYWORD1\",\"text\":\"any\"},{\"tag\":\"KEYWORD1\",\"text\":\"behavior\"},{\"tag\":\"KEYWORD1\",\"text\":\"behaviour\"},{\"tag\":\"KEYWORD1\",\"text\":\"choice\"},{\"tag\":\"KEYWORD1\",\"text\":\"endlib\"},{\"tag\":\"KEYWORD1\",\"text\":\"endproc\"},{\"tag\":\"KEYWORD1\",\"text\":\"endspec\"},{\"tag\":\"KEYWORD1\",\"text\":\"endtype\"},{\"tag\":\"KEYWORD1\",\"text\":\"eqns\"},{\"tag\":\"KEYWORD1\",\"text\":\"exit\"},{\"tag\":\"KEYWORD1\",\"text\":\"for\"},{\"tag\":\"KEYWORD1\",\"text\":\"forall\"},{\"tag\":\"KEYWORD1\",\"text\":\"formaleqns\"},{\"tag\":\"KEYWORD1\",\"text\":\"formalopns\"},{\"tag\":\"KEYWORD1\",\"text\":\"formalsorts\"},{\"tag\":\"KEYWORD1\",\"text\":\"hide\"},{\"tag\":\"KEYWORD1\",\"text\":\"i\"},{\"tag\":\"KEYWORD1\",\"text\":\"in\"},{\"tag\":\"KEYWORD1\",\"text\":\"is\"},{\"tag\":\"KEYWORD1\",\"text\":\"let\"},{\"tag\":\"KEYWORD1\",\"text\":\"library\"},{\"tag\":\"KEYWORD1\",\"text\":\"noexit\"},{\"tag\":\"KEYWORD1\",\"text\":\"of\"},{\"tag\":\"KEYWORD1\",\"text\":\"ofsort\"},{\"tag\":\"KEYWORD1\",\"text\":\"opnnames\"},{\"tag\":\"KEYWORD1\",\"text\":\"opns\"},{\"tag\":\"KEYWORD1\",\"text\":\"par\"},{\"tag\":\"KEYWORD1\",\"text\":\"process\"},{\"tag\":\"KEYWORD1\",\"text\":\"renamedby\"},{\"tag\":\"KEYWORD1\",\"text\":\"sortnames\"},{\"tag\":\"KEYWORD1\",\"text\":\"sorts\"},{\"tag\":\"KEYWORD1\",\"text\":\"specification\"},{\"tag\":\"KEYWORD1\",\"text\":\"stop\"},{\"tag\":\"KEYWORD1\",\"text\":\"type\"},{\"tag\":\"KEYWORD1\",\"text\":\"using\"},{\"tag\":\"KEYWORD1\",\"text\":\"where\"},{\"tag\":\"KEYWORD2\",\"text\":\"Bit\"},{\"tag\":\"KEYWORD2\",\"text\":\"BitString\"},{\"tag\":\"KEYWORD2\",\"text\":\"Bool\"},{\"tag\":\"KEYWORD2\",\"text\":\"DecDigit\"},{\"tag\":\"KEYWORD2\",\"text\":\"DecString\"},{\"tag\":\"KEYWORD2\",\"text\":\"Element\"},{\"tag\":\"KEYWORD2\",\"text\":\"FBool\"},{\"tag\":\"KEYWORD2\",\"text\":\"HexDigit\"},{\"tag\":\"KEYWORD2\",\"text\":\"HexString\"},{\"tag\":\"KEYWORD2\",\"text\":\"OctDigit\"},{\"tag\":\"KEYWORD2\",\"text\":\"Octet\"},{\"tag\":\"KEYWORD2\",\"text\":\"OctString\"},{\"tag\":\"KEYWORD2\",\"text\":\"Nat\"},{\"tag\":\"KEYWORD2\",\"text\":\"NonEmptyString\"},{\"tag\":\"KEYWORD2\",\"text\":\"OctetString\"},{\"tag\":\"KEYWORD2\",\"text\":\"Set\"},{\"tag\":\"KEYWORD2\",\"text\":\"String\"},{\"tag\":\"KEYWORD2\",\"text\":\"BasicNaturalNumber\"},{\"tag\":\"KEYWORD2\",\"text\":\"BasicNonEmptyString\"},{\"tag\":\"KEYWORD2\",\"text\":\"BitNatRepr\"},{\"tag\":\"KEYWORD2\",\"text\":\"Boolean\"},{\"tag\":\"KEYWORD2\",\"text\":\"FBoolean\"},{\"tag\":\"KEYWORD2\",\"text\":\"DecNatRepr\"},{\"tag\":\"KEYWORD2\",\"text\":\"HexNatRepr\"},{\"tag\":\"KEYWORD2\",\"text\":\"NatRepresentations\"},{\"tag\":\"KEYWORD2\",\"text\":\"NaturalNumber\"},{\"tag\":\"KEYWORD2\",\"text\":\"OctNatRepr\"},{\"tag\":\"KEYWORD2\",\"text\":\"RicherNonEmptyString\"},{\"tag\":\"KEYWORD2\",\"text\":\"String0\"},{\"tag\":\"KEYWORD2\",\"text\":\"String1\"},{\"tag\":\"LITERAL1\",\"text\":\"false\"},{\"tag\":\"LITERAL1\",\"text\":\"true\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
