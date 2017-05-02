package com.loonggg.androidframedemo.net.rpc;

import android.content.Context;
import android.widget.Toast;
import com.loonggg.androidframedemo.injection.GlobalBus;
import com.squareup.otto.Bus;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Http错误提示统一处理类
 *
 */
@Singleton
public class HttpErrorUiNotifier {
  private final Context context;
  private final Bus rootBus;
  private Toast toast;

  @Inject
  public HttpErrorUiNotifier(Context context, @GlobalBus Bus rootBus) {
    this.context = context;
    this.rootBus = rootBus;
  }

  public void notifyUi(RpcHttpError httpError) {
    int errorCode = httpError.getHttpCode();
    // TODO 根据业务需要处理
    //if (errorCode == 503) {
    //  rootBus.post(new ServerUpheldEvent(httpError.getMessage()));
    //} else if (NetworkTypeUtils.getNetworkType(context) == NetworkType.NONE) {
    //  showHttpErrorToast(context, context.getString(R.string.network_not_normal));
    //} else {
    //  showHttpErrorToast(context, context.getString(R.string.server_error));
    //}
    showHttpErrorToast(context.getApplicationContext(), httpError.getMessage());
  }

  private void showHttpErrorToast(Context context, String errorMsg) {
    if (toast != null) {
      toast.cancel();
    }
    toast = Toast.makeText(context.getApplicationContext(), errorMsg, Toast.LENGTH_SHORT);
    toast.show();
  }

  /**
   * 服务器维护的事件
   */
  public static class ServerUpheldEvent {
    private String mHtmlStr;

    public ServerUpheldEvent(String htmlStr) {
      this.mHtmlStr = htmlStr;
    }

    public String getHtmlStr() {
      return mHtmlStr;
    }
  }
}
