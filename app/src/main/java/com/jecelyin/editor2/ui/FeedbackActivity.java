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

package com.jecelyin.editor2.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.jecelyin.common.app.JecActivity;
import com.jecelyin.common.hockeyapp.tasks.SendFeedbackTask;
import com.jecelyin.common.utils.CrashDbHelper;
import com.jecelyin.common.utils.SysUtils;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor2.R;
import com.jecelyin.editor2.databinding.FeedbackActivityBinding;

import java.util.HashMap;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class FeedbackActivity extends JecActivity {
    private FeedbackActivityBinding binding;
    private CrashDbHelper dbHelper;
    private SendFeedbackTask task;

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

    @Override
    protected void onStop() {
        super.onStop();

        if (task != null)
            task.detach();
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

        StringBuilder sb = new StringBuilder(email);
        sb.append("\n\n");
        sb.append(content);
        if (withLog) {
            sb.append("\n\n");
            dbHelper = CrashDbHelper.getInstance(getContext());
            dbHelper.crashToString(sb);
            dbHelper.close();
        }

        task = new SendFeedbackTask(this, "", email, title, sb.toString(), null, null, null) {
            @Override
            protected void onPostExecute(HashMap<String, String> result) {
                super.onPostExecute(result);

                String status = result.get("status");
                String response = result.get("response");

                if (("201".equals(status) || "200".equals(status)) && response != null && response.contains("\"status\":\"success\"")) {
                    dbHelper = CrashDbHelper.getInstance(getContext());
                    dbHelper.updateCrashCommitted();
                    dbHelper.close();
                    UIUtils.toast(getContext(), R.string.submit_success);
                    finish();
                } else {
                    UIUtils.alert(getContext(), getString(R.string.feedback_submit_error_x, response));
                }
            }
        };
        task.execute();
    }
}
