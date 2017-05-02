package com.loonggg.androidframedemo.net.constant;

/**
 * 服务器常量<BR>
 *
 */
public class NetConstant {
  public static final String URL_DOWNLOAD_APP = "http://192.168.0.1";

  //public static final String BASE_URL_LOCATION = "http://139.129.133.223/";
  public static final String BASE_URL_LOCATION = "http://v.juhe.cn/";
  //public static final String BASE_URL_LOCATION = "http://192.168.15.216:8080/carheadline/";
  public static final String BASE_URL_SERVICE_SUFFIX = "api/";
  public static final String BASE_URL = BASE_URL_LOCATION ;//+ BASE_URL_SERVICE_SUFFIX;

  private NetConstant() {

  }

  public class HttpCodeConstant {
    public static final int UNKNOWN_ERROR = -1;
    public static final int SUCCESS = 200;
    public static final int HTTP_ERROR_NOT_FOUND = 404;
    public static final int SESSION_EXPIRED = 100;
  }
}
