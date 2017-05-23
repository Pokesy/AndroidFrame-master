package com.loonggg.androidframedemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.CityAdapter;
import com.loonggg.androidframedemo.adapter.PtjAdapter;
import com.loonggg.androidframedemo.model.City;
import com.loonggg.androidframedemo.ui.basic.BasicFragment;
import com.loonggg.androidframedemo.view.LetterComparator;
import com.loonggg.androidframedemo.view.PinnedHeaderDecoration;
import com.loonggg.androidframedemo.view.WaveSideBarView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Pokesy_dajiao on 2017/4/20.
 * 配套件
 *
 */

public class PtjFragment extends BasicFragment {
    String[] name = {"首页", "周边", "品牌", "我的", "首页", "周边", "品牌", "我的", "品牌", "我的"};
    int[] img = {R.mipmap.ad, R.mipmap.ad, R.mipmap.ad, R.mipmap.ad, R.mipmap.ad, R.mipmap.ad, R.mipmap.ad, R.mipmap.ad, R.mipmap.ad, R.mipmap.ad};
    @Bind(R.id.rv_contacts)
    RecyclerView mRecyclerView;
    @Bind(R.id.side_bar)
    WaveSideBarView mSideBarView;
    @Bind(R.id.activity_car_model_lib)
    LinearLayout activityCarModelLib;
    private int scrollY = 0;
    private boolean isAddDecoration;
    //    @Bind(R.id.rm_listView)
//    RGridView rmListView;
    //    private List<CarModel.MasterlistBean.MastersBean> masters = new ArrayList<>();
//    private List<CarModel.HotlistBean> hotlist = new ArrayList<>();
    PtjAdapter adapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_host, null);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
//        adapter1=new GridViewAdapter(getActivity(),name,img);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        final PinnedHeaderDecoration decoration = new PinnedHeaderDecoration();
        decoration.registerTypePinnedHeader(1, new PinnedHeaderDecoration.PinnedHeaderCreator() {
            @Override
            public boolean create(RecyclerView parent, int adapterPosition) {
                return true;
            }
        });
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                scrollY = scrollY + dy;
                if (scrollY < 1050) {
                    if (isAddDecoration) {
                        isAddDecoration = false;
                        recyclerView.removeItemDecoration(decoration);
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    if (!isAddDecoration) {
                        isAddDecoration = true;
                        recyclerView.addItemDecoration(decoration);
                    }
                }
            }
        });
        mRecyclerView.addItemDecoration(decoration);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Type listType = new TypeToken<ArrayList<City>>() {
                }.getType();
                Gson gson = new Gson();
                final List<City> list = gson.fromJson(City.DATA, listType);
                Collections.sort(list, new LetterComparator());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new PtjAdapter(getActivity(), list);
                        mRecyclerView.setAdapter(adapter);
                        mSideBarView.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();
        mSideBarView.setOnTouchLetterChangeListener(new WaveSideBarView.OnTouchLetterChangeListener() {
            @Override
            public void onLetterChange(String letter) {
                int pos = adapter.getLetterPosition(letter);

                if (pos != -1) {
                    mRecyclerView.scrollToPosition(pos);
                    LinearLayoutManager mLayoutManager =
                            (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    mLayoutManager.scrollToPositionWithOffset(pos, 0);
                }
            }
        });
//        masters = GlobalValueManager.getInstance(this).getCarModelList();
//        hotlist = GlobalValueManager.getInstance(this).getCarHotModelList();
//        if (masters.size() > 0) {
//            adapter = new CarModelsAdapter(CarModelLibActivity.this, masters, hotlist, mInfo, flag);
//            recyclerView.setAdapter(adapter);
//            sideView.setVisibility(View.VISIBLE);
//        }
    }

    private void initData() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
