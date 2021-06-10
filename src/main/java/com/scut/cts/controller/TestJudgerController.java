// package com.scut.cts.controller;
//
// import lombok.Data;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
//
// import java.util.ArrayList;
// import java.util.List;
//
// @RestController
// @RequestMapping("/judger")
// public class TestJudgerController
// {
// 	@PostMapping
// 	public NCE judger(@RequestParam(value = "userCode") String userCode,
// 						   @RequestParam(value = "probId") int probId){
// 		Case case1 = new Case(0, "Accept");
// 		Case case2 = new Case(1, "Accpet");
// 		ArrayList<Case> cases = new ArrayList<>();
// 		cases.add(case1);
// 		cases.add(case2);
// 		NCE nce = new NCE(cases, "2/2");
// 		return nce;
// 	}
// }
//
// @Data
// class Case{
// 	private int id;
// 	private String status;
//
// 	public Case(int id, String status) {
// 		this.id = id;
// 		this.status = status;
// 	}
// }
//
// @Data
// class NCE{
// 	private List<Case> cases;
// 	private String score;
//
// 	public NCE(List<Case> cases, String score) {
// 		this.cases = cases;
// 		this.score = score;
// 	}
// }