package com.example.testpproject.designmode.singleton;

public class Singleton {

    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {

        synchronized (Singleton.class) {
            if (singleton == null) {
                singleton = new Singleton();
            }

            return singleton;
        }

    }
}
