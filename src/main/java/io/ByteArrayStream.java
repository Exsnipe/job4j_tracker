package io;

import java.io.ByteArrayInputStream;

public class ByteArrayStream {
    public static void main(String[] args) {
        byte[] bytes = new byte[] {'J', 'a', 'v', 'a'};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        int data;
        while ((data = byteArrayInputStream.read()) != -1) {
            System.out.print((char) data);
        }
    }
}
