package com.demo.longzongjia.daggerdemo.di.moudle;

import android.app.Activity;
import android.app.Fragment;

import com.demo.longzongjia.daggerdemo.di.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by longzongjia on 2018/3/5.
 */
@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @PerFragment
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
