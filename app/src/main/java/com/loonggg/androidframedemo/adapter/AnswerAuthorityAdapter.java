package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.AnswerAuthorityModel;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;
import com.loonggg.androidframedemo.view.CircleImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/6/2.
 * 修云飞  问大家页面的列表对应的适配器
 */

public class AnswerAuthorityAdapter extends TeachBaseAdapter<AnswerAuthorityModel>{

    private Context context;

    public AnswerAuthorityAdapter(Context context, List<AnswerAuthorityModel> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, AnswerAuthorityModel item, int position) {
        TextView questionContent = (TextView) holder.getView(R.id.layout_answerAuthority_quwstionContent);
        questionContent.setText(item.name);

        CircleImageView userImage = (CircleImageView) holder.getView(R.id.layout_answerAuthority_questionImage);
//        new MyUtils().ShowPicture(context,"",userImage);

        TextView answerContent = (TextView) holder.getView(R.id.layout_answerAuthority_answerContent);
//        answerContent.setText();

        TextView allAnswer = (TextView) holder.getView(R.id.layout_answerAuthority_lookAnswer);
        allAnswer.setText("查看"+7+"个回答");

        TextView dateText = (TextView) holder.getView(R.id.layout_answerAuthority_date);
//        dateText.setText();

    }
}
