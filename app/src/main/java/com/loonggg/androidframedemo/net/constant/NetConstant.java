package com.loonggg.androidframedemo.net.constant;

/**
 * 服务器常量<BR>
 *
 */
public class NetConstant {
  public static final String URL_DOWNLOAD_APP = "http://192.168.1.114:8001/";

  //public static final String BASE_URL_LOCATION = "http://139.129.133.223/";
  public static final String BASE_URL_LOCATION = "http://192.168.1.114:8001/";
  //public static final String BASE_URL_LOCATION = "http://192.168.15.216:8080/carheadline/";
  public static final String BASE_URL_SERVICE_SUFFIX = "comm/procWS.action?businessNo=PH";
  public static final String BASE_URL = BASE_URL_LOCATION ;//+ BASE_URL_SERVICE_SUFFIX;

  //修云飞--图片加载之前添加的前缀
  public static final String URL_PICTURE = "http://47.93.117.61:8090/imageResult.create?path=";
  //修云飞--WebView网址加载之前添加的前缀
  public static final String URL_HTML= "http://47.93.117.61:8090/htmlResult.create?path=";
  //修云飞--上传到服务器的视频网址的拼接路径
  public static final String URL_VIDEO="http://47.93.117.61:8090/videoResult.create?path=";

  private NetConstant() {

  }

  public class HttpCodeConstant {
    public static final int UNKNOWN_ERROR = -1;
    public static final int SUCCESS = 200;
    public static final int HTTP_ERROR_NOT_FOUND = 404;
    public static final int SESSION_EXPIRED = 100;
  }
}
