package com.loonggg.androidframedemo.ui.serviceinjection;



import com.loonggg.androidframedemo.MainActivity;
import com.loonggg.androidframedemo.fragment.NewsFragment;
import com.loonggg.androidframedemo.manager.LoginSession;
import com.loonggg.androidframedemo.net.rpc.RpcCallManager;
import com.loonggg.androidframedemo.net.rpc.service.AppService;
import com.loonggg.androidframedemo.net.rpc.service.AuthService;
import com.loonggg.androidframedemo.net.rpc.service.UserService;
import com.loonggg.androidframedemo.ui.activity.NewsDetailActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 服务器接口 Component<BR>
 *
 */
@Singleton
@Component(modules = ServiceModule.class)
public interface ServiceComponent {
    RpcCallManager rpcCallManager();

    AppService appService();

    UserService userService();

    AuthService authService();

    void inject(LoginSession loginSession);


    void inject(MainActivity activity);
    void inject(NewsFragment fragment);
    /*--修云飞   详情页的注入--*/
    void inject(NewsDetailActivity activity);
}
