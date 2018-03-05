package com.demo.longzongjia.daggerdemo.di.component;

import android.app.Application;

import com.demo.longzongjia.daggerdemo.api.GitHubApi;
import com.demo.longzongjia.daggerdemo.di.moudle.ApiMoudle;
import com.demo.longzongjia.daggerdemo.di.moudle.AppMoudle;
import com.demo.longzongjia.daggerdemo.di.moudle.UtilsModule;
import com.demo.longzongjia.daggerdemo.utils.ThemeHelper;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by longzongjia on 2018/2/25.
 */

@Singleton
@Component(modules = {AppMoudle.class, ApiMoudle.class, UtilsModule.class})
public interface AppComponent {
    Application getApplication();

    Retrofit.Builder getRetrofit();

    ThemeHelper getThemeHelper();
}
