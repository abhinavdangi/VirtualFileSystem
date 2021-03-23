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
        file.setOpen(true);
    }

    void fClose(String path){
        File file = files.get(path);
        file.setOpen(false);
    }

    void fWrite(String path, String content){
        File file = files.get(path);
        if(!file.isOpen()){
            throw new RuntimeException("File is not open");
        }
        file.putContent(content);
    }

    String fRead(String path){
        File file = files.get(path);
        return file.getContent();
    }

    void newFile(String path){
        File file = new File(path);
        files.put(path, file);
    }

}
