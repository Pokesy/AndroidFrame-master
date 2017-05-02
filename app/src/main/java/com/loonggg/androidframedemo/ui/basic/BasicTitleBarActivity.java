package com.loonggg.androidframedemo.ui.basic;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.loonggg.androidframedemo.R;
import com.loonggg.androidframedemo.app.CustomApp;
import com.loonggg.androidframedemo.net.rpc.service.AppService;
import com.loonggg.androidframedemo.segmentcontrol.SegmentControl;
import com.loonggg.androidframedemo.ui.basic.titlebar.TitleBar;
import com.loonggg.androidframedemo.utils.ToastUtil;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * 带标 栏的Activity基 <BR>
 *
 */
public abstract class BasicTitleBarActivity extends BasicActivity implements

    BasicTitleBarInterface {
  protected String TAG;
  protected CustomApp mApp;
  protected AppService mEngine;
  private SweetAlertDialog mLoadingDialog;
  /**
   * TitleBar
   */
  private TitleBar mTitleBar;

  /**
   * 子视图的容器
   */
  private FrameLayout mContentContainer;

  private BasicTitleBarInterface mTitleBarInterface;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LayoutInflater inflater = LayoutInflater.from(this);

    initTitleBarViews();

    mContentContainer = (FrameLayout) findViewById(R.id.content_container);
    if (getContentContainerBgId() != -1) {
      mContentContainer.setBackgroundResource(getContentContainerBgId());
    }

    View contentView = inflater.inflate(getLayoutId(), null);
    mContentContainer.addView(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup
        .LayoutParams.MATCH_PARENT);
  }

  /**
   * 标 栏初始化 <BR>
   */
  private void initTitleBarViews() {
    TitleBar.TitleBarStyle style = getTitleBarStyle();
    switch (style) {
      case NORMAL:
        setContentView(R.layout.content_container);
        break;
      case TRANSPARENT:
        setContentView(R.layout.content_container_trans);
        break;
      default:
        setContentView(R.layout.content_container);
        break;
    }
    mTitleBar = (TitleBar) findViewById(R.id.title_bar_layout);
    mTitleBarInterface = new BasicTitleBarInterfaceImp(mTitleBar);
    if (!initializeTitleBar()) {
      mTitleBar.hideTitleBar();
    }
  }

  @Override
  public void setLeftButtonListener(View.OnClickListener listener) {
    mTitleBarInterface.setLeftButtonListener(listener);
  }

  @Override
  public void setRightImgBtnClickListener(View.OnClickListener listener) {
    mTitleBarInterface.setRightImgBtnClickListener(listener);
  }

  @Override
  public void setRightTexBtnListener(View.OnClickListener listener) {
    mTitleBarInterface.setRightTexBtnListener(listener);
  }

  @Override
  public void setLeftSubTitle(CharSequence subTitle, View.OnClickListener listener) {
    mTitleBarInterface.setLeftSubTitle(subTitle, listener);
  }

  @Override
  public void setLeftSubTitle(CharSequence subTitle) {
    mTitleBarInterface.setLeftSubTitle(subTitle);
  }

  @Override
  public int getLayoutId() {
    return mTitleBarInterface.getLayoutId();
  }

  @Override
  public void setLeftTitleButton(int lDrawableId, View.OnClickListener listener) {
    mTitleBarInterface.setLeftTitleButton(lDrawableId, listener);
  }

  @Override
  public void setRightImgButton(int rDrawableId, View.OnClickListener listener) {
    mTitleBarInterface.setRightImgButton(rDrawableId, listener);
  }

  @Override
  public void setRightImgButtonVisible(boolean visible) {
    mTitleBarInterface.setRightImgButtonVisible(visible);
  }

  @Override
  public void setRightTextButton(int textId, View.OnClickListener listener) {
    mTitleBarInterface.setRightTextButton(textId, listener);
  }

  @Override
  public void setRightTextButtonTextColor(int colorId) {
    mTitleBarInterface.setRightTextButtonTextColor(colorId);
  }

  @Override
  public void setRightTextButtonVisible(boolean visible) {
    mTitleBarInterface.setRightTextButtonVisible(visible);
  }

  @Override
  public void setMiddleTitle(int titleId) {
    mTitleBarInterface.setMiddleTitle(titleId);
  }

  @Override
  public void setMiddleTitle(CharSequence titleStr) {
    mTitleBarInterface.setMiddleTitle(titleStr);
  }

  @Override
  public void setMiddleTitleDrawable(int drawableId) {
    mTitleBarInterface.setMiddleTitleDrawable(drawableId);
  }

  @Override
  public void setTitle(int textTitle, int lDrawableId, int rImgBtnSrc, int rTextBtnSrc) {
    mTitleBarInterface.setTitle(textTitle, lDrawableId, rImgBtnSrc, rTextBtnSrc);
  }

  @Override
  public void setTitleBarTabs(SegmentControl.OnSegmentControlClickListener listener, String...
      texts) {
    mTitleBarInterface.setTitleBarTabs(listener, texts);
  }

  @Override
  public boolean initializeTitleBar() {
    return false;
  }

  @Override
  public TitleBar.TitleBarStyle getTitleBarStyle() {
    return TitleBar.TitleBarStyle.NORMAL;
  }

  @Override
  public int getContentContainerBgId() {
    return mTitleBarInterface.getContentContainerBgId();
  }

  @Override
  public void setTitleBarBackground(int backgroundId) {
    mTitleBarInterface.setTitleBarBackground(backgroundId);
  }

  @Override
  public void setTitleBarVisible(boolean isVisible) {
    mTitleBarInterface.setTitleBarVisible(isVisible);
  }

  @Override
  public boolean getTitleBarVisible() {
    return mTitleBarInterface.getTitleBarVisible();
  }

  @Override
  public void setTitleBarTextColor(int color) {
    mTitleBarInterface.setTitleBarTextColor(color);
  }


  public void showLoadingDialog() {
    if (mLoadingDialog == null) {
      mLoadingDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
      mLoadingDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.colorPrimary));
      mLoadingDialog.setCancelable(false);
      mLoadingDialog.setTitleText("数据加载中...");
    }
    mLoadingDialog.show();
  }

  public void dismissLoadingDialog() {
    if (mLoadingDialog != null) {
      mLoadingDialog.dismiss();
    }
  }
}
