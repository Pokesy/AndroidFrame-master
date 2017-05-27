package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.NewsDetailModel;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 * 修云飞  详情页中相关推荐的适配器
 */
public class RecommendAdapter extends TeachBaseAdapter<NewsDetailModel.Data2Bean>{

    private Context context;

    public RecommendAdapter(Context context, List<NewsDetailModel.Data2Bean> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, NewsDetailModel.Data2Bean item, int position) {
        TextView title = (TextView) holder.getView(R.id.adapter_recommend_title);
        title.setText(item.getNEWS_TITLE());

        TextView readCount = (TextView) holder.getView(R.id.adapter_recommend_redCount);//阅读量
        readCount.setText("阅读"+item.getNUM());

        TextView date = (TextView) holder.getView(R.id.adapter_recommend_date);//日期
        date.setText(item.getRELEASE_TIME());

        ImageView picture = (ImageView) holder.getView(R.id.adapter_recommend_picture);//图片
        new MyUtils().ShowPicture(context,item.getPATH_NAME(),picture);
    }
}
