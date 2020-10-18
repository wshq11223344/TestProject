package com.example.testpproject.jetpack.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyObserver implements LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void connectListener() {

        Log.e("qiqi", "开始订阅");

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void disconnectListener() {

        Log.e("qiqi", "取消订阅");


    }

}
