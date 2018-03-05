package com.demo.longzongjia.daggerdemo.di.moudle;

import com.demo.longzongjia.daggerdemo.di.scope.PreActivity;
import com.demo.longzongjia.daggerdemo.mvp.impl.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by longzongjia on 2018/3/5.
 */
@Module
public class ActivityMoudle {
    private MainContract.IView mView;

    public ActivityMoudle(MainContract.IView mView) {
        this.mView = mView;
    }

    @Provides
    @PreActivity
    MainContract.IView provideMainActivity(){
        return mView;
    }
}
