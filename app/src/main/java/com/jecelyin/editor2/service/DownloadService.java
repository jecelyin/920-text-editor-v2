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

package com.jecelyin.editor2.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.SysUtils;
import com.jecelyin.editor2.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class DownloadService extends IntentService {
    private static final int BUFFER_SIZE = 64 * 1024;
    private static final String TAG = "DownloadService";
    private NotificationManager mNotifyManager;
    private NotificationCompat.Builder mBuilder;
    private String downloadUrl;
    private int size;
    private File apkFile;
    private int notifyID = 1;

    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(this);

        //setContentInent如果不设置在4.0+上没有问题，在4.0以下会报异常
        PendingIntent pendingintent = PendingIntent.getActivity(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingintent);

        String appName = getString(getApplicationInfo().labelRes);

        mBuilder.setContentTitle(appName)
                .setSmallIcon(R.drawable.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        downloadUrl = intent.getStringExtra("downloadUrl");
        size = intent.getIntExtra("size", 0);

        mBuilder.setContentText(getString(R.string.start_download));
        mBuilder.setProgress(100, 0, false);

        mNotifyManager.notify(notifyID, mBuilder.build());

        boolean success = false;
        try {
            success = download();
        } catch (Exception e) {
            e.printStackTrace();
            onFailed(getString(R.string.download_failure_x, e.getMessage()));
        }

        if (success) {
            onDownloadSuccess();
        } else {
            onFailed(getString(R.string.cannt_download));
        }
    }

    private void onFailed(String msg) {
        mBuilder.setContentText(msg);
        PendingIntent pendingintent = PendingIntent.getActivity(this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingintent);
        mNotifyManager.notify(notifyID, mBuilder.build());
    }

    private void onDownloadSuccess() {
        // 下载完成
        mNotifyManager.cancel(notifyID);

        Intent installAPKIntent = new Intent(Intent.ACTION_VIEW);
        //如果没有设置SDCard写权限，或者没有sdcard,apk文件保存在内存中，需要授予权限才能安装
        String[] command = {"chmod", "777", apkFile.toString()};
        ProcessBuilder builder = new ProcessBuilder(command);
        try {
            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        installAPKIntent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        installAPKIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //installAPKIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        //installAPKIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        startActivity(installAPKIntent);
    }

    private void updateProgress(int progress) {
        //"正在下载:" + progress + "%"
        mBuilder.setContentText(getString(R.string.download_progress, progress))
                .setProgress(100, progress, false);
        PendingIntent pendingintent = PendingIntent.getActivity(this, 0, new Intent(), PendingIntent.FLAG_CANCEL_CURRENT);
        mBuilder.setContentIntent(pendingintent);
        mNotifyManager.notify(notifyID, mBuilder.build());
    }

    public static void startService(Context context, String downloadUrl, int size) {
        Intent intent = new Intent(context, DownloadService.class);
        intent.putExtra("downloadUrl", downloadUrl);
        intent.putExtra("size", size);
        context.startService(intent);
    }

    private boolean download() throws Exception {
        URL url = new URL(downloadUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");
        urlConnection.setDoOutput(false);
        urlConnection.setConnectTimeout(60 * 1000);
        urlConnection.setReadTimeout(300 * 1000);
        urlConnection.setRequestProperty("Connection", "Keep-Alive");
        urlConnection.setRequestProperty("Charset", "UTF-8");
        urlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");

        urlConnection.connect();
        long bytetotal = urlConnection.getContentLength();
        if (bytetotal < 1)
            bytetotal = size;

        long bytesum = 0;
        int byteread;
        InputStream in = null;
        FileOutputStream out = null;

        try {
            in = urlConnection.getInputStream();
            File dir = SysUtils.getCacheDir(this);
            String apkName = downloadUrl.substring(downloadUrl.lastIndexOf("/") + 1, downloadUrl.length());
            if (!apkName.endsWith(".apk")) {
                apkName = "920-text-editor.apk";
            }
            apkFile = new File(dir, apkName);
            apkFile.delete();

            out = new FileOutputStream(apkFile);
            byte[] buffer = new byte[BUFFER_SIZE];

            int oldProgress = 0;

            while ((byteread = in.read(buffer)) != -1) {
                bytesum += byteread;
                out.write(buffer, 0, byteread);

                int progress = (int) (bytesum * 100L / bytetotal);
                // 如果进度与之前进度相等，则不更新，如果更新太频繁，否则会造成界面卡顿
                if (progress != oldProgress) {
                    updateProgress(progress);
                }
                oldProgress = progress;
            }

            return true;
        } catch (Exception e) {
            L.e("Download new version apk fail", e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

}