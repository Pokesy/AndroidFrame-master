package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/6/2.
 */

public class PartsTypeListAdapter extends TeachBaseAdapter<String> implements View.OnClickListener {

    private LayoutInterface layoutInterface;
    //定义变量
    private int isChecked=-1;

    private Context context;

    public PartsTypeListAdapter(Context context, List<String> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, String item, int position) {
        TextView partsName = (TextView) holder.getView(R.id.layout_partsType_partsName);
        partsName.setText(item);

        //红线
        TextView verticalText = (TextView) holder.getView(R.id.layout_partsType_vertical);

        //配套件分类名称的外层布局
        LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.layout_partsType_linear);
        linearLayout.setTag(position);
        linearLayout.setOnClickListener(this);

        setTextBackground(context,position,partsName,verticalText);
    }

    @Override
    public void onClick(View v) {
        Integer index = (Integer) v.getTag();
        layoutInterface.getLayoutAndIndex(index, ((LinearLayout) v));
    }

    //创建一个接口
    public interface LayoutInterface{
        void getLayoutAndIndex(int index,LinearLayout layout);
    }

    //创建一个方法，传递接口
    public void getLayoutInterface(LayoutInterface layoutInterface){
        this.layoutInterface=layoutInterface;
    }

    //给isChecked符下标
    public void setIsChecked(int index){
        isChecked=index;
    }

    //根据赋值的下标进行相关操作
    public void setTextBackground(Context context,int position,TextView textName,TextView textLine){
        if (isChecked!=-1) {
            if (position==isChecked) {
                textName.setTextColor(context.getResources().getColor(R.color.color_read));
                textName.setBackgroundColor(context.getResources().getColor(R.color.font_color_white));
                textLine.setVisibility(View.VISIBLE);
            }else {
                textName.setTextColor(context.getResources().getColor(R.color.color_xxl));
                textName.setBackgroundColor(context.getResources().getColor(R.color.color_tab_bg));
                textLine.setVisibility(View.INVISIBLE);
            }
        }else {
            //设置刚进入界面时的显示
            if (position==0) {
                textName.setTextColor(context.getResources().getColor(R.color.color_read));
                textName.setBackgroundColor(context.getResources().getColor(R.color.font_color_white));
                textLine.setVisibility(View.VISIBLE);
            }
        }
    }
}
