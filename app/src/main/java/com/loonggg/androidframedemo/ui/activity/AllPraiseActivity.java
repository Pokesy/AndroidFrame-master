package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.AllPraiseAdapter;
import com.loonggg.androidframedemo.model.AllPraiseModel;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
* 修云飞  更多口碑的界面
* */
public class AllPraiseActivity extends BasicTitleBarActivity implements View.OnClickListener {

    @Bind(R.id.activity_allPraise_back)
    ImageView mBackImage;

    @Bind(R.id.activity_allPraise_productImage)
    ImageView mProductImage;
    @Bind(R.id.activity_allPraise_productName)
    TextView mProductName;
    @Bind(R.id.activity_allPraise_companyName)
    TextView mCompanyName;

    @Bind(R.id.activity_allPraise_showList)
    ListView mShowList;

    //列表的数据源
    private List<AllPraiseModel> mPraiseData=new ArrayList<>();
    //列表中的Item的标签数据源
    private List<String> mLabelData=new ArrayList<>();
    //列表中的Item的GridView的数据源
    private List<String> mGridData=new ArrayList<>();
    private AllPraiseAdapter mPraiseAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_all_praise;
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
        //获取头布局
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_all_praise_header, null);
        mShowList.addHeaderView(inflate);

        //获取头部局中的口碑数量
        TextView praiseCont = (TextView) inflate.findViewById(R.id.layout_allPraise_praiseCount);
        praiseCont.setText("共" + 19 + "条口碑");

//        new MyUtils().ShowPicture(this,"",mProductImage);
//        mProductName.setText();
//        mCompanyName.setText();
    }

    private void setView() {
        mPraiseAdapter = new AllPraiseAdapter(this,mPraiseData,mLabelData,mGridData, R.layout.layout_all_praise_item);
        mShowList.setAdapter(mPraiseAdapter);
    }

    private void initData() {
        //Item的数据
        for (int i = 0; i < 6; i++) {
            AllPraiseModel praiseModel = new AllPraiseModel();
            praiseModel.name="太白金星"+i;
            mPraiseData.add(praiseModel);
        }

        //Item中标签的数据
        for (int i = 0; i < 4; i++) {
            mLabelData.add("很好很好"+i);
        }

        //Item中GridView的数据
        for (int i = 0; i < 4; i++) {
            mGridData.add("");
        }

        mPraiseAdapter.notifyDataSetChanged();
    }

    private void setListener() {
        mBackImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //返回按钮的监听
            case R.id.activity_allPraise_back:
                finish();
                break;
        }
    }
}
