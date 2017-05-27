package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.SelectAddressModel;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 * 修云飞  选择收货地址页面中，显示地址信息列表的适配器
 */

public class SelectAddressAdapter extends TeachBaseAdapter<SelectAddressModel>{

    public SelectAddressAdapter(Context context, List<SelectAddressModel> data, int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected void bindData(ViewHolder holder, SelectAddressModel item, int position) {
        TextView peopleName = (TextView) holder.getView(R.id.layout_selectAddress_peopleName);
        peopleName.setText(item.name);

        TextView peoplePhone = (TextView) holder.getView(R.id.layout_selectAddress_peoplePhone);
        peoplePhone.setText(item.phone);

        TextView peopleAddress = (TextView) holder.getView(R.id.layout_selectAddress_peopleAddress);
        if (item.type==0) {
            String prefix = "[默认地址]";
            String address = "地址：" + item.content;
            String content = "[默认地址]"+address;

            final SpannableStringBuilder sp = new  SpannableStringBuilder(content);
            sp.setSpan(new ForegroundColorSpan(0xFFFD7F43), 0, prefix.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            peopleAddress.setText(sp);
        }else {
            peopleAddress.setText(item.content);
        }
    }
}
