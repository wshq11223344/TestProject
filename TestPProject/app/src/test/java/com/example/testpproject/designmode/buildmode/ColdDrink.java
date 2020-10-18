package com.example.testpproject.designmode.buildmode;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

//    @Override
//    public abstract float price();
}
