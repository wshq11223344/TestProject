package com.example.testpproject.zyhs.lsn_20;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileeRederTest {

    FileReader fileReader;


    @Test
    public void test() {

        try {
            fileReader = new FileReader("D:/android/test.txt");

            char[] chars = new char[1024];

            StringBuilder stringBuilder = new StringBuilder();

            int length;

            while ((length = fileReader.read(chars)) != -1) {


                stringBuilder.append(chars,0,length);
            }


            System.out.print(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {

                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
