package com.example.testpproject.zyhs.abstractest;

public class BasketBalPlayer extends Player {


    public BasketBalPlayer(String country) {
        super(country);

        System.out.println("BasketBalPlayer" + this.hashCode());

    }

    @Override
    protected String playerType() {
        return "篮球运动员";
    }



}
