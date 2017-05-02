package com.loonggg.androidframedemo.ui.boot;

import android.content.Intent;
import android.os.Bundle;
import com.loonggg.androidframedemo.ui.basic.BasicActivity;

/**
 * 主页<BR>
 *
 */
public class BootActivity extends BasicActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    dispatchForwardUi();
  }


  private void dispatchForwardUi() {
    Intent intent;
    if (getComponent().appPreferences().showGuideView()) {
//      intent = new Intent(this, LeadActivity.class);
    } else if (getComponent().isLogin()) {
//      intent = new Intent(this, MainTabActivity.class);
    } else {
//      intent = new Intent(this, LoginActivity.class);
    }
//    startActivity(intent);
    finish();
  }

}
