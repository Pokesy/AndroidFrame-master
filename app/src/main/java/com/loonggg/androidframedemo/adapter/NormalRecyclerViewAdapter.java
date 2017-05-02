package com.loonggg.androidframedemo.adapter;

import android.support.v7.widget.RecyclerView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.RefreshModel;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;


/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/5/22 16:31
 * 描述:
 */
public class NormalRecyclerViewAdapter extends BGARecyclerViewAdapter<RefreshModel> {
    public NormalRecyclerViewAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.fragment_today_recommend_news_item);
    }

    @Override
    public void setItemChildListener(BGAViewHolderHelper viewHolderHelper, int viewType) {
        viewHolderHelper.setItemChildClickListener(R.id.news_count);
        viewHolderHelper.setItemChildLongClickListener(R.id.news_count);
    }

    @Override
    public void fillData(BGAViewHolderHelper viewHolderHelper, int position, RefreshModel model) {
//        viewHolderHelper.setText(R.id.news_count, model.title).setText(R.id.tv_content, model.detail);
    }
}