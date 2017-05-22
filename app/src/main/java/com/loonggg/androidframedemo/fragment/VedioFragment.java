package com.loonggg.androidframedemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jtech.listener.OnItemClickListener;
import com.jtech.listener.OnItemLongClickListener;
import com.jtech.listener.OnItemViewMoveListener;
import com.jtech.listener.OnItemViewSwipeListener;
import com.jtech.listener.OnLoadListener;
import com.jtech.view.JRecyclerView;
import com.jtech.view.RecyclerHolder;
import com.jtech.view.RefreshLayout;
import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.VideoAdapter;
import com.loonggg.androidframedemo.ui.basic.BasicFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Pokesy_dajiao on 2017/4/20.
 */

public class VedioFragment extends BasicFragment implements OnItemClickListener, OnItemLongClickListener, RefreshLayout.OnRefreshListener, OnLoadListener, OnItemViewSwipeListener, OnItemViewMoveListener {
    @Bind(R.id.jrecyclerview)
    JRecyclerView jRecyclerView;
//    @Bind(R.id.refreshlayout)
//    RefreshLayout refreshlayout;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    private VideoAdapter testAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news, null);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add(i + "行");
        }
        //设置layoutmanager
        jRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //设置适配器
        testAdapter = new VideoAdapter(getActivity(),list);
        jRecyclerView.setAdapter(testAdapter);
        //开启滑动到底部加载更多功能
        jRecyclerView.setLoadMore(true);
//        //开启滑动删除(默认状态，可以手动设置)
//        jRecyclerView.setSwipeFree(true, this);
//        //开启长点击拖动换位(默认状态，可以手动设置)
//        jRecyclerView.setMoveFree(true, this);
        //设置事件
        jRecyclerView.setOnLoadListener(this);
//        refreshlayout.setOnRefreshListener(this);
        jRecyclerView.setOnItemClickListener(this);
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
        jRecyclerView.setLoadCompleteState();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * item点击事件
     *
     * @param holder
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(RecyclerHolder holder, View view, int position) {
        Toast.makeText(getActivity(), "第" + position + "行点击事件", Toast.LENGTH_SHORT).show();
    }

    /**
     * item长点击事件
     *
     * @param holder
     * @param view
     * @param position
     * @return
     */
    @Override
    public boolean onItemLongClick(RecyclerHolder holder, View view, int position) {
        Toast.makeText(getActivity(), "第" + position + "行长点击事件", Toast.LENGTH_SHORT).show();
        return false;//因为这里return false 所以长点击拖动才有效，演示功能用，所以会触发两次震动
    }

    /**
     * item长点击拖动换位事件
     *
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onItemViewMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        testAdapter.moveData(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return false;
    }

    /**
     * item滑动删除事件
     *
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onItemViewSwipe(RecyclerView.ViewHolder viewHolder, int direction) {
        testAdapter.removeData(viewHolder.getAdapterPosition());
        if (direction == ItemTouchHelper.START) {
            Toast.makeText(getActivity(), "Delete!", Toast.LENGTH_SHORT).show();
        } else if (direction == ItemTouchHelper.END) {
            Toast.makeText(getActivity(), "Android!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 加载更多的回调
     */
    @Override
    public void loadMore() {
        loadData(true);
    }

    /**
     * 下拉刷新的回调
     */
    @Override
    public void onRefresh() {
        loadData(false);
    }
}
