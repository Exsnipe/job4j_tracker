package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintUsage {
    public static void main(String[] args) {
        try (PrintStream printStream = new PrintStream("data/print.txt")) {
            printStream.print(" PrintStream");
            printStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
