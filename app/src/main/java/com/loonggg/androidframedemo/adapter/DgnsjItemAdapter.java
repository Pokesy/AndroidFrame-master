package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jtech.adapter.BaseJAdapter;
import com.jtech.adapter.RecyclerSwipeAdapter;
import com.jtech.view.RecyclerHolder;
import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.RefreshModel;

import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;


/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/5/22 16:31
 * 描述:
 */

public class DgnsjItemAdapter extends
        RecyclerView.Adapter<DgnsjItemAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private String[] name;
    private int[] img;

    public DgnsjItemAdapter(Context context, String[] name, int[] img) {
        mInflater = LayoutInflater.from(context);
        this.name = name;
        this.img = img;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View arg0) {
            super(arg0);
        }

        ImageView mImg;
        TextView mTxt;
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.dgnsj_text_item,
                viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mImg = (ImageView) view
                .findViewById(R.id.iv_icon);
        viewHolder.mTxt = (TextView) view
                .findViewById(R.id.tv_title);
        return viewHolder;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        viewHolder.mImg.setImageResource(img[i]);
        viewHolder.mTxt.setText(name[i]);
    }


}