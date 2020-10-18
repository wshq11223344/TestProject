package com.example.testpproject.zyhs.reference;

import java.lang.ref.WeakReference;

public class Test {


    public static void main(String[] args) {


        Object object = new Object();

        WeakReference<Object> weakReference = new WeakReference<>(object);

        int i = 0;

//        object = null;

        while (true) {

            if (weakReference.get() != null) {
                i++;
                System.out.println("Object还活着" + i);
            } else {
                System.out.println("Object已经被回收了");
                break;
            }
        }


        Integer integer = Integer.valueOf(10);
        System.out.println(integer.intValue());

        String string =new String("456");


        System.out.println(string.toString());

    }


    public void show() {

    }

    public void show(int a) {

    }

    public static void test() {

    }
}
