package com.loonggg.androidframedemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;

/**
 * Created by Administrator on 2017/5/24.
 * 修云飞   自定义界面中顶部的标题栏
 */
public class TopTitleView extends RelativeLayout{

    private TextView mTopTitle;
    private ImageView mTopBack;
    private ImageView mTopSetting;

    public TopTitleView(Context context) {
        super(context);
    }

    public TopTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_top_title,this);

        mTopTitle = ((TextView) findViewById(R.id.layout_topTitle));//标题
        mTopBack = ((ImageView) findViewById(R.id.layout_topImage_back));//返回图标
        mTopSetting = ((ImageView) findViewById(R.id.layout_topImage_setting));//选择功能图标
    }

    //修改顶部标题的方法
    public void setTopTitle(String content){
        mTopTitle.setText(content);
    }

    //修改顶部左边返回按钮的方法
    public void setTopLeftBack(int image){
        mTopBack.setImageResource(image);
    }
    //监听顶部左边返回按钮的方法
    public void setLeftBackListener(OnClickListener listener){
        mTopBack.setOnClickListener(listener);
    }

    //修改顶部右边选择功能按钮的方法
    public void setTopRightSetting(int image){
        mTopSetting.setImageResource(image);
    }
    //监听顶部左边返回按钮的方法
    public void setRightSettingListener(OnClickListener listener){
        mTopBack.setOnClickListener(listener);
    }
}
