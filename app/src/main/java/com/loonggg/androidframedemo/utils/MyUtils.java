package com.loonggg.androidframedemo.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.net.constant.BottomDialogInterface;
import com.loonggg.androidframedemo.net.constant.SendEditContentInterface;
import com.loonggg.androidframedemo.net.constant.SureAndCancelInterface;
import com.loonggg.androidframedemo.ui.activity.DealerProductDetailActivity;
import com.loonggg.androidframedemo.view.FNRadioGroup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by Administrator on 2017/5/24.
 * 修云飞  工具类，存放项目中公用的方法
 */
public class MyUtils {

    //测试，用于页面间没有传值的跳转
    public void JumpActivity(Context context,Class<?> activity){
        Intent intent = new Intent(context,activity);
        context.startActivity(intent);
    }

    //用于界面中常规图片的显示
    public void ShowPicture(Context context,String url,ImageView imagePicture){
        Glide.with(context.getApplicationContext())
                .load(url)
                .error(R.mipmap.ic_launcher)
                .into(imagePicture);
    }

    //自定义布局的Dialog(有确定与取消的按钮)，用于确定的对话框，而且四个角为圆角
    public void ShowCustomDialog(Context context, int layoutResId, int sureId, int cancelId, final SureAndCancelInterface myInterface){
        //下面是弹窗
        final AlertDialog customDialog = new AlertDialog.Builder(context).create();
        //点击对话框以外的位置不会消失
        customDialog.setCancelable(false);
        //cancleDialog.setCanceledOnTouchOutside(false);
        customDialog.show();

        //下面是四个角显示圆形的关键
        Window window = customDialog.getWindow();

        WindowManager.LayoutParams lp = window.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics(); // 获取屏幕宽、高用

        lp.width = (int) (d.widthPixels * 0.7); // 宽度设置为屏幕的0.8
        window.setAttributes(lp);

        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  // 有白色背景，加

        //添加布局
        View inflate = LayoutInflater.from(context).inflate(layoutResId, null);
        window.setContentView(inflate);

        //确定的按钮
        TextView mDialogSure = ((TextView) inflate.findViewById(sureId));
        //确定按钮的监听
        mDialogSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myInterface.returnSure("ok",customDialog);
            }
        });

        //取消的按钮
        TextView mDialogCancel= ((TextView) inflate.findViewById(cancelId));
        //取消按钮的监听
        mDialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myInterface.returnCancel("no",customDialog);
            }
        });
    }

    //购物流程--提交订单中，从底部弹出的Dialog
    public void getDialogFromBottom(Context context, int resourceId, BottomDialogInterface myInterface){
        final Dialog mCameraDialog = new Dialog(context,R.style.MyDialog);
        View root = LayoutInflater.from(context).inflate(resourceId, null);
        mCameraDialog.setContentView(root);
        //点击布局意外的区域不会消失
        mCameraDialog.setCanceledOnTouchOutside(false);
        mCameraDialog.show();

        // 设置弹出的动画效果
        mCameraDialog.getWindow().setWindowAnimations(R.style.AnimBottom);
        //设置宽度全屏要在show后面
        WindowManager.LayoutParams layoutParams = mCameraDialog.getWindow().getAttributes();
        layoutParams.gravity= Gravity.BOTTOM;
        layoutParams.width= ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height= ViewGroup.LayoutParams.WRAP_CONTENT;
        mCameraDialog.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        mCameraDialog.getWindow().setAttributes(layoutParams);
//        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画

        //将布局与Dialog传出去
        myInterface.getLayout(root,mCameraDialog);
    }

    //购物流程--提交订单中，从底部弹出的Dialog(需要确定Dialog长度的)
    public void getVariableDialogFromBottom(Context context, int resourceId, BottomDialogInterface myInterface){
        final Dialog mCameraDialog = new Dialog(context,R.style.MyDialog);
        View root = LayoutInflater.from(context).inflate(resourceId, null);
        mCameraDialog.setContentView(root);
        //点击布局意外的区域不会消失
        mCameraDialog.setCanceledOnTouchOutside(false);
        mCameraDialog.show();

        // 设置弹出的动画效果
        mCameraDialog.getWindow().setWindowAnimations(R.style.AnimBottom);
        //设置宽度全屏要在show后面
        WindowManager.LayoutParams layoutParams = mCameraDialog.getWindow().getAttributes();
        layoutParams.gravity= Gravity.BOTTOM;
        layoutParams.width= ViewGroup.LayoutParams.MATCH_PARENT;
        int immobilizationHeight = DensityUtil.dp2px(context, 450);//获取固定高度的Dialog值
        layoutParams.height= immobilizationHeight;
        mCameraDialog.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        mCameraDialog.getWindow().setAttributes(layoutParams);
//        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画

        //将布局与Dialog传出去
        myInterface.getLayout(root,mCameraDialog);
    }

    //定义一个从底部View动画的方式出现
    public void setAnimationFromBottom(View view){
        int height = view.getHeight();
        //进行动画操作
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f, 0.0f, 1.0f});
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(view, "translationY", new float[]{0.0f, -height, height, 0.0f});
        //组合动画的实现方式之一：
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animator1, animator4);
        set.setDuration(1000);
        set.start();
    }

    //用于提示的对话框
    public void dialogHint(final Context context,int layoutId,int contentId,int sureId,String string,boolean type){//其它情况判断用的Dialog
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setCancelable(false);
        alertDialog.show();

        Window window = alertDialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  // 有白色背景，加（可以使Dialog的角为布局中设置的角）

        View inflate = LayoutInflater.from(context).inflate(layoutId, null);
        window.setContentView(inflate);
        final TextView mTextContent = (TextView) inflate.findViewById(contentId);
        if (type) {
            mTextContent.setText(string+"不能为空");
        }else {
            mTextContent.setText(string);
        }
        TextView mTextSure = (TextView) inflate.findViewById(sureId);
        mTextSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    //PopupWindow,用于设置按钮的实现
    public void setTopPopupWindow(final Context context,int screenWidth, View view, int layoutId){
//        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
//        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
//        messageText.measure(w, h);//计算PopupWindow布局的大小
//        int height = messageText.getMeasuredHeight();
//        int width = messageText.getMeasuredWidth();

        View popupView = LayoutInflater.from(context).inflate(layoutId, null);

//        final PopupWindow popupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final PopupWindow popupWindow = new PopupWindow(popupView);

        //将dp转换成px
        int width = DensityUtil.dp2px(context, 140);
        int height = DensityUtil.dp2px(context, 130);
        popupWindow.setWidth(width);
        popupWindow.setHeight(height);//设置弹出框大小

        //popupWindow设置动画
        popupWindow.setAnimationStyle(R.style.myPopupWindow_anim_style);

        //如果不设置popupWindow背景 无论点击popupWindow的外部区域还是按back键都无法让popupWindow dismiss
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        //设置点击窗口外边空白区域是否让窗口消失--以下两句，点击Back键时PopupWindow会消失
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

        /**
         * showAtLocation相对于父控件的摆放位置 可以设置偏移或者无偏移
         * 第一个参数可以很随意 只要是这个Activity中的View就可以
         */
        int residueWidth = DensityUtil.dp2px(context, 10);
        int cutWidth = screenWidth - residueWidth-width;
        popupWindow.showAsDropDown(view, cutWidth, 0);

        //对布局中的控件进行实例化
        //消息
        TextView messageText = (TextView) popupView.findViewById(R.id.layout_top_popupWindow_message);
        messageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "消息", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });

        //首页
        TextView homeText = (TextView) popupView.findViewById(R.id.layout_top_popupWindow_home);
        homeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "首页", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });

        //收藏夹
        TextView collectText = (TextView) popupView.findViewById(R.id.layout_top_popupWindow_collect);
        collectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "收藏夹", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
    }

    //监听弹出的软键盘右下角的按钮
    public void sendEditText(final EditText mBottomEdit, final SendEditContentInterface editContentInterface){
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
                    String commentContent = mBottomEdit.getText().toString();
//                    mBottomEdit.getText().clear();

                    //将输入的内容通过接口返回
                    editContentInterface.getEditContent(commentContent);

                    return true;
                }
                return false;
            }
        });
    }

    /*---------------------------------------电话号码判断以下---------------------------------*/
    /**
     * 大陆号码或香港号码均可
     */
    public boolean isPhoneLegal(String str)throws PatternSyntaxException {
        return isChinaPhoneLegal(str) || isHKPhoneLegal(str);
    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
     */
    public boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,4,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 香港手机号码8位数，5|6|8|9开头+7位任意数
     */
    public boolean isHKPhoneLegal(String str)throws PatternSyntaxException {
        String regExp = "^(5|6|8|9)\\d{7}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
    /*---------------------------------------电话号码判断以上---------------------------------*/
}
