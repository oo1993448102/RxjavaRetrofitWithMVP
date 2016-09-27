package com.echo.rxjavaretrofitwithmvp.subscribers;

import android.widget.Toast;

import com.echo.rxjavaretrofitwithmvp.http.ApiException;
import com.echo.rxjavaretrofitwithmvp.BaseNet;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;
public class ProgressSubscriber<T> extends Subscriber<T> {

    private SubscriberOnNextListener mSubscriberOnNextListener;

    public ProgressSubscriber(SubscriberOnNextListener mSubscriberOnNextListener) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
    }

    /**
     * 订阅开始时调用
     * 显示ProgressDialog
     */
    @Override
    public void onStart() {
//        showProgressDialog();
    }

    /**
     * 完成，隐藏ProgressDialog
     */
    @Override
    public void onCompleted() {
//        dismissProgressDialog();
        onCancel();
    }

    /**
     * 对错误进行统一处理
     * 隐藏ProgressDialog
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            Toast.makeText(BaseNet.AppContext, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(BaseNet.AppContext, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else if(e instanceof ApiException) {
            Toast.makeText(BaseNet.AppContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
//        dismissProgressDialog();
        onCancel();
    }


    /**
     * 将onNext方法中的返回结果交给Activity或Fragment自己处理
     *
     * @param t 创建Subscriber时的泛型类型
     */
    @Override
    public void onNext(T t) {
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onSuccess(t);
        }
    }

    /**
     * 取消ProgressDialog的时候，取消对observable的订阅，同时也取消了http请求
     */
    public void onCancel() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }
}