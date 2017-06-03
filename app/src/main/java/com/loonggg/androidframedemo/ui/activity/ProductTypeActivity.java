package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.ProductTypeAdapter;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
/*
* 修云飞  申请团购中的产品类型
* */
public class ProductTypeActivity extends BasicTitleBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    @Bind(R.id.activity_productType_back)
    ImageView mBackImage;
    @Bind(R.id.activity_productType_sure)
    TextView mTypeSure;

    //点击是否显示类型
    @Bind(R.id.activity_productType_typeName)
    TextView mTypeName;

    @Bind(R.id.activity_productType_allButton)
    RadioButton mAllButton;
    @Bind(R.id.activity_productType_mainButton)
    RadioButton mMainButton;
    @Bind(R.id.activity_productType_partsButton)
    RadioButton mPartsButton;
    //需要显隐
    @Bind(R.id.activity_productType_radioGroup)
    RadioGroup mRadioGroup;

    @Bind(R.id.activity_productType_showList)
    ListView mShowList;

    //显示对应类型名的内容的数据源
    private List<String> mTypeData=new ArrayList<>();
    private ProductTypeAdapter mTypeAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_product_type;
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
        mTypeAdapter = new ProductTypeAdapter(this,mTypeData, R.layout.layout_product_type_list);
        mShowList.setAdapter(mTypeAdapter);
    }

    private void initData() {
        //获取数据的方法
        getTypeData(9);
    }

    //获取数据的方法
    public void getTypeData(int count){
        for (int i = 0; i < count; i++) {
            mTypeData.add("东华帝君"+i);

            mTypeAdapter.notifyDataSetChanged();
        }
    }

    private void setListener() {

        mBackImage.setOnClickListener(this);
        //点击选择不同的种类
        mTypeName.setOnClickListener(this);

        //显示全部
        mAllButton.setOnClickListener(this);
        //显示主机
        mMainButton.setOnClickListener(this);
        //显示配套件
        mPartsButton.setOnClickListener(this);

        mShowList.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返还按钮
            case R.id.activity_productType_back:
                finish();
                break;
            //点击选择不同的种类
            case R.id.activity_productType_typeName:
                if (mTypeName.isSelected()) {
                    mTypeName.setSelected(false);

                    mRadioGroup.setVisibility(View.GONE);
                }else {
                    mTypeName.setSelected(true);

                    mRadioGroup.setVisibility(View.VISIBLE);
                }
                break;

            //显示全部
            case R.id.activity_productType_allButton:
                mTypeData.clear();
                getTypeData(9);

                mTypeName.setText("全部");
                //隐藏选择项并改变图标
                mRadioGroup.setVisibility(View.GONE);
                mTypeName.setSelected(false);
                break;
            //显示主机
            case R.id.activity_productType_mainButton:
                mTypeData.clear();
                getTypeData(6);

                mTypeName.setText("主机");
                mRadioGroup.setVisibility(View.GONE);
                mTypeName.setSelected(false);
                break;
            //显示配套件
            case R.id.activity_productType_partsButton:
                mTypeData.clear();
                getTypeData(3);

                mTypeName.setText("配套机");
                mRadioGroup.setVisibility(View.GONE);
                mTypeName.setSelected(false);
                break;
        }
    }

    //列表Item的点击事件
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView typeName = (TextView) view.findViewById(R.id.layout_productType_typeName);
        if (typeName.isSelected()) {
            typeName.setSelected(false);
        }else {
            typeName.setSelected(true);
        }
    }
}
