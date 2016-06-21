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
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.jecelyin.common.app.JecActivity;
import com.jecelyin.editor2.R;
import com.jecelyin.editor2.databinding.DonateActivityBinding;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class DonateActivity extends JecActivity implements SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener {
    private DonateActivityBinding binding;
    private int amount = 5;

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
        binding.channelRadioGroup.check(R.id.channel_google);
        binding.seekBar.setProgress(amount);
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
        amount = progress;
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
}
