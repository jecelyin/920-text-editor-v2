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
public class ObjectiveCLang implements LangDefine {
    private final static String JSON = "{\"tag\":\"MODE\",\"text\":\"\",\"child\":[{\"tag\":\"PROPS\",\"text\":\"\",\"child\":[{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"/*\",\"NAME\":\"commentStart\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"*/\",\"NAME\":\"commentEnd\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"//\",\"NAME\":\"lineComment\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\",+-=<>/?^&*\",\"NAME\":\"wordBreakChars\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"{\",\"NAME\":\"indentOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"}\",\"NAME\":\"indentCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"(\",\"NAME\":\"unalignedOpenBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\")\",\"NAME\":\"unalignedCloseBrackets\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"\\\\s*(((if|while)\\\\s*\\\\(|else\\\\s*|else\\\\s+if\\\\s*\\\\(|for\\\\s*\\\\(.*\\\\))[^{;]*)\",\"NAME\":\"indentNextLine\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\"^.*(default:\\\\s*|case.*:.*)$\",\"NAME\":\"unindentThisLine\"}},{\"tag\":\"PROPERTY\",\"attrs\":{\"VALUE\":\":\",\"NAME\":\"electricKeys\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DIGIT_RE\":\"[0-9][0-9a-zA-Z]*\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN\",\"text\":\"#\",\"attrs\":{\"AT_WHITESPACE_END\":\"TRUE\",\"TYPE\":\"KEYWORD2\",\"DELEGATE\":\"CPP\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"c::LEX\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"c::CORE\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"CORE\"}}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"CORE\",\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DIGIT_RE\":\"[0-9][0-9a-zA-Z]*\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"KEYWORD3\",\"text\":\"id\"},{\"tag\":\"KEYWORD3\",\"text\":\"Class\"},{\"tag\":\"KEYWORD3\",\"text\":\"SEL\"},{\"tag\":\"KEYWORD3\",\"text\":\"IMP\"},{\"tag\":\"KEYWORD3\",\"text\":\"BOOL\"},{\"tag\":\"KEYWORD1\",\"text\":\"oneway\"},{\"tag\":\"KEYWORD1\",\"text\":\"in\"},{\"tag\":\"KEYWORD1\",\"text\":\"out\"},{\"tag\":\"KEYWORD1\",\"text\":\"inout\"},{\"tag\":\"KEYWORD1\",\"text\":\"bycopy\"},{\"tag\":\"KEYWORD1\",\"text\":\"byref\"},{\"tag\":\"KEYWORD1\",\"text\":\"self\"},{\"tag\":\"KEYWORD1\",\"text\":\"super\"},{\"tag\":\"KEYWORD1\",\"text\":\"@interface\"},{\"tag\":\"KEYWORD1\",\"text\":\"@implementation\"},{\"tag\":\"KEYWORD1\",\"text\":\"@protocol\"},{\"tag\":\"KEYWORD1\",\"text\":\"@end\"},{\"tag\":\"KEYWORD1\",\"text\":\"@private\"},{\"tag\":\"KEYWORD1\",\"text\":\"@protected\"},{\"tag\":\"KEYWORD1\",\"text\":\"@public\"},{\"tag\":\"KEYWORD1\",\"text\":\"@class\"},{\"tag\":\"KEYWORD1\",\"text\":\"@selector\"},{\"tag\":\"KEYWORD1\",\"text\":\"@endcode\"},{\"tag\":\"KEYWORD1\",\"text\":\"@defs\"},{\"tag\":\"LITERAL2\",\"text\":\"TRUE\"},{\"tag\":\"LITERAL2\",\"text\":\"FALSE\"},{\"tag\":\"LITERAL2\",\"text\":\"YES\"},{\"tag\":\"LITERAL2\",\"text\":\"NO\"},{\"tag\":\"LITERAL2\",\"text\":\"NULL\"},{\"tag\":\"LITERAL2\",\"text\":\"nil\"},{\"tag\":\"LITERAL2\",\"text\":\"Nil\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"CPP\",\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DIGIT_RE\":\"[0-9][0-9a-zA-Z]*\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"include\\\\b\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"c::INCLUDE\",\"HASH_CHAR\":\"include\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"import\\\\b\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"c::INCLUDE\",\"HASH_CHAR\":\"import\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"define\\\\b\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"DEFINE\",\"HASH_CHAR\":\"define\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"endif\\\\b\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"c::LEX\",\"HASH_CHAR\":\"endif\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"elif\\\\b\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"c::CONDITION\",\"HASH_CHAR\":\"elif\"}},{\"tag\":\"EOL_SPAN_REGEXP\",\"text\":\"if\\\\b\",\"attrs\":{\"TYPE\":\"MARKUP\",\"DELEGATE\":\"c::CONDITION\",\"HASH_CHAR\":\"if\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"c::LEX\"}},{\"tag\":\"KEYWORDS\",\"text\":\"\",\"child\":[{\"tag\":\"MARKUP\",\"text\":\"ifdef\"},{\"tag\":\"MARKUP\",\"text\":\"ifndef\"},{\"tag\":\"MARKUP\",\"text\":\"else\"},{\"tag\":\"MARKUP\",\"text\":\"error\"},{\"tag\":\"MARKUP\",\"text\":\"line\"},{\"tag\":\"MARKUP\",\"text\":\"pragma\"},{\"tag\":\"MARKUP\",\"text\":\"undef\"},{\"tag\":\"MARKUP\",\"text\":\"warning\"}]}]},{\"tag\":\"RULES\",\"text\":\"\",\"attrs\":{\"SET\":\"DEFINE\",\"HIGHLIGHT_DIGITS\":\"TRUE\",\"DIGIT_RE\":\"[0-9][0-9a-zA-Z]*\",\"IGNORE_CASE\":\"FALSE\"},\"child\":[{\"tag\":\"SEQ\",\"text\":\"#\",\"attrs\":{\"TYPE\":\"OPERATOR\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"c::LEX\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"c::CORE\"}},{\"tag\":\"IMPORT\",\"attrs\":{\"DELEGATE\":\"CORE\"}}]}]}";

    @Override
    public String langDefine() {
        return JSON;
    }
}
