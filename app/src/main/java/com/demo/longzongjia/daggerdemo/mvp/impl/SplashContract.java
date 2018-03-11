package com.demo.longzongjia.daggerdemo.mvp.impl;

/**
 * Created by longzongjia on 2018/3/10.
 */

public class SplashContract {
    public interface IView {
        void enterApp();
    }

    public interface IPresenter {
        void setDelay();

        void unRegister();
    }

    public interface IModel {
        //TODO:网络请求
    }
}
