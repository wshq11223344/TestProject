package com.example.testpproject.zyhs.lsn_20;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPutStreamTest {

    File file = new File("D:/android/test.txt");

    FileOutputStream fileOutputStream;

    @Test
    public void test() {

        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write("wo shi hanqi".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
