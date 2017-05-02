package com.loonggg.androidframedemo.injection;

import android.content.Context;

import com.loonggg.androidframedemo.manager.LoginSession;
import com.loonggg.androidframedemo.net.rpc.HttpErrorUiNotifier;
import com.loonggg.androidframedemo.net.rpc.SessionNotifier;
import com.loonggg.androidframedemo.utils.preference.CustomAppPreferences;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = GlobalModule.class)
public interface GlobalComponent {

    Context getApplicationContext();

    @GlobalBus
    Bus getGlobalBus();

    HttpErrorUiNotifier httpErrorUiNotifier();

    SessionNotifier sessionNotifier();

    CustomAppPreferences appPreferences();

    LoginSession loginSession();

    boolean isLogin();

}
