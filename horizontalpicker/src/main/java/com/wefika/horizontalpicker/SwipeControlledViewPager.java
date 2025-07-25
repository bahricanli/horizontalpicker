package com.wefika.horizontalpicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;


public class SwipeControlledViewPager extends ViewPager {

    private boolean canScroll = false;

    public SwipeControlledViewPager(@NonNull Context context) {
        super(context);
    }

    public SwipeControlledViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (canScroll) {
            super.onTouchEvent(ev);
        }
        return canScroll;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (canScroll) {
            super.onTouchEvent(ev);
        }
        return canScroll;
    }

    public void setCanScroll(boolean canScroll) {
        this.canScroll = canScroll;
    }

}
