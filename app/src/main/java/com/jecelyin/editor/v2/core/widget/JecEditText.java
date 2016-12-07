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
import android.graphics.Canvas;
import android.text.Editable;
import android.text.InputFilter;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;

import com.jecelyin.common.utils.LimitedQueue;
import com.jecelyin.editor.v2.Pref;
import com.jecelyin.editor.v2.core.content.UndoManager;
import com.jecelyin.editor.v2.core.text.Selection;
import com.jecelyin.editor.v2.core.text.method.ArrowKeyMovementMethod;
import com.jecelyin.editor.v2.core.text.method.MovementMethod;
import com.jecelyin.editor.v2.core.view.InputMethodManagerCompat;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class JecEditText extends TextView {
    private OnEditorSizeChangedListener onEditorSizeChangedListener;
    private UndoManager undoManager;
    private EditorHelper editorHelper;

    private ScaleGestureDetector mScaleDetector;
    private LimitedQueue<Integer> mPositionHistoryList = new LimitedQueue<>(30);
    private int currentLocation = -1;

    /**
     * Helper object that renders and controls the fast scroll thumb.
     */
    private FastScroller mFastScroller;
    private int mMinimumVelocity;
    private int mMaximumVelocity;
    private int mTouchSlop;
    /**
     * Maximum distance to overfling during edge effects
     */
    int mOverflingDistance;
    /**
     * ID of the active pointer. This is used to retain consistency during
     * drags/flings if multiple pointers are used.
     */
    private int mActivePointerId = INVALID_POINTER;
    /**
     * Sentinel value for no current active pointer.
     * Used by {@link #mActivePointerId}.
     */
    private static final int INVALID_POINTER = -1;
    /**
     * Maximum distance to overscroll by during edge effects
     */
    int mOverscrollDistance;
    /**
     * Indicates that we are not in the middle of a touch gesture
     */
    static final int TOUCH_MODE_REST = -1;

    /**
     * Indicates we just received the touch event and we are waiting to see if the it is a tap or a
     * scroll gesture.
     */
    static final int TOUCH_MODE_DOWN = 0;

    /**
     * Indicates the touch has been recognized as a tap and we are now waiting to see if the touch
     * is a longpress
     */
    static final int TOUCH_MODE_TAP = 1;

    /**
     * Indicates we have waited for everything we can wait for, but the user's finger is still down
     */
    static final int TOUCH_MODE_DONE_WAITING = 2;

    /**
     * Indicates the touch gesture is a scroll
     */
    static final int TOUCH_MODE_SCROLL = 3;

    /**
     * Indicates the view is in the process of being flung
     */
    static final int TOUCH_MODE_FLING = 4;

    /**
     * Indicates the touch gesture is an overscroll - a scroll beyond the beginning or end.
     */
    static final int TOUCH_MODE_OVERSCROLL = 5;

    /**
     * Indicates the view is being flung outside of normal content bounds
     * and will spring back.
     */
    static final int TOUCH_MODE_OVERFLING = 6;
    /**
     * The Y value associated with the the down motion event
     */
    int mMotionY;

    /**
     * One of TOUCH_MODE_REST, TOUCH_MODE_DOWN, TOUCH_MODE_TAP, TOUCH_MODE_SCROLL, or
     * TOUCH_MODE_DONE_WAITING
     */
    int mTouchMode = TOUCH_MODE_REST;

    /**
     * Y value from on the previous motion event (if any)
     */
    int mLastY;

    /**
     * How far the finger moved before we started scrolling
     */
    int mMotionCorrection;
    /**
     * Determines speed during touch scrolling
     */
    private VelocityTracker mVelocityTracker;

    /**
     * Handles one frame of a fling
     */
    private FlingRunnable mFlingRunnable;
    private KeyListener keyListener;

    public static interface OnEditorSizeChangedListener {
        void onEditorSizeChanged(int w, int h, int oldw, int oldh);
    }

    public JecEditText(Context context) {
        this(context, null);
    }

    public JecEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected boolean getDefaultEditable() {
        return true;
    }

    @Override
    protected MovementMethod getDefaultMovementMethod() {
        return ArrowKeyMovementMethod.getInstance();
    }

    @Override
    public Editable getText() {
        return (Editable) super.getText();
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, BufferType.EDITABLE);
    }

    /**
     * Convenience for {@link android.text.Selection#setSelection(android.text.Spannable, int, int)}.
     */
    public void setSelection(int start, int stop) {
        Selection.setSelection(getText(), start, stop);
    }

    /**
     * Convenience for {@link Selection#setSelection(android.text.Spannable, int)}.
     */
    public void setSelection(int index) {
        Selection.setSelection(getText(), index);
    }

    /**
     * Convenience for {@link Selection#selectAll}.
     */
//    public void selectAll() {
//        Selection.selectAll(getText());
//    }
    public boolean selectAll() {
        return canSelectText() && selectAllText();
    }

    /**
     * Convenience for {@link Selection#extendSelection}.
     */
    public void extendSelection(int index) {
        Selection.extendSelection(getText(), index);
    }

//    @Override
//    public void setEllipsize(TextUtils.TruncateAt ellipsis) {
//        if (ellipsis == TextUtils.TruncateAt.MARQUEE) {
//            throw new IllegalArgumentException("EditText cannot use the ellipsize mode "
//                    + "TextUtils.TruncateAt.MARQUEE");
//        }
//        super.setEllipsize(ellipsis);
//    }

//    @Override
//    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
//        super.onInitializeAccessibilityEvent(event);
//        event.setClassName(JecEditText.class.getName());
//    }
//
//    @Override
//    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
//        super.onInitializeAccessibilityNodeInfo(info);
//        info.setClassName(JecEditText.class.getName());
//    }
//
//    @Override
//    public boolean performAccessibilityAction(int action, Bundle arguments) {
//        switch (action) {
//            case AccessibilityNodeInfo.ACTION_SET_TEXT: {
//                CharSequence text = (arguments != null) ? arguments.getCharSequence(
//                        AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE) : null;
//                setText(text);
//                if (text != null && text.length() > 0) {
//                    setSelection(text.length());
//                }
//                return true;
//            }
//            default: {
//                return super.performAccessibilityAction(action, arguments);
//            }
//        }
//    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if(onEditorSizeChangedListener != null)
            onEditorSizeChangedListener.onEditorSizeChanged(w, h, oldw, oldh);

        if(mFastScroller != null)
        {
            mFastScroller.onSizeChanged(w, h, oldw, oldh);
        }
    }

    public void setReadOnly(boolean readOnly) {
        if (readOnly) {
            if(keyListener == null) {
                keyListener = getKeyListener();
            }
            setKeyListener(null);
        } else {
            if(keyListener != null) {
                setKeyListener(keyListener);
                keyListener = null;
            }
        }
    }

    public void setOnEditorSizeChangedListener(OnEditorSizeChangedListener onEditorSizeChangedListener) {
        this.onEditorSizeChangedListener = onEditorSizeChangedListener;
    }

    public void hideSoftInput() {
        InputMethodManager imm = InputMethodManagerCompat.peekInstance();
        imm.hideSoftInputFromWindow(getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void showSoftInput() {
        InputMethodManager imm = InputMethodManagerCompat.peekInstance();
        imm.showSoftInput(this, InputMethodManager.SHOW_FORCED);
    }

    private void init() {
        //自动获取焦点并弹出键盘
        setFocusableInTouchMode(true);

        mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener());

        mFastScroller = new FastScroller(getContext(), this);
        final ViewConfiguration configuration = ViewConfiguration.get(getContext());
        mTouchSlop = configuration.getScaledTouchSlop();
        mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        mOverflingDistance = configuration.getScaledOverflingDistance();
        mOverscrollDistance = configuration.getScaledOverscrollDistance();

        editorHelper = new EditorHelper(this);
        undoManager = new UndoManager();
        setUndoManager(undoManager, "undo");
        if (mEditor != null) {
            final boolean undoFilter = mEditor.mUndoInputFilter != null;
            final boolean keyFilter = mEditor.mKeyListener instanceof InputFilter;
            int num = 0;
            if (undoFilter) num++;
            if (keyFilter) num++;
            if (num > 0) {
                InputFilter[] nf = new InputFilter[num];

                num = 0;
                if (undoFilter) {
                    nf[num] = mEditor.mUndoInputFilter;
                    num++;
                }
                if (keyFilter) {
                    nf[num] = (InputFilter) mEditor.mKeyListener;
                }

                getEditableText().setFilters(nf);
            }
        }
    }

    public void redo() {
        undoManager.redo(null, 1);
    }

    public void undo() {
        undoManager.undo(null, 1);
    }

    public boolean canRedo() {
        return undoManager.countRedos(null) > 0;
    }

    public boolean canUndo() {
        return undoManager.countUndos(null) > 0;
    }

    public boolean copy() {
        return canCopy() && onTextContextMenuItem(ID_COPY);
    }

    public boolean paste() {
        return canPaste() && onTextContextMenuItem(ID_PASTE);
    }

    public boolean cut() {
        return canCut() && onTextContextMenuItem(ID_CUT);
    }

    public void duplication() {
        editorHelper.duplication();
    }

    public void convertWrapCharTo(String chars) {
        editorHelper.convertWrapCharTo(chars);
    }

    public void gotoTop() {
        setSelection(0);
    }

    public void gotoEnd() {
        setSelection(getLayout().getLineStart(getLineCount()-1));
    }

    public void gotoLine(int line) {
        if(line <= 0 || line > getLineCount())
            return;
        int vLine = getLayout().realLineToVirtualLine(line);
        if(vLine == -1)
            return;
        int offset = getLayout().getLineStart(vLine);
        setSelection(offset);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        final int action = ev.getActionMasked();

        if (mScaleDetector != null && pref.isTouchScaleTextSize())
            mScaleDetector.onTouchEvent(ev);

        if (mFastScroller != null) {
            if (mFastScroller.onInterceptTouchEvent(ev) || mFastScroller.onTouchEvent(ev)) {
                if (mFlingRunnable != null) {
                    mFlingRunnable.endFling();
                }
                return true;
            }
        }
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(ev);
        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: {
                switch (mTouchMode) {
                    case TOUCH_MODE_OVERFLING: {
                        mFlingRunnable.endFling();
                        mMotionY = mLastY = (int) ev.getY();
                        mMotionCorrection = 0;
                        mTouchMode = TOUCH_MODE_OVERSCROLL;
                        mActivePointerId = ev.getPointerId(0);
                        break;
                    }

                    default: {
                        mActivePointerId = ev.getPointerId(0);
                        final int x = (int) ev.getX();
                        final int y = (int) ev.getY();
                        int motionPosition = getScrollY();//pointToPosition(x, y);
//                        if (!mDataChanged) {
                            if ((mTouchMode != TOUCH_MODE_FLING) && (motionPosition >= 0) ) {
                                // User clicked on an actual view (and was not stopping a fling).
                                // It might be a click or a scroll. Assume it is a click until
                                // proven otherwise
                                mTouchMode = TOUCH_MODE_DOWN;

                            } else {
                                if (mTouchMode == TOUCH_MODE_FLING) {
                                    mMotionCorrection = 0;
                                    mTouchMode = TOUCH_MODE_SCROLL;
//                                    mFlingRunnable.flywheelTouch();
                                }
                            }
//                        }
                        mMotionY = y;
                        mLastY = Integer.MIN_VALUE;
                        break;
                    }
                }

                break;
            }

            case MotionEvent.ACTION_MOVE: {
                int pointerIndex = ev.findPointerIndex(mActivePointerId);
                if (pointerIndex == -1) {
                    pointerIndex = 0;
                    mActivePointerId = ev.getPointerId(pointerIndex);
                }
                final int y = (int) ev.getY(pointerIndex);

                switch (mTouchMode) {
                    case TOUCH_MODE_DOWN:
                    case TOUCH_MODE_TAP:
                    case TOUCH_MODE_DONE_WAITING:
                        // Check if we have moved far enough that it looks more like a
                        // scroll than a tap
                        startScrollIfNeeded(y);
                        break;
                    case TOUCH_MODE_SCROLL:
                    case TOUCH_MODE_OVERSCROLL:
                        scrollIfNeeded(y);
                        break;
                }
                break;
            }

            case MotionEvent.ACTION_UP: {
                switch (mTouchMode) {
                    case TOUCH_MODE_DOWN:
                    case TOUCH_MODE_TAP:
                    case TOUCH_MODE_DONE_WAITING:
                        mTouchMode = TOUCH_MODE_REST;
                        break;
                    case TOUCH_MODE_SCROLL:

                        VelocityTracker velocityTracker = mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                        float mVelocityScale = 1.0f;
                        int initialVelocity = (int)
                                (velocityTracker.getYVelocity(mActivePointerId) * mVelocityScale);
                        // Fling if we have enough velocity and we aren't at a boundary.
                        // Since we can potentially overfling more than we can overscroll, don't
                        // allow the weird behavior where you can scroll to a boundary then
                        // fling further.
                        if (Math.abs(initialVelocity) > mMinimumVelocity) {
                            if (mFlingRunnable == null) {
                                mFlingRunnable = new FlingRunnable(getContext(), this);
                            }

                            mFlingRunnable.start(-initialVelocity);
                        } else {
                            mTouchMode = TOUCH_MODE_REST;
                            if (mFlingRunnable != null) {
                                mFlingRunnable.endFling();
                            }
                        }
                        break;

                    case TOUCH_MODE_OVERSCROLL:
                        if (mFlingRunnable == null) {
                            mFlingRunnable = new FlingRunnable(getContext(), this);
                        }
                        velocityTracker = mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                        initialVelocity = (int) velocityTracker.getYVelocity(mActivePointerId);
                        mFlingRunnable.start(-initialVelocity);
//                        if (Math.abs(initialVelocity) > mMinimumVelocity) {
//                            mFlingRunnable.startOverfling(-initialVelocity);
//                        } else {
//                            mFlingRunnable.startSpringback();
//                        }

                        break;
                }

                // Need to redraw since we probably aren't drawing the selector anymore
                invalidate();

                recycleVelocityTracker();

                mActivePointerId = INVALID_POINTER;
                break;
            }

            case MotionEvent.ACTION_CANCEL: {
                switch (mTouchMode) {
                    case TOUCH_MODE_OVERSCROLL:
//                        if (mFlingRunnable == null) {
//                            mFlingRunnable = new FlingRunnable();
//                        }
//                        mFlingRunnable.startSpringback();
                        break;

                    case TOUCH_MODE_OVERFLING:
                        // Do nothing - let it play out.
                        break;

                    default:
                        mTouchMode = TOUCH_MODE_REST;

                        recycleVelocityTracker();
                }

                mActivePointerId = INVALID_POINTER;
                break;
            }
            case MotionEvent.ACTION_POINTER_UP: {
                final int y = mMotionY;
                mLastY = y;
                break;
            }
            case MotionEvent.ACTION_POINTER_DOWN: {
                // New pointers take over dragging duties
                final int index = ev.getActionIndex();
                final int id = ev.getPointerId(index);
                final int y = (int) ev.getY(index);
                mMotionCorrection = 0;
                mActivePointerId = id;
                mMotionY = y;
                mActivePointerId = id;
                mLastY = y;
                break;
            }
        }

        boolean handle = super.onTouchEvent(ev);

        if (action == MotionEvent.ACTION_UP) {
            recordCurrentLocation();
        }
        return handle;
    }

    private void recordCurrentLocation() {
        int offset = getSelectionStart();
        if (!mPositionHistoryList.isEmpty()) {
            int last = mPositionHistoryList.getLast();
            if (offset >= last - 20 && offset <= last + 20) {
                return;
            }
        }
        mPositionHistoryList.add(offset);
        currentLocation = mPositionHistoryList.size() - 1;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private final float minSize;
        private final float maxSize;

        public ScaleListener() {
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            minSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, Pref.DEF_MIN_FONT_SIZE, metrics);
            maxSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, Pref.DEF_MAX_FONT_SIZE, metrics);
        }

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float size = getTextSize() * detector.getScaleFactor();
            size = Math.max(minSize, Math.min(size, maxSize * 2));
            setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
            return true;
        }
    }

    private boolean startScrollIfNeeded(int y) {
        // Check if we have moved far enough that it looks more like a
        // scroll than a tap
        final int deltaY = y - mMotionY;
        final int distance = Math.abs(deltaY);
        final boolean overscroll = getScrollY() != 0;
        if (overscroll || distance > mTouchSlop) {
//            if (overscroll) {
//                mTouchMode = TOUCH_MODE_OVERSCROLL;
//                mMotionCorrection = 0;
//            } else {
                mTouchMode = TOUCH_MODE_SCROLL;
                mMotionCorrection = deltaY > 0 ? mTouchSlop : -mTouchSlop;
//            }

            // Time to start stealing events! Once we've stolen them, don't let anyone
            // steal from us
            final ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            scrollIfNeeded(y);
            return true;
        }

        return false;
    }

    private void scrollIfNeeded(int y) {
        final int rawDeltaY = y - mMotionY;
        final int deltaY = rawDeltaY - mMotionCorrection;
        int incrementalDeltaY = mLastY != Integer.MIN_VALUE ? y - mLastY : deltaY;

        if (mTouchMode == TOUCH_MODE_SCROLL) {

            if (y != mLastY) {
                // We may be here after stopping a fling and continuing to scroll.
                // If so, we haven't disallowed intercepting touch events yet.
                // Make sure that we do so in case we're in a parent that can intercept.
                if (Math.abs(rawDeltaY) > mTouchSlop) {
                    final ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }

                if (Math.abs(mOverscrollDistance) == Math.abs(getScrollY())) {
                    // Don't allow overfling if we're at the edge.
                    if (mVelocityTracker != null) {
                        mVelocityTracker.clear();
                    }
                }

                final int overscrollMode = getOverScrollMode();
                if (overscrollMode == OVER_SCROLL_ALWAYS ||
                        (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS)) {
                    mTouchMode = TOUCH_MODE_OVERSCROLL;
                }
                mMotionY = y;
                mLastY = y;
            }
        } else if (mTouchMode == TOUCH_MODE_OVERSCROLL) {
            final int oldScroll = getScrollY();
            final int newScroll = oldScroll - incrementalDeltaY;

            int overScrollDistance = -incrementalDeltaY;
            if ((newScroll < 0 && oldScroll >= 0) || (newScroll > 0 && oldScroll <= 0)) {
                overScrollDistance = -oldScroll;
                incrementalDeltaY += overScrollDistance;
            } else {
                incrementalDeltaY = 0;
            }

            if (incrementalDeltaY != 0) {
                mTouchMode = TOUCH_MODE_SCROLL;
                mMotionY = y;
                mMotionCorrection = 0;
            }
            mLastY = y;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (mFastScroller != null) {
            mFastScroller.draw(canvas);
        }
    }

    @Override
    public void onRtlPropertiesChanged(int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);

//        if (mFastScroller != null) {
//            mFastScroller.setScrollbarPosition(getVerticalScrollbarPosition());
//        }
    }

    @Override
    protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);

        if(mFastScroller != null && getLayout() != null)
        {
            int h = getBottom() - getTop() - getExtendedPaddingBottom() - getExtendedPaddingTop();
            int h2 = getLayout().getHeight();
            mFastScroller.onScroll(this, vert, h, h2);
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void recycleVelocityTracker() {
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (disallowIntercept) {
            recycleVelocityTracker();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mFlingRunnable != null) {
            removeCallbacks(mFlingRunnable);
        }
    }

    public boolean backLocation() {
        int size = mPositionHistoryList.size();
        if (size == 0 || currentLocation <= 0)
            return false;

        currentLocation--;

        int offset = mPositionHistoryList.get(currentLocation);

        if (offset >= length() || offset < 0) {
            for (;currentLocation >= 0; currentLocation--) {
                mPositionHistoryList.remove(currentLocation);
            }
            return false;
        }

        setSelection(offset);

        return true;
    }

    public boolean forwardLocation() {
        int size = mPositionHistoryList.size();
        if (size == 0)
            return false;

        if (currentLocation >= size - 1) {
            return false;
        }

        currentLocation++;

        int offset = mPositionHistoryList.get(currentLocation);

        if (offset >= length() || offset < 0) {
            for (int i = size - 1; i >= currentLocation; i++) {
                mPositionHistoryList.remove(i);
            }
            currentLocation = mPositionHistoryList.size() - 1;
            return false;
        }

        setSelection(offset);

        return true;
    }
}
