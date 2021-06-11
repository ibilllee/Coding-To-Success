package com.scut.cts.service;

import com.scut.cts.pojo.Data;

import java.util.List;

public interface DataService {
    public boolean addData(Data data);
    public Data selectDataByDataId(Integer probId, Integer dataId);
    public List<Data> selectDataByProbId(Integer probId);
    public boolean updateData(Data data);
    public boolean deleteDataByDataId(Integer probId, Integer dataId);
    public boolean deleteDataByProbId(Integer probId);
    public Integer selectMaxDataIdInProbId(Integer probId);
}
