package com.example.testpproject.fragments.composite;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.testpproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    NoScrollViewPager mViewPager;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;

    private List<Fragment> mFragmentList;
    private HomeFragment mHomeFragement;
    private DiscoverFragment mDiscoverFragment;
    private ContactFragment mContactFragmentt;
    private MyFragment mMyFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mFragmentList = new ArrayList<Fragment>();
        mHomeFragement = new HomeFragment();
        mDiscoverFragment = new DiscoverFragment();
        mContactFragmentt = new ContactFragment();
        mMyFragment = new MyFragment();

        mFragmentList.add(mHomeFragement);
        mFragmentList.add(mDiscoverFragment);
        mFragmentList.add(mContactFragmentt);
        mFragmentList.add(mMyFragment);

        bottomNavigation.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        bottomNavigation.getMenu().getItem(0).setChecked(true);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item_bottom_home:
                        mViewPager.setCurrentItem(0,false);
                        break;
                    case R.id.item_bottom_discover:
                        mViewPager.setCurrentItem(1,false);
                        break;
                    case R.id.item_bottom_contact:
                        mViewPager.setCurrentItem(2,false);
                        break;
                    case R.id.item_bottom_my:
                        mViewPager.setCurrentItem(3,false);
                        break;
                    default:
                        break;
                }
                // 这里注意返回true,否则点击失效
                return true;
            }
        });



//        预加载
        mViewPager.setOffscreenPageLimit(3);

        MyPagerAdapter mpa = new MyPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mFragmentList);

        mViewPager.setCanScroll(false);
//        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mViewPager.setAdapter(mpa);


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                Log.e("======", position + "");

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
