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

package com.jecelyin.common.task;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class TaskResult<T> {
    private T result;
    private boolean waitResult;
    private boolean hasResult;
    private Exception error;

    void waitResult() throws InterruptedException {
        this.waitResult = true;
        if (!hasResult)
            synchronized (this) {
                wait();
            }
    }

    T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.hasResult = true;
        this.result = result;
        done();
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
        done();
    }

    private void done() {
        if (waitResult)
            synchronized (this) {
                notify();
            }
    }
}