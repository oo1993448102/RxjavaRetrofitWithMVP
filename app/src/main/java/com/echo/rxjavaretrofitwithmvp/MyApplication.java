package com.echo.rxjavaretrofitwithmvp;

import android.app.Application;

import com.echo.rxjavaretrofitwithmvp.http.BaseNet;

/**
 * Created by EchoZhou on 2016/8/4.
 */
public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        BaseNet.AppContext = getApplicationContext();
    }



}
