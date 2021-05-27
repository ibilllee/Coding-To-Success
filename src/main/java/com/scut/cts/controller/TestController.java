package com.scut.cts.controller;

import com.scut.cts.entity.Test;
import com.scut.cts.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;

	@ResponseBody
	@RequestMapping("/hello")
	public String hello(){
		return "Hello";
	}

	@ResponseBody
	@RequestMapping("/add")
	public Test add(Test test){
		return testService.add(test);
	}
}
