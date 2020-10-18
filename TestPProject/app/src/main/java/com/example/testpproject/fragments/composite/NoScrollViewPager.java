package com.example.testpproject.fragments.composite;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class NoScrollViewPager extends ViewPager {

    // 是否禁止 viewpager 左右滑动
    private boolean isCanScroll = false;


    public NoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public void setCanScroll(boolean canScroll) {
        isCanScroll = canScroll;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        Log.e("=====onInterceptEvent", super.onTouchEvent(ev) + "");
        if (!isCanScroll) {
            return false;
        }

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        Log.e("=====onTouchEvent", super.onTouchEvent(ev) + "");
        if (!isCanScroll) {
            return false;
        }
        return super.onTouchEvent(ev);
    }


}
