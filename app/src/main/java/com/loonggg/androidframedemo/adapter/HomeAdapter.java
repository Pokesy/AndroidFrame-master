package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jtech.adapter.BaseJAdapter;
import com.jtech.view.RecyclerHolder;
import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.app.CustomApp;
import com.loonggg.androidframedemo.model.BannerModel;
import com.loonggg.androidframedemo.ui.activity.BrandDetailActivity;
import com.loonggg.androidframedemo.ui.activity.DgnsjActivity;
import com.loonggg.androidframedemo.ui.activity.EsActivity;
import com.loonggg.androidframedemo.ui.activity.GqActivity;
import com.loonggg.androidframedemo.ui.activity.KbActivity;
import com.loonggg.androidframedemo.ui.activity.NewsDetailActivity;
import com.loonggg.androidframedemo.ui.activity.SgalActivity;
import com.loonggg.androidframedemo.view.TimeTaskScroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import cn.bingoogolapple.bgabanner.BGABanner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * 测试适配器
 * Created by dajiao on 16/5/9.
 */
public class HomeAdapter extends BaseJAdapter<RecyclerHolder,String> {
    // 数据集
    private List<String> mDataset;
    Context context;
    protected LayoutInflater mLayoutInflater;

    public HomeAdapter(Context context, List<String> s) {
        super(context);
        this.context = context;
        this.mDataset = s;
        this.mLayoutInflater = LayoutInflater.from(context);
    }



    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else {
            return super.getItemViewType(position-1);
        }
    }


    @Override
    public RecyclerHolder createHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int viewType) {
        if (viewType == 1) {
//
            return new CityHolder(layoutInflater.inflate(R.layout.view_custom_header2, viewGroup, false));
        } else {
            return new NewsHolder(layoutInflater.inflate(R.layout.fragment_today_recommend_news_item, viewGroup, false));
        }
    }
    /**
     * 获取数据
     *
     * @return
     */
    public List<String> getList() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i) + "博运重工有限公司供应液压破碎锤一百件。。。");
        }
        return list;
    }
    @Override
    public void convert(RecyclerHolder recyclerHolder, int viewType, int position) {
        if (recyclerHolder instanceof  CityHolder) {
            final BGABanner banner= recyclerHolder.getView(R.id.banner);
            ListView listView1=recyclerHolder.getView(R.id.listView1);
            new Timer().schedule(new TimeTaskScroll(context, listView1 , getList()), 2000, 200);
            ListView listView2=recyclerHolder.getView(R.id.listView2);
            new Timer().schedule(new TimeTaskScroll(context, listView2 , getList()), 2000, 200);
            banner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
                @Override
                public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                    Glide.with(itemView.getContext())
                            .load(model)
                            .placeholder(R.mipmap.home_ad)
                            .error(R.mipmap.home_ad)
                            .dontAnimate()
                            .centerCrop()
                            .into(itemView);
                }
            });
            banner.setDelegate(new BGABanner.Delegate<ImageView, String>() {
                @Override
                public void onBannerItemClick(BGABanner banner, ImageView imageView, String model, int position) {
                    Toast.makeText(banner.getContext(), "点击了第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
                }
            });

            CustomApp.getInstance().getEngine().getBannerModel().enqueue(new Callback<BannerModel>() {
                @Override
                public void onResponse(Call<BannerModel> call, Response<BannerModel> response) {
                    BannerModel bannerModel = response.body();
                    banner.setData(R.layout.view_image, bannerModel.imgs, null);
                }

                @Override
                public void onFailure(Call<BannerModel> call, Throwable t) {
                }
            });
            recyclerHolder.getView(R.id.tv_more_tool).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, DgnsjActivity.class));
                }
            });
            recyclerHolder.getView(R.id.tv_second_hand).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, EsActivity.class));
                }
            });
            recyclerHolder.getView(R.id.tv_market).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, GqActivity.class));
                }
            });
            recyclerHolder.getView(R.id.tv_mouth).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, KbActivity.class));
                }
            });
            recyclerHolder.getView(R.id.tv_build).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, SgalActivity.class));
                }
            });
//            recyclerHolder.setImageResource(R.id.iv_today_news,R.mipmap.home3);
        } else if (recyclerHolder instanceof NewsHolder){

        }
    }

    class CityHolder extends RecyclerHolder {


        public CityHolder(View view) {
            super(view);
        }
    }
    class NewsHolder extends RecyclerHolder {

        TextView city_name;

        public NewsHolder(View view) {
            super(view);
//            city_name = (TextView) view.findViewById(R.id.city_name);
        }
    }
}