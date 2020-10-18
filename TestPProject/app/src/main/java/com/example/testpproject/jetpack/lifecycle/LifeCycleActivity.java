package com.example.testpproject.jetpack.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.telecom.TelecomManager;

import com.example.testpproject.R;


public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        getLifecycle().addObserver(new MyObserver());

//        getLifecycle().removeObserver(new MyObserver());
    }
}
