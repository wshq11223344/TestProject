package com.example.testpproject.zyhs.proxy;

public class ChinaFactory implements Factory {


    @Override
    public void createDipan() {

        System.out.println("生产轮子");

    }

    @Override
    public void createFadongji() {

        System.out.println("生产发动机");

    }
}
