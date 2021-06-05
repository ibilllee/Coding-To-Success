package com.scut.cts.service;

import com.scut.cts.pojo.Problem;

import java.util.List;

public interface ProblemService {
    public Problem selectProblem(Problem problem);
    public boolean addProblem(Problem problem);
    public boolean updateProblem(Problem problem);
    public boolean deleteProblem(Problem problem);
    public List<Problem> selectProblemByTutoId(int tutoId);
}
