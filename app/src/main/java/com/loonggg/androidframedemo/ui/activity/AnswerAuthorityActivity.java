package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.AnswerAuthorityAdapter;
import com.loonggg.androidframedemo.model.AnswerAuthorityModel;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AnswerAuthorityActivity extends BasicTitleBarActivity implements View.OnClickListener {

    @Bind(R.id.activity_submitIndent_back)
    ImageView mBackImage;

    @Bind(R.id.activity_answerAuthority_questionContent)
    TextView mQuestionContent;
    @Bind(R.id.activity_answerAuthority_questionCount)
    TextView mQuestionCount;

    @Bind(R.id.activity_answerAuthority_showList)
    ListView mShowList;

    @Bind(R.id.activity_answerAuthority_goQuestion)
    TextView mGoQuestion;

    //问大家列表对应的适配器
    private List<AnswerAuthorityModel> mAnswerData=new ArrayList<>();
    private AnswerAuthorityAdapter mAnswerAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_answer_authority;
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
        //问题的内容
//        mQuestionContent.setText();

        //与问题内容有关的数量
        mQuestionCount.setText("的"+13+"个问题");
    }

    private void setView() {
        mAnswerAdapter = new AnswerAuthorityAdapter(this,mAnswerData, R.layout.layout_answer_authority_item);
        mShowList.setAdapter(mAnswerAdapter);
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            AnswerAuthorityModel authorityModel = new AnswerAuthorityModel();
            authorityModel.name="太上老君"+i;
            mAnswerData.add(authorityModel);

            mAnswerAdapter.notifyDataSetChanged();
        }
    }

    private void setListener() {
        mBackImage.setOnClickListener(this);

        //我要提问的监听事件
        mGoQuestion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //顶部标题的返回键
            case R.id.activity_submitIndent_back:
                finish();
                break;

            //我要提问的监听事件
            case R.id.activity_answerAuthority_goQuestion:
                break;
        }
    }
}
