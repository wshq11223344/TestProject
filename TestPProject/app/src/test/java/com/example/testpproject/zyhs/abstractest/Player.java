package com.example.testpproject.zyhs.abstractest;

public abstract class Player {

    protected String country;


    public Player(String country) {
        this.country = country;

        System.out.println("Player" + this.hashCode());

    }

    protected void play() {

        System.out.println("我是" + country + playerType());
    }


    protected abstract String playerType();


    public static void show() {


    }
}
