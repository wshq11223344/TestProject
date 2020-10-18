package com.example.testpproject.test;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IntentServiceTest extends IntentService {


    private static final String TAG = IntentServiceTest.class.getSimpleName();

    public IntentServiceTest() {
        super(TAG);
        Log.e(TAG, "IntentServiceTest创建");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
    }

    int count;


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        count++;

        Log.e(TAG, "onHandleIntent--->" + count);
    }


    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e(TAG, "onStart");
    }


    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        Log.e(TAG, "onStartCommand----" + "flag---->" + flags + "------startId---->" + startId);

        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e(TAG, "onDestroy");

    }
}
