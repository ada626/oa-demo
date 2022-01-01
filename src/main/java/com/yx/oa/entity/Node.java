package com.yx.oa.entity;

import lombok.Data;

@Data
public class Node {
    private Long nodeId;
    private Integer nodeType;
    private String nodeName;
    private String url;
    private Integer nodeCode;
    private Long parentId;
}
