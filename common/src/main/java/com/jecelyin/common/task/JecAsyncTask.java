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

import android.os.AsyncTask;

import com.jecelyin.common.listeners.OnDismissListener;
import com.jecelyin.common.listeners.ProgressInterface;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public abstract class JecAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    private Exception exception;
    private TaskListener<Result> listener;
    private ProgressInterface progressInterface;
    private boolean complete = false;

    public JecAsyncTask<Params, Progress, Result> setTaskListener(TaskListener<Result> listener) {
        this.listener = listener;
        return this;
    }

    public void setProgress(ProgressInterface progressInterface) {
        this.progressInterface = progressInterface;
        if (progressInterface != null) {
            progressInterface.addOnDismissListener(new OnDismissListener() {
                @Override
                public void onDismiss() {
                    if (!complete)
                        cancel(true);
                }
            });
        }
    }

    public ProgressInterface getProgress() {
        return progressInterface;
    }

    @Override
    protected void onPreExecute() {
        if (progressInterface != null) {
            progressInterface.show();
        }
    }

    @Override
    protected final Result doInBackground(Params... params) {
        TaskResult<Result> taskResult = new TaskResult<>();

        try {
            onRun(taskResult, params);
            taskResult.waitResult();
            return taskResult.getResult();
        } catch (Exception e) {
            exception = e;
            return null;
        }
    }

    @Override
    protected final void onPostExecute(Result result) {
        if (!isCancelled()) {
            onComplete();
            if (exception == null) {
                onSuccess(result);
            } else {
                onError(exception);
            }
        }
    }

    @Override
    protected void onCancelled() {
        onComplete();
    }

    protected void onComplete() {
        complete = true;
        if (listener != null)
            listener.onCompleted();

        if (progressInterface != null) {
            progressInterface.dismiss();
        }
    }

    protected void onSuccess(Result result) {
        if (listener != null)
            listener.onSuccess(result);
    }

    protected void onError(Exception e) {
        if (listener != null)
            listener.onError(e);
    }

    protected abstract void onRun(TaskResult<Result> taskResult, Params... params) throws Exception;

}