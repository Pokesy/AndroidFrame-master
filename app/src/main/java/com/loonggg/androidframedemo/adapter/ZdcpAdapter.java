package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jtech.adapter.BaseJAdapter;
import com.jtech.view.RecyclerHolder;
import com.loonggg.androidframedemo.R;

import java.util.List;


/**
 * 测试适配器
 * Created by dajiao on 16/5/9.
 */
public class ZdcpAdapter extends BaseJAdapter<RecyclerHolder,String> {
    // 数据集
    private List<String> mDataset;
    Context context;
    protected LayoutInflater mLayoutInflater;

    public ZdcpAdapter(Context context, List<String> s) {
        super(context);
        this.context = context;
        this.mDataset = s;
        this.mLayoutInflater = LayoutInflater.from(context);
    }



    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    public RecyclerHolder createHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int viewType) {
        return new NewsHolder(layoutInflater.inflate(R.layout.brand_zdcp_item, viewGroup, false));
    }

    @Override
    public void convert(RecyclerHolder recyclerHolder, int viewType, int position) {

    }


    public class NewsHolder extends RecyclerHolder {

        public NewsHolder(View view) {
            super(view);
        }
    }
}