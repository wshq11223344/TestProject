package com.example.testpproject.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.testpproject.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class WorkActivity extends AppCompatActivity implements View.OnClickListener {


    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        textView = findViewById(R.id.txt);
        textView.setOnClickListener(this);
        textView.setTag(123);

        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
        Data data = new Data.Builder().putString("qiqi", "hanqiData").build();


        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest
                .Builder(HeartWork.class)
                .setConstraints(constraints)
                .setInitialDelay(5, TimeUnit.SECONDS)
                .setInputData(data)
                .addTag("worker")
                .build();

        OneTimeWorkRequest oneTimeWorkRequest1 = new OneTimeWorkRequest
                .Builder(Work1.class)
                .build();

        OneTimeWorkRequest oneTimeWorkRequest2 = new OneTimeWorkRequest
                .Builder(Work2.class)
                .build();

        OneTimeWorkRequest oneTimeWorkRequest3 = new OneTimeWorkRequest
                .Builder(Work3.class)
                .build();

        OneTimeWorkRequest oneTimeWorkRequest4 = new OneTimeWorkRequest
                .Builder(Work4.class)
                .build();


        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneTimeWorkRequest.getId())
                .observe(this, (WorkInfo workInfo) -> {

                    if (workInfo != null && workInfo.getState() == WorkInfo.State.SUCCEEDED) {

                        Log.e("=======", "activity取到了任务回传的数据" + workInfo.getOutputData().getString("work"));

                    }

                });

//        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest);

//        WorkManager.getInstance(this).beginWith(oneTimeWorkRequest)
//                .then(oneTimeWorkRequest1)
//                .then(oneTimeWorkRequest4)
//                .then(oneTimeWorkRequest3)
//                .then(oneTimeWorkRequest2)
//                .enqueue();

//        WorkManager.getInstance(this).beginWith(Arrays.asList(oneTimeWorkRequest, oneTimeWorkRequest1))
//                .then(oneTimeWorkRequest4)
//                .then(oneTimeWorkRequest3)
//                .then(oneTimeWorkRequest2)
//                .enqueue();

//        WorkContinuation workContinuation = WorkManager.getInstance(this).beginWith(oneTimeWorkRequest).then(oneTimeWorkRequest4);
//
//        WorkContinuation workContinuation1 = WorkManager.getInstance(this).beginWith(oneTimeWorkRequest2).then(oneTimeWorkRequest3);
//
//        WorkContinuation.combine(Arrays.asList(workContinuation, workContinuation1)).then(oneTimeWorkRequest1).enqueue();


//        WorkManager.getInstance(this).cancelWorkById(oneTimeWorkRequest.getId());


        Constraints constraints1 = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();

        Data data1 = new Data.Builder().putString("qiqi", "测试数据").build();

        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest
                .Builder(HeartWork.class, 15, TimeUnit.MINUTES)
                .setConstraints(constraints1)
                .setInputData(data1)
                .addTag("123")
                .build();

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(periodicWorkRequest.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {

                        if (workInfo != null && workInfo.getState() == WorkInfo.State.SUCCEEDED) {

                            Log.e("=====", "子线程返回的数据" + workInfo.getOutputData().getString("work"));
                        }
                    }
                });


        WorkManager.getInstance(this).enqueue(periodicWorkRequest);
//
//        WorkManager.getInstance(this).cancelAllWorkByTag("123");
//
//        WorkManager.getInstance(this).cancelAllWork();

    }

    @Override
    public void onClick(View view) {

        String viewTag = view.getTag().toString();

        switch (viewTag) {
            case "123":

                ((TextView) view).setText("789");

                break;
        }
    }
}
