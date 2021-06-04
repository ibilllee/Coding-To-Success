package com.scut.cts.service.Impl;

import com.scut.cts.pojo.Problem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProblemServiceImplTest {
    @Autowired
    private ProblemServiceImpl problemService;

    @Test
    public void selectProblem() {
        System.out.println(problemService.selectProblem(new Problem(1,1,"内容")));
    }

    @Test
    public void updateProblem() {
        System.out.println(problemService.updateProblem(new Problem(1,1,"A+B")));
    }

    @Test
    public void deleteProblem() {
        System.out.println(problemService.deleteProblem(new Problem(1,1,"内容")));
    }
}
