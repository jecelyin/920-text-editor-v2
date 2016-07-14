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

import android.os.Build;
import android.view.View;

import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.MethodReflection;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class ViewCompat{
    private static MethodReflection invalidateParentCaches;

    public static boolean isLayoutRtl(View view) {
        return (android.support.v4.view.ViewCompat.getLayoutDirection(view) == android.support.v4.view.ViewCompat.LAYOUT_DIRECTION_RTL);
    }

    public static void invalidateParentCaches(View view) {
        try {
            if (invalidateParentCaches == null) {
                invalidateParentCaches = new MethodReflection(view.getClass(), "invalidateParentCaches", null);
            }
            invalidateParentCaches.invoke(view);
        } catch (Throwable e) {
            L.e(e);
        }

    }

    public static boolean isInLayout(View view) {
        if(Build.VERSION.SDK_INT >= 18)
            return view.isInLayout();
        return false;
    }
}
