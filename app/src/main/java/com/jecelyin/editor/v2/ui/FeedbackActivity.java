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

package com.jecelyin.editor.v2.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.jecelyin.common.app.NetLoadingDialog;
import com.jecelyin.common.github.Issue;
import com.jecelyin.common.github.IssueService;
import com.jecelyin.common.utils.CrashDbHelper;
import com.jecelyin.common.utils.SysUtils;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor.v2.BaseActivity;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.databinding.FeedbackActivityBinding;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class FeedbackActivity extends BaseActivity {
    private FeedbackActivityBinding binding;

    public static void startActivity(Context context, Exception e) {
        Intent it = new Intent(context, FeedbackActivity.class);
        it.putExtra("exception", e == null ? "" : Log.getStackTraceString(e));
        context.startActivity(it);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.feedback_activity);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.feedback_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.send) {
            submit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void submit() {
        String email = binding.emailEditText.getText().toString();
        String content = binding.contentEditText.getText().toString();
        boolean withLog = binding.withLogCheckBox.isChecked();

        if (TextUtils.isEmpty(content) || content.length() < 10) {
            UIUtils.toast(this, R.string.feedback_content_length_must_be_greater_than_x_char, 15);
            return;
        }

        if (!SysUtils.isNetworkAvailable(this)) {
            UIUtils.toast(this, com.jecelyin.common.R.string.network_unavailable);
            return;
        }

        String title = content.length() <= 20 ? content : content.substring(0, 20);

        email = email.trim().replace("@", "#");

        StringBuilder sb = new StringBuilder(email);
        sb.append("\n\n");
        sb.append(content);

        sb.append("Exception Start ==============================\n");
        sb.append(getIntent().getStringExtra("exception"));
        sb.append("Exception End ==============================\n");

        if (withLog) {
            sb.append("\n\n");
            CrashDbHelper dbHelper = CrashDbHelper.getInstance(getContext());
            dbHelper.crashToString(sb);
            dbHelper.close();
        }

        final Issue issue = new Issue();
        issue.setLabel("help wanted");
        issue.setTitle("[Feedback] " + title);
        issue.setBody(sb.toString());

        final NetLoadingDialog netLoadingDialog = new NetLoadingDialog(getContext(), R.string.submitting);
        netLoadingDialog.show();
        final Subscription subscription = Observable.create(new Observable.OnSubscribe<Issue>() {
            @Override
            public void call(Subscriber<? super Issue> subscriber) {
                try {
                    IssueService is = new IssueService();
                    is.getClient().setOAuth2Token(getApplicationContext());
                    Issue rs = is.createIssue(issue);

                    CrashDbHelper dbHelper = CrashDbHelper.getInstance(getContext());
                    dbHelper.updateCrashCommitted();
                    dbHelper.close();

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
                netLoadingDialog.dismiss();
            }

            @Override
            public void onError(Throwable e) {
                netLoadingDialog.dismiss();
                UIUtils.alert(getContext(), getString(R.string.feedback_submit_error_x, e.getMessage()));
            }

            @Override
            public void onNext(Issue issue) {
                UIUtils.toast(getContext(), R.string.submit_success);
            }
        });

        netLoadingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                subscription.unsubscribe();
            }
        });
    }
}
