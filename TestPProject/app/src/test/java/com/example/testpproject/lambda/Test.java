package com.example.testpproject.lambda;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {


    public void test() {


//        equals比较的是值   ==比较的是引用
        String string = new String("123");

        String string1 = new String("123");

        System.out.println(string.equals(string1));

        System.out.println(string == string1);

        String a = "123";

        String b = "123";

        System.out.println(a == (b));

        System.out.println(a.equals(b));

    }


    @org.junit.Test
    public void test2() {
        Test tester = new Test();

        MathOperation mathOperation = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a * b;
            }
        };

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message -> {
            System.out.println("Hello " + message);
        };

        // 用括号
        GreetingService greetService2 = (String message) -> System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

        GreetingService1 greetingService1 = () -> {
            System.out.println("你好");
        };

        greetingService1.sayMessage();

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(15));


        ExecutorService threadPoolExecutor = Executors.newSingleThreadExecutor();

        threadPoolExecutor.execute(() -> {
            System.out.println("我叫韩其");
        });

        threadPoolExecutor.shutdown();

        try {
            boolean b = threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println(b);
            System.out.println(threadPoolExecutor.isTerminated());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("我是lambda表达式");
        }).start();

    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    interface GreetingService1 {
        void sayMessage();
    }


    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

}
