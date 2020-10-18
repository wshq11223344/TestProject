package com.example.testpproject.zyhs.lsn_20;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {

    File file = new File("D:/android/test.txt");

    FileInputStream fileInputStream;

    ObjectInputStream objectInputStream;

    FileOutputStream fileOutputStream;

    ObjectOutputStream objectOutputStream;


    @Test
    public void test() {

        try {
            fileOutputStream = new FileOutputStream(file);

            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject("我是韩琦，我是你妈");

            objectOutputStream.writeObject("你个傻逼");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {

                try {
                    objectOutputStream.close();
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


    @Test
    public void test_2() {

        try {
            fileInputStream = new FileInputStream(file);

            objectInputStream = new ObjectInputStream(fileInputStream);

            Object o = objectInputStream.readObject();

            System.out.println(o.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
