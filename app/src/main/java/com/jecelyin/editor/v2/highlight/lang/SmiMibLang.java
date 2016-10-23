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
public class SmiMibLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"--\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"-_\",\"NAME\":\"noWordSep\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"{\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"}\",\"NAME\":\"indentCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\".*::=\\\\s*\\\\{.*\\\\}\\\\s*$\",\"NAME\":\"unindentNextLines\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\".*(::=|AGENT-CAPABILITIES|DESCRIPTION|IMPORTS|MODULE-COMPLIANCE|MODULE-IDENTITY|NOTIFICATION-GROUP|NOTIFICATION-TYPE|OBJECT-GROUP|OBJECT-IDENTITY|OBJECT-TYPE|TEXTUAL-CONVENTION)\\\\s*$\",\"NAME\":\"indentNextLines\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"--\",\"attrs\":{\"TYPE\":\"COMMENT1\"}},{\"tag\":\"SPAN\",\"text\":\"\",\"attrs\":{\"NO_LINE_BREAK\":\"FALSE\",\"TYPE\":\"LITERAL1\"},\"child\":[{\"tag\":\"BEGIN\",\"text\":\"\\\"\"},{\"tag\":\"END\",\"text\":\"\\\"\"}]},{\"tag\":\"SEQ\",\"text\":\"::=\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"}\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"{\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"SEQ\",\"text\":\"OBJECT IDENTIFIER\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"SEQUENCE OF\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"SEQ\",\"text\":\"OCTET STRING\",\"attrs\":{\"TYPE\":\"KEYWORD2\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"FUNCTION\",\"text\":\"AGENT-CAPABILITIES\"},{\"tag\":\"FUNCTION\",\"text\":\"BEGIN\"},{\"tag\":\"FUNCTION\",\"text\":\"END\"},{\"tag\":\"FUNCTION\",\"text\":\"FROM\"},{\"tag\":\"FUNCTION\",\"text\":\"IMPORTS\"},{\"tag\":\"FUNCTION\",\"text\":\"MODULE-COMPLIANCE\"},{\"tag\":\"FUNCTION\",\"text\":\"MODULE-IDENTITY\"},{\"tag\":\"FUNCTION\",\"text\":\"NOTIFICATION-GROUP\"},{\"tag\":\"FUNCTION\",\"text\":\"NOTIFICATION-TYPE\"},{\"tag\":\"FUNCTION\",\"text\":\"OBJECT-GROUP\"},{\"tag\":\"FUNCTION\",\"text\":\"OBJECT-IDENTITY\"},{\"tag\":\"FUNCTION\",\"text\":\"OBJECT-TYPE\"},{\"tag\":\"FUNCTION\",\"text\":\"TEXTUAL-CONVENTION\"},{\"tag\":\"KEYWORD1\",\"text\":\"ACCESS\"},{\"tag\":\"KEYWORD1\",\"text\":\"AUGMENTS\"},{\"tag\":\"KEYWORD1\",\"text\":\"CONTACT-INFO\"},{\"tag\":\"KEYWORD1\",\"text\":\"CREATION-REQUIRES\"},{\"tag\":\"KEYWORD1\",\"text\":\"DEFINITIONS\"},{\"tag\":\"KEYWORD1\",\"text\":\"DEFVAL\"},{\"tag\":\"KEYWORD1\",\"text\":\"DESCRIPTION\"},{\"tag\":\"KEYWORD1\",\"text\":\"DISPLAY-HINT\"},{\"tag\":\"KEYWORD1\",\"text\":\"GROUP\"},{\"tag\":\"KEYWORD1\",\"text\":\"INCLUDES\"},{\"tag\":\"KEYWORD1\",\"text\":\"INDEX\"},{\"tag\":\"KEYWORD1\",\"text\":\"LAST-UPDATED\"},{\"tag\":\"KEYWORD1\",\"text\":\"MANDATORY-GROUPS\"},{\"tag\":\"KEYWORD1\",\"text\":\"MAX-ACCESS\"},{\"tag\":\"KEYWORD1\",\"text\":\"MIN-ACCESS\"},{\"tag\":\"KEYWORD1\",\"text\":\"MODULE\"},{\"tag\":\"KEYWORD1\",\"text\":\"NOTIFICATIONS\"},{\"tag\":\"KEYWORD1\",\"text\":\"OBJECT\"},{\"tag\":\"KEYWORD1\",\"text\":\"OBJECTS\"},{\"tag\":\"KEYWORD1\",\"text\":\"ORGANIZATION\"},{\"tag\":\"KEYWORD1\",\"text\":\"PRODUCT-RELEASE\"},{\"tag\":\"KEYWORD1\",\"text\":\"REFERENCE\"},{\"tag\":\"KEYWORD1\",\"text\":\"REVISION\"},{\"tag\":\"KEYWORD1\",\"text\":\"STATUS\"},{\"tag\":\"KEYWORD1\",\"text\":\"SYNTAX\"},{\"tag\":\"KEYWORD1\",\"text\":\"SUPPORTS\"},{\"tag\":\"KEYWORD1\",\"text\":\"UNITS\"},{\"tag\":\"KEYWORD1\",\"text\":\"VARIATION\"},{\"tag\":\"KEYWORD1\",\"text\":\"WRITE-SYNTAX\"},{\"tag\":\"KEYWORD2\",\"text\":\"AutonomousType\"},{\"tag\":\"KEYWORD2\",\"text\":\"BITS\"},{\"tag\":\"KEYWORD2\",\"text\":\"Counter32\"},{\"tag\":\"KEYWORD2\",\"text\":\"Counter64\"},{\"tag\":\"KEYWORD2\",\"text\":\"DateAndTime\"},{\"tag\":\"KEYWORD2\",\"text\":\"DisplayString\"},{\"tag\":\"KEYWORD2\",\"text\":\"Gauge32\"},{\"tag\":\"KEYWORD2\",\"text\":\"InstancePointer\"},{\"tag\":\"KEYWORD2\",\"text\":\"INTEGER\"},{\"tag\":\"KEYWORD2\",\"text\":\"Integer32\"},{\"tag\":\"KEYWORD2\",\"text\":\"IpAddress\"},{\"tag\":\"KEYWORD2\",\"text\":\"MacAddress\"},{\"tag\":\"KEYWORD2\",\"text\":\"Opaque\"},{\"tag\":\"KEYWORD2\",\"text\":\"PhysAddress\"},{\"tag\":\"KEYWORD2\",\"text\":\"RowPointer\"},{\"tag\":\"KEYWORD2\",\"text\":\"RowStatus\"},{\"tag\":\"KEYWORD2\",\"text\":\"SEQUENCE\"},{\"tag\":\"KEYWORD2\",\"text\":\"TAddress\"},{\"tag\":\"KEYWORD2\",\"text\":\"TDomain\"},{\"tag\":\"KEYWORD2\",\"text\":\"TestAndIncr\"},{\"tag\":\"KEYWORD2\",\"text\":\"TimeInterval\"},{\"tag\":\"KEYWORD2\",\"text\":\"TimeStamp\"},{\"tag\":\"KEYWORD2\",\"text\":\"TimeTicks\"},{\"tag\":\"KEYWORD2\",\"text\":\"TruthValue\"},{\"tag\":\"KEYWORD2\",\"text\":\"StorageType\"},{\"tag\":\"KEYWORD2\",\"text\":\"Unsigned32\"},{\"tag\":\"KEYWORD2\",\"text\":\"VariablePointer\"},{\"tag\":\"KEYWORD3\",\"text\":\"accessible-for-notify\"},{\"tag\":\"KEYWORD3\",\"text\":\"current\"},{\"tag\":\"KEYWORD3\",\"text\":\"deprecated\"},{\"tag\":\"KEYWORD3\",\"text\":\"not-accessible\"},{\"tag\":\"KEYWORD3\",\"text\":\"obsolete\"},{\"tag\":\"KEYWORD3\",\"text\":\"read-create\"},{\"tag\":\"KEYWORD3\",\"text\":\"read-only\"},{\"tag\":\"KEYWORD3\",\"text\":\"read-write\"},{\"tag\":\"KEYWORD3\",\"text\":\"SIZE\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
