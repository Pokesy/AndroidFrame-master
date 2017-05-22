package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.BrandZdcpPagerAdapter;
import com.loonggg.androidframedemo.adapter.MyViewPager;
import com.loonggg.androidframedemo.adapter.NearViewPagerAdapter;
import com.loonggg.androidframedemo.fragment.BrandSchjFragment;
import com.loonggg.androidframedemo.fragment.BrandZdcpFragment;
import com.loonggg.androidframedemo.fragment.NearSellFragment;
import com.loonggg.androidframedemo.fragment.NearWaterFragment;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Pokesy_dajiao on 2017/5/8.
 * 品牌店详情
 */

public class BrandZdcpActivity extends BasicTitleBarActivity {
    @Bind(R.id.ic_back)
    ImageView icBack;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.action)
    RelativeLayout action;
    @Bind(R.id.viewPager)
    MyViewPager viewPager;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    //纯文本，Fragment的适配器
    private BrandZdcpPagerAdapter adapter;
    //Fragment的集合
    private List<Fragment> list;
    @Override
    public int getLayoutId() {
        return R.layout.activity_brand_zdcp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        list = new ArrayList<>();
        list.add(new BrandZdcpFragment());//新闻Fragment
        list.add(new BrandSchjFragment());//新闻Fragment
        adapter = new BrandZdcpPagerAdapter(getSupportFragmentManager(),list, this);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener
                (tabLayout));
        tabLayout.setupWithViewPager(viewPager);
    }
    @OnClick(R.id.ic_back)
    public void onViewClicked() {
      finish();
    }
}
