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

package com.jecelyin.editor.v2.widget.text;

import java.util.HashMap;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class EditorCommand {
    String cmd;
    HashMap<String, Object> data;
    JsCallback callback;

    private EditorCommand() {}

    public static class Builder {
        private EditorCommand ec;

        public Builder(String cmd) {
            ec = new EditorCommand();
            ec.cmd = cmd;
            ec.data = new HashMap<>();
        }

        public Builder put(String key, Object value) {
            ec.data.put(key, value);
            return this;
        }

        public Builder callback(JsCallback callback) {
            ec.callback = callback;
            return this;
        }

        public EditorCommand build() {
            return ec;
        }
    }
}
