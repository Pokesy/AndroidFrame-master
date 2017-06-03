package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/6/3.
 * 修云飞  申请团购中的产品类型
 */

public class ProductTypeAdapter extends TeachBaseAdapter<String>{

    public ProductTypeAdapter(Context context, List<String> data, int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected void bindData(ViewHolder holder, String item, int position) {
        TextView typeName = (TextView) holder.getView(R.id.layout_productType_typeName);
        typeName.setText(item);
    }
}
