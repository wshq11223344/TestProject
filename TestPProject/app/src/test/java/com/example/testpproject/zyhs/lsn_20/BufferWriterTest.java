package com.example.testpproject.zyhs.lsn_20;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class BufferWriterTest {

    File file = new File("D:/android/test.txt");
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;


    @Test
    public void test() throws Exception {

        fileWriter = new FileWriter(file);
        bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("你好");
        bufferedWriter.append("\n");

        bufferedWriter.write("我叫韩琦");
        bufferedWriter.newLine();
        bufferedWriter.write("我叫Arthur");


        if (bufferedWriter != null) {

            bufferedWriter.close();
        }

        if (fileWriter != null) {

            fileWriter.close();
        }

    }
}
