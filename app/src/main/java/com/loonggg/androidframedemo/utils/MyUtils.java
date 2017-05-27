package com.loonggg.androidframedemo.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.loonggg.androidframedemo.R;

/**
 * Created by Administrator on 2017/5/24.
 * 修云飞  工具类，存放项目中公用的方法
 */
public class MyUtils {

    //测试，用于页面间没有传值的跳转
    public void JumpActivity(Context context,Class<?> activity){
        Intent intent = new Intent(context,activity);
        context.startActivity(intent);
    }

    //用于界面中常规图片的显示
    public void ShowPicture(Context context,String url,ImageView imagePicture){
        Glide.with(context.getApplicationContext())
                .load(url)
                .error(R.mipmap.ic_launcher)
                .into(imagePicture);
    }
}
