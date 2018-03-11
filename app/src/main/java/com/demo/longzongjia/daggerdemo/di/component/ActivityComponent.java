package com.demo.longzongjia.daggerdemo.di.component;

import com.demo.longzongjia.daggerdemo.di.moudle.ActivityMoudle;
import com.demo.longzongjia.daggerdemo.di.scope.PerActivity;
import com.demo.longzongjia.daggerdemo.mvp.view.activity.MainActivity;
import com.demo.longzongjia.daggerdemo.mvp.view.activity.SplashActivity;

import dagger.Component;

/**
 * Created by longzongjia on 2018/2/26.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityMoudle.class)
public interface ActivityComponent {
    SplashActivity inject(SplashActivity splashActivity);

    MainActivity inject(MainActivity mainActivity);
}
