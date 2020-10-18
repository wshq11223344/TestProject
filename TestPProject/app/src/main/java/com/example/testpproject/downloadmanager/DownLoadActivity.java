package com.example.testpproject.downloadmanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import com.example.testpproject.R;

import java.io.File;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class DownLoadActivity extends AppCompatActivity {

    private final String TAG = DownLoadActivity.class.getSimpleName();

    private String url = "https://qd.myapp.com/myapp/qqteam/AndroidQQ/mobileqq_android.apk";


    private long downloadId;

    private DownloadManager downloadManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load);

        getLifecycle().addObserver(new AndroidDownloadManager());

        Log.e("======", Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.e("======", getExternalCacheDir().getAbsolutePath());

        Log.e("======", getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());

        Log.e("======", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());


        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "mobileqq_android.apk");

        if (file.exists()) {

            file.delete();
        }

        new AndroidDownloadManager(this, url)
                .setListener(new AndroidDownloadManagerListener() {
                    @Override
                    public void onPrepare(long downloadId, DownloadManager downloadManager) {
                        Log.e("======", "onPrepare");
                        DownLoadActivity.this.downloadId = downloadId;
                        DownLoadActivity.this.downloadManager = downloadManager;
                    }

                    @Override
                    public void onSuccess(String path) {
                        Log.e("======", "onSuccess >>>>" + path);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && !getPackageManager().canRequestPackageInstalls()) {

                            Uri uri = Uri.parse("package:" + getPackageName());
                            Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, uri);
                            startActivityForResult(intent, 19900);

//            Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
                        } else {

                            installApp(new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "mobileqq_android.apk"));
                        }


                    }

                    @Override
                    public void onFailed(Throwable throwable) {
                        Log.e("======", "onFailed", throwable);
                    }
                })
                .download();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 19900) {
            Log.e("========", "执行了");
            installApp(new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "mobileqq_android.apk"));

        }
    }

    private void installApp(File file) {
        try {

            Intent intent = new Intent(Intent.ACTION_VIEW);
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


    public void jump(View view) {

        startActivity(new Intent(this, DsecondActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        downloadManager.remove(downloadId);

    }
}
