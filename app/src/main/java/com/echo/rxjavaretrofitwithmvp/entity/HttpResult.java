package com.echo.rxjavaretrofitwithmvp.entity;


import com.echo.rxjavaretrofitwithmvp.util.PrettyJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HttpResult<T> extends CodeMsg {
    private T Data;

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(this);
        String pretty = PrettyJson.getPretty(json);
        return this.getClass().getSimpleName() + pretty;
    }

}
