package com.demo.longzongjia.daggerdemo.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.demo.longzongjia.App;
import com.demo.longzongjia.daggerdemo.di.component.AppComponent;
import com.demo.longzongjia.daggerdemo.di.component.DaggerActivityComponent;
import com.demo.longzongjia.daggerdemo.di.moudle.ActivityMoudle;
import com.demo.longzongjia.daggerdemo.mvp.impl.SplashContract;
import com.demo.longzongjia.daggerdemo.mvp.presenter.SplashPresenter;

import javax.inject.Inject;

/**
 * Created by longzongjia on 2018/3/10.
 */

public class SplashActivity extends BaseActivity implements SplashContract.IView {
    @Inject
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(App.getApplication(this).getAppComponent());
    }


    @Override
    public void enterApp() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityMoudle(new ActivityMoudle(this))
                .build()
                .inject(this);
        splashPresenter.setDelay();
    }
}
