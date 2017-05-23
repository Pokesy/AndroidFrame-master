package com.loonggg.androidframedemo.net.rpc.service;


import com.loonggg.androidframedemo.model.BannerModel;
import com.loonggg.androidframedemo.model.HomeNewsModel;
import com.loonggg.androidframedemo.model.RefreshModel;
import com.loonggg.androidframedemo.model.StaggeredModel;
import com.loonggg.androidframedemo.net.rpc.model.ResponseModel;
import com.loonggg.androidframedemo.net.rpc.model.TestInfoModel;


import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface AppService {

    @Multipart
    @POST("file/upload")
    Observable<Response<ResponseModel<String>>> upload(@Part MultipartBody.Part file);

    @GET("sms/verify/{mobileNo}/{code}/{code}")
    Observable<Response<ResponseModel<String>>> verifyCode(@Path("mobileNo") String mobileNo, @Path("code") String code);

    @DELETE("member/mycar/{userId}/{token}")
    Observable<Response<ResponseModel<String>>> deleteMyLoveCar(@Path("userId") String userId, @Path("token") String token, @Query("serialIds") String serialIds);

    @GET("weixin/query")
    Observable<Response<ResponseModel<TestInfoModel>>> getTestInfo(@Query("key") String key, @Query("pno")
            int page, @Query("ps") int pagesize, @Query("dtype") String type);

    //新闻列表接口
    @GET("comm/procWS.action")
    Observable<Response<ResponseModel<HomeNewsModel>>> getNewsList(@Query("businessNo") String businessNo, @Query("resultNum") int resultNum, @Query("procName")
            String procName, @Query("params") int news_type_id, @Query("params") int userid, @Query("params") int page);

    @GET("refreshlayout/api/defaultdata6.json")
    Call<List<RefreshModel>> loadInitDatas();

    @GET("refreshlayout/api/newdata{pageNumber}.json")
    Call<List<RefreshModel>> loadNewData(@Path("pageNumber") int pageNumber);

    @GET("refreshlayout/api/moredata{pageNumber}.json")
    Call<List<RefreshModel>> loadMoreData(@Path("pageNumber") int pageNumber);

    @GET("refreshlayout/api/staggered_default.json")
    Call<List<StaggeredModel>> loadDefaultStaggeredData();

    @GET("refreshlayout/api/staggered_new{pageNumber}.json")
    Call<List<StaggeredModel>> loadNewStaggeredData(@Path("pageNumber") int pageNumber);

    @GET("refreshlayout/api/staggered_more{pageNumber}.json")
    Call<List<StaggeredModel>> loadMoreStaggeredData(@Path("pageNumber") int pageNumber);

    @GET("banner/api/5item.json")
    Call<BannerModel> getBannerModel();
}
