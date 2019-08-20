package cn.layanan.game.base.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * 目录操作类
 *
 * @Author layanan
 * @Date 2019/7/28 19:46
 */
public class DirTest {

    public static void main(String[] args) throws IOException {
        String dirString = "D:/IDEA Project/Lay Project/base-learning/tmp/user/java";
        String baseDir = "D:/IDEA Project/Lay Project/base-learning/tmp";
        createDir(dirString);
        dirList(baseDir);
        fileTree(baseDir);
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

    private static void fileTree(String dirString) throws IOException {
        Path path = Paths.get(dirString);
        FileVisitor<Path> fileVisitor = getFileVisitor();

        Files.walkFileTree(path, fileVisitor);
    }

    private static FileVisitor<Path> getFileVisitor() {
        class DirVisitor<Path> extends SimpleFileVisitor<Path> {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.format("%s [Directory]%n", dir);
                return CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.format("%s [File,  Size: %s  bytes]%n", file, attrs.size());
                return CONTINUE;
            }
        }
        return new DirVisitor<>();
    }
}
