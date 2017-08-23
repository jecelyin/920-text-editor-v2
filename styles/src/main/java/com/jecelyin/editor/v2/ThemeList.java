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

package com.jecelyin.editor.v2;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class ThemeList {
    public static class Theme {
        public final String title;
        public final String mode;
        public final boolean isDark;

        public Theme(String title, String mode, boolean isDark) {
            this.title = title;
            this.mode = mode;
            this.isDark = isDark;
        }
    }

    public static Theme[] themes = new Theme[] {
//BEGIN-REPLACE
        new Theme("Ambiance", "ace/theme/ambiance", true),
        new Theme("Chaos", "ace/theme/chaos", true),
        new Theme("Chrome", "ace/theme/chrome", false),
        new Theme("Clouds", "ace/theme/clouds", false),
        new Theme("Clouds Midnight", "ace/theme/clouds_midnight", true),
        new Theme("Cobalt", "ace/theme/cobalt", true),
        new Theme("Crimson Editor", "ace/theme/crimson_editor", false),
        new Theme("Dawn", "ace/theme/dawn", false),
        new Theme("Dreamweaver", "ace/theme/dreamweaver", false),
        new Theme("Eclipse", "ace/theme/eclipse", false),
        new Theme("GitHub", "ace/theme/github", false),
        new Theme("Green on Black", "ace/theme/gob", true),
        new Theme("Gruvbox", "ace/theme/gruvbox", true),
        new Theme("idle Fingers", "ace/theme/idle_fingers", true),
        new Theme("IPlastic", "ace/theme/iplastic", false),
        new Theme("KatzenMilch", "ace/theme/katzenmilch", false),
        new Theme("krTheme", "ace/theme/kr_theme", true),
        new Theme("Kuroir", "ace/theme/kuroir", false),
        new Theme("Merbivore", "ace/theme/merbivore", true),
        new Theme("Merbivore Soft", "ace/theme/merbivore_soft", true),
        new Theme("Mono Industrial", "ace/theme/mono_industrial", true),
        new Theme("Monokai", "ace/theme/monokai", true),
        new Theme("Pastel on dark", "ace/theme/pastel_on_dark", true),
        new Theme("Solarized Dark", "ace/theme/solarized_dark", true),
        new Theme("Solarized Light", "ace/theme/solarized_light", false),
        new Theme("SQL Server", "ace/theme/sqlserver", false),
        new Theme("Terminal", "ace/theme/terminal", true),
        new Theme("TextMate", "ace/theme/textmate", false),
        new Theme("Tomorrow", "ace/theme/tomorrow", false),
        new Theme("Tomorrow Night", "ace/theme/tomorrow_night", true),
        new Theme("Tomorrow Night 80s", "ace/theme/tomorrow_night_eighties", true),
        new Theme("Tomorrow Night Blue", "ace/theme/tomorrow_night_blue", true),
        new Theme("Tomorrow Night Bright", "ace/theme/tomorrow_night_bright", true),
        new Theme("Twilight", "ace/theme/twilight", true),
        new Theme("Vibrant Ink", "ace/theme/vibrant_ink", true),
        new Theme("XCode", "ace/theme/xcode", false),

//END-REPLACE
    };
}
