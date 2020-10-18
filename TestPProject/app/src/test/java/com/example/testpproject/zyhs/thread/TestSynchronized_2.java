package com.example.testpproject.zyhs.thread;

public class TestSynchronized_2 {

    public void test1() {
        synchronized (TestSynchronized_2.class) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public static synchronized void test2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        final TestSynchronized_2 myt2 = new TestSynchronized_2();


        Thread test1 = new Thread(new Runnable() {
            public void run() {
                myt2.test1();
            }
        }, "test1");


        Thread test2 = new Thread(new Runnable() {
            public void run() {

                TestSynchronized_2.test2();
            }
        }, "test2");
        test1.start();
        test2.start();
    }
}
