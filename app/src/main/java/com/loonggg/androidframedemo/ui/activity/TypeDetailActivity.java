package com.loonggg.androidframedemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.adapter.TypeDetailAdapter;
import com.loonggg.androidframedemo.model.TypeDetailModel;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.loonggg.androidframedemo.view.TopTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TypeDetailActivity extends BasicTitleBarActivity {

    @Bind(R.id.activity_typeDetail_topTitle)
    TopTitleView mTopTitle;

    @Bind(R.id.activity_typeDetail_deatialContent)
    TextView mDeatialContent;

    @Bind(R.id.activity_typeDetail_showList)
    ListView mShowList;
    private TypeDetailAdapter mTypeAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_type_detail;
    }

    private List<TypeDetailModel> mTypeData=new ArrayList<>();

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
        mTopTitle.setTopTitle("换向阀");
        mTopTitle.setTopSetting(View.GONE);

        mDeatialContent.setText("共有"+666+"个与“"+"换向阀"+"”相关的品牌店");
    }

    private void setView() {
        mTypeAdapter = new TypeDetailAdapter(this,mTypeData, R.layout.layout_type_deatial_item);
        mShowList.setAdapter(mTypeAdapter);
    }

    private void initData() {
        for (int i = 0; i < 6; i++) {
            TypeDetailModel detailModel = new TypeDetailModel();
            detailModel.name="天蓬元帅"+i;
            mTypeData.add(detailModel);

            mTypeAdapter.notifyDataSetChanged();
        }
    }

    private void setListener() {
        //返回按钮的监听
        mTopTitle.setLeftBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
