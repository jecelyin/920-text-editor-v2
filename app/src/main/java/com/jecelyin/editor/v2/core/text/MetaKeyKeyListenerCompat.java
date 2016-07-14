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

package com.jecelyin.editor.v2.core.text;

import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.text.method.TextKeyListener;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class MetaKeyKeyListenerCompat extends MetaKeyKeyListener {
    public static final int META_SELECTING = getMetaSelecting();

    private static int getMetaSelecting() {
//        try {
//            return (int) MethodReflection.getField(TextKeyListener.class, "META_SELECTING");
//        } catch (Throwable e) {
//            L.e(e);
//            return 0x800;
//        }
        return TextKeyListener.META_SELECTING;
    }

    /**
     * Stop selecting text.  This does not actually collapse the selection;
     * call {@link android.text.Selection#setSelection} too.
     */
    public static void stopSelecting(View view, Spannable content) {
//        try {
//            MethodReflection.getStaticMethod(
//                    MetaKeyKeyListener.class
//                    , "stopSelecting"
//                    , new Class[]{View.class, Spannable.class}
//                    , new Object[]{view, content}
//            );
//        } catch (Throwable e) {
//            L.e(e);
//        }
        MetaKeyKeyListener.stopSelecting(view, content);
    }

    public static void resetLockedMeta2(Spannable content) {
//        try {
//            MethodReflection.getStaticMethod(MetaKeyKeyListener.class, "resetLockedMeta", new Class[]{Spannable.class}, new Object[]{content});
//        } catch (Throwable e) {
//            L.e(e);
//        }
        resetLockedMeta(content);
    }

    /**
     * Gets the state of a particular meta key to use with a particular key event.
     *
     * If the key event has been created by a device that does not support toggled
     * key modifiers, like a virtual keyboard for example, only the meta state in
     * the key event is considered.
     *
     * @param meta META_SHIFT_ON, META_ALT_ON, META_SYM_ON
     * @param text the buffer in which the meta key would have been pressed.
     * @param event the event for which to evaluate the meta state.
     * @return 0 if inactive, 1 if active, 2 if locked.
     */
    public static final int getMetaState2(final CharSequence text, final int meta,
                                         final KeyEvent event) {
        int metaState = event.getMetaState();
        if (event.getKeyCharacterMap().getModifierBehavior()
                == KeyCharacterMap.MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED) {
            metaState |= getMetaState(text);
        }
        if (META_SELECTING == meta) {
            // #getMetaState(long, int) does not support META_SELECTING, but we want the same
            // behavior as #getMetaState(CharSequence, int) so we need to do it here
            if ((metaState & META_SELECTING) != 0) {
                // META_SELECTING is only ever set to PRESSED and can't be LOCKED, so return 1
                return 1;
            }
            return 0;
        }
        return getMetaState(metaState, meta);
    }
}
