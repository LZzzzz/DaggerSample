package com.demo.longzongjia.daggerdemo.di.component;

import com.demo.longzongjia.daggerdemo.di.moudle.ActivityMoudle;
import com.demo.longzongjia.daggerdemo.di.scope.PreActivity;
import com.demo.longzongjia.daggerdemo.mvp.view.activity.MainActivity;

import dagger.Component;

/**
 * Created by longzongjia on 2018/2/26.
 */

@PreActivity
@Component(dependencies = AppComponent.class, modules = ActivityMoudle.class)
public interface ActivityComponent {
    MainActivity inject(MainActivity mainActivity);
}
