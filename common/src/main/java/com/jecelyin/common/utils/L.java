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

package com.jecelyin.common.utils;

import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;

import com.jecelyin.common.app.JecApp;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class L {

    private static final String TAG = "JecLog";
    public static boolean debug = false;
    private static long tracingStartTime;
    private static String tracingName;

    private static String getTag() {
        if (!debug)
            return TAG;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stack;
        int currentFileLinePosition = 4;
        boolean foundL = false;
        String clsName = L.class.getName();
        for (int i = 0; i < stackTrace.length; i++) {
            stack = stackTrace[i];
            if (clsName.equals(stack.getClassName())) {
                foundL = true;
            } else if(foundL) {
                currentFileLinePosition = i;
                break;
            }
        }
        stack = stackTrace[currentFileLinePosition];
        String fullClassName = stack.getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        String methodName = stack.getMethodName();
        int lineNumber = stack.getLineNumber();

        return className + "." + methodName + "#" + lineNumber;
    }

    public static void startTracing(String name) {
        if (!debug)
            return;
        if (!TextUtils.isEmpty(name))
            Debug.startMethodTracing(name);
        tracingName = name;
        tracingStartTime = System.currentTimeMillis();
    }

    public static void stopTracing() {
        if (!debug)
            return;

        long tracingStopTime = System.currentTimeMillis();

        if (!TextUtils.isEmpty(tracingName))
            Debug.stopMethodTracing();

        float ts = (tracingStopTime - tracingStartTime) / 1000f;
        L.d("Tracing Name: " + tracingName + " Consuming Time: " + ts + "s");
    }

    public static int v(String tag, String msg) {
        if(!debug)
            return 0;
        return Log.v(tag, msg);
    }

    public static int v(String tag, String msg, Throwable tr) {
        if(!debug)
            return 0;
        return Log.v(tag, msg, tr);
    }

    /**
     * 非格式化的字符串，避免有%等字符时出错
     * @param msg
     * @return
     */
    public static int d(String msg) {
        return d(getTag(), msg);
    }

    public static int d(String tag, String msg) {
        if(!debug)
            return 0;
        return Log.d(tag, msg);
    }

    public static int d(String tag, String msg, Throwable tr) {
        if(!debug)
            return 0;
        return Log.d(tag, msg, tr);
    }

    public static int d(String format, Object... args) {
        return d(getTag(), String.format(format, args));
    }

    public static int d(Throwable t) {
        return d(getTag(), t.getMessage(), t);
    }

    public static int i(String tag, String msg) {
        if(!debug)
            return 0;
        return Log.i(tag, msg);
    }

    public static int i(String tag, String msg, Throwable tr) {
        if(!debug)
            return 0;
        return Log.i(tag, msg, tr);
    }

    public static int w(String msg) {
        return Log.w(getTag(), msg);
    }

    public static int w(String tag, String msg) {
        return Log.w(tag, msg);
    }

    public static int w(String tag, String msg, Throwable tr) {
        return Log.w(tag, msg, tr);
    }

    public static int w(String tag, Throwable tr) {
        return Log.w(tag, tr);
    }

    public static int e(String tag, String msg) {
        return logError(tag, msg, null);
    }

    public static int e(String tag, String msg, Throwable tr) {
        return logError(tag, msg, tr);
    }

    /**
     * 非格式化的字符串，避免有%等字符时出错
     * @param msg
     * @return
     */
    public static int e(String msg) {
        return e(getTag(), msg);
    }

    public static int e(String msg, Throwable t) {
        return e(getTag(), msg, t);
    }

    public static int e(String format, Object... args) {
        return e(getTag(), String.format(format, args));
    }

    public static int e(Throwable t) {
        if (t == null)
            return 0;
        return logError(getTag(), t.getMessage(), t);
    }

    private static int logError(String tag, String msg, Throwable t) {
        int ret = Log.e(tag, msg, t);

        final StringBuilder sb = new StringBuilder();
        sb.append("Tag: ").append(tag).append("\n")
          .append("Msg: ").append(msg).append("\n")
          .append("Stacktrace:\n").append(Log.getStackTraceString(t)).append("\n\n");

        new Thread(new Runnable() {
            @Override
            public void run() {
                CrashDbHelper db = null;
                try {
                    db = CrashDbHelper.getInstance(JecApp.getContext());
                    db.insertCrash(sb.toString());
                } catch (Exception e) {
                    Log.e("log-to-sqlite-error", e.getMessage(), e);
                } finally {
                    if(db != null)
                        db.close();
                }
            }
        }).start();

        return ret;
    }
}
