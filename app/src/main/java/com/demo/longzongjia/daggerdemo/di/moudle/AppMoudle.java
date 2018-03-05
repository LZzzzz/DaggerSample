package com.demo.longzongjia.daggerdemo.di.moudle;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by longzongjia on 2018/2/25.
 */

@Module
public class AppMoudle {
    private Application application;


    public AppMoudle(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application getApplication() {
        return application;
    }
}
