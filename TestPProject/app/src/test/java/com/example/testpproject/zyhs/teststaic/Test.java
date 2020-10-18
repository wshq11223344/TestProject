package com.example.testpproject.zyhs.teststaic;

public class Test {


    public static String common = "123";

    private String name = "";

    private String sex;

    public static int age;


    public void getInfo() {

        getage();

    }


    static {
        System.out.println(common);

    }


    public static void getage() {

    }


    public static void main(String[] args) {


    }

    public static class InnerClass {

        private static int grade;

        public String hobby;

        private static void show() {


            getage();

        }

        public void show_1() {
            age = 10;

        }
    }


    public class InnerClass_2 {
        public int count;

        public String string;

        public void show() {

            age = 30;
            getInfo();

            getage();

        }

    }


    static {

        age = 20;
        getage();

    }

}
