package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jtech.adapter.RecyclerSwipeAdapter;
import com.jtech.view.RecyclerHolder;
import com.loonggg.androidframedemo.R;

import java.util.List;

/**
 * 测试适配器
 * Created by wuxubaiyang on 16/5/9.
 */
public class MyTestAdapter extends RecyclerSwipeAdapter<String> {
    // 数据集
    private List<String> mDataset;
    public MyTestAdapter(Context context) {
        super(context);
    }

    /**
     * 重置状态
     *
     * @param recyclerHolder
     */
    @Override
    public void clearView(RecyclerHolder recyclerHolder) {
//        recyclerHolder.hideViewGone(R.id.imageview_android);
//        recyclerHolder.hideViewGone(R.id.imageview_delete);
//        recyclerHolder.getView(R.id.relativelayout).setBackgroundColor(Color.TRANSPARENT);
    }

    /**
     * 返回一个滑动视图用户自定义，不可为空
     *
     * @param recyclerHolder
     * @return
     */
    @Override
    public View getSwipeView(RecyclerHolder recyclerHolder) {
        return null;
    }

    /**
     * 滑动监听
     *
     * @param recyclerHolder
     * @param direction
     * @param dx
     */
    @Override
    public void onSwipe(RecyclerHolder recyclerHolder, int direction, float dx) {
        //可根据direction判断方向，或者重写start和end两个方法
    }

    @Override
    public void onSwipeStart(RecyclerHolder recyclerHolder, float dx) {
        recyclerHolder.showView(R.id.imageview_android);
        recyclerHolder.hideViewGone(R.id.imageview_delete);
        recyclerHolder.getView(R.id.relativelayout).setBackgroundColor(Color.GREEN);
    }

    @Override
    public void onSwipeEnd(RecyclerHolder recyclerHolder, float dx) {
        recyclerHolder.hideViewGone(R.id.imageview_android);
        recyclerHolder.showView(R.id.imageview_delete);
        recyclerHolder.getView(R.id.relativelayout).setBackgroundColor(Color.RED);
    }

    @Override
    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, int viewType) {
        return layoutInflater.inflate(R.layout.view_item_test, viewGroup, false);
    }

    @Override
    protected void convert(RecyclerHolder holder, String model, int position) {
        holder.setText(R.id.textview, model);

    }
}