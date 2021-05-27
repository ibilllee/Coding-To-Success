package com.scut.cts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

	@ResponseBody
	@RequestMapping("/hello")
	public String hello(){
		return "Hello";
	}
}
