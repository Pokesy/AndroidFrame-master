package com.loonggg.androidframedemo.injection;

import android.content.Context;

import com.loonggg.androidframedemo.app.CustomApp;
import com.loonggg.androidframedemo.manager.LoginSession;
import com.loonggg.androidframedemo.utils.preference.CustomAppPreferences;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GlobalModule {
  private CustomApp mApplication;

  public GlobalModule(CustomApp app) {
    mApplication = app;
  }

  @Singleton
  @Provides
  public Context providesApplicationContext() {
    return mApplication;
  }

  @Singleton
  @Provides
  @GlobalBus
  public Bus providesGlobalBus() {
    return new Bus();
  }

  @Singleton
  @Provides
  public CustomAppPreferences providesGlobalPreferences() {
    return new CustomAppPreferences(mApplication);
  }
  @Provides
  public boolean providesLoginStatus(CustomAppPreferences preferences) {
    String type = preferences.getString(CustomAppPreferences.KEY_USER_TYPE, "");
    int uid = preferences.getInt(CustomAppPreferences.KEY_USER_ID, 0);
    return  uid > 0;
  }
  @Provides
  @Singleton
  public LoginSession providesLoginSession() {
    return new LoginSession(mApplication);
  }

}
