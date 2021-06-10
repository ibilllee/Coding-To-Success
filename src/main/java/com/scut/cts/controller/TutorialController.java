package com.scut.cts.controller;

import com.github.pagehelper.PageHelper;
import com.scut.cts.dto.*;
import com.scut.cts.pojo.Comment;
import com.scut.cts.pojo.Tutorial;
import com.scut.cts.service.CommentService;
import com.scut.cts.service.DataService;
import com.scut.cts.service.TutorialService;
import com.scut.cts.data.*;
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
    @Autowired
    private DataService dataService;
    @Autowired
    private RestTemplate restTemplate;

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
        return RespBean.ok("教程获取成功",tutorial);
    }

    @GetMapping("/{tutoId}/commentList/{page}/{pageSize}")
    public RespBean getComments(@PathVariable Integer tutoId, @PathVariable Integer page,
                                @PathVariable Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<CommentWithAvatar> commentList = commentService.getComments(tutoId);
        return RespBean.ok("获取用户评论成功",new CommentList(commentList));
    }

//    @PutMapping("/modifyData/{probId}")
//    public RespBean transformData(@PathVariable int probId, @RequestParam String data) {
//        String url = "http://localhost:8081/problems";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("probId", String.valueOf(probId));
//        map.add("in",String.valueOf(in));
//        map.add("out",String.valueOf(out));
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
//
//        String body = response.getBody();
//        return RespBean.ok("数据已转发",body);
//    }
    @PutMapping("/modifyData/{dataId}/{probId}")
    public RespBean updateData(@PathVariable Integer dataId, @PathVariable Integer probId,
                               DataList dataList) {
        List<AddDataNode> updateList = dataList.getDataList();
        for (int i = 0; i < updateList.size(); i++) {
            com.scut.cts.pojo.Data newData = new com.scut.cts.pojo.Data();
            try {
                com.scut.cts.pojo.Data oldData = dataService.selectDataByDataId(probId,dataId);
                newData.setId(oldData.getId());
                newData.setDataIn(updateList.get(i).getIn());
                newData.setDataOut(updateList.get(i).getOut());
                dataService.updateData(newData);
            }catch (Exception e) {
                return RespBean.unprocessable("数据修改失败"+e.getMessage(),newData);
            }
        }

        String url = "http://localhost/problems";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("probId", String.valueOf(probId));
        map.add("dataList", String.valueOf(dataList));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        try {
            restTemplate.put(url, request, String.class);
        }catch (Exception e) {
            return RespBean.unprocessable("数据转发失败"+e.getMessage());
        }

        return RespBean.ok("数据修改成功");
    }
}

