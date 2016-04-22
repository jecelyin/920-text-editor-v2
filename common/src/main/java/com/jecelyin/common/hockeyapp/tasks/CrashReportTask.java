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

package com.jecelyin.common.hockeyapp.tasks;

import android.content.Context;

import com.jecelyin.common.BuildConfig;
import com.jecelyin.common.R;
import com.jecelyin.common.app.JecApp;
import com.jecelyin.common.app.NetLoadingDialog;
import com.jecelyin.common.hockeyapp.Constants;
import com.jecelyin.common.hockeyapp.objects.CrashDetails;
import com.jecelyin.common.http.HttpURLConnectionBuilder;
import com.jecelyin.common.utils.L;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class CrashReportTask extends ConnectionTask<Void, Void, Boolean> {
    private final String userId;
    private final String email;
    private final String content;
    private Context mContext;
    private NetLoadingDialog mProgressDialog;

    public CrashReportTask(Context context, String email, String content) {
        Constants.loadFromContext(context);
        this.mContext = context;
        this.userId = Constants.DEVICE_IDENTIFIER;
        this.email = email;
        this.content = content;
    }

    public void detach() {
        mContext = null;
        mProgressDialog = null;
    }

    @Override
    protected void onPreExecute() {
        if ((mProgressDialog == null || !mProgressDialog.isShowing())) {
            mProgressDialog = new NetLoadingDialog(mContext, R.string.submitting);
            mProgressDialog.show();
        }
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return submitStackTraces();
    }

    @Override
    protected void onPostExecute(Boolean success) {
        if (mProgressDialog != null) {
            try {
                mProgressDialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns the complete URL for the HockeyApp API.
     */
    private static String getURLString() {
        return Constants.BASE_URL + "api/2/apps/" + Constants.identifier + "/crashes/";
    }

    /**
     * Save a caught exception to disk.
     *
     * @param exception Exception to save.
     * @param thread    Thread that crashed.
     */
    public static void saveException(Context context, Throwable exception, Thread thread) {
        Constants.loadFromContext(context);
        final Date now = new Date();
        final Date startDate = new Date(JecApp.getStartupTimestamp());
        final StringWriter result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        exception.printStackTrace(printWriter);

        String filename = UUID.randomUUID().toString();

        CrashDetails crashDetails = new CrashDetails(filename, exception);
        crashDetails.setAppPackage(Constants.APP_PACKAGE);
        crashDetails.setAppVersionCode(Constants.APP_VERSION);
        crashDetails.setAppVersionName(Constants.APP_VERSION_NAME);
        crashDetails.setAppStartDate(startDate);
        crashDetails.setAppCrashDate(now);

        crashDetails.setOsVersion(Constants.ANDROID_VERSION);
        crashDetails.setOsBuild(Constants.ANDROID_BUILD);
        crashDetails.setDeviceManufacturer(Constants.PHONE_MANUFACTURER);
        crashDetails.setDeviceModel(Constants.PHONE_MODEL);

        if (thread != null) {
            crashDetails.setThreadName(thread.getName() + "-" + thread.getId());
        }

        if (Constants.CRASH_IDENTIFIER != null) {
            crashDetails.setReporterKey(Constants.CRASH_IDENTIFIER);
        }

        crashDetails.writeCrashReport();
    }

    /**
     * Searches .stacktrace files and returns them as array.
     */
    private static File[] searchForStackTraces() {
        if (Constants.FILES_PATH != null) {
            L.d("Looking for exceptions in: " + Constants.FILES_PATH);

            // Try to create the files folder if it doesn't exist
            File dir = new File(Constants.FILES_PATH + "/");
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

    private boolean submitStackTraces() {
        File[] list = searchForStackTraces();
        boolean successful = false, ret = false;

        if ((list != null) && (list.length > 0)) {
            L.d("Found " + list.length + " stacktrace(s).");

            for (File file : list) {
                HttpURLConnection urlConnection = null;
                try {
                    // Read contents of stack trace
                    String stacktrace = contentsOfFile(file);
                    if (stacktrace.length() > 0) {
                        // Transmit stack trace with POST request

                        Map<String, String> parameters = new HashMap<String, String>();

                        parameters.put("raw", stacktrace);
                        parameters.put("userID", userId);
                        parameters.put("contact", email);
                        parameters.put("description", content);
                        parameters.put("sdk", Constants.SDK_NAME);
                        parameters.put("sdk_version", BuildConfig.VERSION_NAME);

                        urlConnection = new HttpURLConnectionBuilder(getURLString())
                                .setRequestMethod("POST")
                                .writeFormFields(parameters)
                                .build();

                        int responseCode = urlConnection.getResponseCode();

                        successful = (responseCode == HttpURLConnection.HTTP_ACCEPTED || responseCode == HttpURLConnection.HTTP_CREATED);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    if (successful) {
                        file.delete();
                        ret = true;
                    }
                }
            }
        }
        return ret;
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
