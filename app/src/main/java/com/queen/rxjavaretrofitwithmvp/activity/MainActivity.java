package com.queen.rxjavaretrofitwithmvp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.queen.rxjavaretrofitwithmvp.R;
import com.queen.rxjavaretrofitwithmvp.entity.AnnexMode;
import com.queen.rxjavaretrofitwithmvp.http.GetAnnexMode;
import com.queen.rxjavaretrofitwithmvp.http.HttpResultFunc;
import com.queen.rxjavaretrofitwithmvp.subscribers.ProgressSubscriber;
import com.queen.rxjavaretrofitwithmvp.subscribers.SubscriberOnNextListener;

import com.queen.rxjavaretrofitwithmvp.http.HttpMethods;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import rx.Observable;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.click_me_BN)
    Button clickMeBN;
    @Bind(R.id.result_TV)
    TextView resultTV;

    private SubscriberOnNextListener getTopMovieOnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getTopMovieOnNext = new SubscriberOnNextListener<List<AnnexMode>>() {
            @Override
            public void onNext(List<AnnexMode> subjects) {
                resultTV.setText(subjects.toString());
            }
        };
    }

    @OnClick(R.id.click_me_BN)
    public void onClick() {
        getMovie();
    }

    //进行网络请求
    private void getMovie(){
        Retrofit mRetrofit = HttpMethods.getInstance();
        GetAnnexMode mGetAnnexMode = mRetrofit.create(GetAnnexMode.class);
        Observable observable = mGetAnnexMode.getAnnexMode()
                .map(new HttpResultFunc<List<AnnexMode>>());
        HttpMethods.getObservable(observable,new ProgressSubscriber(getTopMovieOnNext, MainActivity.this));
    }
}
