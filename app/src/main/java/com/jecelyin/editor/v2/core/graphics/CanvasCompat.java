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

package com.jecelyin.editor.v2.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.NonNull;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class CanvasCompat {

    @SuppressLint("NewApi")
    public static void drawTextRun(Canvas c, @NonNull char[] text, int index, int count, int contextIndex,
                            int contextCount, float x, float y, boolean isRtl, @NonNull Paint paint) {
//        try {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // 5.0以上
                c.drawTextRun(text, index, count, contextIndex, contextCount, x, y, isRtl, paint);
//                MethodReflection.callAny(c, "drawTextRun",
//                        new Class[]{char[].class, int.class, int.class, int.class, int.class, float.class, float.class, boolean.class, Paint.class},
//                        new Object[]{text, index, count, contextIndex, contextCount, x, y, isRtl, paint}
//                );
            } else {
                c.drawTextRun(text, index, count, contextIndex, contextCount, x, y, isRtl ? 1 : 0, paint);
//                MethodReflection.callAny(c, "drawTextRun",
//                        new Class[]{char[].class, int.class, int.class, int.class, int.class, float.class, float.class, int.class, Paint.class},
//                        new Object[]{text, index, count, contextIndex, contextCount, x, y, isRtl ? 1 : 0, paint}
//                );
            }
//        } catch (Throwable e) {
//            L.e(e);
//        }
    }

    /**
     * 4.4
     * public void drawTextRun(CharSequence text, int start, int end, int contextStart, int contextEnd,
     *   float x, float y, int dir, Paint paint) //@param dir the run direction, either 0 for LTR or 1 for RTL.
     * @param c
     * @param text
     * @param start
     * @param end
     * @param contextStart
     * @param contextEnd
     * @param x
     * @param y
     * @param isRtl
     * @param paint
     */
    @SuppressLint("NewApi")
    public static void drawTextRun(Canvas c, @NonNull CharSequence text, int start, int end, int contextStart,
                            int contextEnd, float x, float y, boolean isRtl, @NonNull Paint paint) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // 5.0以上
            c.drawTextRun(text, start, end, contextStart, contextEnd, x, y, isRtl, paint);
        } else {
            c.drawTextRun(text, start, end, contextStart, contextEnd, x, y, isRtl ? 1 : 0, paint);
        }
    }
}
