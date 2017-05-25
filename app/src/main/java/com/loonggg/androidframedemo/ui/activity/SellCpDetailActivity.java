package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.view.MoreTextView;
import com.michael.easydialog.EasyDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Pokesy_dajiao on 2017/5/8.
 * 服务站详情
 */

public class SellCpDetailActivity extends BasicTitleBarActivity {

    @Bind(R.id.iv_today_news)
    ImageView ivTodayNews;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.short_text)
    MoreTextView shortText;
    @Bind(R.id.more)
    MoreTextView more;
    @Bind(R.id.ll_item)
    LinearLayout llItem;
    @Override
    public int getLayoutId() {
        return R.layout.activity_sell_cp_detail;
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
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = SellCpDetailActivity.this.getLayoutInflater().inflate(R.layout.test, null);
                Button bt = (Button) view.findViewById(R.id.imageview_delete);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                final EasyDialog dialog = new EasyDialog(SellCpDetailActivity.this);
//                        .setLayoutResourceId(R.layout.test)//layout resource id
                dialog.setLayout(view)
                        .setBackgroundColor(SellCpDetailActivity.this.getResources().getColor(R.color.background_color_black))
                        // .setLocation(new location[])//point in screen
                        .setLocationByAttachedView(more)
                        .setGravity(EasyDialog.GRAVITY_BOTTOM)
                        .setAnimationTranslationShow(EasyDialog.DIRECTION_X, 1000, -600, 100, -50, 50, 0)
                        .setAnimationAlphaShow(1000, 0.3f, 1.0f)
                        .setAnimationTranslationDismiss(EasyDialog.DIRECTION_X, 500, -50, 800)
                        .setAnimationAlphaDismiss(500, 1.0f, 0.0f)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(true)
                        .setOutsideColor(SellCpDetailActivity.this.getResources().getColor(R.color.font_color_black_half))
                        .show();
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });

    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {

    }
}
