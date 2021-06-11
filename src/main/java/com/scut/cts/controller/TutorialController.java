package com.scut.cts.controller;

import com.github.pagehelper.PageHelper;
import com.scut.cts.dto.*;
import com.scut.cts.pojo.Comment;
import com.scut.cts.pojo.Tutorial;
import com.scut.cts.service.CommentService;
import com.scut.cts.service.DataService;
import com.scut.cts.service.TutorialService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/tutorial")
public class TutorialController {
    @Autowired
    private TutorialService tutorialService;
    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public RespBean addTutorial(@RequestParam String titleContent, @RequestParam String content,
                                @RequestParam Double titleNum) {
        Tutorial tutorial = new Tutorial(titleContent, content, titleNum);
        boolean result;
        try {
            result = tutorialService.addTutorial(tutorial);
        }catch (Exception e) {
            return RespBean.unprocessable("添加失败"+e.getMessage(),tutorial);
        }
        if(result) {
            return RespBean.created("添加成功",tutorial);
        }
        return RespBean.unprocessable("添加失败",tutorial);
    }

    @PutMapping("/modify/{tutoId}")
    public RespBean updateTutorial(@PathVariable Integer tutoId, @RequestParam String content) {
        Tutorial tutorial = new Tutorial(tutoId, content);
        boolean result;
        try {
            result = tutorialService.updateTutorial(tutorial);
        }catch (Exception e) {
            return RespBean.unprocessable("修改失败"+e.getMessage(),tutorial);
        }
        if(result) {
            Tutorial newTutorial = tutorialService.getTutorial(tutoId);
            tutorial.setTitleNum(newTutorial.getTitleNum());
            tutorial.setTitleContent(newTutorial.getTitleContent());
            return RespBean.ok("修改成功",tutorial);
        }
        return RespBean.unprocessable("修改失败",tutorial);
    }

    @DeleteMapping("/delete/{tutoId}")
    public RespBean deleteTutorial(@PathVariable Integer tutoId) {
        boolean result;
        try {
            result = tutorialService.deleteTutorial(tutoId);
        }catch (Exception e) {
            return RespBean.unprocessable("删除失败"+e.getMessage());
        }
        if(result) {
            return RespBean.ok("删除成功");
        }
        return RespBean.unprocessable("删除失败");
    }

    @GetMapping("/first")
    public RespBean getTitles() {
        List<TitleContent> titleList = tutorialService.getTitle(null);
        return RespBean.ok("一级标题获取成功",new TitleList(titleList));
    }

    @GetMapping("/second/{titleNum}")
    public RespBean getTitle(@PathVariable Double titleNum) {
        List<TitleContent> titleList = tutorialService.getTitle(titleNum);
        return RespBean.ok("二级标题获取成功",new TitleList(titleList));
    }

    @GetMapping("/view")
    public RespBean getTutorials(@RequestParam(value = "tutoId") int tutoId) {
        Tutorial tutorial = tutorialService.getTutorial(tutoId);
        return RespBean.ok("查看成功",tutorial);
    }

    @GetMapping("/{tutoId}/commentList/{page}/{pageSize}")
    public RespBean getComments(@PathVariable Integer tutoId, @PathVariable Integer page,
                                @PathVariable Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<CommentWithAvatar> commentList = commentService.getComments(tutoId);
        return RespBean.ok("获取用户评论成功",new CommentList(commentList));
    }
}

