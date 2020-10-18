package com.example.testpproject.statusbar;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testpproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StatusBarActivity extends AppCompatActivity {

    @BindView(R.id.image_iv)
    ImageView imageIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar);
        ButterKnife.bind(this);

        initStatus();
        StatusBarUtil.setImmersiveStatusBar(this, true);
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


        //------------------  不让内容填充状态栏-->2.占位控件设置状态栏  -------------------------
//        //获取到view控件
//        View statusBar = findViewById(R.id.view);
//        //获取到它的Params对象
//        ViewGroup.LayoutParams layoutParams = statusBar.getLayoutParams();
//        //设置它的高度
//        layoutParams.height = getStatusHeight();
//        //设置layoutParams
//        statusBar.setLayoutParams(layoutParams);
//        //设置背景颜色
//        statusBar.setBackgroundColor(ContextCompat.getColor(this,R.color.darker_gray));

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

    /**
     * 获取到底部虚拟按键的高度
     *
     * @return
     */
    public int getNavigationBarHeight() {
        //获取到虚拟按键的资源ID
        int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        //如果获取到了
        if (resourceId > 0) {
            //就返回它的高度
            return getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }


    @OnClick(R.id.image_iv)
    public void onViewClicked() {

        getWindow().setStatusBarColor(Color.BLACK);
        View decor = getWindow().getDecorView();
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);



//        View decor = activity.getWindow().getDecorView();
//        if (dark) {
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        } else {
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//        }

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            //获取窗口区域
//            Window window = getWindow();
//            //获取StatusBar颜色值
//            int colorID = window.getStatusBarColor();
//            if (colorID == Color.WHITE) {
//                //设置状态栏颜色【我这里颜色随便写的】
//                window.setStatusBarColor(Color.parseColor("#000000"));
//                //设置显示为白色背景，黑色字体
//                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            } else {
//                //设置状态栏颜色【我这里颜色随便写的】
//                window.setStatusBarColor(Color.parseColor("#000000"));
//                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
//            }
//        }

    }
}
