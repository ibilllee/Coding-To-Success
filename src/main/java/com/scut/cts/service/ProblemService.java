package com.scut.cts.service;

import com.scut.cts.pojo.Problem;

public interface ProblemService {
    public Problem selectProblem(Problem problem);
    public boolean updateProblem(Problem problem);
    public boolean deleteProblem(Problem problem);
}
