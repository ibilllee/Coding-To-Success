package com.scut.cts.controller;

import com.scut.cts.dto.Text;
import com.scut.cts.pojo.Answer;
import com.scut.cts.dto.RespBean;
import com.scut.cts.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private AnswerService answerService;

	@GetMapping
	public RespBean getAnswer(@RequestParam(value = "problemId") int probId) {
		Answer answer ;
		try {
			answer=answerService.getAnswer(probId);
		}catch (Exception e){
			return RespBean.unprocessable("响应失败"+e.getMessage());
		}
		if (answer != null)
			return RespBean.ok("响应成功", new Text(answer.getContent()));
		return RespBean.unprocessable("响应失败");
	}

	@PostMapping("/add")
	public RespBean addAnswer(@RequestParam int probId,@RequestParam(value = "text") String content){
		boolean result;
		try {
			result=answerService.addAnswer(new Answer(probId,content));
		}catch (Exception e){
			return RespBean.unprocessable("添加失败"+e.getMessage());
		}
		if (result)
			return RespBean.ok("添加成功");
		return RespBean.unprocessable("添加失败");
	}

	@DeleteMapping("/delete/{probId}")
	public RespBean deleteAnswer(@PathVariable int probId){
		boolean result;
		try {
			result=answerService.deleteAnswer(probId);
		}catch (Exception e){
			return RespBean.unprocessable("删除失败"+e.getMessage());
		}
		if (result)
			return RespBean.ok("删除成功");
		return RespBean.unprocessable("删除失败");
	}

	@PutMapping("/update/{probId}")
	public RespBean updateAnswer(@PathVariable int probId,@RequestParam(value = "text") String content){
		boolean result;
		try {
			result=answerService.updateAnswer(new Answer(probId,content));
		}catch (Exception e){
			return RespBean.unprocessable("修改失败"+e.getMessage());
		}
		if (result)
			return RespBean.ok("修改成功");
		return RespBean.unprocessable("修改失败");
	}
}
