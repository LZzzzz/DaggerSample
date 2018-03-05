package com.demo.longzongjia.daggerdemo.di.moudle;

import com.demo.longzongjia.daggerdemo.utils.Url;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by longzongjia on 2018/2/25.
 */
@Module
public class ApiMoudle {

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofit() {
        Retrofit.Builder retrofit = new Retrofit.Builder()
                .baseUrl(Url.BASE_URL);
        return retrofit;
    }

//    @Provides
//    @Singleton

}
