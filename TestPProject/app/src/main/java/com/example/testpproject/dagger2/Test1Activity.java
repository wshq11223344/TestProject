package com.example.testpproject.dagger2;

import androidx.annotation.IntDef;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.testpproject.MyApplication;
import com.example.testpproject.R;
import com.example.testpproject.dagger2.module.DateBaseModule;
import com.example.testpproject.dagger2.module.HttpModule;
import com.example.testpproject.dagger2.object.DateBaseObject;
import com.example.testpproject.dagger2.object.HttpObject;
import com.example.testpproject.dagger2.present_di.PresentComponent;
import com.example.testpproject.dagger2.present_di.PresentModule;
import com.example.testpproject.dagger2.present_di.PresentObject;

import javax.inject.Inject;


public class Test1Activity extends AppCompatActivity {

    @Inject
    DateBaseObject dateBaseObject;

    @Inject
    DateBaseObject dateBaseObject1;

    @Inject
    HttpObject httpObject;

    @Inject
    HttpObject httpObject1;

    @Inject
    PresentObject presentObject;

    @Inject
    PresentObject presentObject1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        Class<Test1Activity> test1ActivityClass = Test1Activity.class;



        ((MyApplication) getApplication()).getAppComponent().injectTest1Activity(this);


        Log.e("hanqi", dateBaseObject.hashCode() + "");
        Log.e("hanqi", dateBaseObject1.hashCode() + "");

        Log.e("hanqi", httpObject.hashCode() + "");
        Log.e("hanqi", httpObject1.hashCode() + "");

        Log.e("hanqi", presentObject.hashCode() + "");
        Log.e("hanqi", presentObject1.hashCode() + "");

    }

    public void jump(View view) {

        startActivity(new Intent(this, Test2Activity.class));
    }
}
