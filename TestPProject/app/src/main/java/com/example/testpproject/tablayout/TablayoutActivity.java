package com.example.testpproject.tablayout;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testpproject.R;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TablayoutActivity extends AppCompatActivity {

    @BindView(R.id.tablayout)
    TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        ButterKnife.bind(this);


//        IndicatorLineUtil.getInstance().setIndicator(tablayout, 100, 100);


        tablayout.addTab(tablayout.newTab().setText("综合"));
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Log.e("被选中----->", tab.getText().toString() + "");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.e("被取消----->", tab.getText().toString() + "");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                Log.e("重复选中----->", tab.getText().toString() + "");

            }
        });

    }


}
