package com.scut.cts.controller;

import com.scut.cts.pojo.RespBean;
import com.scut.cts.pojo.Tutorial;
import com.scut.cts.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutorial")
public class TutorialController {
    @Autowired
    private TutorialService tutorialService;

    @PostMapping("/add")
    public RespBean addTutorial(@RequestParam String titleContent, @RequestParam String content,
                                @RequestParam Double titleNum) {
        Tutorial tutorial = new Tutorial(titleContent, content, titleNum);
        boolean result;
        try {
            result = tutorialService.addTutorial(tutorial);
        }catch (Exception e) {
            return RespBean.unprocessable("教程添加失败"+e.getMessage(),tutorial);
        }
        if(result) {
            return RespBean.created("教程添加成功",tutorial);
        }
        return RespBean.unprocessable("教程添加失败",tutorial);
    }

    @PutMapping("/modify/{tutoId}")
    public RespBean updateTutorial(@RequestParam Integer tutoId, @RequestParam String content) {
        Tutorial tutorial = new Tutorial(tutoId, content);
        boolean result;
        try {
            result = tutorialService.updateTutorial(tutorial);
        }catch (Exception e) {
            return RespBean.unprocessable("教程修改失败"+e.getMessage(),tutorial);
        }
        if(result) {
            return RespBean.ok("教程修改成功",tutorial);
        }
        return RespBean.unprocessable("教程修改失败",tutorial);
    }

    @DeleteMapping("/delete/{tutoId}")
    public RespBean deleteTutorial(Integer tutoId) {
        boolean result;
        try {
            result = tutorialService.deleteTutorial(tutoId);
        }catch (Exception e) {
            return RespBean.unprocessable("教程删除失败"+e.getMessage());
        }
        if(result) {
            return RespBean.ok("教程删除成功");
        }
        return RespBean.unprocessable("教程删除失败");
    }
}
