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

package com.jecelyin.editor.v2.highlight.jedit;

import java.util.List;

/**
 * Created by jecelyin on 15/9/24.
 */
public class Grammar {
    public List<Property> props;
    public List<Rules> rules;

    public static class Property {
        public String name;
        public String value;
    }

    public static class Rules {
        //rules 属性列表
        public String set;
        public boolean ignore_case;
        public boolean highlight_digits;
        public String digit_re;
        public String escape;
        public TokenValues defaultValue;
        public String no_word_sep;
        //rules 元素列表
        public List<Import> imports;
        public List<Terminate> terminate;
        public List<Seq> seq;
        public List<SeqRegexp> seq_regexp;
        public List<Span> Span;
    }

    public static class Span {

    }

    public static class SeqRegexp {
        public String hash_char;
        public String hash_chars;
        public TokenValues type;
        /* %att-position-mix; start */
        public boolean at_line_start;
        public boolean at_whitespace_end;
        public boolean at_word_start;
        /* %att-position-mix; end */
        public String delegate;
        /* 内容 */
        public String pcdata;
    }

    public static class Seq {
        public TokenValues type;
        public String delegate;
        /* %att-position-mix; start */
        public boolean at_line_start;
        public boolean at_whitespace_end;
        public boolean at_word_start;
        /* %att-position-mix; end */
        /* 内容 */
        public String pcdata;
    }

    public static class Terminate {
        public String at_char;
    }

    public static class Import {
        public String delegate;
    }

    public enum TokenValues {
        NULL("NULL"),
        COMMENT1("COMMENT1"),
        COMMENT2("COMMENT2"),
        COMMENT3("COMMENT3"),
        COMMENT4("COMMENT4"),
        DIGIT("DIGIT"),
        FUNCTION("FUNCTION"),
        INVALID("INVALID"),
        KEYWORD1("KEYWORD1"),
        KEYWORD2("KEYWORD2"),
        KEYWORD3("KEYWORD3"),
        KEYWORD4("KEYWORD4"),
        LABEL("LABEL"),
        LITERAL1("LITERAL1"),
        LITERAL2("LITERAL2"),
        LITERAL3("LITERAL3"),
        LITERAL4("LITERAL4"),
        MARKUP("MARKUP"),
        OPERATOR("OPERATOR"),;

        private final String text;

        TokenValues(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
