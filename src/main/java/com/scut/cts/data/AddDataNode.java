package com.scut.cts.data;

@lombok.Data
public class AddDataNode {
    private String in;
    private String out;

    public AddDataNode() {}

    public AddDataNode(String in, String out) {
        this.in = in;
        this.out = out;
    }
}
