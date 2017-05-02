package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Pokesy_dajiao on 2017/4/21.
 */

public class MyViewPager extends ViewPager {

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public MyViewPager(Context context) {
        this(context, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        getParent().requestDisallowInterceptTouchEvent(true);//不允许截获手势
        return super.onTouchEvent(arg0);
    }
}
