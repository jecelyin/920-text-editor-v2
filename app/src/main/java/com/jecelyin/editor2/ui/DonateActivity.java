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

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.jecelyin.common.app.JecActivity;
import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor2.R;
import com.jecelyin.editor2.databinding.DonateActivityBinding;
import com.jecelyin.editor2.ui.donate.DonateChannel;
import com.jecelyin.editor2.ui.donate.DonateListener;
import com.jecelyin.editor2.ui.donate.GoogleBillingDonate;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class DonateActivity extends JecActivity implements SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener, DonateListener {
    private DonateActivityBinding binding;
    private int amount = 5;
    private GoogleBillingDonate googleBilling;

    public static void startActivity(Context context) {
        Intent it = new Intent(context, DonateActivity.class);
        context.startActivity(it);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.donate_activity);
        binding.seekBar.setOnSeekBarChangeListener(this);
        binding.channelRadioGroup.setOnCheckedChangeListener(this);
        binding.seekBar.setProgress(amount);
        binding.donateButton.setOnClickListener(this);

        googleBilling = new GoogleBillingDonate(getContext());
        binding.channelRadioGroup.check(googleBilling.isReady() ? R.id.channel_google : R.id.channel_alipay);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        googleBilling.destroy();
        googleBilling = null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GoogleBillingDonate.RC_REQUEST) {
            if (!googleBilling.onActivityResult(requestCode, resultCode, data)) {
                super.onActivityResult(requestCode, resultCode, data);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void onAmountChanged() {
        binding.moneyTextView.setText(getString(R.string.donate_amount_x, isRMB() ? "￥" : "$", amount));
    }

    private boolean isRMB() {
        int checkedId = binding.channelRadioGroup.getCheckedRadioButtonId();
        switch (checkedId) {
            case R.id.channel_alipay:
                return true;
        }
        return false;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (progress < 1)
            return;
        amount = progress;
        onAmountChanged();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        onAmountChanged();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.donateButton) {
            doDonate();
        }
    }

    private void doDonate() {
        DonateChannel channel = null;

        switch (binding.channelRadioGroup.getCheckedRadioButtonId()) {
            case R.id.channel_google:
                channel = googleBilling;
                break;
            default:
                UIUtils.toast(this, R.string.please_select_a_channel);
                return;
        }

        channel.pay(amount, this);
    }

    @Override
    public void onSuccess() {
        UIUtils.showConfirmDialog(getContext(), R.string.donate_success_message, new UIUtils.OnClickCallback() {
            @Override
            public void onOkClick() {
                finish();
            }
        });
    }

    @Override
    public void onError(String msg, Throwable t) {
        L.e(t);
        UIUtils.alert(getContext(), getString(R.string.donate_fail), msg);
    }
}
