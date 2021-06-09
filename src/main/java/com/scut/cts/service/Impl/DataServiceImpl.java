package com.scut.cts.service.Impl;

import com.scut.cts.mapper.DataMapper;
import com.scut.cts.pojo.Data;
import com.scut.cts.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataMapper dataMapper;

    @Override
    public boolean addData(Data data) {
        return dataMapper.insert(data)==1;
    }

    @Override
    public Data selectDataByDataId(Integer probId, Integer dataId) {
        return dataMapper.selectDataByDataId(probId, dataId);
    }

    @Override
    public List<Data> selectDataByProbId(Integer probId) {
        return dataMapper.selectDataByProbId(probId);
    }

    @Override
    public boolean updateData(Data data) {
        return dataMapper.updateByPrimaryKeySelective(data)==1;
    }

    @Override
    public boolean deleteDataByDataId(Integer probId, Integer dataId) {
        return dataMapper.deleteByDataId(probId, dataId)==1;
    }

    @Override
    public boolean deleteDataByProbId(Integer probId) {
        return dataMapper.deleteByProbId(probId)==1;
    }

    @Override
    public int selectMaxDataIdInProbId(Integer probId) {
        return dataMapper.selectMaxDataIdInProbId(probId);
    }
}
