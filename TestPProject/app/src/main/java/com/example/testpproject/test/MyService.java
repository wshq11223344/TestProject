package com.example.testpproject.test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {


    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 该方法内执行耗时任务可能导致ANR(Application Not Responding)异常
        long endTime = System.currentTimeMillis() + 30 * 1000;
        Log.e("======", "onStart");
        while (System.currentTimeMillis() < endTime) {
            synchronized (this) {
                try {
                    wait(endTime - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Log.e("======", "耗时任务执行完成");
        return START_STICKY;
    }
}
