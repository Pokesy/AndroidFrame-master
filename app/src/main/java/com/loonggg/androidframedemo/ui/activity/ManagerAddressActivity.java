package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
/*
* 修云飞  管理地址页面
* */
public class ManagerAddressActivity extends BasicTitleBarActivity {

    //返回按钮
    @Bind(R.id.activity_managerAddress_back)
    ImageView mBackImage;

    //展现地址信息
    @Bind(R.id.activity_managerAddress_showList)
    ListView mShowList;

    //添加地址信息
    @Bind(R.id.activity_managerAddress_addAddress)
    LinearLayout mAddAddress;

    @Override
    public int getLayoutId() {
        return R.layout.activity_manager_address;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

        initView();
        setView();
        initData();
        setListener();
    }

    private void initView() {

    }

    private void setView() {

    }

    private void initData() {

    }

    private void setListener() {

    }
}
