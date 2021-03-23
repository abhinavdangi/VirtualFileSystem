package com.test;

public class File {

    public File(String path) {
        this.inode = new INode();
        this.path = path;
        this.content = "";
    }

    private INode inode;

    private String path;

    private String content;

}
