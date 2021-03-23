package com.test;

import java.util.ArrayList;
import java.util.List;

public class INode {

    public INode() {
        this.blocks = new ArrayList<>();
        this.size = 0;
    }

    private List<Integer> blocks;

    private long size;

}
