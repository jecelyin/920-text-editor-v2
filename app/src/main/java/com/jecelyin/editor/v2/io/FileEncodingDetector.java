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

package com.jecelyin.editor.v2.io;

import android.text.TextUtils;

import com.jecelyin.common.utils.L;
import com.jecelyin.editor.v2.utils.CharsetDetector;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class FileEncodingDetector {
    public final static String DEFAULT_ENCODING = "UTF-8";

    public static String detectEncoding(File file) {
//        CharsetDetector detector = new CharsetDetector();
//        try {
//            detector.setText(new BufferedInputStream(new FileInputStream(file)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        CharsetMatch detect = detector.detect();
//        if(detect == null)
//            return DEFAULT_ENCODING;
//        String encoding = detect.getName();
        String encoding = null;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            encoding = CharsetDetector.detect(bufferedInputStream);
            bufferedInputStream.close();

        } catch (Exception e) {
            L.e(e);
        }
        if(TextUtils.isEmpty(encoding)) {
            encoding = DEFAULT_ENCODING;
        }

        return encoding;
    }
}
