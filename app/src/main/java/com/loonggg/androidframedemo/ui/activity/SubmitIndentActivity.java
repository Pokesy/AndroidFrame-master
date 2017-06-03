package com.loonggg.androidframedemo.ui.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.SelectAddressModel;
import com.loonggg.androidframedemo.net.constant.BottomDialogInterface;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.utils.DensityUtil;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.view.FNRadioGroup;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
* 修云飞   购物流程中的---提交订单页面
* */
public class SubmitIndentActivity extends BasicTitleBarActivity implements View.OnClickListener {

    //最顶部的返回图标
    @Bind(R.id.activity_submitIndent_back)
    ImageView mBackImage;

    //界面上部的收货人信息
    @Bind(R.id.activity_sunmitIndent_peopleName)
    TextView mPeopleName;
    @Bind(R.id.activity_sunmitIndent_peoplePhone)
    TextView mPeoplePhone;
    @Bind(R.id.activity_sunmitIndent_peopleAddress)
    TextView mPeopleAddress;

    //生产产品的公司名称
    @Bind(R.id.activity_sunmitIndent_companyName)
    TextView mCompanyName;

    //产品信息的介绍
    @Bind(R.id.activity_submitIndent_productImage)
    ImageView mProductImage;
    @Bind(R.id.activity_submitIndent_productName)
    TextView mProductName;
    @Bind(R.id.activity_submitIndent_productPrice)
    TextView mProductPrice;

    //产品支付有关的信息
    @Bind(R.id.activity_submitIndent_standaraRelative)
    RelativeLayout mStandarsRelative;
    @Bind(R.id.activity_submitIndent_textOne)
    TextView mProductStandard;//选择产品规格

    @Bind(R.id.activity_submitIndent_cutCount)
    ImageView mCutCount;//减少产品数量
    @Bind(R.id.activity_submitIndent_addCount)
    ImageView mAddCount;//增加产品数量
    @Bind(R.id.activity_submitIndent_textTwo)
    TextView mPtotuctCount_Two;//显示选择的产品数量

    @Bind(R.id.activity_submitIndent_paymentRelative)
    RelativeLayout mPaymentRelative;
    @Bind(R.id.activity_submitIndent_textThree)
    TextView mPaymentStyle;//选择支付方式

    @Bind(R.id.activity_submitIndent_editContent)
    EditText mEditContent;//显示留言

    //界面底部的按钮
    @Bind(R.id.activity_submitIndent_allPrice)
    TextView mAllPrice;
    @Bind(R.id.activity_submitIndent_submitProduct)
    TextView mSubmitProduct;

    //可滑动页面底部的产品数量统计
    @Bind(R.id.activity_submitIndent_productCount)
    TextView mProductCount;
    //滑动页面底部产品总价格的统计
    @Bind(R.id.activity_submitIndent_allPrice_One)
    TextView mAllPriceOne;


    private TextView mHindAddress;
    //
    public static final int REQUEST_CODE = 1;
    private LinearLayout mShowAddress;
    private LinearLayout mHindAddressLinear;

    //定义一个变量，判断选择支付的方式
    private boolean mIsPayment = true;

    //定义规格数量的数组
    private RadioButton[] radioButtons;
    //选中规格的名字
    private String mStandardName="";
    private double onlyPrice;
    private Integer productCount;
    private String allPrice;

    @Override
    public int getLayoutId() {
        return R.layout.activity_submit_indent;
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
        //添加地址的外层布局
        mHindAddressLinear = ((LinearLayout) findViewById(R.id.activity_submitIndent_HintLinear));
        //添加地址的文本的实例化
        mHindAddress = ((TextView) findViewById(R.id.activity_submitIndent_addressHint));
        //显示地址信息的外层布局的实例化
        mShowAddress = ((LinearLayout) findViewById(R.id.activity_submitIndent_addressShow));

        //获取产品的单价--double   double d = Double.parseDouble("1.0");
        onlyPrice = Double.parseDouble(mProductPrice.getText().toString());
        //获取产品的数量
        productCount = Integer.valueOf(mPtotuctCount_Two.getText().toString());
        //获取产品的总价格--double
        allPrice = String.format("%.2f", onlyPrice * productCount);
        //获取所有产品的总价格
        mAllPrice.setText(allPrice + "");

        mAllPriceOne.setText(allPrice + "");
        mProductCount.setText("共计"+0+ "件商品");
    }

    private void setView() {

    }

    private void initData() {

    }

    private void setListener() {
        //返回图标的监听
        mBackImage.setOnClickListener(this);

        //选择收货地址的监听
        mHindAddress.setOnClickListener(this);

        //选择产品规格
        mStandarsRelative.setOnClickListener(this);

        //选择支付方式的监听
        mPaymentRelative.setOnClickListener(this);

        //减少产品数量
        mCutCount.setOnClickListener(this);
        //增加产品数量
        mAddCount.setOnClickListener(this);

        //提交订单
        mSubmitProduct.setOnClickListener(this);

        //重新选择地址
        mShowAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            //返回图标的监听
            case R.id.activity_submitIndent_back:
                finish();
                break;
            //重新选择收货地址
            case R.id.activity_submitIndent_addressShow:
                Intent intent1 = new Intent(SubmitIndentActivity.this, SelectAddressActivity.class);
                startActivityForResult(intent1, REQUEST_CODE);
                break;
            //添加收货地址的监听--跳转到选择地址页面
            case R.id.activity_submitIndent_addressHint:
                Intent intent = new Intent(SubmitIndentActivity.this, SelectAddressActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            //提交订单按钮的监听
            case R.id.activity_submitIndent_submitProduct:
                Intent intent2 = new Intent(SubmitIndentActivity.this,PayOrderActivity.class);
                intent2.putExtra("allPrice",allPrice+"");
                startActivity(intent2);
                break;
            //减少货物数量
            case R.id.activity_submitIndent_cutCount:
                //获取货物的数量
                Integer productCount1 = Integer.valueOf(mPtotuctCount_Two.getText().toString());
                productCount1--;
                if (productCount1 < 0) {
                    productCount1 = 0;
                }
                mPtotuctCount_Two.setText(productCount1 + "");

                //获取产品的总价格--double
                allPrice = String.format("%.2f", onlyPrice * productCount1);
                //获取所有产品的总价格  String.format("%.2f", allPrice)
                mAllPrice.setText(allPrice + "");

                mAllPriceOne.setText(allPrice + "");
                mProductCount.setText("共计"+productCount1 + "件商品");

                break;
            //增加货物数量
            case R.id.activity_submitIndent_addCount:
                Integer productCount2 = Integer.valueOf(mPtotuctCount_Two.getText().toString());
                productCount2++;
                mPtotuctCount_Two.setText(productCount2 + "");

                //获取产品的总价格--double
                allPrice = String.format("%.2f",onlyPrice * productCount2);
                //获取所有产品的总价格
                mAllPrice.setText(allPrice + "");

                mAllPriceOne.setText(allPrice + "");
                mProductCount.setText("共计"+productCount2 + "件商品");
                break;
            //选择支付方式
            case R.id.activity_submitIndent_paymentRelative:
                new MyUtils().getDialogFromBottom(SubmitIndentActivity.this, R.layout.layout_submit_bottom_dialog, new BottomDialogInterface() {
                    @Override
                    public void getLayout(View view, final Dialog dialog) {
                        //定金支付的金额
                        final TextView downPayment = (TextView) view.findViewById(R.id.layout_submitBottomDialog_downMoney);
                        downPayment.setText("￥" + 100000.00);

                        //是否定金支付
                        final ImageView isDownPayment = (ImageView) view.findViewById(R.id.layout_submitBottomDialog_downOk);

                        //是否全款支付
                        final ImageView isTotalPayment = (ImageView) view.findViewById(R.id.layout_submitBottomDialog_totalOk);

                        //选择定金支付
                        RelativeLayout downRelative = (RelativeLayout) view.findViewById(R.id.layout_submintBottomDialog_downRelative);
                        downRelative.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mIsPayment = false;
                                isDownPayment.setVisibility(View.VISIBLE);//定金
                                isTotalPayment.setVisibility(View.GONE);//全款
                            }
                        });

                        //选择全款支付
                        RelativeLayout totalRelative = (RelativeLayout) view.findViewById(R.id.layout_submintBottomDialog_totalRelative);
                        totalRelative.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mIsPayment = true;
                                isDownPayment.setVisibility(View.GONE);//定金
                                isTotalPayment.setVisibility(View.VISIBLE);//全款
                            }
                        });

                        //取消按钮
                        TextView cancelText = (TextView) view.findViewById(R.id.layout_submitBottomDialog_canael);
                        cancelText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        //确定按钮
                        TextView sureText = (TextView) view.findViewById(R.id.layout_submitBottomDialog_sure);
                        sureText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (mIsPayment) {
                                    mPaymentStyle.setText("全款支付");
                                } else {
                                    mPaymentStyle.setText("定金支付 " + downPayment.getText().toString());
                                }

                                dialog.dismiss();
                            }
                        });
                    }
                });
                break;
            //选择规格
            case R.id.activity_submitIndent_standaraRelative:
                new MyUtils().getDialogFromBottom(SubmitIndentActivity.this, R.layout.layout_standard_bottom_dialog, new BottomDialogInterface() {
                    @Override
                    public void getLayout(View view, final Dialog dialog) {
                        //产品的图片
                        ImageView productImage = (ImageView) view.findViewById(R.id.layout_standardBottom_image);
                        new MyUtils().ShowPicture(SubmitIndentActivity.this, "", productImage);

                        //产品的名字
                        TextView productName = (TextView) view.findViewById(R.id.layout_standardBottom_name);
                        productName.setText("高端大马力产品");

                        //产品的价格
                        TextView productPrice = (TextView) view.findViewById(R.id.layout_standardBottom_price);
                        productPrice.setText("10万");

                        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        //展现产品规格
                        final FNRadioGroup radioGroup = (FNRadioGroup) view.findViewById(R.id.layout_standardBottom_radioGroup);
                        //设置子控件的边距
                        //将dp转成px
                        int marginSpace = DensityUtil.dp2px(SubmitIndentActivity.this, 10);
                        radioGroup.setChildMargin(0, 0, marginSpace, marginSpace);

                        radioButtons = new RadioButton[4];
                        for (int i = 0; i < 4; i++) {
                            //规格类型
                            radioButtons[i] = new RadioButton(SubmitIndentActivity.this);

                            TextView textView = new TextView(SubmitIndentActivity.this);
                            textView.setText("钢钎直径20mm");
                            //获取文本的高度和宽度
                            textView.measure(w, h);
                            int height = textView.getMeasuredHeight();
                            int width = textView.getMeasuredWidth();

                            radioButtons[i].setText("钢钎直径20mm");
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
                            int space = DensityUtil.dp2px(SubmitIndentActivity.this, 13);
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

                        //退出ImageView
                        ImageView backImage = (ImageView) view.findViewById(R.id.layout_standardBottom_back);
                        backImage.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        //确定按钮
                        TextView sureText = (TextView) view.findViewById(R.id.layout_standardBottom_sure);
                        sureText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mProductStandard.setText(mStandardName);
                                dialog.dismiss();
                            }
                        });
                    }
                });
                break;
        }
    }

    //获取顶部选择地址（邮寄地址）返回的内容
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            //得到选择后的地址信息
            SelectAddressModel addressModel = (SelectAddressModel) data.getSerializableExtra("address");
            mHindAddressLinear.setVisibility(View.GONE);
            mShowAddress.setVisibility(View.VISIBLE);
            //添加地址的相关信息
            mPeopleName.setText("收货人：" + addressModel.name);
            mPeoplePhone.setText(addressModel.phone);
            mPeopleAddress.setText("地址：" + addressModel.content);
        }
    }
}
