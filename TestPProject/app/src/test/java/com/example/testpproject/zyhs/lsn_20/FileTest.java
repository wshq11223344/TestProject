package com.example.testpproject.zyhs.lsn_20;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {


    @Test
    public void test_1() {

        File file = new File("D:/android/test.txt");

        if (file.exists()) {

            file.delete();
        }

        if (!file.getParentFile().exists()) {

            file.getParentFile().mkdirs();

        }


        try {
            boolean newFile = file.createNewFile();

            System.out.println(newFile);

            System.out.println(file.getAbsolutePath());
            System.out.println(file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void test_2() {
        File file = new File("D:/android");

        if (!file.exists()) {
            file.mkdirs();
        }

        File file1 = new File(file, "test.txt");

        if (!file1.exists()) {

            try {
                boolean newFile = file1.createNewFile();
                System.out.println(newFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
