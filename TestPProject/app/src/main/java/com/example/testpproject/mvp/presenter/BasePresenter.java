package com.example.testpproject.mvp.presenter;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.testpproject.mvp.view.IBaseView;
import com.example.testpproject.mvp.view.IGirlView;

import java.lang.ref.WeakReference;

public class BasePresenter<T extends IBaseView> implements LifecycleObserver {


    //    持有view的弱引用
    WeakReference<T> iBaseView;

    public void attachView(T view) {

        this.iBaseView = new WeakReference<T>(view);
    }

    public void detachView() {

        if (iBaseView != null) {
            iBaseView.clear();
            iBaseView = null;
        }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void setOnStartListener() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void setOnStopListener() {

    }

}
