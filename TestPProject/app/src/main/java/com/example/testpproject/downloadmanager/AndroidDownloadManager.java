package com.example.testpproject.downloadmanager;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by HyFun on 2019/05/27.
 * Email: 775183940@qq.com
 * <p>
 * https://qd.myapp.com/myapp/qqteam/AndroidQQ/mobileqq_android.apk
 * <p>
 * Description: 使用android系统自带的download manager 进行下载apk文件
 * <p>
 * 只负责下载
 */
public class AndroidDownloadManager implements LifecycleObserver {
    private DownloadManager downloadManager;
    private Context context;
    private long downloadId;
    private String url;
    private String name;

    private String path;

    private AndroidDownloadManagerListener listener;


    public AndroidDownloadManager() {
    }

    public AndroidDownloadManager(Context context, String url) {


        this(context, url, getFileNameByUrl(url));

        Log.e("========", getFileNameByUrl(url));
    }

    public AndroidDownloadManager(Context context, String url, String name) {
        this.context = context;
        this.url = url;
        this.name = name;
    }

    public AndroidDownloadManager setListener(AndroidDownloadManagerListener listener) {
        this.listener = listener;
        return this;
    }

    /**
     * 开始下载
     */
    public void download() {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        //移动网络情况下是否允许漫游
        request.setAllowedOverRoaming(false);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);

//        apk类型
        request.setMimeType("application/vnd.android.package-archive");

        //在通知栏中显示，默认就是显示的
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        request.setTitle(name);
        request.setDescription("文件正在下载中......");
//        request.setVisibleInDownloadsUi(true);

        //设置下载的路径
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), name);
        request.setDestinationUri(Uri.fromFile(file));
        path = file.getAbsolutePath();

        //获取DownloadManager
        if (downloadManager == null) {
            downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        }
        //将下载请求加入下载队列，加入下载队列后会给该任务返回一个long型的id，通过该id可以取消任务，重启任务、获取下载的文件等等
        if (downloadManager != null) {
            if (listener != null) {
                listener.onPrepare(downloadId, downloadManager);
            }
            downloadId = downloadManager.enqueue(request);

//            downloadManager.remove(downloadId);

        }

        //注册广播接收者，监听下载状态
        context.registerReceiver(receiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

        queryProgress();
    }

    private Cursor cursor;
    DownloadManager.Query query = new DownloadManager.Query();
    //广播监听下载的各个状态
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            //通过下载的id查找
            query.setFilterById(downloadId);
            cursor = downloadManager.query(query);
            if (cursor.moveToFirst()) {
                int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));


                switch (status) {
                    //下载暂停
                    case DownloadManager.STATUS_PAUSED:

                        Log.e("=======", "下载暂停");

                        break;
                    //下载延迟
                    case DownloadManager.STATUS_PENDING:
                        Log.e("=======", "下载延迟");
                        break;
                    //正在下载
                    case DownloadManager.STATUS_RUNNING:
                        Log.e("=======", "正在下载");
                        break;
                    //下载完成
                    case DownloadManager.STATUS_SUCCESSFUL:
                        if (listener != null) {
                            listener.onSuccess(path);
                        }
                        cursor.close();
                        context.unregisterReceiver(receiver);
                        break;
                    //下载失败
                    case DownloadManager.STATUS_FAILED:
                        if (listener != null) {
                            listener.onFailed(new Exception("下载失败"));
                        }
                        cursor.close();
                        context.unregisterReceiver(receiver);
                        break;
                }
            }
        }
    };

    int bytes_downloaded;
    int bytes_total;

    ScheduledExecutorService executorService;

    private void queryProgress() {

        executorService = Executors.newScheduledThreadPool(1);

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                Cursor cursor = downloadManager.query(query.setFilterById(downloadId));
                if (cursor != null && cursor.moveToFirst()) {
                    bytes_downloaded = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
                    bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
//                int pro =  (bytes_downloaded * 100) / bytes_total;
                    Log.e("======", bytes_downloaded + "");
                    Log.e("======", bytes_total + "");

                    if (bytes_downloaded == bytes_total) {
                        cursor.close();
                        executorService.shutdownNow();
                    }
                    cursor.close();

                }

            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    // ——————————————————————私有方法———————————————————————

    /**
     * 通过URL获取文件名
     *
     * @param url
     * @return
     */
    private static final String getFileNameByUrl(String url) {
        String filename = url.substring(url.lastIndexOf("/") + 1);
        filename = filename.substring(0, filename.indexOf("?") == -1 ? filename.length() : filename.indexOf("?"));
        return filename;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void connectListener() {

        Log.e("===", "开始订阅");

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void disconnectListener() {

        if (!executorService.isTerminated()) {
            executorService.shutdownNow();
        }

        Log.e("====", "取消订阅");
        if (!cursor.isClosed()) {
            cursor.close();
        }
        context.unregisterReceiver(receiver);

    }


}
