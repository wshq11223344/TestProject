package com.example.testpproject;

import android.os.AsyncTask;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringTest {

    public String string = "123";


    @Test
    public void test() {


//        new Thread(new Runnable() {
//
//
//            @Override
//            public void run() {
//
//                System.out.println("thread1" + string);
//                string = "456";
//                System.out.println("thread1:" + string);
//
//            }
//        }).start();


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("thread2" + string);
//                string = "789";
//                System.out.println("thread2" + string);
//            }
//        }).start();


        int[][][] ints = new int[4][5][5];

        int t = 0;
//        System.out.println(ints.length);

        for (int i = 0; i < ints.length; i++) {
            int[][] anInt = ints[i];

//            System.out.println("第二层" + anInt.length);
            for (int j = 0; j < anInt.length; j++) {
                int[] ints1 = anInt[j];
                for (int k = 0; k < ints1.length; k++) {
                    int i1 = ints1[k];

                    t++;
                    System.out.println(t);
                }
            }
        }

    }


    @Test
    public void tst() {
        boolean b = new Person() instanceof Person;


        boolean a = Person.class.isInstance(new Person());

        boolean assignableFrom = (Object.class).isAssignableFrom(Person.class);

//        boolean instance = Object.class.isInstance(Person.class);


        System.out.println(b);

        System.out.println(a);
        System.out.println(assignableFrom);


        System.out.println("abc".equalsIgnoreCase("abC"));

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(1).append(2).append(3).append("&");

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        System.out.println(stringBuilder.toString());


        String[] strings = new String[]{"aa", "bb", "abc"};

        List<String> list = new ArrayList<>(Arrays.asList(strings));


        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            System.out.println(s);
        }


        String[] strings1 = list.toArray(new String[3]);

        System.out.println(Arrays.toString(strings1));

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "1");
        map.put(1, "6");
        map.put(2, "2");
        map.put(2, "3");

        Set<Integer> integers = map.keySet();

        for (Integer integer : integers) {

            System.out.println(integer + "," + map.get(integer));
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();

        while (iterator.hasNext()) {

            Map.Entry<Integer, String> next = iterator.next();

            Integer key = next.getKey();
            String value = next.getValue();
            System.out.println(key + "," + value);
        }


        int test1 = 300;
        int test2 = 300;
        System.out.println(test1 == test2);

        List<String> list1 = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            list1.add(i + "");

        }

        list1.remove("6");

        for (int i = 0; i < list1.size(); i++) {

            System.out.println(list1.get(i));

        }

    }
}
