package com.loonggg.androidframedemo.utils;

import com.google.gson.Gson;

/**
 * Json转换<BR>
 *
 */
public class JsonConverter {
  public static String objectToJson(Object obj) {
    String jsonStr = "";
    try {
      Gson gson = new Gson();
      jsonStr = gson.toJson(obj);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return jsonStr;
  }

  public static <T> T jsonToObject(Class<T> clazz, String json) {
    T t = null;
    try {
      Gson gson = new Gson();
      t = gson.fromJson(json, clazz);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return t;
  }
}
