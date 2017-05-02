package com.loonggg.androidframedemo.injection;

import android.app.Activity;
import com.squareup.otto.Bus;
import dagger.Module;
import dagger.Provides;


@Module
public class ActivityModule {
  private Activity mActivity;

  public ActivityModule(Activity activity) {
    mActivity = activity;
  }

  @Provides
  public Activity providesActivity() {
    return mActivity;
  }

  @Provides
  @ActivityBus
  public Bus providesActivityBus() {
    return new Bus();
  }
}
