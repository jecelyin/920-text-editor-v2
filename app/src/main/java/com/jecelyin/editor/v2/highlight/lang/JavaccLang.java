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
public class JavaccLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*/\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"//\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\",+-=<>/?^&*\",\"NAME\":\"wordBreakChars\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"{\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"}\",\"NAME\":\"indentCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"(\",\"NAME\":\"unalignedOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\")\",\"NAME\":\"unalignedCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"\\\\s*(((if|while)\\\\s*\\\\(|else\\\\s+|else$|else\\\\s+if\\\\s*\\\\(|for\\\\s*\\\\(.*\\\\))[^{;]*)\",\"NAME\":\"indentNextLine\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"^.*(default:\\\\s*|case.*:.*)$\",\"NAME\":\"unindentThisLine\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\":\",\"NAME\":\"electricKeys\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"java::MAIN\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"<[[:space:]]*\\\\w+[[:space:]]*[:]\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"HASH_CHAR\":\"<\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"<[[:space:]]*\\\\w+([[:space:]]*[,][[:space:]]*\\\\w+[[:space:]]*)*[[:space:]]*>\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"HASH_CHAR\":\"<\"}},{\"tag\":\"SEQ_REGEXP\",\"text\":\"[#]\\\\w+[:]\",\"attrs\":{\"TYPE\":\"KEYWORD2\",\"HASH_CHAR\":\"#\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD1\",\"text\":\"EOF\"},{\"tag\":\"KEYWORD1\",\"text\":\"IGNORE_CASE\"},{\"tag\":\"KEYWORD1\",\"text\":\"JAVACODE\"},{\"tag\":\"KEYWORD1\",\"text\":\"LOOKAHEAD\"},{\"tag\":\"KEYWORD1\",\"text\":\"MORE\"},{\"tag\":\"KEYWORD1\",\"text\":\"PARSER_BEGIN\"},{\"tag\":\"KEYWORD1\",\"text\":\"PARSER_END\"},{\"tag\":\"KEYWORD1\",\"text\":\"SKIP\"},{\"tag\":\"KEYWORD1\",\"text\":\"SPECIAL_TOKEN\"},{\"tag\":\"KEYWORD1\",\"text\":\"TOKEN\"},{\"tag\":\"KEYWORD1\",\"text\":\"TOKEN_MGR_DECLS\"},{\"tag\":\"KEYWORD1\",\"text\":\"options\"},{\"tag\":\"KEYWORD1\",\"text\":\"CHOICE_AMBIGUITY_CHECK\"},{\"tag\":\"KEYWORD1\",\"text\":\"OTHER_AMBIGUITY_CHECK\"},{\"tag\":\"KEYWORD1\",\"text\":\"STATIC\"},{\"tag\":\"KEYWORD1\",\"text\":\"SUPPORT_CLASS_VISIBILITY_PUBLIC\"},{\"tag\":\"KEYWORD1\",\"text\":\"DEBUG_PARSER\"},{\"tag\":\"KEYWORD1\",\"text\":\"DEBUG_LOOKAHEAD\"},{\"tag\":\"KEYWORD1\",\"text\":\"DEBUG_TOKEN_MANAGER\"},{\"tag\":\"KEYWORD1\",\"text\":\"ERROR_REPORTING\"},{\"tag\":\"KEYWORD1\",\"text\":\"JAVA_UNICODE_ESCAPE\"},{\"tag\":\"KEYWORD1\",\"text\":\"UNICODE_INPUT\"},{\"tag\":\"KEYWORD1\",\"text\":\"IGNORE_CASE\"},{\"tag\":\"KEYWORD1\",\"text\":\"USER_TOKEN_MANAGER\"},{\"tag\":\"KEYWORD1\",\"text\":\"USER_CHAR_STREAM\"},{\"tag\":\"KEYWORD1\",\"text\":\"BUILD_PARSER\"},{\"tag\":\"KEYWORD1\",\"text\":\"BUILD_TOKEN_MANAGER\"},{\"tag\":\"KEYWORD1\",\"text\":\"TOKEN_EXTENDS\"},{\"tag\":\"KEYWORD1\",\"text\":\"TOKEN_FACTORY\"},{\"tag\":\"KEYWORD1\",\"text\":\"TOKEN_MANAGER_USES_PARSER\"},{\"tag\":\"KEYWORD1\",\"text\":\"SANITY_CHECK\"},{\"tag\":\"KEYWORD1\",\"text\":\"FORCE_LA_CHECK\"},{\"tag\":\"KEYWORD1\",\"text\":\"COMMON_TOKEN_ACTION\"},{\"tag\":\"KEYWORD1\",\"text\":\"CACHE_TOKENS\"},{\"tag\":\"KEYWORD1\",\"text\":\"OUTPUT_DIRECTORY\"},{\"tag\":\"KEYWORD1\",\"text\":\"BUILD_NODE_FILES\"},{\"tag\":\"KEYWORD1\",\"text\":\"MULTI\"},{\"tag\":\"KEYWORD1\",\"text\":\"NODE_DEFAULT_VOID\"},{\"tag\":\"KEYWORD1\",\"text\":\"NODE_CLASS\"},{\"tag\":\"KEYWORD1\",\"text\":\"NODE_FACTORY\"},{\"tag\":\"KEYWORD1\",\"text\":\"NODE_PACKAGE\"},{\"tag\":\"KEYWORD1\",\"text\":\"NODE_EXTENDS\"},{\"tag\":\"KEYWORD1\",\"text\":\"NODE_PREFIX\"},{\"tag\":\"KEYWORD1\",\"text\":\"NODE_SCOPE_HOOK\"},{\"tag\":\"KEYWORD1\",\"text\":\"NODE_USES_PARSER\"},{\"tag\":\"KEYWORD1\",\"text\":\"TRACK_TOKENS\"},{\"tag\":\"KEYWORD1\",\"text\":\"STATIC\"},{\"tag\":\"KEYWORD1\",\"text\":\"VISITOR\"},{\"tag\":\"KEYWORD1\",\"text\":\"VISITOR_DATA_TYPE\"},{\"tag\":\"KEYWORD1\",\"text\":\"VISITOR_RETURN_TYPE\"},{\"tag\":\"KEYWORD1\",\"text\":\"VISITOR_EXCEPTION\"},{\"tag\":\"KEYWORD1\",\"text\":\"JJTREE_OUTPUT_DIRECTORY\"},{\"tag\":\"KEYWORD2\",\"text\":\"DEFAULT\"}]}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
