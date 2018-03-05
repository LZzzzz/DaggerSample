package com.demo.longzongjia.daggerdemo.mvp.model;


import com.demo.longzongjia.daggerdemo.api.GitHubApi;
import com.demo.longzongjia.daggerdemo.mvp.model.entity.Follows;
import com.demo.longzongjia.daggerdemo.mvp.model.entity.GithubUser;
import com.demo.longzongjia.daggerdemo.gson.StringConverterFactory;
import com.demo.longzongjia.daggerdemo.mvp.impl.MainContract;
import com.demo.longzongjia.daggerdemo.utils.Url;

import java.util.ArrayList;

import javax.inject.Inject;


import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by longzongjia on 2018/2/26.
 */

public class MainModel implements MainContract.IModel {
    @Inject
    Retrofit.Builder builder;

    @Inject
    public MainModel() {
    }

    @Override
    public Observable<GithubUser> getUser(String username) {
        Retrofit retrofit = builder
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Url.BASE_URL)
                .build();
        GitHubApi gitHubApi = retrofit.create(GitHubApi.class);
        return gitHubApi.getUser(username);
    }

    @Override
    public Observable<ArrayList<Follows>> getFowllows(String nickname) {
        Retrofit retrofit = builder
                .addConverterFactory(StringConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Url.BASE_URL)
                .build();
        GitHubApi gitHubApi = retrofit.create(GitHubApi.class);
        return gitHubApi.getFollows(nickname);
    }
}
