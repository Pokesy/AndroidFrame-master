package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.HotBrandViewAdapter;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.view.MoreTextView;
import com.loonggg.androidframedemo.view.ScrollGridView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Pokesy_dajiao on 2017/5/8.
 * 服务站详情
 */

public class NewsDetailActivity extends BasicTitleBarActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        MoreTextView text1 = ((MoreTextView) findViewById(R.id.more));
        text1.setText(getResources().getString(R.string.test_custom_header_title));
        text1.refreshText();
        MoreTextView text2 = ((MoreTextView) findViewById(R.id.short_text));
        text2.setText(getResources().getString(R.string.test_custom_header_desc));
        text2.refreshText();
    }
}
