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

package com.jecelyin.editor.v2.core.view;

import android.text.style.SuggestionSpan;
import android.view.inputmethod.InputMethodManager;


/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class InputMethodManagerCompat {
    /**
     * Private optimization: retrieve the global InputMethodManager instance,
     * if it exists.
     */
    public static InputMethodManager peekInstance() {
//        try {
//            return (InputMethodManager) MethodReflection.getStaticMethod(InputMethodManager.class, "peekInstance", null, null);
//        } catch (Throwable e) {
//            L.e(e);
//            return null;
//        }
        return InputMethodManager.peekInstance();
    }

    public static boolean isCursorAnchorInfoEnabled(InputMethodManager imm) {
//        try {
//            return (Boolean)MethodReflection.callGet(imm, "isCursorAnchorInfoEnabled");
//        } catch (Throwable e) {
//            L.e(e);
//            return true;
//        }
        return imm.isCursorAnchorInfoEnabled();
    }

    public static void notifySuggestionPicked(InputMethodManager imm, SuggestionSpan span, String originalString, int index) {
//        try {
//            MethodReflection.callAny(
//                    imm,
//                    "notifySuggestionPicked",
//                    new Class[]{InputMethodManager.class, SuggestionSpan.class, String.class, int.class},
//                    new Object[]{imm, span, originalString, index}
//            );
//        } catch (Throwable e) {
//            L.e(e);
//        }
        imm.notifySuggestionPicked(span, originalString, index);
    }

    public static void registerSuggestionSpansForNotification(InputMethodManager imm, SuggestionSpan[] spans) {
        //public void registerSuggestionSpansForNotification(SuggestionSpan[] spans)
//        try {
//            MethodReflection.callAny(imm, "registerSuggestionSpansForNotification", new Class[]{SuggestionSpan[].class}, new Object[]{spans});
//        } catch (Throwable e) {
//            L.e(e);
//        }
        imm.registerSuggestionSpansForNotification(spans);
    }

    public static void setUpdateCursorAnchorInfoMode(InputMethodManager imm, int cursorUpdateMode) {
//        try {
//            MethodReflection.callAny(imm, "setUpdateCursorAnchorInfoMode", new Class[]{int.class}, new Object[]{cursorUpdateMode});
//        } catch (Throwable e) {
//            L.e(e);
//        }
        imm.setUpdateCursorAnchorInfoMode(cursorUpdateMode);
    }
}
