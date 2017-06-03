package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.SelectAreaModel;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/5/31.
 */

public class SelectAreaAdapter extends TeachBaseAdapter<SelectAreaModel>{

    public SelectAreaAdapter(Context context, List<SelectAreaModel> data, int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected void bindData(ViewHolder holder, SelectAreaModel item, int position) {
        TextView areaName = (TextView) holder.getView(R.id.layout_selectArea_areaItem);
        areaName.setText(item.name);

        ImageView backImage = (ImageView) holder.getView(R.id.layout_selectArea_backItem);
        //根据标识判断是否显示
    }
}
