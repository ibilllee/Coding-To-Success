package com.scut.cts.dto;

@lombok.Data
public class DataNode {
    private Integer dataId;
    private String in;
    private String out;

    public DataNode() {}

    public DataNode(Integer dataId, String in, String out) {
        this.dataId = dataId;
        this.in = in;
        this.out = out;
    }
}
