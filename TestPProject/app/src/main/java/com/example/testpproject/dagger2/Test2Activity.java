package com.example.testpproject.dagger2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.testpproject.MyApplication;
import com.example.testpproject.R;
import com.example.testpproject.dagger2.object.HttpObject;

import javax.inject.Inject;

public class Test2Activity extends AppCompatActivity {

    @Inject
    HttpObject httpObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        ((MyApplication) getApplication()).getAppComponent().injectTest2Activity(this);

        Log.e("hanqi", httpObject.hashCode() + "");

    }
}
