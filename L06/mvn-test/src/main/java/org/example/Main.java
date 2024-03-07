package org.example;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;

@Data
public class Main {

    public void printFile() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("hello.txt");
        System.out.println(new String(inputStream.readAllBytes()));
    }
    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");

        new Main().printFile();
    }
}