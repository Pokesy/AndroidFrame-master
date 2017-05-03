package com.loonggg.androidframedemo;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;
import com.loonggg.androidframedemo.adapter.FragmentViewPagerAdapter;
import com.loonggg.androidframedemo.app.CustomApp;
import com.loonggg.androidframedemo.fragment.BrandFragment;
import com.loonggg.androidframedemo.fragment.MainFragment;
import com.loonggg.androidframedemo.fragment.ProfileFragment;
import com.loonggg.androidframedemo.injection.GlobalModule;
import com.loonggg.androidframedemo.net.rpc.UiRpcSubscriber;
import com.loonggg.androidframedemo.net.rpc.model.TestInfoModel;
import com.loonggg.androidframedemo.net.rpc.service.AppService;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.ui.serviceinjection.DaggerServiceComponent;
import com.loonggg.androidframedemo.ui.serviceinjection.ServiceModule;
import com.umeng.socialize.UMShareAPI;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class MainActivity extends BasicTitleBarActivity {
    @Inject
    AppService mInfo;
    //底部四个选项卡
    private TabLayout tabLayout;
    //Fragement切换ViewPager
    private ViewPager pager;
    //Fragement结合
    private List<Fragment> list;
    //ViewPager的适配器
    private FragmentPagerAdapter adapter;
    public static final int LOADING_DURATION = 2000;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        initService();
        //对应控件
        initViews();
        //添加四个Fragment
        initData();
    }

    /**
     * 该Activity全部控件
     */
    public void initViews() {
        tabLayout = (TabLayout) findViewById(R.id.tableLayout);
        pager = (ViewPager) findViewById(R.id.viewPager);
        StatusBarCompat.setStatusBarColor(this, R.color.color_bar1, false);
    }

    /**
     * viewPager初始化数据（共四个Fragment）
     * 开发时请在对应fragment里进行更改
     */
    private void initData() {


        list = new ArrayList<>();
        list.add(new MainFragment());//首页fragment
        list.add(new MainFragment());//周边fragment
        list.add(new BrandFragment());//品牌fragment
        list.add(new ProfileFragment());//我的fragment
        Log.e("zhd", "initData: " + "MyselfFragment");
//        Toast.makeText(MainActivity.this, "initData", Toast.LENGTH_SHORT).show();
        initAdapter();//定义适配器
        tabLayout.setupWithViewPager(pager);//tabLayout与viewPager联动
        initUpIcons();//向tabLayout添加自定义布局
    }

    /**
     * 定义适配器
     */
    public void initAdapter() {
        //实例化适配器
        adapter = new FragmentViewPagerAdapter(getSupportFragmentManager(), list);
        //填充适配器
        pager.setAdapter(adapter);

    }

    /**
     * 添加自定义布局
     */
    private void initUpIcons() {
        tabLayout.getTabAt(0).setCustomView(getTabView(0));
        tabLayout.getTabAt(1).setCustomView(getTabView(1));
        tabLayout.getTabAt(2).setCustomView(getTabView(2));
        tabLayout.getTabAt(3).setCustomView(getTabView(3));
    }

    /**
     * 自定义选项卡布局样式
     *
     * @param position
     * @return
     */
    private View getTabView(int position) {
        View img = getLayoutInflater().inflate(R.layout.layout_tablyout_item, null);
        ImageView imageView = (ImageView) img.findViewById(R.id.pic);
        TextView textView = (TextView) img.findViewById(R.id.text);
        String[] name = {"首页", "周边", "品牌", "我的"};
        int[] resId = {R.drawable.home_selector, R.drawable.near_selector, R.drawable.brand_selector, R.drawable.my_selector};
        imageView.setImageResource(resId[position]);
        textView.setText(name[position]);
        return img;
    }


    private void inject() {
        DaggerServiceComponent.builder()
                .globalModule(new GlobalModule((CustomApp) getApplication()))
                .serviceModule(new ServiceModule())
                .build()
                .inject(this);
    }

    private void initService() {

        manageRpcCall(mInfo.getTestInfo("444183889347c497b6505fcad0b29793", 1, 10, "json"), new UiRpcSubscriber<TestInfoModel>(this) {
            @Override
            protected void onSuccess(TestInfoModel testInfoModel) {
                showShortToast(testInfoModel.getList().get(0).getTitle());
            }

            @Override
            protected void onEnd() {

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

}
