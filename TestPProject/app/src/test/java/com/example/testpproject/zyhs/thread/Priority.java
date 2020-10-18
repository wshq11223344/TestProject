package com.example.testpproject.zyhs.thread;

public class Priority {


    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + "(" + Thread.currentThread().getPriority() + ")");

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=0; i<5; i++) {
                    System.out.println(Thread.currentThread().getName()
                            +"("+Thread.currentThread().getPriority()+ ")"
                            +", loop "+i);
                }
            }
        }, "thread1");


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=0; i<5; i++) {
                    System.out.println(Thread.currentThread().getName()
                            +"("+Thread.currentThread().getPriority()+ ")"
                            +", loop "+i);
                }

            }
        }, "thread2");

        thread.setPriority(10);

        thread2.setPriority(1);

        thread.start();


        thread2.start();

    }
}
