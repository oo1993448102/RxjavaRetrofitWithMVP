package com.queen.rxjavaretrofitdemo.http;

import com.queen.rxjavaretrofitdemo.entity.AnnexMode;
import com.queen.rxjavaretrofitdemo.entity.HttpResult;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by liukun on 16/3/9.
 */
public interface GetAnnexMode {

//    @GET("top250")
//    Call<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);

//    @GET("top250")
//    Observable<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);

//    @GET("top250")
//    Observable<HttpResult<List<Subject>>> getTopMovie(@Query("start") int start, @Query("count") int count);

    @GET("Zhy/Order/MyAnnexMode")
    Observable<HttpResult<List<AnnexMode>>> getTopMovie();
}
