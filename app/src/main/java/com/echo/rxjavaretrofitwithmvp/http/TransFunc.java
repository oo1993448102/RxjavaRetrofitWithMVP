package com.echo.rxjavaretrofitwithmvp.http;

import retrofit2.Response;
import rx.functions.Func1;

/**
 * Created by EchoZhou on 2016/9/27.
 *错误预处理
 */

public class TransFunc<T> implements Func1<Response<T>, T> {

    @Override
    public T call(Response<T> tResponse) {
        if (!tResponse.isSuccess()) {
            throw new ApiException(tResponse.code());
        }
        return tResponse.body();
    }
}
