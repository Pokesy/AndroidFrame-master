package com.loonggg.androidframedemo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.jtech.view.JRecyclerView;

/**
 * 简单封装的RecyclerView
 * <p>
 * Created by dajiao on 16-03-01-001.
 */
public class RGridView extends JRecyclerView {
    private int spanCount = 1;

    public RGridView(Context context) {
        this(context, null);
    }

    public RGridView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RGridView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    private void initView(Context context) {
        String tag = (String) this.getTag();
        if (!TextUtils.isEmpty(tag)) {
            spanCount = Integer.parseInt(tag);
        }
        this.setLayoutManager(new GridLayoutManager(context, spanCount));
        this.setItemAnimator(new DefaultItemAnimator());
    }
}
