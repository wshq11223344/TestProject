package com.example.testpproject.zyhs.lsn_20;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BufferReaderTest {

    File file = new File("D:/android/test.txt");
    FileReader fileReader;
    BufferedReader bufferedReader;

    @Test
    public void test() throws Exception {

        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);

//        String readLine = bufferedReader.readLine();
//        System.out.println(readLine);
//        String string;
//        StringBuilder stringBuilder2 = new StringBuilder(64);
//        while ((string = bufferedReader.readLine()) != null) {
//
//            stringBuilder2.append(string);
//            stringBuilder2.append("\n");
//        }
//        System.out.println(stringBuilder2);

        char[] chars = new char[1024];
        StringBuilder stringBuilder = new StringBuilder(64);
        int length;
        while ((length = bufferedReader.read(chars)) != -1) {

            stringBuilder.append(chars, 0, length);
        }
        System.out.println(stringBuilder.toString());
    }
}
