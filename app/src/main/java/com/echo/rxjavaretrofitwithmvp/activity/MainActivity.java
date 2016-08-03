package com.echo.rxjavaretrofitwithmvp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.echo.rxjavaretrofitwithmvp.R;
import com.echo.rxjavaretrofitwithmvp.entity.AnnexMode;
import com.echo.rxjavaretrofitwithmvp.http.GetAnnexMode;
import com.echo.rxjavaretrofitwithmvp.http.HttpMethods;
import com.echo.rxjavaretrofitwithmvp.http.HttpResultFunc;
import com.echo.rxjavaretrofitwithmvp.subscribers.ProgressSubscriber;
import com.echo.rxjavaretrofitwithmvp.subscribers.SubscriberOnNextListener;

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
