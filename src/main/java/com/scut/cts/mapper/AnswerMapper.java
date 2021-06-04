package com.scut.cts.mapper;

import com.scut.cts.pojo.Answer;
import com.scut.cts.pojo.Problem;
import org.apache.ibatis.annotations.Delete;
import tk.mybatis.mapper.common.Mapper;

public interface AnswerMapper extends Mapper<Answer> {
    @Delete("DELETE FROM answer WHERE ans_prob_id = #{probId}")
    public int deleteByProbId(Problem problem);
}
