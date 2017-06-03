package com.loonggg.androidframedemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.MyViewPager;
import com.loonggg.androidframedemo.adapter.ViewPagerAdapter;
import com.loonggg.androidframedemo.model.AllPraiseModel;
import com.loonggg.androidframedemo.ui.activity.AllPraiseActivity;
import com.loonggg.androidframedemo.ui.activity.AnswerAuthorityActivity;
import com.loonggg.androidframedemo.ui.activity.BrandSearchActivity;
import com.loonggg.androidframedemo.ui.activity.DealerProductDetailActivity;
import com.loonggg.androidframedemo.ui.activity.HomeSearchActivity;
import com.loonggg.androidframedemo.ui.activity.PartsTypeActivity;
import com.loonggg.androidframedemo.ui.activity.ProductTypeActivity;
import com.loonggg.androidframedemo.ui.activity.QuestionAndAnswerActivity;
import com.loonggg.androidframedemo.ui.activity.ReplyDetailActivity;
import com.loonggg.androidframedemo.ui.activity.SubmitIndentActivity;
import com.loonggg.androidframedemo.ui.activity.TypeDetailActivity;
import com.loonggg.androidframedemo.ui.basic.BasicFragment;
import com.loonggg.androidframedemo.utils.MyUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Pokesy_dajiao on 2017/4/20.
 * 主界面
 */


public class MainFragment extends BasicFragment implements View.OnClickListener {
    @Bind(R.id.profile)
    ImageView profile;
    @Bind(R.id.message)
    TextView message;
    @Bind(R.id.locationMessage)
    EditText locationMessage;
    @Bind(R.id.top)
    RelativeLayout top;
    @Bind(R.id.tabLayout)
    TabLayout tab;
    @Bind(R.id.action)
    RelativeLayout action;
    @Bind(R.id.viewPager)
    MyViewPager pager;

    private ViewPagerAdapter adapter;
    //Fragment的集合
    private List<Fragment> list;

    private Context ctx;
    private TextView companyName;

    private static final String ACTION = "com.changeCity.name";

    /**
     * 得到上下文
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.ctx = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_main_fragment, null);
        ButterKnife.bind(this, view);
        //对应控件
        //填充选项卡
        init();
        setListener();

        return view;
    }

    private void setListener() {
        //测试  消息按钮的点击监听---购物流程
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyUtils().JumpActivity(getActivity(), SubmitIndentActivity.class);
            }
        });

        //测试  机器人按钮的点击监听---经销商产品详情页
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*--------以下为经销商产品详情文件夹中的-------------*/
                //ReplyDetailActivity---回复详情
                //QuestionAndAnswerActivity---问答详情
                //DealerProductDetailActivity---经销商产品详情页
                //AnswerAuthorityActivity---问大家页面
                //AllPraiseActivity---全部口碑页面

                /*--------以下为品牌分类页文件中的界面-----------*/
                //PartsTypeActivity---配套件分类页面---有
                //TypeDetailActivity---配套件分类页面下面的二级列表---有
                //BrandSearchActivity---品牌的搜索页面---有

                /*-------以下为品牌界面-->主机界面-->热门品牌中顶部图标点击----------*/
                //ProductTypeActivity---申请团购中的产品类型
                new MyUtils().JumpActivity(getActivity(), ProductTypeActivity.class);
            }
        });
    }

    /**
     * 添加Fragment
     * 开发时请在对应Fragment内进行操作
     */
    public void init() {
        adapter = new ViewPagerAdapter(getChildFragmentManager(), getActivity());
        pager.setOffscreenPageLimit(Integer.MAX_VALUE);
        pager.setAdapter(adapter);
        tab.getTabAt(0).setIcon(R.drawable.tab_selector);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener
                (tab));
        tab.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener
                (pager));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.profile, R.id.message, R.id.locationMessage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.profile:

                break;
            case R.id.message:
                break;
            case R.id.locationMessage:
                startActivity(new Intent(getActivity(), HomeSearchActivity.class));
                break;
        }
    }
}
