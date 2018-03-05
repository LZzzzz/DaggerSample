package com.demo.longzongjia.daggerdemo.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by longzongjia on 2018/2/25.
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PreActivity {
}
