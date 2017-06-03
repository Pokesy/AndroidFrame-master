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
* 修云飞  选择地区中的--选择省份的页面
* */
public class SelectProvinceActivity extends BasicTitleBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    @Bind(R.id.activity_selectProvince_back)
    ImageView mBackImage;

    @Bind(R.id.activity_selectProvince_province)
    ListView mProvinceList;

    public static final int REQUEST_CITY=2;

    private List<SelectAreaModel> mAreaData=new ArrayList<>();
    private SelectAreaAdapter mAreaAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_select_province;
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
        mAreaAdapter = new SelectAreaAdapter(SelectProvinceActivity.this,mAreaData, R.layout.layout_select_area_item);
        mProvinceList.setAdapter(mAreaAdapter);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            SelectAreaModel selectAreaModel = new SelectAreaModel();
            selectAreaModel.name="省份"+i;
            mAreaData.add(selectAreaModel);
        }
        mAreaAdapter.notifyDataSetChanged();
    }

    private void setListener() {
        //返回按钮
        mBackImage.setOnClickListener(this);

        //列表中Item的监听
        mProvinceList.setOnItemClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回按钮的监听
            case R.id.activity_selectProvince_back:
                finish();
                break;
        }
    }

    //ListView列表中Item的监听
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        SelectAreaModel areaModel = mAreaData.get(position);

        Intent intent = new Intent(SelectProvinceActivity.this,SelectCityActivity.class);
        intent.putExtra("province_name",areaModel.name);
        startActivityForResult(intent,REQUEST_CITY);
    }

    //接收下一个界面传回的信息

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CITY==requestCode&&resultCode== Activity.RESULT_OK) {
            String city = data.getStringExtra("city");

            //将获取的数据返回给上一个界面
            Intent intent = new Intent();
            intent.putExtra("province",city);//省-市-区
            setResult(Activity.RESULT_OK,intent);

            finish();
        }
    }
}
