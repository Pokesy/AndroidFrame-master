package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.jtech.listener.OnItemClickListener;
import com.jtech.listener.OnItemLongClickListener;
import com.jtech.listener.OnItemViewMoveListener;
import com.jtech.listener.OnItemViewSwipeListener;
import com.jtech.listener.OnLoadListener;
import com.jtech.view.JRecyclerView;
import com.jtech.view.RecyclerHolder;
import com.jtech.view.RefreshLayout;
import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.SgalAdapter;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Pokesy_dajiao on 2017/5/8.
 * 二手市场详列表
 */

public class BrandSgalActivity extends BasicTitleBarActivity implements OnItemClickListener, OnItemLongClickListener, RefreshLayout.OnRefreshListener, OnLoadListener, OnItemViewSwipeListener, OnItemViewMoveListener {
    String[] name = {"艾迪精密", "贝力特", "顺天", "信人", "博运重工", "铭德", "世工", "佰泰", "百财", "铭润"};
    int[] img = {R.mipmap.ad, R.mipmap.blt, R.mipmap.st, R.mipmap.xr, R.mipmap.byzg, R.mipmap.md, R.mipmap.sg, R.mipmap.bt, R.mipmap.bc, R.mipmap.mr};
    @Bind(R.id.jrecyclerview)
    JRecyclerView jrecyclerview;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
    SgalAdapter testAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_brand_sgal;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initData();
    }

    @Override
    public boolean initializeTitleBar() {
        setLeftTitleButton(R.mipmap.back, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setMiddleTitle("施工案例");
        setTitleBarTextColor(R.color.color_xxl);
        setRightImgButton(R.mipmap.fb, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
      return true;
    }

    private void initData() {

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add(i + "行");
        }
        //设置layoutmanager
        jrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        //设置适配器
        testAdapter = new SgalAdapter(this, list);
        jrecyclerview.setAdapter(testAdapter);
        //开启滑动到底部加载更多功能
        jrecyclerview.setLoadMore(true);
//        //开启滑动删除(默认状态，可以手动设置)
//        jRecyclerView.setSwipeFree(true, this);
//        //开启长点击拖动换位(默认状态，可以手动设置)
//        jRecyclerView.setMoveFree(true, this);
        //设置事件
        jrecyclerview.setOnLoadListener(this);
//        refreshlayout.setOnRefreshListener(this);
        jrecyclerview.setOnItemClickListener(this);
//        jRecyclerView.setOnItemLongClickListener(this);
        //主动发起下拉刷新
//        refreshlayout.startRefreshing();
        loadData(true);
    }

    /**
     * 模拟数据请求
     *
     * @param loadMore 是否为加载更多的标记
     */
    private void loadData(final boolean loadMore) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add(i + "");
        }
//        try {
////            Thread.sleep(1300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //设置数据
        testAdapter.setDatas(list, loadMore);
        //标记为请求完成
//        refreshlayout.refreshingComplete();
        jrecyclerview.setLoadCompleteState();
    }


    @Override
    public void onItemClick(RecyclerHolder recyclerHolder, View view, int i) {

    }

    @Override
    public boolean onItemLongClick(RecyclerHolder recyclerHolder, View view, int i) {
        return false;
    }

    @Override
    public boolean onItemViewMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder1) {
        return false;
    }

    @Override
    public void onItemViewSwipe(RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public void loadMore() {
        loadData(true);
    }

    @Override
    public void onRefresh() {
        loadData(true);
    }
}
