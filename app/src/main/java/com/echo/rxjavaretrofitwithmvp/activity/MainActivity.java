package com.echo.rxjavaretrofitwithmvp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.echo.rxjavaretrofitwithmvp.R;
import com.echo.rxjavaretrofitwithmvp.entity.AnnexMode;
import com.echo.rxjavaretrofitwithmvp.imvp.IMainActivity;
import com.echo.rxjavaretrofitwithmvp.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMainActivity.IMainView {

    @Bind(R.id.click_me_BN)
    Button clickMeBN;
    @Bind(R.id.result_TV)
    ListView resultTV;


    private MainPresenter mMainPresenter;
    private List<AnnexMode> list = new ArrayList<AnnexMode>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainPresenter = new MainPresenter(this);
        adapter = new MyAdapter(this, list);
        resultTV.setAdapter(adapter);
        mMainPresenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        mMainPresenter.onDestory();
        super.onDestroy();
    }

    @OnClick(R.id.click_me_BN)
    public void onClick() {
        list.clear();
        adapter.updateListView(list);
        getMovie();
    }

    //进行网络请求
    private void getMovie() {
        mMainPresenter.getMovie();
    }

    @Override
    public void updateListView(List<AnnexMode> subjects) {
        list = subjects;
        adapter.updateListView(subjects);
    }
}
