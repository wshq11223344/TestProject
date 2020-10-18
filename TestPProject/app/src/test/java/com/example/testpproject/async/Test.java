package com.example.testpproject.async;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Test {

    public static void main(String[] args) {


        TextView mTextResult = null;
        ProgressBar mProgressBar = null;

        DownloadAsyncTask downTask = new DownloadAsyncTask(mTextResult);
        downTask.execute("http://10.50.8.79:8088/elife/test.apk"); // 串行运行
        downTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "http://10.50.8.45:8080/hpproject");
        // 最多允许5个并行运行

        ProgressAsyncTask progress = new ProgressAsyncTask(mProgressBar);
        progress.execute("http://10.50.8.79:8088/elife/test.apk");
        progress.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "http://10.50.8.45:8080/hpproject");

    }
}
