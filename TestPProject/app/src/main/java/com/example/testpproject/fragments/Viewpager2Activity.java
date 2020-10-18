package com.example.testpproject.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.testpproject.R;
import com.example.testpproject.fragments.composite.ZoomOutPageTransformer;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Viewpager2Activity extends AppCompatActivity {

    @BindView(R.id.vp_test2)
    ViewPager2 vpTest2;

    ImageView[] imageViews;

    List<Integer> mVpList;

    int mPreviousSelected = 2;

    int position;

    @BindView(R.id.tablayout)
    TabLayout tablayout;

    TabLayoutMediator tabLayoutMediator;

    ViewPager2.OnPageChangeCallback onPageChangeCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager2);
        ButterKnife.bind(this);

        initView();
        initData();

        ViewPager2Adapter viewPagerAdapter = new ViewPager2Adapter(this, mVpList);

        vpTest2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        vpTest2.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);


        onPageChangeCallback = new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                imageViews[mPreviousSelected].setBackgroundResource(R.drawable.point_gray);

                imageViews[position].setBackgroundResource(R.drawable.point_red);

                mPreviousSelected = position;

                Viewpager2Activity.this.position = position;

                Toast.makeText(Viewpager2Activity.this, position + "onPageSelected", Toast.LENGTH_SHORT).show();
            }
        };

        vpTest2.registerOnPageChangeCallback(onPageChangeCallback);

        imageViews[mPreviousSelected].setBackgroundResource(R.drawable.point_red);
//        vpTest2.setPageTransformer(new ZoomOutPageTransformer());
        vpTest2.setAdapter(viewPagerAdapter);
        vpTest2.setCurrentItem(mPreviousSelected, false);

        viewPagerAdapter.setOnItemClistListener((int position) -> {

            Toast.makeText(this, position + "", Toast.LENGTH_SHORT).show();
        });


        tabLayoutMediator = new TabLayoutMediator(tablayout, vpTest2, new TabLayoutMediator.TabConfigurationStrategy() {

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                Log.e("=======", position + "");
            }
        });

        tabLayoutMediator.attach();

        tablayout.getTabAt(0).setText("最新");
        tablayout.getTabAt(1).setText("热门");
        tablayout.getTabAt(2).setText("历史");
        tablayout.getTabAt(3).setText("国际");
        tablayout.getTabAt(4).setText("军事");


        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Log.e("被选中----->", tab.getText().toString() + "");

                vpTest2.setCurrentItem(tab.getPosition(), false);
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


    public void initView() {

        imageViews = new ImageView[5];
        imageViews[0] = (ImageView) findViewById(R.id.one);
        imageViews[1] = (ImageView) findViewById(R.id.two);
        imageViews[2] = (ImageView) findViewById(R.id.three);
        imageViews[3] = (ImageView) findViewById(R.id.four);
        imageViews[4] = (ImageView) findViewById(R.id.five);

    }

    public void initData() {

        mVpList = new ArrayList<Integer>();
        mVpList.add(R.drawable.start_i1);
        mVpList.add(R.drawable.start_i2);
        mVpList.add(R.drawable.start_i3);
        mVpList.add(R.drawable.start_i4);
        mVpList.add(R.drawable.start_i5);
    }

    @Override
    protected void onStop() {
        super.onStop();

        tabLayoutMediator.detach();
        vpTest2.unregisterOnPageChangeCallback(onPageChangeCallback);
    }
}
