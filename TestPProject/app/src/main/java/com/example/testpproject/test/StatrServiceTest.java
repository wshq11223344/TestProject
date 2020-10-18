package com.example.testpproject.test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class StatrServiceTest extends Service {

    private static final String TAG = StatrServiceTest.class.getSimpleName();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.e(TAG, "onBind");

        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e(TAG, "onStartCommand");


        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e(TAG, "onDestroy");

    }
}
