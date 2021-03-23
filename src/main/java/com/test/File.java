package com.test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class File {

    public File(String path) {
        this.inode = new INode(path);
        this.path = path;
        blocks = new ArrayList<>();
    }

    private INode inode;

    private String path;

    private List<Block> blocks;

    public String read() {
        StringBuilder content = new StringBuilder();
        for (Block block : blocks) {
            content.append(new String(block.getContent(), StandardCharsets.UTF_8));
        }
        return content.toString();
    }

    public void write(String content) {
        Integer contentLength = content.getBytes().length;
        if (!FileSystem.isMemoryAvailable(contentLength)) {
            throw new RuntimeException("No memory space available");
        } else {
            Integer blockLength = contentLength / FileSystem.memoryBlockSize;
            if (contentLength % FileSystem.memoryBlockSize != 0) {
                blockLength++;
            }
            for (int i = 0; i < blockLength; i++) {
                Integer toLength = Math.min((i + 1) * FileSystem.memoryBlockSize, contentLength);
                Block block = new Block(FileSystem.currentBlock, Arrays.copyOfRange(
                        content.getBytes(), i * FileSystem.memoryBlockSize, toLength));
                FileSystem.currentBlock++;
                blocks.add(block);
            }
            inode.setSize(contentLength);
        }
    }
}
