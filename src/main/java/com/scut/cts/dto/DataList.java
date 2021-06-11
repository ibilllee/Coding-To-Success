package com.scut.cts.dto;

import java.util.List;

@lombok.Data
public class DataList {
    private Integer probId;
    private List<AddDataNode> dataList;

    public DataList() {}
    public DataList(Integer probId) {
        this.probId = probId;
    }
    public DataList(Integer probId, List<AddDataNode> dataList) {
        this.dataList = dataList;
    }
}
