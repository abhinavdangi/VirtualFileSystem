package com.test;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class INode {

    INode(String path) {
        this.size = 0;
        String[] paths = path.split("/");
        this.name = paths[paths.length - 1];
    }

    private Integer size;
    private String name;

}
