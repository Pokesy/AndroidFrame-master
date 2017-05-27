package com.loonggg.androidframedemo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.CommentAdapter;
import com.loonggg.androidframedemo.adapter.RecommendAdapter;
import com.loonggg.androidframedemo.app.CustomApp;
import com.loonggg.androidframedemo.injection.GlobalModule;
import com.loonggg.androidframedemo.model.NewsDetailModel;
import com.loonggg.androidframedemo.net.rpc.UiRpcSubscriber;
import com.loonggg.androidframedemo.net.rpc.service.AppService;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.ui.serviceinjection.DaggerServiceComponent;
import com.loonggg.androidframedemo.ui.serviceinjection.ServiceModule;
import com.loonggg.androidframedemo.view.ScrollViewWithListView;
import com.loonggg.androidframedemo.view.TopTitleView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by Pokesy_dajiao on 2017/5/8.
 * 修云飞    新闻详情页
 */
public class NewsDetailActivity extends BasicTitleBarActivity implements View.OnClickListener {

    private TopTitleView mTopTitle;

    private TextView mContentTitle;

    private TextView mContentName;
    private TextView mContentType;
    private TextView mContentLike;
    private TextView mContentTime;

    private WebView mWebHtnl;

    private ScrollViewWithListView mRecommendList;

    private ScrollViewWithListView mCommentList;

    private EditText mBottomEdit;
    private ImageView mBottomCollect;
    private ImageView mBottomLike;
    private ImageView mBottomShare;

    private String commentContent;

    @Inject
    AppService mInfo;//用于进行网络请求而设置的参数

    private List<NewsDetailModel.Data2Bean> mRecommend = new ArrayList<>();//相关推荐的列表集合
    private List<NewsDetailModel.Data3Bean> mComment = new ArrayList<>();//精彩评论的列表集合
    private RecommendAdapter mRecommendAdapter;
    private CommentAdapter mCommentAdapter;
    private ScrollView mScroll;

    @Override
    public int getLayoutId() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
//        ButterKnife.bind(this);
        initView();//实例化的方法
        setView();//绑定或初始化的方法
        initData();//请求数据的方法
        setListener();//监听事件的方法
    }

    private void initView() {
        //总的标题
        mTopTitle = ((TopTitleView) findViewById(R.id.activity_newsDetail_topTitle));

        //总标题下的最外层布局
        mScroll = ((ScrollView) findViewById(R.id.activity_newsDetail_scroll));

        //顶部标题
        mContentTitle = ((TextView) findViewById(R.id.activity_newsDetail_contentTitle));

        //顶部的第二层
        mContentName = ((TextView) findViewById(R.id.activity_newsDetail_name));
        mContentType = ((TextView) findViewById(R.id.activity_newsDetail_type));
        mContentLike = ((TextView) findViewById(R.id.activity_newsDetail_likeCount));
        mContentTime = ((TextView) findViewById(R.id.activity_newsDetail_time));

        //WebView显示信息
        mWebHtnl = ((WebView) findViewById(R.id.activity_newsDetail_html));
        mWebHtnl.setVisibility(View.VISIBLE);

        //相关推荐
        mRecommendList = ((ScrollViewWithListView) findViewById(R.id.activity_newsDetail_recommendList));

        //精彩评论
        mCommentList = ((ScrollViewWithListView) findViewById(R.id.activity_newsDetail_commentList));

        //界面底部的实例化
        mBottomEdit = ((EditText) findViewById(R.id.activity_newsDetail_edit));
        mBottomCollect = ((ImageView) findViewById(R.id.activity_newsDetail_collect));
        mBottomLike = ((ImageView) findViewById(R.id.activity_newsDetail_like));
        mBottomShare = ((ImageView) findViewById(R.id.activity_newsDetail_share));
    }

    private void setView() {
        DaggerServiceComponent.builder()
                .globalModule(new GlobalModule((CustomApp) NewsDetailActivity.this.getApplication()))
                .serviceModule(new ServiceModule())
                .build()
                .inject(this);

    }

    private void initData() {
        Log.e(TAG, "initData详情页的接口网址: " + mInfo.getNewsList("PH", 12, "UP_PH_PC_NEWS_L", 418, 10, 1));
        manageRpcCall(mInfo.getDetail("PH", 12, "UP_PH_PC_NEWS_D", 418, 10, 1), new UiRpcSubscriber<NewsDetailModel>(NewsDetailActivity.this) {
            @Override
            protected void onSuccess(NewsDetailModel newsModel) {
                List<NewsDetailModel.Data1Bean> data1 = newsModel.getData1();//详情页顶部的接口信息
                if (data1.size() != 0) {
                    NewsDetailModel.Data1Bean data1Bean = data1.get(0);
                    mContentTitle.setText(data1Bean.getNEWS_TITLE());

                    mContentType.setText(data1Bean.getANNOUNCER());
                    mContentLike.setText("点赞" + data1Bean.getRELEASE_TIME());
                    mContentTime.setText(data1Bean.getRELEASE_TIME());

                    if (data1Bean.getHTML_URL() != null && !data1Bean.getHTML_URL().equals("")) {
                        mWebHtnl.loadUrl(data1Bean.getHTML_URL());
                    } else {
                        mWebHtnl.setVisibility(View.GONE);
                    }
                }

                mRecommend = newsModel.getData2();//获取相关推荐的数据源
                Log.e(TAG, "onSuccess: mRecommend.size()="+mRecommend.size() );
                //相关推荐--绑定适配器
                mRecommendAdapter = new RecommendAdapter(NewsDetailActivity.this, mRecommend, R.layout.layout_recommend_item);
                mRecommendList.setAdapter(mRecommendAdapter);
//                mRecommendAdapter.notifyDataSetChanged();

                mComment = newsModel.getData3();//获取精彩评论的数据源
                Log.e(TAG, "onSuccess: mComment.size()="+mComment.size() );
                //精彩评论--绑定适配器
                mCommentAdapter = new CommentAdapter(NewsDetailActivity.this, mComment, R.layout.layout_comment_item);
                mCommentList.setAdapter(mCommentAdapter);
//                mCommentAdapter.notifyDataSetChanged();
            }

            @Override
            protected void onEnd() {
                Toast.makeText(NewsDetailActivity.this, "请求失败", Toast.LENGTH_LONG);
            }
        });
    }

    private void setListener() {
        mTopTitle.setTopTitle("新闻详情");

        //返回按钮的监听
        mTopTitle.setLeftBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //底部评论EditText，收藏，点赞，分享的监听
        mBottomCollect.setOnClickListener(this);
        mBottomLike.setOnClickListener(this);
        mBottomShare.setOnClickListener(this);

        //监听Edittext的软键盘的右下角的按钮
        mBottomEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //如果为发送按钮
                if (actionId== EditorInfo.IME_ACTION_SEND) {
                    //隐藏软键盘
                    InputMethodManager imm = (InputMethodManager) v
                            .getContext().getSystemService(
                                    Context.INPUT_METHOD_SERVICE);
                    if (imm.isActive()) {
                        imm.hideSoftInputFromWindow(
                                v.getApplicationWindowToken(), 0);
                    }

                    //获取评论内容
                    commentContent = mBottomEdit.getText().toString();
                    mBottomEdit.getText().clear();
//                    Toast.makeText(NewsDetailActivity.this, ""+commentContent, Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "onEditorAction评论内容: "+commentContent );

                    return true;
                }
                return false;
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //收藏的监听
            case R.id.activity_newsDetail_collect:
                break;
            //点赞的监听
            case R.id.activity_newsDetail_like:
                break;
            //分享的监听
            case R.id.activity_newsDetail_share:
                break;
        }
    }

    //通过调用此方法向新闻详情页传递参数
    public void JumpNewsDetailActivity(Context context, int id, int type) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra("id", id);//主键
        intent.putExtra("type", type);//区分是哪一种详情页
        startActivity(intent);
    }
}
