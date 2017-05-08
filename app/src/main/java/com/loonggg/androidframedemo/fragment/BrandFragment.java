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
import com.loonggg.androidframedemo.adapter.BrandViewPagerAdapter;
import com.loonggg.androidframedemo.adapter.MyViewPager;
import com.loonggg.androidframedemo.adapter.ViewPagerAdapter;
import com.loonggg.androidframedemo.ui.basic.BasicFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pokesy_dajiao on 2017/4/20.
 */


public class BrandFragment extends BasicFragment implements View.OnClickListener {
    //上下文
    private Context ctx;
    //顶部选项卡
    private TabLayout tab;
    //Fragment的ViewPager
    private MyViewPager pager;
    //纯文本，Fragment的适配器
    private BrandViewPagerAdapter adapter;
    //Fragment的集合
    private List<Fragment> list;
    //个人，更多按钮
    private ImageView message, profile;

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
        View view = inflater.inflate(R.layout.fragment_brand, null);
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
        message = (ImageView) view.findViewById(R.id.message);
        companyName = (TextView) view.findViewById(R.id.locationMessage);
        profile = (ImageView) view.findViewById(R.id.profile);

        message.setOnClickListener(this);
        profile.setOnClickListener(this);


    }

    /**
     * 添加Fragment
     * 开发时请在对应Fragment内进行操作
     */
    public void init() {
        list = new ArrayList<>();
        list.add(new HostFragment());//新闻Fragment
        list.add(new PtjFragment());//新闻Fragment
        adapter = new BrandViewPagerAdapter(getChildFragmentManager(),list, getActivity());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener
                (tab));

        tab.setupWithViewPager(pager);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {

    }
}
