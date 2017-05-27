package com.loonggg.androidframedemo.view;

import android.widget.ListView;

/**
 * Created by nsus on 2017/3/31.
 * 修云飞  重写的ListView（解决ScrollView嵌套ListView，ListView只显示两条item的问题）
 */
public class ScrollViewWithListView extends ListView {
    public ScrollViewWithListView(android.content.Context context, android.util.AttributeSet attrs) { super(context, attrs); }
    /**
     * Integer.MAX_VALUE >> 2,如果不设置，系统默认设置是显示两条 */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
