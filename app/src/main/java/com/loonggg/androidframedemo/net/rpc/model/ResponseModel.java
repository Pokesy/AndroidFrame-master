package com.loonggg.androidframedemo.net.rpc.model;


public class ResponseModel<T> extends BaseModel {

  private T data;
  public T getData() {
    return data;
  }
  public void setData(T data) {
    this.data = data;
  }


}
