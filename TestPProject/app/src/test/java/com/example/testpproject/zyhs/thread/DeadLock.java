package com.example.testpproject.zyhs.thread;

public class DeadLock {
    public static Object a = new Object();
    public static Object b = new Object();

    public static void main(String[] args) {
        DeadLock d = new DeadLock();
        d.setDeadlock();
    }

    // 建立死锁
    private void setDeadlock() {
        Thread A = new Thread(new Runnable() {
            public void run() {
                threadA();
            }
        });


        Thread B = new Thread(new Runnable() {
            public void run() {
                threadB();
            }
        });
        A.start();
        B.start();
    }

    protected void threadA() {
        synchronized (DeadLock.a) {
            System.out.println("A keeps a");
            sleep();  // 留出时间让线程B去锁住b

//            synchronized (DeadLock.b) {
//                System.out.println("A got b");
//            }

            LockB();

        }
    }


    public void LockB() {

        synchronized (DeadLock.b) {

            System.out.println("A got b");

        }

    }


    private void threadB() {
        synchronized (DeadLock.b) {
            System.out.println("B keeps b");
            sleep();  // 留出时间让线程A去锁住a
            synchronized (DeadLock.a) {
                System.out.println("B got a");
            }

        }
    }

    // 让线程等待一段时间，以便使A,B都能先锁住一个资源
    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}



