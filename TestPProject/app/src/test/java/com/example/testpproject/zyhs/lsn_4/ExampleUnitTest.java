package com.example.testpproject.zyhs.lsn_4;

import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Test
    public void addition_isCorrect() throws Exception {
        BinarayTree binarayTree = new BinarayTree("A");
        binarayTree.createTree();
        binarayTree.midOrderTraverse(binarayTree.root);
        binarayTree.preOrderTraverse(binarayTree.root);
        binarayTree.postOrderTraverse(binarayTree.root);


        byte[] bytes = "a".getBytes();

        System.out.println(Arrays.toString(bytes));


        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = new int[5];


        System.arraycopy(array1, 0, array2, 0, 5);


        array1[1] = 6;

//        update(array2);

//        Arrays.sort(array2);
//        for (int a = array2.length - 1; a >= 0; a--) {
//
//            System.out.print(array2[a]);
//
//        }
        System.out.print(Arrays.toString(array2));

        System.out.println();


        Double i12 = -128D;
        Double i13 = -128D;
        Integer integer0 = new Integer(0);
        System.out.println("i12==i13?  " + (i12 == i13));
//        System.out.println("i12==i13+integer0?  " + (i12 == i13 + integer0));

        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        StringBuilder stringBuilder = new StringBuilder();


        String string1 = stringBuilder.toString();


        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.put(0, "1");
        sparseArray.put(1, "1");
        sparseArray.put(2, "1");

        System.out.println(sparseArray.keyAt(0));


        HashMap<String, String> map = new HashMap<>(5);

        ArrayMap<String, String> map1 = new ArrayMap<>(5);


        Set<String> strings1 = map1.keySet();
        for (String string : strings1) {
            String s = map1.get(string);
        }


//        第一种遍历方式
        Set<String> strings = map.keySet();

        Iterator<String> iterator = strings.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            String s = map.get(next);
        }


//        第二种遍历方式
        for (String string : strings) {

            String s = map.get(string);
        }


//        第三种遍历方式
        Set<Map.Entry<String, String>> entries = map.entrySet();

        Iterator<Map.Entry<String, String>> iterator1 = entries.iterator();

        while (iterator1.hasNext()) {
            Map.Entry<String, String> next = iterator1.next();
            String key = next.getKey();
            String value = next.getValue();
        }
    }

    private void update(int[] array2) {

        array2[1] = 6;


    }



}