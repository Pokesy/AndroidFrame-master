package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */

public class ShowOnePictureAdapter extends TeachBaseAdapter<String>{

    private Context context;

    public ShowOnePictureAdapter(Context context, List<String> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, String item, int position) {
        ImageView pictureShow = (ImageView) holder.getView(R.id.layout_onePicture_image);
//        new MyUtils().ShowPicture(context,"",pictureShow);
    }
}
