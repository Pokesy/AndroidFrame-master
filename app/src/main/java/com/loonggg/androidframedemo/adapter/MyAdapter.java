package com.loonggg.androidframedemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;

import java.util.List;

/**
 * Created by dajiao
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    // 数据集
    private List<String> mDataset;
    private List<String> nDataset;

    public MyAdapter(List<String> dataset) {
        super();
        mDataset = dataset;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        // 创建一个View，简单起见直接使用系统提供的布局，就是一个TextView

        View view = View.inflate(viewGroup.getContext(), R.layout.fragment_today_message_item, null);

        // 创建一个ViewHolder

        ViewHolder holder = new ViewHolder(view);
        holder.mTexttitle = (TextView) view.findViewById(R.id.tv_title);
        holder.mTextcontent = (TextView) view.findViewById(R.id.tv_content);
        return holder;

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        // 绑定数据到ViewHolder上

        viewHolder.mTexttitle.setText("标题"+mDataset.get(i));
        viewHolder.mTextcontent.setText("正文"+mDataset.get(i));
    }

    @Override
    public int getItemCount() {


        return mDataset.size() > 2 ? 2 : mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTexttitle;
        public TextView mTextcontent;


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}



