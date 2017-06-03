package com.loonggg.androidframedemo.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.app.CustomApp;
import com.loonggg.androidframedemo.model.BannerModel;
import com.loonggg.androidframedemo.model.City;
import com.loonggg.androidframedemo.ui.activity.PartsTypeActivity;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.view.ScrollGridView;

import java.util.List;

import cc.solart.turbo.BaseTurboAdapter;
import cc.solart.turbo.BaseViewHolder;
import cn.bingoogolapple.bgabanner.BGABanner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PtjAdapter extends BaseTurboAdapter<City, BaseViewHolder> implements View.OnClickListener {
    private Context context;
    String[] name = {"艾迪精密", "贝力特", "顺天", "信人","博运重工", "铭德", "世工", "佰泰","百财", "铭润"};
    int[] img = {R.mipmap.ad, R.mipmap.blt, R.mipmap.st, R.mipmap.xr,R.mipmap.byzg, R.mipmap.md, R.mipmap.sg, R.mipmap.bt, R.mipmap.bc, R.mipmap.mr};

    String[] name1 = {"210破碎锤", "振动夯", "松土器", "液压剪","抓木器", "静音型破碎锤"};
    int[] img1 = {R.mipmap.cp1, R.mipmap.cp2, R.mipmap.cp3, R.mipmap.cp4,R.mipmap.cp5, R.mipmap.cp6};

    public PtjAdapter(Context context) {
        super(context);
    }

    public PtjAdapter(Context context, List<City> data) {
        super(context, data);
        this.context = context;
    }

    @Override
    protected int getDefItemViewType(int position) {
        if (position==0){
            return 2;
        }else{
            City city = getItem(position-1);
            return city.type;
        }

    }

    @Override
    protected BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0)
            return new CityHolder(inflateItemView(R.layout.item_city, parent));
        else if(viewType==1){
            return new PinnedHolder(inflateItemView(R.layout.item_pinned_header, parent));
        }else {
            return new GridViewHolder(inflateItemView(R.layout.hot_ptj_brand_layout, parent));
        }

    }


    @Override
    protected void convert(final BaseViewHolder holder, City item) {
        if (holder instanceof CityHolder) {
            ((CityHolder) holder).city_name.setText(item.name);
        }else if(holder instanceof PinnedHolder) {
            String letter = item.pys.substring(0, 1);
            ((PinnedHolder) holder).city_tip.setText(letter);
        }else if (holder instanceof GridViewHolder) {
            ((GridViewHolder) holder).gv.setAdapter(new GridViewAdapter(context, name,img));
            ((GridViewHolder) holder).zhd.setAdapter(new GridViewAdapter(context, name1,img1));
            ((GridViewHolder) holder).toPartsRelative.setOnClickListener(this);

        }
    }

    public int getLetterPosition(String letter){
        for (int i = 0 ; i < getData().size(); i++){
            if(getData().get(i).type ==1 && getData().get(i).pys.equals(letter)){
                return i;
            }
        }
        return -1;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //界面顶部的大锤专区的监听事件
            case R.id.layout_ptjBrand_relative:
                new MyUtils().JumpActivity(context, PartsTypeActivity.class);
                break;
        }
    }

    class CityHolder extends BaseViewHolder {

        TextView city_name;

        public CityHolder(View view) {
            super(view);
            city_name = findViewById(R.id.city_name);
        }
    }


    class GridViewHolder extends BaseViewHolder {

        ScrollGridView gv;
        ScrollGridView zhd;
        //大锤专区的实例化
        RelativeLayout toPartsRelative;
        public GridViewHolder(View view) {
            super(view);
            gv = findViewById(R.id.sgv);
            zhd = findViewById(R.id.zhd);
            toPartsRelative=findViewById(R.id.layout_ptjBrand_relative);

        }
    }
    class PinnedHolder extends BaseViewHolder {

        TextView city_tip;

        public PinnedHolder(View view) {
            super(view);
            city_tip = findViewById(R.id.city_tip);
        }
    }
}
