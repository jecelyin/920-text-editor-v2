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

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.jecelyin.common.R;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class NetLoadingDialog extends Dialog {
    private final TextView messageTextView;

    public NetLoadingDialog(Context context) {
        this(context, null);
    }

    public NetLoadingDialog(Context context, @StringRes int titleRes) {
        this(context, context.getString(titleRes));
    }

    public NetLoadingDialog(Context context, CharSequence title) {
        super(context, R.style.NetLoadingDialog);

        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.net_loading_layout);
//        getWindow().setBackgroundDrawable(null);
        getWindow().getAttributes().gravity= Gravity.CENTER;
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.dimAmount=0.2f;
        getWindow().setAttributes(lp);
        messageTextView = (TextView)findViewById(R.id.messageTextView);
        setTitle(title);
    }

    @Override
    public void setTitle(CharSequence title) {
        if(messageTextView != null && title != null) {
            messageTextView.setText(title);
            messageTextView.setVisibility(View.VISIBLE);
        }
    }
}
