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

package com.jecelyin.common.app;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import com.jecelyin.common.app.crash.CrashConstants;
import com.jecelyin.common.app.crash.CrashDetails;
import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.SysUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class JecApp extends Application implements Thread.UncaughtExceptionHandler {
    private static Context context;
    private static long startupTimestamp;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        if (startupTimestamp == 0)
            startupTimestamp = System.currentTimeMillis();

        if (SysUtils.isDebug(this))
        {
            L.debug = true;
            //内存泄漏监控
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            builder.detectAll();
            builder.penaltyLog();
            StrictMode.setVmPolicy(builder.build());
        }
        // 捕捉未知异常
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, final Throwable ex)
    {
        Log.e("uncaughtException", "#ERROR: " + ex.getMessage(), ex);

        saveException(getApplicationContext(), ex, thread);
        CrashReportDialogActivity.startActivity(this, ex);

//        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    /**
     * Save a caught exception to disk.
     *
     * @param exception Exception to save.
     * @param thread    Thread that crashed.
     */
    public static void saveException(Context context, Throwable exception, Thread thread) {
        CrashConstants.loadFromContext(context);
        final Date now = new Date();
        final Date startDate = new Date(JecApp.getStartupTimestamp());
        final StringWriter result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        exception.printStackTrace(printWriter);

        String filename = UUID.randomUUID().toString();

        CrashDetails crashDetails = new CrashDetails(filename, exception);
        crashDetails.setAppPackage(CrashConstants.APP_PACKAGE);
        crashDetails.setAppVersionCode(CrashConstants.APP_VERSION);
        crashDetails.setAppVersionName(CrashConstants.APP_VERSION_NAME);
        crashDetails.setAppStartDate(startDate);
        crashDetails.setAppCrashDate(now);

        crashDetails.setOsVersion(CrashConstants.ANDROID_VERSION);
        crashDetails.setOsBuild(CrashConstants.ANDROID_BUILD);
        crashDetails.setDeviceManufacturer(CrashConstants.PHONE_MANUFACTURER);
        crashDetails.setDeviceModel(CrashConstants.PHONE_MODEL);

        if (thread != null) {
            crashDetails.setThreadName(thread.getName() + "-" + thread.getId());
        }

        if (CrashConstants.CRASH_IDENTIFIER != null) {
            crashDetails.setReporterKey(CrashConstants.CRASH_IDENTIFIER);
        }

        crashDetails.writeCrashReport();
    }

    public static Context getContext() {
        return context;
    }

    public static long getStartupTimestamp() {
        return startupTimestamp;
    }
}
