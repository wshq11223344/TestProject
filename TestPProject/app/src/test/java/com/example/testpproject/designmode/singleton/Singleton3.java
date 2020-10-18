package com.example.testpproject.designmode.singleton;

public class Singleton3 {

    private Singleton3() {
    }

    private static class SingletonHolder {

        private static final Singleton3 singleton3 = new Singleton3();
    }

    public static Singleton3 getInstance() {

        return SingletonHolder.singleton3;
    }
}
