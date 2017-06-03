package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 * 修云飞  经销商产品详情页中的---产品详情展示图片的适配器
 */

public class DealerDetailPictureAdapter extends TeachBaseAdapter<String>{

    private Context context;

    public DealerDetailPictureAdapter(Context context, List<String> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, String item, int position) {
        ImageView showPicture = (ImageView) holder.getView(R.id.layout_dealerDetail_showPicture);
//        new MyUtils().ShowPicture(context,item,showPicture);
    }
}
