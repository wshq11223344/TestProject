package com.example.testpproject.downloadmanager;

import android.app.DownloadManager;

public interface AndroidDownloadManagerListener {

    void onPrepare(long downloadId, DownloadManager downloadManager);

    void onSuccess(String path);

    void onFailed(Throwable throwable);
}
