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

package com.jecelyin.editor.v2.core.widget;

import android.content.Context;

import com.jecelyin.editor.v2.core.text.Layout;
import com.jecelyin.editor.v2.core.text.method.Touch;

/**
 * Responsible for fling behavior. Use  {@link #start(int)}  to
 * initiate a fling. Each frame of the fling is handled in {@link #run()}.
 * A FlingRunnable will keep re-posting itself until the fling is done.
 *
 */
public class FlingRunnable implements Runnable
{

    static final int TOUCH_MODE_REST = -1;
    static final int TOUCH_MODE_FLING = 3;

    int mTouchMode = TOUCH_MODE_REST;

    /**
     * Tracks the decay of a fling scroll
     */
    private final Scroller mScroller;

    /**
     * Y value reported by mScroller on the previous fling
     */
    private int mLastFlingY;

    final private TextView mWidget;
    private int maxY;

    FlingRunnable(Context context, TextView parent)
    {
        mScroller = new Scroller(context);
        mWidget = parent;
    }

    void start(int initialVelocity)
    {
//        int initialX = mWidget.getScrollX(); // initialVelocity < 0 ?
//        // Integer.MAX_VALUE : 0;
//        int initialY = mWidget.getScrollY(); // initialVelocity < 0 ?
//        // Integer.MAX_VALUE : 0;
//        mLastFlingY = initialY;
//        mScroller.fling(initialX, initialY, 0, initialVelocity, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        int initialY = mWidget.getScrollY();
        mLastFlingY = initialY;
        maxY = mWidget.getMaxScrollY();
        mScroller.fling(0, initialY, 0, initialVelocity, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);

        mTouchMode = TOUCH_MODE_FLING;

        mWidget.post(this);
    }

    public void endFling()
    {
        mTouchMode = TOUCH_MODE_REST;

        if(mWidget != null)
        {
            mWidget.removeCallbacks(this);
//                    mWidget.moveCursorToVisibleOffset();

        }
    }

    public void run()
    {
        switch(mTouchMode)
        {
            default:
                return;

            case TOUCH_MODE_FLING:
            {

                final Scroller scroller = mScroller;
                boolean more = scroller.computeScrollOffset();

//                int x = scroller.getCurrX();
                int x = mWidget.getScrollX();
                int y = scroller.getCurrY();

                Layout layout = mWidget.getLayout();
                if(layout == null)
                    break;

                int delta = mLastFlingY - y;
                if(more && delta != 0 && y < maxY)
                {
                    Touch.scrollTo(mWidget, layout, x, y);
                    mWidget.invalidate();
                    mLastFlingY = y;
                    mWidget.post(this);
                }else
                {
                    endFling();
                }
                break;
            }
        }

    }
}
