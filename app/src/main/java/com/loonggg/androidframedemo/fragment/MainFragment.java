package com.loonggg.androidframedemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.MyViewPager;
import com.loonggg.androidframedemo.adapter.ViewPagerAdapter;
import com.loonggg.androidframedemo.ui.activity.HomeSearchActivity;
import com.loonggg.androidframedemo.ui.activity.SubmitIndentActivity;
import com.loonggg.androidframedemo.ui.basic.BasicFragment;
import com.loonggg.androidframedemo.utils.MyUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Pokesy_dajiao on 2017/4/20.
 * 主界面
 */


public class MainFragment extends BasicFragment implements View.OnClickListener {
    @Bind(R.id.profile)
    ImageView profile;
    @Bind(R.id.message)
    TextView message;
    @Bind(R.id.locationMessage)
    EditText locationMessage;
    @Bind(R.id.top)
    RelativeLayout top;
    @Bind(R.id.tabLayout)
    TabLayout tab;
    @Bind(R.id.action)
    RelativeLayout action;
    @Bind(R.id.viewPager)
    MyViewPager pager;

    private ViewPagerAdapter adapter;
    //Fragment的集合
    private List<Fragment> list;

    private Context ctx;
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
        View view = inflater.inflate(R.layout.layout_main_fragment, null);
        ButterKnife.bind(this, view);
        //对应控件
        //填充选项卡
        init();
        setListener();

        return view;
    }

    private void setListener() {
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyUtils().JumpActivity(getActivity(), SubmitIndentActivity.class);
            }
        });
    }

    /**
     * 添加Fragment
     * 开发时请在对应Fragment内进行操作
     */
    public void init() {
        adapter = new ViewPagerAdapter(getChildFragmentManager(), getActivity());
        pager.setOffscreenPageLimit(Integer.MAX_VALUE);
        pager.setAdapter(adapter);
        tab.getTabAt(0).setIcon(R.drawable.tab_selector);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener
                (tab));
        tab.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener
                (pager));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.profile, R.id.message, R.id.locationMessage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.profile:

                break;
            case R.id.message:
                break;
            case R.id.locationMessage:
                startActivity(new Intent(getActivity(), HomeSearchActivity.class));
                break;
        }
    }
}
