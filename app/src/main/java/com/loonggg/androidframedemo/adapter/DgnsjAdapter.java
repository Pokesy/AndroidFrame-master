package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jtech.adapter.BaseJAdapter;
import com.jtech.view.JRecyclerView;
import com.jtech.view.RecyclerHolder;
import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.ui.activity.DgnsjDetailActivity;
import com.loonggg.androidframedemo.ui.activity.SgalActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * 测试适配器
 * Created by dajiao on 16/5/9.
 */
public class DgnsjAdapter extends BaseJAdapter<RecyclerHolder, String> {
    String[] name = {"艾迪精密", "贝力特", "顺天", "信人", "博运重工", "铭德", "世工", "佰泰", "百财", "铭润"};
    int[] img = {R.mipmap.ad, R.mipmap.blt, R.mipmap.st, R.mipmap.xr, R.mipmap.byzg, R.mipmap.md, R.mipmap.sg, R.mipmap.bt, R.mipmap.bc, R.mipmap.mr};

    // 数据集
    private List<String> mDataset;
    Context context;
    protected LayoutInflater mLayoutInflater;
    DgnsjItemAdapter mAdapter;

    public DgnsjAdapter(Context context, List<String> s) {
        super(context);
        this.context = context;
        this.mDataset = s;
        this.mLayoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else {
            return super.getItemViewType(position);
        }
    }


    @Override
    public RecyclerHolder createHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int viewType) {
        if (viewType == 1) {
//
            return new CityHolder(layoutInflater.inflate(R.layout.activity_dgnsj_item_header, viewGroup, false));
        } else {
            return new NewsHolder(layoutInflater.inflate(R.layout.activity_dgnsj_item, viewGroup, false));
        }
    }

    @Override
    public void convert(RecyclerHolder recyclerHolder, int viewType, int position) {
        if (recyclerHolder instanceof CityHolder) {
            RecyclerView jRecyclerView = recyclerHolder.getView(R.id.jrecyclerview);
            //设置布局管理器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            jRecyclerView.setLayoutManager(linearLayoutManager);
            //设置适配器
            mAdapter = new DgnsjItemAdapter(context, name, img);
            jRecyclerView.setAdapter(mAdapter);
        } else if (recyclerHolder instanceof NewsHolder) {
            recyclerHolder.getView(R.id.ll_item).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, DgnsjDetailActivity.class));
                }
            });
        }
    }

    class CityHolder extends RecyclerHolder {


        public CityHolder(View view) {
            super(view);
        }
    }

    class NewsHolder extends RecyclerHolder {

        TextView city_name;

        public NewsHolder(View view) {
            super(view);
        }
    }
}