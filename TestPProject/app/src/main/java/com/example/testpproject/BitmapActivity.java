package com.example.testpproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BitmapActivity extends AppCompatActivity {

    private final String TAG = BitmapActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        verifyStoragePermissions(this);
//
        setContentView(R.layout.activity_bitmap);

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.wyz_p);
        i(bitmap1);

        Bitmap bitmap = getBitmap(R.mipmap.wyz_p, false, bitmap1.getWidth(), bitmap1.getHeight());
        i(bitmap);
    }


    void i(Bitmap bitmap) {
        Log.i("jett", "图片" + bitmap.getWidth() + "X" + bitmap.getHeight() + " 内存大小:" + bitmap.getByteCount());
    }

    private Bitmap getBitmap(int id, boolean isAlpha, int currentWidth, int currentHeight) {

        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;


        if (!isAlpha) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;

        }


        BitmapFactory.decodeResource(getResources(), R.mipmap.wyz_p, options);

        int outWidth = options.outWidth;

        int outHeight = options.outHeight;

        options.inSampleSize = getInSamplesize(outWidth, outHeight, currentHeight, currentWidth);

        options.inJustDecodeBounds = false;

        Log.e(TAG, options.inDensity + "");
        Log.e(TAG, options.inTargetDensity + "");

//        options.inDensity = 320;
//        options.inTargetDensity = 320;


        File file = new File(getStoragePath(getApplicationContext(), false), "wyz_p.png");


//        return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
//
        return BitmapFactory.decodeResource(getResources(), R.mipmap.wyz_p, options);
    }

    private int getInSamplesize(int targetWidth, int targetHeight, int currentHeight, int currentWidth) {


        int inSampleSize = 1;
        if (targetWidth > currentWidth && targetHeight > currentHeight) {

            inSampleSize = 2;
            while (targetWidth / inSampleSize > currentWidth && targetHeight / inSampleSize > currentHeight) {
                inSampleSize *= 2;
            }
        }

        inSampleSize /= 2;
        Log.e("jett", String.valueOf(inSampleSize));

        return inSampleSize;
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
