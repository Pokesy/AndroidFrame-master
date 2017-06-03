package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.BrandSearchModel;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/6/3.
 * 修云飞  品牌搜索中产品GridView列表对应的适配器
 */

public class BrandSearchGridAdapter extends TeachBaseAdapter<BrandSearchModel>{

    private Context context;

    public BrandSearchGridAdapter(Context context, List<BrandSearchModel> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, BrandSearchModel item, int position) {
        ImageView productImage = (ImageView) holder.getView(R.id.layout_brandSearch_productImage);
//        new MyUtils().ShowPicture(context,"",productImage);

        TextView productName = (TextView) holder.getView(R.id.layout_brandSearch_productName);
        productName.setText(item.name);

        TextView productType = (TextView) holder.getView(R.id.layout_brandSearch_typeName);
//        productType.setText();


    }
}
