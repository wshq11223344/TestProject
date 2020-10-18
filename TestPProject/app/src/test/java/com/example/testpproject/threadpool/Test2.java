package com.example.testpproject.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test2 {

    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("你好");

//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                int i = 0;
                if (i == 0) {
                    return;
                }

                System.out.println(i);

            }
        };

        service.scheduleAtFixedRate(runnable, 0, 500, TimeUnit.MILLISECONDS);

//        service.shutdown();
//        try {
//            service.awaitTermination(3, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("执行完了");

//        service.execute(runnable);
    }
}
