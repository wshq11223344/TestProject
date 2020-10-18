package com.example.testpproject.zyhs.interfacetest;

import org.junit.Test;

public class TestF extends TestC {


    public int a = 2;


    @Override
    public void test() {
        System.out.println("2");
    }

    public static void main(String[] args) {

        TestC testC = new TestF();

        testC.test();


    }

    @Test
    public void test2() {

        TestC testC = new TestF();


        System.out.println((testC).a);
    }

}
