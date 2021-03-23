package com.test;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileSystem {

    public static int currentBlock;
    static Map<String, File> files;
    static Integer memoryBlockSize;
    static Integer usedBlocks;
    static Integer totalBlocks;

    public FileSystem(int memoryBlockSize) {
        files = new HashMap<>();
        FileSystem.memoryBlockSize = memoryBlockSize;
        usedBlocks = 0;
        totalBlocks = Math.toIntExact(Runtime.getRuntime().totalMemory() / memoryBlockSize);
        currentBlock = 0;
    }

    static boolean isMemoryAvailable(Integer contentLength) {
        refreshUsedBlocks();
        return usedBlocks + (contentLength / memoryBlockSize) < totalBlocks;
    }

    private static void refreshUsedBlocks() {
        for (File file : files.values()) {
            usedBlocks += file.getBlocks().size();
        }
    }

    File newFile(String path) {
        File file = new File(path);
        files.put(path, file);
        return file;
    }

}
