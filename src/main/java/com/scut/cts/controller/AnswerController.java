package com.scut.cts.controller;

import com.scut.cts.pojo.Answer;
import com.scut.cts.pojo.RespBean;
import com.scut.cts.pojo.meta;
import com.scut.cts.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private AnswerService answerService;

	@GetMapping
	public RespBean getAnswer(@RequestParam(value = "problemId") int probId){
		Answer answer = answerService.getAnswer(probId);
		return RespBean.ok("响应成功",answer.getContent());
	}
}
