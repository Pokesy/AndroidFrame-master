package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.view.MoreTextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Pokesy_dajiao on 2017/5/20.
 */

public class BrandQyjjActivity extends BasicTitleBarActivity {
    @Bind(R.id.more_text)
    MoreTextView moreText;
    @Bind(R.id.tab)
    LinearLayout tab;

    @Override
    public int getLayoutId() {
        return R.layout.brand_qyjj;
    }

    @Override
    public boolean initializeTitleBar() {
        setLeftTitleButton(R.mipmap.back, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setMiddleTitle("企业简介");
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        moreText.setText("我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介我是简介");
        moreText.refreshText();
    }
}
