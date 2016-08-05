package com.echo.rxjavaretrofitwithmvp.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HttpMethods {

    private static Retrofit retrofit;

    //获取单例
    public static Retrofit getInstance(){
        if(retrofit == null){
            new HttpMethods();
        }
        return retrofit;
    }

    //构造方法私有
    private HttpMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(BaseNet.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.addInterceptor(new Interceptor() {   //拦截器
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();
                    builder.addHeader("X-LC-Sign", "FB87E3ADB06EAFD590BD2CD452EA57483964557A34908E3D");

                builder.addHeader("X-LC-Token", "804E07E34815814782EE57A92D6DE3EE52412A27DA8EFB749659D3050C765268124D1C9B573FCD22");

                return chain.proceed(builder.build());
            }
        });

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BaseNet.BASE_URL)
                .build();
    }

    public static void getObservable(Observable observable ,Subscriber subscriber ){
        toSubscribe(observable, subscriber);
    }

    private static <T> void toSubscribe(Observable<T> o, Subscriber<T> s){
         o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())  //订阅运行于主线程中
                .subscribe(s);  //注册 subscriber
    }

}
