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
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.jecelyin.common.R;
import com.jecelyin.common.app.crash.CrashUtils;
import com.jecelyin.common.github.Issue;
import com.jecelyin.common.github.IssueService;
import com.jecelyin.common.task.TaskResult;
import com.jecelyin.common.task.TaskListener;
import com.jecelyin.common.utils.CrashDbHelper;
import com.jecelyin.common.task.JecAsyncTask;
import com.jecelyin.common.utils.SysUtils;
import com.jecelyin.common.utils.UIUtils;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class CrashReportDialogActivity extends JecActivity {
    private static final int MENU_SUBMIT = 1;
    private String title;

    public static void startActivity(Context context, Throwable t) {
        Intent it = new Intent(context, CrashReportDialogActivity.class);
        it.putExtra("title", t.getMessage());
        it.putExtra("trace", Log.getStackTraceString(t));
        it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.crash_report_activity);

        Intent it = getIntent();
        String trace = it.getStringExtra("trace");
        title = it.getStringExtra("title");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView stacktraceTextView = (TextView) findViewById(R.id.stacktraceTextView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.crash_report);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_btn);

        stacktraceTextView.setText(trace);
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
        EditText commentEditText = (EditText) findViewById(R.id.commentEditText);
        String content = commentEditText.getText().toString().trim();

        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        String email = emailEditText.getText().toString().trim().replace("@", "#");

        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);

        StringBuilder sb = new StringBuilder(content);
        sb.append("\n");
        sb.append(email);
        sb.append("\n\n");
        sb.append("Memory: ").append(memoryInfo.availMem/1024/1024).append(" MB / ").append(memoryInfo.totalMem/1024/1024).append(" MB\n");
        sb.append("LogCat Error:\n\n");
        final CrashDbHelper dbHelper = CrashDbHelper.getInstance(getContext());
        dbHelper.crashToString(sb);
        dbHelper.close();

        sb.append("Exception ==========================\n");
        sb.append(CrashUtils.getStackTraces(getApplicationContext()));

        final Issue issue = new Issue();
        issue.setTitle("[BugReport] " + title);
        issue.setBody(sb.toString());
        issue.setLabel("bug");

        final ProgressDialog progressDialog = new ProgressDialog(getContext(), R.string.submitting);
        progressDialog.show();

        final ReportTask task = new ReportTask(getApplicationContext());
        task.setTaskListener(new TaskListener<Void>() {
            @Override
            public void onCompleted() {
                dbHelper.close();
                progressDialog.dismiss();
            }

            @Override
            public void onSuccess(Void result) {
                UIUtils.toast(getApplicationContext(), R.string.crash_report_success);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        close();
                    }
                }, 1000);
            }

            @Override
            public void onError(Exception th) {
                UIUtils.alert(getContext(), getString(R.string.crash_submit_fail_x, th.getMessage()));
            }
        });
        task.execute(issue);

        progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                dbHelper.close();
                task.cancel(true);
            }
        });
    }

    private void close() {
        finish();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);
    }

    private static class ReportTask extends JecAsyncTask<Issue, Void, Void> {
        private final Context context;

        private ReportTask(Context context) {
            this.context = context.getApplicationContext();
        }

        @Override
        protected void onRun(TaskResult<Void> taskResult, Issue... params) throws Exception {
            IssueService is = new IssueService();
            is.getClient().setOAuth2Token(context);
            is.createIssue(params[0]);

            CrashDbHelper dbHelper = CrashDbHelper.getInstance(context);
            dbHelper.updateCrashCommitted();
            dbHelper.close();

            taskResult.setResult(null);
        }
    }

}
