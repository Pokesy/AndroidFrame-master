package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.ManagerAddressAdapter;
import com.loonggg.androidframedemo.model.ManagerAddressModel;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
/*
* 修云飞  管理地址页面
* */
public class ManagerAddressActivity extends BasicTitleBarActivity implements View.OnClickListener {

    //返回按钮
    @Bind(R.id.activity_managerAddress_back)
    ImageView mBackImage;

    //展现地址信息
    @Bind(R.id.activity_managerAddress_showList)
    ListView mShowList;

    //添加地址信息
    @Bind(R.id.activity_managerAddress_addAddress)
    LinearLayout mAddAddress;

    //地址信息的数据源
    private List<ManagerAddressModel> mAddressData=new ArrayList<>();
    private ManagerAddressAdapter mAddressAdapter;

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
        mAddressAdapter = new ManagerAddressAdapter(this,mAddressData, R.layout.layout_manager_address_item);
        mShowList.setAdapter(mAddressAdapter);
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            ManagerAddressModel addressModel = new ManagerAddressModel();
            addressModel.name="弗利沙-"+i;
            addressModel.phone="12345678"+i;
            addressModel.content="床前明月光，疑是地上霜，举头望明月，低头思故乡"+i;
            mAddressData.add(addressModel);
        }
        mAddressAdapter.notifyDataSetChanged();
    }

    private void setListener() {
        //页面顶部的返回按钮
        mBackImage.setOnClickListener(this);
        //添加地址
        mAddAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //页面顶部的返回按钮的监听
            case R.id.activity_managerAddress_back:
                finish();
                break;
            //跳转到添加地址页面
            case R.id.activity_managerAddress_addAddress:
                new MyUtils().JumpActivity(ManagerAddressActivity.this,AddAddressActivity.class);
                break;
        }
    }
}
