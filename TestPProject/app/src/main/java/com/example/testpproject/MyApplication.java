package com.example.testpproject;

import android.app.Application;
import android.util.Log;

import com.example.testpproject.dagger2.component.DaggerMyComponent;
import com.example.testpproject.dagger2.component.MyComponent;
import com.example.testpproject.dagger2.module.DateBaseModule;
import com.example.testpproject.dagger2.module.HttpModule;
import com.example.testpproject.dagger2.present_di.DaggerPresentComponent;
import com.example.testpproject.dagger2.present_di.PresentModule;

public class MyApplication extends Application {


    private final String TAG = MyApplication.class.getSimpleName();

    private static MyApplication context;

    private static int count;

    private int i;


    public static MyApplication getInstance() {
        return context;
    }


    private MyComponent myComponent;

    @Override
    public void onCreate() {


        super.onCreate();

        Log.e("TAG", "MyApplication执行：" + count);

        context = this;

        myComponent = DaggerMyComponent.builder()
                .httpModule(new HttpModule())
                .dateBaseModule(new DateBaseModule())
                .presentComponent(DaggerPresentComponent.builder().presentModule(new PresentModule()).build())
                .build();
    }

    public MyComponent getAppComponent() {
        return myComponent;
    }


    public int getI() {
        i++;
        return i;
    }


    public void setI(int i) {

        this.i = i;
    }


}
