package com.example.testpproject.zyhs.teststaic;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestMain {


    public static void main(String[] args) {


//        Test.InnerClass_2 innerClass_2 = new Test().new InnerClass_2();

//        Test.getage();

        Test.InnerClass innerClass = new Test.InnerClass();

        Stack<String> stack = new Stack<>();

        stack.push("1");

        stack.push("2");

        stack.push("3");
//
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop());
//        }


        Queue<String> queue = new LinkedList<>();

        queue.offer("123");
        queue.offer("456");
        queue.offer("789");


//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//
//        while (queue.peek() != null) {
//            System.out.println(queue.poll());
//        }


//        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(5);


//        try {
//            queue.put("123");
//
//            if (queue.peek() != null) {
//                System.out.println(queue.take());
//                System.out.println(queue.take());
//                queue.put("456");
//                System.out.println(queue.take());
//            }
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }


}
