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

public class ProductsViewAdapter extends BaseAdapter {
    //    private List<CarModel.HotlistBean> hotlist;
    private Context context;
    String[] name;
    int[] img;
//    public GridViewAdapter(Context context, List<CarModel.HotlistBean> hotlist) {
//        this.hotlist = hotlist;
//        this.context = context;
//    }

    public ProductsViewAdapter(Context context, String[] name, int[] img) {
        this.name = name;
        this.context = context;
        this.img = img;
    }

    @Override
    public int getCount() {
        return name.length;
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
        view = LayoutInflater.from(context).inflate(R.layout.brand_product_item, null);
        ImageView iv = (ImageView) view.findViewById(R.id.gv_logo_iv);

        TextView tv = (TextView) view.findViewById(R.id.gv_name_tv);
//        iv.setImageResource(R.mipmap.ad);
//        tv.setText(hotlist.get(i).getName());
//        ImageLoader.loadOptimizedHttpImage(context, hotlist.get(i).getLogoUrl())
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher)
//                .into(iv);
        iv.setImageResource(img[i]);
        tv.setText(name[i]);
        return view;
    }
}
