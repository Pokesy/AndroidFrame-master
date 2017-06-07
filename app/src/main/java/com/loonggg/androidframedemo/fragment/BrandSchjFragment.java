package com.loonggg.androidframedemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.MyViewPager;
import com.loonggg.androidframedemo.adapter.NearViewPagerAdapter;
import com.loonggg.androidframedemo.ui.activity.SearchLocationActivity;
import com.loonggg.androidframedemo.ui.activity.SecondHandActivity;
import com.loonggg.androidframedemo.ui.basic.BasicFragment;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.michael.easydialog.EasyDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by Pokesy_dajiao on 2017/4/20.
 * 品牌店详情    主打产品下的生产环境
 */

public class BrandSchjFragment extends BasicFragment {

    @Bind(R.id.fragment_schj_productShow)
    TextView mProductShow;
    @Bind(R.id.fragment_schj_processTechonlogy)
    TextView mProcessTechonlogy;

    @Bind(R.id.fragment_schj_content)
    TextView mContent;

    @Bind(R.id.fragment_schj_location)
    LinearLayout mLocation;
    @Bind(R.id.fragment_schj_weixin)
    LinearLayout mWeixin;
    @Bind(R.id.fragment_schj_phone)
    LinearLayout mPhone;

    private static final String TAG = "com.changeCity.name";
    public static final String pictureStringOne="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3182634025,3091085037&fm=23&gp=0.jpg";
    public static final String pictureStringTwo="http://img.tuku.com/upload/attach/2013/06/93447-32XzORx.jpg";

    private BGABanner mShowBinner;
    //轮播图的网址
    private List<String> mBinnerImage=new ArrayList<>();
    //轮播图标题
    private List<String> mBinnerTitle=new ArrayList<>();

    /**
     * 得到上下文
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schj, null);
        ButterKnife.bind(this, view);
        //对应控件
        initView(view);
        setView(pictureStringOne);
        initData();
        return view;
    }

    private void initData() {

    }

    private void setView(String string) {
        //轮播图的数据源
        mBinnerImage.clear();
        mBinnerTitle.clear();
        for (int i = 0; i < 5; i++) {
            mBinnerImage.add(string);
            mBinnerTitle.add("");
        }
        mShowBinner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                //显示图片
                new MyUtils().ShowPicture(getActivity(),model,itemView);
            }
        });
        mShowBinner.setData(mBinnerImage,mBinnerTitle);
    }

    /**
     * 对应控件
     *
     * @param view
     */
    public void initView(View view) {

        mShowBinner = ((BGABanner) view.findViewById(R.id.fragment_schj_showBinner));
        //展示企业内容
//        mContent.setText("");
        //默认选中设备展示
        mProductShow.setSelected(true);
        mProcessTechonlogy.setSelected(false);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.fragment_schj_productShow, R.id.fragment_schj_processTechonlogy, R.id.fragment_schj_location, R.id.fragment_schj_weixin, R.id.fragment_schj_phone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //设备展示
            case R.id.fragment_schj_productShow:

                mProcessTechonlogy.setSelected(false);
                mProductShow.setSelected(true);
                //轮播图展示
                setView(pictureStringOne);

                break;
            //加工工艺
            case R.id.fragment_schj_processTechonlogy:
                mProcessTechonlogy.setSelected(true);
                mProductShow.setSelected(false);
                //轮播图展示
                setView(pictureStringTwo);
                break;

            //查看位置
            case R.id.fragment_schj_location:
                startActivity(new Intent(getActivity(), SearchLocationActivity.class));
                break;
            //微信联系
            case R.id.fragment_schj_weixin:
                View view1 = getActivity().getLayoutInflater().inflate(R.layout.test, null);
                TextView bt = (TextView) view1.findViewById(R.id.tv_delete);
                TextView bt_copy = (TextView) view1.findViewById(R.id.tv_copy);

                final EasyDialog dialog = new EasyDialog(getActivity());
//                        .setLayoutResourceId(R.layout.test)//layout resource id
                dialog.setLayout(view1)
                        .setBackgroundColor(getActivity().getResources().getColor(R.color.font_color_white))
                        // .setLocation(new location[])//point in screen
                        .setLocationByAttachedView(mWeixin)
                        .setGravity(EasyDialog.GRAVITY_TOP)
                        .setAnimationTranslationShow(EasyDialog.DIRECTION_X, 1000, -600, 100, -50, 50, 0)
                        .setAnimationAlphaShow(1000, 0.3f, 1.0f)
                        .setAnimationTranslationDismiss(EasyDialog.DIRECTION_X, 500, -50, 800)
                        .setAnimationAlphaDismiss(500, 1.0f, 0.0f)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(true)
                        .setMarginLeftAndRight(50, 50)
                        .setOutsideColor(getActivity().getResources().getColor(R.color.font_color_black_half))
                        .show();
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                bt_copy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                break;
            //拨打电话
            case R.id.fragment_schj_phone:
                View view2 = getActivity().getLayoutInflater().inflate(R.layout.test1, null);
                TextView bt1 = (TextView) view2.findViewById(R.id.tv_delete);
                TextView bt_sure = (TextView) view2.findViewById(R.id.tv_sure);

                final EasyDialog dialog1 = new EasyDialog(getActivity());
//                        .setLayoutResourceId(R.layout.test)//layout resource id
                dialog1.setLayout(view2)
                        .setBackgroundColor(getActivity().getResources().getColor(R.color.font_color_white))
                        // .setLocation(new location[])//point in screen
                        .setLocationByAttachedView(mPhone)
                        .setGravity(EasyDialog.GRAVITY_TOP)
                        .setAnimationTranslationShow(EasyDialog.DIRECTION_X, 1000, -600, 100, -50, 50, 0)
                        .setAnimationAlphaShow(1000, 0.3f, 1.0f)
                        .setAnimationTranslationDismiss(EasyDialog.DIRECTION_X, 500, -50, 800)
                        .setAnimationAlphaDismiss(500, 1.0f, 0.0f)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(true)
                        .setMarginLeftAndRight(50, 50)
                        .setOutsideColor(getActivity().getResources().getColor(R.color.font_color_black_half))
                        .show();
                //取消
                bt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });
                //确定
                bt_sure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + 123456));
                        startActivity(intent);

                        dialog1.dismiss();
                    }
                });
                break;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
