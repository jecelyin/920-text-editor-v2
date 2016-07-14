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

package com.jecelyin.editor.v2.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Base64;

import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.SysUtils;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor.v2.R;

import java.security.MessageDigest;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class AppUtils {
    private final static String rightSign = "u+AXcAUmNluGqVoNFQCe4+o6BLc=\n";

    public static boolean verifySign(Context context) {
        try {
            byte[] signature = SysUtils.getSignature(context);
            if (signature == null)
                return false;
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature);
            final String currentSignature = Base64.encodeToString(md.digest(), Base64.DEFAULT);
            return rightSign.equals(currentSignature);
        } catch (Exception e) {
            L.e(e);
            return false;
        }
    }

    public static void showException(Context context, String code, @NonNull final Exception e) {
        UIUtils.showConfirmDialog(context, context.getString(R.string.unknown_exception_and_report_message_x, code), new UIUtils.OnClickCallback() {
            @Override
            public void onOkClick() {

            }
        });
    }
}
