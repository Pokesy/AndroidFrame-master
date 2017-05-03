package com.loonggg.androidframedemo.view;


import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 * Created by caizhiheng on 2016/10/18.
 */

class Marquee extends AppCompatTextView {

    public Marquee(Context context) {
        super(context);
    }

    public Marquee(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Marquee(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public boolean isFocused(){
        return true;
    }

}
