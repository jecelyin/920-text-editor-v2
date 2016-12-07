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

package com.jecelyin.editor.v2.core.text.method;

import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import com.jecelyin.editor.v2.core.text.Layout;
import com.jecelyin.editor.v2.core.text.MetaKeyKeyListenerCompat;
import com.jecelyin.editor.v2.core.view.MotionEventCompat;
import com.jecelyin.editor.v2.core.widget.TextView;

public class Touch {
    private Touch() { }

    /**
     * Scrolls the specified widget to the specified coordinates, except
     * constrains the X scrolling position to the horizontal regions of
     * the text that will be visible after scrolling to the specified
     * Y position.
     */
    public static void scrollTo(TextView widget, Layout layout, int x, int y) {
        final int horizontalPadding = widget.getTotalPaddingLeft() + widget.getTotalPaddingRight();
        final int availableWidth = widget.getWidth() + horizontalPadding;

        if (widget.getHorizontallyScrolling()) {
            x = Math.max(0, x);

            final int verticalPadding = widget.getTotalPaddingTop() + widget.getTotalPaddingBottom();
            final int bottom = layout.getLineForVertical(y + widget.getHeight() - verticalPadding);
            final int top = layout.getLineForVertical(y);

            int right = availableWidth;
            for (int i = top; i <= bottom; i++) {
                right = (int) Math.max(right, layout.getLineRight(i));
            }
            x = Math.min(x, right);
        } else {
            x = 0;
        }

        widget.scrollTo(x, y);
    }

    /**
     * Handles touch events for dragging.  You may want to do other actions
     * like moving the cursor on touch as well.
     */
    public static boolean onTouchEvent(TextView widget, Spannable buffer,
                                       MotionEvent event) {
        DragState[] ds;

        switch (event.getActionMasked()) {
        case MotionEvent.ACTION_DOWN:
            ds = buffer.getSpans(0, buffer.length(), DragState.class);

            for (int i = 0; i < ds.length; i++) {
                buffer.removeSpan(ds[i]);
            }

            buffer.setSpan(new DragState(event.getX(), event.getY(),
                            widget.getScrollX(), widget.getScrollY()),
                    0, 0, Spannable.SPAN_MARK_MARK);
            return true;

        case MotionEvent.ACTION_UP:
            ds = buffer.getSpans(0, buffer.length(), DragState.class);

            for (int i = 0; i < ds.length; i++) {
                buffer.removeSpan(ds[i]);
            }

            if (ds.length > 0 && ds[0].mUsed) {
                return true;
            } else {
                return false;
            }

        case MotionEvent.ACTION_MOVE:
            ds = buffer.getSpans(0, buffer.length(), DragState.class);

            if (ds.length > 0) {
                ds[0].mIsSelectionStarted = false;

                if (ds[0].mFarEnough == false) {
                    int slop = ViewConfiguration.get(widget.getContext()).getScaledTouchSlop();

                    if (Math.abs(event.getX() - ds[0].mX) >= slop ||
                        Math.abs(event.getY() - ds[0].mY) >= slop) {
                        ds[0].mFarEnough = true;
//                        if (event.isButtonPressed(MotionEvent.BUTTON_PRIMARY)) {
                        if (MotionEventCompat.isButtonPressed(event, MotionEvent.BUTTON_PRIMARY)) {
                            ds[0].mIsActivelySelecting = true;
                            ds[0].mIsSelectionStarted = true;
                        }
                    }
                }

                if (ds[0].mFarEnough) {
                    ds[0].mUsed = true;
                    boolean cap = (event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0
                            || MetaKeyKeyListener.getMetaState(buffer,
                            MetaKeyKeyListener.META_SHIFT_ON) == 1
                            || MetaKeyKeyListener.getMetaState(buffer,
                                    MetaKeyKeyListenerCompat.META_SELECTING) != 0;

//                    if (!event.isButtonPressed(MotionEvent.BUTTON_PRIMARY)) {
                    if (!MotionEventCompat.isButtonPressed(event, MotionEvent.BUTTON_PRIMARY)) {
                        ds[0].mIsActivelySelecting = false;
                    }

                    float dx;
                    float dy;
//                    if (cap && event.isButtonPressed(MotionEvent.BUTTON_PRIMARY)) {
                    if (cap && MotionEventCompat.isButtonPressed(event, MotionEvent.BUTTON_PRIMARY)) {
                        // if we're selecting, we want the scroll to go in
                        // the direction of the drag
                        dx = event.getX() - ds[0].mX;
                        dy = event.getY() - ds[0].mY;
                    } else {
                        dx = ds[0].mX - event.getX();
                        dy = ds[0].mY - event.getY();
                    }
                    ds[0].mX = event.getX();
                    ds[0].mY = event.getY();

                    int nx = widget.getScrollX() + (int) dx;
                    int ny = widget.getScrollY() + (int) dy;

                    int padding = widget.getTotalPaddingTop() + widget.getTotalPaddingBottom();
                    Layout layout = widget.getLayout();

                    ny = Math.min(ny, layout.getHeight() - (widget.getHeight() - padding));
                    ny = Math.max(ny, 0);

                    int oldX = widget.getScrollX();
                    int oldY = widget.getScrollY();

//                    if (!event.isButtonPressed(MotionEvent.BUTTON_PRIMARY)) {
                    if (!MotionEventCompat.isButtonPressed(event, MotionEvent.BUTTON_PRIMARY)) {
                        scrollTo(widget, layout, nx, ny);
                    }

                    // If we actually scrolled, then cancel the up action.
                    if (oldX != widget.getScrollX() || oldY != widget.getScrollY()) {
                        widget.cancelLongPress();
                    }

                    return true;
                }
            }
        }

        return false;
    }

    /**
     * @param widget The text view.
     * @param buffer The text buffer.
     */
    public static int getInitialScrollX(TextView widget, Spannable buffer) {
        DragState[] ds = buffer.getSpans(0, buffer.length(), DragState.class);
        return ds.length > 0 ? ds[0].mScrollX : -1;
    }

    /**
     * @param widget The text view.
     * @param buffer The text buffer.
     */
    public static int getInitialScrollY(TextView widget, Spannable buffer) {
        DragState[] ds = buffer.getSpans(0, buffer.length(), DragState.class);
        return ds.length > 0 ? ds[0].mScrollY : -1;
    }

    /**
     * Checks if selection is still active.
     * This is useful for extending Selection span on buffer.
     * @param buffer The text buffer.
     * @return true if buffer has been marked for selection.
     *
     * @hide
     */
    static boolean isActivelySelecting(Spannable buffer) {
        DragState[] ds;
        ds = buffer.getSpans(0, buffer.length(), DragState.class);

        return ds.length > 0 && ds[0].mIsActivelySelecting;
    }

    /**
     * Checks if selection has begun (are we out of slop?).
     * Note: DragState.mIsSelectionStarted goes back to false with the very next event.
     * This is useful for starting Selection span on buffer.
     * @param buffer The text buffer.
     * @return true if selection has started on the buffer.
     *
     * @hide
     */
    static boolean isSelectionStarted(Spannable buffer) {
        DragState[] ds;
        ds = buffer.getSpans(0, buffer.length(), DragState.class);

        return ds.length > 0 && ds[0].mIsSelectionStarted;
    }

    public static class DragState implements NoCopySpan {
        public float mX;
        public float mY;
        public int mScrollX;
        public int mScrollY;
        public boolean mFarEnough;
        public boolean mUsed;
        public boolean mIsActivelySelecting;
        public boolean mIsSelectionStarted;

        public DragState(float x, float y, int scrollX, int scrollY) {
            mX = x;
            mY = y;
            mScrollX = scrollX;
            mScrollY = scrollY;
        }
    }
}
