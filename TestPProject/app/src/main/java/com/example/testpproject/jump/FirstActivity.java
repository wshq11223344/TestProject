package com.example.testpproject.jump;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testpproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirstActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first2);
        ButterKnife.bind(this);
//
    }

    public void jump(View view) {


//        Intent intent = new Intent(FirstActivity.this,Secondctivity.class);
        Intent intent = new Intent();
//        intent.setClass(this, Secondctivity.class);
//        intent.setComponent(new ComponentName(getPackageName(), "com.example.testpproject.jump.Secondctivity"));
        intent.setAction("Arthur");
//        intent.addCategory("android.intent.category.DEFAULT");
//        startActivity(intent);

        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(FirstActivity.this, tv, "123");


        startActivity(intent, transitionActivityOptions.toBundle());

    }
}