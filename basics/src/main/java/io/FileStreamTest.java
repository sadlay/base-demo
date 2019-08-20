package io;

import java.io.*;

/**
 * 文件IO流测试类
 *
 * @Author layanan
 * @Date 2019/7/28 19:21
 */
public class FileStreamTest {
    public static void main(String[] args) throws IOException {
        String fileName = "test.txt";
        write(fileName);
        read(fileName);

    }

    private static void write(String fileName) throws IOException {
        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");
        writer.append("简体中文");
        writer.append("\r\n");
        writer.append("English");
        writer.append("\r\n");
        writer.close();
        fos.close();
    }

    private static void read(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        while (br.ready()) {
            System.out.println(br.readLine());
        }
        br.close();
        isr.close();
        fis.close();
    }


}
