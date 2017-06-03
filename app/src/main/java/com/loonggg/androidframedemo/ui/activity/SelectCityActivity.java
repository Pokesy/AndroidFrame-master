package com.loonggg.androidframedemo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.SelectAreaAdapter;
import com.loonggg.androidframedemo.model.SelectAreaModel;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
* 修云飞  选择地区中---选择城市的页面
* */
public class SelectCityActivity extends BasicTitleBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    @Bind(R.id.activity_selectCity_back)
    ImageView mBackImage;

    //展现城市信息的列表
    @Bind(R.id.activity_selectCity_province)
    ListView mCityList;

    public static final int REQUEST_COUNTRY=3;

    //城市信息的数据
    private List<SelectAreaModel> mCityData=new ArrayList<>();
    private SelectAreaAdapter mCityAdapter;
    private String provinceName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_select_city;
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
        provinceName = getIntent().getStringExtra("province_name");
    }

    private void setView() {
        mCityAdapter = new SelectAreaAdapter(SelectCityActivity.this,mCityData, R.layout.layout_select_area_item);
        mCityList.setAdapter(mCityAdapter);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            SelectAreaModel selectAreaModel = new SelectAreaModel();
            selectAreaModel.name="城市"+i;
            mCityData.add(selectAreaModel);
        }
        mCityAdapter.notifyDataSetChanged();
    }

    private void setListener() {
        mBackImage.setOnClickListener(this);

        mCityList.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回按钮
            case R.id.activity_selectCity_back:
                finish();
                break;
        }
    }

    //城市列表中Item的监听
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        SelectAreaModel areaModel = mCityData.get(position);

        Intent intent = new Intent(SelectCityActivity.this,SelectCountryActivity.class);
        intent.putExtra("city_name",areaModel.name);
        startActivityForResult(intent,REQUEST_COUNTRY);
    }

    //接受下一个界面返回的数据

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_COUNTRY==requestCode&&resultCode== Activity.RESULT_OK) {
            String country = data.getStringExtra("country");

            //将获取的数据返回给上一个界面
            Intent intent = new Intent();
            intent.putExtra("city",provinceName+"-"+country);//省-市-区
            setResult(Activity.RESULT_OK,intent);

            finish();
        }
    }
}
