package com.demo.longzongjia.daggerdemo.mvp.presenter;

import android.app.Activity;
import android.util.Log;

import com.demo.longzongjia.daggerdemo.mvp.impl.SplashContract;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by longzongjia on 2018/3/10.
 */

public class SplashPresenter implements SplashContract.IPresenter {
    private static final String tag = "SplashPresenter";
    private SplashContract.IView splashView;
    private Disposable subscription;

    @Inject
    public SplashPresenter(Activity splashView) {
        this.splashView = (SplashContract.IView) splashView;
    }

    @Override
    public void setDelay() {
        System.out.println("123");
        System.out.println("123");
        subscription = Observable.timer(1500, TimeUnit.MILLISECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                splashView.enterApp();
            }
        });
    }

    @Override
    public void unRegister() {
        Log.e(tag, "是否已经反注册：" + subscription.isDisposed()+ "");
        //先判断是否已经反注册
        if (!subscription.isDisposed()) {
            Log.e(tag, "进行反注册");
            subscription.dispose();
            Log.e(tag, "是否已经反注册：" + subscription.isDisposed() + "");
        }
    }
}
