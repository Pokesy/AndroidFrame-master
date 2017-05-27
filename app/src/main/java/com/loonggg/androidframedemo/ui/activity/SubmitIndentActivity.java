package com.loonggg.androidframedemo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.SelectAddressModel;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
/*
* 修云飞   购物流程中的---提交订单页面
* */
public class SubmitIndentActivity extends BasicTitleBarActivity implements View.OnClickListener {

    //最顶部的返回图标
    @Bind(R.id.activity_submitIndent_back)
    ImageView mBackImage;

    //界面上部的收货人信息
    @Bind(R.id.activity_sunmitIndent_peopleName)
    TextView mPeopleName;
    @Bind(R.id.activity_sunmitIndent_peoplePhone)
    TextView mPeoplePhone;
    @Bind(R.id.activity_sunmitIndent_peopleAddress)
    TextView mPeopleAddress;

    //生产产品的公司名称
    @Bind(R.id.activity_sunmitIndent_companyName)
    TextView mCompanyName;

    //产品信息的介绍
    @Bind(R.id.activity_submitIndent_productImage)
    ImageView mProductImage;
    @Bind(R.id.activity_submitIndent_productName)
    TextView mProductName;
    @Bind(R.id.activity_submitIndent_productPrice)
    TextView mProductPrice;
    @Bind(R.id.activity_submitIndent_productCount)
    TextView mProductCount_One;

    //产品的其他信息
    @Bind(R.id.activity_submitIndent_textOne)
    TextView mProductStandard;
    @Bind(R.id.activity_submitIndent_textTwo)
    TextView mPtotuctCount_Two;
    @Bind(R.id.activity_submitIndent_textThree)
    TextView mPaymentStyle;
    @Bind(R.id.activity_submitIndent_editContent)
    EditText mEditContent;

    //界面底部的按钮
    @Bind(R.id.activity_submitIndent_allPrice)
    TextView mAllPrice;
    @Bind(R.id.activity_submitIndent_submitProduct)
    TextView mSubmitProduct;

    private TextView mHindAddress;
    //
    public static final int REQUEST_CODE=1;
    private LinearLayout mShowAddress;
    private LinearLayout mHindAddressLinear;

    @Override
    public int getLayoutId() {
        return R.layout.activity_submit_indent;
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
        //添加地址的外层布局
        mHindAddressLinear = ((LinearLayout) findViewById(R.id.activity_submitIndent_HintLinear));
        //添加地址的文本的实例化
        mHindAddress = ((TextView) findViewById(R.id.activity_submitIndent_addressHint));
        //显示地址信息的外层布局的实例化
        mShowAddress = ((LinearLayout) findViewById(R.id.activity_submitIndent_addressShow));
    }

    private void setView() {

    }

    private void initData() {

    }

    private void setListener() {
        //选择地址的监听
        mHindAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //添加地址的监听--跳转到选择地址页面
            case R.id.activity_submitIndent_addressHint:
                Intent intent = new Intent(SubmitIndentActivity.this,SelectAddressActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
                break;
        }
    }

    //获取选择地址返回的内容
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE&&resultCode== Activity.RESULT_OK) {
            //得到选择后的地址信息
            SelectAddressModel addressModel = (SelectAddressModel) data.getSerializableExtra("address");
            mHindAddressLinear.setVisibility(View.GONE);
            mShowAddress.setVisibility(View.VISIBLE);
            //添加地址的相关信息
            mPeopleName.setText("收货人："+addressModel.name);
            mPeoplePhone.setText(addressModel.phone);
            mPeopleAddress.setText("地址："+addressModel.content);
        }
    }
}
