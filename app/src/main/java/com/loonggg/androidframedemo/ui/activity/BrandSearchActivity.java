package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.BrandSearchGridAdapter;
import com.loonggg.androidframedemo.adapter.BrandSearchListAdapter;
import com.loonggg.androidframedemo.model.BrandSearchModel;
import com.loonggg.androidframedemo.net.constant.SendEditContentInterface;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.utils.DensityUtil;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.view.MyGridView;
import com.loonggg.androidframedemo.view.ScrollViewWithListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
* 修云飞   品牌的搜索页面
* */
public class BrandSearchActivity extends BasicTitleBarActivity implements View.OnClickListener {

    //顶部标题返回按钮，搜索的EditText
    @Bind(R.id.activity_brandSearch_backImage)
    ImageView mBackImage;
    @Bind(R.id.activity_brandSearch_editSearch)
    EditText mEditSearch;

    //切换改变列表显示的内容
    @Bind(R.id.activity_brandSearch_allButton)
    RadioButton mAllButton;
    @Bind(R.id.activity_brandSearch_productButton)
    RadioButton mProductButton;
    @Bind(R.id.activity_brandSearch_storeButton)
    RadioButton mStoreButton;

    //显示一共有多少条搜索结果
    @Bind(R.id.activity_brandSearch_countSearch)
    TextView mCountSearch;

    //展示与什么东西有关的产品--隐掉
    @Bind(R.id.activity_brandSearch_nameSearch_product)
    TextView mSearchProduct;
    //以GridView的形式展现产品的信息---隐掉
    @Bind(R.id.activity_brandSearch_gridSearch)
    MyGridView mGridSearch;
    //查看更多相关产品
    @Bind(R.id.activity_brandSearch_productMore_product)
    TextView mMoreProduct;

    //展示与什么东西有关的店铺
    @Bind(R.id.activity_brandSearch_nameSearch_store)
    TextView mSearchStore;
    //用于切换时，隐掉
    @Bind(R.id.activity_brandSearch_productLinear)
    LinearLayout mProductLinear;
    //以列表的形式展现店铺信息---隐掉
    @Bind(R.id.activity_brandSearch_listSearch)
    ScrollViewWithListView mListSearch;
    //产看更多相关店铺--隐掉
    @Bind(R.id.activity_brandSearch_productMore_store)
    TextView mMoreStore;

    //根据是否搜索显隐
    @Bind(R.id.activity_brandSearch_topLinear)
    LinearLayout mTopLinear;
    @Bind(R.id.activity_brandSearch_topScroll)
    ScrollView mTopScroll;

    //产品的数据源
    private List<BrandSearchModel> mGridData = new ArrayList<>();
    private BrandSearchGridAdapter mGridAdapter;

    //店铺的数据源
    private List<BrandSearchModel> mListData = new ArrayList<>();
    private BrandSearchListAdapter mListAdapter;
    private LinearLayout mRecommendLinear;

    @Override
    public int getLayoutId() {
        return R.layout.activity_brand_search;
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
        mRecommendLinear = ((LinearLayout) findViewById(R.id.activity_brandSearch_nameSearch_productLinear));

        mTopLinear.setVisibility(View.GONE);
        mTopScroll.setVisibility(View.GONE);

        mCountSearch.setText("共找到" + 666 + "条相关结果");
    }

    private void setView() {
        //产品列表与适配器绑定
        mGridSearch.setHorizontalSpacing(DensityUtil.dp2px(this,10));
        mGridSearch.setVerticalSpacing(DensityUtil.dp2px(this,10));
        mGridAdapter = new BrandSearchGridAdapter(this, mGridData, R.layout.layout_brand_search_grid);
        mGridSearch.setAdapter(mGridAdapter);

        //店铺列表与适配器绑定
        mListAdapter = new BrandSearchListAdapter(this, mListData, R.layout.layout_brand_search_list);
        mListSearch.setAdapter(mListAdapter);
    }

    private void initData() {
//        //产品列表的数据源
//        getGridData();
//
//        //店铺列表的数据源
//        getListData();
    }

    public void getGridData(int quantity) {
        //产品列表的数据源
        for (int i = 0; i < quantity; i++) {
            BrandSearchModel searchModel = new BrandSearchModel();
            searchModel.name = "赤脚大仙" + i;
            mGridData.add(searchModel);

            mGridAdapter.notifyDataSetChanged();
        }
    }

    //店铺列表的数据源
    private void getListData(int quantity) {
        for (int i = 0; i < quantity; i++) {
            BrandSearchModel searchModel = new BrandSearchModel();
            searchModel.name = "二郎显圣真君" + i;
            mListData.add(searchModel);

            mListAdapter.notifyDataSetChanged();
        }
    }


    private void setListener() {
        mBackImage.setOnClickListener(this);

        //对软键盘右下角按钮的监听
        new MyUtils().sendEditText(mEditSearch, new SendEditContentInterface() {
            @Override
            public void getEditContent(String content) {

                //产品列表的数据源
                mGridData.clear();
                getGridData(4);

                //店铺列表的数据源
                mListData.clear();
                getListData(3);

                mTopLinear.setVisibility(View.VISIBLE);
                mTopScroll.setVisibility(View.VISIBLE);
            }
        });

        //查看全部信息
        mAllButton.setOnClickListener(this);
        //查看产品信息
        mProductButton.setOnClickListener(this);
        //查看店铺信息
        mStoreButton.setOnClickListener(this);

        //查看更多产品
        mMoreProduct.setOnClickListener(this);
        //查看更多店铺
        mMoreStore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回按钮
            case R.id.activity_brandSearch_backImage:
                finish();
                break;

            //查看全部信息
            case R.id.activity_brandSearch_allButton:
                allState();
                mCountSearch.setText("共找到" + 666 + "条相关结果");

                //产品列表的数据源
                mGridData.clear();
                getGridData(4);

                //店铺列表的数据源
                mListData.clear();
                getListData(3);

                break;
            //查看产品信息
            case R.id.activity_brandSearch_productButton:
                productState();
                mCountSearch.setText("共找到" + 333 + "条相关结果");
                //产品列表的数据源
                mGridData.clear();
                getGridData(9);
                break;
            //查看店铺信息
            case R.id.activity_brandSearch_storeButton:
                storeState();
                mCountSearch.setText("共找到" + 111 + "条相关结果");
                //店铺列表的数据源
                mListData.clear();
                getListData(9);
                break;

            //产看更多产品
            case R.id.activity_brandSearch_productMore_product:
                productState();
                mCountSearch.setText("共找到" + 333 + "条相关结果");
                //产品列表的数据源
                mGridData.clear();
                getGridData(9);

                mProductButton.setChecked(true);
                break;
            //查看更多店铺
            case R.id.activity_brandSearch_productMore_store:
                storeState();
                mCountSearch.setText("共找到" + 111 + "条相关结果");
                //店铺列表的数据源
                mListData.clear();
                getListData(9);

                mStoreButton.setChecked(true);
                break;
        }
    }

    //查看全部时的显隐
    public void allState() {
        //展示与搜索有关的产品
        mRecommendLinear.setVisibility(View.VISIBLE);
        //展示产品的列表
        mGridSearch.setVisibility(View.VISIBLE);

        //更多产品，分割线，与店铺有关的产品
        mProductLinear.setVisibility(View.VISIBLE);

        mListSearch.setVisibility(View.VISIBLE);
        //显示更多店铺信息
        mMoreStore.setVisibility(View.VISIBLE);
    }

    //查看产品时的显隐
    public void productState() {
        //展示与搜索有关的产品
        mRecommendLinear.setVisibility(View.GONE);
        //展示产品的列表
        mGridSearch.setVisibility(View.VISIBLE);

        //更多产品，分割线，与店铺有关的产品
        mProductLinear.setVisibility(View.GONE);

        mListSearch.setVisibility(View.GONE);
        //显示更多店铺信息
        mMoreStore.setVisibility(View.GONE);
    }

    //查看店铺时的显隐
    public void storeState() {
        //展示与搜索有关的产品
        mRecommendLinear.setVisibility(View.GONE);
        //展示产品的列表
        mGridSearch.setVisibility(View.GONE);

        //更多产品，分割线，与店铺有关的产品
        mProductLinear.setVisibility(View.GONE);

        mListSearch.setVisibility(View.VISIBLE);
        //显示更多店铺信息
        mMoreStore.setVisibility(View.GONE);
    }
}
