package com.loonggg.androidframedemo.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jtech.listener.OnItemClickListener;
import com.jtech.listener.OnItemLongClickListener;
import com.jtech.listener.OnItemViewMoveListener;
import com.jtech.listener.OnItemViewSwipeListener;
import com.jtech.listener.OnLoadListener;
import com.jtech.view.RecyclerHolder;
import com.jtech.view.RefreshLayout;
import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.ViewHolder.RecyclerViewHolder;
import com.loonggg.androidframedemo.adapter.BaseRecyclerAdapter;
import com.loonggg.androidframedemo.adapter.MyAdapter;
import com.loonggg.androidframedemo.adapter.MyTestAdapter;
import com.loonggg.androidframedemo.ui.activity.SearchLocationActivity;
import com.loonggg.androidframedemo.ui.activity.SearchLocationDemoActivity;
import com.loonggg.androidframedemo.ui.basic.BasicFragment;
import com.loonggg.androidframedemo.view.MyScrollview;
import com.loonggg.androidframedemo.view.RGridView;
import com.loonggg.carouselview.CarouselView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.SocializeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Pokesy_dajiao on 2017/4/20.
 */

public class HomeFragment extends BasicFragment implements OnItemClickListener, OnItemLongClickListener, RefreshLayout.OnRefreshListener, OnLoadListener, OnItemViewSwipeListener, OnItemViewMoveListener {
    public static final String ARG_PAGE = "ARG_PAGE";

    @Bind(R.id.today_message)
    RGridView todayMessage;
    @Bind(R.id.tv_more_tool)
    TextView tvMoreTool;
    @Bind(R.id.tv_market)
    TextView tvMarket;
    @Bind(R.id.tv_second_hand)
    TextView tvSecondHand;
    @Bind(R.id.tv_mouth)
    TextView tvMouth;
    @Bind(R.id.tv_build)
    TextView tvBuild;
    @Bind(R.id.main_radio)
    LinearLayout mainRadio;
    @Bind(R.id.iv_today_news)
    ImageView ivTodayNews;
    @Bind(R.id.tv_today_title)
    TextView tvTodayTitle;
    @Bind(R.id.news_count)
    TextView newsCount;
    @Bind(R.id.iv_today_news_time)
    TextView ivTodayNewsTime;

    @Bind(R.id.scrollView)
    MyScrollview scrollView;
    @Bind(R.id.carousel_view)
    CarouselView carouselView;
    @Bind(R.id.trainee_evaluation_rv)
    RecyclerView traineeEvaluationRv;
    private BaseRecyclerAdapter mEvaluationAdapter;
    private int mPage;
    private RecyclerView lv;
    private MyTestAdapter testAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        initBanner();
        initMessage();
        init();

        return view;

    }

    private void initMessage() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add(i + "");
        }
        // 创建一个线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        // 设置布局管理器
        todayMessage.setLayoutManager(layoutManager);
        todayMessage.setAdapter(new MyAdapter(list));
    }

    /**
     * 模拟数据请求
     *
     * @param loadMore 是否为加载更多的标记
     */
    private void loadData(final boolean loadMore) {

    }

    private void initBanner() {
        final List<String> list = new ArrayList<>();
        list.add("http://f.hiphotos.baidu.com/image/pic/item/00e93901213fb80e0ee553d034d12f2eb9389484.jpg");
        list.add("http://d.hiphotos.baidu.com/image/pic/item/0823dd54564e92584a00b4e99e82d158ccbf4e84.jpg");
        list.add("http://f.hiphotos.baidu.com/image/h%3D200/sign=15c6eac033adcbef1e3479069cae2e0e/6d81800a19d8bc3e7451d5ce808ba61ea8d3455d.jpg");

        //设置加载显示的banner广告轮播图
        carouselView.setImageCarouselLoaderListener(new CarouselView.ImageCarouselLoaderListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                Glide.with(getActivity())
                        .load(list.get(position))
                        .centerCrop()
                        .placeholder(R.mipmap.ic_launcher)
                        .crossFade()
                        .into(imageView);
            }
        });
        //也可以在这里设置轮播banner数
        carouselView.setPageCount(3);
        //设置点击事件
        carouselView.setOnCarouselViewItemClickListener(new CarouselView.OnCarouselViewItemClickListener() {
            @Override
            public void OnCarouselViewItemClickListener(int position) {
                Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        //获取当前展示的item索引
        //carouselView.getCurrentIndex();
    }

    private void init() {
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("11");
        list.add("11");
        mEvaluationAdapter = new BaseRecyclerAdapter<String>(getActivity(), list) {

            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_rv_trainee_evaluation;
            }

            @Override
            public void bindData(RecyclerView.ViewHolder holder, int position, String item) {
                if (holder instanceof RecyclerViewHolder) {

                }
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return super.onCreateViewHolder(parent, viewType);
            }
        };

        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        traineeEvaluationRv.setLayoutManager(mLayoutManager);
        traineeEvaluationRv.setAdapter(mEvaluationAdapter);

        mEvaluationAdapter.setIsShowLoadMore(true);
        mEvaluationAdapter.setLoadMoreString("查看更多");
        traineeEvaluationRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == mEvaluationAdapter
                        .getItemCount()) {
                    mEvaluationAdapter.setMoreStatus(BaseRecyclerAdapter.LOADING_MORE);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });

    }

    public static HomeFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        HomeFragment pageFragment = new HomeFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.today_message, R.id.tv_more_tool, R.id.tv_market, R.id.tv_second_hand, R.id.tv_mouth, R.id.tv_build, R.id.iv_today_news})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.today_message:
                break;
            case R.id.tv_more_tool:
                Intent intent = new Intent(getActivity(), SearchLocationActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.tv_market:
                shareDate();
                break;
            case R.id.tv_second_hand:
                Intent intent1 = new Intent(getActivity(), SearchLocationDemoActivity.class);
                getActivity().startActivity(intent1);
                break;
            case R.id.tv_mouth:
                break;
            case R.id.tv_build:
                break;
            case R.id.iv_today_news:
                break;

        }
    }

    private void shareDate() {

       new ShareAction(getActivity()).withText("hello")
                .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                .setCallback(shareListener).open();
    }
    private UMShareListener shareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            SocializeUtils.safeShowDialog(new Dialog(getActivity()));
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(getActivity(),"成功了",Toast.LENGTH_LONG).show();
            SocializeUtils.safeCloseDialog(new Dialog(getActivity()));
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            SocializeUtils.safeCloseDialog(new Dialog(getActivity()));
            Toast.makeText(getActivity(),"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            SocializeUtils.safeCloseDialog(new Dialog(getActivity()));
            Toast.makeText(getActivity(),"取消了",Toast.LENGTH_LONG).show();

        }
    };

    @Override
    public void onItemClick(RecyclerHolder recyclerHolder, View view, int i) {
        Toast.makeText(getActivity(), "第" + i + "行点击事件", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(RecyclerHolder recyclerHolder, View view, int i) {
        Toast.makeText(getActivity(), "第" + i + "行长点击事件", Toast.LENGTH_SHORT).show();
        return false;//因为这里return false 所以长点击拖动才有效，演示功能用，所以会触发两次震动
    }

    @Override
    public boolean onItemViewMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder1) {
        testAdapter.moveData(viewHolder.getAdapterPosition(), viewHolder1.getAdapterPosition());
        return false;
    }

    @Override
    public void onItemViewSwipe(RecyclerView.ViewHolder viewHolder, int i) {
        testAdapter.removeData(viewHolder.getAdapterPosition());
        if (i == ItemTouchHelper.START) {
            Toast.makeText(getActivity(), "Delete!", Toast.LENGTH_SHORT).show();
        } else if (i == ItemTouchHelper.END) {
            Toast.makeText(getActivity(), "Android!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void loadMore() {
        loadData(true);
    }

    @Override
    public void onRefresh() {
        loadData(false);
    }
}
