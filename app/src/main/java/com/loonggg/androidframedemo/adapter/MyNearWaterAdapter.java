package com.loonggg.androidframedemo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jtech.adapter.RecyclerSwipeAdapter;
import com.jtech.view.RecyclerHolder;
import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.ui.activity.SearchLocationActivity;
import com.michael.easydialog.EasyDialog;

import java.util.List;

/**
 * 测试适配器
 * Created by wuxubaiyang on 16/5/9.
 */
public class MyNearWaterAdapter extends RecyclerSwipeAdapter<String> {
    // 数据集
    private List<String> mDataset;
    public MyNearWaterAdapter(Context context) {
        super(context);
        this.context=context;
    }

    private Context context;
    /**
     * 重置状态
     *
     * @param recyclerHolder
     */
    @Override
    public void clearView(RecyclerHolder recyclerHolder) {

    }

    /**
     * 返回一个滑动视图用户自定义，不可为空
     *
     * @param recyclerHolder
     * @return
     */
    @Override
    public View getSwipeView(RecyclerHolder recyclerHolder) {
        return null;
    }

    /**
     * 滑动监听
     *
     * @param recyclerHolder
     * @param direction
     * @param dx
     */
    @Override
    public void onSwipe(RecyclerHolder recyclerHolder, int direction, float dx) {
        //可根据direction判断方向，或者重写start和end两个方法
    }

    @Override
    public void onSwipeStart(RecyclerHolder recyclerHolder, float dx) {
    }

    @Override
    public void onSwipeEnd(RecyclerHolder recyclerHolder, float dx) {
    }

    @Override
    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, int viewType) {
        return layoutInflater.inflate(R.layout.fragment_near_water_item, viewGroup, false);
    }

    @Override
    protected void convert(final RecyclerHolder holder, String model, int position) {
        holder.getView(R.id.tv_location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,SearchLocationActivity.class));
            }
        });
        holder.getView(R.id.tv_phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view2 =((Activity)context).getLayoutInflater().inflate(R.layout.test1, null);
                TextView bt1 = (TextView) view2.findViewById(R.id.tv_delete);

                final EasyDialog dialog1 = new EasyDialog(context);
//                dialog1.setLayoutResourceId(R.layout.test1)//layout resource id
                dialog1.setLayout(view2)
                        .setBackgroundColor(context.getResources().getColor(R.color.font_color_white))
                        // .setLocation(new location[])//point in screen
                        .setLocationByAttachedView(holder.getView(R.id.tv_phone))
                        .setGravity(EasyDialog.GRAVITY_TOP)
                        .setAnimationTranslationShow(EasyDialog.DIRECTION_X, 1000, -600, 100, -50, 50, 0)
                        .setAnimationAlphaShow(1000, 0.3f, 1.0f)
                        .setAnimationTranslationDismiss(EasyDialog.DIRECTION_X, 500, -50, 800)
                        .setAnimationAlphaDismiss(500, 1.0f, 0.0f)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(true)
                        .setMarginLeftAndRight(50, 50)
                        .setOutsideColor(context.getResources().getColor(R.color.font_color_black_half))
                        .show();
                bt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });
            }
        });
        holder.getView(R.id.tv_water).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view1 =((Activity)context).getLayoutInflater().inflate(R.layout.test2, null);
                TextView bt2 = (TextView) view1.findViewById(R.id.tv_az);

                final EasyDialog dialog1 = new EasyDialog(context);
//                dialog1.setLayoutResourceId(R.layout.test1)//layout resource id
                dialog1.setLayout(view1)
                        .setBackgroundColor(context.getResources().getColor(R.color.font_color_white))
                        // .setLocation(new location[])//point in screen
                        .setLocationByAttachedView(holder.getView(R.id.tv_water))
                        .setGravity(EasyDialog.GRAVITY_TOP)
                        .setAnimationTranslationShow(EasyDialog.DIRECTION_X, 1000, -600, 100, -50, 50, 0)
                        .setAnimationAlphaShow(1000, 0.3f, 1.0f)
                        .setAnimationTranslationDismiss(EasyDialog.DIRECTION_X, 500, -50, 800)
                        .setAnimationAlphaDismiss(500, 1.0f, 0.0f)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(true)
                        .setMarginLeftAndRight(50, 50)
                        .setOutsideColor(context.getResources().getColor(R.color.font_color_black_half))
                        .show();
                bt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });
            }
        });
    }
}