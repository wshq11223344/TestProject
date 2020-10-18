package com.example.testpproject.test;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class BindServiceTest extends Service {

    private MyBinder myBinder = new MyBinder();
    private boolean quit;
    private int count;

    private static final String TAG = BindServiceTest.class.getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {


        Log.e(TAG, "onBind");

        return myBinder;
    }


    public class MyBinder extends Binder {


        protected BindServiceTest getService() {

            return BindServiceTest.this;

        }

    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (!quit) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    count++;
                }


            }
        }).start();

    }


    public int getCount() {
        return count;

    }


    @Override
    public boolean onUnbind(Intent intent) {

        Log.e(TAG, "onUnbind");


        return super.onUnbind(intent);
    }


    @Override
    public void onDestroy() {

        this.quit = true;

        super.onDestroy();

        Log.e(TAG, "onDestroy");

    }
}
