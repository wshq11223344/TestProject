package com.example.testpproject.dagger2.component;


import android.app.Activity;

import com.example.testpproject.dagger2.AppScope;
import com.example.testpproject.dagger2.Test1Activity;
import com.example.testpproject.dagger2.Test2Activity;
import com.example.testpproject.dagger2.module.DateBaseModule;
import com.example.testpproject.dagger2.module.HttpModule;
import com.example.testpproject.dagger2.present_di.PresentComponent;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Component;


@AppScope
//@Singleton
@Component(modules = {DateBaseModule.class, HttpModule.class},
        dependencies = {PresentComponent.class})
public interface MyComponent {

    void injectTest1Activity(Test1Activity test1Activity);

    void injectTest2Activity(Test2Activity test2Activity);

}
