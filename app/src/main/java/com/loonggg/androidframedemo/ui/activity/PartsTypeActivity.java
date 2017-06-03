package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.PartsTypeGridAdapter;
import com.loonggg.androidframedemo.adapter.PartsTypeListAdapter;
import com.loonggg.androidframedemo.model.PartsTypeModel;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.utils.DensityUtil;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.view.TopTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
/*
* 修云飞  配套件分类界面
* */
public class PartsTypeActivity extends BasicTitleBarActivity implements AdapterView.OnItemClickListener {

    @Bind(R.id.activity_partsType_topTitle)
    TopTitleView mTopTitle;

    @Bind(R.id.activity_partsType_showList)
    ListView mShowList;

    @Bind(R.id.activity_partsType_showGrid)
    GridView mShowGrid;

    //配套件分类名称数据源
    private List<String> mListData=new ArrayList<>();
    private PartsTypeListAdapter mListAdapter;

    //配套件分类内容的数据源
    private List<PartsTypeModel> mGridData=new ArrayList<>();
    private PartsTypeGridAdapter mGridAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_parts_type;
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
        mTopTitle.setTopTitle("配套件分类");
        mTopTitle.setTopSetting(View.GONE);
    }

    private void setView() {
        //配套件分类名称
        mListAdapter = new PartsTypeListAdapter(this,mListData, R.layout.layout_parts_type_list_item);
        mShowList.setAdapter(mListAdapter);

        //配套件分类内容
        int space = DensityUtil.dp2px(this, 10);
        mShowGrid.setHorizontalSpacing(space);
        mShowGrid.setVerticalSpacing(space);
        mGridAdapter = new PartsTypeGridAdapter(this,mGridData, R.layout.layout_parts_type_grid_item);
        mShowGrid.setAdapter(mGridAdapter);
    }

    private void initData() {
        //配套件分类名称的数据源
        for (int i = 0; i < 7; i++) {
            mListData.add("配套件分类"+i);

            mListAdapter.notifyDataSetChanged();
        }

        //配套件分类内容的数据源
        setGridData(1);

    }

    public void setGridData(int position){
        //配套件分类内容的数据源
        for (int i = 0; i < position; i++) {
            PartsTypeModel typeModel = new PartsTypeModel();
            typeModel.name="配套件分类内容"+i;
            mGridData.add(typeModel);

            mGridAdapter.notifyDataSetChanged();
        }
    }

    private void setListener() {
        //返回键的监听
        mTopTitle.setLeftBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //通过配套件分类名称的适配器中的接口，得到外部的布局与下标---LstView
        mListAdapter.getLayoutInterface(new PartsTypeListAdapter.LayoutInterface() {
            @Override
            public void getLayoutAndIndex(int index, LinearLayout layout) {
                mListAdapter.setIsChecked(index);

                mGridData.clear();
                setGridData(index+1);
                mListAdapter.notifyDataSetChanged();
            }
        });

        //GridView的Item点击事件
        mShowGrid.setOnItemClickListener(this);
    }

    //GridView的Item点击事件
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        new MyUtils().JumpActivity(this,TypeDetailActivity.class);
    }
}
