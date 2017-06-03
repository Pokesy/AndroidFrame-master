package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.TypeDetailModel;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/6/2.
 */

public class TypeDetailAdapter extends TeachBaseAdapter<TypeDetailModel>{

    private Context context;

    public TypeDetailAdapter(Context context, List<TypeDetailModel> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, TypeDetailModel item, int position) {
        ImageView ptoductImage = (ImageView) holder.getView(R.id.layout_typeDetail_productImage);
//        new MyUtils().ShowPicture(context,"",ptoductImage);

        TextView productName = (TextView) holder.getView(R.id.layout_typeDetail_productName);
        productName.setText(item.name);

        //是否认证
        ImageView renImage = (ImageView) holder.getView(R.id.layout_typeDetail_renImage);

    }
}
