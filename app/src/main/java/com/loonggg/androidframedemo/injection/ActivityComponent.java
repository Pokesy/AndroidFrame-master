package com.loonggg.androidframedemo.injection;

import com.squareup.otto.Bus;
import dagger.Component;

/**
 * [一句话功能简述]<BR>
 * [功能详细描述]
 *
 */
@ActivityScope
@Component(dependencies = GlobalComponent.class, modules = ActivityModule.class)
public interface ActivityComponent extends GlobalComponent {

  @ActivityBus
  Bus getActivityBus();

//  void inject(MainActivity activity);

}
