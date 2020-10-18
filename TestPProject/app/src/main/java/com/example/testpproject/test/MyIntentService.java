package com.example.testpproject.test;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // IntentService会使用单独的线程来执行该方法的代码
        // 该方法内执行耗时任务，比如下载文件，此处只是让线程等待20秒
        long endTime = System.currentTimeMillis() + 20 * 1000;
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
    }
}
