package com.test;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class File {

    public File(String path) {
        this.inode = new INode();
        this.path = path;
        this.content = "";
        this.open = false;
    }

    private INode inode;

    private String path;

    private String content;

    private boolean open;

    public void putContent(String content) {

        this.content += content;

    }
}
