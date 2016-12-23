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

package com.jecelyin.editor.v2.task;

import com.jecelyin.editor.v2.common.Command;
import com.jecelyin.editor.v2.ui.EditorDelegate;

import java.util.ArrayList;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class ClusterCommand {
    private ArrayList<EditorDelegate> buffer;
    private Command command;

    public ClusterCommand(ArrayList<EditorDelegate> buffer) {
        this.buffer = buffer;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void doNextCommand() {
        if (buffer == null || buffer.size() == 0)
            return;
        EditorDelegate editorFragment = buffer.remove(0);
        //无法继续执行时，这里同步手动执行一下
        if (!editorFragment.doCommand(command)) {
            doNextCommand();
        }
    }
}
