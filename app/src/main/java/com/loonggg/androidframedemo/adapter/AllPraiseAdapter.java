package com.loonggg.androidframedemo.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.model.AllPraiseModel;
import com.loonggg.androidframedemo.ui.activity.AllPraiseActivity;
import com.loonggg.androidframedemo.ui.activity.SubmitIndentActivity;
import com.loonggg.androidframedemo.utils.DensityUtil;
import com.loonggg.androidframedemo.utils.MyUtils;
import com.loonggg.androidframedemo.utils.TeachBaseAdapter;
import com.loonggg.androidframedemo.view.MyGridView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.width;

/**
 * Created by Administrator on 2017/6/2.
 * 修云飞  全部口碑页面中的列表对应的适配器
 */

public class AllPraiseAdapter extends TeachBaseAdapter<AllPraiseModel>{

    private final int w;
    private final int h;

    private final int mScreenWidth;
    private int linearWidth;

    private Context context;
    //口碑中的评价标签数据源
    private List<String> mLabel;
    //口碑中的GridView展示的数据源
    private List<String> mGridData;

    //定义一个变量，累计记录添加的标签的长度
    private int allLength=0;

    public AllPraiseAdapter(Context context, List<AllPraiseModel> data,List<String> mLabel,List<String> mGridData, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
        this.mLabel=mLabel;
        this.mGridData=mGridData;

        w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);

        DisplayMetrics metric = new DisplayMetrics();
        ((AllPraiseActivity) context).getWindowManager().getDefaultDisplay().getMetrics(metric);
        mScreenWidth = metric.widthPixels;//获取屏幕的宽度
        linearWidth = mScreenWidth-DensityUtil.dp2px(context,40);//获取LinearLayout的长度

    }

    @Override
    protected void bindData(ViewHolder holder, AllPraiseModel item, int position) {
        ImageView picturePraise = (ImageView) holder.getView(R.id.layout_allPraise_picturePraise);
//        new MyUtils().ShowPicture(context,"",picturePraise);

        TextView namePraise = (TextView) holder.getView(R.id.layout_allPraise_namePraise);
        namePraise.setText(item.name);

        TextView datePraise = (TextView) holder.getView(R.id.layout_allPraise_datePraise);
//        datePraise.setText();

        TextView goodPraise = (TextView) holder.getView(R.id.layout_allPraise_goodPraise);
        goodPraise.setText("有用"+123456789);

        //标签外层布局的实例化以及展示数据
        LinearLayout addLinear = (LinearLayout) holder.getView(R.id.layout_allPraise_lineaAdd);

        addLinear.removeAllViews();
        allLength=0;//初始化累加标签的值

        for (int i = 0; i < mLabel.size(); i++) {
            TextView labelText = new TextView(context);
            labelText.setText(mLabel.get(i));

            labelText.measure(w,h);
            int heights = labelText.getMeasuredHeight();
            int widths = labelText.getMeasuredWidth();

            //设置底色
            labelText.setBackgroundResource(R.drawable.label_shape);
            labelText.setTextColor(context.getResources().getColor(R.color.color_organ));
            labelText.setGravity(Gravity.CENTER);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            //将dp转成px
            int intervalWidth = DensityUtil.dp2px(context, 15);
            int intervalHeight = DensityUtil.dp2px(context, 5);
            params.height = heights+intervalHeight;
            params.width = widths+intervalWidth;
            //设置边距
            params.setMargins(0, 0, intervalWidth, 0);
            labelText.setLayoutParams(params);

            //累计叠加标签的长度
            allLength=allLength+intervalWidth*2+widths;

            Log.e("TAG", "bindData: allLength="+allLength+"   linearWidth="+linearWidth );

            //比较LinearLayout与总的标签的长度
            if (linearWidth>=allLength) {
                addLinear.addView(labelText);
            }
        }

        //GridView的实例化以及展示数据
        MyGridView showGrid = (MyGridView) holder.getView(R.id.layout_allPraise_girdPraise);
        int interval = DensityUtil.dp2px(context, 5);
        showGrid.setVerticalSpacing(interval);
        showGrid.setHorizontalSpacing(interval);
        //GridView展示数据
        ShowOnePictureAdapter pictureAdapter = new ShowOnePictureAdapter(context, mGridData, R.layout.layout_one_picture_item);
        showGrid.setAdapter(pictureAdapter);
        

    }
}
