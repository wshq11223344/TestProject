package com.example.testpproject.zyhs.thread;

import java.util.Timer;
import java.util.TimerTask;

public class Test {


    public static void main(String[] args) {

        ThreadA t1 = new ThreadA("t1");
        synchronized (t1) {
            try {

                System.out.println(Thread.currentThread().getName() + " start t1");
                // 启动“线程t1”

                t1.start();
                // 主线程等待t1通过notify()唤醒。
                System.out.println(Thread.currentThread().getName() + " wait()");
                t1.wait();  //  不是使t1线程等待，而是当前执行wait的线程等待
                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("往下执行");


//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//
//                thread.notify();
//            }
//        };
//
//        Timer timer = new Timer();
//
//        timer.schedule(timerTask, 3000);

    }
}
