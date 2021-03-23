package com.test;

public class Main {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem(5);
        File file = fileSystem.newFile("/test");
        File file2 = fileSystem.newFile("/abhi");
        file.write("cd");
        file2.write("abhinav");
        System.out.println(file.read());
        System.out.println(file2.read());
        System.out.println(file.getInode().getSize());
        System.out.println(file2.getInode().getSize());
    }
}
