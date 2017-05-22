package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jtech.adapter.BaseJAdapter;
import com.jtech.adapter.RecyclerAdapter;
import com.jtech.adapter.RecyclerSwipeAdapter;
import com.jtech.view.RecyclerHolder;
import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.HomeNewsModel;

import java.util.List;

import butterknife.Bind;


/**
 * 测试适配器
 * Created by dajiao on 16/5/9.
 */
public class MyTestAdapter extends MyBaseAdapter<HomeNewsModel.DataBean.Data1Bean> {
    // 数据集
    private List<HomeNewsModel.DataBean.Data1Bean> mDataset;
    Context context;
    protected LayoutInflater mLayoutInflater;

    public MyTestAdapter(Context context) {
        super(context);
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 3) {
            return 1;
        } else {
            return super.getItemViewType(position);
        }
    }


    @Override
    public RecyclerHolder createHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int viewType) {
        if (viewType == 1) {
//
            return new CityHolder(layoutInflater.inflate(R.layout.view_image, viewGroup, false));
        } else {
            return new NewsHolder(layoutInflater.inflate(R.layout.fragment_today_recommend_news_item, viewGroup, false));
        }
    }

    @Override
    protected void convert(RecyclerHolder recyclerHolder, HomeNewsModel.DataBean.Data1Bean data1Bean, int position) {
        if (recyclerHolder instanceof CityHolder) {

        } else if (recyclerHolder instanceof NewsHolder) {
            recyclerHolder.setText(R.id.tv_content,   data1Bean.getNEWS_TITLE());
            recyclerHolder.setText(R.id.news_count,   data1Bean.getBROWSE_QTY()+"");

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
//            city_name = (TextView) view.findViewById(R.id.city_name);
        }
    }
}