package com.scut.cts.controller;

import com.scut.cts.pojo.Problem;
import com.scut.cts.pojo.RespBean;
import com.scut.cts.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    @PostMapping("/add")
    public RespBean addProblem(@RequestParam Integer probId, @RequestParam Integer probTutoId,
                               @RequestParam String content) {
        Problem problem = new Problem(probId,probTutoId,content);
        boolean result;
        try {
            result = problemService.addProblem(problem);
        } catch (Exception e) {
            return RespBean.unprocessable("问题添加失败"+e.getMessage(), problem);
        }
        if (result) {
            return RespBean.created("问题添加成功", problem);
        }
        return RespBean.unprocessable("问题添加失败",problem);
    }

    @PutMapping("/modify")
    public RespBean updateProblem(@RequestParam Integer probId, @RequestParam Integer tutoId,
                                  @RequestParam String content) {
        Problem problem = new Problem(probId, tutoId, content);
        boolean result;
        try {
            result = problemService.updateProblem(problem);
        }catch (Exception e) {
            return RespBean.unprocessable("问题修改失败"+e.getMessage(), problem);
        }
        if(result) {
            return RespBean.ok("问题修改成功",problem);
        }
        return RespBean.unprocessable("问题修改失败",problem);
    }

    @DeleteMapping("/delete")
    public RespBean deleteProblem(@RequestParam Integer probId) {
        boolean result;
        try {
            result = problemService.deleteProblem(new Problem(probId));
        }catch (Exception e) {
            return RespBean.unprocessable("问题删除失败"+e.getMessage());
        }
        if(result) {
            return RespBean.ok("问题删除成功");
        }
        return RespBean.unprocessable("问题删除失败");
    }


}
