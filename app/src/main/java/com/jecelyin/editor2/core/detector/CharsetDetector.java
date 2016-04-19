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

package com.jecelyin.editor2.core.detector;

import com.jecelyin.editor2.core.text.TextUtils;

import org.mozilla.universalchardet.UniversalDetector;

import java.io.BufferedInputStream;

public class CharsetDetector {

    public static String detect(BufferedInputStream bufferedInputStream) throws Exception {
        UniversalDetector detector = new UniversalDetector(null);

        byte[] buf = new byte[1024];
        int len;

        while ((len = bufferedInputStream.read(buf, 0, buf.length)) > 0 && !detector.isDone()) {
            detector.handleData(buf, 0, len);
        }
        detector.dataEnd();

        String encoding = detector.getDetectedCharset();
        detector.reset();
        return TextUtils.isEmpty(encoding) ? "UTF-8" : encoding;
    }
}
