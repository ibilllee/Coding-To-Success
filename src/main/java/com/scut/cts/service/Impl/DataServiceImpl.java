package com.scut.cts.service.Impl;

import com.scut.cts.mapper.DataMapper;
import com.scut.cts.pojo.Data;
import com.scut.cts.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataServiceImpl implements DataService {
    @Autowired
    private DataMapper dataMapper;

    @Override
    public boolean addData(Data data) {
        return dataMapper.insert(data)==1;
    }

    @Override
    public Data selectDataByDataId(Integer dataId) {
        return dataMapper.selectDataByDataId(dataId);
    }

    @Override
    public List<Data> selectDataByProbId(Integer probId) {
        return dataMapper.selectDataByProbId(probId);
    }

    @Override
    public boolean updateData(Data data) {
        int id = dataMapper.selectDataByDataId(data.getDataId()).getId();
        data.setId(id);
        return dataMapper.updateByPrimaryKeySelective(data)==1;
    }

    @Override
    public boolean deleteDataByDataId(Integer dataId) {
        return dataMapper.deleteByDataId(dataId)==1;
    }

    @Override
    public boolean deleteDataByProbId(Integer probId) {
        return dataMapper.deleteByProbId(probId)==1;
    }
}
