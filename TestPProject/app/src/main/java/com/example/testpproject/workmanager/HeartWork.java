package com.example.testpproject.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class HeartWork extends Worker {


    public HeartWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        Log.e("=======", "dowork执行了");

        String data = getInputData().getString("qiqi");

        Log.e("=======", data);

        Data data1 = new Data.Builder().putString("work", "子线程的数据").build();

        return Result.success(data1);
//        return Result.retry();
    }
}
