package com.loonggg.androidframedemo.net.rpc;

import android.text.TextUtils;

import com.loonggg.androidframedemo.log.Logger;
import com.loonggg.androidframedemo.net.constant.NetConstant;
import com.loonggg.androidframedemo.net.rpc.service.AppService;
import com.loonggg.androidframedemo.net.rpc.service.AuthService;
import com.loonggg.androidframedemo.net.rpc.service.UserService;
import com.loonggg.androidframedemo.utils.preference.CustomAppPreferences;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Retrofit 工厂类<BR>
 *
 */
public class RetrofitFactory {
  public static final String TAG = "RetrofitFactory";

  public static AppService createAppService() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(NetConstant.BASE_URL)
        .client(createNormalClient()).addConverterFactory(GsonConverterFactory.create()).
            addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers
                .newThread())).
            build();
    return retrofit.create(AppService.class);
  }

  public static UserService createUserService(CustomAppPreferences appPreferences) {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(NetConstant.BASE_URL)
        .client(createClient(appPreferences)).addConverterFactory(GsonConverterFactory.create()).
            addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers
                .newThread())).
            build();
    return retrofit.create(UserService.class);
  }

  public static AuthService createAuthService(CustomAppPreferences appPreferences) {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(NetConstant.BASE_URL)
        .client(createClient(appPreferences)).addConverterFactory(GsonConverterFactory.create()).
            addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers
                .newThread())).
            build();
    return retrofit.create(AuthService.class);
  }

  private static OkHttpClient createClient() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor
        .Logger() {

      @Override
      public void log(String message) {
        Logger.i(TAG, message);
      }
    });
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(new Interceptor() {
          @Override
          public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            MediaType mediaType = request.body().contentType();
            try {
              Field field = mediaType.getClass().getDeclaredField("mediaType");
              field.setAccessible(true);
              field.set(mediaType, "application/json");
            } catch (NoSuchFieldException e) {
              e.printStackTrace();
            } catch (IllegalAccessException e) {
              e.printStackTrace();
            }
            return chain.proceed(request);
          }
        })
        .addInterceptor(interceptor).build();
    return client;
  }

  private static OkHttpClient createNormalClient() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor
        .Logger() {

      @Override
      public void log(String message) {
        Logger.i(TAG, message);
      }
    });
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(interceptor).build();
    return client;
  }

  private static OkHttpClient createClient(final CustomAppPreferences preferences) {

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor
            .Logger() {

      @Override
      public void log(String message) {
        Logger.i(TAG, message);
      }
    });
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient httpClient = new OkHttpClient.Builder()
            .cookieJar(new CookieJar() {
              final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();

              @Override
              public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                cookieStore.put(url, cookies);
              }

              @Override
              public List<Cookie> loadForRequest(HttpUrl url) {
                List<Cookie> cookies = cookieStore.get(url);
                return cookies != null ? cookies : new ArrayList<Cookie>();
              }
            })
            .addInterceptor(new Interceptor() {
              @Override
              public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());
                System.out.println("---------->"+response.header("Set-Cookie"));
                Request request = chain.request();
                String sessionId = preferences.getString(CustomAppPreferences.KEY_COOKIE_SESSION_ID,
                        "");
                Request newRequest = request;
                if (!TextUtils.isEmpty(sessionId)) {
                  newRequest = request.newBuilder().addHeader("Cookie", "JSESSIONID=" +
                          sessionId).build();
                }
                return chain.proceed(newRequest);
              }
            })
            .addInterceptor(interceptor).build();
    return httpClient;
  }

}
