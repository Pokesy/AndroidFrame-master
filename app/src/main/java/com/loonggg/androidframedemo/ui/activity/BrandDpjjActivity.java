package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;

import butterknife.ButterKnife;

/**
 * Created by Pokesy_dajiao on 2017/5/8.
 * 品牌  店铺简介
 */

public class BrandDpjjActivity extends BasicTitleBarActivity {
    String[] name = {"艾迪精密", "贝力特", "顺天", "信人", "博运重工", "铭德", "世工", "佰泰", "百财", "铭润"};
    int[] img = {R.mipmap.ad, R.mipmap.blt, R.mipmap.st, R.mipmap.xr, R.mipmap.byzg, R.mipmap.md, R.mipmap.sg, R.mipmap.bt, R.mipmap.bc, R.mipmap.mr};


    @Override
    public int getLayoutId() {
        return R.layout.activity_brand_jj;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public boolean initializeTitleBar() {
        setLeftTitleButton(R.mipmap.back, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setMiddleTitle("店铺简介");
        setTitleBarTextColor(R.color.color_xxl);
      return true;
    }

}
