package cn.layanan.game.base.io;

import java.io.File;

/**
 * 目录操作类
 *
 * @Author layanan
 * @Date 2019/7/28 19:46
 */
public class DirTest {

    public static void main(String[] args) {
        String dirString = "D:/IDEA Project/Lay Project/base-learning/tmp/user/java";
        String baseDir = "D:/IDEA Project/Lay Project/base-learning/tmp";
        createDir(dirString);
        dirList(baseDir);
    }


    private static void createDir(String dirString) {
        File d = new File(dirString);
        if (d.mkdirs()) {
            System.out.println("创建目录");
            d.mkdirs();
        } else {
            System.out.println("已存在目录");
        }
    }

    private static void dirList(String dirString) {
        File d = new File(dirString);
        if (d.isDirectory()) {
            System.out.println("Directory of " + d.getName());
            String[] list = d.list();
            for (String s : list) {
                File f = new File(dirString + "/" + s);
                if (f.isDirectory()) {
                    System.out.println(f.getName() + " is a directory");
                    dirList(dirString + "/" + s);
                } else {
                    System.out.println(f.getName() + " is a file");
                }
            }
        } else {
            System.out.println(d.getName() + " is not a directory");
        }
    }
}
