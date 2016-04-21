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

import com.jecelyin.common.app.JecActivity;
import com.jecelyin.common.utils.SysUtils;
import com.jecelyin.editor2.R;
import com.jecelyin.editor2.databinding.AboutActivityBinding;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class AboutActivity extends JecActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AboutActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.about_activity);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String version = SysUtils.getVersionName(this);
        binding.appNameTextView.append(" " + version);
    }
}
