package com.example.testpproject;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.storage.StorageManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testpproject.hotrepair.utils.FileUtils;
import com.example.testpproject.hotrepair.utils.FixDexUtils;
import com.example.testpproject.hotrepair.utils.TestActivity;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MyApplication.getInstance().getI();
//
//        MyApplication.getInstance().setI(0);
//
        int i = MyApplication.getInstance().getI();
        Log.e("i==", i + "");


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            if (checkSelfPermission(perms[0]) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(perms, 200);
            }
        }


        imageView = this.findViewById(R.id.image);

        textView = findViewById(R.id.text);

//        Log.e("SecondActivity", getIntent().getIntExtra("123", 0) + "");
//
//
//

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                stopService(new Intent(getApplicationContext(), ServiceTest.class));

//                String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
//
//                Glide.with(MainActivity.this).load(url).into(imageView);
//                startActivity(new Intent(MainActivity.this, SecondActivity.class));
//
                startActivity(new Intent(MainActivity.this, GlideActivity.class));
            }
        });


//        getMemorySize();

//        fixBug();

//        test_1();


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                Handler handler = new Handler(getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        textView.setText("456");

                    }
                });

            }
        }, 2000);

    }


    public void test_1() {

        File file = new File(getStoragePath(this, false) + "/test.txt");


        Log.e("file==", getStoragePath(this, false));


        if (file.exists()) {

            file.delete();
        }

        if (!file.getParentFile().exists()) {

            file.getParentFile().mkdirs();

        }


        try {
            boolean newFile = file.createNewFile();

            System.out.println(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private void fixBug() {
        //1 从服务器下载dex文件 比如v1.1修复包文件（classes2.dex）
        File sourceFile = new File(getStoragePath(this, false), "classes2.dex");
        // 目标路径：私有目录
        //getDir("odex", Context.MODE_PRIVATE) data/user/0/包名/app_odex
        File targetFile = new File(getDir("odex",
                Context.MODE_PRIVATE).getAbsolutePath() + File.separator + "classes2.dex");
        if (targetFile.exists()) {
            targetFile.delete();
        }
        try {
            // 复制dex到私有目录
            FileUtils.copyFile(sourceFile, targetFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
//        Toast.makeText(this, "复制到私有目录完成", Toast.LENGTH_SHORT).show();
        FixDexUtils.loadFixedDex(this);


    }


    /**
     * 通过反射调用获取内置存储和外置sd卡根路径(通用)
     *
     * @param mContext    上下文
     * @param is_removale 是否可移除，false返回内部存储，true返回外置sd卡
     * @return
     */
    private String getStoragePath(Context mContext, boolean is_removale) {
        StorageManager mStorageManager = (StorageManager) mContext.getSystemService(Context.STORAGE_SERVICE);
        Class<?> storageVolumeClazz = null;
        String path = "";
        try {
            storageVolumeClazz = Class.forName("android.os.storage.StorageVolume");
            Method getVolumeList = mStorageManager.getClass().getMethod("getVolumeList");
            Method getPath = storageVolumeClazz.getMethod("getPath");
            Method isRemovable = storageVolumeClazz.getMethod("isRemovable");
            Object result = getVolumeList.invoke(mStorageManager);
            final int length = Array.getLength(result);
            for (int i = 0; i < length; i++) {
                Object storageVolumeElement = Array.get(result, i);
                path = (String) getPath.invoke(storageVolumeElement);
                boolean removable = (Boolean) isRemovable.invoke(storageVolumeElement);
                if (is_removale == removable) {
                    return path;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return path;
    }


    public void getMemorySize() {


        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        //最大分配内存
        int memory = activityManager.getMemoryClass();
        System.out.println("memory: " + memory);
        //最大分配内存获取方法2
        float maxMemory = (float) (Runtime.getRuntime().maxMemory() * 1.0 / (1024 * 1024));
        //当前分配的总内存
        float totalMemory = (float) (Runtime.getRuntime().totalMemory() * 1.0 / (1024 * 1024));
        //剩余内存
        float freeMemory = (float) (Runtime.getRuntime().freeMemory() * 1.0 / (1024 * 1024));
        System.out.println("maxMemory: " + maxMemory);
        System.out.println("totalMemory: " + totalMemory);
        System.out.println("freeMemory: " + freeMemory);
    }
}
