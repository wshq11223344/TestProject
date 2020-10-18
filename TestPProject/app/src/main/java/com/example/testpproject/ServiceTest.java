package com.example.testpproject;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ServiceTest extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.e("SecondActivity", "onStartCommand");
        Log.e("SecondActivity", Thread.currentThread().getName());


        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("SecondActivity", "onCreate");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("SecondActivity", "onDestroy");

    }
}
