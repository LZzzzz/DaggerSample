package com.demo.longzongjia.daggerdemo.mvp.presenter;

import android.app.Activity;

import com.demo.longzongjia.daggerdemo.mvp.model.entity.Follows;
import com.demo.longzongjia.daggerdemo.mvp.model.entity.GithubUser;
import com.demo.longzongjia.daggerdemo.mvp.impl.MainContract;
import com.demo.longzongjia.daggerdemo.mvp.model.MainModel;


import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by longzongjia on 2018/2/26.
 */

public class Mainpresenter implements MainContract.IPresenter {
    private MainContract.IView mainView;
    @Inject
    MainModel mainModel;

    @Inject
    public Mainpresenter(Activity mainView) {
        this.mainView = (MainContract.IView) mainView;
    }


    @Override
    public void searchUser(String username) {
        mainModel.getUser(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<GithubUser>() {
                    @Override
                    public void onNext(GithubUser githubUser) {
                        mainView.showToast("公司：" + githubUser.company);
                        mainView.updateView(githubUser.name, githubUser.company, githubUser.blog);
                        getFowllows(githubUser.name);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getFowllows(String nickname) {
        mainModel.getFowllows(nickname)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ArrayList<Follows>>() {
                    @Override
                    public void onNext(ArrayList<Follows> follows) {
                        StringBuffer sb = new StringBuffer("粉丝:");
                        for (Follows follow : follows) {
                            sb.append("\n").append(follow.login);
                        }
                        mainView.showFollows(sb.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
