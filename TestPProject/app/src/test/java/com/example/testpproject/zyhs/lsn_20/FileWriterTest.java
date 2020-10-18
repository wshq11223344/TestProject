package com.example.testpproject.zyhs.lsn_20;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

    FileWriter fileWriter;

    File file = new File("D:/android/test.txt");

    @Test
    public void test() {

        try {
            fileWriter = new FileWriter(file);

            fileWriter.write("我叫韩其");
            fileWriter.write("我是你妈");
            fileWriter.write("\n");
            fileWriter.append("我是你爸");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
