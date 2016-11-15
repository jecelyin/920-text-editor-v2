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

package com.jecelyin.editor.v2.highlight;

import com.jecelyin.common.utils.L;
import com.jecelyin.editor.v2.highlight.jedit.Mode;

import java.io.IOException;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class SyntaxParser {
    public static void loadMode(Mode mode) {
        String filename = mode.getFile();
        int langDefine = LangMap.get(filename);
        if (langDefine == 0) {
            L.d("Can't find a lang define: " + filename);
            return;
        }
        L.d("load mode: " + filename);

        ModeObjectHandler handler = new ModeObjectHandler(mode.getName());
        mode.setTokenMarker(handler.getTokenMarker());
        try {
            handler.process(langDefine);
        } catch (IOException e) {
            L.e(e);
        }
    }


}
