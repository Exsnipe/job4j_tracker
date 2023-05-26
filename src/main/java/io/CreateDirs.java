package io;

import java.io.File;
import java.io.IOException;

public class CreateDirs {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/main/java/io/files");
        directory.mkdir();
        File file = new File("src/main/java/io/files/file.txt");
        file.createNewFile();
        System.out.println(directory.isDirectory());
        System.out.println(file.isDirectory());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.isAbsolute());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getName());
    }
}
