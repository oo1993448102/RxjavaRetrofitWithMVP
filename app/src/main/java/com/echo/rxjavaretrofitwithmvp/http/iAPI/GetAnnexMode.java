package com.echo.rxjavaretrofitwithmvp.http.iapi;




import com.echo.rxjavaretrofitwithmvp.entity.AnnexMode;
import com.echo.rxjavaretrofitwithmvp.entity.HttpResult;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface GetAnnexMode {

    @GET("Zhy/Order/MyAnnexMode")
    Observable<HttpResult<List<AnnexMode>>> getAnnexMode();
}
