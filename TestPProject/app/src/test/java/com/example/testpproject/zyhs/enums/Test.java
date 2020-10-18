package com.example.testpproject.zyhs.enums;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class Test {


    @org.junit.Test
    public void test() throws IllegalAccessException {

        MyEnum myEnum = MyEnum.SPRING;

        switch (myEnum) {
            case SPRING:
                System.out.println("我执行了1");
                break;

            case SUMMER:
                break;
            case AUTUMN:
                break;

            case WINTER:
                break;

            default:
                throw new IllegalAccessException("未知错误");
        }

//        EnumSet<MyEnum> enumSetAll = EnumSet.allOf(MyEnum.class);
//        System.out.println(enumSetAll);
//
//
//        EnumMap<MyEnum, String> enumMap = new EnumMap<>(MyEnum.class);
//        enumMap.put(MyEnum.SPRING, "春天");
//        enumMap.put(MyEnum.SUMMER, "夏天");
//        enumMap.put(MyEnum.AUTUMN, "秋天");
//        System.out.println(enumMap);
//
//        System.out.println(enumMap.get(MyEnum.SPRING));
//        System.out.println(enumMap.containsKey(MyEnum.SUMMER));
//        System.out.println(enumMap.remove(MyEnum.AUTUMN));


        MyEnum.AUTUMN.setName("种树");

        System.out.println(MyEnum.AUTUMN.getName());

        setMyEnum(MyEnum.SPRING);

        System.out.println(MyEnum.SPRING == getMyEnum());

        System.out.println(MyEnum.SPRING.name());
        System.out.println(MyEnum.SPRING);

        System.out.println(MyEnum.AUTUMN.ordinal());

        System.out.println(Arrays.toString(MyEnum.values()));
        MyEnum[] values = MyEnum.values();
        System.out.println(MyEnum.valueOf(MyEnum.AUTUMN.name()));
    }

    private MyEnum myEnum;

    public MyEnum getMyEnum() {
        return myEnum;
    }

    public void setMyEnum(MyEnum myEnum) {
        this.myEnum = myEnum;
    }
}
