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
 * 品牌  申请团购
 */

public class BrandSqtgActivity extends BasicTitleBarActivity {
    String[] name = {"艾迪精密", "贝力特", "顺天", "信人", "博运重工", "铭德", "世工", "佰泰", "百财", "铭润"};
    int[] img = {R.mipmap.ad, R.mipmap.blt, R.mipmap.st, R.mipmap.xr, R.mipmap.byzg, R.mipmap.md, R.mipmap.sg, R.mipmap.bt, R.mipmap.bc, R.mipmap.mr};


    @Override
    public int getLayoutId() {
        return R.layout.activity_brand_sqtg;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public boolean initializeTitleBar() {
        setLeftTitleButton(R.mipmap.back, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setMiddleTitle("申请团购");
        setTitleBarTextColor(R.color.color_xxl);
      return true;
    }

}
