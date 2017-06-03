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
 * 修云飞  口碑搜索页中显示店铺列表的适配器
 */

public class BrandSearchListAdapter extends TeachBaseAdapter<BrandSearchModel>{

    private Context context;

    public BrandSearchListAdapter(Context context, List<BrandSearchModel> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, BrandSearchModel item, int position) {
        ImageView storeImage = (ImageView) holder.getView(R.id.layout_brandSearch_storeImage);
//        new MyUtils().ShowPicture(context,"",storeImage);

        TextView storeName = (TextView) holder.getView(R.id.layout_brandSearch_storeName);
        storeName.setText(item.name);

        TextView storeMain = (TextView) holder.getView(R.id.layout_brandSearch_storeMain);
//        storeMain.setText();

        //根据条件判断品牌店是否显示
        ImageView brandStore = (ImageView) holder.getView(R.id.layout_brandSearch_storePin);

        TextView storeDate = (TextView) holder.getView(R.id.layout_brandSearch_storeDate);
//        storeDate.setText();
    }
}
