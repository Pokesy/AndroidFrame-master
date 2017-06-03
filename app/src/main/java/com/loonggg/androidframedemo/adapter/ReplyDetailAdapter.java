package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.ReplyDetailModel;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;
import com.loonggg.androidframedemo.view.CircleImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/5/31.
 */

public class ReplyDetailAdapter extends TeachBaseAdapter<ReplyDetailModel>{

    private Context context;

    public ReplyDetailAdapter(Context context, List<ReplyDetailModel> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, ReplyDetailModel item, int position) {
        CircleImageView imageItem = (CircleImageView) holder.getView(R.id.layout_replyDetail_imageItem);
//        new MyUtils().ShowPicture(context,"",imageItem);

        TextView nameItem = (TextView) holder.getView(R.id.layout_replyDetail_nameItem);
        nameItem.setText(item.name);

        TextView dateItem = (TextView) holder.getView(R.id.layout_replyDetail_dateItem);
//        dateItem.setText();

        TextView timeItem = (TextView) holder.getView(R.id.layout_replyDetail_timeItem);
//        timeItem.setText();

        TextView contentItem = (TextView) holder.getView(R.id.layout_replyDetail_contentItem);
//        contentItem.setText();
    }
}
