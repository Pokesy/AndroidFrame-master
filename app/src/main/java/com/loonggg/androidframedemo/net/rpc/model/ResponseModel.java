package com.loonggg.androidframedemo.net.rpc.model;


public class ResponseModel<T> extends BaseModel {

  private T result;

  public T getResult() {
    return result;
  }

  public void setResult(T data) {
    this.result = data;
  }

}
