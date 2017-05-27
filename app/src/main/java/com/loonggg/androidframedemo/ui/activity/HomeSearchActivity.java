package com.loonggg.androidframedemo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.HomeSearchAdapter;
import com.loonggg.androidframedemo.view.ScrollViewWithListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
* 修云飞   首页的搜索页面
* */
public class HomeSearchActivity extends AppCompatActivity {

    @Bind(R.id.activity_homeSearch_topBack)
    ImageView mBackImage;//返回按钮
    @Bind(R.id.activity_homeSearch_search)
    EditText mSearchEdit;//搜索EditText
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    @Bind(R.id.activity_homeSearch_hot)
    TextView activityHomeSearchHot;

    @Bind(R.id.activity_homeSearch_history)
    TextView activityHomeSearchHistory;
    @Bind(R.id.activity_homeSearch_searchList)
    ScrollViewWithListView mSearchList;
    @Bind(R.id.activity_homeSearch_scroll)
    ScrollView activityHomeSearchScroll;
    private ScrollView mScroll;//显示搜索内容前的最外层布局
    //四个热门搜索
    @Bind(R.id.activity_homeSearch_searchOne)
    TextView mSearchOne;
    @Bind(R.id.activity_homeSearch_searchTwo)
    TextView mSearchTwo;
    @Bind(R.id.activity_homeSearch_searchThree)
    TextView mSearchThree;
    @Bind(R.id.activity_homeSearch_searchFour)
    TextView mSearchFour;


    private List<String> mHistoryData = new ArrayList<>();
    private HomeSearchAdapter mHistoryAdapter;

    private String searchName = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_search);
        ButterKnife.bind(this);

        initView();//初始化
        setView();//
        initData();//网络请求
        setListener();//监听方法
    }

    private void initView() {
        mScroll = ((ScrollView) findViewById(R.id.activity_homeSearch_scroll));
        mScroll.setVisibility(View.VISIBLE);
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeSearchActivity.this, SearchDetalActivity.class));
            }
        });
    }

    private void setView() {

        mHistoryAdapter = new HomeSearchAdapter(this, mHistoryData, R.layout.layout_home_search_item);
        mSearchList.setAdapter(mHistoryAdapter);
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            mHistoryData.add("第" + i + "条搜索历史");
            mHistoryAdapter.notifyDataSetChanged();
        }
    }

    private void setListener() {

        //对EditText的软键盘右下角的按钮的监听
        mSearchEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //判断是否是“SEARCH”键
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //隐藏软键盘
                    InputMethodManager imm = (InputMethodManager) v
                            .getContext().getSystemService(
                                    Context.INPUT_METHOD_SERVICE);
                    if (imm.isActive()) {
                        imm.hideSoftInputFromWindow(
                                v.getApplicationWindowToken(), 0);
                    }
                    searchName = mSearchEdit.getText().toString();
                    Log.e("TAG", "onEditorAction搜索内容: " + searchName);
                    if (searchName.equals("")) {
                        mScroll.setVisibility(View.VISIBLE);
                        Toast.makeText(HomeSearchActivity.this, "搜索内容不能为空！", Toast.LENGTH_SHORT).show();
                    } else {
                        mScroll.setVisibility(View.GONE);
                    }
                    //隐藏原布局，清空数据，根据搜索的内容进行网络请求


                    return true;
                }
                return false;
            }
        });

        //对搜索历史的内容进行搜索
        mSearchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                searchName = mHistoryData.get(position);
                //获取历史搜索记录，显示在EditText中，同时显示搜索内容
                mSearchEdit.setText(searchName);
                //隐藏原布局，清空元数据，网络请求
                mScroll.setVisibility(View.GONE);
            }
        });
    }

    @OnClick(R.id.iv_search)
    public void onViewClicked() {
    }
}
