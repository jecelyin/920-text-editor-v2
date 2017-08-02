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

package com.jecelyin.common.utils.command;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class MkdirRunner extends Runner<Boolean> {
    private final String path;

    public MkdirRunner(String path) {
        this.path = path;
    }

    @Override
    public String command() {
        return "mkdir -p \"" + path + "\"";
    }

    @Override
    protected void process(List<String> results, @NonNull String errors) {
        onResult(results.isEmpty(), errors);
    }

    @Override
    public void onResult(Boolean result, @NonNull String errors) {

    }
}
