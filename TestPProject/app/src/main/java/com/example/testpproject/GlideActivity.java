package com.example.testpproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class GlideActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        imageView = (ImageView) findViewById(R.id.image_view);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            Log.e("==========", ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) + "");

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 1);

            }
        }


        printResolution(this);
    }

    /**
     * 打印不包括虚拟按键的分辨率、屏幕密度dpi、最小宽度sw
     */
    public void printResolution(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        int sw = context.getResources().getConfiguration().smallestScreenWidthDp;
        Log.e("=========", "屏幕分辨率:" + width + "*" + height + ",dpi:" + dm.densityDpi + ",sw:" + sw);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PERMISSION_GRANTED) {
                    Log.e("==========", "申请成功");

//                    getAppDetailSettingIntent(this);
                    // 申请成功
                } else {
//                    失败之后再申请
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 1);

                    Log.e("==========", "申请失败");

                    // 申请失败
                }
            }
        }
    }


    /**
     * 跳转到应用权限界面
     *
     * @param context
     */
    private void getAppDetailSettingIntent(Context context) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            intent.setAction(Intent.ACTION_VIEW);
            intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            intent.putExtra("com.android.settings.ApplicationPkgName", getPackageName());
        }
        startActivity(intent);
    }


    public void loadImage(View view) {
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";

//        RequestOptions cropOptions = new RequestOptions().centerCrop();

        Glide.with(this)
//                .asBitmap()
//                .asGif()
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(getDrawable(R.mipmap.ic_banner_start))
//                .placeholder(R.mipmap.ic_launcher_round)
                .circleCrop()
                .transition(withCrossFade(1000))
//                .override(200,200)
//                .thumbnail(0.6f)
                .into(imageView);


        // 加载本地图片
        File file = new File(getExternalCacheDir() + "/wyz_p.png");
        Glide.with(this).load(file).into(imageView);

//        Log.e("======", getExternalCacheDir().getAbsolutePath());

        // 加载应用资源
//        int resource = R.mipmap.wyz_p;
//        Glide.with(this).load(resource).into(imageView);

//        Glide.with(this).clear(imageView);

//        // 加载二进制流
//        byte[] image = getImageBytes();
//        Glide.with(this).load(image).into(imageView);
//
//        // 加载Uri对象
//        Uri imageUri = getImageUri();
//        Glide.with(this).load(imageUri).into(imageView);

    }


}
