package com.example.testpproject.zyhs.thread;

public class TestSynchronized {

    public Student student = new Student();


    public void test1() {
        synchronized (this) {
            student.setAge(12);
            student.setName("123");
            System.out.println(Thread.currentThread().getName() + student.toString());

            int i = 5;
            while (i-- > 0) {
                int j = i;
                System.out.println(Thread.currentThread().getName() + " : " + j);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }

        }

    }

    public synchronized void test2() {

        student.setName("hanqi");
        student.setAge(20);
        System.out.println(Thread.currentThread().getName() + student.toString());

        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }


    }


    public void test3() {
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
        final TestSynchronized myt2 = new TestSynchronized();
        Thread test1 = new Thread(new Runnable() {
            public void run() {
                myt2.test1();
//                myt2.test2();
            }
        }, "test1");


        Thread test2 = new Thread(new Runnable() {
            public void run() {
//                myt2.test1();
                myt2.test2();
            }
        }, "test2");


        test1.start();
        test2.start();


    }
}
