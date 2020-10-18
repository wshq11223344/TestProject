package com.example.testpproject.zyhs.lsn_20;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferInputStreamTest {

    File file = new File("D:/android/test.txt");

    FileInputStream fileInputStream;

    BufferedInputStream bufferedInputStream;


    @Test
    public void test() {

        try {
            fileInputStream = new FileInputStream(file);

            bufferedInputStream = new BufferedInputStream(fileInputStream);

            byte[] bytes = new byte[100];

            bufferedInputStream.read(bytes);

            System.out.print(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bufferedInputStream != null) {

                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
