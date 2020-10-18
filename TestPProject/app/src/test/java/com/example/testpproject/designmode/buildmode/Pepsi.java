package com.example.testpproject.designmode.buildmode;

public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35f;
    }
}
