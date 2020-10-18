package com.example.testpproject.jobservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;

import com.example.testpproject.R;

public class JobActivity extends AppCompatActivity {


    JobScheduler mJobScheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        startJobScheduler();

//        startAlarm();
    }

    RepeatingAlarm repeatingAlarm;

    public void startAlarm() {
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("com.gcc.alarm");
//
//        repeatingAlarm = new RepeatingAlarm();
//        registerReceiver(repeatingAlarm, intentFilter);

        Intent intent = new Intent(this, RepeatingAlarm.class);
        intent.setAction("com.gcc.alarm");
        PendingIntent sender = PendingIntent.getBroadcast(this, 0, intent, 0);
        // Schedule the alarm!
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
//        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5000, sender);//c为设置闹钟的时间的Calendar对象

        am.setRepeating(AlarmManager.RTC, System.currentTimeMillis() + 5000, 80000, sender);
        // pendingIntent 为发送广播
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            am.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 5000, sender);
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            am.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), sender);
//        } else {
//            am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 5000, sender);
//        }


    }


    public void startJobScheduler() {

        mJobScheduler = (JobScheduler) getSystemService(this.JOB_SCHEDULER_SERVICE);

        JobInfo.Builder builder = new JobInfo.Builder(0, new ComponentName(getApplicationContext(), JobSchedulerService.class));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            builder.setMinimumLatency(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS); //执行的最小延迟时间
            builder.setOverrideDeadline(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS);  //执行的最长延时时间
            builder.setBackoffCriteria(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS, JobInfo.BACKOFF_POLICY_LINEAR);//线性重试方案
        } else {
            builder.setPeriodic(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS);
        }
//        builder.setPeriodic(JobInfo.DEFAULT_INITIAL_BACKOFF_MILLIS);
        builder.setPersisted(true);  // 设置设备重启时，执行该任务
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setRequiresCharging(false); // 当插入充电器，执行该任务
        JobInfo info = builder.build();
        mJobScheduler.schedule(info); //开始定时执行该系统任务
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(repeatingAlarm);
    }
}