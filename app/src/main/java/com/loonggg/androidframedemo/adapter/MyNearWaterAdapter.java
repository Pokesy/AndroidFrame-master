package com.loonggg.androidframedemo.adapter;

import android.content.Context;
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
public class MyNearWaterAdapter extends RecyclerSwipeAdapter<String> {
    // 数据集
    private List<String> mDataset;
    public MyNearWaterAdapter(Context context) {
        super(context);
    }

    /**
     * 重置状态
     *
     * @param recyclerHolder
     */
    @Override
    public void clearView(RecyclerHolder recyclerHolder) {

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
    }

    @Override
    public void onSwipeEnd(RecyclerHolder recyclerHolder, float dx) {
    }

    @Override
    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, int viewType) {
        return layoutInflater.inflate(R.layout.fragment_near_water_item, viewGroup, false);
    }

    @Override
    protected void convert(RecyclerHolder holder, String model, int position) {
        holder.setText(R.id.tv_distance, model);

    }
}