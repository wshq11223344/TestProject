package com.example.testpproject.zyhs.enums;

public enum MyEnum {

    SPRING("春天", "种花"),
    SUMMER("夏天", "长大"),
    AUTUMN("秋天", "开花"),
    WINTER("冬天", "凋落");

    private String name;
    private String name1;

    MyEnum(String name, String name1) {
        this.name = name;
        this.name1 = name1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }



}
