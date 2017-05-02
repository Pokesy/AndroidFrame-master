package com.loonggg.androidframedemo.net.rpc;

/**
 * Http返回码封装类<BR>
 */
public class RpcHttpError {
  private int mHttpCode;
  private String mMessage;

  public RpcHttpError(int httpCode, String message) {
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
