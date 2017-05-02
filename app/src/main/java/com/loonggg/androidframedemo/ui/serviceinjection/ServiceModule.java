package com.loonggg.androidframedemo.ui.serviceinjection;

import com.loonggg.androidframedemo.injection.GlobalModule;
import com.loonggg.androidframedemo.net.rpc.RetrofitFactory;
import com.loonggg.androidframedemo.net.rpc.RpcCallManager;
import com.loonggg.androidframedemo.net.rpc.service.AppService;
import com.loonggg.androidframedemo.net.rpc.service.AuthService;
import com.loonggg.androidframedemo.net.rpc.service.UserService;
import com.loonggg.androidframedemo.utils.preference.CustomAppPreferences;

import dagger.Module;
import dagger.Provides;

/**
 * 服务器接口 Module<BR>
 *

 */
@Module(includes = GlobalModule.class)
public class ServiceModule {

  @Provides
  public AppService providesAppService() {
    return RetrofitFactory.createAppService();
  }
  //@Provides
  //public AdvertisementService providesAdvertisementService() {
  //  return RetrofitFactory.createAdvertisementService();
  //}
  @Provides
  public RpcCallManager providerRpcCallManager() {
    return new RpcCallManager.RpcCallManagerImpl();
  }

  @Provides
  public UserService providesUserService(CustomAppPreferences appPreferences) {
    return RetrofitFactory.createUserService(appPreferences);
  }

  @Provides
  public AuthService providesAuthService(CustomAppPreferences appPreferences) {
    return RetrofitFactory.createAuthService(appPreferences);
  }
}

