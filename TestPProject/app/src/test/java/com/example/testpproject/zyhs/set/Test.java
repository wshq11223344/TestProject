package com.example.testpproject.zyhs.set;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class Test {


    public static void main(String[] args) {

        HashSet<Person> hashSet = new HashSet<Person>();

        Person person = new Person("12", 2);
        Person person1 = new Person("12", 2);
        Person person2 = new Person("12", 2);


        person2.setAge(15);

        hashSet.add(person);
        hashSet.add(person1);
        hashSet.add(person2);


        for (Person person3 : hashSet) {

            System.out.println(person.toString());

        }


        System.out.println("--------------");

        ArrayList<Person> arrayList = new ArrayList<>();

        arrayList.add(person);

        arrayList.add(person1);

        arrayList.add(person2);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));

        }


        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.push("123");
        linkedList.push("4456");
        linkedList.push("789");

        System.out.println(linkedList.pop());

    }
}
