package com.example.testpproject.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

public class TestReceiver extends BroadcastReceiver {


    private final String TAG = TestReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

        if ("123".equals(intent.getAction())) {

            Log.e(TAG, "123");
        } else if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {

            Log.e(TAG, Intent.ACTION_BOOT_COMPLETED);
        }


    }


}
