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

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.jecelyin.common.app.JecActivity;
import com.jecelyin.common.github.PageIterator;
import com.jecelyin.common.github.Release;
import com.jecelyin.common.github.ReleasesService;
import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.SysUtils;
import com.jecelyin.editor.v2.R;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class CheckUpgradeTask extends AsyncTask<String, Void, Release> {
    private final WeakReference<Context> contextWeakReference;

    public CheckUpgradeTask(Context context) {
        this.contextWeakReference = new WeakReference<>(context);
    }

    @Override
    protected Release doInBackground(String... params) {
        String currentVersion = params[0];

        try {
            ReleasesService rs = new ReleasesService();
            PageIterator<Release> releases = rs.pageReleases(null, 1, 1);

            if (releases != null && releases.hasNext()) {
                Collection<Release> list = releases.next();
                if (list.isEmpty())
                    return null;

                Release release = list.iterator().next();
                String version = release.getTagName();
                if (version == null || currentVersion == null)
                    return null;

                int vc = versionCompare(version, currentVersion);
                if (vc > 0) {
                    return release;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); //有wifi但是无网络时会报错
        }

        return null;
    }

    @Override
    protected void onPostExecute(Release release) {
        Context context = contextWeakReference.get();
        if (release == null || context == null)
            return;

        List<Release.Assets> assetsList = release.getAssets();
        if (assetsList == null || assetsList.isEmpty())
            return;
        Release.Assets assets = assetsList.get(0);
        final String downloadUrl = assets.getBrowser_download_url();
        final int size = assets.getSize();

        if (context instanceof JecActivity) {
            if (((JecActivity)context).isDetached())
                return;
        } else if (context instanceof Activity) {
            if (((Activity)context).isFinishing())
                return;
        }
        try {
            new MaterialDialog.Builder(context)
                    .canceledOnTouchOutside(false)
                    .title(R.string.new_version_available)
                    .content(R.string.new_version_update_content, release.getTagName(), release.getBody())
                    .negativeText(R.string.cancel)
                    .positiveText(R.string.upgrade)
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            goToDownload(downloadUrl, size);
                        }
                    }).show();
        } catch (Exception e) {
            L.d(e); //ignore: Bad window token, you cannot show a dialog before an Activity is created or after it'release hidden.
        }
    }

    private void goToDownload(String downloadUrl, int size) {
        Context c = contextWeakReference.get();
        if (c == null)
            return;

        final String appPackageName = c.getPackageName(); // getPackageName() from Context or Activity object
        try {
            c.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            c.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    /**
     * Compares two version strings.
     *
     * Use this instead of String.compareTo() for a non-lexicographical
     * comparison that works for version strings. e.g. "1.10".compareTo("1.6").
     *
     * @note It does not work if "1.10" is supposed to be equal to "1.10.0".
     *
     * @param str1 a string of ordinal numbers separated by decimal points.
     * @param str2 a string of ordinal numbers separated by decimal points.
     * @return The result is a negative integer if str1 is _numerically_ less than str2.
     *         The result is a positive integer if str1 is _numerically_ greater than str2.
     *         The result is zero if the strings are _numerically_ equal.
     */
    private Integer versionCompare(String str1, String str2)
    {
        String[] vals1 = str1.split("\\.");
        String[] vals2 = str2.split("\\.");
        int i = 0;
        // set index to first non-equal ordinal or length of shortest version string
        while (i < vals1.length && i < vals2.length && vals1[i].equals(vals2[i]))
        {
            i++;
        }
        // compare first non-equal ordinal number
        if (i < vals1.length && i < vals2.length)
        {
            int diff = Integer.valueOf(vals1[i]).compareTo(Integer.valueOf(vals2[i]));
            return Integer.signum(diff);
        }
        // the strings are equal or one string is a substring of the other
        // e.g. "1.2.3" = "1.2.3" or "1.2.3" < "1.2.3.4"
        else
        {
            return Integer.signum(vals1.length - vals2.length);
        }
    }

    public void checkVersion(String version) {
        if (contextWeakReference.get() == null)
            return;

        if (!SysUtils.isNetworkAvailable(contextWeakReference.get()))
            return;

        execute(version);
    }
}
