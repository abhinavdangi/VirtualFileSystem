package com.test;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello");
        FileSystem fileSystem = new FileSystem(4);
        File file = fileSystem.newFile("/test");
        file.write("aa");
        System.out.println(file.read());
    }
}
