package com.example.testpproject.zyhs.lsn_20;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

    File file = new File("D:/android/test.txt");

    FileInputStream fileInputStream;


    @Test
    public void test() {

        try {
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[100];
            fileInputStream.read(bytes);
            System.out.println(new String(bytes,"GBK"));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {

                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
