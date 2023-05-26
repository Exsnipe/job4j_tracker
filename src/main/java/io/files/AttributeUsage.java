package io.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class AttributeUsage {
    public static void main(String[] args) {
        Path file = Paths.get("Attributes.txt");
        BasicFileAttributes attributes = null;
        try {
            attributes = Files.readAttributes(file, BasicFileAttributes.class);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        if (attributes != null) {
            System.out.println("Это обычный файл? " + attributes.isRegularFile());
            System.out.println("Это директория? " + attributes.isDirectory());
            System.out.println("Это символическая ссылка? " + attributes.isSymbolicLink());
            System.out.println("Это не файл, директория или символическая ссылка? "
                    + attributes.isOther());
            System.out.println("Дата создания файла: " + attributes.creationTime());
            System.out.println("Размер файла: " + attributes.size());
            System.out.println("Время последнего доступа: " + attributes.lastAccessTime());
            System.out.println("Время последнего изменения: " + attributes.lastModifiedTime());
        }
    }
}
