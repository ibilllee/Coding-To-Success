package com.scut.cts.controller;

import com.github.pagehelper.PageHelper;
import com.scut.cts.pojo.Comment;
import com.scut.cts.pojo.RespBean;
import com.scut.cts.pojo.Tutorial;
import com.scut.cts.service.CommentService;
import com.scut.cts.service.TutorialService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            return RespBean.unprocessable("教程添加失败"+e.getMessage(),tutorial);
        }
        if(result) {
            return RespBean.created("教程添加成功",tutorial);
        }
        return RespBean.unprocessable("教程添加失败",tutorial);
    }

    @PutMapping("/modify/{tutoId}")
    public RespBean updateTutorial(@PathVariable Integer tutoId, @RequestParam String content) {
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
    public RespBean deleteTutorial(@PathVariable Integer tutoId) {
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

    @GetMapping("/first")
    public RespBean getTitles() {
        List<String> titleList = tutorialService.getTitle(null);
        return RespBean.ok("一级标题获取成功",new TitleList(titleList));
    }

    @GetMapping("/second/{titleNum}")
    public RespBean getTitle(@PathVariable Double titleNum) {
        List<String> titleList = tutorialService.getTitle(titleNum);
        return RespBean.ok("二级标题获取成功",new TitleList(titleList));
    }

    @GetMapping("/view")
    public RespBean getTutorials(@RequestParam Integer tutoId) {
        Tutorial tutorial = tutorialService.getTutorial(tutoId);
        return RespBean.ok("教程获取成功",tutorial);
    }

    @GetMapping("/{tutoId}/commentList/{page}/{pageSize}")
    public RespBean getComments(@PathVariable Integer tutoId, @PathVariable Integer page,
                                @PathVariable Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Comment> commentList = commentService.getComments(tutoId);
        return RespBean.ok("获取用户评论成功",new CommentList(commentList));
    }
}

@Data
class TitleList {
    private List<String> titleList;

    public TitleList(List<String> titleList) {
        this.titleList = titleList;
    }
}

@Data
class CommentList {
    private List<Comment> commentList;

    public CommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
