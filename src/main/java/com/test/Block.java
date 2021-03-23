package com.test;

import lombok.Getter;

@Getter
class Block {
    public Block(int blockNumber, byte[] content) {
        this.blockNumber = blockNumber;
        this.content = content;
    }

    private int blockNumber;
    private byte[] content;
}
