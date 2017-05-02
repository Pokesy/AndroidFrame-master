package com.loonggg.androidframedemo.adapter;

import android.content.Context;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.RefreshModel;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;


/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/5/21 上午12:39
 * 描述:
 */
public class NormalAdapterViewAdapter extends BGAAdapterViewAdapter<RefreshModel> {

    public NormalAdapterViewAdapter(Context context) {
        super(context, R.layout.fragment_today_recommend_news_item);
    }

    @Override
    protected void setItemChildListener(BGAViewHolderHelper viewHolderHelper) {
        viewHolderHelper.setItemChildClickListener(R.id.news_count);
        viewHolderHelper.setItemChildLongClickListener(R.id.news_count);
    }

    @Override
    public void fillData(BGAViewHolderHelper viewHolderHelper, int position, RefreshModel model) {
        viewHolderHelper.setText(R.id.news_count, model.title);
        viewHolderHelper.setText(R.id.tv_content, model.detail);
    }
}