package com.example.testpproject.finalizes;

public class User {

    public static User user = null;


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("User-->finalize()");
        user = this;
    }
}
