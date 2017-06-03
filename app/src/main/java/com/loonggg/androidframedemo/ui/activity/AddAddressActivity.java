package com.loonggg.androidframedemo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.ManagerAddressModel;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.utils.MyUtils;

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

    public static final int REQUEST_PROVINCE=1;
    private ManagerAddressModel managerModel;
    private int tag;

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
        //获取管理地址中的编辑按钮--传过来的Model类信息
        tag = getIntent().getIntExtra("tag",-1);
        if (tag==11) {
            managerModel = ((ManagerAddressModel) getIntent().getSerializableExtra("manager_model"));

            //显示传过来的信息
            mPeopleName.setText(managerModel.name);
            mPeoplePhone.setText(managerModel.phone);
            mDetailAddress.setText(managerModel.content);
        }
    }

    private void setData() {
        //获取收货人的名字
        mName = mPeopleName.getText().toString();
        //获取输入的电话号码
        mPhone = mPeoplePhone.getText().toString();
        //获取用户书写的详细地址
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
                //判断电话号码是否正确
                boolean phoneLegal = new MyUtils().isPhoneLegal(mPhone);
                if (phoneLegal) {
                    Toast.makeText(this, "电话号码不正确", Toast.LENGTH_SHORT).show();
                }
                break;
            //设置返回
            case R.id.activity_addAddress_back:
                finish();
                break;
            //选择城市
            case R.id.activity_addAddress_peopleAddress:
                Intent intent = new Intent(AddAddressActivity.this,SelectProvinceActivity.class);
                startActivityForResult(intent,REQUEST_PROVINCE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_PROVINCE==requestCode&&resultCode== Activity.RESULT_OK) {
            String province = data.getStringExtra("province");

            mPeopleAddress.setText(province);
        }
    }
}
