package com.demo.longzongjia.daggerdemo.di.component;

import com.demo.longzongjia.daggerdemo.di.moudle.FragmentModule;
import com.demo.longzongjia.daggerdemo.di.scope.PerFragment;
import com.demo.longzongjia.daggerdemo.widget.CardPickerDialog;

import dagger.Component;

/**
 * Created by longzongjia on 2018/3/5.
 */
@PerFragment
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(CardPickerDialog cardPickerDialog);
}
