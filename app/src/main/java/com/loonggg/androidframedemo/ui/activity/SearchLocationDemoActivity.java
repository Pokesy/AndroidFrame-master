package com.loonggg.androidframedemo.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.ui.basic.BasicTitleBarActivity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.utils.SocializeUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Pokesy_dajiao on 2017/4/26.
 * 定位
 */

public class SearchLocationDemoActivity extends BasicTitleBarActivity {
    @Bind(R.id.bt_location)
    Button btLocation;

    @Override
    public int getLayoutId() {

        return R.layout.activity_search_location_share;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ButterKnife.bind(this);
    }

    private void shareDate() {
        ShareAction action = new ShareAction(this);
        action.setDisplayList(SHARE_MEDIA.WEIXIN);
        action.withMedia(new UMImage(this, R.mipmap.ic_launcher));//附带的图片，音乐，视频等多媒体对象
        UMWeb web = new UMWeb("http://blog.xiongit.com");
        web.setTitle("This is music title");//标题
        web.setThumb(new UMImage(this, R.mipmap.ic_launcher));  //缩略图
        web.setDescription("my description");//描述
        action.withMedia(web);
        action.setCallback(shareListener);
        action.open();//打开集成的分享面板
    }

    private UMShareListener shareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            SocializeUtils.safeShowDialog(new Dialog(SearchLocationDemoActivity.this));
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(SearchLocationDemoActivity.this, "成功了", Toast.LENGTH_LONG).show();
            SocializeUtils.safeCloseDialog(new Dialog(SearchLocationDemoActivity.this));
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            SocializeUtils.safeCloseDialog(new Dialog(SearchLocationDemoActivity.this));
            Toast.makeText(SearchLocationDemoActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {
            SocializeUtils.safeCloseDialog(new Dialog(SearchLocationDemoActivity.this));
            Toast.makeText(SearchLocationDemoActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

    @OnClick(R.id.bt_location)
    public void onViewClicked() {
        shareDate();
    }
}
