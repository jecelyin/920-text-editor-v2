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

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.util.TypedValue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class SysUtils {
    /**
     * Gets a field from the project's BuildConfig. This is useful when, for example, flavors
     * are used at the project level to set custom fields.
     * @param context       Used to find the correct file
     * @param fieldName     The name of the field-to-access
     * @return              The value of the field, or {@code null} if the field is not found.
     */
    public static Object getBuildConfigValue(Context context, String fieldName) {
        try {
            Class<?> clazz = Class.forName(context.getPackageName() + ".BuildConfig");
            Field field = clazz.getField(fieldName);
            return field.get(null);
        } catch (Exception e) {
//            L.d(e);
        }
        return null;
    }

    /**
     * Android studio 多个module时，非当前运行的module对家获取BuildConfig.DEBUG都是false
     * 这里通过获取当前应用的context下的BuildConfig来判断才正确
     * @param context
     * @return
     */
    public static boolean isDebug(Context context) {
        Object result = getBuildConfigValue(context, "DEBUG");
        return result != null && ((boolean)result);
    }

    public static int dpAsPixels(Context context, int dp)
    {
        Resources resources = context.getResources();
        return (int) TypedValue.applyDimension(1, dp, resources.getDisplayMetrics());
    }

    public static File getCacheDir(Context context) {
        File cacheDir;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cacheDir = context.getExternalCacheDir();
            if(cacheDir == null)
                cacheDir = context.getCacheDir();
        } else {
            cacheDir = context.getCacheDir();
        }
        return cacheDir;
    }

    public static File getFileDir(Context context) {
        File fileDir;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            fileDir = context.getExternalFilesDir(null);
            if(fileDir == null)
                fileDir = context.getFilesDir();
        } else {
            fileDir = context.getFilesDir();
        }
        return fileDir;
    }

    public static String getVersionName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            L.e(e);
            return null;
        }
    }

    public static boolean isUIThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void startWebView(Context context, String url) {
        Uri uri = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(launchBrowser);
    }

    /**
     * require: <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            return false;
        }
    }

    public static byte[] getSignature(Context context) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            L.e(e);
        }
        if (packageInfo == null || packageInfo.signatures == null)
            return null;
        Signature signature = packageInfo.signatures[0];
        return signature.toByteArray();
    }

    public static String getAppStoragePath(Context context) {
        File path = new File(Environment.getExternalStorageDirectory(), context.getPackageName());
        if (!path.exists()) {
            path.mkdirs();
        }
        return path.getPath();
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public static List<String> getStorageDirectories(boolean removableStorageOnly)
    {
        List<String> list = new ArrayList<String>();
        String internalPath = Environment.getExternalStorageDirectory().getPath();

        BufferedReader buf_reader = null;
        try {
            buf_reader = new BufferedReader(new FileReader("/proc/mounts"));
            String line;
            while ((line = buf_reader.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line, " ");
                String unused = tokens.nextToken(); //device
                String mountPoint = tokens.nextToken(); //mount point

                unused = tokens.nextToken(); //file system
                if ("tmpfs".equals(unused))
                    continue;
                List<String> flags = Arrays.asList(tokens.nextToken().split(",")); //flags
                boolean readonly = flags.contains("ro");

                if (removableStorageOnly && mountPoint.equals(internalPath)) {
                } else if (mountPoint.startsWith("/mnt/") || mountPoint.startsWith("/storage")
                        || mountPoint.startsWith("/sdcard")){
                    list.add(mountPoint);
                }
            }

        } catch (Exception ex) {
            L.e(ex);
        } finally {
            if (buf_reader != null) {
                try {
                    buf_reader.close();
                } catch (IOException ex) {}
            }
        }
        return list;
    }

    public static boolean isRemovableMediaStoragePath(String path) {
        List<String> directories = getStorageDirectories(true);

        for (String directory : directories) {
            if (path.startsWith(directory))
                return true;
        }

        return false;
    }
}
