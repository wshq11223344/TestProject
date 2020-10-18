package com.example.testpproject.rxjava;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RxLifecycleAndroid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate()");

//        setContentView(R.layout.activity_main);

        // Specifically bind this until onPause()
//        Observable.interval(1, TimeUnit.SECONDS)
//                .doOnDispose(new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        Log.i(TAG, "Unsubscribing subscription from onCreate()");
//                    }
//                })
////                .compose(bindUntilEvent(ActivityEvent.PAUSE))
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long num) throws Exception {
//                        Log.i(TAG, "Started in onCreate(), running until onPause(): " + num);
//                    }
//                });

//        test7();

        text4();
        System.out.println("=====往后执行");

    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume()");

        // `this.<Long>` is necessary if you're compiling on JDK7 or below.
        //
        // If you're using JDK8+, then you can safely remove it.
//        Observable.interval(1, TimeUnit.SECONDS)
//                .doOnDispose(new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        Log.i(TAG, "Unsubscribing subscription from onResume()");
//                    }
//                })
//                .compose(this.<Long>bindUntilEvent(ActivityEvent.DESTROY))
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long num) throws Exception {
//                        Log.i(TAG, "Started in onResume(), running until in onDestroy(): " + num);
//                    }
//                });

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy()");
    }


    public void test7() {

        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {

                int i = 0;
                while (i < 20) {
                    i++;
                    emitter.onNext(i);
                    Log.e("subscribe()===", String.valueOf(i));
                }


            }
        }, BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(5);

                    }

                    @Override
                    public void onNext(Integer integer) {
//                        System.out.println("onNext()===" + integer);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.e("onNext()===", String.valueOf(integer));
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                        Log.e("onNext()===", "complete");


                    }
                });

    }


    public void text4() {
        Observable.just(1, 2, 3)
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .delay(2, TimeUnit.SECONDS)
                .doOnDispose(new Action() {
                    @Override
                    public void run() throws Throwable {

                    }
                })
                .repeat(3)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        System.out.println("onSubscribe()");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("=====" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


}
