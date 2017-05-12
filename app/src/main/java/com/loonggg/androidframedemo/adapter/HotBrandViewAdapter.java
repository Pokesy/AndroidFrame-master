package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;

/**
 * 作者：loonggg on 2016/9/1 16:48
 */

public class HotBrandViewAdapter extends BaseAdapter {
    //    private List<CarModel.HotlistBean> hotlist;
    private Context context;
    String[] name;
    int[] img;
//    public GridViewAdapter(Context context, List<CarModel.HotlistBean> hotlist) {
//        this.hotlist = hotlist;
//        this.context = context;
//    }

    public HotBrandViewAdapter(Context context, String[] name, int[] img) {
        this.name = name;
        this.context = context;
        this.img = img;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int i) {
        return name[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.activity_water_brand_item, null);

        return view;
    }
}
