package com.loonggg.androidframedemo.manager;


public class UserInfoChangedEvent {
  public boolean changeSuccess = true;

  public UserInfoChangedEvent(boolean changeSuccess) {
    this.changeSuccess = changeSuccess;
  }

  public UserInfoChangedEvent() {
  }
}
