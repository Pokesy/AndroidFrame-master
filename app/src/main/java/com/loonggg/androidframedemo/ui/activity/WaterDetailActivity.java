package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.HotBrandViewAdapter;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.view.ScrollGridView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Pokesy_dajiao on 2017/5/8.
 * 服务站详情
 */

public class WaterDetailActivity extends BasicTitleBarActivity {
    String[] name = {"艾迪精密", "贝力特", "顺天", "信人", "博运重工", "铭德", "世工", "佰泰", "百财", "铭润"};
    int[] img = {R.mipmap.ad, R.mipmap.blt, R.mipmap.st, R.mipmap.xr, R.mipmap.byzg, R.mipmap.md, R.mipmap.sg, R.mipmap.bt, R.mipmap.bc, R.mipmap.mr};
    @Bind(R.id.seatch)
    ImageView seatch;
    @Bind(R.id.message)
    ImageView message;
    @Bind(R.id.top)
    RelativeLayout top;
    @Bind(R.id.iv_head)
    ImageView ivHead;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.tv_distance)
    ImageView tvDistance;
    @Bind(R.id.ll_content)
    LinearLayout llContent;
    @Bind(R.id.ll_tv)
    LinearLayout llTv;
    @Bind(R.id.main_radio)
    LinearLayout mainRadio;
    @Bind(R.id.head1)
    ImageView head1;
    @Bind(R.id.title1)
    TextView title1;
    @Bind(R.id.content11)
    TextView content11;
    @Bind(R.id.content2)
    LinearLayout content2;
    @Bind(R.id.head)
    ImageView head;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.content1)
    TextView content1;
    @Bind(R.id.content)
    LinearLayout content;
    @Bind(R.id.zhd)
    ScrollGridView zhd;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;


    @Override
    public int getLayoutId() {
        return R.layout.activity_water_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        tvTitle.setFocusableInTouchMode(true);
        tvTitle.requestFocus();
        zhd.setAdapter(new HotBrandViewAdapter(this, name, img));
    }
}
