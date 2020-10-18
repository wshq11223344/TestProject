package com.example.testpproject.jobservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.testpproject.R;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        alarmDialog();
    }


    public void alarmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("你有未处理的事件");
        builder.setPositiveButton("稍后提醒", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alarm();
                finish();
            }
        });

        builder.setNegativeButton("停止", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                cancleAlarm();
                finish();// 关闭窗口
            }
        });
        builder.show().setCanceledOnTouchOutside(false);

    }

    /**
     * 取消闹钟
     */
    private void cancleAlarm() {
        // Create the same intent, and thus a matching IntentSender, for
        // the one that was scheduled.
        Intent intent = new Intent(AlarmActivity.this, RepeatingAlarm.class);
        intent.setAction("com.gcc.alarm");
        PendingIntent sender = PendingIntent.getBroadcast(AlarmActivity.this, 0, intent, 0);

        // And cancel the alarm.
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.cancel(sender);
    }

    private void alarm() {
        // 获取系统的闹钟服务
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        // 触发闹钟的时间（毫秒）
        long triggerTime = System.currentTimeMillis() + 10000;
        Intent intent = new Intent(this, RepeatingAlarm.class);
        intent.setAction("com.gcc.alarm");
        PendingIntent op = PendingIntent.getBroadcast(this, 0, intent, 0);
        // 启动一次只会执行一次的闹钟
        am.set(AlarmManager.RTC, triggerTime, op);
        // 指定时间重复执行闹钟
        // am.setRepeating(AlarmManager.RTC,triggerTime,2000,op);
    }


}