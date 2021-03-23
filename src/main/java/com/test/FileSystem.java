package com.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileSystem {

    HashMap<String, File> files;
    List<Integer> memoryBlocks;

    public FileSystem(int memoryBlockSize) {
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println(totalMemory);
        System.out.println(totalMemory/memoryBlockSize);
        memoryBlocks = new ArrayList<>();
    }

    void fOpen(String path){
        File file = files.get(path);
        
    }

    void fClose(){

    }

    void fWrite(){

    }

    void fRead(){

    }

    void newFile(String path){
        File file = new File(path);
        files.put(path, file);
    }

}
