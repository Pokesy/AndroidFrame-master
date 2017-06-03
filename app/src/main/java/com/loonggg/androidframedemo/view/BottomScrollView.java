package com.loonggg.androidframedemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
/*
* 修云飞 3/26  自定义ScrollView监听滑动到底部(对外提供OnScrollToBottomListener方法获取滑动距离)
* */
public class BottomScrollView extends ScrollView {

    private OnScrollToBottomListener onScrollToBottom;

    public BottomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomScrollView(Context context) {
        super(context);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,
                                  boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        if(scrollY != 0 && null != onScrollToBottom){
            onScrollToBottom.onScrollBottomListener(clampedY,scrollY);
        }
    }

    public void setOnScrollToBottomLintener(OnScrollToBottomListener listener){
        onScrollToBottom = listener;
    }

    public interface OnScrollToBottomListener{
        public void onScrollBottomListener(boolean isBottom, int scrollY);
    }
}
