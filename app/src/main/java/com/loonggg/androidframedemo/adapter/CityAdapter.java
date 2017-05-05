package com.loonggg.androidframedemo.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.app.CustomApp;
import com.loonggg.androidframedemo.model.BannerModel;
import com.loonggg.androidframedemo.model.City;
import com.loonggg.androidframedemo.view.ScrollGridView;

import java.util.List;

import cc.solart.turbo.BaseTurboAdapter;
import cc.solart.turbo.BaseViewHolder;
import cn.bingoogolapple.bgabanner.BGABanner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.loonggg.androidframedemo.R.id.sgv;


public class CityAdapter extends BaseTurboAdapter<City, BaseViewHolder> {
    private Context context;
    String[] name = {"艾迪精密", "贝力特", "顺天", "信人","博运重工", "铭德", "世工", "佰泰","百财", "铭润"};
    int[] img = {R.mipmap.ad, R.mipmap.blt, R.mipmap.st, R.mipmap.xr,R.mipmap.byzg, R.mipmap.md, R.mipmap.sg, R.mipmap.bt, R.mipmap.bc, R.mipmap.mr};

    String[] name1 = {"210破碎锤", "振动夯", "松土器", "液压剪","抓木器", "静音型破碎锤"};
    int[] img1 = {R.mipmap.cp1, R.mipmap.cp2, R.mipmap.cp3, R.mipmap.cp4,R.mipmap.cp5, R.mipmap.cp6};

    public CityAdapter(Context context) {
        super(context);
    }

    public CityAdapter(Context context, List<City> data) {
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
            return new GridViewHolder(inflateItemView(R.layout.hot_car_brand_layout, parent));
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
            ((GridViewHolder) holder).banner1.setAdapter(new BGABanner.Adapter<ImageView, String>() {
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
            ((GridViewHolder) holder).banner1.setDelegate(new BGABanner.Delegate<ImageView, String>() {
                @Override
                public void onBannerItemClick(BGABanner banner, ImageView imageView, String model, int position) {
                    Toast.makeText(banner.getContext(), "点击了第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
                }
            });

            CustomApp.getInstance().getEngine().getBannerModel().enqueue(new Callback<BannerModel>() {
                @Override
                public void onResponse(Call<BannerModel> call, Response<BannerModel> response) {
                    BannerModel bannerModel = response.body();
                    ((GridViewHolder) holder).banner1.setData(R.layout.view_image, bannerModel.imgs, null);
                }

                @Override
                public void onFailure(Call<BannerModel> call, Throwable t) {
                }
            });
            ((GridViewHolder) holder).banner2.setAdapter(new BGABanner.Adapter<ImageView, String>() {
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
            ((GridViewHolder) holder).banner2.setDelegate(new BGABanner.Delegate<ImageView, String>() {
                @Override
                public void onBannerItemClick(BGABanner banner, ImageView imageView, String model, int position) {
                    Toast.makeText(banner.getContext(), "点击了第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
                }
            });

            CustomApp.getInstance().getEngine().getBannerModel().enqueue(new Callback<BannerModel>() {
                @Override
                public void onResponse(Call<BannerModel> call, Response<BannerModel> response) {
                    BannerModel bannerModel = response.body();
                    ((GridViewHolder) holder).banner2.setData(R.layout.view_image, bannerModel.imgs, null);
                }

                @Override
                public void onFailure(Call<BannerModel> call, Throwable t) {
                }
            });
            ((GridViewHolder) holder).banner3.setAdapter(new BGABanner.Adapter<ImageView, String>() {
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
            ((GridViewHolder) holder).banner3.setDelegate(new BGABanner.Delegate<ImageView, String>() {
                @Override
                public void onBannerItemClick(BGABanner banner, ImageView imageView, String model, int position) {
                    Toast.makeText(banner.getContext(), "点击了第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
                }
            });

            CustomApp.getInstance().getEngine().getBannerModel().enqueue(new Callback<BannerModel>() {
                @Override
                public void onResponse(Call<BannerModel> call, Response<BannerModel> response) {
                    BannerModel bannerModel = response.body();
                    ((GridViewHolder) holder).banner3.setData(R.layout.view_image, bannerModel.imgs, null);
                }

                @Override
                public void onFailure(Call<BannerModel> call, Throwable t) {
                }
            });
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
        BGABanner banner1,banner2,banner3;
        public GridViewHolder(View view) {
            super(view);
            gv = findViewById(R.id.sgv);
            zhd = findViewById(R.id.zhd);
            banner1=findViewById(R.id.banner1);
            banner2=findViewById(R.id.banner2);
            banner3=findViewById(R.id.banner3);
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
