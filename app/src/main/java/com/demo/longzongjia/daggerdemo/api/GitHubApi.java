package com.demo.longzongjia.daggerdemo.api;

import com.demo.longzongjia.daggerdemo.mvp.model.entity.Follows;
import com.demo.longzongjia.daggerdemo.mvp.model.entity.GithubUser;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by longzongjia on 2018/2/25.
 */


public interface GitHubApi {
    @GET("/user/{user}")
    Observable<GithubUser> getUser(@Path("user") String userid);

    @GET("/users/{nickname}/followers")
    Observable<ArrayList<Follows>> getFollows(@Path("nickname") String nickname);
}
