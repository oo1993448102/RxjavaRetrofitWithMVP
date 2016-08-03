package com.queen.rxjavaretrofitdemo.http;

import com.queen.rxjavaretrofitdemo.entity.HttpResult;

import rx.functions.Func1;

/**
 * Created by EchoZhou on 2016/8/2.
 */

/**
 * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
 *
 * @param <T>   Subscriber真正需要的数据类型，也就是Data部分的数据类型
 */
public class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

    @Override
    public T call(HttpResult<T> httpResult) {
        if (!(httpResult.getCode()).equals("0")) {
            throw new ApiException(httpResult.getCode());
        }
        return httpResult.getData();
    }
}
