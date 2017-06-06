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

package com.jecelyin.editor.v2.common;

import android.os.Bundle;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class Command {
    public enum CommandEnum {
        NONE,
        HIDE_SOFT_INPUT,
        SHOW_SOFT_INPUT,
        SAVE,
        SAVE_AS,
        OPEN,
        REDO,
        UNDO,
        CUT,
        COPY,
        PASTE,
        SELECT_ALL,
        DUPLICATION,
        CONVERT_WRAP_CHAR,
        GOTO_LINE,
        FIND,
        GOTO_TOP,
        GOTO_END,
        BACK,
        FORWARD,
        DOC_INFO,
        READONLY_MODE,
        ENABLE_HIGHLIGHT,
        CHANGE_MODE,
        INSERT_TEXT,
        RELOAD_WITH_ENCODING,
        FULL_SCREEN,
        THEME,
    }

    public CommandEnum what;
    public Bundle args = new Bundle();
    public Object object;

    public Command(CommandEnum what) {
        this.what = what;
    }
}
