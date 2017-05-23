package com.loonggg.androidframedemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.MyViewPager;
import com.loonggg.androidframedemo.adapter.NearViewPagerAdapter;
import com.loonggg.androidframedemo.ui.basic.BasicFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pokesy_dajiao on 2017/4/20.
 * 品牌店详情    主打产品下的生产环境
 */


public class BrandSchjFragment extends BasicFragment implements View.OnClickListener {
    //上下文
    private Context ctx;
    //顶部选项卡
    private TabLayout tab;
    //Fragment的ViewPager
    private MyViewPager pager;
    //纯文本，Fragment的适配器
    private NearViewPagerAdapter adapter;
    //Fragment的集合
    private List<Fragment> list;


    private TextView companyName;

    private static final String ACTION = "com.changeCity.name";

    /**
     * 得到上下文
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.ctx = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schj, null);
        //对应控件
        initView(view);
        //填充选项卡
        init();
        return view;
    }

    /**
     * 对应控件
     *
     * @param view
     */
    public void initView(View view) {
        tab = (TabLayout) view.findViewById(R.id.tabLayout);
        pager = (MyViewPager) view.findViewById(R.id.viewPager);
//        profile = (ImageView) view.findViewById(R.id.profile);



    }

    /**
     * 添加Fragment
     * 开发时请在对应Fragment内进行操作
     */
    public void init() {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
    }
}
