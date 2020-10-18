package com.example.testpproject.fragments;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.testpproject.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewpagerActivity extends AppCompatActivity {


    ViewPager mViewPager;
    List<Integer> mVpList;
    int mPreviousSelected = 2;
    ImageView[] imageViews;


    @BindView(R.id.tablayout)
    TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ButterKnife.bind(this);

        initView();
        initData();
        //设置ViewPager中两页之间的距离
//        mViewPager.setPageMargin(80);

        //  设置预加载的页数，我们知道默认情况下这个参数为1，也就是左右各预加载一页，但是我们这里要让左右各预加载两页
//        mViewPager.setOffscreenPageLimit(3);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, mVpList);

//        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());

//        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.setAdapter(viewPagerAdapter);

        mViewPager.setCurrentItem(mPreviousSelected);
        imageViews[mPreviousSelected].setBackgroundResource(R.drawable.point_red);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

//                Log.e("===onPageScrolled=====", position + "");
//                Log.e("==onPageScrolled======", positionOffset + "");
//                Log.e("==onPageScrolled======", positionOffsetPixels + "");
            }

            @Override
            public void onPageSelected(int position) {
//                Log.e("===onPageSelected=====", position + "");

                imageViews[mPreviousSelected].setBackgroundResource(R.drawable.point_gray);

                imageViews[position].setBackgroundResource(R.drawable.point_red);

                mPreviousSelected = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

//                Log.e("===rolStateChanged=====", state + "");
            }
        });


        tablayout.setupWithViewPager(mViewPager,false);
        tablayout.getTabAt(0).setText("最新");
        tablayout.getTabAt(1).setText("热门");
        tablayout.getTabAt(2).setText("历史");
        tablayout.getTabAt(3).setText("国际");
        tablayout.getTabAt(4).setText("军事");

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Log.e("被选中----->", tab.getText().toString() + "");

                mViewPager.setCurrentItem(tab.getPosition(), false);
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
        mViewPager = (ViewPager) findViewById(R.id.vp_test);

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
}
