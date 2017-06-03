package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.AnswerAdapter;
import com.loonggg.androidframedemo.adapter.CommentAdapter;
import com.loonggg.androidframedemo.model.AnswerModel;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.view.ScrollViewWithListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
* 修云飞   问答详情的页面
* */
public class QuestionAndAnswerActivity extends BasicTitleBarActivity implements View.OnClickListener {

    @Bind(R.id.activity_questionAndAnswer_back)
    ImageView mBackImage;
    @Bind(R.id.activity_questionAndAnswer_setting)
    ImageView mSettingImage;

    @Bind(R.id.activity_questionAndAnswer_productImage)
    ImageView mProductImage;
    @Bind(R.id.activity_questionAndAnswer_productName)
    TextView mProductName;
    @Bind(R.id.activity_questionAndAnswer_productStandard)
    TextView mProductStandard;
    @Bind(R.id.activity_questionAndAnswer_linear)//显示产品信息的外层布局
    LinearLayout mProductLinear;

    @Bind(R.id.activity_questionAndAnswer_quwstionContent)
    TextView mQuwstionContent;
    @Bind(R.id.activity_questionAndAnswer_answerCount)
    TextView mAnswerCount;

    @Bind(R.id.activity_questionAndAnswer_list)//显示回答信息
    ScrollViewWithListView mShowList;
    private AnswerAdapter mAnswerAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_question_and_answer;
    }

    //回答的数据源
    private List<AnswerModel> mAnswerData=new ArrayList<>();

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
        //显示产品图片
//        new MyUtils().ShowPicture(QuestionAndAnswerActivity.this,"",mProductImage);
        //显示产品名称
//        mProductName.setText();
        //显示产品规格
//        mProductStandard.setText();

        //问的内容
//        mQuwstionContent.setText();
        //回答的数量
        mAnswerCount.setText("共"+10+"条回答");

        //取消ScrollWithListView的焦点
        mShowList.setFocusable(false);
    }

    private void setView() {
        mAnswerAdapter = new AnswerAdapter(QuestionAndAnswerActivity.this,mAnswerData, R.layout.layout_comment_item);
        mShowList.setAdapter(mAnswerAdapter);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            AnswerModel answerModel = new AnswerModel();
            answerModel.name="孙悟空"+i;
            mAnswerData.add(answerModel);
            //刷新适配器
            mAnswerAdapter.notifyDataSetChanged();
        }
    }

    private void setListener() {
        mBackImage.setOnClickListener(this);
        mSettingImage.setOnClickListener(this);

        mProductLinear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回按钮
            case R.id.activity_questionAndAnswer_back:
                finish();
                break;

            //设置按钮的监听
            case R.id.activity_questionAndAnswer_setting:
                break;

            //设置产品信息的外层布局的监听
            case R.id.activity_questionAndAnswer_linear:
                break;
        }
    }
}
