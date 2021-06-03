package com.scut.cts.controller;

import com.scut.cts.pojo.Comment;
import com.scut.cts.pojo.RespBean;
import com.scut.cts.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController
{
	@Autowired
	private CommentService commentService;

	@PostMapping
	public RespBean addComment(@RequestBody Comment comment) {
		boolean result = commentService.addComment(comment);
		if (result)
			return RespBean.created("评论创建成功", comment);
		return RespBean.unprocessable("评论创建失败", comment);
	}
}
