package com.example.testpproject.test;

import android.app.Activity;
import android.app.IntentService;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.IBinder;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testpproject.R;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TestActivity extends AppCompatActivity {


    public BindServiceTest mService;

    public TestReceiver testReceiver;

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            BindServiceTest.MyBinder myBinder = (BindServiceTest.MyBinder) service;

            mService = myBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {


            mService = null;


        }
    };


    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test2);

//        imageView = this.findViewById(R.id.image);
    }


    @Override
    protected void onStart() {
        super.onStart();

//        Intent intent = new Intent();
//        intent.setClass(getApplicationContext(), StatrServiceTest.class);
//        startService(intent);
//
//        for (int i = 0; i < 6; i++) {
//            startService(intent);
//        }
//
//        stopService(intent);


        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), BindServiceTest.class);
        bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);
//
//        for (int i = 0; i < 6; i++) {
//            bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);
//        }
//
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//
//                if (mService != null) {
//
//                    Log.e("BindServiceTest", mService.getCount() + "");
//
//                    mService = null;
//                    unbindService(serviceConnection);
//
//                } else {
//                    Log.e("BindServiceTest", "还没绑定");
//
//                }
//            }
//        }, 6000);


//        final Intent intent = new Intent();
//        intent.setClass(getApplicationContext(), IntentServiceTest.class);
//
//        startService(intent);
//
//        for (int i = 0; i < 8; i++) {
//            startService(intent);
//        }


//        Intent intent = new Intent(getApplicationContext(), MyIntentService.class);
//        startService(intent);


//        testReceiver = new TestReceiver();
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("123");
//        registerReceiver(testReceiver, intentFilter);


//        Intent intent = new Intent();
//        intent.setAction("123");
//        sendBroadcast(intent);


//        Intent intent = new Intent();
//        intent.setAction("123");
//        ComponentName componentName = new ComponentName(getPackageName(), TestReceiver.class.getName());
//        intent.setComponent(componentName);
//        sendBroadcast(intent);


//        sendHXBroadCast();

//        ActivityControl.getInstance().add(TestActivity.this);
//        ActivityControl.getInstance().close(this);

//        int stringExtra = intent.getIntExtra("123", 0);
//
//        Log.e("stringExtra", stringExtra + "==");
//


    }


    private void sendHXBroadCast() {
        Intent logIntent = new Intent();
        logIntent.setAction("123");
        PackageManager pm = this.getPackageManager();

        List<ResolveInfo> matches = pm.queryBroadcastReceivers(logIntent, 0);
        if (matches != null && matches.size() >= 1) {
            for (ResolveInfo resolveInfo : matches) {
                Intent intent = new Intent(logIntent);
                ComponentName cn = new ComponentName(
                        resolveInfo.activityInfo.applicationInfo.packageName,
                        resolveInfo.activityInfo.name);
                intent.setComponent(cn);
                this.sendBroadcast(intent);
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (testReceiver != null) {

            unregisterReceiver(testReceiver);


        }
    }
}
