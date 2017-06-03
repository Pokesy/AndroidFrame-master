package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.ReplyDetailAdapter;
import com.loonggg.androidframedemo.model.ReplyDetailModel;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.view.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ReplyDetailActivity extends BasicTitleBarActivity implements View.OnClickListener {

    @Bind(R.id.activity_replyDetail_back)
    ImageView mBackImage;
    @Bind(R.id.activity_replyDetail_setting)
    ImageView mSettingImage;

    @Bind(R.id.activity_replyDetail_showList)
    ListView mShowList;

    private CircleImageView mImageHeader;
    private TextView mNameHeader;

    private TextView mDateHeader;
    private TextView mCommentHeader;

    private TextView mContentHeader;

    private List<ReplyDetailModel> mReplyData=new ArrayList<>();
    private ReplyDetailAdapter mReplyAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_reply_detail;
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
        //获取ListView的头布局
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_reply_detail_header, null);
        //给ListView添加头布局
        mShowList.addHeaderView(inflate);

        //寻找ListView头布局中的控件
        mImageHeader = ((CircleImageView) inflate.findViewById(R.id.layout_replyDetail_imageHeader));
        mNameHeader = ((TextView) inflate.findViewById(R.id.layout_replyDetail_nameHeader));

        mDateHeader = ((TextView) inflate.findViewById(R.id.layout_replyDetail_dateHeader));
        //发表的评论
        mCommentHeader = ((TextView) inflate.findViewById(R.id.layout_replyDetail_commentHeader));

        //对评论回复的内容
        mContentHeader = ((TextView) inflate.findViewById(R.id.layout_replyDetail_contentHeader));
    }

    private void setView() {
        mReplyAdapter = new ReplyDetailAdapter(this,mReplyData, R.layout.layout_reply_detail_item);
        mShowList.setAdapter(mReplyAdapter);
    }

    private void initData() {
        for (int i = 0; i < 9; i++) {
            ReplyDetailModel replyDetailModel = new ReplyDetailModel();
            replyDetailModel.name="玉皇大帝"+i;

            mReplyData.add(replyDetailModel);
            //刷新适配器
            mReplyAdapter.notifyDataSetChanged();
        }
    }

    private void setListener() {
        mBackImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回按钮的监听
            case R.id.activity_replyDetail_back:
                finish();
                break;

            //设置按钮的监听
            case R.id.activity_replyDetail_setting:
                break;
        }
    }
}
