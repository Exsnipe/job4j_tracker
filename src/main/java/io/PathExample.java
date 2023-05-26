package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("path/paths");
        Files.createDirectories(dir);
        Path file = Path.of("path/paths/path.txt");
        Files.createFile(file);
        Files.move(file, Path.of("path/path.txt"));
    }
}
