package com.example.testpproject;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SecondActivity extends AppCompatActivity {

    private final String TAG = SecondActivity.class.getSimpleName();

//    ActivityManager.MemoryInfo memoryInfo = getAvailableMemory();

    private ActivityManager.MemoryInfo getAvailableMemory() {
        ActivityManager activityManager = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    Bundle bundle;


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        bundle = outState;

        bundle.putParcelable("key", new Person("韩琦", "男", 27));

        System.out.println("person:" + "onSaveInstanceState执行");

    }


    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("person:" + "onStart执行");
        System.out.println("person:onStart:" + (bundle != null));

        if (bundle != null) {
            Person person = bundle.getParcelable("key");
            System.out.println("person" + person.toString());

        } else {
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("person:" + "onResume执行");


    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("person:" + "onPause执行");

    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("person:" + "onStop执行");


    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        System.out.println("person:" + "onCreatee执行");

        System.out.println("person:" + (savedInstanceState != null));


//        getWindow().getDecorView().setBackground(getResources().getDrawable(R.mipmap.index_daily_ban2));

        super.onCreate(savedInstanceState);

        verifyStoragePermissions(this);
        setContentView(R.layout.activity_second);

//
//        File file = new File(getStoragePath(getApplicationContext(), false), "app1.trace");
//        Log.i(TAG, "onCreate: " + file.getAbsolutePath());
//        //把分析结果存在一个文件
//        Debug.startMethodTracing(file.getAbsolutePath());
//
//
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//
//                Intent intent = new Intent();
//                intent.setClass(SecondActivity.this, MainActivity.class);
//                intent.putExtra("123", 1);
//                startActivity(new Intent(SecondActivity.this, MainActivity.class));
//                finish();
//
//            }
//        }, 3000);
//
//
//        Debug.stopMethodTracing();

//        startService(new Intent(getApplicationContext(), ServiceTest.class));
//        Log.e(TAG, "执行完了");
//        Log.e(TAG, Thread.currentThread().getName());


        SparseArray<String> sparseArray = new SparseArray<>(10);

        sparseArray.put(2, "123");
        sparseArray.append(3, "456");
        sparseArray.append(4, "789");


//        for (int i = 0; i < sparseArray.size(); i++) {
//
//            Log.e(TAG, sparseArray.valueAt(i));
//        }
//
//
//        for (int i = 0; i < sparseArray.size(); i++) {
//
//            int key = sparseArray.keyAt(i);
//
//            Log.e(TAG, sparseArray.get(key));
//
//
//        }

        Log.e("===", sparseArray.indexOfKey(2) + "");
        Log.e("===", sparseArray.indexOfValue("123") + "");


        sparseArray.remove(3);
        sparseArray.put(2, "hanqi");

        for (int i = 0; i < sparseArray.size(); i++) {

            Log.e("===", sparseArray.valueAt(i));


        }


//        Log.e(TAG, sparseArray.get(2));


        ArrayMap<Integer, String> arrayMap = new ArrayMap<Integer, String>(5);

        arrayMap.put(1, "123");
        arrayMap.put(2, "456");
        arrayMap.put(3, "789");

//        Log.e("===", arrayMap.indexOfKey(1) + "");
//        Log.e("===", arrayMap.indexOfValue("789") + "");


        for (int i = 0; i < arrayMap.size(); i++) {

            Log.e(TAG, arrayMap.valueAt(i));
        }

        for (int i = 0; i < arrayMap.size(); i++) {

            Log.e(TAG, arrayMap.get(arrayMap.keyAt(i)));

        }

//        Log.e(TAG, arrayMap.get(arrayMap.indexOfKey(1)));
//        Log.e(TAG, arrayMap.get(arrayMap.indexOfValue("789")));

        //        for (Integer integer : arrayMap.keySet()) {
//
//            Log.e(TAG, arrayMap.get(integer));
//
//        }


        ClassLoader classLoader = SecondActivity.class.getClassLoader();

        System.out.println("classLoader:" + classLoader.getClass().getName());


        ClassLoader parent = classLoader.getParent();

        System.out.println("parent:" + parent + "");

        ClassLoader parent1 = parent.getParent();

        System.out.println("parent1:" + parent1 + "");


        Handler handler = new Handler();


//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//
////                        Looper.prepare();
//
//                        Toast.makeText(SecondActivity.this, "run on thread", Toast.LENGTH_SHORT).show();
////                        Looper.loop();
//
//                    }
//                }).start();
//            }
//        }, 3000);


//        installApp(new File(getStoragePath(this, false), "test.apk"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            Log.e("========", getPackageManager().canRequestPackageInstalls() + "");

//            Uri uri = Uri.parse("package:"+getPackageName());
//            Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,uri);
//            startActivityForResult(intent, 19900);
        }

//        installAPK();


        TextView textView = null;
//
//        ImageView imageView = null;
//
//        imageView.setImageResource(R.mipmap.ic_launcher);
//
//        Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.ic_launcher);
//
//        imageView.setImageDrawable(drawable);
//

//        textView.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
//
//        textView.setText(getString(R.string.app_name));

        Integer[] anArray = new Integer[]{1, 2, 3, 4, 5};

        Integer[] clone = anArray.clone();

        anArray[0] = 7;
        System.out.println("==" + Arrays.toString(clone));

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(anArray));

        for (int i = 0; i < arrayList.size(); i++) {

            System.out.println("==" + arrayList.get(i));

        }

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        int size = list.size();
        String[] array = (String[]) list.toArray(new String[size]);
        for (int i = 0; i < array.length; i++) {
            System.out.println("==" + array[i]);
        }


        int i = MyApplication.getInstance().getI();
        Log.e("i==", i + "");

    }


    private void installApp(File file) {
        try {

            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.putExtra("name", "");
            intent.addCategory("android.intent.category.DEFAULT");
            String packageName = getPackageName();
            Uri data;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                data = FileProvider.getUriForFile(this, packageName + ".provider", file);


            } else if (Build.VERSION.SDK_INT >= 24) {

                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                data = FileProvider.getUriForFile(this, packageName + ".provider", file);
            } else {
                data = Uri.fromFile(file);
            }

            intent.setDataAndType(data, "application/vnd.android.package-archive");
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void installAPK() {
        File apkFile = new File(getStoragePath(this, false), "test.apk");
        if (!apkFile.exists()) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
//      安装完成后，启动app（源码中少了这句话）

        if (null != apkFile) {
            try {
                //兼容7.0
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    Uri contentUri = FileProvider.getUriForFile(this, getPackageName() + ".provider", apkFile);
                    intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
                    //兼容8.0
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        boolean hasInstallPermission = getPackageManager().canRequestPackageInstalls();
                        if (!hasInstallPermission) {
                            startInstallPermissionSettingActivity();
                            return;
                        }
                    }
                } else {
                    intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
                if (getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                    startActivity(intent);
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    private void startInstallPermissionSettingActivity() {
        //注意这个是8.0新API
        Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        method("mServedView");
        method("mNextServedView");
        System.out.println("person:" + "onDestroy执行");

    }


    /**
     * 反射置空输入法中的属性
     */
    public void method(String attr) {
        InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        try {
            Field mCurRootViewField = InputMethodManager.class.getDeclaredField(attr);
            mCurRootViewField.setAccessible(true);

            //取字段上的值
            Object mCurRootView = mCurRootViewField.get(im);

            if (null != mCurRootView && mCurRootView instanceof View) {
                Context context = ((View) mCurRootView).getContext();
                if (context == this) {
                    //破坏GC链
                    mCurRootViewField.set(im, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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


    private final int REQUEST_EXTERNAL_STORAGE = 1;
    private String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};


    public void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
