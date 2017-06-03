package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.DealerProDetailModel;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 * 修云飞  经销商产品详情页中的--相关推荐页面中适配器的数据源
 */

public class DealerProRecommendAdapter extends TeachBaseAdapter<DealerProDetailModel>{

    private Context context;

    public DealerProRecommendAdapter(Context context, List<DealerProDetailModel> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, DealerProDetailModel item, int position) {
        ImageView pictureRecommend = (ImageView) holder.getView(R.id.layout_dealerDetail_pictureRecommend);
//        new MyUtils().ShowPicture(context,"",pictureRecommend);

        TextView nameRecommend = (TextView) holder.getView(R.id.layout_dealerDetail_nameRecommend);
        if (item.name!=null&&!item.name.equals("")) {
            nameRecommend.setText(item.name);
        }

        TextView priceRecommend = (TextView) holder.getView(R.id.layout_dealerDetail_priceRecommend);
//        priceRecommend.setText();

        TextView sellRecommend = (TextView) holder.getView(R.id.layout_dealerDetail_sellRecommend);
//        sellRecommend.setText();
    }
}
