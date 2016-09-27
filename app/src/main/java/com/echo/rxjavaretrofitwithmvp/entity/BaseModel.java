package com.echo.rxjavaretrofitwithmvp.entity;

import com.echo.rxjavaretrofitwithmvp.util.PrettyJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

/**
 * Created by EchoZhou on 2016/9/27.
 */
public class BaseModel implements Serializable {

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = gson.toJson(this);
        String pretty = PrettyJson.getPretty(json);
        return this.getClass().getSimpleName() + pretty;
    }
}
