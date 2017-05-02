package com.loonggg.androidframedemo.app;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.loonggg.androidframedemo.injection.DaggerGlobalComponent;
import com.loonggg.androidframedemo.injection.GlobalComponent;
import com.loonggg.androidframedemo.injection.GlobalModule;
import com.loonggg.androidframedemo.log.Logger;
import com.loonggg.androidframedemo.net.rpc.service.AppService;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CustomApp extends Application {

    private GlobalComponent mGlobalComponent;
    private static CustomApp sInstance;
    private AppService mEngine;
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init();
        Fresco.initialize(this);
        sInstance = this;

        mEngine = new Retrofit.Builder()
                .baseUrl("http://7xk9dj.com1.z0.glb.clouddn.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(AppService.class);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());

        UMShareAPI.get(this);
        mGlobalComponent = DaggerGlobalComponent.builder().globalModule(new GlobalModule(this)).build();
    }

    {
        PlatformConfig.setWeixin("wx4b28c900e4abb857", "d5fb1227cc52230d2c8078d8533176de");
    }

    public static CustomApp getInstance() {
        return sInstance;
    }

    public AppService getEngine() {
        return mEngine;
    }
    public GlobalComponent getGlobalComponent() {
        return mGlobalComponent;
    }
}
