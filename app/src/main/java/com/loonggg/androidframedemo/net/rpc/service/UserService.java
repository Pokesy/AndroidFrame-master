package com.loonggg.androidframedemo.net.rpc.service;

import com.loonggg.androidframedemo.net.rpc.model.ResponseModel;
import com.loonggg.androidframedemo.net.rpc.model.UserInfo;

import retrofit2.Response;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;


public interface UserService {

  @PUT("member/{userId}/{token}")
  Observable<Response<ResponseModel<UserInfo>>> updateUser(@Path("userId") int userId, @Path("token") String token);

}
