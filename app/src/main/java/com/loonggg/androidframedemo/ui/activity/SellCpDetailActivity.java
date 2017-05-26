package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.michael.easydialog.EasyDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Pokesy_dajiao on 2017/5/8.
 * 经销商产品详情
 */

public class SellCpDetailActivity extends BasicTitleBarActivity {


    @Bind(R.id.iv_today_news)
    ImageView ivTodayNews;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.gwc)
    ImageView gwc;
    @Bind(R.id.ll_item)
    LinearLayout llItem;
    @Bind(R.id.tv)
    TextView tv;
    @Bind(R.id.tv_gg)
    TextView tvGg;
    @Bind(R.id.cs)
    TextView cs;
    @Bind(R.id.tv0)
    TextView tv0;
    @Bind(R.id.q_title)
    TextView qTitle;
    @Bind(R.id.tv_num)
    TextView tvNum;
    @Bind(R.id.tv00)
    TextView tv00;
    @Bind(R.id.d_title)
    TextView dTitle;
    @Bind(R.id.iv_head)
    ImageView ivHead;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.ll_content)
    LinearLayout llContent;
    @Bind(R.id.tv_inter)
    TextView tvInter;
    @Bind(R.id.textView3)
    TextView textView3;
    @Bind(R.id.ll_buy)
    LinearLayout llBuy;

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

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = SellCpDetailActivity.this.getLayoutInflater().inflate(R.layout.test1, null);
                TextView bt = (TextView) view.findViewById(R.id.tv_delete);

                final EasyDialog dialog = new EasyDialog(SellCpDetailActivity.this);
//                        .setLayoutResourceId(R.layout.test)//layout resource id
                dialog.setLayout(view)
                        .setBackgroundColor(SellCpDetailActivity.this.getResources().getColor(R.color.font_color_white))
                        // .setLocation(new location[])//point in screen
                        .setLocationByAttachedView(tvGg)
                        .setGravity(EasyDialog.GRAVITY_BOTTOM)
                        .setAnimationTranslationShow(EasyDialog.DIRECTION_X, 1000, -600, 100, -50, 50, 0)
                        .setAnimationAlphaShow(1000, 0.3f, 1.0f)
                        .setAnimationTranslationDismiss(EasyDialog.DIRECTION_X, 500, -50, 800)
                        .setAnimationAlphaDismiss(500, 1.0f, 0.0f)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(true)
                        .setMarginLeftAndRight(50, 50)
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
