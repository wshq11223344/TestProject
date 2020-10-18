package com.example.testpproject.designmode.buildmode;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

//    @Override
//    public abstract float price();
}
