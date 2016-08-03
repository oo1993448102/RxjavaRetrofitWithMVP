package com.queen.rxjavaretrofitdemo.entity;

/**
 * Created by liukun on 16/3/5.
 */
public class HttpResult<T> extends CodeMsg {
    private T Data;

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

}
