package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */

public class HomeSearchAdapter extends TeachBaseAdapter<String>{

    public HomeSearchAdapter(Context context, List<String> data, int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected void bindData(ViewHolder holder, String item, int position) {
        TextView historyName = (TextView) holder.getView(R.id.layout_homeSearch_history);
        historyName.setText(item);
    }
}
