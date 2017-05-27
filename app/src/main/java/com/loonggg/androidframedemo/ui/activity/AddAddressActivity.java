package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
* 修云飞  购物流程中---添加新地址的界面
* */
public class AddAddressActivity extends BasicTitleBarActivity implements View.OnClickListener {

    //顶部的返回，保存按钮
    @Bind(R.id.activity_addAddress_back)
    ImageView mBackImage;
    @Bind(R.id.activity_addAddress_save)
    TextView mAddressSave;

    //中间的地址信息
    @Bind(R.id.activity_addAddress_peopleName)
    EditText mPeopleName;
    @Bind(R.id.activity_addAddress_peoplePhone)
    EditText mPeoplePhone;
    @Bind(R.id.activity_addAddress_peopleAddress)//城市
    TextView mPeopleAddress;
    @Bind(R.id.activity_addAddress_detailAddress)
    EditText mDetailAddress;

    //设置是否为默认地址
    @Bind(R.id.activity_addAddress_setting)
    TextView mAddressSetting;
    private String mName;
    private String mPhone;
    private String detailAddress;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_address;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

        initView();
        setData();
        initData();
        setListener();
    }

    private void initView() {

    }

    private void setData() {
        mName = mPeopleName.getText().toString();
        mPhone = mPeoplePhone.getText().toString();
        detailAddress = mDetailAddress.getText().toString();
    }

    private void initData() {

    }

    private void setListener() {
        //返回按钮的监听事件
        mBackImage.setOnClickListener(this);
        //保存的监听事件
        mAddressSave.setOnClickListener(this);
        //设置是否为默认地址
        mAddressSetting.setOnClickListener(this);
        //选择位置的监听
        mPeopleAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //设置是否为默认地址
            case R.id.activity_addAddress_setting:
                if (mAddressSetting.isSelected()) {
                    mAddressSetting.setSelected(false);
                }else {
                    mAddressSetting.setSelected(true);
                }
                break;
            //设置保存
            case R.id.activity_addAddress_save:
                break;
            //设置返回
            case R.id.activity_addAddress_back:
                finish();
                break;
            //选择城市
            case R.id.activity_addAddress_peopleAddress:
                break;
        }
    }
}
