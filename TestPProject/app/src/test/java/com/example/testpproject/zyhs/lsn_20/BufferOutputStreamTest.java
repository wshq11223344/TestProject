package com.example.testpproject.zyhs.lsn_20;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferOutputStreamTest {

    File file = new File("D:/android/test.txt");

    FileOutputStream fileOutputStream;

    BufferedOutputStream bufferedOutputStream;


    @Test
    public void test() {

        try {
            fileOutputStream = new FileOutputStream(file);


            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            bufferedOutputStream.write("韩琦是我".getBytes());

            bufferedOutputStream.write("\n".getBytes());

            bufferedOutputStream.write("wo shi".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bufferedOutputStream != null) {

                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null) {

                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
