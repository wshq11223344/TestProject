package com.example.testpproject.lambda;

import org.junit.Test;

import java.util.Comparator;

public class Test2 {


    public static void main(String args[]) {
        final int num = 1;
        Converter<Integer, String> s = param -> System.out.println(param + num);
        s.convert(2);  // 输出结果为 3
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }


    @Test
    public void Test() {
        final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(param + num);
        s.convert(2);
//        num = 5;

    }
}
