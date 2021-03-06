package com.scut.cts.controller;

import com.scut.cts.pojo.Comment;
import com.scut.cts.dto.RespBean;
import com.scut.cts.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController
{
	@Autowired
	private CommentService commentService;

	@PostMapping
	public RespBean addComment(Comment comment) {
		boolean result;
		try {
			result = commentService.addComment(comment);
		}catch (Exception e){
			return RespBean.unprocessable("评论创建失败"+e.getMessage(), comment);
		}
		if (result)
			return RespBean.created("评论创建成功", comment);
		return RespBean.unprocessable("评论创建失败", comment);
	}
}
