package com.demo.longzongjia.daggerdemo.di.moudle;



import android.app.Activity;

import com.demo.longzongjia.daggerdemo.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by longzongjia on 2018/3/5.
 */
@Module
public class ActivityMoudle {
    private Activity mView;

    public ActivityMoudle(Activity mView) {
        this.mView = mView;
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return mView;
    }
}
