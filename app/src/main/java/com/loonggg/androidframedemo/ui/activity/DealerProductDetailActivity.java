package com.loonggg.androidframedemo.ui.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.AnswerAdapter;
import com.loonggg.androidframedemo.adapter.DealerDetailPictureAdapter;
import com.loonggg.androidframedemo.adapter.DealerProCommentAdapter;
import com.loonggg.androidframedemo.adapter.DealerProPraiseAdapter;
import com.loonggg.androidframedemo.adapter.DealerProRecommendAdapter;
import com.loonggg.androidframedemo.adapter.ProductParamsAdapter;
import com.loonggg.androidframedemo.model.DealerProDetailModel;
import com.loonggg.androidframedemo.model.ProductParamsModel;
import com.loonggg.androidframedemo.net.constant.BottomDialogInterface;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.utils.DensityUtil;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.view.BottomScrollView;
import com.loonggg.androidframedemo.view.FNRadioGroup;
import com.loonggg.androidframedemo.view.MyGridView;
import com.loonggg.androidframedemo.view.ScrollViewWithListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
* 修云飞  经销商产品详情页
* */
public class DealerProductDetailActivity extends BasicTitleBarActivity implements View.OnClickListener, BottomScrollView.OnScrollToBottomListener {

    //界面顶部的图片
    @Bind(R.id.activity_dealerProduct_topPrice)
    ImageView mTopPrice;

    //界面的重写的ScrollView
    @Bind(R.id.activity_dealerProduct_scrollView)
    BottomScrollView mScrollView;

    //产品的名字，价格，分享
    @Bind(R.id.activity_dealerProduct_productName)
    TextView mProductName;
    @Bind(R.id.activity_dealerProduct_productShare)
    LinearLayout mProductShare;
    @Bind(R.id.activity_dealerProduct_productPrice)
    TextView mProductPrice;

    //产品的出售数量，收藏数，地区
    @Bind(R.id.activity_dealerProduct_productSell)
    TextView mProductSell;
    @Bind(R.id.activity_dealerProduct_productCollect)
    TextView mProductCollect;
    @Bind(R.id.activity_dealerProduct_productArea)
    TextView mProductArea;

    //产品的规格
    @Bind(R.id.activity_dealerProduct_productStandard)
    TextView mProductStandard;

    //产品的参数
    @Bind(R.id.activity_dealerProduct_productParams)
    TextView mProductParams;

    //问答中的问的内容，回答的数量，回答的内容，回答的总数量
    @Bind(R.id.activity_questionAndAnswer_quwstionContent)
    TextView mQuestionContent;
    @Bind(R.id.activity_dealerProduct_answerCount)
    TextView mAnswerCount;
    @Bind(R.id.activity_dealerProduct_answerContent)
    TextView mAnswerContent;
    @Bind(R.id.activity_dealerProduct_allAnswer)
    TextView mAllAnswer;

    //介绍公司的图片，名字，主营，进店
    @Bind(R.id.activity_dealerProduct_companyImage)
    ImageView mCompanyImage;
    @Bind(R.id.activity_dealerProduct_companyName)
    TextView mCompanyName;
    @Bind(R.id.activity_dealerProduct_companyBusiness)
    TextView mCompanyBusiness;
    @Bind(R.id.activity_dealerProduct_companyGo)
    TextView mCompanyGo;

    //全部产品与收藏人数
    @Bind(R.id.activity_dealerProduct_allProduct)
    TextView mAllProduct;
    @Bind(R.id.activity_dealerProduct_collectCount)
    TextView mCollectCount;

    //产品详情---展示图片
    @Bind(R.id.activity_dealerProduct_PictureList)
    ScrollViewWithListView mPictureList;

    //产品口碑---更多，展现口碑
    @Bind(R.id.activity_dealerProduct_moreGo)
    TextView mMoreGo;
    @Bind(R.id.activity_sealerProduct_praiseList)
    ScrollViewWithListView mPraiseList;

    //相关推荐---展现推荐的产品
    @Bind(R.id.activity_sealerProduct_recommendGrid)
    MyGridView mRecommendGrid;

    //精彩评论---展现用户的评论
    @Bind(R.id.activity_sealerProduct_commentList)
    ScrollViewWithListView mCommentList;

    //页面顶部的图标的实例化
    @Bind(R.id.activity_dealerProduct_backTop)
    ImageView mBackTop;
    @Bind(R.id.activity_dealerProduct_shopTop)
    ImageView mShopTop;
    @Bind(R.id.activity_dealerProduct_settingTop)
    ImageView mSettingTop;
    @Bind(R.id.activity_dealerProduct_relativeTop)
    RelativeLayout mRelativeTop;

    //页面底部的三个ImageView图标与两个TextView的按钮
    @Bind(R.id.activity_dealerProduct_talkBottom)
    ImageView mTalkBottom;
    @Bind(R.id.activity_dealerProduct_collectBottom)
    ImageView mCollectBottom;
    @Bind(R.id.activity_dealerProduct_likeBottom)
    ImageView mLikeBottom;
    @Bind(R.id.activity_dealerProduct_joinCar)
    TextView mJoinCar;
    @Bind(R.id.activity_dealerProduct_buyNow)
    TextView mBuyNow;

    //产品详情--图片的数据源，适配器
    private List<String> mPictureData=new ArrayList<>();
    private DealerDetailPictureAdapter mPictureAdapter;

    //产品口碑--的数据源，适配器
    private List<DealerProDetailModel> mPraiseData=new ArrayList<>();
    private DealerProPraiseAdapter mPraiseAdapter;
    //GridView显示图片的适配器
    private List<String> mGridData=new ArrayList<>();

    //相关推荐--的数据源，适配器
    private List<DealerProDetailModel> mRecommendData=new ArrayList<>();
    private DealerProRecommendAdapter mRecommendAdapter;

    //最新评论--得数据源，适配器
    private List<DealerProDetailModel> mCommentData=new ArrayList<>();
    private DealerProCommentAdapter mCommentAdapter;

    //参数的Dialog中的参数数据源
    private List<ProductParamsModel> mParamsData=new ArrayList<>();

    //定义规格数量的数组
    private RadioButton[] radioButtons;
    //选中规格的名字
    private String mStandardName="";
    //获取选择的产品数量
    private int mProductCount;
    
    @Override
    public int getLayoutId() {
        return R.layout.activity_dealer_product_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        initView();
        setView();
        initData();
        setListener();
    }

    private void initView() {

    }

    private void setView() {
        //产品详情--展示图片
        mPictureAdapter = new DealerDetailPictureAdapter(this,mPictureData, R.layout.layout_dealer_detail_picture_item);
        mPictureList.setAdapter(mPictureAdapter);

        //产品口碑
        for (int i = 0; i < 4; i++) {
            mGridData.add("");
        }
        mPraiseAdapter = new DealerProPraiseAdapter(this,mPraiseData,mGridData, R.layout.layout_dealer_praise_item);
        mPraiseList.setAdapter(mPraiseAdapter);

        //相关推荐
        mRecommendGrid.setHorizontalSpacing(10);
        mRecommendGrid.setVerticalSpacing(10);
        mRecommendAdapter = new DealerProRecommendAdapter(this,mRecommendData, R.layout.layout_dealer_recommend_item);
        mRecommendGrid.setAdapter(mRecommendAdapter);

        //最新评论
        mCommentAdapter = new DealerProCommentAdapter(this,mCommentData, R.layout.layout_comment_item);
        mCommentList.setAdapter(mCommentAdapter);
    }

    private void initData() {
        //产品详情
        for (int i = 0; i < 4; i++) {
            mPictureData.add("");

            mPictureAdapter.notifyDataSetChanged();
        }

        //产品口碑
        for (int i = 0; i < 4; i++) {
            DealerProDetailModel detailModel = new DealerProDetailModel();
            detailModel.name="玉皇大帝"+i;
            mPraiseData.add(detailModel);

            mPraiseAdapter.notifyDataSetChanged();
        }

        //相关推荐
        for (int i = 0; i < 4; i++) {
            DealerProDetailModel detailModel = new DealerProDetailModel();
            detailModel.name="西王母"+i;
            mRecommendData.add(detailModel);

            mRecommendAdapter.notifyDataSetChanged();
        }

        //最新评论
        for (int i = 0; i < 4; i++) {
            DealerProDetailModel detailModel = new DealerProDetailModel();
            detailModel.name="二郎神"+i;
            mCommentData.add(detailModel);

            mCommentAdapter.notifyDataSetChanged();
        }

        //参数Dialog
        for (int i = 0; i < 9; i++) {
            ProductParamsModel productParamsModel = new ProductParamsModel();
            productParamsModel.name="产品参数"+i;
            productParamsModel.value="参数的值"+i;
            mParamsData.add(productParamsModel);
        }
    }

    private void setListener() {
        mBackTop.setOnClickListener(this);
        mSettingTop.setOnClickListener(this);

        //产品的参数
        mProductParams.setOnClickListener(this);
        //产品规格
        mProductStandard.setOnClickListener(this);

        //对重写的ScrollView进行监听
        mScrollView.setOnScrollToBottomLintener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回按钮
            case R.id.activity_dealerProduct_backTop:
                finish();
                break;
            //界面顶部的设置按钮
            case R.id.activity_dealerProduct_settingTop:

                DisplayMetrics metric = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metric);
                int width = metric.widthPixels;     // 屏幕宽度（像素）

                new MyUtils().setTopPopupWindow(DealerProductDetailActivity.this,width,mRelativeTop,R.layout.layout_popupwindow_top);
                break;
            //产品的参数的监听
            case R.id.activity_dealerProduct_productParams:
                new MyUtils().getVariableDialogFromBottom(DealerProductDetailActivity.this, R.layout.layout_product_params_dialog, new BottomDialogInterface() {
                    @Override
                    public void getLayout(View view, final Dialog dialog) {
                        //展现产品参数的列表
                        ListView showList = (ListView) view.findViewById(R.id.layout_productParams_showList);

                        ProductParamsAdapter paramsAdapter = new ProductParamsAdapter(DealerProductDetailActivity.this, mParamsData, R.layout.layout_product_params_item);
                        showList.setAdapter(paramsAdapter);

                        //确定按钮的监听
                        TextView sureText = (TextView) view.findViewById(R.id.layout_productParams_sure);
                        sureText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                    }
                });
                break;
            //规格的监听
            case R.id.activity_dealerProduct_productStandard:
                new MyUtils().getDialogFromBottom(DealerProductDetailActivity.this, R.layout.layout_dealerpro_standard_dialog, new BottomDialogInterface() {
                    @Override
                    public void getLayout(View view, final Dialog dialog) {
                        //产品的图片
                        ImageView productImage = (ImageView) view.findViewById(R.id.layout_dealerStandard_image);
//                        new MyUtils().ShowPicture(DealerProductDetailActivity.this, "", productImage);

                        //产品的名字
                        TextView productName = (TextView) view.findViewById(R.id.layout_dealerStandard_name);
                        productName.setText("高端大马力产品");

                        //产品的价格
                        TextView productPrice = (TextView) view.findViewById(R.id.layout_dealerStandard_price);
                        productPrice.setText("10万");

                        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        //展现产品规格
                        final FNRadioGroup radioGroup = (FNRadioGroup) view.findViewById(R.id.layout_dealerStandard_radioGroup);
                        //设置子控件的边距
                        radioGroup.setChildMargin(0, 0, 20, 20);

                        radioButtons = new RadioButton[4];
                        for (int i = 0; i < 4; i++) {
                            //规格类型
                            radioButtons[i] = new RadioButton(DealerProductDetailActivity.this);

                            TextView textView = new TextView(DealerProductDetailActivity.this);
                            textView.setText("钢钎直径20mm"+i);
                            //获取文本的高度和宽度
                            textView.measure(w, h);
                            int height = textView.getMeasuredHeight();
                            int width = textView.getMeasuredWidth();

                            radioButtons[i].setText("钢钎直径20mm"+i);
//                            radioButtons[i].setTextSize(R.dimen.d12sp);
                            //设置去掉自带的圆圈
                            radioButtons[i].setButtonDrawable(R.drawable.radiobutton_hint_shape);
                            //设置字体颜色
                            radioButtons[i].setTextColor(Color.GRAY);

                            //设置底色
                            radioButtons[i].setBackgroundResource(R.drawable.radiobutton_hint_shape);
                            radioButtons[i].setGravity(Gravity.CENTER);
                            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                            //将dp转成px
                            int space = DensityUtil.dp2px(DealerProductDetailActivity.this, 27);
                            params.height = height + space;
                            params.width = width + space;
                            //设置边距
//                            params.setMargins(0, 0, 20, 0);
                            radioButtons[i].setLayoutParams(params);
                            radioGroup.addView(radioButtons[i]);
                        }

                        //设置规格中内容的监听
                        radioGroup.setOnCheckedChangeListener(new FNRadioGroup.OnCheckedChangeListener() {

                            @Override
                            public void onCheckedChanged(FNRadioGroup group, int checkedId) {
                                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                                    if (radioButtons[i].isChecked()) {
                                        radioButtons[i].setTextColor(getResources().getColor(R.color.font_color_white));
                                        radioButtons[i].setBackgroundResource(R.drawable.radiobutton_show_shape);
                                        //得到选中规格的文字
                                        mStandardName = radioButtons[i].getText().toString();

                                    } else {
                                        radioButtons[i].setTextColor(Color.GRAY);
                                        radioButtons[i].setBackgroundResource(R.drawable.radiobutton_hint_shape);
                                    }
                                }
                            }
                        });

                        //显示产品的数量
                        final TextView setCount = (TextView) view.findViewById(R.id.layout_dealerStandard_setCount);

                        //对产品数量减少的监听
                        ImageView cutImage = (ImageView) view.findViewById(R.id.layout_dealerStandard_cutCount);
                        cutImage.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int productCount = Integer.parseInt(setCount.getText().toString());
                                productCount--;
                                if (productCount<0){
                                    productCount=0;
                                }
                                setCount.setText(productCount+"");
                            }
                        });

                        //对产品数量增加的监听
                        ImageView addImage = (ImageView) view.findViewById(R.id.layout_dealerStandard_addCount);
                        addImage.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int productCount = Integer.parseInt(setCount.getText().toString());
                                productCount++;

                                setCount.setText(productCount+"");
                            }
                        });

                        //退出ImageView
                        ImageView backImage = (ImageView) view.findViewById(R.id.layout_dealerStandard_back);
                        backImage.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        //确定按钮
                        TextView sureText = (TextView) view.findViewById(R.id.layout_dealerStandard_sure);
                        sureText.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                //获取选择的数量
                                mProductCount = Integer.parseInt(setCount.getText().toString());
                                mProductStandard.setText("已选规格："+mStandardName);
                                dialog.dismiss();
                            }
                        });
                    }
                });
                break;
        }
    }

    private int color;
    //对重写的ScrollView进行监听，改变控件颜色
    @Override
    public void onScrollBottomListener(boolean isBottom, int scrollY) {
        //页面顶部最外层的控件的高度
        int height = mRelativeTop.getMeasuredHeight();

        Log.e("TAG", "onScrollBottomListener: "+scrollY );

        if (scrollY > 10) {
            float persent = scrollY * 1f / (height * 2);
            if (persent > 1 || persent == 1) {
                persent = 1;

                mBackTop.setImageResource(R.mipmap.black_back);
                mShopTop.setImageResource(R.mipmap.black_shop_car);
                mSettingTop.setImageResource(R.mipmap.black_setting);
            }
            int alpha = (int) (255 * persent);
            color = Color.argb(alpha, 255, 255, 255);

        } else if (scrollY <=10) {
            color = Color.argb(0, 255, 255, 255);

            mBackTop.setImageResource(R.mipmap.back1);
            mShopTop.setImageResource(R.mipmap.shop_car);
            mSettingTop.setImageResource(R.mipmap.message1);

        }
        mRelativeTop.setBackgroundColor(color);
    }
}
