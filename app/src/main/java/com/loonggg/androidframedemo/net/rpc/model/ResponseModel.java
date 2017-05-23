package com.loonggg.androidframedemo.net.rpc.model;


public class ResponseModel<T> extends BaseModel {

  private T data;
  private int resultType;

  public int getResultType() {
    return resultType;
  }

  public void setResultType(int resultType) {
    this.resultType = resultType;
  }

  public T getData() {
    return data;
  }
  public void setData(T data) {
    this.data = data;
  }
}
