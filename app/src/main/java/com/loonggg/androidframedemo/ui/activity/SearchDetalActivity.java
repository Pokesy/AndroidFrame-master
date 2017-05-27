package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.MyViewPager;
import com.loonggg.androidframedemo.adapter.ViewPagerAdapter;
import com.loonggg.androidframedemo.adapter.ViewSearchPagerAdapter;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Pokesy_dajiao on 2017/5/27.
 */

public class SearchDetalActivity extends BasicTitleBarActivity {
    @Bind(R.id.profile)
    ImageView profile;
    @Bind(R.id.locationMessage)
    EditText locationMessage;
    @Bind(R.id.top)
    RelativeLayout top;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.action)
    RelativeLayout action;
    @Bind(R.id.viewPager)
    MyViewPager viewPager;
    @Bind(R.id.iv_enter)
    ImageView ivEnter;
    @Bind(R.id.rl_tab)
    RelativeLayout rlTab;
    @Bind(R.id.rb_1)
    RadioButton rb1;
    @Bind(R.id.rb_2)
    RadioButton rb2;
    @Bind(R.id.rb_3)
    RadioButton rb3;
    @Bind(R.id.rb_4)
    RadioButton rb4;
    @Bind(R.id.rb_5)
    RadioButton rb5;
    @Bind(R.id.rb_enter)
    RadioButton rbEnter;
    @Bind(R.id.rb_6)
    RadioButton rb6;
    @Bind(R.id.rb_7)
    RadioButton rb7;
    @Bind(R.id.rb_8)
    RadioButton rb8;
    @Bind(R.id.rb_9)
    RadioButton rb9;
    @Bind(R.id.rb_10)
    RadioButton rb10;
    @Bind(R.id.ll_tab)
    LinearLayout llTab;
    private ViewSearchPagerAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.layout_search_detail_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        init();
    }

    /**
     * 添加Fragment
     * 开发时请在对应Fragment内进行操作
     */
    public void init() {
        adapter = new ViewSearchPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setOffscreenPageLimit(Integer.MAX_VALUE);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener
                (tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener
                (viewPager));
    }


    @OnClick({R.id.profile, R.id.iv_enter, R.id.rl_tab, R.id.rb_1, R.id.rb_2, R.id.rb_3, R.id.rb_4, R.id.rb_5, R.id.rb_enter, R.id.rb_6, R.id.rb_7, R.id.rb_8, R.id.rb_9, R.id.rb_10})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.profile:
                finish();
                break;
            case R.id.iv_enter:
                rlTab.setVisibility(View.GONE);
                llTab.setVisibility(View.VISIBLE);
                break;
            case R.id.rl_tab:

                break;
            case R.id.rb_1:
                tabLayout.getTabAt(3).select();
                rlTab.setVisibility(View.VISIBLE);
                llTab.setVisibility(View.GONE);
                break;
            case R.id.rb_2:
                tabLayout.getTabAt(2).select();
                rlTab.setVisibility(View.VISIBLE);
                llTab.setVisibility(View.GONE);
                break;
            case R.id.rb_3:
                tabLayout.getTabAt(4).select();
                rlTab.setVisibility(View.VISIBLE);
                llTab.setVisibility(View.GONE);
                break;
            case R.id.rb_4:
                tabLayout.getTabAt(5).select();
                rlTab.setVisibility(View.VISIBLE);
                llTab.setVisibility(View.GONE);
                break;
            case R.id.rb_5:
                break;
            case R.id.rb_enter:
                rlTab.setVisibility(View.VISIBLE);
                llTab.setVisibility(View.GONE);
                break;
            case R.id.rb_6:
                break;
            case R.id.rb_7:
                break;
            case R.id.rb_8:
                break;
            case R.id.rb_9:
                break;
            case R.id.rb_10:
                break;
        }
    }
}
