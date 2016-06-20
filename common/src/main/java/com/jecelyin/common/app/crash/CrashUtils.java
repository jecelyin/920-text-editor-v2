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

package com.jecelyin.common.app.crash;

import android.content.Context;

import com.jecelyin.common.app.JecApp;
import com.jecelyin.common.utils.L;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class CrashUtils {

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

    /**
     * Searches .stacktrace files and returns them as array.
     */
    private static File[] searchForStackTraces() {
        if (CrashConstants.FILES_PATH != null) {
            L.d("Looking for exceptions in: " + CrashConstants.FILES_PATH);

            // Try to create the files folder if it doesn't exist
            File dir = new File(CrashConstants.FILES_PATH + "/");
            boolean created = dir.mkdir();
            if (!created && !dir.exists()) {
                return new File[0];
            }

            // Filter for ".stacktrace" files
            FilenameFilter filter = new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.endsWith(".stacktrace");
                }
            };
            return dir.listFiles(filter);
        } else {
            L.d("Can't search for exception as file path is null.");
            return null;
        }
    }

    public static String getStackTraces(Context context) {
        CrashConstants.loadFromContext(context);
        File[] list = searchForStackTraces();

        StringBuilder sb = new StringBuilder();
        if ((list != null) && (list.length > 0)) {
            L.d("Found " + list.length + " stacktrace(s).");

            for (File file : list) {
                try {
                    // Read contents of stack trace
                    String stacktrace = contentsOfFile(file);
                    sb.append("\n\n");
                    sb.append(stacktrace);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    file.delete();
                }
            }
        }
        return sb.toString();
    }

    /**
     * Returns the content of a file as a string.
     */
    private static String contentsOfFile(File file) {
        StringBuilder contents = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                contents.append(line);
                contents.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }

        return contents.toString();

    }

}
