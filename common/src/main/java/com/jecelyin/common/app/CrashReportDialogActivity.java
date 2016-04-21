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

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.jecelyin.common.R;
import com.jecelyin.common.github.IGitHubConstants;
import com.jecelyin.common.github.Issue;
import com.jecelyin.common.github.IssueService;
import com.jecelyin.common.utils.CrashDbHelper;
import com.jecelyin.common.utils.SysUtils;
import com.jecelyin.common.utils.UIUtils;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class CrashReportDialogActivity extends JecActivity {
    private static final int MENU_SUBMIT = 1;
    private String mTrace;
    private String mMsg;

    public static void startActivity(Context context, Throwable t) {
        Intent dialogIntent = new Intent(context, CrashReportDialogActivity.class);
        dialogIntent.putExtra("throwable", t);
        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(dialogIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.crash_report_activity);

        Intent it = getIntent();
        Throwable t = (Throwable) it.getSerializableExtra("throwable");
        mMsg = t.getMessage();
        mTrace = Log.getStackTraceString(t);
        Log.e("uncaughtException", "#ERROR: " + mMsg, t);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView stacktraceTextView = (TextView) findViewById(R.id.stacktraceTextView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.crash_report);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_btn);

        stacktraceTextView.setText(mTrace);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add(0, MENU_SUBMIT, 0, R.string.crash_submit);
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                close();
                break;
            case MENU_SUBMIT:
                submit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void submit() {
        if (!SysUtils.isNetworkAvailable(this)) {
            UIUtils.toast(this, R.string.network_unavailable);
            return;
        }
        String version;
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            version = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            version = e.getMessage();
        }

        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);

        StringBuilder sb = new StringBuilder();

        EditText commentEditText = (EditText) findViewById(R.id.commentEditText);
        sb.append(commentEditText.getText().toString()).append("\n");
        sb.append("======================================================\n");
        sb.append("App Version: ").append(version).append("\n");
        sb.append("Phone: ").append(android.os.Build.BRAND).append(" ").append(android.os.Build.MODEL).append("\n");
        sb.append("Android Version: ").append(android.os.Build.VERSION.RELEASE).append("\n");
        sb.append("Memory: ").append(memoryInfo.availMem/1024/1024).append(" MB / ").append(memoryInfo.totalMem/1024/1024).append(" MB\n");
        sb.append("\n\n");
        sb.append("Stacktrace:\n\n").append(mTrace).append("\n\n\n");

        final CrashDbHelper dbHelper = CrashDbHelper.getInstance(getContext());
        dbHelper.crashToString(sb);

        final Issue issue = new Issue();
        issue.setTitle(version + " Crash: " + mMsg);
        issue.setBody(sb.toString());
        issue.setLabel("bug");

        final NetLoadingDialog netLoadingDialog = new NetLoadingDialog(getContext(), R.string.submitting);
        netLoadingDialog.show();
        final Subscription subscription = Observable.create(new Observable.OnSubscribe<Issue>() {
            @Override
            public void call(Subscriber<? super Issue> subscriber) {
                try {
                    IssueService is = new IssueService();
                    is.getClient().setOAuth2Token(IGitHubConstants.TOKEN);
                    Issue rs = is.createIssue(issue);
                    dbHelper.updateCrashCommitted();

                    subscriber.onNext(rs);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<Issue>() {
            @Override
            public void onCompleted() {
                dbHelper.close();
                netLoadingDialog.dismiss();
            }

            @Override
            public void onError(Throwable e) {
                dbHelper.close();
                netLoadingDialog.dismiss();
                UIUtils.alert(getContext(), getString(R.string.crash_submit_error_x, e.getMessage()));
            }

            @Override
            public void onNext(Issue issue) {
                UIUtils.toast(getContext(), R.string.crash_report_success);
                close();
            }
        });

        netLoadingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                dbHelper.close();
                subscription.unsubscribe();
                close();
            }
        });
    }

    private void close() {
        finish();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

}
