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

package com.jecelyin.editor.v2.utils;

import java.util.regex.Matcher;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class MatcherResult {
    private final int start;
    private final int end;
    private final int groupCount;
    private final String[] groups;

    public MatcherResult(Matcher m) {
        start = m.start();
        end = m.end();
        groupCount = m.groupCount()+1;

        groups = new String[groupCount];
        for (int i = 0; i < groupCount; i++) {
            groups[i] = m.group(i);
        }
    }

    public int start() {
        return start;
    }

    public int end() {
        return end;
    }

    public int groupCount() {
        return groupCount;
    }

    public String group(int group) {
        return groups[group];
    }
}
