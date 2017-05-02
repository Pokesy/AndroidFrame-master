package com.loonggg.androidframedemo.net.rpc.service;

import com.loonggg.androidframedemo.net.rpc.model.ResponseModel;
import com.loonggg.androidframedemo.net.rpc.model.UserInfo;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface AuthService {
    //@GET("sms/send") Observable<Response<ResponseModel<String>>> getVerifyCode(
    //    @Body GetVerifyCodeParams params);

    @GET("sms/send/{mobileNo}")
    Observable<Response<ResponseModel<String>>> getVerifyCode(
            @Path("mobileNo") String mobileNo);


    @GET("sms/verify/{mobileNo}/{code}")
    Observable<Response<ResponseModel<String>>> loginWithVerifyCode(@Path("mobileNo") String mobileNo,
                                                                    @Path("code") String code);

    @GET("sms/verify/{mobileNo}/{code}")
    Observable<Response<ResponseModel<String>>> checkVerifyCode(@Path("mobileNo") String mobileNo,
                                                                @Path("code") String code);





    @GET("member/{userId}/{token}")
    Observable<Response<ResponseModel<UserInfo>>> getUserInfo(@Path("userId") int userId, @Path("token") String token);




}
