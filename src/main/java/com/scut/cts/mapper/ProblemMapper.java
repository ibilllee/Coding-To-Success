package com.scut.cts.mapper;

import com.scut.cts.pojo.Problem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProblemMapper extends Mapper<Problem> {
    @Select("SELECT * FROM problem WHERE prob_tuto_id=#{tutoId}")
    public List<Problem> selectProblemByTutoId(int tutoId);

    @Delete("DELETE FROM problem WHERE prob_tuto_id = #{tutoId}")
    public int deleteByTutoId(Integer tutoId);
}
