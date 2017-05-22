package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jtech.adapter.BaseJAdapter;
import com.jtech.view.RecyclerHolder;


/**
 * 测试适配器
 * Created by dajiao on 16/5/9.
 */
public abstract class MyBaseAdapter<D> extends BaseJAdapter<RecyclerHolder, D> {
    private Context context;
    public MyBaseAdapter(Context context) {
        super(context);
        this.context = context;
    }

    public RecyclerHolder createHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return this.createHolder(LayoutInflater.from(this.context), parent, viewType);
    }


    public void convert(RecyclerHolder holder, int viewType, int position) {
        this.convert(holder, this.getItem(position), position);
    }

    protected abstract void convert(RecyclerHolder var1, D var2, int var3);
}