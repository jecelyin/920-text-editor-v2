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

package com.jecelyin.editor.v2.view.menu;


import com.jecelyin.editor.v2.R;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public enum MenuGroup {
    TOP(0),
    FILE(R.string.file),
    EDIT(R.string.edit),
    FIND(R.string.find),
    VIEW(R.string.view),
    OTHER(R.string.other);

    private int nameResId;

    MenuGroup(int resId) {
        nameResId = resId;
    }

    public int getNameResId() {
        return nameResId;
    }
}
