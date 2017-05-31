package com.loonggg.androidframedemo.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.net.constant.BottomDialogInterface;
import com.loonggg.androidframedemo.net.constant.SureAndCancelInterface;

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

    //自定义布局的Dialog(有确定与取消的按钮)，而且四个角为圆角
    public void ShowCustomDialog(Context context, int layoutResId, int sureId, int cancelId, final SureAndCancelInterface myInterface){
        //下面是弹窗
        final AlertDialog customDialog = new AlertDialog.Builder(context).create();
        //点击对话框以外的位置不会消失
        customDialog.setCancelable(false);
        //cancleDialog.setCanceledOnTouchOutside(false);
        customDialog.show();

        //下面是四个角显示圆形的关键
        Window window = customDialog.getWindow();

        WindowManager.LayoutParams lp = window.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics(); // 获取屏幕宽、高用

        lp.width = (int) (d.widthPixels * 0.7); // 宽度设置为屏幕的0.8
        window.setAttributes(lp);

        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  // 有白色背景，加

        //添加布局
        View inflate = LayoutInflater.from(context).inflate(layoutResId, null);
        window.setContentView(inflate);

        //确定的按钮
        TextView mDialogSure = ((TextView) inflate.findViewById(sureId));
        //确定按钮的监听
        mDialogSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myInterface.returnSure("ok",customDialog);
            }
        });

        //取消的按钮
        TextView mDialogCancel= ((TextView) inflate.findViewById(cancelId));
        //取消按钮的监听
        mDialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myInterface.returnCancel("no",customDialog);
            }
        });
    }

    //购物流程--提交订单中，从底部弹出的Dialog
    public void getDialogFromBottom(Context context, int resourceId, BottomDialogInterface myInterface){
        final Dialog mCameraDialog = new Dialog(context,R.style.MyDialog);
        View root = LayoutInflater.from(context).inflate(resourceId, null);
        mCameraDialog.setContentView(root);
        //点击布局意外的区域不会消失
        mCameraDialog.setCanceledOnTouchOutside(false);
        mCameraDialog.show();

        // 设置弹出的动画效果
        mCameraDialog.getWindow().setWindowAnimations(R.style.AnimBottom);
        //设置宽度全屏要在show后面
        WindowManager.LayoutParams layoutParams = mCameraDialog.getWindow().getAttributes();
        layoutParams.gravity= Gravity.BOTTOM;
        layoutParams.width= ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height= ViewGroup.LayoutParams.WRAP_CONTENT;
        mCameraDialog.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        mCameraDialog.getWindow().setAttributes(layoutParams);
//        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画

        myInterface.getLayout(root,mCameraDialog);
    }

    //定义一个从底部出现的View（以动画的方式）
    public void setAnimationFromBottom(View view){
        int height = view.getHeight();
        //进行动画操作
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f, 0.0f, 1.0f});
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(view, "translationY", new float[]{0.0f, -height, height, 0.0f});
        //组合动画的实现方式之一：
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animator1, animator4);
        set.setDuration(1000);
        set.start();
    }

}
