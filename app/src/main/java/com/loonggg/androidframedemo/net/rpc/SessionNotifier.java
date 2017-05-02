package com.loonggg.androidframedemo.net.rpc;

import android.content.Context;
import android.widget.Toast;
import com.loonggg.androidframedemo.injection.GlobalBus;
import com.squareup.otto.Bus;
import javax.inject.Inject;

public class SessionNotifier {
  private Bus mGlobalBus;
  private Context mContext;
  private Toast mToast;

  @Inject
  public SessionNotifier(Context context, @GlobalBus Bus bus) {
    this.mGlobalBus = bus;
    this.mContext = context;
  }

  public void notifySessionExpired() {
    //showShortToast(R.string.session_expired);
    //((CustomApp) mContext.getApplicationContext()).getGlobalComponent().loginSession().logout();
  }

  private void showShortToast(int msg) {
    if (null != mToast) {
      mToast.cancel();
    }
    mToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
    mToast.show();
  }
}
