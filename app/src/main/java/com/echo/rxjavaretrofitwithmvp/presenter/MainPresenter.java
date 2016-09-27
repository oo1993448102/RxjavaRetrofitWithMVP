package com.echo.rxjavaretrofitwithmvp.presenter;

import com.echo.rxjavaretrofitwithmvp.entity.AnnexMode;
import com.echo.rxjavaretrofitwithmvp.imvp.IMainActivity;
import com.echo.rxjavaretrofitwithmvp.model.MainModel;
import com.echo.rxjavaretrofitwithmvp.subscribers.ProgressSubscriber;
import com.echo.rxjavaretrofitwithmvp.subscribers.SubscriberOnNextListener;

import java.util.List;

/**
 * Created by EchoZhou on 2016/8/4.
 */
public class MainPresenter implements IMainActivity.IMainPresenter {

    private IMainActivity.IMainView mView;
    private MainModel model;

    private SubscriberOnNextListener getTopMovieOnNext;

    private SubscriberOnNextListener second;


    private ProgressSubscriber subscriber;

    public MainPresenter(IMainActivity.IMainView mView){
        this.mView = mView;
        model = new MainModel();
    }

    @Override
    public void onDestory() {
        subscriber.onCancel();
    }

    @Override
    public void onCreate() {
        second = new SubscriberOnNextListener<List<AnnexMode>>() {   //不同请求
            @Override
            public void onSuccess(List<AnnexMode> subjects) {
                if(subjects != null) {
                    mView.showToast("2222");
                }
            }
        };
        getTopMovieOnNext = new SubscriberOnNextListener<List<AnnexMode>>() {
            @Override
            public void onSuccess(List<AnnexMode> subjects) {
                if(subjects != null) {
                    mView.updateListView(subjects);
                }
            }
        };


    }

    public void getMovie() {
        subscriber = new ProgressSubscriber(getTopMovieOnNext);
        model.getMovie(subscriber);
    }

    public void text() {
        subscriber = new ProgressSubscriber(second);
        model.getMovie(subscriber);
    }
}
