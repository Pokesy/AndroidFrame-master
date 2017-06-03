package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.utils.MyUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
* 修云飞   支付订单的页面
* */
public class PayOrderActivity extends BasicTitleBarActivity implements View.OnClickListener {

    @Bind(R.id.activity_payOrder_back)
    ImageView mBackImage;

    @Bind(R.id.activity_payOrder_showPrice)
    TextView mShowPrice;

    @Bind(R.id.activity_payOrder_weixin)
    TextView mWeixin;
    @Bind(R.id.activity_payOrder_zhifubao)
    TextView mZhifubao;
    @Bind(R.id.activity_payOrder_yinlian)
    TextView mYinlian;

    //判断是哪一种支付方式
    private int mIsPay=-1;
    private TextView mToPay;
    private String allPrice;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_order;
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
        //页面底部的去支付
        mToPay = ((TextView) findViewById(R.id.activity_payOrder_toPay));

        //获取要支付的金额
        allPrice = getIntent().getStringExtra("allPrice");
        //显示支付金额
        mShowPrice.setText(allPrice);
    }

    private void setView() {

    }

    private void initData() {

    }

    private void setListener() {
        mBackImage.setOnClickListener(this);

        mWeixin.setOnClickListener(this);
        mZhifubao.setOnClickListener(this);
        mYinlian.setOnClickListener(this);

        mToPay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回按钮
            case R.id.activity_payOrder_back:
                finish();
                break;
            //去支付
            case R.id.activity_payOrder_toPay:
                switch (mIsPay) {
                    case 0:
                        Toast.makeText(this, "微信", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(this, "支付宝", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(this, "银联", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(this, "未选择", Toast.LENGTH_SHORT).show();
                        break;
                }
                new MyUtils().JumpActivity(PayOrderActivity.this,PayOverActivity.class);
                break;
            //微信支付
            case R.id.activity_payOrder_weixin:
                if (mWeixin.isSelected()) {
                    mWeixin.setSelected(false);
                }else {
                    mWeixin.setSelected(true);
                    mZhifubao.setSelected(false);
                    mYinlian.setSelected(false);

                    mIsPay=0;
                }
                break;
            //支付宝支付
            case R.id.activity_payOrder_zhifubao:
                if (mZhifubao.isSelected()) {
                    mZhifubao.setSelected(false);
                }else {
                    mWeixin.setSelected(false);
                    mZhifubao.setSelected(true);
                    mYinlian.setSelected(false);

                    mIsPay=1;
                }
                break;
            //银联支付
            case R.id.activity_payOrder_yinlian:
                if (mYinlian.isSelected()) {
                    mYinlian.setSelected(false);
                }else {
                    mWeixin.setSelected(false);
                    mZhifubao.setSelected(false);
                    mYinlian.setSelected(true);

                    mIsPay=2;
                }
                break;
        }
    }
}
