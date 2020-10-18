package com.example.testpproject.zyhs.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {


    public static void main(String[] args) {

//        List<String> arrayList = new ArrayList<>(20);
//
//        arrayList.add("1");
//        arrayList.add("2");
//        arrayList.add("3");

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");


        for (String s : linkedList) {
            System.out.println(s);
        }


        int[] ints = new int[10];

        ints[0] = 1;

        int[] clone = ints.clone();

        System.out.println(Arrays.toString(clone));


        String str1 = "aaaaaaaaaaaaa";

        String str2 = "s";

        System.out.println(str1.compareTo(str2));
        Student student = new Student("1", "1");

        Student student1 = new Student("1", "1");

        System.out.println(student.equals(student1));

        System.out.println(student.hashCode());

        System.out.println(student1.hashCode());


    }
}
