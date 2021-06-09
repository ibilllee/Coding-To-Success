package com.scut.cts.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@lombok.Data
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private Integer probId;
    private Integer dataId;
    private String dataIn;
    private String dataOut;

    public Data() {}

    public Data(Integer probId, Integer dataId, String dataIn, String dataOut) {
        this.probId = probId;
        this.dataId = dataId;
        this.dataIn = dataIn;
        this.dataOut = dataOut;
    }
}
