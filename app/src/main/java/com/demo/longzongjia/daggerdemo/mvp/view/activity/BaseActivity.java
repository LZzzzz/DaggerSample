package com.demo.longzongjia.daggerdemo.mvp.view.activity;

import android.support.v7.app.AppCompatActivity;

import com.demo.longzongjia.daggerdemo.di.component.AppComponent;

/**
 * Created by longzongjia on 2018/2/25.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract void setupActivityComponent(AppComponent appComponent);
}
