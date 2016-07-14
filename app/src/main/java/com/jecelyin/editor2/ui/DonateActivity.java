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

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor2.BaseActivity;
import com.jecelyin.editor2.R;
import com.jecelyin.editor2.databinding.DonateActivityBinding;


/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class DonateActivity extends BaseActivity implements View.OnClickListener {

    public static void startActivity(Context context) {
        Intent it = new Intent(context, DonateActivity.class);
        context.startActivity(it);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DonateActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.donate_activity);
        binding.channelAlipay.setOnClickListener(this);
        binding.channelPaypal.setOnClickListener(this);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.channel_alipay:
                copyToClipboard("jecelyin@163.com", ((TextView)v).getText().toString());
                break;
            case R.id.channel_paypal:
                copyToClipboard("jecelyin@gmail.com", ((TextView)v).getText().toString());
                break;
        }
    }

    private void copyToClipboard(String account, String msg) {
        ClipboardManager clipboard = (ClipboardManager)
                getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(getString(R.string.donate), account);
        clipboard.setPrimaryClip(clip);

        UIUtils.alert(this, getString(R.string.donation_account_copied_x, msg));
    }
}
