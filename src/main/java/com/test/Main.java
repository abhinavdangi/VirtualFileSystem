package com.test;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello");
        FileSystem fileSystem = new FileSystem(512);
        fileSystem.newFile("/test");
        fileSystem.newFile("/abhi");

    }
}
