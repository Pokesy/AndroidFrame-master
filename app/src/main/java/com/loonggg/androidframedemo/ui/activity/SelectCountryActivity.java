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

public class SelectCountryActivity extends BasicTitleBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    @Bind(R.id.activity_selectCountry_back)
    ImageView mBackImage;

    @Bind(R.id.activity_selectCountry_province)
    ListView mCountryList;

    private List<SelectAreaModel> mCountryData=new ArrayList<>();
    private SelectAreaAdapter mCountryAdapter;
    private String cityName;


    @Override
    public int getLayoutId() {
        return R.layout.activity_select_country;
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
        cityName = getIntent().getStringExtra("city_name");
    }

    private void setView() {
        mCountryAdapter = new SelectAreaAdapter(SelectCountryActivity.this,mCountryData, R.layout.layout_select_area_item);
        mCountryList.setAdapter(mCountryAdapter);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            SelectAreaModel selectAreaModel = new SelectAreaModel();
            selectAreaModel.name="区镇"+i;
            mCountryData.add(selectAreaModel);
        }
        mCountryAdapter.notifyDataSetChanged();
    }

    private void setListener() {
        mBackImage.setOnClickListener(this);

        mCountryList.setOnItemClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回按钮的监听
            case R.id.activity_selectCountry_back:
                finish();
                break;
        }
    }

    //区县的Item中的监听
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        SelectAreaModel areaModel = mCountryData.get(position);

        //将选择的区县数据返回
        Intent intent = new Intent();
        intent.putExtra("country",cityName+"-"+areaModel.name);//市-区
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}
