package com.echo.rxjavaretrofitwithmvp.model;

import com.echo.rxjavaretrofitwithmvp.entity.AnnexMode;
import com.echo.rxjavaretrofitwithmvp.http.HttpMethods;
import com.echo.rxjavaretrofitwithmvp.http.HttpResultFunc;
import com.echo.rxjavaretrofitwithmvp.http.iapi.GetAnnexMode;
import com.echo.rxjavaretrofitwithmvp.subscribers.ProgressSubscriber;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by EchoZhou on 2016/8/4.
 */
public class MainModel {

    public void getMovie(ProgressSubscriber subscriber) {
        Retrofit mRetrofit = HttpMethods.getInstance();
        GetAnnexMode mGetAnnexMode = mRetrofit.create(GetAnnexMode.class);
        Observable observable = mGetAnnexMode.getAnnexMode()
                .map(new HttpResultFunc<List<AnnexMode>>());
        HttpMethods.getObservable(observable,subscriber);
    }
}
