package com.demo.longzongjia.daggerdemo.di.component;

import com.demo.longzongjia.daggerdemo.di.moudle.FragmentModule;
import com.demo.longzongjia.daggerdemo.di.scope.PreFragment;
import com.demo.longzongjia.daggerdemo.widget.CardPickerDialog;

import dagger.Component;

/**
 * Created by longzongjia on 2018/3/5.
 */
@PreFragment
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(CardPickerDialog cardPickerDialog);
}
