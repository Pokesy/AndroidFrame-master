package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.ProductParamsModel;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */

public class ProductParamsAdapter extends TeachBaseAdapter<ProductParamsModel>{

    public ProductParamsAdapter(Context context, List<ProductParamsModel> data, int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected void bindData(ViewHolder holder, ProductParamsModel item, int position) {
        TextView parmsName = (TextView) holder.getView(R.id.layout_productParams_paramsName);
        parmsName.setText(item.name);

        TextView paramsValue = (TextView) holder.getView(R.id.layout_productParams_paramsContent);
        paramsValue.setText(item.value);

    }
}
