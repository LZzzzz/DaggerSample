package com.demo.longzongjia.daggerdemo.di.moudle;

import com.demo.longzongjia.daggerdemo.utils.ThemeHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by longzongjia on 2018/3/4.
 */
@Module
public class UtilsModule {
    @Provides
    @Singleton
    ThemeHelper provideThemeHelper(){
        return new ThemeHelper();
    }
}
