package com.example.testpproject.zyhs.lsn_2;

import org.junit.Test;

import java.util.Stack;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(6);
        linkedList.add(1, 4);
        linkedList.add(0, 8);
        linkedList.add(0, 5);

//        linkedList.remove(2);

        linkedList.update(0, 10);


        for (int i = 0; i < linkedList.size; i++) {

            System.out.print(i + ":" + linkedList.get(i) + "  ");
        }


//        Object a =1;
//        Object b = a;
//
//        System.out.println("\n");
//
//        System.out.println(a + ":" + a.hashCode());
//        System.out.print(b + ":" + b.hashCode());

    }


    private Object a;


    @Test
    public void test() {

        Object b = new Object();


        a = b;
        System.out.println(a + ":" + a.hashCode());
        System.out.print(b + ":" + b.hashCode());

    }


}