package com.example.testpproject.threadpool;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Test3 {

    static boolean flag = true;
    static BlockingQueue<String> blockingQueue;

    public static void main(String[] args) throws Exception {

        blockingQueue = new LinkedBlockingQueue<>(6);
        ExecutorService executorService = Executors.newSingleThreadExecutor();


        blockingQueue.put("1");
        executorService.submit(new Runnable() {
            @Override
            public void run() {

                while (flag) {

//                    try {
//                        if (blockingQueue.peek() != null) {
//                            String take = blockingQueue.take();
//                            System.out.println(take);
//                        }
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println("在执行");
                }
                System.out.println("执行后面");

            }
        });

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                flag = false;
                executorService.shutdown();
//                blockingQueue.clear();
//                blockingQueue = null;
//                System.out.println(executorService.isShutdown());
//                System.out.println(executorService.isTerminated());

            }
        }, 5000);

    }
}
