package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
* 修云飞  支付完成界面
* */
public class PayOverActivity extends BasicTitleBarActivity implements View.OnClickListener {

    @Bind(R.id.activity_payOver_back)
    ImageView mBackImage;

    @Bind(R.id.activity_payOver_payPrice)
    TextView mPayPrice;

    @Bind(R.id.activity_payOver_lookOrder)
    TextView mLookOrder;
    @Bind(R.id.activity_payOver_shopHome)
    TextView mShopHome;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_over;
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
        //显示支付金额
//        mPayPrice.setText();
    }

    private void setView() {

    }

    private void initData() {

    }

    private void setListener() {
        mBackImage.setOnClickListener(this);

        mPayPrice.setOnClickListener(this);
        mShopHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回按钮的监听
            case R.id.activity_payOver_back:
                finish();
                break;

            //查看订单的监听
            case R.id.activity_payOver_lookOrder:
                break;
            //店铺首页的监听
            case R.id.activity_payOver_shopHome:
                break;
        }
    }
}
