package com.example.testpproject.classloader;

public class Fdd {

    public static int age = 10;

    public static final String str = "123";

    public static void test(int age) {

        Fdd.age = age;

        System.out.println("执行静态方法" + Fdd.age);

    }

    public static class testClass {

        public static void test() {

            System.out.println("执行静态内部类" + age);

        }

    }

    static {
        System.out.println("我是静态代码块。。。。" + age);
    }
}