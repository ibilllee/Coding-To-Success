package com.scut.cts.service.Impl;

import com.scut.cts.mapper.AnswerMapper;
import com.scut.cts.mapper.ProblemMapper;
import com.scut.cts.pojo.Problem;
import com.scut.cts.service.ProblemService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;
    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public Problem selectProblem(Problem problem) {
        return problemMapper.selectOne(problem);
    }

    @Override
    public boolean addProblem(Problem problem) {
        return problemMapper.insert(problem)==1;
    }

    @Override
    public boolean updateProblem(Problem problem) {
        return problemMapper.updateByPrimaryKeySelective(problem)==1;
    }

    @Override
    public boolean deleteProblem(Problem problem) {
        answerMapper.deleteByProbId(problem);
        return problemMapper.deleteByPrimaryKey(problem)==1;
    }

    @Override
    public List<Problem> selectProblemByTutoId(int tutoId) {
        return problemMapper.selectProblemByTutoId(tutoId);
    }
}
