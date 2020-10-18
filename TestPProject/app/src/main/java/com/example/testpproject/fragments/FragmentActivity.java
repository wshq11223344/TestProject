package com.example.testpproject.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.testpproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentActivity extends AppCompatActivity {

    @BindView(R.id.frag)
    Button frag;
    @BindView(R.id.data_btn)
    Button dataBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ButterKnife.bind(this);

        Log.e("======Activity", "onCreate");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        SecondFragment secondFragment = new SecondFragment();
        fragmentTransaction.add(R.id.fragment_container, secondFragment);


        Bundle bundle = new Bundle();
        bundle.putString("han", "我是Activity传过来的数据");
        bundle.putString("qi", "我是Activity传过来的数据2");

        secondFragment.setArguments(bundle);

        secondFragment.setmCallBack(new SecondFragment.ICallBack() {
            @Override
            public void callBack(int i) {

                Log.e("======", i + "");
            }
        });

        secondFragment.test();
        fragmentTransaction.commit();


        FirstFragment firstFragmentTest = (FirstFragment) fragmentManager.findFragmentById(R.id.firstFragment);

        dataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle1 = new Bundle();
                bundle1.putString("test", "发来的数据");
                firstFragmentTest.setArguments(bundle1);
                firstFragmentTest.test();
            }
        });


        FirstFragment firstFragment = new FirstFragment();
        frag.setOnClickListener((View view) -> {

            FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.replace(R.id.fragment_container, firstFragment);
//            transaction.addToBackStack(null);

            transaction.remove(secondFragment);

            //            if (!secondFragment.isHidden()) {
//
//                transaction.hide(secondFragment);
//            }

            Bundle bundle1 = new Bundle();
            bundle1.putString("test", "发来的数据");
            firstFragment.setArguments(bundle1);

            transaction.commit();
        });


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("======Activity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("======Activity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("======Activity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("======Activity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("======Activity", "onDestroy");
    }
}
