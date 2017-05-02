package com.loonggg.androidframedemo.net.rpc;

/**
 * 服务器返回的错误信息<BR>
 *
 */
public class RpcApiError {
  private int mHttpCode;
  private String mMessage;

  public RpcApiError(int httpCode, String message) {
    mHttpCode = httpCode;
    mMessage = message;
  }

  public int getHttpCode() {
    return mHttpCode;
  }

  public String getMessage() {
    return mMessage;
  }
}
