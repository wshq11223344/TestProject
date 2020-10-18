package com.example.testpproject.fragments.composite.viewpager2;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.testpproject.R;
import com.example.testpproject.fragments.composite.ContactFragment;
import com.example.testpproject.fragments.composite.DiscoverFragment;
import com.example.testpproject.fragments.composite.HomeFragment;
import com.example.testpproject.fragments.composite.MyFragment;
import com.example.testpproject.fragments.composite.livedata.FragmentLivedata;
import com.example.testpproject.fragments.composite.livedata.User;
import com.example.testpproject.statusbar.StatusBarUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Home2Activity extends AppCompatActivity {


    @BindView(R.id.viewpager2)
    ViewPager2 viewpager2;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;

    @BindView(R.id.home_btn)
    Button homeBtn;


    private List<Fragment> mFragmentList;
    private HomeFragment mHomeFragement;
    private DiscoverFragment mDiscoverFragment;
    private ContactFragment mContactFragmentt;
    private MyFragment mMyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        ButterKnife.bind(this);
        initStatus();
        StatusBarUtil.setImmersiveStatusBar(this, true);

        mFragmentList = new ArrayList<Fragment>();
        mHomeFragement = new HomeFragment();
        mDiscoverFragment = new DiscoverFragment();
        mContactFragmentt = new ContactFragment();
        mMyFragment = new MyFragment();

        mFragmentList.add(mHomeFragement);
        mFragmentList.add(mDiscoverFragment);
        mFragmentList.add(mContactFragmentt);
        mFragmentList.add(mMyFragment);

//        bottomNavigation.setItemIconTintList(null);
        bottomNavigation.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        Menu menu = bottomNavigation.getMenu();
        menu.getItem(0).setChecked(true);
//        menu.add(0, 1, 1, "资料");
//        MenuItem menuItem = menu.findItem(1);
//        menuItem.setIcon(R.drawable.selector_data);
//        menu.removeItem(R.id.item_bottom_my);


        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                Log.e("=====", menuItem.getTitle().toString());
                switch (menuItem.getItemId()) {

                    case R.id.item_bottom_home:
                        viewpager2.setCurrentItem(0, false);
                        break;
                    case R.id.item_bottom_discover:
                        viewpager2.setCurrentItem(1, false);
                        break;
                    case R.id.item_bottom_contact:
                        viewpager2.setCurrentItem(2, false);
                        break;
                    case R.id.item_bottom_my:
                        viewpager2.setCurrentItem(3, false);
                        break;
                    default:
                        break;
                }
                // 这里注意返回true,否则点击失效
                return true;
            }
        });


//        预加载
        viewpager2.setOffscreenPageLimit(3);

        Viewpager2Adapter mpa = new Viewpager2Adapter(this, mFragmentList);

//        viewpager2.setPageTransformer(new DepthPageTransformer());
        viewpager2.setUserInputEnabled(false);
        viewpager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
//        viewpager2.setLayoutDirection(ViewPager2.LAYOUT_DIRECTION_LTR);
        viewpager2.setAdapter(mpa);


        viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                Log.e("=======", position + "");
            }
        });

        mHomeFragement.setmCallBack((int position) -> {
            Log.e("=======", position + "");

            Bundle bundle = new Bundle();
            bundle.putString("123", position + "");
            mDiscoverFragment.setArguments(bundle);
            mDiscoverFragment.test();

        });


        livedata = new ViewModelProvider(this).get(FragmentLivedata.class);

        Log.e("=======", livedata.hashCode() + "");

        livedata.getUserMutableLiveData().observe(this, (User user) -> {

            Log.e("=======", user.toString());
            homeBtn.setText(user.getName());


        });

    }

    FragmentLivedata livedata;


    boolean flag;

    @OnClick(R.id.home_btn)
    public void onViewClicked() {

//        livedata.getMutableLiveData().setValue(new Random().nextInt(1000) + "");


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (!flag) {
                getWindow().setStatusBarColor(Color.BLACK);
                View decor = getWindow().getDecorView();
//        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_VISIBLE);

                flag = true;
            } else {
                getWindow().setStatusBarColor(Color.WHITE);
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

                flag = false;
            }


        }

    }


    private void initStatus() {
        //版本大于等于4.4
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //获取到状态栏设置的两条属性
            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
            //在4.4之后又有两种情况  第一种 4.4-5.0   第二种 5.0以上
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //第二种 5.0以上
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
                window.setStatusBarColor(0);
            } else {
                //第一种 4.4-5.0
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentStatus | flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }


        //---------------  不让内容填充状态栏-->3.在代码中设置padding值并且设置一个控件来代替状态栏  --------------------------
        //获取到根布局的view
        View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        //给根布局设置padding值
        rootView.setPadding(0, getStatusHeight(), 0, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //第二种 5.0以上
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            //第一种 4.4-5.0
            //获取到根布局
            ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
            View statusBar = new View(this);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusHeight());
            statusBar.setBackgroundColor(Color.RED);
            statusBar.setLayoutParams(layoutParams);
            decorView.addView(statusBar);
        }

    }

    /**
     * 获取状态栏的高度
     *
     * @return
     */
    public int getStatusHeight() {
        //获取到状态栏的资源ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        //如果获取到了
        if (resourceId > 0) {
            //就返回它的高度
            return getResources().getDimensionPixelSize(resourceId);
        }
        //否则返回0
        return 0;
    }
}
