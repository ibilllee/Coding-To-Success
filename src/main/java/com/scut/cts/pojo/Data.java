package com.scut.cts.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@lombok.Data
@Table(name = "data")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer dataProbId;
    private Integer dataId;
    private String dataIn;
    private String dataOut;

    public Data() {}

    public Data(Integer probId, Integer dataId, String dataIn, String dataOut) {
        this.dataProbId = probId;
        this.dataId = dataId;
        this.dataIn = dataIn;
        this.dataOut = dataOut;
    }
}
