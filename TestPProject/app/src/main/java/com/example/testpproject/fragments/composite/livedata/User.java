package com.example.testpproject.fragments.composite.livedata;

public class User {

    private String name;
    private String grnder;
    private int age;

    public User(String name, String grnder, int age) {
        this.name = name;
        this.grnder = grnder;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", grnder='" + grnder + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getGrnder() {
        return grnder;
    }

    public int getAge() {
        return age;
    }
}
