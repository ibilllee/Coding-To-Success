package com.scut.cts.dto;

import com.scut.cts.pojo.Data;

@lombok.Data
public class AddDataNode {
    private String in;
    private String out;

    public AddDataNode() {}

    public AddDataNode(String in, String out) {
        this.in = in;
        this.out = out;
    }

    public AddDataNode(Data data){
        this.in = data.getDataIn();
        this.out = data.getDataOut();
    }
}
