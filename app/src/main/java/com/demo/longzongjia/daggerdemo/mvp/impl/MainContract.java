package com.demo.longzongjia.daggerdemo.mvp.impl;

import com.demo.longzongjia.daggerdemo.mvp.model.entity.Follows;
import com.demo.longzongjia.daggerdemo.mvp.model.entity.GithubUser;

import java.util.ArrayList;

import io.reactivex.Observable;


/**
 * Created by longzongjia on 2018/2/26.
 */

public class MainContract {
    public interface IView {
        void initView();

        void showToast(String msg);

        void updateView(String nickname, String company, String blog);

        void showFollows(String msg);
    }

    public interface IPresenter {
        void searchUser(String username);

        void getFowllows(String nickname);
    }

    public interface IModel {
        Observable<GithubUser> getUser(String username);

        Observable<ArrayList<Follows>> getFowllows(String nickname);
    }
}
