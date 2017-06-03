package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.AnswerModel;
import com.loonggg.androidframedemo.model.DealerProDetailModel;
import com.loonggg.androidframedemo.ui.activity.ReplyDetailActivity;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;
import com.loonggg.androidframedemo.view.CircleImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 * 修云飞  经销商产品详情页中--最新评论列表对应的适配器
 */

public class DealerProCommentAdapter extends TeachBaseAdapter<DealerProDetailModel> implements View.OnClickListener {

    private Context context;

    public DealerProCommentAdapter(Context context, List<DealerProDetailModel> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, DealerProDetailModel item, int position) {
        CircleImageView userImage = (CircleImageView) holder.getView(R.id.adapter_comment_userImage);
//        new MyUtils().ShowPicture(context,item.getPATH_NAME(),userImage);

        TextView userName = (TextView) holder.getView(R.id.adapter_comment_userName);
        userName.setText(item.name);

        TextView date = (TextView) holder.getView(R.id.adapter_comment_date);//日期
//        date.setText(item.getNEWS_REPLY_TIME_STR());

        TextView time = (TextView) holder.getView(R.id.adapter_comment_time);//时间
//        String replyTime = item.getNEWS_REPLY_TIME();
//        time.setText(replyTime.substring(10));

        TextView content = (TextView) holder.getView(R.id.adapter_comment_content);//评论内容
//        content.setText(item.getNEWS_REPLY_CONTENT());

        TextView reply = (TextView) holder.getView(R.id.adapter_comment_reply);//回复按钮
        reply.setTag(position);
        reply.setOnClickListener(this);
    }

    //回复按钮的监听
    @Override
    public void onClick(View v) {
        Integer tag = (Integer) v.getTag();
        Log.e("TAG", "onClick你点击了回复按钮: "+tag );
        new MyUtils().JumpActivity(context, ReplyDetailActivity.class);
    }
}
