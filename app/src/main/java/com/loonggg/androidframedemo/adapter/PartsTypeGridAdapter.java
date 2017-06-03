package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.PartsTypeModel;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/6/2.
 * 修云飞  配套件分类页面中展示相应的配套件的内容的适配器
 */

public class PartsTypeGridAdapter extends TeachBaseAdapter<PartsTypeModel>{

    private Context context;

    public PartsTypeGridAdapter(Context context, List<PartsTypeModel> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, PartsTypeModel item, int position) {
        ImageView gridPicture = (ImageView) holder.getView(R.id.layout_partsType_girdPicture);
//        new MyUtils().ShowPicture(context,"",gridPicture);

        TextView gridName = (TextView) holder.getView(R.id.layout_partsType_girdName);
        gridName.setText(item.name);
    }
}
