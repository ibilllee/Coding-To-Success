package com.scut.cts.controller;

import com.scut.cts.pojo.ResponseObj;
import com.scut.cts.pojo.Test;
import com.scut.cts.service.TestService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;

	@ResponseBody
	@RequestMapping("/hello")
	public ResponseObj hello(){
		ResponseObj resp = new ResponseObj();
		ArrayList<Object> list = new ArrayList<>();
		list.add(new Man(18,"li"));
		list.add(new Car(888));
		resp.setData(list);
		resp.setMsg("OK");
		resp.setMsg("NOK");
		resp.setMsg("BOK");
		resp.setStatus(200);
		return resp;
	}

	@ResponseBody
	@RequestMapping("/add")
	public Test add(Test test){
		return testService.add(test);
	}
}

@Data
class Man{
	private int age;
	private String name;

	public Man(int age, String name) {
		this.age = age;
		this.name = name;
	}
}

@Data
class Car{
	private int number;

	public Car(int number) {
		this.number = number;
	}
}