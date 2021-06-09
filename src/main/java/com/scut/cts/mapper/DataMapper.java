package com.scut.cts.mapper;

import com.scut.cts.pojo.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DataMapper extends Mapper<Data> {
    @Select("SELECT * FROM data WHERE data_id = #{dataId}")
    public Data selectDataByDataId(Integer dataId);

    @Select("SELECT * FROM data WHERE data_prob_id = #{probId}")
    public List<Data> selectDataByProbId(Integer probId);

    @Delete("DELETE FROM data WHERE data_id = #{dataId}")
    public int deleteByDataId(Integer dataId);

    @Delete("DELETE FROM data WHERE data_prob_id = #{probId}")
    public int deleteByProbId(Integer probId);
}
