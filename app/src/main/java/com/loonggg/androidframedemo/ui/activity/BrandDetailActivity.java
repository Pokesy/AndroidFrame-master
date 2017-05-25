package com.loonggg.androidframedemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.MainProductsViewAdapter;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.view.ScrollGridView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Pokesy_dajiao on 2017/5/8.
 * 品牌店详情
 */

public class BrandDetailActivity extends BasicTitleBarActivity {
    String[] name = {"艾迪精密", "贝力特", "顺天", "信人", "博运重工", "铭德", "世工", "佰泰", "百财", "铭润"};
    int[] img = {R.mipmap.ad, R.mipmap.blt, R.mipmap.st, R.mipmap.xr, R.mipmap.byzg, R.mipmap.md, R.mipmap.sg, R.mipmap.bt, R.mipmap.bc, R.mipmap.mr};
    @Bind(R.id.iv_back)
    ImageView ivBack;
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
    @Bind(R.id.tv_more_tool)
    TextView tvMoreTool;
    @Bind(R.id.tv_second_hand)
    TextView tvSecondHand;
    @Bind(R.id.tv_market)
    TextView tvMarket;
    @Bind(R.id.tv_build)
    TextView tvBuild;
    @Bind(R.id.tv_mouth)
    TextView tvMouth;
    @Bind(R.id.main_radio)
    LinearLayout mainRadio;
    @Bind(R.id.tv_qyjj)
    TextView tvQyjj;
    @Bind(R.id.tv_qydt)
    TextView tvQydt;
    @Bind(R.id.tv_xswl)
    TextView tvXswl;
    @Bind(R.id.tv_sqtg)
    TextView tvSqtg;
    @Bind(R.id.tv_xdj)
    TextView tvXdj;
    @Bind(R.id.tv_more)
    TextView tvMore;
    @Bind(R.id.zhd)
    ScrollGridView zhd;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
    @Bind(R.id.tab)
    LinearLayout tab;


    @Override
    public int getLayoutId() {
        return R.layout.activity_brand_detail;
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
        zhd.setAdapter(new MainProductsViewAdapter(this, name, img));
    }

    @OnClick({R.id.iv_back, R.id.seatch, R.id.message, R.id.tv_more_tool, R.id.tv_second_hand, R.id.tv_market, R.id.tv_build, R.id.tv_mouth, R.id.tv_qyjj, R.id.tv_qydt, R.id.tv_xswl, R.id.tv_sqtg, R.id.tv_xdj, R.id.tv_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.seatch:
                break;
            case R.id.message:
                break;
            case R.id.tv_more_tool:
                startActivity(new Intent(this,BrandZdcpActivity.class));
                break;
            case R.id.tv_second_hand:
                startActivity(new Intent(this,BrandEsActivity.class));
                break;
            case R.id.tv_market:
                startActivity(new Intent(this,BrandEsActivity.class));
                break;
            case R.id.tv_build:
                startActivity(new Intent(this,BrandSgalActivity.class));
                break;
            case R.id.tv_mouth:
                startActivity(new Intent(this,BrandKbActivity.class));
                break;
            case R.id.tv_qyjj:
                startActivity(new Intent(this,BrandQyjjActivity.class));
                break;
            case R.id.tv_qydt:
                startActivity(new Intent(this,BrandEsActivity.class));
                break;
            case R.id.tv_xswl:
                startActivity(new Intent(this,BrandEsActivity.class));
                break;
            case R.id.tv_sqtg:
                startActivity(new Intent(this,BrandSqtgActivity.class));
                break;
            case R.id.tv_xdj:
                startActivity(new Intent(this,BrandXdjActivity.class));
                break;
            case R.id.tv_more:

                break;
        }
    }
}
