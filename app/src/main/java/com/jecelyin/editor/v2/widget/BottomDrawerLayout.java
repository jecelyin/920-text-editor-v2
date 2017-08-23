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

package com.jecelyin.editor.v2.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RemoteViews.RemoteView;

import java.util.ArrayList;


/**
 * FrameLayout is designed to block out an area on the screen to display
 * a single item. Generally, FrameLayout should be used to hold a single child view, because it can
 * be difficult to organize child views in a way that's scalable to different screen sizes without
 * the children overlapping each other. You can, however, add multiple children to a FrameLayout
 * and control their position within the FrameLayout by assigning gravity to each child, using the
 * <a href="FrameLayout.LayoutParams.html#attr_android:layout_gravity">{@code
 * android:layout_gravity}</a> attribute.
 * <p>Child views are drawn in a stack, with the most recently added child on top.
 * The size of the FrameLayout is the size of its largest child (plus padding), visible
 * or not (if the FrameLayout's parent permits). Views that are {@link View#GONE} are
 * used for sizing
 * only if {@link #setMeasureAllChildren(boolean) setConsiderGoneChildrenWhenMeasuring()}
 * is set to true.
 *
 * @attr ref android.R.styleable#FrameLayout_measureAllChildren
 */
@RemoteView
public class BottomDrawerLayout extends ViewGroup {
    private static final int DEFAULT_CHILD_GRAVITY = Gravity.TOP | Gravity.START;

    @ViewDebug.ExportedProperty(category = "measurement")
    boolean mMeasureAllChildren = false;

    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingLeft = 0;

    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingTop = 0;

    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingRight = 0;

    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingBottom = 0;

    private final Rect mSelfBounds = new Rect();
    private final Rect mOverlayBounds = new Rect();

    private final ArrayList<View> mMatchParentChildren = new ArrayList<View>(1);

    private ViewDragHelper mBottomDragger;
    private ViewDragCallback mBottomCallback;
    private float mSlideOffset;
    private static final float TOUCH_SLOP_SENSITIVITY = 1.f;
    /**
     * Minimum velocity that will be detected as a fling
     */
    private static final int MIN_FLING_VELOCITY = 400; // dips per second
    /**
     * Length of time to delay before peeking the drawer.
     */
    private static final int PEEK_DELAY = 160; // ms

    public BottomDrawerLayout(Context context) {
        super(context);
    }

    public BottomDrawerLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomDrawerLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final float density = getResources().getDisplayMetrics().density;
        final float minVel = MIN_FLING_VELOCITY * density;

        mBottomCallback = new ViewDragCallback();
        mBottomDragger = ViewDragHelper.create(this, TOUCH_SLOP_SENSITIVITY, mBottomCallback);
        mBottomDragger.setEdgeTrackingEnabled(ViewDragHelper.EDGE_BOTTOM);
        mBottomDragger.setMinVelocity(minVel);
        mBottomCallback.setDragger(mBottomDragger);
    }

    /**
     * Returns a set of layout parameters with a width of
     * {@link ViewGroup.LayoutParams#MATCH_PARENT},
     * and a height of {@link ViewGroup.LayoutParams#MATCH_PARENT}.
     */
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    int getPaddingLeftWithForeground() {
        return getPaddingLeft() + mForegroundPaddingLeft;
    }

    int getPaddingRightWithForeground() {
        return getPaddingRight() + mForegroundPaddingRight;
    }

    private int getPaddingTopWithForeground() {
        return getPaddingTop() + mForegroundPaddingTop;
    }

    private int getPaddingBottomWithForeground() {
        return getPaddingBottom() + mForegroundPaddingBottom;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();

        final boolean measureMatchParentChildren =
                MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.EXACTLY ||
                MeasureSpec.getMode(heightMeasureSpec) != MeasureSpec.EXACTLY;
        mMatchParentChildren.clear();

        int maxHeight = 0;
        int maxWidth = 0;
        int childState = 0;

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (mMeasureAllChildren || child.getVisibility() != GONE) {
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                maxWidth = Math.max(maxWidth,
                        child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin);
                maxHeight = Math.max(maxHeight,
                        child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin);
                childState = combineMeasuredStates(childState, child.getMeasuredState());
                if (measureMatchParentChildren) {
                    if (lp.width == LayoutParams.MATCH_PARENT ||
                            lp.height == LayoutParams.MATCH_PARENT) {
                        mMatchParentChildren.add(child);
                    }
                }
            }
        }

        // Account for padding too
        maxWidth += getPaddingLeftWithForeground() + getPaddingRightWithForeground();
        maxHeight += getPaddingTopWithForeground() + getPaddingBottomWithForeground();

        // Check against our minimum height and width
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());
        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());

        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, childState),
                resolveSizeAndState(maxHeight, heightMeasureSpec,
                        childState << MEASURED_HEIGHT_STATE_SHIFT));

        count = mMatchParentChildren.size();
        if (count > 1) {
            for (int i = 0; i < count; i++) {
                final View child = mMatchParentChildren.get(i);
                final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

                final int childWidthMeasureSpec;
                if (lp.width == LayoutParams.MATCH_PARENT) {
                    final int width = Math.max(0, getMeasuredWidth()
                            - getPaddingLeftWithForeground() - getPaddingRightWithForeground()
                            - lp.leftMargin - lp.rightMargin);
                    childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                            width, MeasureSpec.EXACTLY);
                } else {
                    childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec,
                            getPaddingLeftWithForeground() + getPaddingRightWithForeground() +
                            lp.leftMargin + lp.rightMargin,
                            lp.width);
                }

                final int childHeightMeasureSpec;
                if (lp.height == LayoutParams.MATCH_PARENT) {
                    final int height = Math.max(0, getMeasuredHeight()
                            - getPaddingTopWithForeground() - getPaddingBottomWithForeground()
                            - lp.topMargin - lp.bottomMargin);
                    childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                            height, MeasureSpec.EXACTLY);
                } else {
                    childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec,
                            getPaddingTopWithForeground() + getPaddingBottomWithForeground() +
                            lp.topMargin + lp.bottomMargin,
                            lp.height);
                }

                child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        layoutChildren(left, top, right, bottom, false /* no force left gravity */);
    }

    void layoutChildren(int left, int top, int right, int bottom,
                                  boolean forceLeftGravity) {
        final int count = getChildCount();

        final int parentLeft = getPaddingLeftWithForeground();
        final int parentRight = right - left - getPaddingRightWithForeground();

        final int parentTop = getPaddingTopWithForeground();
        final int parentBottom = bottom - top - getPaddingBottomWithForeground();
        int symbolHeight = 0;
        // 尽可能先找到Bottom View
        for (int i = count - 1; i >= 0; i--) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();

                final int width = child.getMeasuredWidth();
                final int height = child.getMeasuredHeight();

                int childLeft;
                int childTop;

                int gravity = lp.gravity;
                if (gravity == -1) {
                    gravity = Gravity.NO_GRAVITY;
                }

                final int layoutDirection = ViewCompat.getLayoutDirection(this);
                final int absoluteGravity = Gravity.getAbsoluteGravity(gravity, layoutDirection);
                final int verticalGravity = gravity & Gravity.VERTICAL_GRAVITY_MASK;

                switch (absoluteGravity & Gravity.HORIZONTAL_GRAVITY_MASK) {
                    case Gravity.CENTER_HORIZONTAL:
                        childLeft = parentLeft + (parentRight - parentLeft - width) / 2 +
                        lp.leftMargin - lp.rightMargin;
                        break;
                    case Gravity.RIGHT:
                    case Gravity.END:
                        if (!forceLeftGravity) {
                            childLeft = parentRight - width - lp.rightMargin;
                            break;
                        }
                    case Gravity.LEFT:
                    case Gravity.START:
                    default:
                        childLeft = parentLeft + lp.leftMargin;
                }

                switch (verticalGravity) {
                    case Gravity.TOP:
                        childTop = parentTop + lp.topMargin;
                        break;
                    case Gravity.CENTER_VERTICAL:
                        childTop = parentTop + (parentBottom - parentTop - height) / 2 +
                        lp.topMargin - lp.bottomMargin;
                        break;
                    case Gravity.BOTTOM:
                        symbolHeight = ((ViewGroup)child).getChildCount() > 0 ? ((ViewGroup)child).getChildAt(0).getMeasuredHeight() : 0;
                        float offset = mSlideOffset == 0 ? (symbolHeight == 0 ? 0.3f : symbolHeight / (float)height) : mSlideOffset;
                        childTop = parentBottom - (int) (height * offset);
//                        childTop = parentBottom - height - lp.bottomMargin;
                        break;
                    default:
                        childTop = parentTop + lp.topMargin;
                }

                child.layout(childLeft, childTop, childLeft + width, childTop + height);
            }
        }

    }

    /**
     * Sets whether to consider all children, or just those in
     * the VISIBLE or INVISIBLE state, when measuring. Defaults to false.
     *
     * @param measureAll true to consider children marked GONE, false otherwise.
     * Default value is false.
     *
     * @attr ref android.R.styleable#FrameLayout_measureAllChildren
     */
    public void setMeasureAllChildren(boolean measureAll) {
        mMeasureAllChildren = measureAll;
    }

    /**
     * Determines whether all children, or just those in the VISIBLE or
     * INVISIBLE state, are considered when measuring.
     *
     * @return Whether all children are considered when measuring.
     *
     * @deprecated This method is deprecated in favor of
     * {@link #getMeasureAllChildren() getMeasureAllChildren()}, which was
     * renamed for consistency with
     * {@link #setMeasureAllChildren(boolean) setMeasureAllChildren()}.
     */
    @Deprecated
    public boolean getConsiderGoneChildrenWhenMeasuring() {
        return getMeasureAllChildren();
    }

    /**
     * Determines whether all children, or just those in the VISIBLE or
     * INVISIBLE state, are considered when measuring.
     *
     * @return Whether all children are considered when measuring.
     */
    public boolean getMeasureAllChildren() {
        return mMeasureAllChildren;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return BottomDrawerLayout.class.getName();
    }

//    /** @hide */
//    @Override
//    protected void encodeProperties(@NonNull ViewHierarchyEncoder encoder) {
//        super.encodeProperties(encoder);
//
//        encoder.addProperty("measurement:measureAllChildren", mMeasureAllChildren);
//        encoder.addProperty("padding:foregroundPaddingLeft", mForegroundPaddingLeft);
//        encoder.addProperty("padding:foregroundPaddingTop", mForegroundPaddingTop);
//        encoder.addProperty("padding:foregroundPaddingRight", mForegroundPaddingRight);
//        encoder.addProperty("padding:foregroundPaddingBottom", mForegroundPaddingBottom);
//    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public LayoutParams(@NonNull ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }
    }


    // Drag Bottom Start ---------------------------------------------------------------------------
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mBottomDragger.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        mBottomDragger.processTouchEvent(ev);
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if ( !mBottomDragger.isEdgeTouched(ViewDragHelper.EDGE_BOTTOM) ) {
            // If we have an edge touch we want to skip this and track it for later instead.
            super.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }

    @Override
    public void computeScroll() {
        // "|" used on purpose; both need to run.
        if (mBottomDragger.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    int getDrawerViewAbsoluteGravity(View drawerView) {
        final int gravity = ((LayoutParams) drawerView.getLayoutParams()).gravity;
        return GravityCompat.getAbsoluteGravity(gravity, ViewCompat.getLayoutDirection(this));
    }

    View findDrawerWithGravity(int gravity) {
        final int absHorizGravity = GravityCompat.getAbsoluteGravity(
                gravity, ViewCompat.getLayoutDirection(this)) & Gravity.HORIZONTAL_GRAVITY_MASK;
        final int absVerticalGravity = GravityCompat.getAbsoluteGravity(
                gravity, ViewCompat.getLayoutDirection(this)) & Gravity.VERTICAL_GRAVITY_MASK;
        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);
            final int childAbsGravity = getDrawerViewAbsoluteGravity(child);
            if (
                    ( absHorizGravity != 0 && (childAbsGravity & Gravity.HORIZONTAL_GRAVITY_MASK) == absHorizGravity ) ||
                            ( absVerticalGravity != 0 && (childAbsGravity & Gravity.VERTICAL_GRAVITY_MASK) == absVerticalGravity )

                    ) {
                return child;
            }
        }
        return null;
    }

    private class ViewDragCallback extends ViewDragHelper.Callback {
        private ViewDragHelper mDragger;
        private final Runnable mPeekRunnable = new Runnable() {
            @Override public void run() {
                peekDrawer();
            }
        };


        public void setDragger(ViewDragHelper dragger) {
            mDragger = dragger;
        }

        public void removeCallbacks() {
            BottomDrawerLayout.this.removeCallbacks(mPeekRunnable);
        }

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            // Only capture views where the gravity matches what we're looking for.
            // This lets us use two ViewDragHelpers, one for each side drawer.
//            return isDrawerView(child) && checkDrawerViewAbsoluteGravity(child, mAbsGravity)
//                    && getDrawerLockMode(child) == LOCK_MODE_UNLOCKED;
            return getDrawerViewAbsoluteGravity(child) == Gravity.BOTTOM && child.getVisibility() == VISIBLE;
        }

        @Override
        public void onViewDragStateChanged(int state) {
//            updateDrawerState(mAbsGravity, state, mDragger.getCapturedView());
        }

        @Override
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            float offset;
            final int childWidth = changedView.getWidth();

            final int height = getHeight();
            final int childHeight = changedView.getHeight();
            offset = (float) (height - top) / childHeight;

            final LayoutParams lp = (LayoutParams) changedView.getLayoutParams();
            int childTop = height + lp.topMargin;
            float fixOffset = (float) (height - childTop) / childHeight;
            if (offset <= fixOffset) {
                offset = fixOffset;
            }

            setDrawerViewOffset(changedView, offset);
//            changedView.setVisibility(offset == 0 || (isBottom && mHideBottomDrawer) ? INVISIBLE : VISIBLE);
            invalidate();
        }

        void setDrawerViewOffset(View drawerView, float slideOffset) {
            if (slideOffset == mSlideOffset) {
                return;
            }

            mSlideOffset = slideOffset;
        }

        @Override
        public void onViewCaptured(View capturedChild, int activePointerId) {

        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            // Offset is how open the drawer is, therefore left/right values
            // are reversed from one another.
            final float offset = mSlideOffset;
            final int childHeight = releasedChild.getHeight();
            final float symbolHeight = ((ViewGroup)releasedChild).getChildCount() > 0
                    ? ((ViewGroup)releasedChild).getChildAt(0).getMeasuredHeight()
                    : childHeight * 0.3f;

            int left, top;

            final LayoutParams lp = (LayoutParams) releasedChild.getLayoutParams();
            final int height = getHeight();
            left = releasedChild.getLeft();
            //控制底部 View 高度
            top = yvel < 0 || yvel == 0 && offset > 0.5f ? height - childHeight : height - (int)symbolHeight;

            mDragger.settleCapturedViewAt(left, top);
            invalidate();
        }

        @Override
        public void onEdgeTouched(int edgeFlags, int pointerId) {
            postDelayed(mPeekRunnable, PEEK_DELAY);
        }

        private void peekDrawer() {
            final View toCapture = findDrawerWithGravity(Gravity.BOTTOM);
            final int peekDistance = mDragger.getEdgeSize();

            final int childTop = getHeight() - peekDistance;
            if (toCapture.getTop() > childTop) {
                mDragger.smoothSlideViewTo(toCapture, toCapture.getLeft(), childTop);
                invalidate();
            }


        }

        @Override
        public boolean onEdgeLock(int edgeFlags) {
            return false;
        }

        @Override
        public void onEdgeDragStarted(int edgeFlags, int pointerId) {
            View toCapture = null;
            if ((edgeFlags & ViewDragHelper.EDGE_BOTTOM) == ViewDragHelper.EDGE_BOTTOM) {
                toCapture = findDrawerWithGravity(Gravity.BOTTOM);
            }

            if (toCapture != null) {
                mDragger.captureChildView(toCapture, pointerId);
            }
        }

        @Override
        public int getViewHorizontalDragRange(View child) {
            return child.getWidth();
        }

        @Override
        public int getViewVerticalDragRange(View child) {
//            final int height = getHeight();
//            final LayoutParams lp = (LayoutParams) child.getLayoutParams();
//            int childTop = height - lp.topMargin;
//            return childTop;
            return child.getHeight();

        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return child.getLeft();
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            final int height = getHeight();
            final LayoutParams lp = (LayoutParams) child.getLayoutParams();
            int childTop = height + lp.topMargin;
            int v = Math.min(childTop, Math.max(top, height - child.getHeight()));
            return v;
        }
    }
}
