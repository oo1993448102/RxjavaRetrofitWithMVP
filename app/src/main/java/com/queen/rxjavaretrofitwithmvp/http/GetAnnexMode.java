package com.queen.rxjavaretrofitwithmvp.http;

import com.queen.rxjavaretrofitwithmvp.entity.AnnexMode;
import com.queen.rxjavaretrofitwithmvp.entity.HttpResult;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by liukun on 16/3/9.
 */
public interface GetAnnexMode {

    @GET("Zhy/Order/MyAnnexMode")
    Observable<HttpResult<List<AnnexMode>>> getAnnexMode();
}
