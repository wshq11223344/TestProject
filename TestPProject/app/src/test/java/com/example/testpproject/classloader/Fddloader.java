package com.example.testpproject.classloader;

import java.util.HashMap;
import java.util.Map;

public class Fddloader {


    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = Fdd.class.getClassLoader();
        System.out.println(loader);

        //一、 使用ClassLoader.loadClass()来加载类，不会执行初始化块 loader.loadClass("Fdd");
//        Class<?> aClass = loader.loadClass("com.example.testpproject.classloader.Fdd");
//
//        System.out.println(aClass);

        // 二、 使用Class.forName()来加载类，默认会执行初始化块 Class.forName("Fdd");
//        Class.forName("com.example.testpproject.classloader.Fdd");

        // 三、使用Class.forName()来加载类，指定ClassLoader，初始化时不执行静态块 Class.forName("Fdd", false, loader); }
//        Class.forName("com.example.testpproject.classloader.Fdd", true, loader);

//        Fdd.test(20);
//        Fdd.testClass.test();

//        System.out.println(Fdd.str);

    }


}
