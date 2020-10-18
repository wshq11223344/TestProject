package com.example.testpproject.threadpool;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UserTask {


    //队列大小
    private final int QUEUE_LENGTH = 10;
    //基于内存的阻塞队列
    private BlockingQueue<String> queue = new LinkedBlockingQueue<String>(QUEUE_LENGTH);
    //线程池
    private ScheduledExecutorService es = Executors.newScheduledThreadPool(1);

    /**
     * 构造函数，执行execute方法
     */
    public UserTask() {
        execute();
    }

    /**
     * 添加信息至队列中
     *
     * @param content
     */
    public void addQueue(String content) {
        queue.add(content);
    }


    public void stop() {
        try {
            es.shutdown();
            if (!es.awaitTermination(3, TimeUnit.SECONDS)) {
                es.shutdown();
                System.out.println(es.isShutdown());
                System.out.println("线程没有关闭");

            } else {
                System.out.println(es.isTerminated());
                System.out.println("线程已关闭");

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            es.shutdown();
        } finally {
            es.shutdown();
        }

    }

    /**
     * 初始化执行
     */
    public void execute() {
        //每一分钟执行一次
        es.scheduleAtFixedRate(new Runnable() {

            public void run() {
                try {

                    if (queue.peek() != null) {
                        String content = queue.take();
                        //处理队列中的信息。。。。。
                        System.out.println(content);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, 1, 5, TimeUnit.SECONDS);
    }


    public static void main(String[] args) {

        final UserTask userTask = new UserTask();


        userTask.addQueue("韩琦");

        userTask.addQueue("寒气");
        userTask.addQueue("喊喊");
        userTask.addQueue("哈哈");


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                userTask.stop();
            }
        }, 22 * 1000);

//        userTask.stop();
    }

}
