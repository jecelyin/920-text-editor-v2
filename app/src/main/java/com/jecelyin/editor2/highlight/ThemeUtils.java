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

package com.jecelyin.editor2.highlight;

import android.graphics.Color;

/**
 * Created by jecelyin on 15/12/9.
 */
public class ThemeUtils {
    public static ThemeInfo getThemeInfo() {
        ThemeInfo t = new ThemeInfo();

        t.foreground = Color.parseColor("#000000");
        t.background = Color.parseColor("#FFFFFF");
        t.caret = Color.parseColor("#000000");
        t.selection = Color.parseColor("#4D97FF54");
        t.invisibles = Color.parseColor("#dddddd");
        t.gutterForeground = Color.parseColor("#000000");
        t.gutterBackground = Color.parseColor("#dfdfdf");
        t.gutterDivider = Color.parseColor("#000000");

        return t;
    }
}
