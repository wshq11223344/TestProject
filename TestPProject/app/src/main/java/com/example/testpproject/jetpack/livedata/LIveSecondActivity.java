package com.example.testpproject.jetpack.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.testpproject.R;

public class LIveSecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_second);

        LiveDatas liveDatas = new ViewModelProvider(this).get(LiveDatas.class);


        liveDatas.loadData();

    }
}
