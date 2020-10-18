package com.example.testpproject.designmode.buildmode;

public class Coke extends ColdDrink {


    @Override
    public String name() {
        return "coke";
    }

    @Override
    public float price() {
        return 30f;
    }
}
