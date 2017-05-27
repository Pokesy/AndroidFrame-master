package com.loonggg.androidframedemo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.SelectAddressAdapter;
import com.loonggg.androidframedemo.model.SelectAddressModel;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
* 修云飞   购物流程中的---选择收货地址页面
* */
public class SelectAddressActivity extends BasicTitleBarActivity implements View.OnClickListener {

    //顶部的返回按钮
    @Bind(R.id.activity_selectAddress_back)
    ImageView mBackImage;

    //添加新地址
    @Bind(R.id.activity_selectAddress_addAddress)
    TextView mAddAddress;

    //显示所有添加的地址
    @Bind(R.id.activity_selectAddress_showList)
    ListView mShowList;

    //管理地址
    @Bind(R.id.activity_selectAddress_manageAddress)
    LinearLayout mManageAddress;

    //地址列表的数据源
    private List<SelectAddressModel> mAddressData=new ArrayList<>();
    private SelectAddressAdapter mAddressAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_select_address;
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
        mAddressAdapter = new SelectAddressAdapter(this,mAddressData, R.layout.layout_select_address_item);
        mShowList.setAdapter(mAddressAdapter);
    }

    private void initData() {
        for (int i = 0; i < 2; i++) {
            SelectAddressModel addressModel = new SelectAddressModel();
            if (i%2==0) {
                addressModel.type=0;
            }else {
                addressModel.type=1;
            }
            addressModel.content="今天我搬到了一个新的城市,这个城市中有好多的美女，不知能否认识几个"+i;
            addressModel.name="我哈哈"+i;
            addressModel.phone="123456"+i;

            mAddressData.add(addressModel);
        }
        mAddressAdapter.notifyDataSetChanged();
    }

    private void setListener() {
        //地址信息列表页的Item的监听
        mShowList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SelectAddressModel addressModel = mAddressData.get(position);
                //将选择的地址信息会传到提交订单页面
                Intent intent = new Intent(SelectAddressActivity.this,SubmitIndentActivity.class);
                intent.putExtra("address",addressModel);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });

        //添加新地址的监听
        mAddAddress.setOnClickListener(this);
        //返回按钮的监听
        mBackImage.setOnClickListener(this);
        //管理地址的监听
        mManageAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //添加信新地址的监听
            case R.id.activity_selectAddress_addAddress:
                new MyUtils().JumpActivity(SelectAddressActivity.this,AddAddressActivity.class);
                break;
            //退出页面
            case R.id.activity_selectAddress_back:
                finish();
                break;
            //跳转到管理地址的页面
            case R.id.activity_selectAddress_manageAddress:
                break;
        }
    }
}
