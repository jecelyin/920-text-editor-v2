/*
 * Copyright (C) 2006 The Android Open Source Project
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

package com.jecelyin.editor.v2.core.text;

import android.graphics.Paint;
import android.os.Build;
import android.text.TextPaint;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class TextPaintCompat {

    /**
     * Flag for getTextRunAdvances indicating left-to-right run direction.
     * @hide
     */
    public static final int DIRECTION_LTR = 0;

    /**
     * Flag for getTextRunAdvances indicating right-to-left run direction.
     * @hide
     */
    public static final int DIRECTION_RTL = 1;

    /**
     * Option for getTextRunCursor to compute the valid cursor after
     * offset or the limit of the context, whichever is less.
     * @hide
     */
    public static final int CURSOR_AFTER = 0;

    /**
     * Option for getTextRunCursor to compute the valid cursor before
     * offset or the start of the context, whichever is greater.
     * @hide
     */
    public static final int CURSOR_BEFORE = 2;


    public static void setUnderlineText(TextPaint tp, int color, float thickness) {
//        try {
//            MethodReflection.callAny(tp, "setUnderlineText", new Class[]{int.class, float.class}, new Object[]{color, thickness});
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
        tp.setUnderlineText(color, thickness);
    }

    public static int getUnderlineColor(TextPaint tp) {
//        try {
//            return (int)MethodReflection.getField(tp, "underlineColor");
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return 0;
//        }
        return tp.underlineColor;
    }

    public static float getUnderlineThickness(TextPaint tp) {
//        try {
//            return (int)MethodReflection.getField(tp, "underlineThickness");
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return 0;
//        }
        return tp.underlineThickness;
    }

    public static float getTextRunAdvances(Paint tp, char[] chars, int index, int count,
                                    int contextIndex, int contextCount, boolean isRtl, float[] advances,
                                    int advancesIndex) {

//        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // 5.0 above
//                return (float) MethodReflection.callAny(tp, "getTextRunAdvances"
//                        , new Class[]{char[].class, int.class, int.class, int.class, int.class, boolean.class, float[].class, int.class}
//                        , new Object[]{chars, index, count, contextIndex, contextCount, isRtl, advances, advancesIndex}
//                );
                return tp.getTextRunAdvances(chars, index, count, contextIndex, contextCount, isRtl, advances, advancesIndex);
            } else {
//                return (float) MethodReflection.callAny(tp, "getTextRunAdvances"
//                        , new Class[]{char[].class, int.class, int.class, int.class, int.class, int.class, float[].class, int.class}
//                        , new Object[]{chars, index, count, contextIndex, contextCount, isRtl ? 1 : 0, advances, advancesIndex}
//                );
                return tp.getTextRunAdvances(chars, index, count, contextIndex, contextCount, isRtl ? 1 : 0, advances, advancesIndex);
            }
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return 0;
//        }
    }

    public static float getTextRunAdvances(Paint tp, CharSequence text, int start, int end,
                                           int contextStart, int contextEnd, boolean isRtl, float[] advances,
                                           int advancesIndex) {
//        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // 5.0 above
//                return (float)MethodReflection.callAny(tp, "getTextRunAdvances",
//                        new Class[]{CharSequence.class, int.class, int.class, int.class, int.class, boolean.class, float[].class, int.class},
//                        new Object[]{text, start, end, contextStart, contextEnd, isRtl, advances, advancesIndex}
//                );
                return tp.getTextRunAdvances(text, start, end, contextStart, contextEnd, isRtl, advances, advancesIndex);
            } else { // 4.4 below
                //public float getTextRunAdvances(String text, int start, int end, int contextStart,
                //      int contextEnd, int flags, float[] advances, int advancesIndex)
//                return (float)MethodReflection.callAny(tp, "getTextRunAdvances",
//                        new Class[]{CharSequence.class, int.class, int.class, int.class, int.class, int.class, float[].class, int.class},
//                        new Object[]{text, start, end, contextStart, contextEnd, isRtl ? 1 : 0, advances, advancesIndex}
//                );
                return tp.getTextRunAdvances(text, start, end, contextStart, contextEnd, isRtl ? 1 : 0, advances, advancesIndex);
            }

//        } catch (Throwable e) {
//            e.printStackTrace();
//            return 0f;
//        }
    }

    public static int getTextRunCursor(Paint p, CharSequence text, int contextStart,
                                       int contextEnd, int dir, int offset, int cursorOpt) {
//        try {
//            return (int) MethodReflection.callAny(p, "getTextRunCursor",
//                    new Class[]{CharSequence.class, int.class, int.class, int.class, int.class, int.class},
//                    new Object[]{text, contextStart, contextEnd, dir, offset, cursorOpt}
//                    );
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return 0;
//        }
        return p.getTextRunCursor(text, contextStart, contextEnd, dir, offset, cursorOpt);
    }

    public static int getTextRunCursor(Paint p, char[] text, int contextStart, int contextLength,
                                int dir, int offset, int cursorOpt) {
//        try {
//            return (int)MethodReflection.callAny(p, "getTextRunCursor",
//                    new Class[]{char[].class, int.class, int.class, int.class, int.class, int.class},
//                    new Object[]{text, contextStart, contextLength, dir, offset, cursorOpt}
//                    );
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return 0;
//        }
        return p.getTextRunCursor(text, contextStart, contextLength, dir, offset, cursorOpt);
    }
}
