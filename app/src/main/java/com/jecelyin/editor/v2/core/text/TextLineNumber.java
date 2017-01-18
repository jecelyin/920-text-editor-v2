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

package com.jecelyin.editor.v2.core.text;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class TextLineNumber {
    private List<LineInfo> lineInfoList = new ArrayList<>();

    public static class LineInfo {
        public String text;
        public int y;

        public LineInfo(String text, int y) {
            this.text = text;
            this.y = y;
        }
    }

    public void clear() {
        lineInfoList.clear();
    }

    public void addLine(String text, int y) {
        lineInfoList.add(new LineInfo(text, y));
    }

    public List<LineInfo> getLines() {
        return lineInfoList;
    }
}
