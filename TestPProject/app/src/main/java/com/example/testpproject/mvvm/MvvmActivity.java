package com.example.testpproject.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.os.Handler;

import com.example.testpproject.R;
import com.example.testpproject.databinding.ActivityMvvmBinding;

public class MvvmActivity extends AppCompatActivity {


    User user;

    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mvvm);

        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);


        //这些数据是model层来的
        user = new User("jett", "123", "http://e.hiphotos.baidu.com/image/pic/item/4610b912c8fcc3cef70d70409845d688d53f20f7.jpg");

        binding.setUser(user);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                user.setName("alan");
                user.setPassword("*******");

                user.setHeader("http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg");
            }
        }, 5000);


    }
}
