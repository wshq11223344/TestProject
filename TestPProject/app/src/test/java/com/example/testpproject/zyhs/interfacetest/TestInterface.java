package com.example.testpproject.zyhs.interfacetest;

import org.junit.Test;

public class TestInterface extends TestD {


    public int a;

    public TestInterface() {

        a = 666;
    }

    @Override
    public void showValue() {

//        super.showValue();

        System.out.print("我是我");

    }


    @Test
    public void test() {

        TestD testD = new TestInterface();

        testD.showValue();

        System.out.print(testD.a);

    }
}
