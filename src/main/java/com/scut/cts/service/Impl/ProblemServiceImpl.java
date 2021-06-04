package com.scut.cts.service.Impl;

import com.scut.cts.mapper.ProblemMapper;
import com.scut.cts.pojo.Problem;
import com.scut.cts.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public Problem selectProblem(Problem problem) {
        return problemMapper.selectOne(problem);
    }

    @Override
    public boolean updateProblem(Problem problem) {
        return problemMapper.updateByPrimaryKeySelective(problem)==1;
    }

    @Override
    public boolean deleteProblem(Problem problem) {
        return problemMapper.deleteByPrimaryKey(problem)==1;
    }
}
