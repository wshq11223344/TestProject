package com.example.testpproject.designmode.buildmode;

public class VegBurger extends Burger {


    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25f;
    }
}
