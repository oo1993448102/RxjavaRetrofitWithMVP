package com.echo.rxjavaretrofitwithmvp.imvp;

import com.echo.rxjavaretrofitwithmvp.entity.AnnexMode;

import java.util.List;

/**
 * Created by EchoZhou on 2016/8/4.
 */
public class IMainActivity {
    public interface IMainView{
        void updateListView(List<AnnexMode> subjects);
    }

    public interface IMainPresenter{

        void onDestory();

        void onCreate();
    }
}
