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

import org.mozilla.intl.chardet.nsDetector;
import org.mozilla.intl.chardet.nsICharsetDetectionObserver;
import org.mozilla.intl.chardet.nsPSMDetector;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;

public class CharsetDetector {

    public static String detect(BufferedInputStream bufferedInputStream) throws Exception {
//        UniversalDetector detector = new UniversalDetector(null);
//
//        byte[] buf = new byte[1024];
//        int len;
//
//        while ((len = bufferedInputStream.read(buf, 0, buf.length)) > 0 && !detector.isDone()) {
//            detector.handleData(buf, 0, len);
//        }
//        detector.dataEnd();
//
//        String encoding = detector.getDetectedCharset();
//        detector.reset();
        // jchardet ==================
        nsDetector det = new nsDetector(nsPSMDetector.ALL) ;

        // Set an observer...
        // The Notify() will be called when a matching charset is found.
        final List<String> charsets = new ArrayList<>();
        det.Init(new nsICharsetDetectionObserver() {
            public void Notify(String charset) {
                charsets.add(charset);
            }
        });

        byte[] buf = new byte[1024] ;
        int len;
        boolean done = false ;
        boolean isAscii = true ;

        while( (len=bufferedInputStream.read(buf,0,buf.length)) != -1) {

            // Check if the stream is only ascii.
            if (isAscii)
                isAscii = det.isAscii(buf,len);

            // DoIt if non-ascii and not done yet.
            if (!isAscii && !done)
                done = det.DoIt(buf,len, false);
        }
        det.DataEnd();

        String encoding = charsets.isEmpty() ? "UTF-8" : charsets.get(0);
        if ("GB2312".equals(encoding))
            encoding = "GBK";
        return encoding;
    }
}
