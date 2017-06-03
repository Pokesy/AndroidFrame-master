package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.DealerProDetailModel;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;
import com.loonggg.androidframedemo.view.CircleImageView;
import com.loonggg.androidframedemo.view.MyGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */

public class DealerProPraiseAdapter extends TeachBaseAdapter<DealerProDetailModel>{

    private Context context;
    //GridView显示图片的适配器
    private List<String> mPictureData;

    public DealerProPraiseAdapter(Context context, List<DealerProDetailModel> data,List<String> mPictureData, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
        this.mPictureData=mPictureData;
    }

    @Override
    protected void bindData(ViewHolder holder, DealerProDetailModel item, int position) {
        CircleImageView picturePraise = (CircleImageView) holder.getView(R.id.layout_dealerDetail_picturePraise);
//        new MyUtils().ShowPicture(context,"",picturePraise);

        TextView namrPraise = (TextView) holder.getView(R.id.layout_dealerDetail_namePraise);
//        namrPraise.setText();

        TextView datePraise = (TextView) holder.getView(R.id.layout_dealerDetail_datePraise);
//        datePraise.setText();

        TextView goodPraise = (TextView) holder.getView(R.id.layout_dealerDetail_goodPraise);
//        goodPraise.setText();d

        TextView contentPraise = (TextView) holder.getView(R.id.layout_dealerDetail_contentPraise);
//        contentPraise.setText();

        MyGridView gridPraise = (MyGridView) holder.getView(R.id.layout_dealerDetail_girdPraise);
        gridPraise.setHorizontalSpacing(20);
        gridPraise.setVerticalSpacing(20);

        ShowOnePictureAdapter pictureAdapter = new ShowOnePictureAdapter(context, mPictureData, R.layout.layout_one_picture_item);
        gridPraise.setAdapter(pictureAdapter);

    }
}
