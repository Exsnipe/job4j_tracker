package io;

import java.io.*;

public class Buffered {
    public static void main(String[] args) {
        try (BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("data/input.txt"))) {
            BufferedOutputStream out = new BufferedOutputStream(
                    new FileOutputStream("data/output.txt", true));
            out.write(in.readAllBytes());
            out.close();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }
}
