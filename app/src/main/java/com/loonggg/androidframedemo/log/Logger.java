package com.loonggg.androidframedemo.log;


import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;


public class Logger implements HttpLoggingInterceptor.Logger{
  public static void init() {
      Timber.plant(new CustomDebugTree());
    }

  public static void d(String tag, String message, Object... objects) {
    Timber.tag(tag);
    Timber.d(message, objects);
  }

  public static void i(String tag, String message, Object... objects) {
    Timber.tag(tag);
    Timber.i(message, objects);
  }

  public static void e(String tag, Throwable throwable, String message, Object... objects) {
    Timber.tag(tag);
    Timber.e(throwable, message, objects);
  }

  public static void e(String tag, String message, Object... objects) {
    Timber.tag(tag);
    Timber.e(message, objects);
  }

  public static void w(String tag, Throwable throwable, String message, Object... objects) {
    Timber.tag(tag);
    Timber.w(throwable, message, objects);
  }

  public static void w(String tag, String message, Object... objects) {
    Timber.tag(tag);
    Timber.w(message, objects);
  }

  @Override
  public void log(String message) {
    Timber.tag("Server");
    Timber.d(message);
  }
}
