package com.example.testpproject.threadpool;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {


    @Test
    public void test() {

        //1.创建基本线程池
        final ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(15));


        //2.源码实现 FixedThreadPool (可重用固定线程数)
//            public static ExecutorService newFixedThreadPool(int nThreads) {
//                return new ThreadPoolExecutor(nThreads, nThreads,
//                        0L, TimeUnit.MILLISECONDS,
//                        new LinkedBlockingQueue<Runnable>());
//            }
        //适用：执行长期耗时的任务，性能好很多
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);


        //3.源码实现SingleThreadPool(单个核线的fixed)
//        public static ExecutorService newSingleThreadExecutor () {
//            return new FinalizableDelegatedExecutorService
//                    (new ThreadPoolExecutor(1, 1,
//                            0L, TimeUnit.MILLISECONDS,
//                            new LinkedBlockingQueue<Runnable>()));
//        }

        //一个任务一个任务执行的场景
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();


//        //源码实现CachedThreadPool (按需创建)
//        public static ExecutorService newCachedThreadPool() {
//            return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
//                    60L, TimeUnit.SECONDS,
//                    new SynchronousQueue<Runnable>());
//        }
        //执行很多短期异步的小程序或者负载较轻的服务器
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();


        //源码实现ScheduledThreadPool(定时延时执行)
//        public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
//            return new ScheduledThreadPoolExecutor(corePoolSize);
//        }
//public ScheduledThreadPoolExecutor(int corePoolSize) {
//            super(corePoolSize, Integer.MAX_VALUE,
//                    DEFAULT_KEEPALIVE_MILLIS, MILLISECONDS,
//                    new DelayedWorkQueue());
//        }

//        它适合执行一些周期性任务或者延时任务。
//        适用：一个任务一个任务执行的场景
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);


        for (int i = 0; i < 5; i++) {
            final int finali = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {

                    try {

                        Thread.sleep(2000);
                        System.out.println("run : " + finali + "  当前线程：" + Thread.currentThread().getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            };


//            基本线程池执行
            threadPoolExecutor.execute(runnable);


            //FixedThreadPool (可重用固定线程数)
//            fixedThreadPool.execute(runnable);


//            SingleThreadPool(单个核心线程的fixed)
//            singleThreadExecutor.execute(runnable);


//            CachedThreadPool (按需创建)
//            cachedThreadPool.execute(runnable);


            //ScheduledThreadPool(定时延时执行)

            //延迟5秒执行
//            scheduledExecutorService.schedule(runnable, 3, TimeUnit.SECONDS);


            //延迟5s后启动，每1s执行一次
//            scheduledExecutorService.scheduleAtFixedRate(runnable, 5, 1, TimeUnit.SECONDS);

            //启动后第一次延迟5s执行，后面延迟1s执行
//            scheduledExecutorService.scheduleWithFixedDelay(runnable, 5, 1, TimeUnit.SECONDS);

        }


//        try {
//            scheduledExecutorService.shutdown();
//            if (!scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS)) {//20S
//                System.out.println(" 到达指定时间，还有线程没执行完，不再等待，关闭线程池!");
//                scheduledExecutorService.shutdownNow();
//            }
//
////            scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS);
//
//            System.out.println(scheduledExecutorService.isTerminated());
//            System.out.println("接着往下执行");
//
//
//        } catch (Throwable e) {
//            scheduledExecutorService.shutdownNow();
//            e.printStackTrace();
//        }


    }


    public static void cancelAThread() {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println("线程池未关闭");
                return "true";
            }
        };

        Future<String> f = pool.submit(callable);

        System.out.println(f.isCancelled());
        System.out.println(f.isDone());
        f.cancel(true);


    }
}
